package com.tencent.qqnt.pluspanel.processor;

import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/t;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t implements com.tencent.qqnt.pluspanel.logic.b {
    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("RobotCommunicationShareClickProcessor", 1, "onClick| RobotCommunicationShareClickProcessor is clicked");
        com.tencent.mvi.base.route.j e16 = context.e();
        e16.h(new MultiSelectEvent.SetSelectMode(true));
        e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("RobotCommunicationShareClickProcessor", true));
        e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotCommunicationShareClickProcessor", false));
        e16.h(new AIOMsgListEvent.SetCommunicationShareButton(true));
    }
}
