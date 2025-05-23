package com.qzone.reborn.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.reborn.widget.QZoneVPIDotView;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes37.dex */
public class QZoneVPIndicator extends LinearLayout {
    private static final int D = QZoneVPIDotView.F;
    private static final int E = QZoneVPIDotView.G;
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private int f59663d;

    /* renamed from: e, reason: collision with root package name */
    private int f59664e;

    /* renamed from: f, reason: collision with root package name */
    private int f59665f;

    /* renamed from: h, reason: collision with root package name */
    public QFSImageBanner f59666h;

    /* renamed from: i, reason: collision with root package name */
    private int f59667i;

    /* renamed from: m, reason: collision with root package name */
    private int f59668m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneVPIndicator.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f59674a;

        static {
            int[] iArr = new int[QZoneVPIDotView.DotType.values().length];
            f59674a = iArr;
            try {
                iArr[QZoneVPIDotView.DotType.More.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59674a[QZoneVPIDotView.DotType.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f59674a[QZoneVPIDotView.DotType.Choose.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public QZoneVPIndicator(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3, QZoneVPIDotView.DotType dotType) {
        View childAt = getChildAt(i3);
        if (childAt instanceof QZoneVPIDotView) {
            int i16 = d.f59674a[dotType.ordinal()];
            if (i16 == 1) {
                ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.More);
                return;
            }
            if (i16 == 2) {
                ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.Normal);
                return;
            }
            if (i16 != 3) {
                return;
            }
            View childAt2 = getChildAt(this.f59668m);
            if (childAt2 instanceof QZoneVPIDotView) {
                ((QZoneVPIDotView) childAt2).setDotType(QZoneVPIDotView.DotType.Normal);
            }
            ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.Choose);
            this.f59668m = i3;
        }
    }

    private void o(int i3) {
        if (getChildCount() <= 0) {
            return;
        }
        for (int i16 = i3; i16 < this.f59664e + i3; i16++) {
            View childAt = getChildAt(i16);
            if (childAt instanceof QZoneVPIDotView) {
                ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.Normal);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        int i16;
        QLog.i("QZoneVPIndicator", 1, "[adjustTabItemUseComb1] startPosition = " + i3 + ", mScrollX = " + this.f59667i);
        if (getChildCount() <= 0) {
            return;
        }
        int i17 = i3;
        while (true) {
            i16 = this.f59663d;
            if (i17 >= (i3 + i16) - 1) {
                break;
            }
            View childAt = getChildAt(i17);
            if (childAt instanceof QZoneVPIDotView) {
                ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.Normal);
            }
            i17++;
        }
        View childAt2 = getChildAt(((i3 + i3) + i16) - 1);
        if (childAt2 instanceof QZoneVPIDotView) {
            ((QZoneVPIDotView) childAt2).setDotType(QZoneVPIDotView.DotType.More);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3) {
        int i16;
        QLog.i("QZoneVPIndicator", 1, "[adjustTabItemUseComb2] startPosition = " + i3 + ", mScrollX = " + this.f59667i);
        View childAt = getChildAt(i3);
        if (childAt instanceof QZoneVPIDotView) {
            ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.More);
        }
        int i17 = i3 + 1;
        while (true) {
            i16 = this.f59663d;
            if (i17 >= (i3 + i16) - 1) {
                break;
            }
            View childAt2 = getChildAt(i17);
            if (childAt2 instanceof QZoneVPIDotView) {
                ((QZoneVPIDotView) childAt2).setDotType(QZoneVPIDotView.DotType.Normal);
            }
            i17++;
        }
        View childAt3 = getChildAt((i3 + i16) - 1);
        if (childAt3 instanceof QZoneVPIDotView) {
            ((QZoneVPIDotView) childAt3).setDotType(QZoneVPIDotView.DotType.More);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3) {
        QLog.i("QZoneVPIndicator", 1, "[adjustTabItemUseComb3] startPosition = " + i3 + ", mScrollX = " + this.f59667i);
        View childAt = getChildAt(i3);
        if (childAt instanceof QZoneVPIDotView) {
            ((QZoneVPIDotView) childAt).setDotType(QZoneVPIDotView.DotType.More);
        }
        for (int i16 = i3 + 1; i16 < this.f59663d + i3; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2 instanceof QZoneVPIDotView) {
                ((QZoneVPIDotView) childAt2).setDotType(QZoneVPIDotView.DotType.Normal);
            }
        }
    }

    private QZoneVPIDotView s(QZoneVPIDotView.DotType dotType) {
        QZoneVPIDotView qZoneVPIDotView = new QZoneVPIDotView(getContext());
        qZoneVPIDotView.setDotType(dotType);
        return qZoneVPIDotView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        QZoneVPIDotView.DotType dotType;
        int i16 = this.f59667i - 1;
        if (i3 == 1) {
            dotType = QZoneVPIDotView.DotType.Normal;
        } else {
            dotType = QZoneVPIDotView.DotType.More;
        }
        n(i16, dotType);
        int i17 = this.f59667i;
        int i18 = D;
        w(i17 * i18, (i17 - 1) * i18, false, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3) {
        QZoneVPIDotView.DotType dotType;
        int i16 = this.f59667i + this.f59663d;
        if (i3 == this.f59664e - 2) {
            dotType = QZoneVPIDotView.DotType.Normal;
        } else {
            dotType = QZoneVPIDotView.DotType.More;
        }
        n(i16, dotType);
        int i17 = this.f59667i;
        int i18 = D;
        w(i17 * i18, (i17 + 1) * i18, true, i3);
    }

    private void v() {
        int i3;
        QLog.i("QZoneVPIndicator", 1, "[setAllDotItem] mTotalDotCount = " + this.f59664e);
        if (getChildCount() != 0) {
            removeAllViews();
        }
        if (this.f59664e <= 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            i3 = this.f59664e;
            if (i16 >= i3) {
                break;
            }
            addView(s(QZoneVPIDotView.DotType.Normal));
            i16++;
        }
        if (i3 > this.f59663d) {
            p(0);
        }
        n(0, QZoneVPIDotView.DotType.Choose);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(this.f59665f * D, E);
    }

    public void setTotalCount(int i3) {
        if (this.f59664e == i3) {
            return;
        }
        this.f59664e = i3;
        this.f59665f = Math.min(i3, this.f59663d);
        v();
        requestLayout();
    }

    public void setViewPager(QFSImageBanner qFSImageBanner) {
        this.f59666h = qFSImageBanner;
        qFSImageBanner.q0(new a());
    }

    public QZoneVPIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59663d = 5;
        setGravity(16);
    }

    private void w(int i3, int i16, boolean z16, int i17) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i16);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new b());
        ofInt.addListener(new c(z16, i17));
        ofInt.start();
    }

    public void setCurPosition(int i3) {
        int i16;
        if (i3 >= 0 && i3 < (i16 = this.f59664e)) {
            int i17 = this.f59663d;
            if (i16 <= i17) {
                if (this.f59667i != 0) {
                    this.f59667i = 0;
                    scrollTo(0, 0);
                    o(0);
                }
            } else if (i3 < i17 - 1) {
                if (this.f59667i != 0) {
                    this.f59667i = 0;
                    scrollTo(0, 0);
                    p(0);
                }
            } else if (i3 > i16 - 3) {
                int i18 = i16 - i17;
                if (i18 != this.f59667i) {
                    this.f59667i = i18;
                    scrollTo(i18 * D, 0);
                    r(this.f59667i);
                }
            } else {
                int i19 = (i3 - i17) + 2;
                if (i19 != this.f59667i) {
                    this.f59667i = i19;
                    scrollTo(i19 * D, 0);
                    q(this.f59667i);
                }
            }
            n(i3, QZoneVPIDotView.DotType.Choose);
            this.C = i3;
            return;
        }
        QLog.e("QZoneVPIndicator", 1, "[setCurPosition] position is error, " + i3);
    }

    /* loaded from: classes37.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            QLog.i("QZoneVPIndicator", 1, "[onPageSelected] mLastVPPosition = " + QZoneVPIndicator.this.C + ", mLastChooseDotIndex = " + QZoneVPIndicator.this.f59668m + ", mScrollX = " + QZoneVPIndicator.this.f59667i);
            if (i3 > QZoneVPIndicator.this.C) {
                if (QZoneVPIndicator.this.f59668m - QZoneVPIndicator.this.f59667i == QZoneVPIndicator.this.f59663d - 2 && i3 != QZoneVPIndicator.this.f59664e - 1) {
                    QZoneVPIndicator.this.u(i3);
                } else {
                    QZoneVPIndicator qZoneVPIndicator = QZoneVPIndicator.this;
                    qZoneVPIndicator.n(qZoneVPIndicator.f59668m + 1, QZoneVPIDotView.DotType.Choose);
                }
            } else if (i3 < QZoneVPIndicator.this.C) {
                if (QZoneVPIndicator.this.f59668m == QZoneVPIndicator.this.f59667i + 1 && i3 != 0) {
                    QZoneVPIndicator.this.t(i3);
                } else {
                    QZoneVPIndicator qZoneVPIndicator2 = QZoneVPIndicator.this;
                    qZoneVPIndicator2.n(qZoneVPIndicator2.f59668m - 1, QZoneVPIDotView.DotType.Choose);
                }
            }
            QZoneVPIndicator.this.C = i3;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f59671d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f59672e;

        c(boolean z16, int i3) {
            this.f59671d = z16;
            this.f59672e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f59671d) {
                QZoneVPIndicator.this.f59667i++;
                if (this.f59672e == QZoneVPIndicator.this.f59664e - 2) {
                    QZoneVPIndicator qZoneVPIndicator = QZoneVPIndicator.this;
                    qZoneVPIndicator.r(qZoneVPIndicator.f59667i);
                } else {
                    QZoneVPIndicator qZoneVPIndicator2 = QZoneVPIndicator.this;
                    qZoneVPIndicator2.q(qZoneVPIndicator2.f59667i);
                }
                QZoneVPIndicator.this.n((r3.f59667i + QZoneVPIndicator.this.f59663d) - 2, QZoneVPIDotView.DotType.Choose);
                return;
            }
            QZoneVPIndicator.this.f59667i--;
            if (this.f59672e == 1) {
                QZoneVPIndicator qZoneVPIndicator3 = QZoneVPIndicator.this;
                qZoneVPIndicator3.p(qZoneVPIndicator3.f59667i);
            } else {
                QZoneVPIndicator qZoneVPIndicator4 = QZoneVPIndicator.this;
                qZoneVPIndicator4.q(qZoneVPIndicator4.f59667i);
            }
            QZoneVPIndicator qZoneVPIndicator5 = QZoneVPIndicator.this;
            qZoneVPIndicator5.n(qZoneVPIndicator5.f59667i + 1, QZoneVPIDotView.DotType.Choose);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
