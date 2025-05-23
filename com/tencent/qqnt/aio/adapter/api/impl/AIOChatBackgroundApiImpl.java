package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aio.stranger.api.IStrangerBackgroundApi;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.nt.AIOBackgroundContainer;
import com.tencent.mobileqq.vas.nt.ZPlanCoupleAIOBackgroundContainer;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017H\u0016R0\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOChatBackgroundApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOChatBackgroundApi;", "", "friendUid", "", "uinType", "", "useQQStrangerAIOBackground", "Landroid/content/Context;", "context", "curFriendUid", "needImmersive", "Lcom/tencent/qqnt/aio/adapter/background/a;", "aioCreate", "selfUin", "", "aioDelayLoad", "aioResume", "aioPause", "aioDestroy", "uin", "isDIYChaTBackground", "curFriendUin", "Landroid/graphics/drawable/Drawable;", "getCurrentChatBackgroundDrawable", "getCurrentChatBackgroundBg", "isAvatarBackground", "peerUin", "Landroid/content/res/ColorStateList;", "getBackgroundTextColor", "Landroid/app/Activity;", "setWindowFit", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "drawable", "setImmersiveBottomDrawable", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/aio/api/b;", "Lkotlin/collections/ArrayList;", "weakBackgroundViews", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOChatBackgroundApiImpl implements IAIOChatBackgroundApi {
    public static final String TAG = "AIOChatBackgroundApiImpl";
    private final ArrayList<WeakReference<com.tencent.qqnt.aio.api.b>> weakBackgroundViews = new ArrayList<>();

    private final boolean useQQStrangerAIOBackground(String friendUid, int uinType) {
        return ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).useMatchFriendAIOBackgroundOnUinType(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(friendUid), Integer.valueOf(uinType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public com.tencent.qqnt.aio.adapter.background.a aioCreate(Context context, String curFriendUid, int uinType, boolean needImmersive) {
        com.tencent.qqnt.aio.adapter.background.a aVar;
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AIO CREATE curFriendUid = " + curFriendUid);
        new ChatBackgroundAuth().h(Boolean.FALSE);
        if (isAvatarBackground(curFriendUid, uinType)) {
            sb5.append("isAvatarBackground true.");
            if (context == null) {
                sb5.append("aioCreate failed, context null.");
                QLog.e("AIOChatBackgroundApiImpl", 1, sb5.toString());
                return null;
            }
            ZPlanCoupleAIOBackgroundContainer zPlanCoupleAIOBackgroundContainer = new ZPlanCoupleAIOBackgroundContainer(context);
            zPlanCoupleAIOBackgroundContainer.setInfo(curFriendUid, uinType, needImmersive);
            Unit unit = Unit.INSTANCE;
            aVar = new com.tencent.qqnt.aio.adapter.background.a(2, zPlanCoupleAIOBackgroundContainer);
        } else if (useQQStrangerAIOBackground(curFriendUid, uinType)) {
            View createMatchFriendAIOBackground = ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).createMatchFriendAIOBackground(context);
            Intrinsics.checkNotNull(createMatchFriendAIOBackground, "null cannot be cast to non-null type com.tencent.qqnt.aio.api.IAIOBackgroundView");
            ((com.tencent.qqnt.aio.api.b) createMatchFriendAIOBackground).setInfo(curFriendUid, uinType, needImmersive);
            Unit unit2 = Unit.INSTANCE;
            aVar = new com.tencent.qqnt.aio.adapter.background.a(4, createMatchFriendAIOBackground);
        } else {
            sb5.append("aioCreate default");
            AIOBackgroundContainer aIOBackgroundContainer = new AIOBackgroundContainer(context);
            aIOBackgroundContainer.setInfo(curFriendUid, uinType, needImmersive);
            Unit unit3 = Unit.INSTANCE;
            aVar = new com.tencent.qqnt.aio.adapter.background.a(1, aIOBackgroundContainer);
        }
        View b16 = aVar.b();
        if (b16 != null && (b16 instanceof com.tencent.qqnt.aio.api.b)) {
            this.weakBackgroundViews.add(new WeakReference<>(b16));
        }
        QLog.d("AIOChatBackgroundApiImpl", 1, sb5.toString());
        return aVar;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioDelayLoad(String selfUin) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        QLog.d("AIOChatBackgroundApiImpl", 1, "AIO DELAY_LOAD");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public ColorStateList getBackgroundTextColor(String uin, String peerUin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        String e16 = com.tencent.mobileqq.activity.aio.t.e(MobileQQ.sMobileQQ, uin, peerUin);
        if (e16 == null) {
            return null;
        }
        return com.tencent.mobileqq.activity.aio.t.g(MobileQQ.sMobileQQ, uin, e16);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public String getCurrentChatBackgroundBg(String curFriendUin, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        if (uinType != 1) {
            curFriendUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(curFriendUin);
        }
        return ChatBackgroundUtil.getChatBackgroundPath(BaseApplication.getContext(), VasUtil.getCurrentUin(), curFriendUin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public Drawable getCurrentChatBackgroundDrawable(String curFriendUin, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        com.tencent.mobileqq.activity.aio.t tVar = new com.tencent.mobileqq.activity.aio.t();
        if (uinType != 1) {
            curFriendUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(curFriendUin);
        }
        String str = curFriendUin;
        if (TextUtils.isEmpty(str)) {
            QLog.i("AIOChatBackgroundApiImpl", 1, "convert uin is empty string, fail");
        }
        com.tencent.mobileqq.activity.aio.t.c(BaseApplication.getContext(), VasUtil.getCurrentUin(), str, uinType, true, 7, tVar);
        Drawable drawable = tVar.f179996c;
        if (drawable != null && (drawable instanceof IGLDrawable)) {
            Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.chat_bg_texture);
            if (drawable2 instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable2).setGravity(119);
            } else if (drawable2 instanceof SkinnableBitmapDrawable) {
                ((SkinnableBitmapDrawable) drawable2).setGravity(119);
            }
            tVar.f179996c = drawable2;
        }
        return tVar.f179996c;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public boolean isAvatarBackground(String friendUid, int uinType) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(friendUid, "friendUid");
        if (!((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarSwitchConfig().getEnable()) {
            QLog.i("AIOChatBackgroundApiImpl", 1, "isAvatarBackground coupleAvatarSwitchConfig enable false");
            return false;
        }
        String friendUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(friendUid);
        IZPlanCoupleSceneHelper iZPlanCoupleSceneHelper = (IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class);
        Intrinsics.checkNotNullExpressionValue(friendUin, "friendUin");
        if (!iZPlanCoupleSceneHelper.getCoupleAvatarSwitchState(friendUin) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        ChatBackgroundManager chatBackgroundManager = manager instanceof ChatBackgroundManager ? (ChatBackgroundManager) manager : null;
        if (chatBackgroundManager == null) {
            return false;
        }
        String m3 = chatBackgroundManager.m(friendUin);
        QLog.i("AIOChatBackgroundApiImpl", 1, "isAvatarBackground, bgId: " + m3);
        return m3.equals("47967");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public boolean isDIYChaTBackground(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (peekAppRuntime.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER) instanceof ChatBackgroundManager) {
            return !Intrinsics.areEqual("null", ((ChatBackgroundManager) r0).o(uin));
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void setImmersiveBottomDrawable(ViewGroup parent, Drawable drawable) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        com.tencent.mobileqq.qui.b.f276860a.g(parent, drawable);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void setWindowFit(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context != null) {
            com.tencent.mobileqq.qui.b.f276860a.l(context.getWindow());
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioDestroy() {
        QLog.d("AIOChatBackgroundApiImpl", 1, "AIO DESTROY");
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            ThemeVideoController.getInstance().playMainAnimation();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioPause() {
        QLog.d("AIOChatBackgroundApiImpl", 1, "AIO PAUSE");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioResume() {
        QLog.d("AIOChatBackgroundApiImpl", 1, "AIO RESUME");
        Iterator<WeakReference<com.tencent.qqnt.aio.api.b>> it = this.weakBackgroundViews.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.aio.api.b bVar = it.next().get();
            if (bVar != null) {
                bVar.backgroundResume();
            }
        }
    }
}
