package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH&J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\bH&J\u001a\u0010\u0017\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\bH&J\b\u0010\u0018\u001a\u00020\rH&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/q;", "", "Landroid/view/View;", "dragView", "", "rawStartPosition", "offsetX", "Lkotlin/Pair;", "", "b", "rawEndPosition", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "", tl.h.F, "positionOffset", "isUp", "view", "isLeft", "d", "f", "c", "isSelected", "g", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface q {
    void a();

    @NotNull
    Pair<Boolean, Integer> b(@NotNull View dragView, int rawStartPosition, int offsetX);

    boolean c();

    void d(int positionOffset, boolean isUp, @NotNull View view, boolean isLeft);

    int e(@NotNull View dragView, int rawEndPosition, int offsetX);

    boolean f();

    void g(@Nullable o dragView, boolean isSelected);

    void h(@NotNull o dragView);
}
