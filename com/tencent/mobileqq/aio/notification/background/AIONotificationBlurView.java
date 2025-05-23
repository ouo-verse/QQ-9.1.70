package com.tencent.mobileqq.aio.notification.background;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qui.quiblurview.QQBlurView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B\u001d\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001b\u0010\u001c\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u001b\u0010\u001e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u001b\u0010\"\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u0015\u0010!R*\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010.\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R*\u00102\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/background/AIONotificationBlurView;", "Lcom/tencent/qui/quiblurview/QQBlurView;", "", "H", "", "color", "setBlurBackgroundColor", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "D", "()Landroid/graphics/Paint;", "backgroundPaint", "G", "E", "edgePaint", "B", "animEdgePaint", "I", BdhLogUtil.LogTag.Tag_Conn, "animPaint", "J", "roundRectPaint", "Landroid/graphics/Path;", "K", "()Landroid/graphics/Path;", "roundRectPath", "", "value", "L", "getEdgeHeight", "()F", "setEdgeHeight", "(F)V", "edgeHeight", "M", "getAnimAlphaHeight", "setAnimAlphaHeight", "animAlphaHeight", "N", "getAnimAlpha", "setAnimAlpha", "animAlpha", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "P", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationBlurView extends QQBlurView {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final float[] Q;

    @NotNull
    private static final int[] R;
    private static final int S;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy backgroundPaint;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy edgePaint;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy animEdgePaint;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy animPaint;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy roundRectPaint;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy roundRectPath;

    /* renamed from: L, reason: from kotlin metadata */
    private float edgeHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private float animAlphaHeight;

    /* renamed from: N, reason: from kotlin metadata */
    private float animAlpha;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/background/AIONotificationBlurView$a;", "", "", "GRADIENT_COLOR", "[I", "", "GRADIENT_POSITION", "[F", "", "ROUND_RADIUS", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.background.AIONotificationBlurView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        Q = new float[]{0.0f, 1.0f};
        R = new int[]{-1, 0};
        S = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIONotificationBlurView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
    }

    private final Paint B() {
        return (Paint) this.animEdgePaint.getValue();
    }

    private final Paint C() {
        return (Paint) this.animPaint.getValue();
    }

    private final Paint D() {
        return (Paint) this.backgroundPaint.getValue();
    }

    private final Paint E() {
        return (Paint) this.edgePaint.getValue();
    }

    private final Paint F() {
        return (Paint) this.roundRectPaint.getValue();
    }

    private final Path G() {
        return (Path) this.roundRectPath.getValue();
    }

    private final void H() {
        Paint E = E();
        float f16 = this.edgeHeight;
        int[] iArr = R;
        float[] fArr = Q;
        E.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f16, iArr, fArr, Shader.TileMode.CLAMP));
        G().reset();
        Paint B = B();
        float f17 = this.animAlphaHeight;
        B.setShader(new LinearGradient(0.0f, f17, 0.0f, f17 + this.edgeHeight, iArr, fArr, Shader.TileMode.CLAMP));
        float b16 = l.b(S);
        G().addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), new float[]{0.0f, 0.0f, 0.0f, 0.0f, b16, b16, b16, b16}, Path.Direction.CW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qui.quiblurview.QQBlurView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), D());
        super.onDraw(canvas);
        if (this.edgeHeight > 0.0f) {
            int save = canvas.save();
            canvas.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.edgeHeight, E());
            canvas.restoreToCount(save);
        } else {
            canvas.drawPath(G(), F());
        }
        if (this.animAlphaHeight > 0.0f) {
            int save2 = canvas.save();
            canvas.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            float f16 = 1;
            float f17 = 255;
            C().setColor(Color.argb((int) ((f16 - this.animAlpha) * f17), 255, 255, 255));
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.animAlphaHeight, C());
            canvas.restoreToCount(save2);
            B().setAlpha((int) ((f16 - this.animAlpha) * f17));
            int save3 = canvas.save();
            canvas.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            canvas.drawRect(0.0f, this.animAlphaHeight, getWidth(), this.edgeHeight + this.animAlphaHeight, B());
            canvas.restoreToCount(save3);
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
        } else {
            super.onSizeChanged(w3, h16, oldw, oldh);
            H();
        }
    }

    public final void setAnimAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.animAlpha = f16;
            invalidate();
        }
    }

    public final void setAnimAlphaHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.animAlphaHeight = f16;
            invalidate();
        }
    }

    public final void setBlurBackgroundColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, color);
        } else {
            D().setColor(color);
        }
    }

    public final void setEdgeHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.edgeHeight = f16;
            invalidate();
        }
    }

    public /* synthetic */ AIONotificationBlurView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIONotificationBlurView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(AIONotificationBlurView$backgroundPaint$2.INSTANCE);
        this.backgroundPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIONotificationBlurView$edgePaint$2.INSTANCE);
        this.edgePaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIONotificationBlurView$animEdgePaint$2.INSTANCE);
        this.animEdgePaint = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIONotificationBlurView$animPaint$2.INSTANCE);
        this.animPaint = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIONotificationBlurView$roundRectPaint$2.INSTANCE);
        this.roundRectPaint = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(AIONotificationBlurView$roundRectPath$2.INSTANCE);
        this.roundRectPath = lazy6;
        this.animAlpha = 1.0f;
    }
}
