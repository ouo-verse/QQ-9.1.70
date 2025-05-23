package com.tencent.mobileqq.guild.api.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.base.GuildBlankActivity;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.media.GuildMediaChannelFragment;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.QQToastUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class LaunchGuildChatPieApiImpl implements ILaunchGuildChatPieApi {
    private static final int MAX_GET_MAINFRAME_TRY_COUNT = 10;
    private static final String TAG = "Guild.jump.LaunchGuildChatPieApiImpl";

    private static void configMediaAioIntent(Intent intent, String str, IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        intent.putExtra("goto_guildtab_actiontype", GuildMainFrameConstants.f227276t);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        String channelUin = iGProChannelInfo.getChannelUin();
        String channelName = iGProChannelInfo.getChannelName();
        intent.putExtra("uin", channelUin);
        intent.putExtra("uintype", 10014);
        intent.putExtra("uinname", str);
        intent.putExtra("channel_name", channelName);
        intent.putExtra("guild_id", iGProChannelInfo.getGuildId());
        intent.putExtra("channel_type", 2);
        intent.putExtra(AppConstants.Key.GUILD_EXTRA, bundle);
        if (bundle != null) {
            bundle.putInt(FlingConstant.FLING_ACTION_KEY, 0);
            intent.putExtras(bundle);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x016d, code lost:
    
        if (r13.isDestroyed() == false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean enterMediaChannel(Context context, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        int i3;
        String str;
        int i16;
        Intent intent;
        if (!MediaChannelUtils.M()) {
            QLog.e(TAG, 1, "requestMediaChannelAVFocus failed.");
            return false;
        }
        if (ch.M(iGProGuildInfo.getGuildID()) == null) {
            QLog.e(TAG, 1, "launchMediaChannel: sdk guild info is null guildId[" + iGProGuildInfo.getGuildID() + "]");
            return false;
        }
        if (ch.C(ch.l(), iGProGuildInfo.getGuildID(), iGProChannelInfo.getChannelUin()) == null) {
            QLog.e(TAG, 1, "launchMediaChannel: sdk channel info is null channelId[" + iGProChannelInfo.getChannelUin() + "]");
            return false;
        }
        com.tencent.mobileqq.guild.media.core.data.j c16 = com.tencent.mobileqq.guild.media.core.data.j.c(iGProGuildInfo.getGuildID(), iGProChannelInfo.getChannelUin());
        if (bundle != null) {
            i3 = bundle.getInt("openGuildAioFrom", 0);
            GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
            if (guildAppReportSourceInfo != null) {
                str = guildAppReportSourceInfo.getReportInfoMap().get("sgrp_stream_pgin_source_name");
                QLog.d(TAG, 1, "enterMediaChannel joinSourceType " + str);
                String guildId = iGProChannelInfo.getGuildId();
                String channelUin = iGProChannelInfo.getChannelUin();
                if (i3 != 10) {
                    i16 = 3;
                } else {
                    i16 = 1;
                }
                com.tencent.mobileqq.guild.media.core.q qVar = new com.tencent.mobileqq.guild.media.core.q(guildId, channelUin, i16, c16);
                if (str == null) {
                    str = "";
                }
                qVar.m(str);
                if (bundle != null) {
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(iGProChannelInfo.getGuildId(), "", (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM));
                    jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, bundle.getInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 0));
                    qVar.l(jumpGuildParam);
                }
                com.tencent.mobileqq.guild.media.core.j.a().c(qVar, new com.tencent.mobileqq.guild.media.core.b() { // from class: com.tencent.mobileqq.guild.api.impl.x
                    @Override // com.tencent.mobileqq.guild.media.core.b
                    public final void a(boolean z16, IGProSecurityResult iGProSecurityResult) {
                        LaunchGuildChatPieApiImpl.lambda$enterMediaChannel$1(z16, iGProSecurityResult);
                    }
                });
                com.tencent.mobileqq.guild.media.core.j.a().e0(bundle);
                GuildFloatWindowUtils.r();
                QLog.i(TAG, 1, "[launchMediaChannel] guildId: " + iGProGuildInfo.getGuildID() + ", channelId: " + iGProChannelInfo.getChannelUin());
                intent = new Intent();
                intent.putExtra("public_fragment_window_feature", 1);
                intent.addFlags(335544320);
                intent.putExtra("extra_guild_guild_info", iGProGuildInfo);
                intent.putExtra("extra_guild_channel_info", iGProChannelInfo);
                intent.putExtra("ARG_KEY", qVar.getKey());
                configMediaAioIntent(intent, iGProGuildInfo.getGuildName(), iGProChannelInfo, bundle);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (!activity.isFinishing()) {
                    }
                }
                context = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity();
                if (!QQGuildUIUtil.A(context) && !qVar.getSourceType().equals("functional_qq_little_world_feed")) {
                    if (context != null) {
                        Activity activity2 = (Activity) context;
                        if (!activity2.isFinishing() && !activity2.isDestroyed()) {
                            com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().e(false).c(R.anim.f155071vn, R.anim.f155066i1, R.anim.f155071vn, R.anim.f155066i1).g(false).h(LaunchMode.singleTop);
                            if (bundle != null && bundle.getBoolean("jumpGuildFromLoadingPage", false)) {
                                h16.c(0, 0, 0, 0);
                            }
                            com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), GuildMediaChannelFragment.class, h16.a());
                            return true;
                        }
                    }
                    QLog.w(TAG, 1, "[enterMediaChannel] failed. invalid context");
                    return false;
                }
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).startGuildLiveActivity(GuildMediaChannelFragment.class, intent);
                return true;
            }
        } else {
            i3 = -1;
        }
        str = "";
        QLog.d(TAG, 1, "enterMediaChannel joinSourceType " + str);
        String guildId2 = iGProChannelInfo.getGuildId();
        String channelUin2 = iGProChannelInfo.getChannelUin();
        if (i3 != 10) {
        }
        com.tencent.mobileqq.guild.media.core.q qVar2 = new com.tencent.mobileqq.guild.media.core.q(guildId2, channelUin2, i16, c16);
        if (str == null) {
        }
        qVar2.m(str);
        if (bundle != null) {
        }
        com.tencent.mobileqq.guild.media.core.j.a().c(qVar2, new com.tencent.mobileqq.guild.media.core.b() { // from class: com.tencent.mobileqq.guild.api.impl.x
            @Override // com.tencent.mobileqq.guild.media.core.b
            public final void a(boolean z16, IGProSecurityResult iGProSecurityResult) {
                LaunchGuildChatPieApiImpl.lambda$enterMediaChannel$1(z16, iGProSecurityResult);
            }
        });
        com.tencent.mobileqq.guild.media.core.j.a().e0(bundle);
        GuildFloatWindowUtils.r();
        QLog.i(TAG, 1, "[launchMediaChannel] guildId: " + iGProGuildInfo.getGuildID() + ", channelId: " + iGProChannelInfo.getChannelUin());
        intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.addFlags(335544320);
        intent.putExtra("extra_guild_guild_info", iGProGuildInfo);
        intent.putExtra("extra_guild_channel_info", iGProChannelInfo);
        intent.putExtra("ARG_KEY", qVar2.getKey());
        configMediaAioIntent(intent, iGProGuildInfo.getGuildName(), iGProChannelInfo, bundle);
        if (context instanceof Activity) {
        }
        context = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity();
        if (!QQGuildUIUtil.A(context)) {
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).startGuildLiveActivity(GuildMediaChannelFragment.class, intent);
        return true;
    }

    private void exitMediaChannelIfNeeded(@Nullable String str) {
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        if (a16.isInChannel()) {
            a16.D("", str);
        }
    }

    private int getChannelTypeByParams(AppRuntime appRuntime, LaunchGuildChatPieParam launchGuildChatPieParam) {
        return getChannelTypeLaunchChatPie(appRuntime, launchGuildChatPieParam.f214357h, launchGuildChatPieParam.f214354d, launchGuildChatPieParam.f214355e);
    }

    private Bundle getGuildChatFragmentBundle(com.tencent.mobileqq.guild.api.i iVar) {
        if (!iVar.g()) {
            return null;
        }
        if (iVar.f214375e == null) {
            iVar.f214375e = new Bundle();
        }
        if (!iVar.g()) {
            return null;
        }
        QLog.i(TAG, 1, "getGuildChatActivityIntent channelId:" + iVar.f214372b);
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", iVar.f214371a);
        bundle.putString("channel_id", iVar.f214372b);
        bundle.putString("factory_name", iVar.f214373c);
        bundle.putSerializable("AIOParam_ContainerType", ContainerType.CHAT_FRAGMENT_TYPE);
        Bundle bundle2 = iVar.f214375e;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        return bundle;
    }

    private Bundle getSplashGuildChatFragmentBundle(com.tencent.mobileqq.guild.api.i iVar) {
        if (!iVar.g()) {
            return null;
        }
        if (iVar.f214375e == null) {
            iVar.f214375e = new Bundle();
        }
        iVar.f214375e.putBoolean("SHOW_UnreadMsgCnt", true);
        iVar.f214375e.putBoolean("From_SplashActivity", true);
        if (!iVar.g()) {
            return null;
        }
        QLog.i(TAG, 1, "getGuildChatActivityIntent channelId:" + iVar.f214372b);
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", iVar.f214371a);
        bundle.putString("channel_id", iVar.f214372b);
        bundle.putString("factory_name", iVar.f214373c);
        bundle.putSerializable("AIOParam_ContainerType", ContainerType.CHAT_FRAGMENT_TYPE);
        Bundle bundle2 = iVar.f214375e;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        return bundle;
    }

    private Intent handleOtherGuildChatPieIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam) {
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getScheduleChannelIntent(context, launchGuildChatPieParam);
    }

    @SuppressLint({"WrongConstant"})
    private boolean isAcceptableChannelType(int i3) {
        if (i3 != 0 && i3 != 6 && i3 != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enterMediaChannel$0(IGProSecurityResult iGProSecurityResult) {
        if (iGProSecurityResult != null) {
            QQToastUtil.showQQToast(1, iGProSecurityResult.getStrPrompt());
        } else {
            QQToastUtil.showQQToast(1, R.string.f1493011x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enterMediaChannel$1(boolean z16, final IGProSecurityResult iGProSecurityResult) {
        if (!z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.api.impl.y
                @Override // java.lang.Runnable
                public final void run() {
                    LaunchGuildChatPieApiImpl.lambda$enterMediaChannel$0(IGProSecurityResult.this);
                }
            });
        }
    }

    private static void openStandaloneChatFragment(Context context, LaunchGuildChatPieParam launchGuildChatPieParam) {
        QLog.w(TAG, 1, "openStandaloneChatFragment() main frame is not show, will open blackActivity!");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(launchGuildChatPieParam.f214354d, launchGuildChatPieParam.f214355e);
        jumpGuildParam.extras = launchGuildChatPieParam.G;
        if (launchGuildChatPieParam.m()) {
            jumpGuildParam.setDirectMessage(true);
        }
        Bundle bundle = launchGuildChatPieParam.G;
        if (bundle != null && bundle.containsKey(JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE)) {
            int i3 = launchGuildChatPieParam.G.getInt(JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE);
            jumpGuildParam.setChannelOpenSource(i3);
            QLog.w(TAG, 1, "openStandaloneChatFragment() openSource:" + i3);
        }
        jumpGuildParam.setDirectMessage(launchGuildChatPieParam.m());
        GuildBlankActivity.b.a(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public int getChannelTypeLaunchChatPie(AppRuntime appRuntime, int i3, String str, String str2) {
        int i16;
        if (isAcceptableChannelType(i3)) {
            QLog.i(TAG, 1, "getChannelTypeLaunchChatPie channelId:" + str2 + " isAcceptable channelType:" + i3);
            return i3;
        }
        if (MobileQQ.sProcessId != 1 || (i16 = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(appRuntime, str, str2)) == 0) {
            i16 = i3;
        }
        QLog.i(TAG, 1, "getChannelTypeLaunchChatPie channelId:" + str2 + " sourceChannelType:" + i3 + " channelType:" + i16);
        return i16;
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public Intent getGuildChatActivityIntent(@NonNull Context context, @NonNull com.tencent.mobileqq.guild.api.i iVar) {
        if (!iVar.g()) {
            return null;
        }
        QLog.i(TAG, 1, "getGuildChatActivityIntent channelId:" + iVar.f214372b);
        Intent intent = new Intent(context, ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).getGuildChatActivityClass());
        intent.putExtra("guild_id", iVar.f214371a);
        intent.putExtra("channel_id", iVar.f214372b);
        intent.putExtra("factory_name", iVar.f214373c);
        Bundle bundle = new Bundle();
        bundle.putSerializable("AIOParam_ContainerType", ContainerType.STAND_TYPE);
        Bundle bundle2 = iVar.f214375e;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        intent.putExtra(AppConstants.Key.GUILD_EXTRA, bundle);
        if (iVar.f214374d) {
            intent.setFlags(335544320);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public Intent getGuildChatPieIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam) {
        int i3;
        if (context == null || launchGuildChatPieParam == null || !launchGuildChatPieParam.n()) {
            return null;
        }
        Intent handleOtherGuildChatPieIntent = handleOtherGuildChatPieIntent(context, launchGuildChatPieParam);
        if (handleOtherGuildChatPieIntent != null) {
            return handleOtherGuildChatPieIntent;
        }
        Intent intent = new Intent();
        Bundle bundle = launchGuildChatPieParam.G;
        if (bundle != null && bundle.containsKey("forward_type")) {
            intent.putExtras(new Bundle(launchGuildChatPieParam.G));
        }
        if (launchGuildChatPieParam.D) {
            MsgRecord msgRecord = launchGuildChatPieParam.H;
            if (msgRecord != null && msgRecord.getDirectMsgFlag() == 1) {
                i3 = GuildMainFrameConstants.f227277u;
            } else {
                i3 = GuildMainFrameConstants.f227276t;
            }
            intent.putExtra("goto_guildtab_actiontype", i3);
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setGuildTabIntent(context, intent);
            if (launchGuildChatPieParam.H.getDirectMsgFlag() == 1 && launchGuildChatPieParam.E == 10) {
                intent.putExtra(IGuildMainFrameApi.GOTO_CONVERSATION_TAB, true);
                intent.putExtra(IGuildMainFrameApi.OPEN_CONVERSATION_TAG, true);
            } else {
                intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
            }
            intent.putExtra("forceStartActivity", true);
            intent.putExtra("forceStartActivityTemp", true);
        }
        int channelTypeByParams = getChannelTypeByParams(MobileQQ.sMobileQQ.waitAppRuntime(null), launchGuildChatPieParam);
        intent.putExtra("uin", launchGuildChatPieParam.f214355e);
        intent.putExtra("uintype", 10014);
        intent.putExtra("uinname", launchGuildChatPieParam.f214356f);
        intent.putExtra("channel_name", launchGuildChatPieParam.f214356f);
        intent.putExtra("guild_id", launchGuildChatPieParam.f214354d);
        intent.putExtra("channel_type", channelTypeByParams);
        intent.putExtra(AppConstants.Key.KEY_NEED_TO_SHOW_UNREAD_NUM, true);
        intent.putExtra("openGuildAioFrom", launchGuildChatPieParam.E);
        intent.putExtra("openGuildAioDisableReuse", launchGuildChatPieParam.F);
        MsgRecord msgRecord2 = launchGuildChatPieParam.H;
        if (msgRecord2 != null && msgRecord2.getDirectMsgFlag() == 1) {
            if (launchGuildChatPieParam.G == null) {
                launchGuildChatPieParam.G = new Bundle();
            }
            launchGuildChatPieParam.G.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        }
        Bundle bundle2 = launchGuildChatPieParam.G;
        if (bundle2 != null) {
            intent.putExtra(AppConstants.Key.GUILD_EXTRA, bundle2);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("openAioWithoutAnimation", launchGuildChatPieParam.f214359m);
        bundle3.putInt("openAioIn", launchGuildChatPieParam.C);
        bundle3.putBoolean("keepOpenPos", launchGuildChatPieParam.f214358i);
        if (launchGuildChatPieParam.E == 10) {
            bundle3.putInt("openGuildFrom", 1);
        }
        bundle3.putString("uin", launchGuildChatPieParam.f214355e);
        bundle3.putString("guild_id", launchGuildChatPieParam.f214354d);
        intent.putExtra("goto_guildtab_actionextra", bundle3);
        return intent;
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public Intent getSplashGuildChatActivityIntent(@NonNull Context context, @NonNull com.tencent.mobileqq.guild.api.i iVar) {
        if (!iVar.g()) {
            return null;
        }
        if (iVar.f214375e == null) {
            iVar.f214375e = new Bundle();
        }
        iVar.f214375e.putBoolean("SHOW_UnreadMsgCnt", true);
        iVar.f214375e.putBoolean("From_SplashActivity", true);
        return getGuildChatActivityIntent(context, iVar);
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public void launchGuildChatActivity(@NonNull Context context, @NonNull com.tencent.mobileqq.guild.api.i iVar) {
        if (!iVar.g()) {
            return;
        }
        context.startActivity(getGuildChatActivityIntent(context, iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public void launchGuildChatFragment(@NonNull Context context, @NonNull com.tencent.mobileqq.guild.api.i iVar) {
        Bundle guildChatFragmentBundle = getGuildChatFragmentBundle(iVar);
        Intent intent = new Intent();
        intent.putExtras(guildChatFragmentBundle);
        GuildSplitViewUtils.f235370a.o(context, intent, ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).getGuildChatFragmentClass(), LaunchMode.singleTask);
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public void launchGuildChatPie(@NonNull Context context, @NonNull LaunchGuildChatPieParam launchGuildChatPieParam) {
        com.tencent.mobileqq.guild.mainframe.s p16;
        if (context != null && launchGuildChatPieParam != null && launchGuildChatPieParam.n()) {
            if (launchGuildChatPieParam.D) {
                context.startActivity(getGuildChatPieIntent(context, launchGuildChatPieParam));
                QLog.i(TAG, 1, "launchGuildChatPie guildChatPieParam:" + launchGuildChatPieParam);
                return;
            }
            boolean z16 = !((IGuildTempApi) QRoute.api(IGuildTempApi.class)).checkGuildMainFrameShow();
            launchGuildChatPieParam.D = z16;
            Intent guildChatPieIntent = getGuildChatPieIntent(context, launchGuildChatPieParam);
            if (z16) {
                context.startActivity(guildChatPieIntent);
                QLog.i(TAG, 1, "launchGuildChatPie guildChatPieParam:" + launchGuildChatPieParam);
                return;
            }
            if (context instanceof QBaseActivity) {
                p16 = GuildMainFrameUtils.p((QBaseActivity) context);
            } else {
                p16 = GuildMainFrameUtils.p(null);
            }
            if (p16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "openChatCenterPanel guildChatPieParam:" + launchGuildChatPieParam);
                }
                GuildMainFrameManager.j(launchGuildChatPieParam);
                return;
            }
            openStandaloneChatFragment(context, launchGuildChatPieParam);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public void launchGuildDirectMessageAio(@NonNull Context context, @NonNull LaunchGuildChatPieParam launchGuildChatPieParam) {
        if (context != null && launchGuildChatPieParam != null && launchGuildChatPieParam.n()) {
            if (launchGuildChatPieParam.D) {
                context.startActivity(getGuildChatPieIntent(context, launchGuildChatPieParam));
                QLog.i(TAG, 1, "launchGuildDirectMessageAio guildChatPieParam:" + launchGuildChatPieParam);
                return;
            }
            openStandaloneChatFragment(context, launchGuildChatPieParam);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public boolean launchMediaChannel(Context context, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        if (com.tencent.mobileqq.guild.util.o.c(TAG)) {
            return false;
        }
        if (iGProGuildInfo != null && iGProChannelInfo != null) {
            QLog.i(TAG, 1, QLog.getStackTraceString(new Throwable("launchMediaChannel guildId:" + iGProGuildInfo.getGuildID() + ", channelId: " + iGProChannelInfo.getChannelUin() + ", type:" + iGProChannelInfo.getType())));
            if (w02.a.f444141a.a(context)) {
                QLog.e(TAG, 1, "[launchMediaChannel] isRoomMutualExclusion true");
                return false;
            }
            if (enterMediaChannel(context, iGProGuildInfo, iGProChannelInfo, bundle)) {
                return true;
            }
            QLog.w(TAG, 1, "[launchMediaChannel] failed. try exit room");
            exitMediaChannelIfNeeded("launchMediaChannel failed.");
            return false;
        }
        QLog.e(TAG, 1, "[launchMediaChannel] guildInfo of channelInfo is null");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public void launchSplashGuildChatActivity(@NonNull Context context, @NonNull com.tencent.mobileqq.guild.api.i iVar) {
        Intent splashGuildChatActivityIntent = getSplashGuildChatActivityIntent(context, iVar);
        if (splashGuildChatActivityIntent == null) {
            return;
        }
        context.startActivity(splashGuildChatActivityIntent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154433l0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
    public void launchSplashGuildChatFragment(@NonNull Context context, @NonNull com.tencent.mobileqq.guild.api.i iVar) {
        Bundle splashGuildChatFragmentBundle = getSplashGuildChatFragmentBundle(iVar);
        Intent intent = new Intent();
        intent.putExtras(splashGuildChatFragmentBundle);
        GuildSplitViewUtils.f235370a.o(context, intent, ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).getGuildChatFragmentClass(), LaunchMode.singleTask);
    }
}
