package com.tencent.common.danmaku;

import android.content.res.Resources;
import android.os.Handler;
import android.view.WindowManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface b {
    void a(int i3, int i16, long j3, HashMap hashMap);

    boolean b();

    WindowManager c();

    boolean d();

    Resources e();

    Object f(Class<?> cls, String str, Object obj);

    Handler getHandler();

    boolean isDebug();
}
