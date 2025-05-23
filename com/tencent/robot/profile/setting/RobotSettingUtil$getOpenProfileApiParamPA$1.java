package com.tencent.robot.profile.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.robot.profile.setting.RobotSettingUtil", f = "RobotSettingUtil.kt", i = {}, l = {213}, m = "getOpenProfileApiParamPA", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotSettingUtil$getOpenProfileApiParamPA$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RobotSettingUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingUtil$getOpenProfileApiParamPA$1(RobotSettingUtil robotSettingUtil, Continuation<? super RobotSettingUtil$getOpenProfileApiParamPA$1> continuation) {
        super(continuation);
        this.this$0 = robotSettingUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object n3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n3 = this.this$0.n(null, this);
        return n3;
    }
}
