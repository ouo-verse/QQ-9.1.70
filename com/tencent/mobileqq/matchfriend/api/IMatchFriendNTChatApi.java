package com.tencent.mobileqq.matchfriend.api;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000bH&J,\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J,\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u000bH&J\b\u0010!\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000bH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/IMatchFriendNTChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkEnterVoiceChatPage", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "roomInfo", "Lcom/tencent/mobileqq/matchfriend/voicechat/RoomInfo;", "getAssistedChatCacheExpiredTime", "", "getBreakTopicArkMsgRecord", "", "getHaseMatchFriendMiniCardArk", "", "tinyId", "getIceBreakTopicMsgId", "app", "Lcom/tencent/common/app/AppInterface;", "getMatchFriendNTQQText", "", "source", WadlProxyConsts.FLAGS, "emosize", "message", "", "handleGetCanGreet", "isPass", "remindText", "", "hitType", "handleSendIcebreakerTopicMessage", "params", "msgId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "saveBreakTopicArkMsgRecord", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendNTChatApi extends QRouteApi {
    void checkEnterVoiceChatPage(@Nullable Activity activity, @Nullable RoomInfo roomInfo);

    int getAssistedChatCacheExpiredTime();

    long getBreakTopicArkMsgRecord();

    boolean getHaseMatchFriendMiniCardArk(long tinyId);

    long getIceBreakTopicMsgId(@NotNull AppInterface app, long tinyId);

    @NotNull
    CharSequence getMatchFriendNTQQText(@Nullable CharSequence source, int flags, int emosize, @Nullable Object message);

    void handleGetCanGreet(boolean isPass, @Nullable String remindText, int hitType, @Nullable Activity activity);

    void handleSendIcebreakerTopicMessage(@Nullable String params, @Nullable String tinyId, long msgId);

    void onDestroy();

    void saveBreakTopicArkMsgRecord(long msgId);
}
