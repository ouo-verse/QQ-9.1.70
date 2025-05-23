package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.a;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, com.tencent.mobileqq.colornote.list.e {
    private static int K = 2131105893;
    private static int L = 2131105839;
    private static int M = 2131232824;
    private static final List<com.tencent.mobileqq.colornote.list.f> N = new ArrayList();
    private View C;
    private BounceScrollView D;
    private ColorNoteListLayout E;
    RecyclerView F;
    private boolean G;
    private ImageView H;
    private boolean I = true;
    private boolean J = false;

    /* renamed from: d, reason: collision with root package name */
    private Context f201493d;

    /* renamed from: e, reason: collision with root package name */
    private h f201494e;

    /* renamed from: f, reason: collision with root package name */
    private GestureDetector f201495f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.colornote.list.a f201496h;

    /* renamed from: i, reason: collision with root package name */
    private View f201497i;

    /* renamed from: m, reason: collision with root package name */
    private ViewStub f201498m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (b.this.C == null || b.this.C.getVisibility() != 0 || !b.this.C.hasFocus()) {
                b.this.n();
                Bundle bundle = new Bundle();
                bundle.putInt("start_from", 1);
                ColorNoteSettingFragment.vh(b.this.f201493d, ColorNoteSettingFragment.class, bundle);
                ReportController.o(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.list.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C7457b extends GestureDetector.SimpleOnGestureListener {
        C7457b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b.this.n();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return b.this.f201495f.onTouchEvent(motionEvent);
        }
    }

    static {
        try {
            Iterator<Class<? extends com.tencent.mobileqq.colornote.list.f>> it = com.tencent.mobileqq.colornote.list.d.f201524a.iterator();
            while (it.hasNext()) {
                N.add(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("ColorNoteListController", 1, "[static] ", e16);
        }
    }

    public b(Context context, h hVar) {
        this.f201493d = context;
        this.f201494e = hVar;
    }

    private void l() {
        Iterator<com.tencent.mobileqq.colornote.list.f> it = N.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void m(List<ColorNote> list) {
        Iterator<com.tencent.mobileqq.colornote.list.f> it = N.iterator();
        while (it.hasNext()) {
            it.next().d(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        int width;
        this.J = false;
        View view = this.C;
        if (view != null && view.getVisibility() == 0 && this.C.hasFocus()) {
            return;
        }
        this.f201497i.animate().alpha(0.0f).setDuration(200L).start();
        ViewPropertyAnimator interpolator = this.F.animate().setInterpolator(new AccelerateInterpolator(3.0f));
        if (this.G) {
            width = -this.F.getWidth();
        } else {
            width = this.F.getWidth();
        }
        interpolator.translationX(width).setDuration(180L).setListener(new f()).start();
        l();
    }

    private void o() {
        p();
        View inflate = LayoutInflater.from(this.f201493d).inflate(R.layout.c7o, (ViewGroup) null);
        this.f201497i = inflate;
        this.E = (ColorNoteListLayout) inflate.findViewById(R.id.ldk);
        this.H = (ImageView) this.f201497i.findViewById(R.id.a3u);
        this.D = (BounceScrollView) this.f201497i.findViewById(R.id.lah);
        this.F = this.E.a();
        this.f201498m = (ViewStub) this.f201497i.findViewById(R.id.a3t);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f201493d);
        linearLayoutManager.setOrientation(1);
        this.F.setLayoutManager(linearLayoutManager);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.f201497i.setOnClickListener(this);
        this.H.setOnClickListener(new a());
        this.f201495f = new GestureDetector(new C7457b());
        c cVar = new c();
        this.f201497i.setOnTouchListener(cVar);
        this.f201497i.findViewById(R.id.lah).setOnTouchListener(cVar);
        this.f201497i.setBackgroundResource(L);
        this.f201497i.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.f201493d), 0, 0);
        this.E.setFocusableInTouchMode(true);
        this.E.setFocusable(true);
        this.E.requestFocus();
    }

    private void p() {
        if (QQTheme.isNowThemeIsNight()) {
            K = R.color.f156814c3;
            L = R.color.black;
            M = R.drawable.f160483cg0;
        } else {
            K = R.color.alg;
            L = R.color.f158017al3;
            M = R.drawable.color_note_settings;
        }
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void Pf(AppRuntime appRuntime, boolean z16, int i3, int i16) {
        this.J = true;
        this.G = z16;
        o();
        com.tencent.mobileqq.colornote.list.a aVar = new com.tencent.mobileqq.colornote.list.a(N);
        this.f201496h = aVar;
        aVar.B(this);
        this.f201496h.z(z16);
        List<ColorNote> visiableColorNotes = ((IColorNoteDataService) appRuntime.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
        this.f201496h.A(visiableColorNotes);
        this.F.setAdapter(this.f201496h);
        this.F.setVisibility(4);
        this.f201496h.C(new d());
        this.E.setAnchor(i3, i16);
        this.E.setHideListener(this);
        this.f201497i.setAlpha(0.0f);
        this.f201497i.animate().alpha(0.9f).setDuration(200L).setListener(new e(z16)).start();
        if (!this.I) {
            this.H.setVisibility(8);
        } else {
            this.H.setVisibility(0);
        }
        m(visiableColorNotes);
    }

    @Override // com.tencent.mobileqq.colornote.list.h
    public void a() {
        n();
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public View getRoot() {
        return this.f201497i;
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public boolean isShowing() {
        return this.J;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
    public void onAnimationsFinished() {
        if (this.f201496h.getItemCount() == 0) {
            n();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ldl || id5 == R.id.ldk || id5 == R.id.ldn) {
            n();
            ReportController.o(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void onPostThemeChanged() {
        p();
        this.f201497i.setBackgroundResource(K);
        this.H.setBackgroundResource(M);
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void refresh() {
        this.f201496h.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void v7(boolean z16) {
        this.J = z16;
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void refresh(List<ColorNote> list) {
        this.f201496h.A(list);
        refresh();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements a.c {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.colornote.list.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class ViewOnClickListenerC7458b implements View.OnClickListener {
            ViewOnClickListenerC7458b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.C.setVisibility(8);
                b.this.C = null;
                if (b.this.f201496h.getItemCount() == 0) {
                    b.this.n();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.colornote.list.a.c
        public void a(View view) {
            b bVar = b.this;
            bVar.C = bVar.f201498m.inflate();
            b.this.C.setOnClickListener(new a());
            ((TextView) b.this.C.findViewById(R.id.a65)).setOnClickListener(new ViewOnClickListenerC7458b());
            ReportController.o(null, "dc00898", "", "", "0X800A8AD", "0X800A8AD", 0, 0, "", "", "", "");
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f201505d;

        e(boolean z16) {
            this.f201505d = z16;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int measuredWidth;
            b.this.f201497i.scrollTo(0, 0);
            b.this.f201497i.setAlpha(1.0f);
            b.this.f201497i.setBackgroundColor(b.this.f201493d.getResources().getColor(b.K));
            RecyclerView recyclerView = b.this.F;
            if (this.f201505d) {
                measuredWidth = -recyclerView.getMeasuredWidth();
            } else {
                measuredWidth = recyclerView.getMeasuredWidth();
            }
            recyclerView.setX(measuredWidth);
            b.this.F.setAlpha(0.0f);
            b.this.F.setVisibility(0);
            b.this.F.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0f).translationX(0.0f).setDuration(180L).start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f extends com.tencent.mobileqq.widget.f {
        f() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f201494e != null) {
                b.this.f201494e.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
