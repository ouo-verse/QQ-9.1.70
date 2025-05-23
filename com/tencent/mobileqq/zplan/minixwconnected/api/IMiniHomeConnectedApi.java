package com.tencent.mobileqq.zplan.minixwconnected.api;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.helper.u;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001Jp\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000228\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\bH&J3\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0015H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/api/IMiniHomeConnectedApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lkotlin/Function0;", "Landroid/content/Context;", "contextGetter", "", "c2cUinGetter", "c2cNicknameGetter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "value", "", "sender", "Lcom/tencent/mobileqq/activity/aio/helper/u;", "generateAioMiniHomeConnectedEntranceHelper", "", "friendUin", "Lkotlin/Function1;", "", "result", "callback", "showEntrance", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IMiniHomeConnectedApi extends QRouteApi {
    @Nullable
    u generateAioMiniHomeConnectedEntranceHelper(@NotNull Function0<? extends Context> contextGetter, @NotNull Function0<String> c2cUinGetter, @NotNull Function0<String> c2cNicknameGetter, @NotNull Function2<? super Integer, Object, Unit> sender);

    void showEntrance(long friendUin, @NotNull Function1<? super Boolean, Unit> callback);
}
