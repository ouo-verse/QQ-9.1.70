package com.tencent.liteav.base.system;

import com.tencent.liteav.base.util.i;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class i implements i.a {

    /* renamed from: a, reason: collision with root package name */
    private static final i f118992a = new i();

    i() {
    }

    public static i.a a() {
        return f118992a;
    }

    @Override // com.tencent.liteav.base.util.i.a
    public final void a(boolean z16) {
        LiteavSystemInfo.onAppBackgroundStateChanged(z16);
    }
}
