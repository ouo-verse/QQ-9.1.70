package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.ona.protocol.jce.AdCustomActionButtonInfo;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoPoster;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoTitle;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import ev2.e;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import pw2.n;
import pw2.s;
import yu2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class QAdBaseVideoAdDetailView extends LinearLayout {
    protected static int K;
    protected static int L;
    private static final String M = QAdVideoAdDetailView.class.getSimpleName();
    protected static long N = 5000;
    protected static long P = 500;
    protected static float Q = 0.0f;
    protected static float R = 0.9f;
    protected int C;
    protected int D;
    protected String E;
    protected String F;
    protected AdInsideVideoItem G;
    protected boolean H;
    private AdInsideVideoPoster I;
    protected Runnable J;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f303720d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f303721e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f303722f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f303723h;

    /* renamed from: i, reason: collision with root package name */
    protected AdOrderItem f303724i;

    /* renamed from: m, reason: collision with root package name */
    protected int f303725m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ViewVisibleState {
        public static final int BOTH_GONE = 0;
        public static final int BOTH_VISIBLE = 3;
        public static final int COMMON_GONE_VIP_VISIBLE = 2;
        public static final int COMMON_VISIBLE_VIP_GONE = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends Animation {
        a() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) QAdBaseVideoAdDetailView.this.f303720d.getLayoutParams();
            QAdBaseVideoAdDetailView qAdBaseVideoAdDetailView = QAdBaseVideoAdDetailView.this;
            int i3 = qAdBaseVideoAdDetailView.C;
            marginLayoutParams.width = ((int) ((qAdBaseVideoAdDetailView.f303725m - i3) * (1.0f - f16))) + i3;
            if (f16 == 1.0f && i3 <= 0) {
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
            }
            qAdBaseVideoAdDetailView.f303720d.setLayoutParams(marginLayoutParams);
            if (f16 == 1.0f) {
                QAdBaseVideoAdDetailView qAdBaseVideoAdDetailView2 = QAdBaseVideoAdDetailView.this;
                qAdBaseVideoAdDetailView2.f303720d.setText(qAdBaseVideoAdDetailView2.F);
                QAdBaseVideoAdDetailView.this.h();
            }
        }
    }

    public QAdBaseVideoAdDetailView(Context context) {
        super(context);
        this.D = 0;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView.2
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = QAdBaseVideoAdDetailView.this.f303720d;
                if (textView != null && textView.getVisibility() == 0) {
                    QAdBaseVideoAdDetailView.this.r();
                }
            }
        };
        e(context);
    }

    private boolean a(AdInsideVideoPoster adInsideVideoPoster) {
        AdInsideVideoTitle adInsideVideoTitle;
        if (adInsideVideoPoster != null && (adInsideVideoTitle = adInsideVideoPoster.titleInfo) != null && (!TextUtils.isEmpty(adInsideVideoTitle.fullTitle) || !TextUtils.isEmpty(adInsideVideoPoster.titleInfo.fullUnInstallTitle) || !TextUtils.isEmpty(adInsideVideoPoster.titleInfo.shortTitle) || !TextUtils.isEmpty(adInsideVideoPoster.titleInfo.shortUnInstallTitle))) {
            return true;
        }
        return false;
    }

    private void f(AdInsideVideoItem adInsideVideoItem) {
        Integer b16;
        Integer b17;
        AdCustomActionButtonInfo adCustomActionButtonInfo = adInsideVideoItem.actionButtonInfo;
        if (adCustomActionButtonInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(adCustomActionButtonInfo.bgColor) && (b17 = e.b(adCustomActionButtonInfo.bgColor)) != null) {
            L = b17.intValue();
        }
        if (!TextUtils.isEmpty(adCustomActionButtonInfo.hightlightBgColor) && (b16 = e.b(adCustomActionButtonInfo.hightlightBgColor)) != null) {
            K = b16.intValue();
        }
    }

    private void p() {
        n.a(M, "[DetailView] [Type] \u5168\u5c4f\u70b9\u51fb\u6837\u5f0f\uff1a" + N);
        l();
        k();
        this.C = g(this.F);
        this.f303720d.postDelayed(this.J, N);
    }

    private void q() {
        n.a(M, "[DetailView] [Type] \u8be6\u60c5\u70b9\u51fb\u6837\u5f0f");
        l();
        k();
    }

    protected GradientDrawable c() {
        ViewGroup viewGroup = this.f303721e;
        if (viewGroup == null) {
            return null;
        }
        Drawable background = viewGroup.getBackground();
        if (background instanceof GradientDrawable) {
            return (GradientDrawable) background;
        }
        return new GradientDrawable();
    }

    protected int d() {
        return K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context) {
        setGravity(17);
        this.f303723h = context;
        K = getResources().getColor(R.color.b3v);
        L = getResources().getColor(R.color.b3w);
    }

    public int g(String str) {
        TextPaint paint;
        if (this.f303720d != null && !TextUtils.isEmpty(str) && (paint = this.f303720d.getPaint()) != null) {
            return (int) paint.measureText(str);
        }
        return 0;
    }

    public void i() {
        this.H = false;
    }

    protected void j() {
        TextView textView = this.f303720d;
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.width = this.f303725m;
            this.f303720d.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        TextView textView = this.f303720d;
        if (textView != null) {
            textView.measure(0, 0);
            this.f303725m = this.f303720d.getMeasuredWidth();
            j();
        }
    }

    protected void l() {
        TextView textView = this.f303720d;
        if (textView != null) {
            textView.clearAnimation();
            this.f303720d.setText(this.E);
        }
    }

    protected void m(int i3) {
        int i16;
        int i17 = 8;
        if (i3 != 0) {
            i16 = 0;
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = 8;
                    i17 = 0;
                } else {
                    i17 = 0;
                }
            }
        } else {
            i16 = 8;
        }
        ViewGroup viewGroup = this.f303721e;
        if (viewGroup != null) {
            viewGroup.setVisibility(i17);
        }
        ImageView imageView = this.f303722f;
        if (imageView != null) {
            imageView.setVisibility(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(int i3) {
        GradientDrawable c16 = c();
        if (c16 == null) {
            return;
        }
        c16.setCornerRadius(s.a(33.0f));
        c16.setColor(i3);
        this.f303721e.setBackgroundDrawable(c16);
    }

    public void o() {
        TextView textView = this.f303720d;
        if (textView != null) {
            textView.removeCallbacks(this.J);
            this.f303720d.clearAnimation();
            if (this.D == 2) {
                p();
            } else {
                q();
            }
        }
        s();
        m(1);
        setVisibility(0);
    }

    protected void r() {
        TextView textView = this.f303720d;
        if (textView == null) {
            return;
        }
        textView.clearAnimation();
        a aVar = new a();
        aVar.setDuration(500L);
        this.f303720d.startAnimation(aVar);
    }

    protected void s() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(Q, R);
        alphaAnimation.setDuration(P);
        startAnimation(alphaAnimation);
    }

    public void setDetailBgLightColor() {
        n(d());
    }

    public void t(AdInsideVideoItem adInsideVideoItem) {
        AdInsideVideoPoster adInsideVideoPoster;
        if (adInsideVideoItem != null && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null && adInsideVideoItem.orderItem != null && a(adInsideVideoPoster)) {
            AdInsideVideoPoster adInsideVideoPoster2 = adInsideVideoItem.videoPoster;
            if (adInsideVideoPoster2.actionButtonType != 0) {
                if (adInsideVideoPoster2 == this.I && adInsideVideoItem.orderItem == this.f303724i) {
                    return;
                }
                f(adInsideVideoItem);
                AdInsideVideoPoster adInsideVideoPoster3 = adInsideVideoItem.videoPoster;
                this.D = adInsideVideoPoster3.actionButtonType;
                this.I = adInsideVideoPoster3;
                this.f303724i = adInsideVideoItem.orderItem;
                this.G = adInsideVideoItem;
                u();
                n.a(M, "[DetailView] SHOWN");
                o();
                return;
            }
        }
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        AdInsideVideoPoster adInsideVideoPoster = this.I;
        if (adInsideVideoPoster != null && adInsideVideoPoster.titleInfo != null) {
            if (b.x(getContext(), this.f303724i)) {
                AdInsideVideoTitle adInsideVideoTitle = this.I.titleInfo;
                String str = adInsideVideoTitle.fullTitle;
                this.E = str;
                this.F = adInsideVideoTitle.shortTitle;
                if (TextUtils.isEmpty(str)) {
                    this.E = this.I.titleInfo.fullUnInstallTitle;
                }
                if (TextUtils.isEmpty(this.F)) {
                    this.F = this.I.titleInfo.shortUnInstallTitle;
                    return;
                }
                return;
            }
            AdInsideVideoTitle adInsideVideoTitle2 = this.I.titleInfo;
            String str2 = adInsideVideoTitle2.fullUnInstallTitle;
            this.E = str2;
            this.F = adInsideVideoTitle2.shortUnInstallTitle;
            if (TextUtils.isEmpty(str2)) {
                this.E = this.I.titleInfo.fullTitle;
            }
            if (TextUtils.isEmpty(this.F)) {
                this.F = this.I.titleInfo.shortTitle;
                return;
            }
            return;
        }
        this.E = "";
        this.F = "";
    }

    public QAdBaseVideoAdDetailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = 0;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView.2
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = QAdBaseVideoAdDetailView.this.f303720d;
                if (textView != null && textView.getVisibility() == 0) {
                    QAdBaseVideoAdDetailView.this.r();
                }
            }
        };
        e(context);
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
    }
}
