package com.tencent.mobileqq.app.utils;

import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQConfMeetingLogReportHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    static QQConfMeetingLogReportHelper f196616d;

    /* renamed from: a, reason: collision with root package name */
    ShareAppLogHelper f196617a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<QQAppInterface> f196618b;

    /* renamed from: c, reason: collision with root package name */
    private ShareAppLogHelper.d f196619c;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ShareAppLogHelper.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQConfMeetingLogReportHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQConfMeetingLogReportHelper.this.g(str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            QLog.e("QQConfMeetingLogReportHelper", 1, "doReportLocalLog OnGetLocalLogListener onError, code=" + i3);
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void onWarning(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                QQConfMeetingLogReportHelper.this.f196617a.E(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f196616d = null;
        }
    }

    QQConfMeetingLogReportHelper(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f196618b = null;
        this.f196619c = new a();
        this.f196618b = new WeakReference<>(qQAppInterface);
    }

    public static QQConfMeetingLogReportHelper f(QQAppInterface qQAppInterface) {
        QQConfMeetingLogReportHelper qQConfMeetingLogReportHelper = new QQConfMeetingLogReportHelper(qQAppInterface);
        f196616d = qQConfMeetingLogReportHelper;
        return qQConfMeetingLogReportHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        QLog.w("QQConfMeetingLogReportHelper", 1, "sendFile begin, path[" + str + "], Thread[" + Thread.currentThread().getId() + "]");
        ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f196620d;

            {
                this.f196620d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQConfMeetingLogReportHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = "MSFSDK_LogReport" + ((QQAppInterface) QQConfMeetingLogReportHelper.this.f196618b.get()).getCurrentAccountUin();
                AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
                if (runtime != null) {
                    String account = runtime.getAccount();
                    if (QLog.isColorLevel()) {
                        QLog.d("QQConfMeetingLogReportHelper", 2, "[report] run: invoked. ", Integer.valueOf(AppSetting.f()), this.f196620d, str2, "", account);
                    }
                }
                QLog.w("QQConfMeetingLogReportHelper", 1, "sendFile, Runnable, path[" + this.f196620d + "], Thread[" + Thread.currentThread().getId() + "], cost[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
            }
        }, 2, null, true);
    }

    public void c(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j16 - j3 < 1800000) {
            j3 = j16 - 1800000;
        }
        String format = String.format("%02d", Integer.valueOf(e(j3)));
        String format2 = String.format("%02d", Integer.valueOf(e(j16)));
        String d16 = d(j3);
        String d17 = d(j16);
        Time r16 = ShareAppLogHelper.r(d16 + "-" + format, "-");
        Time r17 = ShareAppLogHelper.r(d17 + "-" + format2, "-");
        ShareAppLogHelper shareAppLogHelper = new ShareAppLogHelper(this.f196618b.get().getApplication().getBaseContext());
        this.f196617a = shareAppLogHelper;
        shareAppLogHelper.A(this.f196619c);
        QLog.w("QQConfMeetingLogReportHelper", 1, "doReportLocalLog, ret[" + this.f196617a.o(r16, r17, true) + "], startTime[" + r16 + "], endTime[" + r17 + "], cost[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
    }

    protected String d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
        Time time = new Time();
        time.set(j3);
        return time.year + "-" + (time.month + 1) + "-" + time.monthDay;
    }

    protected int e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, j3)).intValue();
        }
        Time time = new Time();
        time.set(j3);
        return time.hour;
    }
}
