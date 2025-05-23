package com.tencent.mobileqq.multiforward.msglist.childvm;

import at.b;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msglist.childvm.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.msg.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/childvm/a;", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/multiforward/msglist/childvm/ProfileListener;", h.F, "Lcom/tencent/mobileqq/multiforward/msglist/childvm/ProfileListener;", "mProfileListener", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "mParentVm", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;Lcom/tencent/aio/api/runtime/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ProfileListener mProfileListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull MsgListVMWrapper<b, MsgListUiState> mParentVm, @NotNull com.tencent.aio.api.runtime.a mAioContext) {
        super(mAioContext, mParentVm);
        Intrinsics.checkNotNullParameter(mParentVm, "mParentVm");
        Intrinsics.checkNotNullParameter(mAioContext, "mAioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mParentVm, (Object) mAioContext);
        } else {
            this.mProfileListener = new ProfileListener(this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        y f16 = f.f();
        if (f16 != null) {
            f16.r0(this.mProfileListener);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        y f16 = f.f();
        if (f16 != null) {
            f16.D0(this.mProfileListener);
        }
    }
}
