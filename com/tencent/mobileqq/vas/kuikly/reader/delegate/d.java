package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Canvas;
import androidx.core.util.Pools;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/d;", "", "Landroid/graphics/Canvas;", "a", PM.CANVAS, "", "b", "Landroidx/core/util/Pools$SynchronizedPool;", "Landroidx/core/util/Pools$SynchronizedPool;", "pool", "", "size", "<init>", "(I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pools.SynchronizedPool<Canvas> pool;

    public d(int i3) {
        this.pool = new Pools.SynchronizedPool<>(i3);
    }

    @NotNull
    public final Canvas a() {
        Canvas acquire = this.pool.acquire();
        if (acquire == null) {
            return new Canvas();
        }
        return acquire;
    }

    public final void b(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.setBitmap(null);
        canvas.restoreToCount(1);
        this.pool.release(canvas);
    }
}
