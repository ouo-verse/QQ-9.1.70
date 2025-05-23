package com.tencent.mobileqq.poke.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.poke.api.IPokePanelLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/poke/impl/PokePanelLoaderImpl;", "Lcom/tencent/mobileqq/poke/api/IPokePanelLoader;", "()V", "getPokeAndEmoPanel", "Landroid/view/View;", "context", "Landroid/content/Context;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class PokePanelLoaderImpl implements IPokePanelLoader {
    static IPatchRedirector $redirector_;

    public PokePanelLoaderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.poke.api.IPokePanelLoader
    @NotNull
    public View getPokeAndEmoPanel(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.dvz, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026panel_pokeemo_base, null)");
        return inflate;
    }
}
