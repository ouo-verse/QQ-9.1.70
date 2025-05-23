package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferEngine implements IExcitingTransferEngineCallback {
    static String TAG = "ExcitingTransferEngine";
    private static ExcitingTransferEngine s_instance;
    private HashMap<Long, ExcitingSendJobContent> mSendJobs = new LinkedHashMap();
    private HashMap<Long, ExcitingRecvJobContent> mRecvJobs = new LinkedHashMap();
    private boolean mInited = false;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ExcitingRecvJobContent {
        ExcitingTransferDownloadReqInfo mExcRecvReqInfo;
        long mExcitingID;
        IExcitingTransferRecvListener mListener;

        public ExcitingRecvJobContent(long j3, ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo, IExcitingTransferRecvListener iExcitingTransferRecvListener) {
            this.mExcitingID = j3;
            this.mExcRecvReqInfo = excitingTransferDownloadReqInfo;
            this.mListener = iExcitingTransferRecvListener;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class ExcitingSendInfo {
        public ExcitingTransferUploadBizInfo mBusInfo;
        public ExcitingTransferUploadChnConfigInfo mConfig;
        public ExcitingTransferUploadFileEntry mFileEntry;
        public ExcitingTransferUploadReqInfo mReqInfo;

        public String toString() {
            return "reqinfo:{" + this.mReqInfo.toString() + "} fileentry{" + this.mFileEntry.toString() + "} busInfo{" + this.mBusInfo.toString() + "} config {" + this.mConfig.toString() + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ExcitingSendJobContent {
        ExcitingSendInfo mExcSendInfo;
        long mExcitingID;
        IExcitingTransferSendListener mListener;

        public ExcitingSendJobContent(long j3, ExcitingSendInfo excitingSendInfo, IExcitingTransferSendListener iExcitingTransferSendListener) {
            this.mExcitingID = j3;
            this.mExcSendInfo = excitingSendInfo;
            this.mListener = iExcitingTransferSendListener;
        }
    }

    ExcitingTransferEngine() {
        ExcitingTransferNative.load();
    }

    private synchronized void addRecvJobContent(long j3, ExcitingRecvJobContent excitingRecvJobContent) {
        this.mRecvJobs.put(Long.valueOf(j3), excitingRecvJobContent);
    }

    private synchronized void addSendJobContent(long j3, ExcitingSendJobContent excitingSendJobContent) {
        this.mSendJobs.put(Long.valueOf(j3), excitingSendJobContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void delRecvJobContent(long j3) {
        this.mRecvJobs.remove(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void delSendJobContent(long j3) {
        this.mSendJobs.remove(Long.valueOf(j3));
    }

    public static synchronized ExcitingTransferEngine getInstance() {
        ExcitingTransferEngine excitingTransferEngine;
        synchronized (ExcitingTransferEngine.class) {
            if (s_instance == null) {
                s_instance = new ExcitingTransferEngine();
            }
            if (!s_instance.isInited()) {
                s_instance.init();
            }
            excitingTransferEngine = s_instance;
        }
        return excitingTransferEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ExcitingRecvJobContent getRecvJobContent(long j3) {
        return this.mRecvJobs.get(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ExcitingSendJobContent getSendJobContent(long j3) {
        return this.mSendJobs.get(Long.valueOf(j3));
    }

    private void init() {
        if (this.mInited) {
            return;
        }
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "init...");
        ExcitingTransferNative.init(this);
        ExcitingTransferNative.setRecvFileConfig(new ExcitingTransferDownloadConfig());
        this.mInited = true;
    }

    private boolean isInited() {
        return this.mInited;
    }

    public void cancelRecvFile(long j3) {
        delRecvJobContent(j3);
        ExcitingTransferNative.cancelRecvFile(j3);
    }

    public void cancelSendFile(long j3) {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "cancelSendFile:" + j3);
        delSendJobContent(j3);
        ExcitingTransferNative.cancelSendFile(j3);
    }

    public void detectLanChannel(ExcitingTransferUdpDetectInfo excitingTransferUdpDetectInfo) {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "detectLanChannel:" + excitingTransferUdpDetectInfo.toString());
        ExcitingTransferNative.detectLanChannel(excitingTransferUdpDetectInfo);
    }

    @Deprecated
    public long getAutoDownloadSize() {
        return ExcitingTransferNative.getAutoDownloadSize();
    }

    @Deprecated
    public ExcitingTransferConfigInfo getDownloadConfig() {
        return ExcitingTransferNative.getDownloadConfig();
    }

    @Deprecated
    public long getDownloadPieceSize() {
        return ExcitingTransferNative.getDownloadPieceSize();
    }

    public ExcitingTransferHostInfo getNextBigDataHost(long j3) {
        return null;
    }

    @Deprecated
    public boolean isXTFDownloadEnable() {
        return ExcitingTransferNative.isXTFDownloadEnable();
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onOneSlotComplete(final long j3, final int i3, final ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.8
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferRecvListener iExcitingTransferRecvListener;
                ExcitingRecvJobContent recvJobContent = ExcitingTransferEngine.this.getRecvJobContent(j3);
                if (recvJobContent != null && (iExcitingTransferRecvListener = recvJobContent.mListener) != null) {
                    iExcitingTransferRecvListener.onOneSlotComplete(i3, excitingTransferOneSlotComplete);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onRecvComplete(final long j3, final int i3, final ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.6
            @Override // java.lang.Runnable
            public void run() {
                ExcitingRecvJobContent recvJobContent = ExcitingTransferEngine.this.getRecvJobContent(j3);
                if (recvJobContent == null) {
                    return;
                }
                IExcitingTransferRecvListener iExcitingTransferRecvListener = recvJobContent.mListener;
                if (iExcitingTransferRecvListener != null) {
                    iExcitingTransferRecvListener.onRecvComplete(i3, excitingTransferDownloadCompletedInfo);
                }
                ExcitingTransferEngine.this.delRecvJobContent(j3);
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onRecvProgress(final long j3, final long j16, final long j17, final long j18) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.7
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferRecvListener iExcitingTransferRecvListener;
                ExcitingRecvJobContent recvJobContent = ExcitingTransferEngine.this.getRecvJobContent(j3);
                if (recvJobContent != null && (iExcitingTransferRecvListener = recvJobContent.mListener) != null) {
                    iExcitingTransferRecvListener.onRecvProgress(j16, j17, j18);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onRecvStart(final long j3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.5
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferRecvListener iExcitingTransferRecvListener;
                ExcitingRecvJobContent recvJobContent = ExcitingTransferEngine.this.getRecvJobContent(j3);
                if (recvJobContent != null && (iExcitingTransferRecvListener = recvJobContent.mListener) != null) {
                    iExcitingTransferRecvListener.onRecvStart();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onSendComplete(final long j3, final int i3, final ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        ExcitingSendJobContent sendJobContent = getSendJobContent(j3);
        if (sendJobContent == null) {
            return;
        }
        if (sendJobContent.mExcSendInfo.mBusInfo.bUseMediaPlatform && i3 == 0) {
            excitingTransferUploadResultRp.mstrFileIdCrc = ExcitingTransferNative.getMediaFileIdCrc(j3);
            ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "excitingID[" + j3 + "] onSendComplete success, bUseMediaPlatform:true, m_strFileIdCrc:" + excitingTransferUploadResultRp.mstrFileIdCrc);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                ExcitingSendJobContent sendJobContent2 = ExcitingTransferEngine.this.getSendJobContent(j3);
                if (sendJobContent2 == null) {
                    return;
                }
                IExcitingTransferSendListener iExcitingTransferSendListener = sendJobContent2.mListener;
                if (iExcitingTransferSendListener != null) {
                    int i16 = i3;
                    if (i16 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    iExcitingTransferSendListener.onExcitingSendResult(z16, i16, excitingTransferUploadResultRp);
                }
                ExcitingTransferEngine.this.delSendJobContent(j3);
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onSendProgress(final long j3, final long j16, final long j17, final long j18, long j19) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.3
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferSendListener iExcitingTransferSendListener;
                ExcitingSendJobContent sendJobContent = ExcitingTransferEngine.this.getSendJobContent(j3);
                if (sendJobContent != null && (iExcitingTransferSendListener = sendJobContent.mListener) != null) {
                    iExcitingTransferSendListener.onExcitingSendProgress(j17, j16, j18);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onSendStart(final long j3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.1
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferSendListener iExcitingTransferSendListener;
                ExcitingSendJobContent sendJobContent = ExcitingTransferEngine.this.getSendJobContent(j3);
                if (sendJobContent != null && (iExcitingTransferSendListener = sendJobContent.mListener) != null) {
                    iExcitingTransferSendListener.onExcitingSendStart();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onSpeed(final long j3, final ExcitingTransferDownloadSpeedInfo excitingTransferDownloadSpeedInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.9
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferRecvListener iExcitingTransferRecvListener;
                ExcitingRecvJobContent recvJobContent = ExcitingTransferEngine.this.getRecvJobContent(j3);
                if (recvJobContent != null && (iExcitingTransferRecvListener = recvJobContent.mListener) != null) {
                    iExcitingTransferRecvListener.onSpeed(excitingTransferDownloadSpeedInfo);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
    public void onSubSenderResult(final long j3, final int i3, final ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.4
            @Override // java.lang.Runnable
            public void run() {
                IExcitingTransferSendListener iExcitingTransferSendListener;
                ExcitingSendJobContent sendJobContent = ExcitingTransferEngine.this.getSendJobContent(j3);
                if (sendJobContent != null && (iExcitingTransferSendListener = sendJobContent.mListener) != null) {
                    iExcitingTransferSendListener.onExcitingSubSenderResult(i3, excitingTransferUploaderRp);
                }
            }
        });
    }

    public long recvFile(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo, IExcitingTransferRecvListener iExcitingTransferRecvListener) {
        long recvFile = ExcitingTransferNative.recvFile(excitingTransferDownloadReqInfo);
        if (recvFile != -1) {
            addRecvJobContent(recvFile, new ExcitingRecvJobContent(recvFile, excitingTransferDownloadReqInfo, iExcitingTransferRecvListener));
        }
        return recvFile;
    }

    public long recvFileEx(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo, ExcitingTransferDownloadConfig excitingTransferDownloadConfig, IExcitingTransferRecvListener iExcitingTransferRecvListener) {
        long recvFileEx = ExcitingTransferNative.recvFileEx(excitingTransferDownloadReqInfo, excitingTransferDownloadConfig);
        if (recvFileEx != -1) {
            addRecvJobContent(recvFileEx, new ExcitingRecvJobContent(recvFileEx, excitingTransferDownloadReqInfo, iExcitingTransferRecvListener));
        }
        return recvFileEx;
    }

    @Deprecated
    public void resetDownloadConfig() {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "resetDownloadConfig...");
        ExcitingTransferNative.resetDownloadConfig();
    }

    public long sendFile(ExcitingSendInfo excitingSendInfo, IExcitingTransferSendListener iExcitingTransferSendListener) {
        long sendFile = ExcitingTransferNative.sendFile(excitingSendInfo.mReqInfo, excitingSendInfo.mFileEntry, excitingSendInfo.mBusInfo, excitingSendInfo.mConfig);
        if (sendFile != -1) {
            addSendJobContent(sendFile, new ExcitingSendJobContent(sendFile, excitingSendInfo, iExcitingTransferSendListener));
        }
        return sendFile;
    }

    @Deprecated
    public void setDownloadConfig(ExcitingTransferConfigInfo excitingTransferConfigInfo) {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setDownloadConfig:" + excitingTransferConfigInfo.toString());
        ExcitingTransferNative.setDownloadConfig(excitingTransferConfigInfo);
    }

    public void setGlobalProxyInfo(int i3, String str, short s16, String str2, String str3) {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setGlobalProxyInfo proxyType:" + i3 + "strProxyip:" + str + "proxyport:" + ((int) s16) + "strUsename:" + str2 + "strPassword:" + str3);
        ExcitingTransferNative.setGlobalProxyInfo(i3, str, s16, str2, str3);
    }

    public void setRecvFileConfig(ExcitingTransferDownloadConfig excitingTransferDownloadConfig) {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setRecvFileConfig:" + excitingTransferDownloadConfig.toString());
        ExcitingTransferNative.setRecvFileConfig(excitingTransferDownloadConfig);
    }

    public void setSendFileConfig(ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo) {
        ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setSendFileConfig:" + excitingTransferUploadChnConfigInfo.toString());
        ExcitingTransferNative.setSendFileConfig(excitingTransferUploadChnConfigInfo);
    }

    public void setFailBigDataHost(long j3, String str, int i3) {
    }
}
