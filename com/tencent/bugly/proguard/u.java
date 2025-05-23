package com.tencent.bugly.proguard;

import android.os.Looper;
import com.tencent.bugly.common.looper.MsgScheduleRecorder;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    private static u f98569c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f98570d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public MsgScheduleRecorder f98571a = new MsgScheduleRecorder(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public boolean f98572b = false;

    u() {
    }

    public static u a() {
        if (f98569c == null) {
            synchronized (f98570d) {
                if (f98569c == null) {
                    f98569c = new u();
                }
            }
        }
        return f98569c;
    }
}
