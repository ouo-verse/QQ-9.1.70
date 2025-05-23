package com.tencent.qcircle.weseevideo.model.extra;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;", "Ljava/io/Serializable;", "frameInfoModel", "Lcom/tencent/qcircle/weseevideo/model/extra/FrameInfoModel;", "faceInfoModel", "Lcom/tencent/qcircle/weseevideo/model/extra/FaceInfoModel;", "(Lcom/tencent/qcircle/weseevideo/model/extra/FrameInfoModel;Lcom/tencent/qcircle/weseevideo/model/extra/FaceInfoModel;)V", "getFaceInfoModel", "()Lcom/tencent/qcircle/weseevideo/model/extra/FaceInfoModel;", "getFrameInfoModel", "()Lcom/tencent/qcircle/weseevideo/model/extra/FrameInfoModel;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class ExtraInfoModel implements Serializable {

    @Nullable
    private final FaceInfoModel faceInfoModel;

    @Nullable
    private final FrameInfoModel frameInfoModel;

    public ExtraInfoModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ExtraInfoModel copy$default(ExtraInfoModel extraInfoModel, FrameInfoModel frameInfoModel, FaceInfoModel faceInfoModel, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            frameInfoModel = extraInfoModel.frameInfoModel;
        }
        if ((i3 & 2) != 0) {
            faceInfoModel = extraInfoModel.faceInfoModel;
        }
        return extraInfoModel.copy(frameInfoModel, faceInfoModel);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final FrameInfoModel getFrameInfoModel() {
        return this.frameInfoModel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final FaceInfoModel getFaceInfoModel() {
        return this.faceInfoModel;
    }

    @NotNull
    public final ExtraInfoModel copy(@Nullable FrameInfoModel frameInfoModel, @Nullable FaceInfoModel faceInfoModel) {
        return new ExtraInfoModel(frameInfoModel, faceInfoModel);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ExtraInfoModel) {
                ExtraInfoModel extraInfoModel = (ExtraInfoModel) other;
                if (!Intrinsics.areEqual(this.frameInfoModel, extraInfoModel.frameInfoModel) || !Intrinsics.areEqual(this.faceInfoModel, extraInfoModel.faceInfoModel)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final FaceInfoModel getFaceInfoModel() {
        return this.faceInfoModel;
    }

    @Nullable
    public final FrameInfoModel getFrameInfoModel() {
        return this.frameInfoModel;
    }

    public int hashCode() {
        int i3;
        FrameInfoModel frameInfoModel = this.frameInfoModel;
        int i16 = 0;
        if (frameInfoModel != null) {
            i3 = frameInfoModel.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        FaceInfoModel faceInfoModel = this.faceInfoModel;
        if (faceInfoModel != null) {
            i16 = faceInfoModel.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ExtraInfoModel(frameInfoModel=" + this.frameInfoModel + ", faceInfoModel=" + this.faceInfoModel + ")";
    }

    public ExtraInfoModel(@Nullable FrameInfoModel frameInfoModel, @Nullable FaceInfoModel faceInfoModel) {
        this.frameInfoModel = frameInfoModel;
        this.faceInfoModel = faceInfoModel;
    }

    public /* synthetic */ ExtraInfoModel(FrameInfoModel frameInfoModel, FaceInfoModel faceInfoModel, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : frameInfoModel, (i3 & 2) != 0 ? null : faceInfoModel);
    }
}
