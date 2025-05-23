package com.tencent.luggage.wxa.z3;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.luggage.scanner.camera.ScanUtil;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n {
    public static int a() {
        String[] split;
        if (!com.tencent.luggage.wxa.t9.l.g().equals("M9")) {
            return -1;
        }
        String str = Build.DISPLAY;
        if (str.substring(0, 0).equals("1") || (split = str.split("-")) == null || split.length < 2) {
            return -1;
        }
        return ScanUtil.getInt(split[1], 0);
    }

    public q a(int i3, int i16) {
        q qVar = new q();
        try {
            Camera open = CameraMonitor.open();
            qVar.f146264a = open;
            qVar.f146265b = 0;
            if (open == null) {
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                qVar.f146265b = 90;
                qVar.f146264a.setDisplayOrientation(90);
            } else if (a() >= 7093) {
                qVar.f146265b = 90;
                qVar.f146264a.setDisplayOrientation(180);
            }
            return qVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
