package com.tencent.thumbplayer.core.datatransport.service;

import android.text.TextUtils;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportBizIdCreator;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

/* loaded from: classes26.dex */
public class TPDataTransportRemoteBridgeImpl extends ITPDataTransportRemoteBridge.Stub {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportRemoteBridgeImpl");
    private ITPDataTransportRemote mRemoteDataTransport = null;

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public int checkFileCacheStatus(int i3, String str, int i16) {
        if (!isNativeInit()) {
            this.mLogger.e("checkFileCacheStatus failed, native is not loaded!");
            return -1;
        }
        try {
            return TPDownloadProxyNative.getInstance().checkResourceStatus(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str, i16);
        } catch (Throwable th5) {
            this.mLogger.e("checkFileCacheStatus failed, error:" + th5);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public boolean clearCache(int i3, String str, int i16) {
        if (!isNativeInit()) {
            this.mLogger.e("clearCache failed, native is not loaded!");
            return false;
        }
        try {
            String bizDataDir = TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3);
            if (str == null) {
                str = "";
            }
            if (TPDownloadProxyNative.getInstance().clearCache(bizDataDir, str, i16) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("clearCache failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public boolean clearRangeCache(int i3, String str, int i16, int i17) {
        if (!isNativeInit()) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, native is not loaded!");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, file id is empty!");
            return false;
        }
        try {
            if (TPDownloadProxyNative.getInstance().clearRangeCache(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str, i16, i17) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("clearRangeCache failed, error:" + th5);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public String getBizAccessibleNativeInfo(int i3, int i16) {
        if (!isNativeInit()) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, native is not loaded!");
            return "";
        }
        try {
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getBizAccessibleNativeInfo(i3, i16));
        } catch (Throwable th5) {
            this.mLogger.e("getBizAccessibleNativeInfo failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public long getFileCacheSize(int i3, String str) {
        if (!isNativeInit()) {
            this.mLogger.e("getFileCacheSize failed, native is not loaded!");
            return -1L;
        }
        try {
            return TPDownloadProxyNative.getInstance().getResourceSize(TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3), str);
        } catch (Throwable th5) {
            this.mLogger.e("getFileCacheSize failed, error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public String getGlobalAccessibleNativeInfo(int i3) {
        if (!isNativeInit()) {
            this.mLogger.e("getGlobalAccessibleNativeInfo failed, native is not loaded!");
            return "";
        }
        try {
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getGlobalAccessibleNativeInfo(i3));
        } catch (Throwable th5) {
            this.mLogger.e("getGlobalAccessibleNativeInfo failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public String getNativeVersion() {
        if (!isNativeInit()) {
            this.mLogger.e("getNativeVersion failed, native is not loaded!");
            return "";
        }
        try {
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        } catch (Throwable th5) {
            this.mLogger.e("getNativeVersion failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public ITPDataTransportRemote getRemoteDataTransport() {
        if (this.mRemoteDataTransport == null) {
            this.mRemoteDataTransport = new TPDataTransportRemoteImpl();
        }
        return this.mRemoteDataTransport;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public int initBizId(int i3) {
        if (!isNativeInit()) {
            this.mLogger.e("initBizId failed, native is not loaded!");
            return -1;
        }
        return TPDownloadProxyNative.getInstance().initBizId(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public boolean isNativeInit() {
        return TPDownloadProxyNative.getInstance().isNativeLoaded();
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public int registerAssignedBizId(int i3, String str) {
        if (!isNativeInit()) {
            this.mLogger.e("registerCustomizationBizId failed, native is not loaded!");
            return -1;
        }
        int registerBizId = TPDataTransportBizIdCreator.getInstance().registerBizId(i3, str);
        if (i3 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            TPDownloadProxyNative.getInstance().initBizId(registerBizId);
        }
        return registerBizId;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public int registerBizId(String str) {
        if (!isNativeInit()) {
            this.mLogger.e("registerBizId failed, native is not loaded!");
            return -1;
        }
        int registerBizId = TPDataTransportBizIdCreator.getInstance().registerBizId(str);
        this.mLogger.i("register bizId:" + registerBizId + ", dataDir:" + str);
        if (registerBizId <= 0 || TPDownloadProxyNative.getInstance().initBizId(registerBizId) != 0) {
            return -1;
        }
        this.mLogger.i("register bizId:" + registerBizId + ", dataDir:" + str + ", init succeed!");
        return registerBizId;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public void registerCommonInfoListener(final ITPDataTransportRemoteCommonInfoListener iTPDataTransportRemoteCommonInfoListener) {
        TPDataTransportTaskListenerMgr.getInstance().setCommonInfoListener(new ITPDataTransportCommonInfoListener() { // from class: com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteBridgeImpl.1
            @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener
            public void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
                try {
                    iTPDataTransportRemoteCommonInfoListener.onCommonInfoUpdate(i3, tPDataTransportMessageInfo);
                } catch (Throwable th5) {
                    TPDataTransportRemoteBridgeImpl.this.mLogger.e("registerCommonInfoListener failed, error:" + th5);
                }
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public boolean setBizOptionalConfigParam(int i3, String str, String str2) {
        if (!isNativeInit()) {
            this.mLogger.e("setBizOptionalConfigParam failed, native is not loaded!");
            return false;
        }
        try {
            TPDownloadProxyNative.getInstance().setBizOptionalConfigParam(i3, str, str2);
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("setBizOptionalConfigParam failed, error:" + th5);
            return true;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public boolean setGlobalOptionalConfigParam(String str, String str2) {
        if (!isNativeInit()) {
            this.mLogger.e("setGlobalOptionalConfigParam failed, native is not loaded!");
            return false;
        }
        try {
            TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(str, str2);
            return true;
        } catch (Throwable th5) {
            this.mLogger.e("setGlobalOptionalConfigParam failed, error:" + th5);
            return true;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
    public void unregisterBizId(int i3) {
        if (!isNativeInit()) {
            this.mLogger.e("unregisterBizId failed, native is not loaded!");
        } else {
            TPDataTransportBizIdCreator.getInstance().unregisterBizId(i3);
            TPDownloadProxyNative.getInstance().unregisterBizId(i3);
        }
    }
}
