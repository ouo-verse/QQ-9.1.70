package com.tencent.qqnt.robot.api;

import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/robot/api/IRobotShareMultiSelectBarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getRobotShareMultiSelectBar", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotShareMultiSelectBarApi extends QRouteApi {
    @NotNull
    a<? extends b, ? extends MviUIState> getRobotShareMultiSelectBar();
}
