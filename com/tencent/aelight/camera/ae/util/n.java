package com.tencent.aelight.camera.ae.util;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: x, reason: collision with root package name */
    public static n f65795x;

    /* renamed from: a, reason: collision with root package name */
    public int f65796a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f65797b = 1;

    /* renamed from: c, reason: collision with root package name */
    public float f65798c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public int f65799d = 1;

    /* renamed from: e, reason: collision with root package name */
    public int f65800e = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f65801f = 1;

    /* renamed from: g, reason: collision with root package name */
    public int f65802g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f65803h = 1;

    /* renamed from: i, reason: collision with root package name */
    public int f65804i = 6000;

    /* renamed from: j, reason: collision with root package name */
    public int f65805j = 1;

    /* renamed from: k, reason: collision with root package name */
    public int f65806k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f65807l = 3;

    /* renamed from: m, reason: collision with root package name */
    public int f65808m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f65809n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f65810o = 1;

    /* renamed from: p, reason: collision with root package name */
    public int f65811p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f65812q = 1;

    /* renamed from: r, reason: collision with root package name */
    public int f65813r = 1;

    /* renamed from: s, reason: collision with root package name */
    public int f65814s = 1;

    /* renamed from: t, reason: collision with root package name */
    public int f65815t = 1;

    /* renamed from: u, reason: collision with root package name */
    public int f65816u = 1;

    /* renamed from: v, reason: collision with root package name */
    public int f65817v = -1;

    /* renamed from: w, reason: collision with root package name */
    public int f65818w = -1;

    public static int a() {
        n g16 = g();
        if (g16 != null) {
            return g16.f65807l;
        }
        return 3;
    }

    public static float b() {
        n g16 = g();
        if (g16 != null) {
            return g16.f65798c;
        }
        return 1.0f;
    }

    public static int c() {
        n g16 = g();
        if (g16 != null) {
            return g16.f65817v;
        }
        return -1;
    }

    public static int d() {
        n g16 = g();
        if (g16 != null) {
            return g16.f65818w;
        }
        return -1;
    }

    public static int e() {
        n g16 = g();
        if (g16 != null) {
            return g16.f65804i;
        }
        return 6000;
    }

    public static int f() {
        n g16 = g();
        if (g16 == null) {
            return 1;
        }
        int i3 = g16.f65816u;
        if (i3 == 1) {
            if (!com.tencent.mobileqq.shortvideo.util.c.a()) {
                return 1;
            }
            i3 = 2;
        }
        return i3;
    }

    public static n g() {
        if (f65795x == null) {
            f65795x = x();
        }
        return f65795x;
    }

    public static int h() {
        n g16 = g();
        if (g16 != null) {
            return g16.f65802g;
        }
        return -1;
    }

    public static boolean i() {
        n g16 = g();
        if (g16 != null && g16.f65810o == 1) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        n g16 = g();
        if (g16 != null && g16.f65806k == 1) {
            return true;
        }
        return false;
    }

    public static boolean k() {
        n g16 = g();
        if (g16 != null && g16.f65797b == 1) {
            return true;
        }
        return false;
    }

    public static boolean l() {
        n g16 = g();
        if (g16 != null && g16.f65803h == 1) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        n g16 = g();
        if (g16 != null && g16.f65809n == 1) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        n g16 = g();
        if (g16 != null && g16.f65801f == 1) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        n g16 = g();
        if (g16 != null && g16.f65805j == 1) {
            return true;
        }
        return false;
    }

    public static boolean p() {
        n g16 = g();
        if (g16 == null || g16.f65815t == 1) {
            return true;
        }
        return false;
    }

    public static boolean q() {
        n g16 = g();
        if (g16 != null && g16.f65800e == 1) {
            return true;
        }
        return false;
    }

    public static boolean r() {
        n g16 = g();
        if (g16 != null && g16.f65808m == 1) {
            return true;
        }
        return false;
    }

    public static boolean s() {
        if (!com.tencent.aelight.camera.ae.p.b()) {
            return false;
        }
        n g16 = g();
        if (g16 != null && g16.f65814s == 0) {
            return false;
        }
        return true;
    }

    public static boolean t() {
        n g16 = g();
        if (g16 != null && g16.f65812q == 1) {
            return true;
        }
        return false;
    }

    public static boolean u() {
        n g16 = g();
        if (g16 != null && g16.f65799d == 1) {
            return true;
        }
        return false;
    }

    public static boolean v() {
        n g16 = g();
        if (g16 != null && g16.f65796a == 1) {
            return true;
        }
        return false;
    }

    public static boolean w() {
        n g16 = g();
        if (g16 != null && g16.f65813r == 1) {
            return true;
        }
        return false;
    }

    public static n x() {
        String[] split;
        if (QLog.isColorLevel()) {
            QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
        }
        n nVar = new n();
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SVideoCfg.name());
        if (QLog.isColorLevel()) {
            QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + featureValue);
        }
        if (TextUtils.isEmpty(featureValue)) {
            return nVar;
        }
        try {
            split = featureValue.split("\\|");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MediaCodecDPC", 2, "loadMediaCodecDPC exception:", e16);
            }
        }
        if (split == null) {
            return nVar;
        }
        if (split.length >= 1) {
            nVar.f65796a = Integer.valueOf(split[0]).intValue();
        }
        if (split.length >= 2) {
            nVar.f65797b = Integer.valueOf(split[1]).intValue();
        }
        if (split.length >= 4) {
            float floatValue = Float.valueOf(split[2]).floatValue();
            nVar.f65799d = Integer.valueOf(split[3]).intValue();
            if (floatValue <= 1.0d && floatValue > 0.0f) {
                nVar.f65798c = floatValue;
            } else {
                QLog.e("MediaCodecDPC", 1, "MediaCodecDPC:  beautyRate: ", Float.valueOf(floatValue));
            }
        }
        if (split.length >= 5) {
            nVar.f65800e = Integer.valueOf(split[4]).intValue();
        }
        if (split.length >= 6) {
            nVar.f65801f = Integer.valueOf(split[5]).intValue();
        }
        if (split.length >= 7) {
            nVar.f65802g = Integer.valueOf(split[6]).intValue();
        }
        if (split.length >= 8) {
            nVar.f65803h = Integer.valueOf(split[7]).intValue();
        }
        if (split.length >= 9) {
            nVar.f65804i = Integer.valueOf(split[8]).intValue();
        }
        if (split.length >= 10) {
            nVar.f65805j = Integer.valueOf(split[9]).intValue();
        }
        if (split.length >= 12) {
            nVar.f65806k = Integer.valueOf(split[10]).intValue();
            nVar.f65807l = Integer.valueOf(split[11]).intValue();
        }
        if (split.length >= 13) {
            nVar.f65808m = Integer.valueOf(split[12]).intValue();
        }
        if (split.length >= 14) {
            nVar.f65809n = Integer.valueOf(split[13]).intValue();
        }
        if (split.length >= 15) {
            nVar.f65810o = Integer.valueOf(split[14]).intValue();
        }
        if (split.length >= 16) {
            nVar.f65811p = Integer.valueOf(split[15]).intValue();
        }
        if (split.length >= 17) {
            nVar.f65812q = Integer.valueOf(split[16]).intValue();
        }
        if (split.length >= 18) {
            nVar.f65813r = Integer.valueOf(split[17]).intValue();
        }
        if (split.length >= 19) {
            nVar.f65814s = Integer.valueOf(split[18]).intValue();
        }
        if (split.length >= 21) {
            nVar.f65815t = Integer.valueOf(split[19]).intValue();
            nVar.f65816u = Integer.valueOf(split[20]).intValue();
        }
        if (split.length >= 23) {
            nVar.f65817v = Integer.valueOf(split[21]).intValue();
            nVar.f65818w = Integer.valueOf(split[22]).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + nVar.toString());
        }
        return nVar;
    }

    public String toString() {
        return "mediaCodecSwitch: " + this.f65796a + " beautySwitch: " + this.f65797b + " beautyRate: " + this.f65798c + " svafSwitch: " + this.f65799d + " gestureDPCSwitch: " + this.f65800e + " deNoiseDPCSwitch: " + this.f65801f + " qmcfDPCFrameType: " + this.f65802g + " cqBitrateModeSwitch: " + this.f65803h + " cqMaxBitrate: " + this.f65804i + " faceDanceDPCSwitch: " + this.f65805j + " portraitDPCSwitch: " + this.f65808m + " danceRankingSwitch: " + this.f65809n + " arParticleDPCSwitch: " + this.f65810o + " rijiCameraDPCSwitch: " + this.f65811p + " segmentMediaCodecEncodeSwitch: " + this.f65812q + " transitionSwitch: " + this.f65813r + " rijiCamera720PSwitch: " + this.f65814s + " followCaptureSwitch: " + this.f65815t + " followCaptureGopSize: " + this.f65816u + " mLimittedSdkVersion: " + this.f65817v + " camera2Switch: " + this.f65818w;
    }
}
