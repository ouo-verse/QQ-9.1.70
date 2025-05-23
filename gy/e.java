package gy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e implements n<String> {

    /* renamed from: a, reason: collision with root package name */
    private String f403830a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f403831b = "";

    /* renamed from: c, reason: collision with root package name */
    private boolean f403832c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f403833d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f403834e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f403835f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f403836g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f403837h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f403838i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f403839j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f403840k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f403841l = false;

    /* renamed from: m, reason: collision with root package name */
    private String f403842m = "";

    /* renamed from: n, reason: collision with root package name */
    private long f403843n = 3000;

    /* renamed from: o, reason: collision with root package name */
    private boolean f403844o = false;

    /* renamed from: p, reason: collision with root package name */
    private int f403845p = 0;

    /* renamed from: q, reason: collision with root package name */
    private String f403846q = "";

    /* renamed from: r, reason: collision with root package name */
    private boolean f403847r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f403848s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f403849t = false;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<String> f403850u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    private int f403851v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f403852w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f403853x = 0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f403854y = true;

    /* renamed from: z, reason: collision with root package name */
    private String f403855z = "";
    private boolean A = false;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private String F = "";
    private int G = 0;
    private boolean H = false;

    private e a(e eVar, String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("service_folder_name")) {
                this.f403830a = eVar.f403830a;
            }
            if (jSONObject.has("service_folder_icon")) {
                this.f403831b = eVar.f403831b;
            }
            if (jSONObject.has("service_folder_redspots")) {
                this.f403832c = eVar.f403832c;
            }
            if (jSONObject.has("service_folder_delete")) {
                this.f403833d = eVar.f403833d;
            }
            if (jSONObject.has("ServiceFolder_RedClean_After_Enter")) {
                this.f403834e = eVar.f403834e;
            }
            if (jSONObject.has("readInJoy_feeds_preload")) {
                this.f403835f = eVar.f403835f;
            }
            if (jSONObject.has("readInJoy_feeds_preload_wifi")) {
                this.f403836g = eVar.f403836g;
            }
            if (jSONObject.has("readInJoy_feeds_preload_4G")) {
                this.f403837h = eVar.f403837h;
            }
            if (jSONObject.has("readInJoy_feeds_preload_3G")) {
                this.f403838i = eVar.f403838i;
            }
            if (jSONObject.has("readInJoy_feeds_preload_2G")) {
                this.f403839j = eVar.f403839j;
            }
            if (jSONObject.has("pub_account_bottom_bar")) {
                this.f403840k = eVar.f403840k;
            }
            if (jSONObject.has("readInJoy_feeds_image_preload")) {
                this.f403841l = eVar.f403841l;
            }
            if (jSONObject.has("kandian_feeds_fling_LToR_host")) {
                this.f403842m = eVar.f403842m;
            }
            if (jSONObject.has("kandian_ad_background_showtime")) {
                this.f403843n = eVar.f403843n;
            }
            if (jSONObject.has("readInJoy_ip_connect")) {
                this.f403844o = eVar.f403844o;
            }
            if (jSONObject.has("readInJoy_ip_connect_full_report") && jSONObject.has("readInJoy_ip_connect_report_tail")) {
                this.f403845p = eVar.f403845p;
                this.f403846q = eVar.f403846q;
            }
            if (jSONObject.has("readInJoy_load_img")) {
                this.f403847r = eVar.f403847r;
            }
            if (jSONObject.has("service_account_folder_redspots_delete")) {
                this.f403848s = eVar.f403848s;
            }
            if (jSONObject.has("disable_big_data_channel")) {
                this.f403849t = eVar.f403849t;
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && jSONObject.has("host_white_list")) {
                this.f403850u = eVar.f403850u;
            }
            if (jSONObject.has("album_predown_enable")) {
                this.f403851v = eVar.f403851v;
            }
            if (jSONObject.has("album_predown_photo_rule")) {
                this.f403852w = eVar.f403852w;
            }
            if (jSONObject.has("album_predown_slide_photocounts")) {
                this.f403853x = eVar.f403853x;
            }
            if (jSONObject.has("preload_tool_process")) {
                this.f403854y = eVar.f403854y;
            }
            if (jSONObject.has("useNewLogic")) {
                this.f403855z = eVar.f403855z;
                this.A = eVar.A;
                this.B = eVar.B;
                this.C = eVar.C;
                this.D = eVar.D;
                this.E = eVar.E;
            }
            if (jSONObject.has("releaseServiceMinMem")) {
                this.F = eVar.F;
                this.G = eVar.G;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public static e c() {
        e eVar = new e();
        eVar.f403830a = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
        eVar.f403831b = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon();
        eVar.f403833d = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isServiceAccountFolderDelete();
        eVar.f403834e = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isClearAllPublicAccountFolderRedNumber();
        eVar.f403832c = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedSpots();
        eVar.f403835f = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload();
        eVar.f403836g = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreloadWifi();
        eVar.f403837h = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload4G();
        eVar.f403838i = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload3G();
        eVar.f403839j = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload2G();
        eVar.f403840k = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isNeedPABottomBar();
        eVar.f403841l = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsImagePreload();
        eVar.f403842m = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyflingLToRHost();
        eVar.f403843n = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyADBackgroundShowTime();
        eVar.f403844o = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyIpConnect();
        eVar.f403845p = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyIpConnectReportSwitch();
        eVar.f403846q = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyIpConnectReportTail();
        eVar.f403847r = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyLoadImg();
        eVar.f403848s = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete();
        eVar.f403849t = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isDisableBigDataChannel();
        eVar.f403850u = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getBigDataChannelWhiteList();
        eVar.f403851v = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreload();
        eVar.f403852w = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreloadCover();
        eVar.f403853x = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreloadImage();
        eVar.f403854y = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).isPreloadToolProcess();
        String readInJoyPreloadToolConfig = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyPreloadToolConfig();
        eVar.f403855z = readInJoyPreloadToolConfig;
        eVar.F = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyReleaseWebServiceConfig();
        try {
            if (!TextUtils.isEmpty(readInJoyPreloadToolConfig)) {
                JSONObject jSONObject = new JSONObject(readInJoyPreloadToolConfig);
                if (jSONObject.has("useNewLogic")) {
                    h(eVar, jSONObject);
                }
                if (jSONObject.has("releaseServiceMinMem")) {
                    g(eVar, jSONObject);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return eVar;
    }

    public static e f(ai[] aiVarArr) {
        e eVar = new e();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (ai aiVar : aiVarArr) {
                String str = aiVar.f202268b;
                try {
                    eVar = eVar.a((e) as.e(str, e.class), str);
                } catch (QStorageInstantiateException e16) {
                    QLog.i("ServiceAccountFolderConfProcessor", 1, "loadConfig l :" + str, e16);
                }
            }
        }
        return eVar;
    }

    private static void g(e eVar, JSONObject jSONObject) {
        eVar.G = jSONObject.optInt("releaseServiceMinMem", 80);
    }

    private static void h(e eVar, JSONObject jSONObject) {
        eVar.A = jSONObject.optBoolean("useNewLogic", false);
        eVar.B = jSONObject.optInt("minTotalMem", 1024);
        eVar.C = jSONObject.optInt("minAvailableMem", 100);
        eVar.D = jSONObject.optInt("minCpuNum", 2);
        eVar.E = jSONObject.optInt("minCpuFreq", 1000);
    }

    private void i(boolean z16) {
        MqqHandler handler;
        if (z16) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && (handler = ((QQAppInterface) runtime).getHandler(Conversation.class)) != null) {
                handler.sendEmptyMessage(1009);
            }
        }
    }

    public void b() {
        i(this.H);
    }

    public void d() {
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderName(this.f403830a);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderIcon(this.f403831b);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderDelete(this.f403833d);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedCleanAfterEnter(this.f403834e);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedSpots(this.f403832c);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload(this.f403835f);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreloadWifi(this.f403836g);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload4G(this.f403837h);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload3G(this.f403838i);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload2G(this.f403839j);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setNeedPABottomBar(this.f403840k);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsImagePreload(this.f403841l);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyflingLToRHost(this.f403842m);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyADBackgroundShowTime(this.f403843n);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnect(this.f403844o);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnectReportSwitch(this.f403845p);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnectReportTail(this.f403846q);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyLoadImg(this.f403847r);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedDelete(this.f403848s);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setDisableBigDataChannel(this.f403849t);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setBigDataChannelWhiteList(this.f403850u);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreload(this.f403851v);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreloadCover(this.f403852w);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreloadImage(this.f403853x);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setPreloadToolProcess(this.f403854y);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyPreloadToolConfig(this.f403855z);
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyReleaseWebServiceConfig(this.F);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0362 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x039a A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03d5 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0470 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04a4 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04d8 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x050c A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0548 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0586 A[Catch: JSONException -> 0x05e6, TryCatch #0 {JSONException -> 0x05e6, blocks: (B:3:0x0044, B:6:0x0052, B:7:0x0059, B:9:0x005f, B:10:0x0063, B:12:0x006d, B:14:0x0073, B:16:0x007d, B:18:0x00a7, B:20:0x00ad, B:22:0x00b9, B:24:0x00d5, B:26:0x00db, B:27:0x00fb, B:29:0x0101, B:31:0x010d, B:33:0x0129, B:35:0x012f, B:37:0x013b, B:39:0x0157, B:41:0x015d, B:43:0x0169, B:45:0x0185, B:47:0x018b, B:49:0x0197, B:51:0x01b3, B:53:0x01b9, B:55:0x01c5, B:57:0x01e1, B:59:0x01e7, B:61:0x01f3, B:63:0x020f, B:65:0x0215, B:67:0x0221, B:69:0x023d, B:71:0x0245, B:73:0x0251, B:75:0x026d, B:77:0x0275, B:79:0x0285, B:81:0x029e, B:83:0x02a6, B:85:0x02b8, B:87:0x02d9, B:89:0x02e1, B:91:0x02ed, B:93:0x0309, B:95:0x0311, B:97:0x031c, B:99:0x0331, B:101:0x035a, B:103:0x0362, B:105:0x036e, B:107:0x0391, B:109:0x039a, B:111:0x03a9, B:113:0x03cc, B:115:0x03d5, B:117:0x03e4, B:120:0x0409, B:122:0x0412, B:125:0x042b, B:127:0x0431, B:129:0x0442, B:131:0x045c, B:134:0x0465, B:136:0x0470, B:138:0x047f, B:140:0x049b, B:142:0x04a4, B:144:0x04b3, B:146:0x04cf, B:148:0x04d8, B:150:0x04e7, B:152:0x0503, B:154:0x050c, B:156:0x051b, B:158:0x053f, B:160:0x0548, B:162:0x0558, B:164:0x057d, B:166:0x0586, B:168:0x0591, B:170:0x05ab, B:197:0x05e3), top: B:2:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x038d  */
    @Override // com.tencent.mobileqq.config.n
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onParse(String str) {
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        boolean z59;
        boolean z65;
        boolean z66;
        boolean z67;
        boolean z68;
        boolean z69;
        boolean z75;
        boolean z76;
        boolean z77;
        boolean z78;
        boolean z79;
        boolean z85;
        String str4;
        boolean z86;
        boolean z87;
        boolean z88;
        boolean z89;
        boolean z95;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str5 = "";
            if (!jSONObject.has("service_folder_name")) {
                str2 = "";
            } else {
                str2 = jSONObject.getString("service_folder_name");
            }
            if (jSONObject.has("service_folder_icon")) {
                str5 = jSONObject.getString("service_folder_icon");
            }
            String str6 = str5;
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str6)) {
                str3 = "readInJoy_feeds_image_preload";
                z16 = false;
            } else {
                this.f403830a = str2;
                this.f403831b = str6;
                if (!QLog.isColorLevel()) {
                    str3 = "readInJoy_feeds_image_preload";
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    str3 = "readInJoy_feeds_image_preload";
                    sb5.append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:");
                    sb5.append(str2);
                    sb5.append(" SERVICE_ACCOUNT_FOLDER_ICON:");
                    sb5.append(str6);
                    QLog.d("ServiceAccountFolderConfProcessor", 2, sb5.toString());
                }
                z16 = true;
            }
            if (jSONObject.has("service_folder_redspots")) {
                this.f403832c = jSONObject.getBoolean("service_folder_redspots");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + this.f403832c);
                }
                z17 = true;
            } else {
                z17 = false;
            }
            if (jSONObject.has("service_folder_delete")) {
                boolean z96 = jSONObject.getBoolean("service_folder_delete");
                this.f403833d = z96;
                QLog.d("ServiceAccountFolderConfProcessor", 1, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + z96);
                z18 = true;
            } else {
                z18 = false;
            }
            if (jSONObject.has("ServiceFolder_RedClean_After_Enter")) {
                this.f403834e = jSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "ServiceFolder_RedClean_After_Enter = " + this.f403834e);
                }
                z19 = true;
            } else {
                z19 = false;
            }
            if (jSONObject.has("readInJoy_feeds_preload")) {
                this.f403835f = jSONObject.getBoolean("readInJoy_feeds_preload");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload:" + this.f403835f);
                }
                z26 = true;
            } else {
                z26 = false;
            }
            if (jSONObject.has("readInJoy_feeds_preload_wifi")) {
                this.f403836g = jSONObject.getBoolean("readInJoy_feeds_preload_wifi");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload wifi:" + this.f403836g);
                }
                z27 = true;
            } else {
                z27 = false;
            }
            if (jSONObject.has("readInJoy_feeds_preload_4G")) {
                this.f403837h = jSONObject.getBoolean("readInJoy_feeds_preload_4G");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 4G:" + this.f403837h);
                }
                z28 = true;
            } else {
                z28 = false;
            }
            if (jSONObject.has("readInJoy_feeds_preload_3G")) {
                this.f403838i = jSONObject.getBoolean("readInJoy_feeds_preload_3G");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 3G:" + this.f403838i);
                }
                z29 = true;
            } else {
                z29 = false;
            }
            if (jSONObject.has("readInJoy_feeds_preload_2G")) {
                this.f403839j = jSONObject.getBoolean("readInJoy_feeds_preload_2G");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 2G:" + this.f403839j);
                }
                z36 = true;
            } else {
                z36 = false;
            }
            if (jSONObject.has("pub_account_bottom_bar")) {
                this.f403840k = jSONObject.getBoolean("pub_account_bottom_bar");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "needPABottomBar: " + this.f403840k);
                }
                z37 = true;
            } else {
                z37 = false;
            }
            String str7 = str3;
            if (jSONObject.has(str7)) {
                this.f403841l = jSONObject.getBoolean(str7);
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds image preload" + this.f403841l);
                }
                z38 = true;
            } else {
                z38 = false;
            }
            if (jSONObject.has("kandian_feeds_fling_LToR_host")) {
                this.f403842m = jSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_feeds_fling_LToR_host" + this.f403842m);
                }
                z39 = true;
            } else {
                z39 = false;
            }
            if (jSONObject.has("kandian_ad_background_showtime")) {
                z46 = z19;
                z47 = z37;
                this.f403843n = jSONObject.optLong("kandian_ad_background_showtime", 3000L);
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("kandian_ad_background_showtime");
                    z48 = z39;
                    sb6.append(this.f403843n);
                    QLog.d("ServiceAccountFolderConfProcessor", 2, sb6.toString());
                } else {
                    z48 = z39;
                }
                z49 = true;
            } else {
                z46 = z19;
                z47 = z37;
                z48 = z39;
                z49 = false;
            }
            if (jSONObject.has("readInJoy_ip_connect")) {
                this.f403844o = jSONObject.getBoolean("readInJoy_ip_connect");
                if (QLog.isColorLevel()) {
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect:" + this.f403844o);
                }
                z55 = true;
            } else {
                z55 = false;
            }
            if (jSONObject.has("readInJoy_ip_connect_full_report")) {
                z56 = z49;
                if (jSONObject.has("readInJoy_ip_connect_report_tail")) {
                    this.f403845p = jSONObject.getInt("readInJoy_ip_connect_full_report");
                    this.f403846q = jSONObject.getString("readInJoy_ip_connect_report_tail");
                    if (QLog.isColorLevel()) {
                        QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect_full_report:" + this.f403845p + ", readInJoy_ip_connect_report_tail:" + this.f403846q);
                    }
                    z57 = true;
                    if (!jSONObject.has("readInJoy_load_img")) {
                        this.f403847r = jSONObject.getBoolean("readInJoy_load_img");
                        if (QLog.isColorLevel()) {
                            StringBuilder sb7 = new StringBuilder();
                            z58 = z48;
                            sb7.append("readInJoyLoadImg:");
                            sb7.append(this.f403847r);
                            QLog.d("ServiceAccountFolderConfProcessor", 2, sb7.toString());
                        } else {
                            z58 = z48;
                        }
                        z59 = true;
                    } else {
                        z58 = z48;
                        z59 = false;
                    }
                    if (!jSONObject.has("service_account_folder_redspots_delete")) {
                        this.f403848s = jSONObject.getBoolean("service_account_folder_redspots_delete");
                        if (QLog.isColorLevel()) {
                            StringBuilder sb8 = new StringBuilder();
                            z65 = z59;
                            sb8.append("service_account_folder_redspots_delete:");
                            sb8.append(this.f403848s);
                            QLog.d("ServiceAccountFolderConfProcessor", 2, sb8.toString());
                        } else {
                            z65 = z59;
                        }
                        z66 = true;
                    } else {
                        z65 = z59;
                        z66 = false;
                    }
                    if (!jSONObject.has("disable_big_data_channel")) {
                        this.f403849t = jSONObject.getBoolean("disable_big_data_channel");
                        if (QLog.isColorLevel()) {
                            StringBuilder sb9 = new StringBuilder();
                            z67 = z66;
                            sb9.append("disable big data channel is ");
                            sb9.append(this.f403849t);
                            QLog.d("ServiceAccountFolderConfProcessor", 2, sb9.toString());
                        } else {
                            z67 = z66;
                        }
                        z68 = true;
                    } else {
                        z67 = z66;
                        z68 = false;
                    }
                    if (!z68 && jSONObject.has("host_white_list")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("host_white_list");
                        z75 = z68;
                        ArrayList<String> arrayList = new ArrayList<>();
                        this.f403850u = arrayList;
                        arrayList.clear();
                        z69 = z57;
                        if (optJSONArray != null) {
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                boolean z97 = z55;
                                this.f403850u.add(optJSONArray.getString(i3));
                                if (QLog.isColorLevel()) {
                                    QLog.d("ServiceAccountFolderConfProcessor", 2, " big data channel white host is " + optJSONArray.getString(i3));
                                }
                                i3++;
                                z55 = z97;
                            }
                        }
                    } else {
                        z69 = z57;
                        z75 = z68;
                    }
                    boolean z98 = z55;
                    if (!jSONObject.has("album_predown_enable")) {
                        this.f403851v = jSONObject.getInt("album_predown_enable");
                        if (QLog.isColorLevel()) {
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadEnable is " + this.f403851v);
                        }
                        z76 = true;
                    } else {
                        z76 = false;
                    }
                    if (!jSONObject.has("album_predown_photo_rule")) {
                        this.f403852w = jSONObject.getInt("album_predown_photo_rule");
                        if (QLog.isColorLevel()) {
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadCoverEnable is " + this.f403852w);
                        }
                        z77 = true;
                    } else {
                        z77 = false;
                    }
                    if (!jSONObject.has("album_predown_slide_photocounts")) {
                        this.f403853x = jSONObject.getInt("album_predown_slide_photocounts");
                        if (QLog.isColorLevel()) {
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadImageEnable is " + this.f403853x);
                        }
                        z78 = true;
                    } else {
                        z78 = false;
                    }
                    if (!jSONObject.has("preload_tool_process")) {
                        this.f403854y = jSONObject.getBoolean("preload_tool_process");
                        if (QLog.isColorLevel()) {
                            StringBuilder sb10 = new StringBuilder();
                            z79 = z78;
                            sb10.append("preload tool progress is ");
                            sb10.append(this.f403854y);
                            QLog.d("ServiceAccountFolderConfProcessor", 2, sb10.toString());
                        } else {
                            z79 = z78;
                        }
                        z85 = true;
                    } else {
                        z79 = z78;
                        z85 = false;
                    }
                    if (!jSONObject.has("useNewLogic")) {
                        str4 = str;
                        z87 = z85;
                        this.f403855z = str4;
                        h(this, jSONObject);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb11 = new StringBuilder();
                            z86 = z77;
                            sb11.append("read in joy preload tool progress config is ");
                            sb11.append(str4);
                            QLog.d("ServiceAccountFolderConfProcessor", 2, sb11.toString());
                        } else {
                            z86 = z77;
                        }
                        z88 = true;
                    } else {
                        str4 = str;
                        z86 = z77;
                        z87 = z85;
                        z88 = false;
                    }
                    if (!jSONObject.has("releaseServiceMinMem")) {
                        this.F = str4;
                        g(this, jSONObject);
                        if (QLog.isColorLevel()) {
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "release web service config is " + str4);
                        }
                        z89 = true;
                    } else {
                        z89 = false;
                    }
                    d();
                    if (!z16 && !z17 && !z18 && !z26 && !z27 && !z28 && !z29 && !z36 && !z47 && !z38 && !z98 && !z69 && !z65 && !z67 && !z75 && !z76 && !z86 && !z79 && !z87 && !z58 && !z88 && !z56 && !z89 && !z46) {
                        z95 = false;
                        this.H = z95;
                    }
                    z95 = true;
                    this.H = z95;
                }
            } else {
                z56 = z49;
            }
            z57 = false;
            if (!jSONObject.has("readInJoy_load_img")) {
            }
            if (!jSONObject.has("service_account_folder_redspots_delete")) {
            }
            if (!jSONObject.has("disable_big_data_channel")) {
            }
            if (!z68) {
            }
            z69 = z57;
            z75 = z68;
            boolean z982 = z55;
            if (!jSONObject.has("album_predown_enable")) {
            }
            if (!jSONObject.has("album_predown_photo_rule")) {
            }
            if (!jSONObject.has("album_predown_slide_photocounts")) {
            }
            if (!jSONObject.has("preload_tool_process")) {
            }
            if (!jSONObject.has("useNewLogic")) {
            }
            if (!jSONObject.has("releaseServiceMinMem")) {
            }
            d();
            if (!z16) {
                z95 = false;
                this.H = z95;
            }
            z95 = true;
            this.H = z95;
        } catch (JSONException e16) {
            QLog.e("ServiceAccountFolderConfProcessor", 1, "handleFlashChatConfig failed", e16);
        }
    }

    public void j() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).updateServiceAccountFolderConfigData((QQAppInterface) runtime);
        }
    }
}
