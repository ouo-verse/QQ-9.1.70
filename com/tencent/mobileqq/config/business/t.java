package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class t implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private boolean f202834d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f202835e;

    public static t c(String str) {
        if (str == null) {
            return null;
        }
        try {
            t tVar = new t();
            tVar.f202834d = new JSONObject(str).optBoolean("needSeparatePersonWithGroup", false);
            tVar.f202835e = true;
            return tVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GlobalSearchConfProcessor", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }

    public boolean a() {
        return this.f202834d;
    }

    public boolean b() {
        return this.f202835e;
    }

    public String toString() {
        return "needSeparate:" + this.f202834d;
    }
}
