package com.tencent.libra.download.lightquic;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.lightquic.api.IRequestCallback;
import com.tencent.lightquic.api.LightQUICRequest;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/libra/download/lightquic/a;", "", "", "url", "Lcom/tencent/lightquic/api/IRequestCallback;", "callback", "", "headers", "Lcom/tencent/lightquic/api/LightQUICRequest;", "a", Const.BUNDLE_KEY_REQUEST, "", "b", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {
    @Nullable
    LightQUICRequest a(@NotNull String url, @NotNull IRequestCallback callback, @NotNull Map<String, String> headers);

    void b(@NotNull LightQUICRequest request);
}
