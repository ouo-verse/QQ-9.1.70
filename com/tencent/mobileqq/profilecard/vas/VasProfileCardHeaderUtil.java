package com.tencent.mobileqq.profilecard.vas;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* loaded from: classes16.dex */
public class VasProfileCardHeaderUtil {
    public static String getFaceId(AppInterface appInterface, String str) {
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "VasProfileCardHeaderUtil");
        if (vasSimpleInfoWithUid == null) {
            return null;
        }
        return String.valueOf(vasSimpleInfoWithUid.faceId);
    }

    public static void goSplendidDetailsPage(AppInterface appInterface, QBaseActivity qBaseActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String faceId = getFaceId(appInterface, str);
        if (TextUtils.isEmpty(faceId)) {
            return;
        }
        String stringDataSet = VasToggle.VAS_SPLENDID_AVATAR_CONFIG.getStringDataSet("jump_url", "");
        if (TextUtils.isEmpty(stringDataSet)) {
            return;
        }
        String replace = stringDataSet.replace("{type}", String.valueOf(((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(str).getAvatarType())).replace("{appId}", "23").replace("{itemId}", faceId).replace("{visitUin}", str);
        Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", replace);
        qBaseActivity.startActivity(intent);
    }
}
