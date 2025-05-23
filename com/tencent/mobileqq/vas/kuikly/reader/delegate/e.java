package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Canvas;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0007H&R\u0014\u0010\u0003\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;", "", "", "width", "height", "Landroid/graphics/Canvas;", "a", "", "b", PM.CANVAS, "draw", "recycle", "getWidth", "()I", "getHeight", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface e {
    @NotNull
    Canvas a(int width, int height);

    void b();

    void draw(@NotNull Canvas canvas);

    int getHeight();

    int getWidth();

    void recycle();
}
