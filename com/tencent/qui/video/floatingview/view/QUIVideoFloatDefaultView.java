package com.tencent.qui.video.floatingview.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.qui.quiblurview.f;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QUIVideoFloatDefaultView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private FrameLayout C;
    private ImageView D;
    private ImageView E;
    private FrameLayout F;
    private boolean G;
    private boolean H;
    private b I;
    private QQBlurView J;
    private FrameLayout K;
    private ImageView L;
    private FrameLayout M;
    private ImageView N;
    private SeekBar P;
    private Runnable Q;
    private View R;
    private View S;

    /* renamed from: d, reason: collision with root package name */
    private bz3.b f363921d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.qui.video.floatingview.e f363922e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f363923f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f363924h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f363925i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f363926m;

    public QUIVideoFloatDefaultView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void d() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.hga, (ViewGroup) this, false);
        this.f363923f = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.f363924h = (ImageView) this.f363923f.findViewById(R.id.f66573b0);
        this.D = (ImageView) this.f363923f.findViewById(R.id.f66533aw);
        this.E = (ImageView) this.f363923f.findViewById(R.id.f66493as);
        this.F = (FrameLayout) this.f363923f.findViewById(R.id.f66513au);
        this.J = (QQBlurView) this.f363923f.findViewById(R.id.f66523av);
        this.K = (FrameLayout) this.f363923f.findViewById(R.id.f66133_t);
        this.L = (ImageView) this.f363923f.findViewById(R.id.f66143_u);
        this.M = (FrameLayout) this.f363923f.findViewById(R.id.f66373ag);
        this.N = (ImageView) this.f363923f.findViewById(R.id.f66383ah);
        this.P = (SeekBar) this.f363923f.findViewById(R.id.f66553ay);
        this.f363925i = (FrameLayout) this.f363923f.findViewById(R.id.f66563az);
        this.f363926m = (FrameLayout) this.f363923f.findViewById(R.id.f66543ax);
        this.C = (FrameLayout) this.f363923f.findViewById(R.id.f66503at);
        this.R = this.f363923f.findViewById(R.id.f66483ar);
        this.S = this.f363923f.findViewById(R.id.f66463ap);
        this.f363923f.findViewById(R.id.f65973_d).setOnClickListener(this);
        this.P.setEnabled(false);
        this.f363924h.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.f363926m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.f363925i.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.M.setOnClickListener(this);
        com.tencent.biz.qui.quicommon.e.o(this.F, 8);
        com.tencent.biz.qui.quicommon.e.o(this.J, 8);
        w(this.G);
        v(this.H);
        e();
    }

    private void e() {
        this.Q = new Runnable() { // from class: com.tencent.qui.video.floatingview.view.d
            @Override // java.lang.Runnable
            public final void run() {
                QUIVideoFloatDefaultView.this.h();
            }
        };
    }

    private static boolean f() {
        if (com.tencent.qui.video.floatingview.d.i().g()) {
            return false;
        }
        ud0.d.a("QUIVideoFloatDefaultVie", ud0.d.f438811e, "interceptor click");
        ud0.f.b(ud0.b.a(), 1, ud0.b.a().getResources().getString(R.string.f2171960c), 0);
        return true;
    }

    private boolean g() {
        if (this.E.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        q(false);
    }

    private void i() {
        bz3.b bVar = this.f363921d;
        if (bVar == null) {
            return;
        }
        bVar.o();
    }

    private void j() {
        bz3.b bVar = this.f363921d;
        if (bVar == null) {
            return;
        }
        if (!this.G) {
            bVar.l();
        } else {
            bVar.h();
        }
    }

    private void k() {
        bz3.b bVar = this.f363921d;
        if (bVar == null) {
            return;
        }
        if (this.H) {
            bVar.onPause();
        } else {
            bVar.onPlay();
        }
    }

    private void l() {
        bz3.b bVar = this.f363921d;
        if (bVar == null) {
            return;
        }
        bVar.i();
    }

    private void m() {
        bz3.b bVar = this.f363921d;
        if (bVar == null) {
            return;
        }
        bVar.d();
        this.f363921d.n();
    }

    private void n(boolean z16) {
        b bVar = this.I;
        if (bVar != null) {
            bVar.a(z16);
        }
    }

    private void t() {
        removeCallbacks(this.Q);
        postDelayed(this.Q, 3000L);
    }

    private boolean x() {
        if (Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        return false;
    }

    public void b(View view, com.tencent.qui.video.floatingview.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) eVar);
            return;
        }
        this.f363922e = eVar;
        this.F.addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
        t();
    }

    public FrameLayout c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.F;
    }

    public void o(boolean z16) {
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (this.J.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 == z17) {
            return;
        }
        QQBlurView qQBlurView = this.J;
        int i16 = 8;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qQBlurView.setVisibility(i3);
        View view = this.S;
        if (z16) {
            i16 = 0;
        }
        view.setVisibility(i16);
        if (!z16) {
            if (x()) {
                this.F.setRenderEffect(null);
            } else {
                this.J.setEnableBlur(false);
            }
        }
        this.S.setAlpha(1.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            boolean z16 = true;
            if (view.getId() != R.id.f66573b0 && view.getId() != R.id.f66563az) {
                if (view.getId() != R.id.f66533aw && view.getId() != R.id.f66543ax) {
                    if (view.getId() != R.id.f66493as && view.getId() != R.id.f66503at) {
                        if (view.getId() == R.id.f65973_d) {
                            if (g()) {
                                if (!f()) {
                                    m();
                                }
                            } else {
                                q(true);
                            }
                        } else if (view.getId() == R.id.f66133_t || view.getId() == R.id.f66373ag) {
                            if (view.getId() != R.id.f66133_t) {
                                z16 = false;
                            }
                            n(z16);
                        }
                    } else {
                        l();
                        b bVar = this.I;
                        if (bVar != null) {
                            bVar.onCloseClick();
                        }
                        i();
                    }
                } else {
                    b bVar2 = this.I;
                    if (bVar2 != null) {
                        bVar2.c(!this.H);
                    }
                    if (!f()) {
                        k();
                        v(!this.H);
                    }
                }
            } else {
                b bVar3 = this.I;
                if (bVar3 != null) {
                    bVar3.b(!this.G);
                }
                w(!this.G);
                j();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        FrameLayout frameLayout = this.K;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        if (z16) {
            u(1.0f);
        }
    }

    public void q(boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        ImageView imageView = this.D;
        int i27 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        FrameLayout frameLayout = this.f363926m;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        frameLayout.setVisibility(i16);
        ImageView imageView2 = this.E;
        if (z16) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        imageView2.setVisibility(i17);
        FrameLayout frameLayout2 = this.C;
        if (z16) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        frameLayout2.setVisibility(i18);
        FrameLayout frameLayout3 = this.f363925i;
        if (z16) {
            i19 = 0;
        } else {
            i19 = 8;
        }
        frameLayout3.setVisibility(i19);
        View view = this.R;
        if (z16) {
            i26 = 0;
        } else {
            i26 = 8;
        }
        view.setVisibility(i26);
        SeekBar seekBar = this.P;
        if (!z16) {
            i27 = 8;
        }
        seekBar.setVisibility(i27);
        removeCallbacks(this.Q);
        if (z16) {
            t();
        }
    }

    public void r(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        SeekBar seekBar = this.P;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        seekBar.setVisibility(i3);
    }

    public void s(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        FrameLayout frameLayout = this.M;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        if (z16) {
            u(1.0f);
        }
    }

    public void setClickListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.I = bVar;
        }
    }

    public void setDelegate(bz3.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.f363921d = bVar;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.P.setProgress(i3);
        }
    }

    public void u(float f16) {
        float f17;
        RenderEffect createBlurEffect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        if (this.J.getVisibility() != 0) {
            return;
        }
        float f18 = 0.6f;
        float min = Math.min((1.2f * f16) - 0.36f, 0.6f);
        float f19 = f16 * 32.0f;
        if (f16 > 0.8f) {
            f17 = 32.0f;
        } else {
            f18 = min;
            f17 = f19;
        }
        ud0.d.a("QUIVideoFloatDefaultVie", ud0.d.f438809c, "updateBlurRate:" + f16 + APLogFileUtil.SEPARATOR_LOG + f18);
        this.S.setAlpha(f18);
        if (x()) {
            createBlurEffect = RenderEffect.createBlurEffect(f17, f17, Shader.TileMode.CLAMP);
            this.F.setRenderEffect(createBlurEffect);
        } else {
            this.J.a(new f.a(true, f17, this.F, ResourcesCompat.getColor(getResources(), R.color.qui_common_fill_allblack_strong, null), new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.qui_common_fill_allblack_strong, null)), null));
        }
    }

    public void v(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        com.tencent.qui.video.floatingview.e eVar = this.f363922e;
        if (eVar != null) {
            eVar.j(z16);
        }
        this.H = z16;
        ImageView imageView = this.D;
        Resources resources = getResources();
        if (z16) {
            i3 = R.drawable.qui_pause_filled_icon_white;
        } else {
            i3 = R.drawable.qui_play_filled_icon_white;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
    }

    public void w(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        com.tencent.qui.video.floatingview.e eVar = this.f363922e;
        if (eVar != null) {
            eVar.i(z16);
        }
        this.G = z16;
        ImageView imageView = this.f363924h;
        Resources resources = getResources();
        if (z16) {
            i3 = R.drawable.qui_voice_mute_icon_white_primary;
        } else {
            i3 = R.drawable.qui_voice_high_icon_white_primary;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
    }

    public QUIVideoFloatDefaultView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIVideoFloatDefaultView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public QUIVideoFloatDefaultView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.G = false;
        this.H = true;
        d();
    }
}
