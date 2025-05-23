package com.tencent.qzonehub.api.utils.impl;

import android.app.ActivityManager;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.qzonehub.api.utils.impl.QzoneHardwareRestrictionImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneHardwareRestrictionImpl implements IQzoneHardwareRestriction {
    private static final String TAG = "QzoneHardwareRestrictionImpl";
    private static volatile int sCpuCoreNum = -1;
    private static volatile long sCpuMaxFreq = 0;
    private static volatile int sCurCpuLevel = -1;
    private static volatile int sCurMemLevel = -1;
    private static volatile long sSDCardAvailableSize;
    private static volatile long sTotalMem;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    public QzoneHardwareRestrictionImpl() {
        initHardwareInfo();
    }

    private final int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private void initHardwareInfo() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: gz3.c
            @Override // java.lang.Runnable
            public final void run() {
                QzoneHardwareRestrictionImpl.this.lambda$initHardwareInfo$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHardwareInfo$0() {
        sCpuMaxFreq = loadCpuFreq();
        QLog.d(TAG, 1, "[asyncLoadCpuFreq] cpu max freq: " + sCpuMaxFreq);
        sCpuCoreNum = loadNumberOfCores();
        QLog.d(TAG, 1, "[asyncLoadNumberOfCores] cpu core num: " + sCpuCoreNum);
        sTotalMem = loadTotalMem();
        QLog.d(TAG, 1, "[asyncLoadTotalMem] total mem: " + sTotalMem);
        sSDCardAvailableSize = loadSDCardAvailableSize();
        QLog.d(TAG, 1, "[asyncLoadSDCardAvailableSize] sd card available size: " + sSDCardAvailableSize);
    }

    private long loadCpuFreq() {
        FileReader fileReader;
        int numberOfCores = getNumberOfCores();
        for (int i3 = 0; i3 < numberOfCores; i3++) {
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 1024);
                        try {
                            String readLine = bufferedReader2.readLine();
                            long parseLong = readLine != null ? Long.parseLong(readLine) : 0L;
                            if (sCpuMaxFreq < parseLong) {
                                sCpuMaxFreq = parseLong;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, String.format(Locale.getDefault(), "initCpuFreq  [%d, %d Khz]", Integer.valueOf(i3), Long.valueOf(parseLong)));
                            }
                            try {
                                bufferedReader2.close();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            try {
                                fileReader.close();
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                        } catch (Exception e18) {
                            e = e18;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e26) {
                                    e26.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                    throw th;
                                } catch (Exception e27) {
                                    e27.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e28) {
                    e = e28;
                }
            } catch (Exception e29) {
                e = e29;
                fileReader = null;
            } catch (Throwable th7) {
                th = th7;
                fileReader = null;
            }
        }
        if (!TextUtils.isEmpty(DeviceInfoMonitor.getModel()) && (DeviceInfoMonitor.getModel().startsWith("HM") || DeviceInfoMonitor.getModel().startsWith("REDMI"))) {
            sCpuMaxFreq = (long) (sCpuMaxFreq * 0.75d);
            QLog.w(TAG, 2, "cpu * 0.75 Build.MODEL:" + DeviceInfoMonitor.getModel());
        }
        return sCpuMaxFreq;
    }

    private final int loadNumberOfCores() {
        if (sCpuCoreNum == -1) {
            sCpuCoreNum = Runtime.getRuntime().availableProcessors();
        }
        return sCpuCoreNum;
    }

    private long loadSDCardAvailableSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getSDCardAvailableSize " + ((availableBlocks * blockSize) / 1024));
            }
            return (availableBlocks * blockSize) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x001c -> B:11:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long loadTotalMem() {
        Throwable th5;
        BufferedReader bufferedReader;
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        BufferedReader bufferedReader2 = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8);
                try {
                    String readLine = bufferedReader.readLine();
                    str = readLine != null ? readLine : null;
                    bufferedReader.close();
                } catch (FileNotFoundException e17) {
                    e = e17;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (str != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return r0;
                } catch (IOException e18) {
                    e = e18;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (str != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return r0;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                bufferedReader = null;
            } catch (IOException e26) {
                e = e26;
                bufferedReader = null;
            } catch (Throwable th6) {
                th5 = th6;
                if (bufferedReader2 != null) {
                }
                throw th5;
            }
            long parseInt = str != null ? Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim()) : 0L;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getTotalMem " + parseInt);
            }
            return parseInt;
        } catch (Throwable th7) {
            th5 = th7;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            throw th5;
        }
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public boolean equalHardwareRestriction(int i3, int i16) {
        return i3 <= getCurrentMemLevelNew() && i16 <= getCurrentCpuFreSumLevel();
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public long getAvailableMem() {
        ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getAvailableMem " + (memoryInfo.availMem / 1024));
        }
        return memoryInfo.availMem / 1024;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public long getCpuMaxFreq() {
        if (sCpuMaxFreq == 0) {
            sCpuMaxFreq = loadCpuFreq();
        }
        return sCpuMaxFreq;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public int getCurrentCpuFreSumLevel() {
        if (sCurCpuLevel != -1) {
            return sCurCpuLevel;
        }
        sCurCpuLevel = 1;
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HARDWARERESTRICTION_CPU_FRE_SUM, QzoneConfig.DefaultValue.DEFAULT_HARDWARERESTRICTION_CPU_FRE_SUM);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cpuLevelList " + config);
        }
        String[] split = config.split(",");
        long cpuMaxFreq = (getCpuMaxFreq() / 1024) * getNumberOfCores();
        if (split.length == 3 && cpuMaxFreq != 0) {
            float f16 = (float) cpuMaxFreq;
            if (f16 < Float.valueOf(split[0]).floatValue()) {
                sCurCpuLevel = 0;
            } else if (f16 >= Float.valueOf(split[0]).floatValue() && f16 < Float.valueOf(split[1]).floatValue()) {
                sCurCpuLevel = 1;
            } else if (f16 >= Float.valueOf(split[1]).floatValue() && f16 < Float.valueOf(split[2]).floatValue()) {
                sCurCpuLevel = 2;
            } else if (f16 >= Float.valueOf(split[2]).floatValue()) {
                sCurCpuLevel = 3;
            }
        }
        return sCurCpuLevel;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public int getCurrentCpuLevel() {
        if (sCurCpuLevel != -1) {
            return sCurCpuLevel;
        }
        sCurCpuLevel = 1;
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HARDWARERESTRICTION_CPU_SIZE, QzoneConfig.DefaultValue.DEFAULT_HARDWARERESTRICTION_CPU_SIZE);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cpuLevelList " + config);
        }
        String[] split = config.split(",");
        long cpuMaxFreq = getCpuMaxFreq() / 1024;
        if (split.length == 3 && cpuMaxFreq != 0) {
            float f16 = (float) cpuMaxFreq;
            if (f16 < Float.valueOf(split[0]).floatValue()) {
                sCurCpuLevel = 0;
            } else if (f16 >= Float.valueOf(split[0]).floatValue() && f16 < Float.valueOf(split[1]).floatValue()) {
                sCurCpuLevel = 1;
            } else if (f16 >= Float.valueOf(split[1]).floatValue() && f16 < Float.valueOf(split[2]).floatValue()) {
                sCurCpuLevel = 2;
            } else if (f16 >= Float.valueOf(split[2]).floatValue()) {
                sCurCpuLevel = 3;
            }
        }
        return sCurCpuLevel;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public int getCurrentMemLevel() {
        if (sCurMemLevel != -1) {
            return sCurMemLevel;
        }
        sCurMemLevel = 1;
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HARDWARERESTRICTION_RAM_SIZE, QzoneConfig.DefaultValue.DEFAULT_HARDWARERESTRICTION_RAM_SIZE);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "memLevelList " + config);
        }
        String[] split = config.split(",");
        long totalMem = getTotalMem() / 1024;
        if (split.length == 3 && totalMem != 0) {
            float f16 = (float) totalMem;
            if (f16 < Float.valueOf(split[0]).floatValue()) {
                sCurMemLevel = 0;
            } else if (f16 >= Float.valueOf(split[0]).floatValue() && f16 < Float.valueOf(split[1]).floatValue()) {
                sCurMemLevel = 1;
            } else if (f16 >= Float.valueOf(split[1]).floatValue() && f16 < Float.valueOf(split[2]).floatValue()) {
                sCurMemLevel = 2;
            } else if (f16 >= Float.valueOf(split[2]).floatValue()) {
                sCurMemLevel = 3;
            }
        }
        return sCurMemLevel;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public int getCurrentMemLevelNew() {
        if (sCurMemLevel != -1) {
            return sCurMemLevel;
        }
        sCurMemLevel = 1;
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HARDWARERESTRICTION_RAM_SIZE_NEW, QzoneConfig.DefaultValue.DEFAULT_HARDWARERESTRICTION_RAM_SIZE_NEW);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "memLevelList " + config);
        }
        String[] split = config.split(",");
        long totalMem = getTotalMem() / 1024;
        if (split.length == 3 && totalMem != 0) {
            float f16 = (float) totalMem;
            if (f16 < Float.valueOf(split[0]).floatValue()) {
                sCurMemLevel = 0;
            } else if (f16 >= Float.valueOf(split[0]).floatValue() && f16 < Float.valueOf(split[1]).floatValue()) {
                sCurMemLevel = 1;
            } else if (f16 >= Float.valueOf(split[1]).floatValue() && f16 < Float.valueOf(split[2]).floatValue()) {
                sCurMemLevel = 2;
            } else if (f16 >= Float.valueOf(split[2]).floatValue()) {
                sCurMemLevel = 3;
            }
        }
        return sCurMemLevel;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public final int getNumberOfCores() {
        if (sCpuCoreNum == -1) {
            sCpuCoreNum = loadNumberOfCores();
        }
        return sCpuCoreNum;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public long getSDCardAllSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public long getSDCardAvailableSize() {
        if (sSDCardAvailableSize == 0) {
            sSDCardAvailableSize = loadSDCardAvailableSize();
        }
        return sSDCardAvailableSize;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public long getSystemAvailableSize() {
        try {
            StatFs statFs = new StatFs(IQzoneHardwareRestriction.APP_ROOT);
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getSystemAvailableSize " + ((availableBlocks * blockSize) / 1024));
            }
            return (availableBlocks * blockSize) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public long getTotalMem() {
        if (sTotalMem == 0) {
            sTotalMem = loadTotalMem();
        }
        return sTotalMem;
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction
    public boolean meetHardwareRestriction(int i3, int i16) {
        return i3 <= getCurrentMemLevel() && i16 <= getCurrentCpuLevel();
    }
}
