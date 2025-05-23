package com.tencent.android.androidbypass.codeblock.span.plugin;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J:\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/a;", "", "", "w", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetricsInt", "width", "", "text", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "left", "top", "bottom", "d", "height", "c", "Landroid/graphics/Rect;", "tvVisibleRect", "codeBlockRect", "b", "Lcom/tencent/android/androidbypass/codeblock/span/event/a;", "event", "e", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.codeblock.span.plugin.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0712a {
        public static void a(@NotNull a aVar, @NotNull com.tencent.android.androidbypass.codeblock.span.event.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        public static void b(@NotNull a aVar, @NotNull Paint.FontMetricsInt fontMetricsInt, int i3, @Nullable CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        }
    }

    void a(@NotNull Paint.FontMetricsInt fontMetricsInt, int width, @Nullable CharSequence text);

    void b(@NotNull Canvas canvas, @NotNull Rect tvVisibleRect, @NotNull Rect codeBlockRect, @Nullable CharSequence text);

    void c(@NotNull Canvas canvas, int width, int height, @Nullable CharSequence text);

    void d(@NotNull Canvas canvas, float left, int width, int top, int bottom, @Nullable CharSequence text);

    void e(@NotNull com.tencent.android.androidbypass.codeblock.span.event.a event);

    int w();
}
