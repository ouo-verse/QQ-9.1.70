package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoader {
    public static int SV_SO_LOAD_STATUS_artfilter = -4;
    public static final String SV_SO_QMCF = "libQMCF.so";
    private static final String TAG = "SoLoader";
    public static final int VIDEO_FILE_NOT_FIND = -2;
    public static final int VIDEO_INVALID_PARAM = -1;
    public static final int VIDEO_LOAD_ERROR = -3;
    public static final int VIDEO_LOAD_SUCCESS = 0;
    public static final int VIDEO_LOAD_UNINIT = -4;
    private static int VIDEO_SO_LOAD_STATUS = 0;
    public static final int VIDEO_SO_VERSION_ERR = -5;
    public static final String[] SV_SO_QMCF_SNPE = {"libsymphonypower.so", "libsymphony-cpu.so", "libSNPE.so", "libQMCF_snpe.so"};
    public static int[] SV_SO_QMCF_SNPE_LOAD_STATUS = {-4, -4, -4, -4};
    private static boolean isQmcfSoExist = false;
    public static boolean bGetLicensed = false;

    private static int LoadExtractedShortVideoFilterLib(String str) {
        if (str == null) {
            return -1;
        }
        if (!new File(str).exists()) {
            return -2;
        }
        try {
            System.load(str);
            return 0;
        } catch (UnsatisfiedLinkError e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "LoadExtractedShortVideoFilterLib, path:" + str + ", exp:", e16);
            }
            return -3;
        }
    }

    public static boolean isLoadArtFilterSuccess() {
        if (SLog.isEnable()) {
            SLog.i(TAG, String.format("isLoadArtFilterSuccess, status=[%S]", Integer.valueOf(SV_SO_LOAD_STATUS_artfilter)));
        }
        if (SV_SO_LOAD_STATUS_artfilter != 0) {
            return false;
        }
        return true;
    }

    public static boolean isQmcfSoExist() {
        if (isQmcfSoExist) {
            return true;
        }
        String soPathDir = SdkContext.getInstance().getResources().getArtFilterResource().getSoPathDir();
        if (soPathDir == null) {
            return false;
        }
        isQmcfSoExist = FileUtils.fileExists(soPathDir + SV_SO_QMCF);
        boolean fileExists = FileUtils.fileExists(soPathDir + SV_SO_QMCF_SNPE[4]);
        if (SLog.isEnable()) {
            SLog.i(TAG, String.format("isQmcfSoExist, qmcf[%s], snpe[%s]", Boolean.valueOf(isQmcfSoExist), Boolean.valueOf(fileExists)));
        }
        return isQmcfSoExist;
    }

    public static boolean isQmcfSoUnLoaded() {
        if (SV_SO_LOAD_STATUS_artfilter == -4) {
            return true;
        }
        return false;
    }

    private static boolean loadArtFilterSo() {
        if (isLoadArtFilterSuccess()) {
            return true;
        }
        if (SdkContext.getInstance().getResources() == null) {
            return false;
        }
        String soPathDir = SdkContext.getInstance().getResources().getArtFilterResource().getSoPathDir();
        if (SV_SO_LOAD_STATUS_artfilter != 0) {
            if (FileUtils.fileExists(soPathDir + SV_SO_QMCF_SNPE[3])) {
                try {
                    System.loadLibrary("c++_shared");
                    if (SLog.isEnable()) {
                        SLog.i(TAG, "load c++_shared success");
                    }
                } catch (Error unused) {
                }
                int i3 = 0;
                while (true) {
                    String[] strArr = SV_SO_QMCF_SNPE;
                    if (i3 >= strArr.length) {
                        break;
                    }
                    int[] iArr = SV_SO_QMCF_SNPE_LOAD_STATUS;
                    if (iArr[i3] != 0) {
                        iArr[i3] = LoadExtractedShortVideoFilterLib(soPathDir + strArr[i3]);
                    }
                    if (SLog.isEnable()) {
                        SLog.i(TAG, String.format("loadSnpeSo, idx[%d], bSuc[%s]", Integer.valueOf(i3), Integer.valueOf(SV_SO_QMCF_SNPE_LOAD_STATUS[i3])));
                    }
                    i3++;
                }
                boolean z16 = true;
                for (int i16 : SV_SO_QMCF_SNPE_LOAD_STATUS) {
                    if (i16 != 0) {
                        z16 = false;
                    }
                }
                if (z16) {
                    QmcfManager.hasSNPESo = true;
                }
            }
            SV_SO_LOAD_STATUS_artfilter = LoadExtractedShortVideoFilterLib(soPathDir + SV_SO_QMCF);
        }
        boolean isLoadArtFilterSuccess = isLoadArtFilterSuccess();
        if (SLog.isEnable()) {
            SLog.i(TAG, String.format("loadArtFilterSo, bSuc[%s], snpeSuc[%s], soPath[%s]", Boolean.valueOf(isLoadArtFilterSuccess), Boolean.valueOf(QmcfManager.hasSNPESo), soPathDir));
        }
        return isLoadArtFilterSuccess;
    }

    public static synchronized boolean loadSvArtFilterSO(Context context) {
        boolean loadArtFilterSo;
        synchronized (SoLoader.class) {
            loadArtFilterSo = loadArtFilterSo();
        }
        return loadArtFilterSo;
    }
}
