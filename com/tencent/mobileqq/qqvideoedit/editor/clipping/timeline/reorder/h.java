package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ThumbClipView;", "E", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ThumbClipView;", "thumbClipView", "l", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ThumbClipView;", "contentView", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ThumbClipView;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ThumbClipView thumbClipView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull ThumbClipView thumbClipView) {
        super(thumbClipView);
        Intrinsics.checkNotNullParameter(thumbClipView, "thumbClipView");
        this.thumbClipView = thumbClipView;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final ThumbClipView getThumbClipView() {
        return this.thumbClipView;
    }
}
