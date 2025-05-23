package com.tencent.gdtad.impl;

import com.tencent.gdtad.INsrApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/gdtad/impl/NsrApiImpl;", "Lcom/tencent/gdtad/INsrApi;", "()V", "downloadImgRes", "", "imgUrl", "", "qqad-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class NsrApiImpl implements INsrApi {
    @Override // com.tencent.gdtad.INsrApi
    public void downloadImgRes(@NotNull String imgUrl) {
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        com.tencent.mobileqq.nsr.c.f254415a.g(imgUrl);
    }
}
