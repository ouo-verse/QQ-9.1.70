package com.tencent.mobileqq.ar.ARPromotion;

import android.content.Context;
import com.tencent.mobileqq.ar.ARRenderModel.r;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements r.b {
    public static int D = 8;

    /* renamed from: d, reason: collision with root package name */
    private Context f196860d;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC7395a f196863h;

    /* renamed from: e, reason: collision with root package name */
    private boolean f196861e = false;

    /* renamed from: i, reason: collision with root package name */
    private int f196864i = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f196865m = 0;
    private boolean C = true;

    /* renamed from: f, reason: collision with root package name */
    private r f196862f = new r();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARPromotion.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC7395a {
        void a(boolean z16);
    }

    public a(Context context) {
        this.f196860d = context;
    }

    private void a(float f16, float f17, float f18, long j3) {
        int i3;
        if (this.f196865m != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f196865m < 1000) {
                return;
            } else {
                this.f196865m = currentTimeMillis;
            }
        } else {
            this.f196865m = System.currentTimeMillis();
        }
        if (f17 > D) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("ARPhonePoseDetectManager", 1, "ARPhonePoseDetectManager current value:=" + this.f196864i + ";nextPhonepose:=" + i3);
        }
        if (this.f196864i != i3) {
            QLog.i("ARPhonePoseDetectManager", 1, "detectPhonePose. data = " + f16 + "," + f17 + "," + f18 + "," + j3 + ", mPhonePose = " + this.f196864i + ", phonePose = " + i3);
            if (i3 == 2 && this.C) {
                this.C = false;
            }
            this.f196864i = i3;
            InterfaceC7395a interfaceC7395a = this.f196863h;
            if (interfaceC7395a != null) {
                if (i3 == 1) {
                    interfaceC7395a.a(true);
                } else if (i3 == 2) {
                    interfaceC7395a.a(false);
                }
            }
        }
    }

    public void b() {
        this.f196862f.i();
        this.f196864i = 0;
    }

    public void c() {
        if (!this.f196861e) {
            this.f196862f.c(this.f196860d, this);
            this.f196861e = true;
        } else {
            this.f196862f.g();
            this.f196864i = 0;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.r.b
    public void d(float f16, float f17, float f18, long j3) {
        a(f16, f17, f18, j3);
    }

    public void e(InterfaceC7395a interfaceC7395a) {
        this.f196863h = interfaceC7395a;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.r.b
    public void y(float[] fArr) {
    }
}
