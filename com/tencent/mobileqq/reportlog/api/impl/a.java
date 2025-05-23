package com.tencent.mobileqq.reportlog.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reportlog.api.pb.QqlogPushPb$PullReportRuleReq;
import com.tencent.mobileqq.reportlog.api.pb.QqlogPushPb$PullReportRuleRsp;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/reportlog/api/impl/a;", "", "Lcom/tencent/mobileqq/reportlog/api/pb/QqlogPushPb$PullReportRuleRsp;", "pullReportRuleRsp", "", "d", "", "c", "b", "<init>", "()V", "report_log_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f281242a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/reportlog/api/impl/a$a", "Lcom/tencent/mobileqq/reportlog/api/impl/c;", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "", "errMsg", "", "e", "a", "report_log_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reportlog.api.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8511a implements c {
        static IPatchRedirector $redirector_;

        C8511a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.reportlog.api.impl.c
        public void a(@NotNull String errMsg, @Nullable Throwable e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg, (Object) e16);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("ReportLogManager", 1, "resultCallback onError=" + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.reportlog.api.impl.c
        public void b(@NotNull byte[] rspBytes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rspBytes);
                return;
            }
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                QqlogPushPb$PullReportRuleRsp pullReportRuleRsp = new QqlogPushPb$PullReportRuleRsp().mergeFrom(rspBytes);
                a aVar = a.f281242a;
                Intrinsics.checkNotNullExpressionValue(pullReportRuleRsp, "pullReportRuleRsp");
                aVar.d(pullReportRuleRsp);
            } catch (Exception e16) {
                QLog.i("ReportLogManager", 1, "handlePullReportRuleRsp error", e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f281242a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(QqlogPushPb$PullReportRuleRsp pullReportRuleRsp) {
        QLog.i("ReportLogManager", 1, "pullReportRuleRsp=" + pullReportRuleRsp);
        if (pullReportRuleRsp.need.has()) {
            boolean z16 = pullReportRuleRsp.need.get();
            QLog.i("ReportLogManager", 1, "pullReportRuleRsp, need=" + z16);
            if (z16) {
                long j3 = pullReportRuleRsp.start_time.get();
                long j16 = pullReportRuleRsp.end_time.get();
                long j17 = pullReportRuleRsp.task_id.get();
                String c16 = o.c();
                QLog.i("ReportLogManager", 1, "pullReportRuleRsp, start_time=" + j3 + ", end_time=" + j16 + ", task_id=" + j17);
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_AFTER_FETCH_CONFIG_LOG_REPORT);
                newIntent.putExtra("uin", "");
                newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, true);
                long j18 = (long) 1000;
                newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, j3 * j18);
                newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, j16 * j18);
                newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_TASK_ID, j17);
                newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_QIMEI36, c16);
                newIntent.runNow = true;
                newIntent.withouLogin = true;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    peekAppRuntime.startServlet(newIntent);
                } else {
                    QLog.i("ReportLogManager", 1, "MobileQQ.sMobileQQ.peekAppRuntime() == null");
                }
            }
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String c16 = o.c();
        String str = MobileQQ.PACKAGE_NAME;
        QqlogPushPb$PullReportRuleReq qqlogPushPb$PullReportRuleReq = new QqlogPushPb$PullReportRuleReq();
        qqlogPushPb$PullReportRuleReq.qimei.set(c16);
        qqlogPushPb$PullReportRuleReq.product.set(str);
        qqlogPushPb$PullReportRuleReq.platform.set("Android");
        b.INSTANCE.a("trpc.qqlog.qqlog_push.Portal.SsoPullReportRule", c(), qqlogPushPb$PullReportRuleReq.toByteArray(), new C8511a());
    }
}
