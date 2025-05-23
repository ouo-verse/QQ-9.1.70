package com.tencent.android.androidbypass.enhance.drawable.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.android.androidbypass.codeblock.utils.e;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/image/LoadFailedDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "context", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "d", "c", "b", "draw", "", c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "Lkotlin/Lazy;", "e", "()Landroid/graphics/Paint;", "paint", "Lcom/tencent/android/androidbypass/enhance/drawable/image/a;", "Lcom/tencent/android/androidbypass/enhance/drawable/image/a;", "mLoadFailedParam", "<init>", "(Lcom/tencent/android/androidbypass/enhance/drawable/image/a;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class LoadFailedDrawable extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy paint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a mLoadFailedParam;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/image/LoadFailedDrawable$a;", "", "", "BACKGROUND_RADIUS_DP", UserInfo.SEX_FEMALE, "FONT_SIZE_SP", "LIMIT_SIZE_PIC_ELEMENT_DP", "LIMIT_SIZE_TEXT_ELEMENT_DP", "PIC_AND_TEXT_DISTANCE_DP", "PIC_SIZE_DP", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.drawable.image.LoadFailedDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16876);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LoadFailedDrawable(@NotNull a mLoadFailedParam) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mLoadFailedParam, "mLoadFailedParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mLoadFailedParam);
            return;
        }
        this.mLoadFailedParam = mLoadFailedParam;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) LoadFailedDrawable$paint$2.INSTANCE);
        this.paint = lazy;
    }

    private final void a(Context context, Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        e().setColor(this.mLoadFailedParam.d());
        float b16 = e.f72044a.b(context, 4.0f);
        canvas.drawRoundRect(rectF, b16, b16, e());
    }

    private final void b(Context context, Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        float b16 = e.f72044a.b(context, 28.0f);
        if (b16 < rectF.width() && b16 < rectF.height()) {
            float f16 = 2;
            float width = rectF.left + ((rectF.width() - b16) / f16);
            float height = rectF.top + ((rectF.height() - b16) / f16);
            this.mLoadFailedParam.b().setBounds((int) width, (int) height, (int) (width + b16), (int) (height + b16));
            this.mLoadFailedParam.b().draw(canvas);
        }
    }

    private final void c(Context context, Canvas canvas) {
        e eVar = e.f72044a;
        float b16 = eVar.b(context, 28.0f);
        float b17 = eVar.b(context, 4.0f);
        Rect rect = new Rect();
        e().setTextSize(eVar.d(context, 12.0f));
        String string = context.getString(R.string.f1627921d);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.load_image_failed_tips)");
        e().getTextBounds(string, 0, string.length(), rect);
        float height = 0.0f + b16 + b17 + rect.height();
        RectF rectF = new RectF(getBounds());
        if (height < rectF.height() && b16 < rectF.width() && rect.width() < rectF.width()) {
            float f16 = 2;
            float width = rectF.left + ((rectF.width() - b16) / f16);
            float height2 = rectF.top + ((rectF.height() - height) / f16);
            float f17 = height2 + b16;
            this.mLoadFailedParam.b().setBounds((int) width, (int) height2, (int) (width + b16), (int) f17);
            this.mLoadFailedParam.b().draw(canvas);
            e().setColor(this.mLoadFailedParam.c());
            canvas.drawText(string, rectF.left + ((rectF.width() - rect.width()) / f16), (f17 + b17) - e().getFontMetricsInt().ascent, e());
        }
    }

    private final void d(Context context, Canvas canvas) {
        boolean z16;
        RectF rectF = new RectF(getBounds());
        e eVar = e.f72044a;
        float b16 = eVar.b(context, 45.0f);
        boolean z17 = true;
        if (rectF.width() >= b16 && rectF.height() >= b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        float b17 = eVar.b(context, 60.0f);
        if (rectF.width() < b17 || rectF.height() < b17) {
            z17 = false;
        }
        if (z17) {
            c(context, canvas);
        } else {
            b(context, canvas);
        }
    }

    private final Paint e() {
        return (Paint) this.paint.getValue();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Context context = this.mLoadFailedParam.a().get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "mLoadFailedParam.contextRef.get() ?: return");
            canvas.save();
            a(context, canvas);
            d(context, canvas);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) colorFilter);
        }
    }
}
