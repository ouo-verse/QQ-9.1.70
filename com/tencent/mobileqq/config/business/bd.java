package com.tencent.mobileqq.config.business;

import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bd {

    /* renamed from: a, reason: collision with root package name */
    public boolean f202600a = true;

    /* renamed from: b, reason: collision with root package name */
    public long f202601b = 134217728;

    public static bd a(String str) {
        boolean z16;
        if (str == null) {
            return null;
        }
        try {
            bd bdVar = new bd();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(GameCenterAPIJavaScript.OPEN_SWITCH, 0) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bdVar.f202600a = z16;
            bdVar.f202601b = jSONObject.optLong("picMaxLen", 134217728L);
            return bdVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GlobalSearchConfProcessor", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }
}
