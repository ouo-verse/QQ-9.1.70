package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f202588a = false;

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        try {
            b bVar = new b();
            QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + bVar);
            return bVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AppletNotificationConfProcessor", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }
}
