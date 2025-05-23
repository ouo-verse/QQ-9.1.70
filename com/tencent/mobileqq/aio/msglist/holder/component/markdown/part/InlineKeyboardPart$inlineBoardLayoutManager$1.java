package com.tencent.mobileqq.aio.msglist.holder.component.markdown.part;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public /* synthetic */ class InlineKeyboardPart$inlineBoardLayoutManager$1 extends FunctionReferenceImpl implements Function1<com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, InlineBtnStyleSheet> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InlineKeyboardPart$inlineBoardLayoutManager$1(Object obj) {
        super(1, obj, InlineKeyboardPart.class, "createInlineBoardStyleSheet", "createInlineBoardStyleSheet(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/InlineBtnModel;)Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final InlineBtnStyleSheet invoke(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a p06) {
        InlineBtnStyleSheet j3;
        Intrinsics.checkNotNullParameter(p06, "p0");
        j3 = ((InlineKeyboardPart) this.receiver).j(p06);
        return j3;
    }
}
