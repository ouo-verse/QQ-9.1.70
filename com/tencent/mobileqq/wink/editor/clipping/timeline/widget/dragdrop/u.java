package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/u;", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;", "dragModel", "", "a", "", "isLeft", "c", "selected", "Landroid/view/View;", "view", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface u {
    void a(@NotNull DragModel dragModel);

    void b(boolean selected, @NotNull View view);

    void c(@NotNull DragModel dragModel, boolean isLeft);
}
