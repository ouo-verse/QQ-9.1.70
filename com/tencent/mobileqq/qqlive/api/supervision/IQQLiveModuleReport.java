package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveModuleReport extends IQQLiveModule {
    void report(long j3, long j16, long j17, String str, ReportCallback reportCallback);
}
