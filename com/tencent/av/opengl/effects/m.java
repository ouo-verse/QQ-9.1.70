package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.EffectPendantTipsImpl;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.opengl.PtuSoLoader;
import com.tencent.av.video.effect.QavVideoEffect;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.ByteUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import mqq.app.MobileQQ;
import org.light.CameraConfig;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes3.dex */
public class m extends j implements SensorEventListener {

    /* renamed from: d0, reason: collision with root package name */
    private static boolean f73990d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    static final int[] f73991e0 = {2, 13, 14};
    private VideoMaterial T = null;
    private final SensorManager U;
    private final Sensor V;
    CameraConfig.DeviceCameraOrientation W;
    private float X;
    private EffectPendantTipsImpl Y;
    private BitSet Z;

    /* renamed from: a0, reason: collision with root package name */
    private VideoAppInterface f73992a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f73993b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f73994c0;

    public m(VideoAppInterface videoAppInterface) {
        QLog.w("EffectsRenderController", 1, "EffectsRenderController, constructor, app[" + videoAppInterface + "], mContext[" + this.Q + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        this.f73992a0 = videoAppInterface;
        MobileQQ application = videoAppInterface.getApplication();
        this.Q = application;
        EffectPendantTipsImpl effectPendantTipsImpl = new EffectPendantTipsImpl(application);
        this.Y = effectPendantTipsImpl;
        effectPendantTipsImpl.j(videoAppInterface);
        this.F = new q(this.Q, this.f73992a0.y());
        SensorManager sensorManager = (SensorManager) this.Q.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.U = sensorManager;
        this.V = SensorMonitor.getDefaultSensor(sensorManager, 1);
        this.Z = new BitSet();
        if (QLog.isColorLevel()) {
            QavVideoEffect.DEBUG_MODE = true;
        }
        h.d(this.Q);
    }

    public static boolean K() {
        if (!f73990d0) {
            boolean a16 = uv.b.f().a(VideoAppInterface.N());
            f73990d0 = a16;
            if (!a16) {
                QLog.w("EffectsRenderController", 1, "isLoadedSO, \u52a0\u8f7dso\u5931\u8d25");
                return false;
            }
        }
        if (PtuSoLoader.soloadedPTV) {
            return true;
        }
        PtuSoLoader.loadPtuSO();
        QLog.w("EffectsRenderController", 1, "isLoadedSO, soloadedPTV[" + PtuSoLoader.soloadedPTV + "]");
        boolean z16 = PtuSoLoader.soloadedPTV;
        if (z16) {
            m R = com.tencent.av.r.h0().R(true);
            if (R != null) {
                R.o();
            }
            com.tencent.av.r.h0().X2(PtuSoLoader.soloadedPTV);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0100  */
    @Override // com.tencent.av.opengl.effects.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected byte[] B(byte[] bArr, byte[] bArr2, byte[] bArr3, short s16, short s17, short s18, short s19) {
        int c16;
        lv.a aVar;
        boolean z16;
        int c17;
        short s26;
        short s27;
        ArrayList arrayList = new ArrayList();
        if (!this.Z.get(0) && !this.Z.get(1) && !this.Z.get(2) && !this.Z.get(3)) {
            c16 = 0;
        } else {
            if (this.Z.get(2) || this.Z.get(3)) {
                int Q = com.tencent.av.r.h0().Q(false);
                AVCoreLog.printColorLog("EffectsRenderController", "buildExtInfo volume :" + Q + this.Z.get(1) + "|" + this.Z.get(0));
                if (Q < 100) {
                    byte[] bArr4 = new byte[2];
                    ByteUtils.Word2Byte(bArr4, 0, (short) Q);
                    lv.a aVar2 = new lv.a((short) 2, (short) 2, bArr4);
                    if (this.Z.get(3)) {
                        arrayList.add(aVar2);
                        c16 = aVar2.c() + 0;
                        if (!this.Z.get(0) || this.Z.get(1)) {
                            AVCoreLog.printColorLog("EffectsRenderController", "buildExtInfo face :" + bArr + "|" + this.Z.get(1) + "|" + this.Z.get(0));
                            if ((bArr != null && bArr2 != null) || bArr3 != null) {
                                if (bArr != null) {
                                    aVar = new lv.a((short) 1, (short) bArr.length, bArr);
                                } else {
                                    aVar = null;
                                }
                                if (bArr2 != null) {
                                    new lv.a((short) 4, (short) bArr2.length, bArr2);
                                }
                                if (bArr3 != null) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (this.Z.get(1)) {
                                    if (z16) {
                                        lv.a aVar3 = new lv.a((short) 6, (short) bArr3.length, bArr3);
                                        arrayList.add(aVar3);
                                        c17 = aVar3.c();
                                    } else {
                                        if (aVar != null) {
                                            arrayList.add(aVar);
                                            c17 = aVar.c();
                                        }
                                        byte[] bArr5 = new byte[8];
                                        if (!z16) {
                                            s26 = s19;
                                        } else {
                                            s26 = 320;
                                        }
                                        if (!z16) {
                                            s27 = s18;
                                        } else {
                                            s27 = 240;
                                        }
                                        bArr5[0] = (byte) (s26 >> 8);
                                        bArr5[1] = (byte) s26;
                                        bArr5[2] = (byte) (s27 >> 8);
                                        bArr5[3] = (byte) s27;
                                        bArr5[4] = (byte) (s18 >> 8);
                                        bArr5[5] = (byte) s18;
                                        bArr5[6] = (byte) (s19 >> 8);
                                        bArr5[7] = (byte) s19;
                                        lv.a aVar4 = new lv.a((short) 3, (short) 8, bArr5);
                                        arrayList.add(aVar4);
                                        c16 += aVar4.c();
                                    }
                                    c16 += c17;
                                    byte[] bArr52 = new byte[8];
                                    if (!z16) {
                                    }
                                    if (!z16) {
                                    }
                                    bArr52[0] = (byte) (s26 >> 8);
                                    bArr52[1] = (byte) s26;
                                    bArr52[2] = (byte) (s27 >> 8);
                                    bArr52[3] = (byte) s27;
                                    bArr52[4] = (byte) (s18 >> 8);
                                    bArr52[5] = (byte) s18;
                                    bArr52[6] = (byte) (s19 >> 8);
                                    bArr52[7] = (byte) s19;
                                    lv.a aVar42 = new lv.a((short) 3, (short) 8, bArr52);
                                    arrayList.add(aVar42);
                                    c16 += aVar42.c();
                                } else if (this.Z.get(0)) {
                                    L(this.f73993b0, lv.b.a(aVar));
                                }
                            }
                        }
                    } else if (this.Z.get(2)) {
                        L(this.f73993b0, lv.b.a(aVar2));
                    }
                }
            }
            c16 = 0;
            if (!this.Z.get(0)) {
            }
            AVCoreLog.printColorLog("EffectsRenderController", "buildExtInfo face :" + bArr + "|" + this.Z.get(1) + "|" + this.Z.get(0));
            if (bArr != null) {
                if (bArr != null) {
                }
                if (bArr2 != null) {
                }
                if (bArr3 != null) {
                }
                if (this.Z.get(1)) {
                }
            }
            if (bArr != null) {
            }
            if (bArr2 != null) {
            }
            if (bArr3 != null) {
            }
            if (this.Z.get(1)) {
            }
        }
        if (c16 > 0) {
            ByteBuffer allocate = ByteBuffer.allocate(c16);
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                allocate.put(lv.b.a((lv.a) arrayList.get(i3)));
            }
            return allocate.array();
        }
        return null;
    }

    @Override // com.tencent.av.opengl.effects.j
    public float[] C() {
        return com.tencent.av.r.h0().I().f();
    }

    public void J(int i3) {
        if (i3 >= 0 && i3 < 5) {
            if (this.Z.get(i3)) {
                QLog.w("EffectsRenderController", 1, "clearExtInfo, flag[" + i3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
            this.Z.clear(i3);
        }
    }

    protected void L(String str, byte[] bArr) {
        if (this.f73992a0 != null) {
            this.f73992a0.k0(new Object[]{130, str, bArr});
        }
    }

    public void M(VideoAppInterface videoAppInterface) {
        this.f73992a0 = videoAppInterface;
        this.f73993b0 = videoAppInterface.getCurrentAccountUin();
        this.Y.j(videoAppInterface);
    }

    public void N(int i3) {
        if (i3 >= 0 && i3 < 5) {
            if (!this.Z.get(i3)) {
                QLog.w("EffectsRenderController", 1, "setExtInfo, flag[" + i3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
            this.Z.set(i3);
            return;
        }
        if (i3 < 5) {
            return;
        }
        throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5" + HardCodeUtil.qqStr(R.string.m59));
    }

    @Override // com.tencent.av.opengl.effects.i
    public boolean b() {
        boolean z16;
        if (!j.D()) {
            return false;
        }
        SessionInfo f16 = com.tencent.av.n.e().f();
        int i3 = f16.f73035i;
        if (i3 != 2 && i3 != 4) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || (f16.I1.isEmpty() && !this.f73992a0.Z() && !f16.N1)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.av.opengl.effects.i
    public void c(int i3) {
        this.f73994c0 = i3;
    }

    @Override // com.tencent.av.opengl.effects.j, com.tencent.av.opengl.effects.l, com.tencent.av.opengl.effects.s, com.tencent.av.opengl.effects.v
    public void h() {
        super.h();
        ag.e().k(this.Y);
    }

    @Override // com.tencent.av.opengl.effects.l
    protected boolean n() {
        SessionInfo f16;
        if (!((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).isSupported() || (f16 = com.tencent.av.n.e().f()) == null || !f16.f73098x2) {
            return false;
        }
        if (this.T == null) {
            if (!K() || !ax.a.c(this.f73992a0) || !AVAvatarResMgr.v().k()) {
                return false;
            }
            String w3 = AVAvatarResMgr.v().w("LightSDKSettings");
            if (TextUtils.isEmpty(w3)) {
                return false;
            }
            this.T = VideoMaterial.loadLightAsset(w3);
            return true;
        }
        return true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        CameraConfig.DeviceCameraOrientation deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_0;
        if (sensorEvent != null && sensorEvent.sensor == this.V) {
            float[] fArr = sensorEvent.values;
            int i3 = (int) fArr[0];
            int i16 = (int) fArr[1];
            if (Math.abs(i16) > Math.abs(i3)) {
                if (i16 <= 1 && i16 < -1) {
                    deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_180;
                }
            } else if (i3 > 1) {
                deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_90;
            } else if (i3 < -1) {
                deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_270;
            }
            if (this.W != deviceCameraOrientation) {
                float f16 = i3;
                if (Math.abs(f16 - this.X) > 3.0f || Math.abs(i16 - this.X) > 3.0f) {
                    Log.d("EffectsRenderController", "orientation is changed from" + this.W + " to " + deviceCameraOrientation + ", and current XAxis:" + i3);
                    this.X = f16;
                    this.W = deviceCameraOrientation;
                    this.D.obtainMessage(9, deviceCameraOrientation).sendToTarget();
                }
            }
        }
    }

    @Override // com.tencent.av.opengl.effects.l
    protected void w(long j3) {
        if (this.f73992a0.Y(2)) {
            ((EffectPendantTools) this.f73992a0.B(2)).R();
        }
        super.w(j3);
    }

    @Override // com.tencent.av.opengl.effects.l
    protected void x() {
        if (this.f73992a0.Y(2)) {
            ((EffectPendantTools) this.f73992a0.B(2)).R();
        }
        super.x();
    }

    @Override // com.tencent.av.opengl.effects.l
    public void y(com.tencent.avcore.camera.data.c cVar, ab abVar) {
        boolean z16;
        EffectPendantBase effectPendantBase;
        boolean z17;
        abVar.a();
        int i3 = 0;
        if (!abVar.f73920f) {
            if (j.D() && uv.b.f().i()) {
                z17 = true;
            } else {
                z17 = false;
            }
            abVar.f73920f = z17;
        }
        if (!this.Z.get(0) && !this.Z.get(1)) {
            z16 = false;
        } else {
            z16 = true;
        }
        abVar.f73918d = z16;
        while (true) {
            int[] iArr = f73991e0;
            if (i3 >= iArr.length) {
                break;
            }
            if (this.f73992a0.Y(iArr[i3]) && (effectPendantBase = (EffectPendantBase) this.f73992a0.B(iArr[i3])) != null) {
                EffectPendantBase.a W = effectPendantBase.W(cVar.f77443c, cVar.f77442b);
                if (W != null) {
                    abVar.f73916b = W.f73387a;
                    abVar.f73917c = W.f73389c;
                }
                if (abVar.f73917c != null) {
                    effectPendantBase.a0(this.Y);
                }
                if (abVar.f73917c != null && abVar.f73916b != null) {
                    break;
                }
            }
            i3++;
        }
        if (this.f73992a0.Y(1)) {
            abVar.f73915a = ((fu.a) this.f73992a0.B(1)).S();
        }
        boolean n3 = n();
        abVar.f73921g = n3;
        if (n3) {
            abVar.f73916b = this.T;
            abVar.f73917c = null;
        } else {
            this.T = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
