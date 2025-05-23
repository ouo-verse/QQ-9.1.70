package com.tencent.av.opengl.effects;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.avcore.camera.observe.CameraObserver;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class j extends l implements i {
    private static boolean S = false;
    protected Context Q;
    private CameraObserver R = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends CameraObserver {
        a() {
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void c(long j3, boolean z16, int i3) {
            QLog.w("EffectRenderWrapper", 1, "onAfterOpenCamera, success[" + z16 + "], preSessionType[" + i3 + "], seq[" + j3 + "]");
            if (z16) {
                j.this.z(j3);
            }
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void d(boolean z16) {
            long d16 = com.tencent.av.utils.e.d();
            QLog.w("EffectRenderWrapper", 1, "onAfterReopenCamera, success[" + z16 + "], seq[" + d16 + "]");
            if (z16) {
                j.this.z(d16);
            }
        }
    }

    public static boolean D() {
        if (((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).isSupported() && com.tencent.mobileqq.shortvideo.util.f.m()) {
            return true;
        }
        return false;
    }

    public static boolean E() {
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            return false;
        }
        return model.equals("MI 5");
    }

    public static boolean F(int i3, long j3) {
        if (E()) {
            return true;
        }
        int K = com.tencent.mobileqq.utils.ah.K();
        if (K < 17) {
            AVCoreLog.printColorLog("EffectRenderWrapper", "isUserEffectFace error  osVersion:" + K);
            return false;
        }
        return k.a(i3, j3, 1073741824L);
    }

    public static boolean G() {
        boolean z16;
        if (S) {
            return true;
        }
        mv.a a16 = mv.a.a();
        if (a16 != null && a16.b()) {
            S = true;
            return true;
        }
        if (!H()) {
            return false;
        }
        if (!k.a(4, 1400000L, 1073741824L) && !k.a(8, ShortVideoConstants.VIDEO_MAX_DURATION, 1073741824L)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        if (a16 != null && !a16.e()) {
            AVCoreLog.printErrorLog("EffectRenderWrapper", "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + DeviceInfoMonitor.getModel());
            return false;
        }
        S = true;
        return true;
    }

    public static boolean H() {
        return k.a(2, ShortVideoConstants.VIDEO_MAX_DURATION, 1073741824L);
    }

    private void I(com.tencent.avcore.camera.data.c cVar, byte[] bArr, byte[] bArr2, byte[] bArr3, short s16, short s17) {
        if (cVar != null) {
            byte[] B = B(bArr, bArr2, bArr3, s16, s17, (short) cVar.f77442b, (short) cVar.f77443c);
            Object obj = cVar.f77452l;
            if (obj != null) {
                ((com.tencent.av.utils.p) obj).h();
            }
            NtrtcVideoRender.getInstance().sendCameraFrame(cVar.f77441a, cVar.f77444d, cVar.f77442b, cVar.f77443c, cVar.f77445e, cVar.f77446f, cVar.f77449i, cVar.f77447g, C(), B, cVar.f77453m, cVar.f77454n, cVar.f77451k);
            cVar.f77451k = 0;
            cVar.l();
        }
    }

    protected abstract byte[] B(byte[] bArr, byte[] bArr2, byte[] bArr3, short s16, short s17, short s18, short s19);

    protected abstract float[] C();

    @Override // com.tencent.av.opengl.effects.l, com.tencent.av.opengl.effects.s, com.tencent.av.opengl.effects.v
    public void h() {
        super.h();
        com.tencent.av.camera.b.a(this.Q).addObserver(this.R);
    }

    @Override // com.tencent.av.opengl.effects.l
    protected void s(ab abVar, ac acVar) {
        if (abVar != null) {
            NtrtcVideoRender.getInstance().setBeautyOrFaceConfig(EffectPendantTools.c0(abVar.f73917c, abVar.f73919e), 1);
        }
        if (acVar != null) {
            I(acVar.f73922a, acVar.f73923b, acVar.f73924c, acVar.f73925d, acVar.f73926e, acVar.f73927f);
        }
    }
}
