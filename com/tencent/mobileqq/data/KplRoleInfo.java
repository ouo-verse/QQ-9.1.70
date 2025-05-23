package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$RoleInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class KplRoleInfo extends Entity {
    public static final String KPL_TAG = "KplMessage";
    public static final String MSG_EXT_KEY = "msg_ext_key";
    public String roleName;
    public String roleScore;
    public String roleUrl;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class WZRYUIinfo implements Serializable {
        public String nick;
        public int sourceId;
        public int subSourceId;
        public String uin;
        public String verifyMsg;

        public static String buildNickName(String str, String str2) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "";
            }
            if (!TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return str2;
                }
                return str2 + "(" + str + ")";
            }
            return str;
        }

        public static WZRYUIinfo createInfo(String str, String str2, String str3, int i3, int i16) {
            WZRYUIinfo wZRYUIinfo = new WZRYUIinfo();
            wZRYUIinfo.uin = str;
            wZRYUIinfo.nick = str2;
            wZRYUIinfo.verifyMsg = str3;
            wZRYUIinfo.sourceId = i3;
            wZRYUIinfo.subSourceId = i16;
            return wZRYUIinfo;
        }
    }

    public static KplRoleInfo parseJsonString(String str) {
        KplRoleInfo kplRoleInfo = new KplRoleInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            kplRoleInfo.roleName = jSONObject.optString("roleName");
            kplRoleInfo.roleScore = jSONObject.optString("roleScore");
            kplRoleInfo.roleUrl = jSONObject.optString("roleUrl");
            return kplRoleInfo;
        } catch (Exception e16) {
            QLog.e("KplRoleInfo", 1, "parseJsonString exception:");
            e16.printStackTrace();
            return null;
        }
    }

    public static KplRoleInfo parseProtoResp(oidb_0xa28$RoleInfo oidb_0xa28_roleinfo) {
        KplRoleInfo kplRoleInfo = new KplRoleInfo();
        kplRoleInfo.roleName = oidb_0xa28_roleinfo.bytes_role_name.get().toStringUtf8();
        kplRoleInfo.roleScore = oidb_0xa28_roleinfo.bytes_role_score.get().toStringUtf8();
        kplRoleInfo.roleUrl = oidb_0xa28_roleinfo.str_role_url.get();
        return kplRoleInfo;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("roleName", this.roleName);
            jSONObject.put("roleScore", this.roleScore);
            jSONObject.put("roleUrl", this.roleUrl);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("KplRoleInfo", 1, "toJsonString exception:");
            e16.printStackTrace();
            return null;
        }
    }
}
