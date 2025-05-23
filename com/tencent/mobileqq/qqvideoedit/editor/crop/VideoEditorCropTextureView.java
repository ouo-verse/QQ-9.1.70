package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000 S2\u00020\u0001:\u0004TUVWB\u0011\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u00a2\u0006\u0004\bK\u0010LB\u001b\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bK\u0010OB#\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\u0006\u0010Q\u001a\u00020P\u00a2\u0006\u0004\bK\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006J \u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'J\b\u0010)\u001a\u00020\u0004H\u0014J\b\u0010*\u001a\u00020'H\u0014J\u0010\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0002H\u0014J(\u0010.\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0015H\u0014J\u000e\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0006R\u0017\u00104\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001fR\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u001fR\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\u001fR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u001fR\u0016\u0010H\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u001d\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorTransformTextureView;", "", "v", "", "w", "", "drawableWidth", "drawableHeight", HippyTKDListViewAdapter.X, "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroid/graphics/RectF;", "cropRect", "setCropRect", "targetAspectRatio", "setTargetAspectRatio", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView$b;", "cropBoundsChangeListener", "setCropBoundsChangeListener", "", "imageToWrapCropBoundsAnimDuration", "setImageToWrapCropBoundsAnimDuration", "maxScaleMultiplier", "setMaxScaleMultiplier", "scale", "centerX", "centerY", "J", "deltaScale", UserInfo.SEX_FEMALE, "px", "py", "r", "deltaAngle", "E", "y", "setImageToWrapCropBounds", "", "animate", "o", BdhLogUtil.LogTag.Tag_Conn, "imageCorners", "D", "durationMs", "I", "initScale", "H", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/graphics/RectF;", "mCropRect", "Landroid/graphics/Matrix;", "K", "Landroid/graphics/Matrix;", "mTempMatrix", "L", "mTargetAspectRatio", "M", "mMaxScaleMultiplier", "Ljava/lang/Runnable;", "N", "Ljava/lang/Runnable;", "mWrapCropBoundsRunnable", "P", "mZoomImageToPositionRunnable", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mMaxScale", BdhLogUtil.LogTag.Tag_Req, "mMinScale", ExifInterface.LATITUDE_SOUTH, "mImageToWrapCropBoundsAnimDuration", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "T", "a", "b", "WrapCropBoundsRunnable", "ZoomImageToPosition", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class VideoEditorCropTextureView extends VideoEditorTransformTextureView {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final RectF mCropRect;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Matrix mTempMatrix;

    /* renamed from: L, reason: from kotlin metadata */
    private float mTargetAspectRatio;

    /* renamed from: M, reason: from kotlin metadata */
    private float mMaxScaleMultiplier;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Runnable mWrapCropBoundsRunnable;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Runnable mZoomImageToPositionRunnable;

    /* renamed from: Q, reason: from kotlin metadata */
    private float mMaxScale;

    /* renamed from: R, reason: from kotlin metadata */
    private float mMinScale;

    /* renamed from: S, reason: from kotlin metadata */
    private long mImageToWrapCropBoundsAnimDuration;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u000f\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u001d\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView$WrapCropBoundsRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView;", "d", "Ljava/lang/ref/WeakReference;", "mCropImageView", "", "e", "J", "mDurationMs", "f", "mStartTime", "", tl.h.F, UserInfo.SEX_FEMALE, "mOldX", "i", "mOldY", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCenterDiffX", BdhLogUtil.LogTag.Tag_Conn, "mCenterDiffY", "D", "mOldScale", "E", "mDeltaScale", "", "Z", "mWillBeImageInBoundsAfterTranslate", "cropImageView", "durationMs", "oldX", "oldY", "centerDiffX", "centerDiffY", "oldScale", "deltaScale", "willBeImageInBoundsAfterTranslate", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView;JFFFFFFZ)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
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
        private final WeakReference<VideoEditorCropTextureView> mCropImageView;

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

        public WrapCropBoundsRunnable(@NotNull VideoEditorCropTextureView cropImageView, long j3, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
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
            VideoEditorCropTextureView videoEditorCropTextureView = this.mCropImageView.get();
            if (videoEditorCropTextureView == null) {
                return;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float f16 = (float) coerceAtMost;
            float b16 = com.tencent.mobileqq.qqvideoedit.utils.d.b(f16, 0.0f, this.mCenterDiffX, (float) this.mDurationMs);
            float b17 = com.tencent.mobileqq.qqvideoedit.utils.d.b(f16, 0.0f, this.mCenterDiffY, (float) this.mDurationMs);
            float a16 = com.tencent.mobileqq.qqvideoedit.utils.d.a(f16, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (f16 < ((float) this.mDurationMs)) {
                videoEditorCropTextureView.s(b16 - (videoEditorCropTextureView.getMCurrentImageCenter()[0] - this.mOldX), b17 - (videoEditorCropTextureView.getMCurrentImageCenter()[1] - this.mOldY));
                if (!this.mWillBeImageInBoundsAfterTranslate) {
                    videoEditorCropTextureView.J(this.mOldScale + a16, videoEditorCropTextureView.getMCropRect().centerX(), videoEditorCropTextureView.getMCropRect().centerY());
                }
                if (!videoEditorCropTextureView.C()) {
                    videoEditorCropTextureView.post(this);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView$ZoomImageToPosition;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView;", "d", "Ljava/lang/ref/WeakReference;", "mCropImageView", "", "e", "J", "mDurationMs", "f", "mStartTime", "", tl.h.F, UserInfo.SEX_FEMALE, "mOldScale", "i", "mDeltaScale", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mDestX", BdhLogUtil.LogTag.Tag_Conn, "mDestY", "cropImageView", "durationMs", "oldScale", "deltaScale", "destX", "destY", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView;JFFFF)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class ZoomImageToPosition implements Runnable {

        /* renamed from: C, reason: from kotlin metadata */
        private final float mDestY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<VideoEditorCropTextureView> mCropImageView;

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

        public ZoomImageToPosition(@NotNull VideoEditorCropTextureView cropImageView, long j3, float f16, float f17, float f18, float f19) {
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
            VideoEditorCropTextureView videoEditorCropTextureView = this.mCropImageView.get();
            if (videoEditorCropTextureView == null) {
                return;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float f16 = (float) coerceAtMost;
            float a16 = com.tencent.mobileqq.qqvideoedit.utils.d.a(f16, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (f16 < ((float) this.mDurationMs)) {
                videoEditorCropTextureView.J(this.mOldScale + a16, this.mDestX, this.mDestY);
                videoEditorCropTextureView.post(this);
            } else {
                videoEditorCropTextureView.setImageToWrapCropBounds();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView$b;", "", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropTextureView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void G(float drawableWidth, float drawableHeight) {
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

    private final float[] v() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-b());
        float[] copyOf = Arrays.copyOf(getMCurrentImageCorners(), getMCurrentImageCorners().length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
        float[] f16 = iVar.f(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(f16);
        RectF n3 = iVar.n(copyOf);
        RectF n16 = iVar.n(f16);
        float f17 = n3.left - n16.left;
        float f18 = n3.top - n16.top;
        float f19 = n3.right - n16.right;
        float f26 = n3.bottom - n16.bottom;
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
        this.mTempMatrix.setRotate(b());
        this.mTempMatrix.mapPoints(fArr);
        return fArr;
    }

    private final void w() {
        x(getMThisWidth(), getMThisHeight());
    }

    private final void x(float drawableWidth, float drawableHeight) {
        float coerceAtMost;
        float coerceAtMost2;
        float coerceAtMost3;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mCropRect.width() / drawableWidth, this.mCropRect.width() / drawableHeight);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.mCropRect.height() / drawableHeight, this.mCropRect.height() / drawableWidth);
        coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(coerceAtMost, coerceAtMost2);
        this.mMinScale = coerceAtMost3;
        this.mMaxScale = coerceAtMost3 * this.mMaxScaleMultiplier;
    }

    /* renamed from: A, reason: from getter */
    public final float getMMaxScale() {
        return this.mMaxScale;
    }

    /* renamed from: B, reason: from getter */
    public final float getMMinScale() {
        return this.mMinScale;
    }

    protected boolean C() {
        return D(getMCurrentImageCorners());
    }

    protected boolean D(@NotNull float[] imageCorners) {
        Intrinsics.checkNotNullParameter(imageCorners, "imageCorners");
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-b());
        float[] copyOf = Arrays.copyOf(imageCorners, imageCorners.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.mTempMatrix.mapPoints(copyOf);
        com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
        float[] f16 = iVar.f(this.mCropRect);
        this.mTempMatrix.mapPoints(f16);
        return iVar.n(copyOf).contains(iVar.n(f16));
    }

    public final void E(float deltaAngle) {
        q(deltaAngle, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public final void F(float deltaScale) {
        r(deltaScale, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public final void H(float initScale) {
        ArrayList arrayList;
        boolean z16;
        Float m910maxOrNull;
        float f16;
        boolean z17;
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < 8; i3++) {
            fArr[i3] = getMCurrentImageCorners()[i3];
        }
        com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
        float[] f17 = iVar.f(this.mCropRect);
        float[] e16 = iVar.e(this.mCropRect);
        float e17 = e();
        float b16 = b();
        this.mTempMatrix.reset();
        this.mTempMatrix.postTranslate(-e16[0], -e16[1]);
        this.mTempMatrix.postRotate(-b16);
        this.mTempMatrix.mapPoints(f17);
        RectF n3 = iVar.n(f17);
        this.mTempMatrix.mapPoints(fArr);
        RectF n16 = iVar.n(fArr);
        float[] fArr2 = {n3.left / n16.left, n3.top / n16.top, n3.right / n16.right, n3.bottom / n16.bottom};
        if (n16.contains(n3)) {
            arrayList = new ArrayList();
            for (int i16 = 0; i16 < 4; i16++) {
                float f18 = fArr2[i16];
                if (f18 <= 1.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(Float.valueOf(f18));
                }
            }
        } else {
            arrayList = new ArrayList();
            for (int i17 = 0; i17 < 4; i17++) {
                float f19 = fArr2[i17];
                if (f19 >= 1.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(Float.valueOf(f19));
                }
            }
        }
        m910maxOrNull = CollectionsKt___CollectionsKt.m910maxOrNull((Iterable<Float>) arrayList);
        if (m910maxOrNull != null) {
            f16 = m910maxOrNull.floatValue();
        } else {
            f16 = 1.0f;
        }
        if (initScale > 0.0f && f16 < 1.0f) {
            f16 = Math.max(initScale / e17, f16);
        }
        if (Math.abs(f16 - 1.0f) > 1.0E-4f) {
            Matrix matrix = this.mTempMatrix;
            matrix.reset();
            r(f16, this.mCropRect.centerX(), this.mCropRect.centerY());
            p(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(float scale, float centerX, float centerY, long durationMs) {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(scale, getMMaxScale());
        float e16 = e();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, durationMs, e16, coerceAtMost - e16, centerX, centerY);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public final void J(float scale, float centerX, float centerY) {
        if (scale <= getMMaxScale()) {
            r(scale / e(), centerX, centerY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorTransformTextureView
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
        x(getMThisWidth(), getMThisHeight());
        G(getMThisWidth(), getMThisHeight());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorTransformTextureView
    public void r(float deltaScale, float px5, float py5) {
        if (deltaScale > 1.0f && e() * deltaScale <= getMMaxScale()) {
            super.r(deltaScale, px5, py5);
        } else if (deltaScale < 1.0f && e() * deltaScale >= getMMinScale()) {
            super.r(deltaScale, px5, py5);
        }
    }

    public final void setCropRect(@NotNull RectF cropRect) {
        Intrinsics.checkNotNullParameter(cropRect, "cropRect");
        this.mTargetAspectRatio = cropRect.width() / cropRect.height();
        this.mCropRect.set(cropRect.left - getPaddingLeft(), cropRect.top - getPaddingTop(), cropRect.right - getPaddingRight(), cropRect.bottom - getPaddingBottom());
        w();
        setImageToWrapCropBounds(false);
    }

    public final void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public final void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long imageToWrapCropBoundsAnimDuration) {
        if (imageToWrapCropBoundsAnimDuration > 0) {
            this.mImageToWrapCropBoundsAnimDuration = imageToWrapCropBoundsAnimDuration;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public final void setMaxScaleMultiplier(float maxScaleMultiplier) {
        this.mMaxScaleMultiplier = maxScaleMultiplier;
    }

    public final void setTargetAspectRatio(float targetAspectRatio) {
        this.mTargetAspectRatio = targetAspectRatio;
    }

    public final void y() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final RectF getMCropRect() {
        return this.mCropRect;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setImageToWrapCropBounds(boolean animate) {
        float coerceAtLeast;
        float f16;
        float f17;
        float f18;
        if (C()) {
            return;
        }
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
        boolean D = D(copyOf);
        if (D) {
            float[] v3 = v();
            float f27 = -(v3[0] + v3[2]);
            f18 = -(v3[1] + v3[3]);
            f16 = f27;
            f17 = 0.0f;
        } else {
            RectF rectF = new RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(b());
            this.mTempMatrix.mapRect(rectF);
            float[] i3 = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a.i(getMCurrentImageCorners());
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(rectF.width() / i3[0], rectF.height() / i3[1]);
            f16 = centerX;
            f17 = (coerceAtLeast * e16) - e16;
            f18 = centerY;
        }
        if (animate) {
            WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f19, f26, f16, f18, e16, f17, D);
            this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
            post(wrapCropBoundsRunnable);
        } else {
            s(f16, f18);
            if (D) {
                return;
            }
            J(e16 + f17, this.mCropRect.centerX(), this.mCropRect.centerY());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorCropTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
    }

    public final void setCropBoundsChangeListener(@Nullable b cropBoundsChangeListener) {
    }
}
