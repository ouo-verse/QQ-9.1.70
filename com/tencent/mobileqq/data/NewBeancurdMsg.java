package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "frienduin")
/* loaded from: classes10.dex */
public class NewBeancurdMsg extends Entity {
    public String busiUuid;
    public long busiid;
    private String exInfoForPrint;
    public String extensionInfoStr;
    public String frienduin = "";
    public String pushInfoString;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ExtraTofuInfo {
        public int from;
        public boolean isDelete;

        @Deprecated
        private boolean isPushTofu;
        public boolean isValid = true;

        public ExtraTofuInfo(boolean z16, int i3) {
            this.isDelete = z16;
            this.from = i3;
        }

        public static ExtraTofuInfo parseToGetPushInfo(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ExtraTofuInfo(false, 3);
            }
            try {
                ExtraTofuInfo extraTofuInfo = (ExtraTofuInfo) new Gson().fromJson(str, ExtraTofuInfo.class);
                if (extraTofuInfo == null) {
                    return new ExtraTofuInfo(false, 3);
                }
                return extraTofuInfo;
            } catch (Exception e16) {
                QLog.i("PushInfo", 1, "convert jsonString -> PushInfo exception:" + e16);
                return new ExtraTofuInfo(false, 3);
            }
        }

        public boolean checkIsCommonTofu() {
            if (!this.isPushTofu && this.from == 3) {
                return true;
            }
            return false;
        }

        public boolean checkIsPushTofu() {
            int i3;
            if (!this.isPushTofu && (i3 = this.from) != 2 && i3 != 4) {
                return false;
            }
            return true;
        }

        public boolean checkIsSogouTofu() {
            if (!this.isPushTofu && this.from == 1) {
                return true;
            }
            return false;
        }

        public String toJsonString() {
            try {
                return new Gson().toJson(this);
            } catch (Exception e16) {
                QLog.i("PushInfo", 1, "convert PushInfo -> jsonString exception:" + e16);
                return "";
            }
        }

        public String toString() {
            return "PushInfo{isValid=" + this.isValid + ", isPushTofu=" + this.isPushTofu + ", isDelete=" + this.isDelete + ", from=" + this.from + '}';
        }
    }

    public String toString() {
        if (TextUtils.isEmpty(this.exInfoForPrint) && !TextUtils.isEmpty(this.extensionInfoStr)) {
            try {
                JSONObject jSONObject = new JSONObject(this.extensionInfoStr);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("frd_uin");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(MD5Utils.encodeHexStr(jSONArray.getString(i3)));
                }
                jSONObject.put("frd_uin", arrayList);
                this.exInfoForPrint = jSONObject.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return "NewBeancurdMsg{frienduin='" + MD5Utils.encodeHexStr(this.frienduin) + "', busiid=" + this.busiid + ", busiUuid='" + this.busiUuid + "', exInfoForPrint='" + this.exInfoForPrint + "', pushInfoString='" + this.pushInfoString + "'}";
    }
}
