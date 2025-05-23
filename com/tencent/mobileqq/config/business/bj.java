package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bj implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202614d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f202615e = 5;

    /* renamed from: f, reason: collision with root package name */
    public int f202616f = 15;

    public static bj a(String str) {
        boolean z16;
        if (str == null) {
            return new bj();
        }
        try {
            bj bjVar = new bj();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(GameCenterAPIJavaScript.OPEN_SWITCH, 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            bjVar.f202614d = z16;
            bjVar.f202615e = jSONObject.optInt("sameMsgCount", 5);
            int optInt = jSONObject.optInt("loadMoreCount", 15);
            bjVar.f202616f = optInt;
            if (bjVar.f202615e < 2) {
                bjVar.f202614d = false;
            }
            if (optInt < 15) {
                bjVar.f202616f = 15;
            }
            if (bjVar.f202616f > 40) {
                bjVar.f202616f = 40;
            }
            QLog.d("TroopFoldMsgBean", 2, "confBean = " + bjVar.toString());
            return bjVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopFoldMsgBean", 1, "parse e:", e16.toString());
            }
            return new bj();
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("openSwitch = ");
        sb5.append(this.f202614d);
        sb5.append(",sameMsgCount = ");
        sb5.append(this.f202615e);
        return sb5.toString();
    }
}
