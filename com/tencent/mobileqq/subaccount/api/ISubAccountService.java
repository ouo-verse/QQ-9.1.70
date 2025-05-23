package com.tencent.mobileqq.subaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.message.a;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface ISubAccountService extends IRuntimeService {
    public static final int TYPE_INIT = 0;
    public static final int TYPE_NEW_MSG = 1;
    public static final int TYPE_REMOVE_MSG = 2;

    void addNewMessage(SubAccountMessage subAccountMessage);

    void cancelHintIsNew(String str);

    void clearAllUnNotifySenderNum();

    void clearUnreadNum(String str);

    void countUnreadDatum(SubAccountInfo subAccountInfo, ArrayList<SubAccountMessage> arrayList, int i3);

    a createSubAccountMessageProcessor(AppInterface appInterface, BaseMessageHandler baseMessageHandler);

    SubAccountMessage findSubAccountMessage(String str, String str2);

    String getA2(String str);

    long getActionTime(String str);

    List<SubAccountMessage> getAllMessage(String str);

    ArrayList<SubAccountInfo> getAllSubAccountInfo();

    ArrayList<String> getAllSubUin();

    int getBindedNumber();

    byte[] getCookie(String str);

    CharSequence getLatestMsg(String str);

    String getLatestUin(String str);

    String getLatestUinNick(String str);

    HashMap<String, ArrayList<SubAccountMessage>> getMapSubMsg();

    boolean getNotifySwitch();

    Pair<Integer, String> getServerError(String str);

    int getStatus(String str);

    SubAccountInfo getSubAccountInfo(String str);

    int getUnNotifySenderNum(String str);

    int getUnreadAllMsgNum(String str);

    int getUnreadAllTroopMsgNum(String str);

    int getUnreadSenderNum(String str);

    boolean hintIsNew(String str);

    boolean isRecentListTop(String str);

    boolean isSubAccountUin(String str);

    void removeAllMessage();

    void removeAllMessage(String str);

    void removeAllSubAccount();

    int removeMessage(String str, String str2);

    void removeSubAccountInfo(String str);

    void saveSubAccountInfo(SubAccountInfo subAccountInfo);

    void setActionTime(String str, long j3);

    void setAllMessageReaded(String str);

    void setNotifySwitch(boolean z16);

    void setRecentListTop(String str, boolean z16);

    boolean setStatus(String str, int i3);

    void updateA2(String str, String str2, boolean z16);

    void updateCookie(String str, byte[] bArr);

    void updateMsgData2SupportSubUin(String str);

    void updateMsgTimeStr(String str);

    void updateNotifySwitch(AppInterface appInterface);

    void updateServerError(String str, int i3, String str2);

    void updateSubAccountInfo(com.tencent.mobileqq.subaccount.logic.a aVar);

    void updateTroopMsgRedDot(SubAccountMessage subAccountMessage);

    void updateUnreadNum(AppInterface appInterface, String str, String str2, int i3);
}
