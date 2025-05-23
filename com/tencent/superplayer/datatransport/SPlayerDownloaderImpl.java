package com.tencent.superplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class SPlayerDownloaderImpl implements ISPlayerDownloader {
    private static final String TAG = "SPlayerDownloaderImpl";
    private ITPDownloadProxy mTPDownloadProxy;

    public SPlayerDownloaderImpl(Context context, int i3) {
        CommonUtil.j(CommonUtil.i(i3));
        this.mTPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(CommonUtil.i(i3));
    }

    private int getDlTypeForDownloadParam(int i3) {
        if (i3 != 101) {
            if (i3 != 102) {
                if (i3 != 105) {
                    return 0;
                }
                return 10;
            }
            return 3;
        }
        return 1;
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader
    public void pauseOfflineDownload(int i3) {
        ITPDownloadProxy iTPDownloadProxy = this.mTPDownloadProxy;
        if (iTPDownloadProxy != null) {
            iTPDownloadProxy.pauseDownload(i3);
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader
    public void resumeOfflineDownload(int i3) {
        ITPDownloadProxy iTPDownloadProxy = this.mTPDownloadProxy;
        if (iTPDownloadProxy != null) {
            iTPDownloadProxy.resumeDownload(i3);
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader
    public int startOfflineDownload(SuperPlayerVideoInfo superPlayerVideoInfo, final ISPlayerDownloader.Listener listener) {
        if (this.mTPDownloadProxy != null && superPlayerVideoInfo != null) {
            superPlayerVideoInfo.setFileId(CommonUtil.a(superPlayerVideoInfo));
            CommonUtil.q(superPlayerVideoInfo, getDlTypeForDownloadParam(superPlayerVideoInfo.getFormat()), superPlayerVideoInfo.getExtraDownloadParams());
            HashMap hashMap = new HashMap();
            hashMap.putAll(superPlayerVideoInfo.getExtraDownloadParams());
            Map<String, String> e16 = CommonUtil.e(superPlayerVideoInfo);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(superPlayerVideoInfo.getPlayUrl());
            arrayList2.add(e16);
            if (superPlayerVideoInfo.getPlayUrls() != null && superPlayerVideoInfo.getPlayUrls().length > 0) {
                String[] playUrls = superPlayerVideoInfo.getPlayUrls();
                if (playUrls != null && playUrls.length > 0) {
                    for (String str : playUrls) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
                arrayList2.add(e16);
            }
            hashMap.put("dl_param_url_header", arrayList2);
            int startOfflineDownload = this.mTPDownloadProxy.startOfflineDownload(CommonUtil.a(superPlayerVideoInfo), new TPDownloadParam(arrayList, getDlTypeForDownloadParam(superPlayerVideoInfo.getFormat()), hashMap), null);
            TPDataTransportTaskListenerMgr.getInstance().addOfflineTaskListener(startOfflineDownload, new ITPDataTransportOfflineTaskMgr.OfflineTaskListener() { // from class: com.tencent.superplayer.datatransport.SPlayerDownloaderImpl.1
                @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr.OfflineTaskListener
                public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
                    ISPlayerDownloader.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onCommonMessageCallback(i3, i16, tPDataTransportMessageInfo);
                    }
                }

                @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr.OfflineTaskListener
                public void onDownloadError(int i3, int i16, int i17, String str2) {
                    ISPlayerDownloader.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onDownloadError(i3, i16, i17, str2);
                    }
                }

                @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr.OfflineTaskListener
                public void onDownloadFinished(int i3) {
                    ISPlayerDownloader.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onDownloadFinish(i3);
                    }
                }

                @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr.OfflineTaskListener
                public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str2) {
                    ISPlayerDownloader.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onDownloadProgressUpdate(i3, i16, i17, j3, j16, str2);
                    }
                }
            });
            this.mTPDownloadProxy.startTask(startOfflineDownload);
            return startOfflineDownload;
        }
        LogUtil.e(TAG, "error, mTPDownloadProxy = " + this.mTPDownloadProxy + ", videoInfo = " + superPlayerVideoInfo + ", return");
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader
    public void stopOfflineDownload(int i3) {
        ITPDownloadProxy iTPDownloadProxy = this.mTPDownloadProxy;
        if (iTPDownloadProxy != null) {
            iTPDownloadProxy.stopOfflineDownload(i3);
            TPDataTransportTaskListenerMgr.getInstance().removeTaskListener(i3);
        }
    }
}
