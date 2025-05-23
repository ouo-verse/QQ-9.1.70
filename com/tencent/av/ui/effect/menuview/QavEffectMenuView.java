package com.tencent.av.ui.effect.menuview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.m;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.FilterToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.InteractiveToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.VoiceChangeToolbar;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavEffectMenuView extends QavEffectBaseMenuView {
    private WeakReference<AVActivity> E;
    RelativeLayout F;
    RelativeLayout G;
    RelativeLayout H;
    LinearLayout I;
    private final View.OnClickListener J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            BaseToolbar.keepInToolbar(((QavMenuBaseView) QavEffectMenuView.this).f75038e, -1008L);
            QLog.w("QavEffectMenuView", 1, "m_qav_effect_bottom, onTouchEvent[" + motionEvent.getAction() + "]");
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            m R;
            EventCollector.getInstance().onViewClickedBefore(view);
            long d16 = e.d();
            int id5 = view.getId();
            Object tag = view.getTag(R.id.jae);
            if (tag instanceof Boolean) {
                z16 = ((Boolean) tag).booleanValue();
            } else {
                z16 = false;
            }
            QavEffectMenuView qavEffectMenuView = QavEffectMenuView.this;
            int i3 = qavEffectMenuView.f75552m;
            boolean C = qavEffectMenuView.C(d16, id5, z16);
            if (C && i3 != id5) {
                ((QavMenuBaseView) QavEffectMenuView.this).f75038e.k0(new Object[]{6105, Integer.valueOf(id5), Long.valueOf(d16)});
            }
            if (C && (R = r.h0().R(true)) != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QavEffectMenuView", 1, "onShow clear state");
                }
                R.c(id5);
            }
            ((QavMenuBaseView) QavEffectMenuView.this).f75038e.k0(new Object[]{165, 1});
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QavEffectMenuView(Context context) {
        super(context);
        this.E = null;
        this.J = new b();
        if (context instanceof AVActivity) {
            this.E = new WeakReference<>((AVActivity) context);
        }
    }

    private void J() {
        this.f75038e.j0(1, null);
        this.f75038e.j0(2, null);
    }

    private void K(long j3) {
        boolean g16 = VideoUtil.g(this.f75038e, true);
        boolean a16 = uv.b.f().a(this.f75038e);
        AVCoreLog.printColorLog("QavEffectMenuView", "initBtn:" + g16 + "|" + a16);
        t(a16, PendantToolbar.class);
        t(g16, InteractiveToolbar.class);
        t(true, FilterToolbar.class);
        t(true, VoiceChangeToolbar.class);
        if (r.h0() != null) {
            setSelectedBtn(n.e().f().f73010c2);
        }
    }

    void L(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("QavEffectMenuView", 2, "initUi, seq[" + j3 + "]");
        }
        setGravity(80);
        View inflate = this.E.get().getLayoutInflater().inflate(R.layout.fty, this);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f75473z2);
        this.F = relativeLayout;
        relativeLayout.setOnTouchListener(new a());
        this.G = (RelativeLayout) inflate.findViewById(R.id.f75483z3);
        this.H = (RelativeLayout) inflate.findViewById(R.id.f75463z1);
        this.I = (LinearLayout) inflate.findViewById(R.id.f166093yo1);
        J();
        K(j3);
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
        L(-1053L);
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void e(long j3) {
        URLDrawable.clearMemoryCache();
        if (!this.E.get().f74683y0 && r.h0() != null && n.e().f().f73043k != 0 && n.e().f().f73043k != 7) {
            n.e().f().f73010c2 = this.f75552m;
        }
        this.E = null;
        super.e(j3);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void f(long j3, boolean z16) {
        super.f(j3, z16);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void g(long j3, boolean z16) {
        super.g(j3, z16);
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView
    protected View.OnClickListener n() {
        return this.J;
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView
    protected ViewGroup o() {
        return this.I;
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView
    protected ViewGroup p() {
        return this.H;
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView
    protected ViewGroup r() {
        return this.G;
    }

    @Override // com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView
    protected void s(long j3) {
        this.f75038e.k0(new Object[]{6105, 100, Long.valueOf(j3)});
    }
}
