package com.tencent.mobileqq.activity.recent.msgbox.api;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b;
import com.tencent.mobileqq.activity.recent.msgbox.c;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ITempMsgBoxService extends QRouteApi {
    void addNicknameToVideoMsg(int i3, String str, MsgSummary msgSummary);

    int getAllFilterMsgUnreadNumOfQCall(AppInterface appInterface, Message message);

    HashMap<String, b> getBusinessHandlerMap();

    Map<Integer, String> getBusinessStringMap();

    c getCallback();

    List<RecentUser> getFilterBoxRecentUsers(AppInterface appInterface);

    String getFilterMsgBoxHandlerName();

    Map<Integer, Integer> getServiceIdMap();

    Map<Integer, Integer> getSummaryTextMap();

    int getTempMsgBoxUnread(AppInterface appInterface);

    int getTempSettingStatus(boolean z16, boolean z17);

    ArrayList<Integer> getTempUinTypeList();

    String getTitleName(AppInterface appInterface, RecentUser recentUser);

    long getUpdateTime();

    ConversationInfo onGetUnreadCount(ConversationInfo conversationInfo);

    void removeFilterBoxIfNecessary(AppInterface appInterface, boolean z16);

    void removeMsgBoxIfNecessary(AppInterface appInterface, boolean z16);

    void reportTempMsgBoxExposure(AppInterface appInterface, Object obj);

    void saveUpdateTime(long j3);
}
