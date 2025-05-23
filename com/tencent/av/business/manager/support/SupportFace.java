package com.tencent.av.business.manager.support;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.r;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SupportFace extends b {

    /* renamed from: f, reason: collision with root package name */
    private int f73442f;

    /* renamed from: g, reason: collision with root package name */
    private int f73443g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f73444h;

    public SupportFace(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f73442f = -1;
        this.f73443g = -1;
        this.f73444h = false;
    }

    private boolean i() {
        return j.G();
    }

    private boolean j() {
        return j.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (QLog.isColorLevel()) {
            QLog.i("SupportFace", 2, "onSendSupportMsg");
        }
        boolean h16 = uv.b.h();
        boolean j3 = j();
        if (j3 && h16) {
            r.h0().s2(1, "SUPPORT_TRUE");
        }
        boolean i3 = i();
        if (i3 && h16) {
            r.h0().s2(3, "SUPPORT_TRUE");
        }
        if (!j3 || !i3) {
            QLog.w("SupportFace", 1, "onSendSupportMsg, normal[" + j3 + "], interact[" + i3 + "], isAEKitResExist[" + h16 + "]");
        }
    }

    @Override // com.tencent.av.business.manager.support.b
    public boolean a(String str) {
        if ("normal".equalsIgnoreCase(str)) {
            return j();
        }
        if ("interact".equalsIgnoreCase(str)) {
            return i();
        }
        return false;
    }

    @Override // com.tencent.av.business.manager.support.b
    public boolean c(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("SupportFace", 2, "onReceiveSupportMessage type: " + i3 + " id: " + str);
        }
        if (!this.f73444h) {
            com.tencent.qav.thread.a.d().postDelayed(new Runnable() { // from class: com.tencent.av.business.manager.support.SupportFace.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SupportFace.this.f73444h) {
                        SupportFace.this.e();
                        SupportFace.this.f73444h = true;
                    }
                }
            }, 1100L);
        }
        AVCoreLog.printColorLog("SupportFace", "onReceiveSupportMessage type:" + i3 + "|" + str);
        if (str == null) {
            return false;
        }
        if (str.equals("SUPPORT_TRUE")) {
            if (i3 == 1) {
                this.f73442f = 1;
                return false;
            }
            if (i3 == 3) {
                this.f73442f = 1;
                this.f73443g = 1;
                return false;
            }
        } else {
            if (!str.equals("SUPPORT_FALSE")) {
                return false;
            }
            if (i3 == 1) {
                this.f73442f = 0;
                this.f73443g = 0;
            } else if (i3 == 3) {
                this.f73443g = 0;
            }
        }
        return true;
    }

    @Override // com.tencent.av.business.manager.support.b
    public void d() {
        this.f73444h = false;
        this.f73442f = -1;
        this.f73443g = -1;
        AVCoreLog.printColorLog("SupportFace", "SupportFace restore:");
    }

    @Override // com.tencent.av.business.manager.support.b
    public void e() {
        if (QLog.isColorLevel()) {
            QLog.i("SupportFace", 2, "sendSupportMsg");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.manager.support.SupportFace.2
            @Override // java.lang.Runnable
            public void run() {
                SupportFace.this.k();
            }
        }, 16, null, false);
    }
}
