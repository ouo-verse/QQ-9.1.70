package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b@\u0010AJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0095\u0001\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010(R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010(R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010 \u001a\u0004\b-\u0010\"\"\u0004\b.\u0010(R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010(R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b1\u0010\"\"\u0004\b2\u0010(R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b4\u0010(R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010 \u001a\u0004\b3\u0010\"\"\u0004\b;\u0010(R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b1\u0010<\u001a\u0004\b:\u0010=R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u0010>\u001a\u0004\b#\u0010?\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/p;", "", "", "e", "", "uuid", "type", "path", "leftMargin", "leftOffset", "minLeftMargin", "width", NodeProps.MAX_WIDTH, "startClipWidth", "endClipWidth", "", "duration", NodeProps.MIN_WIDTH, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;", "sourceData", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "drawData", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "b", "I", DomainData.DOMAIN_NAME, "()I", "c", "k", "d", "f", "r", "(I)V", "g", ReportConstant.COSTREPORT_PREFIX, "i", "setMinLeftMargin", "p", "t", tl.h.F, "setMaxWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setStartClipWidth", "j", "setEndClipWidth", "J", "getDuration", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(J)V", "l", "setMinWidth", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "<init>", "(Ljava/lang/String;ILjava/lang/String;IIIIIIIJILcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.p, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class VideoTrackModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uuid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int leftMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int leftOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int minLeftMargin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int maxWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int startClipWidth;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int endClipWidth;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long duration;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int minWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final VariableClipModel sourceData;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DrawData drawData;

    public VideoTrackModel(@NotNull String uuid, int i3, @NotNull String path, int i16, int i17, int i18, int i19, int i26, int i27, int i28, long j3, int i29, @NotNull VariableClipModel sourceData, @NotNull DrawData drawData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(sourceData, "sourceData");
        Intrinsics.checkNotNullParameter(drawData, "drawData");
        this.uuid = uuid;
        this.type = i3;
        this.path = path;
        this.leftMargin = i16;
        this.leftOffset = i17;
        this.minLeftMargin = i18;
        this.width = i19;
        this.maxWidth = i26;
        this.startClipWidth = i27;
        this.endClipWidth = i28;
        this.duration = j3;
        this.minWidth = i29;
        this.sourceData = sourceData;
        this.drawData = drawData;
    }

    @NotNull
    public final VideoTrackModel a(@NotNull String uuid, int type, @NotNull String path, int leftMargin, int leftOffset, int minLeftMargin, int width, int maxWidth, int startClipWidth, int endClipWidth, long duration, int minWidth, @NotNull VariableClipModel sourceData, @NotNull DrawData drawData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(sourceData, "sourceData");
        Intrinsics.checkNotNullParameter(drawData, "drawData");
        return new VideoTrackModel(uuid, type, path, leftMargin, leftOffset, minLeftMargin, width, maxWidth, startClipWidth, endClipWidth, duration, minWidth, sourceData, drawData);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final DrawData getDrawData() {
        return this.drawData;
    }

    /* renamed from: d, reason: from getter */
    public final int getEndClipWidth() {
        return this.endClipWidth;
    }

    public final int e() {
        return this.leftMargin + this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoTrackModel)) {
            return false;
        }
        VideoTrackModel videoTrackModel = (VideoTrackModel) other;
        if (Intrinsics.areEqual(this.uuid, videoTrackModel.uuid) && this.type == videoTrackModel.type && Intrinsics.areEqual(this.path, videoTrackModel.path) && this.leftMargin == videoTrackModel.leftMargin && this.leftOffset == videoTrackModel.leftOffset && this.minLeftMargin == videoTrackModel.minLeftMargin && this.width == videoTrackModel.width && this.maxWidth == videoTrackModel.maxWidth && this.startClipWidth == videoTrackModel.startClipWidth && this.endClipWidth == videoTrackModel.endClipWidth && this.duration == videoTrackModel.duration && this.minWidth == videoTrackModel.minWidth && Intrinsics.areEqual(this.sourceData, videoTrackModel.sourceData) && Intrinsics.areEqual(this.drawData, videoTrackModel.drawData)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getLeftMargin() {
        return this.leftMargin;
    }

    /* renamed from: g, reason: from getter */
    public final int getLeftOffset() {
        return this.leftOffset;
    }

    /* renamed from: h, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.uuid.hashCode() * 31) + this.type) * 31) + this.path.hashCode()) * 31) + this.leftMargin) * 31) + this.leftOffset) * 31) + this.minLeftMargin) * 31) + this.width) * 31) + this.maxWidth) * 31) + this.startClipWidth) * 31) + this.endClipWidth) * 31) + androidx.fragment.app.a.a(this.duration)) * 31) + this.minWidth) * 31) + this.sourceData.hashCode()) * 31) + this.drawData.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final int getMinLeftMargin() {
        return this.minLeftMargin;
    }

    /* renamed from: j, reason: from getter */
    public final int getMinWidth() {
        return this.minWidth;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final VariableClipModel getSourceData() {
        return this.sourceData;
    }

    /* renamed from: m, reason: from getter */
    public final int getStartClipWidth() {
        return this.startClipWidth;
    }

    /* renamed from: n, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: p, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void q(long j3) {
        this.duration = j3;
    }

    public final void r(int i3) {
        this.leftMargin = i3;
    }

    public final void s(int i3) {
        this.leftOffset = i3;
    }

    public final void t(int i3) {
        this.width = i3;
    }

    @NotNull
    public String toString() {
        return "VideoTrackModel(uuid=" + this.uuid + ", type=" + this.type + ", path=" + this.path + ", leftMargin=" + this.leftMargin + ", leftOffset=" + this.leftOffset + ", minLeftMargin=" + this.minLeftMargin + ", width=" + this.width + ", maxWidth=" + this.maxWidth + ", startClipWidth=" + this.startClipWidth + ", endClipWidth=" + this.endClipWidth + ", duration=" + this.duration + ", minWidth=" + this.minWidth + ", sourceData=" + this.sourceData + ", drawData=" + this.drawData + ")";
    }
}
