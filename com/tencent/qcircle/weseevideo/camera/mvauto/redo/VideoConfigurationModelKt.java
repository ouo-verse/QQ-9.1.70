package com.tencent.qcircle.weseevideo.camera.mvauto.redo;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.EditorPointF;
import com.tencent.qcircle.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u0006\u0010!\u001a\u00020\"J_\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "", "contentMode", "", "frameOrigin", "Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "frameWidth", "", "frameHeight", "matrix", "", JsonUtils.KEY_EFFECTS, "Lcom/tencent/qcircle/weseevideo/model/effect/VideoEffectModel;", CanvasView.ACTION_ROTATE, "(ILcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;FFLjava/util/List;Ljava/util/List;I)V", "getContentMode", "()I", "getEffects", "()Ljava/util/List;", "getFrameHeight", "()F", "getFrameOrigin", "()Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "getFrameWidth", "getMatrix", "getRotate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "convert", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VideoConfigurationModelKt {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int contentMode;

    @Nullable
    private final List<VideoEffectModel> effects;
    private final float frameHeight;

    @Nullable
    private final EditorPointF frameOrigin;
    private final float frameWidth;

    @NotNull
    private final List<Float> matrix;
    private final int rotate;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt$Companion;", "", "()V", "from", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "it", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final VideoConfigurationModelKt from(@NotNull VideoConfigurationModel it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
            int contentMode = it.getContentMode();
            float frameHeight = it.getFrameHeight();
            return new VideoConfigurationModelKt(contentMode, it.getFrameOrigin(), it.getFrameWidth(), frameHeight, it.getMatrix(), it.getEffects(), it.getRotate());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VideoConfigurationModelKt(int i3, @Nullable EditorPointF editorPointF, float f16, float f17, @NotNull List<Float> matrix, @Nullable List<VideoEffectModel> list, int i16) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        this.contentMode = i3;
        this.frameOrigin = editorPointF;
        this.frameWidth = f16;
        this.frameHeight = f17;
        this.matrix = matrix;
        this.effects = list;
        this.rotate = i16;
    }

    public static /* synthetic */ VideoConfigurationModelKt copy$default(VideoConfigurationModelKt videoConfigurationModelKt, int i3, EditorPointF editorPointF, float f16, float f17, List list, List list2, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = videoConfigurationModelKt.contentMode;
        }
        if ((i17 & 2) != 0) {
            editorPointF = videoConfigurationModelKt.frameOrigin;
        }
        EditorPointF editorPointF2 = editorPointF;
        if ((i17 & 4) != 0) {
            f16 = videoConfigurationModelKt.frameWidth;
        }
        float f18 = f16;
        if ((i17 & 8) != 0) {
            f17 = videoConfigurationModelKt.frameHeight;
        }
        float f19 = f17;
        if ((i17 & 16) != 0) {
            list = videoConfigurationModelKt.matrix;
        }
        List list3 = list;
        if ((i17 & 32) != 0) {
            list2 = videoConfigurationModelKt.effects;
        }
        List list4 = list2;
        if ((i17 & 64) != 0) {
            i16 = videoConfigurationModelKt.rotate;
        }
        return videoConfigurationModelKt.copy(i3, editorPointF2, f18, f19, list3, list4, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getContentMode() {
        return this.contentMode;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final EditorPointF getFrameOrigin() {
        return this.frameOrigin;
    }

    /* renamed from: component3, reason: from getter */
    public final float getFrameWidth() {
        return this.frameWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final float getFrameHeight() {
        return this.frameHeight;
    }

    @NotNull
    public final List<Float> component5() {
        return this.matrix;
    }

    @Nullable
    public final List<VideoEffectModel> component6() {
        return this.effects;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRotate() {
        return this.rotate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final VideoConfigurationModel convert() {
        List list;
        List emptyList;
        int i3 = this.contentMode;
        EditorPointF editorPointF = this.frameOrigin;
        float f16 = this.frameWidth;
        float f17 = this.frameHeight;
        list = CollectionsKt___CollectionsKt.toList(this.matrix);
        List<VideoEffectModel> list2 = this.effects;
        if (list2 == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new VideoConfigurationModel(i3, editorPointF, f16, f17, list, emptyList, this.rotate);
    }

    @NotNull
    public final VideoConfigurationModelKt copy(int contentMode, @Nullable EditorPointF frameOrigin, float frameWidth, float frameHeight, @NotNull List<Float> matrix, @Nullable List<VideoEffectModel> effects, int rotate) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        return new VideoConfigurationModelKt(contentMode, frameOrigin, frameWidth, frameHeight, matrix, effects, rotate);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VideoConfigurationModelKt) {
                VideoConfigurationModelKt videoConfigurationModelKt = (VideoConfigurationModelKt) other;
                if (this.contentMode != videoConfigurationModelKt.contentMode || !Intrinsics.areEqual(this.frameOrigin, videoConfigurationModelKt.frameOrigin) || Float.compare(this.frameWidth, videoConfigurationModelKt.frameWidth) != 0 || Float.compare(this.frameHeight, videoConfigurationModelKt.frameHeight) != 0 || !Intrinsics.areEqual(this.matrix, videoConfigurationModelKt.matrix) || !Intrinsics.areEqual(this.effects, videoConfigurationModelKt.effects) || this.rotate != videoConfigurationModelKt.rotate) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getContentMode() {
        return this.contentMode;
    }

    @Nullable
    public final List<VideoEffectModel> getEffects() {
        return this.effects;
    }

    public final float getFrameHeight() {
        return this.frameHeight;
    }

    @Nullable
    public final EditorPointF getFrameOrigin() {
        return this.frameOrigin;
    }

    public final float getFrameWidth() {
        return this.frameWidth;
    }

    @NotNull
    public final List<Float> getMatrix() {
        return this.matrix;
    }

    public final int getRotate() {
        return this.rotate;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.contentMode * 31;
        EditorPointF editorPointF = this.frameOrigin;
        int i18 = 0;
        if (editorPointF != null) {
            i3 = editorPointF.hashCode();
        } else {
            i3 = 0;
        }
        int floatToIntBits = (((((i17 + i3) * 31) + Float.floatToIntBits(this.frameWidth)) * 31) + Float.floatToIntBits(this.frameHeight)) * 31;
        List<Float> list = this.matrix;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (floatToIntBits + i16) * 31;
        List<VideoEffectModel> list2 = this.effects;
        if (list2 != null) {
            i18 = list2.hashCode();
        }
        return ((i19 + i18) * 31) + this.rotate;
    }

    @NotNull
    public String toString() {
        return "VideoConfigurationModelKt(contentMode=" + this.contentMode + ", frameOrigin=" + this.frameOrigin + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", matrix=" + this.matrix + ", effects=" + this.effects + ", rotate=" + this.rotate + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ VideoConfigurationModelKt(int i3, EditorPointF editorPointF, float f16, float f17, List list, List list2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, editorPointF, f16, f17, r7, list2, (i17 & 64) != 0 ? 0 : i16);
        List list3;
        List listOf;
        if ((i17 & 16) != 0) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)});
            list3 = listOf;
        } else {
            list3 = list;
        }
    }
}
