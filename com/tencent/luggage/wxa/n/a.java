package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.nf.f;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f134890a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f134891b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f134892c = {RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f134893d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f134894e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, MsgConstant.KRMFILETHUMBSIZE384, TroopInfo.PAY_PRIVILEGE_ALL, 512, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT, 640};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f134895f = {69, 87, 104, 121, 139, 174, 208, 243, 278, f.b.CTRL_INDEX, 417, 487, PlayerResources.ViewId.PLAYER_DURATION, 696, 835, 975, 1114, UfsGROUPMASK.GROUP_MASK_PRECISE_FEATURE, 1393};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f134896a;

        /* renamed from: b, reason: collision with root package name */
        public final int f134897b;

        /* renamed from: c, reason: collision with root package name */
        public final int f134898c;

        /* renamed from: d, reason: collision with root package name */
        public final int f134899d;

        /* renamed from: e, reason: collision with root package name */
        public final int f134900e;

        public b(String str, int i3, int i16, int i17, int i18) {
            this.f134896a = str;
            this.f134898c = i3;
            this.f134897b = i16;
            this.f134899d = i17;
            this.f134900e = i18;
        }
    }

    public static int a() {
        return 1536;
    }

    public static com.tencent.luggage.wxa.m.j b(com.tencent.luggage.wxa.n0.l lVar, String str, String str2, com.tencent.luggage.wxa.p.a aVar) {
        lVar.f(2);
        int i3 = f134891b[(lVar.q() & 192) >> 6];
        int q16 = lVar.q();
        int i16 = f134893d[(q16 & 14) >> 1];
        if ((q16 & 1) != 0) {
            i16++;
        }
        return com.tencent.luggage.wxa.m.j.a(str, "audio/eac3", null, -1, -1, i16, i3, null, aVar, 0, str2);
    }

    public static com.tencent.luggage.wxa.m.j a(com.tencent.luggage.wxa.n0.l lVar, String str, String str2, com.tencent.luggage.wxa.p.a aVar) {
        int i3 = f134891b[(lVar.q() & 192) >> 6];
        int q16 = lVar.q();
        int i16 = f134893d[(q16 & 56) >> 3];
        if ((q16 & 4) != 0) {
            i16++;
        }
        return com.tencent.luggage.wxa.m.j.a(str, "audio/ac3", null, -1, -1, i16, i3, null, aVar, 0, str2);
    }

    public static b a(com.tencent.luggage.wxa.n0.k kVar) {
        int a16;
        int i3;
        String str;
        int i16;
        int i17;
        int b16 = kVar.b();
        kVar.c(40);
        boolean z16 = kVar.a(5) == 16;
        kVar.b(b16);
        int i18 = 6;
        if (z16) {
            kVar.c(21);
            int a17 = (kVar.a(11) + 1) * 2;
            int a18 = kVar.a(2);
            if (a18 == 3) {
                i3 = f134892c[kVar.a(2)];
            } else {
                i18 = f134890a[kVar.a(2)];
                i3 = f134891b[a18];
            }
            a16 = kVar.a(3);
            str = "audio/eac3";
            i17 = i18 * 256;
            i16 = a17;
        } else {
            kVar.c(32);
            int a19 = kVar.a(2);
            int a26 = a(a19, kVar.a(6));
            kVar.c(8);
            a16 = kVar.a(3);
            if ((a16 & 1) != 0 && a16 != 1) {
                kVar.c(2);
            }
            if ((a16 & 4) != 0) {
                kVar.c(2);
            }
            if (a16 == 2) {
                kVar.c(2);
            }
            i3 = f134891b[a19];
            str = "audio/ac3";
            i16 = a26;
            i17 = 1536;
        }
        return new b(str, f134893d[a16] + (kVar.c() ? 1 : 0), i3, i16, i17);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        byte b16 = bArr[4];
        return a((b16 & 192) >> 6, b16 & 63);
    }

    public static int a(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f134890a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static int a(int i3, int i16) {
        int i17 = i16 / 2;
        if (i3 < 0) {
            return -1;
        }
        int[] iArr = f134891b;
        if (i3 >= iArr.length || i16 < 0) {
            return -1;
        }
        int[] iArr2 = f134895f;
        if (i17 >= iArr2.length) {
            return -1;
        }
        int i18 = iArr[i3];
        if (i18 == 44100) {
            return (iArr2[i17] + (i16 % 2)) * 2;
        }
        int i19 = f134894e[i17];
        return i18 == 32000 ? i19 * 6 : i19 * 4;
    }
}
