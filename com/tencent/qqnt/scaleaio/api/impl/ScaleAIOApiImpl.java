package com.tencent.qqnt.scaleaio.api.impl;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqnt.scaleaio.api.IScaleAIOApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/scaleaio/api/impl/ScaleAIOApiImpl;", "Lcom/tencent/qqnt/scaleaio/api/IScaleAIOApi;", "()V", "getScaleAIOFragment", "Landroidx/fragment/app/Fragment;", "getScaleAIOFragmentClassName", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class ScaleAIOApiImpl implements IScaleAIOApi {
    static IPatchRedirector $redirector_;

    public ScaleAIOApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.scaleaio.api.IScaleAIOApi
    @NotNull
    public Fragment getScaleAIOFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Fragment) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new SplashAIOFragment();
    }

    @Override // com.tencent.qqnt.scaleaio.api.IScaleAIOApi
    @NotNull
    public String getScaleAIOFragmentClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String name = SplashAIOFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "SplashAIOFragment::class.java.name");
        return name;
    }
}
