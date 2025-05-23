package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public /* synthetic */ class TextContentBuildUtilKt$buildContent$1 extends FunctionReferenceImpl implements Function2<Boolean, CharSequence, CharSequence> {
    static IPatchRedirector $redirector_;
    public static final TextContentBuildUtilKt$buildContent$1 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47954);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new TextContentBuildUtilKt$buildContent$1();
        }
    }

    TextContentBuildUtilKt$buildContent$1() {
        super(2, TextContentBuildUtilKt.class, "defaultFilter", "defaultFilter(ZLjava/lang/CharSequence;)Ljava/lang/CharSequence;", 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final CharSequence invoke(boolean z16, @NotNull CharSequence p16) {
        CharSequence d16;
        Intrinsics.checkNotNullParameter(p16, "p1");
        d16 = TextContentBuildUtilKt.d(z16, p16);
        return d16;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ CharSequence invoke(Boolean bool, CharSequence charSequence) {
        return invoke(bool.booleanValue(), charSequence);
    }
}
