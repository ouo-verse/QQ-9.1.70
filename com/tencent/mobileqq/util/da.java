package com.tencent.mobileqq.util;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.UndeciedPersonRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xc26$UndecidePerson;

/* compiled from: P */
/* loaded from: classes20.dex */
public class da {
    public static void a(QQAppInterface qQAppInterface, List<oidb_0xc26$UndecidePerson> list, int i3) {
        ArrayList<UndeciedPersonRecommend> covServerVerifyUndeciedDataToLocal = MayKnowRecommend.covServerVerifyUndeciedDataToLocal(list, i3, 23);
        if (QLog.isDebugVersion()) {
            QLog.d("UndeciedPersonUtil", 4, "undeciedPersonRecommends size is " + covServerVerifyUndeciedDataToLocal.size() + " !");
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("mayknow_friend_verify" + qQAppInterface.getAccount(), 4).edit();
        edit.clear();
        Gson gson = new Gson();
        for (int i16 = 0; i16 < covServerVerifyUndeciedDataToLocal.size(); i16++) {
            edit.putString(String.valueOf(i16), gson.toJson(covServerVerifyUndeciedDataToLocal.get(i16), UndeciedPersonRecommend.class));
        }
        edit.commit();
    }
}
