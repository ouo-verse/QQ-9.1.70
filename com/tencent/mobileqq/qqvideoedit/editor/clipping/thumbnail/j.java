package com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/j;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "a", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "b", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "generatedListener", "", "I", "d", "()I", "thumbnailWidth", "c", "thumbnailHeight", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "generateHandler", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;IILcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d generatedListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int thumbnailWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int thumbnailHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c generateHandler;

    public j(@NotNull d generatedListener, int i3, int i16, @NotNull c generateHandler) {
        Intrinsics.checkNotNullParameter(generatedListener, "generatedListener");
        Intrinsics.checkNotNullParameter(generateHandler, "generateHandler");
        this.generatedListener = generatedListener;
        this.thumbnailWidth = i3;
        this.thumbnailHeight = i16;
        this.generateHandler = generateHandler;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final c getGenerateHandler() {
        return this.generateHandler;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final d getGeneratedListener() {
        return this.generatedListener;
    }

    /* renamed from: c, reason: from getter */
    public final int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getThumbnailWidth() {
        return this.thumbnailWidth;
    }
}
