package com.tencent.mobileqq.dt.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
            }
        }
    }

    public static com.tencent.mobileqq.dt.data.e a() {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("o3_report_config", new byte[0]));
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "");
            int optInt = jSONObject.optInt("quiklyEnable", 0);
            String optString2 = jSONObject.optString("androidQuiklyMinResVer", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdBlackList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    hashSet.add(optJSONArray.getString(i3));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shortAppIdList");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    hashSet2.add(optJSONArray2.getString(i16));
                }
            }
            return new com.tencent.mobileqq.dt.data.e(optString, optInt, optString2, hashSet, hashSet2);
        } catch (JSONException unused) {
            QLog.e("DTAPIImpl.SecConfig", 1, "parse config error " + str);
            return new com.tencent.mobileqq.dt.data.e("", 0, "", hashSet, hashSet2);
        }
    }

    public static com.tencent.mobileqq.dt.data.f b() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103239", false);
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("103239", new byte[0]));
        HashSet hashSet = new HashSet();
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("ocrEnable", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("domains");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    hashSet.add(optJSONArray.getString(i3));
                }
            }
            return new com.tencent.mobileqq.dt.data.f(isSwitchOn, optBoolean, hashSet);
        } catch (JSONException unused) {
            QLog.e("DTAPIImpl.SecConfig", 1, "parse scan config error " + str);
            return new com.tencent.mobileqq.dt.data.f(false, false, hashSet);
        }
    }

    public static void c() {
        JSONArray jSONArray;
        try {
            String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("102712", new byte[0]));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("modules");
            String optString = jSONObject.optString("gap", "0");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("details");
                if (optJSONObject != null && optJSONObject.length() == optJSONArray.length()) {
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        String string = optJSONArray.getString(i3);
                        if (string != null) {
                            jSONArray = optJSONArray;
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(string);
                            if (optJSONObject2 != null) {
                                arrayList.add(string);
                                arrayList3.add(optJSONObject2.optString("report_rule"));
                                arrayList2.add(optJSONObject2.optString("report_data"));
                            }
                        } else {
                            jSONArray = optJSONArray;
                        }
                        i3++;
                        optJSONArray = jSONArray;
                    }
                }
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "qsec_mmkv_configurations");
                String string2 = fromV2.getString("QSEC.P.CONFIG.module.20240618", "");
                String string3 = fromV2.getString("QSEC.P.CONFIG.rule.20240618", "");
                String string4 = fromV2.getString("QSEC.P.CONFIG.datatype.20240618", "");
                String string5 = fromV2.getString("QSEC.P.CONFIG.gap.20240627", "0");
                String join = TextUtils.join("|", arrayList);
                String join2 = TextUtils.join("|", arrayList3);
                String join3 = TextUtils.join("|", arrayList2);
                if (!TextUtils.equals(string5, optString)) {
                    fromV2.putString("QSEC.P.CONFIG.gap.20240627", optString);
                }
                if (!TextUtils.equals(string2, join)) {
                    fromV2.putString("QSEC.P.CONFIG.module.20240618", join);
                }
                if (!TextUtils.equals(string3, join2)) {
                    fromV2.putString("QSEC.P.CONFIG.rule.20240618", join2);
                }
                if (!TextUtils.equals(string4, join3)) {
                    fromV2.putString("QSEC.P.CONFIG.datatype.20240618", join3);
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    ((O3BusinessHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(O3BusinessHandler.class.getName())).D2("updateModuleConfig", "", new a());
                } else {
                    QLog.e("DTAPIImpl.SecConfig", 1, "updateModuleConfig but runtime is null");
                }
                QLog.d("DTAPIImpl.SecConfig", 1, "specail_task models:" + join + ",rule type:" + join2 + ",data list:" + join3);
            }
        } catch (Throwable th5) {
            QLog.e("DTAPIImpl.SecConfig", 1, "parse config error " + th5);
        }
    }
}
