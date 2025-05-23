package com.tencent.tmassistant.appinfo.a;

import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f380367b;

    /* renamed from: a, reason: collision with root package name */
    private a f380368a = new a();

    b() {
    }

    public static b a() {
        if (f380367b == null) {
            synchronized (b.class) {
                if (f380367b == null) {
                    f380367b = new b();
                }
            }
        }
        return f380367b;
    }

    public int a(AppDetailReqParam appDetailReqParam, IGetAppInfoCallback iGetAppInfoCallback) {
        return this.f380368a.a(appDetailReqParam, iGetAppInfoCallback);
    }
}
