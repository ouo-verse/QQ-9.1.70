package com.tencent.mobileqq.guild.home.views.embeddable;

import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "", "direction", "canScrollVertically", "dX", "dY", "", "consumed", "", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {
    boolean a(int direction);

    void c(int dX, int dY, @NotNull int[] consumed);

    boolean canScrollVertically(int direction);

    boolean dispatchTouchEvent(@NotNull MotionEvent ev5);
}
