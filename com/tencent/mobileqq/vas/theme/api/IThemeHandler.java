package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/IThemeHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isNeedAuth", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sendThemeAuth", "", "sendThemeVersionCheck", "themeId", "", "version", "isBackAuth", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IThemeHandler extends QRouteApi {
    @Nullable
    AtomicBoolean isNeedAuth();

    void sendThemeAuth();

    void sendThemeVersionCheck(@NotNull String themeId, @NotNull String version, boolean isBackAuth);
}
