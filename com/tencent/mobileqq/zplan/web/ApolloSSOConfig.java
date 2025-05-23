package com.tencent.mobileqq.zplan.web;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.h;
import com.tencent.mobileqq.zplan.web.api.impl.ZPlanWebDataHandlerImpl;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$RspItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ApolloSSOConfig {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, f> f335966a = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f335969d;

        a(AppInterface appInterface) {
            this.f335969d = appInterface;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            long currentTimeMillis = System.currentTimeMillis();
            ApolloSSOConfig.this.i(this.f335969d, z16, bundle);
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "checkRequestSendSSO, type:" + i3 + "isSuccess:" + z16 + "onReceive use:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f335971a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f335972b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ApolloSSOConfig f335973c;

        b(SharedPreferences sharedPreferences, int i3, ApolloSSOConfig apolloSSOConfig) {
            this.f335971a = sharedPreferences;
            this.f335972b = i3;
            this.f335973c = apolloSSOConfig;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            super.onDone(gVar);
            QLog.i("[zplan]apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + gVar.i() + ", httpCode: " + gVar.O);
            if (3 == gVar.i()) {
                this.f335971a.edit().putInt(ZPlanWebDataHandlerImpl.SP_KEY_WEBVIEW_CONFIG_VERSION, this.f335972b).commit();
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.f335972b);
                }
                ApolloSSOConfig apolloSSOConfig = this.f335973c;
                if (apolloSSOConfig != null) {
                    apolloSSOConfig.n();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f335974a;

        /* renamed from: b, reason: collision with root package name */
        public String f335975b;

        /* renamed from: d, reason: collision with root package name */
        public final List<e> f335977d = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap<String, String> f335976c = new HashMap<>();

        public boolean a() {
            return (TextUtils.isEmpty(this.f335974a) || TextUtils.isEmpty(this.f335975b)) ? false : true;
        }

        public String b(boolean z16) {
            if (!a()) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            try {
                int size = this.f335977d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e eVar = this.f335977d.get(i3);
                    if (eVar != null && !TextUtils.isEmpty(eVar.f335981a)) {
                        int i16 = eVar.f335983c;
                        if (i16 == 6 || i16 == 7) {
                            if (!TextUtils.isEmpty(Uri.parse(this.f335974a).getQueryParameter(eVar.f335982b))) {
                                if (z16) {
                                    sb5.append(URLUtil.encodeUrl(eVar.f335981a));
                                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb5.append(URLUtil.encodeUrl(eVar.f335982b));
                                } else {
                                    sb5.append(eVar.f335981a);
                                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb5.append(eVar.f335982b);
                                }
                                if (i3 != size - 1) {
                                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                                }
                            }
                        } else if (i16 == 8) {
                            if (z16) {
                                sb5.append(URLUtil.encodeUrl(eVar.f335981a));
                                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                sb5.append(System.currentTimeMillis());
                            } else {
                                sb5.append(eVar.f335981a);
                                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                sb5.append(System.currentTimeMillis());
                            }
                            if (i3 != size - 1) {
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                        } else {
                            if (z16) {
                                sb5.append(URLUtil.encodeUrl(eVar.f335981a));
                                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                sb5.append(URLUtil.encodeUrl(eVar.f335982b));
                            } else {
                                sb5.append(eVar.f335981a);
                                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                sb5.append(eVar.f335982b);
                            }
                            if (i3 != size - 1) {
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("[zplan]apollo_client_ApolloSSOConfig", 1, e16, new Object[0]);
            }
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "getParameterStr parameterBuilder:", sb5.toString());
            }
            return sb5.toString();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("CGIConfig{");
            stringBuffer.append("mUrl='");
            stringBuffer.append(this.f335974a);
            stringBuffer.append('\'');
            stringBuffer.append(", mMethod='");
            stringBuffer.append(this.f335975b);
            stringBuffer.append('\'');
            stringBuffer.append(", mHeaders=");
            stringBuffer.append(this.f335976c);
            stringBuffer.append(", mParameters=");
            stringBuffer.append(this.f335977d);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f335978a;

        /* renamed from: b, reason: collision with root package name */
        public int f335979b;

        /* renamed from: c, reason: collision with root package name */
        public final List<e> f335980c = new ArrayList();

        public JSONObject a(String str, AppInterface appInterface) {
            if (this.f335980c == null || appInterface == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            Iterator<e> it = this.f335980c.iterator();
            while (it.hasNext()) {
                it.next().a(str, jSONObject, appInterface);
            }
            return jSONObject;
        }

        public String toString() {
            return "mClientId:" + this.f335979b + " mCmdSSOName:" + this.f335978a + " mParameters:" + this.f335980c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f335984a;

        /* renamed from: b, reason: collision with root package name */
        public String f335985b;

        /* renamed from: c, reason: collision with root package name */
        public List<d> f335986c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public List<c> f335987d = new ArrayList();

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("ThunderConfig{");
            stringBuffer.append("mPageId=");
            stringBuffer.append(this.f335984a);
            stringBuffer.append(", mMd5='");
            stringBuffer.append(this.f335985b);
            stringBuffer.append('\'');
            stringBuffer.append(", mCmdConfigs=");
            stringBuffer.append(this.f335986c);
            stringBuffer.append(", mCGIConfigs=");
            stringBuffer.append(this.f335987d);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public ApolloSSOConfig() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AppInterface appInterface, boolean z16, Bundle bundle) {
        if (appInterface == null || bundle == null || !z16) {
            return;
        }
        try {
            ClubContentUpdateInfoPb$RspBody clubContentUpdateInfoPb$RspBody = new ClubContentUpdateInfoPb$RspBody();
            clubContentUpdateInfoPb$RspBody.mergeFrom(bundle.getByteArray("extra_data"));
            if (clubContentUpdateInfoPb$RspBody.int_result.get() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "handleReceiveSSO, result=" + clubContentUpdateInfoPb$RspBody.int_result.get());
                    return;
                }
                return;
            }
            Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspBody.rpt_msg_rspappinfo.get()).iterator();
            while (it.hasNext()) {
                ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo = (ClubContentUpdateInfoPb$RspAppInfo) it.next();
                if (clubContentUpdateInfoPb$RspAppInfo != null && clubContentUpdateInfoPb$RspAppInfo.uint_appid.get() == 205 && clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.has() && clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.size() > 0) {
                    ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get().get(0);
                    String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
                    int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
                    String str2 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
                    int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
                    d(this, appInterface, i3, 1 == (i16 & 1));
                    QLog.i("[zplan]apollo_client_ApolloSSOConfig", 1, "handleApolloWebViewResponse apollo_client ApolloWebView Config json: " + str + ", ver: " + i3 + ", updateFlag: " + i16 + ", extStr: " + str2);
                }
            }
        } catch (Exception e16) {
            QLog.e("[zplan]apollo_client_ApolloSSOConfig", 1, "handleReceiveSSO error :" + e16.getMessage());
        }
    }

    private void m() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.ApolloSSOConfig.1
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface;
                if (ApolloSSOConfig.this.n() || (appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")) == null) {
                    return;
                }
                int i3 = BaseApplicationImpl.getApplication().getSharedPreferences(ZPlanWebDataHandlerImpl.SP_KEY_NAME, 4).getInt(ZPlanWebDataHandlerImpl.SP_KEY_WEBVIEW_CONFIG_VERSION, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "new ApolloSSOConfig updateConfigsFromDb=false, checkUpdateApolloWebViewConfig");
                }
                ApolloSSOConfig.d(ApolloSSOConfig.this, appInterface, i3, true);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0301  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        int i3;
        JSONArray jSONArray;
        int i16;
        JSONArray jSONArray2;
        int i17;
        JSONArray jSONArray3;
        int i18;
        JSONArray optJSONArray;
        JSONArray jSONArray4;
        int i19;
        JSONArray jSONArray5;
        int i26;
        JSONArray jSONArray6;
        int i27;
        ApolloSSOConfig apolloSSOConfig = this;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(com.tencent.mobileqq.zplan.web.a.g());
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "updateConfigsFromDb use:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return false;
        }
        try {
            String h16 = com.tencent.mobileqq.zplan.web.a.h(file);
            if (TextUtils.isEmpty(h16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, ApolloClientUtil.readFileSafety null");
                }
                return false;
            }
            JSONArray optJSONArray2 = new JSONObject(h16).optJSONObject("data").optJSONArray("thunderConfig");
            apolloSSOConfig.f335966a.clear();
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, content:" + h16);
            }
            if (optJSONArray2 == null) {
                return false;
            }
            int length = optJSONArray2.length();
            int i28 = 0;
            while (i28 < length) {
                try {
                    JSONObject jSONObject = optJSONArray2.getJSONObject(i28);
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("pageId");
                        String optString = jSONObject.optString("md5");
                        if (!TextUtils.isEmpty(optString)) {
                            f fVar = new f();
                            fVar.f335984a = optInt;
                            fVar.f335985b = optString;
                            apolloSSOConfig.f335966a.put(String.valueOf(optInt), fVar);
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("cmds");
                            if (optJSONArray3 != null) {
                                int length2 = optJSONArray3.length();
                                int i29 = 0;
                                while (i29 < length2) {
                                    JSONObject optJSONObject = optJSONArray3.optJSONObject(i29);
                                    if (optJSONObject == null) {
                                        i18 = length;
                                    } else {
                                        i18 = length;
                                        String optString2 = optJSONObject.optString("name");
                                        if (!TextUtils.isEmpty(optString2) && (optJSONArray = optJSONObject.optJSONArray("parameters")) != null) {
                                            jSONArray4 = optJSONArray2;
                                            int length3 = optJSONArray.length();
                                            if (QLog.isColorLevel()) {
                                                i19 = length2;
                                                StringBuilder sb5 = new StringBuilder();
                                                jSONArray5 = optJSONArray3;
                                                sb5.append("updateConfigsFromDb, cmdName:");
                                                sb5.append(optString2);
                                                sb5.append(",parameterLength:");
                                                sb5.append(length3);
                                                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 1, sb5.toString());
                                            } else {
                                                i19 = length2;
                                                jSONArray5 = optJSONArray3;
                                            }
                                            ArrayList arrayList = new ArrayList();
                                            int i36 = 0;
                                            while (i36 < length3) {
                                                int i37 = length3;
                                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i36);
                                                if (optJSONObject2 == null) {
                                                    jSONArray6 = optJSONArray;
                                                } else {
                                                    jSONArray6 = optJSONArray;
                                                    String optString3 = optJSONObject2.optString("key");
                                                    if (!TextUtils.isEmpty(optString3)) {
                                                        String optString4 = optJSONObject2.optString("value");
                                                        int optInt2 = optJSONObject2.optInt("valueType");
                                                        i27 = i28;
                                                        e eVar = new e();
                                                        eVar.f335981a = optString3;
                                                        eVar.f335983c = optInt2;
                                                        eVar.f335982b = optString4;
                                                        arrayList.add(eVar);
                                                        i36++;
                                                        length3 = i37;
                                                        optJSONArray = jSONArray6;
                                                        i28 = i27;
                                                    }
                                                }
                                                i27 = i28;
                                                i36++;
                                                length3 = i37;
                                                optJSONArray = jSONArray6;
                                                i28 = i27;
                                            }
                                            i26 = i28;
                                            d dVar = new d();
                                            dVar.f335978a = optString2;
                                            dVar.f335979b = optInt;
                                            dVar.f335980c.addAll(arrayList);
                                            fVar.f335986c.add(dVar);
                                            i29++;
                                            length = i18;
                                            optJSONArray2 = jSONArray4;
                                            length2 = i19;
                                            optJSONArray3 = jSONArray5;
                                            i28 = i26;
                                        }
                                    }
                                    jSONArray4 = optJSONArray2;
                                    i26 = i28;
                                    i19 = length2;
                                    jSONArray5 = optJSONArray3;
                                    i29++;
                                    length = i18;
                                    optJSONArray2 = jSONArray4;
                                    length2 = i19;
                                    optJSONArray3 = jSONArray5;
                                    i28 = i26;
                                }
                            }
                            i3 = length;
                            jSONArray = optJSONArray2;
                            i16 = i28;
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("cgis");
                            if (optJSONArray4 != null) {
                                int length4 = optJSONArray4.length();
                                int i38 = 0;
                                while (i38 < length4) {
                                    JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i38);
                                    if (optJSONObject3 != null) {
                                        String optString5 = optJSONObject3.optString("url");
                                        if (!TextUtils.isEmpty(optString5)) {
                                            String optString6 = optJSONObject3.optString("method");
                                            if (!TextUtils.isEmpty(optString6)) {
                                                c cVar = new c();
                                                cVar.f335974a = optString5;
                                                cVar.f335975b = optString6;
                                                JSONArray optJSONArray5 = optJSONObject3.optJSONArray("parameters");
                                                if (optJSONArray5 != null) {
                                                    int length5 = optJSONArray5.length();
                                                    ArrayList arrayList2 = new ArrayList();
                                                    if (QLog.isColorLevel()) {
                                                        jSONArray2 = optJSONArray4;
                                                        StringBuilder sb6 = new StringBuilder();
                                                        i17 = length4;
                                                        sb6.append("updateConfigsFromDb cgis url:");
                                                        sb6.append(optString5);
                                                        sb6.append(" method:");
                                                        sb6.append(optString6);
                                                        sb6.append(" parameterLength:");
                                                        sb6.append(length5);
                                                        QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, sb6.toString());
                                                    } else {
                                                        jSONArray2 = optJSONArray4;
                                                        i17 = length4;
                                                    }
                                                    int i39 = 0;
                                                    while (i39 < length5) {
                                                        JSONObject optJSONObject4 = optJSONArray5.optJSONObject(i39);
                                                        if (optJSONObject4 != null) {
                                                            String optString7 = optJSONObject4.optString("key");
                                                            if (!TextUtils.isEmpty(optString7)) {
                                                                String optString8 = optJSONObject4.optString("value");
                                                                int optInt3 = optJSONObject4.optInt("valueType");
                                                                jSONArray3 = optJSONArray5;
                                                                e eVar2 = new e();
                                                                eVar2.f335981a = optString7;
                                                                eVar2.f335983c = optInt3;
                                                                eVar2.f335982b = optString8;
                                                                arrayList2.add(eVar2);
                                                                i39++;
                                                                optJSONArray5 = jSONArray3;
                                                            }
                                                        }
                                                        jSONArray3 = optJSONArray5;
                                                        i39++;
                                                        optJSONArray5 = jSONArray3;
                                                    }
                                                    cVar.f335977d.addAll(arrayList2);
                                                } else {
                                                    jSONArray2 = optJSONArray4;
                                                    i17 = length4;
                                                }
                                                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("headers");
                                                if (optJSONObject5 != null) {
                                                    Iterator keys = optJSONObject5.keys();
                                                    while (keys.hasNext()) {
                                                        String str = (String) keys.next();
                                                        cVar.f335976c.put(str, optJSONObject5.optString(str));
                                                    }
                                                }
                                                fVar.f335987d.add(cVar);
                                                i38++;
                                                optJSONArray4 = jSONArray2;
                                                length4 = i17;
                                            }
                                        }
                                    }
                                    jSONArray2 = optJSONArray4;
                                    i17 = length4;
                                    i38++;
                                    optJSONArray4 = jSONArray2;
                                    length4 = i17;
                                }
                            }
                            i28 = i16 + 1;
                            apolloSSOConfig = this;
                            length = i3;
                            optJSONArray2 = jSONArray;
                        }
                    }
                    i3 = length;
                    jSONArray = optJSONArray2;
                    i16 = i28;
                    i28 = i16 + 1;
                    apolloSSOConfig = this;
                    length = i3;
                    optJSONArray2 = jSONArray;
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                    }
                    QLog.e("[zplan]apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb error :" + e.getMessage());
                    return false;
                }
            }
            if (!QLog.isColorLevel()) {
                return true;
            }
            int i46 = BaseApplication.getContext().getSharedPreferences(ZPlanWebDataHandlerImpl.SP_KEY_NAME, 4).getInt(ZPlanWebDataHandlerImpl.SP_KEY_WEBVIEW_CONFIG_VERSION, 0);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("mCurrentConfigVersion:");
            sb7.append(i46);
            sb7.append("mThunderConfigs:");
            try {
                sb7.append(this.f335966a);
                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, sb7.toString());
                return true;
            } catch (Exception e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    e.printStackTrace();
                }
                QLog.e("[zplan]apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb error :" + e.getMessage());
                return false;
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    public JSONObject e(String str, String str2, String str3, AppInterface appInterface) {
        f fVar;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && appInterface != null && (fVar = this.f335966a.get(str2)) != null) {
            for (d dVar : fVar.f335986c) {
                if (dVar != null && str3.equals(dVar.f335978a)) {
                    return dVar.a(str, appInterface);
                }
            }
        }
        return null;
    }

    public List<c> f(String str) {
        f fVar = this.f335966a.get(str);
        if (fVar != null) {
            return fVar.f335987d;
        }
        return null;
    }

    public String g(String str) {
        f fVar;
        if (!TextUtils.isEmpty(str) && (fVar = this.f335966a.get(str)) != null) {
            return fVar.f335985b;
        }
        return "";
    }

    public Set<String> h(String str) {
        f fVar;
        if (TextUtils.isEmpty(str) || (fVar = this.f335966a.get(str)) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (d dVar : fVar.f335986c) {
            if (dVar != null && !TextUtils.isEmpty(dVar.f335978a)) {
                hashSet.add(dVar.f335978a);
            }
        }
        return hashSet;
    }

    public boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f335966a.containsKey(str);
    }

    public boolean k(String str, String str2) {
        f fVar;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (fVar = this.f335966a.get(str)) == null) {
            return false;
        }
        for (d dVar : fVar.f335986c) {
            if (dVar != null && str2.equals(dVar.f335978a)) {
                return true;
            }
        }
        return false;
    }

    public String l(String str, String str2) {
        return str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f335981a;

        /* renamed from: b, reason: collision with root package name */
        public String f335982b;

        /* renamed from: c, reason: collision with root package name */
        public int f335983c = 0;

        e() {
        }

        public String toString() {
            return "mKey:" + this.f335981a + " mValue:" + this.f335982b + " mType:" + this.f335983c;
        }

        public void a(String str, JSONObject jSONObject, AppInterface appInterface) {
            if (jSONObject != null) {
                try {
                    if (!TextUtils.isEmpty(this.f335981a)) {
                        int i3 = this.f335983c;
                        if (i3 == 0) {
                            jSONObject.put(this.f335981a, this.f335982b);
                        } else if (i3 == 1) {
                            jSONObject.put(this.f335981a, Integer.parseInt(this.f335982b));
                        } else if (i3 == 2) {
                            jSONObject.put(this.f335981a, Long.parseLong(this.f335982b));
                        } else if (i3 == 3) {
                            jSONObject.put(this.f335981a, Float.parseFloat(this.f335982b));
                        } else if (i3 == 4) {
                            jSONObject.put(this.f335981a, Long.parseLong(appInterface.getCurrentAccountUin()));
                        } else if (i3 == 5) {
                            jSONObject.put(this.f335981a, appInterface.getCurrentAccountUin());
                        } else if (i3 == 8) {
                            jSONObject.put(this.f335981a, System.currentTimeMillis());
                        } else if (i3 == 6) {
                            if (!TextUtils.isEmpty(str)) {
                                String queryParameter = Uri.parse(str).getQueryParameter(this.f335982b);
                                if (!TextUtils.isEmpty(queryParameter)) {
                                    jSONObject.put(this.f335981a, Long.parseLong(queryParameter));
                                }
                            }
                        } else if (i3 == 7 && !TextUtils.isEmpty(str)) {
                            String queryParameter2 = Uri.parse(str).getQueryParameter(this.f335982b);
                            if (!TextUtils.isEmpty(queryParameter2)) {
                                jSONObject.put(this.f335981a, queryParameter2);
                            }
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("[zplan]apollo_client_ApolloSSOConfig", 1, e16, new Object[0]);
                }
            }
        }
    }

    public static void d(ApolloSSOConfig apolloSSOConfig, final AppRuntime appRuntime, int i3, boolean z16) {
        SharedPreferences sharedPreferences;
        if (appRuntime == null || (sharedPreferences = appRuntime.getApplication().getSharedPreferences(ZPlanWebDataHandlerImpl.SP_KEY_NAME, 4)) == null) {
            return;
        }
        int i16 = sharedPreferences.getInt(ZPlanWebDataHandlerImpl.SP_KEY_WEBVIEW_CONFIG_VERSION, 0);
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "apollo_client checkUpdateApolloWebViewConfig, oldVersion" + i16 + ",version:" + i3);
        }
        File file = new File(com.tencent.mobileqq.zplan.web.a.g());
        if (i3 > 0 && !file.exists()) {
            z16 = true;
        }
        sharedPreferences.edit().putLong(ZPlanWebDataHandlerImpl.SP_KEY_SSO_CHECK_TIME, System.currentTimeMillis()).commit();
        if (!z16 && i3 <= i16) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig local config is new\uff0c not need to download");
                return;
            }
            return;
        }
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        final com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_thunder_config/xydata.json", file);
        gVar.U = true;
        gVar.Q = true;
        gVar.S = "apollo_res";
        gVar.f313008f = 1;
        gVar.W = true;
        gVar.X = true;
        gVar.u(new b(sharedPreferences, i3, apolloSSOConfig));
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.ApolloSSOConfig.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                h c16 = com.tencent.mobileqq.zplan.download.a.c(AppRuntime.this);
                if (c16 != null) {
                    com.tencent.mobileqq.vip.g gVar2 = gVar;
                    c16.startDownload(gVar2, gVar2.g(), null);
                    z17 = false;
                } else {
                    DownloaderFactory.o(gVar, null);
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig async:" + z17);
                }
            }
        });
    }

    public void c(AppInterface appInterface) {
        if (appInterface == null) {
            return;
        }
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences(ZPlanWebDataHandlerImpl.SP_KEY_NAME, 4);
        if (System.currentTimeMillis() - sharedPreferences.getLong(ZPlanWebDataHandlerImpl.SP_KEY_SSO_CHECK_TIME, 0L) > 1800000) {
            ClubContentUpdateInfoPb$ReqBody clubContentUpdateInfoPb$ReqBody = new ClubContentUpdateInfoPb$ReqBody();
            String currentAccountUin = appInterface.getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                QLog.e("[zplan]apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO account is null!");
                return;
            }
            clubContentUpdateInfoPb$ReqBody.int_protocolver.set(1);
            clubContentUpdateInfoPb$ReqBody.uint_clientplatid.set(109);
            clubContentUpdateInfoPb$ReqBody.str_clientver.set(AppSetting.f99554n);
            clubContentUpdateInfoPb$ReqBody.uint_uin.set(Long.parseLong(currentAccountUin));
            int i3 = sharedPreferences.getInt(ZPlanWebDataHandlerImpl.SP_KEY_WEBVIEW_CONFIG_VERSION, 0);
            ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
            clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(i3);
            clubContentUpdateInfoPb$ReqItemInfo.str_name.set("apollo_thunder_json_v670");
            ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
            clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(205);
            clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.add(clubContentUpdateInfoPb$ReqItemInfo);
            ArrayList arrayList = new ArrayList();
            arrayList.add(clubContentUpdateInfoPb$ReqAppInfo);
            clubContentUpdateInfoPb$ReqBody.rpt_msg_reqappinfo.set(arrayList);
            NewIntent newIntent = new NewIntent(appInterface.getApp(), am.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "ClubContentUpdate.Req");
            newIntent.putExtra("extra_data", clubContentUpdateInfoPb$ReqBody.toByteArray());
            newIntent.putExtra("extra_callbackid", appInterface.getCurrentAccountUin());
            newIntent.setObserver(new a(appInterface));
            appInterface.startServlet(newIntent);
            QLog.i("[zplan]apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO local ver: " + i3);
        }
    }
}
