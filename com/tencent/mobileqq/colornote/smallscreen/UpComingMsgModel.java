package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class UpComingMsgModel implements Serializable {
    public boolean exposed;
    public String frienduin;
    public int istroop;
    public String nickName;
    public int reportType;
    public String troopUin;
    public int type;
    public List<Long> uniseq;

    public UpComingMsgModel() {
    }

    public UpComingMsgModel parseFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.frienduin = jSONObject.optString("key_uin");
            this.istroop = jSONObject.optInt("key_session_type");
            this.reportType = jSONObject.optInt("key_report_type");
            this.nickName = jSONObject.optString("key_nick_name");
            this.troopUin = jSONObject.optString("key_troop_uin");
            JSONArray optJSONArray = jSONObject.optJSONArray("key_uniseq");
            this.uniseq = new ArrayList(optJSONArray.length());
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                this.uniseq.add(Long.valueOf(optJSONArray.optLong(i3)));
            }
            this.type = jSONObject.optInt(QZoneHelper.QZoneAlbumConstants.KEY_FROM_TYPE);
            if (QLog.isColorLevel()) {
                QLog.d("UpComingMsgLogic.UpComingMsgModel", 2, "parseFromJson info: " + toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public String toJson() {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key_uin", this.frienduin);
            jSONObject.put("key_session_type", this.istroop);
            jSONObject.put("key_report_type", this.reportType);
            jSONObject.put("key_nick_name", this.nickName);
            jSONObject.put("key_troop_uin", this.troopUin);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.uniseq.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            jSONObject.put("key_uniseq", jSONArray);
            jSONObject.put(QZoneHelper.QZoneAlbumConstants.KEY_FROM_TYPE, this.type);
            str = jSONObject.toString();
            if (QLog.isColorLevel()) {
                QLog.d("UpComingMsgLogic.UpComingMsgModel", 2, "toJsonStr json: " + str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str;
    }

    public UpComingMsgModel(String str, String str2, List<Long> list, int i3, int i16, int i17, String str3) {
        this.frienduin = str;
        this.uniseq = new ArrayList(list);
        this.istroop = i3;
        this.type = i16;
        this.reportType = i17;
        this.nickName = str3;
        this.troopUin = str2;
    }
}
