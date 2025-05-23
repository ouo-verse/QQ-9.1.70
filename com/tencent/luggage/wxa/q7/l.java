package com.tencent.luggage.wxa.q7;

import com.tencent.luggage.wxaapi.WxaApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f138014b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(l.class, "modeInt", "getModeInt()I", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final l f138013a = new l();

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f138015c = new com.tencent.luggage.wxa.e5.j("Wxa.MiniGameRenderModeConfig", (Object) 0);

    public final void a(int i3) {
        f138015c.a(this, f138014b[0], Integer.valueOf(i3));
    }

    public final int b() {
        return ((Number) f138015c.a(this, f138014b[0])).intValue();
    }

    public final void a(WxaApi.MiniGameRenderMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        a(value.ordinal());
    }

    public final WxaApi.MiniGameRenderMode a() {
        int b16 = b();
        for (WxaApi.MiniGameRenderMode miniGameRenderMode : WxaApi.MiniGameRenderMode.values()) {
            if (b16 == miniGameRenderMode.ordinal()) {
                return miniGameRenderMode;
            }
        }
        return WxaApi.MiniGameRenderMode.SurfaceView;
    }
}
