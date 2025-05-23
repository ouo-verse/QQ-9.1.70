package com.tencent.mobileqq.vas.apng.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.ui.SharpPDrawable;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/IVasSharpPFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSharpPDrawable", "Lcom/tencent/mobileqq/vas/ui/SharpPDrawable;", "urlStr", "", "options", "Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions;", "getSharpPURLDrawable", "Lcom/tencent/image/URLDrawable;", "filePath", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasSharpPFactory extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/IVasSharpPFactory$Companion;", "", "()V", DTConstants.TAG.API, "Lcom/tencent/mobileqq/vas/apng/api/IVasSharpPFactory;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final IVasSharpPFactory api() {
            QRouteApi api = QRoute.api(IVasSharpPFactory.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasSharpPFactory::class.java)");
            return (IVasSharpPFactory) api;
        }
    }

    @NotNull
    SharpPDrawable getSharpPDrawable(@NotNull String urlStr);

    @NotNull
    SharpPDrawable getSharpPDrawable(@NotNull String urlStr, @NotNull SharpPOptions options);

    @Nullable
    URLDrawable getSharpPURLDrawable(@NotNull String urlStr, @NotNull SharpPOptions options, @NotNull String filePath);
}
