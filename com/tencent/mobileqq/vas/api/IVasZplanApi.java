package com.tencent.mobileqq.vas.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u0011H&J\u001e\u0010\u0018\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0019H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasZplanApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "openDemoFragment", "Lq03/c;", "getConfig", "Lq03/f;", "getWoTransitPageConfig", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "showSmallHomeTransitPanel", "Lcom/tencent/mobileqq/vas/aio/a;", "getAIOSmallHomeControl", "", "", "appIds", "", "scene", "addWhiteList", "", "getDebugSsoId", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasZplanApi extends QRouteApi {
    void addWhiteList(@NotNull List<Long> appIds, @NotNull String scene);

    @NotNull
    com.tencent.mobileqq.vas.aio.a getAIOSmallHomeControl();

    @NotNull
    q03.c getConfig();

    int getDebugSsoId();

    @NotNull
    q03.f getWoTransitPageConfig();

    void openDemoFragment(@NotNull Context context, @Nullable Bundle bundle);

    void showSmallHomeTransitPanel(@NotNull Context context, @NotNull TransitPageInfo info, @NotNull ZootopiaSource source);
}
