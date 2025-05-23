package com.tencent.mobileqq.gamecenter.nt.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u000245J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u008e\u0001\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0098\u0001\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H&J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&J\u001a\u0010 \u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0012\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H&J\u0012\u0010&\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010$H&J\u0012\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0012\u0010(\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H&J8\u0010-\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004H&J7\u00103\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042#\u00102\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\b0.H&\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "uin", "", "from", "", "enterGameMsgAio", "peerUid", "peerRoleId", "selfRoleId", "peerOpenId", "selfOpenId", "peerTinyId", "selfTinyId", "gameAppId", PreloadTRTCPlayerParams.KEY_SIG, "topGrayText", "windowFlag", "", "isFromPlayer", WadlProxyConsts.EXT_JSON, "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "gameSession", "Landroid/content/Intent;", "intent", "createJumpIntent", "convertUin", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$a;", "callback", "reqCanShowIceBreakImages", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$b;", "listener", "setMsgInterceptListener", "", "text", "onSendMsgIntercept", "getFriendFaceUrl", "getFriendNickName", "curUin", "myRoleId", "friendRoleId", "newReportMsg", "jumpJuBaoReport", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sign", "receiver", "getGameSign", "a", "b", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMsgAioNtApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$a;", "", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "appId", "", "onResult", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void onResult(boolean canShow, @Nullable String appId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$b;", "", "", "text", "", "a", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        boolean a(@Nullable CharSequence text);
    }

    @NotNull
    Intent createJumpIntent(@Nullable Context context, @NotNull TempChatGameSession gameSession, @NotNull Intent intent);

    void enterGameMsgAio(@Nullable Context context, @NotNull TempChatGameSession gameSession, int from);

    void enterGameMsgAio(@Nullable Context context, @Nullable String uin);

    void enterGameMsgAio(@Nullable Context context, @Nullable String uin, int from);

    void enterGameMsgAio(@Nullable Context context, @Nullable String peerUid, @Nullable String peerRoleId, @Nullable String selfRoleId, @Nullable String peerOpenId, @Nullable String selfOpenId, @Nullable String peerTinyId, @Nullable String selfTinyId, @Nullable String gameAppId, @Nullable String sig, @Nullable String topGrayText, int windowFlag, int from, boolean isFromPlayer);

    void enterGameMsgAio(@Nullable Context context, @Nullable String peerUid, @Nullable String peerRoleId, @Nullable String selfRoleId, @Nullable String peerOpenId, @Nullable String selfOpenId, @Nullable String peerTinyId, @Nullable String selfTinyId, @Nullable String gameAppId, @Nullable String sig, @Nullable String topGrayText, int windowFlag, int from, boolean isFromPlayer, @Nullable String extJson);

    @Nullable
    String getFriendFaceUrl(@NotNull TempChatGameSession gameSession);

    @NotNull
    String getFriendNickName(@NotNull TempChatGameSession gameSession);

    @NotNull
    String getFriendNickName(@Nullable String convertUin);

    void getGameSign(@Nullable String convertUin, @NotNull Function1<? super String, Unit> receiver);

    void jumpJuBaoReport(@NotNull Context context, @Nullable String curUin, @Nullable String myRoleId, @Nullable String friendRoleId, @Nullable String newReportMsg);

    boolean onSendMsgIntercept(@Nullable CharSequence text);

    void reqCanShowIceBreakImages(@Nullable String convertUin, @NotNull a callback);

    void setMsgInterceptListener(@Nullable b listener);
}
