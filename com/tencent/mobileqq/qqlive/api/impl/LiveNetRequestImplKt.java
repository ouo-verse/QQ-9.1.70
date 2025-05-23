package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u00a8\u0006\u0004"}, d2 = {"getFullCmd", "", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "qq-live-sdk-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class LiveNetRequestImplKt {
    @NotNull
    public static final <T> String getFullCmd(@NotNull LiveBaseRequest<? extends T> liveBaseRequest) {
        Intrinsics.checkNotNullParameter(liveBaseRequest, "<this>");
        return liveBaseRequest.getMainCmd() + "." + liveBaseRequest.getSubCmd();
    }
}
