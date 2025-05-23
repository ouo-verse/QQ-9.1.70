package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface Action<T> {
    public static final String TAG = "Action";

    T perform(BaseRuntime baseRuntime);
}
