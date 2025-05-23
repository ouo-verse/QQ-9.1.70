package com.tencent.android.androidbypass.richui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.state.view.RoundRelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001\u0005B\u0013\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b5\u00106B\u001d\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109B%\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u0010:\u001a\u00020\u0007\u00a2\u0006\u0004\b5\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006="}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "b", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "l", "t", "r", "onLayout", "dispatchDraw", "Lcom/tencent/android/androidbypass/richui/view/k;", "perfCallback", "setPerfCallback", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "getMRoundPath", "()Landroid/graphics/Path;", "setMRoundPath", "(Landroid/graphics/Path;)V", "mRoundPath", "e", "I", "getMRadius", "()I", "setMRadius", "(I)V", "mRadius", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "paint", tl.h.F, "getMCorners", "setMCorners", "mCorners", "", "i", "[F", "radiusValue", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/android/androidbypass/richui/view/k;", "mPerfCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class RoundLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private static final int C;
    private static final int[] D;

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Path mRoundPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mRadius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Paint paint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCorners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float[] radiusValue;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private k mPerfCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout$a;", "", "", "CORNER_ALL", "I", "CORNER_EMPTY", "CORNER_LEFT_BOTTOM", "CORNER_LEFT_TOP", "CORNER_RIGHT_TOP", "CORNER_RITH_BOTTOM", "", "CORNORS", "[I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.richui.view.RoundLinearLayout$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        INSTANCE = new Companion(null);
        C = 15;
        D = new int[]{1, 2, 4, 8};
    }

    public RoundLinearLayout(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
            return;
        }
        this.mCorners = C;
        this.radiusValue = new float[8];
        b();
    }

    private final void a(Canvas canvas) {
        int length = this.radiusValue.length;
        for (int i3 = 0; i3 < length; i3++) {
            if ((D[i3 / 2] & this.mCorners) != 0) {
                this.radiusValue[i3] = this.mRadius;
            } else {
                this.radiusValue[i3] = 0.0f;
            }
        }
        Path path = this.mRoundPath;
        Intrinsics.checkNotNull(path);
        path.reset();
        Path path2 = this.mRoundPath;
        Intrinsics.checkNotNull(path2);
        path2.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.radiusValue, Path.Direction.CW);
        Path path3 = this.mRoundPath;
        Intrinsics.checkNotNull(path3);
        Paint paint = this.paint;
        Intrinsics.checkNotNull(paint);
        canvas.drawPath(path3, paint);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Path path = new Path();
        this.mRoundPath = path;
        Intrinsics.checkNotNull(path);
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.paint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.paint;
        Intrinsics.checkNotNull(paint2);
        paint2.setColor(0);
        Paint paint3 = this.paint;
        Intrinsics.checkNotNull(paint3);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRadius != 0 && this.mCorners != 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
            super.dispatchDraw(canvas);
            try {
                try {
                    a(canvas);
                } catch (Exception e16) {
                    com.tencent.android.androidbypass.config.a.f72049a.i(RoundRelativeLayout.TAG, "checkPathChanged" + Log.getStackTraceString(e16));
                }
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        } else {
            super.dispatchDraw(canvas);
        }
        k kVar = this.mPerfCallback;
        if (kVar != null) {
            kVar.a(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(changed), Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.onLayout(changed, l3, t16, r16, b16);
        k kVar = this.mPerfCallback;
        if (kVar != null) {
            kVar.b(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        k kVar = this.mPerfCallback;
        if (kVar != null) {
            kVar.c(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final void setMCorners(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mCorners = i3;
        }
    }

    public final void setMRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mRadius = i3;
        }
    }

    public final void setMRoundPath(@Nullable Path path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
        } else {
            this.mRoundPath = path;
        }
    }

    public final void setPerfCallback(@Nullable k perfCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) perfCallback);
        } else {
            this.mPerfCallback = perfCallback;
        }
    }

    public RoundLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mCorners = C;
        this.radiusValue = new float[8];
        b();
    }

    public RoundLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mCorners = C;
        this.radiusValue = new float[8];
        b();
    }
}
