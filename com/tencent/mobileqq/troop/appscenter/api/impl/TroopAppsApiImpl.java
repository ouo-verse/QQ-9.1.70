package com.tencent.mobileqq.troop.appscenter.api.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.appscenter.TroopAppsFragment;
import com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/api/impl/TroopAppsApiImpl;", "Lcom/tencent/mobileqq/troop/appscenter/api/ITroopAppsApi;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "openNewPage", "", "context", "Landroid/content/Context;", "troopUin", "", "pageType", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopAppsApiImpl implements ITroopAppsApi {
    static IPatchRedirector $redirector_;

    public TroopAppsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi
    @NotNull
    public Fragment getFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Fragment) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new TroopAppsFragment();
    }

    @Override // com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi
    public void openNewPage(@NotNull Context context, @NotNull String troopUin, int pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, troopUin, Integer.valueOf(pageType));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopAppsFragment.INSTANCE.a(context, troopUin, pageType);
    }
}
