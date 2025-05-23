package com.tencent.mobileqq.gamecenter.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TinyInfo implements Serializable {
    public static final String EXT_KEY_GAME_MSG_INFO = "ext_key_game_msg_info";
    public static final String KEY_FROM_FOLE_ID = "key_from_role_id";
    public static final String KEY_FROM_OPEN_ID = "key_from_open_id";
    public static final String KEY_FROM_TINY_ID = "key_from_tiny_id";
    public static final String KEY_GAME_APP_ID = "key_game_app_id";
    public static final String KEY_REDPOINT_INFO = "key_redpoint_info";
    public static final String KEY_TO_FOLE_ID = "key_to_role_id";
    public static final String KEY_TO_OPEN_ID = "key_to_open_id";
    public static final String KEY_TO_TINY_ID = "key_to_tiny_id";
    public String fromOpenId;
    public String fromRoleId;
    public long fromTinyId;
    public long gameAppId;
    public String nickName;
    public int redpointSwitch;
    public String toOpenId;
    public String toRoleId;
    public long toTinyId;
    public long windowFlag;

    public TinyInfo() {
    }

    private void a(String str, boolean z16) {
        String optString;
        String optString2;
        String optString3;
        String optString4;
        long optLong;
        long optLong2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (z16) {
                optString = jSONObject.optString(KEY_TO_FOLE_ID);
            } else {
                optString = jSONObject.optString(KEY_FROM_FOLE_ID);
            }
            this.fromRoleId = optString;
            if (z16) {
                optString2 = jSONObject.optString(KEY_TO_OPEN_ID);
            } else {
                optString2 = jSONObject.optString(KEY_FROM_OPEN_ID);
            }
            this.fromOpenId = optString2;
            if (z16) {
                optString3 = jSONObject.optString(KEY_FROM_FOLE_ID);
            } else {
                optString3 = jSONObject.optString(KEY_TO_FOLE_ID);
            }
            this.toRoleId = optString3;
            if (z16) {
                optString4 = jSONObject.optString(KEY_FROM_OPEN_ID);
            } else {
                optString4 = jSONObject.optString(KEY_TO_OPEN_ID);
            }
            this.toOpenId = optString4;
            this.gameAppId = jSONObject.optLong(KEY_GAME_APP_ID);
            if (z16) {
                optLong = jSONObject.optLong(KEY_TO_TINY_ID);
            } else {
                optLong = jSONObject.optLong(KEY_FROM_TINY_ID);
            }
            this.fromTinyId = optLong;
            if (z16) {
                optLong2 = jSONObject.optLong(KEY_FROM_TINY_ID);
            } else {
                optLong2 = jSONObject.optLong(KEY_TO_TINY_ID);
            }
            this.toTinyId = optLong2;
            this.windowFlag = jSONObject.optInt("key_window_flag");
            this.nickName = jSONObject.optString("key_nick_name");
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.TinyInfo", 2, "parseFromJson 2 info: " + toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static String toJsonStr(String str, String str2, String str3, String str4, long j3, long j16, long j17, int i3, String str5, int i16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_FROM_FOLE_ID, str);
            jSONObject.put(KEY_FROM_OPEN_ID, str2);
            jSONObject.put(KEY_TO_FOLE_ID, str3);
            jSONObject.put(KEY_TO_OPEN_ID, str4);
            jSONObject.put(KEY_GAME_APP_ID, j3);
            jSONObject.put(KEY_FROM_TINY_ID, j16);
            jSONObject.put(KEY_TO_TINY_ID, j17);
            jSONObject.put("key_window_flag", i3);
            jSONObject.put("key_nick_name", str5);
            jSONObject.put(KEY_REDPOINT_INFO, i16);
            return jSONObject.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public void parseFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.fromRoleId = jSONObject.optString(KEY_FROM_FOLE_ID);
            this.fromOpenId = jSONObject.optString(KEY_FROM_OPEN_ID);
            this.toRoleId = jSONObject.optString(KEY_TO_FOLE_ID);
            this.toOpenId = jSONObject.optString(KEY_TO_OPEN_ID);
            this.gameAppId = jSONObject.optInt(KEY_GAME_APP_ID);
            this.fromTinyId = jSONObject.optLong(KEY_FROM_TINY_ID);
            this.toTinyId = jSONObject.optLong(KEY_TO_TINY_ID);
            this.windowFlag = jSONObject.optInt("key_window_flag");
            this.nickName = jSONObject.optString("key_nick_name");
            this.redpointSwitch = jSONObject.optInt(KEY_REDPOINT_INFO);
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.TinyInfo", 2, "parseFromJson info: " + toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void parseFromMessageRecord(MessageRecord messageRecord) {
        if (messageRecord == null) {
            QLog.e("Q.tiny_msg.TinyInfo", 1, "[parseFromMessageRecord], gameMsg is null.");
            return;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(EXT_KEY_GAME_MSG_INFO);
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            parseFromJson(extInfoFromExtStr);
        }
    }

    @NonNull
    public String toString() {
        return "[fromRoleId" + ContainerUtils.KEY_VALUE_DELIMITER + this.fromRoleId + " fromOpenId" + ContainerUtils.KEY_VALUE_DELIMITER + this.fromOpenId + " toRoleId" + ContainerUtils.KEY_VALUE_DELIMITER + this.toRoleId + " toOpenId" + ContainerUtils.KEY_VALUE_DELIMITER + this.toOpenId + " gameAppId" + ContainerUtils.KEY_VALUE_DELIMITER + this.gameAppId + " fromTinyId" + ContainerUtils.KEY_VALUE_DELIMITER + this.fromTinyId + " toTinyId" + ContainerUtils.KEY_VALUE_DELIMITER + this.toTinyId + " nickName" + ContainerUtils.KEY_VALUE_DELIMITER + this.nickName + " windowFlag" + ContainerUtils.KEY_VALUE_DELIMITER + this.windowFlag + " redpointR" + ContainerUtils.KEY_VALUE_DELIMITER + this.redpointSwitch + "]";
    }

    public TinyInfo(String str, String str2, String str3, String str4, long j3, long j16, long j17, int i3, String str5) {
        this.fromOpenId = str2;
        this.fromRoleId = str;
        this.toOpenId = str4;
        this.toRoleId = str3;
        this.gameAppId = j3;
        this.fromTinyId = j16;
        this.toTinyId = j17;
        this.windowFlag = i3;
        this.nickName = str5;
    }

    public TinyInfo(String str) {
        parseFromJson(str);
    }

    public TinyInfo(String str, boolean z16) {
        a(str, z16);
    }

    public String toJsonStr() {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_FROM_FOLE_ID, this.fromRoleId);
            jSONObject.put(KEY_FROM_OPEN_ID, this.fromOpenId);
            jSONObject.put(KEY_TO_FOLE_ID, this.toRoleId);
            jSONObject.put(KEY_TO_OPEN_ID, this.toOpenId);
            jSONObject.put(KEY_GAME_APP_ID, this.gameAppId);
            jSONObject.put(KEY_FROM_TINY_ID, this.fromTinyId);
            jSONObject.put(KEY_TO_TINY_ID, this.toTinyId);
            jSONObject.put("key_window_flag", this.windowFlag);
            jSONObject.put("key_nick_name", this.nickName);
            jSONObject.put(KEY_REDPOINT_INFO, this.redpointSwitch);
            str = jSONObject.toString();
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.TinyInfo", 2, "toJsonStr 2 json: " + str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str;
    }
}
