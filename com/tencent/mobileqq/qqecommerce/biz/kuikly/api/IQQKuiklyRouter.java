package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyRouter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jump", "", "context", "Landroid/content/Context;", "schemeUrl", "", "jumpKuiklyPageWithWebUrl", "", "webUrl", "launchKuiklyPage", "args", "Landroid/os/Bundle;", "params", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/KuiklyLaunchParams;", "Lorg/json/JSONObject;", "updateLaunchArgs", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQKuiklyRouter extends QRouteApi {
    void jump(@NotNull Context context, @NotNull String schemeUrl);

    boolean jumpKuiklyPageWithWebUrl(@NotNull Context context, @Nullable String webUrl);

    void launchKuiklyPage(@NotNull Context context, @NotNull Bundle args);

    void launchKuiklyPage(@NotNull Context context, @NotNull KuiklyLaunchParams params);

    void launchKuiklyPage(@NotNull Context context, @NotNull JSONObject args);

    void updateLaunchArgs(@NotNull Bundle args);
}
