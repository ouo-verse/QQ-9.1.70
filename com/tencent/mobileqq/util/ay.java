package com.tencent.mobileqq.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ay {
    public static Map<String, String> a(ArrayList<String> arrayList) {
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null && !arrayList.isEmpty()) {
            return b16.getBuddyRemark(arrayList);
        }
        return null;
    }

    public static String b(String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(uidFromUin);
        Map<String, String> a16 = a(arrayList);
        if (a16 != null && a16.containsKey(uidFromUin)) {
            return a16.get(uidFromUin);
        }
        return "";
    }
}
