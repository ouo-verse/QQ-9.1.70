package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
    }

    public static String a(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return str;
        }
        d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "OlympicShareHelper");
        if (friendsSimpleInfoWithUid != null) {
            return friendsSimpleInfoWithUid.m();
        }
        return str;
    }

    public static String b(long j3) {
        int c16 = c(j3);
        if (c16 != 2) {
            if (c16 != 3) {
                return "share/1/";
            }
            return "share/3/";
        }
        return "share/2/";
    }

    public static int c(long j3) {
        if (j3 <= 1000000) {
            return 1;
        }
        if (j3 <= 10000000) {
            return 2;
        }
        return 3;
    }

    public static boolean d(String str) {
        try {
            if (!new File(str).exists()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e(long j3, Activity activity, AppInterface appInterface, a aVar) {
    }
}
