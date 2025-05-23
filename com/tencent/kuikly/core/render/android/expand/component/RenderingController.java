package com.tencent.kuikly.core.render.android.expand.component;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 52\u00020\u0001:\u0001CB\u0017\u0012\u000e\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0z\u00a2\u0006\u0004\b}\u0010~J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J/\u0010\u0010\u001a\u00020\u00072%\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J+\u0010$\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b$\u0010%J\n\u0010'\u001a\u0004\u0018\u00010&H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u0005J\u0018\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010.\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u001a\u00100\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010/\u001a\u0004\u0018\u00010&J\u0010\u00101\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u00102\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u001a\u00104\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u00103\u001a\u0004\u0018\u00010&J\u001a\u00105\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u00103\u001a\u0004\u0018\u00010&J\u0006\u00106\u001a\u00020\u0007J\u001a\u00107\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010/\u001a\u0004\u0018\u00010&J\u001a\u00108\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010/\u001a\u0004\u0018\u00010&J\u001a\u00109\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u00103\u001a\u0004\u0018\u00010&J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010<\u001a\u00020\u0007J\u0010\u0010=\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010>\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010?\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u000e\u0010@\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0001J\u0006\u0010A\u001a\u00020\u0007R;\u0010E\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u000e0B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010(R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010XR\u0018\u0010_\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010ZR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\"\u0010k\u001a\u00020d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010uR\u0014\u0010v\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010mR\u0014\u0010y\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010xR\u001c\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010{\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/RenderingController;", "", "", "w", tl.h.F, "Landroid/graphics/Bitmap;", "D", "", "M", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lkotlin/ParameterName;", "name", PM.CANVAS, "Lcom/tencent/kuikly/core/render/android/expand/component/CanvasRenderingTask;", "task", "p", "", "cap", "I", "", "lineWidth", ExifInterface.LATITUDE_SOUTH, "style", BdhLogUtil.LogTag.Tag_Conn, "V", "Landroid/graphics/LinearGradient;", "W", "params", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "gradient", "color", "Landroid/graphics/Paint;", "paint", "G", "(Landroid/graphics/LinearGradient;Ljava/lang/Integer;Landroid/graphics/Paint;)V", "Lcom/tencent/kuikly/core/render/android/a;", "E", UserInfo.SEX_FEMALE, "Landroid/graphics/RectF;", "rectF", MimeHelper.IMAGE_SUBTYPE_BITMAP, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Req, "kuiklyContext", "T", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "kuiklyRenderContext", "N", "t", ReportConstant.COSTREPORT_PREFIX, "L", "J", "r", "u", "B", "y", "P", "K", "Y", "X", "O", "", "a", "Ljava/util/List;", "renderingQueue", "Landroid/graphics/Path;", "b", "Landroid/graphics/Path;", "path", "Landroid/graphics/Paint$Cap;", "c", "Landroid/graphics/Paint$Cap;", "lineCap", "Landroid/graphics/Paint$Join;", "d", "Landroid/graphics/Paint$Join;", "strokeJoin", "e", "Landroid/graphics/Paint$Style;", "f", "Landroid/graphics/Paint$Style;", "drawStyle", "g", "Ljava/lang/Integer;", "fillColor", "Landroid/graphics/LinearGradient;", "fillGradient", "i", "strokeColor", "j", "strokeGradient", "Landroid/graphics/PorterDuffXfermode;", "k", "Landroid/graphics/PorterDuffXfermode;", com.tencent.luggage.wxa.c8.c.W, "", "l", "Z", "H", "()Z", "setDiffPatchDrawMode", "(Z)V", "isDiffPatchDrawMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "", DomainData.DOMAIN_NAME, "Ljava/util/Map;", "undoMarkMap", "o", "Landroid/graphics/Bitmap;", "currentBitmap", "Landroid/graphics/Canvas;", "bitmapPaint", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "pathCurrentPoint", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "contextGetter", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class RenderingController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile List<Function1<Canvas, Unit>> renderingQueue;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Path path;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Paint.Cap lineCap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Paint.Join strokeJoin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float lineWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Paint.Style drawStyle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Integer fillColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearGradient fillGradient;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer strokeColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private LinearGradient strokeGradient;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private PorterDuffXfermode blendMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isDiffPatchDrawMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, Bitmap> undoMarkMap;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private volatile Bitmap currentBitmap;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Canvas canvas;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Paint bitmapPaint;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final PointF pathCurrentPoint;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Function0<com.tencent.kuikly.core.render.android.a> contextGetter;

    /* JADX WARN: Multi-variable type inference failed */
    public RenderingController(@NotNull Function0<? extends com.tencent.kuikly.core.render.android.a> contextGetter) {
        Intrinsics.checkNotNullParameter(contextGetter, "contextGetter");
        this.contextGetter = contextGetter;
        this.renderingQueue = new ArrayList();
        this.path = new Path();
        this.lineCap = Paint.Cap.BUTT;
        this.strokeJoin = Paint.Join.MITER;
        this.drawStyle = Paint.Style.STROKE;
        this.blendMode = KRCanvasView.INSTANCE.b();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Unit unit = Unit.INSTANCE;
        this.paint = paint;
        this.undoMarkMap = new LinkedHashMap();
        this.canvas = new Canvas();
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setFilterBitmap(true);
        this.bitmapPaint = paint2;
        this.pathCurrentPoint = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        this.canvas.drawPath(this.path, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String style) {
        Integer num;
        LinearGradient W = W(style);
        this.fillGradient = W;
        if (W == null) {
            num = Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w(style));
        } else {
            num = null;
        }
        this.fillColor = num;
    }

    private final Bitmap D(int w3, int h16) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(w3, h16, Bitmap.Config.ARGB_8888);
            this.canvas.setBitmap(bitmap);
            F();
            Iterator<Function1<Canvas, Unit>> it = this.renderingQueue.iterator();
            while (it.hasNext()) {
                it.next().invoke(this.canvas);
            }
            this.currentBitmap = bitmap;
        } catch (Throwable th5) {
            w.f392617a.b("KRCanvasView", "fullDraw error: " + th5);
        }
        return bitmap;
    }

    private final com.tencent.kuikly.core.render.android.a E() {
        return this.contextGetter.invoke();
    }

    private final void F() {
        this.lineCap = Paint.Cap.BUTT;
        this.strokeJoin = Paint.Join.MITER;
        this.lineWidth = 0.0f;
        this.drawStyle = Paint.Style.STROKE;
        this.fillColor = null;
        this.fillGradient = null;
        this.strokeColor = null;
        this.strokeGradient = null;
        this.blendMode = KRCanvasView.INSTANCE.b();
        this.path = new Path();
    }

    private final void G(LinearGradient gradient, Integer color, Paint paint) {
        if (color != null) {
            paint.setColor(color.intValue());
            paint.setShader(null);
        } else if (gradient != null) {
            paint.setShader(gradient);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String cap) {
        Paint.Cap cap2;
        Paint.Join join;
        int hashCode = cap.hashCode();
        if (hashCode != -894674659) {
            if (hashCode != 3035667) {
                if (hashCode == 108704142 && cap.equals("round")) {
                    cap2 = Paint.Cap.ROUND;
                }
                cap2 = Paint.Cap.BUTT;
            } else {
                if (cap.equals("butt")) {
                    cap2 = Paint.Cap.BUTT;
                }
                cap2 = Paint.Cap.BUTT;
            }
        } else {
            if (cap.equals("square")) {
                cap2 = Paint.Cap.SQUARE;
            }
            cap2 = Paint.Cap.BUTT;
        }
        this.lineCap = cap2;
        if (cap2 == Paint.Cap.ROUND) {
            join = Paint.Join.ROUND;
        } else {
            join = Paint.Join.MITER;
        }
        this.strokeJoin = join;
    }

    private final void M() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.renderingQueue);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this.canvas);
        }
        this.renderingQueue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(String style) {
        Integer num;
        LinearGradient W = W(style);
        this.strokeGradient = W;
        if (W == null) {
            num = Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w(style));
        } else {
            num = null;
        }
        this.strokeColor = num;
    }

    private final LinearGradient W(String style) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(style, "linear-gradient", false, 2, null);
        if (!startsWith$default) {
            return null;
        }
        if (style != null) {
            String substring = style.substring(15);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return v(substring);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void p(Function1<? super Canvas, Unit> task) {
        this.renderingQueue.add(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.paint.setStrokeCap(this.lineCap);
        this.paint.setStrokeJoin(this.strokeJoin);
        this.paint.setStyle(this.drawStyle);
        if (this.drawStyle == Paint.Style.FILL) {
            G(this.fillGradient, this.fillColor, this.paint);
            this.paint.setStrokeWidth(0.0f);
        } else {
            G(this.strokeGradient, this.strokeColor, this.paint);
            this.paint.setStrokeWidth(this.lineWidth);
        }
        this.paint.setXfermode(this.blendMode);
    }

    private final LinearGradient v(String params) {
        List split$default;
        List split$default2;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        com.tencent.kuikly.core.render.android.a E = E();
        float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(E, (float) k06.optDouble("x0"));
        float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(E, (float) k06.optDouble("y0"));
        float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(E, (float) k06.optDouble("x1"));
        float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(E, (float) k06.optDouble("y1"));
        String optString = k06.optString("colorStops");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsJSON.optString(\"colorStops\")");
        split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null);
        int[] iArr = new int[split$default.size()];
        float[] fArr = new float[split$default.size()];
        int i3 = 0;
        for (Object obj : split$default) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) obj, new String[]{" "}, false, 0, 6, (Object) null);
            iArr[i3] = com.tencent.kuikly.core.render.android.css.ktx.b.w((String) split$default2.get(0));
            fArr[i3] = Float.parseFloat((String) split$default2.get(1));
            i3 = i16;
        }
        return new LinearGradient(I, I2, I3, I4, iArr, fArr, Shader.TileMode.CLAMP);
    }

    private final Bitmap w(int w3, int h16) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(w3, h16, Bitmap.Config.ARGB_8888);
            this.canvas.setBitmap(bitmap);
            Bitmap bitmap2 = this.currentBitmap;
            if (bitmap2 != null) {
                this.canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.bitmapPaint);
            }
            M();
            this.currentBitmap = bitmap;
            Path path = new Path();
            PointF pointF = this.pathCurrentPoint;
            path.moveTo(pointF.x, pointF.y);
            this.path = path;
        } catch (Throwable th5) {
            w.f392617a.b("KRCanvasView", "diffPatchDraw erorr: " + th5);
        }
        return bitmap;
    }

    public final void B() {
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$drawStroke$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController.this.drawStyle = Paint.Style.STROKE;
                RenderingController.this.q();
                RenderingController.this.A();
            }
        });
    }

    /* renamed from: H, reason: from getter */
    public final boolean getIsDiffPatchDrawMode() {
        return this.isDiffPatchDrawMode;
    }

    public final void J(@Nullable String params, @Nullable final com.tencent.kuikly.core.render.android.a kuiklyContext) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        final float optDouble = (float) k06.optDouble(HippyTKDListViewAdapter.X);
        final float optDouble2 = (float) k06.optDouble("y");
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$lineTo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                PointF pointF;
                Path path;
                Intrinsics.checkNotNullParameter(it, "it");
                float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyContext, optDouble);
                float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyContext, optDouble2);
                pointF = RenderingController.this.pathCurrentPoint;
                pointF.set(I, I2);
                path = RenderingController.this.path;
                path.lineTo(I, I2);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(@Nullable String params) {
        Integer intOrNull;
        if (params != null && intOrNull != null) {
            final int intValue = intOrNull.intValue();
            this.isDiffPatchDrawMode = true;
            p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$markUndoIndex$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                    invoke2(canvas);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Canvas it) {
                    Bitmap bitmap;
                    Map map;
                    Intrinsics.checkNotNullParameter(it, "it");
                    bitmap = RenderingController.this.currentBitmap;
                    if (bitmap != null) {
                        map = RenderingController.this.undoMarkMap;
                        Integer valueOf = Integer.valueOf(intValue);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
                        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(bitmap)");
                        map.put(valueOf, createBitmap);
                    }
                }
            });
        }
    }

    public final void L(@Nullable String params, @Nullable final com.tencent.kuikly.core.render.android.a kuiklyContext) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        final float optDouble = (float) k06.optDouble(HippyTKDListViewAdapter.X);
        final float optDouble2 = (float) k06.optDouble("y");
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$moveTo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                PointF pointF;
                Path path;
                Intrinsics.checkNotNullParameter(it, "it");
                float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyContext, optDouble);
                float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyContext, optDouble2);
                pointF = RenderingController.this.pathCurrentPoint;
                pointF.set(I, I2);
                path = RenderingController.this.path;
                path.moveTo(I, I2);
            }
        });
    }

    public final void N(@Nullable String params, @Nullable com.tencent.kuikly.core.render.android.a kuiklyRenderContext) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        final float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("cpx"));
        final float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("cpy"));
        final float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble(HippyTKDListViewAdapter.X));
        final float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("y"));
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$quadraticCurveTo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                PointF pointF;
                Path path;
                Intrinsics.checkNotNullParameter(it, "it");
                pointF = RenderingController.this.pathCurrentPoint;
                pointF.set(I3, I4);
                path = RenderingController.this.path;
                path.quadTo(I, I2, I3, I4);
            }
        });
    }

    public final void O() {
        this.lineCap = Paint.Cap.BUTT;
        this.strokeJoin = Paint.Join.MITER;
        this.lineWidth = 0.0f;
        this.drawStyle = Paint.Style.STROKE;
        this.fillColor = null;
        this.fillGradient = null;
        this.strokeColor = null;
        this.strokeGradient = null;
        this.blendMode = KRCanvasView.INSTANCE.b();
        this.renderingQueue.clear();
        this.undoMarkMap.clear();
        this.currentBitmap = null;
        this.path = new Path();
        this.pathCurrentPoint.set(0.0f, 0.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(@Nullable String params) {
        int i3;
        final PorterDuffXfermode b16;
        Integer intOrNull;
        if (params != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                b16 = KRCanvasView.INSTANCE.b();
            } else {
                b16 = KRCanvasView.INSTANCE.a();
            }
        } else {
            b16 = KRCanvasView.INSTANCE.b();
        }
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$setClearBlendMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController.this.blendMode = b16;
            }
        });
    }

    public final void Q(@Nullable String params) {
        final String optString = KRCSSViewExtensionKt.k0(params).optString("style");
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$setFillStyle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController renderingController = RenderingController.this;
                String fillStyle = optString;
                Intrinsics.checkNotNullExpressionValue(fillStyle, "fillStyle");
                renderingController.C(fillStyle);
            }
        });
    }

    public final void R(@Nullable String params) {
        final String optString = KRCSSViewExtensionKt.k0(params).optString("style");
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$setLineCap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController renderingController = RenderingController.this;
                String style = optString;
                Intrinsics.checkNotNullExpressionValue(style, "style");
                renderingController.I(style);
            }
        });
    }

    public final void T(@Nullable String params, @Nullable final com.tencent.kuikly.core.render.android.a kuiklyContext) {
        final float optDouble = (float) KRCSSViewExtensionKt.k0(params).optDouble("width");
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$setLineWidth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController.this.S(com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyContext, optDouble));
            }
        });
    }

    public final void U(@Nullable String params) {
        final String optString = KRCSSViewExtensionKt.k0(params).optString("style");
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$setStrokeStyle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController renderingController = RenderingController.this;
                String strokeStyle = optString;
                Intrinsics.checkNotNullExpressionValue(strokeStyle, "strokeStyle");
                renderingController.V(strokeStyle);
            }
        });
    }

    public final void X(@NotNull Object params) {
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z16 = true;
        if (((Integer) params).intValue() != 1) {
            z16 = false;
        }
        this.isDiffPatchDrawMode = z16;
    }

    public final void Y(@Nullable String params) {
        Bitmap bitmap;
        if (params != null) {
            Bitmap bitmap2 = this.undoMarkMap.get(Integer.valueOf(Integer.parseInt(params)));
            if (bitmap2 != null) {
                bitmap = Bitmap.createBitmap(bitmap2);
            } else {
                bitmap = null;
            }
            this.currentBitmap = bitmap;
        }
    }

    public final void r(@Nullable String params, @Nullable com.tencent.kuikly.core.render.android.a kuiklyRenderContext) {
        final boolean z16;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        final float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble(HippyTKDListViewAdapter.X));
        final float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("y"));
        final float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("r"));
        final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
        doubleRef.element = k06.optDouble("sAngle");
        double optDouble = k06.optDouble("eAngle");
        if (k06.optInt("counterclockwise") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        double d16 = doubleRef.element * 57.29577951308232d;
        doubleRef.element = d16;
        final double abs = Math.abs((optDouble * 57.29577951308232d) - d16);
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$arc$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Path path;
                Intrinsics.checkNotNullParameter(it, "it");
                path = RenderingController.this.path;
                float f16 = I;
                float f17 = I3;
                float f18 = I2;
                path.arcTo(new RectF(f16 - f17, f18 - f17, f16 + f17, f18 + f17), (float) doubleRef.element, (float) (z16 ? -abs : abs));
            }
        });
    }

    public final void s() {
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$beginPath$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController.this.path = new Path();
            }
        });
    }

    public final void t(@Nullable String params, @Nullable com.tencent.kuikly.core.render.android.a kuiklyRenderContext) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        final float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("cp1x"));
        final float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("cp1y"));
        final float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("cp2x"));
        final float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("cp2y"));
        final float I5 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble(HippyTKDListViewAdapter.X));
        final float I6 = com.tencent.kuikly.core.render.android.css.ktx.b.I(kuiklyRenderContext, (float) k06.optDouble("y"));
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$bezierCurveTo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                PointF pointF;
                Path path;
                Intrinsics.checkNotNullParameter(it, "it");
                pointF = RenderingController.this.pathCurrentPoint;
                pointF.set(I5, I6);
                path = RenderingController.this.path;
                path.cubicTo(I, I2, I3, I4, I5, I6);
            }
        });
    }

    public final void u() {
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$closePath$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Path path;
                Intrinsics.checkNotNullParameter(it, "it");
                path = RenderingController.this.path;
                path.close();
            }
        });
    }

    public final void x(@NotNull final RectF rectF, @Nullable final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        if (bitmap == null) {
            return;
        }
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$drawBitmap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Canvas canvas;
                Paint paint;
                Intrinsics.checkNotNullParameter(it, "it");
                canvas = RenderingController.this.canvas;
                Bitmap bitmap2 = bitmap;
                RectF rectF2 = rectF;
                paint = RenderingController.this.bitmapPaint;
                canvas.drawBitmap(bitmap2, (Rect) null, rectF2, paint);
            }
        });
    }

    public final void y() {
        p(new Function1<Canvas, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.RenderingController$drawFill$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RenderingController.this.drawStyle = Paint.Style.FILL;
                RenderingController.this.q();
                RenderingController.this.A();
            }
        });
    }

    @Nullable
    public final Bitmap z(int w3, int h16) {
        if (this.isDiffPatchDrawMode) {
            return w(w3, h16);
        }
        return D(w3, h16);
    }
}
