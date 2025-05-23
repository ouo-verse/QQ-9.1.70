package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public String f202698a = "";

    public static p a(String str) {
        if (str == null) {
            return null;
        }
        try {
            p pVar = new p();
            pVar.f202698a = str;
            QLog.d("ConfBean", 2, "confBean = " + pVar.toString());
            return pVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ConfBean", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("configContent:");
        sb5.append(this.f202698a);
        return sb5.toString();
    }
}
