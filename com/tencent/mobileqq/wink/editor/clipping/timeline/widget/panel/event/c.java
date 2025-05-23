package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/c;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "data", "", "b", "Z", "c", "()Z", "isLeft", "", "I", "()I", "state", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;ZI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class c extends g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipModel data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isLeft;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int state;

    public c(@NotNull ClipModel data, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isLeft = z16;
        this.state = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ClipModel getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsLeft() {
        return this.isLeft;
    }
}
