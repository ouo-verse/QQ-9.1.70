package com.qzone.util;

import android.content.Context;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa {
    private static int a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return 61;
            }
            return 60;
        }
        return 0;
    }

    public static void b(Context context, long j3, String str, int i3, int i16) {
        try {
            AllInOne allInOne = new AllInOne(j3 + "", a(i3));
            if (str != null) {
                allInOne.nickname = str;
            }
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 7);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 71);
            allInOne.profileEntryType = 7;
            ProfileUtils.openProfileCard(BaseApplication.getContext(), allInOne);
        } catch (Error e16) {
            QZLog.e("ProfileCardJumpUtil", "jumpProfileCardFromUserHome fail", e16);
        }
    }
}
