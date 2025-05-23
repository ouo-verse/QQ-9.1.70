package com.tencent.mobileqq.qqexpand.chat;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bg\u0018\u0000 `2\u00020\u0001:\u0001aJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u001c\u0010\u0014\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fH&J\\\u0010\u001f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H&J4\u0010#\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H&J$\u0010%\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!H&J-\u0010)\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010'H&\u00a2\u0006\u0004\b)\u0010*J-\u0010+\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010'H&\u00a2\u0006\u0004\b+\u0010*J-\u0010.\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010&2\b\u0010-\u001a\u0004\u0018\u00010,H&\u00a2\u0006\u0004\b.\u0010/J$\u00101\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\u0006\u00100\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010,H&J\u0012\u00102\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H&J*\u00106\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020&H&J\b\u00107\u001a\u00020\bH&J\u001c\u00108\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J,\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010$\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000fH&J\u001a\u0010@\u001a\u00020\r2\u0010\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010>H&J\u0012\u0010A\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H&J\u0014\u0010B\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010C\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&J&\u0010H\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010\b2\b\u0010G\u001a\u0004\u0018\u00010\bH&J\u001c\u0010I\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&J4\u0010N\u001a\u00020&2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J>\u0010T\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010O\u001a\u0004\u0018\u00010\b2\u0006\u0010P\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010\b2\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u000fH&J\u001a\u0010U\u001a\u00020\r2\u0010\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010>H&J$\u0010X\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010V\u001a\u0004\u0018\u00010\b2\u0006\u0010W\u001a\u00020\u000fH&J.\u0010[\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010Y\u001a\u0004\u0018\u00010\b2\b\u0010F\u001a\u0004\u0018\u00010\b2\u0006\u0010Z\u001a\u00020\u000fH&J \u0010_\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\\2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010^\u001a\u00020]H&\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/data/MessageRecord;", "msgR", "Lcom/tencent/common/app/AppInterface;", "app", "", "handleLimitChatC2CConfirmMsg", "", "currentAccountUinStr", "matchUinStr", "getSessionId", "mr", "", "isExtendMatchChatMsg", "", "uinType", "isExtendMatchChatType", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "matchUin", "needAddFriendConversationNode", "addFriendConversationNode", "closeIceBreakingPanel", QQBrowserActivity.KEY_MSG_TYPE, "isSystemMessage", "nickName", "tipsString", "tipsID", "keyWordString", "actionType", "lastMessage", "addGrayTipsMessage", "createConversationNode", "", "data", "handlePreLoadDataForArkMiniProfileCard", "uin", "handlePreLoadDataForAvatarProfileCard", "", "Lcom/tencent/mobileqq/app/BusinessObserver;", "extendObserver", "preLoadDataForArkMiniProfileCard", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/app/BusinessObserver;)V", "preLoadDataForAvatarProfileCard", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "getExtendFriendSwitch", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/qqexpand/network/d;)V", "siwtchOn", "setExtendFriendSwitch", "getExtendFriendUserSwitch", "switchOn", "switchText", "nextTs", "setExtendFriendUserSwitch", "getExtendFriendUserSwitchText", "hasWatchedAdvertise", "posId", "count", "deepLinkVersion", "Ltencent/gdt/qq_ad_get$QQAdGet;", "createRequest", "", "list", "hasValidMessage", "bNeedShowLimitChatByAllController", "getLimitChatOnPlusName", "checkInterceptMatchMessage", "Landroid/content/Context;", "context", "friendUin", "friendNick", "startAddFriendActivity", "resetMatchChatAIOData", "Lvg2/d;", "matchInfo", "msgTime", "from", "addTopicMessage", "toUin", "tagID", "tagName", "showTopicMsg", IProfileCardConst.KEY_FROM_TYPE, "addExtendFriendUserInfo", "hasMiniProfileCard", IProfileProtocolConst.PARAM_TARGET_UIN, "fromPage", "startExtendFriendCardOnClickAvatar", "hostUin", "matchSourceId", "requestAddMatchedRelation", "Lmqq/app/AppRuntime;", "", "signature", "saveTempC2cSignature", "Companion", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ILimitChatUtils extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f263510a;

    @NotNull
    public static final String EXT_KEY_LIMIT_CHAT_ENTER_TYPE = "key_limitchat_enter_type";

    @NotNull
    public static final String EXT_KEY_LIMIT_CHAT_FROME_TYPE = "key_limitchat_from_type";

    @NotNull
    public static final String EXT_KEY_LIMIT_CHAT_MATCH_PURPOSE = "key_limitchat_match_purpose";

    @NotNull
    public static final String EXT_KEY_LIMIT_CHAT_MATCH_RELATION_SOURCE = "key_limitchat_match_relation_source";

    @NotNull
    public static final String EXT_KEY_LIMIT_CHAT_MATCH_SEX_TYPE = "key_limitchat_match_sex_type";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatUtils$a;", "", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f263510a = new Companion();

        Companion() {
        }
    }

    void addExtendFriendUserInfo(@Nullable BaseQQAppInterface app, @Nullable String toUin, int tagID, @Nullable String tagName, boolean showTopicMsg, int fromType);

    void addFriendConversationNode(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    void addGrayTipsMessage(@Nullable BaseQQAppInterface app, @Nullable String matchUin, int uinType, @Nullable String nickName, @Nullable String tipsString, int tipsID, @Nullable String keyWordString, int actionType, @Nullable MessageRecord lastMessage);

    long addTopicMessage(@Nullable BaseQQAppInterface app, @Nullable vg2.d matchInfo, long msgTime, int from, int uinType);

    boolean bNeedShowLimitChatByAllController(@Nullable BaseQQAppInterface app);

    boolean checkInterceptMatchMessage(@Nullable BaseQQAppInterface app, @Nullable MessageRecord mr5);

    void closeIceBreakingPanel(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    @Nullable
    qq_ad_get.QQAdGet createRequest(long uin, @Nullable String posId, int count, int deepLinkVersion);

    void getExtendFriendSwitch(@Nullable BaseQQAppInterface app, @Nullable Long uin, @Nullable com.tencent.mobileqq.qqexpand.network.d callback);

    boolean getExtendFriendUserSwitch(@Nullable BaseQQAppInterface app);

    @NotNull
    String getExtendFriendUserSwitchText();

    @Nullable
    String getLimitChatOnPlusName(@Nullable BaseQQAppInterface app);

    @Nullable
    String getSessionId(@Nullable String currentAccountUinStr, @Nullable String matchUinStr);

    void handleLimitChatC2CConfirmMsg(@Nullable MessageRecord msgR, @Nullable AppInterface app);

    void handlePreLoadDataForArkMiniProfileCard(@Nullable BaseQQAppInterface app, @Nullable String matchUin, int uinType, boolean createConversationNode, @NotNull Object data);

    void handlePreLoadDataForAvatarProfileCard(@Nullable BaseQQAppInterface app, @Nullable String uin, @NotNull Object data);

    boolean hasMiniProfileCard(@Nullable List<? extends MessageRecord> list);

    boolean hasValidMessage(@Nullable List<? extends MessageRecord> list);

    boolean hasWatchedAdvertise(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    boolean isExtendMatchChatMsg(@Nullable MessageRecord mr5);

    boolean isExtendMatchChatType(int uinType);

    boolean isSystemMessage(int msgType);

    boolean needAddFriendConversationNode(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    void preLoadDataForArkMiniProfileCard(@Nullable BaseQQAppInterface app, @Nullable Long matchUin, @Nullable BusinessObserver extendObserver);

    void preLoadDataForAvatarProfileCard(@Nullable BaseQQAppInterface app, @Nullable Long uin, @Nullable BusinessObserver extendObserver);

    void requestAddMatchedRelation(@Nullable BaseQQAppInterface app, @Nullable String hostUin, @Nullable String friendUin, int matchSourceId);

    void resetMatchChatAIOData(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    void saveTempC2cSignature(@NotNull AppRuntime app, @NotNull String matchUin, @NotNull byte[] signature);

    void setExtendFriendSwitch(@Nullable BaseQQAppInterface app, boolean siwtchOn, @Nullable com.tencent.mobileqq.qqexpand.network.d callback);

    void setExtendFriendUserSwitch(@Nullable BaseQQAppInterface app, boolean switchOn, @NotNull String switchText, long nextTs);

    void startAddFriendActivity(@Nullable Context context, @Nullable String friendUin, @Nullable String friendNick);

    void startExtendFriendCardOnClickAvatar(@Nullable Context context, @Nullable String targetUin, int fromPage);
}
