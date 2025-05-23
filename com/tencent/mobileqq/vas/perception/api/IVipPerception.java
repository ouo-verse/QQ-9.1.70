package com.tencent.mobileqq.vas.perception.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import gu4.m;
import gu4.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012H&J\b\u0010\u0018\u001a\u00020\tH&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/IVipPerception;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "chatType", "", "peerUid", "", "peerUin", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", "longClickVoiceMsg", "voiceMsg30s", "sVipExpiredCheck", "groupKeyWord", "uin", "privilegeType", "", "checkInExperience", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/o;", "callback", "getUserExperience", "Lgu4/m;", "obtainExperience", "debugClearCache", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipPerception extends QRouteApi {
    boolean checkInExperience(@NotNull String uin, int privilegeType);

    void debugClearCache();

    void getUserExperience(int privilegeType, @Nullable VipPerceptionRequestResult<o> callback);

    void groupKeyWord(int chatType, long peerUin);

    void longClickVoiceMsg(int chatType, @NotNull String peerUid, long peerUin, long senderUin);

    void obtainExperience(int privilegeType, @Nullable VipPerceptionRequestResult<m> callback);

    void sVipExpiredCheck(int chatType, long peerUin);

    void voiceMsg30s(int chatType, @NotNull String peerUid, long peerUin, long senderUin);
}
