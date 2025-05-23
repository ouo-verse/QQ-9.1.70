package com.tencent.mobileqq.winkpublish;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.winkpublish.config.UploadLocalConfig;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.mobileqq.winkpublish.model.PublishUploadParams;
import java.util.List;

/* compiled from: P */
@PluginInterface
/* loaded from: classes21.dex */
public interface IQueueTask extends com.tencent.smartparcelable.a {
    boolean cancel();

    void clear();

    String getCacheKey();

    String getClientKey();

    int getExactType();

    PublishQueueTaskInfo getInfo();

    long getLeaveSize();

    int getManualRetryNum();

    String getMissionId();

    String getPhotoSource();

    List<String> getPhotoSources();

    int getResultCode();

    String getResultMsg();

    int getRetryNum();

    int getSeqId();

    int getState();

    long getTaskId();

    long getTime();

    long getTimeStamp();

    String getTraceId();

    UploadLocalConfig getUploadLocalConfig();

    long getUploadTime();

    void increaseManualRetryNum();

    void increaseRetryNum();

    void increaseSeqId();

    boolean isNeedRetryByQueue();

    boolean isNullTask();

    boolean isQunTask();

    boolean isRunningToUpload();

    boolean isUploading();

    boolean isVideoTask();

    boolean needShowCloseBt();

    void notifyComplete(boolean z16, boolean z17);

    void onRemove();

    void onRestore();

    void onResume();

    void resetDataSize();

    void setResultCode(int i3);

    void setResultMsg(String str);

    void setState(int i3);

    void setTaskReady();

    void setTime(long j3);

    QueueTaskBean transform2Bean();

    void updateShuoShuoTask(PublishUploadParams publishUploadParams);
}
