package cooperation.vip.qqbanner.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class NakedEyesView extends RelativeLayout {
    private int C;
    private int D;
    private int E;
    private Drawable F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f391356d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f391357e;

    /* renamed from: f, reason: collision with root package name */
    private SensorLayout f391358f;

    /* renamed from: h, reason: collision with root package name */
    private SensorLayout f391359h;

    /* renamed from: i, reason: collision with root package name */
    private View f391360i;

    /* renamed from: m, reason: collision with root package name */
    private int f391361m;

    public NakedEyesView(Context context) {
        this(context, null);
    }

    private int c(Drawable drawable) {
        int i3;
        if (drawable == null) {
            return -1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        QLog.i("NakedEyesView", 2, "getDrawableHeight contentViewHeight:" + this.f391361m + " height:" + intrinsicHeight);
        if (intrinsicHeight == -1 && (i3 = this.f391361m) != 0) {
            intrinsicHeight = i3;
        }
        int i16 = this.D;
        if (intrinsicHeight > i16) {
            return i16;
        }
        return intrinsicHeight;
    }

    private int d(Drawable drawable) {
        int i3;
        if (drawable == null) {
            return -1;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        QLog.i("NakedEyesView", 2, "getDrawableWidth contentViewWidth:" + this.C + " width:" + intrinsicWidth);
        if (intrinsicWidth == -1 && (i3 = this.C) != 0) {
            intrinsicWidth = i3;
        }
        int i16 = this.E;
        if (intrinsicWidth > i16) {
            return i16;
        }
        return intrinsicWidth;
    }

    private void e() {
        this.f391360i = View.inflate(getContext(), R.layout.hgx, this);
        i();
    }

    private void f(Drawable drawable) {
        if (drawable == null) {
            k();
            return;
        }
        setWidthAndHeight(-1, -1);
        setContainerViewWidthAndHeight(this.K, this.J);
        ViewGroup.LayoutParams layoutParams = this.f391356d.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        this.f391356d.setImageDrawable(drawable);
        this.f391356d.setLayoutParams(layoutParams);
        QLog.i("NakedEyesView", 2, "initDataWhenNeedNotSensor");
        this.G = false;
        l(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Drawable drawable, boolean z16) {
        Object valueOf;
        if (drawable == null) {
            k();
            return;
        }
        m();
        this.D = this.f391359h.getHeight();
        this.E = this.f391359h.getWidth();
        this.f391361m = c(drawable);
        int d16 = d(drawable);
        this.C = d16;
        if (this.f391361m > 0 && d16 > 0) {
            this.H = (this.E - d16) / 2;
            this.I = ViewUtils.dip2px(21.0f);
            n(this.f391356d, this.C, this.f391361m);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f391356d.getLayoutParams();
            layoutParams.bottomMargin = this.I;
            this.f391356d.setImageDrawable(drawable);
            this.f391356d.setLayoutParams(layoutParams);
            this.f391359h.setDirection(1);
            this.f391359h.setXMoveDistance(this.H);
            this.f391359h.setYMoveDistance(this.I);
            this.f391358f.setDirection(-1);
            this.f391358f.setXMoveDistance(this.H);
            this.f391358f.setYMoveDistance(this.I);
            int width = getWidth() + (this.H * 2);
            int height = getHeight() + (this.I * 2);
            if (z16 && this.f391357e.getLayoutParams() != null && (this.f391357e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                n(this.f391357e, -1, height);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f391357e.getLayoutParams();
                int i3 = this.H;
                layoutParams2.leftMargin = -i3;
                layoutParams2.rightMargin = -i3;
                this.f391357e.setLayoutParams(layoutParams2);
            } else {
                n(this.f391357e, width, height);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initDataWhenNeedSensor  adaptPad:");
            sb5.append(z16);
            sb5.append(" bgViewWidth:");
            sb5.append(width);
            sb5.append(" bgViewHeight:");
            sb5.append(height);
            sb5.append(" backgroundView.getHeight:");
            sb5.append(this.f391357e.getHeight());
            sb5.append(" backgroundView.getWidth:");
            sb5.append(this.f391357e.getWidth());
            sb5.append(" mYMoveDistance:");
            sb5.append(this.I);
            sb5.append(" mXMoveDistance:");
            sb5.append(this.H);
            sb5.append(" bgDrawableHeight:");
            Object obj = "-1";
            if (this.f391357e.getDrawable() == null) {
                valueOf = "-1";
            } else {
                valueOf = Integer.valueOf(this.f391357e.getDrawable().getIntrinsicHeight());
            }
            sb5.append(String.valueOf(valueOf));
            sb5.append(" bgDrawableWidth:");
            if (this.f391357e.getDrawable() != null) {
                obj = Integer.valueOf(this.f391357e.getDrawable().getIntrinsicWidth());
            }
            sb5.append(String.valueOf(obj));
            QLog.i("NakedEyesView", 2, sb5.toString());
            QLog.i("NakedEyesView", 1, "initDataWhenNeedSensor containerViewHeight:" + this.D + " containerViewWidth:" + this.E + " contentViewHeight:" + this.f391361m + " contentViewWidth:" + this.C);
            this.G = true;
            j();
            l(drawable);
            return;
        }
        QLog.e("NakedEyesView", 1, "initDataWhenNeedSensor contentViewHeight or contentViewWidth = -1");
        f(drawable);
    }

    private void i() {
        this.f391356d = (ImageView) this.f391360i.findViewById(R.id.f83274j4);
        this.f391357e = (ImageView) this.f391360i.findViewById(R.id.f83264j3);
        this.f391358f = (SensorLayout) this.f391360i.findViewById(R.id.t6g);
        this.f391359h = (SensorLayout) this.f391360i.findViewById(R.id.u8k);
    }

    private void l(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).isRunning(drawable)) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(drawable);
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(drawable);
    }

    private void m() {
        if (getHeight() <= 0 || getWidth() <= 0) {
            setWidthAndHeight(this.M, this.L);
            setContainerViewWidthAndHeight(this.K, this.J);
        }
    }

    private void n(View view, int i3, int i16) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        view.setLayoutParams(layoutParams);
        QLog.i("NakedEyesView", 2, "setViewWidthAndHeight view.id:" + view.getId() + " width = " + i3 + " and width = " + i16);
    }

    public void h(int i3, int i16) {
        this.f391361m = i16;
        this.C = i3;
        QLog.i("NakedEyesView", 2, "initDrawableWidthAndHeight contentViewHeight = " + this.f391361m + " or contentViewWidth = " + this.C);
    }

    public void j() {
        if (!this.G) {
            return;
        }
        this.f391358f.a();
        this.f391359h.a();
    }

    public void k() {
        o();
        this.F = null;
        this.G = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        setBgOnClickListener(null);
    }

    public void o() {
        this.f391358f.c();
        this.f391359h.c();
    }

    public void setBgOnClickListener(View.OnClickListener onClickListener) {
        this.f391357e.setOnClickListener(onClickListener);
    }

    public void setBgViewDrawable(Drawable drawable) {
        this.f391357e.setImageDrawable(drawable);
    }

    public void setContainerViewWidthAndHeight(int i3, int i16) {
        this.J = i16;
        this.K = i3;
        ViewGroup.LayoutParams layoutParams = this.f391359h.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f391359h.setLayoutParams(layoutParams);
        QLog.i("NakedEyesView", 2, "setContainerViewWidthAndHeight bgViewWidth = " + i3 + " and bgViewHeight = " + i16);
    }

    public void setImageDrawable(Drawable drawable, final boolean z16) {
        if (drawable != null && this.F == null) {
            this.F = drawable;
            postDelayed(new Runnable() { // from class: cooperation.vip.qqbanner.widget.NakedEyesView.1
                @Override // java.lang.Runnable
                public void run() {
                    NakedEyesView nakedEyesView = NakedEyesView.this;
                    nakedEyesView.g(nakedEyesView.F, z16);
                }
            }, 250L);
        }
    }

    public void setWidthAndHeight(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        setLayoutParams(layoutParams);
        this.L = i16;
        this.M = i3;
        if (i3 > 0 && i16 > 0) {
            i3 += this.H * 2;
            i16 += this.I * 2;
        }
        n(this.f391357e, i3, i16);
    }

    public NakedEyesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NakedEyesView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f391356d = null;
        this.f391357e = null;
        this.f391358f = null;
        this.f391359h = null;
        this.f391360i = null;
        this.F = null;
        this.G = false;
        e();
    }
}
