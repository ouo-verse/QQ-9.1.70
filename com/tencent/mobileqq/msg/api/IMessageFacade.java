package com.tencent.mobileqq.msg.api;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ak;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import ed1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes15.dex */
public interface IMessageFacade extends IRuntimeService {
    void addAIOHeadMessage(String str, int i3, List<MessageRecord> list);

    void addMessage(MessageRecord messageRecord, String str);

    void addMessage(MessageRecord messageRecord, String str, boolean z16, boolean z17, boolean z18, boolean z19);

    void addMessage(ArrayList<MessageRecord> arrayList, String str, boolean z16);

    void addMessage(ArrayList<MessageRecord> arrayList, String str, boolean z16, boolean z17);

    void addMessage(ArrayList<MessageRecord> arrayList, String str, boolean z16, boolean z17, boolean z18);

    void addMessage(List<MessageRecord> list, String str);

    void addMessage(List<MessageRecord> list, String str, boolean z16);

    void addObserver(Observer observer);

    void cancelNotificationWhenRevokeMessage(MessageRecord messageRecord);

    int clearHistory(String str, int i3);

    int clearHistory(String str, int i3, boolean z16, boolean z17);

    void clearInAioParallerPullMsgMark(String str, long j3, long j16);

    void clearTransFileInfo(String str);

    MessageRecord constructMessageForText(String str, String str2, String str3, int i3);

    void decodeMsg(MessageRecord messageRecord);

    void deleteObserver(Observer observer);

    void dumpmsgs(String str, Collection<MessageRecord> collection);

    MessageRecord findLongMsgHead(MessageRecord messageRecord);

    List<MessageRecord> getAIOList(String str, int i3);

    List<ChatMessage> getAIOList(String str, int i3, long j3);

    List<MessageRecord> getAllMessages(String str, int i3, int[] iArr);

    ConcurrentHashMap<String, Boolean> getAutoPullCache();

    Map<String, Message> getCachedMsg();

    String getCurrChatUin();

    DraftSummaryInfo getDraftSummaryInfo(String str, int i3);

    Handler getFacadeHandler();

    Message getFirstUnreadMessage(String str, int i3);

    Message getIncomingMsg();

    int getIsLastMsgCacheLazyLoad();

    boolean getIsLastMsgCacheLoaded();

    Message getLastMessage(String str, int i3);

    Message getLastMessage(String str, int i3, int i16);

    MessageRecord getLastMsgForMsgTab(String str, int i3);

    MessageRecord getLastMsgForMsgTabWithAutoInit(String str, int i3);

    List<MessageRecord> getMessages(String str, int i3, int i16);

    MessageRecord getMsgItemByUniseq(String str, int i3, long j3);

    List<MessageRecord> getMsgList(String str, int i3);

    long getMsgUinSeq(MessageRecord messageRecord);

    <T> List<T> getPBMsgElemsDecoders();

    ConcurrentHashMap<Integer, List<MessageRecord>> getPullCache();

    AtomicInteger getPullCounter();

    Object getQQMessageFacadeStub();

    int getQuickDBMsgCount(String str, long j3, long j16, boolean z16);

    List<MessageRecord> getQuickDbMessage(String str, String str2);

    Map<String, Boolean> getRefreshActionMap();

    ak getRegistry();

    int getRoutingType(int i3);

    MessageRecord getSendingTroopMsgItem(String str, int i3, MessageRecord messageRecord);

    MessageRecord getSendingTroopMsgItem(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list);

    int getSlowDBMsgCount(String str, long j3, long j16, boolean z16);

    List<MessageRecord> getSlowDbMessage(String str, String str2);

    String getSqlStr(String str, long j3, long j16, long j17, int i3, boolean z16);

    c getTinyIdCache();

    int getUinType(int i3);

    int getUnreadMsgsNum();

    void handleReceivedMessage(int i3, boolean z16, boolean z17);

    void handleReceivedMessage(int i3, boolean z16, boolean z17, Message message);

    void handleRefreshMessageListHeadResult(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle);

    void handleRevokedNotifyAndNotify(ArrayList<RevokeMsgInfo> arrayList, boolean z16);

    boolean isChatting();

    boolean isMessageForText(MessageRecord messageRecord);

    boolean isTheLastTabMsg(MessageRecord messageRecord);

    boolean pullRecentGroupMsg(String str);

    void putAioInParallelPullMsgMark(String str, long j3, long j16);

    void qLogColor(String str, String str2);

    List<MessageRecord> queryMsgItemByShmsgseq(String str, int i3, long j3, long j16);

    MessageRecord queryMsgItemByUniseq(String str, int i3, long j3);

    void removeMsgByMessageRecord(MessageRecord messageRecord, boolean z16);

    void removeMsgByUniseq(String str, int i3, long j3);

    void removeMsgByUniseq(String str, int i3, long j3, boolean z16);

    boolean removeMsgFromCacheByUniseq(String str, int i3, int i16, long j3);

    void removeNotification(String str, int i3);

    void removeRecentUser(RecentUser recentUser);

    void sendMessage(MessageRecord messageRecord, BaseMessageObserver baseMessageObserver);

    boolean setAutoPullC2CMsgResult(String str, int i3, List<MessageRecord> list, boolean z16);

    void setChangeAndNotify(Object obj);

    void setIncomingMsg(MessageRecord messageRecord);

    void setReadFrom(String str, int i3, long j3);

    void setReadFrom(String str, int i3, long j3, boolean z16);

    void setReaded(String str, int i3);

    void setReaded(String str, int i3, boolean z16, boolean z17);

    boolean setRoutingHead(AppInterface appInterface, int i3, Object obj, Object obj2);

    void stopHttpProcessorIfNeed(MessageRecord messageRecord);

    void updateGroupMsgSeqAndTimeByUniseq(String str, int i3, long j3, long j16, long j17);

    void updateMsgContentByUniseq(String str, int i3, long j3, byte[] bArr);

    void updateMsgFieldByUniseq(String str, int i3, long j3, String str2, Object obj);
}
