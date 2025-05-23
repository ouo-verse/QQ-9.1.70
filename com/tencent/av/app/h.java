package com.tencent.av.app;

import androidx.annotation.RequiresApi;
import com.tencent.av.mediacodec.api.IAndroidCodecHelperApi;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.codec.AndroidCodecUtil;
import com.tencent.avcore.util.GlStringParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {

        /* compiled from: P */
        /* renamed from: com.tencent.av.app.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0733a {

            /* renamed from: a, reason: collision with root package name */
            public int f73159a;

            /* renamed from: b, reason: collision with root package name */
            public String f73160b;

            /* renamed from: c, reason: collision with root package name */
            public String f73161c;

            /* renamed from: d, reason: collision with root package name */
            public String f73162d;

            /* renamed from: e, reason: collision with root package name */
            public int f73163e;

            /* renamed from: f, reason: collision with root package name */
            public int f73164f;

            /* renamed from: g, reason: collision with root package name */
            public String f73165g;

            public String a() {
                GlStringParser glStringParser = new GlStringParser('=', ';');
                glStringParser.set("s_path", this.f73161c);
                if (c()) {
                    glStringParser.set("i_fps", this.f73163e);
                    glStringParser.set("i_bitrate", this.f73164f);
                    glStringParser.set("s_outpath", this.f73165g);
                    File file = new File(this.f73165g);
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    glStringParser.set("s_expMd5", this.f73162d);
                }
                return glStringParser.flatten();
            }

            public int b() {
                int i3 = this.f73159a;
                if (i3 == 1) {
                    return 2;
                }
                if (i3 == 4) {
                    return 1;
                }
                if (i3 == 2) {
                    return 4;
                }
                if (i3 == 8) {
                    return 3;
                }
                return 0;
            }

            public boolean c() {
                int i3 = this.f73159a;
                if (i3 != 2 && i3 != 8) {
                    return false;
                }
                return true;
            }
        }

        void a(int i3, String str, int i16, int i17, String str2);
    }

    @RequiresApi(api = 16)
    public static void a(long j3, a.C0733a c0733a, a aVar) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = c0733a.a();
        byte[] W1 = com.tencent.av.r.h0().W1(j3, c0733a.b(), a16.getBytes());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (W1 == null) {
            str = "";
        } else {
            str = new String(W1);
        }
        QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + c0733a.f73159a + "], sampleMD5[" + c0733a.f73160b + "], cmdParams[" + a16 + "], result[" + str + "], cost[" + currentTimeMillis2 + "], seq[" + j3 + "]");
        AndroidCodecUtil.hardwareCodecLevelInfo();
        QLog.w("DeviceCapability", 1, "doCodecTest get_info_test numCores: " + AVCoreSystemInfo.getNumCores() + ", cpu frep: " + AVCoreSystemInfo.getMaxCpuFreq() + ", memory: " + AVCoreSystemInfo.getMemoryTotal() + ", output format: " + ((IAndroidCodecHelperApi) QRoute.api(IAndroidCodecHelperApi.class)).getHwDetectOutputFormatForReport() + ", H264EncBaseLineLevel: " + AndroidCodecUtil.mH264EncBaseLineLevel + ", H264DecBaseLineLevel: " + AndroidCodecUtil.mH264DecBaseLineLevel + ", H264EncHighProfileLevel: " + AndroidCodecUtil.mH264EncHighProfileLevel + ", H264DecHighProfileLevel: " + AndroidCodecUtil.mH264DecHighProfileLevel + ", H265EncLevel: " + AndroidCodecUtil.mH265EncLevel + ", H265DecLevel: " + AndroidCodecUtil.mH265DecLevel);
        GlStringParser glStringParser = new GlStringParser('=', ';');
        glStringParser.unflatten(str);
        aVar.a(glStringParser.getInt("i_resultCode", -99), "", 0, glStringParser.getInt("i_delay", -99), null);
    }
}
