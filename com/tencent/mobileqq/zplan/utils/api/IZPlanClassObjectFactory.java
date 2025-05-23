package com.tencent.mobileqq.zplan.utils.api;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout;
import com.tencent.mobileqq.zplan.view.b;
import kotlin.Metadata;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H&J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H&J\u0010\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u0002H&J\u0010\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u0002H&J\u0010\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u0002H&J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030\u0002H&\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/IZPlanClassObjectFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/data/ChatMessage;", "getMessageForZPlanClass", "Lmqq/manager/Manager;", "getZPlanEditAvatarManagerClass", "Lcom/tencent/mobileqq/data/MessageRecord;", "createMessageForZPlan", "", "getZPlanDebugFragment", "getZPlanEnterAvatarSceneParser", "getZPlanOpenPageParser", "getZPlanStatusSquareParser", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/view/AbsZPlanStaticFrameLayout;", "createZPlanStaticFrameLayout", "Landroid/view/View;", "parentView", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;", "source", "", "enableFoldSplit", "", "friendUin", "Lcom/tencent/mobileqq/zplan/view/b;", "createZPlanHeaderTouchDelegate", "Landroidx/lifecycle/ViewModel;", "getZPlanDynamicAvatarOverlayViewModelClass", "getZPlanLebaAvatarOverlayViewModelClass", "getZPlanProfileAvatarOverlayViewModelClass", "getZPlanSettingMeAvatarOverlayViewModelClass", "Lcom/tencent/qqnt/graytips/handler/b;", "getZPlanOpenPanelHandlerClass", "getZPlanCreateRoleHandlerClass", "getZPlanAIOOpenGuideClass", "getForwardMiniHomeConnectOptionClass", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanClassObjectFactory extends QRouteApi {
    @NotNull
    MessageRecord createMessageForZPlan();

    @NotNull
    b createZPlanHeaderTouchDelegate(@NotNull View parentView, @NotNull ZPlanAvatarSource source, boolean enableFoldSplit, long friendUin);

    @NotNull
    AbsZPlanStaticFrameLayout createZPlanStaticFrameLayout(@NotNull Context context);

    @NotNull
    Class<?> getForwardMiniHomeConnectOptionClass();

    @NotNull
    Class<? extends ChatMessage> getMessageForZPlanClass();

    @NotNull
    Class<? extends com.tencent.qqnt.graytips.handler.b> getZPlanAIOOpenGuideClass();

    @NotNull
    Class<? extends com.tencent.qqnt.graytips.handler.b> getZPlanCreateRoleHandlerClass();

    @NotNull
    Class<Object> getZPlanDebugFragment();

    @NotNull
    Class<ViewModel> getZPlanDynamicAvatarOverlayViewModelClass();

    @NotNull
    Class<? extends Manager> getZPlanEditAvatarManagerClass();

    @NotNull
    Class<Object> getZPlanEnterAvatarSceneParser();

    @NotNull
    Class<ViewModel> getZPlanLebaAvatarOverlayViewModelClass();

    @NotNull
    Class<Object> getZPlanOpenPageParser();

    @NotNull
    Class<? extends com.tencent.qqnt.graytips.handler.b> getZPlanOpenPanelHandlerClass();

    @NotNull
    Class<ViewModel> getZPlanProfileAvatarOverlayViewModelClass();

    @NotNull
    Class<ViewModel> getZPlanSettingMeAvatarOverlayViewModelClass();

    @NotNull
    Class<Object> getZPlanStatusSquareParser();
}
