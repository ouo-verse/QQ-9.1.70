package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.INTVasHybirdApi;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/NTVasHybirdApiImpl;", "Lcom/tencent/mobileqq/vas/api/INTVasHybirdApi;", "()V", DTConstants.TAG.API, "Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "getApi", "()Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", PluginConst.SchemeJsPluginConst.API_OPEN_SCHEME, "", "context", "Landroid/content/Context;", "url", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class NTVasHybirdApiImpl implements INTVasHybirdApi {

    @NotNull
    private final IVasHybridRoute api;

    public NTVasHybirdApiImpl() {
        QRouteApi api = QRoute.api(IVasHybridRoute.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasHybridRoute::class.java)");
        this.api = (IVasHybridRoute) api;
    }

    @NotNull
    public final IVasHybridRoute getApi() {
        return this.api;
    }

    @Override // com.tencent.mobileqq.vas.api.INTVasHybirdApi
    public void openScheme(@Nullable Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.api.openSchema(context, url);
    }
}
