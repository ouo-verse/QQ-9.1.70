package com.tencent.aio.api;

import android.graphics.Canvas;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J2\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/api/b;", "", "", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "Lcom/tencent/aio/api/c;", "parentPadding", "", "c", "parentLeft", "parentTop", "parentRight", "parentBottom", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @Nullable Canvas canvas, @NotNull c parentPadding) {
            Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        }

        public static /* synthetic */ void b(b bVar, Canvas canvas, c cVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    cVar = com.tencent.aio.api.a.f69115e;
                }
                bVar.b(canvas, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw");
        }

        public static /* synthetic */ void c(b bVar, int i3, int i16, int i17, int i18, c cVar, int i19, Object obj) {
            if (obj == null) {
                if ((i19 & 16) != 0) {
                    cVar = com.tencent.aio.api.a.f69115e;
                }
                bVar.a(i3, i16, i17, i18, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layoutChildren");
        }

        public static /* synthetic */ void d(b bVar, int i3, int i16, c cVar, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    cVar = com.tencent.aio.api.a.f69115e;
                }
                bVar.c(i3, i16, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureChildren");
        }
    }

    void a(int parentLeft, int parentTop, int parentRight, int parentBottom, @NotNull c parentPadding);

    void b(@Nullable Canvas canvas, @NotNull c parentPadding);

    void c(int parentWidthMeasureSpec, int parentHeightMeasureSpec, @NotNull c parentPadding);
}
