package com.tencent.mobileqq.activity.aio.item;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l {
    public static int A = 0;
    public static int B = 0;
    public static int C = 0;
    public static int D = 0;
    public static int E = 0;
    public static int F = 0;
    public static String G = null;
    public static String H = null;
    public static String I = null;
    public static String J = null;
    public static int K = 0;
    public static int L = 0;
    public static int M = 0;
    private static int N = 0;
    private static int O = 0;
    static ArrayList<Bitmap> P = null;
    private static BitSet Q = null;
    private static final String[] R;
    private static final int[] S;
    public static Bitmap[] T = null;
    public static Bitmap[] U = null;
    public static Bitmap[] V = null;
    public static Bitmap[] W = null;
    public static volatile boolean X = false;
    public static volatile boolean Y = false;
    public static int Z = 0;

    /* renamed from: a, reason: collision with root package name */
    public static String f179480a = "PokeItemHelper";

    /* renamed from: a0, reason: collision with root package name */
    public static boolean f179481a0;

    /* renamed from: b, reason: collision with root package name */
    public static final String f179482b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f179483c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f179484d;

    /* renamed from: e, reason: collision with root package name */
    private static int f179485e;

    /* renamed from: f, reason: collision with root package name */
    private static int f179486f;

    /* renamed from: g, reason: collision with root package name */
    private static int f179487g;

    /* renamed from: h, reason: collision with root package name */
    private static int f179488h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f179489i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f179490j;

    /* renamed from: k, reason: collision with root package name */
    public static int f179491k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f179492l;

    /* renamed from: m, reason: collision with root package name */
    private static String f179493m;

    /* renamed from: n, reason: collision with root package name */
    private static String f179494n;

    /* renamed from: o, reason: collision with root package name */
    private static String f179495o;

    /* renamed from: p, reason: collision with root package name */
    private static String f179496p;

    /* renamed from: q, reason: collision with root package name */
    private static String f179497q;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f179498r;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f179499s;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f179500t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f179501u;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f179502v;

    /* renamed from: w, reason: collision with root package name */
    public static int f179503w;

    /* renamed from: x, reason: collision with root package name */
    public static int f179504x;

    /* renamed from: y, reason: collision with root package name */
    public static int f179505y;

    /* renamed from: z, reason: collision with root package name */
    public static int f179506z;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallBacker f179507a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f179508b;

        a(CallBacker callBacker, String str) {
            this.f179507a = callBacker;
            this.f179508b = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            VasUpdateUtil.vasPokeCallback(this.f179507a, updateListenerParams, this.f179508b);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            VasUpdateUtil.vasPokeCallback(this.f179507a, updateListenerParams, this.f179508b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallBacker f179509a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f179510b;

        b(CallBacker callBacker, String str) {
            this.f179509a = callBacker;
            this.f179510b = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            VasUpdateUtil.vasPokeCallback(this.f179509a, updateListenerParams, this.f179510b);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            VasUpdateUtil.vasPokeCallback(this.f179509a, updateListenerParams, this.f179510b);
        }
    }

    static {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        f179482b = absolutePath;
        String str = absolutePath + "/Tencent/MobileQQ/";
        f179483c = str;
        f179484d = VFSAssistantUtils.getSDKPrivatePath(str);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str + ".vaspoke/");
        f179489i = sDKPrivatePath;
        f179490j = sDKPrivatePath + "vasPokeMarket.json";
        f179491k = -1;
        f179492l = false;
        f179493m = "";
        f179494n = "";
        f179495o = "";
        f179496p = "";
        f179497q = "";
        f179498r = false;
        f179499s = false;
        f179500t = false;
        f179501u = false;
        f179502v = false;
        f179503w = -1;
        f179504x = -1;
        f179505y = 10;
        f179506z = 60;
        A = -1;
        B = -1;
        C = 10;
        D = 60;
        E = 0;
        F = 0;
        K = 0;
        L = 0;
        M = 50;
        N = 0;
        O = 0;
        P = null;
        Q = null;
        R = new String[]{"chuo_icon", "bixin_icon", "zan_icon", "xinsui_icon", "666_icon", "dazhao_icon", "chuo_motion", "bixin_motion", "zan_motion", "xinsui_motion", "666_motion", "dazhao_motion"};
        S = new int[]{22, 22, 22, 22, 22, 22, 35, 99, 25, 60, 0, 0};
        T = new Bitmap[6];
        U = new Bitmap[6];
        V = new Bitmap[6];
        W = new Bitmap[6];
        X = false;
        Y = false;
        Z = 0;
        f179481a0 = true;
    }

    public static void A(QQAppInterface qQAppInterface, boolean z16) {
        if ((z16 && N != 2) || (!z16 && N != 1)) {
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("sp_aio_panel_unique_clicked", true).commit();
            }
            if (z16) {
                N = 2;
            } else {
                N = 1;
            }
        }
    }

    public static boolean B(String str, int i3) {
        String savePath;
        File file;
        String str2;
        String str3 = f179489i;
        com.tencent.mobileqq.activity.photo.album.j.a(str3);
        boolean l3 = l(str);
        QQVasUpdateBusiness f16 = f();
        if (f16 != null) {
            if (!str.endsWith(IAIOPokeApi.VAS_POKE_RES_NORMAL) && !str.endsWith("/pressed.png") && !str.endsWith("effect.gif")) {
                savePath = f16.getSavePath(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + i3);
            } else {
                savePath = f16.getSavePath(VasUpdateConstants.SCID_POKE_PANEL_PREFIX + i3);
            }
            if (l3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(savePath);
                String str4 = File.separator;
                sb5.append(str4);
                sb5.append(str);
                sb5.append(str4);
                sb5.append(str);
                sb5.append(Sticker.JSON_SUFFIX);
                file = new File(sb5.toString());
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(savePath);
                if (str.startsWith("/")) {
                    str2 = "";
                } else {
                    str2 = File.separator;
                }
                sb6.append(str2);
                sb6.append(str);
                file = new File(sb6.toString());
            }
            return file.exists();
        }
        if (l3) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str3);
            sb7.append(i3);
            String str5 = File.separator;
            sb7.append(str5);
            sb7.append(str);
            sb7.append(str5);
            sb7.append(str);
            sb7.append(Sticker.JSON_SUFFIX);
            return new File(sb7.toString()).exists();
        }
        return new File(str3 + i3 + "/" + str).exists();
    }

    private static void a(String str, String str2) {
        String[] list;
        if (QLog.isColorLevel()) {
            QLog.d(f179480a, 2, "[res checking]" + str + str2);
        }
        if (str2.equals("dazhao_motion")) {
            Q.set(11, false);
            return;
        }
        if (str2.equals("666_motion")) {
            Q.set(10, false);
            return;
        }
        for (int i3 = 0; i3 < 12; i3++) {
            if (R[i3].equals(str2)) {
                File file = new File(str + str2);
                if (file.isDirectory() && (list = file.list()) != null && list.length >= S[i3]) {
                    Q.set(i3, true);
                    if (QLog.isColorLevel()) {
                        QLog.d(f179480a, 2, "[res checked]" + str2);
                    }
                }
            }
        }
    }

    public static void b(String str) {
        String[] list;
        if (QLog.isColorLevel()) {
            QLog.d(f179480a, 2, "[all res checking]  dir" + str);
        }
        if (Q == null) {
            BitSet bitSet = new BitSet(12);
            Q = bitSet;
            bitSet.clear();
            Q.set(7);
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            for (String str2 : list) {
                a(str, str2);
            }
        }
    }

    public static void c(AppRuntime appRuntime, CallBacker callBacker) {
        File fileFromLocal;
        IEarlyDownloadService iEarlyDownloadService;
        PokeResHandler pokeResHandler;
        QQVasUpdateBusiness f16 = f();
        if (f16 != null) {
            fileFromLocal = new File(f16.getBusinessItemInfo(21L, VasUpdateConstants.SCID_POKE_EFFECT_LIST).mSavePath);
        } else {
            fileFromLocal = VasUpdateUtil.getFileFromLocal(appRuntime, 21L, VasUpdateConstants.SCID_POKE_EFFECT_LIST, f179490j, true, callBacker);
        }
        if (fileFromLocal != null && (iEarlyDownloadService = (IEarlyDownloadService) appRuntime.getRuntimeService(IEarlyDownloadService.class, "")) != null && (pokeResHandler = (PokeResHandler) iEarlyDownloadService.getEarlyHandler("qq.android.poke.res_0625")) != null && !pokeResHandler.A()) {
            pokeResHandler.M();
            if (QLog.isColorLevel()) {
                QLog.d(f179480a, 2, "vas poke config exists, do not download, set ready");
            }
        }
    }

    private static void d(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            if (!f179498r || !f179493m.equals(account)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
                if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION)) {
                    f179503w = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_BAR_SWITCH, A);
                    f179504x = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_PAD_SWITCH, B);
                    f179506z = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_SEND_TIME_LIMITED, D);
                    f179505y = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_SEND_COUNTS_LIMITED, C);
                    E = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_POKE_ENTRY_TYPE, 0);
                    F = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_VIEW_TYPE, 0);
                    G = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_RES_URL, "");
                    H = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_RES_MD5, "");
                    I = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_SURPRICE_INDEXS, "");
                    J = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_ORDER, "");
                    K = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_INPUT_SWITCH, 0);
                    L = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_FEED_BACK_SWITCH, 0);
                    M = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_BUBBLE_LIMIT_COUNT, 50);
                    f179491k = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_LAST_TAB_INDEX, -1);
                } else {
                    f179503w = A;
                    f179504x = B;
                    E = 0;
                    F = 0;
                    K = 0;
                    L = 0;
                    M = 50;
                }
                f179493m = account;
                f179498r = true;
                if (QLog.isColorLevel()) {
                    QLog.d("pokeMsg", 2, String.format("getPokeSwitch, first init, bar switch: %d, pad switch: %d, uin: %s ,limited count:%d,limited time:%d,peInputSwitch:%d,entryType:%d,viewType:%d", Integer.valueOf(f179503w), Integer.valueOf(f179504x), f179493m, Integer.valueOf(f179505y), Integer.valueOf(f179506z), Integer.valueOf(K), Integer.valueOf(E), Integer.valueOf(F)));
                }
            }
        }
    }

    private static QQVasUpdateBusiness e() {
        try {
            return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 21L);
        } catch (Exception unused) {
            return null;
        }
    }

    public static QQVasUpdateBusiness f() {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(21L).booleanValue()) {
            return e();
        }
        return null;
    }

    public static String g(QQAppInterface qQAppInterface, int i3) {
        d(qQAppInterface);
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        return null;
                    }
                    return J;
                }
                return I;
            }
            return H;
        }
        return G;
    }

    public static int h(QQAppInterface qQAppInterface, int i3) {
        d(qQAppInterface);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            switch (i3) {
                                case 9:
                                    return K;
                                case 10:
                                    return M;
                                case 11:
                                    return F;
                                default:
                                    return -1;
                            }
                        }
                        return E;
                    }
                    return f179506z;
                }
                return f179505y;
            }
            return f179503w;
        }
        return f179504x;
    }

    public static boolean i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(f179480a, 1, "getPokePreDownloadFeatureSwitch appRuntime null");
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "")).isFeatureSwitchEnable("poke_pre_download");
        QLog.d(f179480a, 1, "getPokePreDownloadFeatureSwitch: status: " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    public static String j() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_POKE);
    }

    public static boolean k(QQAppInterface qQAppInterface) {
        if (L == 1) {
            return true;
        }
        return false;
    }

    private static boolean l(String str) {
        if (!"bubble".equals(str) && !ReportConst.ACTION.FULLSCREEN.equals(str) && !"view_aio".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean m(String str) {
        if (!TextUtils.isEmpty(str) && AppSetting.b(str) >= 0) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f179480a, 2, "curr ver: " + AppSetting.f99551k + ", config qqVer:" + str);
            return false;
        }
        return false;
    }

    public static boolean n() {
        String[] split;
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
        if (!TextUtils.isEmpty(featureValue) && (split = featureValue.split("\\|")) != null && split.length >= 7 && !"0".equals(split[6])) {
            return true;
        }
        return false;
    }

    public static int o(String str) throws JSONException {
        return new JSONObject(str).getInt("comboNum");
    }

    public static String p(String str) throws JSONException {
        StringBuilder sb5 = new StringBuilder();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("isShowPanel") == 1) {
            JSONArray jSONArray = jSONObject.getJSONArray("panel_source");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                sb5.append(jSONArray.getInt(i3));
            }
            return sb5.toString();
        }
        return null;
    }

    public static int q(String str) throws JSONException {
        return new JSONObject(str).getInt("TouchFeelingEntrance");
    }

    public static int r(String str) throws JSONException {
        return new JSONObject(str).getInt("IndependentEntrance");
    }

    public static int s(String str) {
        try {
            return new JSONObject(str).getInt("IndependentEntranceType");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f179480a, 2, e16.toString());
            }
            return 0;
        }
    }

    public static ArrayList<ao> t(AppRuntime appRuntime, CallBacker callBacker) {
        ArrayList<ao> arrayList = new ArrayList<>();
        File file = new File(f179490j);
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
                try {
                    if (!jSONObject.optBoolean("lottieEnable", true)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f179480a, 2, "lottie disable");
                        }
                        return arrayList;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
                    int i3 = 0;
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i16);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("name");
                        int optInt = jSONObject2.optInt(VipFunCallConstants.KEY_FEET_TYPE, i3);
                        int optInt2 = jSONObject2.optInt("status", i3);
                        int optInt3 = jSONObject2.optInt(ViewStickEventHelper.IS_SHOW, i3);
                        String optString3 = jSONObject2.optString("minVersion");
                        if (!m(optString3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(f179480a, 2, "curr ver: " + AppSetting.f99551k + ", config qqVer:" + optString3);
                            }
                        } else if (optInt2 == 1 && optInt3 == 1) {
                            ao aoVar = new ao();
                            aoVar.f178216a = 126;
                            aoVar.f178218c = Integer.parseInt(optString);
                            aoVar.f178219d = optString2;
                            aoVar.f178221f = optInt;
                            aoVar.f178220e = optString2;
                            aoVar.f178224i = optString3;
                            IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "");
                            if (!B("effect.gif", aoVar.f178218c)) {
                                aoVar.f178223h = true;
                                String str = VasUpdateConstants.SCID_POKE_PANEL_PREFIX + aoVar.f178218c;
                                QQVasUpdateBusiness f16 = f();
                                if (f16 != null) {
                                    f16.addDownLoadListener(str, new a(callBacker, str));
                                    f16.startDownload(str);
                                } else {
                                    iVasQuickUpdateService.downloadItem(21L, str, "parseVasPokeConfig");
                                    iVasQuickUpdateService.addCallBacker(callBacker);
                                }
                            }
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            obtain.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
                            obtain.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
                            obtain.mPlayGifImage = true;
                            obtain.mGifRoundCorner = 0.0f;
                            aoVar.f178217b = URLDrawable.getDrawable(new File(f179489i + aoVar.f178218c + "/effect.gif"), obtain);
                            if (QLog.isColorLevel()) {
                                QLog.i(f179480a, 2, "name: " + aoVar.f178219d + " resId: " + aoVar.f178218c + " feeType: " + aoVar.f178221f);
                            }
                            arrayList.add(aoVar);
                            if (!B("bubble", aoVar.f178218c)) {
                                aoVar.f178222g = true;
                                if (com.tencent.mobileqq.core.util.a.j()) {
                                    String str2 = VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + aoVar.f178218c;
                                    QQVasUpdateBusiness f17 = f();
                                    if (f17 != null) {
                                        f17.addDownLoadListener(str2, new b(callBacker, str2));
                                        f17.startDownload(str2);
                                    } else {
                                        iVasQuickUpdateService.downloadItem(21L, str2, "parseVasPokeConfig");
                                        iVasQuickUpdateService.addCallBacker(callBacker);
                                    }
                                }
                                i3 = 0;
                            } else {
                                i3 = 0;
                                aoVar.f178222g = false;
                            }
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("PokeItemHelper", 1, "parse json config fail", e16);
                }
            } catch (Throwable th5) {
                QLog.e(f179480a, 1, "getJsonOOM,json_name:vasPoke", th5);
            }
        } else {
            c(appRuntime, callBacker);
        }
        return arrayList;
    }

    public static void u(QQAppInterface qQAppInterface) {
        if (i()) {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("IS_POKE_RES_NEED_PRE_DOWNLOAD", true);
        } else {
            ((PokeBigResHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER)).Q2(true);
        }
    }

    public static void v(int i3) {
        f179502v = true;
        f179488h = i3;
    }

    public static void w(QQAppInterface qQAppInterface, boolean z16) {
        if ((z16 && O != 2) || (!z16 && O != 1)) {
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("sp_aio_panel_poke_clicked", true).commit();
            }
            if (z16) {
                O = 2;
            } else {
                O = 1;
            }
        }
    }

    public static void x(int i3, int i16, int i17, int i18) {
        f179498r = true;
        f179503w = i3;
        f179504x = i16;
        f179505y = i17;
        f179506z = i18;
    }

    public static void y(int i3) {
        f179501u = true;
        f179487g = i3;
    }

    public static void z(int i3, int i16) {
        f179500t = true;
        f179485e = i3;
        f179486f = i16;
    }
}
