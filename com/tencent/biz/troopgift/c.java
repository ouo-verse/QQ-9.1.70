package com.tencent.biz.troopgift;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3$ExclusiveGiftItem;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    public static String a(String str) {
        return cl.d(BaseApplication.getContext(), "troop_gift_last_receiver_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + str);
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        String str3 = "troop_gift_last_receiver_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + str;
        cl.j(context, str3, str2);
        if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAioPanelData", 2, "saveLastGiftReceiver, key=" + str3 + ", data=" + str2);
        }
    }

    public static String c(List<oidb_0x6c3$ExclusiveGiftItem> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.put(list.get(i3).gift_id.get());
            }
        }
        return jSONArray.toString();
    }
}
