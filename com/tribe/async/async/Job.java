package com.tribe.async.async;

import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.utils.AssertUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class Job<Params, Progress, Result> implements Callable<Result> {
    public static final int TYPE_CPU = 2;
    public static final int TYPE_DISK_READ = 4;
    public static final int TYPE_DISK_WRITE = 8;
    public static final int TYPE_NETWORK = 16;
    private JobContext mJobContext;

    @Nullable
    private Params mParams;
    private final String mTAG;
    private int mType;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface JobType {
    }

    @Deprecated
    public Job() {
        this("Job");
    }

    public static JobContext stubJobContext() {
        return new StubJobContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        Object[] objArr;
        Process.setThreadPriority(10);
        Params params = this.mParams;
        if (params != null) {
            objArr = (Object[]) Array.newInstance(params.getClass(), 1);
            objArr[0] = this.mParams;
        } else {
            objArr = null;
        }
        AssertUtils.checkNotNull(this.mJobContext);
        return (Result) doInBackground(this.mJobContext, objArr);
    }

    protected boolean checkParams(@Nullable Params params) {
        return true;
    }

    protected abstract Result doInBackground(@NonNull JobContext jobContext, @Nullable Params... paramsArr);

    public int getJobType() {
        return this.mType;
    }

    @Nullable
    public Params getParams() {
        return this.mParams;
    }

    public boolean isCancelled() {
        return this.mJobContext.isJobCancelled();
    }

    public void publishProgress(Progress progress) {
        JobContext jobContext = this.mJobContext;
        if (jobContext != null) {
            jobContext.publishJobProgress(progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setJobContext(JobContext jobContext) {
        this.mJobContext = jobContext;
    }

    public void setJobType(int i3) {
        this.mType = i3;
    }

    public void setParams(@Nullable Params params) {
        this.mParams = params;
        if (checkParams(params)) {
            return;
        }
        throw new IllegalArgumentException("params is incorrect! \n" + toString());
    }

    public String toString() {
        return "Job{mTAG='" + this.mTAG + "', mType= " + this.mType + ", mParams=" + this.mParams + '}';
    }

    public Job(@NonNull String str) {
        this.mType = 2;
        this.mTAG = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelled() {
    }

    public void onPost() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResult(@Nullable Result result) {
    }
}
