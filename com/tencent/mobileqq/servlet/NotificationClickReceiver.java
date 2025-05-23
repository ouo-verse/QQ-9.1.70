package com.tencent.mobileqq.servlet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.part.QFSPublishNotification;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleNotificationReporter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NotificationClickReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f286436a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f286436a = new String[]{"com.tencent.mobileqq.activity.SplashActivity", "com.tencent.mobileqq.activity.NearbyActivity", "com.tencent.mobileqq.activity.ChatActivity"};
        }
    }

    public NotificationClickReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra("qcircle_publish_traceid");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.i("pushReport", 1, "[reportPublishClick] not publish notification");
            return;
        }
        QLog.i("pushReport", 1, "[reportPublishClick] traceId=" + stringExtra);
        String stringExtra2 = intent.getStringExtra("qcircle_publish_status");
        String stringExtra3 = intent.getStringExtra("qcircle_publish_missionid");
        String stringExtra4 = intent.getStringExtra("qcircle_publish_taskid");
        WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
        builder.eventId(QCirclePublishQualityReporter.E_NOTIFICATION_CLICK).traceId(stringExtra).ext1(stringExtra2).ext2(String.valueOf(QFSPublishNotification.f87509a.c())).ext3(stringExtra3).ext4(stringExtra4);
        WinkPublishReportQueue.INSTANCE.report(builder.getReportData(), "QCIRCLE");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0125 A[Catch: Exception -> 0x01a1, TryCatch #0 {Exception -> 0x01a1, blocks: (B:22:0x00aa, B:25:0x00c5, B:27:0x00ce, B:28:0x00f0, B:30:0x00fe, B:32:0x0108, B:33:0x0119, B:35:0x0125, B:36:0x014f, B:40:0x018b, B:43:0x017e, B:46:0x0113), top: B:21:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017e A[Catch: Exception -> 0x01a1, TRY_ENTER, TryCatch #0 {Exception -> 0x01a1, blocks: (B:22:0x00aa, B:25:0x00c5, B:27:0x00ce, B:28:0x00f0, B:30:0x00fe, B:32:0x0108, B:33:0x0119, B:35:0x0125, B:36:0x014f, B:40:0x018b, B:43:0x017e, B:46:0x0113), top: B:21:0x00aa }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2 = "1";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intent intent2 = (Intent) intent.getParcelableExtra("realIntent");
        intent2.setExtrasClassLoader(getClass().getClassLoader());
        int intExtra = intent2.getIntExtra("type", 1);
        String stringExtra = intent.getStringExtra("pushschema");
        if (intExtra == 2 && !TextUtils.isEmpty(stringExtra)) {
            if (stringExtra.startsWith("https://")) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("url", stringExtra);
                com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(BaseApplication.getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_WEBVIEW, hashMap);
            } else if (stringExtra.startsWith("mqqapi://")) {
                Intent intent3 = new Intent(context, (Class<?>) JumpActivity.class);
                intent3.setData(Uri.parse(stringExtra));
                intent3.addFlags(268435456);
                context.startActivity(intent3);
                a(intent2);
            }
            ((IQCircleNotificationReporter) QRoute.api(IQCircleNotificationReporter.class)).reportClick(intent2.getStringExtra("push_id"), intent2.getStringExtra(ServiceConst.PARA_SESSION_ID), intent2.getStringExtra(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO));
            return;
        }
        context.startActivity(intent2);
        try {
            String stringExtra2 = intent.getStringExtra("hostuin");
            String stringExtra3 = intent.getStringExtra("pushstatkey");
            int intExtra2 = intent.getIntExtra("pushType", 0);
            if (stringExtra != null) {
                if (stringExtra.startsWith("mqzone://arouse/livevideo")) {
                    QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
                    reportInfo.actionType = String.valueOf(322);
                    reportInfo.subactionType = String.valueOf(3);
                    reportInfo.reserves = String.valueOf(7);
                    QZoneClickReport.report(stringExtra2, reportInfo, true);
                    d.f286467f.clear();
                }
                Uri parse = Uri.parse(stringExtra);
                if (TextUtils.isEmpty(parse.getQueryParameter("from"))) {
                    if (parse.getPathSegments().size() > 0) {
                        str = parse.getPathSegments().get(0);
                    }
                } else {
                    str = parse.getQueryParameter("from");
                }
                LpReportInfo_dc00420.report(3, 0, str, stringExtra3, 1);
                QZoneLoginReportHelper.reportLoginFromMQQPush();
                if (QLog.isColorLevel()) {
                    QLog.d("pushReport", 2, "CLICK: uin: " + stringExtra2 + " schema: " + stringExtra + " pushstatkey: " + stringExtra3);
                }
                QZonePushReporter.QZonePushEventValueBuilder pushContent = new QZonePushReporter.QZonePushEventValueBuilder().setPushChannel("1").setPushType(intExtra2 + "").setPushContent(stringExtra3);
                if (BaseApplicationImpl.getApplication().getRuntime() != null) {
                    if (!BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause) {
                    }
                    QZonePushReporter.reportPushEvent(pushContent.setDisplayType(str2).setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2("click"));
                }
                str2 = "2";
                QZonePushReporter.reportPushEvent(pushContent.setDisplayType(str2).setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2("click"));
            }
            str = "";
            LpReportInfo_dc00420.report(3, 0, str, stringExtra3, 1);
            QZoneLoginReportHelper.reportLoginFromMQQPush();
            if (QLog.isColorLevel()) {
            }
            QZonePushReporter.QZonePushEventValueBuilder pushContent2 = new QZonePushReporter.QZonePushEventValueBuilder().setPushChannel("1").setPushType(intExtra2 + "").setPushContent(stringExtra3);
            if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            }
            str2 = "2";
            QZonePushReporter.reportPushEvent(pushContent2.setDisplayType(str2).setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2("click"));
        } catch (Exception e16) {
            QLog.e("NotificationClickReceiver", 1, e16, new Object[0]);
        }
    }
}
