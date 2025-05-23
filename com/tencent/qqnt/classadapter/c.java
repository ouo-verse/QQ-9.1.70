package com.tencent.qqnt.classadapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0016\u0018\u0000 52\u00020\u0001:\u0001\rB/\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002R\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010,R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/classadapter/c;", "", "", "g", "Landroid/graphics/Canvas;", PM.CANVAS, h.F, "", "repeat", "l", "", "k", DomainData.DOMAIN_NAME, "a", "I", "j", "()I", "width", "b", "i", "height", "", "c", "Ljava/lang/String;", "colorValue", "d", "Z", "isSingle", "()Z", "Landroid/view/View;", "e", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "f", "Landroid/graphics/Bitmap;", "mMaskBitmap", "mRightMaskBitmap", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "scanAnimator", "", UserInfo.SEX_FEMALE, "scanPosition", "isPlayEnd", "scannerWidth", "", "D", "scannerHeight", "<init>", "(IILjava/lang/String;ZLandroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final PorterDuffXfermode f355686n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final Paint f355687o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String colorValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSingle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mMaskBitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mRightMaskBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator scanAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float scanPosition;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayEnd;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int scannerWidth;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private double scannerHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/classadapter/c$a;", "", "", "TAG", "Ljava/lang/String;", "Landroid/graphics/PorterDuffXfermode;", "X_FER_MODE", "Landroid/graphics/PorterDuffXfermode;", "Landroid/graphics/Paint;", "markPaint", "Landroid/graphics/Paint;", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.classadapter.c$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/classadapter/c$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                c.this.g();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        f355686n = porterDuffXfermode;
        Paint paint = new Paint();
        paint.setXfermode(porterDuffXfermode);
        f355687o = paint;
    }

    public c(int i3, int i16, @NotNull String colorValue, boolean z16, @NotNull View view) {
        boolean z17;
        String str;
        Intrinsics.checkNotNullParameter(colorValue, "colorValue");
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), colorValue, Boolean.valueOf(z16), view);
            return;
        }
        this.width = i3;
        this.height = i16;
        this.colorValue = colorValue;
        this.isSingle = z16;
        this.view = view;
        int i17 = i16 * 3;
        this.scannerWidth = i17;
        double d16 = i16 * 1.5d;
        this.scannerHeight = d16;
        try {
            if (this.mMaskBitmap == null) {
                this.mMaskBitmap = Bitmap.createBitmap(i17, (int) d16, Bitmap.Config.ARGB_8888);
                if (!z16) {
                    this.mRightMaskBitmap = Bitmap.createBitmap(this.scannerWidth, (int) this.scannerHeight, Bitmap.Config.ARGB_8888);
                }
            }
            if (colorValue.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                str = colorValue.substring(1, colorValue.length());
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str = "FFFFCE";
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#00" + str), Color.parseColor("#88" + str), Color.parseColor(colorValue), Color.parseColor("#88" + str), Color.parseColor("#00" + str)});
            gradientDrawable.setShape(1);
            Bitmap bitmap = this.mMaskBitmap;
            if (bitmap != null) {
                gradientDrawable.setBounds(0, 0, this.scannerWidth, (int) this.scannerHeight);
                gradientDrawable.draw(new Canvas(bitmap));
            }
            Bitmap bitmap2 = this.mRightMaskBitmap;
            if (bitmap2 != null) {
                gradientDrawable.setBounds(0, 0, this.scannerWidth, (int) this.scannerHeight);
                gradientDrawable.draw(new Canvas(bitmap2));
            }
        } catch (Throwable th5) {
            QLog.e("FlashNickName", 1, "create bitmap error " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.isPlayEnd = true;
        ValueAnimator valueAnimator = this.scanAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.scanAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(c this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.scanPosition = ((Float) animatedValue).floatValue();
        this$0.view.invalidate();
    }

    public final void h(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.mMaskBitmap;
        if (bitmap != null) {
            float f16 = this.scanPosition;
            int i3 = this.width;
            float f17 = (f16 * (i3 + r3)) - this.scannerWidth;
            Paint paint = f355687o;
            canvas.drawBitmap(bitmap, f17, 0.0f, paint);
            Bitmap bitmap2 = this.mRightMaskBitmap;
            if (bitmap2 != null && !this.isSingle) {
                float f18 = 1.0f - this.scanPosition;
                int i16 = this.width;
                canvas.drawBitmap(bitmap2, (f18 * (i16 + r5)) - this.scannerWidth, 0.0f, paint);
            }
        }
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.height;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.width;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isPlayEnd;
    }

    public final void l(int repeat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, repeat);
            return;
        }
        if (this.scanAnimator == null) {
            this.scanPosition = 0.0f;
            this.isPlayEnd = false;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(1500L);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(repeat);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.classadapter.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.m(c.this, valueAnimator);
                }
            });
            ofFloat.addListener(new b());
            ofFloat.start();
            this.scanAnimator = ofFloat;
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.scanAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        g();
    }
}
