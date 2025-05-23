package com.tencent.mobileqq.shortvideo;

import android.app.ActivityManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f287758a;

        /* renamed from: b, reason: collision with root package name */
        public int f287759b;

        /* renamed from: c, reason: collision with root package name */
        public long f287760c;

        /* renamed from: d, reason: collision with root package name */
        public long f287761d;

        /* renamed from: e, reason: collision with root package name */
        public float f287762e;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f287763a = 1280;

        /* renamed from: b, reason: collision with root package name */
        int f287764b = 30;

        /* renamed from: c, reason: collision with root package name */
        double f287765c = 0.15d;

        /* renamed from: d, reason: collision with root package name */
        double f287766d = 0.067d;

        /* renamed from: e, reason: collision with root package name */
        long f287767e = ShortVideoConstants.MAX_SIZE_DEFAULT;

        /* renamed from: f, reason: collision with root package name */
        long f287768f = 1048576;

        /* renamed from: g, reason: collision with root package name */
        long f287769g = 4194304;

        /* renamed from: h, reason: collision with root package name */
        public final a f287770h = new a();

        /* compiled from: P */
        /* loaded from: classes18.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f287771a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f287772b = 0;

            /* renamed from: c, reason: collision with root package name */
            public long f287773c = 314572800;

            /* renamed from: d, reason: collision with root package name */
            int f287774d = 0;

            /* renamed from: e, reason: collision with root package name */
            String f287775e = null;

            public boolean a() {
                int i3 = this.f287771a;
                if (i3 != 0 && this.f287772b != 0) {
                    int i16 = Build.VERSION.SDK_INT;
                    if (i16 < i3) {
                        if (QLog.isColorLevel()) {
                            QLog.i("VideoCompressConfig", 1, "isSoftwareFirst, api level " + i16 + " less than " + this.f287771a);
                        }
                        return false;
                    }
                    try {
                        ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        if (memoryInfo.totalMem < this.f287772b * 1073741824) {
                            if (QLog.isColorLevel()) {
                                QLog.i("VideoCompressConfig", 1, "isSoftwareFirst, device memory " + memoryInfo.totalMem + " less than " + this.f287772b + "GB");
                            }
                            return false;
                        }
                        if (memoryInfo.availMem >= this.f287773c) {
                            return true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("VideoCompressConfig", 1, "isSoftwareFirst, free memory " + memoryInfo.availMem + " less than 314572800");
                        }
                        return false;
                    } catch (Exception e16) {
                        QLog.w("VideoCompressConfig", 1, "isSoftwareFirst, exception=" + e16);
                        return false;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("VideoCompressConfig", 1, "isSoftwareFirst, switch disabled");
                }
                return false;
            }

            @NonNull
            public String toString() {
                return "{" + getClass().getSimpleName() + ":apiLevel=" + this.f287771a + ",memory=" + this.f287772b + ",crf=" + this.f287774d + ",preset=" + this.f287775e;
            }
        }

        public int a() {
            return this.f287763a;
        }

        @NonNull
        public String toString() {
            return "{" + getClass().getSimpleName() + ":maxLength=" + this.f287763a + ",maxFPS=" + this.f287764b + ",maxDensity=" + this.f287765c + ",minDensity=" + this.f287766d + ",maxSize=" + this.f287767e + ",minBitRate=" + this.f287768f + ",maxBitRate=" + this.f287769g + ",softwareConfig=" + this.f287770h + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f287776a;

        /* renamed from: b, reason: collision with root package name */
        public int f287777b;

        /* renamed from: c, reason: collision with root package name */
        public int f287778c;

        /* renamed from: d, reason: collision with root package name */
        public int f287779d;

        /* renamed from: e, reason: collision with root package name */
        public int f287780e;

        /* renamed from: f, reason: collision with root package name */
        public int f287781f;

        /* renamed from: g, reason: collision with root package name */
        public long f287782g;
    }

    public static a a(c cVar, b bVar, boolean z16) {
        int i3;
        a aVar = new a();
        int i16 = cVar.f287781f;
        if (i16 <= 0) {
            i16 = 30;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i16);
        }
        if (z16) {
            aVar.f287762e = 1.0f;
            aVar.f287758a = cVar.f287777b;
            aVar.f287759b = cVar.f287778c;
            aVar.f287761d = i16;
            long j3 = cVar.f287776a;
            if (j3 > 0 && j3 * 8 < bVar.f287767e) {
                aVar.f287760c = cVar.f287782g;
            } else {
                aVar.f287760c = (int) (bVar.f287767e / cVar.f287780e);
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + aVar.f287760c);
            }
        } else {
            int i17 = cVar.f287777b;
            int i18 = cVar.f287778c;
            if (i17 <= i18) {
                i3 = i18;
            } else {
                i3 = i17;
            }
            int i19 = bVar.f287763a;
            if (i3 > i19) {
                float f16 = i19 / i3;
                aVar.f287762e = f16;
                aVar.f287758a = (int) (i17 * f16);
                aVar.f287759b = (int) (i18 * f16);
            } else {
                aVar.f287762e = 1.0f;
                aVar.f287758a = i17;
                aVar.f287759b = i18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + aVar.f287762e + ", compressInfo.desWidth = " + aVar.f287758a + ", compressInfo.desHeight = " + aVar.f287759b);
            }
            int i26 = cVar.f287781f;
            if (i26 > 0 && i26 < bVar.f287764b) {
                aVar.f287761d = i26;
            } else {
                aVar.f287761d = bVar.f287764b;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + aVar.f287761d);
            }
            double d16 = aVar.f287758a * aVar.f287759b * aVar.f287761d * bVar.f287765c;
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d16);
            }
            long j16 = cVar.f287782g;
            if (d16 > j16) {
                d16 = j16;
            }
            long j17 = bVar.f287769g;
            if (d16 > j17) {
                d16 = j17;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d16);
            }
            double d17 = cVar.f287780e * d16;
            long j18 = bVar.f287767e;
            if (d17 > j18) {
                double d18 = j18 / (((aVar.f287758a * aVar.f287759b) * aVar.f287761d) * r11);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d18);
                }
                double d19 = bVar.f287766d;
                if (d18 < d19) {
                    d18 = d19;
                }
                aVar.f287760c = (int) (aVar.f287758a * aVar.f287759b * aVar.f287761d * d18);
            } else {
                aVar.f287760c = (int) d16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + aVar.f287760c);
            }
        }
        return aVar;
    }

    public static b b(AppRuntime appRuntime) {
        b bVar = new b();
        if (appRuntime == null) {
            QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
            return bVar;
        }
        e(appRuntime, bVar);
        return bVar;
    }

    public static c c(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("VideoCompressConfig", 1, "getVideoInfo, videoPath is empty.");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("VideoCompressConfig", 1, "getVideoInfo, file not exists.");
            return null;
        }
        c cVar = new c();
        cVar.f287776a = file.length();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
                String extractMetadata5 = mediaMetadataRetriever.extractMetadata(32);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCompressConfig", 2, "getVideoInfo by MediaMetadataRetriever, width = " + extractMetadata + ", height = " + extractMetadata2 + ", rotation = " + extractMetadata3 + ", duration = " + extractMetadata4 + ", frameCount = " + extractMetadata5);
                }
                cVar.f287777b = Integer.valueOf(extractMetadata).intValue();
                cVar.f287778c = Integer.valueOf(extractMetadata2).intValue();
                cVar.f287779d = Integer.valueOf(extractMetadata3).intValue();
                cVar.f287780e = (int) ((Integer.valueOf(extractMetadata4).intValue() / 1000.0d) + 0.5d);
                cVar.f287781f = (int) (((Integer.valueOf(extractMetadata5).intValue() * 1.0d) / cVar.f287780e) + 0.5d);
            } catch (Exception e16) {
                QLog.e("VideoCompressConfig", 1, "getVideoProperty:", e16);
            }
            mediaMetadataRetriever.release();
            int i3 = cVar.f287780e;
            if (i3 > 0) {
                cVar.f287782g = (cVar.f287776a * 8) / i3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + cVar.f287776a + ", width = " + cVar.f287777b + ", height = " + cVar.f287778c + ", rotation = " + cVar.f287779d + ", duration = " + cVar.f287780e + ", fps = " + cVar.f287781f + ", videoInfo.bitRate = " + cVar.f287782g);
            }
            return cVar;
        } catch (Throwable th5) {
            mediaMetadataRetriever.release();
            throw th5;
        }
    }

    public static boolean d(c cVar, b bVar) {
        if (cVar != null && bVar != null) {
            if (cVar.f287776a * 8 > bVar.f287767e) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + cVar.f287776a);
                }
                return true;
            }
            long j3 = cVar.f287782g;
            if (j3 < bVar.f287768f) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + cVar.f287782g + ", minBitRate = " + bVar.f287768f);
                }
                return false;
            }
            if (j3 > bVar.f287769g) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + cVar.f287782g + ", maxBitRate = " + bVar.f287769g);
                }
                return true;
            }
            int i3 = cVar.f287781f;
            if (i3 <= 0) {
                i3 = 30;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i3);
            }
            if (cVar.f287782g > cVar.f287777b * cVar.f287778c * i3 * bVar.f287765c * 1.2d) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + cVar.f287782g + ", width * height * videoFps * maxDensity * 1.2 = " + (cVar.f287777b * cVar.f287778c * i3 * bVar.f287765c * 1.2d));
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + cVar.f287782g + ", width * height * videoFps * maxDensity * 1.2 = " + (cVar.f287777b * cVar.f287778c * i3 * bVar.f287765c * 1.2d));
            }
            return false;
        }
        QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
        return false;
    }

    private static void e(AppRuntime appRuntime, b bVar) {
        String a16 = zq2.a.INSTANCE.a(appRuntime.getApp(), appRuntime.getCurrentAccountUin());
        if (a16 != null && a16.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(a16);
                bVar.f287763a = jSONObject.optInt("maxLength", bVar.f287763a);
                bVar.f287764b = jSONObject.optInt("maxFPS", bVar.f287764b);
                bVar.f287765c = jSONObject.optDouble("density", bVar.f287765c);
                bVar.f287766d = jSONObject.optDouble("minDensity", bVar.f287766d);
                if (jSONObject.has("compressLargeMaxSize")) {
                    bVar.f287767e = Long.parseLong(jSONObject.getString("compressLargeMaxSize")) * 1024 * 1024 * 8;
                }
                bVar.f287769g = jSONObject.optLong("maxBitRate", bVar.f287769g);
                bVar.f287768f = jSONObject.optLong("minBitRate", bVar.f287768f);
                if (jSONObject.has("softwareCompress")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("softwareCompress");
                    bVar.f287770h.f287771a = jSONObject2.optInt("apiLevel", 0);
                    bVar.f287770h.f287772b = jSONObject2.optInt("deviceMemory", 0);
                    bVar.f287770h.f287774d = jSONObject2.optInt("crf", 0);
                    bVar.f287770h.f287775e = jSONObject2.optString("preset", "");
                    return;
                }
                return;
            } catch (NumberFormatException | JSONException e16) {
                QLog.e("VideoCompressConfig", 2, "loadConfigs, exception is", e16);
                return;
            }
        }
        QLog.i("VideoCompressConfig", 1, "loadConfigs, config is empty");
    }
}
