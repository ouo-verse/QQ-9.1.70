package com.tencent.mobileqq.troop.homework.common;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes19.dex */
public final class HWViewModelsExtKt$hwViewModels$4 extends Lambda implements Function0<ViewModelProvider.Factory> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Fragment $this_hwViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWViewModelsExtKt$hwViewModels$4(Fragment fragment) {
        super(0);
        this.$this_hwViewModels = fragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? b.a(this.$this_hwViewModels) : (ViewModelProvider.Factory) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
