package com.tencent.imsdk.common;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.imsdk.manager.BaseManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CpuUsageMeasurer {
    private static final String TAG = "CpuUsageMeasurer";
    private static final long UPDATE_INTERVAL = TimeUnit.SECONDS.toMillis(2);
    private RandomAccessFile mProcessStatFile;
    private RandomAccessFile mSystemStatFile;
    private long mLastUpdateTime = 0;
    private float mLastAppCpuTimeUsed = 0.0f;
    private float mLastAppCpuUsage = 0.0f;
    private long mTotalCpuTime = 0;
    private long mIdleCpuTime = 0;
    private float mLastSysCpuUsage = 0.0f;
    private final long mClockClkInHz = BaseManager.getInstance().getClockTickInHz();
    private final int mProcessorCount = Runtime.getRuntime().availableProcessors();

    public CpuUsageMeasurer() {
        try {
            this.mProcessStatFile = new RandomAccessFile(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(Process.myPid())), "r");
        } catch (IOException e16) {
            IMLog.e(TAG, "open /proc/[PID]/stat failed. " + e16.getMessage());
        }
        try {
            this.mSystemStatFile = new RandomAccessFile("/proc/stat", "r");
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String[] readFirstLineAndSplit(RandomAccessFile randomAccessFile) {
        String str;
        if (randomAccessFile == null) {
            return null;
        }
        try {
            randomAccessFile.seek(0L);
            str = randomAccessFile.readLine();
        } catch (IOException e16) {
            IMLog.e(TAG, "read line failed. " + e16.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("\\s+");
    }

    private void updateCpuUsage() {
        long timeTick;
        long j3;
        String[] readFirstLineAndSplit = readFirstLineAndSplit(this.mProcessStatFile);
        if (readFirstLineAndSplit != null && readFirstLineAndSplit.length >= 52) {
            long parseLong = (((float) (((Long.parseLong(readFirstLineAndSplit[13]) + Long.parseLong(readFirstLineAndSplit[14])) + Long.parseLong(readFirstLineAndSplit[15])) + Long.parseLong(readFirstLineAndSplit[16]))) * 1000.0f) / ((float) this.mClockClkInHz);
            String[] readFirstLineAndSplit2 = readFirstLineAndSplit(this.mSystemStatFile);
            if (readFirstLineAndSplit2 != null && readFirstLineAndSplit2.length >= 8) {
                long parseLong2 = Long.parseLong(readFirstLineAndSplit2[1]) + Long.parseLong(readFirstLineAndSplit2[2]) + Long.parseLong(readFirstLineAndSplit2[3]) + Long.parseLong(readFirstLineAndSplit2[4]) + Long.parseLong(readFirstLineAndSplit2[5]) + Long.parseLong(readFirstLineAndSplit2[6]) + Long.parseLong(readFirstLineAndSplit2[7]);
                long parseLong3 = Long.parseLong(readFirstLineAndSplit2[4]) + Long.parseLong(readFirstLineAndSplit2[5]);
                float f16 = ((float) parseLong2) * 1000.0f;
                long j16 = this.mClockClkInHz;
                timeTick = f16 / ((float) j16);
                j3 = (((float) parseLong3) * 1000.0f) / ((float) j16);
            } else {
                timeTick = BaseManager.getInstance().getTimeTick() * this.mProcessorCount;
                j3 = timeTick;
            }
            long j17 = timeTick - this.mTotalCpuTime;
            float f17 = (float) parseLong;
            float f18 = (float) j17;
            this.mLastAppCpuUsage = ((f17 - this.mLastAppCpuTimeUsed) * 100.0f) / f18;
            this.mLastSysCpuUsage = (((float) (j17 - (j3 - this.mIdleCpuTime))) * 100.0f) / f18;
            this.mLastAppCpuTimeUsed = f17;
            this.mIdleCpuTime = j3;
            this.mTotalCpuTime = timeTick;
            this.mLastUpdateTime = BaseManager.getInstance().getTimeTick();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        closeQuietly(this.mProcessStatFile);
        closeQuietly(this.mSystemStatFile);
        IMLog.i(TAG, "measurer is released");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getCpuUsage() {
        int[] iArr;
        synchronized (this) {
            if (BaseManager.getInstance().getTimeTick() - this.mLastUpdateTime >= UPDATE_INTERVAL) {
                updateCpuUsage();
            }
            iArr = new int[]{(int) (this.mLastAppCpuUsage * 10.0f), (int) (this.mLastSysCpuUsage * 10.0f)};
        }
        return iArr;
    }
}
