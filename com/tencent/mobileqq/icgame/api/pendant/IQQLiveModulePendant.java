package com.tencent.mobileqq.icgame.api.pendant;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import z22.a;

/* loaded from: classes15.dex */
public interface IQQLiveModulePendant extends IQQLiveModule {
    void addFetchPendantInfoListener(a aVar);

    void removeFetchPendantInfoListener(a aVar);

    void startFetchPendantInfo(long j3, long j16);
}
