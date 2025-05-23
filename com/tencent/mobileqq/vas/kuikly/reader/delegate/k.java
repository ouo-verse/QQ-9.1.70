package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.kuikly.reader.VasBookTransitionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010u\u001a\u00020t\u00a2\u0006\u0004\bv\u0010wJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001aR\u0016\u0010,\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001aR\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00104\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00103R\u0014\u00105\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00103R\u0014\u00107\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00103R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00103R\u0014\u00109\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00103R\u0014\u0010;\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00103R\u0014\u0010<\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00103R\u0016\u0010>\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010@\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010%R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010%R\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010%R\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010%R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010%R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u0016\u0010c\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010^R\u0016\u0010e\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010^R\u0016\u0010f\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010^R\u0016\u0010g\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010^R\u0016\u0010h\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010^R\u0016\u0010i\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010^R\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010mR\u0018\u0010o\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010mR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010qR\u0016\u0010s\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010\u001a\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/k;", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/j;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "U", "W", "X", "V", "", HippyTKDListViewAdapter.X, "y", ExifInterface.LATITUDE_SOUTH, "T", "Landroid/graphics/PointF;", "P1", "P2", "P3", "P4", "Y", BdhLogUtil.LogTag.Tag_Req, "", "width", "height", "I", "Landroid/view/MotionEvent;", "event", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;", "direction", "D", "animationSpeed", "u", "v", "o", UserInfo.SEX_FEMALE, "mTouchX", "p", "mTouchY", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mCornerX", "r", "mCornerY", "Landroid/graphics/Path;", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/Path;", "mPath0", "t", "mPath1", "Landroid/graphics/PointF;", "mBezierStart1", "mBezierControl1", "w", "mBezierVertex1", "mBezierEnd1", "mBezierStart2", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mBezierControl2", "mBezierVertex2", "B", "mBezierEnd2", BdhLogUtil.LogTag.Tag_Conn, "mMiddleX", "mMiddleY", "E", "mDegrees", "mTouchToCornerDis", "Landroid/graphics/ColorMatrixColorFilter;", "G", "Landroid/graphics/ColorMatrixColorFilter;", "mColorMatrixFilter", "Landroid/graphics/Matrix;", "H", "Landroid/graphics/Matrix;", "mMatrix", "", "[F", "mMatrixArray", "", "J", "Z", "mIsRtOrLb", "K", "mMaxLength", "", "L", "[I", "mBackShadowColors", "M", "mFrontShadowColors", "Landroid/graphics/drawable/GradientDrawable;", "N", "Landroid/graphics/drawable/GradientDrawable;", "mBackShadowDrawableLR", "O", "mBackShadowDrawableRL", "P", "mFolderShadowDrawableLR", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mFolderShadowDrawableRL", "mFrontShadowDrawableHBT", "mFrontShadowDrawableHTB", "mFrontShadowDrawableVLR", "mFrontShadowDrawableVRL", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Bitmap;", "curBitmap", "prevBitmap", "nextBitmap", "Landroid/graphics/Canvas;", "a0", "shadowWidth", "Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "readView", "<init>", "(Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class k extends j {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private final PointF mBezierVertex2;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private PointF mBezierEnd2;

    /* renamed from: C, reason: from kotlin metadata */
    private float mMiddleX;

    /* renamed from: D, reason: from kotlin metadata */
    private float mMiddleY;

    /* renamed from: E, reason: from kotlin metadata */
    private float mDegrees;

    /* renamed from: F, reason: from kotlin metadata */
    private float mTouchToCornerDis;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ColorMatrixColorFilter mColorMatrixFilter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Matrix mMatrix;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final float[] mMatrixArray;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsRtOrLb;

    /* renamed from: K, reason: from kotlin metadata */
    private float mMaxLength;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private int[] mBackShadowColors;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private int[] mFrontShadowColors;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mBackShadowDrawableLR;

    /* renamed from: O, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mBackShadowDrawableRL;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mFolderShadowDrawableLR;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mFolderShadowDrawableRL;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mFrontShadowDrawableHBT;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mFrontShadowDrawableHTB;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mFrontShadowDrawableVLR;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private GradientDrawable mFrontShadowDrawableVRL;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Bitmap curBitmap;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Bitmap prevBitmap;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private Bitmap nextBitmap;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private Canvas canvas;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int shadowWidth;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float mTouchX;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float mTouchY;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int mCornerX;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int mCornerY;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath0;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath1;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mBezierStart1;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mBezierControl1;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mBezierVertex1;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF mBezierEnd1;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mBezierStart2;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mBezierControl2;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309945a;

        static {
            int[] iArr = new int[PageDirection.values().length];
            try {
                iArr[PageDirection.PREV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageDirection.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f309945a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull VasBookTransitionView readView) {
        super(readView);
        Intrinsics.checkNotNullParameter(readView, "readView");
        this.mTouchX = 0.1f;
        this.mTouchY = 0.1f;
        this.mCornerX = 1;
        this.mCornerY = 1;
        this.mPath0 = new Path();
        this.mPath1 = new Path();
        this.mBezierStart1 = new PointF();
        this.mBezierControl1 = new PointF();
        this.mBezierVertex1 = new PointF();
        this.mBezierEnd1 = new PointF();
        this.mBezierStart2 = new PointF();
        this.mBezierControl2 = new PointF();
        this.mBezierVertex2 = new PointF();
        this.mBezierEnd2 = new PointF();
        this.mColorMatrixFilter = new ColorMatrixColorFilter(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        this.mMatrix = new Matrix();
        this.mMatrixArray = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.mMaxLength = (float) Math.hypot(getViewWidth(), getViewHeight());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.mPaint = paint;
        this.canvas = new Canvas();
        this.shadowWidth = 5;
        int[] iArr = {16250871, 1326715924};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr);
        this.mFolderShadowDrawableRL = gradientDrawable;
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        this.mFolderShadowDrawableLR = gradientDrawable2;
        gradientDrawable2.setGradientType(0);
        this.mBackShadowColors = new int[]{DownloadCardView.COLOR_APP_NAME, 15066597};
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, this.mBackShadowColors);
        this.mBackShadowDrawableRL = gradientDrawable3;
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.mBackShadowColors);
        this.mBackShadowDrawableLR = gradientDrawable4;
        gradientDrawable4.setGradientType(0);
        this.mFrontShadowColors = new int[]{-2146365167, 1118481};
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.mFrontShadowColors);
        this.mFrontShadowDrawableVLR = gradientDrawable5;
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, this.mFrontShadowColors);
        this.mFrontShadowDrawableVRL = gradientDrawable6;
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.mFrontShadowColors);
        this.mFrontShadowDrawableHTB = gradientDrawable7;
        gradientDrawable7.setGradientType(0);
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.mFrontShadowColors);
        this.mFrontShadowDrawableHBT = gradientDrawable8;
        gradientDrawable8.setGradientType(0);
    }

    private final void S(float x16, float y16) {
        int viewWidth;
        int viewHeight;
        boolean z16 = false;
        if (x16 <= getViewWidth() / 2) {
            viewWidth = 0;
        } else {
            viewWidth = getViewWidth();
        }
        this.mCornerX = viewWidth;
        if (y16 <= getViewHeight() / 2) {
            viewHeight = 0;
        } else {
            viewHeight = getViewHeight();
        }
        this.mCornerY = viewHeight;
        if ((this.mCornerX == 0 && viewHeight == getViewHeight()) || (this.mCornerY == 0 && this.mCornerX == getViewWidth())) {
            z16 = true;
        }
        this.mIsRtOrLb = z16;
    }

    private final void T() {
        boolean z16;
        this.mTouchX = k();
        float l3 = l();
        this.mTouchY = l3;
        float f16 = this.mTouchX;
        int i3 = this.mCornerX;
        float f17 = 2;
        float f18 = (i3 + f16) / f17;
        this.mMiddleX = f18;
        int i16 = this.mCornerY;
        float f19 = (l3 + i16) / f17;
        this.mMiddleY = f19;
        PointF pointF = this.mBezierControl1;
        pointF.x = f18 - (((i16 - f19) * (i16 - f19)) / (i3 - f18));
        pointF.y = i16;
        PointF pointF2 = this.mBezierControl2;
        pointF2.x = i3;
        boolean z17 = true;
        if (i16 - f19 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            pointF2.y = f19 - (((i3 - f18) * (i3 - f18)) / 0.1f);
        } else {
            pointF2.y = f19 - (((i3 - f18) * (i3 - f18)) / (i16 - f19));
        }
        PointF pointF3 = this.mBezierStart1;
        float f26 = pointF.x;
        pointF3.x = f26 - ((i3 - f26) / f17);
        pointF3.y = i16;
        if (f16 > 0.0f && f16 < getViewWidth()) {
            float f27 = this.mBezierStart1.x;
            if (f27 < 0.0f || f27 > getViewWidth()) {
                PointF pointF4 = this.mBezierStart1;
                if (pointF4.x < 0.0f) {
                    pointF4.x = getViewWidth() - this.mBezierStart1.x;
                }
                float abs = Math.abs(this.mCornerX - this.mTouchX);
                float abs2 = Math.abs(this.mCornerX - ((getViewWidth() * abs) / this.mBezierStart1.x));
                this.mTouchX = abs2;
                float abs3 = Math.abs(this.mCornerY - ((Math.abs(this.mCornerX - abs2) * Math.abs(this.mCornerY - this.mTouchY)) / abs));
                this.mTouchY = abs3;
                float f28 = this.mTouchX;
                int i17 = this.mCornerX;
                float f29 = (f28 + i17) / f17;
                this.mMiddleX = f29;
                int i18 = this.mCornerY;
                float f36 = (abs3 + i18) / f17;
                this.mMiddleY = f36;
                PointF pointF5 = this.mBezierControl1;
                pointF5.x = f29 - (((i18 - f36) * (i18 - f36)) / (i17 - f29));
                pointF5.y = i18;
                PointF pointF6 = this.mBezierControl2;
                pointF6.x = i17;
                if (i18 - f36 != 0.0f) {
                    z17 = false;
                }
                if (z17) {
                    pointF6.y = f36 - (((i17 - f29) * (i17 - f29)) / 0.1f);
                } else {
                    pointF6.y = f36 - (((i17 - f29) * (i17 - f29)) / (i18 - f36));
                }
                PointF pointF7 = this.mBezierStart1;
                float f37 = pointF5.x;
                pointF7.x = f37 - ((i17 - f37) / f17);
            }
        }
        PointF pointF8 = this.mBezierStart2;
        pointF8.x = this.mCornerX;
        float f38 = this.mBezierControl2.y;
        pointF8.y = f38 - ((this.mCornerY - f38) / f17);
        this.mTouchToCornerDis = (float) Math.hypot(this.mTouchX - r1, this.mTouchY - r3);
        this.mBezierEnd1 = Y(new PointF(this.mTouchX, this.mTouchY), this.mBezierControl1, this.mBezierStart1, this.mBezierStart2);
        PointF Y = Y(new PointF(this.mTouchX, this.mTouchY), this.mBezierControl2, this.mBezierStart1, this.mBezierStart2);
        this.mBezierEnd2 = Y;
        PointF pointF9 = this.mBezierVertex1;
        PointF pointF10 = this.mBezierStart1;
        float f39 = pointF10.x;
        PointF pointF11 = this.mBezierControl1;
        float f46 = f39 + (pointF11.x * f17);
        PointF pointF12 = this.mBezierEnd1;
        float f47 = 4;
        pointF9.x = (f46 + pointF12.x) / f47;
        pointF9.y = (((pointF11.y * f17) + pointF10.y) + pointF12.y) / f47;
        PointF pointF13 = this.mBezierVertex2;
        PointF pointF14 = this.mBezierStart2;
        float f48 = pointF14.x;
        PointF pointF15 = this.mBezierControl2;
        pointF13.x = ((f48 + (pointF15.x * f17)) + Y.x) / f47;
        pointF13.y = (((f17 * pointF15.y) + pointF14.y) + Y.y) / f47;
    }

    private final void U(Canvas canvas, Bitmap bitmap) {
        int i3;
        int i16;
        GradientDrawable gradientDrawable;
        if (bitmap == null) {
            return;
        }
        float f16 = this.mBezierStart1.x;
        float f17 = 2;
        float abs = Math.abs(((int) ((f16 + r1) / f17)) - this.mBezierControl1.x);
        float f18 = this.mBezierStart2.y;
        float min = Math.min(abs, Math.abs(((int) ((f18 + r3) / f17)) - this.mBezierControl2.y));
        this.mPath1.reset();
        Path path = this.mPath1;
        PointF pointF = this.mBezierVertex2;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.mPath1;
        PointF pointF2 = this.mBezierVertex1;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.mPath1;
        PointF pointF3 = this.mBezierEnd1;
        path3.lineTo(pointF3.x, pointF3.y);
        this.mPath1.lineTo(this.mTouchX, this.mTouchY);
        Path path4 = this.mPath1;
        PointF pointF4 = this.mBezierEnd2;
        path4.lineTo(pointF4.x, pointF4.y);
        this.mPath1.close();
        if (this.mIsRtOrLb) {
            float f19 = this.mBezierStart1.x;
            float f26 = 1;
            i3 = (int) (f19 - f26);
            i16 = (int) (f19 + min + f26);
            gradientDrawable = this.mFolderShadowDrawableLR;
        } else {
            float f27 = this.mBezierStart1.x;
            float f28 = 1;
            i3 = (int) ((f27 - min) - f28);
            i16 = (int) (f27 + f28);
            gradientDrawable = this.mFolderShadowDrawableRL;
        }
        canvas.save();
        canvas.clipPath(this.mPath0);
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.mPath1);
        } else {
            canvas.clipPath(this.mPath1, Region.Op.INTERSECT);
        }
        this.mPaint.setColorFilter(this.mColorMatrixFilter);
        float hypot = (float) Math.hypot(this.mCornerX - this.mBezierControl1.x, this.mBezierControl2.y - this.mCornerY);
        float f29 = (this.mCornerX - this.mBezierControl1.x) / hypot;
        float f36 = (this.mBezierControl2.y - this.mCornerY) / hypot;
        float[] fArr = this.mMatrixArray;
        float f37 = 1;
        fArr[0] = f37 - ((f17 * f36) * f36);
        float f38 = f17 * f29;
        float f39 = f36 * f38;
        fArr[1] = f39;
        fArr[3] = f39;
        fArr[4] = f37 - (f38 * f29);
        this.mMatrix.reset();
        this.mMatrix.setValues(this.mMatrixArray);
        Matrix matrix = this.mMatrix;
        PointF pointF5 = this.mBezierControl1;
        matrix.preTranslate(-pointF5.x, -pointF5.y);
        Matrix matrix2 = this.mMatrix;
        PointF pointF6 = this.mBezierControl1;
        matrix2.postTranslate(pointF6.x, pointF6.y);
        canvas.drawColor(0);
        canvas.drawBitmap(bitmap, this.mMatrix, this.mPaint);
        this.mPaint.setColorFilter(null);
        float f46 = this.mDegrees;
        PointF pointF7 = this.mBezierStart1;
        canvas.rotate(f46, pointF7.x, pointF7.y);
        float f47 = this.mBezierStart1.y;
        gradientDrawable.setBounds(i3, (int) f47, i16, (int) (f47 + this.mMaxLength));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private final void V(Canvas canvas, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.mPath0.reset();
        Path path = this.mPath0;
        PointF pointF = this.mBezierStart1;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.mPath0;
        PointF pointF2 = this.mBezierControl1;
        float f16 = pointF2.x;
        float f17 = pointF2.y;
        PointF pointF3 = this.mBezierEnd1;
        path2.quadTo(f16, f17, pointF3.x, pointF3.y);
        this.mPath0.lineTo(this.mTouchX, this.mTouchY);
        Path path3 = this.mPath0;
        PointF pointF4 = this.mBezierEnd2;
        path3.lineTo(pointF4.x, pointF4.y);
        Path path4 = this.mPath0;
        PointF pointF5 = this.mBezierControl2;
        float f18 = pointF5.x;
        float f19 = pointF5.y;
        PointF pointF6 = this.mBezierStart2;
        path4.quadTo(f18, f19, pointF6.x, pointF6.y);
        this.mPath0.lineTo(this.mCornerX, this.mCornerY);
        this.mPath0.close();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutPath(this.mPath0);
        } else {
            canvas.clipPath(this.mPath0, Region.Op.XOR);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    private final void W(Canvas canvas) {
        double atan2;
        double d16;
        int i3;
        int i16;
        GradientDrawable gradientDrawable;
        int i17;
        int i18;
        GradientDrawable gradientDrawable2;
        if (this.mIsRtOrLb) {
            PointF pointF = this.mBezierControl1;
            atan2 = Math.atan2(pointF.y - this.mTouchY, this.mTouchX - pointF.x);
        } else {
            float f16 = this.mTouchY;
            PointF pointF2 = this.mBezierControl1;
            atan2 = Math.atan2(f16 - pointF2.y, this.mTouchX - pointF2.x);
        }
        double d17 = 0.7853981633974483d - ((float) atan2);
        double cos = this.shadowWidth * 1.414d * Math.cos(d17);
        double sin = this.shadowWidth * 1.414d * Math.sin(d17);
        float f17 = (float) (this.mTouchX + cos);
        if (this.mIsRtOrLb) {
            d16 = this.mTouchY + sin;
        } else {
            d16 = this.mTouchY - sin;
        }
        float f18 = (float) d16;
        this.mPath1.reset();
        this.mPath1.moveTo(f17, f18);
        this.mPath1.lineTo(this.mTouchX, this.mTouchY);
        Path path = this.mPath1;
        PointF pointF3 = this.mBezierControl1;
        path.lineTo(pointF3.x, pointF3.y);
        Path path2 = this.mPath1;
        PointF pointF4 = this.mBezierStart1;
        path2.lineTo(pointF4.x, pointF4.y);
        this.mPath1.close();
        canvas.save();
        int i19 = Build.VERSION.SDK_INT;
        if (i19 >= 26) {
            canvas.clipOutPath(this.mPath0);
        } else {
            canvas.clipPath(this.mPath0, Region.Op.XOR);
        }
        canvas.clipPath(this.mPath1, Region.Op.INTERSECT);
        if (this.mIsRtOrLb) {
            float f19 = this.mBezierControl1.x;
            i3 = (int) f19;
            i16 = (int) (f19 + this.shadowWidth);
            gradientDrawable = this.mFrontShadowDrawableVLR;
        } else {
            float f26 = this.mBezierControl1.x;
            i3 = (int) (f26 - this.shadowWidth);
            i16 = (int) (f26 + 1);
            gradientDrawable = this.mFrontShadowDrawableVRL;
        }
        float f27 = this.mTouchX;
        PointF pointF5 = this.mBezierControl1;
        float degrees = (float) Math.toDegrees((float) Math.atan2(f27 - pointF5.x, pointF5.y - this.mTouchY));
        PointF pointF6 = this.mBezierControl1;
        canvas.rotate(degrees, pointF6.x, pointF6.y);
        float f28 = this.mBezierControl1.y;
        gradientDrawable.setBounds(i3, (int) (f28 - this.mMaxLength), i16, (int) f28);
        gradientDrawable.draw(canvas);
        canvas.restore();
        this.mPath1.reset();
        this.mPath1.moveTo(f17, f18);
        this.mPath1.lineTo(this.mTouchX, this.mTouchY);
        Path path3 = this.mPath1;
        PointF pointF7 = this.mBezierControl2;
        path3.lineTo(pointF7.x, pointF7.y);
        Path path4 = this.mPath1;
        PointF pointF8 = this.mBezierStart2;
        path4.lineTo(pointF8.x, pointF8.y);
        this.mPath1.close();
        canvas.save();
        if (i19 >= 26) {
            canvas.clipOutPath(this.mPath0);
        } else {
            canvas.clipPath(this.mPath0, Region.Op.XOR);
        }
        canvas.clipPath(this.mPath1);
        if (this.mIsRtOrLb) {
            float f29 = this.mBezierControl2.y;
            i17 = (int) f29;
            i18 = (int) (f29 + this.shadowWidth);
            gradientDrawable2 = this.mFrontShadowDrawableHTB;
        } else {
            float f36 = this.mBezierControl2.y;
            i17 = (int) (f36 - this.shadowWidth);
            i18 = (int) (f36 + 1);
            gradientDrawable2 = this.mFrontShadowDrawableHBT;
        }
        PointF pointF9 = this.mBezierControl2;
        float degrees2 = (float) Math.toDegrees((float) Math.atan2(pointF9.y - this.mTouchY, pointF9.x - this.mTouchX));
        PointF pointF10 = this.mBezierControl2;
        canvas.rotate(degrees2, pointF10.x, pointF10.y);
        float f37 = this.mBezierControl2.y;
        if (f37 < 0.0f) {
            f37 -= getViewHeight();
        }
        double hypot = Math.hypot(this.mBezierControl2.x, f37);
        float f38 = this.mMaxLength;
        if (hypot > f38) {
            float f39 = this.mBezierControl2.x;
            gradientDrawable2.setBounds((int) ((f39 - this.shadowWidth) - hypot), i17, (int) ((f39 + f38) - hypot), i18);
        } else {
            float f46 = this.mBezierControl2.x;
            gradientDrawable2.setBounds((int) (f46 - f38), i17, (int) f46, i18);
        }
        gradientDrawable2.draw(canvas);
        canvas.restore();
    }

    private final void X(Canvas canvas, Bitmap bitmap) {
        int i3;
        int i16;
        GradientDrawable gradientDrawable;
        if (bitmap == null) {
            return;
        }
        this.mPath1.reset();
        Path path = this.mPath1;
        PointF pointF = this.mBezierStart1;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.mPath1;
        PointF pointF2 = this.mBezierVertex1;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.mPath1;
        PointF pointF3 = this.mBezierVertex2;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.mPath1;
        PointF pointF4 = this.mBezierStart2;
        path4.lineTo(pointF4.x, pointF4.y);
        this.mPath1.lineTo(this.mCornerX, this.mCornerY);
        this.mPath1.close();
        this.mDegrees = (float) Math.toDegrees(Math.atan2(this.mBezierControl1.x - this.mCornerX, this.mBezierControl2.y - this.mCornerY));
        if (this.mIsRtOrLb) {
            float f16 = this.mBezierStart1.x;
            i3 = (int) f16;
            i16 = (int) (f16 + (this.mTouchToCornerDis / 5));
            gradientDrawable = this.mBackShadowDrawableLR;
        } else {
            float f17 = this.mBezierStart1.x;
            i3 = (int) (f17 - (this.mTouchToCornerDis / 5));
            i16 = (int) f17;
            gradientDrawable = this.mBackShadowDrawableRL;
        }
        canvas.save();
        canvas.clipPath(this.mPath0);
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.mPath1);
        } else {
            canvas.clipPath(this.mPath1, Region.Op.INTERSECT);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f18 = this.mDegrees;
        PointF pointF5 = this.mBezierStart1;
        canvas.rotate(f18, pointF5.x, pointF5.y);
        float f19 = this.mBezierStart1.y;
        gradientDrawable.setBounds(i3, (int) f19, i16, (int) (this.mMaxLength + f19));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private final PointF Y(PointF P1, PointF P2, PointF P3, PointF P4) {
        PointF pointF = new PointF();
        float f16 = P2.y;
        float f17 = P1.y;
        float f18 = P2.x;
        float f19 = P1.x;
        float f26 = (f16 - f17) / (f18 - f19);
        float f27 = ((f16 * f19) - (f17 * f18)) / (f19 - f18);
        float f28 = P4.y;
        float f29 = P3.y;
        float f36 = P4.x;
        float f37 = P3.x;
        float f38 = ((((f28 * f37) - (f29 * f36)) / (f37 - f36)) - f27) / (f26 - ((f28 - f29) / (f36 - f37)));
        pointF.x = f38;
        pointF.y = (f26 * f38) + f27;
        return pointF;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.j, com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void A(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.A(event);
        int action = event.getAction();
        if (action != 0) {
            if (action == 2) {
                if ((j() > getViewHeight() / 3 && j() < (getViewHeight() * 2) / 3) || getMDirection() == PageDirection.PREV) {
                    getReadView().setTouchY(getViewHeight());
                }
                if (j() > getViewHeight() / 3 && j() < getViewHeight() / 2 && getMDirection() == PageDirection.NEXT) {
                    getReadView().setTouchY(1.0f);
                    return;
                }
                return;
            }
            return;
        }
        S(event.getX(), event.getY());
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.j, com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void D(@NotNull PageDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        super.D(direction);
        int i3 = a.f309945a[direction.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && getViewWidth() / 2 > i()) {
                S(getViewWidth() - i(), j());
                return;
            }
            return;
        }
        if (i() > getViewWidth() / 2) {
            S(i(), getViewHeight());
        } else {
            S(getViewWidth() - i(), getViewHeight());
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void I(int width, int height) {
        super.I(width, height);
        this.mMaxLength = (float) Math.hypot(getViewWidth(), getViewHeight());
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.j
    public void R() {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i3 = a.f309945a[getMDirection().ordinal()];
        Bitmap bitmap3 = null;
        if (i3 != 1) {
            if (i3 == 2) {
                View e16 = e();
                if (e16 != null) {
                    bitmap2 = l.a(e16, this.nextBitmap, this.canvas);
                } else {
                    bitmap2 = null;
                }
                this.nextBitmap = bitmap2;
                View b16 = b();
                if (b16 != null) {
                    bitmap3 = l.a(b16, this.curBitmap, this.canvas);
                }
                this.curBitmap = bitmap3;
                return;
            }
            return;
        }
        View f16 = f();
        if (f16 != null) {
            bitmap = l.a(f16, this.prevBitmap, this.canvas);
        } else {
            bitmap = null;
        }
        this.prevBitmap = bitmap;
        View b17 = b();
        if (b17 != null) {
            bitmap3 = l.a(b17, this.curBitmap, this.canvas);
        }
        this.curBitmap = bitmap3;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void u(int animationSpeed) {
        float viewWidth;
        float f16;
        float l3;
        float f17;
        if (getIsCancel()) {
            if (this.mCornerX > 0 && getMDirection() == PageDirection.NEXT) {
                viewWidth = getViewWidth() - k();
            } else {
                viewWidth = -k();
            }
            if (getMDirection() != PageDirection.NEXT) {
                viewWidth = -(getViewWidth() + k());
            }
            if (this.mCornerY > 0) {
                f16 = getViewHeight();
                l3 = l();
            } else {
                f17 = -l();
                J((int) k(), (int) l(), (int) viewWidth, (int) f17, animationSpeed);
            }
        } else {
            if (this.mCornerX > 0 && getMDirection() == PageDirection.NEXT) {
                viewWidth = -(getViewWidth() + k());
            } else {
                viewWidth = getViewWidth() - k();
            }
            if (this.mCornerY > 0) {
                f16 = getViewHeight();
                l3 = l();
            } else {
                f16 = 1;
                l3 = l();
            }
        }
        f17 = f16 - l3;
        J((int) k(), (int) l(), (int) viewWidth, (int) f17, animationSpeed);
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void v() {
        if (!getIsCancel()) {
            getReadView().a(getMDirection());
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void y(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!getIsRunning()) {
            return;
        }
        int i3 = a.f309945a[getMDirection().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            T();
            V(canvas, this.curBitmap);
            X(canvas, this.nextBitmap);
            W(canvas);
            U(canvas, this.curBitmap);
            return;
        }
        T();
        V(canvas, this.prevBitmap);
        X(canvas, this.curBitmap);
        W(canvas);
        U(canvas, this.prevBitmap);
    }
}
