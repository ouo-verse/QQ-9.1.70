package com.tencent.mobileqq.vas.frequency.impl;

import com.tencent.mobileqq.n;
import com.tencent.mobileqq.vas.frequency.IFrequencyCheckApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/frequency/impl/FrequencyCheckApiImpl;", "Lcom/tencent/mobileqq/vas/frequency/IFrequencyCheckApi;", "()V", "checkAvatarPendantChangedAndTriggerFrequency", "", "uin", "", "peerUin", "", "peerUid", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class FrequencyCheckApiImpl implements IFrequencyCheckApi {
    @Override // com.tencent.mobileqq.vas.frequency.IFrequencyCheckApi
    public void checkAvatarPendantChangedAndTriggerFrequency(long uin, @NotNull String peerUin, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        n.f252475a.h(uin, peerUin, peerUid);
    }
}
