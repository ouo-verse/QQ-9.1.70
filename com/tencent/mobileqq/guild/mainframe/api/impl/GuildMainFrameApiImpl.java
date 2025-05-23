package com.tencent.mobileqq.guild.mainframe.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame;
import com.tencent.mobileqq.guild.mainframe.GuildMainFragment;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.manager.PanelState;
import com.tencent.mobileqq.guild.mainframe.s;
import com.tencent.mobileqq.guild.mainframe.util.GuildHashTagJumpUtils;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.mainframe.util.h;
import com.tencent.mobileqq.guild.mainframe.util.i;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.report.d;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import dq1.k;
import java.util.HashMap;
import mqq.app.AppRuntime;
import o02.c;
import qr1.HashTagJumpParams;
import rr1.a;
import rr1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMainFrameApiImpl implements IGuildMainFrameApi {
    private static final String TAG = "Guild.MF.GuildMainFrameApiImpl";

    private s getGuildMainFrame(FrameFragment frameFragment) {
        return (s) frameFragment.getFrame(getGuildMainFrameClass());
    }

    private boolean isRealNeedOpenConversationTab(JumpGuildParam jumpGuildParam) {
        IGProChannelInfo B;
        if (!TextUtils.isEmpty(jumpGuildParam.getChannelId()) && (B = ch.B(jumpGuildParam.getChannelId())) != null) {
            int type = B.getType();
            QLog.d(TAG, 1, "isRealNeedOpenConversationTab channelType: " + type);
            if (type == 2 || type == 5 || type == 11) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void addGestureListener(a aVar) {
        GuildMainFrameManager.a(aVar);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void closeAppChannel(QBaseActivity qBaseActivity, b bVar) {
        ((QQGuildHandler) ((AppInterface) qBaseActivity.getAppRuntime()).getBusinessHandler(QQGuildHandler.class.getName())).K2(bVar);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void closeGuildSearchPageIfNeed() {
        GuildMainFrameManager.b();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public Intent createConversationTabUrlIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent();
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setConversationTabIntent(context, intent);
        intent.putExtra(IGuildMainFrameApi.GOTO_CONVERSATION_TAB, true);
        intent.putExtra("ConversationTabUrlJump", str);
        QLog.d(TAG, 1, "createConversationTabUrlIntent ", str);
        return intent;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public Intent createGotoConversationGuildIntent(@NonNull Context context, @NonNull JumpGuildParam jumpGuildParam) {
        Intent intent = new Intent();
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setConversationTabIntent(context, intent);
        intent.putExtra(IGuildMainFrameApi.GOTO_CONVERSATION_TAB, true);
        intent.putExtra(IGuildMainFrameApi.OPEN_CONVERSATION_TAG, isRealNeedOpenConversationTab(jumpGuildParam));
        intent.putExtra(jumpGuildParam.getClass().getCanonicalName(), (Parcelable) jumpGuildParam);
        String str = AppSetting.f99551k;
        intent.putExtra(IGuildMainFrameApi.APP_VERSION, str);
        QLog.d(TAG, 1, "createGotoConversationGuildIntent ", str, " target", jumpGuildParam);
        return intent;
    }

    public HashMap<String, Object> createGuildParams(View view, int i3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (i3 == 2) {
            hashMap.put("dt_pgid", "pg_sgrp_discover_scene");
        } else {
            hashMap.put("dt_pgid", "pg_bas_msglist");
        }
        hashMap.put("dt_eid", "em_sgrp_create_new_channel");
        hashMap.put("eid", "em_sgrp_create_new_channel");
        return hashMap;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void doOpenCreateGuild(Context context, View view, int i3) {
        if (FastClickUtils.isFastDoubleClick(TAG)) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            g.c(1, R.string.f1510816q);
        } else {
            GuildCreateFragment.ei(context);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void exitGuildChatFragment(FragmentActivity fragmentActivity, int i3, String str) {
        if (fragmentActivity == null) {
            return;
        }
        int transChannelType = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transChannelType(str);
        QLog.i(TAG, 1, "exitGuildChatPie containerType: " + i3 + " channelType:" + transChannelType);
        if (transChannelType == 1 || transChannelType == 3 || transChannelType == 7 || transChannelType == 8 || transChannelType == 9) {
            if (i3 == ContainerType.MF_TYPE.ordinal()) {
                ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).setCenterPanelInOrOut(fragmentActivity, 2, true);
                GuildCenterPanelController f16 = GuildMainFrameManager.f();
                if (f16 != null) {
                    f16.r();
                    return;
                }
                return;
            }
            if (i3 == ContainerType.STAND_TYPE.ordinal() && !((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).isSplashActivity(fragmentActivity)) {
                fragmentActivity.finish();
            } else if (GuildSplitViewUtils.f235370a.n(fragmentActivity)) {
                fragmentActivity.onBackPressed();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public String getAnnouncementFactoryName() {
        return com.tencent.mobileqq.guild.main.announcement.detail.aio.a.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    @Nullable
    public Fragment getChatFragment(String str) {
        us.a aVar = com.tencent.mobileqq.guild.mainframe.centerpanel.b.INSTANCE.a().get();
        if (aVar == null) {
            Logger.g(4, TAG, "getChatFragment(src=" + str + ") is null");
            return null;
        }
        Fragment h16 = aVar.h();
        if (h16 == null) {
            QLog.i(TAG, 1, "getChatFragment(src=" + str + ") from provider is null");
            return null;
        }
        QLog.d(TAG, 4, "getChatFragment(src=" + str + ") from provider is " + h16);
        return h16;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public AIOContact getCurrentOpenGuildAIOContact(FrameFragment frameFragment) {
        GuildCenterPanelController f16;
        if (frameFragment == null || (f16 = GuildMainFrameManager.f()) == null) {
            return null;
        }
        return f16.v();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public String getDirectFactoryName() {
        return com.tencent.qqguild.directmessage.aio.a.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public Class<? extends Frame> getGuildMainFrameClass() {
        return GuildFragmentDelegateFrame.class;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void gotoChannelDirectly(@NonNull Context context, @NonNull JumpGuildParam jumpGuildParam) {
        k.b(jumpGuildParam.guildId, jumpGuildParam.getChannelId(), jumpGuildParam.extras).jump(context);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void gotoConversationGuild(@NonNull Context context, @NonNull JumpGuildParam jumpGuildParam) {
        Intent createGotoConversationGuildIntent = createGotoConversationGuildIntent(context, jumpGuildParam);
        context.startActivity(createGotoConversationGuildIntent);
        GuildJumpDebugUtils.a(TAG, "gotoConversationGuild intent = ", createGotoConversationGuildIntent);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void gotoGuild(Context context, BaseGuildShareParam baseGuildShareParam) {
        GuildJumpUtil.m(context, baseGuildShareParam);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void gotoGuildTab(Context context, int i3, Bundle bundle) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("goto_guildtab_actiontype", i3);
        intent.putExtra("goto_guildtab_actionextra", bundle);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setGuildTabIntent(context, intent);
        intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void guildCenterPanelInOrOut(FrameFragment frameFragment, int i3, boolean z16) {
        s guildMainFrame;
        if (frameFragment != null && (guildMainFrame = getGuildMainFrame(frameFragment)) != null) {
            guildMainFrame.guildCenterPanelInOrOut(i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void handleHashTagJump(HashTagJumpParams hashTagJumpParams) {
        GuildHashTagJumpUtils.m(hashTagJumpParams);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void handleJumpAction(FrameFragment frameFragment, Bundle bundle) {
        if (frameFragment != null && bundle != null) {
            s guildMainFrame = getGuildMainFrame(frameFragment);
            if (guildMainFrame != null) {
                GuildJumpDebugUtils.a("Guild.jump.GuildMainFrameApiImpl", "jumpTo GuildMainFrame extra = ", bundle);
                guildMainFrame.handleJumpAction(bundle);
            } else {
                QLog.e("Guild.jump.GuildMainFrameApiImpl", 1, "handleJumpAction guildMainFrame is null");
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void handleReadOnlyJumpChannel(qr1.a aVar) {
        h.a(aVar);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isAioFullyOnLeft(FrameFragment frameFragment) {
        if (GuildMainFrameManager.g() == PanelState.THIRD_PANEL) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isAioFullyOnRight(FrameFragment frameFragment) {
        if (GuildMainFrameManager.g() == PanelState.MAIN_FRAME) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isAioFullyOpen(FrameFragment frameFragment) {
        return GuildMainFrameManager.g() == PanelState.AIO_SHOWING;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isAioTranslationAnimRunning() {
        return GuildMainFrameManager.i();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isGuildSearchPageShow(FrameFragment frameFragment) {
        return GuildMainFrameManager.h();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isNewDiscoverTab() {
        return GuildDiscoverABTestHelper.B();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public Boolean isSimpleGuildMode() {
        if (!at.c()) {
            QLog.i(TAG, 1, "isSimpleGuildMode sdkNotReady return false");
            return Boolean.FALSE;
        }
        return Boolean.valueOf(d12.a.c());
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isSplashActivityTop() {
        return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isSplashActivityTop();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isSplitViewState(Context context) {
        return QQGuildUIUtil.A(context);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public Frame newGuildMainFrame(FrameFragment frameFragment) {
        return new GuildFragmentDelegateFrame(frameFragment, new Bundle());
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void notifyGuildFrameVisibleChanged(String str, boolean z16) {
        be obtainGuildMainFrame = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame();
        if (!(obtainGuildMainFrame instanceof s)) {
            QLog.e(TAG, 1, "notifyGuildFrameVisibleChanged[" + str + "," + z16 + "] can't find guildMainFrame!");
            return;
        }
        s sVar = (s) obtainGuildMainFrame;
        if (QQGuildUIUtil.x(obtainGuildMainFrame.getActivity())) {
            QLog.i(TAG, 1, str + ", " + z16 + ", but isInMagicWindow, force show.");
            sVar.changeGuildFacadeVisible("mainFrame isInMagicWindow", true);
            return;
        }
        sVar.changeGuildFacadeVisible(str, z16);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void onGuildTabClick(View view, Context context) {
        if (!(context instanceof QBaseActivity)) {
            QLog.e(TAG, 1, "error context" + context);
            return;
        }
        if (i.d()) {
            i.e();
            return;
        }
        o02.b.c(13);
        be obtainGuildMainFrame = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame(context);
        if (obtainGuildMainFrame instanceof s) {
            ((s) obtainGuildMainFrame).onGuildTabClick(view);
        } else {
            c.b(GuildMainFragment.Ih());
        }
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            return;
        }
        GuildDiscoverABTestHelper.J();
        d.d("onGuildTabClick");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void onPostThemeChanged(be beVar, int i3) {
        if (beVar instanceof s) {
            ((s) beVar).onPostThemeChanged(i3);
        }
        ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).onThemeChanged();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void onTabChanged(FrameFragment frameFragment, boolean z16, IGuildUnreadCntService.b bVar) {
        s guildMainFrame;
        QLog.d(TAG, 4, "onTabChanged guildTab:" + z16 + " tabUnreadCntInfo:" + bVar);
        if (frameFragment == null || (guildMainFrame = getGuildMainFrame(frameFragment)) == null) {
            return;
        }
        guildMainFrame.onTabChanged(z16, bVar);
        ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).onTabChanged(z16);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void openTeamSharePage(QBaseActivity qBaseActivity, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "guildId: " + str + ", teamId: " + j3);
        }
        if (!ch.o(qBaseActivity, str)) {
            QQToast.makeText(qBaseActivity.getApplicationContext(), 1, "\u6682\u65e0\u6587\u5b57\u5b50\u9891\u9053\u53d1\u8a00\u6743\u9650\u54e6", 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("is_multi_selection", false);
        intent.putExtra("open_single_guild_id", str);
        intent.putExtra("only_single_selection", false);
        intent.putExtra("moba_teamid", j3);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).buildTeamShareForwardIntent(intent, qBaseActivity);
        QPublicFragmentActivity.startForResult(qBaseActivity, intent, (Class<? extends QPublicBaseFragment>) ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getGuildForwardListFragmentClass(), -1);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void removeGestureListener(a aVar) {
        GuildMainFrameManager.l(aVar);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void reportCreateGuild(View view, int i3) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_create_new_channel");
        VideoReport.reportEvent("imp", view, createGuildParams(view, i3));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void setCenterPanelInOrOut(FragmentActivity fragmentActivity, int i3, boolean z16) {
        s p16 = GuildMainFrameUtils.p(fragmentActivity);
        if (p16 != null) {
            p16.guildCenterPanelInOrOut(i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void setTabHeight(be beVar, int i3) {
        if (beVar instanceof s) {
            ((s) beVar).setTabHeight(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void updateEnableEndPageSwitch(Intent intent) {
        GuildMainFrameManager.m(intent);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void updateLiveChannel(AppRuntime appRuntime, IGProChannelInfo iGProChannelInfo) {
        ((QQGuildHandler) ((AppInterface) appRuntime).getBusinessHandler(QQGuildHandler.class.getName())).f3(iGProChannelInfo);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void updateSelectedChannel(QBaseActivity qBaseActivity, String str) {
        ((QQGuildHandler) ((AppInterface) qBaseActivity.getAppRuntime()).getBusinessHandler(QQGuildHandler.class.getName())).g3(str);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public boolean isAioFullyOpen() {
        return GuildMainFrameManager.g() == PanelState.AIO_SHOWING;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void onSplashActivityResume() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
    public void gotoGuildStandalone(Context context, @NonNull JumpGuildParam jumpGuildParam) {
    }
}
