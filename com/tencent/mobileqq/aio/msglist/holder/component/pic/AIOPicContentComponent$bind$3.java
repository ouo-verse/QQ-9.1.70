package com.tencent.mobileqq.aio.msglist.holder.component.pic;

import com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
/* synthetic */ class AIOPicContentComponent$bind$3 extends FunctionReferenceImpl implements Function2<Boolean, PicContentViewUtil.FailReason, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIOPicContentComponent$bind$3(Object obj) {
        super(2, obj, AIOPicContentComponent.class, "onLoadResult", "onLoadResult(ZLcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$FailReason;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, PicContentViewUtil.FailReason failReason) {
        invoke(bool.booleanValue(), failReason);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @NotNull PicContentViewUtil.FailReason p16) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((AIOPicContentComponent) this.receiver).f2(z16, p16);
    }
}
