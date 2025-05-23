package com.tencent.richframework.gallery.anim;

import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010'\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010(\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010*\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010 J\b\u00100\u001a\u000201H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\"\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0003\u001a\u0004\u0018\u00010 @BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00063"}, d2 = {"Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "Ljava/io/Serializable;", "()V", "<set-?>", "", "fadeCoverTimeMs", "getFadeCoverTimeMs", "()I", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean$SourceRect;", "imageRect", "getImageRect", "()Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean$SourceRect;", "", "isBackTransition", "()Z", "isCarvedAnimOpen", "setCarvedAnimOpen", "(Z)V", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", "getLayerPicInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layoutRect", "getLayoutRect", "Landroid/widget/ImageView$ScaleType;", "scaleType", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "transitionDelayTimeMs", "getTransitionDelayTimeMs", "transitionDuration", "getTransitionDuration", "Ljava/util/UUID;", "uUid", "getUUid", "()Ljava/util/UUID;", "setBackTransition", "backTransition", "setFadeCoverTimeMs", "setImageRect", "setLayerPicInfo", "setLayoutRect", "setScaleType", "setTransitionDelayTimeMs", "delayTimeMs", "setTransitionDurationMs", "setUUid", "mUUid", "toString", "", "SourceRect", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWTransAnimBean implements Serializable {

    @Nullable
    private SourceRect imageRect;
    private boolean isCarvedAnimOpen;

    @Nullable
    private RFWLayerPicInfo layerPicInfo;
    private SourceRect layoutRect;

    @Nullable
    private ImageView.ScaleType scaleType;

    @Nullable
    private UUID uUid;
    private boolean isBackTransition = true;
    private int transitionDelayTimeMs = 300;
    private int fadeCoverTimeMs = 500;
    private int transitionDuration = 300;

    public final int getFadeCoverTimeMs() {
        return this.fadeCoverTimeMs;
    }

    @Nullable
    public final SourceRect getImageRect() {
        return this.imageRect;
    }

    @Nullable
    public final RFWLayerPicInfo getLayerPicInfo() {
        return this.layerPicInfo;
    }

    @NotNull
    public final SourceRect getLayoutRect() {
        SourceRect sourceRect = this.layoutRect;
        if (sourceRect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutRect");
        }
        return sourceRect;
    }

    @Nullable
    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final int getTransitionDelayTimeMs() {
        return this.transitionDelayTimeMs;
    }

    public final int getTransitionDuration() {
        return this.transitionDuration;
    }

    @Nullable
    public final UUID getUUid() {
        return this.uUid;
    }

    /* renamed from: isBackTransition, reason: from getter */
    public final boolean getIsBackTransition() {
        return this.isBackTransition;
    }

    /* renamed from: isCarvedAnimOpen, reason: from getter */
    public final boolean getIsCarvedAnimOpen() {
        return this.isCarvedAnimOpen;
    }

    @NotNull
    public final RFWTransAnimBean setBackTransition(boolean backTransition) {
        this.isBackTransition = backTransition;
        return this;
    }

    public final void setCarvedAnimOpen(boolean z16) {
        this.isCarvedAnimOpen = z16;
    }

    @NotNull
    public final RFWTransAnimBean setFadeCoverTimeMs(int fadeCoverTimeMs) {
        this.fadeCoverTimeMs = fadeCoverTimeMs;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setImageRect(@Nullable SourceRect imageRect) {
        this.imageRect = imageRect;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setLayerPicInfo(@Nullable RFWLayerPicInfo layerPicInfo) {
        this.layerPicInfo = layerPicInfo;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setLayoutRect(@NotNull SourceRect layoutRect) {
        Intrinsics.checkNotNullParameter(layoutRect, "layoutRect");
        this.layoutRect = layoutRect;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setScaleType(@Nullable ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setTransitionDelayTimeMs(int delayTimeMs) {
        this.transitionDelayTimeMs = delayTimeMs;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setTransitionDurationMs(int fadeCoverTimeMs) {
        this.transitionDuration = fadeCoverTimeMs;
        return this;
    }

    @NotNull
    public final RFWTransAnimBean setUUid(@Nullable UUID mUUid) {
        this.uUid = mUUid;
        return this;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QFSTransitionAnimBean{mLayoutRect=");
        SourceRect sourceRect = this.layoutRect;
        if (sourceRect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutRect");
        }
        sb5.append(sourceRect);
        sb5.append(", mImageRect=");
        sb5.append(this.imageRect);
        sb5.append(", mScaleType=");
        sb5.append(this.scaleType);
        sb5.append('}');
        return sb5.toString();
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0017\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean$SourceRect;", "Ljava/io/Serializable;", "left", "", "top", "right", "bottom", "(IIII)V", CanvasView.ACTION_RECT, "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "getBottom", "()I", "setBottom", "(I)V", "height", "getHeight", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "width", "getWidth", "toString", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class SourceRect implements Serializable {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public SourceRect(int i3, int i16, int i17, int i18) {
            this.left = i3;
            this.top = i16;
            this.right = i17;
            this.bottom = i18;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getHeight() {
            return this.bottom - this.top;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getWidth() {
            return this.right - this.left;
        }

        public final void setBottom(int i3) {
            this.bottom = i3;
        }

        public final void setLeft(int i3) {
            this.left = i3;
        }

        public final void setRight(int i3) {
            this.right = i3;
        }

        public final void setTop(int i3) {
            this.top = i3;
        }

        @NotNull
        public String toString() {
            return "SourceRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }

        public SourceRect(@NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.left = rect.left;
            this.top = rect.top;
            this.right = rect.right;
            this.bottom = rect.bottom;
        }
    }
}
