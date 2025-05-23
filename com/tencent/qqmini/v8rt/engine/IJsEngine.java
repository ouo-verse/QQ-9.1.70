package com.tencent.qqmini.v8rt.engine;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IJsEngine {
    boolean canHandleEvent(String str);

    V8JsRuntime getJsRuntime(int i3);

    void onCreate(Context context);

    void onDestroy();

    String onScriptCall(String str, String str2, int i3, int i16);
}
