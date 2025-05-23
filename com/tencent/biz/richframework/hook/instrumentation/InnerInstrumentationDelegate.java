package com.tencent.biz.richframework.hook.instrumentation;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface InnerInstrumentationDelegate {
    Activity newActivity(Context context, Instrumentation instrumentation, ClassLoader classLoader, String str, Intent intent);
}
