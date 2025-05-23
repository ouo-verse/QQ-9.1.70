package com.tencent.mobileqq.zplan.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\bH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H&J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\nH&J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanShowGuideApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "friendUin", "", "onNeedShowDialog", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "onShowDialog", "", "source", "peerUin", "onPlayAvatarAnimation", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "onEnterAIO", "onExitAIO", "onGetAIOContext", "onGetCurrentNickname", "Lkotlin/Function0;", "callback", "onShowDialogFromUpgradeBanner", "screenId", "onShowDialogFromAIOGrayTip", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "onShowBubbleTip", "onGetCurrentPeekUin", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanShowGuideApi extends QRouteApi {
    void onEnterAIO(@NotNull com.tencent.aio.api.runtime.a aioContext);

    void onExitAIO();

    @Nullable
    com.tencent.aio.api.runtime.a onGetAIOContext();

    @NotNull
    String onGetCurrentNickname(@NotNull String peerUin);

    @Nullable
    String onGetCurrentPeekUin();

    boolean onNeedShowDialog(@NotNull String friendUin);

    void onPlayAvatarAnimation(@NotNull AIOMsgItem msgItem);

    void onShowBubbleTip(@NotNull Context context, @Nullable View anchorView);

    void onShowDialog(int source, @NotNull String peerUin);

    void onShowDialog(@NotNull AIOMsgItem msgItem);

    void onShowDialogFromAIOGrayTip(@NotNull String peerUin, int screenId);

    void onShowDialogFromUpgradeBanner(@NotNull String peerUin, @NotNull Function0<Unit> callback);
}
