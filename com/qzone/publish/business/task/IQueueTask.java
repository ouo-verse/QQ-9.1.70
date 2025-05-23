package com.qzone.publish.business.task;

import com.tencent.component.app.common.SmartParcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IQueueTask extends SmartParcelable {
    boolean cancel();

    void clear();

    String getCacheKey();

    String getCaseId();

    String getClientKey();

    List<String> getEditMissionId();

    int getExactType();

    c getInfo();

    long getLeaveSize();

    int getManualRetryNum();

    String getPhotoSource();

    com.qzone.publish.business.publishqueue.a getPublishQueue();

    int getResultCode();

    String getResultMsg();

    int getRetryNum();

    int getState();

    long getTaskId();

    long getTime();

    long getTimeStamp();

    String getTraceId();

    long getUploadTime();

    void increaseManualRetryNum();

    void increaseRetryNum();

    boolean isNullTask();

    boolean isQunTask();

    boolean isVideoTask();

    void onRemove();

    void onRestore();

    void onResume();

    void resetDataSize();

    void resetTraceId();

    void setResultCode(int i3);

    void setResultMsg(String str);

    void setState(int i3);

    void setTime(long j3);
}
