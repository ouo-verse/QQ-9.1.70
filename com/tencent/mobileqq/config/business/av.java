package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class av implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f202553d = 1;

    /* renamed from: e, reason: collision with root package name */
    private long f202554e = 3000;

    public static av c(String str) {
        if (str == null) {
            return null;
        }
        try {
            av avVar = new av();
            JSONObject jSONObject = new JSONObject(str);
            avVar.f202553d = jSONObject.optInt("pttWithTextSwitch", -1);
            avVar.f202554e = jSONObject.optLong("aioSttSpliceTimeout", 45000L);
            return avVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PttWithTextSwitchBean", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }

    public long a() {
        return this.f202554e;
    }

    public boolean b() {
        if (this.f202553d == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "open:" + this.f202553d + "  |  aioSttSpliceTimeout:" + this.f202554e;
    }
}
