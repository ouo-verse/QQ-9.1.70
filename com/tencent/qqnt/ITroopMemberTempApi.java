package com.tencent.qqnt;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Pair;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ITroopMemberTempApi extends QRouteApi {
    void clearNoFriendRemarkCache();

    void deleteTroopMemberCache(String str, String str2);

    String getNoFriendRemark(String str);

    Object getTroopMemberInfoSync(String str, String str2, String str3);

    @Deprecated(since = "\u540c\u6b65\u8c03\u7528\u4e0d\u4e00\u5b9a\u6709\u503c\uff0c\u5efa\u8bae\u4f7f\u7528[IRelationNTUinAndUidApi]")
    String getTroopMemberUidSync(String str);

    void preloadNoFriendRemark(ArrayList<Pair<String, String>> arrayList);
}
