package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020\u0019\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0003J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0003J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J0\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0019H\u0014J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0015J\u0016\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0019J\u000e\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000bR\u0014\u00104\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00106R\u0016\u00109\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00108R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00108R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010AR\u0016\u0010G\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010CR\u0014\u0010I\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010AR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010OR\u0016\u0010S\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u00108R\u0014\u0010W\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u00103\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "f", "e", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Paint;", "paint", "", "leftOffset", "topOffset", "l", "k", "startDrawX", "g", "j", "bitmapWidth", "d", "", "location", "", "a", "", "windowX", "Lkotlin/Pair;", "c", "Landroid/graphics/Path;", "path", HippyTKDListViewAdapter.X, "y", "b", "changed", "left", "top", "right", "bottom", "onLayout", "onDraw", "i", tl.h.F, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/e;", "provider", "setThumbProvider", "px", "setSingleBitmapWidth", "setMaxLeftBorderWidth", "setStartClipWidth", "setEndClipWidth", "Landroid/graphics/Paint;", "drawBitmapPaint", "Landroid/graphics/PaintFlagsDrawFilter;", "Landroid/graphics/PaintFlagsDrawFilter;", "filter", "I", "singleBitmapWidth", "displayWidth", "[I", "Landroid/graphics/Matrix;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Matrix;", "bitmapMatrix", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Path;", "D", UserInfo.SEX_FEMALE, "startClipWidth", "E", "startClipPath", "endClipWidth", "G", "endClipPath", "Landroid/graphics/RectF;", "H", "Landroid/graphics/RectF;", "clickRegionRectF", "Landroid/graphics/Region;", "Landroid/graphics/Region;", "clickRegion", "J", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/e;", "videoThumbProvider", "K", "maxLeftBorderWidth", "L", "maskPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayTrackExpandWidthView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: D, reason: from kotlin metadata */
    private float startClipWidth;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Path startClipPath;

    /* renamed from: F, reason: from kotlin metadata */
    private float endClipWidth;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Path endClipPath;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final RectF clickRegionRectF;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Region clickRegion;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private e videoThumbProvider;

    /* renamed from: K, reason: from kotlin metadata */
    private int maxLeftBorderWidth;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Paint maskPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint drawBitmapPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PaintFlagsDrawFilter filter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int singleBitmapWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int displayWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] location;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matrix bitmapMatrix;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView$b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/e;", "", "offset", "", "tag", "Landroid/graphics/Bitmap;", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements e {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.e
        @Nullable
        public Bitmap a(int offset, @Nullable Object tag) {
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayTrackExpandWidthView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean a(int[] location) {
        boolean z16;
        if (location.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        int i3 = location[0];
        if (i3 <= this.displayWidth && i3 + getMeasuredWidth() >= 0) {
            return true;
        }
        return false;
    }

    private final boolean b(Path path, float x16, float y16) {
        RectF rectF = this.clickRegionRectF;
        rectF.setEmpty();
        path.computeBounds(rectF, true);
        this.clickRegion.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return this.clickRegion.contains((int) x16, (int) y16);
    }

    private final Pair<Integer, Integer> c(int windowX) {
        int min;
        int max = Math.max(-windowX, 0);
        if (windowX <= 0) {
            min = Math.min(this.displayWidth, getMeasuredWidth() + windowX);
        } else {
            min = Math.min(this.displayWidth - windowX, getMeasuredWidth());
        }
        int i3 = min + max;
        int i16 = max - ((this.maxLeftBorderWidth + max) % this.singleBitmapWidth);
        if (QLog.isDevelopLevel()) {
            QLog.d("PlayTrackExpandWidthView", 1, "computeDrawHorizontalRegion [" + i16 + " to " + i3 + "] displayW:" + this.displayWidth + " windowX:" + windowX + " measuredWidth:" + getMeasuredWidth() + " singleBitmapWidth:" + this.singleBitmapWidth);
        }
        return TuplesKt.to(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    @RequiresApi(19)
    private final void d(float startDrawX, float bitmapWidth) {
        Path path = this.path;
        path.reset();
        path.moveTo(startDrawX, 0.0f);
        float f16 = bitmapWidth + startDrawX;
        path.lineTo(f16, 0.0f);
        path.lineTo(f16, getMeasuredHeight());
        path.lineTo(startDrawX, getMeasuredHeight());
        path.lineTo(startDrawX, 0.0f);
        path.close();
        if (!isSelected()) {
            path.op(this.startClipPath, Path.Op.DIFFERENCE);
            path.op(this.endClipPath, Path.Op.DIFFERENCE);
        }
    }

    @RequiresApi(19)
    private final void e(Canvas canvas) {
        Pair<Integer, Integer> c16 = c(this.location[0]);
        int intValue = c16.component1().intValue();
        int intValue2 = c16.component2().intValue();
        int i3 = this.singleBitmapWidth;
        if (i3 > 0) {
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(intValue, intValue2, i3);
            if (intValue > progressionLastElement) {
                return;
            }
            while (true) {
                Bitmap a16 = this.videoThumbProvider.a(this.maxLeftBorderWidth + intValue, null);
                if (a16 != null) {
                    g(canvas, a16, intValue);
                }
                if (intValue != progressionLastElement) {
                    intValue += i3;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Step must be positive, was: " + i3 + ".");
        }
    }

    private final void f(Canvas canvas) {
        if (isSelected()) {
            j();
            canvas.drawPath(this.startClipPath, this.maskPaint);
            canvas.drawPath(this.endClipPath, this.maskPaint);
        }
    }

    @RequiresApi(19)
    private final void g(Canvas canvas, Bitmap bitmap, float startDrawX) {
        l(bitmap, this.drawBitmapPaint, startDrawX - ((bitmap.getWidth() - this.singleBitmapWidth) >> 1), (bitmap.getHeight() - getHeight()) >> 1);
        j();
        d(startDrawX, this.singleBitmapWidth);
        canvas.drawPath(this.path, this.drawBitmapPaint);
    }

    private final void j() {
        Path path = this.startClipPath;
        path.reset();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(this.startClipWidth, 0.0f);
        path.lineTo(0.0f, getMeasuredHeight());
        path.lineTo(0.0f, 0.0f);
        path.close();
        Path path2 = this.endClipPath;
        path2.reset();
        path2.moveTo(getMeasuredWidth(), 0.0f);
        path2.lineTo(getMeasuredWidth(), getMeasuredHeight());
        path2.lineTo(getMeasuredWidth() - this.endClipWidth, getMeasuredHeight());
        path2.lineTo(getMeasuredWidth(), 0.0f);
        path2.close();
    }

    private final void k(float leftOffset, float topOffset) {
        this.bitmapMatrix.reset();
        this.bitmapMatrix.postTranslate(leftOffset, -topOffset);
    }

    private final void l(Bitmap bitmap, Paint paint, float leftOffset, float topOffset) {
        paint.reset();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        k(leftOffset, topOffset);
        bitmapShader.setLocalMatrix(this.bitmapMatrix);
        paint.setShader(bitmapShader);
    }

    public final boolean h(float x16, float y16) {
        return b(this.endClipPath, x16, y16);
    }

    public final boolean i(float x16, float y16) {
        return b(this.startClipPath, x16, y16);
    }

    @Override // android.view.View
    @RequiresApi(19)
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        getLocationInWindow(this.location);
        if (!a(this.location)) {
            return;
        }
        canvas.setDrawFilter(this.filter);
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.displayWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        if (QLog.isDevelopLevel()) {
            QLog.d("PlayTrackExpandWidthView", 1, "onLayout displayWidth:" + this.displayWidth + " changed:" + changed);
        }
    }

    public final void setEndClipWidth(float px5) {
        this.endClipWidth = px5;
    }

    public final void setMaxLeftBorderWidth(int px5) {
        this.maxLeftBorderWidth = px5;
    }

    public final void setSingleBitmapWidth(int px5) {
        this.singleBitmapWidth = px5;
    }

    public final void setStartClipWidth(float px5) {
        this.startClipWidth = px5;
    }

    public final void setThumbProvider(@NotNull e provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.videoThumbProvider = provider;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayTrackExpandWidthView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PlayTrackExpandWidthView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayTrackExpandWidthView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.drawBitmapPaint = paint;
        this.filter = new PaintFlagsDrawFilter(0, 3);
        this.location = new int[2];
        this.bitmapMatrix = new Matrix();
        this.path = new Path();
        this.startClipPath = new Path();
        this.endClipPath = new Path();
        this.clickRegionRectF = new RectF();
        this.clickRegion = new Region();
        this.videoThumbProvider = new b();
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#88000000"));
        this.maskPaint = paint2;
        this.displayWidth = context.getResources().getDisplayMetrics().widthPixels;
    }
}
