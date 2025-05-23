package com.tencent.mobileqq.applets;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthReportApi;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class PublicAccountEventReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f196704a;

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f196705b;

    /* renamed from: com.tencent.mobileqq.applets.PublicAccountEventReport$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ QQAppInterface C;
        final /* synthetic */ String D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196716d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f196717e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f196718f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f196719h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f196720i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f196721m;

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = this.f196716d;
            String str2 = this.f196717e;
            if (this.f196718f == 0 && this.f196719h <= 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            PublicAccountEventReport.o(str, 137, str2, z16, this.f196720i, this.f196721m);
            ReportController.o(this.C, "dc00898", "", this.f196716d, "0X8009EB3", "0X8009EB3", 2, 0, this.f196718f + "", this.f196719h + "", this.D, "");
            if (!TextUtils.isEmpty(this.f196717e)) {
                ReportController.o(this.C, "dc05007", "", this.f196716d, "0X8009EB3", "0X8009EB3", 2, 0, this.f196718f + "", this.f196719h + "", this.D, this.f196717e);
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.applets.PublicAccountEventReport$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ QQAppInterface C;
        final /* synthetic */ String D;
        final /* synthetic */ MessageRecord E;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196722d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f196723e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f196724f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f196725h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f196726i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f196727m;

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = this.f196722d;
            String str2 = this.f196723e;
            if (this.f196724f == 0 && this.f196725h <= 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            PublicAccountEventReport.o(str, 138, str2, z16, this.f196726i, this.f196727m);
            ReportController.o(this.C, "dc00898", "", this.f196722d, "0X8009EB4", "0X8009EB4", 2, 0, this.f196724f + "", this.f196725h + "", this.D, "");
            if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isHealthUin(this.f196722d)) {
                ((IQQHealthReportApi) QRoute.api(IQQHealthReportApi.class)).reportHealthMessageClick(this.C, this.E);
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.applets.PublicAccountEventReport$4, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f196728d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f196729e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f196730f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f196731h;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ReportController.o(this.f196728d, "dc00898", "", this.f196729e, "0X8009EB7", "0X8009EB7", this.f196730f, 0, "", "", this.f196731h + "", "");
        }
    }

    /* renamed from: com.tencent.mobileqq.applets.PublicAccountEventReport$7, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196743d;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ReportController.o(null, "dc00898", "", this.f196743d, "0X8009EB7", "0X8009EB7", 0, 0, "", "", "", "-1");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f196704a = new ConcurrentHashMap<>();
            f196705b = new ConcurrentHashMap<>();
        }
    }

    public static void b(int i3, int i16, String str, String str2) {
        c(i3, i16, str, str2, 1);
    }

    public static void c(int i3, int i16, String str, String str2, int i17) {
        ThreadManagerV2.executeOnSubThread(new Runnable(str, i3, i16, i17, str2) { // from class: com.tencent.mobileqq.applets.PublicAccountEventReport.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f196746d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f196747e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f196748f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f196749h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f196750i;

            {
                this.f196746d = str;
                this.f196747e = i3;
                this.f196748f = i16;
                this.f196749h = i17;
                this.f196750i = str2;
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
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime == null) {
                    str3 = "";
                } else {
                    str3 = runtime.getAccount();
                }
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
                tianShuReportData.mAppId = "vab_push";
                tianShuReportData.mPageId = "vab_push";
                tianShuReportData.mTraceId = str3 + "_" + serverTimeMillis;
                tianShuReportData.mTraceNum = 1;
                tianShuReportData.mItemId = this.f196746d;
                tianShuReportData.mSubItemId = "";
                tianShuReportData.mOperTime = serverTimeMillis;
                tianShuReportData.mActionId = this.f196747e;
                tianShuReportData.mPositionId = Integer.toString(this.f196748f);
                tianShuReportData.mActionValue = 1;
                tianShuReportData.mActionAttr = this.f196749h;
                tianShuReportData.mTriggerInfo = this.f196750i;
                TianShuManager.getInstance().report(tianShuReportData);
            }
        });
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return i(new JSONObject(str).optString("oac_triggle")).getString("ad_id");
            } catch (Exception unused) {
                QLog.e("PublicAccountEventReport", 2, "parseException error ");
            }
        }
        return "";
    }

    public static Bundle e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return i(new JSONObject(str).optString("oac_triggle"));
        } catch (JSONException e16) {
            QLog.e("PublicAccountEventReport", 1, "parse input=" + str, e16);
            return null;
        }
    }

    public static void f() {
        f196704a.clear();
    }

    public static void g(String str, long j3) {
        ThreadManagerV2.executeOnSubThread(new Runnable(str, j3) { // from class: com.tencent.mobileqq.applets.PublicAccountEventReport.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f196744d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f196745e;

            {
                this.f196744d = str;
                this.f196745e = j3;
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
                ReportController.o(null, "dc00898", "", this.f196744d, "0X800A306", "0X800A306", 0, 0, "", "", this.f196745e + "", "");
            }
        });
    }

    public static void h(int i3, String str, String str2, int i16) {
        c(205, i3, str, str2, i16);
    }

    public static Bundle i(String str) {
        Bundle bundle = new Bundle();
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split != null) {
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2) {
                    try {
                        bundle.putString(split2[0], URLDecoder.decode(split2[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return bundle;
    }

    public static void j(int i3, MessageRecord messageRecord, int i16, ArrayList<QQVipMsgInfo> arrayList) {
        ThreadManagerV2.executeOnSubThread(new Runnable(i3, messageRecord, i16, arrayList) { // from class: com.tencent.mobileqq.applets.PublicAccountEventReport.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f196712d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MessageRecord f196713e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f196714f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ ArrayList f196715h;

            {
                this.f196712d = i3;
                this.f196713e = messageRecord;
                this.f196714f = i16;
                this.f196715h = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16), arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PublicAccountEventReport.k(this.f196712d, this.f196713e, this.f196714f, this.f196715h);
                }
            }
        });
    }

    public static void k(int i3, MessageRecord messageRecord, int i16, ArrayList<QQVipMsgInfo> arrayList) {
        String str;
        QQVipMsgInfo qQVipMsgInfo = null;
        if (103 == i3) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime instanceof QQAppInterface) {
                arrayList = s23.a.f(-1, null);
            }
            if (arrayList != null && i16 >= 0 && i16 < arrayList.size()) {
                qQVipMsgInfo = arrayList.get(i16);
            }
        } else if (messageRecord instanceof MessageForArkApp) {
            MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
            if (messageForArkApp.ark_app_message == null) {
                return;
            }
            qQVipMsgInfo = new QQVipMsgInfo();
            QQVipMsgInfo.parseArkAdvInfo(messageForArkApp, qQVipMsgInfo);
        }
        QLog.d("PublicAccountEventReport", 4, "reportForAmsArk reportType:", Integer.valueOf(i3), " msgInfo:", qQVipMsgInfo, " position:", Integer.valueOf(i16));
        if (qQVipMsgInfo != null && qQVipMsgInfo.mIsAmsAdv && !qQVipMsgInfo.mAmsAdvMsgReported) {
            switch (i3) {
                case 101:
                    str = qQVipMsgInfo.mAmsRPExposeUrl;
                    break;
                case 102:
                    str = qQVipMsgInfo.mAmsRPClickUrl;
                    break;
                case 103:
                    str = qQVipMsgInfo.mAmsMessageExposeUrl;
                    qQVipMsgInfo.mAmsAdvMsgReported = true;
                    if (arrayList != null) {
                        arrayList.set(i16, qQVipMsgInfo);
                        break;
                    }
                    break;
                default:
                    str = "";
                    break;
            }
            QLog.d("PublicAccountEventReport", 4, "reportForAmsArk do reportType:", Integer.valueOf(i3), " url", str);
            s23.b.a(i3, str);
        }
    }

    public static void l(QQAppInterface qQAppInterface, int i3, int i16, MessageRecord messageRecord) {
        String str;
        if (messageRecord != null) {
            JSONObject jSONObject = messageRecord.mExJsonObject;
            if (jSONObject != null) {
                str = jSONObject.optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND);
            } else {
                str = "";
            }
            m(qQAppInterface, messageRecord.frienduin, i3, i16, messageRecord.msgUid, str);
        }
    }

    public static void m(QQAppInterface qQAppInterface, String str, int i3, int i16, long j3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountEventReport", 2, "report report Msg item click in aio, UIN=", str, " from=", Integer.valueOf(i3), " type=", Integer.valueOf(i16), " msgId=", Long.valueOf(j3));
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(str, i3, i16, j3, str2) { // from class: com.tencent.mobileqq.applets.PublicAccountEventReport.6
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f196738e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f196739f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f196740h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f196741i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f196742m;

            {
                this.f196738e = str;
                this.f196739f = i3;
                this.f196740h = i16;
                this.f196741i = j3;
                this.f196742m = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ReportController.o(QQAppInterface.this, "dc00898", "", this.f196738e, "0X8009EB6", "0X8009EB6", this.f196739f, 0, "" + this.f196740h, "", this.f196741i + "", "");
                if (!TextUtils.isEmpty(this.f196742m)) {
                    ReportController.o(QQAppInterface.this, "dc05007", "", this.f196738e, "0X8009EB6", "0X8009EB6", this.f196739f, 0, "" + this.f196740h, "", this.f196741i + "", this.f196742m);
                }
            }
        });
    }

    public static void n(AppInterface appInterface, MessageRecord messageRecord) {
        if (appInterface != null && messageRecord != null) {
            if ("1".equals(messageRecord.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("gdt_msgImp");
                String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("pa_msgId");
                String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("gdt_view_id");
                ArrayList arrayList = new ArrayList();
                arrayList.add(extInfoFromExtStr2);
                ((IPAReportUtil) QRoute.api(IPAReportUtil.class)).reportAdMsgArriveReceipt(appInterface, "", "", messageRecord.senderuin, extInfoFromExtStr, extInfoFromExtStr3, arrayList);
            } else if (AppConstants.VALUE.UIN_QZONE.equals(messageRecord.frienduin)) {
                ReportController.o(appInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
            }
            j(101, messageRecord, -1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(String str, int i3, String str2, boolean z16, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(str2, str, i3, z16, str3, str4) { // from class: com.tencent.mobileqq.applets.PublicAccountEventReport.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f196706d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f196707e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f196708f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f196709h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f196710i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f196711m;

            {
                this.f196706d = str2;
                this.f196707e = str;
                this.f196708f = i3;
                this.f196709h = z16;
                this.f196710i = str3;
                this.f196711m = str4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str2, str, Integer.valueOf(i3), Boolean.valueOf(z16), str3, str4);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String d16 = PublicAccountEventReport.d(this.f196706d);
                if (!TextUtils.isEmpty(d16)) {
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    TianShuReportData tianShuReportData = new TianShuReportData(this.f196707e + "_" + currentTimeMillis, 1, this.f196708f, 1, "vab_push", "vab_push", d16, "vab_push", currentTimeMillis);
                    tianShuReportData.mTriggerInfo = this.f196706d;
                    tianShuReportData.mPageId = "vab_push";
                    if (this.f196709h) {
                        i16 = 6;
                    } else {
                        i16 = -1;
                    }
                    tianShuReportData.mActionAttr = i16;
                    tianShuReportData.mBusiInfo = this.f196710i;
                    tianShuReportData.mPositionId = this.f196711m;
                    TianShuManager.getInstance().report(tianShuReportData);
                }
            }
        });
    }

    public static void p(QQAppInterface qQAppInterface, String str, int i3, int i16, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountEventReport", 2, "report report Stay Time In Page, UIN=", str, " from=", Integer.valueOf(i3), " type=", Integer.valueOf(i16), " time=", Long.valueOf(j3));
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(str, i3, i16, j3) { // from class: com.tencent.mobileqq.applets.PublicAccountEventReport.5
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f196733e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f196734f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f196735h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f196736i;

            {
                this.f196733e = str;
                this.f196734f = i3;
                this.f196735h = i16;
                this.f196736i = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ReportController.o(QQAppInterface.this, "dc00898", "", this.f196733e, "0X8009EB5", "0X8009EB5", this.f196734f, 0, "" + this.f196735h, this.f196736i + "", "", "");
            }
        });
    }
}
