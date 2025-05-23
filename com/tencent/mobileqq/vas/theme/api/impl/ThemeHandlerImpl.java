package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.vas.theme.api.IThemeHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeHandlerImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeHandler;", "()V", "isNeedAuth", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sendThemeAuth", "", "sendThemeVersionCheck", "themeId", "", "version", "isBackAuth", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ThemeHandlerImpl implements IThemeHandler {
    @Override // com.tencent.mobileqq.vas.theme.api.IThemeHandler
    @Nullable
    public AtomicBoolean isNeedAuth() {
        AppRuntime createAppRuntime = ThemeUtil.getCreateAppRuntime();
        Intrinsics.checkNotNull(createAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) createAppRuntime).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.ThemeHandler");
        return ((ThemeHandler) businessHandler).f195123e;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeHandler
    public void sendThemeAuth() {
        AppRuntime createAppRuntime = ThemeUtil.getCreateAppRuntime();
        Intrinsics.checkNotNull(createAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) createAppRuntime).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.ThemeHandler");
        ((ThemeHandler) businessHandler).sendThemeAuth();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeHandler
    public void sendThemeVersionCheck(@NotNull String themeId, @NotNull String version, boolean isBackAuth) {
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(version, "version");
        AppRuntime createAppRuntime = ThemeUtil.getCreateAppRuntime();
        Intrinsics.checkNotNull(createAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) createAppRuntime).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.ThemeHandler");
        ((ThemeHandler) businessHandler).sendThemeVersionCheck(themeId, version, isBackAuth);
    }
}
