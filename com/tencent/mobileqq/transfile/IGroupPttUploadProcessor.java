package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.StatictisInfo;

/* loaded from: classes19.dex */
public interface IGroupPttUploadProcessor {
    void copyStatisInfo(StepInfo stepInfo, boolean z16, boolean z17, StatictisInfo statictisInfo);

    TransferRequest getRequest();

    StepInfo getStepMsg();

    void logRichMediaEvent(String str, String str2);

    void onError();

    void onSuccess();

    void setShouldMsgReportSucc(int i3);
}
