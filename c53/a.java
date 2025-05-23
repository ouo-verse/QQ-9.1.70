package c53;

import a53.a;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.cardlistview.animation.QUICardListAnimator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private final Context f30350c;

    /* renamed from: d, reason: collision with root package name */
    private List<d53.b> f30351d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerViewCompat f30352e;

    /* renamed from: f, reason: collision with root package name */
    private QUICardListAnimator f30353f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.widget.pull2refresh.a f30354g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f30355h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f30356i;

    /* renamed from: a, reason: collision with root package name */
    private int f30348a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f30349b = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30357j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f30358k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: c53.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class ViewOnClickListenerC0170a implements View.OnClickListener {
        ViewOnClickListenerC0170a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.o();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements QUICardListAnimator.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.cardlistview.animation.QUICardListAnimator.e
        public void onFinish() {
            a.this.f30352e.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
    }

    public a(Context context) {
        this.f30350c = context;
    }

    private void i() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        this.f30355h.addView(this.f30352e, layoutParams);
        this.f30355h.setOnClickListener(new ViewOnClickListenerC0170a());
        ((ViewGroup) ((Activity) this.f30350c).getWindow().getDecorView().getRootView()).addView(this.f30355h);
    }

    @NotNull
    private RecyclerViewCompat j(int i3, ArrayList<d53.b> arrayList) {
        RecyclerViewCompat recyclerViewCompat = new RecyclerViewCompat(this.f30350c);
        l(recyclerViewCompat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f30350c);
        linearLayoutManager.setOrientation(0);
        recyclerViewCompat.setLayoutManager(linearLayoutManager);
        a53.b bVar = new a53.b(this.f30350c);
        bVar.t(null);
        bVar.setData(arrayList);
        bVar.s(i3);
        recyclerViewCompat.setAdapter(bVar);
        recyclerViewCompat.setOverScrollMode(2);
        recyclerViewCompat.addItemDecoration(new e53.a());
        com.tencent.widget.pull2refresh.a aVar = new com.tencent.widget.pull2refresh.a(0, 50.0f);
        this.f30354g = aVar;
        aVar.e0((int) this.f30350c.getResources().getDimension(R.dimen.d_8));
        this.f30354g.B(recyclerViewCompat);
        return recyclerViewCompat;
    }

    private void k() {
        this.f30355h = new FrameLayout(this.f30350c);
        this.f30355h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f30356i = new FrameLayout(this.f30350c);
        this.f30356i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f30356i.setBackground(new ColorDrawable(this.f30350c.getResources().getColor(R.color.qui_cardlist_fullscreen_mask_bg)));
        this.f30355h.addView(this.f30356i);
    }

    private void l(RecyclerViewCompat recyclerViewCompat) {
        recyclerViewCompat.addOnItemTouchListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(QUIButton qUIButton, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                qUIButton.setPressed(false);
                return;
            }
            return;
        }
        qUIButton.setPressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        FrameLayout frameLayout = this.f30355h;
        if (frameLayout == null) {
            return;
        }
        ViewParent parent = frameLayout.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f30355h);
            this.f30357j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.tencent.widget.pull2refresh.a aVar;
        if (!this.f30358k && !QUICardListAnimator.f316817j.get()) {
            this.f30358k = true;
            QUICardListAnimator qUICardListAnimator = this.f30353f;
            if (qUICardListAnimator != null && (aVar = this.f30354g) != null) {
                qUICardListAnimator.p(this.f30352e, aVar.Q());
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setAnimationListener(new d());
            this.f30355h.startAnimation(alphaAnimation);
        }
    }

    private void q(View view, int i3, ArrayList<d53.b> arrayList, boolean z16) {
        this.f30352e.setVisibility(4);
        QUICardListAnimator u16 = new QUICardListAnimator(this.f30350c).w(arrayList).x(z16).v(0).u(new b());
        this.f30353f = u16;
        u16.y(this.f30352e);
        this.f30353f.s(view, i3);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setFillAfter(true);
        this.f30356i.startAnimation(alphaAnimation);
    }

    public a p(View view, int i3, int i16) {
        synchronized (this) {
            if (this.f30357j) {
                return this;
            }
            boolean z16 = true;
            this.f30357j = true;
            ArrayList<d53.b> arrayList = new ArrayList<>(this.f30351d);
            k();
            this.f30352e = j(i16, arrayList);
            i();
            if (i16 == 0) {
                z16 = false;
            }
            q(view, i3, arrayList, z16);
            this.f30352e.scrollToPosition(i3);
            return this;
        }
    }

    public a s(List<d53.b> list) {
        this.f30351d = list;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements RecyclerView.OnItemTouchListener {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0) {
                a.this.f30348a = x16;
                a.this.f30349b = 0;
            } else {
                a.this.f30349b += Math.abs(x16 - a.this.f30348a);
                a.this.f30348a = x16;
            }
            int[] iArr = new int[2];
            View view = null;
            int i3 = 0;
            while (true) {
                if (i3 >= recyclerView.getChildCount()) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i3);
                View findViewById = childAt.findViewById(R.id.f65843_1);
                if (findViewById != null) {
                    findViewById.getLocationInWindow(iArr);
                    if (iArr[0] > 0) {
                        iArr[0] = ((int) findViewById.getX()) + ((int) childAt.getX());
                        view = findViewById;
                        break;
                    }
                }
                i3++;
                view = findViewById;
            }
            if (view == null) {
                return false;
            }
            int i16 = iArr[0];
            if (x16 - i16 >= 0 && x16 - i16 <= view.getMeasuredWidth()) {
                float f16 = y16;
                if (f16 - view.getY() >= 0.0f && f16 - view.getY() <= view.getMeasuredHeight()) {
                    a.this.m((QUIButton) view.findViewById(R.id.f65853_2), motionEvent);
                    return false;
                }
            }
            view.findViewById(R.id.f65853_2).setPressed(false);
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.n();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public a r(e eVar) {
        return this;
    }

    public a t(b53.a aVar) {
        return this;
    }

    public a u(a.c cVar) {
        return this;
    }
}
