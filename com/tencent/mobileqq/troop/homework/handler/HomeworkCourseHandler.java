package com.tencent.mobileqq.troop.homework.handler;

import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.TroopHwCourseMgrRsp;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.d;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJN\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fH\u0002JP\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2>\u0010\r\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002JL\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00112<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fJT\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fJT\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/handler/HomeworkCourseHandler;", "", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/a;", "req", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "resp", "", "Lcom/tencent/mobileqq/troop/homework/handler/CourseMgrCallback;", "callback", "d", "Lcom/tencent/common/app/AppInterface;", "appInterface", "", "psKey", IPublicAccountDetailReportUtil.KEY_SEARCH, "Lcom/tencent/mobileqq/troop/homework/handler/GetHomeworkPskCallback;", "g", ReportConstant.COSTREPORT_PREFIX, "f", "troopUin", "e", "courseName", "c", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HomeworkCourseHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HomeworkCourseHandler f297080a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/handler/HomeworkCourseHandler$a", "Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$a;", "", "Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$b;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, Unit> f297081a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super String, ? super String, Unit> function2) {
            this.f297081a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onFailed(@Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
            } else {
                d.f297051a.e(BaseApplication.getContext());
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.entry.ui.utils.d.a
        public void onSuccess(@NotNull List<d.b> pSKeys) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pSKeys);
                return;
            }
            Intrinsics.checkNotNullParameter(pSKeys, "pSKeys");
            if (!pSKeys.isEmpty()) {
                str = pSKeys.get(0).a();
            } else {
                str = null;
            }
            this.f297081a.invoke(str, HomeworkCourseHandler.f297080a.f(str));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f297080a = new HomeworkCourseHandler();
        }
    }

    HomeworkCourseHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(com.tencent.mobileqq.troop.homework.coursemgr.repo.a req, Function2<? super Boolean, ? super TroopHwCourseMgrRsp, Unit> callback) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        g(appInterface, new HomeworkCourseHandler$executeCgiTask$1(req, appInterface, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(String s16) {
        boolean z16;
        if (s16 != null && s16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && s16.length() >= 10) {
            String substring = s16.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return "";
    }

    private final void g(AppInterface appInterface, Function2<? super String, ? super String, Unit> callback) {
        d.f297051a.c(appInterface, new String[]{FlockBaseRequest.QUN_DOMAIN}, new a(callback));
    }

    public final void b(@NotNull String troopUin, @NotNull String courseName, @NotNull Function2<? super Boolean, ? super TroopHwCourseMgrRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, courseName, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d(new com.tencent.mobileqq.troop.homework.coursemgr.repo.a(troopUin, 2, null, courseName, null, null, null, 116, null), callback);
    }

    public final void c(@NotNull String troopUin, @NotNull String courseName, @NotNull Function2<? super Boolean, ? super TroopHwCourseMgrRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, courseName, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d(new com.tencent.mobileqq.troop.homework.coursemgr.repo.a(troopUin, 3, null, courseName, null, null, null, 116, null), callback);
    }

    public final void e(@NotNull String troopUin, @NotNull Function2<? super Boolean, ? super TroopHwCourseMgrRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d(new com.tencent.mobileqq.troop.homework.coursemgr.repo.a(troopUin, 1, null, null, null, null, null, 124, null), callback);
    }
}
