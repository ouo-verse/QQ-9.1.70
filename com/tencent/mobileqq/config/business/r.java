package com.tencent.mobileqq.config.business;

import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public boolean f202817a = false;

    public static r a(String str) {
        boolean z16;
        if (str == null) {
            return null;
        }
        try {
            r rVar = new r();
            if (new JSONObject(str).optInt(GameCenterAPIJavaScript.OPEN_SWITCH, 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            rVar.f202817a = z16;
            return rVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GlobalSearchConfProcessor", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }
}
