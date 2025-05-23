package com.tencent.timi.game.live.impl.danmuku.ktv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayView;
import com.tencent.timi.game.utils.l;
import fh4.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import li4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0002FGB'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u001e\u00a2\u0006\u0004\bC\u0010DJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010&\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001cR\u0016\u0010(\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010*R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006H"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "Landroid/view/View;", "Landroid/graphics/Paint;", "", h.F, "i", "j", "g", "k", "Lli4/a$a;", "controller", "setKtvPlayController", "", "ktv", "f", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "Lli4/a$a;", "ktvPlayController", "Landroid/graphics/PorterDuffXfermode;", "e", "Landroid/graphics/PorterDuffXfermode;", "srcInXfermode", "Ljava/lang/String;", "ktvStr", "", UserInfo.SEX_FEMALE, "progress", "", "I", "accentColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "outlineColor", BdhLogUtil.LogTag.Tag_Conn, "ktvFontColor", "D", "fontSize", "E", "fontWidth", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "accentRectF", "G", "Landroid/graphics/Paint;", "paint", "Landroid/animation/ValueAnimator;", "H", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animatorUpdateListener", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView$a;", "J", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView$a;", "animatorListenerAdapter", "", "K", "Z", "isAnimating", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class KtvPlayView extends View {
    private static final Typeface M = Typeface.DEFAULT_BOLD;

    /* renamed from: C, reason: from kotlin metadata */
    private int ktvFontColor;

    /* renamed from: D, reason: from kotlin metadata */
    private float fontSize;

    /* renamed from: E, reason: from kotlin metadata */
    private float fontWidth;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RectF accentRectF;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ValueAnimator animator;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ValueAnimator.AnimatorUpdateListener animatorUpdateListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a animatorListenerAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isAnimating;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.InterfaceC10727a ktvPlayController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PorterDuffXfermode srcInXfermode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ktvStr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int accentColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int outlineColor;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView$a;", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "d", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "ktvPlayView", "<init>", "(Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final KtvPlayView ktvPlayView;

        public a(@NotNull KtvPlayView ktvPlayView) {
            Intrinsics.checkNotNullParameter(ktvPlayView, "ktvPlayView");
            this.ktvPlayView = ktvPlayView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.ktvPlayView.progress = -1.0f;
            this.ktvPlayView.invalidate();
            this.ktvPlayView.isAnimating = false;
            a.InterfaceC10727a interfaceC10727a = this.ktvPlayView.ktvPlayController;
            if (interfaceC10727a != null) {
                interfaceC10727a.onPlayEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
            this.ktvPlayView.isAnimating = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public KtvPlayView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(KtvPlayView this$0, ValueAnimator valueAnimator) {
        Float f16;
        float f17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (valueAnimator == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f16 = (Float) animatedValue;
        } else {
            f16 = null;
        }
        if (f16 != null) {
            f17 = f16.floatValue();
        } else {
            f17 = 0.0f;
        }
        this$0.progress = f17;
        this$0.invalidate();
    }

    private final void g(Paint paint) {
        h(paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(this.accentColor);
        paint.setXfermode(this.srcInXfermode);
        paint.setTypeface(M);
        paint.setFakeBoldText(true);
    }

    private final void h(Paint paint) {
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setXfermode(null);
        paint.setFakeBoldText(false);
        paint.setTypeface(Typeface.DEFAULT);
    }

    private final void i(Paint paint) {
        h(paint);
        paint.setColor(this.ktvFontColor);
        paint.setTextSize(this.fontSize);
        paint.setStyle(Paint.Style.FILL);
        paint.setFakeBoldText(true);
        paint.setTypeface(M);
    }

    private final void j(Paint paint) {
        h(paint);
        paint.setColor(this.outlineColor);
        paint.setTextSize(this.fontSize);
        paint.setStrokeWidth(1.0f);
        paint.setTypeface(M);
        paint.setFakeBoldText(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    private final void k() {
        this.animator.removeAllListeners();
        this.animator.removeAllUpdateListeners();
        this.animator.cancel();
        this.animator.setFloatValues(0.0f, 1.0f);
        this.animator.setDuration(7000L);
        this.animator.addUpdateListener(this.animatorUpdateListener);
        this.animator.addListener(this.animatorListenerAdapter);
        this.animator.start();
    }

    public final void f(@NotNull String ktv) {
        Intrinsics.checkNotNullParameter(ktv, "ktv");
        l.b("KtvPlayView", "ktv: " + ktv);
        this.ktvStr = ktv;
        i(this.paint);
        this.fontWidth = this.paint.measureText(ktv);
        k();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        boolean z16;
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        if (this.progress == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        i(this.paint);
        float width = (getWidth() - this.fontWidth) / 2.0f;
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        float f16 = fontMetrics.bottom - fontMetrics.top;
        canvas.translate(width, (getHeight() - f16) / 2.0f);
        canvas.drawText(this.ktvStr, 0.0f, -fontMetrics.top, this.paint);
        j(this.paint);
        canvas.drawText(this.ktvStr, 0.0f, -fontMetrics.top, this.paint);
        g(this.paint);
        RectF rectF = this.accentRectF;
        rectF.set(0.0f, 0.0f, this.fontWidth * this.progress, f16);
        canvas.drawRect(rectF, this.paint);
        canvas.restoreToCount(saveLayer);
    }

    public final void setKtvPlayController(@NotNull a.InterfaceC10727a controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.ktvPlayController = controller;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public KtvPlayView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ KtvPlayView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public KtvPlayView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.srcInXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.ktvStr = "";
        this.progress = -1.0f;
        this.accentColor = Color.parseColor("#33BBFA");
        this.outlineColor = -16777216;
        this.ktvFontColor = -1;
        this.fontSize = b.d(12);
        this.accentRectF = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        this.paint = paint;
        this.animator = new ValueAnimator();
        this.animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: li4.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                KtvPlayView.e(KtvPlayView.this, valueAnimator);
            }
        };
        this.animatorListenerAdapter = new a(this);
    }
}
