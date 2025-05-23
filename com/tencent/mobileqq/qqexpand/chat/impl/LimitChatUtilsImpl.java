package com.tencent.mobileqq.qqexpand.chat.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.manager.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import tencent.gdt.qq_ad_get;
import vg2.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b_\u0010`J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\\\u0010\u001f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J4\u0010#\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0016J$\u0010%\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!H\u0016J-\u0010)\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016\u00a2\u0006\u0004\b)\u0010*J-\u0010+\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016\u00a2\u0006\u0004\b+\u0010*J-\u0010.\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010&2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016\u00a2\u0006\u0004\b.\u0010/J$\u00101\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\u0006\u00100\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u001c\u00102\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J,\u00107\u001a\u0004\u0018\u0001062\u0006\u0010$\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0016J\u001a\u0010:\u001a\u00020\r2\u0010\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u000108H\u0016J\u0012\u0010;\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010<\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010=\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010B\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010@\u001a\u0004\u0018\u00010\b2\b\u0010A\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010C\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J4\u0010H\u001a\u00020&2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J>\u0010N\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010I\u001a\u0004\u0018\u00010\b2\u0006\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010\b2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u000fH\u0016J\u001a\u0010O\u001a\u00020\r2\u0010\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u000108H\u0016J$\u0010R\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010P\u001a\u0004\u0018\u00010\b2\u0006\u0010Q\u001a\u00020\u000fH\u0016J.\u0010U\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010S\u001a\u0004\u0018\u00010\b2\b\u0010@\u001a\u0004\u0018\u00010\b2\u0006\u0010T\u001a\u00020\u000fH\u0016J \u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020V2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010X\u001a\u00020WH\u0016J\u0012\u0010Z\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010]\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\u0006\u00100\u001a\u00020\r2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020&H\u0016J\b\u0010^\u001a\u00020\bH\u0016\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/impl/LimitChatUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatUtils;", "Lcom/tencent/mobileqq/data/MessageRecord;", "msgR", "Lcom/tencent/common/app/AppInterface;", "app", "", "handleLimitChatC2CConfirmMsg", "", "currentAccountUinStr", "matchUinStr", "getSessionId", "mr", "", "isExtendMatchChatMsg", "", "uinType", "isExtendMatchChatType", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "matchUin", "needAddFriendConversationNode", "addFriendConversationNode", "closeIceBreakingPanel", QQBrowserActivity.KEY_MSG_TYPE, "isSystemMessage", "nickName", "tipsString", "tipsID", "keyWordString", "actionType", "lastMessage", "addGrayTipsMessage", "createConversationNode", "", "data", "handlePreLoadDataForArkMiniProfileCard", "uin", "handlePreLoadDataForAvatarProfileCard", "", "Lcom/tencent/mobileqq/app/BusinessObserver;", "extendObserver", "preLoadDataForArkMiniProfileCard", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/app/BusinessObserver;)V", "preLoadDataForAvatarProfileCard", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "getExtendFriendSwitch", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/qqexpand/network/d;)V", "siwtchOn", "setExtendFriendSwitch", "hasWatchedAdvertise", "posId", "count", "deepLinkVersion", "Ltencent/gdt/qq_ad_get$QQAdGet;", "createRequest", "", "list", "hasValidMessage", "bNeedShowLimitChatByAllController", "getLimitChatOnPlusName", "checkInterceptMatchMessage", "Landroid/content/Context;", "context", "friendUin", "friendNick", "startAddFriendActivity", "resetMatchChatAIOData", "Lvg2/d;", "matchInfo", "msgTime", "from", "addTopicMessage", "toUin", "tagID", "tagName", "showTopicMsg", IProfileCardConst.KEY_FROM_TYPE, "addExtendFriendUserInfo", "hasMiniProfileCard", IProfileProtocolConst.PARAM_TARGET_UIN, "fromPage", "startExtendFriendCardOnClickAvatar", "hostUin", "matchSourceId", "requestAddMatchedRelation", "Lmqq/app/AppRuntime;", "", "signature", "saveTempC2cSignature", "getExtendFriendUserSwitch", "switchText", "nextTs", "setExtendFriendUserSwitch", "getExtendFriendUserSwitchText", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class LimitChatUtilsImpl implements ILimitChatUtils {
    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void addExtendFriendUserInfo(BaseQQAppInterface app, String toUin, int tagID, String tagName, boolean showTopicMsg, int fromType) {
        LimitChatUtil.c(app, toUin, tagID, tagName, showTopicMsg, fromType);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void addFriendConversationNode(BaseQQAppInterface app, String matchUin) {
        LimitChatUtil.d(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void addGrayTipsMessage(BaseQQAppInterface app, String matchUin, int uinType, String nickName, String tipsString, int tipsID, String keyWordString, int actionType, MessageRecord lastMessage) {
        LimitChatUtil.e(app, matchUin, uinType, nickName, tipsString, tipsID, keyWordString, actionType, lastMessage);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public long addTopicMessage(BaseQQAppInterface app, d matchInfo, long msgTime, int from, int uinType) {
        return LimitChatUtil.g(app, matchInfo, msgTime, from, uinType);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean bNeedShowLimitChatByAllController(BaseQQAppInterface app) {
        return LimitChatUtil.h(app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean checkInterceptMatchMessage(BaseQQAppInterface app, MessageRecord mr5) {
        return LimitChatUtil.j(app, mr5);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void closeIceBreakingPanel(BaseQQAppInterface app, String matchUin) {
        LimitChatUtil.k(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public qq_ad_get.QQAdGet createRequest(long uin, String posId, int count, int deepLinkVersion) {
        return LimitChatUtil.l(uin, posId, count, deepLinkVersion);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void getExtendFriendSwitch(BaseQQAppInterface app, Long uin, com.tencent.mobileqq.qqexpand.network.d callback) {
        LimitChatUtil.s(app, uin, callback);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean getExtendFriendUserSwitch(BaseQQAppInterface app) {
        return LimitChatUtil.v(app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public String getExtendFriendUserSwitchText() {
        String u16 = LimitChatUtil.u();
        Intrinsics.checkNotNullExpressionValue(u16, "getExtendFriendSwitchText()");
        return u16;
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public String getLimitChatOnPlusName(BaseQQAppInterface app) {
        return LimitChatUtil.w(app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public String getSessionId(String currentAccountUinStr, String matchUinStr) {
        return LimitChatUtil.A(currentAccountUinStr, matchUinStr);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void handleLimitChatC2CConfirmMsg(MessageRecord msgR, AppInterface app) {
        LimitChatUtil.C(msgR, app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void handlePreLoadDataForArkMiniProfileCard(BaseQQAppInterface app, String matchUin, int uinType, boolean createConversationNode, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LimitChatUtil.D(app, matchUin, uinType, createConversationNode, data);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void handlePreLoadDataForAvatarProfileCard(BaseQQAppInterface app, String uin, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LimitChatUtil.E(app, uin, data);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean hasMiniProfileCard(List<? extends MessageRecord> list) {
        return LimitChatUtil.F(list);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean hasValidMessage(List<? extends MessageRecord> list) {
        return LimitChatUtil.G(list);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean hasWatchedAdvertise(BaseQQAppInterface app, String matchUin) {
        return LimitChatUtil.H(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean isExtendMatchChatMsg(MessageRecord mr5) {
        return LimitChatUtil.L(mr5);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean isExtendMatchChatType(int uinType) {
        return LimitChatUtil.M(uinType);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean isSystemMessage(int msgType) {
        return LimitChatUtil.R(msgType);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public boolean needAddFriendConversationNode(BaseQQAppInterface app, String matchUin) {
        return LimitChatUtil.V(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void preLoadDataForArkMiniProfileCard(BaseQQAppInterface app, Long matchUin, BusinessObserver extendObserver) {
        LimitChatUtil.X(app, matchUin, extendObserver);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void preLoadDataForAvatarProfileCard(BaseQQAppInterface app, Long uin, BusinessObserver extendObserver) {
        LimitChatUtil.Y(app, uin, extendObserver);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void requestAddMatchedRelation(BaseQQAppInterface app, String hostUin, String friendUin, int matchSourceId) {
        LimitChatUtil.f(app, hostUin, friendUin, matchSourceId);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void resetMatchChatAIOData(BaseQQAppInterface app, String matchUin) {
        LimitChatUtil.Z(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void saveTempC2cSignature(AppRuntime app, String matchUin, byte[] signature) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(matchUin, "matchUin");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Manager manager = app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager");
        ((c) manager).y(matchUin, app.getCurrentAccountUin(), signature);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void setExtendFriendSwitch(BaseQQAppInterface app, boolean siwtchOn, com.tencent.mobileqq.qqexpand.network.d callback) {
        LimitChatUtil.b0(app, siwtchOn, callback);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void setExtendFriendUserSwitch(BaseQQAppInterface app, boolean siwtchOn, String switchText, long nextTs) {
        Intrinsics.checkNotNullParameter(switchText, "switchText");
        LimitChatUtil.c0(app, siwtchOn, switchText, nextTs);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void startAddFriendActivity(Context context, String friendUin, String friendNick) {
        LimitChatUtil.e0(context, friendUin, friendNick);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
    public void startExtendFriendCardOnClickAvatar(Context context, String targetUin, int fromPage) {
        LimitChatUtil.f0(context, targetUin, fromPage);
    }
}
