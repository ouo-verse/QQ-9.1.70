package com.tencent.state.publicchat.component;

import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatBaseComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/publicchat/component/IPublicChatEventListener;", "()V", "onConfigLoaded", "", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class PublicChatBaseComponent extends VasBaseFragmentComponent implements IPublicChatEventListener {
    @Override // com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
    }

    @Override // com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onMsgAction(MsgAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }
}
