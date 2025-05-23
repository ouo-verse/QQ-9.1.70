package com.tencent.mobileqq.aio.robot.titlebar.entrance;

import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.robot.titlebar.intent.BabyQModelSwitchMsgIntent;
import k81.RobotAIModelData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "", "Lk81/a;", "data", "", "preCallback", "", "l", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<Object, Object> {
    /* JADX WARN: Multi-variable type inference failed */
    public final void l(@NotNull RobotAIModelData data, @NotNull String preCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(preCallback, "preCallback");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new BabyQModelSwitchMsgIntent.OnAIModelSwitch(data));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.RemoveBotExtData(preCallback));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.AddBotExtData(data.getCallBackData(), false, 2, null));
    }
}
