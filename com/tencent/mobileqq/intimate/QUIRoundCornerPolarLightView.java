package com.tencent.mobileqq.intimate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.intimate.QUIRoundCornerPolarLightView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001c\u0018\u0000 \u001a2\u00020\u0001:\u00010B\u0019\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B!\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020\u0019\u00a2\u0006\u0004\b,\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0015J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "init", "", "radius", "setRadius", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "stopAnimation", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "D", "Landroid/graphics/RectF;", "rec", "E", UserInfo.SEX_FEMALE, "", "I", "bgColor", "com/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView$b", "G", "Lcom/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView$b;", "polarRenderCallback", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "H", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "l", "()Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "setPolarLightRender", "(Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;)V", "polarLightRender", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QUIRoundCornerPolarLightView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Path path;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private RectF rec;

    /* renamed from: E, reason: from kotlin metadata */
    private float radius;

    /* renamed from: F, reason: from kotlin metadata */
    private int bgColor;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private b polarRenderCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private PolarImageRender polarLightRender;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.intimate.QUIRoundCornerPolarLightView$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView$b", "Lcom/tencent/biz/qui/quipolarlight/render/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "errorMsg", "onFailed", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.biz.qui.quipolarlight.render.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIRoundCornerPolarLightView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QUIRoundCornerPolarLightView this$0, Bitmap it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0.setImageBitmap(it);
            this$0.invalidate();
        }

        @Override // com.tencent.biz.qui.quipolarlight.render.d
        public void onFailed(@Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorMsg);
                return;
            }
            QLog.e("QUIRoundCornerPolarLightView", 1, "polar light render failed: " + errorMsg);
        }

        @Override // com.tencent.biz.qui.quipolarlight.render.d
        public void onSuccess(@Nullable final Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
                return;
            }
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                if (bitmap != null) {
                    final QUIRoundCornerPolarLightView qUIRoundCornerPolarLightView = QUIRoundCornerPolarLightView.this;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.intimate.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            QUIRoundCornerPolarLightView.b.b(QUIRoundCornerPolarLightView.this, bitmap);
                        }
                    });
                    return;
                }
                return;
            }
            if (bitmap != null) {
                QUIRoundCornerPolarLightView qUIRoundCornerPolarLightView2 = QUIRoundCornerPolarLightView.this;
                qUIRoundCornerPolarLightView2.setImageBitmap(bitmap);
                qUIRoundCornerPolarLightView2.invalidate();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIRoundCornerPolarLightView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attrs);
            return;
        }
        this.paint = new Paint();
        this.path = new Path();
        this.rec = new RectF();
        this.bgColor = 16777215;
        this.polarRenderCallback = new b();
        this.polarLightRender = new PolarImageRender();
        init();
    }

    public final void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setColor(this.bgColor);
        this.path = new Path();
        this.rec = new RectF();
    }

    @NotNull
    public final PolarImageRender l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PolarImageRender) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.polarLightRender;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.polarLightRender.u(this.polarRenderCallback);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        this.path.reset();
        this.rec.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.path;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f16 = this.radius;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        if (canvas != null) {
            canvas.clipPath(this.path);
        }
        if (canvas != null) {
            canvas.drawRect(this.rec, this.paint);
        }
        super.onDraw(canvas);
    }

    public final void setPolarLightRender(@NotNull PolarImageRender polarImageRender) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) polarImageRender);
        } else {
            Intrinsics.checkNotNullParameter(polarImageRender, "<set-?>");
            this.polarLightRender = polarImageRender;
        }
    }

    public final void setRadius(float radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(radius));
        } else {
            this.radius = radius;
            invalidate();
        }
    }

    public final void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.polarLightRender.v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIRoundCornerPolarLightView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attrs, Integer.valueOf(i3));
            return;
        }
        this.paint = new Paint();
        this.path = new Path();
        this.rec = new RectF();
        this.bgColor = 16777215;
        this.polarRenderCallback = new b();
        this.polarLightRender = new PolarImageRender();
        init();
    }
}
