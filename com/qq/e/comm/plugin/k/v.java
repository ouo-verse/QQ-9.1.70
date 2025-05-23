package com.qq.e.comm.plugin.k;

import android.hardware.SensorManager;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class v {
    public static int a(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 4) {
            return 4;
        }
        if (i3 != 8) {
            return i3 != 16 ? 0 : 10;
        }
        return 9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        com.qq.e.comm.util.GDTLogger.d("HardWareUtil break bit:" + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(int i3) {
        int i16 = 0;
        try {
            SensorManager sensorManager = (SensorManager) GDTADManager.getInstance().getAppContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            int i17 = 1;
            while (true) {
                if (i17 <= 0) {
                    break;
                }
                i16 |= a(sensorManager, i17, i3);
                i3 &= ~i17;
                if (i3 == 0) {
                    break;
                }
                i17 <<= 1;
            }
        } catch (Throwable th5) {
            GDTLogger.e("getSensorStatus", th5);
        }
        return i16;
    }

    private static int a(SensorManager sensorManager, int i3, int i16) {
        if (sensorManager == null) {
            GDTLogger.e("HardWareUtil sensorManager is null");
            return 0;
        }
        int a16 = a(i3);
        if ((i16 & i3) <= 0 || SensorMonitor.getDefaultSensor(sensorManager, a16) == null) {
            return 0;
        }
        GDTLogger.d("HardWareUtil get sensor type:" + a16);
        return i3;
    }
}
