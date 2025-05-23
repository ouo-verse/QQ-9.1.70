package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener;
import com.tribe.async.log.SLog;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThrottlingFunction<IN> extends StreamFunction<IN, IN> {
    private static final String TAG = "async.boss.ThrottlingFunction";
    private Map<IN, Future> mFutures;
    private int mJobType;
    private final int mMaxSimultaneousRequests;
    private int mNumCurrentRequests;
    private final ConcurrentLinkedQueue<IN> mPendingRequests;
    private String mTAG;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class InnerCallFutureListener extends FutureListener.SimpleFutureListener<Void, IN> {
        InnerCallFutureListener() {
        }

        @Override // com.tribe.async.async.FutureListener.SimpleFutureListener, com.tribe.async.async.FutureListener
        public void onFutureDone(@Nullable IN in5) {
            ThrottlingFunction.this.onRequestFinished();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class ThreadOffErrJob extends Job<Error, Void, Error> {
        ThreadOffErrJob(String str) {
            super(str + ".error");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        public Error doInBackground(@NonNull JobContext jobContext, @Nullable Error... errorArr) {
            AssertUtils.checkNotNull(errorArr);
            AssertUtils.assertTrue(errorArr.length > 0);
            Error error = errorArr[0];
            ThrottlingFunction.this.notifyError(error);
            return error;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ThreadOffJob extends Job<IN, Void, IN> {
        @Override // com.tribe.async.async.Job
        protected IN doInBackground(@NonNull JobContext jobContext, @Nullable IN... inArr) {
            if (inArr == null || inArr.length <= 0) {
                ThrottlingFunction.this.notifyResult(null);
                return null;
            }
            ThrottlingFunction.this.notifyResult(inArr[0]);
            return inArr[0];
        }

        ThreadOffJob(String str) {
            super(str);
        }
    }

    public ThrottlingFunction(int i3, int i16) {
        this("ThrottlingFunction", i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestFinished() {
        IN poll;
        synchronized (this) {
            poll = this.mPendingRequests.poll();
            if (poll == null) {
                this.mNumCurrentRequests--;
            }
        }
        if (poll != null) {
            produceResultsInternal(poll);
        }
    }

    private void produceResultsInternal(@NonNull IN in5) {
        SLog.d(TAG, "process " + in5 + ", size = " + this.mNumCurrentRequests);
        new ThreadOffJob(this.mTAG).setJobType(this.mJobType);
        Worker prepareWorker = Bosses.get().prepareWorker(new ThreadOffJob(this.mTAG), this.mJobType, new InnerCallFutureListener(), in5);
        this.mFutures.put(in5, prepareWorker);
        Bosses.get().getJobController().getDefaultHandler().handleExecute(Bosses.get().getExecutors(), prepareWorker);
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void call(IN in5) {
        boolean z16;
        synchronized (this) {
            int i3 = this.mNumCurrentRequests;
            z16 = true;
            if (i3 >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(in5);
            } else {
                this.mNumCurrentRequests = i3 + 1;
                z16 = false;
            }
        }
        if (!z16) {
            produceResultsInternal(in5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void error(Error error) {
        ThreadOffErrJob threadOffErrJob = new ThreadOffErrJob(this.mTAG);
        threadOffErrJob.setJobType(this.mJobType);
        Bosses.get().postJob(threadOffErrJob, error);
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void onCancel() {
        Iterator<Map.Entry<IN, Future>> it = this.mFutures.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel(true);
        }
        synchronized (this) {
            this.mFutures.clear();
            this.mPendingRequests.clear();
            this.mNumCurrentRequests = 0;
        }
    }

    public ThrottlingFunction(@NonNull String str, int i3, int i16) {
        this.mFutures = new ConcurrentHashMap();
        this.mTAG = str;
        this.mPendingRequests = new ConcurrentLinkedQueue<>();
        this.mMaxSimultaneousRequests = i3;
        this.mJobType = i16;
        this.mNumCurrentRequests = 0;
    }
}
