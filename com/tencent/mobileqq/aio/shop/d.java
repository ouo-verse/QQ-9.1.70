package com.tencent.mobileqq.aio.shop;

import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVM;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/d;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB;", "", "position", "", "M3", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "u0", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM;", NowProxyConstants.AccountInfoKey.A2, "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends AIOMsgListVB {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void M3(int position) {
        boolean z16;
        boolean z17;
        if (W2() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (X2() == 0.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (M2().isLayoutSuppressed()) {
                    M2().suppressLayout(false);
                    a.C11562a.a(I2(), position, false, null, 6, null);
                    M2().suppressLayout(true);
                } else {
                    a.C11562a.a(I2(), position, false, null, 6, null);
                }
                QLog.d("AIOMsgListVB", 1, "handleScrollToPositionTop scrollToPosition position = " + position);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.api.list.j
    @NotNull
    /* renamed from: A2 */
    public AIOMsgListVM F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgListVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new e(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof AIOMsgListViewState.ScrollToPosition) {
            M3(((AIOMsgListViewState.ScrollToPosition) state).a());
        }
        super.u0(state, uiHelper);
    }
}
