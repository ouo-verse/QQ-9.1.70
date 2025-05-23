package com.tencent.mobileqq.ark.api.notify;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements g {
    protected static QQAppInterface a() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(String str, String str2, String str3) {
        String str4;
        try {
            str4 = new JSONObject(str3).optString("gc");
        } catch (Exception e16) {
            QLog.e("TroopNotify", 1, "notify json error!", e16);
            str4 = null;
        }
        if (TextUtils.isEmpty(str4) || !str2.equals("GetIsTroopOwner")) {
            return false;
        }
        QQAppInterface a16 = a();
        if (a16 == null) {
            QLog.e("TroopNotify", 1, "ark.notify error! appInterface == null");
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isOwner", TroopUtils.B(a16, str4, a16.getCurrentUin()));
            ark.arkNotify(str, "", str2, jSONObject.toString(), ark.ARKMETADATA_JSON);
        } catch (Throwable th5) {
            QLog.e("TroopNotify", 1, "ark.notify error!", th5);
        }
        return true;
    }
}
