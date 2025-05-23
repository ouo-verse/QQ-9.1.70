package com.tencent.mobileqq.guild.api.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.aj;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAioGift;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.activity.QQGuildAIOSingleTaskTransActivity;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.chatpie.GuildChatFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.AbsJumpExtra;
import com.tencent.mobileqq.guild.jump.model.extras.ConversationTabExtra;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.top.handler.GuildGlobalTopMsgHandler;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqalbum.impl.PhotoTempUtilsImpl;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqnt.videoplay.api.IVideoPlaySoLoaderInit;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.util.ProcessUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildTempApiImpl implements IGuildTempApi {
    private static final int REMOVE_OBSERVER_TIME_OUT = 3000;
    public static final String TAG = "GuildTempApiImpl";
    private static final int VISIBLE_UNKNOWN = -1;
    private List<com.tencent.mobileqq.guild.api.c> mDrawerInitListeners;
    private ViewTreeObserver.OnGlobalLayoutListener mLayoutListener;
    private AnimatorSet mTabHideAnim;
    private AnimatorSet mTabShowAnim;
    private boolean mTabVisible = true;
    private int mTabWidgetVisible = -1;
    private int mTabBlurViewVisible = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTabState(View view, View view2) {
        QLog.i(TAG, 1, "checkTabState, mTabVisible = " + this.mTabVisible + " tabWidget=" + view.getVisibility() + " bgView=" + view2.getVisibility() + " mTabWidgetVisible=" + this.mTabWidgetVisible + " mTabBlurViewVisible=" + this.mTabBlurViewVisible);
        if (this.mTabVisible) {
            int i3 = this.mTabWidgetVisible;
            if (i3 == -1) {
                view.setVisibility(0);
            } else {
                view.setVisibility(i3);
            }
            int i16 = this.mTabBlurViewVisible;
            if (i16 == -1) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(i16);
            }
            this.mTabWidgetVisible = -1;
            this.mTabBlurViewVisible = -1;
            view.setTranslationY(0.0f);
            view2.setTranslationY(0.0f);
            return;
        }
        if (this.mTabWidgetVisible == -1) {
            this.mTabWidgetVisible = view.getVisibility();
            this.mTabBlurViewVisible = view2.getVisibility();
        }
        view.setVisibility(8);
        view2.setVisibility(8);
        int height = view.getHeight();
        if (height == 0) {
            height = com.tencent.mobileqq.util.x.c(view.getContext(), 54.0f);
        }
        float f16 = height;
        view.setTranslationY(f16);
        view2.setTranslationY(f16);
    }

    private void dismissTabWidget(QBaseActivity qBaseActivity) {
        QLog.i(TAG, 1, "dismissTabWidget");
        setTabVisibleState(false);
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment == null) {
            QLog.i(TAG, 1, "dismissTabWidget, mf is null");
            return;
        }
        resetTabHostDivider(mainFragment.mTabHost, 8);
        if (isDoingTabAnim()) {
            return;
        }
        ViewGroup viewGroup = mainFragment.mTabWidget;
        if (viewGroup.getHeight() == 0) {
            QLog.w(TAG, 1, "tab height is 0");
            checkTabState(viewGroup, mainFragment.mTabBlurView);
        } else {
            if (viewGroup.getVisibility() == 8) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "dismissTabWidget is invisible do nothing");
                    return;
                }
                return;
            }
            doDismissAnim(mainFragment, viewGroup);
        }
    }

    private void dismissTabWidgetInConversationTab(QBaseActivity qBaseActivity) {
        if (!isInConversationTab(qBaseActivity)) {
            QLog.w(TAG, 1, "not in conversation tab can't dismissTabWidget!!");
        } else {
            dismissTabWidget(qBaseActivity);
        }
    }

    private void dismissTabWidgetInGuildTab(QBaseActivity qBaseActivity) {
        if (!isInGuildTab(qBaseActivity)) {
            QLog.w(TAG, 1, "not in guild tab can't dismissTabWidget!!");
        } else {
            dismissTabWidget(qBaseActivity);
        }
    }

    private void doDismissAnim(MainFragment mainFragment, View view) {
        if (mainFragment.mTabBlurView == null) {
            QLog.i(TAG, 1, "dismissTabWidget, tab is null");
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(mainFragment.mTabBlurView, "translationY", 0.0f, view.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        this.mTabHideAnim = animatorSet;
        animatorSet.setDuration(100L);
        this.mTabHideAnim.setInterpolator(new LinearInterpolator());
        this.mTabHideAnim.playTogether(ofFloat, ofFloat2);
        this.mTabHideAnim.start();
        resetTabHostDivider(mainFragment.mTabHost, 8);
        this.mTabHideAnim.addListener(new b(view, mainFragment));
    }

    private static Intent getGuildTabMsgRecordIntent(Context context, MsgRecord msgRecord, boolean z16, String str) {
        Intent pullSplashActivityAndOpenChannelIntent;
        QLog.i(TAG, 1, "getGuildTabMsgRecordIntent");
        String guildId = msgRecord.getGuildId();
        boolean z17 = false;
        int channelTypeLaunchChatPie = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getChannelTypeLaunchChatPie(MobileQQ.sMobileQQ.peekAppRuntime(), 0, guildId, str);
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached() || (channelTypeLaunchChatPie != 1 && channelTypeLaunchChatPie != 2 && channelTypeLaunchChatPie != 5)) {
            z17 = true;
        }
        if (z17) {
            LaunchGuildChatPieParam a16 = new LaunchGuildChatPieParam().l(guildId).b(str).k(null).r(true).o(1).f(true).p(msgRecord).g(10).a();
            if (z16 && !MsgExtKt.V(msgRecord)) {
                if (a16.G == null) {
                    a16.G = new Bundle();
                }
                a16.G.putBoolean(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_IS_NEED_JUMP, true);
                a16.G.putLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, msgRecord.getMsgSeq());
            }
            if (channelTypeLaunchChatPie == 7) {
                if (a16.G == null) {
                    a16.G = new Bundle();
                }
                a16.G.putString("detailId", msgRecord.getFeedId());
            }
            pullSplashActivityAndOpenChannelIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(context, a16);
        } else {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, str);
            if (!MsgExtKt.V(msgRecord)) {
                jumpGuildParam.getExtras().putLong("navigate_msg_seq", msgRecord.getMsgSeq());
            }
            jumpGuildParam.getExtras().putInt("openGuildAioFrom", 10);
            pullSplashActivityAndOpenChannelIntent = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getPullSplashActivityAndOpenChannelIntent(context, jumpGuildParam);
        }
        QLog.i(TAG, 1, "getGuildTabMsgRecordIntent channelId:" + str + " openByMF:" + z17);
        return pullSplashActivityAndOpenChannelIntent;
    }

    private static Intent getGuildTabNoticeFeedMsgRecordIntent(Context context, Message message, String str, String str2, String str3) {
        Object obj = message.extObj;
        Intent guildChatPieIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(context, new LaunchGuildChatPieParam().l(str).b(str2).k(obj instanceof Bundle ? (Bundle) obj : null).r(true).f(true).g(10).a());
        guildChatPieIntent.putExtra("goto_guildtab_actiontype", GuildMainFrameConstants.E);
        Bundle bundleExtra = guildChatPieIntent.getBundleExtra("goto_guildtab_actionextra");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        if (!TextUtils.isEmpty(str3)) {
            JumpGuildNoticeMsg jumpGuildNoticeMsg = new JumpGuildNoticeMsg(1, str, str2, str3, false, 0);
            guildChatPieIntent.putExtra(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG, (Parcelable) jumpGuildNoticeMsg);
            bundleExtra.putParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG, jumpGuildNoticeMsg);
        }
        guildChatPieIntent.putExtra("goto_guildtab_actionextra", bundleExtra);
        return guildChatPieIntent;
    }

    private void handelParamsJump(FrameFragment frameFragment, JumpGuildParam jumpGuildParam) {
        ConversationTabExtra conversationTabExtra = (ConversationTabExtra) AbsJumpExtra.loadFrom(jumpGuildParam.extras, ConversationTabExtra.class);
        if (conversationTabExtra != null && conversationTabExtra.getJumpToMsgListOnly()) {
            QLog.i(TAG, 1, "handleConversationJump: getJumpToMsgListOnly");
            return;
        }
        if (conversationTabExtra != null && conversationTabExtra.getScrollToItemOnly()) {
            QLog.e(TAG, 1, "handleConversationJump: scrollToItemOnly " + jumpGuildParam.guildId);
            GuildSlideCoordinator.y(af1.a.a(jumpGuildParam));
            return;
        }
        int i3 = jumpGuildParam.getExtras().getInt(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, -1);
        if (i3 != -1) {
            QLog.e(TAG, 1, "handleConversationJump: startMyGuildBoxFragmentWithJumpParam  pushFrom:" + i3);
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildHomeFragment(frameFragment.requireContext(), jumpGuildParam);
            return;
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(frameFragment.requireContext(), jumpGuildParam);
    }

    private void handleUrlJump(FrameFragment frameFragment, String str) {
        if (!str.startsWith("http") && !str.startsWith("https")) {
            ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), frameFragment.requireContext(), str);
            if (c16 == null) {
                QLog.e(TAG, 1, "handleUrlJump: url parser error");
                return;
            } else {
                QLog.d(TAG, 1, "handleUrlJump: result:", Boolean.valueOf(c16.b()), " url:", str);
                return;
            }
        }
        openGuildByShareUrl(frameFragment.requireContext(), str, "");
    }

    private void hideTabWidgetInstantly(QBaseActivity qBaseActivity) {
        QLog.i(TAG, 1, "hideTabWidgetInstantly");
        setTabVisibleState(false);
        if (isDoingTabAnim()) {
            return;
        }
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment != null && mainFragment.mTabBlurView != null) {
            ViewGroup viewGroup = mainFragment.mTabWidget;
            QLog.d(TAG, 2, "hideTabWidgetInstantly");
            checkTabState(viewGroup, mainFragment.mTabBlurView);
            resetTabHostDivider(mainFragment.mTabHost, 8);
            return;
        }
        QLog.i(TAG, 1, "hideTabWidgetInstantly, tab is null");
    }

    private boolean isDoingTabAnim() {
        AnimatorSet animatorSet = this.mTabShowAnim;
        if (animatorSet != null && animatorSet.isRunning()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "isDoingTabShowAnim");
            }
            return true;
        }
        AnimatorSet animatorSet2 = this.mTabHideAnim;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isDoingTabHidAnim");
        }
        return true;
    }

    private boolean isInConversationTab(QBaseActivity qBaseActivity) {
        if (qBaseActivity instanceof SplashActivity) {
            Fragment findFragmentByTag = qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
            if (findFragmentByTag instanceof MainFragment) {
                MainFragment mainFragment = (MainFragment) findFragmentByTag;
                return mainFragment.getFrame(Conversation.class) != null && mainFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a;
            }
            QLog.w(TAG, 1, "splash activity do not has main fragment!");
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isInConversationTab context is=");
            sb5.append(qBaseActivity == null ? "null" : qBaseActivity.getClass().getSimpleName());
            QLog.w(TAG, 1, sb5.toString());
        }
        return false;
    }

    private void setTabVisibleState(boolean z16) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            QLog.e(TAG, 1, "check here. it must be called on main thread!!!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "setTabVisibleState " + z16);
        }
        this.mTabVisible = z16;
    }

    private void showTabWidget(QBaseActivity qBaseActivity) {
        QLog.i(TAG, 1, "showTabWidget");
        setTabVisibleState(true);
        if (isDoingTabAnim()) {
            return;
        }
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment != null && mainFragment.mTabBlurView != null) {
            ViewGroup viewGroup = mainFragment.mTabWidget;
            if (viewGroup.getHeight() == 0) {
                QLog.w(TAG, 1, "showTabWidget height is zero");
                checkTabState(viewGroup, mainFragment.mTabBlurView);
                return;
            }
            if (viewGroup.getVisibility() == 0 && viewGroup.getTranslationY() == 0.0f) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "showTabWidget is visible do nothing");
                    return;
                }
                return;
            }
            viewGroup.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getHeight(), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(mainFragment.mTabBlurView, "translationY", r7.getHeight(), 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mTabShowAnim = animatorSet;
            animatorSet.setDuration(100L);
            this.mTabShowAnim.playTogether(ofFloat, ofFloat2);
            this.mTabShowAnim.setInterpolator(new LinearInterpolator());
            this.mTabShowAnim.start();
            resetTabHostDivider(mainFragment.mTabHost, 0);
            this.mTabShowAnim.addListener(new a(viewGroup, mainFragment));
            return;
        }
        QLog.i(TAG, 1, "showTabWidget, tab is null");
    }

    private void showTabWidgetInstantly(QBaseActivity qBaseActivity) {
        QQBlurViewWrapper qQBlurViewWrapper;
        QLog.i(TAG, 1, "showTabWidgetInstantly mTabVisible=" + this.mTabVisible);
        boolean z16 = this.mTabVisible;
        setTabVisibleState(true);
        if (isDoingTabAnim()) {
            return;
        }
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment != null && (qQBlurViewWrapper = mainFragment.mTabBlurView) != null) {
            checkTabState(mainFragment.mTabWidget, qQBlurViewWrapper);
            if (z16) {
                return;
            }
            resetTabHostDivider(mainFragment.mTabHost, 0);
            return;
        }
        QLog.i(TAG, 1, "showTabWidgetInstantly, tab is null");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void addOnDrawerInitListener(com.tencent.mobileqq.guild.api.c cVar) {
        if (this.mDrawerInitListeners == null) {
            this.mDrawerInitListeners = new ArrayList();
        }
        this.mDrawerInitListeners.add(cVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void adjustTab(QBaseActivity qBaseActivity) {
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (isInGuildTab(qBaseActivity)) {
            boolean isAioFullyOpen = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isAioFullyOpen(mainFragment);
            boolean isAioFullyOnLeft = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isAioFullyOnLeft(mainFragment);
            boolean isGuildSearchPageShow = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isGuildSearchPageShow(mainFragment);
            boolean isSplitViewState = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplitViewState(qBaseActivity);
            boolean b16 = com.tencent.mobileqq.guild.mainframe.h.b();
            if (isSplitViewState && !b16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "adjustTab, isSplitViewState, showTabWidget");
                }
                showTabWidget(qBaseActivity);
            } else if (!isAioFullyOpen && !isAioFullyOnLeft && !isGuildSearchPageShow && !b16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "adjustTab. showTabWidget");
                }
                showTabWidget(qBaseActivity);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "adjustTab. dismissTabWidget done");
                }
                dismissTabWidgetInGuildTab(qBaseActivity);
            }
        } else if (mainFragment != null && mainFragment.isVisible()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "adjustTab. showTabWidgetInstantly");
            }
            showTabWidgetInstantly(qBaseActivity);
        }
        ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).onConversationTabChanged(isInConversationTab(qBaseActivity));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void buildTeamShareForwardIntent(Intent intent, QBaseActivity qBaseActivity) {
        intent.putExtra("forward_type", 1002);
        intent.putExtra("call_by_forward", true);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean checkChatPie(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean checkGuildMainFrameShow() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (!(qBaseActivity instanceof SplashActivity)) {
            return false;
        }
        Fragment findFragmentByTag = qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (!(findFragmentByTag instanceof MainFragment)) {
            return false;
        }
        MainFragment mainFragment = (MainFragment) findFragmentByTag;
        return mainFragment.getFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()) != null && mainFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183047j && SplashActivity.currentFragment == 1;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public int convActiveTab(int i3) {
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183047j) {
            return 1;
        }
        return i3 == com.tencent.mobileqq.activity.home.impl.a.f183038a ? 2 : 0;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public int getCurrentActiveTab() {
        if (SplashActivity.sWeakInstance == null || SplashActivity.sWeakInstance.get() == null) {
            return 0;
        }
        return convActiveTab(SplashActivity.sWeakInstance.get().getCurrentTab());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public Class getGuildForwardListFragmentClass() {
        return GuildSelectorForwardFragment.class;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (((com.tencent.mobileqq.qqguildsdk.api.IGPSService) r0.getRuntimeService(com.tencent.mobileqq.qqguildsdk.api.IGPSService.class, "")).isQQMsgListGuild(java.lang.Long.parseLong(r11)) != false) goto L19;
     */
    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent getGuildIntent(Context context, Message message, boolean z16, String str) {
        Intent guildTabNoticeFeedMsgRecordIntent;
        Object obj = message.extObj;
        if (obj instanceof MsgRecord) {
            MsgRecord msgRecord = (MsgRecord) obj;
            if (!i12.a.e(((MsgRecord) obj).getGuildId()) && (!((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome() || msgRecord.getDirectMsgFlag() == 1)) {
                guildTabNoticeFeedMsgRecordIntent = getGuildTabMsgRecordIntent(context, msgRecord, z16, str);
            } else {
                guildTabNoticeFeedMsgRecordIntent = i12.a.a(context, (MsgRecord) message.extObj, z16, str);
            }
        } else {
            String b16 = su1.c.b(message);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str2 = "";
            boolean z17 = false;
            if (peekAppRuntime != null) {
                try {
                    if (!((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
                    }
                    z17 = true;
                } catch (Exception unused) {
                    QLog.e(TAG, 1, "isQQMsgListGuild Exception, guildId=" + b16);
                }
            }
            Object obj2 = message.extObj;
            if (obj2 instanceof Bundle) {
                str2 = ((Bundle) obj2).getString("detailId");
            }
            if (z17) {
                guildTabNoticeFeedMsgRecordIntent = i12.a.b(context, message, b16, str, str2);
            } else {
                guildTabNoticeFeedMsgRecordIntent = getGuildTabNoticeFeedMsgRecordIntent(context, message, b16, str, str2);
            }
        }
        QLog.i(TAG, 1, "dona_push getGuildIntent i " + guildTabNoticeFeedMsgRecordIntent.getExtras());
        return guildTabNoticeFeedMsgRecordIntent;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public FrameFragment getMainFragment() {
        QBaseActivity splashActivity = getSplashActivity();
        if (splashActivity != null) {
            return (FrameFragment) splashActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public long getReplyMsgCommentCnt(MessageRecord messageRecord) {
        MessageForReplyText.SourceMsgInfo sourceMsgInfo;
        if (!(messageRecord instanceof MessageForReplyText) || (sourceMsgInfo = ((MessageForReplyText) messageRecord).mSourceMsgInfo) == null) {
            return 0L;
        }
        return sourceMsgInfo.commentCnt;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public QBaseActivity getSplashActivity() {
        if (SplashActivity.sWeakInstance == null) {
            return null;
        }
        return SplashActivity.sWeakInstance.get();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public Map<String, Object> getTitleData() {
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap.put("showRedDot", bool);
        hashMap.put("visiable", bool);
        hashMap.put("msgTab_unselectRes", Integer.valueOf(R.drawable.f135100));
        hashMap.put("msgTab_selectRes", Integer.valueOf(R.drawable.f159662yc));
        hashMap.put("feedTab_unselectRes", Integer.valueOf(R.drawable.f135302));
        hashMap.put("feedTab_selectRes", Integer.valueOf(R.drawable.f135201));
        return hashMap;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void handleConversationJump(FrameFragment frameFragment, Bundle bundle) {
        try {
            QLog.d("Guild.jump.", 1, "jumpTo GuildConversationFrame extra = ", bundle);
            if (!TextUtils.isEmpty(bundle.getString("ConversationTabUrlJump"))) {
                com.tencent.mobileqq.guild.mainframe.h.a().postValue(new ef1.a<>(Boolean.TRUE));
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpDirectMsgAio(frameFragment.requireContext(), bundle);
                return;
            }
            if (bundle.getInt("goto_guildtab_actiontype", -1) == GuildMainFrameConstants.f227277u) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpDirectMsgAio(frameFragment.requireContext(), bundle);
                return;
            }
            String string = bundle.getString(IGuildMainFrameApi.APP_VERSION);
            String str = AppSetting.f99551k;
            if (!str.equals(string)) {
                QLog.e("Guild.jump.", 1, "handleConversationJump version error, ", string, APLogFileUtil.SEPARATOR_LOG, str);
                return;
            }
            JumpGuildParam jumpGuildParam = (JumpGuildParam) bundle.getParcelable(JumpGuildParam.class.getCanonicalName());
            if (jumpGuildParam != null) {
                com.tencent.mobileqq.guild.mainframe.h.a().postValue(new ef1.a<>(Boolean.TRUE));
                handelParamsJump(frameFragment, jumpGuildParam);
            } else {
                QQToastUtil.showQQToast(1, "\u6253\u5f00\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                QLog.e(TAG, 1, "handleConversationJump error ", bundle);
            }
        } catch (Exception e16) {
            QLog.e("Guild.jump.", 1, "handleConversationJump error ", e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void handleReceivedMessage(int i3, boolean z16, boolean z17, Message message, AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            try {
                ((QQAppInterface) appRuntime).handleReceivedMessage(i3, z16, z17, message);
            } catch (Exception e16) {
                com.tencent.mobileqq.guild.util.s.f(TAG, "handleReceivedMessage", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void initVideoPlaySo() {
        ((IVideoPlaySoLoaderInit) QRoute.api(IVideoPlaySoLoaderInit.class)).initLoader();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isAtMeMsgApi(MsgRecord msgRecord, String str) {
        return qr0.e.b(msgRecord, str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isChatFragmentShowing(Activity activity) {
        return (activity instanceof SplashActivity) && SplashActivity.currentFragment == 2;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isConversationGuildContentVisible(Activity activity) {
        return isInConversationTabSelected(activity) && GuildSlideCoordinator.s();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isDisplayGuildFrameLayout() {
        return GuildSlideCoordinator.s();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isEmptyBeforeMessageSend(Object obj) {
        if (!(obj instanceof a61.a)) {
            return false;
        }
        a61.a aVar = (a61.a) obj;
        ArrayList<LocalMediaInfo> selectedMediaInfos = ((IGuildSelectMediaNotifyService) aVar.j().getRuntimeService(IGuildSelectMediaNotifyService.class, "")).getSelectedMediaInfos(aVar.d());
        return selectedMediaInfos == null || selectedMediaInfos.size() <= 0;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isGiftMsg(MessageRecord messageRecord) {
        ArkAppMessage arkAppMessage;
        if (messageRecord instanceof MessageForAioGift) {
            return true;
        }
        if (!(messageRecord instanceof MessageForArkApp) || (arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message) == null) {
            return false;
        }
        return TextUtils.equals("com.tencent.channel.gift", arkAppMessage.appName);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isGuildChatPieFilterMsg(AppRuntime appRuntime, ChatMessage chatMessage) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isGuildListUIAtBottom() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isGuildTabSelected() {
        SplashActivity splashActivity = QBaseActivity.sTopActivity;
        if (!(splashActivity instanceof SplashActivity) && SplashActivity.sWeakInstance != null && SplashActivity.sWeakInstance.get() != null) {
            splashActivity = SplashActivity.sWeakInstance.get();
        }
        return isInGuildTab(splashActivity);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isInConversationTabSelected(Activity activity) {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        return baseActivity instanceof SplashActivity ? ((SplashActivity) baseActivity).getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a : (activity instanceof SplashActivity) && ((SplashActivity) activity).getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isInGuildTab() {
        return isInGuildTab(QBaseActivity.sTopActivity);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isLiveChannelOpen() {
        ChatFragment chatFragment;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity == null || (chatFragment = baseActivity.getChatFragment()) == null) {
            return false;
        }
        return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildLiveChannelChatPie(chatFragment.qh());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isMainFragmentTabShowing() {
        Object obj;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        QLog.d(TAG, 1, "isInMainFragment  QBaseActivity.sTopActivity: " + qBaseActivity + " currentFragment:" + SplashActivity.currentFragment);
        if (!(qBaseActivity instanceof SplashActivity) || SplashActivity.currentFragment != 1) {
            return false;
        }
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment != null && mainFragment.mTabBlurView != null && mainFragment.isResumed()) {
            if (FrameHelperActivity.Gi()) {
                QLog.d(TAG, 1, "isInMainFragment isDrawerFrameOpenOrMoving");
                return false;
            }
            ViewGroup viewGroup = mainFragment.mTabWidget;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isInMainFragment tabWidget: ");
            sb5.append(viewGroup.getVisibility() == 0);
            sb5.append(" height:");
            sb5.append(viewGroup.getHeight());
            QLog.d(TAG, 1, sb5.toString());
            return viewGroup.getVisibility() == 0 && viewGroup.getHeight() != 0;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("isInMainFragment  MainFragment: ");
        sb6.append(mainFragment);
        sb6.append(" tabBlueView: ");
        Object obj2 = "mfIsNull";
        if (mainFragment == null) {
            obj = "mfIsNull";
        } else {
            obj = mainFragment.mTabBlurView;
        }
        sb6.append(obj);
        sb6.append(" isResume: ");
        if (mainFragment != null) {
            obj2 = Boolean.valueOf(mainFragment.isResumed());
        }
        sb6.append(obj2);
        QLog.d(TAG, 1, sb6.toString());
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isMainProcessOnTop() {
        return ProcessUtils.isQQ(ProcessUtils.getRunningProcessPackageName());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isMyPersonalRedPacketMsg(AppRuntime appRuntime, MessageRecord messageRecord) {
        MessageForQQWalletMsg messageForQQWalletMsg;
        QQWalletRedPacketMsg qQWalletRedPacketMsg;
        if (isPersonalRedPacketMsg(messageRecord) && (qQWalletRedPacketMsg = (messageForQQWalletMsg = (MessageForQQWalletMsg) messageRecord).mQQWalletRedPacketMsg) != null && qQWalletRedPacketMsg.specifyUinList != null) {
            String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            Iterator<Long> it = messageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
            while (it.hasNext()) {
                if (selfTinyId.equals(String.valueOf(it.next().longValue()))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isPersonalRedPacketMsg(MessageRecord messageRecord) {
        if (!((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(messageRecord)) {
            return false;
        }
        int i3 = ((MessageForQQWalletMsg) messageRecord).messageType;
        return i3 == 7 || i3 == 8 || i3 == 31;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isRedPacketMsg(MessageRecord messageRecord) {
        return ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(messageRecord);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isRedPacketMsgApi(MsgRecord msgRecord) {
        return qr0.e.f(msgRecord);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isShowContent(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).isShowMsgContent();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isSourceRevokeForReplyMsg(MessageRecord messageRecord) {
        MessageForReplyText.SourceMsgInfo sourceMsgInfo;
        if (!(messageRecord instanceof MessageForReplyText) || (sourceMsgInfo = ((MessageForReplyText) messageRecord).mSourceMsgInfo) == null) {
            return false;
        }
        int i3 = sourceMsgInfo.oriMsgRevokeType;
        return i3 == 2 || i3 == 1;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isSplashActivity(Activity activity) {
        return ep.a(activity) instanceof SplashActivity;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public Intent jumpToCropActivity(Activity activity, Intent intent) {
        return new PhotoTempUtilsImpl().toCropActivity(activity, intent);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void jumpTpAioPosition(AppRuntime appRuntime, String str, String str2, long j3) {
        if (appRuntime instanceof AppInterface) {
            com.tencent.mobileqq.guild.top.handler.a aVar = (com.tencent.mobileqq.guild.top.handler.a) ((AppInterface) appRuntime).getBusinessHandler(GuildGlobalTopMsgHandler.class.getName());
            Bundle bundle = new Bundle();
            bundle.putLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, j3);
            bundle.putLong("openGuildAioFrom", 9L);
            bundle.putString(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, str2);
            aVar.A(true, bundle, u02.a.f438022e);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean needHidePanel() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void notifyGuildHiddenChanged(QBaseFragment qBaseFragment) {
        if (qBaseFragment instanceof GuildChatFragment) {
            ((GuildChatFragment) qBaseFragment).rh(true, GuildMainFrameConstants.G);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public String obtainConversationTabGuildContentGuildId() {
        return GuildSlideCoordinator.o();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public be obtainGuildMainFrame() {
        be obtainGuildMainFrame = obtainGuildMainFrame(BaseActivity.sTopActivity);
        if (obtainGuildMainFrame != null) {
            return obtainGuildMainFrame;
        }
        if (SplashActivity.sWeakInstance == null) {
            return null;
        }
        return obtainGuildMainFrame(SplashActivity.sWeakInstance.get());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public View obtainTabWidget(QBaseActivity qBaseActivity) {
        MainFragment mainFragment = (MainFragment) qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment != null && mainFragment.mTabBlurView != null) {
            return mainFragment.mTabWidget;
        }
        QLog.i(TAG, 1, "obtainTabWidget, tab is null");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void onDrawerInit() {
        List<com.tencent.mobileqq.guild.api.c> list = this.mDrawerInitListeners;
        if (list != null) {
            Iterator<com.tencent.mobileqq.guild.api.c> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDrawerInit();
            }
            this.mDrawerInitListeners.clear();
            this.mDrawerInitListeners = null;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void onGuildChatFragmentActivityResult(QBaseFragment qBaseFragment, int i3, int i16, Intent intent) {
        if (qBaseFragment instanceof GuildChatFragment) {
            ((GuildChatFragment) qBaseFragment).onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void openChannelInChannel(Context context, String str, String str2, String str3, int i3, JumpGuildParam.JoinInfoParam joinInfoParam, GuildAppReportSourceInfo guildAppReportSourceInfo, int i16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        boolean z16 = true;
        QLog.i(TAG, 1, "openChannelInChannel: sourceChannelId[" + str + "] targetChannelId[" + str3 + "]");
        if (str != null && str.equals(str3)) {
            QQToast.makeText(context, "\u5df2\u5728\u8be5\u5b50\u9891\u9053\u4e2d", 0).show();
            return;
        }
        IGProChannelInfo channelInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        IGProChannelInfo channelInfo2 = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str3);
        if (channelInfo == null) {
            QQToast.makeText(context, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        if (!((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).isGuest(str2) && channelInfo2 == null) {
            QLog.i(TAG, 1, "targetChannel[" + str3 + "] not exist");
            QQToast.makeText(context, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        String guildId = channelInfo.getGuildId();
        boolean isGuest = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).isGuest(guildId);
        boolean z17 = guildAppReportSourceInfo != null && guildAppReportSourceInfo.getStartFromGuildTab() && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected();
        if (!isGuest && channelInfo2 != null && z17) {
            if (context instanceof QQGuildAIOSingleTaskTransActivity) {
                QQGuildAIOSingleTaskTransActivity qQGuildAIOSingleTaskTransActivity = (QQGuildAIOSingleTaskTransActivity) context;
                int tryGetJumpChannelStatusCode = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).tryGetJumpChannelStatusCode(qQGuildAIOSingleTaskTransActivity.getFragment());
                if (tryGetJumpChannelStatusCode == 0 || tryGetJumpChannelStatusCode == 1 || tryGetJumpChannelStatusCode == 2 || tryGetJumpChannelStatusCode == 4) {
                    qQGuildAIOSingleTaskTransActivity.finish();
                }
                if (tryGetJumpChannelStatusCode == 3) {
                    QQToast.makeText(context, "\u6b63\u5728\u76f4\u64ad\u4e2d\uff0c\u8bf7\u5173\u64ad\u540e\u518d\u8bd5\u3002", 0).show();
                    z16 = false;
                }
            }
            if (z16) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(i16);
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildInTab(context, guildId, str3, guildAppReportSourceInfo);
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "openChannelInChannel: jump channel with standalone.");
        if (isGuest && joinInfoParam == null) {
            QLog.e(TAG, 1, "openChannelInChannel: guest and join info is null.");
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str2, str3, joinInfoParam);
        jumpGuildParam.setSourceChannelId(str);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void openGuildByShareUrl(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("param_force_internal_browser", true);
        bundle.putBoolean("key_isReadModeEnabled", true);
        GuildWebApiImpl.guildOpenWebUrlOnly(context, str, bundle, "", "");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean otherDevLoginMute(AppInterface appInterface) {
        return ((rd0.g) appInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).m();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void printAtMsgInfoLog(String str, MessageRecord messageRecord) {
        ArrayList<AtTroopMemberInfo> troopMemberInfoFromExtrJson;
        try {
            if ((messageRecord instanceof MessageForText) || (messageRecord instanceof MessageForReplyText)) {
                String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
                String str2 = messageRecord.f203106msg;
                StringBuilder sb5 = new StringBuilder();
                if (TextUtils.isEmpty(extInfoFromExtStr) || TextUtils.isEmpty(str2) || (troopMemberInfoFromExtrJson = MessageForText.getTroopMemberInfoFromExtrJson(extInfoFromExtStr)) == null || troopMemberInfoFromExtrJson.size() <= 0) {
                    return;
                }
                Iterator<AtTroopMemberInfo> it = troopMemberInfoFromExtrJson.iterator();
                while (it.hasNext()) {
                    AtTroopMemberInfo next = it.next();
                    short s16 = next.startPos;
                    if (s16 >= 0 && s16 < str2.length()) {
                        short s17 = next.startPos;
                        short s18 = next.textLen;
                        if (s17 + s18 > 0 && s17 + s18 <= str2.length() && str2.length() >= next.startPos + next.textLen) {
                            sb5.append("[");
                            sb5.append("uin:");
                            sb5.append(next.uin);
                            sb5.append(" ");
                            short s19 = next.startPos;
                            sb5.append(str2.substring(s19, next.textLen + s19));
                            sb5.append("]");
                        }
                    }
                }
                QLog.i(str, 1, "printAtMsgInfoLog:" + sb5.toString());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void refreshMsgTabUnreadNum(AppRuntime appRuntime) {
        ((QQAppInterface) appRuntime).refreshMsgTabUnreadNum(true, 0);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void saveRecentForwardGuildRecord(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "saveRecentForwardGuildRecord " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ForwardUtils.i0((QQAppInterface) peekAppRuntime, str, 10027, str);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void sendClientAuthSuccessToArk(String str, String str2) {
        GuildClientAuthNotify.a(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void setDrawerFrameEnable(boolean z16) {
        FrameHelperActivity.gj(z16, TAG);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void setPreRemoveRoamMsgSeqSet(String str, HashSet<Long> hashSet) {
        q61.a.a(str, hashSet);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void setSelectMember(String str, String str2, Drawable drawable) {
        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).setReceiverInfo(str, str2, drawable);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean setSourceRevokeForReplyMsg(MessageRecord messageRecord, int i3) {
        MessageForReplyText.SourceMsgInfo sourceMsgInfo;
        if ((messageRecord instanceof MessageForReplyText) && (sourceMsgInfo = ((MessageForReplyText) messageRecord).mSourceMsgInfo) != null) {
            try {
                if (sourceMsgInfo.oriMsgRevokeType != i3) {
                    sourceMsgInfo.oriMsgRevokeType = i3;
                    messageRecord.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(sourceMsgInfo)));
                    return true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void setTabWidgetVisible(QBaseActivity qBaseActivity, boolean z16) {
        if (qBaseActivity instanceof SplashActivity) {
            if (z16) {
                showTabWidgetInstantly(qBaseActivity);
            } else {
                hideTabWidgetInstantly(qBaseActivity);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setTabWidgetVisible, visible = " + z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean shouldJumpConversationTab(String str) {
        return i12.a.e(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void startDownloadPic(ArrayList<MessageRecord> arrayList, boolean z16, AppInterface appInterface) {
        com.tencent.mobileqq.app.handler.c.b(arrayList, z16, appInterface);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void startGuildLiveActivity(Class<? extends QPublicBaseFragment> cls, Intent intent) {
        QQGuildAIOSingleTaskTransActivity.b.a(intent, QQGuildAIOSingleTaskTransActivity.class, cls);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void tabWidgetAnim(QBaseActivity qBaseActivity, boolean z16) {
        if ((qBaseActivity instanceof SplashActivity) && SplashActivity.currentFragment == 1) {
            if (z16) {
                showTabWidget(qBaseActivity);
            } else {
                dismissTabWidgetInGuildTab(qBaseActivity);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void tabWidgetAnimInConversation(QBaseActivity qBaseActivity, boolean z16) {
        if ((qBaseActivity instanceof SplashActivity) && SplashActivity.currentFragment == 1) {
            if (z16) {
                showTabWidget(qBaseActivity);
            } else {
                dismissTabWidgetInConversationTab(qBaseActivity);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean updateReferCommonInfo(MessageRecord messageRecord, MessageRecord messageRecord2) {
        MessageForReplyText.SourceMsgInfo sourceMsgInfo;
        if (!(messageRecord instanceof MessageForReplyText) || messageRecord2 == null || (sourceMsgInfo = ((MessageForReplyText) messageRecord).mSourceMsgInfo) == null) {
            return false;
        }
        cu1.a a16 = cu1.a.a(messageRecord2.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_SELF_COMMENT_INFO));
        long j3 = a16 != null ? a16.f391846a : 0L;
        if (sourceMsgInfo.commentCnt != j3) {
            sourceMsgInfo.commentCnt = j3;
            try {
                messageRecord.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(sourceMsgInfo)));
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void doFirstDrawCompleted(QBaseActivity qBaseActivity) {
        QLog.i(TAG, 1, "[doFirstDrawCompleted] ");
        ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).onConversationTabChanged(isInConversationTab(qBaseActivity));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public Activity getCurrentTopActivity() {
        Activity activity;
        if (2 == MobileQQ.sProcessId) {
            activity = ProcessUtils.getTopActivity();
        } else {
            activity = QBaseActivity.sTopActivity;
            if (activity == null) {
                activity = BaseActivity.sTopActivity;
            }
        }
        if (activity == null || !activity.isFinishing()) {
            return activity;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isInGuildTab(Activity activity) {
        if (activity instanceof SplashActivity) {
            Fragment findFragmentByTag = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
            if (findFragmentByTag instanceof MainFragment) {
                MainFragment mainFragment = (MainFragment) findFragmentByTag;
                return mainFragment.getFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()) != null && mainFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183047j;
            }
            QLog.w(TAG, 1, "splash activity do not has main fragment!");
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isInGuildTab context is=");
            sb5.append(activity == null ? "null" : activity.getClass().getSimpleName());
            QLog.w(TAG, 1, sb5.toString());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void refreshChatPieListView(AppRuntime appRuntime, String str) {
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return;
        }
        IMessageFacade iMessageFacade = (IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "");
        aj ajVar = new aj();
        ajVar.f116523a = new com.tencent.mobileqq.activity.aio.u(str);
        ajVar.f116542t = 10014;
        iMessageFacade.setChangeAndNotify(ajVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void resetTabHostDivider(FrameFragment.c cVar, int i3) {
        View findViewById;
        if (cVar == 0 || !SimpleModeHelper.C() || (findViewById = ((ViewGroup) cVar).findViewById(R.id.f916655s)) == null) {
            return;
        }
        findViewById.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public FrameFragment getMainFragment(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            QLog.w(TAG, 1, "getMainFragment but activity is null");
            return null;
        }
        return (FrameFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public be obtainGuildMainFrame(Context context) {
        if (!(context instanceof SplashActivity)) {
            return null;
        }
        Fragment findFragmentByTag = ((SplashActivity) context).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag instanceof MainFragment) {
            return ((MainFragment) findFragmentByTag).getFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
        }
        QLog.e(TAG, 1, "obtainGuildMainFrame can't find MainFragment!");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isDrawerInit(QBaseActivity qBaseActivity) {
        if (qBaseActivity == null) {
            QLog.w(TAG, 1, "getMainFragment but activity is null");
            return false;
        }
        FrameFragment mainFragment = getMainFragment(qBaseActivity);
        return (mainFragment instanceof MainFragment) && ((MainFragment) mainFragment).Hi();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isGiftMsg(Message message) {
        if (message == null) {
            return false;
        }
        int i3 = message.msgtype;
        if (i3 == -5009 && message.msgData != null) {
            return true;
        }
        if ((i3 != -5008 && i3 != -5017) || message.msgData == null) {
            return false;
        }
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        arkAppMessage.fromBytes(message.msgData);
        return TextUtils.equals("com.tencent.channel.gift", arkAppMessage.appName);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void setConversationTabIntent(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        int i3 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
        intent.setComponent(SplashActivity.getAliasComponent(context));
        intent.setFlags(335544320);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void setGuildTabIntent(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        int i3 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
        intent.setComponent(SplashActivity.getAliasComponent(context));
        intent.setFlags(335544320);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public boolean isInConversationTab() {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity instanceof SplashActivity) {
            return SplashActivity.currentFragment == 1 && ((SplashActivity) baseActivity).getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f214401d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MainFragment f214402e;

        a(ViewGroup viewGroup, MainFragment mainFragment) {
            this.f214401d = viewGroup;
            this.f214402e = mainFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            GuildTempApiImpl.this.mTabShowAnim = null;
            if (QLog.isColorLevel()) {
                QLog.i(GuildTempApiImpl.TAG, 1, "showTab. onAnimationCancel");
            }
            GuildTempApiImpl.this.checkTabState(this.f214401d, this.f214402e.mTabBlurView);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GuildTempApiImpl.this.mTabShowAnim = null;
            if (QLog.isColorLevel()) {
                QLog.i(GuildTempApiImpl.TAG, 1, "showTab. onAnimationEnd");
            }
            GuildTempApiImpl.this.checkTabState(this.f214401d, this.f214402e.mTabBlurView);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f214404d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MainFragment f214405e;

        b(View view, MainFragment mainFragment) {
            this.f214404d = view;
            this.f214405e = mainFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            GuildTempApiImpl.this.mTabHideAnim = null;
            if (QLog.isColorLevel()) {
                QLog.i(GuildTempApiImpl.TAG, 1, "dismissTab. onAnimationCancel");
            }
            GuildTempApiImpl.this.checkTabState(this.f214404d, this.f214405e.mTabBlurView);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GuildTempApiImpl.this.mTabHideAnim = null;
            if (QLog.isColorLevel()) {
                QLog.i(GuildTempApiImpl.TAG, 1, "dismissTab. onAnimationEnd");
            }
            GuildTempApiImpl.this.checkTabState(this.f214404d, this.f214405e.mTabBlurView);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTempApi
    public void startAsyncStepLite(AppInterface appInterface) {
    }
}
