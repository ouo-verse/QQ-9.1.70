package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOTitleApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "isSupportEar", "isSupportUnreadCount", "Landroid/graphics/drawable/Drawable;", "getRight1Bg", "getRight2Bg", "Landroid/content/Context;", "Landroid/widget/TextView;", "getLyricView", "Landroid/view/Window;", "window", "", "setWindowStyle", "onNickClick", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOTitleApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static void a(@NotNull IAIOTitleApi iAIOTitleApi, @NotNull Window window) {
            Intrinsics.checkNotNullParameter(window, "window");
        }
    }

    @NotNull
    TextView getLyricView(@NotNull Context context);

    @NotNull
    Drawable getRight1Bg(@NotNull com.tencent.aio.api.runtime.a context);

    @Nullable
    Drawable getRight2Bg(@NotNull com.tencent.aio.api.runtime.a context);

    boolean isSupportEar(@NotNull com.tencent.aio.api.runtime.a context);

    boolean isSupportUnreadCount(@NotNull com.tencent.aio.api.runtime.a context);

    void onNickClick(@NotNull com.tencent.aio.api.runtime.a context);

    void setWindowStyle(@NotNull Window window);
}
