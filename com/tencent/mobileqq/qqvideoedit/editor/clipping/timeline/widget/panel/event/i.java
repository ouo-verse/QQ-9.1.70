package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event;

import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.ClipModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/i;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/c;", "", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "", "b", "I", "getSelectedStatus", "()I", "selectedStatus", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "getData", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "data", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i extends c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int selectedStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ClipModel data;

    public i(@NotNull String id5, int i3, @Nullable ClipModel clipModel) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.selectedStatus = i3;
        this.data = clipModel;
    }
}
