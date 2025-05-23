package com.tencent.intimate_space.impl;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public /* synthetic */ class IntimateSpaceFilamentView$ktvPropMap$1 extends FunctionReferenceImpl implements Function1<Object, Object> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntimateSpaceFilamentView$ktvPropMap$1(Object obj) {
        super(1, obj, IntimateSpaceFilamentView.class, IECSearchBar.METHOD_SET_CALLBACK, "setCallback(Ljava/lang/Object;)Ljava/lang/Object;", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Object invoke(@Nullable Object obj) {
        Object t16;
        t16 = ((IntimateSpaceFilamentView) this.receiver).t(obj);
        return t16;
    }
}
