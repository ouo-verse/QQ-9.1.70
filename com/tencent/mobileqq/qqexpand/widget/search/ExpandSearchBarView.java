package com.tencent.mobileqq.qqexpand.widget.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandHorizontalTagsView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandSearchBarView extends FrameLayout implements View.OnClickListener, ExpandHorizontalTagsView.a {
    private boolean C;
    private int D;
    private final Interpolator E;
    private ValueAnimator F;
    private Animator.AnimatorListener G;
    private ValueAnimator H;
    private Animator.AnimatorListener I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private e f264260d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f264261e;

    /* renamed from: f, reason: collision with root package name */
    private InterceptHorizontalScrollView f264262f;

    /* renamed from: h, reason: collision with root package name */
    private ExpandHorizontalTagsView f264263h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f264264i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f264265m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f264266a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f264267b;

        a(FrameLayout.LayoutParams layoutParams, View view) {
            this.f264266a = layoutParams;
            this.f264267b = view;
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = this.f264266a;
            layoutParams.topMargin = (int) ((-ExpandSearchBarView.this.D) * (1.0f - ((((Integer) valueAnimator.getAnimatedValue()).intValue() * 1.0f) / 1000.0f)));
            this.f264267b.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f264270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f264271b;

        c(FrameLayout.LayoutParams layoutParams, View view) {
            this.f264270a = layoutParams;
            this.f264271b = view;
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = this.f264270a;
            layoutParams.topMargin = (int) ((-ExpandSearchBarView.this.D) * ((((Integer) valueAnimator.getAnimatedValue()).intValue() * 1.0f) / 1000.0f));
            this.f264271b.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface e {
        void a(String str, int i3);

        void b();
    }

    public ExpandSearchBarView(Context context) {
        this(context, null);
    }

    private void c(View view) {
        if (!this.J) {
            f(view);
        }
        if (this.D <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (this.H == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1000);
            this.H = ofInt;
            ofInt.setDuration(200L);
            this.H.setInterpolator(this.E);
            this.H.addUpdateListener(new c(layoutParams, view));
            this.I = new d(view);
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.F.cancel();
            this.F.removeAllListeners();
        }
        this.H.removeAllListeners();
        this.H.cancel();
        this.H.addListener(this.I);
        this.H.start();
    }

    private void d(View view) {
        if (!this.J) {
            f(view);
        }
        if (this.D <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (this.F == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1000);
            this.F = ofInt;
            ofInt.setDuration(200L);
            this.F.setInterpolator(this.E);
            this.F.addUpdateListener(new a(layoutParams, view));
            this.G = new b();
        }
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.H.cancel();
            this.H.removeAllListeners();
        }
        this.F.removeAllListeners();
        this.F.cancel();
        this.F.addListener(this.G);
        this.F.start();
    }

    private void f(View view) {
        this.D = ((FrameLayout.LayoutParams) view.getLayoutParams()).topMargin + view.getHeight();
        this.J = true;
    }

    private void g() {
        this.f264261e = (ViewGroup) findViewById(R.id.iis);
        this.f264262f = (InterceptHorizontalScrollView) findViewById(R.id.ikh);
        this.f264263h = (ExpandHorizontalTagsView) findViewById(R.id.ikd);
        this.f264264i = (ImageView) findViewById(R.id.ija);
        this.f264265m = (TextView) findViewById(R.id.f80704c7);
        ExpandHorizontalTagsView expandHorizontalTagsView = this.f264263h;
        if (expandHorizontalTagsView != null) {
            expandHorizontalTagsView.setOnItemClickListener(this);
        }
        ImageView imageView = this.f264264i;
        if (imageView != null) {
            imageView.setOnClickListener(this);
            this.f264264i.setOnTouchListener(ba.f77070d);
        }
        TextView textView = this.f264265m;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.search.ExpandHorizontalTagsView.a
    public void a(String str, int i3) {
        e eVar = this.f264260d;
        if (eVar != null) {
            eVar.a(str, i3);
        }
    }

    public void e() {
        if (!this.C) {
            return;
        }
        this.C = false;
        c(this.f264261e);
    }

    public void h() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f264261e.getLayoutParams();
        layoutParams.topMargin = 0;
        this.f264261e.setLayoutParams(layoutParams);
    }

    public void i(String str) {
        int i3;
        TextView textView = null;
        if (!TextUtils.isEmpty(str)) {
            for (int i16 = 0; i16 < this.f264263h.getChildCount(); i16++) {
                textView = (TextView) this.f264263h.getChildAt(i16);
                if ((textView.getTag() instanceof ExpandHorizontalTagsView.b) && str.equals(((ExpandHorizontalTagsView.b) textView.getTag()).f264258b)) {
                    i3 = textView.getRight();
                    break;
                }
            }
        }
        i3 = 0;
        int width = this.f264262f.getWidth();
        if (i3 > width && width > 0 && textView != null) {
            this.f264262f.scrollTo(i3 - width, 0);
        }
    }

    public void j() {
        if (this.C) {
            ValueAnimator valueAnimator = this.F;
            if (valueAnimator != null && !valueAnimator.isRunning() && ((FrameLayout.LayoutParams) this.f264261e.getLayoutParams()).topMargin != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendSearchBarView", 2, "showSearchBar catch a display exception");
                }
                h();
                return;
            }
            return;
        }
        this.C = true;
        d(this.f264261e);
    }

    public void k(int i3) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i16 = iArr[1];
        int height = getHeight();
        int i17 = i3 + i16;
        if (i17 <= i16 || i16 <= 0 || height <= 0) {
            i17 = 1920;
            i16 = 223;
            height = 105;
        }
        int i18 = height + i16;
        setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(255, 79 - ((i16 * 36) / i17), 127 - ((i16 * (-35)) / i17), 255), Color.argb(255, 79 - ((i18 * 36) / i17), 127 - ((i18 * (-35)) / i17), 255)}));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        e eVar = this.f264260d;
        if (eVar != null) {
            eVar.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setItemClickListener(e eVar) {
        this.f264260d = eVar;
    }

    public void setSearchButtonEnable(boolean z16) {
        int i3;
        ImageView imageView = this.f264264i;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public void setSearchTags(ArrayList<String> arrayList, int i3) {
        ExpandHorizontalTagsView expandHorizontalTagsView = this.f264263h;
        if (expandHorizontalTagsView != null) {
            expandHorizontalTagsView.setSearchTags(arrayList, i3);
        }
    }

    public void setSearchTextShow(boolean z16) {
        TextView textView;
        if (this.f264262f != null && (textView = this.f264265m) != null) {
            if (z16) {
                if (textView.getVisibility() == 8) {
                    this.f264265m.setVisibility(0);
                    this.f264262f.setVisibility(4);
                    return;
                }
                return;
            }
            if (textView.getVisibility() == 0) {
                this.f264265m.setVisibility(8);
                this.f264262f.setVisibility(0);
            }
        }
    }

    public ExpandSearchBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandSearchBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = true;
        this.D = -1;
        this.E = new LinearInterpolator();
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = false;
        View.inflate(context, R.layout.gwi, this);
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ExpandSearchBarView.this.h();
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandSearchBarView.this.h();
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f264273a;

        d(View view) {
            this.f264273a = view;
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f264273a.getLayoutParams();
            layoutParams.topMargin = -ExpandSearchBarView.this.D;
            this.f264273a.setLayoutParams(layoutParams);
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f264273a.getLayoutParams();
            layoutParams.topMargin = -ExpandSearchBarView.this.D;
            this.f264273a.setLayoutParams(layoutParams);
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
