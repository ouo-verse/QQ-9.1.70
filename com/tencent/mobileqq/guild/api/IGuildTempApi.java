package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildTempApi extends QRouteApi {
    void addOnDrawerInitListener(c cVar);

    void adjustTab(QBaseActivity qBaseActivity);

    void buildTeamShareForwardIntent(Intent intent, QBaseActivity qBaseActivity);

    boolean checkChatPie(Object obj);

    boolean checkGuildMainFrameShow();

    int convActiveTab(int i3);

    void doFirstDrawCompleted(QBaseActivity qBaseActivity);

    int getCurrentActiveTab();

    Activity getCurrentTopActivity();

    Class getGuildForwardListFragmentClass();

    Intent getGuildIntent(Context context, Message message, boolean z16, String str);

    @Nullable
    FrameFragment getMainFragment();

    FrameFragment getMainFragment(FragmentActivity fragmentActivity);

    long getReplyMsgCommentCnt(MessageRecord messageRecord);

    QBaseActivity getSplashActivity();

    Map<String, Object> getTitleData();

    void handleConversationJump(FrameFragment frameFragment, Bundle bundle);

    void handleReceivedMessage(int i3, boolean z16, boolean z17, Message message, AppRuntime appRuntime);

    void initVideoPlaySo();

    boolean isAtMeMsgApi(MsgRecord msgRecord, String str);

    boolean isChatFragmentShowing(Activity activity);

    boolean isConversationGuildContentVisible(@NonNull Activity activity);

    boolean isDisplayGuildFrameLayout();

    boolean isDrawerInit(QBaseActivity qBaseActivity);

    boolean isEmptyBeforeMessageSend(Object obj);

    boolean isGiftMsg(Message message);

    boolean isGiftMsg(MessageRecord messageRecord);

    boolean isGuildChatPieFilterMsg(AppRuntime appRuntime, ChatMessage chatMessage);

    boolean isGuildListUIAtBottom();

    boolean isGuildTabSelected();

    boolean isInConversationTab();

    boolean isInConversationTabSelected(Activity activity);

    boolean isInGuildTab();

    boolean isInGuildTab(Activity activity);

    boolean isLiveChannelOpen();

    boolean isMainFragmentTabShowing();

    boolean isMainProcessOnTop();

    boolean isMyPersonalRedPacketMsg(AppRuntime appRuntime, MessageRecord messageRecord);

    boolean isPersonalRedPacketMsg(MessageRecord messageRecord);

    boolean isRedPacketMsg(MessageRecord messageRecord);

    boolean isRedPacketMsgApi(MsgRecord msgRecord);

    boolean isShowContent(AppRuntime appRuntime);

    boolean isSourceRevokeForReplyMsg(MessageRecord messageRecord);

    boolean isSplashActivity(Activity activity);

    Intent jumpToCropActivity(Activity activity, Intent intent);

    void jumpTpAioPosition(AppRuntime appRuntime, String str, String str2, long j3);

    @Deprecated
    boolean needHidePanel();

    void notifyGuildHiddenChanged(QBaseFragment qBaseFragment);

    String obtainConversationTabGuildContentGuildId();

    be obtainGuildMainFrame();

    be obtainGuildMainFrame(Context context);

    View obtainTabWidget(QBaseActivity qBaseActivity);

    void onDrawerInit();

    void onGuildChatFragmentActivityResult(QBaseFragment qBaseFragment, int i3, int i16, Intent intent);

    void openChannelInChannel(Context context, String str, String str2, String str3, int i3, JumpGuildParam.JoinInfoParam joinInfoParam, GuildAppReportSourceInfo guildAppReportSourceInfo, int i16);

    void openGuildByShareUrl(Context context, String str, String str2);

    boolean otherDevLoginMute(AppInterface appInterface);

    void printAtMsgInfoLog(String str, MessageRecord messageRecord);

    void refreshChatPieListView(AppRuntime appRuntime, String str);

    void refreshMsgTabUnreadNum(AppRuntime appRuntime);

    void saveRecentForwardGuildRecord(String str);

    void sendClientAuthSuccessToArk(String str, String str2);

    void setConversationTabIntent(Context context, Intent intent);

    void setDrawerFrameEnable(boolean z16);

    void setGuildTabIntent(Context context, Intent intent);

    void setPreRemoveRoamMsgSeqSet(String str, HashSet<Long> hashSet);

    void setSelectMember(String str, String str2, Drawable drawable);

    boolean setSourceRevokeForReplyMsg(MessageRecord messageRecord, int i3);

    void setTabWidgetVisible(QBaseActivity qBaseActivity, boolean z16);

    boolean shouldJumpConversationTab(String str);

    void startAsyncStepLite(AppInterface appInterface);

    void startDownloadPic(ArrayList<MessageRecord> arrayList, boolean z16, AppInterface appInterface);

    void startGuildLiveActivity(Class<? extends QPublicBaseFragment> cls, Intent intent);

    void tabWidgetAnim(QBaseActivity qBaseActivity, boolean z16);

    void tabWidgetAnimInConversation(QBaseActivity qBaseActivity, boolean z16);

    boolean updateReferCommonInfo(MessageRecord messageRecord, MessageRecord messageRecord2);
}
