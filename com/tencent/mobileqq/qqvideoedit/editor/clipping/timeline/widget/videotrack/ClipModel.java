package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;", "d", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uuid", "b", "I", "getType", "()I", "type", "path", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/h;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/h;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/h;", "timeData", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "getDrawData", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "drawData", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/h;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.a, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class ClipModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uuid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final h timeData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DrawData drawData;

    public ClipModel(@NotNull String uuid, int i3, @NotNull String path, @NotNull h timeData, @NotNull DrawData drawData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(timeData, "timeData");
        Intrinsics.checkNotNullParameter(drawData, "drawData");
        this.uuid = uuid;
        this.type = i3;
        this.path = path;
        this.timeData = timeData;
        this.drawData = drawData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final h getTimeData() {
        return this.timeData;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final VariableClipModel d() {
        return new VariableClipModel(this.uuid, this.type, this.path, this.timeData, 0L, 0L, this.drawData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClipModel)) {
            return false;
        }
        ClipModel clipModel = (ClipModel) other;
        if (Intrinsics.areEqual(this.uuid, clipModel.uuid) && this.type == clipModel.type && Intrinsics.areEqual(this.path, clipModel.path) && Intrinsics.areEqual(this.timeData, clipModel.timeData) && Intrinsics.areEqual(this.drawData, clipModel.drawData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.uuid.hashCode() * 31) + this.type) * 31) + this.path.hashCode()) * 31) + this.timeData.hashCode()) * 31) + this.drawData.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClipModel(uuid=" + this.uuid + ", type=" + this.type + ", path=" + this.path + ", timeData=" + this.timeData + ", drawData=" + this.drawData + ")";
    }
}
