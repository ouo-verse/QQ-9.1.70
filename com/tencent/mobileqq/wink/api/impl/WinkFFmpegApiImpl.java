package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.wink.api.IWinkFFmpegApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkFFmpegApiImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkFFmpegApi;", "", "getFFmpegCmdBinPath", "getFFmpegCmdSoPath", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkFFmpegApiImpl implements IWinkFFmpegApi {

    @NotNull
    private static final String TAG = "WinkFFmpegApiImpl";

    @Override // com.tencent.mobileqq.wink.api.IWinkFFmpegApi
    @Nullable
    public String getFFmpegCmdBinPath() {
        return y73.a.f449547a.a();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkFFmpegApi
    @Nullable
    public String getFFmpegCmdSoPath() {
        return y73.a.f449547a.b();
    }
}
