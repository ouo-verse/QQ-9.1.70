package com.tencent.mobileqq.zplan.friend;

import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin,appid")
/* loaded from: classes21.dex */
public class ForwardZPlanUserList extends Entity {
    public static final long EXPIRED_TIME = 120000;
    private static final String TAG = "ForwardZPlanUserList";
    public String appid;
    public String forwardListJsonString;
    public String uin;
    public long updateTimestamp;

    public ForwardZPlanUserList() {
    }

    private static ForwardZPlanUserList find(EntityManager entityManager, String str, String str2) {
        if (entityManager != null && entityManager.isOpen()) {
            return (ForwardZPlanUserList) DBMethodProxy.find(entityManager, ForwardZPlanUserList.class, "uin = ? and appid = ?", new String[]{str, str2});
        }
        return null;
    }

    public static List<String> getForwardList(String str) {
        int i3;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("forwardList");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                i3 = optJSONArray.length();
            } else {
                i3 = 0;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList.add(optJSONArray.getString(i16));
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getForwardListJsonString error", e16);
            return null;
        }
    }

    private static String getForwardListJsonString(List<String> list) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                jSONArray.mo162put(list.get(i16));
            }
            jSONObject.put("forwardList", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getForwardListJsonString error", e16);
            return null;
        }
    }

    public static List<String> readFromDB(EntityManager entityManager, String str, String str2) {
        ForwardZPlanUserList find = find(entityManager, str, str2);
        if (find != null && !TextUtils.isEmpty(find.forwardListJsonString) && System.currentTimeMillis() - find.updateTimestamp < 120000) {
            return getForwardList(find.forwardListJsonString);
        }
        return null;
    }

    public static void removeFromDB(EntityManager entityManager, String str, String str2) {
        if (entityManager.isOpen()) {
            entityManager.remove(find(entityManager, str, str2));
        }
    }

    public static void updateDB(EntityManager entityManager, String str, String str2, List<String> list) {
        ForwardZPlanUserList find = find(entityManager, str, str2);
        if (find == null) {
            find = new ForwardZPlanUserList(str, str2);
        }
        find.forwardListJsonString = getForwardListJsonString(list);
        find.updateTimestamp = System.currentTimeMillis();
        if (entityManager.isOpen()) {
            if (find.getStatus() == 1000) {
                entityManager.persistOrReplace(find);
            } else if (find.getStatus() == 1001 || find.getStatus() == 1002) {
                entityManager.update(find);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + find.getTableName());
        }
    }

    public String toString() {
        return "ForwardZPlanUserList{uin=" + this.uin + ", appid=" + this.appid + ", forwardListJsonString=" + this.forwardListJsonString + ", updateTimestamp=" + this.updateTimestamp + '}';
    }

    public ForwardZPlanUserList(String str, String str2) {
        this.uin = str;
        this.appid = str2;
    }
}
