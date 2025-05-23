package com.tencent.av.utils;

import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.avcore.jni.dav.NtrtcAudio;
import com.tencent.avcore.jni.dav.NtrtcUtil;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements com.tencent.av.ui.funchat.record.i {
    private static volatile d H;

    /* renamed from: d, reason: collision with root package name */
    private VcControllerImpl f77083d = null;

    /* renamed from: e, reason: collision with root package name */
    private QQGAudioCtrl f77084e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f77085f = false;

    /* renamed from: h, reason: collision with root package name */
    private int f77086h = 0;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f77087i = null;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f77088m = null;
    private int C = 0;
    private int D = 0;
    private String E = "";
    private String F = "";
    private final Object G = new Object();

    public d() {
        f();
    }

    public static void a() {
        if (H != null) {
            synchronized (d.class) {
                if (H != null) {
                    H.l();
                }
                H = null;
                com.tencent.qav.log.a.e("AudioDump", "destroyInstance.", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
        }
    }

    private boolean b(boolean z16) {
        QQGAudioCtrl qQGAudioCtrl = this.f77084e;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.enableDumpAudioData(z16);
            return true;
        }
        if (this.f77083d != null) {
            NtrtcUtil.getInstance().enableDumpAudioData(z16);
            return true;
        }
        return true;
    }

    public static d c() {
        if (H == null) {
            synchronized (d.class) {
                if (H == null) {
                    H = new d();
                }
            }
        }
        return H;
    }

    public static boolean d() {
        return false;
    }

    private static boolean e(int i3) {
        return false;
    }

    private boolean f() {
        if (this.f77085f) {
            return true;
        }
        this.f77085f = true;
        com.tencent.qav.log.a.d("AudioDump", "init successfully.");
        return true;
    }

    private boolean h(int i3, boolean z16) {
        int i16;
        int i17;
        QQGAudioCtrl qQGAudioCtrl = this.f77084e;
        if (qQGAudioCtrl != null) {
            i16 = qQGAudioCtrl.registerAudioDataCallback(i3, z16);
            i17 = this.f77084e.setAudioDataFormat(i3, 16000, 1, 16);
        } else if (this.f77083d != null) {
            i16 = NtrtcAudio.getInstance().registerAudioDataCallback(i3, z16);
            i17 = NtrtcAudio.getInstance().setAudioDataFormat(i3, 16000, 1, 16);
        } else {
            i16 = -1;
            i17 = -1;
        }
        if (i16 == 0 && i17 == 0) {
            return true;
        }
        com.tencent.qav.log.a.b("AudioDump", "registerAudioDataCallback failed. srcType = " + i3 + ", ret1 = " + i16 + ", ret2 = " + i17);
        return false;
    }

    private static void i(byte[] bArr, int i3, String str) {
        if (i3 <= 0) {
            return;
        }
        DataOutputStream dataOutputStream = null;
        try {
            try {
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(str));
                    try {
                        dataOutputStream2.write(bArr, 0, i3);
                        com.tencent.qav.log.a.d("AudioDump", "saveData successfully.");
                        dataOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        dataOutputStream = dataOutputStream2;
                        com.tencent.qav.log.a.c("AudioDump", "saveData failed. ", e);
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException unused2) {
        }
    }

    private boolean m(int i3) {
        QQGAudioCtrl qQGAudioCtrl = this.f77084e;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.unregisterAudioDataCallback(i3);
            return true;
        }
        if (this.f77083d != null) {
            NtrtcAudio.getInstance().unregisterAudioDataCallback(i3);
            return true;
        }
        return true;
    }

    public boolean g() {
        if (this.f77086h != 0) {
            return true;
        }
        return false;
    }

    public boolean j(VcControllerImpl vcControllerImpl, QQGAudioCtrl qQGAudioCtrl) {
        if (!this.f77085f) {
            com.tencent.qav.log.a.b("AudioDump", "startSave failed. !mIsInited.");
            return false;
        }
        if (g()) {
            return true;
        }
        this.f77083d = vcControllerImpl;
        this.f77084e = qQGAudioCtrl;
        if (e(35)) {
            b(true);
            h(0, false);
            h(2, false);
        } else if (e(36)) {
            b(true);
        } else if (e(37)) {
            h(0, false);
        } else {
            if (!e(38)) {
                return false;
            }
            h(2, false);
        }
        synchronized (this.G) {
            this.f77087i = new byte[52428800];
            this.f77088m = new byte[52428800];
            this.C = 0;
            this.D = 0;
            Calendar calendar = Calendar.getInstance();
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            int i17 = calendar.get(5);
            int i18 = calendar.get(11);
            int i19 = calendar.get(12);
            int i26 = calendar.get(13);
            String b16 = com.tencent.av.b.b();
            File file = new File(b16);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.E = b16 + String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), "after3A", 16000, 1);
            this.F = b16 + String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), "afterVAD", 16000, 1);
        }
        this.f77086h = 1;
        com.tencent.qav.log.a.d("AudioDump", "startSave successfully. ");
        return true;
    }

    public void k() {
        if (!this.f77085f || !g()) {
            return;
        }
        this.f77086h = 0;
        synchronized (this.G) {
            i(this.f77087i, this.C, this.E);
            i(this.f77088m, this.D, this.F);
            this.f77087i = null;
            this.f77088m = null;
            this.C = 0;
            this.D = 0;
        }
        try {
            b(false);
            m(0);
            m(2);
            com.tencent.qav.log.a.d("AudioDump", "stopSave sucessfully.");
        } catch (Exception e16) {
            com.tencent.qav.log.a.c("AudioDump", "stopSave failed.", e16);
        }
    }

    public void l() {
        if (!this.f77085f) {
            return;
        }
        k();
        this.f77083d = null;
        this.f77084e = null;
        this.f77085f = false;
        com.tencent.qav.log.a.d("AudioDump", "uninit successfully.");
    }

    @Override // com.tencent.av.ui.funchat.record.i
    public void onReceiveAudioFrame(byte[] bArr, int i3, int i16) {
        byte[] bArr2;
        if (this.f77085f && this.f77086h == 1) {
            synchronized (this.G) {
                try {
                    if (i3 == 0) {
                        byte[] bArr3 = this.f77087i;
                        if (bArr3 != null) {
                            System.arraycopy(bArr, 0, bArr3, this.C, i16);
                            this.C += i16;
                        }
                    } else if (i3 == 2 && (bArr2 = this.f77088m) != null) {
                        System.arraycopy(bArr, 0, bArr2, this.D, i16);
                        this.D += i16;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
        }
    }
}
