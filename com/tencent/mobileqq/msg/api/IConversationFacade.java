package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.List;
import java.util.Set;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface IConversationFacade extends IRuntimeService {
    void addNewSayHelloToSet(int i3, String str);

    void addUnread(List<MessageRecord> list);

    void cleanUnread(String str, int i3, long j3, boolean z16);

    void cleanUnread(String str, int i3, long j3, boolean z16, boolean z17);

    void cleanUnread(String str, int i3, long j3, boolean z16, boolean z17, int i16);

    void cleanUnreadFrom(String str, int i3, long j3);

    void decreaseUnread(String str, int i3, MessageRecord messageRecord);

    void decreaseUnreads(String str, int i3, List<MessageRecord> list);

    ConversationInfo getConversationInfo(String str, int i3);

    Set<ConversationInfo> getConversationInfoSet();

    long getLastRead(String str, int i3);

    int getPublicAccountConversationRedMask(String str, int i3);

    int getReadUnreadCount(String str, int i3);

    int getReadUnreadMark(String str, int i3);

    ConversationInfo getTinyConvInfo(String str, int i3);

    GroupMsgMask getTroopMask(String str);

    int getUnreadCount(String str, int i3);

    int getUnreadCountConfess(String str, int i3, int i16);

    int getUnreadCountFromExtInt2(String str, int i3);

    void increaseUnread(String str, int i3, int i16);

    boolean isInMsgBox(String str, int i3);

    boolean isInMsgBox(String str, int i3, String str2);

    boolean isSyncMsgFinish();

    boolean isUinInRecentList(String str, int i3);

    boolean isUinInRecentNotSubAccount(String str);

    void moveBoxToMessageTab(String str, int i3, String str2, int i16);

    void removeUnreadItem(String str, int i3);

    void setSubAccountTroopUnReadMsg(String str, int i3, int i16);

    void setUnreadMark(String str, int i3, int i16);

    void updateLastRead(String str, int i3, long j3);

    void updateTroopGuildUnreadCount(String str, int i3, int i16);
}
