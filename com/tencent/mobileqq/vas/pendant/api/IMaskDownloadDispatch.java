package com.tencent.mobileqq.vas.pendant.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/IMaskDownloadDispatch;", "", "registerDispatchCallback", "", "uin", "", "callback", "Lcom/tencent/mobileqq/vas/pendant/api/VasMaskDownloadCallback;", "unregisterDispatchCallback", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IMaskDownloadDispatch {
    void registerDispatchCallback(@NotNull String uin, @Nullable VasMaskDownloadCallback callback);

    void unregisterDispatchCallback(@NotNull String uin, @Nullable VasMaskDownloadCallback callback);
}
