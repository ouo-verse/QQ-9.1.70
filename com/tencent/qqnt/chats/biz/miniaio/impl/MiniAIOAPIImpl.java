package com.tencent.qqnt.chats.biz.miniaio.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.miniaio.IMiniAIOAPI;
import com.tencent.qqnt.chats.biz.miniaio.MiniMsgFragment;
import com.tencent.qqnt.chats.biz.miniaio.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/biz/miniaio/impl/MiniAIOAPIImpl;", "Lcom/tencent/qqnt/chats/biz/miniaio/IMiniAIOAPI;", "Lcom/tencent/qqnt/chats/biz/miniaio/b;", "createMiniMsgFragment", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniAIOAPIImpl implements IMiniAIOAPI {
    static IPatchRedirector $redirector_;

    public MiniAIOAPIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.miniaio.IMiniAIOAPI
    @NotNull
    public b createMiniMsgFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new MiniMsgFragment();
    }
}
