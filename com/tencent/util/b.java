package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/util/b;", "", "", "a", "<init>", "()V", "qq-appbadge-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f383971a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383971a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notify_reduce_red_dot_9120", true)) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qq_desk_inital_start_reddot_contrl");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(QQ_TAB_REDUCE_RED_DOT)");
        expEntity.reportExpExposure();
        return expEntity.isExperiment();
    }
}
