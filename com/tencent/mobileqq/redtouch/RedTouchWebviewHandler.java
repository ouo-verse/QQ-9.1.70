package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedTouchWebviewHandler extends VasWebviewJsPlugin {
    static IPatchRedirector $redirector_ = null;
    private static final String ERRMSG_EXCEPTION = "exception";
    private static final String ERRMSG_FAILED = "failed";
    private static final String ERRMSG_NO_DATA = "data not prepared or cannot find the path, try again.";
    private static final String ERRMSG_SUCCESS = "success";
    public static final int INTVALUE_UNKNOWN = -1;
    public static final String KEY_CALLBACK = "callback";
    public static final String KEY_ERROR_MSG = "errorMessage";
    public static final String KEY_PATH = "path";
    public static final String KEY_RESULT = "ret";
    public static final String KEY_SRC_TYPE = "srcType";
    public static final String KEY_TYPE = "type";
    public static final int LEBA_ITEM_OFF = 0;
    public static final int LEBA_ITEM_ON = 1;
    public static final String METHOD_GET_LEBA_STATE = "getDynamicState";
    public static final String METHOD_SET_LEBA_STATE = "setDynamicState";
    private static final String OBJECT_NAME = "redpoint";
    public static final String PLUGIN_NAMESPACE = "redpoint";
    public static final String REDBUFFERJSON_2722 = "2722";
    public static final String REDBUFFERJSON_PARAM = "param";
    public static String TAG = null;
    public static final int VALUE_EXCEPTION = -1;
    public static final int VALUE_FAILED = 1;
    public static final int VALUE_SUCCESS = 0;
    private AppInterface browserApp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74536);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            TAG = "RedTouchWebviewHandler";
        }
    }

    public RedTouchWebviewHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private JSONObject getRedBufferJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = jSONObject.getJSONObject("param");
            if (jSONObject3 == null) {
                return null;
            }
            Iterator keys = jSONObject3.keys();
            if (keys.hasNext()) {
                return jSONObject3.getJSONObject((String) keys.next());
            }
            return jSONObject2;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleGetAppinfo(String str, Bundle bundle) {
        String str2;
        String str3;
        int i3;
        int i16;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String string = bundle.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
        BusinessInfoCheckUpdate.AppInfo e16 = g.e((RedAppInfo) bundle.getParcelable("redInfo"));
        ArrayList<String> arrayList = new ArrayList<>();
        String str4 = "";
        if (e16 != null) {
            try {
                List<BusinessInfoCheckUpdate.RedTypeInfo> list = e16.red_display_info.red_type_info.get();
                str3 = e16.path.get();
                try {
                    try {
                        if (e16.type.get() == -1) {
                            arrayList.add("");
                            i3 = -3;
                            jSONObject.put("code", -3);
                            jSONObject.put("errorMessage", "appInfo not found");
                            str2 = "";
                            i16 = 0;
                        } else {
                            jSONObject.put("code", 0);
                            jSONObject2.put("appID", e16.uiAppId.get());
                            jSONObject2.put("iNewFlag", e16.iNewFlag.get());
                            int i17 = e16.iNewFlag.get();
                            JSONArray jSONArray = new JSONArray();
                            i16 = i17;
                            for (int i18 = 0; i18 < e16.missions.size(); i18++) {
                                jSONArray.mo162put(e16.missions.get(i18));
                                arrayList.add(e16.missions.get(i18));
                            }
                            jSONObject2.put("redInfo", RedTouchUtil.buidRedJson(list));
                            jSONObject2.put("missions", jSONArray);
                            jSONObject2.put("type", e16.type.get());
                            jSONObject2.put(QFSEdgeItem.KEY_EXTEND, e16.extend.get());
                            jSONObject2.put("buffer", e16.buffer.get());
                            jSONObject2.put("path", e16.path.get());
                            jSONObject2.put("appset", e16.appset.get());
                            jSONObject2.put("modify_ts", e16.modify_ts.get());
                            jSONObject2.put(WidgetCacheConstellationData.NUM, e16.num.get());
                            jSONObject2.put("push_red_ts", e16.push_red_ts.get());
                            jSONObject.put("data", jSONObject2);
                            str2 = RedTouchUtil.getReportBufferString(e16.buffer.get());
                            i3 = 0;
                        }
                    } catch (JSONException e17) {
                        e = e17;
                        str2 = "";
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "getAppInfo:" + jSONObject.toString());
                        }
                        str4 = str3;
                    } catch (JSONException e18) {
                        e = e18;
                        str3 = str3;
                        e.printStackTrace();
                        arrayList.add("");
                        i3 = -4;
                        i16 = 0;
                        String lastClickPath = RedTouchUtil.getLastClickPath(this.mRuntime.b());
                        if (!TextUtils.isEmpty(str3)) {
                            i16 = 1;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("ret", String.valueOf(i3));
                        bundle2.putString("buffer", str2);
                        bundle2.putString("red", String.valueOf(i16));
                        bundle2.putStringArrayList("missions", arrayList);
                        bundle2.putString("path", str3);
                        bundle2.putString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, string);
                        bundle2.putString("callback", str);
                        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getAppInfo_report", str, this.mOnRemoteResp.key, bundle2), false, true);
                        if (QLog.isColorLevel()) {
                        }
                        callJs(str, jSONObject.toString());
                    }
                } catch (JSONException e19) {
                    e = e19;
                    str2 = "";
                }
            } catch (JSONException e26) {
                e = e26;
                str2 = "";
                str3 = str2;
            }
        } else {
            i3 = -2;
            str2 = "";
            i16 = 0;
        }
        str3 = str4;
        String lastClickPath2 = RedTouchUtil.getLastClickPath(this.mRuntime.b());
        if (!TextUtils.isEmpty(str3) && str3.equals(lastClickPath2)) {
            i16 = 1;
        }
        Bundle bundle22 = new Bundle();
        bundle22.putString("ret", String.valueOf(i3));
        bundle22.putString("buffer", str2);
        bundle22.putString("red", String.valueOf(i16));
        bundle22.putStringArrayList("missions", arrayList);
        bundle22.putString("path", str3);
        bundle22.putString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, string);
        bundle22.putString("callback", str);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getAppInfo_report", str, this.mOnRemoteResp.key, bundle22), false, true);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getAppinfo response:" + jSONObject.toString());
        }
        callJs(str, jSONObject.toString());
    }

    private void handleGetRedpointShowInfo(String str, Bundle bundle) {
        RedTypeInfo redTypeInfo;
        int i3;
        int i16;
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            redTypeInfo = null;
        } else {
            redTypeInfo = (RedTypeInfo) bundle.getSerializable("redInfo");
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("code", 0);
            if (redTypeInfo != null) {
                i3 = redTypeInfo.getRedType();
                i16 = 1;
            } else {
                i3 = -1;
                i16 = 0;
            }
            jSONObject2.put("hintType", i3);
            jSONObject2.put("number", 0);
            jSONObject2.put(ViewStickEventHelper.IS_SHOW, i16);
            jSONObject.put("data", jSONObject2);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRedPointShowInfo:" + jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            try {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing callback");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        callJs(str, jSONObject.toString());
    }

    private void handleLebaItemGet(String str, Bundle bundle) {
        int i3;
        if (bundle == null) {
            i3 = 1;
        } else {
            i3 = bundle.getInt("ret");
        }
        int i16 = -1;
        if (i3 == 0) {
            i16 = bundle.getInt("type", -1);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "get leba item result: " + i3 + ", type: " + i16);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i3);
            jSONObject.put("type", i16);
            if (i3 == 0) {
                jSONObject.put("errorMessage", "success");
            } else {
                jSONObject.put("errorMessage", ERRMSG_NO_DATA);
            }
            callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleLebaItemSet(String str, Bundle bundle) {
        int i3;
        if (bundle == null) {
            i3 = 1;
        } else {
            i3 = bundle.getInt("ret");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set leba item result: " + i3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i3);
            if (i3 == 0) {
                jSONObject.put("errorMessage", "success");
            } else {
                jSONObject.put("errorMessage", "failed");
            }
            callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleRedInfoResponse(String str, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(RedAppInfo.class.getClassLoader());
        String string = bundle.getString("subCmd");
        if (string != null) {
            if ("redTouch_getIndividuationType".equals(string)) {
                handlegetIndivationType(str, bundle);
                return;
            }
            if (!"redTouch_reportRedTouch".equals(string)) {
                if ("redTouch_reportBusinessRedTouch".equals(string)) {
                    handleReportRedtouch(str, bundle);
                } else if ("redTouch_getAppInfo".equals(string)) {
                    handleGetAppinfo(str, bundle);
                } else if ("redTouch_getRedPointShowInfo_path".equals(string)) {
                    handlegetRedpointShowInfoPath(str, bundle);
                }
            }
        }
    }

    private void handleReportRedtouch(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        RedAppInfo redAppInfo = (RedAppInfo) bundle.getParcelable("redInfo");
        String string = bundle.getString("path");
        try {
            JSONObject jSONObject2 = new JSONObject(bundle.getString(ark.ARKMETADATA_JSON));
            Activity a16 = this.mRuntime.a();
            BusinessInfoCheckUpdate.ReportReqBody reportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
            reportReqBody.uin.set(Long.parseLong(this.mRuntime.b().getCurrentAccountUin()));
            reportReqBody.clientver.set(AppSetting.f99554n);
            reportReqBody.platid.set(109);
            reportReqBody.appid.set(((IRedTouchManager) this.mRuntime.b().getRuntimeService(IRedTouchManager.class, "")).getAppIdByPath(string));
            reportReqBody.platver.set(Build.VERSION.SDK_INT + "");
            if (redAppInfo.z() != null) {
                reportReqBody.missionid.set(redAppInfo.z());
            }
            ArrayList arrayList = new ArrayList();
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                BusinessInfoCheckUpdate.ReportStaticsData reportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
                reportStaticsData.key.set(str2);
                reportStaticsData.value.set(jSONObject2.getString(str2));
                arrayList.add(reportStaticsData);
                System.out.println("key:" + reportStaticsData.key.get() + "value:" + reportStaticsData.value.get());
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 5);
            reportReqBody.buffer.set(jSONObject3.toString());
            reportReqBody.reportdata.set(arrayList);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.mRuntime.b().getCurrentAccountUin(), RedTouchConst.Cmd.CMD_RED_TOUCH_CLIENT_REPORT);
            toServiceMsg.putWupBuffer(reportReqBody.toByteArray());
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            long length = toServiceMsg.getWupBuffer().length;
            int i3 = (int) length;
            byte[] bArr = new byte[i3 + 4];
            PkgTools.dWord2Byte(bArr, 0, length + 4);
            PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
            toServiceMsg.putWupBuffer(bArr);
            NewIntent newIntent = new NewIntent(a16.getApplication(), com.tencent.mobileqq.compatible.a.class);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            this.mRuntime.b().startServlet(newIntent);
            jSONObject.put("code", 0);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "reportBusinessRedTouch:" + jSONObject.toString());
            }
        } catch (JSONException e16) {
            try {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing path or callback");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            e16.printStackTrace();
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "reportBusinessRedTouch:" + e18.toString());
            }
        }
        callJs(str, jSONObject.toString());
    }

    private void handleSetAppInfo(String str, Bundle bundle) {
        int i3;
        if (bundle == null) {
            i3 = -1;
        } else {
            i3 = bundle.getInt("iret");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            if (i3 == -3) {
                jSONObject.put("errorMessage", "appInfo not found");
            } else if (i3 == -4) {
                jSONObject.put("errorMessage", "failed to set appInfo");
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "setAppInfo:" + jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJs(str, jSONObject.toString());
    }

    private void handlegetIndivationType(String str, Bundle bundle) {
        JSONObject redBufferJson;
        String str2 = "0";
        JSONObject jSONObject = new JSONObject();
        try {
            RedAppInfo redAppInfo = (RedAppInfo) bundle.getParcelable("redInfo");
            String string = bundle.getString("path");
            if (redAppInfo != null && redAppInfo.M() != 0 && (redBufferJson = getRedBufferJson(new JSONObject(redAppInfo.t()))) != null && redBufferJson.has("_red_ext_busi_")) {
                str2 = redBufferJson.getString("_red_ext_busi_");
            }
            jSONObject.put("result", str2);
            ipcItemClick(string);
        } catch (JSONException e16) {
            e16.printStackTrace();
            try {
                jSONObject.put("result", str2);
                callJs(str, jSONObject.toString());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        callJs(str, jSONObject.toString());
    }

    private void handlegetRedpointShowInfoPath(String str, Bundle bundle) {
        RedAppInfo redAppInfo = (RedAppInfo) bundle.getParcelable("redInfo");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (redAppInfo == null) {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing path");
            } else if (redAppInfo.getType() == -1) {
                jSONObject.put("code", -3);
                jSONObject.put("errorMessage", "appInfo not found");
            } else {
                jSONObject.put("code", 0);
                jSONObject2.put("hintType", redAppInfo.getType());
                jSONObject2.put("number", redAppInfo.B());
                jSONObject2.put(ViewStickEventHelper.IS_SHOW, redAppInfo.M());
                jSONObject.put("data", jSONObject2);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRedPointShowInfo:" + jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            try {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing callback");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        callJs(str, jSONObject.toString());
    }

    private void ipcItemClick(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("myIndividuationRedInfo", null, 0, bundle), false, true);
    }

    public void getAppInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        try {
            if (new JSONObject(str).has("pathList")) {
                getAppInfoList(str);
                return;
            }
        } catch (JSONException unused) {
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo js startime : " + currentTimeMillis);
        }
        ThreadManagerV2.post(new Runnable(currentTimeMillis, str) { // from class: com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f280281d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f280282e;

            {
                this.f280281d = currentTimeMillis;
                this.f280282e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RedTouchWebviewHandler.this, Long.valueOf(currentTimeMillis), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity a16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, Object> parseGetAppInfoList = RedTouchUtil.parseGetAppInfoList(RedTouchWebviewHandler.this.browserApp, this.f280281d, this.f280282e);
                WebViewPlugin.b bVar = RedTouchWebviewHandler.this.mRuntime;
                if (bVar != null && (a16 = bVar.a()) != null) {
                    a16.runOnUiThread(new Runnable(parseGetAppInfoList) { // from class: com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ HashMap f280283d;

                        {
                            this.f280283d = parseGetAppInfoList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) parseGetAppInfoList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str2 = (String) this.f280283d.get("callbackId");
                            Bundle bundle = (Bundle) this.f280283d.get("req");
                            RedTouchWebviewHandler.this.callJs(str2, (String) this.f280283d.get("jsonResult"));
                            RedTouchWebviewHandler.this.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getAppInfo_report", str2, RedTouchWebviewHandler.this.mOnRemoteResp.key, bundle), false, true);
                        }
                    });
                }
            }
        }, 8, null, true);
    }

    public void getAppInfoList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfolist js startime : " + currentTimeMillis);
        }
        ThreadManagerV2.post(new Runnable(currentTimeMillis, str) { // from class: com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f280285d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f280286e;

            {
                this.f280285d = currentTimeMillis;
                this.f280286e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RedTouchWebviewHandler.this, Long.valueOf(currentTimeMillis), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity a16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, Object> parseGetAppInfoList = RedTouchUtil.parseGetAppInfoList(RedTouchWebviewHandler.this.browserApp, this.f280285d, this.f280286e);
                WebViewPlugin.b bVar = RedTouchWebviewHandler.this.mRuntime;
                if (bVar != null && (a16 = bVar.a()) != null) {
                    a16.runOnUiThread(new Runnable(parseGetAppInfoList) { // from class: com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ HashMap f280287d;

                        {
                            this.f280287d = parseGetAppInfoList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) parseGetAppInfoList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str2 = (String) this.f280287d.get("callbackId");
                            Bundle bundle = (Bundle) this.f280287d.get("req");
                            RedTouchWebviewHandler.this.callJs(str2, (String) this.f280287d.get("jsonResult"));
                            RedTouchWebviewHandler.this.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getAppInfo_report", str2, RedTouchWebviewHandler.this.mOnRemoteResp.key, bundle), false, true);
                        }
                    });
                }
            }
        }, 8, null, true);
    }

    public void getDynamicState(String str) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        String str2 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Failed to parse json string: " + str);
            }
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        try {
            str2 = jSONObject.getString("callback");
            Bundle bundle = new Bundle();
            bundle.putInt("path", RedTouchUtil.getAppIdByPath(jSONObject.getString("path")));
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("leba_item_get", str2, this.mOnRemoteResp.key, bundle), false, false);
        } catch (Exception e17) {
            e17.printStackTrace();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ret", -1);
                jSONObject2.put("errorMessage", "exception");
                callJs(str2, jSONObject2.toString());
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "redpoint";
    }

    public void getRedPointShowInfo(String str) {
        String str2 = "callback";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            str2 = jSONObject2.getString("callback");
            if (!jSONObject2.isNull("set")) {
                try {
                    int parseInt = Integer.parseInt(jSONObject2.getString("set"));
                    if (parseInt != 0 && parseInt != 1 && parseInt != 2) {
                        jSONObject.put("code", -3);
                        jSONObject.put("errorMessage", "redPoint showInfo not found");
                        callJs(str2, jSONObject.toString());
                        return;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt("setId", parseInt);
                        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getRedPointShowInfo_set", str2, this.mOnRemoteResp.key, bundle), false, true);
                        return;
                    }
                } catch (Exception unused) {
                    jSONObject.put("code", -3);
                    jSONObject.put("errorMessage", "redPoint showInfo not found");
                    callJs(str2, jSONObject.toString());
                    return;
                }
            }
            if (!jSONObject2.isNull("path")) {
                String string = jSONObject2.getString("path");
                Bundle bundle2 = new Bundle();
                bundle2.putString("path", string);
                bundle2.putString("subCmd", "redTouch_getRedPointShowInfo_path");
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getRedInfo", str2, this.mOnRemoteResp.key, bundle2), false, true);
                return;
            }
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "missing set and path");
            callJs(str2, jSONObject.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing callback");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            callJs(str2, jSONObject.toString());
        }
    }

    public void getServerTime(String str) {
        String str2 = "callback";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            str2 = new JSONObject(str).getString("callback");
            jSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
            jSONObject2.put("data", jSONObject);
            jSONObject2.put("code", 0);
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                jSONObject2.put("code", -1);
                jSONObject2.put("errorMessage", "missing callback");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        callJs(str2, jSONObject2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (str2 == null || !str2.equalsIgnoreCase("redpoint")) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str4 : strArr) {
            arrayList.add(str4);
        }
        return call(str3, arrayList);
    }

    public void isEnterFromRedPoint(String str) {
        String str2 = "callback";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            str2 = jSONObject2.getString("callback");
            if (!RedTouchUtil.getLastClickPath(this.mRuntime.b()).equals(jSONObject2.getString("path"))) {
                jSONObject.put("code", 0);
                jSONObject.put("data", 0);
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("data", 1);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "isEnterFromRedPoint:" + jSONObject.toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing path or callback");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        callJs(str2, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
        } else {
            super.onActivityResult(intent, b16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
            this.browserApp = this.mRuntime.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if ("leba_item_set".equals(string)) {
                handleLebaItemSet(string2, bundle2);
                return;
            }
            if ("leba_item_get".equals(string)) {
                handleLebaItemGet(string2, bundle2);
                return;
            }
            if ("redTouch_setAppInfo".equals(string)) {
                handleSetAppInfo(string2, bundle2);
            } else if ("redTouch_getRedPointShowInfo_set".equals(string)) {
                handleGetRedpointShowInfo(string2, bundle2);
            } else if ("redTouch_getRedInfo".equals(string)) {
                handleRedInfoResponse(string2, bundle2);
            }
        }
    }

    public void reportBusinessRedTouch(String str) {
        String str2 = "callback";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("callback");
            try {
                jSONObject2.remove("callback");
                String string2 = jSONObject2.getString("path");
                jSONObject2.remove("path");
                Bundle bundle = new Bundle();
                bundle.putString("path", string2);
                bundle.putString(ark.ARKMETADATA_JSON, jSONObject2.toString());
                bundle.putString("subCmd", "redTouch_reportBusinessRedTouch");
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getRedInfo", string, this.mOnRemoteResp.key, bundle), false, true);
            } catch (Exception e16) {
                e = e16;
                str2 = string;
                e.printStackTrace();
                try {
                    jSONObject.put("code", -1);
                    jSONObject.put("errorMessage", "missing path or callback");
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                callJs(str2, jSONObject.toString());
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    public void reportRedTouch(String str) {
        String str2 = "callback";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            str2 = jSONObject2.getString("callback");
            String string = jSONObject2.getString("path");
            int i3 = jSONObject2.getInt("isWithRedPoint");
            JSONArray optJSONArray = jSONObject2.optJSONArray("missions");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    String string2 = optJSONArray.getString(i16);
                    if (!TextUtils.isEmpty(string2)) {
                        arrayList.add(string2);
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("path", string);
            bundle.putInt("isWithRedPoint", i3);
            if (arrayList.size() > 0) {
                bundle.putStringArrayList("missions", arrayList);
            }
            bundle.putString("subCmd", "redTouch_reportRedTouch");
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getRedInfo", str2, this.mOnRemoteResp.key, bundle), false, true);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("code", 0);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "reportRedTouch: Exception e = " + e16.getMessage());
                e16.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "reportRedTouch:" + jSONObject3.toString());
            }
            callJs(str2, jSONObject3.toString());
        } catch (Exception e17) {
            e17.printStackTrace();
            try {
                jSONObject.put("code", -1);
                jSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
            callJs(str2, jSONObject.toString());
        }
    }

    public void setAppInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        HashMap<String, Object> parseSetAppInfoParam = RedTouchUtil.parseSetAppInfoParam(str);
        int intValue = ((Integer) parseSetAppInfoParam.get("code")).intValue();
        String str2 = (String) parseSetAppInfoParam.get("callback");
        if (intValue == 0) {
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_setAppInfo", str2, this.mOnRemoteResp.key, (Bundle) parseSetAppInfoParam.get("req")), false, true);
        } else {
            callJs(str2, (String) parseSetAppInfoParam.get("errorJson"));
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void startActivityForResult(Intent intent, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, intent, Byte.valueOf(b16));
        } else {
            super.startActivityForResult(intent, b16);
        }
    }
}
