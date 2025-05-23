package com.tencent.open.agent.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.mobileqq.tianjige.metric.f;
import com.tencent.mobileqq.tianjige.metric.h;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenAuthTelemetryReportMgrImpl implements IOpenAuthTelemetryReportMgr {
    private static final String TAG = "OpenAuthTelemetryReportMgr";
    private static AtomicBoolean hasInitTraceConfig = new AtomicBoolean(false);
    private static AtomicBoolean hasInitMetricConfig = new AtomicBoolean(false);

    private static h getOpenAuthRecorder() {
        return f.b(4);
    }

    private static i getOpenAuthTracer() {
        return com.tencent.mobileqq.tianjige.f.d(4);
    }

    private static void initMetricConfig(String str) {
        if (hasInitMetricConfig.compareAndSet(false, true)) {
            try {
                f.d(4, new a.C8649a().o("qq").m(1.0d).p(str).n(false).k());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "initMetricConfig catch exception", e16);
            }
        }
    }

    public static void initTelemetryConfig(String str) {
        if (hasInitTraceConfig.compareAndSet(false, true)) {
            try {
                com.tencent.mobileqq.tianjige.f.e(4, new a.C8649a().o("qq").m(1.0d).p(str).n(false).k());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "initTelemetryConfig catch exception", e16);
            }
        }
    }

    public static void reportOpenAuth(String str) {
        initTelemetryConfig(str);
        initMetricConfig(str);
        getOpenAuthTracer().t("QOpenAuth", null);
        getOpenAuthTracer().h("QOpenAuth", "QOpenAuth_HandleScheme", null);
        getOpenAuthRecorder().b("QOpen_AuthLoginHandleSchemeCount").a(1L);
    }

    public static void reportOpenAuthCancel() {
        getOpenAuthTracer().h("QOpenAuth", "QOpenAuth_CancelButtonClicked", null);
        getOpenAuthTracer().b("QOpenAuth", 0, null);
        getOpenAuthRecorder().b("QOpen_AuthCancelButtonClickedCount").a(1L);
    }

    public static void reportOpenAuthClickBtn() {
        getOpenAuthTracer().h("QOpenAuth", "QOpenAuth_SubmitButtonClicked", null);
        getOpenAuthRecorder().b("QOpen_AuthSubmitButtonClickedCount").a(1L);
    }

    public static void reportOpenAuthFinish(boolean z16) {
        String str;
        HashMap hashMap = new HashMap(1);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("isSuccess", str);
        getOpenAuthTracer().h("QOpenAuth", "QOpenAuth_Result", hashMap);
        getOpenAuthTracer().b("QOpenAuth", 0, null);
        com.tencent.mobileqq.tianjige.metric.a b16 = getOpenAuthRecorder().b("QOpen_AuthResultCount");
        if (z16) {
            b16.b(1L, "AUTH_RESULT", "AUTH_RESULT_Success");
        } else {
            b16.b(1L, "AUTH_RESULT", "AUTH_RESULT_Fail");
        }
    }

    public static void reportOpenAuthUI() {
        getOpenAuthTracer().h("QOpenAuth", "QOpenAuth_AuthViewShowed", null);
        getOpenAuthRecorder().b("QOpen_AuthLoginViewShowedCount").a(1L);
    }

    @Override // com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr
    public void doReportAction(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString(IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if ("ACTION_INIT".equals(string)) {
            reportOpenAuth(bundle.getString("uin", ""));
            return;
        }
        if ("ACTION_UI_SHOWED".equals(string)) {
            reportOpenAuthUI();
            return;
        }
        if ("ACTION_CLICK_SUBMIT".equals(string)) {
            reportOpenAuthClickBtn();
        } else if ("ACTION_CLICK_CANCEL".equals(string)) {
            reportOpenAuthCancel();
        } else if ("ACTION_AUTH_RESULT".equals(string)) {
            reportOpenAuthFinish(bundle.getBoolean("isSuccess"));
        }
    }
}
