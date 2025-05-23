package com.tencent.mobileqq.zplan.utils.api.impl;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager;
import com.tencent.mobileqq.zplan.debug.ZPlanDebugGroup;
import com.tencent.mobileqq.zplan.emoticon.grayTip.c;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.meme.frameanim.overlay.f;
import com.tencent.mobileqq.zplan.meme.frameanim.overlay.g;
import com.tencent.mobileqq.zplan.meme.frameanim.overlay.h;
import com.tencent.mobileqq.zplan.meme.frameanim.overlay.i;
import com.tencent.mobileqq.zplan.message.MessageForZPlan;
import com.tencent.mobileqq.zplan.minixwconnected.forward.ForwardMiniHomeConnectOption;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout;
import com.tencent.mobileqq.zplan.view.ZPlanStaticFrameLayout;
import com.tencent.mobileqq.zplan.view.b;
import com.tencent.mobileqq.zplan.view.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk3.e;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002H\u0016J\u0010\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u0002H\u0016J\u0010\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u0002H\u0016J\u0010\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u0002H\u0016J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/impl/ZPlanClassObjectFactoryImpl;", "Lcom/tencent/mobileqq/zplan/utils/api/IZPlanClassObjectFactory;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/data/ChatMessage;", "getMessageForZPlanClass", "Lmqq/manager/Manager;", "getZPlanEditAvatarManagerClass", "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "createMessageForZPlan", "", "getZPlanDebugFragment", "getZPlanEnterAvatarSceneParser", "getZPlanOpenPageParser", "getZPlanStatusSquareParser", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/view/AbsZPlanStaticFrameLayout;", "createZPlanStaticFrameLayout", "Landroid/view/View;", "parentView", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;", "source", "", "enableFoldSplit", "", "friendUin", "Lcom/tencent/mobileqq/zplan/view/b;", "createZPlanHeaderTouchDelegate", "Landroidx/lifecycle/ViewModel;", "getZPlanDynamicAvatarOverlayViewModelClass", "getZPlanLebaAvatarOverlayViewModelClass", "getZPlanProfileAvatarOverlayViewModelClass", "getZPlanSettingMeAvatarOverlayViewModelClass", "Lcom/tencent/qqnt/graytips/handler/b;", "getZPlanOpenPanelHandlerClass", "getZPlanCreateRoleHandlerClass", "getZPlanAIOOpenGuideClass", "getForwardMiniHomeConnectOptionClass", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanClassObjectFactoryImpl implements IZPlanClassObjectFactory {
    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public b createZPlanHeaderTouchDelegate(View parentView, ZPlanAvatarSource source, boolean enableFoldSplit, long friendUin) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(source, "source");
        return new d(parentView, source, enableFoldSplit, friendUin);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public AbsZPlanStaticFrameLayout createZPlanStaticFrameLayout(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ZPlanStaticFrameLayout(context);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<?> getForwardMiniHomeConnectOptionClass() {
        return ForwardMiniHomeConnectOption.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<? extends ChatMessage> getMessageForZPlanClass() {
        return MessageForZPlan.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getZPlanAIOOpenGuideClass() {
        return com.tencent.mobileqq.zplan.aio.graytips.b.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getZPlanCreateRoleHandlerClass() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<Object> getZPlanDebugFragment() {
        return ZPlanDebugGroup.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<ViewModel> getZPlanDynamicAvatarOverlayViewModelClass() {
        return f.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<? extends Manager> getZPlanEditAvatarManagerClass() {
        return ZPlanEditAvatarManager.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<Object> getZPlanEnterAvatarSceneParser() {
        return mk3.b.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<ViewModel> getZPlanLebaAvatarOverlayViewModelClass() {
        return g.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<Object> getZPlanOpenPageParser() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getZPlanOpenPanelHandlerClass() {
        return com.tencent.mobileqq.zplan.emoticon.grayTip.d.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<ViewModel> getZPlanProfileAvatarOverlayViewModelClass() {
        return h.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<ViewModel> getZPlanSettingMeAvatarOverlayViewModelClass() {
        return i.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public Class<Object> getZPlanStatusSquareParser() {
        return mk3.c.class;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory
    public MessageForZPlan createMessageForZPlan() {
        return new MessageForZPlan();
    }
}
