package com.tencent.mobileqq.guild.live.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.gamedatabar.QQGuildGameDataBarFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.program.GuildLiveProgramSourceBarFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLandLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveRoomBaseFragment;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.quickshare.GuildQuickDialogTheme;
import com.tencent.mobileqq.guild.quickshare.GuildQuickShareTriggerScene;
import com.tencent.mobileqq.guild.quickshare.ShareParam;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.performance.PerformanceManager;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.guild.widget.operationbanner.GuildOperationBanner;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class QQGuildBaseLiveRoomFragment extends QQGuildLiveRoomBaseFragment implements com.tencent.mobileqq.guild.live.livemanager.h, GuildLiveSwipeBackLayout.b, GuildLiveSwipeBackLayout.c {
    private static final long A_DAY_TIME = 86400000;
    private FrameLayout danmakuLayout;
    private boolean floatWindowHintDialogShowing;
    private final oq1.a guildLiveGiftBannerManager;
    private com.tencent.mobileqq.guild.live.viewmodel.module.b mAnchorInfoVM;
    private uf1.a mChannelProxyManager;
    private FrameLayout mChatBar;
    private boolean mExitRoomWhenFinish;
    private FrameLayout mGiftFullContainerView;
    private FrameLayout mGiftMsgContainerView;
    private View mLandTopBar;
    private int mLiveBusinessBarHeight;
    protected final tq1.b mLiveRoomUiData;
    protected com.tencent.mobileqq.guild.live.viewmodel.h mLiveRoomVM;
    private final com.tencent.mobileqq.guild.live.livemanager.e mLiveShowHideAnimHelper;
    private IGuildMainFrameApi mMainFrameApi;
    protected boolean mNeedExitChannelWhenFinish;
    private boolean mNeedQuickActivityAnim;
    private GuildOperationBanner mOperationBanner;
    private FloatWindowPermissionHandler mPermissionHandler;
    private FrameLayout mSubTopBar;
    private FrameLayout mSubVideoBar;
    private GuildLiveSwipeBackLayout mSwipeBackLayout;
    private View mTopBar;
    private View mTopForegroundView;
    private FrameLayout mVerticalSubTopBar;
    private FrameLayout mVideoBar;
    private final String tag = "QGL.QQGuildBaseLiveRoomFragment." + hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i(QQGuildBaseLiveRoomFragment.this.tag, 1, "showEndLiveDialog, confirmed");
            HashMap hashMap = new HashMap();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            hashMap.put("live_room_type", String.valueOf(gLiveChannelCore.s().getLiveType()));
            com.tencent.mobileqq.guild.performance.report.l.f("live_room_live_end_dialog_end", hashMap);
            gLiveChannelCore.c("showEndLiveDialog, click end live.");
            QQGuildBaseLiveRoomFragment.this.finishActivity("showEndLiveDialog, click end live.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i(QQGuildBaseLiveRoomFragment.this.tag, 1, "showEndLiveDialog, canceled");
            com.tencent.mobileqq.guild.performance.report.l.c("live_room_live_end_dialog_cancel");
        }
    }

    public QQGuildBaseLiveRoomFragment() {
        tq1.b t16 = GLiveChannelCore.f226698a.t();
        this.mLiveRoomUiData = t16;
        this.mLiveShowHideAnimHelper = new com.tencent.mobileqq.guild.live.livemanager.e();
        this.mLiveBusinessBarHeight = 0;
        this.mNeedExitChannelWhenFinish = true;
        this.mNeedQuickActivityAnim = false;
        this.mMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
        this.floatWindowHintDialogShowing = false;
        this.guildLiveGiftBannerManager = new oq1.a(t16, this);
    }

    private boolean checkCurrentIsLandShow() {
        if (getActivity() == null || getActivity().getRequestedOrientation() != 0) {
            return false;
        }
        return true;
    }

    private boolean checkHasFloatWindowPermission() {
        QLog.i(this.tag, 1, "[checkHasFloatWindowPermission] ");
        if (this.mPermissionHandler == null) {
            this.mPermissionHandler = new FloatWindowPermissionHandler(getActivity());
        }
        boolean e16 = this.mPermissionHandler.e();
        destroyPermissionHandler();
        return e16;
    }

    private void checkNeedShowGiftPanel(Bundle bundle) {
        if (!MediaChannelUtils.f228046a.s(getActivity()) && bundle != null && bundle.getBoolean("open_gift_panel")) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            gLiveChannelCore.i().i(getActivity());
            bundle.putBoolean("open_gift_panel", false);
            bundle.putLong("gift_receiver", 0L);
            Bundle bundle2 = gLiveChannelCore.s().getBundle();
            bundle2.putBoolean("open_gift_panel", false);
            bundle2.putLong("gift_receiver", 0L);
        }
    }

    private void configChatBarMarginTop() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mChatBar.getLayoutParams();
        layoutParams.topMargin = getChatBarTopMargin();
        this.mChatBar.setLayoutParams(layoutParams);
    }

    private void destroyPermissionHandler() {
        QLog.i(this.tag, 1, "[destroyPermissionHandler] " + this.mPermissionHandler);
        FloatWindowPermissionHandler floatWindowPermissionHandler = this.mPermissionHandler;
        if (floatWindowPermissionHandler != null) {
            floatWindowPermissionHandler.f();
            this.mPermissionHandler = null;
        }
    }

    private void exitChannelIfNeed(String str) {
        com.tencent.mobileqq.guild.live.viewmodel.h hVar;
        if (this.mNeedExitChannelWhenFinish && (hVar = this.mLiveRoomVM) != null && hVar.b2()) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (gLiveChannelCore.x()) {
                com.tencent.mobileqq.guild.live.livemanager.player.m K = this.mLiveRoomUiData.K();
                if (K != null) {
                    K.disableViewCallback();
                }
                this.mLiveRoomUiData.v().d();
            }
            gLiveChannelCore.b(str);
        }
    }

    private int getChatBarTopMargin() {
        if (getActivity() == null) {
            return 0;
        }
        return getGameDataBarHeight();
    }

    private int getGameDataBarHeight() {
        return this.mLiveBusinessBarHeight;
    }

    private void handleBeClosedEvent() {
        if (this.mLiveRoomVM != null && !this.mExitRoomWhenFinish) {
            if (this.mLiveRoomUiData.n().getValue() == Boolean.TRUE && checkHasFloatWindowPermission() && !GLiveChannelStartParams.fromLittleWorld()) {
                this.mNeedExitChannelWhenFinish = false;
                if (this.mLiveRoomVM.b2()) {
                    handleZoomFloatWindow(false);
                }
            }
            exitChannelIfNeed("handleBeClosedEvent");
        }
    }

    private boolean handleFloatWindowPermission() {
        if (this.mPermissionHandler == null) {
            this.mPermissionHandler = new FloatWindowPermissionHandler(getActivity());
        }
        boolean e16 = this.mPermissionHandler.e();
        if (!e16) {
            this.mPermissionHandler.l(new FloatWindowPermissionHandler.a() { // from class: com.tencent.mobileqq.guild.live.fragment.c
                @Override // com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler.a
                public final void a(boolean z16) {
                    QQGuildBaseLiveRoomFragment.this.lambda$handleFloatWindowPermission$7(z16);
                }
            });
            this.floatWindowHintDialogShowing = !this.mPermissionHandler.k(null, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.live.fragment.d
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    QQGuildBaseLiveRoomFragment.this.lambda$handleFloatWindowPermission$8(dialogInterface);
                }
            });
            QLog.i(this.tag, 1, "[handleFloatWindowPermission] floatWindowHintDialogShowing:" + this.floatWindowHintDialogShowing);
        } else {
            destroyPermissionHandler();
        }
        return e16;
    }

    private void handleFloatWindowPermissionResult(boolean z16) {
        QLog.i(this.tag, 1, "handleFloatWindowPermissionResult grant=" + z16);
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    QQGuildBaseLiveRoomFragment.this.handleZoomFloatWindow(false);
                }
            });
            return;
        }
        if (getActivity() != null && !getActivity().isDestroyed()) {
            boolean booleanValue = ((Boolean) e12.d.b(this.mLiveRoomUiData.D(), Boolean.FALSE)).booleanValue();
            boolean d16 = GLiveChannelCore.f226698a.r().d();
            if (booleanValue && d16) {
                showEndLiveDialog();
                return;
            }
            finishActivity("handleFloatWindowPermissionResult, grant:" + z16 + " selfIsAnchorLiving" + booleanValue + " liveSdkType:" + d16);
            return;
        }
        GLiveChannelCore.f226698a.b("activity destroyed, and not float permission");
    }

    private boolean handleRequestFloatWindowPermission() {
        handleZoomFloatWindow(true);
        return false;
    }

    private void initChannelLoadProxyManager() {
        GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
        if (s16.getBundle() != null && !s16.getBundle().isEmpty()) {
            this.mChannelProxyManager = new uf1.a(s16.getBundle());
        }
        uf1.a aVar = this.mChannelProxyManager;
        if (aVar != null) {
            aVar.b();
        }
    }

    private void initDanmu() {
        boolean z16;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        gLiveChannelCore.j().c();
        if (!com.tencent.mobileqq.guild.live.viewmodel.d.P1()) {
            return;
        }
        gLiveChannelCore.j().b(this, this.danmakuLayout);
        this.mLiveRoomUiData.g().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.setDanmuViewVisibility(((Boolean) obj).booleanValue());
            }
        });
        this.mLiveRoomUiData.l().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initDanmu$2((Integer) obj);
            }
        });
        if (getArguments() != null && getArguments().getBoolean("arg_from_float")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((com.tencent.mobileqq.guild.live.viewmodel.d) gLiveChannelCore.q(com.tencent.mobileqq.guild.live.viewmodel.d.class)).Q1(fn0.a.f399890a.b(), new Bundle());
        }
    }

    private void initGiftContainerView() {
        if (getShowHideAnimHelper() != null) {
            getShowHideAnimHelper().k(this.mGiftMsgContainerView, "giftBannerContainer");
            getShowHideAnimHelper().j(this.mGiftMsgContainerView, "giftBannerContainer");
            getShowHideAnimHelper().k(this.mGiftFullContainerView, "giftContainer");
            getShowHideAnimHelper().j(this.mGiftFullContainerView, "giftContainer");
        }
        initGiftView();
        GLiveChannelCore.f226698a.i().b(getViewLifecycleOwner().getLifecycle(), null, this.mGiftFullContainerView);
        this.guildLiveGiftBannerManager.f();
    }

    private void initGiftView() {
        View c16 = this.guildLiveGiftBannerManager.c(LayoutInflater.from(getContext()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(210.0f));
        layoutParams.gravity = 48;
        this.mGiftMsgContainerView.addView(c16, layoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.mGiftMsgContainerView.getLayoutParams());
        int i3 = -ViewUtils.dip2px(60.0f);
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i3, marginLayoutParams.rightMargin, marginLayoutParams.height + i3);
        this.mGiftMsgContainerView.setLayoutParams(new RelativeLayout.LayoutParams(marginLayoutParams));
    }

    private void initLiuHaiUtil() {
        if (getActivity() != null) {
            LiuHaiUtils.initLiuHaiProperty(getActivity());
            LiuHaiUtils.enableNotch(getActivity());
            LiuHaiUtils.initLiuHaiBarHeight(getActivity());
        }
    }

    private void initOperationBanner() {
        try {
            GuildOperationBanner guildOperationBanner = this.mOperationBanner;
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            guildOperationBanner.u(Long.parseLong(gLiveChannelCore.s().getGuildId()), Long.parseLong(gLiveChannelCore.s().getChannelId()), 5);
        } catch (Exception unused) {
        }
        this.mLiveRoomUiData.l().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initOperationBanner$0((Integer) obj);
            }
        });
        this.mLiveRoomUiData.w().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initOperationBanner$1((Boolean) obj);
            }
        });
    }

    private void initSubVideoBarHeight() {
        if (getContext() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSubVideoBar.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.mLiveRoomUiData.u(getActivity());
        this.mSubVideoBar.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleFloatWindowPermission$7(boolean z16) {
        QLog.i(this.tag, 1, "[onRequestPermission] floatWindowHintDialogShowing:" + this.floatWindowHintDialogShowing);
        if (!this.floatWindowHintDialogShowing) {
            handleFloatWindowPermissionResult(z16);
            destroyPermissionHandler();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleFloatWindowPermission$8(DialogInterface dialogInterface) {
        QLog.i(this.tag, 1, "[handleFloatWindowPermission] dismiss");
        this.floatWindowHintDialogShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDanmu$2(Integer num) {
        if (num.intValue() == 2) {
            ((ViewGroup.MarginLayoutParams) this.danmakuLayout.getLayoutParams()).topMargin = ViewUtils.dpToPx(5.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) this.danmakuLayout.getLayoutParams()).topMargin = ViewUtils.dpToPx(2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLiveDataObserver$3(Boolean bool) {
        if (bool == Boolean.TRUE) {
            finishActivity("observe, need finish page");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLiveDataObserver$4(Boolean bool) {
        onEnterRoomSuc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLiveDataObserver$5(Integer num) {
        QLog.i(this.tag, 1, "[initLiveDataObserver] mNormalVideoHeight = " + num);
        onVideoScreenHeightChange(this.mLiveRoomUiData.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLiveDataObserver$6(Boolean bool) {
        if (bool.booleanValue()) {
            openGuildQuickShareDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initOperationBanner$0(Integer num) {
        setOperationBannerVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initOperationBanner$1(Boolean bool) {
        setOperationBannerVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$9() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel, on resume.", false);
        }
    }

    private boolean landscapeToPortraitOrientation() {
        if (getActivity() != null && getActivity().getRequestedOrientation() == 0) {
            com.tencent.mobileqq.guild.performance.report.l.b(1, 1);
            doLandscapeToPortraitOrientation();
            return true;
        }
        return false;
    }

    private void onVideoScreenHeightChange(int i3) {
        boolean z16;
        initSubVideoBarHeight();
        configChatBarMarginTop();
        updateTopBarMargin();
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        setVideoFullScreen(z16);
        updateChatBarLayoutParams(i3);
        updateGiftMsgContainerViewLayoutParams(Integer.valueOf(i3));
        if (GLiveChannelStartParams.fromLittleWorld()) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, QQGuildUIUtil.f(78.0f), 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            this.mVideoBar.startAnimation(translateAnimation);
        }
    }

    private void openGuildQuickShareDialog() {
        QLog.i(this.tag, 1, "onLiveRoomStatusOpenEvent self open live");
        if (isAdded() && System.currentTimeMillis() - bw.L().decodeLong("key_live_open_share_tip", 0L) > 86400000) {
            bw.L().encodeLong("key_live_open_share_tip", System.currentTimeMillis());
            IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            FragmentManager childFragmentManager = getChildFragmentManager();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            iQQGuildRouterApi.openGuildQuickShareDialog(childFragmentManager, new ShareParam(gLiveChannelCore.s().getGuildInfo(), gLiveChannelCore.s().getChannelInfo(), GuildSharePageSource.LIVE_SUCCESS_QUICK_SHARE, GuildQuickShareTriggerScene.LIVE_SUCCESS, "\u5f00\u64ad\u6210\u529f~\u901f\u558a\u597d\u53cb\u6765\u56f4\u89c2\uff01", GuildQuickDialogTheme.DARK));
        }
    }

    private void removeFragmentState(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:viewHierarchyState");
            bundle.remove("android:fragments");
            bundle.remove("android:support:fragments");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEntryLiveSession(LiveChannelRoomInfo liveChannelRoomInfo) {
        setDtPageReport();
        if (liveChannelRoomInfo == null || liveChannelRoomInfo.getProgramInfo() == null || TextUtils.isEmpty(liveChannelRoomInfo.getProgramInfo().getProgramId())) {
            return;
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_sgrp_user_entry_stream_aio_session", new z().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDanmuViewVisibility(boolean z16) {
        int i3;
        FrameLayout frameLayout = this.danmakuLayout;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    private void setDtPageReport() {
        if (getActivity() != null && getActivity().getWindow() != null) {
            View decorView = getActivity().getWindow().getDecorView();
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(decorView, "pg_sgrp_stream_aio");
            VideoReport.setPageParams(decorView, new PageParams(new z().b()));
        }
    }

    private void setOperationBannerVisibility() {
        boolean z16;
        int i3 = 0;
        if (!this.mLiveRoomUiData.w().getValue().booleanValue() && this.mLiveRoomUiData.l().getValue().intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildOperationBanner guildOperationBanner = this.mOperationBanner;
        if (!z16) {
            i3 = 8;
        }
        guildOperationBanner.setVisibility(i3);
    }

    private void setVideoFullScreen(boolean z16) {
        if (getContext() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.tag, 1, "setVideoFullScreen fullScreen:" + z16);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoBar.getLayoutParams();
        if (z16) {
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.removeRule(3);
        } else {
            layoutParams.width = -1;
            layoutParams.height = this.mLiveRoomUiData.u(getActivity());
            layoutParams.addRule(3, R.id.f165561wo1);
        }
        this.mVideoBar.setLayoutParams(layoutParams);
        this.mVideoBar.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(QQGuildBaseLiveRoomFragment.this.tag, 1, "mVideoBar, left:" + QQGuildBaseLiveRoomFragment.this.mVideoBar.getLeft() + " top:" + QQGuildBaseLiveRoomFragment.this.mVideoBar.getTop() + " width:" + QQGuildBaseLiveRoomFragment.this.mVideoBar.getWidth() + "height:" + QQGuildBaseLiveRoomFragment.this.mVideoBar.getHeight());
            }
        });
    }

    private boolean shouldShowFloatViewWhenFinishAct() {
        if (((Boolean) e12.d.b(this.mLiveRoomUiData.n(), Boolean.FALSE)).booleanValue() && checkHasFloatWindowPermission()) {
            return true;
        }
        return false;
    }

    private void showEndLiveDialog() {
        String str;
        if (getContext() == null) {
            return;
        }
        QLog.i(this.tag, 1, "showEndLiveDialog.");
        String string = getResources().getString(R.string.f147650xg);
        if (GLiveChannelCore.f226698a.r().d()) {
            str = getResources().getString(R.string.f147630xe);
        } else {
            str = null;
        }
        DialogUtil.createCustomDialog(getContext(), 230, string, str, getResources().getString(R.string.f140850f3), getResources().getString(R.string.f147640xf), new a(), new b()).show();
    }

    private void switchSubTopVertical(boolean z16) {
        if (z16) {
            this.mSubTopBar.setVisibility(8);
            this.mVerticalSubTopBar.setVisibility(0);
            setDanmuViewVisibility(false);
        } else {
            this.mSubTopBar.setVisibility(0);
            this.mVerticalSubTopBar.setVisibility(8);
            tq1.b bVar = this.mLiveRoomUiData;
            bVar.V(bVar.g().getValue());
        }
    }

    private void switchUi2Land(boolean z16) {
        if (z16) {
            this.mTopBar.setVisibility(8);
            this.mLandTopBar.setVisibility(0);
            this.mSubVideoBar.setVisibility(8);
            if (!(getChildFragmentManager().findFragmentById(R.id.wmn) instanceof QQGuildTopBarLandLiveFragment)) {
                replaceFragment(R.id.wmn, QQGuildTopBarLandLiveFragment.uh());
            }
            if (com.tencent.mobileqq.guild.live.viewmodel.d.P1()) {
                this.mChatBar.setVisibility(8);
                return;
            }
            return;
        }
        this.mLandTopBar.setVisibility(8);
        this.mTopBar.setVisibility(0);
        this.mSubVideoBar.setVisibility(0);
        if (!(getChildFragmentManager().findFragmentById(R.id.f165561wo1) instanceof QQGuildTopBarLiveFragment)) {
            QQGuildLiveModuleBaseFragment Th = QQGuildTopBarLiveFragment.Th();
            Th.setArguments(getArguments());
            replaceFragment(R.id.f165561wo1, Th);
        }
        if (this.mChatBar.getVisibility() == 8) {
            this.mChatBar.setVisibility(0);
        }
    }

    private void updateChatBarLayoutParams(int i3) {
        QLog.d(this.tag, 4, "updateChatBarLayoutParams state = " + i3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mChatBar.getLayoutParams();
        if (i3 == 2 && getActivity() != null) {
            layoutParams.addRule(6, 0);
            Resources resources = getActivity().getResources();
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.cge);
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.cgb);
            layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.cgd);
            layoutParams.topMargin = 0;
        } else {
            layoutParams.addRule(6, R.id.wnp);
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = getChatBarTopMargin();
        }
        this.mChatBar.setLayoutParams(layoutParams);
        this.mChatBar.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QQGuildBaseLiveRoomFragment.this.tag, 4, "mChatBar.width = " + QQGuildBaseLiveRoomFragment.this.mChatBar.getMeasuredWidth() + ", mChatBar.height = " + QQGuildBaseLiveRoomFragment.this.mChatBar.getHeight());
            }
        });
    }

    private void updateFragmentsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(QPublicBaseFragment.TAG, 1, "updateFragmentsKey, key is empty!!!");
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString("arg_key", str);
        }
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            Bundle arguments2 = fragment.getArguments();
            if (arguments2 != null && (fragment instanceof QQGuildLiveModuleBaseFragment)) {
                arguments2.putString("arg_key", str);
            }
        }
    }

    private void updateGiftMsgContainerViewLayoutParams(Integer num) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mGiftMsgContainerView.getLayoutParams();
        if (num.intValue() == 2 && getActivity() != null) {
            layoutParams.addRule(6, R.id.wm8);
            layoutParams.addRule(3, 0);
        } else {
            layoutParams.addRule(6, 0);
            layoutParams.addRule(3, R.id.wnp);
        }
        this.mGiftMsgContainerView.setLayoutParams(layoutParams);
    }

    private void updateSwipeEnableState(boolean z16) {
        if (z16) {
            this.mSwipeBackLayout.e();
        } else {
            this.mSwipeBackLayout.f();
        }
    }

    private void updateTopBarMargin() {
        boolean z16;
        if (getActivity() != null) {
            int statusBarHeight = LiuHaiUtils.getStatusBarHeight(getActivity());
            if (getActivity().getRequestedOrientation() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.i(this.tag, 1, "LiuHaiUtils.sNotchHeight=" + LiuHaiUtils.sNotchHeight);
                }
                int i3 = LiuHaiUtils.sNotchHeight;
                if (i3 > 0) {
                    statusBarHeight = i3;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(this.tag, 1, "marginTop=" + statusBarHeight);
            }
            this.mTopBar.setPadding(0, statusBarHeight, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkToUpdateVideoState(boolean z16) {
        int i3;
        boolean isLiving = GLiveChannelCore.f226698a.s().isLiving();
        if (z16 && isLiving) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        this.mLiveRoomUiData.b0(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        if (this.mLiveRoomVM != null) {
            if (shouldShowFloatViewWhenFinishAct()) {
                QLog.i(this.tag, 1, "onFinish\uff0cshow float window.");
                this.mNeedExitChannelWhenFinish = false;
                handleZoomFloatWindow(false, false);
            }
            this.mExitRoomWhenFinish = true;
            exitChannelIfNeed("activity onFinish");
        }
        this.mLiveShowHideAnimHelper.v();
        GuildTimeRecHelper.c(GuildLiveTimeEvent.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeCardFragment() {
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag("Guild.profile.GuildProfileCard");
        if (findFragmentByTag instanceof BottomSheetDialogFragment) {
            BottomSheetDialogFragment bottomSheetDialogFragment = (BottomSheetDialogFragment) findFragmentByTag;
            if (bottomSheetDialogFragment.getDialog() != null && bottomSheetDialogFragment.getDialog().isShowing()) {
                bottomSheetDialogFragment.getDialog().dismiss();
            }
        }
    }

    abstract void doFinish();

    abstract void doLandscapeToPortraitOrientation();

    protected void finishActivity(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("finish_live_activity_reason", str);
        com.tencent.mobileqq.guild.performance.report.l.f("live_finish_activity", hashMap);
        doFinish();
    }

    public FrameLayout getGiftAnimLayout() {
        return this.mGiftMsgContainerView;
    }

    public FrameLayout getGiftFullScreenLayout() {
        return this.mGiftFullContainerView;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ewo;
    }

    @Override // nq1.c
    public com.tencent.mobileqq.guild.live.livemanager.e getLiveShowHideAnimHelper() {
        return this.mLiveShowHideAnimHelper;
    }

    @Override // nq1.c
    public void handleZoomFloatWindow(boolean z16) {
        handleZoomFloatWindow(z16, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initLiveDataObserver() {
        this.mLiveRoomUiData.l().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.onVideoScreenStateChange(((Integer) obj).intValue());
            }
        });
        this.mLiveRoomVM.f2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initLiveDataObserver$3((Boolean) obj);
            }
        });
        this.mLiveRoomUiData.n().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initLiveDataObserver$4((Boolean) obj);
            }
        });
        this.mLiveRoomUiData.t().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initLiveDataObserver$5((Integer) obj);
            }
        });
        this.mLiveRoomUiData.F().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.lambda$initLiveDataObserver$6((Boolean) obj);
            }
        });
        this.mLiveRoomUiData.p().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildBaseLiveRoomFragment.this.reportEntryLiveSession((LiveChannelRoomInfo) obj);
            }
        });
    }

    protected void initModuleFragments() {
        if (QLog.isColorLevel()) {
            QLog.i(this.tag, 1, "initAudienceFragments.");
        }
        replaceFragment(R.id.wm8, QQGuildChatBarLiveFragment.hi(getArguments()));
        replaceFragment(R.id.wo6, QQGuildVideoBarLiveFragment.Dh());
        replaceFragment(R.id.wnp, QQGuildSubVideoBarLiveFragment.Nh());
        replaceFragment(R.id.wnf, QQGuildSubTopBarLiveFragment.Bh());
        QQGuildLiveModuleBaseFragment Th = QQGuildTopBarLiveFragment.Th();
        Th.setArguments(getArguments());
        replaceFragment(R.id.f165561wo1, Th);
        replaceFragment(R.id.f165563wo3, QQGuildSubTopBarLiveFragment.Bh());
        replaceFragment(R.id.wmh, QQGuildGameDataBarFragment.INSTANCE.a());
        replaceFragment(R.id.wmy, GuildLiveProgramSourceBarFragment.INSTANCE.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NonNull View view) {
        setDtPageReport();
        if (com.tencent.mobileqq.guild.live.config.a.b()) {
            view.findViewById(R.id.f909053q).setVisibility(8);
        }
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout = (GuildLiveSwipeBackLayout) view.findViewById(R.id.f165556wn1);
        this.mSwipeBackLayout = guildLiveSwipeBackLayout;
        guildLiveSwipeBackLayout.e();
        this.mSwipeBackLayout.setOnPageSwipeListener(this);
        this.mSwipeBackLayout.setOnSwipeListener(this);
        this.mTopForegroundView = view.findViewById(R.id.f165560wo0);
        this.mTopBar = view.findViewById(R.id.f165561wo1);
        this.mLandTopBar = view.findViewById(R.id.wmn);
        this.mVideoBar = (FrameLayout) view.findViewById(R.id.wo6);
        this.mSubVideoBar = (FrameLayout) view.findViewById(R.id.wnp);
        this.mSubTopBar = (FrameLayout) view.findViewById(R.id.wnf);
        this.mVerticalSubTopBar = (FrameLayout) view.findViewById(R.id.f165563wo3);
        this.mChatBar = (FrameLayout) view.findViewById(R.id.wm8);
        configChatBarMarginTop();
        this.mGiftMsgContainerView = (FrameLayout) view.findViewById(R.id.f165558wn3);
        this.mGiftFullContainerView = (FrameLayout) view.findViewById(R.id.wmj);
        this.mOperationBanner = (GuildOperationBanner) view.findViewById(R.id.f2106000);
        this.danmakuLayout = (FrameLayout) view.findViewById(R.id.wmb);
        initGiftContainerView();
        initLiuHaiUtil();
        updateTopBarMargin();
        initSubVideoBarHeight();
        initModuleFragments();
        initDanmu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initViewModel() {
        this.mLiveRoomVM = (com.tencent.mobileqq.guild.live.viewmodel.h) GLiveChannelCore.f226698a.q(com.tencent.mobileqq.guild.live.viewmodel.h.class);
        com.tencent.mobileqq.guild.live.viewmodel.module.b bVar = (com.tencent.mobileqq.guild.live.viewmodel.module.b) com.tencent.mobileqq.guild.live.viewmodel.i.a(this).get(com.tencent.mobileqq.guild.live.viewmodel.module.b.class);
        this.mAnchorInfoVM = bVar;
        bVar.init();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        boolean fromLittleWorld = GLiveChannelStartParams.fromLittleWorld();
        this.mNeedQuickActivityAnim = fromLittleWorld;
        if (fromLittleWorld) {
            activity.overridePendingTransition(0, 0);
            return;
        }
        if (getArguments() != null && getArguments().getBoolean("arg_from_float")) {
            activity.overridePendingTransition(R.anim.f154605od, 0);
        } else if (activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA).getBoolean("jumpGuildFromLoadingPage", false)) {
            activity.overridePendingTransition(R.anim.l_, R.anim.l_);
        } else {
            activity.overridePendingTransition(R.anim.f154606oe, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // nq1.c
    public void onAIOPanelChanged(boolean z16) {
        int i3;
        if (checkCurrentIsLandShow()) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        this.mGiftMsgContainerView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveRoomBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        GLiveChannelCore.f226698a.g().J(this);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.h
    public void onAutoExitRoomPage(@Nullable String str, String str2) {
        this.mNeedExitChannelWhenFinish = false;
        QLog.i(this.tag, 1, "onAutoExitRoomPage. finishActivity.");
        finishActivity("onAutoExitRoomPage, reason:" + str2);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveRoomBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    @SuppressLint({"SourceLockedOrientationActivity"})
    public boolean onBackEvent() {
        boolean z16;
        QLog.i(this.tag, 1, "[onBackEvent] ");
        if (!landscapeToPortraitOrientation() && !super.onBackEvent()) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (gLiveChannelCore.r().c()) {
                finishActivity("onBackEvent, isEnterSdkAudienceRoom.");
                return true;
            }
            if (this.mLiveRoomUiData.D().getValue() != Boolean.TRUE && !gLiveChannelCore.s().getAnchorIsSelf()) {
                z16 = false;
            } else {
                z16 = true;
            }
            boolean b16 = gLiveChannelCore.r().b();
            boolean checkHasFloatWindowPermission = checkHasFloatWindowPermission();
            if (z16 && !b16 && !checkHasFloatWindowPermission) {
                handleRequestFloatWindowPermission();
            } else {
                finishActivity("onBackEvent, hasFloatPermission:" + checkHasFloatWindowPermission + " isSelfLiving:" + z16);
            }
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mMainFrameApi.notifyGuildFrameVisibleChanged("live onConfigurationChanged", QQGuildUIUtil.x(getContext()));
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        QLog.i(this.tag, 1, "onCreate.");
        int b16 = o02.a.b();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        gLiveChannelCore.a(gLiveChannelCore.s());
        super.onCreate(bundle);
        ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
        z.c(b16);
        if (getActivity() != null && getActivity().getIntent() != null) {
            z.d(getActivity().getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA));
        }
        PerformanceManager.l().m();
        f12.f.f397616a.f("live_channel", true);
        initChannelLoadProxyManager();
        this.mLiveRoomUiData.g0(gq1.b.b(getActivity()));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i(this.tag, 1, "onDestroy.");
        this.mLiveShowHideAnimHelper.v();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        GLiveChannelStartParams s16 = gLiveChannelCore.s();
        String string = requireArguments().getString("arg_key", "");
        if (!s16.isEmpty() && !string.equals(s16.getKey())) {
            QLog.i(this.tag, 1, "onDestroy. page key is invalid, ignore.");
            return;
        }
        handleBeClosedEvent();
        f12.f.f397616a.f("live_channel", false);
        uf1.a aVar = this.mChannelProxyManager;
        if (aVar != null) {
            aVar.c(true);
        }
        destroyPermissionHandler();
        gLiveChannelCore.j().c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.guildLiveGiftBannerManager.d();
        if (getView() instanceof ViewGroup) {
            ((ViewGroup) getView()).removeAllViews();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveRoomBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        GLiveChannelCore.f226698a.g().H0(this);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.h
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onEndLiveEvent(@NonNull sq1.b bVar) {
        landscapeToPortraitOrientation();
        if (this.mQQGuildLiveModuleControl.b() != null) {
            this.mQQGuildLiveModuleControl.b().onEndLiveEvent(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEnterRoomSuc() {
        com.tencent.mobileqq.guild.performance.report.l.b(1, 1);
        setDtPageReport();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        QLog.i(this.tag, 1, "onFinish.");
        clean();
        this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel finish.", true);
    }

    @Override // nq1.c
    public void onLiveBusinessBarHeightChanged(int i3) {
        QLog.i(this.tag, 1, "onGameDataBarChanged " + i3);
        this.mLiveBusinessBarHeight = i3;
        configChatBarMarginTop();
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.h
    public boolean onLiveRoomStatusOpenEvent() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onNewIntent(Intent intent) {
        updateFragmentsKey(GLiveChannelCore.f226698a.s().getKey());
        if (intent != null) {
            if (intent.getExtras() != null) {
                checkNeedShowGiftPanel(intent.getExtras().getBundle(AppConstants.Key.GUILD_EXTRA));
            }
            if (this.mLiveRoomVM.l2()) {
                super.onNewIntent(intent);
                landscapeToPortraitOrientation();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.b
    public void onPageSwipeClose() {
        finishActivity("onPageSwipeClose");
    }

    @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.b
    public void onPageSwipeOpen() {
        this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel, swipe cancel.", false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i(this.tag, 1, "onPause.");
        this.mOperationBanner.setAttachedPageVisibility(false);
        GLiveChannelCore.f226698a.k().h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i(this.tag, 1, "onResume.");
        GuildFloatWindowUtils.p();
        this.mOperationBanner.setAttachedPageVisibility(true);
        this.mLiveRoomVM.s2();
        GLiveChannelCore.f226698a.k().i();
        this.mSwipeBackLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildBaseLiveRoomFragment.this.lambda$onResume$9();
            }
        }, 200L);
        if (getArguments() != null) {
            checkNeedShowGiftPanel(getArguments().getBundle(AppConstants.Key.GUILD_EXTRA));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        removeFragmentState(bundle);
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            removeFragmentState(bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
        }
    }

    @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.c
    public boolean onSwipe(boolean z16) {
        if (z16) {
            if (GLiveChannelCore.f226698a.r().c()) {
                this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel, swipe start.", true);
                return true;
            }
            if (!((Boolean) e12.d.b(this.mLiveRoomUiData.D(), Boolean.FALSE)).booleanValue()) {
                this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel, swipe start.", true);
                return true;
            }
            if (!checkHasFloatWindowPermission()) {
                return handleRequestFloatWindowPermission();
            }
            this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel, swipe start.", true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVideoScreenStateChange(int i3) {
        boolean z16;
        boolean z17;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "onVideoScreenStateChange  videoState = " + i3);
        }
        boolean z18 = true;
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQGuildUIUtil.J(getActivity(), false, false);
        } else {
            QQGuildUIUtil.J(getActivity(), true, true);
        }
        if (z16) {
            this.mLiveRoomVM.X1(getActivity());
        }
        switchUi2Land(z16);
        updateSwipeEnableState(z16);
        updateTopBarMargin();
        if (i3 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        View view = this.mTopForegroundView;
        if (z17) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view.setVisibility(i16);
        if (!checkCurrentIsLandShow()) {
            switchSubTopVertical(z17);
        }
        if (i3 == 0) {
            z18 = false;
        }
        setVideoFullScreen(z18);
        updateChatBarLayoutParams(i3);
        updateGiftMsgContainerViewLayoutParams(Integer.valueOf(i3));
        this.mLiveShowHideAnimHelper.J(i3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.s().isLiving()) {
            GuildTimeRecHelper.g(GuildLiveTimeEvent.AUDIENCE_PAGE_BETWEEN_SHOW_FIRST_FRAME);
        }
        initOperationBanner();
        GuildTimeRecHelper.d(GuildLiveTimeEvent.LAUNCH_BETWEEN_PAGE_SHOW);
        vh1.k.INSTANCE.b(gLiveChannelCore.s().getGuildId(), "QQGuildBaseLiveRoomFragment");
    }

    public int tryGetJumpChannelStatusCode() {
        if (getContext() == null) {
            return 1;
        }
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (!gLiveChannelCore.s().isLiving()) {
            return 2;
        }
        if (((Boolean) e12.d.b(this.mLiveRoomUiData.D(), Boolean.FALSE)).booleanValue() && gLiveChannelCore.r().d()) {
            return 3;
        }
        return 4;
    }

    public void handleZoomFloatWindow(boolean z16, boolean z17) {
        QLog.i(this.tag, 1, "[handleZoomFloatWindow] needRequest:" + z16 + ", needAnim:" + z17);
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, new Throwable("\u6253\u5370\u8c03\u7528\u6808"), new Object[0]);
        }
        if (!z16 || handleFloatWindowPermission()) {
            boolean checkHasFloatWindowPermission = checkHasFloatWindowPermission();
            if (!z16 && !checkHasFloatWindowPermission) {
                finishActivity("handleZoomFloatWindow, needRequestPermission:" + z16 + " hasFloatPermission:" + checkHasFloatWindowPermission);
                return;
            }
            Boolean value = this.mLiveRoomUiData.J().getValue();
            boolean z18 = value == null || value.booleanValue();
            View value2 = this.mLiveRoomUiData.z().getValue();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
            IGProGuildInfo guildInfo = gLiveChannelCore.s().getGuildInfo();
            if (channelInfo == null && guildInfo == null) {
                QLog.e(this.tag, 1, "handleZoomFloatWindow, data is null, return.");
                return;
            }
            this.mNeedExitChannelWhenFinish = false;
            this.mMainFrameApi.notifyGuildFrameVisibleChanged("live channel, show float window.", true);
            com.tencent.mobileqq.guild.live.livemanager.player.m K = this.mLiveRoomUiData.K();
            if (K != null) {
                K.disableViewCallback();
            }
            GuildFloatWindowUtils.w(value2, guildInfo, channelInfo, z18, getActivity(), getView(), z17);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void finishActivity() {
        QLog.i(this.tag, 1, "finishActivity, call stack: " + QLog.getStackTraceString(new Throwable()));
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        getActivity().finish();
        if (this.mNeedQuickActivityAnim) {
            getActivity().overridePendingTransition(0, R.anim.f154589nx);
        } else {
            getActivity().overridePendingTransition(0, R.anim.f154607of);
        }
    }
}
