package com.qzone.reborn.configx;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000eJ#\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0004H&J\b\u0010\u0014\u001a\u00020\u0004H&R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/configx/d;", "", "Led/a;", "g", "", "secondKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "e", "", "f", "", "b", "", "c", "", "a", "T", "d", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "i", tl.h.F, "Led/a;", "mWnsConfigChannel", "mCangLanConfigChannel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ed.a mWnsConfigChannel = new ed.c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ed.a mCangLanConfigChannel = new ed.b();

    private final ed.a g() {
        String h16 = h();
        if (Intrinsics.areEqual(h16, "CONFIG_CHANNEL_WNS")) {
            return this.mWnsConfigChannel;
        }
        if (Intrinsics.areEqual(h16, "CONFIG_CHANNEL_CANG_LAN")) {
            return this.mCangLanConfigChannel;
        }
        return this.mWnsConfigChannel;
    }

    public final float a(String secondKey, float defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return g().d(i(), secondKey, defaultValue);
    }

    public final int b(String secondKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return g().getConfig(i(), secondKey, defaultValue);
    }

    public final long c(String secondKey, long defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return g().c(i(), secondKey, defaultValue);
    }

    public final <T> T d(String secondKey, T defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return (T) g().getConfig(i(), secondKey, (String) defaultValue);
    }

    public final String e(String secondKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return g().a(i(), secondKey, defaultValue);
    }

    public final boolean f(String secondKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return g().b(i(), secondKey, defaultValue);
    }

    public abstract String h();

    public abstract String i();
}
