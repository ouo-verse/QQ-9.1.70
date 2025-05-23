package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020\u001f\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b\u0018\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b\u000e\u0010!\"\u0004\b%\u0010#R\"\u0010,\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010(\u001a\u0004\b\t\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "uuid", "b", "I", "f", "()I", "type", "c", "setPath", "(Ljava/lang/String;)V", "path", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/h;", "d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/h;", "e", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/h;", "setTimeData", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/h;)V", "timeData", "", "J", "()J", "i", "(J)V", "startOverlapTimeUs", tl.h.F, "endOverlapTimeUs", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;", "setDrawData", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;)V", "drawData", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/h;JJLcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.i, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class VariableClipModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uuid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private TimeData timeData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long startOverlapTimeUs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long endOverlapTimeUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private DrawData drawData;

    public VariableClipModel(@NotNull String uuid, int i3, @NotNull String path, @NotNull TimeData timeData, long j3, long j16, @NotNull DrawData drawData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(timeData, "timeData");
        Intrinsics.checkNotNullParameter(drawData, "drawData");
        this.uuid = uuid;
        this.type = i3;
        this.path = path;
        this.timeData = timeData;
        this.startOverlapTimeUs = j3;
        this.endOverlapTimeUs = j16;
        this.drawData = drawData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final DrawData getDrawData() {
        return this.drawData;
    }

    /* renamed from: b, reason: from getter */
    public final long getEndOverlapTimeUs() {
        return this.endOverlapTimeUs;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: d, reason: from getter */
    public final long getStartOverlapTimeUs() {
        return this.startOverlapTimeUs;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TimeData getTimeData() {
        return this.timeData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VariableClipModel)) {
            return false;
        }
        VariableClipModel variableClipModel = (VariableClipModel) other;
        if (Intrinsics.areEqual(this.uuid, variableClipModel.uuid) && this.type == variableClipModel.type && Intrinsics.areEqual(this.path, variableClipModel.path) && Intrinsics.areEqual(this.timeData, variableClipModel.timeData) && this.startOverlapTimeUs == variableClipModel.startOverlapTimeUs && this.endOverlapTimeUs == variableClipModel.endOverlapTimeUs && Intrinsics.areEqual(this.drawData, variableClipModel.drawData)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    public final void h(long j3) {
        this.endOverlapTimeUs = j3;
    }

    public int hashCode() {
        return (((((((((((this.uuid.hashCode() * 31) + this.type) * 31) + this.path.hashCode()) * 31) + this.timeData.hashCode()) * 31) + androidx.fragment.app.a.a(this.startOverlapTimeUs)) * 31) + androidx.fragment.app.a.a(this.endOverlapTimeUs)) * 31) + this.drawData.hashCode();
    }

    public final void i(long j3) {
        this.startOverlapTimeUs = j3;
    }

    @NotNull
    public String toString() {
        return "VariableClipModel(uuid=" + this.uuid + ", type=" + this.type + ", path=" + this.path + ", timeData=" + this.timeData + ", startOverlapTimeUs=" + this.startOverlapTimeUs + ", endOverlapTimeUs=" + this.endOverlapTimeUs + ", drawData=" + this.drawData + ")";
    }
}
