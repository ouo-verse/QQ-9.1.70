package com.tencent.relation.common.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/relation/common/utils/e;", "", "", "a", "<init>", "()V", "relation-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f364767a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f364767a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102276", true);
    }
}
