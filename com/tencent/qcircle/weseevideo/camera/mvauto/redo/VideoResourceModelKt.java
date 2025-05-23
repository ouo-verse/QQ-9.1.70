package com.tencent.qcircle.weseevideo.camera.mvauto.redo;

import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001GB\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0015J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0007H\u00c6\u0003J\t\u00103\u001a\u00020\u0007H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0007H\u00c6\u0003J\t\u00109\u001a\u00020\u0007H\u00c6\u0003J\t\u0010:\u001a\u00020\u0007H\u00c6\u0003J\t\u0010;\u001a\u00020\u0007H\u00c6\u0003J\t\u0010<\u001a\u00020\u0007H\u00c6\u0003J\t\u0010=\u001a\u00020\u0007H\u00c6\u0003J\t\u0010>\u001a\u00020\u0007H\u00c6\u0003J\u0006\u0010?\u001a\u00020@J\u00a9\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010E\u001a\u00020\u0005H\u00d6\u0001J\t\u0010F\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010%\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a\u00a8\u0006H"}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "", "path", "", "type", "", "scaleDuration", "", "sourceTimeStart", "sourceTimeDuration", "sourceTimeStartUs", "sourceTimeDurationUs", "selectTimeStart", "selectTimeDuration", "selectTimeStartUs", "selectTimeDurationUs", "cutTimeStart", "cutTimeDuration", "width", "height", CanvasView.ACTION_ROTATE, "(Ljava/lang/String;IJJJJJJJJJJJIII)V", "getCutTimeDuration", "()J", "getCutTimeStart", "getHeight", "()I", "getPath", "()Ljava/lang/String;", "getRotate", "getScaleDuration", "scaleSpeed", "", "getScaleSpeed", "()F", "getSelectTimeDuration", "getSelectTimeDurationUs", "selectTimeEndUs", "getSelectTimeEndUs", "getSelectTimeStart", "getSelectTimeStartUs", "getSourceTimeDuration", "getSourceTimeDurationUs", "getSourceTimeStart", "getSourceTimeStartUs", "getType", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convert", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VideoResourceModelKt {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long cutTimeDuration;
    private final long cutTimeStart;
    private final int height;

    @NotNull
    private final String path;
    private final int rotate;
    private final long scaleDuration;
    private final float scaleSpeed;
    private final long selectTimeDuration;
    private final long selectTimeDurationUs;
    private final long selectTimeEndUs;
    private final long selectTimeStart;
    private final long selectTimeStartUs;
    private final long sourceTimeDuration;
    private final long sourceTimeDurationUs;
    private final long sourceTimeStart;
    private final long sourceTimeStartUs;
    private final int type;
    private final int width;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt$Companion;", "", "()V", "from", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "it", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final VideoResourceModelKt from(@NotNull VideoResourceModel it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
            String path = it.getPath();
            if (path == null) {
                path = "";
            }
            int type = it.getType();
            long scaleDuration = it.getScaleDuration();
            long sourceTimeStart = it.getSourceTimeStart();
            long sourceTimeStartUs = it.getSourceTimeStartUs();
            return new VideoResourceModelKt(path, type, scaleDuration, sourceTimeStart, it.getSourceTimeDuration(), sourceTimeStartUs, it.getSourceTimeDurationUs(), it.getSelectTimeStart(), it.getSelectTimeDuration(), it.getSelectTimeStartUs(), it.getSelectTimeDurationUs(), it.getCutTimeStart(), it.getCutTimeDuration(), it.getWidth(), it.getHeight(), it.getRotate());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VideoResourceModelKt(@NotNull String path, int i3, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, int i16, int i17, int i18) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        this.path = path;
        this.type = i3;
        this.scaleDuration = j3;
        this.sourceTimeStart = j16;
        this.sourceTimeDuration = j17;
        this.sourceTimeStartUs = j18;
        this.sourceTimeDurationUs = j19;
        this.selectTimeStart = j26;
        this.selectTimeDuration = j27;
        this.selectTimeStartUs = j28;
        this.selectTimeDurationUs = j29;
        this.cutTimeStart = j36;
        this.cutTimeDuration = j37;
        this.width = i16;
        this.height = i17;
        this.rotate = i18;
        this.scaleSpeed = j27 != 0 ? (((float) j27) * 1.0f) / ((float) j3) : 1.0f;
        this.selectTimeEndUs = ((float) (j28 + j29)) / r10;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component10, reason: from getter */
    public final long getSelectTimeStartUs() {
        return this.selectTimeStartUs;
    }

    /* renamed from: component11, reason: from getter */
    public final long getSelectTimeDurationUs() {
        return this.selectTimeDurationUs;
    }

    /* renamed from: component12, reason: from getter */
    public final long getCutTimeStart() {
        return this.cutTimeStart;
    }

    /* renamed from: component13, reason: from getter */
    public final long getCutTimeDuration() {
        return this.cutTimeDuration;
    }

    /* renamed from: component14, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component15, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component16, reason: from getter */
    public final int getRotate() {
        return this.rotate;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final long getScaleDuration() {
        return this.scaleDuration;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSourceTimeStart() {
        return this.sourceTimeStart;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSourceTimeDuration() {
        return this.sourceTimeDuration;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSourceTimeStartUs() {
        return this.sourceTimeStartUs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getSourceTimeDurationUs() {
        return this.sourceTimeDurationUs;
    }

    /* renamed from: component8, reason: from getter */
    public final long getSelectTimeStart() {
        return this.selectTimeStart;
    }

    /* renamed from: component9, reason: from getter */
    public final long getSelectTimeDuration() {
        return this.selectTimeDuration;
    }

    @NotNull
    public final VideoResourceModel convert() {
        return new VideoResourceModel(this.path, this.scaleDuration, this.type, this.sourceTimeStartUs, this.sourceTimeDurationUs, this.selectTimeStartUs, this.selectTimeDurationUs, this.cutTimeStart, this.cutTimeDuration, this.width, this.height, this.rotate, null, 4096, null);
    }

    @NotNull
    public final VideoResourceModelKt copy(@NotNull String path, int type, long scaleDuration, long sourceTimeStart, long sourceTimeDuration, long sourceTimeStartUs, long sourceTimeDurationUs, long selectTimeStart, long selectTimeDuration, long selectTimeStartUs, long selectTimeDurationUs, long cutTimeStart, long cutTimeDuration, int width, int height, int rotate) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        return new VideoResourceModelKt(path, type, scaleDuration, sourceTimeStart, sourceTimeDuration, sourceTimeStartUs, sourceTimeDurationUs, selectTimeStart, selectTimeDuration, selectTimeStartUs, selectTimeDurationUs, cutTimeStart, cutTimeDuration, width, height, rotate);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VideoResourceModelKt) {
                VideoResourceModelKt videoResourceModelKt = (VideoResourceModelKt) other;
                if (!Intrinsics.areEqual(this.path, videoResourceModelKt.path) || this.type != videoResourceModelKt.type || this.scaleDuration != videoResourceModelKt.scaleDuration || this.sourceTimeStart != videoResourceModelKt.sourceTimeStart || this.sourceTimeDuration != videoResourceModelKt.sourceTimeDuration || this.sourceTimeStartUs != videoResourceModelKt.sourceTimeStartUs || this.sourceTimeDurationUs != videoResourceModelKt.sourceTimeDurationUs || this.selectTimeStart != videoResourceModelKt.selectTimeStart || this.selectTimeDuration != videoResourceModelKt.selectTimeDuration || this.selectTimeStartUs != videoResourceModelKt.selectTimeStartUs || this.selectTimeDurationUs != videoResourceModelKt.selectTimeDurationUs || this.cutTimeStart != videoResourceModelKt.cutTimeStart || this.cutTimeDuration != videoResourceModelKt.cutTimeDuration || this.width != videoResourceModelKt.width || this.height != videoResourceModelKt.height || this.rotate != videoResourceModelKt.rotate) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getCutTimeDuration() {
        return this.cutTimeDuration;
    }

    public final long getCutTimeStart() {
        return this.cutTimeStart;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final int getRotate() {
        return this.rotate;
    }

    public final long getScaleDuration() {
        return this.scaleDuration;
    }

    public final float getScaleSpeed() {
        return this.scaleSpeed;
    }

    public final long getSelectTimeDuration() {
        return this.selectTimeDuration;
    }

    public final long getSelectTimeDurationUs() {
        return this.selectTimeDurationUs;
    }

    public final long getSelectTimeEndUs() {
        return this.selectTimeEndUs;
    }

    public final long getSelectTimeStart() {
        return this.selectTimeStart;
    }

    public final long getSelectTimeStartUs() {
        return this.selectTimeStartUs;
    }

    public final long getSourceTimeDuration() {
        return this.sourceTimeDuration;
    }

    public final long getSourceTimeDurationUs() {
        return this.sourceTimeDurationUs;
    }

    public final long getSourceTimeStart() {
        return this.sourceTimeStart;
    }

    public final long getSourceTimeStartUs() {
        return this.sourceTimeStartUs;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        String str = this.path;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = ((i3 * 31) + this.type) * 31;
        long j3 = this.scaleDuration;
        int i17 = (i16 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.sourceTimeStart;
        int i18 = (i17 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.sourceTimeDuration;
        int i19 = (i18 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.sourceTimeStartUs;
        int i26 = (i19 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.sourceTimeDurationUs;
        int i27 = (i26 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        long j26 = this.selectTimeStart;
        int i28 = (i27 + ((int) (j26 ^ (j26 >>> 32)))) * 31;
        long j27 = this.selectTimeDuration;
        int i29 = (i28 + ((int) (j27 ^ (j27 >>> 32)))) * 31;
        long j28 = this.selectTimeStartUs;
        int i36 = (i29 + ((int) (j28 ^ (j28 >>> 32)))) * 31;
        long j29 = this.selectTimeDurationUs;
        int i37 = (i36 + ((int) (j29 ^ (j29 >>> 32)))) * 31;
        long j36 = this.cutTimeStart;
        int i38 = (i37 + ((int) (j36 ^ (j36 >>> 32)))) * 31;
        long j37 = this.cutTimeDuration;
        return ((((((i38 + ((int) (j37 ^ (j37 >>> 32)))) * 31) + this.width) * 31) + this.height) * 31) + this.rotate;
    }

    @NotNull
    public String toString() {
        return "VideoResourceModelKt(path=" + this.path + ", type=" + this.type + ", scaleDuration=" + this.scaleDuration + ", sourceTimeStart=" + this.sourceTimeStart + ", sourceTimeDuration=" + this.sourceTimeDuration + ", sourceTimeStartUs=" + this.sourceTimeStartUs + ", sourceTimeDurationUs=" + this.sourceTimeDurationUs + ", selectTimeStart=" + this.selectTimeStart + ", selectTimeDuration=" + this.selectTimeDuration + ", selectTimeStartUs=" + this.selectTimeStartUs + ", selectTimeDurationUs=" + this.selectTimeDurationUs + ", cutTimeStart=" + this.cutTimeStart + ", cutTimeDuration=" + this.cutTimeDuration + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.rotate + ")";
    }
}
