package com.tencent.mobileqq.troop.troopsquare.api;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\rH&R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/api/ITroopSquareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "", "isSwitchOn", "Lcom/tencent/aio/main/businesshelper/h;", "createAIOHelper", "ext", "", "openSquarePage", "", "groupCode", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSquareRedpointInfoRsp;", "callback", "getGroupSquareRedpoint", "Ljava/lang/Class;", "getParserClass", "()Ljava/lang/Class;", "parserClass", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopSquareApi extends QRouteApi {
    @NotNull
    h createAIOHelper();

    void getGroupSquareRedpoint(long groupCode, @NotNull Function1<? super GetGroupSquareRedpointInfoRsp, Unit> callback);

    @NotNull
    Class<?> getParserClass();

    boolean isSwitchOn(@NotNull String troopUin);

    void openSquarePage(@NotNull String troopUin, @NotNull String ext);
}
