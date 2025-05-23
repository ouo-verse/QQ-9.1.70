package org.light.utils;

import android.os.Process;
import java.io.RandomAccessFile;
import org.light.device.LightDeviceProperty;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DeviceInfoUtil {
    private static final String TAG = "DeviceInfoUtil";
    private static RandomAccessFile appStatFile;
    private static Long lastAppCpuTime;
    private static Long lastCpuTime;
    private static RandomAccessFile procStatFile;

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    public static float getCpuUsage() {
        long parseLong;
        long parseLong2;
        if (LightDeviceProperty.VERSION.SDK_INT >= 26) {
            return -1.0f;
        }
        try {
            RandomAccessFile randomAccessFile = procStatFile;
            if (randomAccessFile != null && appStatFile != null) {
                randomAccessFile.seek(0L);
                appStatFile.seek(0L);
                String readLine = procStatFile.readLine();
                String readLine2 = appStatFile.readLine();
                String[] split = readLine.split(" ");
                String[] split2 = readLine2.split(" ");
                parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                parseLong2 = Long.parseLong(split2[13]) + Long.parseLong(split2[14]);
                if (lastCpuTime != null && lastAppCpuTime == null) {
                    lastCpuTime = Long.valueOf(parseLong);
                    lastAppCpuTime = Long.valueOf(parseLong2);
                    return 0.0f;
                }
                float longValue = (((float) (parseLong2 - lastAppCpuTime.longValue())) / ((float) (parseLong - lastCpuTime.longValue()))) * 100.0f;
                lastCpuTime = Long.valueOf(parseLong);
                lastAppCpuTime = Long.valueOf(parseLong2);
                return longValue;
            }
            procStatFile = new RandomAccessFile("/proc/stat", "r");
            appStatFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            String readLine3 = procStatFile.readLine();
            String readLine22 = appStatFile.readLine();
            String[] split3 = readLine3.split(" ");
            String[] split22 = readLine22.split(" ");
            parseLong = Long.parseLong(split3[2]) + Long.parseLong(split3[3]) + Long.parseLong(split3[4]) + Long.parseLong(split3[5]) + Long.parseLong(split3[6]) + Long.parseLong(split3[7]) + Long.parseLong(split3[8]);
            parseLong2 = Long.parseLong(split22[13]) + Long.parseLong(split22[14]);
            if (lastCpuTime != null) {
            }
            float longValue2 = (((float) (parseLong2 - lastAppCpuTime.longValue())) / ((float) (parseLong - lastCpuTime.longValue()))) * 100.0f;
            lastCpuTime = Long.valueOf(parseLong);
            lastAppCpuTime = Long.valueOf(parseLong2);
            return longValue2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0.0f;
        }
    }

    public static float getMemoryUsage() {
        return 100.0f;
    }

    private static native void nativeInit();
}
