package com.tencent.state.square.download;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/download/Source;", "Ljava/io/Serializable;", "remoteUrl", "", QAdRewardDefine$VideoParams.CACHE_PATH, "(Ljava/lang/String;Ljava/lang/String;)V", "getCachePath", "()Ljava/lang/String;", "getRemoteUrl", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class Source implements Serializable {

    @NotNull
    private final String cachePath;

    @NotNull
    private final String remoteUrl;

    public Source(@NotNull String remoteUrl, @NotNull String cachePath) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        this.remoteUrl = remoteUrl;
        this.cachePath = cachePath;
    }

    @NotNull
    public final String getCachePath() {
        return this.cachePath;
    }

    @NotNull
    public final String getRemoteUrl() {
        return this.remoteUrl;
    }
}
