package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

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
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020\u0019\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010#\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-R\u0014\u00101\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00103R\u0016\u00106\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00105R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010:R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010<R\u0016\u0010?\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010>R\u0014\u0010D\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010MR\u0016\u0010Q\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00105R\u0014\u0010U\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u00100R\u0014\u0010W\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010V\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "f", "e", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Paint;", "paint", "", "leftOffset", "topOffset", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "startDrawX", "g", "k", "bitmapWidth", "d", "", "location", "", "a", "", "screenX", "Lkotlin/Pair;", "c", "Landroid/graphics/Path;", "path", HippyTKDListViewAdapter.X, "y", "b", "onDraw", "j", "i", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/e;", "provider", "setThumbProvider", "px", "setSingleBitmapWidth", "setMaxLeftBorderWidth", "setStartClipWidth", "setEndClipWidth", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/c;", "listener", "setDrawBitmapListener", "Landroid/graphics/Paint;", "drawBitmapPaint", "Landroid/graphics/PaintFlagsDrawFilter;", "Landroid/graphics/PaintFlagsDrawFilter;", "filter", "I", "singleBitmapWidth", tl.h.F, "[I", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "bitmapMatrix", "Landroid/graphics/Path;", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "startClipWidth", "D", "startClipPath", "E", "endClipWidth", "endClipPath", "Landroid/graphics/RectF;", "G", "Landroid/graphics/RectF;", "clickRegionRectF", "Landroid/graphics/Region;", "H", "Landroid/graphics/Region;", "clickRegion", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/c;", "drawBitmapListener", "J", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/e;", "videoThumbProvider", "K", "maxLeftBorderWidth", "L", "maskPaint", "()I", "screenWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PlayTrackExpandWidthView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float startClipWidth;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Path startClipPath;

    /* renamed from: E, reason: from kotlin metadata */
    private float endClipWidth;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Path endClipPath;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final RectF clickRegionRectF;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Region clickRegion;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c drawBitmapListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private e videoThumbProvider;

    /* renamed from: K, reason: from kotlin metadata */
    private int maxLeftBorderWidth;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Paint maskPaint;

    @NotNull
    public Map<Integer, View> M;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint drawBitmapPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PaintFlagsDrawFilter filter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int singleBitmapWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] location;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matrix bitmapMatrix;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/e;", "", "offset", "", "tag", "Landroid/graphics/Bitmap;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements e {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.e
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
        if (location[0] <= h() && location[0] + getMeasuredWidth() >= 0) {
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

    private final Pair<Integer, Integer> c(int screenX) {
        int min;
        int max = Math.max(-screenX, 0);
        if (screenX <= 0) {
            min = Math.min(h(), getMeasuredWidth() + screenX);
        } else {
            min = Math.min(h() - screenX, getMeasuredWidth());
        }
        return TuplesKt.to(Integer.valueOf(max - ((this.maxLeftBorderWidth + max) % this.singleBitmapWidth)), Integer.valueOf(min + max));
    }

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
                    com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c cVar = this.drawBitmapListener;
                    if (cVar != null) {
                        cVar.onCompleted();
                    }
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
            k();
            canvas.drawPath(this.startClipPath, this.maskPaint);
            canvas.drawPath(this.endClipPath, this.maskPaint);
        }
    }

    private final void g(Canvas canvas, Bitmap bitmap, float startDrawX) {
        m(bitmap, this.drawBitmapPaint, startDrawX - ((bitmap.getWidth() - this.singleBitmapWidth) >> 1), (bitmap.getHeight() - getHeight()) >> 1);
        k();
        d(startDrawX, this.singleBitmapWidth);
        canvas.drawPath(this.path, this.drawBitmapPaint);
    }

    private final int h() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private final void k() {
        Path path = this.startClipPath;
        path.reset();
        path.moveTo(0.0f, 0.0f);
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

    private final void l(float leftOffset, float topOffset) {
        this.bitmapMatrix.reset();
        this.bitmapMatrix.postTranslate(leftOffset, -topOffset);
    }

    private final void m(Bitmap bitmap, Paint paint, float leftOffset, float topOffset) {
        paint.reset();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        l(leftOffset, topOffset);
        bitmapShader.setLocalMatrix(this.bitmapMatrix);
        paint.setShader(bitmapShader);
    }

    public final boolean i(float x16, float y16) {
        return b(this.endClipPath, x16, y16);
    }

    public final boolean j(float x16, float y16) {
        return b(this.startClipPath, x16, y16);
    }

    @Override // android.view.View
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

    public final void setDrawBitmapListener(@Nullable com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c listener) {
        this.drawBitmapListener = listener;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayTrackExpandWidthView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.M = new LinkedHashMap();
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
    }

    public /* synthetic */ PlayTrackExpandWidthView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
