package com.tencent.mobileqq.vas.vipstatus.impl;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.perception.api.IVipPerception;
import com.tencent.mobileqq.vas.vipstatus.IVasAioVipPerceptionProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/vipstatus/impl/VasAioVipPerceptionProxyImpl;", "Lcom/tencent/mobileqq/vas/vipstatus/IVasAioVipPerceptionProxy;", "()V", "longClickVoiceMsg", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "voiceMsg30s", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasAioVipPerceptionProxyImpl implements IVasAioVipPerceptionProxy {
    @Override // com.tencent.mobileqq.vas.vipstatus.IVasAioVipPerceptionProxy
    public void longClickVoiceMsg(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IVipPerception iVipPerception = (IVipPerception) QRoute.api(IVipPerception.class);
        int i3 = msgItem.getMsgRecord().chatType;
        String str = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        iVipPerception.longClickVoiceMsg(i3, str, msgItem.getMsgRecord().peerUin, msgItem.getMsgRecord().senderUin);
    }

    @Override // com.tencent.mobileqq.vas.vipstatus.IVasAioVipPerceptionProxy
    public void voiceMsg30s(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IVipPerception iVipPerception = (IVipPerception) QRoute.api(IVipPerception.class);
        int i3 = msgItem.getMsgRecord().chatType;
        String str = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        iVipPerception.voiceMsg30s(i3, str, msgItem.getMsgRecord().peerUin, msgItem.getMsgRecord().senderUin);
    }
}
