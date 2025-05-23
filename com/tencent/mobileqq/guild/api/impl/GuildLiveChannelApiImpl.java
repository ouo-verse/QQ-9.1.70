package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.fragment.push.QQGuildLivePushMsgHandler;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildLiveChannelApiImpl implements IGuildLiveChannelApi {
    private static final String TAG = "GuildLiveChannelApiImpl";
    private static MessageRecordForGuildWelcome securityMsg;
    private static Set<String> showSecurityMsgRoomProgramIds;
    private final List<gq1.a> mGuildLiveAgreementListeners = new ArrayList();

    private void checkLocalRoomProgramIds() {
        long h16 = bx.h();
        long todayStartSecond = getTodayStartSecond();
        if (h16 != todayStartSecond) {
            bx.v(new HashSet());
            bx.y(todayStartSecond);
        }
    }

    private Set<String> getShowedRoomProgramIds() {
        if (showSecurityMsgRoomProgramIds == null) {
            checkLocalRoomProgramIds();
            showSecurityMsgRoomProgramIds = bx.g();
        }
        return showSecurityMsgRoomProgramIds;
    }

    private long getTodayStartSecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isAnchorInPlayListShow$0(boolean z16, boolean z17) {
        return "[isAnchorInPlayListShow] programListType:" + z16 + ", allowLive:" + z17;
    }

    private void saveShowedRoomProgramId(String str) {
        getShowedRoomProgramIds().add(str);
        bx.v(getShowedRoomProgramIds());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public void addCloseLiveAgreementListener(gq1.a aVar) {
        this.mGuildLiveAgreementListeners.add(aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean checkGuildLiveAvBusinessFocus(String str) {
        return com.tencent.mobileqq.guild.util.h.f(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    @RequiresApi(api = 16)
    public void cleanLiveChannelAIOBg(ViewGroup viewGroup) {
        if (viewGroup.getId() == R.id.wm8) {
            return;
        }
        while (viewGroup.getId() != R.id.wm8) {
            Drawable background = viewGroup.getBackground();
            if (background != null) {
                QLog.d(TAG, 4, "cleanLiveChannelAIOBg  bg = " + background.getClass().getName() + ", --- id = " + viewGroup.getId() + ", ---view = " + viewGroup.getClass().getName());
                viewGroup.setBackground(null);
            }
            if (viewGroup.getParent() instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewGroup.getParent();
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public ChatMessage createSecurityMsg(Context context) {
        MessageRecordForGuildWelcome messageRecordForGuildWelcome;
        Activity activity = (Activity) context;
        if (activity == null) {
            return null;
        }
        String S = ch.S();
        if (TextUtils.isEmpty(S)) {
            S = context.getApplicationContext().getString(R.string.f147570x9);
        }
        if (activity.getIntent().getBooleanExtra("arg_from_float", false) && (messageRecordForGuildWelcome = securityMsg) != null) {
            messageRecordForGuildWelcome.showMsg = S;
            return messageRecordForGuildWelcome;
        }
        MessageRecordForGuildWelcome messageRecordForGuildWelcome2 = new MessageRecordForGuildWelcome();
        messageRecordForGuildWelcome2.showMsg = S;
        messageRecordForGuildWelcome2.shmsgseq = 0L;
        messageRecordForGuildWelcome2.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        messageRecordForGuildWelcome2.init("", "", "", "", com.tencent.mobileqq.service.message.e.K0(), MessageRecord.MSG_TYPE_GUILD_WELCOME_TIPS, 10014, 0L);
        securityMsg = messageRecordForGuildWelcome2;
        return messageRecordForGuildWelcome2;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public Intent getLiveChannelIntent() {
        return gq1.c.b(GLiveChannelCore.f226698a.s());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public String getLiveChannelSecurityMsgText(Context context) {
        Activity activity = (Activity) context;
        if (activity == null) {
            return null;
        }
        String S = ch.S();
        if (TextUtils.isEmpty(S)) {
            return activity.getString(R.string.f147570x9);
        }
        return S;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public Integer getLiveVideoScreenState() {
        return Integer.valueOf(GLiveChannelCore.f226698a.t().m());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public Bundle getStartParamsBundle() {
        return GLiveChannelCore.f226698a.s().getBundle();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean guildLiveVideoIsFullScreenState() {
        if (GLiveChannelCore.f226698a.t().m() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean guildLiveVideoIsLandScreenState() {
        if (GLiveChannelCore.f226698a.t().m() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean hasFetchedRoomInfo() {
        return GLiveChannelCore.f226698a.t().M();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean isAnchorInPlayListShow() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        final boolean a16 = gLiveChannelCore.r().a();
        final boolean allowStartLive = gLiveChannelCore.s().getAllowStartLive();
        Logger.f235387a.b(TAG, new Function0() { // from class: com.tencent.mobileqq.guild.api.impl.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String lambda$isAnchorInPlayListShow$0;
                lambda$isAnchorInPlayListShow$0 = GuildLiveChannelApiImpl.lambda$isAnchorInPlayListShow$0(a16, allowStartLive);
                return lambda$isAnchorInPlayListShow$0;
            }
        });
        if (a16 && allowStartLive) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean isLiveSpeakClose(String str) {
        return com.tencent.mobileqq.guild.util.security.h.f235636d.c(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean isSelfLiving() {
        return GLiveChannelCore.f226698a.t().N();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean isSelfLivingAndPushFlowType(Boolean bool) {
        boolean z16;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.t().N() && gLiveChannelCore.r().d()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && bool.booleanValue()) {
            com.tencent.mobileqq.guild.util.aa.a(R.string.f148520zt);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public boolean needAddSecurityMsg() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (!gLiveChannelCore.s().isLiving()) {
            QLog.d(TAG, 1, "needAddSecurityMsg channel is not living.");
            return false;
        }
        if (ch.h()) {
            QLog.d(TAG, 1, "needAddSecurityMsg alwaysShowSecurityMsg.");
            return true;
        }
        LiveChannelRoomInfo value = gLiveChannelCore.t().p().getValue();
        if (value == null) {
            QLog.i(TAG, 1, "[needAddSecurityMsg] roomInfo = null ");
            return false;
        }
        String programId = value.getProgramId();
        boolean z16 = !getShowedRoomProgramIds().contains(programId);
        QLog.d(TAG, 1, "needAddSecurityMsg needShow = " + z16 + ", programId = " + programId);
        if (z16) {
            saveShowedRoomProgramId(programId);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public void onCloseLiveAgreement() {
        Iterator<gq1.a> it = this.mGuildLiveAgreementListeners.iterator();
        while (it.hasNext()) {
            it.next().onCloseLiveAgreement();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public void removeCloseLiveAgreementListener(gq1.a aVar) {
        this.mGuildLiveAgreementListeners.remove(aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public void switchLiveChannel(@NonNull IGProChannelInfo iGProChannelInfo, String str) {
        GLiveChannelStartParams create = GLiveChannelStartParams.create(iGProChannelInfo);
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam();
        joinInfoParam.setAfterJoinJumpChannelId(iGProChannelInfo.getChannelUin());
        joinInfoParam.setJoinSignature(str);
        joinInfoParam.setMainSource("share");
        joinInfoParam.setSubSource("others");
        create.getBundle().putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        gq1.c.e(create);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public void updateMultiSelectState(boolean z16) {
        GLiveChannelCore.f226698a.t().f0(Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
    public Intent getLiveChannelIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam) {
        IGProChannelInfo channelInfo = ((IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getChannelInfo(launchGuildChatPieParam.f214355e);
        if (channelInfo == null || channelInfo.getType() != 5) {
            return null;
        }
        return QQGuildLivePushMsgHandler.ph(channelInfo.getChannelUin(), launchGuildChatPieParam);
    }
}
