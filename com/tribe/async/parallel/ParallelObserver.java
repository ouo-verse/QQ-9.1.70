package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tribe.async.log.SLog;

/* loaded from: classes27.dex */
public abstract class ParallelObserver implements Observer {
    private static final int MAX_FUNCTION_COUNT = 100;
    private static final String TAG = "vianhuang.SimpleParallelObserver";
    private boolean mSuccess = true;
    private boolean mIsCancel = false;
    private int mObserverFunctionCount = 0;
    private SparseArray<Integer> mObserverFunctions = new SparseArray<>();
    private Object[] mFunctionResults = new Object[100];

    private boolean isAllFunctionComplete() {
        if (this.mObserverFunctions.size() > 0) {
            return false;
        }
        return true;
    }

    @Override // com.tribe.async.parallel.Observer
    public final synchronized void addObserverFunction(Integer num) {
        SLog.d(TAG, "add a function that need be observed. functionCode = %d", num);
        if (this.mObserverFunctions.size() != 100) {
            this.mObserverFunctions.put(num.intValue(), Integer.valueOf(this.mObserverFunctions.size()));
            this.mObserverFunctionCount = this.mObserverFunctions.size();
        } else {
            throw new IllegalStateException("you can't add more than 100 functions.");
        }
    }

    public <Result> Result getFunctionResult(int i3) {
        Result result;
        if (i3 >= 0 && i3 < this.mObserverFunctionCount) {
            result = (Result) this.mFunctionResults[i3];
        } else {
            result = null;
        }
        SLog.i(TAG, "get the %d function's result is %s.", Integer.valueOf(i3), result);
        return result;
    }

    public abstract void onCancel();

    public abstract void onOneFuncErr(int i3, @NonNull Error error);

    public abstract void onOneFuncSuc(int i3, Object obj);

    @Override // com.tribe.async.parallel.Observer
    public final void onOneFunctionErr(Integer num, @NonNull Error error) {
        if (this.mIsCancel) {
            SLog.d(TAG, "one function error while stream is cancel.");
            return;
        }
        int intValue = this.mObserverFunctions.get(num.intValue()).intValue();
        int i3 = this.mObserverFunctionCount - (intValue + 1);
        if (intValue < 0) {
            SLog.w(TAG, "can't find this error function in observing queue, just ignore.");
            return;
        }
        SLog.d(TAG, "on one function error. functionCode = %d, error = %s.", num, error);
        synchronized (this) {
            this.mSuccess = false;
            this.mObserverFunctions.delete(num.intValue());
        }
        onOneFuncErr(i3, error);
        if (isAllFunctionComplete()) {
            SLog.d(TAG, "all functions had completed. result = %s.", Boolean.valueOf(this.mSuccess));
            onAllFunctionComplete(this.mSuccess);
        }
    }

    @Override // com.tribe.async.parallel.Observer
    public final void onOneFunctionSuc(Integer num, Object obj) {
        if (this.mIsCancel) {
            SLog.d(TAG, "one function success while stream is cancel.");
            return;
        }
        if (this.mObserverFunctions.get(num.intValue()) == null) {
            SLog.w(TAG, "can't find this successful function in observing queue, just ignore.");
            return;
        }
        int intValue = this.mObserverFunctionCount - (this.mObserverFunctions.get(num.intValue()).intValue() + 1);
        SLog.d(TAG, "on one function success. functionCode = %d, result = %s.", num, obj);
        synchronized (this) {
            this.mObserverFunctions.delete(num.intValue());
            this.mFunctionResults[intValue] = obj;
        }
        onOneFuncSuc(intValue, obj);
        if (isAllFunctionComplete()) {
            onAllFunctionComplete(this.mSuccess);
        }
    }

    @Override // com.tribe.async.parallel.Observer
    public final void onStreamCancel() {
        this.mIsCancel = true;
        onCancel();
    }
}
