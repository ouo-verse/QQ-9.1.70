package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.guild.aio.activity.GuildChatActivityAbility;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.activity.QQGuildAIOSingleTaskTransActivity;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.impl.GuildWebApiImpl;
import com.tencent.mobileqq.guild.chatpie.GuildChatFragment;
import com.tencent.mobileqq.guild.chatpie.pluspanel.GuildGiftAppInfo;
import com.tencent.mobileqq.guild.chatpie.pluspanel.GuildMobaTeamAppInfo;
import com.tencent.mobileqq.guild.chatpie.pluspanel.GuildPicAppInfo;
import com.tencent.mobileqq.guild.feed.GuildUserCardFragment;
import com.tencent.mobileqq.guild.forward.ForwardGuildChooseOption;
import com.tencent.mobileqq.guild.forward.ForwardGuildCommentArgMsgOption;
import com.tencent.mobileqq.guild.forward.ForwardGuildInvitationArkMsgOption;
import com.tencent.mobileqq.guild.forward.ForwardGuildRobotOption;
import com.tencent.mobileqq.guild.forward.ForwardSendGuildScheduleOption;
import com.tencent.mobileqq.guild.forward.ForwardTroopRobotOption;
import com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment;
import com.tencent.mobileqq.guild.forward.utils.GuildForwardUtils;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.data.j;
import com.tencent.mobileqq.guild.message.data.k;
import com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager;
import com.tencent.mobileqq.guild.navigatebar.GuildMessageNavigateInfo;
import com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment;
import com.tencent.mobileqq.guild.open.GuildVerifyAccountAndOpenH5Fragment;
import com.tencent.mobileqq.guild.share.h;
import com.tencent.mobileqq.guild.share.r;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.widget.i;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import t02.c;
import t02.e;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildFeatureAdapterApiImpl implements IGuildFeatureAdapterApi {
    private static final MediaPlayerManager.b DEFAULT_MEDIA_CALLBACK = new a();
    private static final String ENTER_MSG_SWITCH_ID = "102418";
    private static final String TAG = "GuildFeatureAdapterApiImpl";

    private boolean judgeEnterSendMsgFlagByNewLogic() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false);
    }

    private boolean judgeEnterSendMsgFlagByOldLogic() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (from.containsKey(AppConstants.QQSETTING_ENTER_SENDMSG_KEY)) {
            return from.decodeBool(AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false);
        }
        if (((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isFirstLaunchNew()) {
            from.encodeBool(AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false);
            return false;
        }
        BaseApplication baseApplication = BaseApplication.context;
        boolean readValue = SettingCloneUtil.readValue((Context) baseApplication, (String) null, baseApplication.getString(R.string.cyo), AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false);
        from.encodeBool(AppConstants.QQSETTING_ENTER_SENDMSG_KEY, readValue);
        return readValue;
    }

    private void openChannelWithSplashActivity(Context context, Intent intent) {
        JumpGuildParam jumpGuildParam = (JumpGuildParam) intent.getParcelableExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
        intent.removeExtra("fromGuildOpen");
        intent.removeExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
        if (jumpGuildParam != null && !TextUtils.isEmpty(jumpGuildParam.getGuildId()) && !TextUtils.isEmpty(jumpGuildParam.getChannelId())) {
            ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).loadGuildChannelFromSplash(context, jumpGuildParam);
        } else {
            QLog.w(TAG, 1, "openChannelWithSplashActivity: guildId/channelId is empty");
        }
    }

    private void openGuildProcessShareJump(Context context, Intent intent) {
        BaseGuildShareParam baseGuildShareParam = (BaseGuildShareParam) intent.getParcelableExtra("share_original_param");
        if (baseGuildShareParam == null) {
            QLog.e(TAG, 2, "openGuildProcessShareJump: error");
        } else {
            intent.removeExtra("share_original_param");
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuild(context, baseGuildShareParam);
        }
    }

    private t02.e parseRecentTalkedRecord(String str, long j3, QQAppInterface qQAppInterface) {
        IGPSService iGPSService = (IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo != null && channelInfo.getType() == 1) {
            String guildId = channelInfo.getGuildId();
            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
            if (guildInfo == null || !guildInfo.isMember()) {
                return null;
            }
            String avatarUrl = guildInfo.getAvatarUrl(100);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("channelId: %s, guildId: %s, avatarUrl: %s, time: %d", str, guildId, avatarUrl, Long.valueOf(j3)));
            }
            return new e.b().c(str).d(channelInfo.getChannelName()).e(guildId).f(guildInfo.getGuildName()).a(avatarUrl).g(j3).b();
        }
        QLog.w(TAG, 1, "get channelInfo not invalid: " + str);
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void addRecentTalkedRecord(boolean z16, String str, String str2) {
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).addOneRecentTalkedChannel(z16, str2);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public ViewGroup buildArkViewContentGroup(Context context, Object obj, t02.a aVar, ViewGroup viewGroup) {
        if (obj instanceof i) {
            return ((i) obj).d(context, aVar, viewGroup);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean checkShowShareGuildEntrance(Intent intent) {
        return GuildForwardUtils.a(intent);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void clearExpandGuildList() {
        jo1.d.g();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void clearRecentUserAvatarLoader() {
        h.c();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void clearSplash(Context context) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra("openGuildWithSplash", true);
        aliasIntent.setFlags(67174400);
        context.startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public <PB extends MessageMicro<PB>> String convertToJson(PB pb5) {
        return com.tencent.biz.qqstory.utils.g.d(pb5);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void decodeMixTypeMsg(Message message, IMessageManager iMessageManager) {
        MessageForMixedMsg messageForMixedMsg = new MessageForMixedMsg();
        messageForMixedMsg.frienduin = message.frienduin;
        messageForMixedMsg.msgData = message.msgData;
        messageForMixedMsg.extStr = message.extStr;
        messageForMixedMsg.extLong |= 1;
        messageForMixedMsg.parse();
        message.f203106msg = messageForMixedMsg.f203106msg;
        String str = messageForMixedMsg.msg2;
        message.msg2 = str;
        if (str != null && !"".equals(str)) {
            message.emoRecentMsg = new QQText(message.msg2, 3, 16);
            return;
        }
        String str2 = message.f203106msg;
        if (str2 == null || "".equals(str2)) {
            return;
        }
        message.emoRecentMsg = new QQText(message.f203106msg, 3, 16);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void destroyArkViewContainer(Object obj) {
        if (obj instanceof i) {
            ((i) obj).c();
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void fillJubaoIntent(Intent intent, String str, int i3, String str2) {
        if (intent == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgcount", i3);
            jSONObject.put("msgs", str2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        intent.putExtra("chatuin", str);
        intent.putExtra("chattype", 10014);
        intent.putExtra("msgs", jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public AIOContact getActiveAIOContact() {
        return GuildChatActivityAbility.d();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void getArkMsgSummary(Message message) {
        if (message.msgData != null) {
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            arkAppMessage.fromBytes(message.msgData);
            message.f203106msg = arkAppMessage.getSummery();
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public int getCONTENTVIEW_MAX_WIDTH_SIZE() {
        BaseApplication context = BaseApplication.getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158959cc4);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.ccm);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.cco);
        return (((ViewUtils.getScreenWidth() - dimensionPixelSize2) - dimensionPixelSize3) - dimensionPixelSize) - context.getResources().getDimensionPixelSize(R.dimen.cwr);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getChooseGuildOptionClass() {
        return ForwardGuildChooseOption.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getForwardGuildRobotClass() {
        return ForwardGuildRobotOption.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getForwardSendGuildScheduleClass() {
        return ForwardSendGuildScheduleOption.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getForwardServerArkOptionClass() {
        return ForwardGuildInvitationArkMsgOption.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getForwardTroopRobotClass() {
        return ForwardTroopRobotOption.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildAioNavigateBarManagerClass() {
        return GuildAioNavigateBarManager.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String getGuildArticleMsgChatFragmentClassName() {
        return "getGuildArticleMsgChatFragmentClassName";
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String getGuildChatContextGuildId(Object obj) {
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String getGuildChatFragmentClassName() {
        return GuildChatFragment.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public int getGuildChatPieScene(Object obj) {
        return 1;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildCommentArkMsgOptionClass() {
        return ForwardGuildCommentArgMsgOption.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String getGuildLiveChannelChatFragmentClassName() {
        return "getGuildLiveChannelChatFragmentClassName";
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildMessageNavigateInfoClass() {
        return GuildMessageNavigateInfo.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildMixMsgRichTextAndMsgViaProviderClass() {
        return pu1.a.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildNotificationProcessorClass() {
        return com.tencent.mobileqq.guild.notification.a.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildOpenVerifyFragmentClass() {
        return GuildOpenVerifyFragment.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getGuildPieAdapterCallback(ChatMessage chatMessage, Object obj) {
        return DEFAULT_MEDIA_CALLBACK;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String getGuildTopMsgListChatFragmentClassName() {
        return x02.a.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Class getGuildVerifyAccountAndOpenH5FragmentClass() {
        return GuildVerifyAccountAndOpenH5Fragment.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getLiveGuildLiveRoomFragment(Context context) {
        if (context instanceof QQGuildAIOSingleTaskTransActivity) {
            return ((QQGuildAIOSingleTaskTransActivity) context).getFragment();
        }
        if (context instanceof FragmentActivity) {
            return ((FragmentActivity) context).getSupportFragmentManager().findFragmentById(R.id.ve8);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getMainFragment(Context context) {
        if (context instanceof QBaseActivity) {
            return ((QBaseActivity) context).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildGiftAppInfo() {
        return new GuildGiftAppInfo();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildGuestMessageProcessorCallback() {
        return new com.tencent.mobileqq.guild.message.data.a();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildLiveChatPieCreator() {
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildMessageManagerCallback() {
        return new com.tencent.mobileqq.guild.message.data.b();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildMobaTeamAppInfo() {
        return new GuildMobaTeamAppInfo();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildOfflineMessageProcessorCallback() {
        return new com.tencent.mobileqq.guild.message.data.e();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildPicAppInfo() {
        return new GuildPicAppInfo();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildPushMessageProcessorCallback() {
        return new com.tencent.mobileqq.guild.message.data.f();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildRoamMessageEventFlowProcessorCallback() {
        return new com.tencent.mobileqq.guild.message.data.h();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildRoamMessageProcessorCallback() {
        return new com.tencent.mobileqq.guild.message.data.i();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildS2CMessageProcessorCallback() {
        return new j();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object getNewGuildSystemMessageProcessorCallback() {
        return new k();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Intent getPullSplashActivityAndOpenChannelIntent(Context context, JumpGuildParam jumpGuildParam) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        aliasIntent.putExtra("openGuildWithSplash", true);
        aliasIntent.putExtra("openGuildTypeWithSplash", 1);
        aliasIntent.putExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM, (Parcelable) jumpGuildParam);
        aliasIntent.setFlags(67174400);
        if (!(context instanceof Activity)) {
            aliasIntent.addFlags(268435456);
        }
        return aliasIntent;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String getQImei36() {
        return o.c();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public List<t02.e> getRecentTalkedChannelsInfo(Object obj) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached()) {
                return arrayList;
            }
            String recentTalkedChannelsWithTime = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getRecentTalkedChannelsWithTime();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "loaded recent channel records:" + recentTalkedChannelsWithTime);
            }
            for (c.a aVar : new t02.c(recentTalkedChannelsWithTime).b()) {
                t02.e parseRecentTalkedRecord = parseRecentTalkedRecord(aVar.f435234a, aVar.f435235b, (QQAppInterface) obj);
                if (parseRecentTalkedRecord != null) {
                    arrayList.add(parseRecentTalkedRecord);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            QLog.w(TAG, 1, "failed getRecentTalkedChannelsInfo");
            return arrayList;
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public ArrayList<GuildRecentUser> getRecentUsers(AppRuntime appRuntime) {
        return com.tencent.mobileqq.guild.share.i.h(appRuntime);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public Object initArkViewContainer() {
        return new i();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void invalidateArkViewContainer(Object obj) {
        if (obj instanceof i) {
            ((i) obj).g();
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isEnterSendMsg() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(ENTER_MSG_SWITCH_ID, true)) {
            return judgeEnterSendMsgFlagByNewLogic();
        }
        return judgeEnterSendMsgFlagByOldLogic();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isGuildArticleListUI(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isGuildTopMsgListUI(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isQrCodeOrAppCode(String str) {
        return gg1.a.a(str);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isSplashActivityAlive() {
        SplashActivity splashActivity;
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        return (weakReference == null || (splashActivity = weakReference.get()) == null || splashActivity.isFinishing() || splashActivity.isDestroyed()) ? false : true;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isSplashActivityTop() {
        return QBaseActivity.sTopActivity instanceof SplashActivity;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeAdapterIsGuildPieAdapter(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeBaseChatPieIsGuildChatPie(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeGuildChatContextIsHomePageChannel(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeIsGuildArticleChatPie(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeIsGuildChatContext(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeIsGuildLiveChannelChatPie(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean judgeListUiIsGuildListUI(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void launchSplashAndProcessShareJump(Context context, BaseGuildShareParam baseGuildShareParam) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        aliasIntent.putExtra("openGuildWithSplash", true);
        aliasIntent.putExtra("openGuildTypeWithSplash", 2);
        aliasIntent.putExtra("share_original_param", baseGuildShareParam);
        if (baseGuildShareParam.toString().contains("jumpGuildTab=1")) {
            aliasIntent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
        }
        aliasIntent.setFlags(335609856);
        context.startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void loadRecentUserAvatar(Context context, GuildRecentUser guildRecentUser, ImageView imageView, t02.d dVar) {
        h.e(context, guildRecentUser, imageView, dVar);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void openGuildSharePanelForMini(Context context, String str) {
        r.a(context, str);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void openNormalUrl(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "fail to openNormalUrl, url is empty");
        } else {
            GuildWebApiImpl.guildOpenWebUrlOnly(context, str, null, null, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void pullSplashActivityAndOpenChannel(Context context, JumpGuildParam jumpGuildParam) {
        context.startActivity(getPullSplashActivityAndOpenChannelIntent(context, jumpGuildParam));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void showGuildUserCard(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtra(GuildUserCardFragment.H, bundle);
        }
        intent.addFlags(268435456);
        PublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildUserCardFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void startForwardActivity(Context context, Intent intent, int i3) {
        ForwardBaseOption.startForwardActivity(context, intent, i3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void startForwardActivityForResult(Activity activity, Intent intent, int i3, int i16, String str) {
        ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, i3, i16, str);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void startQQGuildForwardGuildListFragment(Activity activity, Intent intent, int i3) {
        QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, GuildSelectorForwardFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public int transChannelType(String str) {
        return g.f235279a.b(str);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public String transFactoryName(int i3) {
        return g.f235279a.a(i3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void openGuildWithSplash(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("openGuildTypeWithSplash", 0);
        intent.removeExtra("openGuildWithSplash");
        intent.removeExtra("openGuildTypeWithSplash");
        if (intExtra == 1) {
            openChannelWithSplashActivity(context, intent);
            return;
        }
        if (intExtra == 2) {
            openGuildProcessShareJump(context, intent);
            return;
        }
        QLog.d(TAG, 2, "openGuildWithSplash: can not handle type[" + intExtra + "]");
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void startForwardFriendListActivity(Context context, Intent intent) {
        QLog.i(TAG, 4, "startForwardFriendListActivity");
        intent.setClass(context, ForwardFriendListActivity.class);
        intent.putExtra("extra_choose_friend", 5);
        intent.putExtra("only_single_selection", false);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void startForwardTroopListFragment(Context context, Intent intent) {
        QLog.i(TAG, 4, "startForwardTroopListFragment");
        intent.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.b.a(context, intent, PublicTransFragmentActivity.class, ForwardTroopListFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public ChatMessage convertToChatMessage(AppRuntime appRuntime, MsgRecord msgRecord) {
        if (appRuntime == null || msgRecord == null) {
            return null;
        }
        return lu1.k.a(appRuntime, msgRecord);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public boolean isGuildMsg(AppRuntime appRuntime, MessageRecord messageRecord) {
        return (appRuntime == null || messageRecord == null || messageRecord.istroop != 10014) ? false : true;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements MediaPlayerManager.b {
        a() {
        }

        private int a(ChatMessage chatMessage) {
            return -1;
        }

        @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
        public boolean A2(XListView xListView, int i3, View view, ChatMessage chatMessage) {
            QLog.d(GuildFeatureAdapterApiImpl.TAG, 1, "[isReady] msgType = " + a(chatMessage));
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
        public boolean L1(XListView xListView, int i3, View view, ChatMessage chatMessage, AudioPlayerBase audioPlayerBase, int i16) {
            QLog.d(GuildFeatureAdapterApiImpl.TAG, 1, "[play] msgType = " + a(chatMessage));
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
        public boolean Y(ChatMessage chatMessage) {
            QLog.d(GuildFeatureAdapterApiImpl.TAG, 1, "[canStop] msgType = " + a(chatMessage));
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
        public void m(XListView xListView, int i3, View view, ChatMessage chatMessage, boolean z16) {
            QLog.d(GuildFeatureAdapterApiImpl.TAG, 1, "[onStop] msgType = " + a(chatMessage));
        }

        @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
        public void l(XListView xListView, int i3, View view, ChatMessage chatMessage, long j3, float f16) {
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void reportAioOpenTimeCost(Object obj) {
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
    public void guildAIOMultiActionHelperPullNickName(Object obj, String str, ArrayList<String> arrayList) {
    }
}
