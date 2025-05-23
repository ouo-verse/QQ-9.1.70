package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes11.dex */
public class GeneralAR3DRenderable implements a, ARNativeBridge.ActionCallback {
    private int D;
    private int E;
    private com.tencent.mobileqq.ar.e F;

    /* renamed from: d, reason: collision with root package name */
    private Context f197142d;

    /* renamed from: f, reason: collision with root package name */
    private k f197144f;

    /* renamed from: h, reason: collision with root package name */
    private c f197145h;

    /* renamed from: i, reason: collision with root package name */
    private ARNativeBridge f197146i;

    /* renamed from: m, reason: collision with root package name */
    private int f197147m;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f197143e = 1;
    private volatile int C = 1;
    boolean G = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ GeneralAR3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            GeneralAR3DRenderable generalAR3DRenderable = this.this$0;
            generalAR3DRenderable.G = true;
            generalAR3DRenderable.onDestroy();
        }
    }

    public GeneralAR3DRenderable(c cVar, k kVar) {
        this.f197145h = cVar;
        this.f197144f = kVar;
        this.f197142d = cVar.d();
        this.f197146i = (ARNativeBridge) this.f197145h.e(kVar.f197226b);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void c(int i3, int i16) {
        this.D = i3;
        this.E = i16;
    }

    @Override // com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback
    public void callback(int i3, String str, int i16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_GeneralAR3DRenderable", 2, "fNativeDoActionCallback action=" + i3 + ", params=" + str + ", callbackId=" + i16 + ", result=" + str2);
        }
        c cVar = this.f197145h;
        if (cVar == null) {
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                cVar.h(2, 0);
                return;
            }
            return;
        }
        cVar.h(3, 0);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean canRender() {
        if (this.f197143e == 9 && this.f197147m != 0) {
            return true;
        }
        return false;
    }

    public void e(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        k kVar = this.f197144f;
        if (kVar != null && kVar.f197228d == 1) {
            this.f197146i.nativeOnDrawFrame(this.f197147m, fArr3, fArr4);
        } else {
            this.f197146i.nativeOnDrawFrame(this.f197147m, fArr2, fArr4);
        }
    }

    public void f(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_GeneralAR3DRenderable", 2, "setState, mCurState=" + this.f197143e + ", new State=" + i3 + ", arTarget=");
        }
        this.f197143e = i3;
        if (i3 != 2) {
            switch (i3) {
                case 6:
                    this.f197146i.nativeonSurfaceChanged(this.f197147m, this.D, this.E);
                    return;
                case 7:
                    this.f197146i.nativeResume(this.f197147m);
                    this.C = 0;
                    f(11);
                    return;
                case 8:
                    this.f197146i.nativePause(this.f197147m);
                    return;
                case 9:
                    this.f197145h.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GeneralAR3DRenderable.this.f197143e != 9) {
                                return;
                            }
                            if (GeneralAR3DRenderable.this.f197145h != null) {
                                GeneralAR3DRenderable.this.f197145h.h(0, 1);
                            }
                            if (GeneralAR3DRenderable.this.F != null) {
                                GeneralAR3DRenderable.this.F.k();
                            }
                        }
                    });
                    return;
                case 10:
                    this.f197146i.nativeDestroyCertainEngine(this.f197147m);
                    this.f197146i.setupActionCallback(null);
                    this.f197147m = 0;
                    com.tencent.mobileqq.ar.e eVar = this.F;
                    if (eVar != null) {
                        eVar.o();
                        this.F.j();
                    }
                    this.f197143e = 1;
                    return;
                default:
                    return;
            }
        }
        int indentification = this.f197146i.getIndentification();
        this.f197147m = indentification;
        String str = this.f197144f.f197283i;
        Context context = this.f197142d;
        this.f197146i.nativeCreateEngine(indentification, str, context, context.getAssets(), this.f197144f.f197284j, this.D, this.E);
        this.f197146i.setupActionCallback(this);
        f(7);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int g() {
        k kVar = this.f197144f;
        if (kVar != null) {
            return kVar.f197228d;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int getType() {
        k kVar = this.f197144f;
        if (kVar != null) {
            return kVar.f197226b;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public String getUniqueKey() {
        return this.f197144f.f197225a;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void init() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_GeneralAR3DRenderable", 2, "init");
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void l(h.a aVar) {
        e((float[]) aVar.a("TARGET_SIZE"), (float[]) aVar.a("POSE"), (float[]) aVar.a("CAMERA_MATRIX"), (float[]) aVar.a("CAMERA_POSITION"));
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean o() {
        return true;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, " + this);
        }
        if (this.f197143e == 9) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, queueEvent, " + this);
            }
            c cVar = this.f197145h;
            if (cVar != null && this.G) {
                cVar.h(1, 0);
                this.G = false;
            }
            c cVar2 = this.f197145h;
            if (cVar2 != null) {
                cVar2.f(this.f197144f.f197225a);
                QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
            }
            if (this.f197143e == 9) {
                f(10);
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onUpdate() {
        if (this.f197143e == 11) {
            int i3 = this.C + 1;
            this.C = i3;
            if (i3 >= 2) {
                f(9);
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void start() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_GeneralAR3DRenderable", 2, "start");
        }
        if (1 == this.f197143e) {
            this.F = new com.tencent.mobileqq.ar.e(this.f197144f.f197285k, "");
            f(2);
        }
    }
}
