package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountConfigAttr extends QRouteApi {
    public static final String BACK_COLOR = "background_color";
    public static final String CARD_STYLE = "card_style";
    public static final String CERT_DESP = "certified_description";
    public static final String CERT_ENT = "certified_enterprise";
    public static final String CERT_WX = "certified_weixin";
    public static final String CONFIG_ATTR = "config_arr";
    public static final String CUSTOM_ATTR = "custom_arr";
    public static final int CardStyle_Default = 0;
    public static final int CardStyle_FullScree = 1;
    public static final String FULLSCREEN_ATTR = "fullscreen_arr";
    public static final int LAYOUT_BANNER = 2;
    public static final int LAYOUT_HORIZONTAL = 1;
    public static final int LAYOUT_JIGSAW = 4;
    public static final int LAYOUT_ScreenGIF = 6;
    public static final int LAYOUT_ScreenStaticPic = 5;
    public static final int LAYOUT_VERTICAL = 0;
    public static final int LAYOUT_WINDOW = 3;
    public static final int Layout_ScreenVideo = 7;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: s, reason: collision with root package name */
        public static final Map<Class<?>, Integer> f79328s;

        /* renamed from: b, reason: collision with root package name */
        public String f79330b;

        /* renamed from: c, reason: collision with root package name */
        public String f79331c;

        /* renamed from: h, reason: collision with root package name */
        public String f79336h;

        /* renamed from: j, reason: collision with root package name */
        public String f79338j;

        /* renamed from: k, reason: collision with root package name */
        public String f79339k;

        /* renamed from: l, reason: collision with root package name */
        public String f79340l;

        /* renamed from: m, reason: collision with root package name */
        public String f79341m;

        /* renamed from: n, reason: collision with root package name */
        public String f79342n;

        /* renamed from: q, reason: collision with root package name */
        public String f79345q;

        /* renamed from: r, reason: collision with root package name */
        public String f79346r;

        /* renamed from: a, reason: collision with root package name */
        public int f79329a = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f79332d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f79333e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f79334f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f79335g = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f79337i = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f79343o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f79344p = 0;

        static {
            HashMap hashMap = new HashMap();
            f79328s = hashMap;
            hashMap.put(Boolean.TYPE, 1);
            hashMap.put(Integer.TYPE, 2);
            hashMap.put(Long.TYPE, 3);
            hashMap.put(String.class, 4);
            hashMap.put(Double.TYPE, 5);
        }
    }

    List<IPublicAccountConfigAttr> castToPaConfigAttrs(List<mobileqq_mp$ConfigGroupInfo> list);

    List<a> getConfigs();

    int getType();

    List<IPublicAccountConfigAttr> parser(JSONArray jSONArray);
}
