package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 Y2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0007J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H\u0016R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010*R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00101R\u001c\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00105R\u0014\u00107\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00101R\u0014\u00108\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u00109\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00101R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010>R\u0016\u0010@\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010;R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010BR\u0016\u0010E\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0016\u0010G\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010I\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0016\u0010K\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010BR\u0016\u0010M\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010BR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010\"R\u0016\u0010T\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010\"R\u0016\u0010V\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010(\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/ae;", "", "", "k", "", "p", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "c", "", "text", "d", "b", "", Element.ELEMENT_NAME_MIN, "max", "current", "g", "Landroid/content/res/Resources;", tl.h.F, "", "i", "f", "o", "containerWidth", "containerHeight", "j", "e", "percent", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "compressing", DomainData.DOMAIN_NAME, "I", "mUploadProgress", "mVideoCompressProgress", "Ljava/lang/String;", "mProgressTips", "", "J", "mOffsetTime", UserInfo.SEX_FEMALE, "mCenterX", "mCenterY", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "accelerateDecelerateInterpolator", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "mImageRect", "Ljava/lang/ref/WeakReference;", "Landroid/widget/EditText;", "Ljava/lang/ref/WeakReference;", "mEditTextViewRef", "mDeleteClickRect", "mReloadClickRect", "mVideoClickRect", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "mBackgroudPath", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mBackgroudRect", "mDisappearPath", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mBreathPaint", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mBreathRectF", "r", "mTextPaint", ReportConstant.COSTREPORT_PREFIX, "mArcPaint", "t", "mTrianglePaint", "u", "mBackgroundPaint", "v", "Z", "mIsVideoCompressing", "w", "mContainerWidth", HippyTKDListViewAdapter.X, "mContainerHeight", "y", "mBreadthBeginTime", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class ae {
    private static int A;
    private static RectF B;
    private static float C;
    private static float E;
    private static float F;
    private static float G;
    private static float H;
    private static float I;
    private static float J;
    private static float K;
    private static float L;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile int mUploadProgress;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile int mVideoCompressProgress;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mProgressTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mOffsetTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mCenterX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mCenterY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AccelerateDecelerateInterpolator accelerateDecelerateInterpolator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect mImageRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<EditText> mEditTextViewRef = new WeakReference<>(null);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mDeleteClickRect = new Rect();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mReloadClickRect = new Rect();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mVideoClickRect = new Rect();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Path mBackgroudPath;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private RectF mBackgroudRect;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Path mDisappearPath;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Paint mBreathPaint;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private RectF mBreathRectF;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Paint mTextPaint;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Paint mArcPaint;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Paint mTrianglePaint;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private Paint mBackgroundPaint;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean mIsVideoCompressing;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int mContainerWidth;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int mContainerHeight;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private volatile long mBreadthBeginTime;
    private static long D = 667;

    private final void a(Canvas canvas) {
        BlurMaskFilter blurMaskFilter;
        if (this.mUploadProgress >= 0 && this.mUploadProgress < 10000.0f) {
            long j3 = this.mOffsetTime;
            long j16 = D;
            float f16 = H;
            float f17 = I;
            float f18 = ((((float) j3) / ((float) j16)) * (f16 - f17)) + f17;
            L = f18;
            float f19 = ((float) j3) / ((float) j16);
            float f26 = F;
            float f27 = G;
            K = (f19 * (f26 - f27)) + f27;
            float g16 = g(f17, f16, f18);
            J = E + (g(G, F, K) / 2);
            Paint paint = this.mBreathPaint;
            Paint paint2 = null;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
                paint = null;
            }
            paint.setStrokeWidth(g16);
            try {
                blurMaskFilter = new BlurMaskFilter(g16, BlurMaskFilter.Blur.SOLID);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ProgressDrawHandler", 2, "create BlurMaskFilter exp:" + e16.getMessage());
                }
                blurMaskFilter = null;
            }
            if (blurMaskFilter != null) {
                Paint paint3 = this.mBreathPaint;
                if (paint3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
                    paint3 = null;
                }
                paint3.setMaskFilter(blurMaskFilter);
            }
            float f28 = this.mCenterX;
            float f29 = this.mCenterY;
            float f36 = J;
            Paint paint4 = this.mBreathPaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
            } else {
                paint2 = paint4;
            }
            canvas.drawCircle(f28, f29, f36, paint2);
        }
    }

    private final void b(Canvas canvas) {
        Paint paint;
        synchronized (this) {
            if (this.mVideoCompressProgress >= 0 && this.mVideoCompressProgress < 10000.0f) {
                float f16 = (G + F) / 2;
                float f17 = E + f16;
                Paint paint2 = this.mBreathPaint;
                if (paint2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
                    paint2 = null;
                }
                paint2.setStrokeWidth(f16);
                Paint paint3 = this.mBreathPaint;
                if (paint3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
                    paint3 = null;
                }
                paint3.setMaskFilter(new BlurMaskFilter(f16, BlurMaskFilter.Blur.SOLID));
                RectF rectF = this.mBreathRectF;
                if (rectF == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBreathRectF");
                    rectF = null;
                }
                float f18 = this.mCenterX;
                float f19 = this.mCenterY;
                rectF.set(f18 - f17, f19 - f17, f18 + f17, f19 + f17);
                float f26 = (this.mVideoCompressProgress * 1.0f) / 10000.0f;
                RectF rectF2 = this.mBreathRectF;
                if (rectF2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBreathRectF");
                    rectF2 = null;
                }
                float f27 = 360.0f * f26;
                Paint paint4 = this.mBreathPaint;
                if (paint4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
                    paint = null;
                } else {
                    paint = paint4;
                }
                canvas.drawArc(rectF2, -90.0f, f27, false, paint);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void c(Canvas canvas) {
        if (this.mUploadProgress >= 0 && this.mUploadProgress < 10000.0f) {
            RectF rectF = B;
            Paint paint = null;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("TEXT_RECT");
                rectF = null;
            }
            float f16 = this.mCenterX;
            float f17 = E;
            float f18 = this.mCenterY;
            rectF.set(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
            Paint paint2 = this.mTextPaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
                paint2 = null;
            }
            paint2.setTextSize(A);
            Paint paint3 = this.mTextPaint;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
                paint3 = null;
            }
            Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
            Intrinsics.checkNotNullExpressionValue(fontMetrics, "mTextPaint.getFontMetrics()");
            float f19 = fontMetrics.top;
            float f26 = fontMetrics.bottom;
            RectF rectF2 = B;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("TEXT_RECT");
                rectF2 = null;
            }
            float f27 = 2;
            int centerY = (int) ((rectF2.centerY() - (f19 / f27)) - (f26 / f27));
            String str = ((int) ((this.mUploadProgress / 10000.0f) * 100)) + "%";
            RectF rectF3 = B;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("TEXT_RECT");
                rectF3 = null;
            }
            float centerX = rectF3.centerX();
            float f28 = centerY;
            Paint paint4 = this.mTextPaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
            } else {
                paint = paint4;
            }
            canvas.drawText(str, centerX, f28, paint);
        }
    }

    private final void d(Canvas canvas, String text) {
        RectF rectF = B;
        Paint paint = null;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("TEXT_RECT");
            rectF = null;
        }
        float f16 = this.mCenterX;
        float f17 = E;
        float f18 = this.mCenterY;
        rectF.set(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
        Paint paint2 = this.mTextPaint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
            paint2 = null;
        }
        paint2.setTextSize(h().getDimension(R.dimen.cb6));
        Paint paint3 = this.mTextPaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
            paint3 = null;
        }
        Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
        Intrinsics.checkNotNullExpressionValue(fontMetrics, "mTextPaint.fontMetrics");
        float f19 = fontMetrics.top;
        float f26 = fontMetrics.bottom;
        RectF rectF2 = B;
        if (rectF2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("TEXT_RECT");
            rectF2 = null;
        }
        float f27 = 2;
        int centerY = (int) ((rectF2.centerY() - (f19 / f27)) - (f26 / f27));
        Intrinsics.checkNotNull(text);
        RectF rectF3 = B;
        if (rectF3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("TEXT_RECT");
            rectF3 = null;
        }
        float centerX = rectF3.centerX();
        float f28 = centerY;
        Paint paint4 = this.mTextPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
        } else {
            paint = paint4;
        }
        canvas.drawText(text, centerX, f28, paint);
    }

    /* renamed from: f, reason: from getter */
    private final int getMContainerHeight() {
        return this.mContainerHeight;
    }

    private final float g(float min, float max, float current) {
        if (current >= min && current <= max) {
            float f16 = max - min;
            try {
                float floatValue = new BigDecimal((current - min) / f16).setScale(3, 4).floatValue();
                AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = this.accelerateDecelerateInterpolator;
                if (accelerateDecelerateInterpolator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accelerateDecelerateInterpolator");
                    accelerateDecelerateInterpolator = null;
                }
                float interpolation = accelerateDecelerateInterpolator.getInterpolation(floatValue);
                if (interpolation >= 0.0f && interpolation <= 1.0f) {
                    return (interpolation * f16) + min;
                }
                return current;
            } catch (Exception unused) {
                return current;
            }
        }
        return current;
    }

    private final Resources h() {
        Resources resources = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getContext().resources");
        return resources;
    }

    /* renamed from: i, reason: from getter */
    private final int getMContainerWidth() {
        return this.mContainerWidth;
    }

    /* renamed from: k, reason: from getter */
    private final boolean getMIsVideoCompressing() {
        return this.mIsVideoCompressing;
    }

    private final void o() {
        long j3;
        if (this.mBreadthBeginTime == 0) {
            this.mBreadthBeginTime = SystemClock.uptimeMillis();
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.mBreadthBeginTime;
        if (uptimeMillis >= 0) {
            if (this.mUploadProgress < 10000.0f) {
                long j16 = D;
                if ((uptimeMillis / j16) % 2 == 0) {
                    j3 = uptimeMillis % j16;
                } else {
                    j3 = j16 - (uptimeMillis % j16);
                }
                this.mOffsetTime = j3;
                return;
            }
            return;
        }
        this.mBreadthBeginTime = SystemClock.uptimeMillis();
    }

    private final void p() {
        float f16 = 2;
        this.mCenterX = (getMContainerWidth() * 1.0f) / f16;
        this.mCenterY = (getMContainerHeight() * 1.0f) / f16;
        if (Math.min(getMContainerWidth(), getMContainerHeight()) < C) {
            E = h().getDimension(R.dimen.cb6);
            G = h().getDimension(R.dimen.cb8);
            F = h().getDimension(R.dimen.cba);
            H = h().getDimension(R.dimen.cbb);
            I = h().getDimension(R.dimen.cb9);
            A = (int) h().getDimension(R.dimen.cbe);
        }
    }

    public final void e(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        p();
        if (getMIsVideoCompressing()) {
            b(canvas);
        } else {
            a(canvas);
            o();
        }
        String str = this.mProgressTips;
        if (str != null) {
            d(canvas, str);
        } else {
            c(canvas);
        }
    }

    @TargetApi(11)
    public final void j(int containerWidth, int containerHeight) {
        this.accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        E = h().getDimension(R.dimen.cb_);
        G = h().getDimension(R.dimen.cba);
        F = h().getDimension(R.dimen.cbc);
        H = h().getDimension(R.dimen.cbc);
        I = h().getDimension(R.dimen.cba);
        A = (int) h().getDimension(R.dimen.cb7);
        Paint paint = new Paint();
        this.mBreathPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.mBreathPaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
            paint2 = null;
        }
        paint2.setColor(-1);
        Paint paint4 = this.mBreathPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBreathPaint");
            paint4 = null;
        }
        paint4.setAntiAlias(true);
        this.mBreathRectF = new RectF();
        Paint paint5 = new Paint();
        this.mTextPaint = paint5;
        paint5.setAntiAlias(true);
        Paint paint6 = this.mTextPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
            paint6 = null;
        }
        paint6.setTextSize(A);
        Paint paint7 = this.mTextPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
            paint7 = null;
        }
        paint7.setColor(-1);
        Paint paint8 = this.mTextPaint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPaint");
            paint8 = null;
        }
        paint8.setTextAlign(Paint.Align.CENTER);
        Paint paint9 = new Paint();
        this.mArcPaint = paint9;
        paint9.setStyle(Paint.Style.STROKE);
        Paint paint10 = this.mArcPaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mArcPaint");
            paint10 = null;
        }
        paint10.setColor(-1);
        Paint paint11 = this.mArcPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mArcPaint");
            paint11 = null;
        }
        paint11.setAntiAlias(true);
        Paint paint12 = new Paint();
        this.mTrianglePaint = paint12;
        paint12.setStyle(Paint.Style.FILL);
        Paint paint13 = this.mTrianglePaint;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrianglePaint");
            paint13 = null;
        }
        paint13.setColor(-1);
        Paint paint14 = this.mTrianglePaint;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrianglePaint");
            paint14 = null;
        }
        paint14.setAntiAlias(true);
        Paint paint15 = new Paint();
        this.mBackgroundPaint = paint15;
        paint15.setAntiAlias(true);
        Paint paint16 = this.mBackgroundPaint;
        if (paint16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundPaint");
            paint16 = null;
        }
        paint16.setFilterBitmap(true);
        Paint paint17 = this.mBackgroundPaint;
        if (paint17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundPaint");
        } else {
            paint3 = paint17;
        }
        paint3.setStyle(Paint.Style.FILL);
        this.mBackgroudPath = new Path();
        this.mBackgroudRect = new RectF();
        this.mDisappearPath = new Path();
        this.mImageRect = new Rect();
        B = new RectF();
        C = h().getDimension(R.dimen.cbd);
        this.mContainerWidth = containerWidth;
        this.mContainerHeight = containerHeight;
    }

    public final void l(float percent, @Nullable String text) {
        this.mUploadProgress = (int) (10000.0f * percent);
        this.mProgressTips = text;
        if (QLog.isColorLevel()) {
            QLog.i("ProgressDrawHandler", 2, "[onUploadProgress] percent:" + percent + ",text:" + text);
        }
    }

    public final void m(float percent, @Nullable String text) {
        int coerceAtLeast;
        synchronized (this) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (10000.0f * percent), this.mVideoCompressProgress);
            this.mVideoCompressProgress = coerceAtLeast;
            this.mProgressTips = text;
            if (QLog.isColorLevel()) {
                QLog.i("ProgressDrawHandler", 2, "[onVideoCompressProgress] percent:" + percent + ",text:" + text);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void n(boolean compressing) {
        this.mIsVideoCompressing = compressing;
    }
}
