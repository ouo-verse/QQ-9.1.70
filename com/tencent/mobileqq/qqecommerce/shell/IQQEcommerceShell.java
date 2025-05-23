package com.tencent.mobileqq.qqecommerce.shell;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H&J,\u0010\b\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H&J4\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/shell/IQQEcommerceShell;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "callLogicInNative", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callService", "reportEnter", "pluginVersion", "qqecommerce_shell_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQEcommerceShell extends QRouteApi {
    void callLogicInNative(@NotNull HashMap<String, String> params);

    void callService(@NotNull HashMap<String, String> params);

    void reportEnter(@NotNull String pluginVersion, @NotNull HashMap<String, String> params);
}
