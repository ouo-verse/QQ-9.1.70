package com.tencent.mobileqq.wink.editor.crop;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 [2\u00020\u0001:\u0005\\]^_`B\u0011\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TB\u001b\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u00a2\u0006\u0004\bS\u0010WB#\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u0012\u0006\u0010Y\u001a\u00020X\u00a2\u0006\u0004\bS\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0010\u0010$\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\"J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0011J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'J\u001e\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0011J \u00102\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0011H\u0016J\u001a\u00105\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00112\b\b\u0002\u00104\u001a\u00020\u0011H\u0007J\u000e\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0011J\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010:\u001a\u00020\u0004H\u0014J(\u0010<\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\"H\u0014J\u0006\u0010=\u001a\u00020\u0004R\u0017\u0010A\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b6\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010CR\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010F\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010HR\u0016\u0010K\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\fR\u0016\u0010L\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\fR\u0016\u0010M\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00105R\u0016\u0010P\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorTransformTextureView;", "", "animate", "", "M", "O", "N", "", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", UserInfo.SEX_FEMALE, "imageCorners", "G", "I", "H", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "initScale", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "drawableWidth", "drawableHeight", "P", "D", "E", "Landroid/graphics/RectF;", "cropRect", "setCropRect", "targetAspectRatio", "setTargetAspectRatio", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$b;", "cropBoundsChangeListener", "setCropBoundsChangeListener", "", "imageToWrapCropBoundsAnimDuration", "setImageToWrapCropBoundsAnimDuration", "maxScaleMultiplier", "setMaxScaleMultiplier", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$ScaleMode;", HippyQQPagViewController.PropertyName.SCALE_MODE, "setScaleMode", "scale", "centerX", "centerY", "T", "deltaScale", "L", "px", "py", "r", "deltaAngle", "withInitScale", "J", "K", "B", "setImageToWrapCropBounds", "setImageToWrapCropMinBounds", "o", "durationMs", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/RectF;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/graphics/RectF;", "mCropRect", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "mTempMatrix", "mTargetAspectRatio", "mMaxScaleMultiplier", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mWrapCropBoundsRunnable", "mZoomImageToPositionRunnable", "mMaxScale", "mMinScale", "mImageToWrapCropBoundsAnimDuration", "U", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$ScaleMode;", "mScaleMode", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "W", "a", "b", "ScaleMode", "WrapCropBoundsRunnable", "ZoomImageToPosition", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkEditorCropTextureView extends WinkEditorTransformTextureView {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final RectF mCropRect;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Matrix mTempMatrix;

    /* renamed from: M, reason: from kotlin metadata */
    private float mTargetAspectRatio;

    /* renamed from: N, reason: from kotlin metadata */
    private float mMaxScaleMultiplier;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Runnable mWrapCropBoundsRunnable;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Runnable mZoomImageToPositionRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    private float mMaxScale;

    /* renamed from: S, reason: from kotlin metadata */
    private float mMinScale;

    /* renamed from: T, reason: from kotlin metadata */
    private long mImageToWrapCropBoundsAnimDuration;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private ScaleMode mScaleMode;

    @NotNull
    public Map<Integer, View> V;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$ScaleMode;", "", "(Ljava/lang/String;I)V", "LETTER_BOX", "ZOOM", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum ScaleMode {
        LETTER_BOX,
        ZOOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u000f\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u001d\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$WrapCropBoundsRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView;", "d", "Ljava/lang/ref/WeakReference;", "mCropImageView", "", "e", "J", "mDurationMs", "f", "mStartTime", "", tl.h.F, UserInfo.SEX_FEMALE, "mOldX", "i", "mOldY", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCenterDiffX", BdhLogUtil.LogTag.Tag_Conn, "mCenterDiffY", "D", "mOldScale", "E", "mDeltaScale", "", "Z", "mWillBeImageInBoundsAfterTranslate", "cropImageView", "durationMs", "oldX", "oldY", "centerDiffX", "centerDiffY", "oldScale", "deltaScale", "willBeImageInBoundsAfterTranslate", "<init>", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView;JFFFFFFZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class WrapCropBoundsRunnable implements Runnable {

        /* renamed from: C, reason: from kotlin metadata */
        private final float mCenterDiffY;

        /* renamed from: D, reason: from kotlin metadata */
        private final float mOldScale;

        /* renamed from: E, reason: from kotlin metadata */
        private final float mDeltaScale;

        /* renamed from: F, reason: from kotlin metadata */
        private final boolean mWillBeImageInBoundsAfterTranslate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<WinkEditorCropTextureView> mCropImageView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long mDurationMs;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long mStartTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final float mOldX;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final float mOldY;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final float mCenterDiffX;

        public WrapCropBoundsRunnable(@NotNull WinkEditorCropTextureView cropImageView, long j3, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
            Intrinsics.checkNotNullParameter(cropImageView, "cropImageView");
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j3;
            this.mStartTime = System.currentTimeMillis();
            this.mOldX = f16;
            this.mOldY = f17;
            this.mCenterDiffX = f18;
            this.mCenterDiffY = f19;
            this.mOldScale = f26;
            this.mDeltaScale = f27;
            this.mWillBeImageInBoundsAfterTranslate = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            long coerceAtMost;
            WinkEditorCropTextureView winkEditorCropTextureView = this.mCropImageView.get();
            if (winkEditorCropTextureView == null) {
                return;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float f16 = (float) coerceAtMost;
            float b16 = com.tencent.mobileqq.wink.utils.g.b(f16, 0.0f, this.mCenterDiffX, (float) this.mDurationMs);
            float b17 = com.tencent.mobileqq.wink.utils.g.b(f16, 0.0f, this.mCenterDiffY, (float) this.mDurationMs);
            float a16 = com.tencent.mobileqq.wink.utils.g.a(f16, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (f16 < ((float) this.mDurationMs)) {
                winkEditorCropTextureView.s(b16 - (winkEditorCropTextureView.getMCurrentImageCenter()[0] - this.mOldX), b17 - (winkEditorCropTextureView.getMCurrentImageCenter()[1] - this.mOldY));
                if (!this.mWillBeImageInBoundsAfterTranslate) {
                    winkEditorCropTextureView.T(this.mOldScale + a16, winkEditorCropTextureView.getMCropRect().centerX(), winkEditorCropTextureView.getMCropRect().centerY());
                }
                if (!winkEditorCropTextureView.F()) {
                    winkEditorCropTextureView.post(this);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$ZoomImageToPosition;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView;", "d", "Ljava/lang/ref/WeakReference;", "mCropImageView", "", "e", "J", "mDurationMs", "f", "mStartTime", "", tl.h.F, UserInfo.SEX_FEMALE, "mOldScale", "i", "mDeltaScale", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mDestX", BdhLogUtil.LogTag.Tag_Conn, "mDestY", "cropImageView", "durationMs", "oldScale", "deltaScale", "destX", "destY", "<init>", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView;JFFFF)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private static final class ZoomImageToPosition implements Runnable {

        /* renamed from: C, reason: from kotlin metadata */
        private final float mDestY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<WinkEditorCropTextureView> mCropImageView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long mDurationMs;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long mStartTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final float mOldScale;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final float mDeltaScale;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final float mDestX;

        public ZoomImageToPosition(@NotNull WinkEditorCropTextureView cropImageView, long j3, float f16, float f17, float f18, float f19) {
            Intrinsics.checkNotNullParameter(cropImageView, "cropImageView");
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j3;
            this.mStartTime = System.currentTimeMillis();
            this.mOldScale = f16;
            this.mDeltaScale = f17;
            this.mDestX = f18;
            this.mDestY = f19;
        }

        @Override // java.lang.Runnable
        public void run() {
            long coerceAtMost;
            WinkEditorCropTextureView winkEditorCropTextureView = this.mCropImageView.get();
            if (winkEditorCropTextureView == null) {
                return;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float f16 = (float) coerceAtMost;
            float a16 = com.tencent.mobileqq.wink.utils.g.a(f16, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (f16 < ((float) this.mDurationMs)) {
                winkEditorCropTextureView.T(this.mOldScale + a16, this.mDestX, this.mDestY);
                winkEditorCropTextureView.post(this);
            } else {
                winkEditorCropTextureView.setImageToWrapCropBounds();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView$b;", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropTextureView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float A() {
        ArrayList arrayList;
        boolean z16;
        Float m910maxOrNull;
        boolean z17;
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < 8; i3++) {
            fArr[i3] = getMCurrentImageCorners()[i3];
        }
        u uVar = u.f326728a;
        float[] f16 = uVar.f(this.mCropRect);
        float[] e16 = uVar.e(this.mCropRect);
        float a16 = a();
        this.mTempMatrix.reset();
        this.mTempMatrix.postTranslate(-e16[0], -e16[1]);
        this.mTempMatrix.postRotate(-a16);
        this.mTempMatrix.mapPoints(f16);
        RectF p16 = uVar.p(f16);
        this.mTempMatrix.mapPoints(fArr);
        RectF p17 = uVar.p(fArr);
        float[] fArr2 = {p16.left / p17.left, p16.top / p17.top, p16.right / p17.right, p16.bottom / p17.bottom};
        if (p17.contains(p16)) {
            arrayList = new ArrayList();
            for (int i16 = 0; i16 < 4; i16++) {
                float f17 = fArr2[i16];
                if (f17 <= 1.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(Float.valueOf(f17));
                }
            }
        } else {
            arrayList = new ArrayList();
            for (int i17 = 0; i17 < 4; i17++) {
                float f18 = fArr2[i17];
                if (f18 >= 1.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(Float.valueOf(f18));
                }
            }
        }
        m910maxOrNull = CollectionsKt___CollectionsKt.m910maxOrNull((Iterable<Float>) arrayList);
        if (m910maxOrNull == null) {
            return 1.0f;
        }
        return m910maxOrNull.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F() {
        return G(getMCurrentImageCorners());
    }

    private final boolean G(float[] imageCorners) {
        if (this.mScaleMode == ScaleMode.LETTER_BOX) {
            return H(imageCorners);
        }
        return I(imageCorners);
    }

    private final boolean H(float[] imageCorners) {
        try {
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(-a());
            float[] copyOf = Arrays.copyOf(imageCorners, imageCorners.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            u uVar = u.f326728a;
            this.mTempMatrix.mapPoints(copyOf);
            RectF p16 = uVar.p(copyOf);
            float[] f16 = uVar.f(this.mCropRect);
            this.mTempMatrix.mapPoints(f16);
            RectF p17 = uVar.p(f16);
            if (p16.width() >= p17.width() && p16.height() >= p17.height()) {
                return p16.contains(p17);
            }
            float width = p16.width() / p16.height();
            if (width > p17.width() / p17.height()) {
                w53.b.a("WinkEditorCropTextureView", "isImageWrapCropBoundsLetterBoxMode cropRect: " + com.tencent.mobileqq.wink.editor.util.e.a(p17) + ", imageRect: " + com.tencent.mobileqq.wink.editor.util.e.a(p16));
                float max = Math.max(p17.width() / width, p16.height());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isImageWrapCropBoundsLetterBoxMode height: ");
                sb5.append(max);
                w53.b.a("WinkEditorCropTextureView", sb5.toString());
                float centerY = p17.centerY();
                float f17 = max / 2;
                p17.top = (centerY - f17) + 0.5f;
                p17.bottom = (centerY + f17) - 0.5f;
                w53.b.a("WinkEditorCropTextureView", "isImageWrapCropBoundsLetterBoxMode cropRect: " + com.tencent.mobileqq.wink.editor.util.e.a(p17));
                return p16.contains(p17);
            }
            float max2 = Math.max(p17.height() * width, p16.width());
            float centerX = p17.centerX();
            float f18 = max2 / 2;
            p17.left = (centerX - f18) + 0.5f;
            p17.right = (centerX + f18) - 0.5f;
            return p16.contains(p17);
        } catch (Exception e16) {
            w53.b.d("WinkEditorCropTextureView", "isImageWrapCropBoundsLetterBoxMode error ", e16);
            return true;
        }
    }

    private final boolean I(float[] imageCorners) {
        try {
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(-a());
            float[] copyOf = Arrays.copyOf(imageCorners, imageCorners.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.mTempMatrix.mapPoints(copyOf);
            u uVar = u.f326728a;
            float[] f16 = uVar.f(this.mCropRect);
            this.mTempMatrix.mapPoints(f16);
            return uVar.p(copyOf).contains(uVar.p(f16));
        } catch (Exception e16) {
            w53.b.d("WinkEditorCropTextureView", "isImageWrapCropBoundsZoomMode error ", e16);
            return false;
        }
    }

    private final void M(boolean animate) {
        if (this.mScaleMode == ScaleMode.LETTER_BOX) {
            N(animate);
        } else {
            O(animate);
        }
    }

    private final void N(boolean animate) {
        float coerceAtLeast;
        float f16;
        float f17;
        float f18;
        if (!F()) {
            float f19 = getMCurrentImageCenter()[0];
            float f26 = getMCurrentImageCenter()[1];
            float e16 = e();
            float centerX = this.mCropRect.centerX() - f19;
            float centerY = this.mCropRect.centerY() - f26;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(centerX, centerY);
            float[] copyOf = Arrays.copyOf(getMCurrentImageCorners(), getMCurrentImageCorners().length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.mTempMatrix.mapPoints(copyOf);
            boolean G = G(copyOf);
            if (G) {
                float[] x16 = x();
                float f27 = -(x16[0] + x16[2]);
                f18 = -(x16[1] + x16[3]);
                f16 = f27;
                f17 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(a());
                this.mTempMatrix.mapRect(rectF);
                float[] k3 = u.f326728a.k(getMCurrentImageCorners());
                float width = rectF.width();
                float height = rectF.height();
                if (k3[0] < rectF.width() || k3[1] < rectF.height()) {
                    float f28 = k3[0] / k3[1];
                    if (f28 > rectF.width() / rectF.height()) {
                        height = Math.max(rectF.width() / f28, k3[1]);
                    } else {
                        width = Math.max(rectF.height() * f28, k3[0]);
                    }
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(width / k3[0], height / k3[1]);
                f16 = centerX;
                f17 = (coerceAtLeast * e16) - e16;
                f18 = centerY;
            }
            if (animate) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f19, f26, f16, f18, e16, f17, G);
                this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
            } else {
                s(f16, f18);
                if (!G) {
                    T(e16 + f17, this.mCropRect.centerX(), this.mCropRect.centerY());
                }
            }
        }
    }

    private final void O(boolean animate) {
        float coerceAtLeast;
        float f16;
        float f17;
        float f18;
        if (!F()) {
            float f19 = getMCurrentImageCenter()[0];
            float f26 = getMCurrentImageCenter()[1];
            float e16 = e();
            float centerX = this.mCropRect.centerX() - f19;
            float centerY = this.mCropRect.centerY() - f26;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(centerX, centerY);
            float[] copyOf = Arrays.copyOf(getMCurrentImageCorners(), getMCurrentImageCorners().length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.mTempMatrix.mapPoints(copyOf);
            boolean G = G(copyOf);
            if (G) {
                float[] x16 = x();
                float f27 = -(x16[0] + x16[2]);
                f18 = -(x16[1] + x16[3]);
                f16 = f27;
                f17 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(a());
                this.mTempMatrix.mapRect(rectF);
                float[] k3 = u.f326728a.k(getMCurrentImageCorners());
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(rectF.width() / k3[0], rectF.height() / k3[1]);
                f16 = centerX;
                f17 = (coerceAtLeast * e16) - e16;
                f18 = centerY;
            }
            if (animate) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f19, f26, f16, f18, e16, f17, G);
                this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
            } else {
                s(f16, f18);
                if (!G) {
                    T(e16 + f17, this.mCropRect.centerX(), this.mCropRect.centerY());
                }
            }
        }
    }

    private final void P(float drawableWidth, float drawableHeight) {
        float coerceAtLeast;
        float width = this.mCropRect.width();
        float height = this.mCropRect.height();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mCropRect.width() / drawableWidth, this.mCropRect.height() / drawableHeight);
        RectF rectF = this.mCropRect;
        float f16 = ((width - (drawableWidth * coerceAtLeast)) / 2.0f) + rectF.left;
        float f17 = ((height - (drawableHeight * coerceAtLeast)) / 2.0f) + rectF.top;
        getMCurrentImageMatrix().reset();
        getMCurrentImageMatrix().postScale(coerceAtLeast, coerceAtLeast);
        getMCurrentImageMatrix().postTranslate(f16, f17);
        setTransform(getMCurrentImageMatrix());
    }

    private final void Q(float initScale) {
        float e16 = e();
        float A = A();
        if (initScale > 0.0f && A < 1.0f) {
            A = Math.max(initScale / e16, A);
        }
        if (Math.abs(A - 1.0f) > 1.0E-4f) {
            Matrix matrix = this.mTempMatrix;
            matrix.reset();
            r(A, this.mCropRect.centerX(), this.mCropRect.centerY());
            p(matrix);
        }
    }

    private final float[] x() {
        if (this.mScaleMode == ScaleMode.LETTER_BOX) {
            return y();
        }
        return z();
    }

    private final float[] y() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-a());
        float[] copyOf = Arrays.copyOf(getMCurrentImageCorners(), getMCurrentImageCorners().length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        u uVar = u.f326728a;
        float[] f16 = uVar.f(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        RectF p16 = uVar.p(copyOf);
        this.mTempMatrix.mapPoints(f16);
        RectF p17 = uVar.p(f16);
        if (p16.width() < p17.width() || p16.height() < p17.height()) {
            float width = p16.width() / p16.height();
            if (width > p17.width() / p17.height()) {
                float max = Math.max(p17.width() / width, p16.height());
                float centerY = p17.centerY();
                float f17 = max / 2;
                p17.top = centerY - f17;
                p17.bottom = centerY + f17;
            } else {
                float max2 = Math.max(p17.height() * width, p16.width());
                float centerX = p17.centerX();
                float f18 = max2 / 2;
                p17.left = centerX - f18;
                p17.right = centerX + f18;
            }
        }
        float f19 = p16.left - p17.left;
        float f26 = p16.top - p17.top;
        float f27 = p16.right - p17.right;
        float f28 = p16.bottom - p17.bottom;
        float[] fArr = new float[4];
        if (f19 <= 0.0f) {
            f19 = 0.0f;
        }
        fArr[0] = f19;
        if (f26 <= 0.0f) {
            f26 = 0.0f;
        }
        fArr[1] = f26;
        if (f27 >= 0.0f) {
            f27 = 0.0f;
        }
        fArr[2] = f27;
        if (f28 >= 0.0f) {
            f28 = 0.0f;
        }
        fArr[3] = f28;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(a());
        this.mTempMatrix.mapPoints(fArr);
        return fArr;
    }

    private final float[] z() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-a());
        float[] copyOf = Arrays.copyOf(getMCurrentImageCorners(), getMCurrentImageCorners().length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        u uVar = u.f326728a;
        float[] f16 = uVar.f(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(f16);
        RectF p16 = uVar.p(copyOf);
        RectF p17 = uVar.p(f16);
        float f17 = p16.left - p17.left;
        float f18 = p16.top - p17.top;
        float f19 = p16.right - p17.right;
        float f26 = p16.bottom - p17.bottom;
        float[] fArr = new float[4];
        if (f17 <= 0.0f) {
            f17 = 0.0f;
        }
        fArr[0] = f17;
        if (f18 <= 0.0f) {
            f18 = 0.0f;
        }
        fArr[1] = f18;
        if (f19 >= 0.0f) {
            f19 = 0.0f;
        }
        fArr[2] = f19;
        if (f26 >= 0.0f) {
            f26 = 0.0f;
        }
        fArr[3] = f26;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(a());
        this.mTempMatrix.mapPoints(fArr);
        return fArr;
    }

    public final void B() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final RectF getMCropRect() {
        return this.mCropRect;
    }

    /* renamed from: D, reason: from getter */
    public final float getMMaxScale() {
        return this.mMaxScale;
    }

    /* renamed from: E, reason: from getter */
    public final float getMMinScale() {
        return this.mMinScale;
    }

    @JvmOverloads
    public final void J(float deltaAngle, float withInitScale) {
        q(deltaAngle, this.mCropRect.centerX(), this.mCropRect.centerY());
        Q(withInitScale);
    }

    public final void K(float deltaAngle) {
        q(deltaAngle, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public final void L(float deltaScale) {
        r(deltaScale, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public final void R() {
        float A = A();
        if (Math.abs(A - 1.0f) > 1.0E-4f) {
            Matrix matrix = this.mTempMatrix;
            matrix.reset();
            r(A, this.mCropRect.centerX(), this.mCropRect.centerY());
            p(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(float scale, float centerX, float centerY, long durationMs) {
        float e16 = e();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, durationMs, e16, scale - e16, centerX, centerY);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public final void T(float scale, float centerX, float centerY) {
        w53.b.a("WinkEditorCropTextureView", "zoomInImage scale " + scale);
        if (scale <= getMMaxScale()) {
            r(scale / e(), centerX, centerY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorTransformTextureView
    public void o() {
        boolean z16;
        super.o();
        if (this.mTargetAspectRatio == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mTargetAspectRatio = getMThisWidth() / getMThisHeight();
        }
        int mThisWidth = (int) (getMThisWidth() / this.mTargetAspectRatio);
        if (mThisWidth > getMThisHeight()) {
            this.mCropRect.set((getMThisWidth() - ((int) (getMThisHeight() * this.mTargetAspectRatio))) / 2, 0.0f, r0 + r2, getMThisHeight());
        } else {
            this.mCropRect.set(0.0f, (getMThisHeight() - mThisWidth) / 2, getMThisWidth(), mThisWidth + r2);
        }
        P(getMThisWidth(), getMThisHeight());
    }

    @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorTransformTextureView
    public void r(float deltaScale, float px5, float py5) {
        float e16 = e() * deltaScale;
        w53.b.a("WinkEditorCropTextureView", "postScale  finalScale:" + e16 + ", deltaScale:" + deltaScale);
        if (e16 <= getMMaxScale() && e16 >= getMMinScale()) {
            super.r(deltaScale, px5, py5);
        }
    }

    public final void setCropRect(@NotNull RectF cropRect) {
        Intrinsics.checkNotNullParameter(cropRect, "cropRect");
        this.mTargetAspectRatio = cropRect.width() / cropRect.height();
        this.mCropRect.set(cropRect.left - getPaddingLeft(), cropRect.top - getPaddingTop(), cropRect.right - getPaddingRight(), cropRect.bottom - getPaddingBottom());
        M(false);
    }

    public final void setImageToWrapCropBounds() {
        M(true);
    }

    public final void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long imageToWrapCropBoundsAnimDuration) {
        if (imageToWrapCropBoundsAnimDuration > 0) {
            this.mImageToWrapCropBoundsAnimDuration = imageToWrapCropBoundsAnimDuration;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public final void setImageToWrapCropMinBounds(boolean animate) {
        L(this.mMinScale);
        M(animate);
    }

    public final void setMaxScaleMultiplier(float maxScaleMultiplier) {
        this.mMaxScaleMultiplier = maxScaleMultiplier;
    }

    public final void setScaleMode(@NotNull ScaleMode scaleMode) {
        Intrinsics.checkNotNullParameter(scaleMode, "scaleMode");
        this.mScaleMode = scaleMode;
    }

    public final void setTargetAspectRatio(float targetAspectRatio) {
        this.mTargetAspectRatio = targetAspectRatio;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.V = new LinkedHashMap();
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mMaxScale = 10.0f;
        this.mMinScale = 0.2f;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
        this.mScaleMode = ScaleMode.ZOOM;
    }

    public final void setCropBoundsChangeListener(@Nullable b cropBoundsChangeListener) {
    }
}
