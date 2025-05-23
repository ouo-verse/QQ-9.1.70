package com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f287868c;

    /* renamed from: a, reason: collision with root package name */
    c f287869a = null;

    /* renamed from: b, reason: collision with root package name */
    b f287870b = null;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.shortvideo.gesture.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8592a {
        void l8(boolean z16, boolean z17, int i3);

        void onDownloadProgress(int i3);
    }

    a() {
    }

    public static a c() {
        if (f287868c == null) {
            synchronized (a.class) {
                if (f287868c == null) {
                    a aVar = new a();
                    aVar.d();
                    f287868c = aVar;
                }
            }
        }
        return f287868c;
    }

    private void d() {
        this.f287869a = new c();
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            this.f287870b = new b();
        }
    }

    public static void g() {
        a c16 = c();
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", Integer.valueOf(c16.f287869a.f287886b)));
        }
        b.a();
    }

    public void a(boolean z16, InterfaceC8592a interfaceC8592a) {
        this.f287869a.a(z16, interfaceC8592a);
    }

    public boolean b() {
        return this.f287869a.b();
    }

    public boolean e() {
        if (this.f287869a.f287886b == 1) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f287869a.d();
    }
}
