package com.tencent.biz.qui.dragrefresh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.biz.qui.quipolarlight.render.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.theme.SkinnableView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0002TX\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0002deB'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010`\u001a\u00020\u001a\u00a2\u0006\u0004\ba\u0010bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R#\u0010/\u001a\n ,*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b\u001b\u0010.R\u001b\u00102\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b \u00101R#\u00105\u001a\n ,*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010.R\u0018\u00107\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010(R\u001b\u00109\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010\u001c\u001a\u0004\b*\u00101R\u001b\u0010<\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\u001c\u001a\u0004\b'\u0010;R\u001b\u0010?\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010\u001c\u001a\u0004\b>\u00101R\u0016\u0010B\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00108R\u0016\u0010\u0016\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00108R\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00108R\u0016\u0010O\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00108R\u001b\u0010S\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010\u001c\u001a\u0004\b-\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006f"}, d2 = {"Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView;", "Landroid/view/View;", "Lcom/tencent/theme/SkinnableView;", "", "progress", "", "setDragProgress", "r", "t", "p", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "onThemeChanged", "v", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "scale", "Landroid/graphics/Paint;", "g", "u", "", "d", "Lkotlin/Lazy;", "j", "()I", "maskSize", "e", "f", "circleSize", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "bmpDstRect", "Landroid/graphics/Bitmap;", h.F, "Landroid/graphics/Bitmap;", "bgBitmap", "i", "circleDstRect", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/graphics/Bitmap;", "circleBitmap", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/graphics/Paint;", "circlePaint", "D", "l", "originMaskBitmap", "E", "maskBitmap", UserInfo.SEX_FEMALE, "maskPaint", "G", "()Landroid/graphics/Rect;", "maskDstRect", "H", "k", "normalPaint", "I", "Z", "isPolarRendering", "J", "isAnimation", "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView$RefreshState;", "K", "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView$RefreshState;", "state", "L", "degrees", "M", "N", "lastDegrees", "P", "lastScale", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "polarImageRender", "com/tencent/biz/qui/dragrefresh/QUIDragRefreshView$c", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView$c;", "renderCallback", "com/tencent/biz/qui/dragrefresh/QUIDragRefreshView$b", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView$b;", "animationHandler", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "T", "a", "RefreshState", "QUIDragRefreshView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIDragRefreshView extends View implements SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy circlePaint;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy originMaskBitmap;

    /* renamed from: E, reason: from kotlin metadata */
    private Bitmap maskBitmap;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy maskPaint;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy maskDstRect;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy normalPaint;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isPolarRendering;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isAnimation;

    /* renamed from: K, reason: from kotlin metadata */
    private RefreshState state;

    /* renamed from: L, reason: from kotlin metadata */
    private float degrees;

    /* renamed from: M, reason: from kotlin metadata */
    private float scale;

    /* renamed from: N, reason: from kotlin metadata */
    private float lastDegrees;

    /* renamed from: P, reason: from kotlin metadata */
    private float lastScale;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy polarImageRender;

    /* renamed from: R, reason: from kotlin metadata */
    private final c renderCallback;

    /* renamed from: S, reason: from kotlin metadata */
    private final b animationHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy maskSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy circleSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Rect bmpDstRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Bitmap bgBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Rect circleDstRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy circleBitmap;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView$RefreshState;", "", "(Ljava/lang/String;I)V", "IDLE", "DRAG", "ROTATE", "QUIDragRefreshView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public enum RefreshState {
        IDLE,
        DRAG,
        ROTATE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qui/dragrefresh/QUIDragRefreshView$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "refreshViewRef", "QUIDragRefreshView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QUIDragRefreshView> refreshViewRef;

        b(Looper looper) {
            super(looper);
            this.refreshViewRef = new WeakReference<>(QUIDragRefreshView.this);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            QUIDragRefreshView qUIDragRefreshView;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1 && (qUIDragRefreshView = this.refreshViewRef.get()) != null) {
                qUIDragRefreshView.n();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qui/dragrefresh/QUIDragRefreshView$c", "Lcom/tencent/biz/qui/quipolarlight/render/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "errorMsg", "onFailed", "QUIDragRefreshView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class c implements d {
        c() {
        }

        @Override // com.tencent.biz.qui.quipolarlight.render.d
        public void onFailed(@Nullable String errorMsg) {
            if (ud0.d.h()) {
                ud0.d.a("QUIDragRefreshView", ud0.d.f438809c, "PolarImageRender onFailed " + errorMsg);
            }
        }

        @Override // com.tencent.biz.qui.quipolarlight.render.d
        public void onSuccess(@Nullable Bitmap bitmap) {
            QUIDragRefreshView.this.bgBitmap = bitmap;
        }
    }

    @JvmOverloads
    public QUIDragRefreshView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    private final Bitmap d() {
        return (Bitmap) this.circleBitmap.getValue();
    }

    private final Paint e() {
        return (Paint) this.circlePaint.getValue();
    }

    private final int f() {
        return ((Number) this.circleSize.getValue()).intValue();
    }

    private final Paint g(float scale) {
        Paint paint = new Paint(i());
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.0f, 1.0f, 1.0f, scale);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        return paint;
    }

    private final Rect h() {
        return (Rect) this.maskDstRect.getValue();
    }

    private final Paint i() {
        return (Paint) this.maskPaint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        return ((Number) this.maskSize.getValue()).intValue();
    }

    private final Paint k() {
        return (Paint) this.normalPaint.getValue();
    }

    private final Bitmap l() {
        return (Bitmap) this.originMaskBitmap.getValue();
    }

    private final PolarImageRender m() {
        return (PolarImageRender) this.polarImageRender.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (this.state == RefreshState.ROTATE) {
            this.degrees = (this.degrees + 24) % 360;
        }
        invalidate();
        this.animationHandler.sendEmptyMessageDelayed(1, 33L);
    }

    private final boolean o() {
        int i3 = a.f95083a[this.state.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2 && this.scale >= 0.05f) {
            return true;
        }
        return false;
    }

    private final void q() {
        if (!this.isPolarRendering) {
            this.isPolarRendering = true;
            m().u(this.renderCallback);
            ud0.d.a("QUIDragRefreshView", ud0.d.f438811e, "startPolarImageRender");
        }
    }

    private final void s() {
        if (this.isPolarRendering) {
            m().v();
            this.isPolarRendering = false;
            ud0.d.a("QUIDragRefreshView", ud0.d.f438811e, "stopPolarImageRender");
        }
    }

    private final void u() {
        if (this.maskBitmap != null && this.degrees == this.lastDegrees && this.scale == this.lastScale) {
            return;
        }
        System.currentTimeMillis();
        Bitmap createBitmap = Bitmap.createBitmap(j(), j(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (this.state == RefreshState.ROTATE) {
            float f16 = this.degrees;
            if (f16 != 0.0f) {
                canvas.rotate(f16, j() / 2.0f, j() / 2.0f);
            }
        }
        if (this.state == RefreshState.DRAG) {
            float f17 = this.scale;
            if (f17 != 1.0f) {
                canvas.scale(f17, f17, j() / 2.0f, j() / 2.0f);
            }
        }
        canvas.drawBitmap(l(), (Rect) null, h(), k());
        this.maskBitmap = createBitmap;
        this.lastDegrees = this.degrees;
        this.lastScale = this.scale;
    }

    private final void v() {
        boolean o16 = o();
        if (o16) {
            q();
        } else {
            s();
        }
        if (o16) {
            if (!this.isAnimation) {
                this.isAnimation = true;
                this.animationHandler.sendEmptyMessageDelayed(1, 33L);
                return;
            }
            return;
        }
        this.animationHandler.removeMessages(1);
        this.isAnimation = false;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (o()) {
            v();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        this.animationHandler.removeCallbacksAndMessages(null);
        this.isAnimation = false;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        System.currentTimeMillis();
        int min = Math.min(getWidth(), getHeight());
        this.bmpDstRect.set((getWidth() - min) / 2, (getHeight() - min) / 2, (getWidth() + min) / 2, (getHeight() + min) / 2);
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.bmpDstRect, k());
            }
            u();
            Bitmap bitmap2 = this.maskBitmap;
            if (bitmap2 != null) {
                if (this.state == RefreshState.DRAG) {
                    float f16 = this.scale;
                    if (f16 >= 0.0f && f16 <= 1.0f) {
                        canvas.drawBitmap(bitmap2, (Rect) null, this.bmpDstRect, g(f16));
                    }
                }
                canvas.drawBitmap(bitmap2, (Rect) null, this.bmpDstRect, i());
            }
        }
        float f17 = this.degrees;
        if (f17 != 0.0f) {
            canvas.rotate(f17, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        float f18 = this.scale;
        if (f18 != 1.0f) {
            canvas.scale(f18, f18, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        int f19 = (f() * min) / j();
        this.circleDstRect.set((getWidth() - f19) / 2, (getHeight() - f19) / 2, (getWidth() + f19) / 2, (getHeight() + f19) / 2);
        canvas.drawBitmap(d(), (Rect) null, this.circleDstRect, e());
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        e().setColorFilter(new LightingColorFilter(0, getResources().getColor(R.color.qui_common_bg_top_light, null)));
        postInvalidate();
    }

    public final void p() {
        this.state = RefreshState.IDLE;
        this.bgBitmap = null;
        this.degrees = 0.0f;
        this.scale = 1.0f;
        v();
    }

    public final void r() {
        this.state = RefreshState.ROTATE;
        this.degrees = 0.0f;
        this.scale = 1.0f;
        v();
    }

    public final void setDragProgress(float progress) {
        this.state = RefreshState.DRAG;
        this.degrees = 0.0f;
        this.scale = Math.min(progress, 1.0f);
        v();
    }

    public final void t() {
        this.state = RefreshState.IDLE;
        v();
    }

    @JvmOverloads
    public QUIDragRefreshView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ QUIDragRefreshView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIDragRefreshView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$maskSize$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.a(64);
            }
        });
        this.maskSize = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$circleSize$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.a(26);
            }
        });
        this.circleSize = lazy2;
        this.bmpDstRect = new Rect();
        this.circleDstRect = new Rect();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Bitmap>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$circleBitmap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bitmap invoke() {
                return BitmapFactory.decodeResource(QUIDragRefreshView.this.getResources(), R.drawable.ohv);
            }
        });
        this.circleBitmap = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$circlePaint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setFlags(6);
                paint.setColorFilter(new LightingColorFilter(0, QUIDragRefreshView.this.getResources().getColor(R.color.qui_common_bg_top_light, null)));
                return paint;
            }
        });
        this.circlePaint = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Bitmap>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$originMaskBitmap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bitmap invoke() {
                return BitmapFactory.decodeResource(QUIDragRefreshView.this.getResources(), R.drawable.ohw);
            }
        });
        this.originMaskBitmap = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$maskPaint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                return paint;
            }
        });
        this.maskPaint = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Rect>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$maskDstRect$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Rect invoke() {
                int j3;
                int j16;
                j3 = QUIDragRefreshView.this.j();
                j16 = QUIDragRefreshView.this.j();
                return new Rect(0, 0, j3, j16);
            }
        });
        this.maskDstRect = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$normalPaint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                return paint;
            }
        });
        this.normalPaint = lazy8;
        this.state = RefreshState.IDLE;
        this.scale = 1.0f;
        this.lastScale = 1.0f;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<PolarImageRender>() { // from class: com.tencent.biz.qui.dragrefresh.QUIDragRefreshView$polarImageRender$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PolarImageRender invoke() {
                PolarImageRender polarImageRender = new PolarImageRender();
                polarImageRender.t(PolarImageRender.RenderSize.SMALL);
                polarImageRender.o(30);
                polarImageRender.p(0.07f);
                polarImageRender.n(180.0f);
                polarImageRender.r(0.7f);
                return polarImageRender;
            }
        });
        this.polarImageRender = lazy9;
        this.renderCallback = new c();
        this.animationHandler = new b(Looper.getMainLooper());
        setLayerType(1, null);
    }
}
