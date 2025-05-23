package com.qq.e.comm.plugin.k;

import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ap f39625a;

    ap() {
    }

    public static ap a() {
        if (f39625a == null) {
            synchronized (ap.class) {
                if (f39625a == null) {
                    f39625a = new ap();
                }
            }
        }
        return f39625a;
    }

    public void a(Map<Integer, String> map) {
        if (SDKStatus.getSDKVersionCode() >= 282) {
            StubVisitor.getInstance().onDataUsed(map);
        }
    }
}
