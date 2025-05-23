package com.tencent.mobileqq.guild.mainframe.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import qr1.HashTagJumpParams;
import rr1.a;
import rr1.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMainFrameApi extends QRouteApi {
    public static final String APP_VERSION = "APP_VERSION";
    public static final String GOTO_CONVERSATION_TAB = "GOTO_CONVERSATION_TAB";
    public static final String GOTO_GUILD_TAB = "GOTO_GUILD_TAB";
    public static final String GUILD_TAB_ID = "GUILD_TAB_ID";
    public static final String OPEN_CONVERSATION_TAG = "OPEN_CONVERSATION_TAB";

    void addGestureListener(a aVar);

    void closeAppChannel(QBaseActivity qBaseActivity, b bVar);

    void closeGuildSearchPageIfNeed();

    Intent createConversationTabUrlIntent(@NonNull Context context, @NonNull String str);

    Intent createGotoConversationGuildIntent(@NonNull Context context, @NonNull JumpGuildParam jumpGuildParam);

    void doOpenCreateGuild(Context context, View view, int i3);

    void exitGuildChatFragment(FragmentActivity fragmentActivity, int i3, String str);

    String getAnnouncementFactoryName();

    @Nullable
    Fragment getChatFragment(String str);

    AIOContact getCurrentOpenGuildAIOContact(FrameFragment frameFragment);

    String getDirectFactoryName();

    Class<? extends Frame> getGuildMainFrameClass();

    void gotoChannelDirectly(@NonNull Context context, @NonNull JumpGuildParam jumpGuildParam);

    void gotoConversationGuild(@NonNull Context context, @NonNull JumpGuildParam jumpGuildParam);

    void gotoGuild(Context context, BaseGuildShareParam baseGuildShareParam);

    void gotoGuildStandalone(Context context, @NonNull JumpGuildParam jumpGuildParam);

    void gotoGuildTab(Context context, int i3, Bundle bundle);

    void guildCenterPanelInOrOut(FrameFragment frameFragment, int i3, boolean z16);

    void handleHashTagJump(HashTagJumpParams hashTagJumpParams);

    void handleJumpAction(FrameFragment frameFragment, Bundle bundle);

    void handleReadOnlyJumpChannel(qr1.a aVar);

    boolean isAioFullyOnLeft(FrameFragment frameFragment);

    boolean isAioFullyOnRight(FrameFragment frameFragment);

    boolean isAioFullyOpen();

    boolean isAioFullyOpen(FrameFragment frameFragment);

    boolean isAioTranslationAnimRunning();

    boolean isGuildSearchPageShow(FrameFragment frameFragment);

    boolean isNewDiscoverTab();

    Boolean isSimpleGuildMode();

    boolean isSplashActivityTop();

    boolean isSplitViewState(Context context);

    Frame newGuildMainFrame(FrameFragment frameFragment);

    void notifyGuildFrameVisibleChanged(String str, boolean z16);

    void onGuildTabClick(View view, Context context);

    void onPostThemeChanged(be beVar, int i3);

    void onSplashActivityResume();

    void onTabChanged(FrameFragment frameFragment, boolean z16, IGuildUnreadCntService.b bVar);

    void openTeamSharePage(QBaseActivity qBaseActivity, String str, long j3);

    void removeGestureListener(a aVar);

    void reportCreateGuild(View view, int i3);

    void setCenterPanelInOrOut(FragmentActivity fragmentActivity, int i3, boolean z16);

    void setTabHeight(be beVar, int i3);

    void updateEnableEndPageSwitch(Intent intent);

    void updateLiveChannel(AppRuntime appRuntime, IGProChannelInfo iGProChannelInfo);

    void updateSelectedChannel(QBaseActivity qBaseActivity, String str);
}
