package com.tencent.mobileqq.matchfriend.api;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendChatApi extends QRouteApi {
    void deleteAllRecentContact();

    void deleteUnusedMatchFriendChatDB();

    void doWhenQQLogout();

    h getAIOSigHelper();

    int getEntryVisibleUnreadCount();

    String getFriendOpenId();

    h getLittleAssistantHelper();

    String getMatchFriendOfficialMessageSourceType(MessageRecord messageRecord);

    String getNotificationContent();

    Intent getNotificationIntent(Context context, String str);

    String getNotificationTitle();

    h getQQStrangerInteractiveMarkHelper();

    String getSelfOpenId();

    int getUnreadNum();

    boolean isFirstEnterSession(String str);

    boolean isNeedForbidNotification();

    void matchFriendOfficialMessageReport(Context context, String str, String str2);

    List<Pair<String, String>> parseMatchFriendQQText(String str);

    String parseMatchFriendUrl(String str);

    void reportQuoteExpExposure(int i3);

    void setFlagFirstEnterSession(String str, boolean z16);

    void setFriendOpenId(String str);
}
