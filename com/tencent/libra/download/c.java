package com.tencent.libra.download;

import com.tencent.libra.download.lightquic.LightQuicRequestCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/libra/download/c;", "Lcom/tencent/libra/download/d;", "Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback$RequestResultCode;", "errorCode", "", "retryTimes", "", "a", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f118671a = new c();

    c() {
    }

    @Override // com.tencent.libra.download.d
    public boolean a(@NotNull LightQuicRequestCallback.RequestResultCode errorCode, int retryTimes) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return false;
    }
}
