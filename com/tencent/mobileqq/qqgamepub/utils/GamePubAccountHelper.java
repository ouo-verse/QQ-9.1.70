package com.tencent.mobileqq.qqgamepub.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QGameBusEvent;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.util.QQCustomArkDialogUtil;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class GamePubAccountHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, List<Long>> f264682a;

    /* renamed from: b, reason: collision with root package name */
    private static String f264683b;

    /* renamed from: c, reason: collision with root package name */
    private static String f264684c;

    /* renamed from: d, reason: collision with root package name */
    private static String f264685d;

    /* renamed from: e, reason: collision with root package name */
    private static String f264686e;

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, String> f264687f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22289);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f264682a = Collections.synchronizedMap(new HashMap());
        f264683b = "https://w.gamecenter.qq.com/v1/cgi-bin/common/feeds";
        f264684c = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/first";
        f264685d = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/get-game-priority-json";
        f264686e = "4";
        f264687f = new HashMap();
    }

    public static long A() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return 0L;
        }
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getLong(waitAppRuntime.getAccount() + "sp_key_game_pa_notice_rsptime_", 0L);
    }

    public static boolean B() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100491", false);
        QLog.d("QQGamePub_GamePubAccountHelper", 1, "isCalendarJsbridgeEnable=", Boolean.valueOf(isSwitchOn));
        return isSwitchOn;
    }

    public static boolean C() {
        if (!"3".equals(f264686e) && !"6".equals(f264686e)) {
            return false;
        }
        return true;
    }

    private static boolean D(QQGameMsgInfo qQGameMsgInfo, long j3) {
        boolean z16;
        try {
            if (j3 >= qQGameMsgInfo.msgTime) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("QQGamePub_GamePubAccountHelper", 4, "isMsgRead...lastRead:" + j3 + ",msgTime:" + qQGameMsgInfo.msgTime + ",isRead:" + z16);
            }
            return z16;
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePubAccountHelper", 1, th5, new Object[0]);
            return false;
        }
    }

    public static boolean E(String str) {
        return "com.tencent.gamecenter.newvideo".equals(str);
    }

    public static void F(String str, long j3) {
        ThreadManagerV2.executeOnSubThread(new Runnable(str, j3) { // from class: com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f264688d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f264689e;

            {
                this.f264688d = str;
                this.f264689e = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ReportController.o(null, "dc00898", "", this.f264688d, "0X800A306", "0X800A306", 0, 0, "", "", this.f264689e + "", "");
            }
        });
    }

    public static void G(int i3, QQGameMsgInfo qQGameMsgInfo, int i16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GamePubAccountHelper", 1, "publicAccountTianshuReport---> action=" + i3, "   position=" + i16);
        }
        if (qQGameMsgInfo == null) {
            return;
        }
        if (i3 == 117) {
            F(qQGameMsgInfo.frienduin, qQGameMsgInfo.uniseq);
        }
        if (!TextUtils.isEmpty(qQGameMsgInfo.advId)) {
            str = qQGameMsgInfo.advId;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h(i3, i16, str, qQGameMsgInfo.triggerInfo);
    }

    public static void H(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQGamePub_GamePubAccountHelper", 4, "reportExposureToGdt,exposureUrl is null");
        } else {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f264695d;

                {
                    this.f264695d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f264695d).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.connect();
                        QLog.i("QQGamePub_GamePubAccountHelper", 1, "reportExposureByHttp rspCode=" + httpURLConnection.getResponseCode());
                    } catch (Throwable unused) {
                        QLog.i("QQGamePub_GamePubAccountHelper", 1, "reportExposureByHttp error, url = " + this.f264695d);
                    }
                }
            }, 16, null, false);
        }
    }

    public static void I(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ThreadManagerV2.excute(new Runnable(str, str2) { // from class: com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f264696d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f264697e;

                {
                    this.f264696d = str;
                    this.f264697e = str2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        GamePubAccountHelper.f(this.f264696d, this.f264697e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, false);
        } else {
            QLog.e("QQGamePub_GamePubAccountHelper", 4, "reportExposureToGdt,exposureUrl or  reqBody is null");
        }
    }

    public static void J(QQGameMsgInfo qQGameMsgInfo) {
        if (qQGameMsgInfo != null && qQGameMsgInfo.isAdMsg) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GamePubAccountHelper", 1, "reportExposureToGdt");
            }
            if (TextUtils.isEmpty(qQGameMsgInfo.adJson)) {
                QLog.e("QQGamePub_GamePubAccountHelper", 4, "reportExposureToGdt,adJsonStr is null");
                return;
            }
            try {
                H(new JSONObject(qQGameMsgInfo.adJson).optString("exposure_url", ""));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static void K(QQGameMsgInfo qQGameMsgInfo, int i3, String str) {
        if (qQGameMsgInfo == null) {
            QLog.e("QQGamePub_GamePubAccountHelper", 1, "reportMsgExposure msgInfo is null");
            return;
        }
        r(str).setOperId("205017").setModuleType("76901").setExt(2, qQGameMsgInfo.paMsgid).setExt(3, "0").setExt(4, "8").setGameAppId(qQGameMsgInfo.gameAppId).report();
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(117, qQGameMsgInfo, i3);
        J(qQGameMsgInfo);
    }

    public static void L(String str) {
        try {
            if (f264682a.containsKey(str)) {
                List<Long> list = f264682a.get(str);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("url=");
                stringBuffer.append(str);
                stringBuffer.append("|apiSendEnd:");
                stringBuffer.append(list.get(0));
                stringBuffer.append("|sendPack:");
                stringBuffer.append(list.get(1));
                stringBuffer.append("|resPack:");
                stringBuffer.append(list.get(2));
                stringBuffer.append("|apiPackStart:");
                stringBuffer.append(list.get(3));
                stringBuffer.append("|costTime=" + (list.get(3).longValue() - list.get(0).longValue()));
                QLog.d("QQGamePub_GamePubAccountHelper", 1, stringBuffer.toString());
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void M(AppInterface appInterface, String str) {
        appInterface.getApp().getSharedPreferences("game_center_sp", 0).edit().putString("msgPos_web" + appInterface.getCurrentAccountUin(), str).apply();
    }

    public static void N(GmpEnterInfoRsp gmpEnterInfoRsp) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
            String str = waitAppRuntime.getAccount() + "sp_key_game_center_enter_status_jumpUrl";
            String str2 = waitAppRuntime.getAccount() + "sp_key_game_center_enter_status_bubbleId";
            sharedPreferences.edit().putString(str, gmpEnterInfoRsp.url).apply();
            sharedPreferences.edit().putString(str2, gmpEnterInfoRsp.bubbleId).apply();
        }
    }

    public static void O(JSONObject jSONObject) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putString(waitAppRuntime.getAccount() + "sp_key_game_center_enter_notice", jSONObject.toString()).apply();
        }
    }

    public static void P(boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QMMKV.from(BaseApplication.getContext(), "vas_mmkv_configurations").encodeBool(peekAppRuntime.getAccount() + "hippy_enable_http2", z16);
        }
    }

    public static void Q(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            f264687f.put(str, str2);
        }
    }

    public static void R(long j3) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putLong(waitAppRuntime.getAccount() + "sp_key_game_pa_notice_rsptime_", j3).apply();
        }
    }

    public static void S(boolean z16) {
        QLog.d("QQGamePub_GamePubAccountHelper", 1, "setCalendarJsbridgeStatus, enable=", Boolean.valueOf(z16));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QMMKV.from(BaseApplication.getContext(), "vas_mmkv_configurations").encodeBool(peekAppRuntime.getAccount() + "mmkv_key_game_center_calendar_jsbridge_enable", z16);
            return;
        }
        QLog.e("QQGamePub_GamePubAccountHelper", 1, "setCalendarJsbridgeStatus, appRuntime null");
    }

    public static void T(String str) {
        f264686e = str;
        QLog.i("QQGamePub_GamePubAccountHelper", 1, "[setGamePubType] " + str);
    }

    public static void U(String str, long j3) {
        try {
            if (str.startsWith(f264683b) || str.startsWith(f264684c) || str.startsWith(f264685d)) {
                if (f264682a.containsKey(str)) {
                    f264682a.remove(str);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j3));
                f264682a.put(str, arrayList);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void b(String str, long j3) {
        try {
            if (str.startsWith(f264683b) || str.startsWith(f264684c) || str.startsWith(f264685d)) {
                if (f264682a.containsKey(str)) {
                    f264682a.get(str).add(Long.valueOf(j3));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(j3));
                    f264682a.put(str, arrayList);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void c() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
            String str = waitAppRuntime.getAccount() + "sp_key_game_center_enter_status_jumpUrl";
            String str2 = waitAppRuntime.getAccount() + "sp_key_game_center_enter_status_bubbleId";
            sharedPreferences.edit().putString(str, "").apply();
            sharedPreferences.edit().putString(str2, "").apply();
        }
    }

    public static void d() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putString(waitAppRuntime.getAccount() + "sp_key_game_center_enter_notice", "").apply();
        }
    }

    public static void e(int i3) {
        SimpleEventBus.getInstance().dispatchEvent(new QGameBusEvent(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x005d -> B:14:0x006c). Please report as a decompilation issue!!! */
    public static void f(String str, String str2) {
        HttpURLConnection v3 = v(str);
        if (v3 != null) {
            BufferedWriter bufferedWriter = null;
            BufferedWriter bufferedWriter2 = null;
            BufferedWriter bufferedWriter3 = null;
            bufferedWriter = null;
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
                bufferedWriter = bufferedWriter;
            }
            try {
                try {
                    BufferedWriter bufferedWriter4 = new BufferedWriter(new OutputStreamWriter(v3.getOutputStream(), "UTF-8"));
                    try {
                        bufferedWriter4.write(str2);
                        bufferedWriter4.close();
                        int responseCode = v3.getResponseCode();
                        if (QLog.isColorLevel()) {
                            QLog.i("QQGamePub_GamePubAccountHelper", 4, "reportExposureByHttpPost rspCode=" + responseCode);
                            bufferedWriter2 = "reportExposureByHttpPost rspCode=";
                        }
                        bufferedWriter4.close();
                        bufferedWriter = bufferedWriter2;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedWriter3 = bufferedWriter4;
                        QLog.e("QQGamePub_GamePubAccountHelper", 1, e.getMessage());
                        bufferedWriter = bufferedWriter3;
                        if (bufferedWriter3 != null) {
                            bufferedWriter3.close();
                            bufferedWriter = bufferedWriter3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter = bufferedWriter4;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e19) {
                    e = e19;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public static JSONObject g(String str) {
        try {
            if (f264682a.containsKey(str)) {
                List<Long> list = f264682a.get(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apiSendEnd", list.get(0));
                jSONObject.put("sendPack", list.get(1));
                jSONObject.put("resPack", list.get(2));
                jSONObject.put("apiPackStart", list.get(3));
                long longValue = list.get(3).longValue() - list.get(0).longValue();
                jSONObject.put("costTime", longValue + "");
                r(s()).setOperId("206660").setExt(15, str).setExt(16, list.get(0) + "").setExt(17, list.get(1) + "").setExt(18, list.get(2) + "").setExt(19, list.get(3) + "").setExt(20, longValue + "").report();
                return jSONObject;
            }
            return null;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void h(int i3, int i16, String str, String str2) {
        i(i3, i16, str, str2, 1);
    }

    public static void i(int i3, int i16, String str, String str2, int i17) {
        ThreadManagerV2.executeOnSubThread(new Runnable(str, i3, i16, i17, str2) { // from class: com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f264690d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f264691e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f264692f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f264693h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f264694i;

            {
                this.f264690d = str;
                this.f264691e = i3;
                this.f264692f = i16;
                this.f264693h = i17;
                this.f264694i = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TianShuReportData tianShuReportData = new TianShuReportData();
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime == null) {
                    str3 = "";
                } else {
                    str3 = waitAppRuntime.getAccount();
                }
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
                tianShuReportData.mAppId = "vab_push";
                tianShuReportData.mPageId = "vab_push";
                tianShuReportData.mTraceId = str3 + "_" + serverTimeMillis;
                tianShuReportData.mTraceNum = 1;
                tianShuReportData.mItemId = this.f264690d;
                tianShuReportData.mSubItemId = "";
                tianShuReportData.mOperTime = serverTimeMillis;
                tianShuReportData.mActionId = this.f264691e;
                tianShuReportData.mPositionId = Integer.toString(this.f264692f);
                tianShuReportData.mActionValue = 1;
                tianShuReportData.mActionAttr = this.f264693h;
                tianShuReportData.mTriggerInfo = this.f264694i;
                ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
            }
        });
    }

    public static float j(int i3, float f16, float f17) {
        if (f16 > 0.0f && f17 > 0.0f) {
            float f18 = f17 / f16;
            if (f18 != 0.0f) {
                return i3 / f18;
            }
        }
        return 0.0f;
    }

    public static JSONObject k(QQGameMsgInfo qQGameMsgInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appName", qQGameMsgInfo.arkAppName);
            jSONObject.put(QQCustomArkDialogUtil.APP_VIEW, qQGameMsgInfo.arkAppView);
            jSONObject.put(QQCustomArkDialogUtil.APP_MIN_VERSION, qQGameMsgInfo.arkAppMinVersion);
            jSONObject.put("appMetaList", qQGameMsgInfo.arkMetaList);
            jSONObject.put("appConfig", qQGameMsgInfo.arkAppConfig);
            int b16 = (int) g.b(x.f(BaseApplication.getContext()).f185860a, BaseApplication.getContext().getResources());
            int j3 = (int) j(b16, qQGameMsgInfo.arkHeight, qQGameMsgInfo.arkWidth);
            QLog.e("QQGamePub_GamePubAccountHelper", 1, "msgInfo.arkHeight =" + qQGameMsgInfo.arkHeight + "/msgInfo.arkWidth=" + qQGameMsgInfo.arkWidth + "/getGameArkData targetWidth=/targetHeight=" + j3);
            jSONObject.put("width", b16);
            jSONObject.put("height", j3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public static Map<String, Object> l(QQGameMsgInfo qQGameMsgInfo) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("appName", qQGameMsgInfo.arkAppName);
            hashMap.put(QQCustomArkDialogUtil.APP_VIEW, qQGameMsgInfo.arkAppView);
            hashMap.put(QQCustomArkDialogUtil.APP_MIN_VERSION, qQGameMsgInfo.arkAppMinVersion);
            hashMap.put("appMetaList", qQGameMsgInfo.arkMetaList);
            hashMap.put("appConfig", qQGameMsgInfo.arkAppConfig);
            int b16 = (int) g.b(x.f(BaseApplication.getContext()).f185860a, BaseApplication.getContext().getResources());
            int j3 = (int) j(b16, qQGameMsgInfo.arkHeight, qQGameMsgInfo.arkWidth);
            QLog.e("QQGamePub_GamePubAccountHelper", 1, "msgInfo.arkHeight =" + qQGameMsgInfo.arkHeight + "/msgInfo.arkWidth=" + qQGameMsgInfo.arkWidth + "/getGameArkData targetWidth=/targetHeight=" + j3);
            hashMap.put("width", Integer.valueOf(b16));
            hashMap.put("height", Integer.valueOf(j3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public static JSONArray m(List<QQGameMsgInfo> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            try {
                for (QQGameMsgInfo qQGameMsgInfo : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rawMsgId", qQGameMsgInfo.msgId);
                    jSONObject.put("adID", qQGameMsgInfo.paMsgid);
                    jSONObject.put("msgID", qQGameMsgInfo.paMsgid);
                    jSONObject.put("appID", qQGameMsgInfo.gameAppId);
                    jSONObject.put("msgTime", qQGameMsgInfo.msgTime);
                    if (!TextUtils.isEmpty(qQGameMsgInfo.sortedConfigs)) {
                        jSONObject.put("sorted_configs", qQGameMsgInfo.sortedConfigs);
                    }
                    if (!TextUtils.isEmpty(qQGameMsgInfo.extJson)) {
                        jSONObject.put(WadlProxyConsts.EXT_JSON, qQGameMsgInfo.extJson);
                    }
                    jSONArray.mo162put(jSONObject);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static List<Map<String, Object>> n(List<QQGameMsgInfo> list, long j3, long j16, String str) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (list != null && list.size() > 0) {
            try {
                int i16 = 0;
                for (QQGameMsgInfo qQGameMsgInfo : list) {
                    if (TextUtils.isEmpty(str) || str.equals(qQGameMsgInfo.gameAppId)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("rawMsgId", String.valueOf(qQGameMsgInfo.msgId));
                        hashMap.put("adID", qQGameMsgInfo.paMsgid);
                        hashMap.put("msgID", qQGameMsgInfo.paMsgid);
                        hashMap.put("appID", qQGameMsgInfo.gameAppId);
                        hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, Integer.valueOf(qQGameMsgInfo.msgType));
                        int i17 = qQGameMsgInfo.msgType;
                        if (i17 == 1) {
                            hashMap.put("arkData", l(qQGameMsgInfo));
                        } else if (i17 == 2) {
                            hashMap.put("structData", u(qQGameMsgInfo));
                        } else if (i17 == 3) {
                            hashMap.put("structData", u(qQGameMsgInfo));
                        }
                        hashMap.put("msgTime", Long.valueOf(qQGameMsgInfo.msgTime));
                        if (!TextUtils.isEmpty(qQGameMsgInfo.sortedConfigs)) {
                            hashMap.put("sorted_configs", qQGameMsgInfo.sortedConfigs);
                        }
                        if (!TextUtils.isEmpty(qQGameMsgInfo.extJson)) {
                            hashMap.put(WadlProxyConsts.EXT_JSON, qQGameMsgInfo.extJson);
                        }
                        hashMap.put("desc", qQGameMsgInfo.desc);
                        hashMap.put("icon", qQGameMsgInfo.icon);
                        hashMap.put("frienduin", qQGameMsgInfo.frienduin);
                        hashMap.put("uniseq", Long.valueOf(qQGameMsgInfo.uniseq));
                        hashMap.put("advId", qQGameMsgInfo.advId);
                        hashMap.put("triggerInfo", qQGameMsgInfo.triggerInfo);
                        boolean D = D(qQGameMsgInfo, j3);
                        if (!D) {
                            i16++;
                        }
                        if (i16 <= j16) {
                            hashMap.put("isReaded", Boolean.valueOf(D));
                        } else {
                            hashMap.put("isReaded", Boolean.TRUE);
                        }
                        arrayList.add(hashMap);
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getGameDataParamV2,infoList:");
            if (list != null) {
                i3 = list.size();
            }
            sb5.append(i3);
            sb5.append(",lastRead:");
            sb5.append(j3);
            sb5.append(",mUnreadMsgNum:");
            sb5.append(j16);
            QLog.i("QQGamePub_GamePubAccountHelper", 2, sb5.toString());
        }
        return arrayList;
    }

    public static JSONArray o(List<QQGameMsgInfo> list, long j3, long j16, String str) {
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        if (list != null && list.size() > 0) {
            try {
                int i16 = 0;
                for (QQGameMsgInfo qQGameMsgInfo : list) {
                    if (!TextUtils.isEmpty(str) && !str.equals(qQGameMsgInfo.gameAppId)) {
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rawMsgId", String.valueOf(qQGameMsgInfo.msgId));
                    jSONObject.put("adID", qQGameMsgInfo.paMsgid);
                    jSONObject.put("msgID", qQGameMsgInfo.paMsgid);
                    jSONObject.put("appID", qQGameMsgInfo.gameAppId);
                    jSONObject.put(QQBrowserActivity.KEY_MSG_TYPE, qQGameMsgInfo.msgType);
                    int i17 = qQGameMsgInfo.msgType;
                    if (i17 == 1) {
                        jSONObject.put("arkData", k(qQGameMsgInfo));
                    } else if (i17 == 2) {
                        jSONObject.put("structData", t(qQGameMsgInfo));
                    } else if (i17 == 3) {
                        jSONObject.put("structData", t(qQGameMsgInfo));
                    }
                    jSONObject.put("msgTime", qQGameMsgInfo.msgTime);
                    if (!TextUtils.isEmpty(qQGameMsgInfo.sortedConfigs)) {
                        jSONObject.put("sorted_configs", qQGameMsgInfo.sortedConfigs);
                    }
                    if (!TextUtils.isEmpty(qQGameMsgInfo.extJson)) {
                        jSONObject.put(WadlProxyConsts.EXT_JSON, qQGameMsgInfo.extJson);
                    }
                    jSONObject.put("desc", qQGameMsgInfo.desc);
                    jSONObject.put("icon", qQGameMsgInfo.icon);
                    jSONObject.put("frienduin", qQGameMsgInfo.frienduin);
                    jSONObject.put("uniseq", qQGameMsgInfo.uniseq);
                    jSONObject.put("advId", qQGameMsgInfo.advId);
                    jSONObject.put("triggerInfo", qQGameMsgInfo.triggerInfo);
                    boolean D = D(qQGameMsgInfo, j3);
                    if (!D) {
                        i16++;
                    }
                    if (i16 <= j16) {
                        jSONObject.put("isReaded", D);
                    } else {
                        jSONObject.put("isReaded", true);
                    }
                    jSONArray.mo162put(jSONObject);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getGameDataParamV2,infoList:");
            if (list != null) {
                i3 = list.size();
            }
            sb5.append(i3);
            sb5.append(",lastRead:");
            sb5.append(j3);
            sb5.append(",mUnreadMsgNum:");
            sb5.append(j16);
            QLog.i("QQGamePub_GamePubAccountHelper", 2, sb5.toString());
        }
        return jSONArray;
    }

    public static GmpEnterInfoRsp p() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
            String str = waitAppRuntime.getAccount() + "sp_key_game_center_enter_status_jumpUrl";
            String str2 = waitAppRuntime.getAccount() + "sp_key_game_center_enter_status_bubbleId";
            GmpEnterInfoRsp gmpEnterInfoRsp = new GmpEnterInfoRsp();
            gmpEnterInfoRsp.url = sharedPreferences.getString(str, "");
            gmpEnterInfoRsp.bubbleId = sharedPreferences.getString(str2, "");
            return gmpEnterInfoRsp;
        }
        return new GmpEnterInfoRsp();
    }

    public static JSONObject q() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            String string = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getString(waitAppRuntime.getAccount() + "sp_key_game_center_enter_notice", "");
            try {
                if (StringUtil.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            } catch (JSONException e16) {
                QLog.e("QQGamePub_GamePubAccountHelper", 1, e16, new Object[0]);
            }
        }
        return null;
    }

    public static WadlReportBuilder r(String str) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setBussinessId("1").setPageId("160").setExt(24, str);
        return wadlReportBuilder;
    }

    public static String s() {
        return f264686e;
    }

    public static JSONObject t(QQGameMsgInfo qQGameMsgInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coverUrl", qQGameMsgInfo.coverUrl);
            jSONObject.put("url", qQGameMsgInfo.url);
            jSONObject.put("title", qQGameMsgInfo.title);
            jSONObject.put("dateTitle", qQGameMsgInfo.dateTitle);
            jSONObject.put("contentText", qQGameMsgInfo.contentText);
            jSONObject.put("limitText", qQGameMsgInfo.limitText);
            jSONObject.put("actionUrl", qQGameMsgInfo.actionUrl);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public static Map<String, Object> u(QQGameMsgInfo qQGameMsgInfo) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("coverUrl", qQGameMsgInfo.coverUrl);
            hashMap.put("url", qQGameMsgInfo.url);
            hashMap.put("title", qQGameMsgInfo.title);
            hashMap.put("dateTitle", qQGameMsgInfo.dateTitle);
            hashMap.put("contentText", qQGameMsgInfo.contentText);
            hashMap.put("limitText", qQGameMsgInfo.limitText);
            hashMap.put("actionUrl", qQGameMsgInfo.actionUrl);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    private static HttpURLConnection v(String str) {
        IOException e16;
        HttpURLConnection httpURLConnection;
        ProtocolException e17;
        MalformedURLException e18;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (MalformedURLException e19) {
            e18 = e19;
            httpURLConnection = null;
        } catch (ProtocolException e26) {
            e17 = e26;
            httpURLConnection = null;
        } catch (IOException e27) {
            e16 = e27;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_TYPE, ITVKHttpProcessor.HTTP_REQUEST_CONTENT_TYPE_VALUE_FORM);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
        } catch (MalformedURLException e28) {
            e18 = e28;
            QLog.e("QQGamePub_GamePubAccountHelper", 1, e18.getMessage());
            return httpURLConnection;
        } catch (ProtocolException e29) {
            e17 = e29;
            QLog.e("QQGamePub_GamePubAccountHelper", 1, e17.getMessage());
            return httpURLConnection;
        } catch (IOException e36) {
            e16 = e36;
            QLog.e("QQGamePub_GamePubAccountHelper", 1, e16.getMessage());
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    public static long w(ArrayList<WadlResult> arrayList) {
        long j3 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<WadlResult> it = arrayList.iterator();
            String str = "";
            long j16 = 0;
            int i3 = 0;
            String str2 = "";
            while (it.hasNext()) {
                WadlResult next = it.next();
                if (next.taskStatus == 6) {
                    long j17 = next.createTime;
                    if (j17 > j16) {
                        WadlParams wadlParams = next.wadlParams;
                        String str3 = wadlParams.appId;
                        i3 = wadlParams.versionCode;
                        j16 = j17;
                        str2 = wadlParams.packageName;
                        str = str3;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                int appVersionCode = GameCenterUtil.getAppVersionCode(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("QQGamePub_GamePubAccountHelper", 1, "appVersionCode = " + appVersionCode + " lastGameVer=" + i3);
                }
                if (appVersionCode < i3) {
                    try {
                        j3 = Long.parseLong(str);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GamePubAccountHelper", 1, "getLastGameAppID gameAppId=" + j3);
        }
        return j3;
    }

    public static String x(AppInterface appInterface) {
        return appInterface.getApp().getSharedPreferences("game_center_sp", 0).getString("msgPos_web" + appInterface.getCurrentAccountUin(), "");
    }

    public static String y(String str) {
        if (f264687f.containsKey(str)) {
            return f264687f.get(str);
        }
        return "";
    }

    public static WadlReportBuilder z(String str) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setExt(24, str);
        return wadlReportBuilder;
    }
}
