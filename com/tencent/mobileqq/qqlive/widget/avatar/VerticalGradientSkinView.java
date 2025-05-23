package com.tencent.mobileqq.qqlive.widget.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001MB'\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\b\b\u0002\u0010I\u001a\u00020\u0004\u00a2\u0006\u0004\bJ\u0010KJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\tJ(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0014J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010>\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00107R\u0016\u0010A\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00107R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/avatar/VerticalGradientSkinView;", "Landroid/view/View;", "", "url", "", "requestWidth", "requestHeight", "", "b", "", "shouldShow", "c", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "d", "imageUrl", "setImageUrl", "isShapeImage", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "imgDrawable", "Landroid/graphics/RectF;", "f", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "Landroid/graphics/Path;", "Landroid/graphics/Path;", "path", "", "i", "[F", "radiusList", "Landroid/graphics/LinearGradient;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "Landroid/graphics/PorterDuffXfermode;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/PorterDuffXfermode;", "dstInXfermode", "D", "I", "_imageExceptWidth", "E", "_imageExceptHeight", UserInfo.SEX_FEMALE, "_shapeImageExceptHeight", "G", "_radius", "H", "imageWidth", "imageHeight", "J", "Z", "shouldShowRadius", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VerticalGradientSkinView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final PorterDuffXfermode dstInXfermode;

    /* renamed from: D, reason: from kotlin metadata */
    private final int _imageExceptWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private final int _imageExceptHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private final int _shapeImageExceptHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private final int _radius;

    /* renamed from: H, reason: from kotlin metadata */
    private int imageWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private int imageHeight;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean shouldShowRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable imgDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF rect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] radiusList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient linearGradient;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/avatar/VerticalGradientSkinView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.avatar.VerticalGradientSkinView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/avatar/VerticalGradientSkinView$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends QCirclePicStateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerticalGradientSkinView.this);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) option);
            } else {
                super.onStateChange(state, option);
                VerticalGradientSkinView.this.d(state, option);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalGradientSkinView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) ctx);
    }

    private final void b(String url, int requestWidth, int requestHeight) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(requestWidth).setRequestHeight(requestHeight).setUrl(url), new b());
    }

    private final void c(boolean shouldShow) {
        this.shouldShowRadius = shouldShow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(LoadState state, Option option) {
        Bitmap bitmap;
        if (state == LoadState.STATE_SUCCESS) {
            Bitmap.Config config = null;
            if (option != null) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                Bitmap resultBitMap = option.getResultBitMap();
                if (resultBitMap != null) {
                    config = resultBitMap.getConfig();
                }
                if (config != null) {
                    this.imageWidth = option.getResultBitMap().getWidth();
                    this.imageHeight = option.getResultBitMap().getHeight();
                    this.imgDrawable = new BitmapDrawable(getContext().getResources(), option.getResultBitMap());
                    invalidate();
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (canvas != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            if (this.shouldShowRadius) {
                this.path.reset();
                this.path.addRoundRect(this.rect, this.radiusList, Path.Direction.CW);
                this.path.close();
                canvas.clipPath(this.path);
            }
            Drawable drawable = this.imgDrawable;
            if (drawable != null) {
                drawable.getBounds().set(0, 0, getWidth(), (this.imageHeight * getWidth()) / this.imageWidth);
                drawable.draw(canvas);
            }
            this.paint.setShader(this.linearGradient);
            this.paint.setXfermode(this.dstInXfermode);
            canvas.drawRect(this.rect, this.paint);
            this.paint.setShader(null);
            this.paint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.linearGradient = new LinearGradient(0.0f, getHeight() - q.a(getContext(), 80.0f), 0.0f, getHeight(), Color.parseColor("#FFFFFF"), Color.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public final void setImageUrl(@Nullable String imageUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            setImageUrl(imageUrl, false);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageUrl);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalGradientSkinView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) ctx, (Object) attributeSet);
    }

    public final void setImageUrl(@Nullable String imageUrl, boolean isShapeImage) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, imageUrl, Boolean.valueOf(isShapeImage));
            return;
        }
        if (imageUrl == null || imageUrl.length() == 0) {
            QLog.w("VerticalGradientImageView", 1, "setImageUrl, imageUrl is empty");
            this.imgDrawable = null;
            invalidate();
            return;
        }
        int i16 = this._imageExceptWidth;
        if (isShapeImage) {
            i3 = this._shapeImageExceptHeight;
        } else {
            i3 = this._imageExceptHeight;
        }
        QLog.i("VerticalGradientImageView", 1, "setImageUrl, imageUrl:" + imageUrl + ", exceptWidth:" + i16 + ", exceptHeight:" + i3 + ", isShapeImage:" + isShapeImage + '.');
        c(isShapeImage ^ true);
        b(imageUrl, i16, i3);
    }

    public /* synthetic */ VerticalGradientSkinView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalGradientSkinView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ctx, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.paint = new Paint();
        this.rect = new RectF();
        this.path = new Path();
        this.radiusList = new float[8];
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        int a16 = q.a(getContext(), 375.0f);
        this._imageExceptWidth = a16;
        int a17 = q.a(getContext(), 176.0f);
        this._imageExceptHeight = a17;
        this._shapeImageExceptHeight = q.a(getContext(), 236.0f);
        int a18 = q.a(getContext(), 8.0f);
        this._radius = a18;
        this.imageWidth = a16;
        this.imageHeight = a17;
        Arrays.fill(this.radiusList, 0, 4, a18);
        Arrays.fill(this.radiusList, 4, 8, 0.0f);
    }
}
