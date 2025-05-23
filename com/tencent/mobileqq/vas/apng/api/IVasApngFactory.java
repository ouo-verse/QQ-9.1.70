package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u5f03\u7528URLDrawable")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H'J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH'J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H'J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getApngDrawable", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "from", "", "urlStr", "options", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "filePath", "getApngURLDrawable", "Lcom/tencent/image/URLDrawable;", "getDynamicDrawable", "Landroid/graphics/drawable/Drawable;", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasApngFactory extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory$Companion;", "", "()V", "ENABLE_CACHE_DRAWABLE", "", "getENABLE_CACHE_DRAWABLE", "()Z", DTConstants.TAG.API, "Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final boolean ENABLE_CACHE_DRAWABLE = ar.INSTANCE.b("anzaihuang", "2024-05-30", "vas_new_dynamic_drawable_switch_two").isEnable(true);

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final IVasApngFactory api() {
            QRouteApi api = QRoute.api(IVasApngFactory.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasApngFactory::class.java)");
            return (IVasApngFactory) api;
        }

        public final boolean getENABLE_CACHE_DRAWABLE() {
            return ENABLE_CACHE_DRAWABLE;
        }
    }

    @Deprecated(message = "\u5f03\u7528")
    @NotNull
    APNGDrawable getApngDrawable(@NotNull String from, @NotNull String urlStr);

    @Deprecated(message = "\u5f03\u7528")
    @NotNull
    APNGDrawable getApngDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options);

    @Deprecated(message = "\u5f03\u7528")
    @NotNull
    APNGDrawable getApngDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options, @NotNull String filePath);

    @Nullable
    URLDrawable getApngURLDrawable(@NotNull String urlStr, @NotNull ApngOptions options, @NotNull String filePath);

    @Nullable
    URLDrawable getApngURLDrawable(@NotNull String from, @NotNull String urlStr);

    @Nullable
    URLDrawable getApngURLDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options);

    @NotNull
    Drawable getDynamicDrawable(@NotNull String urlStr);

    @NotNull
    Drawable getDynamicDrawable(@NotNull String urlStr, @NotNull ApngOptions options);

    @NotNull
    Drawable getDynamicDrawable(@NotNull String urlStr, @NotNull ApngOptions options, @NotNull String filePath);
}
