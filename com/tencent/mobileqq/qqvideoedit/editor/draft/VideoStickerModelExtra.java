package com.tencent.mobileqq.qqvideoedit.editor.draft;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqvideoedit.editor.model.PointF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003Jo\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoStickerModelExtra;", "Ljava/io/Serializable;", "initStickerScale", "", "downScaleRecord", "originPointInView", "Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "sizeInView", "centerInView", "leftTopInView", "rightBottomInView", WadlProxyConsts.KEY_MATERIAL, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "lastDownScale", "lastDownRotate", "(FFLcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;FF)V", "getCenterInView", "()Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "getDownScaleRecord", "()F", "getInitStickerScale", "getLastDownRotate", "getLastDownScale", "getLeftTopInView", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getOriginPointInView", "getRightBottomInView", "getSizeInView", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class VideoStickerModelExtra implements Serializable {

    @NotNull
    private final PointF centerInView;
    private final float downScaleRecord;
    private final float initStickerScale;
    private final float lastDownRotate;
    private final float lastDownScale;

    @NotNull
    private final PointF leftTopInView;

    @Nullable
    private final MetaMaterial material;

    @NotNull
    private final PointF originPointInView;

    @NotNull
    private final PointF rightBottomInView;

    @NotNull
    private final PointF sizeInView;

    public VideoStickerModelExtra() {
        this(0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final float getInitStickerScale() {
        return this.initStickerScale;
    }

    /* renamed from: component10, reason: from getter */
    public final float getLastDownRotate() {
        return this.lastDownRotate;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDownScaleRecord() {
        return this.downScaleRecord;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final PointF getOriginPointInView() {
        return this.originPointInView;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final PointF getSizeInView() {
        return this.sizeInView;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final PointF getCenterInView() {
        return this.centerInView;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final PointF getLeftTopInView() {
        return this.leftTopInView;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final PointF getRightBottomInView() {
        return this.rightBottomInView;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    /* renamed from: component9, reason: from getter */
    public final float getLastDownScale() {
        return this.lastDownScale;
    }

    @NotNull
    public final VideoStickerModelExtra copy(float initStickerScale, float downScaleRecord, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial material, float lastDownScale, float lastDownRotate) {
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        return new VideoStickerModelExtra(initStickerScale, downScaleRecord, originPointInView, sizeInView, centerInView, leftTopInView, rightBottomInView, material, lastDownScale, lastDownRotate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoStickerModelExtra)) {
            return false;
        }
        VideoStickerModelExtra videoStickerModelExtra = (VideoStickerModelExtra) other;
        if (Float.compare(this.initStickerScale, videoStickerModelExtra.initStickerScale) == 0 && Float.compare(this.downScaleRecord, videoStickerModelExtra.downScaleRecord) == 0 && Intrinsics.areEqual(this.originPointInView, videoStickerModelExtra.originPointInView) && Intrinsics.areEqual(this.sizeInView, videoStickerModelExtra.sizeInView) && Intrinsics.areEqual(this.centerInView, videoStickerModelExtra.centerInView) && Intrinsics.areEqual(this.leftTopInView, videoStickerModelExtra.leftTopInView) && Intrinsics.areEqual(this.rightBottomInView, videoStickerModelExtra.rightBottomInView) && Intrinsics.areEqual(this.material, videoStickerModelExtra.material) && Float.compare(this.lastDownScale, videoStickerModelExtra.lastDownScale) == 0 && Float.compare(this.lastDownRotate, videoStickerModelExtra.lastDownRotate) == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final PointF getCenterInView() {
        return this.centerInView;
    }

    public final float getDownScaleRecord() {
        return this.downScaleRecord;
    }

    public final float getInitStickerScale() {
        return this.initStickerScale;
    }

    public final float getLastDownRotate() {
        return this.lastDownRotate;
    }

    public final float getLastDownScale() {
        return this.lastDownScale;
    }

    @NotNull
    public final PointF getLeftTopInView() {
        return this.leftTopInView;
    }

    @Nullable
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    @NotNull
    public final PointF getOriginPointInView() {
        return this.originPointInView;
    }

    @NotNull
    public final PointF getRightBottomInView() {
        return this.rightBottomInView;
    }

    @NotNull
    public final PointF getSizeInView() {
        return this.sizeInView;
    }

    public int hashCode() {
        int hashCode;
        int floatToIntBits = ((((((((((((Float.floatToIntBits(this.initStickerScale) * 31) + Float.floatToIntBits(this.downScaleRecord)) * 31) + this.originPointInView.hashCode()) * 31) + this.sizeInView.hashCode()) * 31) + this.centerInView.hashCode()) * 31) + this.leftTopInView.hashCode()) * 31) + this.rightBottomInView.hashCode()) * 31;
        MetaMaterial metaMaterial = this.material;
        if (metaMaterial == null) {
            hashCode = 0;
        } else {
            hashCode = metaMaterial.hashCode();
        }
        return ((((floatToIntBits + hashCode) * 31) + Float.floatToIntBits(this.lastDownScale)) * 31) + Float.floatToIntBits(this.lastDownRotate);
    }

    @NotNull
    public String toString() {
        return "VideoStickerModelExtra(initStickerScale=" + this.initStickerScale + ", downScaleRecord=" + this.downScaleRecord + ", originPointInView=" + this.originPointInView + ", sizeInView=" + this.sizeInView + ", centerInView=" + this.centerInView + ", leftTopInView=" + this.leftTopInView + ", rightBottomInView=" + this.rightBottomInView + ", material=" + this.material + ", lastDownScale=" + this.lastDownScale + ", lastDownRotate=" + this.lastDownRotate + ")";
    }

    public VideoStickerModelExtra(float f16, float f17, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial metaMaterial, float f18, float f19) {
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        this.initStickerScale = f16;
        this.downScaleRecord = f17;
        this.originPointInView = originPointInView;
        this.sizeInView = sizeInView;
        this.centerInView = centerInView;
        this.leftTopInView = leftTopInView;
        this.rightBottomInView = rightBottomInView;
        this.material = metaMaterial;
        this.lastDownScale = f18;
        this.lastDownRotate = f19;
    }

    public /* synthetic */ VideoStickerModelExtra(float f16, float f17, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, MetaMaterial metaMaterial, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? new PointF() : pointF, (i3 & 8) != 0 ? new PointF() : pointF2, (i3 & 16) != 0 ? new PointF() : pointF3, (i3 & 32) != 0 ? new PointF() : pointF4, (i3 & 64) != 0 ? new PointF() : pointF5, (i3 & 128) != 0 ? null : metaMaterial, (i3 & 256) != 0 ? 0.0f : f18, (i3 & 512) == 0 ? f19 : 0.0f);
    }
}
