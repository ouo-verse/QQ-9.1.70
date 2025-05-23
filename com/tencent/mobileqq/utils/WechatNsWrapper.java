package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class WechatNsWrapper extends com.tencent.mobileqq.qqaudio.audioprocessor.a {
    public static boolean J = false;
    private int F;
    long G;
    short[] H;
    private boolean I;

    public WechatNsWrapper(Context context) {
        super(context);
        this.F = 0;
        this.I = false;
        g();
    }

    private void g() {
        if (!J) {
            try {
                boolean loadNativeLibrary = com.tencent.mobileqq.inject.a.f238063a.loadNativeLibrary(this.f262200d, "stlport_shared", 0, false);
                if (QLog.isColorLevel()) {
                    QLog.d("WechatNsWrapper", 2, "load stlport_shared " + loadNativeLibrary);
                }
                boolean loadSoByName = SoLoadUtilNew.loadSoByName(this.f262200d, "voicemessagedenoise");
                if (QLog.isColorLevel()) {
                    QLog.d("WechatNsWrapper", 2, "load voicemessagedenoise " + loadSoByName);
                }
                boolean loadSoByName2 = SoLoadUtilNew.loadSoByName(this.f262200d, "wechatns");
                if (QLog.isColorLevel()) {
                    QLog.d("WechatNsWrapper", 2, "load wechatns " + loadSoByName2);
                }
                J = true;
            } catch (Throwable th5) {
                th5.printStackTrace();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                hashMap.put("throwable", th5.getMessage());
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.WECHAT_NS_LOAD_FAIL, false, 0L, 0L, hashMap, "");
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void b(int i3, int i16, int i17) throws IOException {
        boolean z16;
        super.b(i3, i16, i17);
        if (this.G == 0) {
            try {
                this.G = nsNew();
                if (QLog.isColorLevel()) {
                    QLog.d("WechatNsWrapper", 2, "silkEncoderNew =" + this.G);
                }
                int nsInit = nsInit(this.G, i3);
                if (nsInit == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.I = z16;
                long j3 = this.G;
                if (j3 != 0 && z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WechatNsWrapper", 2, "silkEncoderInit =" + nsInit);
                    }
                }
                QLog.d("WechatNsWrapper", 1, "init codec=", Long.valueOf(j3), ", ret=", Integer.valueOf(nsInit), ", sampleRate=", Integer.valueOf(i3), ", perFrameSize=", Integer.valueOf(this.E));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WechatNsWrapper", 2, "init silk codec =" + e16.toString());
                }
                this.G = 0L;
                J = false;
            }
        }
        int c16 = QQAudioUtils.c(i3);
        this.E = c16;
        this.H = new short[c16 / 2];
        this.f262203h = new byte[c16];
        this.f262204i = new byte[c16];
        int i18 = 960;
        if (c16 * 2 > 960) {
            i18 = c16 * 2;
        }
        byte[] bArr = new byte[i18];
        this.f262205m = bArr;
        this.C = new c.a(bArr, 0);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        h();
    }

    public void e(byte[] bArr, short[] sArr) {
        ByteBuffer.wrap(bArr, 0, bArr.length).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr, 0, bArr.length / 2);
    }

    public void h() {
        long j3 = this.G;
        if (j3 != 0) {
            int nsDelete = nsDelete(j3);
            if (QLog.isColorLevel()) {
                QLog.d("WechatNsWrapper", 2, "deleteCodec =" + nsDelete);
            }
        }
        this.G = 0L;
    }

    public void i(short[] sArr, byte[] bArr) {
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
    }

    public native int nsDelete(long j3);

    public native int nsInit(long j3, int i3);

    public native long nsNew();

    public native int nsProcess(long j3, short[] sArr, int i3);

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (this.G != 0 && this.I) {
            if (this.f262202f.read(this.f262203h, 0, this.E) == -1) {
                return -1;
            }
            e(this.f262203h, this.H);
            nsProcess(this.G, this.H, this.f262203h.length);
            i(this.H, this.f262203h);
            System.arraycopy(this.f262203h, 0, bArr, i3, this.E);
            return this.E;
        }
        if (this.f262202f.read(this.f262203h, 0, this.E) == -1) {
            return -1;
        }
        System.arraycopy(this.f262203h, 0, bArr, i3, this.E);
        return this.E;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void release() throws IOException {
        super.release();
        h();
    }

    public WechatNsWrapper() {
        super(BaseApplication.getContext());
        this.F = 0;
        this.I = false;
        g();
    }
}
