package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;

/* loaded from: classes27.dex */
public class SimpleParallelObserver extends ParallelObserver {
    private static final String TAG = "vianhuang.SimpleParallelObserver";

    @Override // com.tribe.async.parallel.Observer
    public void onAllFunctionComplete(boolean z16) {
        SLog.i(TAG, "on all function completed.");
    }

    @Override // com.tribe.async.parallel.ParallelObserver
    public void onCancel() {
        SLog.i(TAG, "on parallel stream been canceled.");
    }

    @Override // com.tribe.async.parallel.ParallelObserver
    public void onOneFuncErr(int i3, @NonNull Error error) {
        SLog.i(TAG, "on one function error. functionIndex = %d, error = %s.", Integer.valueOf(i3), error);
    }

    @Override // com.tribe.async.parallel.ParallelObserver
    public void onOneFuncSuc(int i3, Object obj) {
        SLog.i(TAG, "on one function success. functionIndex = %d, result = %s.", Integer.valueOf(i3), obj);
    }
}
