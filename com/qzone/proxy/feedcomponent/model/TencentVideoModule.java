package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_VIDEO.UrlRsp;
import NS_MOBILE_VIDEO.change_vkey_rsp;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.protocol.QZoneChangeVideoVkeyRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.proxy.feedcomponent.model.q;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.video.service.QZoneVideoCheckService;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zo.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TencentVideoModule {

    /* renamed from: k, reason: collision with root package name */
    private static int f50267k = 1;

    /* renamed from: l, reason: collision with root package name */
    private static TencentVideoModule f50268l;

    /* renamed from: m, reason: collision with root package name */
    public static Map<String, Pair<Long, SegmentVideoInfo.StreamInfo>> f50269m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public static Map<String, String[]> f50270n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    public static Map<String, Boolean> f50271o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    public static Map<String, Integer> f50272p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public static Map<String, Boolean> f50273q = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f50275b;

    /* renamed from: c, reason: collision with root package name */
    private String f50276c;

    /* renamed from: d, reason: collision with root package name */
    private int f50277d;

    /* renamed from: e, reason: collision with root package name */
    private zo.a f50278e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qzoneplayer.video.i f50279f;

    /* renamed from: a, reason: collision with root package name */
    public int f50274a = -1;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, String> f50280g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, String> f50281h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, String> f50282i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public a.InterfaceC11704a f50283j = new a();

    TencentVideoModule(Context context) {
        this.f50275b = "";
        this.f50276c = "";
        this.f50277d = 0;
        zo.c.b(context, "bCCgZepwIV5blRH87C9PFoUoKr6L7psMTisk66bF/1H03pkHaMz+aTqm+EuZsK5jcMw59CSdT+HILS6gWACGrz1HI21JyAtRIxrBvOZEIdoj1COzz/eVC/+5e7hWL6V2I/gm1gxEkQDsdjfI7TQY5BXACgEBiEjXdN9SDLt0nCc5kPtAKyEu18twINZA3Ndo3liswMNGwUmXCGTs3HUPFa4OZCVNAPbKyolzR8pKhp9yCH9rTDl2RxtLmfZyaax8FVEkIUE7EvLA/GMeA/zposvTUBK24ryQnkWieR99gIb2GiPybAP4y52heANvkBr0UXbGa4pGac2gtiROPg4IcQ==", "");
        zo.a a16 = zo.e.a();
        this.f50278e = a16;
        a16.b(this.f50283j);
        this.f50275b = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_DEFINITION_WIFI, this.f50275b);
        this.f50276c = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_DEFINITION_MOBILE_CONN, this.f50276c);
        this.f50277d = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_PLAY_FLRST_SEGMENT, this.f50277d);
        f50267k = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_USE_WNS_CGI, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(int i3) {
        int i16;
        if (this.f50274a == -1) {
            this.f50274a = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL, 26);
        }
        int i17 = Build.VERSION.SDK_INT;
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_OSVERSION, 20);
        PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] osVersion=" + i17 + ", osVersionLimit=" + config);
        if (i17 <= config) {
            PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] os version not supported");
            t(1, 0);
            return 0;
        }
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_MODELS, QzoneConfig.DEFAULT_TENCENT_VIDEO_REQUEST_LEVEL_BLACKLIST_MODELS);
        String model = DeviceInfoMonitor.getModel();
        PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] modelsLimit=" + config2 + ", model=" + model);
        String[] split = config2.split(";");
        if (split != null && split.length > 0) {
            for (String str : split) {
                if (model.equals(str)) {
                    PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] model not supported");
                    t(2, 0);
                    return 0;
                }
            }
        }
        boolean s16 = QZoneVideoLoader.s();
        PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] supportSuperPlayer=" + s16);
        if (!s16) {
            PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] SuperPlayer not supported");
            t(4, 0);
            return 0;
        }
        PlayerUtils.log(4, "TencentVideoModule", "[adjustHevclv] hevclv=" + i3 + ", hevcCheck=" + this.f50274a);
        if (i3 > 0 && (i16 = this.f50274a) > 0) {
            int min = Math.min(i3, i16);
            t(0, min);
            return min;
        }
        t(4, 0);
        return 0;
    }

    public static void k(String str) {
        Map<String, Pair<Long, SegmentVideoInfo.StreamInfo>> map = f50269m;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        f50269m.remove(str);
    }

    public static TencentVideoModule m(Context context) {
        if (f50268l == null) {
            synchronized (TencentVideoModule.class) {
                if (f50268l == null) {
                    f50268l = new TencentVideoModule(context);
                }
            }
        }
        return f50268l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType == 1) {
            return 1;
        }
        if (netWorkType == 4) {
            return 4;
        }
        return netWorkType == 3 ? 3 : 0;
    }

    private void t(int i3, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("situation", String.valueOf(i3));
        hashMap.put("result", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "tencent_video_hevclv", true, 0L, 0L, hashMap, null);
    }

    public static int v() {
        return f50267k;
    }

    public void g(String str, String str2) {
        HashMap<String, String> hashMap = this.f50282i;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
    }

    public void h(String str, String str2) {
        HashMap<String, String> hashMap = this.f50281h;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
    }

    public void i(String str, String str2) {
        HashMap<String, String> hashMap = this.f50280g;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
    }

    public int o() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3;
        QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        int comDiamondType = currentVipInfo.getComDiamondType();
        int comDiamondLevel = currentVipInfo.getComDiamondLevel();
        boolean isComDiamondAnnualVip = currentVipInfo.isComDiamondAnnualVip();
        switch (comDiamondType) {
            case 1:
                z16 = true;
                z18 = true;
                z17 = false;
                z19 = false;
                break;
            case 2:
                z16 = true;
                z17 = false;
                z19 = z17;
                z18 = z19;
                break;
            case 3:
            case 6:
                z17 = true;
                z18 = true;
                z16 = false;
                z19 = false;
                break;
            case 4:
                z17 = true;
                z16 = false;
                z19 = false;
                z18 = z19;
                break;
            case 5:
                z16 = true;
                z19 = true;
                z17 = false;
                z18 = false;
                break;
            default:
                z16 = false;
                z17 = false;
                z19 = z17;
                z18 = z19;
                break;
        }
        if (z16) {
            i3 = comDiamondLevel > 0 ? comDiamondLevel - 1 : 0;
            if (isComDiamondAnnualVip) {
                i3 += 16;
            }
            if (z19) {
                i3 += 32;
            }
            return z18 ? i3 + 64 : i3;
        }
        if (!z17) {
            return 0;
        }
        i3 = comDiamondLevel > 0 ? (comDiamondLevel - 1) << 8 : 0;
        if (isComDiamondAnnualVip) {
            i3 += 4096;
        }
        return !z18 ? i3 + 8192 : i3;
    }

    public void s(com.tencent.mobileqq.qzoneplayer.video.i iVar, a.InterfaceC11704a interfaceC11704a) {
        this.f50279f = iVar;
    }

    public void u(final String str, final String str2, final String str3, final String str4, final String str5, final int i3, final String str6, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.model.TencentVideoModule.1
            @Override // java.lang.Runnable
            public void run() {
                zo.d dVar;
                PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + str5);
                if (str5 == null || TencentVideoModule.this.f50278e == null) {
                    return;
                }
                if (str != null) {
                    int n3 = TencentVideoModule.this.n();
                    int o16 = TencentVideoModule.this.o();
                    int a16 = zo.c.a();
                    TencentVideoModule tencentVideoModule = TencentVideoModule.this;
                    int l3 = tencentVideoModule.l(tencentVideoModule.p(str5));
                    String q16 = TencentVideoModule.this.q(str5);
                    String str7 = "uin=" + LoginData.getInstance().getUinString() + ";skey=null;";
                    int j3 = TencentVideoModule.this.j(i3);
                    zo.d dVar2 = new zo.d(str5, str6, q16, o16, l3, n3, a16, str, str2, str3, str4, str7, j3, i16);
                    PlayerUtils.log(4, "TencentVideoModule", "[requestSafeUrl] vid = " + str5 + ", normal request situation:ckey!=null, defn=" + str6 + ", dfnre=" + q16 + ", hevcRequest=" + j3 + ", useHttps=" + i16);
                    dVar = dVar2;
                } else {
                    dVar = new zo.d(str5, null);
                    PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + str5 + ", abnormal request situation:ckey==null!");
                }
                TencentVideoModule.this.f50278e.a(1, dVar);
            }
        });
    }

    public String p(String str) {
        HashMap<String, String> hashMap;
        if (str != null && (hashMap = this.f50282i) != null && hashMap.containsKey(str)) {
            return this.f50282i.get(str);
        }
        return "0";
    }

    public String q(String str) {
        HashMap<String, String> hashMap;
        if (str == null || (hashMap = this.f50281h) == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f50281h.get(str);
    }

    public String r(String str) {
        HashMap<String, String> hashMap;
        if (str == null || (hashMap = this.f50280g) == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f50280g.get(str);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements a.InterfaceC11704a {
        a() {
        }

        @Override // zo.a.InterfaceC11704a
        public void a(int i3, int i16, zo.b bVar, String str) {
            PlayerUtils.log(6, "TencentVideoModule", "request safe vid = " + str + ", video call fail: mainErrorCode = " + i16 + "subErrorCode" + bVar.i());
            String r16 = TencentVideoModule.this.r(str);
            if (i16 != 101 || bVar.i() != 85 || TextUtils.isEmpty(r16)) {
                if (TencentVideoModule.this.f50279f != null) {
                    TencentVideoModule.this.f50279f.a(r16, false, r16, bVar.i(), 0);
                    com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
                    BaseApplicationImpl.getApplication();
                    H.i2(BaseApplication.getContext(), false, r16, i16, bVar.i());
                    PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + str + ", refreshVideoKey result getSucceed error");
                    return;
                }
                return;
            }
            PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + str + ", 85 error ! need change ckey first");
            QZoneVideoCheckService.get().changeVideoVkey(r16, new C0426a(str, bVar));
        }

        @Override // zo.a.InterfaceC11704a
        public void b(int i3, zo.b bVar, String str) {
            List<q.a> list;
            String r16 = TencentVideoModule.this.r(str);
            if (TencentVideoModule.this.f50279f == null) {
                return;
            }
            if (bVar == null) {
                PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + str + ", netVideoInfo is null, oldurl = " + r16);
                TencentVideoModule.this.f50279f.a(r16, false, null, -777, 0);
                return;
            }
            String g16 = bVar.g();
            String[] b16 = bVar.b();
            String[] c16 = bVar.c();
            boolean f16 = bVar.f();
            int h16 = bVar.h();
            boolean z16 = bVar.e() > 0;
            PlayerUtils.log(4, "TencentVideoModule", "magi request safe url vid = " + str + ", response safe url = " + g16 + ", hevc = " + z16);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(g16)) {
                if (TextUtils.isEmpty(g16)) {
                    for (String str2 : b16) {
                        if (!TextUtils.isEmpty(str2)) {
                            TencentVideoModule.this.f50279f.a(r16, true, str2, bVar.i(), 0);
                            return;
                        }
                    }
                    return;
                }
                SegmentVideoInfo.StreamInfo streamInfo = new SegmentVideoInfo.StreamInfo();
                if (g16.contains("CLIPINFO")) {
                    try {
                        list = new q().a(new ByteArrayInputStream(bVar.g().getBytes("UTF-8")));
                    } catch (Exception e16) {
                        PlayerUtils.log(6, "TencentVideoModule", "request safe vid = " + str + ", safe url decode error" + e16.getMessage());
                        list = null;
                    }
                    if (list != null) {
                        for (q.a aVar : list) {
                            List<String> d16 = aVar.d();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(aVar.c());
                            Iterator<String> it = d16.iterator();
                            while (it.hasNext()) {
                                sb5.append(it.next());
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            if (!sb5.toString().toLowerCase().contains("vkey=null")) {
                                streamInfo.addSegmentInfo(sb5.toString(), (int) aVar.b());
                            } else {
                                streamInfo.isVip = true;
                            }
                            if (TencentVideoModule.this.f50277d != 0) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (HttpUtil.isValidUrl(g16) && g16.toLowerCase().contains("vkey=")) {
                    streamInfo.isVip = true;
                    streamInfo.addSegmentInfo(g16, Math.min(bVar.h(), bVar.d()) * 1000);
                    if (streamInfo.segmentInfos.size() > 0) {
                        String str3 = streamInfo.segmentInfos.get(0).url;
                        if (!TextUtils.isEmpty(str3)) {
                            String substring = str3.substring(0, str3.lastIndexOf(".") + 1);
                            String substring2 = substring.substring(substring.lastIndexOf("/") + 1);
                            if (substring2.contains(".")) {
                                String substring3 = substring2.substring(0, substring2.indexOf("."));
                                Pair<Long, SegmentVideoInfo.StreamInfo> pair = new Pair<>(Long.valueOf(System.currentTimeMillis()), streamInfo);
                                if (!str.equals(substring3)) {
                                    TencentVideoModule.f50269m.put(substring3, pair);
                                    TencentVideoModule.f50270n.put(substring3, c16);
                                    TencentVideoModule.f50271o.put(substring3, Boolean.valueOf(f16));
                                    TencentVideoModule.f50272p.put(substring3, Integer.valueOf(h16));
                                    TencentVideoModule.f50273q.put(substring3, Boolean.valueOf(z16));
                                } else {
                                    TencentVideoModule.f50269m.put(str, pair);
                                    TencentVideoModule.f50270n.put(str, c16);
                                    TencentVideoModule.f50271o.put(str, Boolean.valueOf(f16));
                                    TencentVideoModule.f50272p.put(str, Integer.valueOf(h16));
                                    TencentVideoModule.f50273q.put(str, Boolean.valueOf(z16));
                                }
                            }
                            TencentVideoModule.this.f50279f.b(r16, true, streamInfo, c16, f16, h16, z16);
                            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
                            BaseApplicationImpl.getApplication();
                            H.i2(BaseApplication.getContext(), true, g16, 0, bVar.i());
                            PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + str + ", requestSafeUrl success! limitState=" + f16 + " preview=" + h16);
                            return;
                        }
                    }
                }
                TencentVideoModule.this.f50279f.a(r16, false, g16, -780, 0);
                return;
            }
            TencentVideoModule.this.f50279f.a(r16, false, null, -778, 0);
        }

        /* compiled from: P */
        /* renamed from: com.qzone.proxy.feedcomponent.model.TencentVideoModule$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0426a implements IQZoneServiceListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f50291d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ zo.b f50292e;

            C0426a(String str, zo.b bVar) {
                this.f50291d = str;
                this.f50292e = bVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x01bd  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x01bf  */
            @Override // com.qzone.common.business.IQZoneServiceListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onTaskResponse(QZoneTask qZoneTask) {
                String str;
                Uri parse;
                String str2;
                int i3;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                Map<String, UrlRsp> map;
                String str10;
                if (qZoneTask != null && qZoneTask.mType == 3) {
                    QZoneChangeVideoVkeyRequest qZoneChangeVideoVkeyRequest = (QZoneChangeVideoVkeyRequest) qZoneTask.mRequest;
                    String str11 = (String) qZoneTask.getParameter("url");
                    change_vkey_rsp resp = qZoneChangeVideoVkeyRequest.getResp();
                    if (resp != null && (map = resp.video_urls) != null) {
                        UrlRsp urlRsp = map.get(str11);
                        if (urlRsp != null && urlRsp.code == 0 && !TextUtils.isEmpty(urlRsp.url)) {
                            str = urlRsp.url;
                            PlayerUtils.log(2, "TencentVideoModule", "request safe vid = " + this.f50291d + "oldUrl=" + str11 + " newUrl=" + str);
                            if (!str.equals(str11) && TencentVideoModule.this.f50279f != null) {
                                TencentVideoModule.this.f50279f.a(str11, false, str, this.f50292e.i(), 0);
                                PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + this.f50291d + ", change ckey fail ! newUrl equals oldUrl");
                                return;
                            }
                            PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + this.f50291d + ", change ckey success ! newUrl=" + str);
                            parse = Uri.parse(str);
                            Uri parse2 = Uri.parse(str11);
                            if (parse != null || parse2 == null) {
                                str2 = null;
                                i3 = 0;
                                str3 = null;
                                str4 = null;
                                str5 = null;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                                str9 = null;
                            } else {
                                try {
                                    String queryParameter = parse.getQueryParameter("cKey");
                                    String queryParameter2 = parse.getQueryParameter(AdParam.APPVER);
                                    String queryParameter3 = parse.getQueryParameter("platform");
                                    String queryParameter4 = parse.getQueryParameter("sdtfrom");
                                    String queryParameter5 = parse.getQueryParameter("hevclv");
                                    String queryParameter6 = parse.getQueryParameter("playerformat");
                                    if (TextUtils.isEmpty(queryParameter6)) {
                                        queryParameter6 = "auto";
                                    }
                                    int intValue = Integer.valueOf(parse.getQueryParameter(TVKLiveRequestBuilder.RequestParamKey.HTTPS)).intValue();
                                    str4 = parse.getHost();
                                    str3 = parse2.getHost();
                                    str9 = queryParameter6;
                                    i3 = intValue;
                                    str7 = queryParameter3;
                                    str8 = queryParameter4;
                                    str5 = queryParameter;
                                    str2 = queryParameter5;
                                    str6 = queryParameter2;
                                } catch (Exception e16) {
                                    PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + this.f50291d + ", change ckey fail ! parse url error" + e16.getMessage());
                                    if (TencentVideoModule.this.f50279f != null) {
                                        TencentVideoModule.this.f50279f.a(str11, false, str11, -779, 0);
                                        return;
                                    }
                                    return;
                                }
                            }
                            boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_REQUEST_SAFE_URL_NEED_CHECK_HOST, 0) == 0;
                            if ((str4 != null || ((z16 && !str4.equals(str3)) || TextUtils.isEmpty(str5))) && TencentVideoModule.this.f50279f != null) {
                                TencentVideoModule.this.f50279f.a(str11, false, str, -781, 0);
                                PlayerUtils.log(4, "TencentVideoModule", "change ckey fail!newUrl is wrong format");
                            } else {
                                TencentVideoModule.this.u(str5, str6, str7, str8, this.f50291d, str2 != null ? Integer.valueOf(str2).intValue() : 0, str9, i3);
                                return;
                            }
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("request safe vid = ");
                        sb5.append(this.f50291d);
                        sb5.append("change vkey error! old url = ");
                        sb5.append(str11);
                        if (urlRsp == null) {
                            str10 = "";
                        } else {
                            str10 = " resultCode=" + urlRsp.code;
                        }
                        sb5.append(str10);
                        PlayerUtils.log(2, "TencentVideoModule", sb5.toString());
                    }
                    str = str11;
                    if (!str.equals(str11)) {
                    }
                    PlayerUtils.log(4, "TencentVideoModule", "request safe vid = " + this.f50291d + ", change ckey success ! newUrl=" + str);
                    parse = Uri.parse(str);
                    Uri parse22 = Uri.parse(str11);
                    if (parse != null) {
                    }
                    str2 = null;
                    i3 = 0;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                    str8 = null;
                    str9 = null;
                    if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_REQUEST_SAFE_URL_NEED_CHECK_HOST, 0) == 0) {
                    }
                    if (str4 != null) {
                    }
                    TencentVideoModule.this.f50279f.a(str11, false, str, -781, 0);
                    PlayerUtils.log(4, "TencentVideoModule", "change ckey fail!newUrl is wrong format");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equals("1") || str.equals("2")) {
            return 1;
        }
        if (str.equals("3")) {
            return 3;
        }
        return (str.equals("4") || str.equals("5")) ? 2 : 0;
    }
}
