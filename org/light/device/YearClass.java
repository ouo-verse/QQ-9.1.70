package org.light.device;

import android.content.Context;
import java.util.ArrayList;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class YearClass {
    public static final int CLASS_UNKNOWN = -1;
    private static final String TAG = "Phone_year";
    private static long mCPUMaxFreq = 0;
    private static int mCoreNum = 0;
    private static long mTotalMem = 0;
    private static volatile Integer mYearCategory = null;
    private static int sBaseYear = 2012;
    private static float sCpuRate = 0.5f;

    private static int categorizeByYear(Context context) {
        float f16;
        float f17;
        int clockSpeedYear = getClockSpeedYear();
        int ramYear = getRamYear(context);
        int i3 = -1;
        if (clockSpeedYear != -1 || -1 != ramYear) {
            int i16 = sBaseYear;
            if (clockSpeedYear >= i16) {
                f16 = clockSpeedYear * sCpuRate;
            } else {
                f16 = 0.0f;
            }
            if (f16 <= 0.0f) {
                f17 = ramYear;
            } else if (ramYear >= i16) {
                f17 = (ramYear * (1.0f - sCpuRate)) + f16;
            } else {
                f17 = clockSpeedYear;
            }
            i3 = (int) (f17 + 0.5f);
        }
        LightLogUtil.i(TAG, "\u624b\u673a\u914d\u7f6e\u6240\u5c5e\u5e74\u4efd\u4e3a\uff1a" + i3 + ",cpuYear:" + clockSpeedYear + ",ramYear:" + ramYear);
        return i3;
    }

    private static void conditionallyAdd(ArrayList<Integer> arrayList, int i3) {
        if (i3 != -1) {
            arrayList.add(Integer.valueOf(i3));
        }
    }

    public static int get(Context context) {
        if (mYearCategory == null) {
            if (context == null) {
                return -1;
            }
            synchronized (YearClass.class) {
                if (mYearCategory == null) {
                    mYearCategory = Integer.valueOf(categorizeByYear(context));
                }
            }
        }
        return mYearCategory.intValue();
    }

    private static int getClockSpeedYear() {
        mCPUMaxFreq = LightDeviceUtils.getMaxCpuFreq();
        LightLogUtil.i(TAG, "cpuMaxHZ:" + mCPUMaxFreq);
        long j3 = mCPUMaxFreq;
        if (j3 <= 0) {
            return -1;
        }
        return CPUYearList.getCPUOclock(j3);
    }

    private static int getNumCoresYear() {
        mCoreNum = LightDeviceUtils.getNumCores();
        LightLogUtil.i(TAG, "corenum:" + mCoreNum);
        return CPUYearList.getCoreNumYear(mCoreNum);
    }

    public static String getPhonHWInfo() {
        return "CPU core num:" + mCoreNum + ",CPU max freq:" + mCPUMaxFreq + ",total memory:" + mTotalMem;
    }

    private static int getRamYear(Context context) {
        long totalRamMemory = LightDeviceUtils.getTotalRamMemory(context);
        mTotalMem = totalRamMemory;
        LightLogUtil.i(TAG, "ramSize:" + mTotalMem);
        if (mTotalMem <= 0) {
            return -1;
        }
        return RamYearList.getRamYear(totalRamMemory);
    }
}
