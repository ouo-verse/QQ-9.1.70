package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileTracer;
import com.tencent.mobileqq.profilecard.report.ProfileTraceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/profilecard/api/impl/ProfileTracerImpl;", "Lcom/tencent/mobileqq/profilecard/api/IProfileTracer;", "()V", "report", "", "key", "", "value", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileTracerImpl implements IProfileTracer {
    @Override // com.tencent.mobileqq.profilecard.api.IProfileTracer
    public void report(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ProfileTraceManager.INSTANCE.doReport(key, value);
    }
}
