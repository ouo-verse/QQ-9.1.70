package com.tencent.mobileqq.newfriend.api;

import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.newfriend.msg.c;
import com.tencent.mobileqq.newfriend.msg.i;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import mqq.app.api.IRuntimeService;
import nb2.a;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface INewFriendService extends IRuntimeService {
    void addListener(a aVar);

    void addObserver(Observer observer);

    void clearAllSysSuspiciousMsg();

    void deleteObserver(Observer observer);

    void deleteSysSuspiciousMsg(long j3);

    List<SysSuspiciousMsg> getAllSysSuspiciousMsg();

    int getAllUnreadMessageCount();

    List<Object> getAllUnreadMsg();

    com.tencent.mobileqq.newfriend.config.a getConfBean();

    i getLastUnreadNewFriendMessage();

    ArrayList<i> getMixedNewFriendDatas();

    void getUnreadMessageCountAsync();

    int getUnreadSystemMessageCount();

    boolean handleNewFrdAIOShow(int i3, String str);

    void handleQIMNewFollower(QIMFollwerAdd qIMFollwerAdd);

    void initNewFriendList();

    void insertCommonHobbyForAIOShowNewsMsg(String str, String str2);

    void insertFriendFeedForAIOShowNewsMsg(String str, String str2);

    boolean isFirstEnterNewFriendAio(String str);

    boolean isNewFriend(String str);

    void loadNewFriendMsg(boolean z16);

    void markAllDataReaded();

    void markSystemMsgReaded();

    boolean needShowAvatar();

    void reSetLastSysMsgTotalCount(int i3);

    void refreshContactUnreadCount();

    void refreshNotificationWithFriendSystemMessage(c cVar);

    void reloadNewFriendMsg();

    void removeListener(a aVar);

    void saveNewFriend2Cache(String str);

    void setSysSuspiciousUnreadNum(int i3);

    void updateBindContactGuideState();

    void updateSuspiciousMsgListFromServer(ArrayList<SysSuspiciousMsg> arrayList, boolean z16);
}
