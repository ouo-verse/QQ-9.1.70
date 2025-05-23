package com.tencent.mobileqq.component.qrcode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class QUIColorfulQRCodeView$3$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QUIColorfulQRCodeView$3$1(Object obj) {
        super(1, obj, QUIColorfulQRCodeView.class, "refreshLogoSize", "refreshLogoSize(I)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i3) {
        ((QUIColorfulQRCodeView) this.receiver).h(i3);
    }
}
