package com.tencent.mobileqq.troop.troopsetting.modules.base;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u4ec5\u5386\u53f2\u4e0a\u62a5\u7528\uff0c\u6700\u65b0\u7684\u4e0a\u62a5\u90fd\u4f7f\u7528DT\u4e0a\u62a5")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014Jr\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/base/j;", "", "Lmqq/app/AppRuntime;", "app", "", "tag", "mainAction", "toUin", "subAction", "actionName", "", IProfileCardConst.KEY_FROM_TYPE, "result", "r2", "r3", "r4", "r5", "", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f301158a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f301158a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AppRuntime app, String tag, String mainAction, String toUin, String subAction, String actionName, int i3, int i16, String r26, String r36, String r46, String r56) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(mainAction, "$mainAction");
        Intrinsics.checkNotNullParameter(toUin, "$toUin");
        Intrinsics.checkNotNullParameter(subAction, "$subAction");
        Intrinsics.checkNotNullParameter(actionName, "$actionName");
        Intrinsics.checkNotNullParameter(r26, "$r2");
        Intrinsics.checkNotNullParameter(r36, "$r3");
        Intrinsics.checkNotNullParameter(r46, "$r4");
        Intrinsics.checkNotNullParameter(r56, "$r5");
        ReportController.o(app, tag, mainAction, toUin, subAction, actionName, i3, i16, r26, r36, r46, r56);
    }

    public final void b(@NotNull final AppRuntime app, @NotNull final String tag, @NotNull final String mainAction, @NotNull final String toUin, @NotNull final String subAction, @NotNull final String actionName, final int fromType, final int result, @NotNull final String r26, @NotNull final String r36, @NotNull final String r46, @NotNull final String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, tag, mainAction, toUin, subAction, actionName, Integer.valueOf(fromType), Integer.valueOf(result), r26, r36, r46, r56);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mainAction, "mainAction");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        Intrinsics.checkNotNullParameter(subAction, "subAction");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.base.i
            @Override // java.lang.Runnable
            public final void run() {
                j.d(AppRuntime.this, tag, mainAction, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56);
            }
        }, 16, null, false);
    }
}
