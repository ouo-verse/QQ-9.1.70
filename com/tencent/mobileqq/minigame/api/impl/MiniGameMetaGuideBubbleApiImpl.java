package com.tencent.mobileqq.minigame.api.impl;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.minigame.leba.MiniGameMetaLebaGuideBubbleInfo;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameMetaGuideBubbleApiImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameMetaGuideBubbleApi;", "", "shouldShowLebaGuideBubble", "Lcom/tencent/mobileqq/app/FrameFragment;", "frameFragment", "Lcom/tencent/mobileqq/minigame/leba/MiniGameMetaLebaGuideBubbleInfo;", "bubbleInfo", "showLebaMetaGuideBubble", "", "selectLebaTab", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "getGuideBubbleInfo", "isClick", "reportGuideBubble", "dismissLebaMetaGuideBubble", "hasGuideBubbleRedTouch", "hasSendGuideBubbleReq", "clearSendGuideBubbleReqFlag", "checkRedTouchWhenExit", "mIsShowGuideBubble", "Z", "", "mCurrentLebaTab", "Ljava/lang/String;", "Lcom/tencent/mobileqq/widget/tip/a;", "mGuideBubbleTip", "Lcom/tencent/mobileqq/widget/tip/a;", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameMetaGuideBubbleApiImpl implements IMiniGameMetaGuideBubbleApi {
    private static final String TAG = "MiniGameMetaGuideBubbleApiImpl";
    private String mCurrentLebaTab;
    private com.tencent.mobileqq.widget.tip.a mGuideBubbleTip;
    private boolean mIsShowGuideBubble;

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportGuideBubble(boolean isClick) {
        String str;
        String str2;
        if (isClick) {
            str = "989574";
        } else {
            str = "989573";
        }
        if (isClick) {
            str2 = "20";
        } else {
            str2 = "8";
        }
        MiniAppUtils.reportMiniGameCenterDC00087("1", "1118", "9390", "939002", str, str2, "", null);
    }

    private final boolean shouldShowLebaGuideBubble() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MiniGameVAManagerImpl.GUIDE_BUBBLE_CONFIG_ID, false);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        String str = "_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SHOWN);
        sb5.append(str);
        return isSwitchOn && !fromV2.decodeBool(sb5.toString(), false);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi
    public void checkRedTouchWhenExit() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MiniGameVAManagerImpl.GUIDE_BUBBLE_CONFIG_ID, false)) {
            QLog.d(TAG, 1, "checkRedTouchWhenExit guideBubbleSwitch off");
            return;
        }
        boolean hasSendGuideBubbleReq = hasSendGuideBubbleReq();
        boolean hasGuideBubbleRedTouch = hasGuideBubbleRedTouch();
        QLog.d(TAG, 1, "checkRedTouchWhenExit isSendReq:", Boolean.valueOf(hasSendGuideBubbleReq), ", hasRedTouch=", Boolean.valueOf(hasGuideBubbleRedTouch));
        if (hasSendGuideBubbleReq && !hasGuideBubbleRedTouch) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchServer.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ((IRedTouchServer) runtimeService).sendRedpointReq(true, false, 9);
        }
        clearSendGuideBubbleReqFlag();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi
    public void clearSendGuideBubbleReqFlag() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.encodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SEND_REQ_FLAG + ("_" + currentUin), false);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi
    public void dismissLebaMetaGuideBubble() {
        com.tencent.mobileqq.widget.tip.a aVar;
        if (!this.mIsShowGuideBubble || (aVar = this.mGuideBubbleTip) == null) {
            return;
        }
        aVar.o();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi
    public boolean hasGuideBubbleRedTouch() {
        MiniGameMetaLebaGuideBubbleInfo guideBubbleInfo;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        try {
            BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) runtimeService).getAppInfo(0, IMiniGameLebaController.MINI_GAME_RES_ID);
            if (appInfo != null && RedTouch.hasRedTouch(appInfo) && (guideBubbleInfo = getGuideBubbleInfo(appInfo)) != null) {
                if (guideBubbleInfo.getContent().length() > 0) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "hasGuideBubbleRedTouch getAppInfo exception=", e16);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi
    public boolean hasSendGuideBubbleReq() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        return fromV2.decodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SEND_REQ_FLAG + ("_" + currentUin), false);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi
    public boolean showLebaMetaGuideBubble(FrameFragment frameFragment) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        if (frameFragment == null) {
            return false;
        }
        if (this.mIsShowGuideBubble) {
            QLog.d(TAG, 1, "showLebaMetaGuideBubble showing");
            return true;
        }
        if (!(frameFragment.getCurrentFrame() instanceof Conversation)) {
            QLog.d(TAG, 1, "showLebaMetaGuideBubble currentFrame not conversation");
            return false;
        }
        if (!shouldShowLebaGuideBubble()) {
            return false;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        try {
            appInfo = iRedTouchManager.getAppInfo(0, IMiniGameLebaController.MINI_GAME_RES_ID);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showLebaMetaGuideBubble getAppInfo exception=", e16);
            appInfo = null;
        }
        if (appInfo != null) {
            appInfo.iNewFlag.get();
            appInfo.exposure_max.get();
            appInfo.push_red_ts.get();
            if (RedTouch.hasRedTouch(appInfo)) {
                MiniGameMetaLebaGuideBubbleInfo guideBubbleInfo = getGuideBubbleInfo(appInfo);
                QLog.d(TAG, 2, "showLebaMetaGuideBubble guideBubbleInfo:" + guideBubbleInfo);
                if (guideBubbleInfo != null && showLebaMetaGuideBubble(frameFragment, guideBubbleInfo)) {
                    iRedTouchManager.onRedTouchItemExposure(appInfo, null);
                    return true;
                }
            }
        } else {
            QLog.d(TAG, 1, "showLebaMetaGuideBubble appInfo null");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectLebaTab(FrameFragment frameFragment) {
        if (frameFragment == null) {
            return;
        }
        ArrayList<FrameFragment.e> arrayList = frameFragment.mTabHostTabListWithOrder;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = 0;
                break;
            }
            FrameFragment.e eVar = arrayList.get(i3);
            if ((Intrinsics.areEqual("QZONE", this.mCurrentLebaTab) && Intrinsics.areEqual(QzoneFrame.class.getName(), eVar.getTag())) || (Intrinsics.areEqual(TabDataHelper.TAB_LEBA, this.mCurrentLebaTab) && ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).isLeba(eVar.getTag()))) {
                break;
            } else {
                i3++;
            }
        }
        QLog.d(TAG, 1, "selectLebaTab index=", Integer.valueOf(i3));
        frameFragment.setCurrentTab(i3);
    }

    private final MiniGameMetaLebaGuideBubbleInfo getGuideBubbleInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        List<BusinessInfoCheckUpdate.RedTypeInfo> list;
        if (appInfo == null || (list = appInfo.red_display_info.red_type_info.get()) == null || list.size() == 0) {
            return null;
        }
        String str = "";
        int i3 = -1;
        String str2 = "";
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
            int i16 = redTypeInfo.red_type.get();
            String redContent = redTypeInfo.red_content.get();
            switch (i16) {
                case 35:
                    Intrinsics.checkNotNullExpressionValue(redContent, "redContent");
                    str2 = redContent;
                    break;
                case 36:
                    Intrinsics.checkNotNullExpressionValue(redContent, "redContent");
                    str = redContent;
                    break;
                case 37:
                    if (TextUtils.isEmpty(redContent)) {
                        break;
                    } else {
                        try {
                            Intrinsics.checkNotNullExpressionValue(redContent, "redContent");
                            i3 = Integer.parseInt(redContent);
                            break;
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, " parse duration exception=", e16);
                            break;
                        }
                    }
            }
        }
        return new MiniGameMetaLebaGuideBubbleInfo(str, str2, i3);
    }

    private final boolean showLebaMetaGuideBubble(final FrameFragment frameFragment, MiniGameMetaLebaGuideBubbleInfo bubbleInfo) {
        View v3;
        if (bubbleInfo == null) {
            return false;
        }
        if (bubbleInfo.getContent().length() == 0) {
            QLog.d(TAG, 1, "showLebaMetaGuideBubble content empty");
            return false;
        }
        View view = frameFragment.mTabViewMap.get("QZONE");
        if (view == null) {
            QLog.d(TAG, 1, "showLebaMetaGuideBubble qzone tabView null");
            view = frameFragment.mTabViewMap.get(TabDataHelper.TAB_LEBA);
            if (view == null) {
                QLog.d(TAG, 1, "showLebaMetaGuideBubble leba tabView null");
                return false;
            }
            this.mCurrentLebaTab = TabDataHelper.TAB_LEBA;
        } else {
            this.mCurrentLebaTab = "QZONE";
        }
        if (frameFragment.getBaseActivity() == null) {
            return false;
        }
        QBaseActivity baseActivity = frameFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "frameFragment.baseActivity");
        long duration = bubbleInfo.getDuration();
        if (duration != -1) {
            duration *= 1000;
        }
        this.mGuideBubbleTip = QUIDefaultBubbleTip.r(baseActivity).S(view).m0(5).R(0).k0(0).o0(bubbleInfo.getContent()).b0(duration).f(new a.b() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameMetaGuideBubbleApiImpl$showLebaMetaGuideBubble$2
            @Override // com.tencent.mobileqq.widget.tip.a.b
            public void onClick(View v16) {
                Intrinsics.checkNotNullParameter(v16, "v");
                QLog.d("MiniGameMetaGuideBubbleApiImpl", 1, "showLebaGuideBubble onclick");
                MiniGameMetaGuideBubbleApiImpl.this.selectLebaTab(frameFragment);
                MiniGameMetaGuideBubbleApiImpl.this.reportGuideBubble(true);
            }

            @Override // com.tencent.mobileqq.widget.tip.a.b
            public void onDismiss() {
                QLog.d("MiniGameMetaGuideBubbleApiImpl", 1, "showLebaGuideBubble, bubble onDismiss");
                MiniGameMetaGuideBubbleApiImpl.this.mIsShowGuideBubble = false;
            }

            @Override // com.tencent.mobileqq.widget.tip.a.b
            public void onShow() {
                QLog.d("MiniGameMetaGuideBubbleApiImpl", 1, "showLebaGuideBubble, bubble onShow");
                ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).setLebaGuideBubbleShown();
            }
        });
        if (!TextUtils.isEmpty(bubbleInfo.getIconUrl())) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            Drawable[] drawableArr = {URLDrawable.getDrawable(bubbleInfo.getIconUrl(), obtain)};
            com.tencent.mobileqq.widget.tip.a aVar = this.mGuideBubbleTip;
            if (aVar != null) {
                aVar.U(drawableArr);
            }
        }
        com.tencent.mobileqq.widget.tip.a aVar2 = this.mGuideBubbleTip;
        if (aVar2 != null) {
            aVar2.s0();
        }
        com.tencent.mobileqq.widget.tip.a aVar3 = this.mGuideBubbleTip;
        RoundImageView roundImageView = (aVar3 == null || (v3 = aVar3.v()) == null) ? null : (RoundImageView) v3.findViewById(R.id.thy);
        if (roundImageView != null) {
            roundImageView.setQwRadius(0);
        }
        this.mIsShowGuideBubble = true;
        reportGuideBubble(false);
        return true;
    }
}
