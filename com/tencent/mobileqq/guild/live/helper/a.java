package com.tencent.mobileqq.guild.live.helper;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private INetEventHandler f226688b = new C7811a();

    /* renamed from: a, reason: collision with root package name */
    private pq1.c f226687a = new pq1.c();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.live.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7811a implements INetEventHandler {
        C7811a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            a.this.f226687a.h(z16);
            QLog.i("QGL.HttpDns_helper", 4, "\u7f51\u7edc\u53d8\u5316\u4e8b\u4ef6:" + z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f226690a = new a();
    }

    a() {
    }

    private uq1.c c() {
        QLog.e("QGL.HttpDns_helper", 1, "get httpdns result fail, empty");
        return null;
    }

    public static final a d() {
        return b.f226690a;
    }

    public uq1.b b(String str) {
        new uq1.b().e(str);
        c();
        return null;
    }

    public boolean e() {
        return this.f226687a.d();
    }

    public void f(boolean z16) {
        QLog.i("QGL.HttpDns_helper", 4, "\u5f53\u524d\u9891\u9053\u53ef\u89c1 :" + z16);
        this.f226687a.g(z16);
        if (z16) {
            AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this.f226688b);
        } else {
            AppNetConnInfo.unregisterNetEventHandler(this.f226688b);
        }
    }

    public void g(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u5f53\u524d\u9891\u9053 :");
        if (z16) {
            str = "\u6b63\u5728\u76f4\u64ad\u4e2d";
        } else {
            str = "\u65e0\u76f4\u64ad";
        }
        sb5.append(str);
        QLog.i("QGL.HttpDns_helper", 4, sb5.toString());
        this.f226687a.f(z16);
    }
}
