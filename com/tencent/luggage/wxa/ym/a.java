package com.tencent.luggage.wxa.ym;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.smtt.sdk.TbsListener;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f146021a = com.tencent.luggage.wxa.ym.b.f146040c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ym.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6962a {

        /* renamed from: a, reason: collision with root package name */
        public String f146022a;

        /* renamed from: b, reason: collision with root package name */
        public int f146023b;

        /* renamed from: c, reason: collision with root package name */
        public int f146024c;

        /* renamed from: d, reason: collision with root package name */
        public int f146025d;

        /* renamed from: e, reason: collision with root package name */
        public int f146026e;

        /* renamed from: f, reason: collision with root package name */
        public int f146027f;

        /* renamed from: g, reason: collision with root package name */
        public float f146028g;

        public C6962a(String str, int i3, int i16, int i17, int i18, int i19, float f16) {
            this.f146022a = str;
            this.f146023b = i3;
            this.f146024c = i16;
            this.f146025d = i17;
            this.f146026e = i18;
            this.f146027f = i19;
            this.f146028g = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f146029a;

        /* renamed from: b, reason: collision with root package name */
        public int f146030b;

        /* renamed from: c, reason: collision with root package name */
        public String f146031c;

        /* renamed from: d, reason: collision with root package name */
        public int f146032d;

        /* renamed from: e, reason: collision with root package name */
        public long f146033e;

        /* renamed from: f, reason: collision with root package name */
        public int f146034f;

        /* renamed from: g, reason: collision with root package name */
        public int f146035g;

        /* renamed from: h, reason: collision with root package name */
        public int f146036h;

        /* renamed from: i, reason: collision with root package name */
        public float f146037i;

        public b(String str, int i3, String str2, int i16, long j3, int i17, int i18, int i19, float f16) {
            this.f146029a = str;
            this.f146030b = i3;
            this.f146031c = str2;
            this.f146032d = i16;
            this.f146033e = j3;
            this.f146034f = i17;
            this.f146035g = i18;
            this.f146036h = i19;
            this.f146037i = f16;
        }
    }

    public static String a(C6962a c6962a) {
        int i3;
        if (c6962a == null) {
            w.b("WMPF.RemuxHelper", "remuxIfNeed, compress request is null");
            return null;
        }
        String str = c6962a.f146022a;
        if (a(str) != -50006) {
            w.d("WMPF.RemuxHelper", "STATUS_NO_NEED_TO_REMUX");
            return str;
        }
        w.d("WMPF.RemuxHelper", "compress info: filePath: %s, suggestWidth: %d, suggestHeight: %d, outputWidth: %d, outputHeight: %d, remuxBitRate %d", str, Integer.valueOf(c6962a.f146023b), Integer.valueOf(c6962a.f146024c), Integer.valueOf(c6962a.f146025d), Integer.valueOf(c6962a.f146026e), Integer.valueOf(c6962a.f146027f));
        int i16 = c6962a.f146025d;
        if (i16 != 0 && (i3 = c6962a.f146026e) != 0) {
            if (i16 % 2 != 0) {
                i16++;
            }
            if (i3 % 2 != 0) {
                i3++;
            }
        } else {
            int i17 = c6962a.f146023b;
            if (i17 <= 0) {
                i17 = 720;
            }
            int i18 = c6962a.f146024c;
            if (i18 <= 0) {
                i18 = 540;
            }
            b c16 = c(str);
            w.d("WMPF.RemuxHelper", "sourceWidth: %d, sourceHeight: %d", Integer.valueOf(c16 == null ? 0 : c16.f146034f), Integer.valueOf(c16 == null ? 0 : c16.f146035g));
            int[] iArr = new int[2];
            com.tencent.luggage.wxa.zm.a.a(str, iArr, i17, i18);
            i16 = iArr[0];
            i3 = iArr[1];
        }
        int i19 = i16;
        int i26 = i3;
        w.d("WMPF.RemuxHelper", "outputWidth: %d, outputHeight: %d", Integer.valueOf(i19), Integer.valueOf(i26));
        int i27 = c6962a.f146027f;
        if (i27 <= 0) {
            i27 = com.tencent.luggage.wxa.ym.b.f146040c;
        }
        int i28 = i27;
        float f16 = c6962a.f146028g;
        if (f16 <= 0.0f) {
            f16 = com.tencent.luggage.wxa.ym.b.f146041d;
        }
        float f17 = f16;
        if (!x.d(com.tencent.luggage.wxa.zm.a.a())) {
            x.m(com.tencent.luggage.wxa.zm.a.a());
        }
        String str2 = com.tencent.luggage.wxa.zm.a.a() + "wxa." + System.currentTimeMillis() + ".mp4";
        w.d("WMPF.RemuxHelper", "soft remux mode.");
        int a16 = SightVideoJNI.a(str, str2, i19, i26, i28, com.tencent.luggage.wxa.ym.b.f146039b, 8, 2, 25.0f, f17, null, 0, false, 0, 51);
        if (a16 < 0) {
            w.d("WMPF.RemuxHelper", "STATUS_SOFT_REMUX_FAIL");
        } else {
            w.d("WMPF.RemuxHelper", "STATUS_SOFT_REMUX_SECCESS");
        }
        w.d("WMPF.RemuxHelper", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(a16), Integer.valueOf(i19), Integer.valueOf(i26));
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r8 = r5.getInteger("frame-rate");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float b(String str) {
        int i3;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                int i16 = 0;
                while (true) {
                    if (i16 < trackCount) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i16);
                        if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                            break;
                        }
                        i16++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
            } catch (IOException e16) {
                w.a("WMPF.RemuxHelper", e16, "", new Object[0]);
                mediaExtractor.release();
                i3 = 0;
            }
            w.d("WMPF.RemuxHelper", "getVideoFrameRate fps: %d", Integer.valueOf(i3));
            return i3 * 1.0f;
        } finally {
            mediaExtractor.release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b c(String str) {
        com.tencent.luggage.wxa.ba.b bVar;
        com.tencent.luggage.wxa.ba.b bVar2 = null;
        try {
            bVar = new com.tencent.luggage.wxa.ba.b();
        } catch (Exception unused) {
            bVar = null;
        } catch (Throwable th5) {
            th = th5;
            bVar = bVar2;
            if (bVar != null) {
            }
            throw th;
        }
        try {
            bVar.setDataSource(str);
            int a16 = w0.a(bVar.extractMetadata(24), 0);
            String extractMetadata = bVar.extractMetadata(12);
            int a17 = w0.a(bVar.extractMetadata(9), 0);
            long e16 = x.e(str);
            int a18 = w0.a(bVar.extractMetadata(18), 0);
            int a19 = w0.a(bVar.extractMetadata(19), 0);
            int a26 = w0.a(bVar.extractMetadata(20), 0);
            float a27 = w0.a(bVar.extractMetadata(25), 0.0f);
            if (a27 == 0.0f) {
                w.d("WMPF.RemuxHelper", "fps is 0");
                a27 = b(str);
            }
            w.d("WMPF.RemuxHelper", "filepath: %s, rotation: %d, type: %s, duration: %d, size %d, width: %d, height: %d, bitrate: %d, fps: %f", str, Integer.valueOf(a16), extractMetadata, Integer.valueOf(a17), Long.valueOf(e16), Integer.valueOf(a18), Integer.valueOf(a19), Integer.valueOf(a26), Float.valueOf(a27));
            b bVar3 = new b(str, a16, extractMetadata, a17, e16, a18, a19, a26, a27);
            try {
                bVar.release();
            } catch (IOException unused2) {
            }
            return bVar3;
        } catch (Exception unused3) {
            try {
                w.f("WMPF.RemuxHelper", "getVideoInfo error");
                if (bVar != null) {
                    try {
                        bVar.release();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th6) {
                th = th6;
                bVar2 = bVar;
                bVar = bVar2;
                if (bVar != null) {
                    try {
                        bVar.release();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            if (bVar != null) {
            }
            throw th;
        }
    }

    public static String d(String str) {
        if (str == null) {
            w.b("WMPF.RemuxHelper", "remuxIfNeed, filePath is null");
            return null;
        }
        return a(new C6962a(str, 720, 540, 0, 0, com.tencent.luggage.wxa.ym.b.f146040c, com.tencent.luggage.wxa.ym.b.f146041d));
    }

    public static int a(String str) {
        int i3;
        boolean a16 = com.tencent.luggage.wxa.zm.a.a(str);
        w.d("WMPF.RemuxHelper", "checkRemux, isMp4 = %b", Boolean.valueOf(a16));
        if (a16) {
            i3 = SightVideoJNI.a(str, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, 500, QZoneAppCtrlUploadFileLogic.WARNING_SIZE_LEVLE, 1200000.0d, 1000000);
            w.d("WMPF.RemuxHelper", "checkRemux, ret = %d", Integer.valueOf(i3));
        } else {
            w.d("WMPF.RemuxHelper", "fileLength = %d", Integer.valueOf((int) x.e(str)));
            i3 = 1;
        }
        switch (i3) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return HiHealthStatusCodes.NO_SAVED_DEVICE_ERROR;
            case 0:
                return -50006;
            case 1:
                return 2;
            case 2:
            case 3:
            case 4:
            case 5:
                return 1;
            default:
                w.b("WMPF.RemuxHelper", "unknown check type");
                return HiHealthStatusCodes.EXISTED_RECORDER_ERROR;
        }
    }
}
