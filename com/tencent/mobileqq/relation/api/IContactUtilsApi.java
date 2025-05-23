package com.tencent.mobileqq.relation.api;

import android.os.Bundle;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IContactUtilsApi extends QRouteApi {
    String getBuddyName(String str, boolean z16);

    String getDateNickName(String str);

    String getDiscussionMemberShowName(String str, String str2);

    String getFriendName(String str);

    String getFriendShowName(String str);

    String getGrayBarShowName(String str, String str2);

    String getStatusName(Friends friends);

    String getStatusName(c cVar);

    String getTroopNickName(String str, String str2, String str3, boolean z16, Bundle bundle);

    boolean isContactShown();

    boolean isSelfNetworkStatusVisible(Friends friends);

    boolean isSelfNetworkStatusVisible(c cVar);
}
