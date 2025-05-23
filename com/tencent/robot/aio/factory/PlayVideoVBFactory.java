package com.tencent.robot.aio.factory;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.data.a;
import com.tencent.robot.aio.playvideo.PlayVideoVB;
import kotlin.Metadata;
import ol3.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/factory/PlayVideoVBFactory;", "Lcom/tencent/qqnt/aio/data/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PlayVideoVBFactory implements a {
    @Override // com.tencent.qqnt.aio.data.a
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> create() {
        return new PlayVideoVB();
    }
}
