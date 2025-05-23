package com.tencent.robot.aio.bottombar;

import com.tencent.robot.aio.input.inputbar.emotionbtn.RobotInputEmotionBtnMsgIntent;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mvi/api/runtime/b;", "mviContext", "", "enable", "", "b", "", "source", "a", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    public static final void a(@NotNull String source, @NotNull com.tencent.mvi.api.runtime.b mviContext) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        mviContext.e().h(new RobotInputPttRecordMsgIntent.SetPttRecordModeMsgIntent(source, false));
    }

    public static final void b(@NotNull com.tencent.mvi.api.runtime.b mviContext, boolean z16) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        mviContext.e().h(new RobotInputPttRecordMsgIntent.SetPttBttBtnState(z16));
        mviContext.e().h(new RobotInputEmotionBtnMsgIntent.SetEmojiBtnState(z16));
    }
}
