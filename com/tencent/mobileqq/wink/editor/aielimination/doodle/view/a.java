package com.tencent.mobileqq.wink.editor.aielimination.doodle.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010R\u001a\u00020\t\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*J\u0006\u0010,\u001a\u00020*J\u0016\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013J\u0016\u00100\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013J\u0016\u00101\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00102R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00102R\u0014\u00106\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00105R\u0014\u00107\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00105R\u0014\u00109\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010>R\u0014\u0010A\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010@R\u0014\u0010B\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010>R\u0018\u0010D\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010CR\u0016\u0010E\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00108R\u0018\u0010G\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010HR\u0016\u0010K\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010OR\u0016\u0010Q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/a;", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/e;", "", "changePivot", "", "c", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;", "j", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pen", "v", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/g;", DomainData.DOMAIN_NAME, "shape", "w", "", "o", "size", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/d;", "i", "color", "t", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "g", "e", tl.h.F, "f", "b", "y", "u", "Landroid/graphics/PointF;", "k", "a", "onRemove", "r", "Landroid/graphics/Path;", "path", "l", "dx", "dy", "d", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "drawCloseDrawable", "shouldDrawCloseDrawable", "Landroid/graphics/Path;", "mPath", "mOriginPath", "Landroid/graphics/PointF;", "mCloseXY", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "mTransform", "Landroid/graphics/Rect;", "mRect", "mBitmapColorMatrix", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;", "mDoodle", "mLocation", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/f;", "mPen", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/g;", "mShape", UserInfo.SEX_FEMALE, "mSize", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/d;", "mColor", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mBound", "mHasAdded", "doodle", "<init>", "(Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements e {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean drawCloseDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean shouldDrawCloseDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mOriginPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mCloseXY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matrix mTransform;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matrix mBitmapColorMatrix;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mDoodle;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF mLocation;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f mPen;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mShape;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float mSize;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mColor;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mBound;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean mHasAdded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/a$a;", "", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;", "doodle", "Landroid/graphics/Path;", "p", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/a;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a(@NotNull c doodle, @Nullable Path p16) {
            f fVar;
            g gVar;
            Intrinsics.checkNotNullParameter(doodle, "doodle");
            a aVar = new a(doodle);
            f mPen = doodle.getMPen();
            d dVar = null;
            if (mPen != null) {
                fVar = mPen.copy();
            } else {
                fVar = null;
            }
            aVar.v(fVar);
            g mShape = doodle.getMShape();
            if (mShape != null) {
                gVar = mShape.copy();
            } else {
                gVar = null;
            }
            aVar.w(gVar);
            aVar.x(doodle.getSize());
            d mColor = doodle.getMColor();
            if (mColor != null) {
                dVar = mColor.copy();
            }
            aVar.t(dVar);
            aVar.y(p16);
            return aVar;
        }

        Companion() {
        }
    }

    public a(@NotNull c doodle) {
        Intrinsics.checkNotNullParameter(doodle, "doodle");
        this.mPath = new Path();
        this.mOriginPath = new Path();
        this.mCloseXY = new PointF();
        this.mPaint = new Paint();
        this.mTransform = new Matrix();
        this.mRect = new Rect();
        this.mBitmapColorMatrix = new Matrix();
        this.mLocation = new PointF();
        this.mBound = new RectF();
        this.mDoodle = doodle;
    }

    private final void c(boolean changePivot) {
        s(this.mRect);
        this.mPath.reset();
        this.mPath.addPath(this.mOriginPath);
        this.mTransform.reset();
        Matrix matrix = this.mTransform;
        Rect rect = this.mRect;
        matrix.setTranslate(-rect.left, -rect.top);
        this.mPath.transform(this.mTransform);
        if (changePivot) {
            Rect rect2 = this.mRect;
            u(rect2.left, rect2.top);
        }
        r();
    }

    private final void s(Rect rect) {
        int o16 = (int) ((o() / 2) + 0.5f);
        this.mOriginPath.computeBounds(this.mBound, false);
        RectF rectF = this.mBound;
        float f16 = o16;
        rect.set((int) (rectF.left - f16), (int) (rectF.top - f16), (int) (rectF.right + f16), (int) (rectF.bottom + f16));
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.e
    public void a() {
        this.mHasAdded = true;
    }

    public final boolean d(float dx5, float dy5) {
        DoodleView doodleView;
        int a16;
        c mDoodle = getMDoodle();
        if (mDoodle instanceof DoodleView) {
            doodleView = (DoodleView) mDoodle;
        } else {
            doodleView = null;
        }
        if (doodleView != null) {
            a16 = (int) doodleView.y();
        } else {
            a16 = cx.a(15.0f);
        }
        PointF pointF = this.mCloseXY;
        float f16 = pointF.x;
        float f17 = a16 * 2;
        if (dx5 <= f16 + f17 && dx5 >= f16) {
            float f18 = pointF.y;
            if (dy5 <= f17 + f18 && dy5 >= f18) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.e
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        PointF mLocation = getMLocation();
        this.mLocation = mLocation;
        canvas.translate(mLocation.x, mLocation.y);
        e(canvas);
        canvas.restoreToCount(save);
        g(canvas);
    }

    public final void e(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mPaint.reset();
        this.mPaint.setStrokeWidth(o());
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        f mPen = getMPen();
        if (mPen != null) {
            mPen.config(this, this.mPaint);
        }
        d mColor = getMColor();
        if (mColor != null) {
            mColor.config(this, this.mPaint);
        }
        g mShape = getMShape();
        if (mShape != null) {
            mShape.config(this, this.mPaint);
        }
        canvas.drawPath(getMPath(), this.mPaint);
    }

    public final void f(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        w53.b.a("DoodlePath", "doExport" + canvas);
        Paint paint = new Paint();
        paint.reset();
        paint.setStrokeWidth(o());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setAlpha(1);
        paint.setColor(-16777216);
        canvas.drawPath(getMPath(), paint);
    }

    public final void g(@NotNull Canvas canvas) {
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.drawCloseDrawable && (getMDoodle() instanceof DoodleView)) {
            c mDoodle = getMDoodle();
            Intrinsics.checkNotNull(mDoodle, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleView");
            Bitmap x16 = ((DoodleView) mDoodle).x();
            if (x16 != null) {
                num = Integer.valueOf(x16.getWidth());
            } else {
                num = null;
            }
            if (x16 != null) {
                num2 = Integer.valueOf(x16.getHeight());
            } else {
                num2 = null;
            }
            w53.b.a("DoodlePath", "close_bitmap:" + num + ":" + num2);
            if (x16 != null) {
                PointF pointF = this.mCloseXY;
                canvas.drawBitmap(x16, pointF.x, pointF.y, (Paint) null);
            }
        }
    }

    public void h(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        PointF mLocation = getMLocation();
        this.mLocation = mLocation;
        canvas.translate(mLocation.x, mLocation.y);
        f(canvas);
        canvas.restoreToCount(save);
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public d getMColor() {
        return this.mColor;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public c getMDoodle() {
        return this.mDoodle;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public PointF getMLocation() {
        return this.mLocation;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final Path getMPath() {
        return this.mPath;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public f getMPen() {
        return this.mPen;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public g getMShape() {
        return this.mShape;
    }

    public float o() {
        w53.b.a("DoodlePath", "doodlePath: " + this.mSize);
        return this.mSize;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.e
    public void onRemove() {
        this.mHasAdded = false;
    }

    public final boolean p(float dx5, float dy5) {
        Bitmap bitmap;
        c mDoodle = getMDoodle();
        if (mDoodle != null) {
            bitmap = mDoodle.getMBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            w53.b.a("DoodlePath", "onScroll dx:" + dx5 + ",dy:" + dy5 + ",width:" + width + ",height:" + height);
            if (dx5 <= width && dx5 >= 0.0f && dy5 <= height && dy5 >= 0.0f) {
                this.shouldDrawCloseDrawable = true;
                this.mCloseXY.set(dx5, dy5);
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean q(float dx5, float dy5) {
        Bitmap bitmap;
        float f16;
        if (!this.shouldDrawCloseDrawable) {
            return false;
        }
        this.shouldDrawCloseDrawable = false;
        this.drawCloseDrawable = true;
        c mDoodle = getMDoodle();
        DoodleView doodleView = null;
        if (mDoodle != null) {
            bitmap = mDoodle.getMBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            c mDoodle2 = getMDoodle();
            if (mDoodle2 instanceof DoodleView) {
                doodleView = (DoodleView) mDoodle2;
            }
            float f17 = 0.0f;
            if (doodleView != null) {
                f16 = doodleView.y();
            } else {
                f16 = 0.0f;
            }
            PointF pointF = this.mCloseXY;
            float f18 = pointF.x - f16;
            float f19 = 2 * f16;
            float f26 = width - f19;
            if (f18 >= f26) {
                f18 = f26;
            } else if (f18 < 0.0f) {
                f18 = 0.0f;
            }
            float f27 = pointF.y - f16;
            float f28 = height - f19;
            if (f27 >= f28) {
                f17 = f28;
            } else if (f27 >= 0.0f) {
                f17 = f27;
            }
            w53.b.a("DoodlePath", "drawCloseDrawable dx:" + dx5 + ",dy:" + dy5 + ",closeX:" + f18 + ",closeY:" + f17);
            this.mCloseXY.set(f18, f17);
        }
        return true;
    }

    public void r() {
        c cVar;
        if (this.mHasAdded && (cVar = this.mDoodle) != null && cVar != null) {
            cVar.refresh();
        }
    }

    public void t(@Nullable d color) {
        this.mColor = color;
        r();
    }

    public void u(float x16, float y16) {
        PointF pointF = this.mLocation;
        pointF.x = x16;
        pointF.y = y16;
        r();
    }

    public void v(@Nullable f pen) {
        this.mPen = pen;
        r();
    }

    public void w(@Nullable g shape) {
        this.mShape = shape;
        r();
    }

    public void x(float size) {
        this.mSize = size;
        r();
    }

    public final void y(@Nullable Path path) {
        if (path != null) {
            this.mOriginPath.reset();
            this.mOriginPath.addPath(path);
            c(true);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.e
    public void b(@Nullable Canvas canvas) {
    }
}
