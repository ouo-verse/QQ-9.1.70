package com.tencent.qqnt.msgselect.msglist;

import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/msgselect/msglist/b;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM;", NowProxyConstants.AccountInfoKey.A2, "", "S0", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends AIOMsgListVB {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.api.list.j
    @NotNull
    /* renamed from: A2 */
    public AIOMsgListVM F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgListVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new MsgSelectMsgListVM(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.S0();
        AIORecycleView M2 = M2();
        M2.setPadding(M2.getPaddingLeft(), M2.getPaddingTop(), M2.getPaddingRight(), (int) getMContext().getResources().getDimension(R.dimen.c0r));
    }
}
