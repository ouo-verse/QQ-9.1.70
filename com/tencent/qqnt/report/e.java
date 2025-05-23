package com.tencent.qqnt.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "b", "a", "Ljava/lang/Boolean;", "IS_REPORT_OPEN", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static Boolean f361948a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b() {
        if (f361948a == null) {
            f361948a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102675", false));
        }
        Boolean bool = f361948a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
