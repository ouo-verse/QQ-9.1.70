package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.StatictisInfo;

/* loaded from: classes19.dex */
public interface IC2CPttUploadProcessor {
    void copyStatisInfo(StepInfo stepInfo, boolean z16, boolean z17, StatictisInfo statictisInfo);

    StepInfo getStepMsg();

    void logRichMediaEvent(String str, String str2);

    void onError();

    void onSuccess();
}
