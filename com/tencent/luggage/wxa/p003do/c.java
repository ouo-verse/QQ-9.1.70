package com.tencent.luggage.wxa.p003do;

import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f124403a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f124404b;

    public static final boolean a() {
        Boolean bool;
        Boolean bool2 = f124404b;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            Object invoke = cls.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(cls.newInstance(), "ro.config.hw_magic_window_enable", Boolean.FALSE);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) invoke;
        } catch (Throwable th5) {
            w.f("MicroMsg.HuaweiKt", "hasHuaweiMagicWindowFeature: " + th5.getMessage());
            bool = Boolean.FALSE;
        }
        f124404b = bool;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }
}
