package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.api.ITianshuTempApi;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes11.dex */
public class OnlinePushJumpReportUtil {
    static IPatchRedirector $redirector_;

    public static void a(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            Uri data = activity.getIntent().getData();
            if (data != null) {
                String queryParameter = data.getQueryParameter("tianshu_app_open_source");
                if (!TextUtils.isEmpty(queryParameter)) {
                    ((ITianshuTempApi) QRoute.api(ITianshuTempApi.class)).setHalfLayerADParams(queryParameter, "OnlinePushJumpReportUtil");
                }
            }
            int intExtra = activity.getIntent().getIntExtra("KEY_MAIN_BUSINESS_ID", -1);
            int intExtra2 = activity.getIntent().getIntExtra("KEY_SUB_BUSINESS_ID", 0);
            int intExtra3 = activity.getIntent().getIntExtra("KEY_PUSH_ID", 0);
            String stringExtra = activity.getIntent().getStringExtra("KEY_PUSH_TRIGGER_INFO");
            String stringExtra2 = activity.getIntent().getStringExtra("KEY_PUSH_IS_FROM");
            if (intExtra != -1 && intExtra3 != 0) {
                ReportController.o(null, "dc00898", "", "", "0X800AE74", "0X800AE74", intExtra, 0, String.valueOf(intExtra2), String.valueOf(intExtra3), "", "");
                ThreadManagerV2.excute(new Runnable(intExtra3, stringExtra, stringExtra2) { // from class: com.tencent.mobileqq.app.parser.OnlinePushJumpReportUtil.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f196431d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f196432e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f196433f;

                    {
                        this.f196431d = intExtra3;
                        this.f196432e = stringExtra;
                        this.f196433f = stringExtra2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(intExtra3), stringExtra, stringExtra2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        TianShuReportData tianShuReportData = new TianShuReportData();
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        tianShuReportData.mTraceId = MobileQQ.sMobileQQ.peekAppRuntime().getAccount() + util.base64_pad_url + currentTimeMillis;
                        tianShuReportData.mActionId = 118;
                        tianShuReportData.mActionValue = 1;
                        tianShuReportData.mItemId = String.valueOf(this.f196431d);
                        tianShuReportData.mOperTime = currentTimeMillis;
                        tianShuReportData.mTriggerInfo = this.f196432e;
                        tianShuReportData.mTraceNum = 1;
                        GuardManager guardManager = GuardManager.sInstance;
                        if (guardManager != null) {
                            if (guardManager.isApplicationForeground()) {
                                str = "0";
                            } else {
                                str = "1";
                            }
                            tianShuReportData.mPositionId = str;
                        }
                        tianShuReportData.mBusiInfo = "{\"msgFrom\":\"" + this.f196433f + "\"}";
                        tianShuReportData.mAppId = "vab_push";
                        tianShuReportData.mPageId = "vab_push";
                        tianShuReportData.mModuleId = "";
                        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
                    }
                }, 16, null, true);
                QLog.d("OnlinePushJumpReportUtil", 1, "tianShuReportPushClick: called.  | mainBusinessId = " + intExtra + " | subBusinessId = " + intExtra2 + " | pushId = " + intExtra3 + " | pushTriggerInfo = " + stringExtra + " | from = " + stringExtra2 + " | activity = " + activity);
                return;
            }
            QLog.e("OnlinePushJumpReportUtil", 1, "reportPushClick: called. ", "no need report mainBusinessId: " + intExtra);
            return;
        }
        QLog.e("OnlinePushJumpReportUtil", 1, "tianShuReportPushClick  params error");
    }
}
