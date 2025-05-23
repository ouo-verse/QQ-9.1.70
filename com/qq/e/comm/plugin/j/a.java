package com.qq.e.comm.plugin.j;

import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.status.SDKStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f39586a = new a();

    public static a a() {
        return f39586a;
    }

    public void b() {
        e.a().b();
    }

    public void c() {
        if (SDKStatus.getSDKVersionCode() >= 220) {
            e.a().c();
        }
    }

    public void a(int i3, String str, ADListener aDListener) {
        e.a().a(i3, str, aDListener);
    }
}
