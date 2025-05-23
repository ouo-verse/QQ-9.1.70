package com.tencent.qcircle.weseevideo.model.resource;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u00c6\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J_\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\b\u0010-\u001a\u0004\u0018\u00010.J\u0006\u0010/\u001a\u00020\u0000J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u00d6\u0003J\u0006\u00104\u001a\u000205J\t\u00106\u001a\u00020\u0003H\u00d6\u0001J\u000e\u00107\u001a\u0002082\u0006\u0010\t\u001a\u000205J\t\u00109\u001a\u00020:H\u00d6\u0001J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012\u00a8\u0006<"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "Ljava/io/Serializable;", "contentMode", "", "frameOrigin", "Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "frameWidth", "", "frameHeight", "matrix", "", JsonUtils.KEY_EFFECTS, "Lcom/tencent/qcircle/weseevideo/model/effect/VideoEffectModel;", CanvasView.ACTION_ROTATE, "(ILcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;FFLjava/util/List;Ljava/util/List;I)V", "getContentMode", "()I", "setContentMode", "(I)V", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getFrameHeight", "()F", "setFrameHeight", "(F)V", "getFrameOrigin", "()Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "setFrameOrigin", "(Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;)V", "getFrameWidth", "setFrameWidth", "getMatrix", "setMatrix", "getRotate", "setRotate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createFrameRect", "Lcom/tencent/tav/coremedia/CGRect;", "deepClone", "equals", "", "other", "", "getMatrixCompat", "Landroid/graphics/Matrix;", "hashCode", "setMatrixCompat", "", "toString", "", "update", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VideoConfigurationModel implements Serializable {
    private int contentMode;

    @Nullable
    private List<VideoEffectModel> effects;
    private float frameHeight;

    @Nullable
    private EditorPointF frameOrigin;
    private float frameWidth;

    @NotNull
    private List<Float> matrix;
    private int rotate;

    public VideoConfigurationModel() {
        this(0, null, 0.0f, 0.0f, null, null, 0, 127, null);
    }

    public static /* synthetic */ VideoConfigurationModel copy$default(VideoConfigurationModel videoConfigurationModel, int i3, EditorPointF editorPointF, float f16, float f17, List list, List list2, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = videoConfigurationModel.contentMode;
        }
        if ((i17 & 2) != 0) {
            editorPointF = videoConfigurationModel.frameOrigin;
        }
        EditorPointF editorPointF2 = editorPointF;
        if ((i17 & 4) != 0) {
            f16 = videoConfigurationModel.frameWidth;
        }
        float f18 = f16;
        if ((i17 & 8) != 0) {
            f17 = videoConfigurationModel.frameHeight;
        }
        float f19 = f17;
        if ((i17 & 16) != 0) {
            list = videoConfigurationModel.matrix;
        }
        List list3 = list;
        if ((i17 & 32) != 0) {
            list2 = videoConfigurationModel.effects;
        }
        List list4 = list2;
        if ((i17 & 64) != 0) {
            i16 = videoConfigurationModel.rotate;
        }
        return videoConfigurationModel.copy(i3, editorPointF2, f18, f19, list3, list4, i16);
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

    @NotNull
    public final VideoConfigurationModel copy(int contentMode, @Nullable EditorPointF frameOrigin, float frameWidth, float frameHeight, @NotNull List<Float> matrix, @Nullable List<VideoEffectModel> effects, int rotate) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        return new VideoConfigurationModel(contentMode, frameOrigin, frameWidth, frameHeight, matrix, effects, rotate);
    }

    @Nullable
    public final CGRect createFrameRect() {
        float f16;
        if (this.frameOrigin != null) {
            float f17 = 0;
            if (this.frameWidth > f17 && this.frameHeight > f17) {
                EditorPointF editorPointF = this.frameOrigin;
                float f18 = 0.0f;
                if (editorPointF != null) {
                    f16 = editorPointF.getX();
                } else {
                    f16 = 0.0f;
                }
                EditorPointF editorPointF2 = this.frameOrigin;
                if (editorPointF2 != null) {
                    f18 = editorPointF2.getY();
                }
                return new CGRect(new PointF(f16, f18), new CGSize(this.frameWidth, this.frameHeight));
            }
        }
        return null;
    }

    @NotNull
    public final VideoConfigurationModel deepClone() {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        try {
            List<VideoEffectModel> list = this.effects;
            if (list != null) {
                List<VideoEffectModel> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(VideoEffectModel.copy$default((VideoEffectModel) it.next(), 0, null, null, 0.0f, 0.0f, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null));
                }
            } else {
                arrayList = null;
            }
            return copy$default(this, 0, null, 0.0f, 0.0f, null, arrayList, 0, 95, null);
        } catch (CloneNotSupportedException unused) {
            return copy$default(this, 0, null, 0.0f, 0.0f, null, null, 0, 127, null);
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VideoConfigurationModel) {
                VideoConfigurationModel videoConfigurationModel = (VideoConfigurationModel) other;
                if (this.contentMode != videoConfigurationModel.contentMode || !Intrinsics.areEqual(this.frameOrigin, videoConfigurationModel.frameOrigin) || Float.compare(this.frameWidth, videoConfigurationModel.frameWidth) != 0 || Float.compare(this.frameHeight, videoConfigurationModel.frameHeight) != 0 || !Intrinsics.areEqual(this.matrix, videoConfigurationModel.matrix) || !Intrinsics.areEqual(this.effects, videoConfigurationModel.effects) || this.rotate != videoConfigurationModel.rotate) {
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

    @NotNull
    public final Matrix getMatrixCompat() {
        float[] floatArray;
        Matrix matrix = new Matrix();
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(this.matrix);
        matrix.setValues(floatArray);
        return matrix;
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

    public final void setContentMode(int i3) {
        this.contentMode = i3;
    }

    public final void setEffects(@Nullable List<VideoEffectModel> list) {
        this.effects = list;
    }

    public final void setFrameHeight(float f16) {
        this.frameHeight = f16;
    }

    public final void setFrameOrigin(@Nullable EditorPointF editorPointF) {
        this.frameOrigin = editorPointF;
    }

    public final void setFrameWidth(float f16) {
        this.frameWidth = f16;
    }

    public final void setMatrix(@NotNull List<Float> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.matrix = list;
    }

    public final void setMatrixCompat(@NotNull Matrix matrix) {
        List<Float> list;
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        list = ArraysKt___ArraysKt.toList(fArr);
        this.matrix = list;
    }

    public final void setRotate(int i3) {
        this.rotate = i3;
    }

    @NotNull
    public String toString() {
        return "VideoConfigurationModel(contentMode=" + this.contentMode + ", frameOrigin=" + this.frameOrigin + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", matrix=" + this.matrix + ", effects=" + this.effects + ", rotate=" + this.rotate + ")";
    }

    @NotNull
    public final VideoConfigurationModel update(int rotate) {
        return copy$default(this, 0, null, 0.0f, 0.0f, null, null, rotate, 63, null);
    }

    public VideoConfigurationModel(int i3, @Nullable EditorPointF editorPointF, float f16, float f17, @NotNull List<Float> matrix, @Nullable List<VideoEffectModel> list, int i16) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        this.contentMode = i3;
        this.frameOrigin = editorPointF;
        this.frameWidth = f16;
        this.frameHeight = f17;
        this.matrix = matrix;
        this.effects = list;
        this.rotate = i16;
    }

    public /* synthetic */ VideoConfigurationModel(int i3, EditorPointF editorPointF, float f16, float f17, List list, List list2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? null : editorPointF, (i17 & 4) != 0 ? 0.0f : f16, (i17 & 8) != 0 ? 0.0f : f17, (i17 & 16) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)}) : list, (i17 & 32) != 0 ? new ArrayList() : list2, (i17 & 64) != 0 ? 0 : i16);
    }
}
