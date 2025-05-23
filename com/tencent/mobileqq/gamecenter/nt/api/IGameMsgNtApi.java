package com.tencent.mobileqq.gamecenter.nt.api;

import androidx.annotation.WorkerThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0003XYZJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0012H&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H&J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H&J.\u0010(\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H&J\u0014\u0010+\u001a\u0004\u0018\u00010\u001f2\b\u0010*\u001a\u0004\u0018\u00010)H&J\u0012\u0010,\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010.\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020-H'J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020/H&J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020/H&J\u001c\u00102\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u00102\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u0001032\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020605H&J\u0010\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020605H&J\u0018\u0010;\u001a\u00020\u00022\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fH&J\u0018\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0002H&J(\u0010A\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u001fH&Jj\u0010I\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010B\u001a\u0004\u0018\u00010\u00022\b\u0010C\u001a\u0004\u0018\u00010\u00022\b\u0010D\u001a\u0004\u0018\u00010\u00022\b\u0010E\u001a\u0004\u0018\u00010\u00022\b\u0010:\u001a\u0004\u0018\u00010\u00022\b\u00109\u001a\u0004\u0018\u00010\u00022\b\u0010F\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00022\u0006\u0010H\u001a\u00020\u0004H&J\u001c\u0010K\u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010J\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010L\u001a\u0004\u0018\u00010\u001f2\u0006\u0010J\u001a\u00020\u0002H&J\u0018\u0010M\u001a\u00020\u00022\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fH&J\u0012\u0010O\u001a\u0004\u0018\u00010\u00172\u0006\u0010N\u001a\u00020\u0002H&J\u0012\u0010P\u001a\u0004\u0018\u00010\u00022\u0006\u0010N\u001a\u00020\u0002H&J\u0014\u0010S\u001a\u0004\u0018\u00010R2\b\u0010Q\u001a\u0004\u0018\u00010\u0002H&J$\u0010V\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010T\u001a\u0004\u0018\u00010R2\u0006\u0010U\u001a\u00020#H&J\b\u0010W\u001a\u00020\u0006H&\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "peerUid", "", "chatType", "", "setMsgRead", "limitSize", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$b;", "listener", "getMsgList", "", "msgId", "msgTime", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "params", "queryMsgsWithFilter", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$a;", "getLatestMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "buildRecentContactInfo", "info", "Lcom/tencent/mobileqq/gamecenter/msginfo/GameCenterSessionInfo;", "getGameSessionInfo", "", "getGameRecentContactList", "getGameRecentContact", "getRecentContactInfo", "getGameRecentContactInfo", "contact", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "getGameSessionFromContact", "Lcom/tencent/qqnt/kernel/nativeinterface/AnchorPointContactInfo;", "anchor", "", "fetchOld", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "fetchGameRecentContactInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "getGameSessionFromMsg", "getGameSessionFromPeerUid", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$c;", "getTempGameSessionFromPeerUid", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "addMsgListener", "removeMsgListener", "addGrayTipForGameAIO", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "localGrayTip", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "getGrayTipsJumpSettingHandlerClz", "getGrayTipsAddFriendHandlerClz", "selfTinyId", "peerTinyId", "createUidFromTinyId", "selfTinyIdStr", "peerTinyIdStr", "sayHiType", "text", "gameSession", "sendSayHiMsg", "peerRoleId", "selfRoleId", "peerOpenId", "selfOpenId", "gameAppId", PreloadTRTCPlayerParams.KEY_SIG, "windowFlag", "getGameSessionJson", "jsonStr", "getGameSessionFromPeerUidOrJson", "parseGameSessionJson", "createConvertUinFromTinyId", "convertUin", "getSessionInfoByUin", "getPeerUidByUin", "content", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "createArkElement", "arkElement", "front", "insertLocalArkRecord", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "b", "c", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMsgNtApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "latestMsg", "", "a", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void a(@Nullable MsgRecord latestMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$b;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void onSuccess(@NotNull ArrayList<MsgRecord> msgList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "sessionInfo", "", "a", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface c {
        void a(@Nullable TempChatGameSession sessionInfo);
    }

    void addGrayTipForGameAIO(@Nullable LocalGrayTip localGrayTip, @Nullable String peerUid);

    void addGrayTipForGameAIO(@Nullable String msg2, @Nullable String peerUid);

    void addMsgListener(@NotNull IKernelMsgListener listener);

    @NotNull
    RecentContactInfo buildRecentContactInfo(@NotNull String peerUid, int chatType);

    @Nullable
    MsgElement createArkElement(@Nullable String content);

    @NotNull
    String createConvertUinFromTinyId(long selfTinyId, long peerTinyId);

    @NotNull
    String createUidFromTinyId(long selfTinyId, long peerTinyId);

    @NotNull
    String createUidFromTinyId(@NotNull String selfTinyIdStr, @NotNull String peerTinyIdStr);

    void fetchGameRecentContactInfo(@NotNull AnchorPointContactInfo anchor, boolean fetchOld, int count, @Nullable IOperateCallback callback);

    @Nullable
    RecentContactInfo getGameRecentContact(@NotNull String peerUid);

    @Nullable
    RecentContactInfo getGameRecentContactInfo(int chatType, @NotNull String peerUid);

    @NotNull
    List<RecentContactInfo> getGameRecentContactList();

    @Nullable
    TempChatGameSession getGameSessionFromContact(@Nullable RecentContactInfo contact);

    @Nullable
    TempChatGameSession getGameSessionFromMsg(@Nullable MsgRecord msg2);

    @Nullable
    TempChatGameSession getGameSessionFromPeerUid(@NotNull String peerUid);

    @NotNull
    TempChatGameSession getGameSessionFromPeerUidOrJson(@Nullable String peerUid, @Nullable String jsonStr);

    @Nullable
    GameCenterSessionInfo getGameSessionInfo(@Nullable RecentContactInfo info);

    @NotNull
    String getGameSessionJson(@Nullable String peerUid, @Nullable String peerRoleId, @Nullable String selfRoleId, @Nullable String peerOpenId, @Nullable String selfOpenId, @Nullable String peerTinyId, @Nullable String selfTinyId, @Nullable String gameAppId, @Nullable String sig, int windowFlag);

    @NotNull
    Class<? extends com.tencent.qqnt.graytips.handler.b> getGrayTipsAddFriendHandlerClz();

    @NotNull
    Class<? extends com.tencent.qqnt.graytips.handler.b> getGrayTipsJumpSettingHandlerClz();

    void getLatestMsg(@NotNull String peerUid, int chatType, @NotNull a listener);

    void getMsgList(@NotNull String peerUid, int chatType, int limitSize, @NotNull b listener);

    @Nullable
    String getPeerUidByUin(@NotNull String convertUin);

    @Nullable
    RecentContactInfo getRecentContactInfo(int chatType, @NotNull String peerUid);

    @Nullable
    GameCenterSessionInfo getSessionInfoByUin(@NotNull String convertUin);

    @WorkerThread
    void getTempGameSessionFromPeerUid(@Nullable String peerUid, @NotNull c listener);

    void insertLocalArkRecord(@Nullable String peerUid, @Nullable MsgElement arkElement, boolean front);

    void onDestroy();

    @Nullable
    TempChatGameSession parseGameSessionJson(@NotNull String jsonStr);

    void queryMsgsWithFilter(long msgId, long msgTime, @Nullable QueryMsgsParams params, @NotNull b listener);

    void removeMsgListener(@NotNull IKernelMsgListener listener);

    void sendSayHiMsg(int sayHiType, @NotNull String peerUid, @NotNull String text, @NotNull TempChatGameSession gameSession);

    void setMsgRead(@NotNull String peerUid, int chatType);
}
