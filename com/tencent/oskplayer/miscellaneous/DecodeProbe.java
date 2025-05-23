package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.oskplayer.miscellaneous.HardwareDecodeProbe;
import com.tencent.oskplayer.miscellaneous.SoftwareDecodeProbe;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@TargetApi(17)
/* loaded from: classes22.dex */
public class DecodeProbe {
    public static final String TAG = "DecodeProbe";
    private static final String outDirBasePath = "video_dec_probe";
    private static String outDirPath = "";
    HardwareDecodeProbe mHardwareDecodeProbe;
    Set<Integer> mSaveFrameSet;
    SoftwareDecodeProbe mSoftwareProbe;

    /* loaded from: classes22.dex */
    private static class SingletonHolder {
        private static DecodeProbe instance = new DecodeProbe();

        SingletonHolder() {
        }
    }

    private void deleteRecursive(File file) {
        File[] fileArr;
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            fileArr = file.listFiles();
        } else {
            fileArr = null;
        }
        if (fileArr != null) {
            for (File file2 : fileArr) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }

    private boolean failedEnsurePicOutDir() {
        return TextUtils.isEmpty(OskFile.ensureFilesDir(outDirBasePath));
    }

    public static DecodeProbe getInstance() {
        return SingletonHolder.instance;
    }

    public void addSaveFrame(int... iArr) {
        for (int i3 : iArr) {
            this.mSaveFrameSet.add(Integer.valueOf(i3));
        }
    }

    public void cleanPicOutDir() {
        deleteRecursive(getPicOutDir());
    }

    public long getHwDecodeAvgCost() {
        HardwareDecodeProbe hardwareDecodeProbe = this.mHardwareDecodeProbe;
        if (hardwareDecodeProbe == null) {
            return 0L;
        }
        return hardwareDecodeProbe.getDecodeFrameAvgCost();
    }

    public File getPicOutDir() {
        String picOutDirPath = getPicOutDirPath();
        if (!TextUtils.isEmpty(picOutDirPath)) {
            return new File(picOutDirPath);
        }
        return null;
    }

    public String getPicOutDirPath() {
        if (TextUtils.isEmpty(outDirPath)) {
            outDirPath = OskFile.ensureFilesDir(outDirBasePath);
        }
        return outDirPath;
    }

    public long getSwDecodeAvgCost() {
        if (this.mSoftwareProbe == null) {
            return 0L;
        }
        return SoftwareDecodeProbe.getDecodeFrameAvgCost();
    }

    public int hwProbe(String str) {
        if (failedEnsurePicOutDir()) {
            return 60000;
        }
        int probe = this.mHardwareDecodeProbe.probe(str, getPicOutDirPath(), this.mSaveFrameSet);
        if (probe != 0) {
            return probe;
        }
        return 0;
    }

    public int probe(String str) {
        if (failedEnsurePicOutDir()) {
            return 60000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int probe = this.mHardwareDecodeProbe.probe(str, getPicOutDirPath(), this.mSaveFrameSet);
        if (probe != 0) {
            return probe;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ILogger g16 = Logger.g();
        String str2 = TAG;
        g16.d(str2, "[probe] hw probe cost=" + currentTimeMillis2 + ", decode frame avg cost=" + this.mHardwareDecodeProbe.getDecodeFrameAvgCost());
        long currentTimeMillis3 = System.currentTimeMillis();
        int probe2 = this.mSoftwareProbe.probe(str, getPicOutDirPath(), this.mSaveFrameSet);
        if (probe2 != 0) {
            return probe2;
        }
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        Logger.g().d(str2, "[probe] sw probe cost=" + currentTimeMillis4 + ", decode frame avg cost=" + SoftwareDecodeProbe.getDecodeFrameAvgCost());
        return 0;
    }

    public void setHwProbeCallback(HardwareDecodeProbe.HwProbeCallback hwProbeCallback) {
        this.mHardwareDecodeProbe.setProbeCallback(hwProbeCallback);
    }

    public void setSwProbeCallback(SoftwareDecodeProbe.SwProbeCallback swProbeCallback) {
        SoftwareDecodeProbe.setProbeCallback(swProbeCallback);
    }

    public int swProbe(String str) {
        if (failedEnsurePicOutDir()) {
            return 60000;
        }
        int probe = this.mSoftwareProbe.probe(str, getPicOutDirPath(), this.mSaveFrameSet);
        if (probe != 0) {
            return probe;
        }
        return 0;
    }

    DecodeProbe() {
        this.mSaveFrameSet = new HashSet();
        this.mHardwareDecodeProbe = new HardwareDecodeProbe();
        this.mSoftwareProbe = new SoftwareDecodeProbe();
    }
}
