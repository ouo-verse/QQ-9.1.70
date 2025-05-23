package com.tencent.mobileqq.qqlive.widget.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mobileqq.qqlive.widget.b;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ]2\u00020\u0001:\u0001^B\u001d\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u00a2\u0006\u0004\b[\u0010\\J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0014J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0010\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00107R\u0014\u0010;\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010\"R\u0014\u0010=\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010*R\u0016\u0010?\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00107R\u0016\u0010A\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00107R\u0016\u0010C\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010.R\u0014\u0010E\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010\"R\u0014\u0010G\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010*R\u0016\u0010I\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00107R\u0016\u0010K\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00107R\u0016\u0010M\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010.R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0018\u0010V\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/avatar/QQLiveAvatarImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "getBitmapFromDrawable", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "l", "o", "updateShaderMatrix", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "bm", "setImageBitmap", "setImageDrawable", "resId", "setImageResource", "color", "width", "setOuterBorder", "setInnerBorder", "", "url", "setImageUrl", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "drawableRect", "Landroid/graphics/Matrix;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Matrix;", "shaderMatrix", "Landroid/graphics/Paint;", "D", "Landroid/graphics/Paint;", "bitmapPaint", "", "E", UserInfo.SEX_FEMALE, "drawableRadius", "Landroid/graphics/Bitmap;", "currentBitmap", "Landroid/graphics/BitmapShader;", "G", "Landroid/graphics/BitmapShader;", "bitmapShader", "H", "I", "bitmapWidth", "bitmapHeight", "J", "outerBorderRect", "K", "outerBorderPaint", "L", "outerBorderColor", "M", "outerBorderWidth", "N", "outerBorderRadius", "P", "innerBorderRect", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "innerBorderPaint", BdhLogUtil.LogTag.Tag_Req, "innerBorderColor", ExifInterface.LATITUDE_SOUTH, "innerBorderWidth", "T", "innerBorderRadius", "", "U", "Z", "isReady", "V", "isSetupPending", "W", "Ljava/lang/String;", "currentAvatarUrl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a0", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAvatarImageView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f273496b0;

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final Bitmap.Config f273497c0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Matrix shaderMatrix;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Paint bitmapPaint;

    /* renamed from: E, reason: from kotlin metadata */
    private float drawableRadius;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Bitmap currentBitmap;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private BitmapShader bitmapShader;

    /* renamed from: H, reason: from kotlin metadata */
    private int bitmapWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private int bitmapHeight;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final RectF outerBorderRect;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Paint outerBorderPaint;

    /* renamed from: L, reason: from kotlin metadata */
    private int outerBorderColor;

    /* renamed from: M, reason: from kotlin metadata */
    private int outerBorderWidth;

    /* renamed from: N, reason: from kotlin metadata */
    private float outerBorderRadius;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final RectF innerBorderRect;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Paint innerBorderPaint;

    /* renamed from: R, reason: from kotlin metadata */
    private int innerBorderColor;

    /* renamed from: S, reason: from kotlin metadata */
    private int innerBorderWidth;

    /* renamed from: T, reason: from kotlin metadata */
    private float innerBorderRadius;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isReady;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isSetupPending;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private String currentAvatarUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF drawableRect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/avatar/QQLiveAvatarImageView$a;", "", "Landroid/graphics/Bitmap$Config;", "BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "", "COLORDRAWABLE_DIMENSION", "I", "DEFAULT_AVATAR_SIZE", "DEFAULT_BORDER_COLOR", "DEFAULT_BORDER_WIDTH", "Landroid/widget/ImageView$ScaleType;", "SCALE_TYPE", "Landroid/widget/ImageView$ScaleType;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.avatar.QQLiveAvatarImageView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20954);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        f273496b0 = ImageView.ScaleType.CENTER_CROP;
        f273497c0 = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveAvatarImageView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
    }

    private final Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof ColorDrawable) && drawable.getIntrinsicWidth() >= 0 && drawable.getIntrinsicHeight() >= 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f273497c0);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n                Bitmap\u2026MAP_CONFIG)\n            }");
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            bitmap = createBitmap;
            return bitmap;
        }
        createBitmap = Bitmap.createBitmap(1, 1, f273497c0);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n                Bitmap\u2026MAP_CONFIG)\n            }");
        Canvas canvas2 = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
        drawable.draw(canvas2);
        bitmap = createBitmap;
        return bitmap;
    }

    private final void l() {
        if (this.outerBorderWidth > 0 && this.innerBorderWidth > 0) {
            this.innerBorderPaint.setStyle(Paint.Style.STROKE);
            this.innerBorderPaint.setAntiAlias(true);
            this.innerBorderPaint.setColor(this.innerBorderColor);
            this.innerBorderPaint.setStrokeWidth(this.innerBorderWidth);
            float f16 = this.outerBorderWidth - this.innerBorderWidth;
            this.innerBorderRect.set(f16, f16, this.outerBorderRect.width() - f16, this.outerBorderRect.height() - f16);
            float f17 = 2;
            this.innerBorderRadius = Math.min((this.innerBorderRect.height() - this.innerBorderWidth) / f17, (this.innerBorderRect.width() - this.innerBorderWidth) / f17);
        }
    }

    private final void m() {
        if (!this.isReady) {
            this.isSetupPending = true;
            return;
        }
        if (this.currentBitmap == null) {
            return;
        }
        p();
        l();
        o();
        updateShaderMatrix();
        invalidate();
    }

    private final void o() {
        int i3;
        Bitmap bitmap = this.currentBitmap;
        Intrinsics.checkNotNull(bitmap);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.bitmapPaint.setAntiAlias(true);
        this.bitmapPaint.setShader(this.bitmapShader);
        Bitmap bitmap2 = this.currentBitmap;
        int i16 = 0;
        if (bitmap2 != null) {
            i3 = bitmap2.getHeight();
        } else {
            i3 = 0;
        }
        this.bitmapHeight = i3;
        Bitmap bitmap3 = this.currentBitmap;
        if (bitmap3 != null) {
            i16 = bitmap3.getWidth();
        }
        this.bitmapWidth = i16;
        RectF rectF = this.drawableRect;
        int i17 = this.outerBorderWidth;
        rectF.set(i17, i17, getWidth() - this.outerBorderWidth, getHeight() - this.outerBorderWidth);
        float f16 = 2;
        this.drawableRadius = Math.min(this.drawableRect.height() / f16, this.drawableRect.width() / f16);
    }

    private final void p() {
        if (this.outerBorderWidth > 0) {
            this.outerBorderPaint.setStyle(Paint.Style.STROKE);
            this.outerBorderPaint.setAntiAlias(true);
            this.outerBorderPaint.setColor(this.outerBorderColor);
            this.outerBorderPaint.setStrokeWidth(this.outerBorderWidth);
            this.outerBorderRect.set(0.0f, 0.0f, getWidth(), getHeight());
            float f16 = 2;
            this.outerBorderRadius = Math.min((this.outerBorderRect.height() - this.outerBorderWidth) / f16, (this.outerBorderRect.width() - this.outerBorderWidth) / f16);
        }
    }

    private final void updateShaderMatrix() {
        float width;
        float height;
        this.shaderMatrix.set(null);
        float f16 = 0.0f;
        if (this.bitmapWidth * this.drawableRect.height() > this.drawableRect.width() * this.bitmapHeight) {
            width = this.drawableRect.height() / this.bitmapHeight;
            height = 0.0f;
            f16 = (this.drawableRect.width() - (this.bitmapWidth * width)) * 0.5f;
        } else {
            width = this.drawableRect.width() / this.bitmapWidth;
            height = (this.drawableRect.height() - (this.bitmapHeight * width)) * 0.5f;
        }
        this.shaderMatrix.setScale(width, width);
        Matrix matrix = this.shaderMatrix;
        int i3 = this.outerBorderWidth;
        matrix.postTranslate(((int) (f16 + 0.5f)) + i3, ((int) (height + 0.5f)) + i3);
        BitmapShader bitmapShader = this.bitmapShader;
        if (bitmapShader != null) {
            bitmapShader.setLocalMatrix(this.shaderMatrix);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.drawableRadius, this.bitmapPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.outerBorderRadius, this.outerBorderPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.innerBorderRadius, this.innerBorderPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
        } else {
            super.onSizeChanged(w3, h16, oldw, oldh);
            m();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(@NotNull Bitmap bm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bm5);
            return;
        }
        Intrinsics.checkNotNullParameter(bm5, "bm");
        super.setImageBitmap(bm5);
        this.currentBitmap = bm5;
        m();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
            return;
        }
        super.setImageDrawable(drawable);
        this.currentBitmap = getBitmapFromDrawable(drawable);
        m();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, resId);
            return;
        }
        super.setImageResource(resId);
        this.currentBitmap = getBitmapFromDrawable(getDrawable());
        m();
    }

    public final void setImageUrl(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) url);
            return;
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        boolean z16 = false;
        if (url != null && url.equals(this.currentAvatarUrl)) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.currentAvatarUrl = url;
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(q.a(getContext(), 80.0f)).setRequestHeight(q.a(getContext(), 80.0f)).setLoadingDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ovu)).setFailDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ovu)).setTargetView(this).setUrl(url));
    }

    public final void setInnerBorder(int color, int width) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(color), Integer.valueOf(width));
            return;
        }
        this.innerBorderColor = color;
        this.innerBorderWidth = width;
        m();
    }

    public final void setOuterBorder(int color, int width) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(color), Integer.valueOf(width));
            return;
        }
        this.outerBorderColor = color;
        this.outerBorderWidth = width;
        m();
    }

    public /* synthetic */ QQLiveAvatarImageView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveAvatarImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.drawableRect = new RectF();
        this.shaderMatrix = new Matrix();
        this.bitmapPaint = new Paint();
        this.outerBorderRect = new RectF();
        this.outerBorderPaint = new Paint();
        this.innerBorderRect = new RectF();
        this.innerBorderPaint = new Paint();
        super.setScaleType(f273496b0);
        this.isReady = true;
        if (this.isSetupPending) {
            m();
            this.isSetupPending = false;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.X3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026le.QQLiveAvatarImageView)");
        this.outerBorderWidth = obtainStyledAttributes.getDimensionPixelSize(b.f273519b4, 0);
        this.outerBorderColor = obtainStyledAttributes.getColor(b.f273511a4, 0);
        this.innerBorderWidth = obtainStyledAttributes.getDimensionPixelSize(b.Z3, 0);
        this.innerBorderColor = obtainStyledAttributes.getColor(b.Y3, 0);
        obtainStyledAttributes.recycle();
    }
}
