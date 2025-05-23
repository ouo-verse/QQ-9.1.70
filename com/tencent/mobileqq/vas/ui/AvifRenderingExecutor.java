package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AvifRenderingExecutor;", "", "()V", "invalidateSelf", "", "drawable", "Landroid/graphics/drawable/Drawable;", "logE", ReportConstant.COSTREPORT_PREFIX, "", "e", "Ljava/lang/Exception;", "logI", "postTask", "runnable", "Ljava/lang/Runnable;", "postTaskDelay", "delay", "", "removeTask", "UpdateDrawableRunnable", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class AvifRenderingExecutor {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AvifRenderingExecutor$UpdateDrawableRunnable;", "Ljava/lang/Runnable;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "wd", "Lmqq/util/WeakReference;", "getWd", "()Lmqq/util/WeakReference;", TencentLocation.RUN_MODE, "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class UpdateDrawableRunnable implements Runnable {

        @NotNull
        private final WeakReference<Drawable> wd;

        public UpdateDrawableRunnable(@Nullable Drawable drawable) {
            this.wd = new WeakReference<>(drawable);
        }

        @NotNull
        public final WeakReference<Drawable> getWd() {
            return this.wd;
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable drawable = this.wd.get();
            if (drawable != null) {
                drawable.invalidateSelf();
            }
        }
    }

    public static /* synthetic */ void logE$default(AvifRenderingExecutor avifRenderingExecutor, String str, Exception exc, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            exc = null;
        }
        avifRenderingExecutor.logE(str, exc);
    }

    public final void invalidateSelf(@Nullable Drawable drawable) {
        ThreadManagerV2.getUIHandlerV2().post(new UpdateDrawableRunnable(drawable));
    }

    @JvmOverloads
    public final void logE(@NotNull String s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        logE$default(this, s16, null, 2, null);
    }

    public final void logI(@NotNull String s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
    }

    public final void postTask(@Nullable Runnable runnable) {
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    public final void postTaskDelay(@Nullable Runnable runnable, long delay) {
        ThreadManagerV2.executeDelay(runnable, 16, null, false, delay);
    }

    public final void removeTask(@Nullable Runnable runnable) {
        ThreadManagerV2.removeJobFromThreadPool(runnable, 16);
    }

    @JvmOverloads
    public final void logE(@NotNull String s16, @Nullable Exception e16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        Log.e("AvifSequence", s16, e16);
    }
}
