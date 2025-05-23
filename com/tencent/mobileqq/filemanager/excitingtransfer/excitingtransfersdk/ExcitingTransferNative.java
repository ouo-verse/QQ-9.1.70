package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferNative {
    static {
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "xplatform", 0, false);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "mbedtlsall", 0, false);
        } catch (UnsatisfiedLinkError e17) {
            e17.printStackTrace();
        }
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "excitingtransfer", 0, false);
        } catch (UnsatisfiedLinkError e18) {
            e18.printStackTrace();
        }
    }

    public static native void cancelRecvFile(long j3);

    public static native void cancelSendFile(long j3);

    public static native void detectLanChannel(ExcitingTransferUdpDetectInfo excitingTransferUdpDetectInfo);

    public static native long getAutoDownloadSize();

    @Deprecated
    public static native ExcitingTransferConfigInfo getDownloadConfig();

    public static native long getDownloadPieceSize();

    public static native String getMediaFileIdCrc(long j3);

    public static native void init(IExcitingTransferEngineCallback iExcitingTransferEngineCallback);

    public static native boolean isXTFDownloadEnable();

    public static native long recvFile(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo);

    public static native long recvFileEx(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo, ExcitingTransferDownloadConfig excitingTransferDownloadConfig);

    @Deprecated
    public static native void resetDownloadConfig();

    public static native long sendFile(ExcitingTransferUploadReqInfo excitingTransferUploadReqInfo, ExcitingTransferUploadFileEntry excitingTransferUploadFileEntry, ExcitingTransferUploadBizInfo excitingTransferUploadBizInfo, ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo);

    @Deprecated
    public static native void setDownloadConfig(ExcitingTransferConfigInfo excitingTransferConfigInfo);

    public static native void setGlobalProxyInfo(int i3, String str, short s16, String str2, String str3);

    public static native void setRecvFileConfig(ExcitingTransferDownloadConfig excitingTransferDownloadConfig);

    public static native void setSendFileConfig(ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo);

    public static native void unInit();

    public static void load() {
    }
}
