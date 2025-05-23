package com.tencent.mobileqq.troop.utils.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.tipsbar.TroopSecurityTipsBanner;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopapps.m;
import com.tencent.mobileqq.troop.utils.ab;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.troop.utils.f;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.report.TroopFeatureReport;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import okhttp3.internal.connection.RealConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopUtilsApiImpl implements ITroopUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final int CMD_0X88D_SERVICE_TYPE_14 = 14;
    public static final String TAG = "TroopUtilsApiImpl";
    private final String domain;
    private final String[] domainArray;
    public int mExposureSource;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f302060a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f302061b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f302062c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ StringBuilder f302063d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f302064e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f302065f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e.a f302066g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f302067h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f302068i;

        a(Bundle bundle, String str, String str2, StringBuilder sb5, String str3, Context context, e.a aVar, int i3, Bundle bundle2) {
            this.f302060a = bundle;
            this.f302061b = str;
            this.f302062c = str2;
            this.f302063d = sb5;
            this.f302064e = str3;
            this.f302065f = context;
            this.f302066g = aVar;
            this.f302067h = i3;
            this.f302068i = bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopUtilsApiImpl.this, bundle, str, str2, sb5, str3, context, aVar, Integer.valueOf(i3), bundle2);
            }
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.e(TroopUtilsApiImpl.TAG, 1, "fail to get pskey, domain = connect.qq.com errMsg: " + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            String str = map.get("connect.qq.com");
            this.f302060a.putString("Referer", "https://cgi.connect.qq.com/");
            this.f302060a.putString("Cookie", "p_skey=" + str + ";p_uin=" + this.f302061b + ";uin=" + this.f302062c);
            this.f302063d.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            StringBuilder sb5 = this.f302063d;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("appid=");
            sb6.append(this.f302064e);
            sb5.append(sb6.toString());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("BUNDLE", this.f302060a);
            hashMap.put("CONTEXT", this.f302065f);
            if (QLog.isColorLevel()) {
                QLog.i(TroopUtilsApiImpl.TAG, 2, "checkApiState params = " + this.f302060a);
            }
            new f(this.f302063d.toString(), "GET", this.f302066g, this.f302067h, this.f302068i).b(hashMap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f302070a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f302071b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f302072c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e.a f302073d;

        b(AppRuntime appRuntime, Context context, Intent intent, e.a aVar) {
            this.f302070a = appRuntime;
            this.f302071b = context;
            this.f302072c = intent;
            this.f302073d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopUtilsApiImpl.this, appRuntime, context, intent, aVar);
            }
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.e(TroopUtilsApiImpl.TAG, 1, "joinGroupOneStep fail to get pskey, domain = connect.qq.com errMsg: " + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            } else {
                TroopUtilsApiImpl.this.joinGroupOneStepWithPSkey(this.f302070a, this.f302071b, this.f302072c, this.f302073d, map.get("connect.qq.com"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f302075a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65175);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupMsgMask.values().length];
            f302075a = iArr;
            try {
                iArr[GroupMsgMask.NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f302075a[GroupMsgMask.RECEIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f302075a[GroupMsgMask.ASSISTANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f302075a[GroupMsgMask.SHIELD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TroopUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.domain = "connect.qq.com";
            this.domainArray = new String[]{"connect.qq.com"};
        }
    }

    private static char hexDigit(int i3) {
        int i16;
        int i17 = i3 & 15;
        if (i17 < 10) {
            i16 = i17 + 48;
        } else {
            i16 = (i17 - 10) + 97;
        }
        return (char) i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0113, code lost:
    
        if (r27 == 10002) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void calJoinTroop(String str, int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 6;
        int i27 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        if (i3 == 19) {
            ReportController.o(null, "P_CliOper", "Grp_nearby", "", QCircleDaTongConstant.ElementParamValue.RECOM, "Clk_joingrp", 0, 0, str, "", "", "");
            return;
        }
        if (i3 == 18) {
            ReportController.o(null, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, str, "", "", "");
            return;
        }
        if (i3 == 24) {
            ReportController.o(null, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
            return;
        }
        if (i3 == 17) {
            ReportController.o(null, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, str, "", "", "");
            return;
        }
        int i28 = 10;
        if (i3 != 10) {
            i27 = 11;
            if (i3 == 11) {
                i26 = 2;
            } else if (i3 == 15) {
                i26 = 0;
            } else if (i3 != 34) {
                if (i3 != 20) {
                    i26 = i3 != 21 ? -1 : 7;
                }
            }
            if (i26 == -1) {
                if (i16 == 7) {
                    i28 = 3;
                } else if (i16 == 8) {
                    i28 = 4;
                }
                int i29 = i28;
                ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i29, 0, str, i17 + "", "" + TroopInfoData.getStatOption(i16, i3), i18 + "");
                ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", i29, 0, str, i17 + "", i19 + "", "");
            }
            i28 = i26;
            int i292 = i28;
            ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i292, 0, str, i17 + "", "" + TroopInfoData.getStatOption(i16, i3), i18 + "");
            ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", i292, 0, str, i17 + "", i19 + "", "");
        }
        i26 = i27;
        if (i26 == -1) {
        }
        i28 = i26;
        int i2922 = i28;
        ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i2922, 0, str, i17 + "", "" + TroopInfoData.getStatOption(i16, i3), i18 + "");
        ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", i2922, 0, str, i17 + "", i19 + "", "");
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void checkApiState(AppRuntime appRuntime, Context context, String str, e.a aVar, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, context, str, aVar, Integer.valueOf(i3), bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.mobileqq.troop.utils.api.a.f302051a);
        String account = appRuntime.getAccount();
        ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(this.domainArray, new a(bundle2, account, account, sb5, str, context, aVar, i3, bundle));
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean checkIsShowCacheAppInfos(AppRuntime appRuntime, String str, ArrayList<TroopAppInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, appRuntime, str, arrayList)).booleanValue();
        }
        ITroopAppService iTroopAppService = (ITroopAppService) appRuntime.getRuntimeService(ITroopAppService.class, "all");
        ArrayList<TroopAppInfo> troopCardAppInfosCache = iTroopAppService.getTroopCardAppInfosCache(iTroopAppService.getTroopCardAppIdListCache(str));
        if (troopCardAppInfosCache != null && troopCardAppInfosCache.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public String constructParams(Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this, (Object) bundle, (Object) bundle2);
        }
        if (bundle == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject3.put(str, wrap(bundle.get(str)));
            }
            jSONObject2.put("param", jSONObject3);
            if (bundle2 != null) {
                for (String str2 : bundle2.keySet()) {
                    jSONObject2.put(str2, wrap(bundle2.get(str2)));
                }
            }
            jSONObject.put("key", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public long convertQQFullVersion2Long(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Long) iPatchRedirector.redirect((short) 45, (Object) this, (Object) str)).longValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = 0;
        }
        int i16 = 0;
        boolean z16 = false;
        for (int i17 = 0; i17 < str.length(); i17++) {
            char charAt = str.charAt(i17);
            if (charAt >= '0' && charAt <= '9') {
                iArr[i16] = (iArr[i16] * 10) + (charAt - '0');
                z16 = true;
            } else {
                if (z16 && (i16 == 3 || charAt == '.')) {
                    i16++;
                    if (i16 >= 4) {
                        break;
                    }
                } else if (z16) {
                    iArr[i16] = 0;
                }
                z16 = false;
            }
        }
        long j3 = (iArr[3] % 10000) + ((iArr[2] % 1000) * 10000) + ((iArr[1] % 1000) * 10000000) + ((iArr[0] % 1000) * RealConnection.IDLE_CONNECTION_HEALTHY_NS);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("convertQQFullVersion2Long [%s, %s]", Long.valueOf(j3), str));
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public dt2.c createAndShowCapsuleDialog(Context context, String str, AppDetail appDetail, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (dt2.c) iPatchRedirector.redirect((short) 51, this, context, str, appDetail, bool);
        }
        m mVar = new m(context, str, appDetail, bool.booleanValue());
        mVar.show();
        return mVar;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public EntryModel createEntryModel(TroopInfo troopInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (EntryModel) iPatchRedirector.redirect((short) 38, (Object) this, (Object) troopInfo, (Object) str);
        }
        if (troopInfo == null) {
            return null;
        }
        EntryModel entryModel = new EntryModel(1, Long.parseLong(troopInfo.troopuin), troopInfo.troopname, troopInfo.isOwnerOrAdmin());
        entryModel.reportData = "groupid=" + str;
        entryModel.dwGroupClassExt = troopInfo.dwGroupClassExt;
        QLog.d(TAG, 1, "EntryModel uin:" + entryModel.uin + " dwGroupClassExt:" + entryModel.dwGroupClassExt + " isAdmin: " + entryModel.isAdmin);
        return entryModel;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int dp2px(float f16, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, this, Float.valueOf(f16), resources)).intValue();
        }
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public String encrypt(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (String) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(getBytesUTF8(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb5 = new StringBuilder();
                for (byte b16 : digest) {
                    sb5.append(hexDigit(b16 >>> 4));
                    sb5.append(hexDigit(b16));
                }
                return sb5.toString();
            }
            return str;
        } catch (NoSuchAlgorithmException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "encrypt has exception: " + e16.getMessage());
                return str;
            }
            return str;
        }
    }

    public byte[] getBytesUTF8(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (byte[]) iPatchRedirector.redirect((short) 53, (Object) this, (Object) str);
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public String getDateString(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) ? j3 > 0 ? new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(Long.valueOf(j3 * 1000)) : "" : (String) iPatchRedirector.redirect((short) 40, (Object) this, j3);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getExposureSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mExposureSource;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getExposureSourceReportVal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getExposureSource() == 1) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getMaxWidthForNameInTroopMemberListActivity(int i3) {
        boolean z16;
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this, i3)).intValue();
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        Resources resources = BaseApplication.getContext().getResources();
        float f18 = 130.0f;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (z16) {
                        f17 = 160.0f;
                    } else {
                        f17 = 180.0f;
                    }
                    return dp2px(f17, resources);
                }
                if (z16) {
                    f16 = 50.0f;
                } else {
                    f16 = 100.0f;
                }
                return dp2px(f16, resources);
            }
            if (!z16) {
                f18 = 150.0f;
            }
            return dp2px(f18, resources);
        }
        if (!z16) {
            f18 = 150.0f;
        }
        return dp2px(f18, resources);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getSpecialCareRingRoamingSetting(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime)).intValue();
        }
        if (appRuntime == null) {
            return 0;
        }
        return ((IRoamSettingService) appRuntime.getRuntimeService(IRoamSettingService.class, "")).getSettingValue(AppConstants.RoamingMapPath.SPECIAL_CARE_RING, 0);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getTroopGeneralSettingRing(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) appRuntime)).intValue();
        }
        if (appRuntime == null) {
            return 0;
        }
        return ((IRoamSettingService) appRuntime.getRuntimeService(IRoamSettingService.class, "")).getSettingValue(AppConstants.RoamingMapPath.TROOP_RING, 0);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getTroopGeneralSettingVibrate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime)).intValue();
        }
        if (appRuntime == null) {
            return 0;
        }
        return ((IRoamSettingService) appRuntime.getRuntimeService(IRoamSettingService.class, "")).getSettingValue(AppConstants.RoamingMapPath.TROOP_VIBRATE, 0);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean getTroopInfoEditRedShow(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, this, appRuntime, str, Integer.valueOf(i3))).booleanValue();
        }
        if (appRuntime == null || str == null) {
            return false;
        }
        return appRuntime.getApplication().getSharedPreferences(ITroopUtilsApi.SP_TROOP_INFO_EDIT_RED_SHOW + appRuntime.getCurrentAccountUin() + "_" + str, 0).getBoolean(ITroopUtilsApi.SP_KEY_TROOP_INFO_EDIT_RED_SHOW_TAG + i3, true);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public GroupMsgMask getTroopMask(AppRuntime appRuntime, String str) {
        GroupMsgMask groupMsgMask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GroupMsgMask) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) str);
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(str);
        if (troopInfoFromCache != null && (groupMsgMask = troopInfoFromCache.troopmask) != null && groupMsgMask != GroupMsgMask.UNSPECIFIED) {
            return groupMsgMask;
        }
        return GroupMsgMask.NOTIFY;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int getTroopMaskPriority(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        int i3 = c.f302075a[getTroopMask(null, str).ordinal()];
        int i16 = 2;
        if (i3 != 2) {
            i16 = 3;
            if (i3 != 3) {
                if (i3 == 4) {
                    return 4;
                }
                return 1;
            }
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public Intent getTroopMemberListActivityLaunchIntent(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (Intent) iPatchRedirector.redirect((short) 50, this, context, str, Integer.valueOf(i3));
        }
        return TroopMemberListActivity.getLaunchIntent(context, str, i3);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void goToAppealForTempBlock(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) context, (Object) str);
        } else {
            ab.b(context, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void handleJoinTroopFailed(Context context, int i3) {
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) context, i3);
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 8 && i3 != 11) {
                            qqStr = HardCodeUtil.qqStr(R.string.f171048c00);
                        } else {
                            qqStr = HardCodeUtil.qqStr(R.string.i7h);
                        }
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.urk);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.urq);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.urj);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.i7i);
        }
        QQToast.makeText(context, qqStr, 0, 1).show();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public TroopInfo initTroopInfo(AppRuntime appRuntime, TroopInfoData troopInfoData, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 17, this, appRuntime, troopInfoData, context);
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopInfoData.troopUin);
        if (findTroopInfo != null) {
            troopInfoData.isMember = true;
            troopInfoData.updateForTroopChatSetting(findTroopInfo, context.getResources(), appRuntime.getCurrentAccountUin());
        }
        return findTroopInfo;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public TroopInfoData initTroopInfoData(Bundle bundle, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TroopInfoData) iPatchRedirector.redirect((short) 16, (Object) this, (Object) bundle, (Object) context);
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        if (bundle == null) {
            return troopInfoData;
        }
        troopInfoData.troopUin = bundle.getString("troop_uin");
        troopInfoData.troopCode = bundle.getString(AppConstants.Key.TROOP_CODE);
        try {
            if (Long.parseLong(troopInfoData.troopUin) > 0) {
                troopInfoData.f294880pa = bundle.getInt(AppConstants.Key.TROOP_INFO_FROM);
                troopInfoData.nStatOption = bundle.getInt(AppConstants.Key.TROOP_INFO_FROM_EX);
                troopInfoData.remark = bundle.getString("param_return_addr");
                troopInfoData.isMember = bundle.getBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER);
                troopInfoData.troopface = bundle.getShort(AppConstants.Key.TROOP_INFO_FACEID);
                String string = bundle.getString(AppConstants.Key.TROOP_INFO_NAME);
                troopInfoData.troopName = string;
                troopInfoData.newTroopName = string;
                troopInfoData.troopowneruin = bundle.getString(AppConstants.Key.TROOP_INFO_OWNER);
                troopInfoData.dwGroupClassExt = bundle.getLong(AppConstants.Key.TROOP_INFO_CLASSEXT);
                troopInfoData.troopLocation = bundle.getString(AppConstants.Key.TROOP_INFO_LOCA);
                String string2 = bundle.getString(AppConstants.Key.TROOP_INFO_FINGERMEMO);
                troopInfoData.mRichFingerMemo = string2;
                if (!TextUtils.isEmpty(string2)) {
                    troopInfoData.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(troopInfoData.mRichFingerMemo);
                }
                troopInfoData.cGroupOption = bundle.getByte(AppConstants.Key.TROOP_INFO_OPT);
                troopInfoData.mStrJoinQuestion = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(context, troopInfoData.troopUin);
                troopInfoData.nTroopGrade = bundle.getInt(AppConstants.Key.TROOP_INFO_TROOP_GRADE);
                troopInfoData.mStrJoinAnswer = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopAnswerFromSP(context, troopInfoData.troopUin);
                troopInfoData.dwGroupFlagExt = bundle.getLong(AppConstants.Key.TROOP_INFO_FLAG_EXT);
                troopInfoData.dwAuthGroupType = bundle.getLong(AppConstants.Key.TROOP_INFO_AUTH_TYPE);
                troopInfoData.troopTags = TroopInfo.getTags(bundle.getString(AppConstants.Key.TROOP_INFO_TAGS_EXT));
            }
            return troopInfoData;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return troopInfoData;
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isEmptyRedPointSP(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        String d16 = cl.d(BaseApplication.getContext(), str);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("isEmptyRedPointSP [%s, %s]", str, d16));
        }
        return TextUtils.isEmpty(d16);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isShowKingTeamRedPoint(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), str)).booleanValue();
        }
        if (z16 && isEmptyRedPointSP(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isShowRedPoint(boolean z16, String str) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), str)).booleanValue();
        }
        if (z16) {
            z17 = isEmptyRedPointSP(str);
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("isShowRedPoint [%s, %s, %s]", str, Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isTroopAdmin(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, this, appRuntime, str, str2)).booleanValue();
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo == null) {
            return false;
        }
        return findTroopInfo.isTroopAdmin(str2);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isTroopEditInfoRedExist(AppRuntime appRuntime, String str, boolean[] zArr, int[] iArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, this, appRuntime, str, zArr, iArr)).booleanValue();
        }
        if (appRuntime != null && str != null && iArr != null && zArr != null && iArr.length == zArr.length) {
            SharedPreferences sharedPreferences = appRuntime.getApplication().getSharedPreferences(ITroopUtilsApi.SP_TROOP_INFO_EDIT_RED_SHOW + appRuntime.getCurrentAccountUin() + "_" + str, 0);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (zArr[i3]) {
                    z16 = sharedPreferences.getBoolean(ITroopUtilsApi.SP_KEY_TROOP_INFO_EDIT_RED_SHOW_TAG + iArr[i3], true);
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isTroopMark(AppRuntime appRuntime, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? isTroopMark(appRuntime, message.frienduin, message.istroop) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) message)).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isTroopOwnerOrAdmin(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, this, appRuntime, str, str2)).booleanValue();
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo == null) {
            return false;
        }
        if (!findTroopInfo.isTroopAdmin(str2) && !findTroopInfo.isTroopOwner(str2)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isTroopTagNeedRedDot(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, j3)).booleanValue();
        }
        if (j3 != 10009 && j3 != 10010 && j3 != 10011 && j3 != 32) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isUpdateBeforeSomeVersion(Context context, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserGuide", 0);
        String string = sharedPreferences.getString(AppConstants.Preferences.QQ_VERSION_PRE, null);
        String string2 = sharedPreferences.getString(AppConstants.Preferences.QQ_VERSION_FULL_PRE, null);
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("isUpdateBeforeSomeVersion pre[%s, %s]", string, string2));
            }
            return false;
        }
        String str2 = AppSetting.f99542b;
        if (TextUtils.equals(str2, string)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", str2, string));
            }
            return false;
        }
        if (TextUtils.isEmpty(string2)) {
            string2 = "8.0.0";
        }
        String d16 = AppSetting.d();
        if (TextUtils.equals(string2, d16)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", d16, string2));
            }
            return false;
        }
        long convertQQFullVersion2Long = convertQQFullVersion2Long(str);
        long convertQQFullVersion2Long2 = convertQQFullVersion2Long(string2);
        if (Math.abs(convertQQFullVersion2Long2) < Math.abs(convertQQFullVersion2Long)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("isUpdateBeforeSomeVersion some: %s, pre: %s, ret: %s", Long.valueOf(convertQQFullVersion2Long), Long.valueOf(convertQQFullVersion2Long2), Boolean.valueOf(z16)));
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void joinGroupOneStep(AppRuntime appRuntime, Context context, Intent intent, e.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, appRuntime, context, intent, aVar);
        } else {
            ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(this.domainArray, new b(appRuntime, context, intent, aVar));
        }
    }

    public void joinGroupOneStepWithPSkey(AppRuntime appRuntime, Context context, Intent intent, e.a aVar, String str) {
        StringBuilder sb5;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, appRuntime, context, intent, aVar, str);
            return;
        }
        if (appRuntime == null || context == null || intent == null) {
            return;
        }
        Bundle bundle = new Bundle();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("o");
        if (currentAccountUin.length() < 10) {
            for (int i3 = 0; i3 < 10 - currentAccountUin.length(); i3++) {
                sb7.append("0");
            }
            sb7.append(currentAccountUin);
        } else {
            sb7.append("0");
            sb7.append(currentAccountUin);
        }
        bundle.putString("Cookie", "uin=" + ((Object) sb7) + "; p_skey=" + str);
        bundle.putString("Host", "info.gamecenter.qq.com");
        String stringExtra = intent.getStringExtra("appid");
        if (!"true".equals(intent.getStringExtra("is_from_game")) || TextUtils.isEmpty(stringExtra)) {
            sb5 = sb6;
            str2 = "guild_id";
            str3 = "";
            str4 = "";
            str5 = str4;
            str6 = str5;
        } else {
            sb5 = sb6;
            str2 = "guild_id";
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).checkApiState(appRuntime, context, stringExtra, aVar, 0, null);
            str3 = intent.getStringExtra(str2);
            str4 = intent.getStringExtra("zone_id");
            str5 = intent.getStringExtra("role_id");
            str6 = intent.getStringExtra("gc");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appid", stringExtra);
        bundle2.putString(str2, str3);
        bundle2.putString("zone_id", str4);
        bundle2.putString("gc", str6);
        bundle2.putString("platid", "2");
        bundle2.putString("roleid", str5);
        Bundle bundle3 = new Bundle();
        bundle3.putString("module", "gc_bind_group_svr");
        bundle3.putString("method", "join_group");
        String constructParams = constructParams(bundle2, bundle3);
        bundle.putString("param", constructParams);
        bundle.putString("signature", encrypt(constructParams + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", context);
        new f(sb5.toString(), "GET", aVar, 1, null).b(hashMap);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void notifyUser(Context context, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            new QQToastNotifier(context).notifyUser(i16, i3, 0, i17);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void preloadWebProcess(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) appRuntime);
        } else {
            ((IWebProcessManagerService) appRuntime.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcessUnderStrategy(33, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public int readPictureDegree(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str)).intValue();
        }
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public String replaceSpecialTag(String str, long j3, int i3, TroopInfoData troopInfoData, AppRuntime appRuntime, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, this, str, Long.valueOf(j3), Integer.valueOf(i3), troopInfoData, appRuntime, Boolean.valueOf(z16));
        }
        String str3 = "1";
        if (troopInfoData.bOwner) {
            str2 = "0";
        } else if (troopInfoData.bAdmin) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        String replace = str.replace("$GCODE$", troopInfoData.troopUin).replace("$CLIENTVER$", "android" + AppSetting.f99551k).replace("$UIN$", appRuntime.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(j3)).replace("$ROLE$", str2);
        if (!z16) {
            str3 = "2";
        }
        String replace2 = replace.replace("$ENTERSOURCE$", str3).replace("$GUIN$", troopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(i3));
        if (!TextUtils.isEmpty(troopInfoData.newTroopName)) {
            return replace2.replace("$GNAME$", troopInfoData.newTroopName);
        }
        return replace2;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void reportQunMiniApp(oidb_0xe83$AppInfo oidb_0xe83_appinfo, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, oidb_0xe83_appinfo, str, str2);
            return;
        }
        if (oidb_0xe83_appinfo == null) {
            return;
        }
        SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
        simpleMiniAppInfo.appId = String.valueOf(oidb_0xe83_appinfo.appid.get());
        simpleMiniAppInfo.name = oidb_0xe83_appinfo.name.get();
        SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
        SimpleMiniAppConfig.SimpleLaunchParam simpleLaunchParam = simpleMiniAppConfig.launchParam;
        simpleLaunchParam.scene = 2010;
        simpleMiniAppConfig.config.via = "2010_3";
        simpleLaunchParam.reportData = "groupid=" + str2 + "&category_tag=";
        ThreadManagerV2.excute(new Runnable(simpleMiniAppConfig, str) { // from class: com.tencent.mobileqq.troop.utils.api.impl.TroopUtilsApiImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SimpleMiniAppConfig f302058d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f302059e;

            {
                this.f302058d = simpleMiniAppConfig;
                this.f302059e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopUtilsApiImpl.this, simpleMiniAppConfig, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(this.f302058d, "page_view", this.f302059e, null, null);
                }
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void reportTroopFeaturePageImp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) str);
        } else {
            TroopFeatureReport.f361921a.b(str, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void setExposureSource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mExposureSource = i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void setRedPointSP(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str) || !isEmptyRedPointSP(str)) {
            return;
        }
        cl.j(BaseApplication.getContext(), str, str);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("setRedPointSP [%s, %s]", str, str));
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void setSpecialCareRingRoamingSetting(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime, i3);
        } else {
            if (appRuntime == null) {
                return;
            }
            ((IRoamSettingService) appRuntime.getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue(AppConstants.RoamingMapPath.SPECIAL_CARE_RING, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void setTroopGeneralSettingRing(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoundSetting", 2, "setTroopGeneralSettingRing :" + i3);
        }
        if (appRuntime == null) {
            return;
        }
        ((IRoamSettingService) appRuntime.getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue(AppConstants.RoamingMapPath.TROOP_RING, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void setTroopGeneralSettingVibrate(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoundSetting", 2, "setTroopGeneralSettingVibrate :" + i3);
        }
        if (appRuntime == null) {
            return;
        }
        ((IRoamSettingService) appRuntime.getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue(AppConstants.RoamingMapPath.TROOP_VIBRATE, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void setTroopInfoEditRedShow(AppRuntime appRuntime, String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, appRuntime, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setTroopInfoEditRedShow " + str + " " + i3 + " " + z16);
        }
        if (appRuntime != null) {
            SharedPreferences.Editor edit = appRuntime.getApplication().getSharedPreferences(ITroopUtilsApi.SP_TROOP_INFO_EDIT_RED_SHOW + appRuntime.getCurrentAccountUin() + "_" + str, 0).edit();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(ITroopUtilsApi.SP_KEY_TROOP_INFO_EDIT_RED_SHOW_TAG);
            sb5.append(i3);
            edit.putBoolean(sb5.toString(), z16).commit();
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean skipSecurityPush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        return TroopSecurityTipsBanner.F();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public long stringToLong(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str)).longValue();
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public JSONArray toJSONArray(Object obj) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (JSONArray) iPatchRedirector.redirect((short) 44, (Object) this, obj);
        }
        JSONArray jSONArray = new JSONArray();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i3 = 0; i3 < length; i3++) {
                jSONArray.mo162put(wrap(Array.get(obj, i3)));
            }
            return jSONArray;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void updateRedPoint(boolean z16, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), textView);
            return;
        }
        if (z16) {
            textView.setVisibility(0);
            textView.setBackgroundResource(0);
            textView.setCompoundDrawablePadding(Utils.n(10.0f, BaseApplication.getContext().getResources()));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.d3e, 0);
            return;
        }
        textView.setCompoundDrawablePadding(0);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public Object wrap(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return iPatchRedirector.redirect((short) 43, (Object) this, obj);
        }
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            if (obj.equals(JSONObject.NULL)) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return toJSONArray(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
            return obj;
        }
        return obj;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public boolean isTroopMark(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? i3 == 1 && getTroopMask(appRuntime, str) != GroupMsgMask.NOTIFY : ((Boolean) iPatchRedirector.redirect((short) 7, this, appRuntime, str, Integer.valueOf(i3))).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public String getDateString(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, this, context, Long.valueOf(j3));
        }
        if (j3 <= 0) {
            return "";
        }
        return context.getResources().getString(R.string.f171285dr3) + new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(Long.valueOf(j3 * 1000));
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void updateRedPoint(boolean z16, String str, boolean z17, boolean z18, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18), textView);
            return;
        }
        boolean z19 = isShowRedPoint(z16, str) || z17 || z18;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isShowRedPoint:" + z19);
        }
        updateRedPoint(z19, textView);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi
    public void calJoinTroop(TroopInfoData troopInfoData, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, troopInfoData, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            calJoinTroop(troopInfoData.troopUin, troopInfoData.f294880pa, troopInfoData.nStatOption, i3, i16, i17);
            troopInfoData.getStatOption();
        }
    }
}
