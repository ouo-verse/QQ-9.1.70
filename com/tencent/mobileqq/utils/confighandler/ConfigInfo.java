package com.tencent.mobileqq.utils.confighandler;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class ConfigInfo {
    public String mUin;
    public int parseRet = -1;
    public int taskId = 0;
    public long serverVer = 0;

    protected abstract boolean parse(JSONObject jSONObject);

    public final void setUin(String str) {
        this.mUin = str;
    }

    public final boolean tryParse(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(str, 1, "parseJson, jsonContent\u4e3a\u7a7a");
                }
                return true;
            }
            JSONObject jSONObject = new JSONObject(str2);
            this.taskId = jSONObject.optInt("task_id");
            boolean parse = parse(jSONObject);
            this.parseRet = parse ? 1 : 0;
            return parse;
        } catch (Exception e16) {
            QLog.d(str, 1, "parseJson, Exception", e16);
            return false;
        }
    }
}
