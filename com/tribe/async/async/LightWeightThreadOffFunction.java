package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LightWeightThreadOffFunction<IN> extends StreamFunction<IN, IN> {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class ThreadOffErrRunnable implements Runnable {
        private Error mError;

        public ThreadOffErrRunnable(Error error) {
            this.mError = error;
        }

        @Override // java.lang.Runnable
        public void run() {
            LightWeightThreadOffFunction.this.notifyError(this.mError);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class ThreadOffRunnable implements Runnable {
        private IN mResult;

        public ThreadOffRunnable(IN in5) {
            this.mResult = in5;
        }

        @Override // java.lang.Runnable
        public void run() {
            LightWeightThreadOffFunction.this.notifyResult(this.mResult);
        }
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void call(IN in5) {
        Bosses.get().postLightWeightJob(new ThreadOffRunnable(in5), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void error(Error error) {
        Bosses.get().postLightWeightJob(new ThreadOffErrRunnable(error), 0);
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void onCancel() {
    }
}
