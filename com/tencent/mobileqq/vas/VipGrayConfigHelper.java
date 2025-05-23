package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipGrayConfigHelper {
    private static final String BUSINESS_BACKGROUNG_WEBVIEW = "backgroundWebView";
    private static final String BUSINESS_IPSITE = "ipStackConfigDic";
    private static final String BUSINESS_VIP_ENTER_WORD = "vipEnterText";
    private static final String BUSINESS_VIP_KING_NAMEPLATE = "gameIcon";
    private static final String KEY_CONFIG = "vipGrayConfig";
    public static final String NAMEPLATE_OF_KING_DEFAULT_URL = "https://imgcache.gtimg.cn/club/mqgame/";
    public static final String TAG = "VipGrayConfigHelper";
    private static VipGrayConfigHelper sInstance;
    private static final AtomicInteger S_CURRENT_ENTRY_INDEX = new AtomicInteger(0);
    private static final Map<String, AtomicInteger> S_LAUNCH_COUNTER_MAP = new HashMap();
    private static final Map<String, AtomicInteger> S_MAX_LAUNCH_COUNTER_MAP = new HashMap();
    private static final Map<String, AtomicReference<Intent>> S_INTENT_REF_MAP = new HashMap();
    private static final Map<String, AtomicLong> S_DELAY_MILLIS_MAP = new HashMap();
    private static final List<String> S_ENTRY_ID_LIST = new ArrayList();
    private static final Runnable S_JOB = new Runnable() { // from class: com.tencent.mobileqq.vas.VipGrayConfigHelper.1
        @Override // java.lang.Runnable
        public void run() {
            AtomicReference atomicReference;
            int i3 = VipGrayConfigHelper.S_CURRENT_ENTRY_INDEX.get();
            if (i3 >= 0 && i3 < VipGrayConfigHelper.S_ENTRY_ID_LIST.size()) {
                String str = (String) VipGrayConfigHelper.S_ENTRY_ID_LIST.get(i3);
                AtomicInteger atomicInteger = (AtomicInteger) VipGrayConfigHelper.S_LAUNCH_COUNTER_MAP.get(str);
                AtomicInteger atomicInteger2 = (AtomicInteger) VipGrayConfigHelper.S_MAX_LAUNCH_COUNTER_MAP.get(str);
                Object obj = VipGrayConfigHelper.S_INTENT_REF_MAP.get(str);
                while (true) {
                    atomicReference = (AtomicReference) obj;
                    if (atomicInteger.get() < atomicInteger2.get() || (i3 = i3 + 1) >= VipGrayConfigHelper.S_ENTRY_ID_LIST.size()) {
                        break;
                    }
                    str = (String) VipGrayConfigHelper.S_ENTRY_ID_LIST.get(i3);
                    atomicInteger = (AtomicInteger) VipGrayConfigHelper.S_LAUNCH_COUNTER_MAP.get(str);
                    atomicInteger2 = (AtomicInteger) VipGrayConfigHelper.S_MAX_LAUNCH_COUNTER_MAP.get(str);
                    obj = VipGrayConfigHelper.S_INTENT_REF_MAP.get(str);
                }
                VipGrayConfigHelper.S_CURRENT_ENTRY_INDEX.set(i3);
                if (i3 >= VipGrayConfigHelper.S_ENTRY_ID_LIST.size()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(VipGrayConfigHelper.TAG, 2, "Entry: " + str + ", Case " + (atomicInteger.get() + 1) + " of " + atomicInteger2.get());
                }
                try {
                    Intent intent = (Intent) atomicReference.get();
                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                    BaseApplication.getContext().startActivity(intent);
                    atomicInteger.incrementAndGet();
                    VipMMKV.getVipGray(BaseApplication.getContext()).edit().putInt(str, atomicInteger.get()).apply();
                } catch (Exception unused) {
                }
                if (QLog.isColorLevel()) {
                    QLog.d(VipGrayConfigHelper.TAG, 2, "start background webview.");
                }
            }
        }
    };
    public String notVipStr = "";
    public String vipStr = "";
    public String outDateVipStr = "";
    public String svipStr = "";
    public String namePlateOfKingUrl = NAMEPLATE_OF_KING_DEFAULT_URL;
    private int namePlateOfKingExpireDay = 1;
    private volatile boolean isParsed = false;
    private List<WeakReference<VipGrayConfigListener>> listenerList = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface VipGrayConfigListener {
        void jsonParseOver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f307884d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGameCardManager.a f307885e;

        b(URLImageView uRLImageView, IGameCardManager.a aVar) {
            this.f307884d = uRLImageView;
            this.f307885e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IGameCardManager gameCardManager = VasUtil.getService().getGameCardManager();
            Context context = this.f307884d.getContext();
            IGameCardManager.a aVar = this.f307885e;
            gameCardManager.gotoGameIconSetWeb(context, aVar.f312734b, aVar.f312737e, aVar.f312738f);
            if (gameCardManager.isSelf(this.f307885e.f312734b)) {
                str = "owner";
            } else {
                str = IGameCardManager.VISITOR;
            }
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(this.f307885e.f312738f), "4", SearchConstants.PLATFORM, this.f307885e.f312733a, str, 102, 1, System.currentTimeMillis());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void a(boolean z16);
    }

    VipGrayConfigHelper() {
        parseJson(MobileQQ.sMobileQQ.peekAppRuntime());
    }

    private void clearOriginalData() {
        this.notVipStr = "";
        this.vipStr = "";
        this.outDateVipStr = "";
        this.svipStr = "";
        this.namePlateOfKingUrl = NAMEPLATE_OF_KING_DEFAULT_URL;
        this.namePlateOfKingExpireDay = 1;
    }

    @Nullable
    private Intent getWebviewIntent(AppRuntime appRuntime, String str, String str2) {
        if ("qqcomic".equals(str)) {
            return ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).getBackgroundQQComicIntent(appRuntime);
        }
        if (!TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.putExtra("url", str2);
            return intent;
        }
        return null;
    }

    public static VipGrayConfigHelper getsInstance() {
        if (sInstance == null) {
            sInstance = new VipGrayConfigHelper();
        }
        return sInstance;
    }

    private boolean isLegal(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        if (z19) {
            if (z26 && (z18 || z17)) {
                return true;
            }
        } else if (z26 && z16) {
            return true;
        }
        return false;
    }

    private boolean isUinVaild(JSONObject jSONObject, String str, int i3, int i16) {
        if (i3 >= i16) {
            int length = str.length();
            if (length >= i3 && length >= i16) {
                long parseLong = Long.parseLong(str.substring(length - i3, (length - i16) + 1));
                long optLong = jSONObject.optLong(Element.ELEMENT_NAME_MIN);
                long optLong2 = jSONObject.optLong("max");
                if (parseLong >= optLong && parseLong <= optLong2) {
                    return true;
                }
                return false;
            }
            QLog.e(TAG, 1, "parseJson, index config error, uin length=" + length + ", config=" + jSONObject.toString());
            return false;
        }
        QLog.e(TAG, 1, "parseJson, startIndex < endIndex, element=" + jSONObject);
        return false;
    }

    private boolean isValidVersion(JSONObject jSONObject) throws JSONException {
        boolean z16;
        String string;
        if (jSONObject.has("minVersion")) {
            String string2 = jSONObject.getString("minVersion");
            if (!TextUtils.isEmpty(string2) && !IndividuationConfigInfo.isLaterVersion(string2, AppSetting.f99554n)) {
                z16 = false;
                if (z16 && jSONObject.has("maxVersion")) {
                    string = jSONObject.getString("maxVersion");
                    if (!TextUtils.isEmpty(string) && !IndividuationConfigInfo.isLaterVersion(AppSetting.f99554n, string)) {
                        return false;
                    }
                }
                return z16;
            }
        }
        z16 = true;
        if (z16) {
            string = jSONObject.getString("maxVersion");
            if (!TextUtils.isEmpty(string)) {
                return false;
            }
        }
        return z16;
    }

    public static void launchBackgroundWebView() {
        int i3 = S_CURRENT_ENTRY_INDEX.get();
        if (i3 >= 0) {
            List<String> list = S_ENTRY_ID_LIST;
            if (i3 < list.size()) {
                AtomicLong atomicLong = S_DELAY_MILLIS_MAP.get(list.get(i3));
                if (atomicLong != null) {
                    MqqHandler subThreadHandler = ThreadManager.getSubThreadHandler();
                    Runnable runnable = S_JOB;
                    subThreadHandler.removeCallbacks(runnable);
                    ThreadManager.getSubThreadHandler().postDelayed(runnable, atomicLong.get());
                }
            }
        }
    }

    private synchronized void notifyListener() {
        int size = this.listenerList.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                VipGrayConfigListener vipGrayConfigListener = this.listenerList.get(i3).get();
                if (vipGrayConfigListener != null) {
                    vipGrayConfigListener.jsonParseOver();
                }
            }
        }
    }

    private void parseConfigList(AppRuntime appRuntime, JSONArray jSONArray, boolean z16, SharedPreferences sharedPreferences) {
        try {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("business");
                if (BUSINESS_VIP_ENTER_WORD.equals(optString)) {
                    parseVipEntryConfig(appRuntime, jSONObject);
                } else if (BUSINESS_BACKGROUNG_WEBVIEW.equals(optString) && z16) {
                    parseWebviewConfig(appRuntime, sharedPreferences, jSONObject);
                } else if (BUSINESS_VIP_KING_NAMEPLATE.equals(optString)) {
                    wangzheConfig(appRuntime, jSONObject);
                } else if (BUSINESS_IPSITE.equals(optString) && isConfigValid(appRuntime, jSONObject)) {
                    long optLong = jSONObject.optLong("ipStackTimeInterval");
                    ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).updateDisPlayInteval(optLong);
                    QLog.d(TAG, 2, "ipsite interval = " + optLong);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseVipGrayConfig exception", e16);
        }
    }

    private void parseVipEntryConfig(AppRuntime appRuntime, JSONObject jSONObject) {
        if (isConfigValid(appRuntime, jSONObject)) {
            this.notVipStr = jSONObject.optString("notVip");
            this.outDateVipStr = jSONObject.optString("outdatedVip");
            this.vipStr = jSONObject.optString("vip");
            this.svipStr = jSONObject.optString("svip");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parse vipEnterText notvip = " + this.notVipStr + ", outdatevip = " + this.outDateVipStr + ", vipstr= " + this.vipStr + ", svip = " + this.svipStr);
            }
        }
    }

    private void parseVipGrayConfig(AppRuntime appRuntime, JSONArray jSONArray, boolean z16) {
        if (appRuntime != null && jSONArray != null && jSONArray.length() >= 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseVipGrayConfig begin config = " + jSONArray.toString());
            }
            SharedPreferences vipGray = VipMMKV.getVipGray(BaseApplication.getContext());
            if (z16) {
                S_ENTRY_ID_LIST.clear();
                S_LAUNCH_COUNTER_MAP.clear();
                S_MAX_LAUNCH_COUNTER_MAP.clear();
                S_DELAY_MILLIS_MAP.clear();
                S_INTENT_REF_MAP.clear();
                vipGray.edit().clear().apply();
            } else if (S_ENTRY_ID_LIST.isEmpty()) {
                z16 = true;
            }
            if (z16) {
                S_CURRENT_ENTRY_INDEX.set(0);
            }
            parseConfigList(appRuntime, jSONArray, z16, vipGray);
            launchBackgroundWebView();
            return;
        }
        QLog.e(TAG, 1, "parseVipGrayConfig app = null or configList = null or len < 0");
    }

    private boolean parseWebviewConfig(AppRuntime appRuntime, SharedPreferences sharedPreferences, JSONObject jSONObject) {
        return false;
    }

    private void wangzheConfig(AppRuntime appRuntime, JSONObject jSONObject) {
        if (isConfigValid(appRuntime, jSONObject)) {
            this.namePlateOfKingUrl = jSONObject.optString("baseUrl", "");
            this.namePlateOfKingExpireDay = jSONObject.optInt("expireDay", 0);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "king info, url = " + this.namePlateOfKingUrl + ",expireDay = " + this.namePlateOfKingExpireDay);
            }
        }
    }

    public String getNamePlateOfKingUrl(String str, long j3, int i3, boolean z16, boolean z17) {
        StringBuilder sb5;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getNamePlateOfKingUrl, gameAppId = " + j3 + " dan = " + i3 + " danSwitch = " + z16 + " isSetting = " + z17);
        }
        AppRuntime app = VasUtil.getApp();
        boolean z18 = (TextUtils.isEmpty(this.namePlateOfKingUrl) || j3 == 0) ? false : true;
        SharedPreferences sharedPreferences = app.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0);
        boolean z19 = !TextUtils.isEmpty(str) && app.getCurrentUin().equals(str);
        boolean z26 = sharedPreferences.getBoolean("plate_of_king_display_switch_" + app.getCurrentUin(), true);
        if (isLegal(z16, z17, z26, z19, z18)) {
            if (i3 == 0) {
                sb5 = new StringBuilder();
                sb5.append(this.namePlateOfKingUrl);
                sb5.append(j3);
            } else {
                sb5 = new StringBuilder();
                sb5.append(this.namePlateOfKingUrl);
                sb5.append(j3);
                sb5.append("_");
                sb5.append(i3);
            }
            sb5.append(".png");
            return sb5.toString();
        }
        QLog.e(TAG, 1, "getNamePlateOfKingUrl namePlateOfKingUrl = null gameAppId= " + j3 + " dan= " + i3 + " danSwitch= " + z16 + " localSwitch = " + z26);
        return null;
    }

    public boolean isConfigValid(AppRuntime appRuntime, JSONObject jSONObject) {
        boolean z16 = false;
        if (appRuntime != null && jSONObject != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isConfigValid config = " + jSONObject.toString());
            }
            try {
                int optInt = jSONObject.optInt(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
                if ((optInt == 0 || optInt == 2) && isValidVersion(jSONObject)) {
                    z16 = isUinVaild(jSONObject, appRuntime.getAccount(), jSONObject.optInt("startIndex"), jSONObject.optInt("endIndex"));
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "isConfigValid exception", e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isConfigValid valid = " + z16);
            }
            return z16;
        }
        QLog.e(TAG, 1, "isConfigValid app = null || config = null");
        return false;
    }

    public void parseJson(AppRuntime appRuntime) {
        parseJson(appRuntime, false);
    }

    public synchronized void registerListener(VipGrayConfigListener vipGrayConfigListener) {
        for (int i3 = 0; i3 < this.listenerList.size(); i3++) {
            if (this.listenerList.get(i3).get() == vipGrayConfigListener) {
                return;
            }
        }
        if (vipGrayConfigListener != null) {
            this.listenerList.add(new WeakReference<>(vipGrayConfigListener));
        }
    }

    public void showGameCardIcon(URLImageView uRLImageView, IGameCardManager.a aVar) {
        String str;
        if (uRLImageView == null) {
            return;
        }
        uRLImageView.setVisibility(0);
        try {
            if (VasUtil.getService().getGameCardManager().isSelf(aVar.f312734b)) {
                str = "owner";
            } else {
                str = IGameCardManager.VISITOR;
            }
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(aVar.f312738f), "4", SearchConstants.PLATFORM, aVar.f312733a, str, 101, 1, System.currentTimeMillis());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "new_game_card list_error:" + e16.getMessage());
        }
    }

    public boolean showNamePlateOfKing(String str, boolean z16, long j3, boolean z17, int i3) {
        if (!z17 && i3 > 0) {
            return true;
        }
        if (!z16) {
            return false;
        }
        if (((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(str).isWzryVip()) {
            return true;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(serverTime * 1000);
        int i16 = calendar.get(6);
        calendar.setTimeInMillis(j3 * 1000);
        if (i16 - calendar.get(6) <= this.namePlateOfKingExpireDay) {
            return true;
        }
        return false;
    }

    public synchronized void unRegisterListener(VipGrayConfigListener vipGrayConfigListener) {
        WeakReference<VipGrayConfigListener> weakReference;
        int i3 = 0;
        while (true) {
            if (i3 < this.listenerList.size()) {
                if (this.listenerList.get(i3).get() == vipGrayConfigListener) {
                    weakReference = this.listenerList.get(i3);
                    break;
                }
                i3++;
            } else {
                weakReference = null;
                break;
            }
        }
        if (weakReference != null) {
            this.listenerList.remove(weakReference);
        }
    }

    public void updateNamePlateOfKingIconView(URLImageView uRLImageView, boolean z16, long j3, IGameCardManager.a aVar) {
        updateNamePlateOfKingIconView(uRLImageView, z16, j3, aVar, null);
    }

    public void parseJson(AppRuntime appRuntime, boolean z16) {
        JSONObject jSONFromLocal;
        if (appRuntime == null) {
            QLog.e(TAG, 1, "parsejson error, app = null");
            return;
        }
        if (z16) {
            this.isParsed = false;
        }
        if (this.isParsed) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parsejson, begin");
        }
        clearOriginalData();
        try {
            jSONFromLocal = VasUpdateUtil.getJSONFromLocal(appRuntime, VasUpdateConstants.SCID_PERSONAL_CONFIG, true, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseJson exception", e16);
        }
        if (jSONFromLocal == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parsejson file not exists");
            }
        } else {
            JSONArray optJSONArray = jSONFromLocal.optJSONArray(KEY_CONFIG);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                parseVipGrayConfig(appRuntime, optJSONArray, z16);
            } else {
                QLog.e(TAG, 1, "parsejson configList = null or len < 0");
            }
            notifyListener();
        }
    }

    public void updateNamePlateOfKingIconView(URLImageView uRLImageView, boolean z16, long j3, IGameCardManager.a aVar, c cVar) {
        if (uRLImageView == null || aVar == null) {
            return;
        }
        uRLImageView.setVisibility(8);
        uRLImageView.setOnClickListener(null);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "showNamePlateOfKing, new_game_card , isSuperVip=" + z16 + ", lastLoginTime=" + j3 + ", info=" + aVar);
        }
        if (showNamePlateOfKing(aVar.f312734b, z16, j3, aVar.f312737e, aVar.f312738f)) {
            URLDrawable gameCardDrawable = VasUtil.getService().getGameCardManager().getGameCardDrawable(false, aVar, new a(uRLImageView, aVar, cVar));
            uRLImageView.setOnClickListener(new b(uRLImageView, aVar));
            uRLImageView.setBackgroundDrawable(gameCardDrawable);
        }
    }

    public String getNamePlateOfKingUrl(String str, long j3, int i3, boolean z16) {
        return getNamePlateOfKingUrl(str, j3, i3, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IGameCardManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLImageView f307880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGameCardManager.a f307881b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f307882c;

        a(URLImageView uRLImageView, IGameCardManager.a aVar, c cVar) {
            this.f307880a = uRLImageView;
            this.f307881b = aVar;
            this.f307882c = cVar;
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void a(URLDrawable uRLDrawable) {
            URLImageView uRLImageView = this.f307880a;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(8);
            }
            c cVar = this.f307882c;
            if (cVar != null) {
                cVar.a(false);
            }
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void c(URLDrawable uRLDrawable) {
            VipGrayConfigHelper.this.showGameCardIcon(this.f307880a, this.f307881b);
            c cVar = this.f307882c;
            if (cVar != null) {
                cVar.a(true);
            }
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void d(URLDrawable uRLDrawable) {
            uRLDrawable.restartDownload();
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void b(URLDrawable uRLDrawable) {
        }
    }
}
