package com.tencent.luggage.wxa.q;

import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f137755h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f137756i = {44100, 48000, 32000};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f137757j = {32, 64, 96, 128, 160, 192, 224, 256, 288, 320, com.tencent.luggage.wxa.rf.g.CTRL_INDEX, MsgConstant.KRMFILETHUMBSIZE384, 416, TroopInfo.PAY_PRIVILEGE_ALL};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f137758k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f137759l = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, MsgConstant.KRMFILETHUMBSIZE384};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f137760m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f137761n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    /* renamed from: a, reason: collision with root package name */
    public int f137762a;

    /* renamed from: b, reason: collision with root package name */
    public String f137763b;

    /* renamed from: c, reason: collision with root package name */
    public int f137764c;

    /* renamed from: d, reason: collision with root package name */
    public int f137765d;

    /* renamed from: e, reason: collision with root package name */
    public int f137766e;

    /* renamed from: f, reason: collision with root package name */
    public int f137767f;

    /* renamed from: g, reason: collision with root package name */
    public int f137768g;

    public static int a(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if ((i3 & (-2097152)) != -2097152 || (i16 = (i3 >>> 19) & 3) == 1 || (i17 = (i3 >>> 17) & 3) == 0 || (i18 = (i3 >>> 12) & 15) == 0 || i18 == 15 || (i19 = (i3 >>> 10) & 3) == 3) {
            return -1;
        }
        int i27 = f137756i[i19];
        if (i16 == 2) {
            i27 /= 2;
        } else if (i16 == 0) {
            i27 /= 4;
        }
        int i28 = (i3 >>> 9) & 1;
        if (i17 == 3) {
            return ((((i16 == 3 ? f137757j[i18 - 1] : f137758k[i18 - 1]) * 12000) / i27) + i28) * 4;
        }
        if (i16 == 3) {
            i26 = i17 == 2 ? f137759l[i18 - 1] : f137760m[i18 - 1];
        } else {
            i26 = f137761n[i18 - 1];
        }
        int i29 = TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR;
        if (i16 == 3) {
            return ((i26 * TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR) / i27) + i28;
        }
        if (i17 == 1) {
            i29 = DefaultOggSeeker.MATCH_RANGE;
        }
        return ((i29 * i26) / i27) + i28;
    }

    public static boolean a(int i3, i iVar) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        if ((i3 & (-2097152)) != -2097152 || (i16 = (i3 >>> 19) & 3) == 1 || (i17 = (i3 >>> 17) & 3) == 0 || (i18 = (i3 >>> 12) & 15) == 0 || i18 == 15 || (i19 = (i3 >>> 10) & 3) == 3) {
            return false;
        }
        int i36 = f137756i[i19];
        if (i16 == 2) {
            i36 /= 2;
        } else if (i16 == 0) {
            i36 /= 4;
        }
        int i37 = i36;
        int i38 = (i3 >>> 9) & 1;
        if (i17 == 3) {
            i26 = i16 == 3 ? f137757j[i18 - 1] : f137758k[i18 - 1];
            i28 = (((i26 * 12000) / i37) + i38) * 4;
            i29 = 384;
        } else {
            int i39 = TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR;
            int i46 = gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION;
            if (i16 == 3) {
                i26 = i17 == 2 ? f137759l[i18 - 1] : f137760m[i18 - 1];
                i27 = (TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR * i26) / i37;
            } else {
                i26 = f137761n[i18 - 1];
                if (i17 == 1) {
                    i46 = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                }
                if (i17 == 1) {
                    i39 = DefaultOggSeeker.MATCH_RANGE;
                }
                i27 = (i39 * i26) / i37;
            }
            i28 = i27 + i38;
            i29 = i46;
        }
        iVar.a(i16, f137755h[3 - i17], i28, i37, ((i3 >> 6) & 3) == 3 ? 1 : 2, i26 * 1000, i29);
        return true;
    }

    public final void a(int i3, String str, int i16, int i17, int i18, int i19, int i26) {
        this.f137762a = i3;
        this.f137763b = str;
        this.f137764c = i16;
        this.f137765d = i17;
        this.f137766e = i18;
        this.f137767f = i19;
        this.f137768g = i26;
    }
}
