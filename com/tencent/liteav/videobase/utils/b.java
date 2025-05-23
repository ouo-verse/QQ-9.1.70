package com.tencent.liteav.videobase.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f119371a;

    /* renamed from: b, reason: collision with root package name */
    public int f119372b;

    /* renamed from: c, reason: collision with root package name */
    public String f119373c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f119374d;

    /* renamed from: e, reason: collision with root package name */
    private a f119375e;

    /* renamed from: f, reason: collision with root package name */
    private MediaFormat f119376f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f119377g;

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videobase.utils.b$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119378a;

        static {
            int[] iArr = new int[a.values().length];
            f119378a = iArr;
            try {
                iArr[a.kQcom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119378a[a.kHisi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119378a[a.kExynos.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119378a[a.kAmlogic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        kUnKnown,
        kQcom,
        kHisi,
        kExynos,
        kAmlogic
    }

    public b() {
        a aVar = a.kUnKnown;
        this.f119375e = aVar;
        a b16 = b();
        if (b16 == aVar) {
            String lowerCase = LiteavSystemInfo.getHardware().toLowerCase();
            if (lowerCase.contains("qcom")) {
                aVar = a.kQcom;
            } else if (lowerCase.contains("kirin")) {
                aVar = a.kHisi;
            } else if (lowerCase.contains("exynos")) {
                aVar = a.kExynos;
            }
            b16 = aVar;
        }
        this.f119375e = b16;
        LiteavLog.i("HardwareDecoderMediaFormatBuilder", "hardware name:" + LiteavSystemInfo.getHardware().toLowerCase() + " chip brand:" + this.f119375e);
    }

    private static a b() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return a.kUnKnown;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                String lowerCase = mediaCodecInfo.getName().toLowerCase();
                if (lowerCase.contains("hisi")) {
                    return a.kHisi;
                }
                if (lowerCase.contains("amlogic")) {
                    return a.kAmlogic;
                }
                if (!lowerCase.contains("qcom") && !lowerCase.contains("qti")) {
                }
                return a.kQcom;
            }
        } catch (Throwable th5) {
            LiteavLog.e("HardwareDecoderMediaFormatBuilder", "get mediacode info error:" + th5.getMessage());
        }
        return a.kUnKnown;
    }

    public final MediaFormat a() {
        MediaFormat mediaFormat = this.f119376f;
        if (mediaFormat == null) {
            mediaFormat = MediaFormat.createVideoFormat(this.f119373c, this.f119371a, this.f119372b);
        }
        if (this.f119374d) {
            int systemOSVersionInt = LiteavSystemInfo.getSystemOSVersionInt();
            if (systemOSVersionInt >= 30 && this.f119375e != a.kHisi) {
                mediaFormat.setInteger("low-latency", 1);
            }
            if (systemOSVersionInt > 23 || !LiteavSystemInfo.getManufacturer().toLowerCase().contains("xiaomi")) {
                mediaFormat.setInteger("vdec-lowlatency", 1);
            }
            if (systemOSVersionInt >= 26) {
                int i3 = AnonymousClass1.f119378a[this.f119375e.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                mediaFormat.setInteger("vendor.low-latency.enable", 1);
                            }
                        } else {
                            mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
                        }
                    } else {
                        mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                        mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
                    }
                } else {
                    mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
                    mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
                }
            }
        }
        JSONArray jSONArray = this.f119377g;
        if (jSONArray != null) {
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i16);
                    mediaFormat.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                } catch (JSONException e16) {
                    LiteavLog.e("HardwareDecoderMediaFormatBuilder", "set MediaCodec device related params failed.", e16);
                }
            }
        }
        return mediaFormat;
    }
}
