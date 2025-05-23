package com.tencent.robot.action.api;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import n14.c;
import n14.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/action/api/IRobotActionApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotActionApi extends QRouteApi {
    /* synthetic */ boolean doSchemeAction(@NotNull c cVar, @NotNull String str);

    @Nullable
    /* synthetic */ d match(@NotNull String str);

    /* synthetic */ void showAnchor(@NotNull String str, @NotNull a aVar, int i3, @Nullable Function2<? super Boolean, ? super String, Unit> function2);
}
