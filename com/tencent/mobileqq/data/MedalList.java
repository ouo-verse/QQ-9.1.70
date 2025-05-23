package com.tencent.mobileqq.data;

import MQQ.VipMedalList;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MedalList {
    public ArrayList<Info> infoList = new ArrayList<>();
    public String jumpUrl;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Info {
        public boolean isClose = true;
        public int isRemind;
        public int tipsTimes;
        public int type;
        public String value;

        public String toString() {
            return "Info{type=" + this.type + ", value='" + this.value + "', isRemind='" + this.isRemind + "', tipsTimes='" + this.tipsTimes + "', isClose =" + this.isClose + "'}";
        }
    }

    MedalList() {
    }

    public static MedalList parse(@NonNull VipMedalList vipMedalList) {
        MedalList medalList = new MedalList();
        for (int i3 = 0; i3 < vipMedalList.medalInfo.size(); i3++) {
            Info info = new Info();
            info.type = vipMedalList.medalInfo.get(i3).type;
            info.value = vipMedalList.medalInfo.get(i3).value;
            info.isRemind = vipMedalList.medalInfo.get(i3).is_remind;
            info.tipsTimes = vipMedalList.medalInfo.get(i3).tips_times;
            info.isClose = vipMedalList.medalInfo.get(i3).is_close;
            medalList.infoList.add(info);
        }
        medalList.jumpUrl = vipMedalList.jumpUrl;
        return medalList;
    }

    public String convert() throws JSONException {
        if (this.infoList.size() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.infoList.size(); i3++) {
            Info info = this.infoList.get(i3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("t", info.type);
            jSONObject2.put("v", info.value);
            jSONObject2.put("i", info.isRemind);
            jSONObject2.put("ti", info.tipsTimes);
            jSONObject2.put("cl", info.isClose);
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("l", jSONArray);
        if (!TextUtils.isEmpty(this.jumpUrl)) {
            jSONObject.put("j", this.jumpUrl);
        }
        return jSONObject.toString();
    }

    public static MedalList parse(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("l");
        MedalList medalList = new MedalList();
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                Info info = new Info();
                info.type = jSONObject2.optInt("t");
                info.value = jSONObject2.getString("v");
                info.isRemind = jSONObject2.optInt("i");
                info.tipsTimes = jSONObject2.optInt("ti");
                info.isClose = jSONObject2.optBoolean("cl", true);
                medalList.infoList.add(info);
            }
        }
        medalList.jumpUrl = jSONObject.optString("j");
        return medalList;
    }
}
