package com.tencent.mobileqq.springhb.interactive.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.interactive.config.DegradeConfigParser;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0018\u00010\u0002R\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\n\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/a;", "", "Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$b;", "Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser;", "a", "()Lcom/tencent/mobileqq/springhb/interactive/config/DegradeConfigParser$b;", "degradeConfig", "", "b", "()Z", "isOpenFeatureWithBlack", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f289231a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f289231a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final DegradeConfigParser.b a() {
        return (DegradeConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101625");
    }

    public final boolean b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        DegradeConfigParser.b a16 = a();
        if (a16 != null && a16.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        return false;
    }
}
