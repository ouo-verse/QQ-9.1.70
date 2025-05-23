package com.tencent.mobileqq.subaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes18.dex */
public interface ISubAccountControllUtil extends QRouteApi {
    void bindRecentItem(AppInterface appInterface, String str, int i3);

    void bindRecentItem(AppInterface appInterface, ArrayList<String> arrayList, int i3);

    Pair<Boolean, Boolean> checkSubAccountLoginStatus(AppInterface appInterface, String str);

    void cleanAllSubAccountMessageUnread(AppInterface appInterface, boolean z16, String str);

    boolean cleanAllThirdQQUnreadMsgNum(AppInterface appInterface);

    void cleanOneSubAccountMessageUnread(AppInterface appInterface, boolean z16, String str, String str2);

    void cleanReqSubAccountSpecialCareListSysTime(AppInterface appInterface);

    boolean cleanThirdQQUnreadMsgNum(AppInterface appInterface, SimpleAccount simpleAccount);

    void clearAllData(AppInterface appInterface, String str);

    void clearSubAccountAssistantTime();

    int getAllSubAccountMsgUnreadNum(AppInterface appInterface, IConversationFacade iConversationFacade);

    int getAllSubAccountTroopMsgUnreadNum(AppInterface appInterface, IConversationFacade iConversationFacade);

    int getAllThirdQQMsgUnreadLastTime(AppInterface appInterface);

    int getLocalThirdUnreadMsgNum(AppInterface appInterface, String str);

    RecentContactData getRecentContactData();

    String getShowName(AppInterface appInterface, SimpleAccount simpleAccount);

    void getSubAccountSpecialCareListFromService(AppInterface appInterface, boolean z16, String str);

    ISubAccountControlService.a getUnreadCount(AppInterface appInterface, String str);

    void initAllData(AppInterface appInterface);

    boolean isAnyAccountBind(AppInterface appInterface);

    boolean isHeadIconLongClickFunc(AppInterface appInterface, boolean z16);

    boolean isRemoveSubUnreadConversationDB();

    boolean isThirdAccountDisplayFunc(AppInterface appInterface, boolean z16);

    boolean loadServerMessage(AppInterface appInterface, String str, boolean z16);

    boolean needShowHintDialog(AppInterface appInterface, String str);

    void onTimeFormatChange(AppInterface appInterface, String str);

    void setBindUinStatus(AppInterface appInterface, byte b16, String str);

    void setBindUinStatus(AppInterface appInterface, byte b16, ArrayList<String> arrayList);

    void setDisplayThirdQQChecked(AppInterface appInterface, boolean z16);

    void setRecentItemSubAccountContentAndUnread(AppInterface appInterface, Context context, RecentItemSubAccount recentItemSubAccount, MsgSummary msgSummary);

    void setTopInRecentList(AppInterface appInterface, String str, boolean z16);

    void showMaxHintDialog(AppRuntime appRuntime, QBaseActivity qBaseActivity);

    boolean startGetThirdQQUnreadNum(AppInterface appInterface, boolean z16);

    void unbindAllRecentItem(AppInterface appInterface, int i3);

    void unbindRecentItem(AppInterface appInterface, String str);

    boolean updateAllThirdQQMsgUnreadLastTime(AppInterface appInterface, int i3);
}
