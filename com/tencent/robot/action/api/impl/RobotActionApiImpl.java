package com.tencent.robot.action.api.impl;

import com.tencent.robot.action.api.IRobotActionApi;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n14.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J[\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e28\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0096\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/action/api/impl/RobotActionApiImpl;", "Lcom/tencent/robot/action/api/IRobotActionApi;", "", "Ln14/c;", "context", "", ZPlanPublishSource.FROM_SCHEME, "", "doSchemeAction", "Ln14/d;", QZoneImageUtils.KEY_MATCH, "source", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "anchorId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "errorMsg", "", "callback", "showAnchor", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotActionApiImpl implements IRobotActionApi {
    private final /* synthetic */ RobotCommandActionApiImpl $$delegate_0 = new RobotCommandActionApiImpl();

    @Override // com.tencent.robot.action.api.IRobotActionApi
    public boolean doSchemeAction(@NotNull n14.c context, @NotNull String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return this.$$delegate_0.c(context, scheme);
    }

    @Override // com.tencent.robot.action.api.IRobotActionApi
    @Nullable
    public d match(@NotNull String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return this.$$delegate_0.h(scheme);
    }

    @Override // com.tencent.robot.action.api.IRobotActionApi
    public void showAnchor(@NotNull String source, @NotNull com.tencent.aio.api.runtime.a aioContext, int anchorId, @Nullable Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.$$delegate_0.i(source, aioContext, anchorId, callback);
    }
}
