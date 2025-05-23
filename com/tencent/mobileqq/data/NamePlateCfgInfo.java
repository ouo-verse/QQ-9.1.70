package com.tencent.mobileqq.data;

import MQQ.ItemCfgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class NamePlateCfgInfo {
    public static JSONObject converItem2JsonObject(ItemCfgInfo itemCfgInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate converItem2JsonObject");
        }
        if (itemCfgInfo != null && itemCfgInfo.itemJumUrl != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                HashMap hashMap = new HashMap();
                for (Map.Entry<Long, String> entry : itemCfgInfo.itemJumUrl.entrySet()) {
                    hashMap.put(String.valueOf(entry.getKey().longValue()), entry.getValue());
                }
                jSONObject.put("vipType", itemCfgInfo.vipType);
                jSONObject.put("itemJumUrl", new JSONObject(hashMap));
                return jSONObject;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("QVIP.NamePlateCfgInfo", 1, "converItem2JsonObject exception message = " + e16.getMessage());
            }
        }
        return null;
    }

    public static String convert2Json(ArrayList<ItemCfgInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ItemCfgInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject converItem2JsonObject = converItem2JsonObject(it.next());
                if (converItem2JsonObject != null) {
                    jSONArray.mo162put(converItem2JsonObject);
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    public static String getCfgJumpUrl(int i3, long j3, String str) {
        Map<Long, String> map;
        if (QLog.isColorLevel()) {
            QLog.i("QVIP.NamePlateCfgInfo", 2, "getCfgJumpUrl type = " + i3 + " nameplateId = " + j3 + " json = \n" + str);
        }
        ArrayList<ItemCfgInfo> parseJsonArray2List = parseJsonArray2List(str);
        if (parseJsonArray2List == null) {
            return null;
        }
        Iterator<ItemCfgInfo> it = parseJsonArray2List.iterator();
        while (it.hasNext()) {
            ItemCfgInfo next = it.next();
            if (next != null && next.vipType == i3 && (map = next.itemJumUrl) != null) {
                for (Map.Entry<Long, String> entry : map.entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getKey().longValue() == j3) {
                        return entry.getValue();
                    }
                }
            }
        }
        return null;
    }

    public static String getVipNamePlateCfgInfo(AppRuntime appRuntime, String str) {
        Friends v3;
        FriendsManager friendsManager = (FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager != null && (v3 = friendsManager.v(str)) != null) {
            return v3.nameplateCfgInfo;
        }
        return null;
    }

    public static String getVipNamePlateJumUrl(AppRuntime appRuntime, String str, int i3, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("QVIP.NamePlateCfgInfo", 2, "getVipNamePlateJumUrl");
        }
        String vipNamePlateCfgInfo = getVipNamePlateCfgInfo(appRuntime, str);
        if (!TextUtils.isEmpty(vipNamePlateCfgInfo)) {
            return getCfgJumpUrl(i3, j3, vipNamePlateCfgInfo);
        }
        return null;
    }

    public static Map<Long, String> parseJson2Map(String str) {
        Map<String, Object> c16;
        if (TextUtils.isEmpty(str) || (c16 = cooperation.vip.b.c(str)) == null) {
            return null;
        }
        HashMap hashMap = new HashMap(c16.size());
        for (Map.Entry<String, Object> entry : c16.entrySet()) {
            if (entry != null) {
                hashMap.put(Long.valueOf(Long.parseLong(entry.getKey())), (String) entry.getValue());
            }
        }
        return hashMap;
    }

    public static ArrayList<ItemCfgInfo> parseJsonArray2List(String str) {
        ItemCfgInfo parseJsonObject2Item;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList<ItemCfgInfo> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && (parseJsonObject2Item = parseJsonObject2Item(optJSONObject.toString())) != null) {
                    arrayList.add(parseJsonObject2Item);
                }
            }
            return arrayList;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QVIP.NamePlateCfgInfo", 1, "parseJsonArray2List exception message = " + e16.getMessage());
            return null;
        }
    }

    public static ItemCfgInfo parseJsonObject2Item(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ItemCfgInfo itemCfgInfo = new ItemCfgInfo();
            itemCfgInfo.vipType = jSONObject.optInt("vipType");
            itemCfgInfo.itemJumUrl = parseJson2Map(jSONObject.optString("itemJumUrl"));
            return itemCfgInfo;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QVIP.NamePlateCfgInfo", 1, "parseJsonObject2Item exception message = " + e16.getMessage());
            return null;
        }
    }

    public static void vipNamePlateClickReport(AppRuntime appRuntime, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate vipNamePlateClickReport namePlateId = " + j3);
        }
        ReportController.o(appRuntime, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A59C", (int) j3, 0, "", "", "", "");
    }
}
