package com.tencent.mobileqq.wink.editor.filter;

import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.videocut.model.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/a;", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "a", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "()Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSource", "Lcom/tencent/videocut/model/SizeF;", "b", "Lcom/tencent/videocut/model/SizeF;", "()Lcom/tencent/videocut/model/SizeF;", "size", "<init>", "(Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;Lcom/tencent/videocut/model/SizeF;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipSource clipSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SizeF size;

    public a(@NotNull ClipSource clipSource, @NotNull SizeF size) {
        Intrinsics.checkNotNullParameter(clipSource, "clipSource");
        Intrinsics.checkNotNullParameter(size, "size");
        this.clipSource = clipSource;
        this.size = size;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ClipSource getClipSource() {
        return this.clipSource;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final SizeF getSize() {
        return this.size;
    }
}
