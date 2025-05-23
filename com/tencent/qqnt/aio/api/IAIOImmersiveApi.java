package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOImmersiveApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "enableImmersive", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "originDrawable", "", "shortcutBarHeight", "Lkotlin/Pair;", "getImmersiveDrawable", "getNavigationBarSwitch", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOImmersiveApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static boolean a(@NotNull IAIOImmersiveApi iAIOImmersiveApi, @NotNull com.tencent.aio.api.runtime.a aioContext) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            return false;
        }

        @NotNull
        public static Pair<Drawable, Drawable> b(@NotNull IAIOImmersiveApi iAIOImmersiveApi, @NotNull Context context, @NotNull Drawable originDrawable, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originDrawable, "originDrawable");
            return new Pair<>(new BitmapDrawable(), new BitmapDrawable());
        }

        public static boolean c(@NotNull IAIOImmersiveApi iAIOImmersiveApi) {
            return true;
        }
    }

    boolean enableImmersive(@NotNull com.tencent.aio.api.runtime.a aioContext);

    @NotNull
    Pair<Drawable, Drawable> getImmersiveDrawable(@NotNull Context context, @NotNull Drawable originDrawable, int shortcutBarHeight);

    boolean getNavigationBarSwitch();
}
