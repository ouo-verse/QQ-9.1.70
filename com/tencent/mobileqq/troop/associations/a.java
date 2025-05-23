package com.tencent.mobileqq.troop.associations;

import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context, AssociatedTroopItem associatedTroopItem) {
        if (context != null && associatedTroopItem != null) {
            String format = String.format("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=%s&subsource_id=12001", associatedTroopItem.uin);
            Intent intent = new Intent(context, (Class<?>) JoinGroupTransitActivity.class);
            intent.putExtra("source_scheme", format);
            context.startActivity(intent);
        }
    }

    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            String replace = "https://qun.qq.com/v2/associate/index?gc=$GC&_wv=16777216&cwv=1&_wwv=128".replace("$GC", str);
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", replace);
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 4);
            }
        }
    }

    public static void c(Context context, AssociatedTroopItem associatedTroopItem) {
        if (context != null && associatedTroopItem != null) {
            GroupInfo groupInfo = new GroupInfo();
            boolean z16 = true;
            try {
                groupInfo.lCode = Long.valueOf(associatedTroopItem.uin).longValue();
                groupInfo.strName = associatedTroopItem.name;
                groupInfo.strIntro = associatedTroopItem.intro;
                groupInfo.iMemberCnt = associatedTroopItem.memberNum;
                ArrayList<GroupLabel> arrayList = associatedTroopItem.labelList;
                if (arrayList != null) {
                    groupInfo.labels = arrayList;
                }
                groupInfo.strJoinSig = associatedTroopItem.joinAuth;
                if (associatedTroopItem.privilege == 3) {
                    z16 = false;
                }
                TroopUtils.I(context, TroopUtils.k(116, groupInfo, 12001, z16), 2);
            } catch (Exception unused) {
                QLog.d("TroopAssociationsUtil", 1, "cast string2long error");
            }
        }
    }
}
