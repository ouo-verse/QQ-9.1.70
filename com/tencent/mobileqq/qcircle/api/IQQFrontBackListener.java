package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQQFrontBackListener {
    void onQQEnterBackground();

    void onQQEnterForeground();
}
