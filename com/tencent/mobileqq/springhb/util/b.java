package com.tencent.mobileqq.springhb.util;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.ReportInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.spring_hb.ReportData$NYReportRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004J$\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004J0\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00140\u0013J\n\u0010\u0017\u001a\u00020\u0004*\u00020\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/springhb/util/b;", "", "", "b", "", "tag", "", "isColor", "msg", "", "f", "d", "", ReportConstant.COSTREPORT_TRANS, "e", "a", "Lmqq/app/AppRuntime;", "app", "c", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/springhb/ReportInfo;", "g", "Ltencent/im/spring_hb/ReportData$NYReportRsp;", h.F, "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289632a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25999);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f289632a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b() {
        int mobileInfo;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        int i3 = 1;
        if (!AppNetConnInfo.isWifiConn()) {
            if (!AppNetConnInfo.isMobileConn() || (mobileInfo = AppNetConnInfo.getMobileInfo()) == -1) {
                return 0;
            }
            if (mobileInfo == 0 || mobileInfo == 1) {
                return 2;
            }
            i3 = 3;
            if (mobileInfo != 2) {
                if (mobileInfo == 3) {
                    return 4;
                }
                if (mobileInfo != 4) {
                    return -1;
                }
                return 6;
            }
        }
        return i3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        switch (b()) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                return 0;
        }
    }

    @NotNull
    public final String c(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) app);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        int privilegeFlags = ((IVasSingedApi) app.getRuntimeService(IVasSingedApi.class, "all")).getVipStatus().getPrivilegeFlags(null);
        if ((privilegeFlags & 8) != 0) {
            return "1";
        }
        if ((privilegeFlags & 4) != 0) {
            return "2";
        }
        if ((privilegeFlags & 2) != 0) {
            return "3";
        }
        return "4";
    }

    public final void d(@NotNull String tag, boolean isColor, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tag, Boolean.valueOf(isColor), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (isColor && com.tencent.mobileqq.springhb.debug.b.f289046a.i()) {
            if (QLog.isColorLevel()) {
                QLog.e(tag, 2, msg2);
                return;
            }
            return;
        }
        QLog.e(tag, 1, msg2);
    }

    public final void e(@NotNull String tag, boolean isColor, @Nullable String msg2, @Nullable Throwable tr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tag, Boolean.valueOf(isColor), msg2, tr5);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (isColor && com.tencent.mobileqq.springhb.debug.b.f289046a.i()) {
            if (QLog.isColorLevel()) {
                QLog.e(tag, 2, msg2, tr5);
                return;
            }
            return;
        }
        QLog.e(tag, 1, msg2, tr5);
    }

    public final void f(@NotNull String tag, boolean isColor, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tag, Boolean.valueOf(isColor), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (isColor && com.tencent.mobileqq.springhb.debug.b.f289046a.i()) {
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, msg2);
                return;
            }
            return;
        }
        QLog.i(tag, 1, msg2);
    }

    @NotNull
    public final String g(@NotNull LinkedList<ReportInfo> linkedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) linkedList);
        }
        Intrinsics.checkNotNullParameter(linkedList, "<this>");
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            sb5.append(((ReportInfo) it.next()).toSimpleString());
            sb5.append(",");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "joiner.toString()");
        return sb6;
    }

    @NotNull
    public final String h(@NotNull ReportData$NYReportRsp reportData$NYReportRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) reportData$NYReportRsp);
        }
        Intrinsics.checkNotNullParameter(reportData$NYReportRsp, "<this>");
        return "ret:" + reportData$NYReportRsp.ret.get() + ",errMsg:" + reportData$NYReportRsp.errMsg.get() + ",batchSize:" + reportData$NYReportRsp.batchSize.get() + ",reportInterval:" + reportData$NYReportRsp.reportInterval.get() + ",switchToBgInterval:" + reportData$NYReportRsp.switchToBgInterval.get() + ",reportLevel:" + reportData$NYReportRsp.reportLevel.get() + ",reportLevelTime:" + reportData$NYReportRsp.reportLevelTime.get();
    }
}
