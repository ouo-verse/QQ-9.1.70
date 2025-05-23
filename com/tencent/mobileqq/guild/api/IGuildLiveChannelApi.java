package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildLiveChannelApi extends QRouteApi {
    void addCloseLiveAgreementListener(gq1.a aVar);

    boolean checkGuildLiveAvBusinessFocus(String str);

    void cleanLiveChannelAIOBg(ViewGroup viewGroup);

    ChatMessage createSecurityMsg(Context context);

    Intent getLiveChannelIntent();

    Intent getLiveChannelIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam);

    String getLiveChannelSecurityMsgText(Context context);

    Integer getLiveVideoScreenState();

    Bundle getStartParamsBundle();

    boolean guildLiveVideoIsFullScreenState();

    boolean guildLiveVideoIsLandScreenState();

    boolean hasFetchedRoomInfo();

    boolean isAnchorInPlayListShow();

    boolean isLiveSpeakClose(String str);

    boolean isSelfLiving();

    boolean isSelfLivingAndPushFlowType(Boolean bool);

    boolean needAddSecurityMsg();

    void onCloseLiveAgreement();

    void removeCloseLiveAgreementListener(gq1.a aVar);

    void switchLiveChannel(@NonNull IGProChannelInfo iGProChannelInfo, String str);

    void updateMultiSelectState(boolean z16);
}
