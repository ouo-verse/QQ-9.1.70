package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QueryTask<Param, Result> implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QueryTask";
    public static final int TIME_NO_WAIT = 0;
    public QueryCallback<Result> callback;
    private final AtomicBoolean isCallbackInvoked;
    private final CountDownLatch latch;
    private Param param;
    public Query<Param, Result> query;
    private Result result;
    private final long taskCreateTime;
    private int waitTime;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface Query<P, R> {
        R query(P p16);
    }

    public QueryTask(Query<Param, Result> query, QueryCallback<Result> queryCallback) {
        this(query, queryCallback, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) query, (Object) queryCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback() {
        if (this.isCallbackInvoked.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis() - this.taskCreateTime;
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "[doCallback] costTime=" + currentTimeMillis);
            }
            this.callback.postQuery(this.result);
        }
    }

    public void execute(Param param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        this.param = param;
        ThreadManagerV2.excute(this, 32, null, true);
        CountDownLatch countDownLatch = this.latch;
        if (countDownLatch != null) {
            try {
                if (countDownLatch.await(this.waitTime, TimeUnit.MILLISECONDS)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "[execute] finish task in time");
                    }
                    doCallback();
                }
            } catch (InterruptedException e16) {
                QLog.i(TAG, 1, "[execute] exc=" + e16);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.result = this.query.query(this.param);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.an
                @Override // java.lang.Runnable
                public final void run() {
                    QueryTask.this.doCallback();
                }
            });
        }
    }

    public QueryTask(Query<Param, Result> query, QueryCallback<Result> queryCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, query, queryCallback, Integer.valueOf(i3));
            return;
        }
        this.waitTime = 0;
        this.isCallbackInvoked = new AtomicBoolean(false);
        this.query = query;
        this.callback = queryCallback;
        this.waitTime = i3;
        this.taskCreateTime = System.currentTimeMillis();
        if (i3 > 0) {
            this.latch = new CountDownLatch(1);
        } else {
            this.latch = null;
        }
    }
}
