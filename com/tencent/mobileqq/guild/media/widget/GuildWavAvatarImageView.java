package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildWavAvatarImageView extends ViewGroup {
    private final List<a> C;
    private Interpolator D;
    private Paint E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private Context L;
    private int M;
    private int N;
    private boolean P;
    private GuildUserAvatarViewWithPendant Q;
    private Path R;
    private float S;
    private double T;
    private GuildAVImageView U;
    private Runnable V;

    /* renamed from: d, reason: collision with root package name */
    private float f229786d;

    /* renamed from: e, reason: collision with root package name */
    private long f229787e;

    /* renamed from: f, reason: collision with root package name */
    private int f229788f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f229789h;

    /* renamed from: i, reason: collision with root package name */
    private long f229790i;

    /* renamed from: m, reason: collision with root package name */
    private long f229791m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f229792a = System.currentTimeMillis();

        /* renamed from: b, reason: collision with root package name */
        private float f229793b;

        /* renamed from: c, reason: collision with root package name */
        private float f229794c;

        /* renamed from: d, reason: collision with root package name */
        private float f229795d;

        a() {
            if (GuildWavAvatarImageView.this.M > 0) {
                GuildWavAvatarImageView.this.f229786d = (GuildWavAvatarImageView.this.M >> 1) * 0.783f;
                this.f229793b = GuildWavAvatarImageView.this.f229786d * GuildWavAvatarImageView.this.F;
                this.f229794c = GuildWavAvatarImageView.this.f229786d * GuildWavAvatarImageView.this.G;
                this.f229795d = GuildWavAvatarImageView.this.f229786d * 2.0f * GuildWavAvatarImageView.this.H;
            }
            f();
        }

        private void f() {
            if (GuildWavAvatarImageView.this.I >= 10.0f && GuildWavAvatarImageView.this.I < 65.0f) {
                float f16 = GuildWavAvatarImageView.this.I / 65.0f;
                if (f16 >= GuildWavAvatarImageView.this.J) {
                    this.f229793b *= f16;
                    this.f229794c *= f16;
                    return;
                } else {
                    this.f229793b *= GuildWavAvatarImageView.this.J;
                    this.f229794c *= GuildWavAvatarImageView.this.J;
                    return;
                }
            }
            if (GuildWavAvatarImageView.this.I > 65.0f) {
                float f17 = GuildWavAvatarImageView.this.I / 65.0f;
                if (f17 > GuildWavAvatarImageView.this.K) {
                    f17 = GuildWavAvatarImageView.this.K;
                }
                this.f229794c *= f17;
                this.f229795d *= f17;
            }
        }

        int c() {
            return (int) ((1.5f - GuildWavAvatarImageView.this.D.getInterpolation((((float) (System.currentTimeMillis() - this.f229792a)) * 1.0f) / ((float) GuildWavAvatarImageView.this.f229787e))) * 255.0f);
        }

        float d() {
            return this.f229793b + (GuildWavAvatarImageView.this.D.getInterpolation((((float) (System.currentTimeMillis() - this.f229792a)) * 1.0f) / ((float) GuildWavAvatarImageView.this.f229787e)) * (this.f229794c - this.f229793b));
        }

        int e() {
            return (int) (this.f229795d - (GuildWavAvatarImageView.this.D.getInterpolation((((float) (System.currentTimeMillis() - this.f229792a)) * 1.0f) / ((float) GuildWavAvatarImageView.this.f229787e)) * this.f229795d));
        }
    }

    public GuildWavAvatarImageView(Context context) {
        this(context, null);
    }

    private void B() {
        this.Q.getLayoutParams().width = this.M;
        ViewGroup.LayoutParams layoutParams = this.Q.getLayoutParams();
        int i3 = this.N;
        layoutParams.height = i3;
        float f16 = this.M;
        float f17 = this.S;
        int i16 = (int) (f16 * f17);
        this.U.getLayoutParams().width = i16;
        this.U.getLayoutParams().height = (int) (i3 * f17);
        setIdentityViewBorderWidth((int) (i16 * 0.1d));
    }

    private void r(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.M, this.N);
        layoutParams.addRule(13, -1);
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = new GuildUserAvatarViewWithPendant(context);
        this.Q = guildUserAvatarViewWithPendant;
        guildUserAvatarViewWithPendant.setShowPendantView(this.P);
        this.Q.setLogTag("GuildWavAvatarImageView");
        this.Q.setId(R.id.vzu);
        addView(this.Q, layoutParams);
    }

    private void s(Context context) {
        float f16 = this.M;
        float f17 = this.S;
        int i3 = (int) (f16 * f17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, (int) (this.N * f17));
        layoutParams.addRule(13, -1);
        GuildAVImageView guildAVImageView = new GuildAVImageView(context);
        this.U = guildAVImageView;
        addView(guildAVImageView, layoutParams);
        this.U.bringToFront();
        setIdentityViewBorderWidth((int) (i3 * 0.1d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f229790i < this.f229788f) {
            return;
        }
        this.C.add(new a());
        this.f229790i = currentTimeMillis;
    }

    private void v() {
        View childAt = getChildAt(0);
        int measuredWidth = (getMeasuredWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredHeight = (getMeasuredHeight() / 2) - (childAt.getMeasuredHeight() / 2);
        childAt.layout(measuredWidth, measuredHeight, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
        int i3 = this.M;
        int i16 = ((int) (i3 * 0.783f)) >> 1;
        int i17 = ((int) (i3 * this.S)) >> 1;
        View childAt2 = getChildAt(1);
        int right = getRight() >> 1;
        int bottom = getBottom() >> 1;
        int sin = (int) (i16 * Math.sin((this.T * 3.141592653589793d) / 180.0d));
        int i18 = (right + sin) - i17;
        int i19 = (bottom + sin) - i17;
        childAt2.layout(i18, i19, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + i19);
    }

    private void w(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.J5);
        try {
            try {
                this.M = (int) (obtainStyledAttributes.getDimension(up1.a.L5, 50.0f) / 0.783f);
                this.N = (int) (obtainStyledAttributes.getDimension(up1.a.K5, 50.0f) / 0.783f);
                this.P = obtainStyledAttributes.getBoolean(up1.a.M5, true);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void x(Context context) {
        r(context);
        s(context);
    }

    public void A() {
        if (this.f229789h) {
            this.f229789h = false;
            this.C.clear();
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        View childAt = getChildAt(0);
        if (childAt != null && this.f229786d != 0.0f) {
            int width = childAt.getWidth() / 2;
            int height = childAt.getHeight() / 2;
            int left = width + childAt.getLeft();
            int top = height + childAt.getTop();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<a> it = this.C.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                a next = it.next();
                float d16 = next.d();
                int e16 = next.e();
                float f16 = e16;
                i3 = Math.max(i3, (int) (next.f229794c + f16 + 0.5d));
                Iterator<a> it5 = it;
                if (currentTimeMillis - next.f229792a <= this.f229787e) {
                    float f17 = e16 >> 1;
                    float f18 = d16 + f17;
                    if (f18 > this.f229786d) {
                        this.E.setStrokeJoin(Paint.Join.ROUND);
                        this.E.setStrokeCap(Paint.Cap.ROUND);
                        this.E.setStyle(Paint.Style.STROKE);
                        this.E.setStrokeWidth(f16);
                        this.E.setAlpha(next.c());
                        float f19 = (int) (d16 - f17);
                        float f26 = this.f229786d;
                        if (f19 < f26) {
                            d16 = (r0 >> 1) + f26;
                            this.E.setStrokeWidth((int) (f18 - f26));
                        }
                        canvas.drawCircle(left, top, d16, this.E);
                    }
                } else {
                    it5.remove();
                }
                it = it5;
            }
            if (this.C.size() > 0) {
                postInvalidateDelayed(30L, left - i3, top - i3, left + i3, i3 + top);
            } else {
                this.f229789h = false;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        v();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            measureChild(getChildAt(i17), i3, i16);
        }
        super.onMeasure(i3, i16);
    }

    public void setAvatarHeight(int i3) {
        this.N = (int) (i3 / 0.783f);
        B();
    }

    public void setAvatarSize(int i3) {
        this.Q.setAvatarSize(i3);
    }

    public void setAvatarTinyId(String str, String str2) {
        this.Q.setAvatarTinyId(str, str2);
    }

    public void setAvatarWidth(int i3) {
        this.M = (int) (i3 / 0.783f);
        B();
    }

    public void setColor(int i3) {
        this.E.setColor(i3);
    }

    public void setDuration(long j3) {
        this.f229787e = j3;
    }

    public void setIdentityView(int i3) {
        if (i3 == -1) {
            this.U.setVisibility(8);
            return;
        }
        if (this.U.getTag() == null || ((Integer) this.U.getTag()).intValue() != i3) {
            this.U.setImageResource(i3);
            this.U.setTag(Integer.valueOf(i3));
        }
        this.U.setVisibility(0);
    }

    public void setIdentityViewBorderColor(@ColorInt int i3) {
        this.U.setBorderColor(i3);
    }

    public void setIdentityViewBorderWidth(int i3) {
        this.U.setBorderWidth(i3);
    }

    public void setImageWidth(int i3) {
        int dip2px = ViewUtils.dip2px(i3);
        if (this.M == dip2px) {
            return;
        }
        int i16 = (int) (dip2px / 0.783f);
        this.M = i16;
        this.N = i16;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams.width = this.M;
        layoutParams.height = this.N;
        this.Q.setLayoutParams(layoutParams);
        float f16 = this.M;
        float f17 = this.S;
        int i17 = (int) (f16 * f17);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
        layoutParams2.width = i17;
        layoutParams2.height = (int) (this.N * f17);
        this.U.setLayoutParams(layoutParams2);
        setIdentityViewBorderWidth((int) (i17 * 0.1d));
        requestLayout();
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.D = interpolator;
        if (interpolator == null) {
            this.D = new LinearInterpolator();
        }
    }

    public void setSpeed(int i3) {
        this.f229788f = i3;
    }

    public void setStyle(Paint.Style style) {
        this.E.setStyle(style);
    }

    public void setVolume(float f16) {
        this.I = f16;
        this.f229791m = System.currentTimeMillis();
        y();
    }

    public void t(String str, Object obj) {
        if ("avatar_width".equals(str)) {
            this.M = (int) (((Integer) obj).intValue() / 0.783f);
        } else if ("avatar_height".equals(str)) {
            this.N = (int) (((Integer) obj).intValue() / 0.783f);
        }
        B();
    }

    public void y() {
        if (!this.f229789h) {
            this.f229789h = true;
            this.V.run();
            invalidate();
        }
    }

    public void z() {
        this.f229789h = false;
    }

    public GuildWavAvatarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f229787e = 1000L;
        this.f229788f = TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR;
        this.C = new ArrayList();
        this.D = new DecelerateInterpolator();
        this.E = new Paint(1);
        this.F = 0.85f;
        this.G = 1.62f;
        this.H = 0.2f;
        this.I = 0.0f;
        this.J = 0.8f;
        this.K = 1.0f;
        this.P = true;
        this.R = new Path();
        this.S = 0.3f;
        this.T = 45.0d;
        this.V = new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildWavAvatarImageView.this.I < 10.0f || System.currentTimeMillis() - GuildWavAvatarImageView.this.f229791m > GuildWavAvatarImageView.this.f229788f) {
                    GuildWavAvatarImageView.this.f229789h = false;
                } else if (GuildWavAvatarImageView.this.f229789h) {
                    GuildWavAvatarImageView.this.u();
                    GuildWavAvatarImageView guildWavAvatarImageView = GuildWavAvatarImageView.this;
                    guildWavAvatarImageView.postDelayed(guildWavAvatarImageView.V, GuildWavAvatarImageView.this.f229788f);
                }
            }
        };
        this.L = context;
        setWillNotDraw(false);
        w(context, attributeSet);
        x(context);
    }

    public void setAvatarTinyId(String str, String str2, String str3, String str4) {
        this.Q.setAvatarMeta(str, str2, str3, str4);
    }
}
