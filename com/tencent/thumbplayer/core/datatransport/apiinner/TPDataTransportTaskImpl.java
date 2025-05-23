package com.tencent.thumbplayer.core.datatransport.apiinner;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.datatransport.util.TPTaskParamTransform;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes26.dex */
public class TPDataTransportTaskImpl implements ITPDataTransportTask {
    private static final ArrayList<String> sValidTaskOptionalConfigParams;
    private final ITPDataTransportLog mLogger;
    private final ConcurrentHashMap<Integer, Integer> mMultiTaskClipInfo;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sValidTaskOptionalConfigParams = arrayList;
        arrayList.add("taskinfo_play_offset");
        arrayList.add("taskinfo_speed_ratio");
        arrayList.add("optional_id_global_long_adaptive_limit_bitrate_range_max");
        arrayList.add("taskinfo_max_bitrate");
        arrayList.add(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_DYNAMIC_SWITCH);
        arrayList.add("taskinfo_adaptive_dynamic_switch");
        arrayList.add("taskinfo_adaptive_control_strategy");
        arrayList.add(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_STATE);
        arrayList.add(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_EVENT);
        arrayList.add(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_RUNNING_STATE);
        arrayList.add(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_MODE);
        arrayList.add(TPDataTransportEnum.TASK_OPTIONAL_SlEF_EMERGENCY_SAFE_TIME);
    }

    public TPDataTransportTaskImpl() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportTaskImpl");
        this.mLogger = logger;
        this.mMultiTaskClipInfo = new ConcurrentHashMap<>();
        logger.i("construct start");
    }

    private String buildClipFileId(TPDownloadParam tPDownloadParam) {
        String clipFileId = tPDownloadParam.getClipFileId();
        if (TextUtils.isEmpty(clipFileId)) {
            clipFileId = TPDLProxyUtils.generateMd5(tPDownloadParam.getCdnUrls());
        }
        if (TextUtils.isEmpty(clipFileId)) {
            return String.valueOf(System.currentTimeMillis());
        }
        return clipFileId;
    }

    private String buildFileId(TPDownloadParam tPDownloadParam) {
        StringBuilder sb5 = new StringBuilder(tPDownloadParam.getKeyid());
        if (sb5.length() == 0) {
            sb5.append(TPDLProxyUtils.generateMd5(tPDownloadParam.getCdnUrls()));
        }
        if (sb5.length() == 0) {
            sb5.append(System.currentTimeMillis());
        } else if (!tPDownloadParam.isDownloadDataReusable()) {
            sb5.append(".");
            sb5.append(System.currentTimeMillis());
        }
        return sb5.toString();
    }

    private boolean isNativeNotInit() {
        return !TPDownloadProxyNative.getInstance().isNativeLoaded();
    }

    private int sendCgiRequest(TPDownloadParam tPDownloadParam, ITPDataTransportTaskMgr.TaskListener taskListener) {
        if (isNativeNotInit()) {
            this.mLogger.e("sendCgiRequest failed, native not loaded");
            return -1;
        }
        int sendCgiRequest = TPDownloadProxyNative.getInstance().sendCgiRequest(tPDownloadParam.getCdnUrls(), tPDownloadParam.getExtraJsonInfo());
        if (sendCgiRequest > 0) {
            TPDataTransportTaskListenerMgr.getInstance().addTaskListener(sendCgiRequest, taskListener);
        }
        return sendCgiRequest;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createMultiOfflineTask(List<TPDataTransportTaskParam> list, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        TPDownloadParam convert;
        int i3;
        int i16 = -1;
        if (isNativeNotInit()) {
            this.mLogger.e("createMultiOfflineTask failed, native not loaded");
            return -1;
        }
        try {
            Iterator<TPDataTransportTaskParam> it = list.iterator();
            int i17 = 1;
            int i18 = -1;
            while (it.hasNext()) {
                try {
                    convert = TPTaskParamTransform.convert(it.next());
                    if (i18 == -1) {
                        i18 = TPDownloadProxyNative.getInstance().createDownloadTask(convert.getBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId()), buildFileId(convert), convert.getDlType() + 100, convert.getClipCount());
                        if (i18 > 0) {
                            TPDataTransportTaskListenerMgr.getInstance().addOfflineTaskListener(i18, offlineTaskListener);
                        } else {
                            return i18;
                        }
                    }
                    i3 = i18;
                } catch (Throwable th5) {
                    th = th5;
                    i16 = i18;
                }
                try {
                    TPDownloadProxyNative.getInstance().setClipInfo(i3, i17, buildClipFileId(convert), convert.getDlType() + 100, convert.getCdnUrls(), convert.getSavaPath(), convert.getExtraJsonInfo());
                    i17++;
                    i18 = i3;
                } catch (Throwable th6) {
                    th = th6;
                    i16 = i3;
                    this.mLogger.e("createMultiOfflineTask failed, error:" + th);
                    return i16;
                }
            }
            return i18;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createMultiTask(List<TPDataTransportTaskParam> list, ITPDataTransportTaskMgr.TaskListener taskListener) {
        int i3 = -1;
        if (isNativeNotInit()) {
            this.mLogger.e("createMultiTask failed, native not loaded");
            return -1;
        }
        try {
            Iterator<TPDataTransportTaskParam> it = list.iterator();
            int i16 = 1;
            int i17 = -1;
            while (it.hasNext()) {
                try {
                    TPDownloadParam convert = TPTaskParamTransform.convert(it.next());
                    int dlType = convert.getDlType();
                    if (convert.isOffline()) {
                        dlType += 300;
                    }
                    int i18 = dlType;
                    if (i17 == -1) {
                        i17 = TPDownloadProxyNative.getInstance().createDownloadTask(convert.getBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId()), buildFileId(convert), i18, list.size());
                        if (i17 <= 0) {
                            break;
                        }
                        TPDataTransportTaskListenerMgr.getInstance().addTaskListener(i17, taskListener);
                    }
                    int i19 = i17;
                    try {
                        TPDownloadProxyNative.getInstance().setClipInfo(i19, i16, buildClipFileId(convert), i18, convert.getCdnUrls(), convert.getSavaPath(), convert.getExtraJsonInfo());
                        i16++;
                        i17 = i19;
                    } catch (Throwable th5) {
                        th = th5;
                        i3 = i19;
                        this.mLogger.e("createMultiTask failed, error:" + th);
                        return i3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i3 = i17;
                }
            }
            i3 = i17;
            if (i3 > 0) {
                synchronized (this.mMultiTaskClipInfo) {
                    this.mMultiTaskClipInfo.put(Integer.valueOf(i3), Integer.valueOf(list.size()));
                }
            }
        } catch (Throwable th7) {
            th = th7;
            this.mLogger.e("createMultiTask failed, error:" + th);
            return i3;
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createOfflineTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        String clipFileId;
        int i3 = -1;
        if (isNativeNotInit()) {
            this.mLogger.e("createOfflineTask failed, native not loaded");
            return -1;
        }
        try {
            TPDownloadParam convert = TPTaskParamTransform.convert(tPDataTransportTaskParam);
            int dlType = convert.getDlType() + 100;
            int bizId = convert.getBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId());
            String buildFileId = buildFileId(convert);
            i3 = TPDownloadProxyNative.getInstance().createDownloadTask(bizId, buildFileId, dlType, convert.getClipCount());
            if (i3 > 0) {
                TPDataTransportTaskListenerMgr.getInstance().addOfflineTaskListener(i3, offlineTaskListener);
                if (TextUtils.isEmpty(convert.getClipFileId())) {
                    clipFileId = buildFileId;
                } else {
                    clipFileId = convert.getClipFileId();
                }
                TPDownloadProxyNative.getInstance().setClipInfo(i3, 1, clipFileId, dlType, convert.getCdnUrls(), convert.getSavaPath(), convert.getExtraJsonInfo());
            }
        } catch (Throwable th5) {
            this.mLogger.e("createOfflineTask failed, error:" + th5);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
        String clipFileId;
        int i3 = -1;
        if (isNativeNotInit()) {
            this.mLogger.e("createPreloadTask failed, native not loaded");
            return -1;
        }
        try {
            TPDownloadParam convert = TPTaskParamTransform.convert(tPDataTransportTaskParam);
            int dlType = convert.getDlType() + 200;
            int bizId = convert.getBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId());
            String buildFileId = buildFileId(convert);
            i3 = TPDownloadProxyNative.getInstance().createDownloadTask(bizId, buildFileId, dlType, convert.getClipCount());
            if (i3 > 0) {
                TPDataTransportTaskListenerMgr.getInstance().addPreloadTaskListener(i3, preloadTaskListener);
                if (TextUtils.isEmpty(convert.getClipFileId())) {
                    clipFileId = buildFileId;
                } else {
                    clipFileId = convert.getClipFileId();
                }
                TPDownloadProxyNative.getInstance().setClipInfo(i3, convert.getClipNo(), clipFileId, dlType, convert.getCdnUrls(), convert.getSavaPath(), convert.getExtraJsonInfo());
                TPDownloadProxyNative.getInstance().startDownload(i3);
            }
        } catch (Throwable th5) {
            this.mLogger.e("createPreloadTask failed, error:" + th5);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createTask(@NonNull TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportTaskMgr.TaskListener taskListener) {
        TPDownloadParam convert;
        int dlType;
        int i3 = -1;
        if (isNativeNotInit()) {
            this.mLogger.e("createTask failed, native not loaded");
            return -1;
        }
        try {
            convert = TPTaskParamTransform.convert(tPDataTransportTaskParam);
            dlType = convert.getDlType();
        } catch (Throwable th5) {
            this.mLogger.e("createTask failed, error:" + th5);
        }
        if (dlType == 24) {
            return sendCgiRequest(convert, taskListener);
        }
        if (convert.isOffline()) {
            dlType += 300;
        }
        if (convert.isAdaptive() && (dlType == 3 || dlType == 5)) {
            dlType += 400;
        }
        if (dlType == 16 && convert.isUseP2p()) {
            if (convert.isTencentCloudOrigin()) {
                convert.getExtInfoMap().put("package", TPDownloadProxyNative.getInstance().getAppContext().getPackageName());
                dlType = 12;
            } else {
                dlType = 23;
            }
        }
        int i16 = dlType;
        int bizId = convert.getBizId(TPDataTransportBizIdCreator.getInstance().getDefaultBizId());
        String buildFileId = buildFileId(convert);
        i3 = TPDownloadProxyNative.getInstance().createDownloadTask(bizId, buildFileId, i16, 1);
        if (i3 > 0) {
            TPDataTransportTaskListenerMgr.getInstance().addTaskListener(i3, taskListener);
            TPDownloadProxyNative.getInstance().setClipInfo(i3, 1, buildFileId, i16, convert.getCdnUrls(), convert.getSavaPath(), convert.getExtraJsonInfo());
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public ArrayList<String> getMultiProxyUrlList(int i3, int i16) {
        int i17;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!isNativeNotInit() && i3 > 0) {
            try {
                synchronized (this.mMultiTaskClipInfo) {
                    Integer num = this.mMultiTaskClipInfo.get(Integer.valueOf(i3));
                    if (num != null) {
                        i17 = num.intValue();
                    } else {
                        i17 = 0;
                    }
                }
                for (int i18 = 1; i18 <= i17; i18++) {
                    arrayList.add(TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i3, i18, i16)));
                }
            } catch (Throwable th5) {
                this.mLogger.e("getMultiProxyUrlList failed, taskId:" + i3 + ", error:" + th5);
            }
            return arrayList;
        }
        this.mLogger.e("getMultiProxyUrlList failed, native not loaded or taskId invalid:" + i3);
        return arrayList;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public String getProxyUrl(int i3, int i16) {
        if (!isNativeNotInit() && i3 > 0) {
            if (i16 != 2) {
                try {
                    TPDownloadProxyNative.getInstance().startDownload(i3);
                } catch (Throwable th5) {
                    this.mLogger.e("getProxyUrl failed, error:" + th5);
                    return "";
                }
            }
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i3, 1, i16));
        }
        this.mLogger.e("getProxyUrl failed, native not loaded or taskId invalid:" + i3);
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public String getTaskAccessibleNativeInfo(int i3, int i16) {
        if (i3 <= 0) {
            return "";
        }
        if (isNativeNotInit()) {
            this.mLogger.e("getTaskAccessibleNativeInfo failed, native not loaded, taskId :" + i3);
            return "";
        }
        try {
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getTaskAccessibleNativeInfo(i3, i16));
        } catch (Throwable th5) {
            this.mLogger.e("getTaskAccessibleNativeInfo failed, taskId:" + i3 + ", error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public String getTaskErrorCode(int i3) {
        if (!isNativeNotInit() && i3 > 0) {
            try {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(i3));
            } catch (Throwable th5) {
                this.mLogger.e("getTaskErrorCode failed, error:" + th5);
                return "";
            }
        }
        this.mLogger.e("getTaskErrorCode failed, native not loaded or taskId invalid:" + i3);
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void pauseTask(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (isNativeNotInit()) {
            this.mLogger.e("pauseTask failed, native not loaded, taskId:" + i3);
            return;
        }
        try {
            TPDownloadProxyNative.getInstance().pauseDownload(i3);
        } catch (Throwable th5) {
            this.mLogger.e("pauseTask failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void resumeTask(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (isNativeNotInit()) {
            this.mLogger.e("resumeTask failed, native not loaded, taskId:" + i3);
            return;
        }
        try {
            TPDownloadProxyNative.getInstance().resumeDownload(i3);
        } catch (Throwable th5) {
            this.mLogger.e("resumeTask failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void setTaskOptionalConfigParam(int i3, String str, String str2) {
        if (i3 <= 0) {
            return;
        }
        if (isNativeNotInit()) {
            this.mLogger.e("setTaskOptionalConfigParam failed, native not loaded, taskId:" + i3);
            return;
        }
        if (!sValidTaskOptionalConfigParams.contains(str)) {
            return;
        }
        try {
            if (str.equals(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_DYNAMIC_SWITCH)) {
                str = "taskinfo_adaptive_dynamic_switch";
            } else if (str.equals("optional_id_global_long_adaptive_limit_bitrate_range_max")) {
                str = "taskinfo_max_bitrate";
            }
            TPDownloadProxyNative.getInstance().updateTaskInfo(i3, str, str2);
        } catch (Throwable th5) {
            this.mLogger.e("setTaskOptionalConfigParam failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void setTaskResourceLoaderListener(int i3, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
        TPDataTransportTaskListenerMgr.getInstance().addResourceLoaderListener(i3, iTPDownloadProxyResourceLoaderListener);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void startTask(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (isNativeNotInit()) {
            this.mLogger.e("startTask failed, native not loaded, taskId:" + i3);
            return;
        }
        try {
            TPDownloadProxyNative.getInstance().startDownload(i3);
        } catch (Throwable th5) {
            this.mLogger.e("startTask failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void stopTask(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (isNativeNotInit()) {
            this.mLogger.e("stopTask failed, native not loaded, taskId invalid:" + i3);
            return;
        }
        try {
            TPDownloadProxyNative.getInstance().stopDownload(i3);
            TPDataTransportTaskListenerMgr.getInstance().removeTaskListener(i3);
            TPDataTransportTaskListenerMgr.getInstance().removeResourceLoaderListener(i3);
            synchronized (this.mMultiTaskClipInfo) {
                this.mMultiTaskClipInfo.remove(Integer.valueOf(i3));
            }
        } catch (Throwable th5) {
            this.mLogger.e("stopTask failed, taskId:" + i3 + ",  error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list) {
        int i16;
        if (i3 <= 0) {
            return;
        }
        if (isNativeNotInit()) {
            this.mLogger.e("updateRunningTaskParam failed, native not loaded or taskId invalid:" + i3);
            return;
        }
        try {
            Iterator<TPDataTransportTaskParam> it = list.iterator();
            int i17 = 1;
            while (it.hasNext()) {
                TPDownloadParam convert = TPTaskParamTransform.convert(it.next());
                String buildFileId = buildFileId(convert);
                if (list.size() > 1) {
                    buildFileId = buildClipFileId(convert);
                }
                String str = buildFileId;
                int dlType = convert.getDlType();
                if (convert.isOffline()) {
                    dlType += 100;
                }
                int i18 = dlType;
                TPDownloadProxyNative tPDownloadProxyNative = TPDownloadProxyNative.getInstance();
                if (convert.getClipNo() > 1) {
                    i16 = convert.getClipNo();
                } else {
                    i16 = i17;
                }
                tPDownloadProxyNative.setClipInfo(i3, i16, str, i18, convert.getCdnUrls(), convert.getSavaPath(), convert.getExtraJsonInfo());
                i17++;
            }
        } catch (Throwable th5) {
            this.mLogger.e("updateRunningTaskParam failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void updateRemoteService(ITPDataTransportRemote iTPDataTransportRemote) {
    }
}
