package com.tencent.mobileqq.activity.selectable;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.selectable.g;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a<T extends QBaseActivity> implements View.OnClickListener, com.tencent.qqnt.textpreview.inject.c<T> {
    static IPatchRedirector $redirector_;
    private static int K;
    protected WeakReference<T> C;
    public String D;
    private boolean E;
    private boolean F;
    private long G;
    private int H;
    private int I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private Point f186149d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.qqnt.textpreview.inject.a f186150e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.qqnt.selectable.b f186151f;

    /* renamed from: h, reason: collision with root package name */
    private Integer f186152h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.qqnt.textpreview.b f186153i;

    /* renamed from: m, reason: collision with root package name */
    protected WeakReference<AppRuntime> f186154m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.selectable.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ViewOnTouchListenerC7207a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        ViewOnTouchListenerC7207a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                a.this.f186149d.x = (int) motionEvent.getRawX();
                a.this.f186149d.y = (int) motionEvent.getRawY();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PreviewTextContainerView f186156d;

        b(PreviewTextContainerView previewTextContainerView) {
            this.f186156d = previewTextContainerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) previewTextContainerView);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                a.this.j(this.f186156d, view);
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69333);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            K = -1;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f186149d = new Point();
        this.f186152h = null;
        this.G = -1L;
        this.I = -1;
        this.J = -1;
    }

    public void a(T t16, PreviewTextContainerView previewTextContainerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) previewTextContainerView);
            return;
        }
        this.D = previewTextContainerView.h().getText().toString();
        this.f186153i = new com.tencent.qqnt.textpreview.b();
        this.f186154m = new WeakReference<>(t16.getAppRuntime());
        this.C = new WeakReference<>(t16);
        g(previewTextContainerView);
        if (K == -1) {
            int scaledTouchSlop = ViewConfiguration.get(t16).getScaledTouchSlop();
            K = scaledTouchSlop * scaledTouchSlop;
        }
    }

    public void b(PreviewTextContainerView previewTextContainerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) previewTextContainerView);
            return;
        }
        if (previewTextContainerView != null && previewTextContainerView.h() != null) {
            previewTextContainerView.h().setOnLongClickListener(null);
            previewTextContainerView.h().setOnClickListener(null);
        }
        com.tencent.qqnt.selectable.b bVar = this.f186151f;
        if (bVar != null) {
            bVar.v();
            this.f186151f = null;
        }
        com.tencent.qqnt.textpreview.inject.a aVar = this.f186150e;
        if (aVar != null) {
            aVar.setOnClickListener(null);
            this.f186150e = null;
        }
        this.f186153i = null;
    }

    @Override // com.tencent.qqnt.textpreview.inject.c
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.D = str;
        }
    }

    public void e(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent);
            return;
        }
        com.tencent.qqnt.selectable.a C = com.tencent.qqnt.selectable.a.C();
        if (C.isSelected() && this.E) {
            int action = motionEvent.getAction();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (action == 0) {
                boolean z16 = !C.E(rawX, rawY);
                this.F = z16;
                this.G = C.Q;
                if (z16) {
                    this.I = rawX;
                    this.J = rawY;
                } else {
                    this.I = -1;
                    this.J = -1;
                }
                this.H = 0;
                return;
            }
            if (action == 2) {
                if (this.F && Math.pow(this.I - rawX, 2.0d) + Math.pow(this.J - rawY, 2.0d) > K) {
                    this.H = 2;
                    if (QLog.isColorLevel()) {
                        QLog.d("CommonSelectableMenu", 2, "detect scrolling.");
                        return;
                    }
                    return;
                }
                return;
            }
            if ((action == 1 || action == 3) && this.F) {
                if (this.H == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CommonSelectableMenu", 2, "detect taping.");
                    }
                    long j3 = C.Q;
                    long j16 = this.G;
                    if (j16 != -1 && j3 != -1) {
                        if (j16 == j3) {
                            C.z();
                        }
                    } else {
                        C.z();
                    }
                }
                this.H = 1;
                this.F = false;
                this.G = -1L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (com.tencent.qqnt.selectable.a.C().isSelected()) {
            return com.tencent.qqnt.selectable.a.C().J();
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void g(PreviewTextContainerView previewTextContainerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) previewTextContainerView);
        } else {
            previewTextContainerView.h().setOnTouchListener(new ViewOnTouchListenerC7207a());
            previewTextContainerView.h().setOnLongClickListener(new b(previewTextContainerView));
        }
    }

    protected void h(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        aVar.b(R.id.bbi, HardCodeUtil.qqStr(R.string.kuy), R.drawable.cb5);
        aVar.b(R.id.cjs, HardCodeUtil.qqStr(R.string.kuw), R.drawable.cbd);
        aVar.b(R.id.c39, HardCodeUtil.qqStr(R.string.kux), R.drawable.cbc);
    }

    public void i(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f186152h = Integer.valueOf(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void j(PreviewTextContainerView previewTextContainerView, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) previewTextContainerView, (Object) view);
            return;
        }
        if (view instanceof g) {
            g gVar = (g) view;
            if (view.getContext() != null) {
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                h(aVar);
                if (this.f186150e == null) {
                    c cVar = new c();
                    this.f186150e = cVar;
                    cVar.setOnClickListener(this);
                }
                int f16 = this.f186149d.y - BaseAIOUtils.f(10.0f, view.getResources());
                int dpToPx = this.f186149d.x - ViewUtils.dpToPx(14.0f);
                this.f186150e.h(aVar, false);
                this.f186150e.d(dpToPx, f16);
                this.f186150e.setPoint(dpToPx, f16);
                if (QLog.isColorLevel()) {
                    QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + f16 + ", lastShowX -> " + this.f186149d.x);
                }
                if (this.f186151f == null) {
                    this.f186151f = new com.tencent.qqnt.selectable.b();
                }
                this.f186151f.s(gVar);
                this.f186151f.t(previewTextContainerView, previewTextContainerView);
                this.f186151f.g(this.f186150e);
                this.f186153i.b(view, this.f186150e, this.f186152h);
            }
        }
    }

    public boolean onBackPress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.textpreview.inject.c
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.E = false;
        com.tencent.qqnt.selectable.a C = com.tencent.qqnt.selectable.a.C();
        if (C.isSelected() && C.o()) {
            C.z();
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.c
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.E = true;
        }
    }
}
