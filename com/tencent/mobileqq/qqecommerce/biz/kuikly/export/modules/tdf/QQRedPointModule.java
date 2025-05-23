package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.g;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tdf.annotation.TDFMethod;
import com.tencent.tdf.annotation.TDFModule;
import com.tencent.tdf.module.TDFModuleContext;
import com.tencent.tdf.module.TDFModulePromise;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@TDFModule(name = QQRedPointModule.CLASSNAME)
/* loaded from: classes35.dex */
public class QQRedPointModule extends QQBaseWebIpcModule {
    static final String CLASSNAME = "QQRedPointModule";
    private static final int CLICK_APPINFO_ERR_CODE_PARAM_FAILED = -1;
    private static final int CLICK_APPINFO_ERR_CODE_SUCCESS = 0;
    private static final int CLICK_APPINFO_ERR_CODE_UNKNOWN = -2;
    private static final int SET_APPINFO_ERR_CODE_NO_APPINFO = -3;
    private static final int SET_APPINFO_ERR_CODE_SET_FAILED = -4;
    private static final int SET_APPINFO_ERR_CODE_UNKNOWN = -1;

    public QQRedPointModule(TDFModuleContext tDFModuleContext) {
        super(tDFModuleContext, MobileQQ.sProcessId != 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clickAppInfoInSubThread, reason: merged with bridge method [inline-methods] */
    public void lambda$clickAppInfo$2(String str, TDFModulePromise tDFModulePromise) {
        String str2;
        if (getAppInterface() == null) {
            handleClickAppInfo(-2, tDFModulePromise);
            return;
        }
        try {
            str2 = new JSONObject(str).optString("path");
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "parseGetAppInfoParams error", e16);
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            handleClickAppInfo(-1, tDFModulePromise);
        } else if (isInMainProcess()) {
            reportClickAppInfoInMainProcess(str2, tDFModulePromise);
        } else {
            reportClickAppInfoByWebIpc(str2, tDFModulePromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAppInfoInSubThread, reason: merged with bridge method [inline-methods] */
    public void lambda$getAppInfo$0(String str, long j3, TDFModulePromise tDFModulePromise) {
        HashMap<String, Object> hashMap;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        try {
            if (new JSONObject(str).has("pathList")) {
                hashMap = RedTouchUtil.parseGetAppInfoList(appInterface, j3, str);
            } else {
                hashMap = RedTouchUtil.parseGetAppInfo(appInterface, j3, str);
            }
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "parseGetAppInfoParams error", e16);
            hashMap = null;
        }
        if (hashMap == null) {
            return;
        }
        tDFModulePromise.resolve((String) hashMap.get("jsonResult"));
        if (isInMainProcess()) {
            reportGetAppInfoInMainProcess(hashMap);
        } else {
            reportGetAppInfoByWebIpc(hashMap, tDFModulePromise);
        }
    }

    private void handleClickAppInfo(int i3, TDFModulePromise tDFModulePromise) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            if (i3 == -1) {
                jSONObject.put("errorMessage", "param is failed");
            }
            if (QLog.isColorLevel()) {
                QLog.i(CLASSNAME, 2, "setAppInfo:" + jSONObject);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (tDFModulePromise != null) {
            tDFModulePromise.resolve(jSONObject.toString());
        }
    }

    private void handleSetAppInfo(int i3, TDFModulePromise tDFModulePromise) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            if (i3 == -3) {
                jSONObject.put("errorMessage", "appInfo not found");
            } else if (i3 == -4) {
                jSONObject.put("errorMessage", "failed to set appInfo");
            }
            if (QLog.isColorLevel()) {
                QLog.i(CLASSNAME, 2, "setAppInfo:" + jSONObject);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (tDFModulePromise != null) {
            tDFModulePromise.resolve(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportClickAppInfoByWebIpc$3(String str, TDFModulePromise tDFModulePromise) {
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("myIndividuationRedInfo", "", 0, bundle), false, true);
        handleClickAppInfo(0, tDFModulePromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportGetAppInfoByWebIpc$1(TDFModulePromise tDFModulePromise, HashMap hashMap) {
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getAppInfo_report", tDFModulePromise.getCallId(), getIPCRequestKey(), (Bundle) hashMap.get("req")), false, true);
    }

    private void reportClickAppInfoByWebIpc(final String str, final TDFModulePromise tDFModulePromise) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.b
            @Override // java.lang.Runnable
            public final void run() {
                QQRedPointModule.this.lambda$reportClickAppInfoByWebIpc$3(str, tDFModulePromise);
            }
        });
    }

    private void reportClickAppInfoInMainProcess(String str, TDFModulePromise tDFModulePromise) {
        ((IRedTouchManager) getAppInterface().getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(str);
        handleClickAppInfo(0, tDFModulePromise);
    }

    private void reportGetAppInfoByWebIpc(final HashMap<String, Object> hashMap, final TDFModulePromise tDFModulePromise) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.a
            @Override // java.lang.Runnable
            public final void run() {
                QQRedPointModule.this.lambda$reportGetAppInfoByWebIpc$1(tDFModulePromise, hashMap);
            }
        });
    }

    private void reportGetAppInfoInMainProcess(HashMap<String, Object> hashMap) {
        Bundle bundle = (Bundle) hashMap.get("req");
        String string = bundle.getString("ret");
        String string2 = bundle.getString("buffer");
        String string3 = bundle.getString("red");
        String string4 = bundle.getString("path");
        String string5 = bundle.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
        String string6 = bundle.getString("callback");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("missions");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) getAppInterface().getRuntimeService(IRedTouchManager.class, "");
        iRedTouchManager.getAndSetAppInfoJsReport(12, stringArrayList, string3, string, string2, string5, string6, iRedTouchManager.getAppIdByPath(string4));
    }

    private void setAppInfoByWebIpc(HashMap<String, Object> hashMap, TDFModulePromise tDFModulePromise) {
        String callId = tDFModulePromise.getCallId();
        saveCallback(tDFModulePromise);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_setAppInfo", callId, getIPCRequestKey(), (Bundle) hashMap.get("req")), false, true);
    }

    private void setAppInfoInMainProcess(HashMap<String, Object> hashMap, TDFModulePromise tDFModulePromise) {
        BusinessInfoCheckUpdate.AppInfo e16 = g.e((RedAppInfo) ((Bundle) hashMap.get("req")).getParcelable("red"));
        IRedTouchManager iRedTouchManager = (IRedTouchManager) getAppInterface().getRuntimeService(IRedTouchManager.class, "");
        if (e16 != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(e16.missions.get());
            iRedTouchManager.getAndSetAppInfoJsReport(13, arrayList, e16.iNewFlag.get() + "", "", iRedTouchManager.getSetAppInfoReportMsg(e16.path.get(), e16.buffer.get()), "", "", iRedTouchManager.getAppIdByPath(e16.path.get()));
        }
        handleSetAppInfo(iRedTouchManager.updateAppInfo(e16, false), tDFModulePromise);
    }

    @TDFMethod(name = "clickAppInfo")
    public void clickAppInfo(final String str, final TDFModulePromise tDFModulePromise) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.d
            @Override // java.lang.Runnable
            public final void run() {
                QQRedPointModule.this.lambda$clickAppInfo$2(str, tDFModulePromise);
            }
        }, 8, null, true);
    }

    @TDFMethod(name = "getAppInfo")
    public void getAppInfo(final String str, final TDFModulePromise tDFModulePromise) {
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.c
            @Override // java.lang.Runnable
            public final void run() {
                QQRedPointModule.this.lambda$getAppInfo$0(str, currentTimeMillis, tDFModulePromise);
            }
        }, 8, null, true);
    }

    protected int getIPCRequestKey() {
        t tVar = this.mOnRemoteResp;
        if (tVar != null) {
            return tVar.key;
        }
        return 0;
    }

    @TDFMethod(name = "isEnterFromRedPoint")
    public void isEnterFromRedPoint(String str, TDFModulePromise tDFModulePromise) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            hashMap.put("code", -1);
            hashMap.put("errorMessage", "path params is empty");
            tDFModulePromise.resolve(hashMap);
        } else {
            boolean equals = RedTouchUtil.getLastClickPath(getAppInterface()).equals(str);
            hashMap.put("code", 0);
            hashMap.put("data", Integer.valueOf(equals ? 1 : 0));
            tDFModulePromise.resolve(hashMap);
        }
    }

    @TDFMethod(name = "setAppInfo")
    public void setAppInfo(String str, TDFModulePromise tDFModulePromise) {
        HashMap<String, Object> parseSetAppInfoParam = RedTouchUtil.parseSetAppInfoParam(str);
        if (((Integer) parseSetAppInfoParam.get("code")).intValue() != 0) {
            tDFModulePromise.resolve((String) parseSetAppInfoParam.get("errorJson"));
        } else if (isInMainProcess()) {
            setAppInfoInMainProcess(parseSetAppInfoParam, tDFModulePromise);
        } else {
            setAppInfoByWebIpc(parseSetAppInfoParam, tDFModulePromise);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.QQBaseWebIpcModule
    protected void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == getIPCRequestKey()) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if ("redTouch_setAppInfo".equals(string)) {
                handleSetAppInfo(bundle2 == null ? -1 : bundle2.getInt("iret"), getCallback(string2));
            }
        }
    }
}
