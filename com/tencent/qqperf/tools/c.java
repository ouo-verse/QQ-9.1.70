package com.tencent.qqperf.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_device_ability", 0);
        if (Math.abs(System.currentTimeMillis() - sharedPreferences.getLong("device_ability_report_time", 0L)) < 86400000) {
            return;
        }
        sharedPreferences.edit().putLong("device_ability_report_time", System.currentTimeMillis()).commit();
        try {
            b(context);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("TAG", 2, "", th5);
            }
        }
    }

    private static void b(Context context) {
        int i3;
        int i16;
        int totalInnernalMemorySize = (int) ((FileUtils.getTotalInnernalMemorySize() / 1024.0f) / 1024.0f);
        int availableInnernalMemorySize = (int) ((FileUtils.getAvailableInnernalMemorySize() / 1024.0f) / 1024.0f);
        int i17 = -1;
        if (FileUtils.hasSDCardAndWritable()) {
            int totalInnernalMemorySize2 = (int) ((FileUtils.getTotalInnernalMemorySize() / 1024.0f) / 1024.0f);
            int availableInnernalMemorySize2 = (int) ((FileUtils.getAvailableInnernalMemorySize() / 1024.0f) / 1024.0f);
            List<FileUtils.StorageInfo> listAvaliableExternalStorage = FileUtils.listAvaliableExternalStorage(context);
            int size = listAvaliableExternalStorage.size();
            Iterator<FileUtils.StorageInfo> it = listAvaliableExternalStorage.iterator();
            while (it.hasNext()) {
                if (it.next().isRemoveable) {
                    i17++;
                }
            }
            i16 = i17;
            i17 = size;
            availableInnernalMemorySize = availableInnernalMemorySize2;
            i3 = totalInnernalMemorySize2;
        } else {
            i3 = -1000;
            i16 = -1;
        }
        int f16 = f.f();
        int m3 = (int) (ah.m() / 1024);
        int c16 = (int) ((m.c() / 1024) / 1024);
        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("totalRom", String.valueOf(totalInnernalMemorySize));
        hashMap.put("avaiRom", String.valueOf(availableInnernalMemorySize));
        hashMap.put("totalSD", String.valueOf(i3));
        hashMap.put("avaiSD", String.valueOf(-1000));
        hashMap.put("extCount", String.valueOf(i17));
        hashMap.put("remoableExtCount", String.valueOf(i16));
        hashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("cpuCoreNum", String.valueOf(f16));
        hashMap.put("maxFrequency", String.valueOf(m3));
        hashMap.put("cpu_abi", Build.CPU_ABI);
        hashMap.put("cpu_abi2", Build.CPU_ABI2);
        hashMap.put("ramSize", String.valueOf(c16));
        long totalInternalMemorySize = SdCardUtil.getTotalInternalMemorySize();
        long totalExternalMemorySize = SdCardUtil.getTotalExternalMemorySize(context);
        long availableInternalMemorySize = SdCardUtil.getAvailableInternalMemorySize();
        long availableExternalMemorySize = SdCardUtil.getAvailableExternalMemorySize(context);
        hashMap.put("totalInter", String.valueOf(totalInternalMemorySize));
        hashMap.put("totalExter", String.valueOf(totalExternalMemorySize));
        hashMap.put("avaInter", String.valueOf(availableInternalMemorySize));
        hashMap.put("avaExter", String.valueOf(availableExternalMemorySize));
        hashMap.put("totalSpace", String.valueOf(totalInternalMemorySize + totalExternalMemorySize));
        hashMap.put("totalAvaSpace", String.valueOf(availableInternalMemorySize + availableExternalMemorySize));
        hashMap.put("realUin", String.valueOf(QQRMonitorSDKManager.uin));
        StatisticCollector.getInstance(context).collectPerformance("", "actStorageStats", true, 0L, 0L, hashMap, "");
    }
}
