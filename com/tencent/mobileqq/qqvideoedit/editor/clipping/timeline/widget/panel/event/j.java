package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event;

import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.ClipModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/j;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/d;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "a", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "data", "", "b", "Z", "isLeft", "()Z", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;Z)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j extends d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ClipModel data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isLeft;

    public j(@Nullable ClipModel clipModel, boolean z16) {
        this.data = clipModel;
        this.isLeft = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final ClipModel getData() {
        return this.data;
    }
}
