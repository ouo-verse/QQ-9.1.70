package com.tencent.av.opengl.effects;

import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {
    public static boolean a(int i3, long j3, long j16) {
        int numCores = AVCoreSystemInfo.getNumCores();
        if (numCores < i3) {
            QLog.w("EffectCtrlUtils", 1, "isSupportOfDevice fail, cpuCount[" + numCores + " < " + i3 + "]");
            return false;
        }
        long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
        if (maxCpuFreq != 0 && maxCpuFreq < j3) {
            QLog.w("EffectCtrlUtils", 1, "isSupportOfDevice fail, cpuFrequency[" + maxCpuFreq + " < " + j3 + "]");
            return false;
        }
        long c16 = com.tencent.mobileqq.utils.m.c();
        if (c16 >= j16) {
            return true;
        }
        QLog.w("EffectCtrlUtils", 1, "isSupportOfDevice fail, mem[" + c16 + " < " + j16 + "]");
        return false;
    }
}
