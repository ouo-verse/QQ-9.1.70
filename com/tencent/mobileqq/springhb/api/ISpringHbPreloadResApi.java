package com.tencent.mobileqq.springhb.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.springhb.interf.a;
import com.tencent.mobileqq.springhb.interf.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/ISpringHbPreloadResApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "url", "Lcom/tencent/mobileqq/springhb/interf/a;", "getSpringFileRes", "defaultDrawableKey", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/springhb/interf/b;", "getPreloadDrawableRes", "Landroid/content/Context;", "context", "", "copyKuiklyPagFile", "copyKuiklyFontFile", "springhb-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISpringHbPreloadResApi extends QRouteApi {
    void copyKuiklyFontFile(@NotNull String url);

    void copyKuiklyPagFile(@NotNull Context context, @NotNull String url);

    @NotNull
    b getPreloadDrawableRes(@NotNull String url, @NotNull String defaultDrawableKey, @NotNull Bundle bundle);

    @NotNull
    a getSpringFileRes(@NotNull String url);
}
