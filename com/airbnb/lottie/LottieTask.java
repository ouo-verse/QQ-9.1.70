package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR = ProxyExecutors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;

    @Nullable
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.setResult(get());
                } catch (InterruptedException | ExecutionException e16) {
                    LottieTask.this.setResult(new LottieResult(e16));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyListeners$0() {
        LottieResult<T> lottieResult = this.result;
        if (lottieResult == null) {
            return;
        }
        if (lottieResult.getValue() != null) {
            notifySuccessListeners(lottieResult.getValue());
        } else {
            notifyFailureListeners(lottieResult.getException());
        }
    }

    private synchronized void notifyFailureListeners(Throwable th5) {
        ArrayList arrayList = new ArrayList(this.failureListeners);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th5);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(th5);
        }
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.af
            @Override // java.lang.Runnable
            public final void run() {
                LottieTask.this.lambda$notifyListeners$0();
            }
        });
    }

    private synchronized void notifySuccessListeners(T t16) {
        Iterator it = new ArrayList(this.successListeners).iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(@Nullable LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (lottieResult != null && lottieResult.getException() != null) {
            lottieListener.onResult(lottieResult.getException());
        }
        this.failureListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (lottieResult != null && lottieResult.getValue() != null) {
            lottieListener.onResult(lottieResult.getValue());
        }
        this.successListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable, boolean z16) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z16) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th5) {
                setResult(new LottieResult<>(th5));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(callable));
    }
}
