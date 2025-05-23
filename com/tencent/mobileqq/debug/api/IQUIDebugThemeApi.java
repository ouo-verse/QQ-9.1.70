package com.tencent.mobileqq.debug.api;

import ae0.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/debug/api/IQUIDebugThemeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "tryShowDebugFloatingView", "", "isQUIViewMarkSwitchOn", "isQUIFloatingViewOn", "", "primaryColor", "isDark", "Lae0/a;", "getQUIProfileColorPalette", "qq_debug_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQUIDebugThemeApi extends QRouteApi {
    @NotNull
    a getQUIProfileColorPalette(int primaryColor, boolean isDark);

    boolean isQUIFloatingViewOn();

    boolean isQUIViewMarkSwitchOn();

    void tryShowDebugFloatingView();
}
