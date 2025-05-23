package com.tencent.mobileqq.vas.troopkeyword;

import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ExpireSet extends HashSet<Long> {
    public static ExpireSet fromJson(String str) {
        ExpireSet expireSet = new ExpireSet();
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    expireSet.add(Long.valueOf(jSONArray.getLong(i3)));
                }
            } catch (JSONException e16) {
                QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "fromJson: ", e16);
            }
        }
        return expireSet;
    }

    public String toJson() {
        JSONArray jSONArray = new JSONArray();
        Iterator<Long> it = iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        return jSONArray.toString();
    }
}
