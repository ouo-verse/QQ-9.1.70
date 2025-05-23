package com.tencent.thumbplayer.core.datatransport.apiinner;

import android.text.TextUtils;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.List;

/* loaded from: classes26.dex */
public class TPDataTransportOfflineTaskMgrImpl implements ITPDataTransportOfflineTaskMgr {
    private final ITPDataTransportLog mLogger;
    private boolean mUseService;

    public TPDataTransportOfflineTaskMgrImpl(boolean z16) {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportOfflineTaskMgrImpl");
        this.mLogger = logger;
        logger.i("construct start, use service:" + z16);
        this.mUseService = z16;
    }

    private boolean isNativeNotInit() {
        return !TPDownloadProxyNative.getInstance().isNativeLoaded();
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public int createMultiOfflineTask(List<TPDataTransportTaskParam> list, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.createMultiOfflineTask(list, offlineTaskListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public int createOfflineTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.createOfflineTask(tPDataTransportTaskParam, offlineTaskListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public String getHLSOfflineExtTag(String str, String str2, int i3, long j3) {
        if (!isNativeNotInit() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(str, str2, i3, j3));
            } catch (Throwable th5) {
                this.mLogger.e("getHLSOfflineExtTag failed, error:" + th5);
                return "";
            }
        }
        this.mLogger.e("getHLSOfflineExtTag failed, native not loaded or params invalid, vid:" + str + ", linkVid:" + str2 + ", formatId:" + i3 + ", random:" + j3);
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public int removeOfflineTask(int i3, String str) {
        if (!isNativeNotInit() && i3 > 0 && !TextUtils.isEmpty(str)) {
            try {
                String bizDataDir = TPDataTransportBizIdCreator.getInstance().getBizDataDir(i3);
                if (TextUtils.isEmpty(bizDataDir)) {
                    this.mLogger.e("removeOfflineTask failed, data dir is empty, bizId:" + i3);
                    return -1;
                }
                return TPDownloadProxyNative.getInstance().deleteCache(bizDataDir, str);
            } catch (Throwable th5) {
                this.mLogger.e("removeOfflineTask failed, error:" + th5);
                return -1;
            }
        }
        this.mLogger.e("removeOfflineTask failed, native not loaded or param invalid, bizId:" + i3 + ", fileId:" + str);
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public void startOfflineTask(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.startTask(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public void stopOfflineTask(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.stopTask(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public void updateOfflinePath(int i3, String str) {
        if (!isNativeNotInit() && i3 > 0) {
            this.mLogger.i("bizId:" + i3 + " , savePath:" + str);
            if (TPDataTransportBizIdCreator.getInstance().updateBizIdDataDir(i3, str)) {
                this.mLogger.i("bizId:" + i3 + " , update data dir success!");
            }
            try {
                TPDownloadProxyNative.getInstance().updateStoragePath(i3, str);
                return;
            } catch (Throwable th5) {
                this.mLogger.e("updateOfflinePath failed, error:" + th5);
                return;
            }
        }
        this.mLogger.e("updateOfflinePath failed, native not loaded or param invalid, bizId:" + i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr
    public long verifyOfflineCacheSync(String str, int i3, String str2, String str3) {
        if (!isNativeNotInit() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                return TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(str, i3, str2, str3);
            } catch (Throwable th5) {
                this.mLogger.e("verifyOfflineCacheSync failed, error:" + th5);
                return -1L;
            }
        }
        this.mLogger.e("verifyOfflineCacheSync failed, native not loaded or params invalid, diskPath:" + str + ", fileFormat:" + i3 + ", resourceId:" + str2 + ", keyId:" + str3);
        return -1L;
    }
}
