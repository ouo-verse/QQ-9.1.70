package com.tencent.paysdk.api;

import com.tencent.ark.ark;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.paysdk.network.RequestWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/paysdk/api/m;", "", "", "key", "value", "a", "url", "b", "referKey", "refer", "f", "cookieKey", "cookie", "c", "mediaType", ark.ARKMETADATA_JSON, "d", "Lcom/tencent/paysdk/network/RequestWrapper$RequestType;", "type", "e", Const.BUNDLE_KEY_REQUEST, "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public interface m {
    @NotNull
    m a(@NotNull String key, @NotNull String value);

    @NotNull
    m b(@NotNull String url);

    @NotNull
    m c(@NotNull String cookieKey, @NotNull String cookie);

    @NotNull
    m d(@NotNull String mediaType, @NotNull String json);

    @NotNull
    m e(@NotNull RequestWrapper.RequestType type);

    @NotNull
    m f(@NotNull String referKey, @NotNull String refer);

    @Nullable
    String request() throws Exception;
}
