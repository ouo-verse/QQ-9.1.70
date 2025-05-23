package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandConversation {
    public boolean isMySendMsg;
    public MatchedInfo matchInfo;
    public long msgSeq;
    public int msgStatus;
    public String msgSummary;
    public int msgType;
    public String nickName;
    public String peerUin;
    public String selfUin;
    public long time;
    public int uinType;
    public int unreadNum;

    public static ExpandConversation convert2Con(RecentMatchChatListItem recentMatchChatListItem) {
        ExpandConversation expandConversation = new ExpandConversation();
        expandConversation.peerUin = recentMatchChatListItem.getRecentUserUin();
        expandConversation.uinType = recentMatchChatListItem.getRecentUserType();
        expandConversation.nickName = recentMatchChatListItem.mTitleName;
        expandConversation.unreadNum = recentMatchChatListItem.mUnreadNum;
        expandConversation.msgType = recentMatchChatListItem.messageRecord.msgtype;
        expandConversation.time = recentMatchChatListItem.getLastMsgTime();
        expandConversation.msgStatus = c.a(recentMatchChatListItem);
        expandConversation.isMySendMsg = recentMatchChatListItem.messageRecord.isSelf();
        expandConversation.msgSeq = recentMatchChatListItem.messageRecord.msgseq;
        expandConversation.msgSummary = getLastMsg(recentMatchChatListItem);
        MatchedInfo matchedInfo = new MatchedInfo();
        if (recentMatchChatListItem.getRecentUserType() == 1045) {
            matchedInfo.matchSrcDes = "\u6696\u8bf4\u8bf4";
        } else {
            AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
            QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
            if (qQAppInterface != null) {
                matchedInfo.matchSrcDes = ExpandFriendData.getMatchSrcDes(qQAppInterface, expandConversation.peerUin);
            }
        }
        expandConversation.matchInfo = matchedInfo;
        return expandConversation;
    }

    private static String getLastMsg(RecentMatchChatListItem recentMatchChatListItem) {
        String charSequence = recentMatchChatListItem.mLastMsg.toString();
        int a16 = c.a(recentMatchChatListItem);
        if (a16 == 3) {
            charSequence = charSequence.replaceFirst(MsgSummary.STR_FAILED, "");
        } else if (a16 == 2) {
            charSequence = charSequence.replaceFirst(MsgSummary.STR_SENDING, "");
        }
        String a17 = b.a(charSequence);
        StringBuilder sb5 = new StringBuilder();
        Object obj = recentMatchChatListItem.mMsgExtroInfo;
        sb5.append(obj != null ? obj : "");
        sb5.append(a17);
        return sb5.toString();
    }

    public String toString() {
        return "ExpandConversation{selfUin='" + this.selfUin + "', peerUin='" + this.peerUin + "', nickName='" + this.nickName + "', isMySendMsg=" + this.isMySendMsg + ", uinType=" + this.uinType + ", msgType=" + this.msgType + ", msgSeq=" + this.msgSeq + ", time=" + this.time + ", msgStatus=" + this.msgStatus + ", unreadNum=" + this.unreadNum + ", msgSummary='" + this.msgSummary + "', matchInfo=" + this.matchInfo + '}';
    }
}
