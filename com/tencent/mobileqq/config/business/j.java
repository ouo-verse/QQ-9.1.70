package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f202662d = 0;

    public static j a(String str) {
        if (str == null) {
            return null;
        }
        try {
            j jVar = new j();
            jVar.f202662d = new JSONObject(str).optInt("open_don_disturb", 0);
            return jVar;
        } catch (Exception e16) {
            QLog.e("DonDisturbProcessor", 1, "DonDisturbBean parse " + e16);
            return null;
        }
    }

    public int b() {
        return this.f202662d;
    }

    public String toString() {
        return super.toString() + " showDonDisturb=" + this.f202662d;
    }
}
