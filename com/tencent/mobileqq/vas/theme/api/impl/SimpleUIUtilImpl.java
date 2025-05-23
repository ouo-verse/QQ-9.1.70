package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/SimpleUIUtilImpl;", "Lcom/tencent/mobileqq/vas/theme/api/ISimpleUIUtil;", "()V", "isThemeSimpleDayUI", "", "currentThemeId", "", "isThemeSimpleUI", "themeId", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SimpleUIUtilImpl implements ISimpleUIUtil {
    @Override // com.tencent.mobileqq.vas.theme.api.ISimpleUIUtil
    public boolean isThemeSimpleDayUI(@NotNull String currentThemeId) {
        Intrinsics.checkNotNullParameter(currentThemeId, "currentThemeId");
        return QQTheme.isThemeSimpleDayUI(currentThemeId);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.ISimpleUIUtil
    public boolean isThemeSimpleUI(@NotNull String themeId) {
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        return QQTheme.isThemeSimpleUI(themeId);
    }
}
