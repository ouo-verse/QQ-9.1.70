package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildChatApi;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.channel.choose.QQGuildSelectChannelDialogFragment;
import com.tencent.mobileqq.guild.channel.choose.QQGuildSelectChannelFragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateMainDialogFragment;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.channel.manage.QQGuildChannelCreateCategoryFragment;
import com.tencent.mobileqq.guild.channel.manage.QQGuildChannelModifyCategoryFragment;
import com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.manage.GuildClientManageFragment;
import com.tencent.mobileqq.guild.client.titledisplay.GuildClientTitleDisplaySettingFragment;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.discoveryv2.jump.GuildDiscoveryMFJumpHelper;
import com.tencent.mobileqq.guild.emoj.details.GuildEmojiDetailsDialog;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.jump.GuildJumpArkCheck;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.mainframe.standalone.GuildStandaloneDialogAttachFragment;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.detail.QQGuildMediaChannelDetailFragment;
import com.tencent.mobileqq.guild.message.chatpie.GuildMenuDialogFragment;
import com.tencent.mobileqq.guild.message.chatpie.GuildResendDialogFragment;
import com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment;
import com.tencent.mobileqq.guild.profile.profilearchives.fragment.GuildProfileArchivesListFragment;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildUserProfileCardFragment;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.quickshare.GuildQuickShareDialog;
import com.tencent.mobileqq.guild.quickshare.ShareParam;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.robot.components.square.RobotExploreDialogFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildRoleDetailFragment;
import com.tencent.mobileqq.guild.setting.channeldetails.QQGuildChannelDetailFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.GuildFoundAndJoinSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinQuestionAnswerFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinTestFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.SpeakingThresholdManageFragment;
import com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;
import com.tencent.mobileqq.guild.share.app.JoinGuildFromMiniAppDialogFragment;
import com.tencent.mobileqq.guild.share.o;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.guild.JoinGuildHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import eipc.EIPCResult;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import m02.m;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import vh2.bv;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildRouterApiImpl implements IQQGuildRouterApi {
    private static final String CLICK_ARK = "click_ark";
    private static final long ONE_SEC = 1000;
    public static final String TAG = "Guild.jump.QQGuildRouterApiImpl";
    private String mPendingJumpChannelId = null;
    private int mPendingJumpChannelType = 0;
    private int mChannelEnterSource = -1;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements bv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f214409a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f214410b;

        b(Runnable runnable, Context context) {
            this.f214409a = runnable;
            this.f214410b = context;
        }

        @Override // vh2.bv
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            QLog.d(QQGuildRouterApiImpl.TAG, 1, "[joinGuild] getInnerHandlerErrorCode result = $result, errMsg = $errMsg");
            if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
                QLog.d(QQGuildRouterApiImpl.TAG, 1, "[joinGuild] Success");
                this.f214409a.run();
            } else {
                QLog.d(QQGuildRouterApiImpl.TAG, 1, "[joinGuild] not Success. result=$result msg=$errMsg");
                ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).handleJoinGuildError(this.f214410b, i3, str, iGProSecurityResult);
            }
        }
    }

    private static void addEntranceReportItemToReportInfo(Intent intent, String str, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        if (str.startsWith("mqqguild://guild/join")) {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_entrance_pgin_source", "qq_outside");
            return;
        }
        GuildJumpArkCheck.ArkShareScene a16 = GuildJumpArkCheck.a(intent);
        if (a16 == GuildJumpArkCheck.ArkShareScene.QZONE) {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_entrance_pgin_source", "qq_zone");
            return;
        }
        if (a16 == GuildJumpArkCheck.ArkShareScene.C2C) {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_entrance_pgin_source", "aio_c2c");
        } else if (a16 == GuildJumpArkCheck.ArkShareScene.TROOP) {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_entrance_pgin_source", "aio_group");
        } else {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_entrance_pgin_source", "others");
        }
    }

    public static Pair<String, String> getJoinSource(Intent intent, String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("mainSourceId");
        String queryParameter2 = parse.getQueryParameter("subSourceId");
        Pair<String, String> b16 = QQGuildJumpSource.b(246610, TAG);
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = b16.first;
        }
        if (TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = b16.second;
        }
        if (!"share".equals(queryParameter)) {
            return new Pair<>(queryParameter, queryParameter2);
        }
        if (str.startsWith("mqqguild://guild/join")) {
            return new Pair<>(VasWebConstants.REPORT_ORIGIN, "sdk");
        }
        GuildJumpArkCheck.ArkShareScene a16 = GuildJumpArkCheck.a(intent);
        if (a16 == GuildJumpArkCheck.ArkShareScene.QZONE) {
            queryParameter2 = "others";
        } else if (a16 == GuildJumpArkCheck.ArkShareScene.C2C) {
            queryParameter2 = "c2c";
        } else if (a16 == GuildJumpArkCheck.ArkShareScene.TROOP) {
            queryParameter2 = "grp";
        } else {
            if (a16 == GuildJumpArkCheck.ArkShareScene.GUILD) {
                queryParameter2 = WadlProxyConsts.CHANNEL;
            }
            return new Pair<>(queryParameter, queryParameter2);
        }
        queryParameter = "share";
        return new Pair<>(queryParameter, queryParameter2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (r5 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleGuildUrl(Activity activity, String str, Intent intent) {
        if (com.tencent.mobileqq.guild.util.o.d(CLICK_ARK, 1000L)) {
            QLog.d(TAG, 1, "isFastClick, filter shareUrl = " + str);
            return true;
        }
        QLog.i(TAG, 1, "handleGuildUrl with url:" + str);
        new HashMap().put("jump_url", str);
        Activity activity2 = QBaseActivity.sTopActivity;
        if (activity2 == null) {
            activity2 = activity;
        }
        if (!intent.getBooleanExtra(JoinGuildHelper.INTENT_KEY_JUMP_FROM_MINI_APP, false)) {
            activity.overridePendingTransition(0, 0);
            activity.finish();
        }
        activity = activity2;
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.Key.COLUMN_MSG_SENDER_UIN, intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN));
        bundle.putString("friendUin", intent.getStringExtra("friend_uin"));
        bundle.putParcelable("activity_bundle", intent);
        GuildJumpUtil.i(activity, str, bundle);
        com.tencent.mobileqq.guild.mainframe.d.f227410a.b(transferReportSourceInfoFromUrl(str, intent));
        return false;
    }

    private void parseAtInfo(Uri uri, Bundle bundle) {
        bundle.putString("atTinyid", uri.getQueryParameter("atTinyid"));
        bundle.putBoolean("showKeyboard", uri.getBooleanQueryParameter("showKeyboard", false));
    }

    public static GuildAppReportSourceInfo transferReportSourceInfoFromUrl(String str, Intent intent) {
        Uri parse = Uri.parse(str);
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        String queryParameter = parse.getQueryParameter("appChannel");
        String queryParameter2 = parse.getQueryParameter("pginSource");
        String queryParameter3 = parse.getQueryParameter("inviteCode");
        String queryParameter4 = parse.getQueryParameter("from");
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", queryParameter);
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_into_source", queryParameter2);
        guildAppReportSourceInfo.addReportItem("sgrp_channel_invite_code", queryParameter3);
        guildAppReportSourceInfo.addReportItem("sgrp_pgin_source_mode", GuildAppReportSourceInfo.getPginSourceMode(queryParameter4));
        guildAppReportSourceInfo.addReportItem("sgrp_share_type", parse.getQueryParameter("shareType"));
        guildAppReportSourceInfo.addReportItem("sgrp_share_session_id", parse.getQueryParameter("sessionId"));
        addEntranceReportItemToReportInfo(intent, str, guildAppReportSourceInfo);
        return guildAppReportSourceInfo;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void addGuildByAuthSig(Context context, String str, String str2, int i3) {
        Pair<String, String> b16 = QQGuildJumpSource.b(i3, TAG);
        GuildJumpUtil.j(context, str, "", str2, b16.first, b16.second);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void addGuildByParam(Context context, JumpGuildParam jumpGuildParam, String str, Runnable runnable) {
        JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
        jumpParam.a(1);
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(context, jumpGuildParam, jumpParam, str, new b(runnable, context));
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void addGuildByShareUrl(Context context, String str) {
        int i3;
        if (o02.a.c()) {
            i3 = o02.a.b();
        } else {
            i3 = 7;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("appChannel");
        String queryParameter2 = parse.getQueryParameter("pginSource");
        String queryParameter3 = parse.getQueryParameter("inviteCode");
        String queryParameter4 = parse.getQueryParameter("from");
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", queryParameter);
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_into_source", queryParameter2);
        guildAppReportSourceInfo.addReportItem("sgrp_channel_invite_code", queryParameter3);
        String pginSourceMode = GuildAppReportSourceInfo.getPginSourceMode(queryParameter4);
        guildAppReportSourceInfo.addReportItem("sgrp_pgin_source_mode", pginSourceMode);
        guildAppReportSourceInfo.addReportItem("sgrp_stream_entrance_pgin_source", pginSourceMode);
        Bundle bundle = new Bundle();
        bundle.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
        parseAtInfo(parse, bundle);
        o02.a.e(bundle, i3);
        o02.a.f(i3);
        GuildJumpUtil.i(context, str, bundle);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void createBoardChannel(FragmentManager fragmentManager, String str, String str2, long j3) {
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(str, j3, str2);
        createSubChannelInfo.f214824h = 7;
        QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(fragmentManager, "createBoardChannelFragment");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void createLiveChannel(FragmentManager fragmentManager, String str, String str2, long j3) {
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(str, j3, str2);
        createSubChannelInfo.f214824h = 5;
        createSubChannelInfo.f214826m = "\u53d6\u6d88";
        QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(fragmentManager, "createTextChannel");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void createTextChannel(FragmentManager fragmentManager, String str, String str2, String str3, long j3) {
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(str, j3, str3);
        Bundle bundle = new Bundle();
        bundle.putString("extra_key_text_channel_name", str2);
        createSubChannelInfo.a(bundle);
        createSubChannelInfo.f214824h = 1;
        createSubChannelInfo.f214826m = "\u53d6\u6d88";
        QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(fragmentManager, "createTextChannel");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void createVoiceChannel(FragmentManager fragmentManager, String str, String str2, long j3) {
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(str, j3, str2);
        createSubChannelInfo.f214824h = 2;
        createSubChannelInfo.f214826m = "\u53d6\u6d88";
        QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(fragmentManager, "createTextChannel");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void forceFetchGuildInfo(String str, vh2.v vVar) {
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoWithSource(str, 104, vVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public int getChannelEnterSource() {
        QLog.d(TAG, 1, "[getChannelEnterSource] " + this.mChannelEnterSource);
        return this.mChannelEnterSource;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    @Nullable
    public Bundle getExtrasForQQBrowserActivity(String str) {
        if (str == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addParamsForQQBrowserActivity, url: " + str);
        }
        if (!str.contains("qun.qq.com/guild/h5/saturday-party") && !str.contains("qun.qq.com/qqweb/qunpro/share")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("extra_theme_id", R.style.avu);
        return bundle;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public JumpGuildParam.JoinInfoParam getJoinParamFromInAioIntent(Intent intent) {
        Bundle bundle;
        if (intent == null || intent.getExtras() == null || (bundle = intent.getExtras().getBundle(AppConstants.Key.GUILD_EXTRA)) == null) {
            return null;
        }
        return (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public com.tencent.mobileqq.guild.data.u getMediaChannelSelfUserInfo() {
        return com.tencent.mobileqq.guild.media.core.j.c().B();
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public com.tencent.mobileqq.guild.data.u getMediaChannelUserInfo(String str) {
        return com.tencent.mobileqq.guild.media.core.j.c().b0(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public Class getQQGuildSelectChannelFragmentClass() {
        return QQGuildSelectChannelFragment.class;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public GuildAppReportSourceInfo getReportSourceInfoFromInAioIntent(Intent intent) {
        Bundle bundle;
        if (intent == null || intent.getExtras() == null || (bundle = intent.getExtras().getBundle(AppConstants.Key.GUILD_EXTRA)) == null) {
            return null;
        }
        return (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public Intent getScheduleChannelIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam) {
        MsgRecord msgRecord;
        if (launchGuildChatPieParam != null && (msgRecord = launchGuildChatPieParam.H) != null && msgRecord.getMsgType() == -4051) {
            Intent intent = new Intent();
            if (launchGuildChatPieParam.D) {
                intent.putExtra("goto_guildtab_actiontype", GuildMainFrameConstants.f227279w);
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setGuildTabIntent(context, intent);
                intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
                intent.putExtra("forceStartActivity", true);
                intent.putExtra("forceStartActivityTemp", true);
            }
            intent.putExtra("uin", launchGuildChatPieParam.f214355e);
            intent.putExtra("uintype", 10014);
            intent.putExtra("uinname", launchGuildChatPieParam.f214356f);
            intent.putExtra("channel_name", launchGuildChatPieParam.f214356f);
            intent.putExtra("guild_id", launchGuildChatPieParam.f214354d);
            intent.putExtra(AppConstants.Key.KEY_NEED_TO_SHOW_UNREAD_NUM, true);
            intent.putExtra("openGuildAioFrom", launchGuildChatPieParam.E);
            intent.putExtra("openGuildAioDisableReuse", launchGuildChatPieParam.F);
            if (launchGuildChatPieParam.H != null) {
                if (launchGuildChatPieParam.G == null) {
                    launchGuildChatPieParam.G = new Bundle();
                }
                MsgRecord msgRecord2 = launchGuildChatPieParam.H;
                if (msgRecord2.getElements() != null && msgRecord2.getElements().size() > 0) {
                    CalendarElement calendarElement = msgRecord2.getElements().get(0).getCalendarElement();
                    if (calendarElement.getExpireTimeMs() > NetConnInfoCenter.getServerTimeMillis()) {
                        launchGuildChatPieParam.G.putString(WadlProxyConsts.KEY_JUMP_URL, calendarElement.getSchema());
                        launchGuildChatPieParam.G.putInt("schemaType", calendarElement.getSchemaType());
                    }
                }
            }
            Bundle bundle = launchGuildChatPieParam.G;
            if (bundle != null) {
                intent.putExtra(AppConstants.Key.GUILD_EXTRA, bundle);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("openAioWithoutAnimation", launchGuildChatPieParam.f214359m);
            bundle2.putInt("openAioIn", launchGuildChatPieParam.C);
            bundle2.putBoolean("keepOpenPos", launchGuildChatPieParam.f214358i);
            intent.putExtra("goto_guildtab_actionextra", bundle2);
            return intent;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public String getSourceGuildId(Intent intent) {
        String str;
        Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra != null) {
            str = bundleExtra.getString(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean hasGuildInfoCache(String str) {
        if (ch.L(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isChannelExist(String str) {
        if (MobileQQ.sProcessId == 1) {
            if (((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(str) == null) {
                return false;
            }
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("channel_id", str);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "action_to_check_channel_exist", bundle);
        if (callServer == null) {
            return false;
        }
        return callServer.data.getBoolean("result");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isChannelGray(String str) {
        if (MobileQQ.sProcessId == 1) {
            IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(str);
            if (guildInfo == null) {
                return false;
            }
            return guildInfo.isMovePostSection();
        }
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", str);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "action_check_is_guild_gray", bundle);
        if (callServer == null) {
            return false;
        }
        return callServer.data.getBoolean("result");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isGuest(String str) {
        return ch.j0(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isGuildShareUrl(String str) {
        return com.tencent.mobileqq.guild.share.shorturl.a.m(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isGuildShortUrl(String str) {
        return com.tencent.mobileqq.guild.share.shorturl.a.k(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isShowGuildTab() {
        return ca.a();
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean isShowGuildTabCached() {
        return ca.a();
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void jumpDirectMsgAio(Context context, Bundle bundle) {
        ((IGuildChatApi) QRoute.api(IGuildChatApi.class)).openGuildHelper(context);
        GuildDiscoveryMFJumpHelper.b(context, bundle);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void jumpGuildByBusinessType(Context context, String str, String str2, String str3, int i3, Bundle bundle) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str, "");
        jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam("", str2, str3));
        jumpGuildParam.businessType = i3;
        jumpGuildParam.extras.putAll(bundle);
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void jumpGuildFormSearch(String str, String str2, int i3, Bundle bundle) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            Pair<String, String> b16 = QQGuildJumpSource.b(i3, "jumpGuildFormSearch");
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str, "", str2, b16.first, b16.second);
            if (bundle != null) {
                jumpGuildParam.extras.putAll(bundle);
            }
            GuildJumpUtil.n(qBaseActivity, jumpGuildParam);
            return;
        }
        QLog.d(TAG, 1, "[openGuildTab] activity state illegal");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void jumpGuildOnFullStandalone(Context context, JumpGuildParam jumpGuildParam) {
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void onRecallMsg(GuildSpeakParamsInfo guildSpeakParamsInfo, String str, String str2, int i3) {
        GuildSpeakManageGuide.c(guildSpeakParamsInfo, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openChannelSharePanel(@NonNull Activity activity, @NonNull IGProGuildInfo iGProGuildInfo, @NonNull IGProChannelInfo iGProChannelInfo, GuildSharePageSource guildSharePageSource) {
        if (FastClickUtils.isFastDoubleClick("Guild.jump.QQGuildRouterApiImplopenChannelSharePanel")) {
            QLog.w(TAG, 1, "openChannelSharePanel isFastDoubleClick");
        } else {
            new com.tencent.mobileqq.guild.share.m(activity, iGProGuildInfo, iGProChannelInfo, guildSharePageSource).z();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openClientManagePage(Context context, String str, String str2) {
        GuildClientManageFragment.Nh(context, new GuildClientParams().e0(str).l(str2).e(), 2);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openCreateGuildChannel(Context context, AppInterface appInterface, String str, String str2, String str3, long j3) {
        String obj;
        FragmentActivity fragmentActivity = QBaseActivity.sTopActivity;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("openCreateGuildChannel ");
            if (fragmentActivity == null) {
                obj = "null";
            } else {
                obj = fragmentActivity.toString();
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        if (fragmentActivity == null) {
            if (context instanceof FragmentActivity) {
                QLog.i(TAG, 1, "openCreateGuildChannel by context, activity is null");
                fragmentActivity = (FragmentActivity) context;
            } else {
                QLog.w(TAG, 1, "openCreateGuildChannel fail, activity is null");
                return;
            }
        }
        QQGuildSubChannelCreateMainDialogFragment.Eh(new CreateSubChannelInfo(str, j3, str2)).show(fragmentActivity.getSupportFragmentManager(), "QQGuildSubChannelCreateMainDialogFragment");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openCreateGuildChannelByFragmentManager(FragmentManager fragmentManager, String str, String str2, long j3) {
        QQGuildSubChannelCreateMainDialogFragment.Eh(new CreateSubChannelInfo(str, j3, str2)).show(fragmentManager, "QQGuildSubChannelCreateMainDialogFragment");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildChannelCreateCategorySetting(Context context, AppInterface appInterface, String str, int i3) {
        QPublicFragmentActivity.b.f(context, QQGuildChannelCreateCategoryFragment.Jh(str), QPublicFragmentActivity.class, QQGuildChannelCreateCategoryFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildChannelDetailFragment(AppInterface appInterface, Context context, String str, String str2, int i3) {
        QQGuildChannelDetailFragment.Wh(appInterface, context, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildChannelInfoSetting(AppInterface appInterface, Context context, String str, String str2, int i3) {
        if (context == null) {
            QLog.e(TAG, 1, "openChannelInfoSetting but context = null");
        } else {
            ChannelSettingUtils.f(context, new ChannelSettingUtils.Params(str, str2));
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildChannelListSetting(Context context, String str, int i3) {
        GuildCategoryChannelFragment.Uh(context, str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildChannelManage(Context context, String str, int i3) {
        GuildChannelManageFragment.INSTANCE.a(context, str, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildChannelModifyCategorySetting(Context context, AppInterface appInterface, String str, String str2, long j3) {
        QPublicFragmentActivity.b.b(context, QQGuildChannelModifyCategoryFragment.Ih(str, str2, j3), QPublicFragmentActivity.class, QQGuildChannelModifyCategoryFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public Fragment openGuildChatPieMenuDialog(com.tencent.mobileqq.guild.emoj.b bVar, AppRuntime appRuntime, QBaseActivity qBaseActivity, com.tencent.mobileqq.utils.dialogutils.a aVar, ChatMessage chatMessage, wt1.g gVar, com.tencent.mobileqq.guild.emoj.f fVar) {
        if (appRuntime != null && qBaseActivity != null) {
            FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
            GuildMenuDialogFragment guildMenuDialogFragment = new GuildMenuDialogFragment(bVar, appRuntime, aVar, chatMessage);
            guildMenuDialogFragment.Bh(gVar);
            guildMenuDialogFragment.Ch(fVar);
            supportFragmentManager.beginTransaction().add(guildMenuDialogFragment, "menuDialogFragment").commitAllowingStateLoss();
            return guildMenuDialogFragment;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildClientListSettingFragment(Activity activity, @NonNull String str, @NonNull String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_owner", true);
        GuildProfileArchivesListFragment.Jh(activity, bundle, str2, str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildDirectMessageDetailFragment(Context context, String str, String str2, String str3, String str4, int i3, boolean z16) {
        GuildC2CSettingsFragment.INSTANCE.a(context, str, str2, str3, str4, i3, z16);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildEmojiDetailDialog(Activity activity, GuildEmojiDetailsData guildEmojiDetailsData) {
        GuildEmojiDetailsDialog.Lh(activity, guildEmojiDetailsData);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildFoundAndJoinSetting(Context context, String str, boolean z16) {
        QPublicFragmentActivity.b.b(context, GuildFoundAndJoinSettingFragment.Mh(str, z16), QPublicFragmentActivity.class, GuildFoundAndJoinSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildInTab(Context context, String str, String str2, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        GuildJumpUtil.s(context, str, str2, guildAppReportSourceInfo);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildInfoSetting(Context context, IGProGuildInfo iGProGuildInfo, int i3, int i16) {
        QPublicFragmentActivity.b.b(context, QQGuildManageFragment.jj(iGProGuildInfo, i3, i16), QPublicFragmentActivity.class, QQGuildManageFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildJoinQuestionAnswer(Context context, String str, GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion, int i3) {
        QPublicFragmentActivity.b.f(context, GuildJoinQuestionAnswerFragment.Oh(str, gWGProJoinGuildWordQuestion), QPublicFragmentActivity.class, GuildJoinQuestionAnswerFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildJoinSetting(Context context, String str) {
        QPublicFragmentActivity.b.b(context, GuildJoinSettingFragment.Nh(str), QPublicFragmentActivity.class, GuildJoinSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildJoinTest(Context context, String str, GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion, int i3) {
        QPublicFragmentActivity.b.f(context, GuildJoinTestFragment.Sh(str, gWGProJoinGuildChoiceQuestion), QPublicFragmentActivity.class, GuildJoinTestFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildMediaChannelDetailFragment(AppInterface appInterface, Context context, String str, String str2, int i3) {
        QQGuildMediaChannelDetailFragment.INSTANCE.a(appInterface, context, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildMediaThirdAppProfileCard(Activity activity, String str, String str2, String str3) {
        GuildMediaUtils.o(activity, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildProfile(Context context, String str, String str2, int i3) {
        ch.M0(context, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildProfileDialog(Activity activity, GuildProfileData guildProfileData) {
        GuildProfileCard.Lh(activity, guildProfileData);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildQuickShareDialog(FragmentManager fragmentManager, ShareParam shareParam) {
        GuildQuickShareDialog.INSTANCE.a(fragmentManager, shareParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildThirdAppSetting(Context context, String str) {
        GuildClientTitleDisplaySettingFragment.Mh(context, str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openGuildUserProfile(Context context, String str, String str2, int i3, int i16) {
        GuildUserProfileCardFragment.rh(context, new GuildProfileData(str, null, str2, i3, i16));
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openJoinGuildDialogFromMiniApp(GuildMiniAppShareData guildMiniAppShareData, IQQGuildRouterApi.MiniAppJoinGuildDialogCallback miniAppJoinGuildDialogCallback) {
        String obj;
        if (QLog.isColorLevel()) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("openJoinGuildDialogFromMiniApp ");
            if (qBaseActivity == null) {
                obj = "null";
            } else {
                obj = qBaseActivity.toString();
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        JoinGuildFromMiniAppDialogFragment.Eh(guildMiniAppShareData, miniAppJoinGuildDialogCallback).show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "GuildJoinMiniAppChannelDialogFragment");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openMuteAllSetting(Activity activity, String str) {
        QQGuildMuteSettingFragment.ki(activity, str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openMuteUserSetting(Activity activity, String str, String str2, String str3, int i3) {
        QQGuildMuteSettingFragment.li(activity, str, str2, str3, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openPrivateLetterThresholdManageFragment(Context context, String str) {
        SpeakingThresholdManageFragment.INSTANCE.a(context, str, true);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openQQGuildRoleGroupDetailFragment(String str, int i3, String str2, int i16) {
        GuildRoleDetailFragment.Di(str, i3, str2, i16);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public Fragment openQQGuildSelectChannelDialogFragment(FragmentActivity fragmentActivity, @NonNull String str, vy1.a aVar) {
        if (fragmentActivity == null) {
            return null;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        QQGuildSelectChannelDialogFragment qQGuildSelectChannelDialogFragment = new QQGuildSelectChannelDialogFragment(str);
        qQGuildSelectChannelDialogFragment.th(aVar);
        qQGuildSelectChannelDialogFragment.show(supportFragmentManager, "QQGuildSelectChannelDialogFragment");
        return qQGuildSelectChannelDialogFragment;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openResendDialog(FragmentActivity fragmentActivity, String str, View.OnClickListener onClickListener) {
        GuildResendDialogFragment guildResendDialogFragment = new GuildResendDialogFragment();
        guildResendDialogFragment.th(onClickListener);
        guildResendDialogFragment.uh(str);
        guildResendDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "menuDialogFragment");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openRobotCommonGuildFragment(Activity activity, String str, String str2, String str3, String str4, int i3, int i16) {
        sx1.f.l(activity, str, str2, str3, str4, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openRobotExplorationDialog(FragmentActivity fragmentActivity, String str) {
        new RobotExploreDialogFragment(str).show(fragmentActivity.getSupportFragmentManager(), "RobotExploreDialogFragment");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openRobotList(Activity activity, String str) {
        ch.O0(activity, str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openRobotListAndOpenRobotProfileByRobotUin(Activity activity, String str, String str2) {
        ch.P0(activity, str, new ArrayList(), str2);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openRobotProfileCard(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z16) {
        RobotInfoFragment.wh((FragmentActivity) activity, str2, str, str3, str4, str5, z16, 0);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSingleMemberExcludeSelfSelector(Activity activity, AppInterface appInterface, String str, String str2, int i3) {
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, HardCodeUtil.qqStr(R.string.e4_), 7, 8).setSubChannelId(str2).setActivityRequestCode(i3).setExcludeList(new ArrayList(Collections.singletonList(((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId()))));
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSingleMemberSelector(Activity activity, AppInterface appInterface, String str, String str2, int i3) {
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, "\u9009\u62e9\u8d60\u9001\u5bf9\u8c61", 7, 8).setSubChannelId(str2).setActivityRequestCode(i3));
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSingleMemberSelectorForAudioLiveOnline(QBaseFragment qBaseFragment, String str, String str2, List<RoleGroupUserUIData> list, int i3) {
        GuildCommonViewMemberFragment.mi(qBaseFragment, new GuildRoleMemberParamData(str, "\u9009\u62e9\u8d60\u9001\u5bf9\u8c61", 7, 17).setSubChannelId(str2).setSelectedUIList(list).setActivityRequestCode(i3));
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSpeakRuleManageSetting(Context context, String str) {
        QPublicFragmentActivity.b.b(context, GuildSpeakRuleSettingFragment.Xh(str), QPublicFragmentActivity.class, GuildSpeakRuleManageFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSpeakRuleSetting(Context context, String str) {
        QPublicFragmentActivity.b.b(context, GuildSpeakRuleSettingFragment.Xh(str), QPublicFragmentActivity.class, GuildSpeakRuleSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSpeakingThresholdManageFragment(Context context, String str) {
        SpeakingThresholdManageFragment.INSTANCE.a(context, str, false);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openStandaloneFacadeDialog(Context context, String str, String str2) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str, "");
        jumpGuildParam.setSourceChannelId(str2);
        GuildStandaloneDialogAttachFragment.qh(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void savePendingJumpChannel(String str, int i3) {
        this.mPendingJumpChannelId = str;
        this.mPendingJumpChannelType = i3;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void setChannelEnterSource(int i3) {
        QLog.d(TAG, 1, "[setChannelEnterSource] " + i3);
        this.mChannelEnterSource = i3;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void setGuildPginSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QBaseActivity splashActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity();
        if (str.contains("jumpGuildTab=1") && splashActivity == null) {
            com.tencent.mobileqq.guild.report.b.g("growth_qq_push", TAG);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void setShowGuildTab(boolean z16) {
        bx.x(z16);
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).notifyUI(8, true, null);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean shouldInterceptQQBrowserDelegationActivity(Activity activity, String str, Intent intent) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            str2 = Uri.parse(str).getQueryParameter("url");
        } catch (NullPointerException | UnsupportedOperationException e16) {
            QLog.w(TAG, 1, "getShareUrl error url:" + str, e16);
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                str2 = URLDecoder.decode(str2);
            } catch (Exception e17) {
                QLog.e(TAG, 1, "decodeUrl error url: " + str, e17);
            }
            if (com.tencent.mobileqq.guild.share.shorturl.a.m(str2)) {
                QLog.i(TAG, 1, "handle qzone jump url:" + str);
                handleGuildUrl(activity, str2, intent);
                return true;
            }
        }
        if (!com.tencent.mobileqq.guild.share.shorturl.a.m(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("_wv=1");
        if (lastIndexOf > 0) {
            QLog.i(TAG, 1, "handle qzone jump url:" + str);
            str = str.substring(0, lastIndexOf - 1);
        }
        handleGuildUrl(activity, str, intent);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public boolean showNavigateTitle(String str) {
        return GuildOpenRecordManager.g(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void showSharePicActionSheet(Activity activity, Bitmap bitmap, String str, GuildSharePageSource guildSharePageSource, String str2, String str3, final IQQGuildRouterApi.OnGuildPicShareFinish onGuildPicShareFinish) {
        m.b bVar;
        if (onGuildPicShareFinish == null) {
            bVar = null;
        } else {
            bVar = new m.b() { // from class: com.tencent.mobileqq.guild.api.impl.ab
                @Override // m02.m.b
                public final void onFinished(int i3) {
                    IQQGuildRouterApi.OnGuildPicShareFinish.this.onFinished(i3);
                }
            };
        }
        new m02.m(activity, bVar).K(bitmap, str, guildSharePageSource, str2, str3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public Pair<String, Integer> takePendingJumpChannel() {
        String str = this.mPendingJumpChannelId;
        if (str == null) {
            return null;
        }
        Pair<String, Integer> pair = new Pair<>(str, Integer.valueOf(this.mPendingJumpChannelType));
        this.mPendingJumpChannelId = null;
        this.mPendingJumpChannelType = 0;
        return pair;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public int tryGetJumpChannelStatusCode(QPublicBaseFragment qPublicBaseFragment) {
        if (qPublicBaseFragment instanceof QQGuildBaseLiveRoomFragment) {
            return ((QQGuildBaseLiveRoomFragment) qPublicBaseFragment).tryGetJumpChannelStatusCode();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void updateGuildTabStatus() {
        ca.b();
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openRobotList(Activity activity, String str, ArrayList<String> arrayList) {
        ch.P0(activity, str, arrayList, "");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openStandaloneFacadeDialog(Context context, String str, String str2, JumpGuildParam.JoinInfoParam joinInfoParam, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2, joinInfoParam);
        jumpGuildParam.setSourceChannelId(str2);
        GuildStandaloneDialogAttachFragment.qh(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openChannelSharePanel(Activity activity, GuildMiniAppShareData guildMiniAppShareData) {
        if (FastClickUtils.isFastDoubleClick("Guild.jump.QQGuildRouterApiImplopenChannelSharePanel_mini")) {
            QLog.w(TAG, 1, "openChannelSharePanel_mini isFastDoubleClick");
        } else {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).openGuildSharePanelForMini(activity, new Gson().toJson(guildMiniAppShareData));
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openSingleMemberSelector(Activity activity, AppInterface appInterface, String str, String str2, int i3, ts.a aVar, ActivityResultCallback<ActivityResult> activityResultCallback) {
        GuildCommonViewMemberFragment.li(activity, new GuildRoleMemberParamData(str, "\u9009\u62e9\u8d60\u9001\u5bf9\u8c61", 7, 8).setSubChannelId(str2).setActivityRequestCode(i3), aVar, activityResultCallback);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openStandaloneFacadeDialog(Context context, String str, String str2, JumpGuildParam.JoinInfoParam joinInfoParam, GuildAppReportSourceInfo guildAppReportSourceInfo, String str3) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2, joinInfoParam);
        jumpGuildParam.setSourceChannelId(str2);
        jumpGuildParam.getExtras().putString("EXTRA_KEY_FROM", str3);
        GuildStandaloneDialogAttachFragment.qh(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi
    public void openChannelSharePanel(Activity activity, GuildMiniAppShareData guildMiniAppShareData, ActionSheet.OnDismissListener onDismissListener) {
        if (FastClickUtils.isFastDoubleClick("Guild.jump.QQGuildRouterApiImplopenChannelSharePanel_mini_dismiss")) {
            QLog.w(TAG, 1, "openChannelSharePanel_mini_dismiss isFastDoubleClick");
            return;
        }
        com.tencent.mobileqq.guild.share.o oVar = new com.tencent.mobileqq.guild.share.o(activity, guildMiniAppShareData);
        oVar.h(new a(onDismissListener));
        oVar.j();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements o.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionSheet.OnDismissListener f214407a;

        a(ActionSheet.OnDismissListener onDismissListener) {
            this.f214407a = onDismissListener;
        }

        @Override // com.tencent.mobileqq.guild.share.o.a
        public void b() {
            ActionSheet.OnDismissListener onDismissListener = this.f214407a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // com.tencent.mobileqq.guild.share.o.a
        public void a() {
        }
    }
}
