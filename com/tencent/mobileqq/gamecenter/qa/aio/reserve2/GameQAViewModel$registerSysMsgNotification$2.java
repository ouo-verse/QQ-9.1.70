package com.tencent.mobileqq.gamecenter.qa.aio.reserve2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.common.nt_msg_common$Msg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public /* synthetic */ class GameQAViewModel$registerSysMsgNotification$2 extends AdaptedFunctionReference implements Function2<nt_msg_common$Msg, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GameQAViewModel$registerSysMsgNotification$2(Object obj) {
        super(2, obj, GameQAViewModel.class, "onSysMsgReceived", "onSysMsgReceived(Ltencent/im/common/nt_msg_common$Msg;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull nt_msg_common$Msg nt_msg_common_msg, @NotNull Continuation<? super Unit> continuation) {
        Object u16;
        u16 = GameQAViewModel.u((GameQAViewModel) this.receiver, nt_msg_common_msg, continuation);
        return u16;
    }
}
