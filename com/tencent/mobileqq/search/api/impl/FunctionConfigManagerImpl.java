package com.tencent.mobileqq.search.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IFunctionConfigManager;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lo2.m;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rn2.k;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FunctionConfigManagerImpl implements IFunctionConfigManager {
    public static final String CONFIG_CONTENT_URL = "contentUrl";
    public static final int FID_DATA_LINE = 28;
    public static final int FID_HELLO = 44;
    public static final int FID_READ_IN_JOY = 15;
    protected static final String TAG = "search_manager_configFunctionModuleConfigManager";
    private static ArrayList<Integer> studyModeExtract;
    protected Handler mHandler;
    protected boolean mTagEquals;
    public y resultModel;
    public m templateBaseItem;
    public static HashMap<String, List<BusinessGroupWord.c>> busiHotWordListMap = new HashMap<>();
    public static HashMap<String, String> busiClueItemWordMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<lo2.c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(lo2.c cVar, lo2.c cVar2) {
            int[] iArr = cVar2.f415199q0;
            int i3 = iArr[2];
            int[] iArr2 = cVar.f415199q0;
            int i16 = i3 - iArr2[2];
            if (i16 != 0) {
                return i16;
            }
            int i17 = iArr2[0];
            int i18 = i17 - iArr[0];
            if (i18 != 0) {
                return i18;
            }
            String substring = cVar.I.substring(i17 + iArr2[1]);
            String str = cVar2.I;
            int[] iArr3 = cVar2.f415199q0;
            return ChnToSpell.d(substring, 2).compareTo(ChnToSpell.d(str.substring(iArr3[0] + iArr3[1]), 2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Comparator<lo2.c> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(lo2.c cVar, lo2.c cVar2) {
            return ChnToSpell.d(cVar.I, 2).compareTo(ChnToSpell.d(cVar2.I, 2));
        }
    }

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        studyModeExtract = arrayList;
        arrayList.add(10);
        studyModeExtract.add(12);
        studyModeExtract.add(13);
        studyModeExtract.add(14);
        studyModeExtract.add(15);
        studyModeExtract.add(17);
        studyModeExtract.add(18);
        studyModeExtract.add(19);
        studyModeExtract.add(20);
        studyModeExtract.add(22);
        studyModeExtract.add(36);
        studyModeExtract.add(43);
        studyModeExtract.add(46);
        studyModeExtract.add(51);
        studyModeExtract.add(52);
        studyModeExtract.add(53);
        studyModeExtract.add(54);
        studyModeExtract.add(55);
        studyModeExtract.add(56);
        studyModeExtract.add(57);
        studyModeExtract.add(58);
        studyModeExtract.add(64);
        studyModeExtract.add(65);
        studyModeExtract.add(109);
        studyModeExtract.add(121);
    }

    public static String convertGroupMaskToKey(List<Long> list) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().longValue());
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        return sb5.toString();
    }

    private List<c> getFunctionItemList() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFunctionItemList !!! no data,just use local data");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(1, "QQ\u4f1a\u5458", "https://pub.idqqimg.com/pc/misc/files/20170321/a89cb3ba283040058367d36b0a1f5aad.png", "https://h5.vip.qq.com/p/sonic/mc/vipcenterv5?_bid=193&_wvSb=1&asyncMode=3&_wwv=64&_nav_alpha=true&_wwv=4&pay_src=10&platform=1&type=20001&networkInfo=1&status=-1&number=0&path=100400"));
        arrayList.add(new c(2, "QQ\u94b1\u5305", "https://pub.idqqimg.com/pc/misc/files/20170310/e3f2c05439d745c6b39505c757468bcc.png", ""));
        arrayList.add(new c(3, HardCodeUtil.qqStr(R.string.f172035mv2), "https://pub.idqqimg.com/pc/misc/files/20170321/f8b7922d137b4174a32408c2a874d439.png", "https://zb.vip.qq.com/sonic/index?_wv=16778243&asyncMode=3&_wwv=68&_nav_txtclr=ffffff&_nav_titleclr=ffffff&btest=1"));
        arrayList.add(new c(4, HardCodeUtil.qqStr(R.string.mun), "https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", ""));
        arrayList.add(new c(5, HardCodeUtil.qqStr(R.string.mum), "https://pub.idqqimg.com/pc/misc/files/20170310/a601d5f50db940ee9cf8d30e915671ce.png", ""));
        arrayList.add(new c(6, HardCodeUtil.qqStr(R.string.f172036mv4), "https://pub.idqqimg.com/pc/misc/files/20170310/2490d524bbf84417929137e35d93b0c2.png", ""));
        arrayList.add(new c(7, "QQ\u8fbe\u4eba", "https://pub.idqqimg.com/pc/misc/files/20170321/b38bddc6e6a24a1eb5253f6505fb349e.png", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297"));
        arrayList.add(new c(8, HardCodeUtil.qqStr(R.string.muq), "https://pub.idqqimg.com/pc/misc/files/20170310/5765374679c8415894d31ff020f5558a.png", ""));
        arrayList.add(new c(9, "QQ\u7a7a\u95f4", "https://pub.idqqimg.com/pc/misc/files/20170310/5aaef4e89ac540ff9d0e1a4c3f0aee65.png", ""));
        arrayList.add(new c(10, HardCodeUtil.qqStr(R.string.mup), "https://pub.idqqimg.com/pc/misc/files/20170310/c88ccef2e6d44e3f94357ac7cecd04b4.png", ""));
        arrayList.add(new c(11, HardCodeUtil.qqStr(R.string.mv6), "https://pub.idqqimg.com/pc/misc/files/20170310/c83498c5dfd54489af3147b027c091b0.png", "https://cmshow.qq.com/apollo/html/intro.html?_wv=3&adtag=search"));
        arrayList.add(new c(12, HardCodeUtil.qqStr(R.string.mul), "https://pub.idqqimg.com/pc/misc/files/20170310/e8310f3460fa41b487b5922a0df671c5.png", "https://buluo.qq.com/mobile/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&plg_auth=1"));
        arrayList.add(new c(13, HardCodeUtil.qqStr(R.string.f172034mv1), "https://pub.idqqimg.com/pc/misc/files/20170310/ee1b6352ec7340bba07949a15b9adc19.png", "https://m.gamecenter.qq.com/directout/index?st=1489458002385&uin=3043939851&status=-1&number=0&path=489&plat=qq&gamecenter=1&_wv=1031&gc_version=2&ADTAG=neisou&_nav_bgclr=18b4ed&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=255&asyncMode=3&_wwv=64"));
        arrayList.add(new c(14, vc0.a.f441361a, "https://pub.idqqimg.com/pc/misc/files/20170310/6a09f5f91fff46e0ada71ff7b2a667f4.png", ""));
        arrayList.add(new c(15, "QQ\u770b\u70b9", "https://sqimg.qq.com/qq_product_operations/kan/images/QQkandian_symbol.png", ""));
        arrayList.add(new c(16, HardCodeUtil.qqStr(R.string.mvc), "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", "https://wq.jd.com/mcoss/wxmall/home?ptype=4&_wv=67113987&fetchCode=1"));
        arrayList.add(new c(17, HardCodeUtil.qqStr(R.string.mv5), "https://pub.idqqimg.com/pc/misc/files/20170310/cd28b2e8ba7f4d9e98a2d244ced31789.png", ""));
        arrayList.add(new c(18, HardCodeUtil.qqStr(R.string.f172033mv0), "https://pub.idqqimg.com/pc/misc/files/20170310/6727610036b648c3bc3aaa4d0c047ec3.png", ""));
        arrayList.add(new c(19, HardCodeUtil.qqStr(R.string.muu), "https://pub.idqqimg.com/pc/misc/files/20170310/ee8e56925bb646f9b6ae831afcbb0aca.png", "https://y.qq.com/m/mqq/music/index.html?plg_auth=1&plg_dev=1"));
        arrayList.add(new c(20, "NOW\u76f4\u64ad", "https://pub.idqqimg.com/pc/misc/files/20170321/fd790f79230e4776a33c608c9557ae0b.png", "https://now.qq.com/qq/hall.html?_bid=2374&_wv=16778245&from=1"));
        arrayList.add(new c(21, HardCodeUtil.qqStr(R.string.mv7), "https://pub.idqqimg.com/pc/misc/files/20170321/5657f0d4fd6f49858d10bca7451d91a8.png", "https://imgcache.qq.com/zzapp/chwl/prev/html/shop.html?max_age=0&_wv=3"));
        arrayList.add(new c(22, HardCodeUtil.qqStr(R.string.mv9), "https://pub.idqqimg.com/pc/misc/files/20170310/0291fa0854954779a9eeeb9d843f0157.png", "https://tcsh.qq.com/58/html/home.html?_wv=1027&plg_auth=1&plg_dev=1"));
        arrayList.add(new c(23, HardCodeUtil.qqStr(R.string.mur), "https://pub.idqqimg.com/pc/misc/files/20170310/3a4608e81a5e4158a07d92e4ae8a7b7a.png", "https://info.3g.qq.com/g/s?aid=index&g_ut=3&_wv=1&g_f=22580&plg_auth=1&plg_dev=1"));
        arrayList.add(new c(24, HardCodeUtil.qqStr(R.string.mvb), "https://pub.idqqimg.com/pc/misc/files/20170310/35fa7f030fe44507a9732f6d034677e3.png", "https://yundong.qq.com/?_wv=2172899&asyncMode=1&crashFrom=40501"));
        arrayList.add(new c(25, HardCodeUtil.qqStr(R.string.mux), "https://pub.idqqimg.com/pc/misc/files/20170310/26cee3d3d78a4c7e8be121cce7ce1df5.png", "https://m.ke.qq.com/index.html?_bid=167&_wv=5121"));
        arrayList.add(new c(26, HardCodeUtil.qqStr(R.string.muz), "https://pub.idqqimg.com/pc/misc/files/20170321/30e65ca21a2a42529c90a83a46630ce1.png", "https://fudao.qq.com/rn2web/coursebreak.html?_wv=5123&_bid=2356&n_r=1&from=dongtai&plg_auth=1&plg_dev=1"));
        arrayList.add(new c(27, HardCodeUtil.qqStr(R.string.muv), "https://pub.idqqimg.com/pc/misc/files/20170310/f668a11f690c49bc82210b5773e9f27b.png", ""));
        arrayList.add(new c(28, HardCodeUtil.qqStr(R.string.cf5), "https://pub.idqqimg.com/pc/misc/files/20170310/25b9983be4dd4092bf03f6cac00e0095.png", ""));
        arrayList.add(new c(30, HardCodeUtil.qqStr(R.string.muy), "https://pub.idqqimg.com/pc/misc/files/20170321/831513c842904cdda53780b36110478e.png", ""));
        arrayList.add(new c(31, HardCodeUtil.qqStr(R.string.mus), "https://pub.idqqimg.com/pc/misc/files/20170310/9f15b7bd262c42b28a285e3e12a49808.png", ""));
        arrayList.add(new c(32, HardCodeUtil.qqStr(R.string.muw), "https://pub.idqqimg.com/pc/misc/files/20170310/4fedf2b96f4d4acda93fe619d9cb925e.png", ""));
        arrayList.add(new c(33, HardCodeUtil.qqStr(R.string.mv8), "https://pub.idqqimg.com/pc/misc/files/20170321/9cd89480b0284a27a8938318dbc897df.png", ""));
        arrayList.add(new c(35, HardCodeUtil.qqStr(R.string.i59), "https://pub.idqqimg.com/pc/misc/files/20170310/6f2aad7545014d13a230cb237390b567.png", ""));
        arrayList.add(new c(36, HardCodeUtil.qqStr(R.string.mv_), "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", ""));
        arrayList.add(new c(37, HardCodeUtil.qqStr(R.string.a_7), "https://pub.idqqimg.com/pc/misc/files/20170310/5cba92c8405749bbb66d13cd2f42c7b5.png", ""));
        arrayList.add(new c(38, HardCodeUtil.qqStr(R.string.mut), "https://pub.idqqimg.com/pc/misc/files/20170322/3152361128324bfd97776b10c803f73c.png", ""));
        arrayList.add(new c(39, "QQ\u7ea2\u5305", "https://pub.idqqimg.com/pc/misc/files/20170310/96d80f6c7cef4e3aa8d45237cc301295.png", "https://mqq.tenpay.com/mqq/hongbao/index.shtml?_wv=2098179&_wvNb=D12928&f=17&_vacf=qw&_wvNt=FFFFFF&_wvSb=1"));
        arrayList.add(new c(40, HardCodeUtil.qqStr(R.string.f213475qa), "https://pub.idqqimg.com/pc/misc/files/20170510/e74d00a108ba43e8b7e324ad425dc85c.png", ""));
        arrayList.add(new c(41, HardCodeUtil.qqStr(R.string.mva), "https://pub.idqqimg.com/pc/misc/files/20170510/9a58b5bdda80403cb3a2923d8f96f519.png", ""));
        arrayList.add(new c(43, HardCodeUtil.qqStr(R.string.vjb), "https://pub.idqqimg.com/pc/misc/files/20170510/445bcc0024c24add97831ec6e987d5a8.png", ""));
        arrayList.add(new c(44, HardCodeUtil.qqStr(R.string.muo), "https://pub.idqqimg.com/pc/misc/files/20170510/439579e680cc45789586480ff897aad2.png", ""));
        arrayList.add(new c(124, HardCodeUtil.qqStr(R.string.f167902e7), "https://downv6.qq.com/qqface/voice/wecom-temp-da48e008ba02ccf771af4060f4d93cf2.png", "mqqapi://eldermode/elderopen", buildElderModeTag()));
        return arrayList;
    }

    private static tp2.a loadConfig() {
        tp2.a aVar = (tp2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100515");
        if (aVar == null || !aVar.a()) {
            return (tp2.a) am.s().x(190);
        }
        return aVar;
    }

    public static void preLoadConfig(AppInterface appInterface) {
        appInterface.getApp().getSharedPreferences(TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readFile(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + readLine;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedReader = bufferedReader2;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, e.toString());
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                bufferedReader2.close();
            } catch (IOException e19) {
                e = e19;
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public List<String> buildElderModeTag() {
        ArrayList arrayList = new ArrayList(15);
        arrayList.add(HardCodeUtil.qqStr(R.string.f212735ob));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212805oi));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212815oj));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212825ok));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212835ol));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212845om));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212855on));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212865oo));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212875op));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212745oc));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212755od));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212765oe));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212775of));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212785og));
        arrayList.add(HardCodeUtil.qqStr(R.string.f212795oh));
        return arrayList;
    }

    public void checkLocalFunctionListFile(StringBuilder sb5) {
        String str;
        tp2.a loadConfig = loadConfig();
        if (loadConfig == null) {
            str = null;
        } else {
            str = loadConfig.f437064d;
        }
        String configContentUrl = getConfigContentUrl();
        sb5.append(",netFunctionUrl=");
        sb5.append(str);
        sb5.append(",localContentUrl=");
        sb5.append(configContentUrl);
        if (TextUtils.isEmpty(str) || str.equals(configContentUrl)) {
            return;
        }
        getFunctionListFile(str);
    }

    public AppInterface getApp() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public String getConfigContentUrl() {
        return getApp().getApp().getSharedPreferences(TAG, 0).getString(CONFIG_CONTENT_URL, "");
    }

    public void getFunctionListFile(final String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "getFunctionListFile fileUrl isEmpty");
            return;
        }
        if (str.equals(getConfigContentUrl())) {
            QLog.i(TAG, 1, "getFunctionListFile equals");
            return;
        }
        QLog.i(TAG, 1, "getFunctionListFile fileUrl = " + str);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), MsfSdkUtils.insertMtype("GameCenter", str), "GET", null, null);
                    if (openUrlForByte != null) {
                        String readFile = FunctionConfigManagerImpl.this.readFile(openUrlForByte);
                        if (!TextUtils.isEmpty(readFile)) {
                            FunctionConfigManagerImpl.this.saveConfigContent(readFile);
                            FunctionConfigManagerImpl.this.saveConfigContentUrl(str);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.i(FunctionConfigManagerImpl.TAG, 1, "getFunctionListFile", th5);
                }
            }
        }, 8, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public List<y> getModels(String str, int i3) {
        int i16;
        int i17;
        String str2;
        List<c> parseServletConfigContent = parseServletConfigContent();
        if (parseServletConfigContent == null || parseServletConfigContent.size() == 0) {
            parseServletConfigContent = getFunctionItemList();
        }
        List<c> list = parseServletConfigContent;
        boolean z16 = true;
        ArrayList arrayList = new ArrayList(list.size() + 1);
        ArrayList arrayList2 = new ArrayList(list.size() + 1);
        ArrayList arrayList3 = new ArrayList();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        Iterator<c> it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            i16 = R.string.f187533u9;
            i17 = 28;
            str2 = "";
            if (!hasNext) {
                break;
            }
            c next = it.next();
            if (next.f282740a == 28 && h.p((BaseQQAppInterface) getApp())) {
                next.f282741b = getApp().getApp().getString(R.string.f187533u9);
            }
            int[] q06 = SearchUtils.q0(str, next.f282741b, z16);
            if (q06 != null && q06.length >= 3) {
                if (q06[0] > -1 && (next.f282740a != 111 || ((ITempMsgBoxManager) getApp().getRuntimeService(ITempMsgBoxManager.class, "")).msgBoxSwitch())) {
                    if (!studyModeSwitch || !studyModeExtract.contains(Integer.valueOf(next.f282740a))) {
                        if (next.f282740a != 123 || ((IGameMsgManagerService) getApp().getRuntimeService(IGameMsgManagerService.class, "")).isGrayOpen()) {
                            ArrayList arrayList4 = arrayList;
                            ArrayList arrayList5 = arrayList3;
                            List<c> list2 = list;
                            ArrayList arrayList6 = arrayList2;
                            lo2.c cVar = new lo2.c(str, next.f282740a + "", next.f282741b, next.f282742c, next.f282743d, "", VasBusiness.QWALLET, null, i3);
                            cVar.S(7);
                            cVar.f415199q0 = q06;
                            if (next.f282741b.equals(str)) {
                                arrayList6.add(0, cVar);
                            } else {
                                arrayList6.add(cVar);
                            }
                            arrayList2 = arrayList6;
                            arrayList = arrayList4;
                            list = list2;
                            arrayList3 = arrayList5;
                            z16 = true;
                        }
                    }
                }
            }
        }
        ArrayList arrayList7 = arrayList3;
        List<c> list3 = list;
        ArrayList arrayList8 = arrayList;
        boolean z17 = false;
        ArrayList arrayList9 = arrayList2;
        for (c cVar2 : list3) {
            List<String> list4 = cVar2.f282744e;
            if (list4 != null && list4.size() != 0) {
                boolean z18 = z17;
                for (?? r65 = z18; r65 < cVar2.f282744e.size(); r65++) {
                    if (this.mTagEquals) {
                        z18 = str.equals(cVar2.f282744e.get(r65));
                    } else {
                        z18 = str.contains(cVar2.f282744e.get(r65));
                    }
                    if (z18) {
                        break;
                    }
                }
                if (z18) {
                    if (cVar2.f282740a == i17 && h.p((BaseQQAppInterface) getApp())) {
                        cVar2.f282741b = getApp().getApp().getString(i16);
                    }
                    int i18 = cVar2.f282740a;
                    if (!studyModeSwitch || !studyModeExtract.contains(Integer.valueOf(i18))) {
                        arrayList7.add(new lo2.c(str, cVar2.f282740a + str2, cVar2.f282741b, cVar2.f282742c, cVar2.f282743d, "", VasBusiness.QWALLET, null, i3));
                        str2 = str2;
                        i16 = i16;
                        i17 = i17;
                        z17 = false;
                    }
                }
            }
        }
        Collections.sort(arrayList9, new a());
        Collections.sort(arrayList7, new b());
        arrayList8.addAll(arrayList9);
        arrayList8.addAll(arrayList7);
        int size = arrayList8.size();
        for (int i19 = 0; i19 < size; i19++) {
            k.e((y) arrayList8.get(i19), size, i19);
        }
        return arrayList8;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mTagEquals = ((IFeatureRuntimeService) getApp().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("function_search_tag_equals");
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public List<c> parseServletConfigContent() {
        String string = getApp().getApp().getSharedPreferences(TAG, 0).getString("content", "");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder("parseServletConfigContent");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray optJSONArray = new JSONObject(string).optJSONArray("functionList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        int optInt = optJSONObject.optInt(Utils.KEY_BUSINESS_ID);
                        String optString = optJSONObject.optString("name");
                        String optString2 = optJSONObject.optString("headUrl");
                        String optString3 = optJSONObject.optString("androidJumpUrl");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("tag");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                                String optString4 = optJSONArray2.optString(i16);
                                if (!TextUtils.isEmpty(optString4)) {
                                    arrayList2.add(optString4);
                                }
                            }
                        }
                        arrayList.add(new c(optInt, optString, optString2, optString3, arrayList2));
                    }
                }
            } catch (JSONException e16) {
                QLog.i(TAG, 1, "parseServletConfigContent", e16);
                return null;
            }
        } else {
            sb5.append(",configContent null");
        }
        checkLocalFunctionListFile(sb5);
        sb5.append(",items=");
        sb5.append(arrayList.size());
        QLog.i(TAG, 1, sb5.toString());
        return arrayList;
    }

    public void saveConfigContent(String str) {
        SharedPreferences sharedPreferences = getApp().getApp().getSharedPreferences(TAG, 0);
        sharedPreferences.edit().putString("content", str);
        sharedPreferences.edit().commit();
    }

    public void saveConfigContentUrl(String str) {
        SharedPreferences sharedPreferences = getApp().getApp().getSharedPreferences(TAG, 0);
        sharedPreferences.edit().putString(CONFIG_CONTENT_URL, str);
        sharedPreferences.edit().commit();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f282740a;

        /* renamed from: b, reason: collision with root package name */
        public String f282741b;

        /* renamed from: c, reason: collision with root package name */
        public String f282742c;

        /* renamed from: d, reason: collision with root package name */
        public String f282743d;

        /* renamed from: e, reason: collision with root package name */
        public List<String> f282744e;

        public c(int i3, String str, String str2, String str3) {
            this.f282740a = i3;
            this.f282741b = str;
            this.f282742c = str2;
            this.f282743d = str3;
        }

        public c(int i3, String str, String str2, String str3, List<String> list) {
            this.f282740a = i3;
            this.f282741b = str;
            this.f282742c = str2;
            this.f282743d = str3;
            this.f282744e = list;
        }
    }

    public static String convertGroupMaskToKey(long[] jArr) {
        if (jArr == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (long j3 : jArr) {
            sb5.append(j3);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        return sb5.toString();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
