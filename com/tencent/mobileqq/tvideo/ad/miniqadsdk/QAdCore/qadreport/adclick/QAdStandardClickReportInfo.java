package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParamKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qqlive.ona.protocol.jce.AdAction;
import com.tencent.qqlive.ona.protocol.jce.AdActionReport;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdReportType;
import ew2.d;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import pw2.n;
import pw2.u;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdStandardClickReportInfo extends c implements ew2.b {
    private int A;
    public int B;

    /* renamed from: s, reason: collision with root package name */
    private int f303970s;

    /* renamed from: t, reason: collision with root package name */
    private int f303971t;

    /* renamed from: u, reason: collision with root package name */
    private ClickExtraInfo f303972u;

    /* renamed from: v, reason: collision with root package name */
    private String f303973v;

    /* renamed from: w, reason: collision with root package name */
    private Map<String, String> f303974w;

    /* renamed from: x, reason: collision with root package name */
    private Object f303975x;

    /* renamed from: y, reason: collision with root package name */
    private int f303976y;

    /* renamed from: z, reason: collision with root package name */
    private int f303977z;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ActionType {
        public static final int ACT_REDIRECT = 1029;
        public static final int ACT_TYPE_ACT_BTN = 1021;
        public static final int ACT_TYPE_ADVERTISER = 1003;
        public static final int ACT_TYPE_ADVERTISER_DOWNLOAD = 1034;
        public static final int ACT_TYPE_AD_HEAD = 1002;
        public static final int ACT_TYPE_ANIM = 1049;
        public static final int ACT_TYPE_BOTTOM = 1022;
        public static final int ACT_TYPE_ELSE = 1024;
        public static final int ACT_TYPE_ELSE_DOWNLOAD = 1037;
        public static final int ACT_TYPE_EXTERNAL_COMMENT = 9002;
        public static final int ACT_TYPE_EXTERNAL_PHONE = 9001;
        public static final int ACT_TYPE_FEED_CYCLE_CARD_ITEM_SELECT = 9004;
        public static final int ACT_TYPE_FOCUS_SHAKE = 1046;
        public static final int ACT_TYPE_FULL_VIDEO = 1040;
        public static final int ACT_TYPE_HALF_AUTO_OPEN_FULL = 1033;
        public static final int ACT_TYPE_HALF_PAGE = 1050;
        public static final int ACT_TYPE_HIGH_LIGHT_BANNER = 1032;
        public static final int ACT_TYPE_HORIZONTAL_BANNER = 1025;
        public static final int ACT_TYPE_IMAGE = 1014;
        public static final int ACT_TYPE_IMMERSIVE_FORM = 9000;
        public static final int ACT_TYPE_INNER_VIDEO_AUTO_SLIDE_IN = 9003;
        public static final int ACT_TYPE_INNER_VIDEO_CLICK_DETAIL = 9000;
        public static final int ACT_TYPE_INS_BOTTOM_TITLE = 1039;
        public static final int ACT_TYPE_INTERACTIVE_SLIDE = 1071;
        public static final int ACT_TYPE_INVALID = -1;
        public static final int ACT_TYPE_IP = 1047;
        public static final int ACT_TYPE_MASK_ACTION_BTN = 1023;
        public static final int ACT_TYPE_MASK_PLAY_END_TITLE = 1041;
        public static final int ACT_TYPE_MESSAGE = 1038;
        public static final int ACT_TYPE_OUT_FEED_BACK_ACTION_TYPE = 5001;
        public static final int ACT_TYPE_OUT_FEED_BACK_COMPLAIN_ACTION_TYPE = 5009;
        public static final int ACT_TYPE_PENDANT_ITEM = 1045;
        public static final int ACT_TYPE_PLAY_END_IMAGE = 1031;
        public static final int ACT_TYPE_PLAY_END_SUBTITLE = 1041;
        public static final int ACT_TYPE_PLAY_END_TITLE = 1030;
        public static final int ACT_TYPE_PORTRAIT = 1002;
        public static final int ACT_TYPE_REPLAY_MASK = 1028;
        public static final int ACT_TYPE_SHAKE_CLICK = 1048;
        public static final int ACT_TYPE_TITLE = 1011;
        public static final int ACT_TYPE_TITLE_DOWNLOAD = 1035;
        public static final int ACT_TYPE_VERTICAL_BANNER = 1026;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class ClickExtraInfo implements Serializable, Cloneable {
        public int height;
        public int width;
        public int downX = -999;
        public int downY = -999;
        public int upX = -999;
        public int upY = -999;
        public long playTime = 0;

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ClickExtraInfo m226clone() {
            try {
                return (ClickExtraInfo) super.clone();
            } catch (Exception e16) {
                n.b("ClickExtraInfo", "clone error, e=" + e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface NoChargeActionScene {
        public static final String ACTION_SCENE_FEEDBACK_CANCEL_BTN = "0007";
        public static final String ACTION_SCENE_FEED_MASK_OTHER = "0006";
        public static final String ACTION_SCENE_FLOAT_WIN_CLOSE_BTN = "0004";
        public static final String ACTION_SCENE_FREE_SPACE_BTN = "0003";
        public static final String ACTION_SCENE_FULLSCREEN_BACK_BTN = "0005";
        public static final String ACTION_SCENE_OUTER_FEEDBACK_BTN = "0002";
        public static final String ACTION_SCENE_VIDEO_FULLSCREEN_BTN = "0001";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface NoChargeClickType {
        public static final String CLICK_TYPE_CLICK = "1";
        public static final String CLICK_TYPE_SLIDE = "2";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface NoChargeInteractiveResult {
        public static final String INTERACTIVE_RESULT_FAILED = "0";
        public static final String INTERACTIVE_RESULT_SUCCESS = "1";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ReportType {
        public static final int TYPE_CHANNEL_FEED = 3;
        public static final int TYPE_DETAIL_FEED = 4;
        public static final int TYPE_FEED = 1;
        public static final int TYPE_FOCUS = 2;
        public static final int TYPE_IMMERSIVE_FEED = 5;
        public static final int TYPE_IMMERSIVE_PENDANT = 6;
        public static final int TYPE_NORMAL = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ReturnType {
        public static final int TYPE_ONLY_REPORT = 3;
        public static final int TYPE_OPEN_APP = 1;
        public static final int TYPE_WEB_PAGE = 2;
    }

    public QAdStandardClickReportInfo() {
        super(null, null, null, null, null, null, null);
        this.f303976y = 0;
    }

    public static QAdStandardClickReportInfo D(AdOrderItem adOrderItem, int i3, int i16, ClickExtraInfo clickExtraInfo, String str) {
        AdAction adAction;
        String str2;
        String str3;
        AdReport adReport = null;
        if (adOrderItem == null || (adAction = adOrderItem.adAction) == null) {
            return null;
        }
        AdActionReport adActionReport = adAction.actionReport;
        if (adActionReport != null) {
            adReport = adActionReport.clickReport;
        }
        AdReport adReport2 = adReport;
        String str4 = "";
        if (adActionReport == null) {
            str2 = "";
        } else {
            str2 = adActionReport.adReportKey;
        }
        if (adActionReport == null) {
            str3 = "";
        } else {
            str3 = adActionReport.adReportParams;
        }
        AdPositionItem adPositionItem = adOrderItem.positionItem;
        if (adPositionItem != null) {
            str4 = adPositionItem.adSpace;
        }
        return new QAdStandardClickReportInfo(i3, i16, clickExtraInfo, adReport2, adOrderItem.orderId, str4, str2, str3, adOrderItem, str);
    }

    public static QAdStandardClickReportInfo E(AdOrderItem adOrderItem, int i3, int i16, ClickExtraInfo clickExtraInfo, String str, Map<String, String> map) {
        QAdStandardClickReportInfo D = D(adOrderItem, i3, i16, clickExtraInfo, str);
        if (D == null) {
            return null;
        }
        D.K(map);
        return D;
    }

    public static QAdStandardClickReportInfo F(com.tencent.tvideo.protocol.pb.AdOrderItem adOrderItem, com.tencent.tvideo.protocol.pb.AdAction adAction, int i3, int i16, ClickExtraInfo clickExtraInfo, String str) {
        AdReportType adReportType;
        AdReport a16;
        if (adOrderItem == null || (a16 = kw2.b.a(adOrderItem, (adReportType = AdReportType.AD_REPORT_TYPE_CLICK))) == null) {
            return null;
        }
        QAdStandardClickReportInfo qAdStandardClickReportInfo = new QAdStandardClickReportInfo();
        qAdStandardClickReportInfo.f304052e = adOrderItem.ad_report_param;
        qAdStandardClickReportInfo.f304051d = adOrderItem.ad_report_key;
        qAdStandardClickReportInfo.f304049b = adOrderItem.order_id;
        qAdStandardClickReportInfo.f303970s = i3;
        qAdStandardClickReportInfo.f303971t = i16;
        qAdStandardClickReportInfo.f303972u = clickExtraInfo;
        qAdStandardClickReportInfo.f304047r = str;
        qAdStandardClickReportInfo.f304048a = a16;
        Map<String, String> c16 = kw2.b.c(adOrderItem, adReportType);
        if (!y.i(c16)) {
            qAdStandardClickReportInfo.f304044o = c16.get("__CHANNEL_ID__");
            qAdStandardClickReportInfo.f304045p = y.m(c16.get("__SEQ__"), 0);
            qAdStandardClickReportInfo.f304046q = y.m(c16.get("__ABS_SEQ__"), 0);
        }
        qAdStandardClickReportInfo.B();
        qAdStandardClickReportInfo.I(adOrderItem);
        return qAdStandardClickReportInfo;
    }

    public static QAdStandardClickReportInfo G(com.tencent.tvideo.protocol.pb.AdOrderItem adOrderItem, com.tencent.tvideo.protocol.pb.AdAction adAction, int i3, int i16, ClickExtraInfo clickExtraInfo, String str, Map<String, String> map) {
        QAdStandardClickReportInfo F = F(adOrderItem, adAction, i3, i16, clickExtraInfo, str);
        if (F == null) {
            return null;
        }
        if (!y.i(map)) {
            F.K(map);
        }
        return F;
    }

    public void H(int i3) {
        this.f303977z = i3;
    }

    public void I(Object obj) {
        this.f303975x = obj;
    }

    public void J(String str) {
        this.f303973v = str;
        n.e("QAdStandardClickReportInfo", "setClickCount=" + str);
        B();
    }

    public void K(Map<String, String> map) {
        this.f303974w = map;
    }

    public void L(int i3) {
        this.A = i3;
    }

    public void M(int i3) {
        this.f303976y = i3;
    }

    @Override // ew2.b
    public void a(int i3) {
        this.f303971t = i3;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public HashMap<String, String> s() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = this.f304049b;
        if (str != null) {
            hashMap.put("adId", str);
        }
        String str2 = this.f304050c;
        if (str2 != null) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_POS, str2);
        }
        hashMap.put("actionType", String.valueOf(this.f303970s));
        hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.f304051d);
        hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAM, this.f304052e);
        Map<String, String> map = this.f303974w;
        if (map != null) {
            hashMap.putAll(map);
        }
        HashMap<String, String> b16 = b();
        if (b16.size() > 0) {
            hashMap.putAll(b16);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        e.a(this, this.f304054g, gVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c
    public String y() {
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        long j3;
        AdReport adReport = this.f304048a;
        if (adReport == null || (str = adReport.url) == null) {
            str = null;
        }
        String d16 = u.d(str);
        if (d16 == null) {
            return null;
        }
        String replace = d16.replace("__ACT_TYPE__", String.valueOf(this.f303970s)).replace("__CHANNEL_ID__", y.f(this.f304044o)).replace("__SEQ__", String.valueOf(this.f304045p)).replace("__ABS_SEQ__", String.valueOf(this.f304046q)).replace("__RETURN_TYPE__", String.valueOf(this.f303971t)).replace("__ENCRYPT_DATA__", y.f(this.f304047r)).replace("__NET_STATUS__", String.valueOf(QAdDeviceUtils.l()));
        ClickExtraInfo clickExtraInfo = this.f303972u;
        int i26 = 0;
        if (clickExtraInfo != null) {
            i3 = clickExtraInfo.width;
        } else {
            i3 = 0;
        }
        String replace2 = replace.replace("__WIDTH__", String.valueOf(i3));
        ClickExtraInfo clickExtraInfo2 = this.f303972u;
        if (clickExtraInfo2 != null) {
            i16 = clickExtraInfo2.height;
        } else {
            i16 = 0;
        }
        String replace3 = replace2.replace("__HEIGHT__", String.valueOf(i16));
        ClickExtraInfo clickExtraInfo3 = this.f303972u;
        if (clickExtraInfo3 != null) {
            i17 = clickExtraInfo3.downX;
        } else {
            i17 = 0;
        }
        String replace4 = replace3.replace("__DOWN_X__", String.valueOf(i17));
        ClickExtraInfo clickExtraInfo4 = this.f303972u;
        if (clickExtraInfo4 != null) {
            i18 = clickExtraInfo4.downY;
        } else {
            i18 = 0;
        }
        String replace5 = replace4.replace("__DOWN_Y__", String.valueOf(i18));
        ClickExtraInfo clickExtraInfo5 = this.f303972u;
        if (clickExtraInfo5 != null) {
            i19 = clickExtraInfo5.upX;
        } else {
            i19 = 0;
        }
        String replace6 = replace5.replace("__UP_X__", String.valueOf(i19));
        ClickExtraInfo clickExtraInfo6 = this.f303972u;
        if (clickExtraInfo6 != null) {
            i26 = clickExtraInfo6.upY;
        }
        String replace7 = replace6.replace("__UP_Y__", String.valueOf(i26)).replace("__CLICK_LPP__", y.f(d.a()));
        ClickExtraInfo clickExtraInfo7 = this.f303972u;
        if (clickExtraInfo7 != null) {
            j3 = clickExtraInfo7.playTime;
        } else {
            j3 = 0;
        }
        return replace7.replace("__VIDEO_PLAY_TIME__", String.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c
    public String z() {
        String str;
        AdReport adReport = this.f304048a;
        if (adReport == null || (str = adReport.url) == null) {
            str = null;
        }
        return u.e(str);
    }

    public QAdStandardClickReportInfo(int i3, int i16, ClickExtraInfo clickExtraInfo, AdReport adReport, String str, String str2, String str3, String str4, AdOrderItem adOrderItem, String str5) {
        super(adReport, str, str2, str3, str4, adOrderItem, str5);
        this.f303976y = 0;
        this.f303970s = i3;
        this.f303971t = i16;
        this.f303972u = clickExtraInfo;
        this.f303975x = adOrderItem;
    }
}
