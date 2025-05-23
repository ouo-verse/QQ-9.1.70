package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.aio.data.AIOContact;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildFeatureAdapterApi extends QRouteApi {
    public static final String PARAM_NEED_SHOW_GUILD_ENTRANCE = "PARAM_NEED_SHOW_GUILD_ENTRANCE";

    void addRecentTalkedRecord(boolean z16, String str, String str2);

    ViewGroup buildArkViewContentGroup(Context context, Object obj, t02.a aVar, ViewGroup viewGroup);

    boolean checkShowShareGuildEntrance(Intent intent);

    void clearExpandGuildList();

    void clearRecentUserAvatarLoader();

    void clearSplash(Context context);

    ChatMessage convertToChatMessage(AppRuntime appRuntime, MsgRecord msgRecord);

    <PB extends MessageMicro<PB>> String convertToJson(PB pb5);

    void decodeMixTypeMsg(Message message, IMessageManager iMessageManager);

    void destroyArkViewContainer(Object obj);

    void fillJubaoIntent(Intent intent, String str, int i3, String str2);

    @Nullable
    AIOContact getActiveAIOContact();

    void getArkMsgSummary(Message message);

    int getCONTENTVIEW_MAX_WIDTH_SIZE();

    Class getChooseGuildOptionClass();

    Class getForwardGuildRobotClass();

    Class getForwardSendGuildScheduleClass();

    Class getForwardServerArkOptionClass();

    Class getForwardTroopRobotClass();

    Class getGuildAioNavigateBarManagerClass();

    String getGuildArticleMsgChatFragmentClassName();

    String getGuildChatContextGuildId(Object obj);

    String getGuildChatFragmentClassName();

    int getGuildChatPieScene(Object obj);

    Class getGuildCommentArkMsgOptionClass();

    String getGuildLiveChannelChatFragmentClassName();

    Class getGuildMessageNavigateInfoClass();

    Class<? extends IRichTextAndMsgViaProvider> getGuildMixMsgRichTextAndMsgViaProviderClass();

    Class getGuildNotificationProcessorClass();

    Class getGuildOpenVerifyFragmentClass();

    Object getGuildPieAdapterCallback(ChatMessage chatMessage, Object obj);

    String getGuildTopMsgListChatFragmentClassName();

    Class getGuildVerifyAccountAndOpenH5FragmentClass();

    Object getLiveGuildLiveRoomFragment(Context context);

    Object getMainFragment(Context context);

    Object getNewGuildGiftAppInfo();

    Object getNewGuildGuestMessageProcessorCallback();

    Object getNewGuildLiveChatPieCreator();

    Object getNewGuildMessageManagerCallback();

    Object getNewGuildMobaTeamAppInfo();

    Object getNewGuildOfflineMessageProcessorCallback();

    Object getNewGuildPicAppInfo();

    Object getNewGuildPushMessageProcessorCallback();

    Object getNewGuildRoamMessageEventFlowProcessorCallback();

    Object getNewGuildRoamMessageProcessorCallback();

    Object getNewGuildS2CMessageProcessorCallback();

    Object getNewGuildSystemMessageProcessorCallback();

    Intent getPullSplashActivityAndOpenChannelIntent(Context context, JumpGuildParam jumpGuildParam);

    String getQImei36();

    List<t02.e> getRecentTalkedChannelsInfo(Object obj);

    ArrayList<GuildRecentUser> getRecentUsers(AppRuntime appRuntime);

    void guildAIOMultiActionHelperPullNickName(Object obj, String str, ArrayList<String> arrayList);

    Object initArkViewContainer();

    void invalidateArkViewContainer(Object obj);

    boolean isEnterSendMsg();

    boolean isGuildArticleListUI(Object obj);

    boolean isGuildMsg(AppRuntime appRuntime, MessageRecord messageRecord);

    boolean isGuildTopMsgListUI(Object obj);

    boolean isQrCodeOrAppCode(String str);

    boolean isSplashActivityAlive();

    boolean isSplashActivityTop();

    boolean judgeAdapterIsGuildPieAdapter(Object obj);

    boolean judgeBaseChatPieIsGuildChatPie(Object obj);

    boolean judgeGuildChatContextIsHomePageChannel(Object obj);

    boolean judgeIsGuildArticleChatPie(Object obj);

    boolean judgeIsGuildChatContext(Object obj);

    boolean judgeIsGuildLiveChannelChatPie(Object obj);

    boolean judgeListUiIsGuildListUI(Object obj);

    void launchSplashAndProcessShareJump(Context context, BaseGuildShareParam baseGuildShareParam);

    void loadRecentUserAvatar(Context context, GuildRecentUser guildRecentUser, ImageView imageView, t02.d dVar);

    void openGuildSharePanelForMini(Context context, String str);

    void openGuildWithSplash(Context context, Intent intent);

    void openNormalUrl(Context context, String str);

    void pullSplashActivityAndOpenChannel(Context context, JumpGuildParam jumpGuildParam);

    void reportAioOpenTimeCost(Object obj);

    void showGuildUserCard(Bundle bundle);

    void startForwardActivity(Context context, Intent intent, int i3);

    void startForwardActivityForResult(Activity activity, Intent intent, int i3, int i16, String str);

    void startForwardFriendListActivity(Context context, Intent intent);

    void startForwardTroopListFragment(Context context, Intent intent);

    void startQQGuildForwardGuildListFragment(Activity activity, Intent intent, int i3);

    int transChannelType(String str);

    String transFactoryName(int i3);
}
