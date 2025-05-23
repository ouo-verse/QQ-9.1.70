package com.tribe.async.parallel;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Observer {
    void addObserverFunction(Integer num);

    void onAllFunctionComplete(boolean z16);

    void onOneFunctionErr(Integer num, @NonNull Error error);

    void onOneFunctionSuc(Integer num, Object obj);

    void onStreamCancel();
}
