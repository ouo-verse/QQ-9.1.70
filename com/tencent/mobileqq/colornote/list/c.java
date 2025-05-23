package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
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
import com.tencent.mobileqq.colornote.list.ColorNoteListLayoutV2;
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
public class c implements com.tencent.mobileqq.colornote.list.e {
    private static int I = 2131105893;
    private static int J = 2131105839;
    private static int K = 2131232824;
    private static final List<com.tencent.mobileqq.colornote.list.f> L = new ArrayList();
    private BounceScrollView C;
    private ColorNoteListLayoutV2 D;
    private ImageView E;
    private boolean F = true;
    private boolean G = false;
    private boolean H = false;

    /* renamed from: d, reason: collision with root package name */
    private Context f201508d;

    /* renamed from: e, reason: collision with root package name */
    private h f201509e;

    /* renamed from: f, reason: collision with root package name */
    private GestureDetector f201510f;

    /* renamed from: h, reason: collision with root package name */
    private View f201511h;

    /* renamed from: i, reason: collision with root package name */
    private ViewStub f201512i;

    /* renamed from: m, reason: collision with root package name */
    private View f201513m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (c.this.f201513m == null || c.this.f201513m.getVisibility() != 0 || !c.this.f201513m.hasFocus()) {
                c.this.n();
                Bundle bundle = new Bundle();
                bundle.putInt("start_from", 1);
                ColorNoteSettingFragment.vh(c.this.f201508d, ColorNoteSettingFragment.class, bundle);
                ReportController.o(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            c.this.n();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.list.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnTouchListenerC7459c implements View.OnTouchListener {
        ViewOnTouchListenerC7459c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return c.this.f201510f.onTouchEvent(motionEvent);
        }
    }

    static {
        try {
            Iterator<Class<? extends com.tencent.mobileqq.colornote.list.f>> it = com.tencent.mobileqq.colornote.list.d.f201524a.iterator();
            while (it.hasNext()) {
                L.add(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("ColorNoteListControllerV2", 1, "[static] ", e16);
        }
    }

    public c(Context context, h hVar) {
        this.f201508d = context;
        this.f201509e = hVar;
    }

    private void l() {
        Iterator<com.tencent.mobileqq.colornote.list.f> it = L.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void m(List<ColorNote> list) {
        Iterator<com.tencent.mobileqq.colornote.list.f> it = L.iterator();
        while (it.hasNext()) {
            it.next().d(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.G = false;
        View view = this.f201513m;
        if (view != null && view.getVisibility() == 0 && this.f201513m.hasFocus()) {
            return;
        }
        o();
        ReportController.o(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
        l();
    }

    private void o() {
        int width;
        this.f201511h.animate().alpha(0.0f).setDuration(200L).start();
        ViewPropertyAnimator interpolator = this.D.animate().setInterpolator(new AccelerateInterpolator(3.0f));
        if (this.H) {
            width = -this.D.getWidth();
        } else {
            width = this.D.getWidth();
        }
        interpolator.translationX(width).setDuration(180L).setListener(new f()).start();
    }

    private void p() {
        q();
        View inflate = LayoutInflater.from(this.f201508d).inflate(R.layout.e37, (ViewGroup) null);
        this.f201511h = inflate;
        this.D = (ColorNoteListLayoutV2) inflate.findViewById(R.id.f164841u10);
        this.E = (ImageView) this.f201511h.findViewById(R.id.a3u);
        this.C = (BounceScrollView) this.f201511h.findViewById(R.id.lah);
        this.f201512i = (ViewStub) this.f201511h.findViewById(R.id.a3t);
        View findViewById = this.f201511h.findViewById(R.id.u0y);
        this.D.setVisibility(4);
        this.D.setParentScroll(this.C);
        findViewById.setOnClickListener(this);
        this.E.setOnClickListener(new a());
        this.f201510f = new GestureDetector(new b());
        ViewOnTouchListenerC7459c viewOnTouchListenerC7459c = new ViewOnTouchListenerC7459c();
        this.f201511h.setOnTouchListener(viewOnTouchListenerC7459c);
        this.f201511h.findViewById(R.id.lah).setOnTouchListener(viewOnTouchListenerC7459c);
        this.f201511h.setBackgroundResource(J);
        this.f201511h.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.f201508d), 0, 0);
    }

    private void q() {
        if (QQTheme.isNowThemeIsNight()) {
            I = R.color.f156814c3;
            J = R.color.black;
            K = R.drawable.f160483cg0;
        } else {
            I = R.color.alg;
            J = R.color.f158017al3;
            K = R.drawable.color_note_settings;
        }
    }

    private void r() {
        this.D.setRecentNoteListener(new d());
    }

    private void s(boolean z16) {
        this.f201511h.setAlpha(0.0f);
        this.f201511h.animate().alpha(0.9f).setDuration(200L).setListener(new e(z16)).start();
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void Pf(AppRuntime appRuntime, boolean z16, int i3, int i16) {
        this.G = true;
        this.H = z16;
        p();
        this.D.setColorNoteListListeners(L);
        this.D.setHideListener(this);
        List<ColorNote> visiableColorNotes = ((IColorNoteDataService) appRuntime.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
        this.D.y(visiableColorNotes);
        r();
        this.D.setHideListener(this);
        s(z16);
        if (!this.F) {
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
        }
        m(visiableColorNotes);
    }

    @Override // com.tencent.mobileqq.colornote.list.h
    public void a() {
        n();
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public View getRoot() {
        return this.f201511h;
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public boolean isShowing() {
        return this.G;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.u0y) {
            n();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void onPostThemeChanged() {
        q();
        this.f201511h.setBackgroundResource(I);
        this.E.setBackgroundResource(K);
        this.D.A();
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void refresh() {
        this.D.A();
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void v7(boolean z16) {
        this.G = z16;
    }

    @Override // com.tencent.mobileqq.colornote.list.e
    public void refresh(List<ColorNote> list) {
        this.D.y(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements ColorNoteListLayoutV2.d {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ColorNote f201519d;

            b(ColorNote colorNote) {
                this.f201519d = colorNote;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.this.f201513m.setVisibility(8);
                c.this.f201513m = null;
                c.this.D.s(this.f201519d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.colornote.list.ColorNoteListLayoutV2.d
        public void a(View view) {
            ColorNote colorNote = (ColorNote) view.getTag();
            c cVar = c.this;
            cVar.f201513m = cVar.f201512i.inflate();
            c.this.f201513m.setOnClickListener(new a());
            ((TextView) c.this.f201513m.findViewById(R.id.a65)).setOnClickListener(new b(colorNote));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f201521d;

        e(boolean z16) {
            this.f201521d = z16;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int measuredWidth;
            c.this.f201511h.scrollTo(0, 0);
            c.this.f201511h.setAlpha(1.0f);
            c.this.f201511h.setBackgroundColor(c.this.f201508d.getResources().getColor(c.I));
            ColorNoteListLayoutV2 colorNoteListLayoutV2 = c.this.D;
            if (this.f201521d) {
                measuredWidth = -c.this.D.getMeasuredWidth();
            } else {
                measuredWidth = c.this.D.getMeasuredWidth();
            }
            colorNoteListLayoutV2.setX(measuredWidth);
            c.this.D.setAlpha(0.0f);
            c.this.D.setVisibility(0);
            c.this.D.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0f).translationX(0.0f).setDuration(180L).start();
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
            c.this.D.t();
            if (c.this.f201509e != null) {
                c.this.f201509e.a();
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
