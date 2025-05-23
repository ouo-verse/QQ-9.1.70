package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.filemanager.util.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class f extends m implements h {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    protected TextView F;
    protected TextView G;
    protected TextView H;
    protected ImageView I;
    protected ImageView J;
    protected ImageView K;
    protected View L;
    protected GestureSelectGridView M;
    protected RelativeLayout N;
    protected boolean P;
    protected TextView Q;
    public com.tencent.common.galleryactivity.d R;
    protected com.tencent.common.galleryactivity.a S;
    protected boolean T;
    h U;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.common.galleryactivity.e f99869h;

    /* renamed from: i, reason: collision with root package name */
    protected Activity f99870i;

    /* renamed from: m, reason: collision with root package name */
    int f99871m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.this.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.this.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.this.F();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.this.B();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.this.C();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void D() {
        if (this.T) {
            this.L.setVisibility(0);
        } else {
            this.L.setVisibility(8);
        }
        this.I.setOnClickListener(new c());
        this.J.setOnClickListener(new d());
        ImageView imageView = this.K;
        if (imageView != null) {
            imageView.setOnClickListener(new e());
        }
    }

    private void E() {
        TextView textView = this.G;
        if (textView != null) {
            GalleryManager galleryManager = this.f99886f;
            if (galleryManager != null && galleryManager.f99841i) {
                this.Q.setVisibility(0);
                this.Q.setText("");
                ((ViewGroup.MarginLayoutParams) this.Q.getLayoutParams()).setMargins(BaseAIOUtils.f(16.0f, this.f99870i.getResources()), 0, 0, 0);
                this.G.setVisibility(8);
                this.Q.setOnClickListener(new a());
            } else {
                textView.setVisibility(0);
                this.Q.setVisibility(8);
                this.G.setText(R.string.f170202in);
                this.G.setOnClickListener(new b());
            }
        }
        TextView textView2 = this.H;
        if (textView2 != null) {
            textView2.setVisibility(0);
            this.H.setText(R.string.f170286ld);
            this.H.setOnClickListener(t());
        }
    }

    private void v() {
        ((WindowManager) this.f99870i.getSystemService("window")).getDefaultDisplay();
        this.E = this.f99870i.getResources().getDimensionPixelSize(R.dimen.f159226xw);
        this.C = this.f99870i.getResources().getDimensionPixelSize(R.dimen.f159227xx);
        this.D = this.f99870i.getResources().getDimensionPixelSize(R.dimen.f159228xy);
        this.f99871m = ((ViewUtils.getScreenWidth() - (this.E * 2)) - (this.C * 3)) / 4;
    }

    private void w(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f99870i).inflate(R.layout.ar3, (ViewGroup) null);
        this.N = relativeLayout;
        if (viewGroup == null) {
            this.f99870i.addContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } else {
            viewGroup.addView(relativeLayout, 0);
        }
        p(this.N);
        this.F = (TextView) this.f99870i.findViewById(R.id.title);
        this.G = (TextView) this.f99870i.findViewById(R.id.az7);
        this.H = (TextView) this.f99870i.findViewById(R.id.ilx);
        this.I = (ImageView) this.f99870i.findViewById(R.id.cju);
        this.J = (ImageView) this.f99870i.findViewById(R.id.ifu);
        this.K = (ImageView) this.f99870i.findViewById(R.id.l2r);
        this.L = this.f99870i.findViewById(R.id.f164243oa);
        this.Q = (TextView) this.f99870i.findViewById(R.id.aui);
        GestureSelectGridView gestureSelectGridView = (GestureSelectGridView) this.f99870i.findViewById(R.id.f164193lz);
        this.M = gestureSelectGridView;
        gestureSelectGridView.setScrollBarStyle(0);
        this.M.setNumColumns(4);
        this.M.setColumnWidth(this.f99871m);
        this.M.setHorizontalSpacing(this.C);
        this.M.setVerticalSpacing(this.D);
        GestureSelectGridView gestureSelectGridView2 = this.M;
        gestureSelectGridView2.setPadding(this.E, gestureSelectGridView2.getPaddingTop(), this.E, this.M.getPaddingBottom());
        this.M.setOnItemClickListener(q());
        this.M.setOnIndexChangedListener(r());
        com.tencent.common.galleryactivity.d s16 = s(this.f99870i, this.f99871m);
        this.R = s16;
        this.M.setAdapter((ListAdapter) s16);
        this.F.setText(R.string.hq7);
        E();
        D();
        this.N.setVisibility(4);
        av.a((ViewGroup) this.L, this.I, this.J, this.K);
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.F.setText(R.string.hq7);
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GalleryComponent", 2, "imagelist onstart");
        }
    }

    protected abstract void B();

    protected abstract void C();

    protected abstract void F();

    @Override // com.tencent.common.galleryactivity.m
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        x();
        this.f99870i.finish();
        if (this.P) {
            this.f99870i.overridePendingTransition(R.anim.f154567be, R.anim.f154563bb);
            return true;
        }
        this.f99870i.overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        return true;
    }

    @Override // com.tencent.common.galleryactivity.m
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.k();
        this.T = false;
        this.R = null;
        this.f99869h = null;
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    protected abstract AdapterView.OnItemClickListener q();

    protected abstract GestureSelectGridView.OnSelectListener r();

    protected abstract com.tencent.common.galleryactivity.d s(Activity activity, int i3);

    protected abstract View.OnClickListener t();

    public Rect u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Rect) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        int firstVisiblePosition = this.M.getFirstVisiblePosition();
        View childAt = this.M.getChildAt(this.f99869h.getSelectedIndex() - firstVisiblePosition);
        if (childAt != null) {
            return j.d(childAt);
        }
        return null;
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void y(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
            return;
        }
        this.S = this.f99886f.j();
        v();
        w(viewGroup);
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f99886f.j().a(this.U);
        }
    }
}
