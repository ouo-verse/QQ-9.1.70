package com.qq.e.comm.plugin.tangramsplash;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ITangramDecoderPlayer;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.b;
import com.qq.e.comm.plugin.base.ad.e.b;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.s;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.base.adevent.ADLifeEvent;
import com.qq.e.comm.plugin.k.ab;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.av;
import com.qq.e.comm.plugin.k.ba;
import com.qq.e.comm.plugin.k.e;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.k;
import com.qq.e.comm.plugin.k.n;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.interactive.a;
import com.qq.e.comm.plugin.tangramsplash.interactive.gesture.DrawGestureManager;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.RoundRectUtil;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.splash.SplashOrder;
import com.qq.e.tg.splash.TGSplashAD;
import com.qq.e.tg.splash.lifecycle.TADSplashLifeCycleHolder;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayInfo;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class f extends FrameLayout implements com.qq.e.comm.plugin.base.adevent.a, e.a, c.a {

    /* renamed from: a, reason: collision with root package name */
    static int f39909a = 1;

    /* renamed from: b, reason: collision with root package name */
    static int f39910b = 2;

    /* renamed from: c, reason: collision with root package name */
    static int f39911c = 3;
    private int A;
    private com.qq.e.comm.plugin.tangramsplash.e.a B;
    private int C;
    private View D;
    private View E;
    private TextView F;
    private LinearLayout G;
    private TextView H;
    private ImageView I;
    private View J;
    private Rect K;
    private ITangramDecoderPlayer L;
    private boolean M;
    private volatile boolean N;
    private WeakReference<a> O;
    private volatile boolean P;
    private Map<String, String> Q;
    private View R;
    private volatile boolean S;
    private volatile boolean T;
    private av U;
    private av V;
    private av W;
    private com.qq.e.comm.plugin.tangramsplash.e.c aA;
    private com.qq.e.comm.plugin.tangramsplash.e.b aB;
    private TextView aC;
    private TextView aD;
    private View aE;
    private FrameLayout aF;
    private volatile boolean aG;
    private long aH;
    private boolean aI;
    private volatile boolean aJ;

    /* renamed from: aa, reason: collision with root package name */
    private com.qq.e.comm.plugin.tangramsplash.d.c f39912aa;

    /* renamed from: ab, reason: collision with root package name */
    private int f39913ab;

    /* renamed from: ac, reason: collision with root package name */
    private LoadAdParams f39914ac;

    /* renamed from: ad, reason: collision with root package name */
    private int f39915ad;

    /* renamed from: ae, reason: collision with root package name */
    private volatile boolean f39916ae;

    /* renamed from: af, reason: collision with root package name */
    private volatile boolean f39917af;

    /* renamed from: ag, reason: collision with root package name */
    private long f39918ag;

    /* renamed from: ah, reason: collision with root package name */
    private int f39919ah;

    /* renamed from: ai, reason: collision with root package name */
    private boolean f39920ai;

    /* renamed from: aj, reason: collision with root package name */
    private boolean f39921aj;

    /* renamed from: ak, reason: collision with root package name */
    private boolean f39922ak;

    /* renamed from: al, reason: collision with root package name */
    private volatile boolean f39923al;

    /* renamed from: am, reason: collision with root package name */
    private Point f39924am;

    /* renamed from: an, reason: collision with root package name */
    private Point f39925an;

    /* renamed from: ao, reason: collision with root package name */
    private Point f39926ao;

    /* renamed from: ap, reason: collision with root package name */
    private boolean f39927ap;

    /* renamed from: aq, reason: collision with root package name */
    private boolean f39928aq;

    /* renamed from: ar, reason: collision with root package name */
    private View f39929ar;

    /* renamed from: as, reason: collision with root package name */
    private ImageView f39930as;

    /* renamed from: at, reason: collision with root package name */
    private View f39931at;

    /* renamed from: au, reason: collision with root package name */
    private long f39932au;

    /* renamed from: av, reason: collision with root package name */
    private v f39933av;

    /* renamed from: aw, reason: collision with root package name */
    private volatile boolean f39934aw;

    /* renamed from: ax, reason: collision with root package name */
    private SlideGestureViewHelper f39935ax;

    /* renamed from: ay, reason: collision with root package name */
    private View f39936ay;

    /* renamed from: az, reason: collision with root package name */
    private ImageView f39937az;

    /* renamed from: d, reason: collision with root package name */
    com.qq.e.comm.plugin.tangramsplash.selector.c f39938d;

    /* renamed from: e, reason: collision with root package name */
    private String f39939e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f39940f;

    /* renamed from: g, reason: collision with root package name */
    private r f39941g;

    /* renamed from: h, reason: collision with root package name */
    private int f39942h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f39943i;

    /* renamed from: j, reason: collision with root package name */
    private View f39944j;

    /* renamed from: k, reason: collision with root package name */
    private View f39945k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f39946l;

    /* renamed from: m, reason: collision with root package name */
    private ADListener f39947m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f39948n;

    /* renamed from: o, reason: collision with root package name */
    private com.qq.e.comm.plugin.tangramsplash.video.b f39949o;

    /* renamed from: p, reason: collision with root package name */
    private int f39950p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f39951q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39952r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f39953s;

    /* renamed from: t, reason: collision with root package name */
    private volatile boolean f39954t;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f39955u;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f39956v;

    /* renamed from: w, reason: collision with root package name */
    private Bitmap f39957w;

    /* renamed from: x, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.c f39958x;

    /* renamed from: y, reason: collision with root package name */
    private int f39959y;

    /* renamed from: z, reason: collision with root package name */
    private View f39960z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public File f39994a;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f39995b;

        /* renamed from: c, reason: collision with root package name */
        public long f39996c;

        b() {
        }

        public boolean a() {
            if (this.f39995b != null) {
                return true;
            }
            return false;
        }
    }

    public f(Context context, String str, String str2) {
        super(context);
        this.f39940f = false;
        this.f39950p = 1;
        this.f39952r = true;
        this.f39953s = true;
        this.f39954t = false;
        this.f39955u = false;
        this.f39956v = false;
        this.f39957w = null;
        this.f39959y = 1;
        this.A = 0;
        this.C = 0;
        this.M = false;
        this.N = true;
        this.P = false;
        this.S = true;
        this.T = false;
        this.f39913ab = 1;
        this.f39915ad = 0;
        this.f39916ae = false;
        this.f39917af = false;
        this.f39918ag = 0L;
        this.f39919ah = f39909a;
        this.f39920ai = false;
        this.f39921aj = false;
        this.f39922ak = false;
        this.f39923al = false;
        this.f39928aq = true;
        this.f39932au = 0L;
        this.f39934aw = false;
        this.aG = false;
        this.aJ = false;
        this.f39939e = str2;
        this.f39938d = new com.qq.e.comm.plugin.tangramsplash.selector.c(str, str2, this);
    }

    private int U() {
        com.qq.e.comm.plugin.tangramsplash.video.b bVar = this.f39949o;
        if (bVar == null) {
            return 0;
        }
        int g16 = bVar.g();
        int bN = this.f39941g.bN();
        if (bN > 0) {
            return Math.min(g16, bN * 1000);
        }
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView V() {
        TextView textView = new TextView(getContext());
        textView.setText("\u5173\u95ed\u5e7f\u544a\u52a8\u753b");
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(-1);
        textView.setMaxLines(1);
        textView.setMaxEms(10);
        textView.setGravity(17);
        textView.setPadding(ak.a(getContext(), 20), 0, ak.a(getContext(), 20), 0);
        textView.setBackgroundDrawable(RoundRectUtil.createRoundRectBorderDrawable(76.0f, Color.parseColor("#FFFFFF"), ak.a(getContext(), 1) / 2, Color.parseColor("#99333333")));
        textView.setId(22);
        textView.setOnClickListener(this.f39912aa);
        return textView;
    }

    private void W() {
        long j3;
        r rVar = this.f39941g;
        if (rVar != null && rVar.bJ() != null) {
            int h16 = this.f39941g.bJ().h();
            if (this.T && h16 == 2) {
                com.qq.e.comm.plugin.tangramsplash.interactive.d.a().i();
            }
            if (this.T && !this.S) {
                com.qq.e.comm.plugin.tangramsplash.interactive.d.a().h();
            }
            com.qq.e.comm.plugin.tangramsplash.interactive.d.a().f();
            int n3 = this.f39941g.bJ().n();
            if (this.f39918ag > 0) {
                j3 = System.currentTimeMillis() - this.f39918ag;
            } else {
                j3 = 0;
            }
            if (h16 == 1) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310342, this.f39941g.s(), this.f39941g, f(), this.f39919ah, n3, this.f39940f, this.M);
            } else if (h16 == 2) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310349, this.f39941g.s(), this.f39941g, j3, this.f39919ah, n3, this.f39940f, this.M);
            } else if (h16 == 3) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310354, this.f39941g.s(), this.f39941g, j3, this.f39919ah, n3, this.f39940f, this.M);
            }
        }
    }

    private void X() {
        Integer num;
        int i3;
        ag();
        if (this.f39943i == null) {
            return;
        }
        r rVar = this.f39941g;
        if (rVar != null && rVar.bJ() == null) {
            return;
        }
        String str = this.f39939e;
        r rVar2 = this.f39941g;
        if (rVar2 != null) {
            num = Integer.valueOf(rVar2.bJ().n());
        } else {
            num = null;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310339, str, rVar2, num.intValue(), this.f39940f);
        int i16 = this.f39959y;
        boolean z16 = this.f39940f;
        com.qq.e.comm.plugin.tangramsplash.video.b bVar = this.f39949o;
        if (bVar != null) {
            i3 = bVar.g();
        } else {
            i3 = 0;
        }
        com.qq.e.comm.plugin.tangramsplash.interactive.d.a().a(this.f39941g, new com.qq.e.comm.plugin.tangramsplash.interactive.c(i16, z16, i3, this.M), new c(new WeakReference(this)), Y());
    }

    private a.C0289a Y() {
        r rVar = this.f39941g;
        if (rVar == null || !"FlipInteractive".equals(rVar.bP())) {
            return null;
        }
        a.C0289a c0289a = new a.C0289a();
        c0289a.f40119a = this.f39948n;
        c0289a.f40120b = this.f39957w;
        return c0289a;
    }

    private void Z() {
        if (this.f39941g.bJ().h() == 3) {
            String str = this.f39939e;
            r rVar = this.f39941g;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310352, str, rVar, 0L, rVar.bJ().n(), this.f39940f, this.M);
        }
        com.qq.e.comm.plugin.tangramsplash.video.b bVar = this.f39949o;
        if (bVar != null && bVar.b() != null) {
            this.f39949o.b().setId(13);
        }
        ImageView imageView = this.I;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        i(true);
        ac();
    }

    private void aa() {
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        textView.setVisibility(4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, ak.a(getContext(), 60), 0.0f);
        translateAnimation.setDuration(600L);
        final AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.9
            @Override // java.lang.Runnable
            public void run() {
                f.this.F.setVisibility(0);
                f.this.F.setAnimation(animationSet);
            }
        }, 1000L);
    }

    private void ab() {
        View view = this.f39944j;
        if (view != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.f39951q;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            ba.a(this.f39951q);
        }
        View view2 = this.f39945k;
        if (view2 == null) {
            TextView textView = new TextView(getContext());
            this.aC = textView;
            textView.setText("\u8df3\u8fc7");
            this.aC.setTextSize(2, 14.0f);
            this.aC.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = ak.a(getContext(), 12);
            layoutParams.topMargin = ak.a(getContext(), 16) + n.a(getContext());
            this.aC.setPadding(ak.a(getContext(), 12), ak.a(getContext(), 4), ak.a(getContext(), 12), ak.a(getContext(), 4));
            this.aC.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(50.0f, -16777216, 100));
            this.aC.setId(17);
            this.aC.setOnClickListener(this.f39912aa);
            addView(this.aC, layoutParams);
            return;
        }
        view2.setVisibility(0);
        if (this.f39945k.getParent() == null) {
            addView(this.f39945k);
        }
        this.f39945k.setOnClickListener(this.f39912aa);
        this.f39945k.setId(17);
    }

    private void ac() {
        LinearLayout linearLayout = this.G;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.G = linearLayout2;
        linearLayout2.setGravity(17);
        this.G.setPadding(ak.a(getContext(), 6), 0, ak.a(getContext(), 6), 0);
        this.G.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(ak.a(getContext(), 20), -16777216, 100));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAYAAAH5FsI7AAAABGdBTUEAALGPC/xhBQAAADhlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAAqACAAQAAAABAAAAUKADAAQAAAABAAAAUAAAAAASKG51AAAJBUlEQVR4Ae2cTahVVRTHU6OBZdigEKUm0UCUgiAiHFQ6KRoEoQkFTgszqEGzRjqVdOjQQTR4OkmIbFDkJIjCBvahFUUvbaBk0Bdkqf3+95193j777L32Pueee3vX7oL1zj7r47/W3udrf913002FtCq0uw452SrIlesj+j99Iyl0Dm2rjZywIahOZFnLGye1dLmAflHwCzIULauapVpXF5r60Rm6B+CjEVVTFAXxhRVSMh3lfFYOUD5cM3jkDJQTI6ylPzsjJvVV2O+U2P4ue3c+OrYElRb5+oaucdKAWIok0WrLyPdZHb2VfIuSMtHei0b0hSqLkoBLasMg6TmEgugHXAaZ4xozng9kGqLEdo0LFrVF6e6v+vaJGgbCJGhSEQDETn3f1TKQwBlSvOjKYx0BWugDoGREfXwbPmCM7uYQrP3KrdxCwwZadTLIcxYDni2Z1Ya3UJW/ItX5m7aTLkpRwJILAto1gO1nWSEF5iiWArp1Tq9jzKaWeYaHa2Gi4NnGQTG4WBmdS2C0xB7o2qSypcgIHKgzG70c3AnHb7xy/yJRDlWRkrdDCh2/f+Rb6yugxqFWFhRw/EjOtSnlOyVwVCsKC1E/J+S4qxCnNnO+tcAVpHDl0iMuG5KApSC+XQwsvG18e7MssMrglGkopYvM8VBojOySp78c6qPnOJz0nFLFh6POlhCk5yNod1o+/z9d9AvQtRlo5h34PAXfA6+Df4I/gd/mK3GB43SIRNQjdO/1yOUvEu0bPFvCnjdCf41uN9x4M3O+GT4CW7R1rGRBjiVW/EUMg4O3JZHtxtDWPAek7tx7gK2XjgmSUXq4rng647KkxvoW5+GORY49jMAPb4H8A+WScscecTu5EOegi1Ud9yQBMNgRGO9OGg+oCGK6j147AobHfeO2xWQkxDxjxvWViXJ8EmWgfIn5gx83CotBPa+VNY4i9Bf68VROIqHzO5zDDL6T0ZYUxPT7R8ov3xvBqHPnNZNHVE2cv5WRR69EDactJKGXvaRcsXuHMEwcpI3wx/BLoS53jo969GGLIbpudns7dbeEZiTyD7rv4J/hTbC6Xhadoiv2mGXQS0eO+hQuKtketDLusV41nzvNW2CFtkCn10ysDjzJeqU8DT8Eq+v+G7wIv8Nr5H2O0yeS2glf6fCa0fR/Y1A1kawJsq9DUjFTDVnzs6ldsxcofDUWsafsQNcckvYksDWThAY+m30AzvW10VhZY+YUnfd9epVB3pZA1+qjpjiKCNv9CZw/iwBiRgCq5xKjLTH7Ehlg5yKA/VoyAiTR2Dc4GIcj2N3uSQBOhyAlLVRqk0iyrPI4rw2T43x9afBSOzDDy102BsLxQpDgkdKgXe2CODrNv8xDp65Bu9gTK3y6T5j+OOwJEjxoOgygDOJZQ4rR/H6jKz9A/CwECTZe5qZDp9qYSOVKYuqL49OOpLdvRVmjtIkTccL5yDf8oNba0Fe+4aTK9BmvBNiN4epqv9UCQ7+T0GtvQ4BXetr4xqsFs/Mw1PLZUvQB7LTGUpP2Ih3n7FItaRfuaouGk3AFG101kLUA1Cb/UnvliV9aYoUT6RrjtAnDXV5io2LbanhJp5gY+8tc+YnEMfMlXmOjBufhE92OUNVo4pdWkYk12hdYxdQhPxeOUfapbleru4Q4rWWx7igT8iC52FJbdBV07JmFPnUgwbDXktx9ZH3q+sQ2fcirub102TrfUV22TZcIoAHPh/Ctaau4Bp/wfYdoROOtGbtwQIUB9ErKzsxjc3CURvzPNoefOhbfg+CfAcSqrT6XmkRX6+rzlRulbeIz2/ju4tOiLgmuxfuPFkJ3wWck9mB3t0IPWvLF+NXKSjVaVCWnQwS7DX4TvganSGOcPdPJaB5l3gLzFpi3wLwFpt8CxR/iIVPj06LR2JPw9orv7on/I34fVPwuH3j1Vm4sorE03/0KHE4rI5oYKZZiTq9jMuRlI/GH4dYqBrL/ipRLtuPfpw0Ge4RJUMvYb8GP9knE87lKWXswf4W1LC7SbOHtsKaUcoMITEw6hfa5koGGiTKUkobTUuhluAtpq5uGeQ+Mm4cwKqxw+xxik5Rzdjg5bn5Jf4Jr7rq04bSZTOPpDUnAgRSKUcWKbWBD1SLVwRpGD5RZBUMwTUidaqURF+j3hoMvkJbWSLHh+jeP8RRrqWZyxn092KkRQB+Hkj0f0Rk+G32yWvKO7fVE3CDVbSIfG00ilySgqz3ZqzhGOys3uOSOHPYGIOirsEV632wZo25TdVWucO4dOcwWVgJpc5tFWt6Y+Mdh6BZWznC4NBPWM79UYyUGmnbzWzsD1XVorOhaeCtNp9xhq/ujuvdfBMT5KGzR2P24/7pRqZz6kRYd7ZUjiJssVHQT2yLVK+ExnFSXTF3ji+pWTAD3ZkDDrQUW3IrWUU/9qtOivakKWGubD6WckC8ylpzKNh8jh8FUVV0WDcBkW1gNqMmBFOV/cJnyXLlyq07JtriZ+1ZfmS9gHUvpEd3vgbEmM7fM8KSm1Ztws0JBlfnfUqowrK1Yx1racsExYcxq43EvaHuE9U63Hu/lVgKotVNLd1qGdi0jzGaJ+oUbUsMq7yiuGZ7qPPu7yUIwdy6bLo99cQ7TNqQejS3HroLVsezuC5PGeSEA8k8XQvtZPadS1v4d1bn/3gqcY4/0zD+y7mJTv/AnA2own+yfEDgg6wiae6RvmEdW9aVeudGHVvaG2XtnNfCs6WgUzVKfgy3SzTKbS6KTvCA0ymGr1SrdaY4rdlJ4ku0TxVZjwO5/zlVtlDwciIL8H4U0kWadc4+qa0n996bkcG3q7adk4MY/iaky1bvlNXjw9wuYmhzVVzU3y4xJTfp3z2OtDQ+2M8G/SiT1Lef3+jKj/D26k/CnFX/JkDD6izNw9VUU7v3w4/B2+D64K2ni4AnifN7VcSr2VPR1eKWRliwPwLPxgSBRzfS8AMceZcRTIb0y9sGz0WjW7U0l9APNZ+AFePSv5jkOSVoA0r+70Cri1DrAE3kHWg0Z01Fh7bzSrx+0SKUJijs81qSv5uPEv8B6v+r/G57lHWZNgmIyp3kLzFtg3gJmC/wLDxx8va1iU2sAAAAASUVORK5CYII="));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 15), ak.a(getContext(), 15));
        layoutParams.rightMargin = ak.a(getContext(), 6);
        this.G.addView(imageView, layoutParams);
        TextView textView = new TextView(getContext());
        this.aD = textView;
        textView.setPadding(ak.a(getContext(), 8), ak.a(getContext(), 3), ak.a(getContext(), 8), ak.a(getContext(), 3));
        this.aD.setText("\u91cd\u65b0\u64ad\u653e");
        this.aD.setTextSize(14.0f);
        this.aD.setTextColor(-1);
        this.aD.setGravity(17);
        this.aD.setId(12);
        this.aD.setOnClickListener(this.f39912aa);
        this.G.addView(this.aD);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = ak.a(getContext(), 73);
        addView(this.G, layoutParams2);
    }

    private void ad() {
        T();
        j();
        K();
        P();
        ae();
        M();
        H();
        J();
        L();
        X();
        Q();
        y();
    }

    private void ae() {
        v H = this.f39941g.H(2);
        if (H != null) {
            View a16 = a(H);
            this.f39936ay = a16;
            a16.setId(15);
            this.f39936ay.setOnClickListener(this.f39912aa);
        }
    }

    private String af() {
        try {
            this.f39958x.b(System.currentTimeMillis());
            this.f39958x.a().a("41");
            com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39958x, this.f39943i.getWidth(), this.f39943i.getHeight());
            this.f39958x.a().b(this.f39943i.getWidth());
            this.f39958x.a().a(this.f39943i.getHeight());
            return URLEncoder.encode(this.f39958x.b(), "UTF-8");
        } catch (Exception e16) {
            GDTLogger.w("GetAntiSpamInfoException:" + e16.getMessage());
            return null;
        }
    }

    private void ag() {
        r rVar = this.f39941g;
        if (rVar == null) {
            GDTLogger.d("calculateAndSetSplashViewFilterRects null splashAdInfo");
            return;
        }
        if (rVar.bJ() == null) {
            GDTLogger.d("calculateAndSetSplashViewFilterRects null interactiveInfo");
            return;
        }
        InteractiveInfo.b g16 = this.f39941g.bJ().g();
        if (g16 == null) {
            GDTLogger.d("calculateAndSetSplashViewFilterRects null imageAnimationInfo");
            return;
        }
        AnimationPlayInfo a16 = g16.a();
        if (a16 == null) {
            GDTLogger.d("calculateAndSetSplashViewFilterRects null imageAnimationInfo");
            return;
        }
        a(a16);
        ArrayList arrayList = new ArrayList();
        if (com.qq.e.comm.plugin.j.c.a("redPackRainUnderAllView", 0, 1)) {
            int childCount = getChildCount();
            if (childCount <= 1) {
                return;
            }
            for (int i3 = 1; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getId() != 15) {
                    GDTLogger.d("FilterRects child id =" + childAt.getId());
                    a(childAt, arrayList);
                }
            }
        } else {
            a(this.f39944j, arrayList);
            a(this.f39945k, arrayList);
            a(this.f39951q, arrayList);
            a(this.f39931at, arrayList);
        }
        g16.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        int i3;
        if (this.f39941g == null) {
            GDTLogger.d("doReportVideoInfo splashAdInfo\u4e3a\u7a7a\uff0c\u4e0d\u4e0a\u62a5\u89c6\u9891\u64ad\u653e\u6548\u679c\uff01");
            return;
        }
        if (this.f39919ah == f39910b && this.f39949o != null) {
            int i16 = 0;
            if (!com.qq.e.comm.plugin.j.c.a("splashVideoReport", 0, 1)) {
                GDTLogger.d("doReportVideoInfo \u672a\u5f00\u542f\u89c6\u9891\u64ad\u653e\u4e0a\u62a5");
                return;
            }
            com.qq.e.comm.plugin.base.ad.model.a aVar = new com.qq.e.comm.plugin.base.ad.model.a(this.f39941g.u(), com.qq.e.comm.plugin.base.ad.b.SPLASH, this.f39941g.s());
            if (this.f39950p == 0) {
                i3 = this.f39949o.h();
            } else {
                i3 = 0;
            }
            if (this.f39950p == 0) {
                i16 = this.f39949o.g();
            }
            int i17 = i16;
            GDTLogger.d("doReportVideoInfo VideoPlayReport mPlayStatus=" + this.f39950p);
            GDTLogger.d("doReportVideoInfo VideoPlayReport currentPosition=" + i3);
            GDTLogger.d("doReportVideoInfo VideoPlayReport duration=" + i17);
            com.qq.e.comm.plugin.base.ad.e.b.a(3, 0, 1, this.f39950p, i3, i17, 0, this.f39941g.ae(), aVar, new b.a() { // from class: com.qq.e.comm.plugin.tangramsplash.f.10
                @Override // com.qq.e.comm.plugin.base.ad.e.b.a
                public void a() {
                    GDTLogger.d("TangramSplashAdViewsplash report video info success");
                }

                @Override // com.qq.e.comm.plugin.base.ad.e.b.a
                public void a(int i18) {
                    GDTLogger.e("TangramSplashAdViewsplash report video info error");
                }
            });
            return;
        }
        GDTLogger.d("doReportVideoInfo \u975e\u89c6\u9891\u95ea\u5c4f\uff0c\u4e0d\u4e0a\u62a5\u89c6\u9891\u64ad\u653e\u6548\u679c\uff01");
    }

    private void ai() {
        if (com.qq.e.comm.plugin.j.c.a(this.f39941g.s(), "splashSetAccessibilityDelegate", 0, 1)) {
            boolean a16 = com.qq.e.comm.plugin.j.c.a(this.f39941g.s(), "splashShieldAccessibilityClick", 0, 1);
            com.qq.e.comm.plugin.k.e.a(this.f39944j, a16, this);
            com.qq.e.comm.plugin.k.e.a(this.f39945k, a16, this);
            com.qq.e.comm.plugin.k.e.a(this.f39951q, a16, this);
        }
    }

    public void b() {
    }

    public String d() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f39958x != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f39958x.a().a(true);
                    }
                } else {
                    this.f39958x.a().c(motionEvent.getX());
                    this.f39958x.a().d(motionEvent.getY());
                    this.f39958x.a().d(System.currentTimeMillis());
                }
            } else {
                this.f39958x.a().m();
                this.f39958x.a().a(motionEvent.getX());
                this.f39958x.a().b(motionEvent.getY());
                this.f39958x.a().c(System.currentTimeMillis());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f(int i3) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.qq.e.comm.plugin.tangramsplash.video.b bVar;
        try {
            super.onDetachedFromWindow();
            GDTLogger.d(NodeProps.ON_DETACHED_FROM_WINDOW);
            av avVar = this.U;
            if (avVar != null) {
                avVar.c();
                this.U.f();
            }
            av avVar2 = this.V;
            if (avVar2 != null) {
                avVar2.c();
                this.V.f();
            }
            av avVar3 = this.W;
            if (avVar3 != null) {
                avVar3.c();
                this.W.f();
            }
            ImageView imageView = this.f39948n;
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
            Bitmap bitmap = this.f39957w;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f39957w.recycle();
                this.f39957w = null;
            }
            SlideGestureViewHelper slideGestureViewHelper = this.f39935ax;
            if (slideGestureViewHelper != null) {
                slideGestureViewHelper.setEnabled(false);
                this.f39935ax.onDetachedFromWindow();
            }
            if (this.f39952r) {
                com.qq.e.comm.plugin.tangramsplash.video.b bVar2 = this.f39949o;
                if (bVar2 != null && bVar2.c() && this.f39949o.b() != null) {
                    this.f39949o.b().clearAnimation();
                }
            } else {
                ViewGroup viewGroup = this.f39943i;
                if (viewGroup != null) {
                    viewGroup.clearAnimation();
                }
            }
            View view = this.f39960z;
            if (view != null) {
                ba.a(view);
                this.f39960z = null;
            }
            removeAllViews();
            com.qq.e.comm.plugin.tangramsplash.a.a().c();
            com.qq.e.comm.plugin.tangramsplash.c.e.a().b();
            StatTracer.instantReport(this.f39939e);
            this.f39938d.b();
            if ((!this.f39922ak || this.f39953s) && (bVar = this.f39949o) != null) {
                bVar.j();
            }
        } catch (Exception e16) {
            GDTLogger.d("Error during onDetachedFromWindow: " + e16.getMessage());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        if (!this.f39923al && b(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void B() {
        if (this.f39949o == null) {
            this.f39953s = true;
            com.qq.e.comm.plugin.tangramsplash.video.b bVar = new com.qq.e.comm.plugin.tangramsplash.video.b(GDTADManager.getInstance().getAppContext(), (WeakReference<f>) new WeakReference(this));
            this.f39949o = bVar;
            bVar.i();
            if (this.f39949o.c()) {
                this.f39949o.b(true);
            }
        }
    }

    private void C() {
        ai();
        this.f39932au = System.currentTimeMillis();
        com.qq.e.comm.plugin.base.ad.e.b.a(this.f39941g.l(), this.f39941g.v());
        if (!this.f39940f) {
            com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39939e);
        } else {
            com.qq.e.comm.plugin.tangramsplash.d.f.b(this.f39939e);
        }
        com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f39941g);
        com.qq.e.comm.plugin.tangramsplash.a.c.d();
        if (this.f39940f) {
            return;
        }
        c(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f39943i.removeAllViews();
        ba.a(this);
        this.f39943i.addView(this, layoutParams);
        this.f39912aa = new com.qq.e.comm.plugin.tangramsplash.d.c(this, this.f39941g, this.f39940f);
        if (this.f39959y == 1) {
            setVisibility(0);
            com.qq.e.comm.plugin.base.ad.c cVar = new com.qq.e.comm.plugin.base.ad.c();
            this.f39958x = cVar;
            cVar.a(this.f39943i);
            this.f39958x.a(System.currentTimeMillis());
        }
    }

    private boolean E() {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310304, this.f39939e, this.f39941g, this.f39940f);
        com.qq.e.comm.plugin.tangramsplash.d.f.b();
        if (!com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39943i)) {
            GDTLogger.e("\u5e7f\u544a\u5bb9\u5668\u5904\u4e8e\u4e0d\u53ef\u89c1\u72b6\u6001\uff0c\u65e0\u6cd5\u8fdb\u884c\u66dd\u5149\u4e0a\u62a5\u548c\u8ba1\u8d39\uff0c\u8bf7\u68c0\u67e5\u60a8\u7684\u4ee3\u7801\u903b\u8f91\uff0c\u4fdd\u8bc1\u5e7f\u544a\u5bb9\u5668\u53ef\u89c1\u3002");
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310300, this.f39939e, this.f39941g, this.f39940f);
            h(600);
            return false;
        }
        if (this.O == null) {
            this.O = new WeakReference<>(new a(this));
        }
        WeakReference<a> weakReference = this.O;
        if (weakReference != null && weakReference.get() != null) {
            ((Application) getContext().getApplicationContext()).registerActivityLifecycleCallbacks(this.O.get());
        }
        this.N = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        long h16;
        com.qq.e.comm.plugin.tangramsplash.video.b bVar;
        av avVar;
        int i3 = this.f39959y;
        if (i3 == 1 && (avVar = this.U) != null) {
            h16 = avVar.e();
        } else {
            h16 = (i3 != 2 || (bVar = this.f39949o) == null) ? 0L : bVar.h();
        }
        String j3 = this.f39941g.j();
        if (!StringUtil.isEmpty(j3)) {
            this.f39941g.h(j3 + "&gap=" + h16);
        }
        SplashLinkReporter.a(7010002, this.f39941g);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310320, this.f39939e, this.f39941g, f(), this.f39919ah, this.aI ? 1 : 0, this.f39940f, this.M);
        if (this.f39941g.bJ() != null) {
            String str = this.f39939e;
            r rVar = this.f39941g;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310340, str, rVar, rVar.bJ() != null ? this.f39941g.bJ().n() : -1, this.f39940f);
        }
        if (!com.qq.e.comm.plugin.tangramsplash.d.f.a(getContext())) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310326, this.f39939e, this.f39941g, this.f39940f);
            com.qq.e.comm.plugin.tangramsplash.a.c.a(this.f39941g, this.f39940f);
        } else {
            com.qq.e.comm.plugin.tangramsplash.d.d.a(null, 0, this.f39941g, this.f39940f);
            List<s> C = this.f39941g.C();
            if (C != null && C.size() > 0) {
                for (s sVar : C) {
                    if (sVar != null) {
                        af.b(sVar.a());
                    }
                }
            }
            List<s> D = this.f39941g.D();
            if (D != null && D.size() > 0) {
                for (s sVar2 : D) {
                    if (sVar2 != null) {
                        ab.a(sVar2.a());
                    }
                }
            }
            String o16 = this.f39941g.o();
            if (!StringUtil.isEmpty(o16)) {
                af.b(o16);
            }
        }
        if (this.f39947m != null) {
            a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.16
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f39947m.onADEvent(new ADEvent(6));
                }
            });
        }
        GDTLogger.d("gap=%d" + h16);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310321, this.f39939e, this.f39941g, f(), this.f39919ah, this.aI ? 1 : 0, this.f39940f, this.M);
        TADSplashLifeCycleHolder.getInstance().notifySplashExposure(this.f39940f);
    }

    private void G() {
        com.qq.e.comm.plugin.tangramsplash.video.b bVar;
        if (this.f39959y != 2 || (bVar = this.f39949o) == null) {
            return;
        }
        bVar.e();
    }

    private void H() {
        com.qq.e.comm.plugin.tangramsplash.video.b bVar;
        View view = this.f39945k;
        if (view != null) {
            view.setVisibility(4);
        }
        r rVar = this.f39941g;
        int bD = rVar != null ? rVar.bD() * 1000 : 0;
        GDTLogger.d("skip view for delay " + bD);
        if (this.f39959y == 2 && (bVar = this.f39949o) != null) {
            this.f39942h = bVar.g();
            int bN = this.f39941g.bN() * 1000;
            if (this.f39941g.bJ() != null) {
                this.f39942h = Math.min(this.f39942h, bN);
            }
            if (this.f39942h <= 0) {
                if (bN <= 0) {
                    bN = 5000;
                }
                this.f39942h = bN;
            }
        }
        if (this.f39959y == 1) {
            this.f39942h = this.f39941g.bq() * 1000 > 0 ? this.f39941g.bq() * 1000 : 5000;
        }
        GDTLogger.i(" exposureDelay :" + this.f39942h + " type :" + this.f39959y);
        View view2 = this.f39944j;
        if (view2 == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f39951q = linearLayout;
            linearLayout.setId(2);
            this.f39951q.setPadding(ak.a(getContext(), 12), ak.a(getContext(), 4), ak.a(getContext(), 12), ak.a(getContext(), 4));
            this.f39951q.setOnClickListener(this.f39912aa);
            this.f39951q.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(50.0f, -16777216, 100));
            TextView textView = new TextView(getContext());
            this.f39946l = textView;
            textView.setText(String.format("%d", Integer.valueOf(Math.round(this.f39942h / 1000.0f))));
            this.f39946l.setTextSize(2, 14.0f);
            this.f39946l.setTextColor(Color.parseColor("#F0F0F0"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ak.a(getContext(), 6);
            this.f39951q.addView(this.f39946l, layoutParams);
            View view3 = new View(getContext());
            view3.setBackgroundColor(Color.parseColor("#80FFFFFF"));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ak.a(getContext(), 2), -1);
            layoutParams2.rightMargin = ak.a(getContext(), 6);
            layoutParams2.topMargin = ak.a(getContext(), 3);
            layoutParams2.bottomMargin = ak.a(getContext(), 3);
            this.f39951q.addView(view3, layoutParams2);
            TextView textView2 = new TextView(getContext());
            textView2.setText("\u8df3\u8fc7");
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(Color.parseColor("#F0F0F0"));
            this.f39951q.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 8388661;
            layoutParams3.leftMargin = ak.a(getContext(), 12);
            layoutParams3.rightMargin = ak.a(getContext(), 12);
            layoutParams3.topMargin = ak.a(getContext(), 24) + n.a(getContext());
            addView(this.f39951q, layoutParams3);
            a(this.f39951q, bD);
            I();
            return;
        }
        a(view2, bD);
        if (this.f39944j.getParent() == null) {
            addView(this.f39944j);
        }
        this.f39944j.setOnClickListener(this.f39912aa);
        this.f39944j.setId(2);
        if (this.E == null && this.D == null) {
            I();
        }
    }

    private void I() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.18
            /* JADX WARN: Removed duplicated region for block: B:10:0x007f  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x007e A[RETURN] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                int i16;
                int width;
                TextView textView;
                FrameLayout.LayoutParams layoutParams;
                GDTLogger.i("alignCountDownAndAdLogo.post come in");
                if (f.this.f39951q != null) {
                    i3 = f.this.f39951q.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = f.this.f39951q.getLayoutParams();
                    if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                        width = layoutParams3.leftMargin + f.this.f39951q.getWidth() + layoutParams3.rightMargin;
                        i16 = layoutParams3.topMargin;
                        textView = f.this.H;
                        if (textView == null) {
                            return;
                        }
                        int height = textView.getHeight();
                        ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            layoutParams = (FrameLayout.LayoutParams) layoutParams4;
                        } else {
                            layoutParams = null;
                        }
                        if (layoutParams == null) {
                            GDTLogger.i("align countDown and ad logo layoutParams  == null, then return");
                            return;
                        }
                        int i17 = (i3 - height) / 2;
                        if (i17 > 0) {
                            GDTLogger.i("align countDown and ad logo marginMore:" + i17);
                            layoutParams.topMargin = i16 + i17;
                        }
                        if (width > 0) {
                            GDTLogger.i("reset splashADMarkMarginRight:" + width);
                            layoutParams.rightMargin = width;
                        }
                        layoutParams.gravity = 8388661;
                        ba.a(textView);
                        f.this.addView(textView, layoutParams);
                        textView.setVisibility(0);
                        return;
                    }
                    i16 = 0;
                } else if (f.this.f39944j != null) {
                    i3 = f.this.f39944j.getHeight();
                    ViewGroup.LayoutParams layoutParams5 = f.this.f39944j.getLayoutParams();
                    if (layoutParams5 instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
                        width = layoutParams6.leftMargin + f.this.f39944j.getWidth() + layoutParams6.rightMargin;
                        i16 = layoutParams6.topMargin;
                        textView = f.this.H;
                        if (textView == null) {
                        }
                    }
                    i16 = 0;
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                width = i16;
                textView = f.this.H;
                if (textView == null) {
                }
            }
        });
    }

    private void J() {
        av avVar = new av(this.f39942h, 500L, false) { // from class: com.qq.e.comm.plugin.tangramsplash.f.3
            @Override // com.qq.e.comm.plugin.k.av
            public void a(final long j3) {
                if (j3 <= f.this.f39942h - GDTADManager.getInstance().getSM().getInteger("splashOnExposureTimeDelay", 200) && !f.this.P) {
                    f.this.F();
                    f.this.P = true;
                }
                f.this.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.f39944j == null && f.this.f39946l != null) {
                            f.this.f39946l.setText(String.format("%d", Integer.valueOf((int) Math.ceil(j3 / 1000.0d))));
                        }
                        if (f.this.f39947m != null && f.this.N) {
                            f.this.f39947m.onADEvent(new ADEvent(5, new Object[]{Long.valueOf(j3)}));
                        }
                    }
                });
            }

            @Override // com.qq.e.comm.plugin.k.av
            public void a() {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("splash finish by 'TikTokTimer end'  with ");
                sb5.append(f.this.S ? "normal" : "not normal");
                GDTLogger.d(sb5.toString());
                f.this.f(13);
                f.this.g();
            }
        };
        this.U = avVar;
        avVar.b();
    }

    private void K() {
        if (this.f39960z != null) {
            GDTLogger.i("TangramSplashAdViewinitFloatView customLogoView\uff1a" + this.f39955u);
            if (this.f39955u) {
                this.f39960z.setVisibility(0);
                if (this.f39960z.getParent() == null) {
                    addView(this.f39960z);
                }
                this.f39960z.setOnClickListener(this.f39912aa);
                return;
            }
            if (this.f39960z.getParent() != null) {
                ba.a(this.f39960z);
            }
            this.aF = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.aF.addView(this.f39960z);
            this.aF.setId(6);
            if (com.qq.e.comm.plugin.j.c.a("isCustomLogoClickable", 0, 1)) {
                this.aF.setOnClickListener(this.f39912aa);
            }
            addView(this.aF, layoutParams);
        }
    }

    private void L() {
        View view = this.R;
        if (view != null) {
            view.setVisibility(0);
            s();
            this.R.setId(18);
            this.R.setOnClickListener(this.f39912aa);
            if (this.R.getParent() == null) {
                addView(this.R);
            }
        }
    }

    private void M() {
        if (this.f39941g.bT() == 0) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310801, this.f39941g.s(), this.f39941g, 0L, 0, this.f39940f, this.M);
            return;
        }
        if (this.f39941g.bT() == 1) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310802, this.f39941g.s(), this.f39941g, 0L, 0, this.f39940f, this.M);
            h();
        } else if (this.f39941g.bT() == 2) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310803, this.f39941g.s(), this.f39941g, 0L, 0, this.f39940f, this.M);
            h();
        } else if (this.f39941g.bT() == 3) {
            i();
        }
    }

    private void N() {
        int i3;
        com.qq.e.comm.plugin.tangramsplash.e.c cVar = new com.qq.e.comm.plugin.tangramsplash.e.c(getContext(), true);
        this.aA = cVar;
        if (cVar.getParent() != null) {
            ba.a(this.aA);
        }
        this.aA.a(this.f39941g.g());
        this.aA.setId(7);
        this.aA.setOnClickListener(this.f39912aa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        v vVar = this.f39933av;
        int i16 = AppConstants.RichMediaErrorCode.ERROR_FAST_FORWARD_MD5_MISS;
        if (vVar != null) {
            r3 = vVar.e() > 0 ? this.f39933av.e() : 17241;
            int c16 = this.f39933av.c() > 0 ? this.f39933av.c() : 9333;
            if (this.f39933av.d() > 0) {
                i16 = this.f39933av.d();
            }
            int i17 = i16;
            i16 = c16;
            i3 = i17;
        } else {
            i3 = 9333;
        }
        int c17 = ak.c(getContext(), i16);
        int c18 = ak.c(getContext(), i3);
        int b16 = ak.b(getContext());
        int i18 = (b16 - c17) - c18;
        if (i18 <= 0 || i18 > b16) {
            GDTLogger.d("TangramSplashAdViewheight invalid");
            i18 = ak.a(getContext(), 305);
        }
        int a16 = ak.a(i18, 508333);
        layoutParams.bottomMargin = ak.d(getContext(), r3);
        layoutParams.width = i18;
        layoutParams.height = a16;
        layoutParams.gravity = 81;
        addView(this.aA, layoutParams);
        i(this.aA);
    }

    private void O() {
        com.qq.e.comm.plugin.tangramsplash.e.c cVar = new com.qq.e.comm.plugin.tangramsplash.e.c(getContext(), false);
        this.aA = cVar;
        cVar.a();
        if (this.aA.getParent() != null) {
            ba.a(this.aA);
        }
        this.aA.a(this.f39941g.g());
        this.aA.setId(7);
        this.aA.setOnClickListener(this.f39912aa);
        this.aA.setPadding(ak.a(getContext(), 23), ak.a(getContext(), 3), ak.a(getContext(), 23), ak.a(getContext(), 3));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        v vVar = this.f39933av;
        layoutParams.bottomMargin = ak.d(getContext(), (vVar == null || vVar.e() <= 0) ? 17241 : this.f39933av.e());
        layoutParams.gravity = 81;
        addView(this.aA, layoutParams);
        i(this.aA);
    }

    private void P() {
        v H;
        r rVar = this.f39941g;
        if (rVar == null || (H = rVar.H(3)) == null) {
            return;
        }
        if ("SlideFlipInteractive".equals(this.f39941g.bP())) {
            GDTLogger.e("SlideFlipInteractive can not createHotArea return");
            return;
        }
        this.f39929ar = a(H);
        if (!g.a(this.f39941g.bQ())) {
            if (com.qq.e.comm.plugin.tangramsplash.d.f.d(this.f39941g)) {
                return;
            }
            this.f39929ar = null;
        } else {
            FrameLayout.LayoutParams R = R();
            ImageView imageView = new ImageView(getContext());
            this.f39930as = imageView;
            imageView.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAAFgAAABYCAMAAABGS8AGAAAAUVBMVEUAAAAvLy////8vLy8wMDAtLS0uLi7l5eUvLy8nJyfy8vKxsbF9fX3KyspjY2NJSUkuLi4vLy8vLy8vLy88PDyXl5eJiYksLCzY2NikpKRvb2+n8wQBAAAAG3RSTlMAzMxmvxlNzLMNzMzMzMzMppmGc8zMzEDMzMx2YoavAAABaElEQVRYw+2WYY+DIAxA6SgI6pzCNu/u///QWy7bNQsLFa3JkvG+mjzrI42oSqVSqVQ+HG9jcAh53BStKbLqCRYzkpvVIpQRFqlJW4BmtWaEVThmaIuwEpyzGWADmvPKm2fYiH3tNQgbwdcn6GAzIxNYNLMBCdAn4gAiaGZguZEtwD4jj8BxvrRNdwKOqbDE0B3+4NW+pMRwPPxz7EvWL+YaXJvDE01WHZ/EUy7t3fd17R9vyMUOzDpT2nuBAW783Jowsd2TmEnbdgPcOXVMbOTElLa9nAGI03eTjc2Ie0p7Th+SmhFj8rihtCkUu4UE5vBaSptCsRvm8MKLr32kTaHYbc/sdAQxIrPSQn9UD2IYxey00P9Uy5YgPIqWkB85KLXPyGb/Cwsxwmbc/pdC2fWbMxfvd7zSa5VhxtV9rcpiHKxipHOTzIFaLcCEYq1XyzC2YFmmRMu448TlRhei9apSqVQqlc/mF/WxFagFTU4cAAAAAElFTkSuQmCC"));
            addView(this.f39930as, R);
        }
    }

    private void Q() {
        r rVar;
        if (this.f39943i == null || (rVar = this.f39941g) == null || rVar.bJ() == null) {
            return;
        }
        String bP = this.f39941g.bP();
        boolean z16 = "SlideAndClickInteractive".equals(bP) || com.qq.e.comm.plugin.tangramsplash.d.f.d(this.f39941g);
        if ("SlideFlipInteractive".equals(bP)) {
            z16 = false;
        }
        if (z16 && this.f39941g.bJ().y()) {
            v H = this.f39941g.H(3);
            if (H == null) {
                GDTLogger.e("initSlideGestureViewHelper areaInfo == null");
                return;
            }
            if (this.f39941g.bJ().z() < 1) {
                GDTLogger.e("initSlideGestureViewHelper SlideTrackWidth invalid");
                return;
            }
            SlideGestureViewHelper slideGestureViewHelper = new SlideGestureViewHelper(getContext(), this);
            this.f39935ax = slideGestureViewHelper;
            slideGestureViewHelper.setGestureColor(this.f39941g.bJ().d());
            this.f39935ax.setGestureStrokeWidthDp(this.f39941g.bJ().z());
            int c16 = ak.c(getContext(), H.c());
            int c17 = ak.c(getContext(), H.d());
            int c18 = ak.c(getContext(), H.e());
            int a16 = ak.a((ak.b(getContext()) - c16) - c17, H.f());
            SlideGestureViewHelper slideGestureViewHelper2 = this.f39935ax;
            if (a16 == 0) {
                a16 = -1;
            }
            slideGestureViewHelper2.setGestureHotArea(c16, c17, c18, a16);
            this.f39935ax.setGestureClickView(this.f39951q, this.f39944j, this.f39945k, this.aC, this.aA, this.aB, this.f39937az, this.f39936ay, this.aD, this.B, this.F, this.aF, this.f39960z, this.R);
            this.f39935ax.setSlideGestureListener(new SlideGestureViewHelper.ISlideGestureListener() { // from class: com.qq.e.comm.plugin.tangramsplash.f.5
                @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
                public void onGestureResult(int i3, View view, boolean z17, float f16, float f17, float f18) {
                    GDTLogger.d("SlideGestureViewHelper onGestureResult gestureType :" + i3 + " success:" + z17);
                    if (i3 == 1 && view != null && z17) {
                        if (view.getId() == 21) {
                            view.performClick();
                        } else {
                            f.this.f39912aa.onClick(view);
                        }
                    }
                }

                @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
                public void onGestureStart() {
                    GDTLogger.d("SlideGestureViewHelper onGestureStart");
                }

                @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
                public void onTouch(View view, MotionEvent motionEvent) {
                }
            });
            this.f39935ax.onAttachedToWindow();
            return;
        }
        GDTLogger.e("initSlideGestureViewHelper type error or no need show track");
    }

    private FrameLayout.LayoutParams R() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        v vVar = this.f39933av;
        layoutParams.bottomMargin = ak.d(getContext(), (vVar == null || vVar.e() <= 0) ? 17241 : this.f39933av.e()) + ak.a(getContext(), 58);
        layoutParams.gravity = 81;
        return layoutParams;
    }

    private void S() {
        if (this.f39948n == null) {
            this.f39948n = new com.qq.e.comm.plugin.base.media.a.b(getContext());
        }
        if (this.f39948n.getParent() != null) {
            ba.a(this.f39948n);
        }
        boolean z16 = false;
        if (this.aE != null) {
            addView(this.f39948n, 0, new FrameLayout.LayoutParams(-1, -1));
        } else {
            addView(this.f39948n, new FrameLayout.LayoutParams(-1, -1));
        }
        this.f39948n.setId(1);
        this.f39948n.setOnClickListener(this.f39912aa);
        if (this.f39920ai && this.f39921aj) {
            r rVar = this.f39941g;
            if (rVar != null && rVar.bZ()) {
                z16 = true;
            }
            GDTLogger.i("allOneShotNotCrop :" + z16);
            if (z16) {
                this.f39948n.setScaleType(ImageView.ScaleType.FIT_XY);
                return;
            }
            this.f39948n.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageView imageView = this.f39948n;
            if (imageView instanceof com.qq.e.comm.plugin.base.media.a.b) {
                ((com.qq.e.comm.plugin.base.media.a.b) imageView).b(com.qq.e.comm.plugin.j.c.a(this.f39939e, "splashImgDrawableBoundsHandle", 1, 1));
                return;
            }
            return;
        }
        this.f39948n.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private void T() {
        if (this.f39941g.bA() <= 0) {
            GDTLogger.d("button\u5f15\u5bfc\u5f00\u5173\u5173\u95ed");
            return;
        }
        if (!this.f39956v) {
            GDTLogger.d("\u5ba2\u6237\u7aefbutton\u5f15\u5bfc\u5173\u95ed");
            return;
        }
        if (this.B == null) {
            this.B = new com.qq.e.comm.plugin.tangramsplash.e.a(getContext());
        }
        if (!StringUtil.isEmpty(this.f39941g.getButtonTxt())) {
            this.B.a(this.f39941g.getButtonTxt());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        int i3 = this.C;
        if (i3 <= 0) {
            i3 = 32;
        }
        layoutParams.bottomMargin = this.A + ak.a(getContext(), i3);
        addView(this.B, layoutParams);
        this.B.setId(8);
        this.B.setOnClickListener(this.f39912aa);
        this.B.a();
        this.B.a(this.f39941g.getButtonTxt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3) {
        a(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        this.f39934aw = (i3 == 2 || i3 == 0) ? false : true;
        com.qq.e.comm.plugin.base.ad.clickcomponent.e eVar = new com.qq.e.comm.plugin.base.ad.clickcomponent.e(new WeakReference(this));
        eVar.b(-1);
        GDTLogger.d("splash clickAndJump");
        if (this.f39929ar != null && com.qq.e.comm.plugin.j.c.a("splash_slide_animation_allowed", 0, 1)) {
            try {
                GDTLogger.d("get activity animation params");
                if (eVar.b() != null) {
                    int identifier = eVar.b().getResources().getIdentifier("gdt_activity_in_from_bottom", "anim", eVar.b().getPackageName());
                    GDTLogger.d("animId is " + identifier);
                    eVar.a(identifier, 0);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        new b.a().a(new ClickInfo.b().a(this.f39941g).a(new ClickInfo.c(this.f39941g.u(), this.f39941g.t(), this.f39941g.s())).a(eVar).a(new ClickInfo.d(i3)).a()).a().a().a();
    }

    public r A() {
        return this.f39941g;
    }

    public void g(View view) {
        this.J = view;
    }

    public void j() {
        try {
            TextView textView = new TextView(getContext());
            this.H = textView;
            textView.setTextSize(2, 11.0f);
            this.H.setTextColor(Color.parseColor("#F0F0F0"));
            this.H.setShadowLayer(1.0f, 0.5f, 0.5f, Color.parseColor("#66000000"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            StringBuilder sb5 = new StringBuilder();
            if (this.f39941g.bO() == 1) {
                GDTLogger.d("\u5e7f\u544a\u6807\u793a\u540e\u53f0\u5173\u95ed");
                View view = this.E;
                if (view != null) {
                    view.setVisibility(4);
                }
            } else if (this.E != null) {
                GDTLogger.d("show custom ad logo view");
                this.E.setVisibility(0);
                if (this.E.getParent() == null) {
                    addView(this.E);
                }
            } else if (!TextUtils.isEmpty(this.f39941g.br())) {
                sb5.append(this.f39941g.br());
            } else {
                sb5.append(this.f39941g.bJ() != null ? "\u4e92\u52a8\u5e7f\u544a" : "\u5e7f\u544a");
            }
            if (this.f39959y == 2) {
                View view2 = this.D;
                if (view2 != null) {
                    view2.setVisibility(0);
                    if (this.D.getParent() == null) {
                        addView(this.D);
                    }
                } else {
                    if (!TextUtils.isEmpty(sb5.toString())) {
                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                    }
                    sb5.append("\u5df2 WiFi \u9884\u52a0\u8f7d");
                }
            }
            String sb6 = sb5.toString();
            if (TextUtils.isEmpty(sb6)) {
                return;
            }
            this.H.setText(sb6);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = ak.a(getContext(), 24) + n.a(getContext());
            this.H.setLayoutParams(layoutParams);
            addView(this.H);
            this.H.setVisibility(4);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    public void k() {
        if (com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39951q)) {
            ba.a(this.f39951q);
        }
        av avVar = this.U;
        if (avVar != null) {
            avVar.c();
            this.U.f();
        }
    }

    public void l() {
        if ((this.f39949o == null || this.f39941g.bJ() == null || this.f39941g.bJ().h() == 1) && this.f39949o != null) {
            final int U = U();
            long j3 = U;
            a(j3);
            av avVar = new av(j3, 500L, false) { // from class: com.qq.e.comm.plugin.tangramsplash.f.6
                @Override // com.qq.e.comm.plugin.k.av
                public void a(final long j16) {
                    int h16 = f.this.f39949o.h();
                    if (h16 >= U || !f.this.f39949o.f()) {
                        return;
                    }
                    if (h16 >= GDTADManager.getInstance().getSM().getInteger("splashOnExposureTimeDelay", 200) && !f.this.P) {
                        f.this.F();
                        f.this.P = true;
                    }
                    f.this.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.f39944j == null && f.this.f39946l != null) {
                                f.this.f39946l.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf((int) Math.ceil(j16 / 1000.0d))));
                            }
                            if (f.this.f39947m != null && f.this.N) {
                                f.this.f39947m.onADEvent(new ADEvent(5, new Object[]{Long.valueOf(j16)}));
                            }
                        }
                    });
                }

                @Override // com.qq.e.comm.plugin.k.av
                public void a() {
                    if (f.this.f39916ae) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("splash finish by 'video timer end'  with ");
                    sb5.append(f.this.S ? "normal" : "not normal");
                    GDTLogger.d(sb5.toString());
                    f.this.f(13);
                    f.this.g();
                }
            };
            this.V = avVar;
            avVar.b();
        }
    }

    public boolean m() {
        r rVar = this.f39941g;
        if (rVar == null) {
            return false;
        }
        if (!this.f39923al && rVar.ce()) {
            return true;
        }
        GDTLogger.e("TransparentVideo animation has started!");
        return false;
    }

    public void n() {
        com.qq.e.comm.plugin.tangramsplash.video.b bVar;
        if (m()) {
            int U = U();
            r rVar = this.f39941g;
            int cd5 = rVar != null ? rVar.cd() : 0;
            GDTLogger.e("seekTransparentVideoToSpecifiedPosition : total :" + U + " switchTime:" + cd5);
            if (cd5 > U || this.f39941g == null || (bVar = this.f39949o) == null || bVar.b() == null) {
                return;
            }
            this.f39949o.a(cd5);
        }
    }

    public void o() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f39949o != null && f.this.f39949o.b() != null && f.this.getChildCount() > 1) {
                    for (int i3 = 0; i3 < f.this.getChildCount(); i3++) {
                        try {
                            View childAt = f.this.getChildAt(i3);
                            if (childAt != null && childAt.getId() != 5) {
                                childAt.setVisibility(8);
                            }
                        } catch (Throwable th5) {
                            GDTLogger.e(th5.getMessage());
                            return;
                        }
                    }
                    if (f.this.f39944j != null) {
                        f.this.f39944j.setVisibility(8);
                    }
                    if (f.this.f39960z != null) {
                        f.this.f39960z.setVisibility(8);
                    }
                    if (f.this.E != null) {
                        f.this.E.setVisibility(8);
                    }
                    if (f.this.D != null) {
                        f.this.D.setVisibility(8);
                    }
                    if (f.this.f39945k != null) {
                        f.this.f39945k.setVisibility(8);
                    }
                    if (f.this.R != null) {
                        f.this.R.setVisibility(8);
                    }
                    if (f.this.f39951q != null) {
                        f.this.f39951q.setVisibility(8);
                    }
                    com.qq.e.comm.plugin.tangramsplash.interactive.d.a().f();
                    if (f.this.J != null) {
                        ba.a(f.this.J);
                        f.this.J.setId(22);
                        f fVar = f.this;
                        fVar.addView(fVar.J);
                        f.this.J.setOnClickListener(f.this.f39912aa);
                        return;
                    }
                    f fVar2 = f.this;
                    fVar2.J = fVar2.V();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, ak.a(f.this.getContext(), 40));
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = ak.a(f.this.getContext(), 12);
                    layoutParams.topMargin = ak.a(f.this.getContext(), 50);
                    f fVar3 = f.this;
                    fVar3.addView(fVar3.J, layoutParams);
                }
            }
        });
    }

    public void p() {
        if (m()) {
            int U = U();
            r rVar = this.f39941g;
            int cd5 = rVar != null ? rVar.cd() : 0;
            GDTLogger.e("updateVideoCountDownTimer : total :" + U + " switchTime:" + cd5);
            int i3 = U - cd5;
            if (i3 >= 0) {
                av avVar = this.V;
                if (avVar != null) {
                    avVar.b(i3);
                }
                av avVar2 = this.W;
                if (avVar2 != null) {
                    avVar2.b(i3);
                }
            }
        }
    }

    public void q() {
        SplashLinkReporter.a(7010004, this.f39941g);
    }

    public void r() {
        r rVar = this.f39941g;
        if (rVar == null || rVar.bJ() == null) {
            return;
        }
        long currentTimeMillis = this.f39918ag > 0 ? System.currentTimeMillis() - this.f39918ag : 0L;
        if (this.f39941g.bJ().h() == 2) {
            String s16 = this.f39941g.s();
            r rVar2 = this.f39941g;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310347, s16, rVar2, currentTimeMillis, this.f39919ah, rVar2.bJ().n(), this.f39940f, this.M);
        } else if (this.f39941g.bJ().h() == 3) {
            String s17 = this.f39941g.s();
            r rVar3 = this.f39941g;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310353, s17, rVar3, currentTimeMillis, this.f39919ah, rVar3.bJ().n(), this.f39940f, this.M);
        }
    }

    public void s() {
        r rVar = this.f39941g;
        if (rVar == null) {
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310316, this.f39939e, rVar, f(), this.f39919ah, Integer.MAX_VALUE, this.f39940f, this.M);
    }

    public void t() {
        r rVar = this.f39941g;
        if (rVar == null) {
            return;
        }
        SplashLinkReporter.a(7010030, rVar);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310317, this.f39939e, this.f39941g, f(), this.f39919ah, Integer.MAX_VALUE, this.f39940f, this.M);
    }

    public void u() {
        if (com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f39914ac)) {
            com.qq.e.comm.plugin.tangramsplash.d.f.b(this.f39939e);
        } else {
            com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39939e);
        }
    }

    public void v() {
        r rVar = this.f39941g;
        GDTLogger.i("TangramSplashAdView[doRecycleBeforeSplashDismiss] state" + ((rVar == null || rVar.bJ() == null) ? -1 : this.f39941g.bJ().h()));
        r rVar2 = this.f39941g;
        String bP = rVar2 != null ? rVar2.bP() : "";
        boolean b16 = com.qq.e.comm.plugin.tangramsplash.d.f.b(bP, "doRecycleBeforeSplashDismiss", "");
        GDTLogger.i("TangramSplashAdView[doRecycleBeforeSplashDismiss] currentMode:" + bP + " switch open :" + b16);
        if (b16) {
            com.qq.e.comm.plugin.tangramsplash.interactive.d.a().g();
        }
    }

    public void w() {
        TextView textView = this.H;
        if (textView != null) {
            textView.setVisibility(4);
        }
        View view = this.E;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.D;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.f39960z;
        if (view3 != null) {
            view3.setVisibility(4);
        }
        ab();
        r rVar = this.f39941g;
        if (rVar == null || rVar.bJ() == null || this.f39941g.bJ().h() != 2) {
            return;
        }
        String str = this.f39939e;
        r rVar2 = this.f39941g;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310346, str, rVar2, 0L, rVar2.bJ().n(), this.f39940f, this.M);
    }

    public void x() {
        r rVar = this.f39941g;
        if (rVar == null || rVar.bJ() == null) {
            return;
        }
        if (this.f39941g.bJ().h() == 3) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310355, this.f39939e, this.f39941g, this.f39940f);
        }
        this.f39941g.bJ().i();
        LinearLayout linearLayout = this.G;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        ImageView imageView = this.I;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        com.qq.e.comm.plugin.tangramsplash.video.b bVar = this.f39949o;
        if (bVar != null) {
            bVar.d();
            if (this.f39949o.b() != null) {
                this.f39949o.b().setId(5);
            }
        }
        i(false);
        aa();
    }

    public void y() {
        if (this.f39947m == null || this.f39917af) {
            return;
        }
        this.f39947m.onADEvent(new ADEvent(3));
        this.f39917af = true;
    }

    public void z() {
        com.qq.e.comm.plugin.tangramsplash.report.c.c(13100205, this.f39939e, this.f39941g, 2, this.f39940f);
        if (this.aH != 0) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1319052, this.f39939e, this.f39941g, System.currentTimeMillis() - this.aH);
        }
        ImageView imageView = this.f39948n;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.f39948n.setVisibility(8);
        }
        View view = this.aE;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        H();
    }

    public void e(View view) {
        if (view == null) {
            return;
        }
        this.D = view;
    }

    public void f(View view) {
        if (view == null) {
            return;
        }
        this.E = view;
        GDTLogger.d("use custom ad logo view");
    }

    public synchronized void g() {
        WeakReference<a> weakReference = this.O;
        if (weakReference != null && weakReference.get() != null) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.O.get());
            this.O = null;
        }
        com.qq.e.comm.plugin.tangramsplash.interactive.d.a().f();
        DrawGestureManager.a().b();
        if (this.f39938d.a() == 5 || this.f39938d.a() == 4 || this.f39938d.a() == 7 || this.f39938d.a() == 2) {
            this.f39938d.a(6);
            if (!this.f39922ak || this.f39953s) {
                G();
            }
            ah();
            if (this.S) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310310, this.f39941g.s(), this.f39941g, f(), this.f39919ah, Integer.MAX_VALUE, this.f39940f, this.M);
                SplashLinkReporter.a(7010005, this.f39941g);
                if (this.f39941g.bJ() != null && this.f39941g.bJ().h() == 1) {
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310356, this.f39941g.s(), this.f39941g, f(), this.f39919ah, Integer.MAX_VALUE, this.f39940f, this.M);
                }
            }
            if (this.f39941g.bG()) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310360, this.f39941g.s(), this.f39941g, f(), this.f39919ah, Integer.MAX_VALUE, this.f39940f, this.M);
            }
            d(false);
            if (this.f39947m != null) {
                a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.17
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.f39947m.onADEvent(new ADEvent(1));
                    }
                });
            }
            TADSplashLifeCycleHolder.getInstance().notifySplashDismiss(this.f39940f);
            com.qq.e.comm.plugin.g.a.c.a();
        }
    }

    public void h(View view) {
        a(view, true);
    }

    public void c(View view) {
        if (view == null) {
            GDTLogger.e("TangramSplashAdViewset null limit ad view");
        } else {
            this.R = view;
        }
    }

    public void d(View view) {
        if (view == null) {
            return;
        }
        this.f39960z = view;
        view.setId(6);
    }

    public ITangramDecoderPlayer e() {
        return this.L;
    }

    public void h() {
        if (this.f39954t) {
            GDTLogger.d("\u5f00\u53d1\u8005\u4f7f\u7528\u81ea\u5b9a\u4e49\u52a8\u6001\u6d6e\u5c42");
        } else if (this.f39941g.H(3) != null) {
            N();
        } else {
            O();
        }
    }

    private boolean b(MotionEvent motionEvent) {
        Rect rect;
        if (motionEvent == null) {
            return false;
        }
        if (this.f39929ar != null) {
            rect = new Rect();
            this.f39929ar.getGlobalVisibleRect(rect);
            GDTLogger.d("slide globalVisibleRect = " + rect.toString());
        } else {
            rect = null;
        }
        if (motionEvent.getAction() == 0) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310811, this.f39939e, this.f39941g, n.c(getContext()), n.d(getContext()), motionEvent.getRawX(), motionEvent.getRawY());
            Point point = this.f39924am;
            if (point == null) {
                this.f39924am = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            } else {
                point.x = (int) motionEvent.getRawX();
                this.f39924am.y = (int) motionEvent.getRawY();
            }
            if (com.qq.e.comm.plugin.tangramsplash.d.f.a(motionEvent, rect)) {
                GDTLogger.d("slide not hit hot area");
                this.f39928aq = false;
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f39928aq = true;
            GDTLogger.d("slide start = " + this.f39924am.toString());
        }
        if (motionEvent.getAction() == 2) {
            if (com.qq.e.comm.plugin.tangramsplash.d.f.a(motionEvent, rect) && !this.f39927ap) {
                GDTLogger.d("slide isOutHotArea lastValidXY = " + this.f39926ao);
                return a(this.f39926ao);
            }
            if (this.f39926ao == null) {
                this.f39926ao = new Point();
            }
            this.f39926ao.x = (int) motionEvent.getRawX();
            this.f39926ao.y = (int) motionEvent.getRawY();
        }
        if (motionEvent.getAction() == 1) {
            Point point2 = this.f39925an;
            if (point2 == null) {
                this.f39925an = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            } else {
                point2.x = (int) motionEvent.getRawX();
                this.f39925an.y = (int) motionEvent.getRawY();
            }
            if (!com.qq.e.comm.plugin.tangramsplash.d.f.a(motionEvent, rect) && !this.f39927ap) {
                GDTLogger.d("slide ACTION_UP endXY = " + this.f39925an.toString() + " slideProcessed :" + this.f39927ap);
                return a(this.f39925an);
            }
        }
        return false;
    }

    public void e(boolean z16) {
        this.f39923al = z16;
    }

    public long f() {
        com.qq.e.comm.plugin.tangramsplash.video.b bVar;
        if (this.f39919ah != f39910b || (bVar = this.f39949o) == null) {
            return 0L;
        }
        return bVar.h();
    }

    public boolean c() {
        return this.f39940f;
    }

    public void d(boolean z16) {
        this.aG = z16;
    }

    public void e(int i3) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310311, this.f39941g.s(), this.f39941g, f(), this.f39919ah, Integer.MAX_VALUE, this.f39940f, this.M);
        if (i3 == 22) {
            SplashLinkReporter.a(7010013, this.f39941g);
        } else {
            SplashLinkReporter.a(7010003, this.f39941g);
        }
        if (this.f39941g.bJ() != null) {
            W();
        }
    }

    public void c(boolean z16) {
        this.f39956v = z16;
    }

    public void d(int i3) {
        this.f39915ad = i3;
        if (i3 == 0) {
            GDTLogger.d("\u5f00\u5c4f\u8d85\u65f6\u65f6\u957f\u5df2\u8bbe\u4e3a\u9ed8\u8ba4\u503c2500");
            return;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("splashMinFetchDelay", 100);
        int integer2 = GDTADManager.getInstance().getSM().getInteger("splashMaxFetchDelay", 5000);
        if (i3 < integer) {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(integer));
            GDTLogger.w("\u5f00\u5c4f\u8d85\u65f6\u65f6\u957f\u53d6\u503c\u8303\u56f4\u4e3a[" + integer + ", " + integer2 + "]\uff0c\u5df2\u5c06\u8d85\u65f6\u65f6\u957f\u8bbe\u4e3a" + integer + "ms\u3002");
            return;
        }
        if (i3 > integer2) {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(integer2));
            GDTLogger.w("\u5f00\u5c4f\u8d85\u65f6\u65f6\u957f\u53d6\u503c\u8303\u56f4\u4e3a[" + integer + ", " + integer2 + "]\uff0c\u5df2\u5c06\u8d85\u65f6\u65f6\u957f\u8bbe\u4e3a" + integer2 + "ms\u3002");
            return;
        }
        GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(i3));
    }

    public boolean f(boolean z16) {
        return a(z16, false);
    }

    public void c(int i3) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(15019, this.f39939e);
        au.a(1310503, this.f39939e, this.f39940f, this.f39914ac, this.f39953s, this.f39915ad);
        this.M = true;
        a((ViewGroup) null, i3);
    }

    public void h(boolean z16) {
        this.T = z16;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.selector.c.a
    public void a(AdError adError) {
        a(adError.getErrorCode(), false);
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.selector.c.a
    public void a(r rVar) {
        this.f39941g = rVar;
        if (!com.qq.e.comm.plugin.j.c.a(rVar.s(), "needLandingPageGestureBack", 0, 1)) {
            this.f39941g.f(false);
        }
        this.f39942h = this.f39941g.bq() * 1000 <= 0 ? 5000 : this.f39941g.bq() * 1000;
        if (this.f39947m != null) {
            if (com.qq.e.comm.plugin.j.c.a("allowReturnSplashOrderWhenSelectSuccess", 1, 1)) {
                SplashOrder splashOrder = new SplashOrder(getContext(), GDTADManager.getInstance().getAppStatus().getAPPID());
                if (SDKStatus.getSDKVersionCode() >= 280) {
                    try {
                        splashOrder.cacheResult(rVar);
                    } catch (Throwable th5) {
                        GDTLogger.e("cacheResult error ", th5);
                    }
                    this.f39947m.onADEvent(new ADEvent(9, new Object[]{splashOrder}));
                }
            }
            this.f39947m.onADEvent(new ADEvent(7));
        }
    }

    private void c(Bitmap bitmap) {
        if (bitmap != null && this.f39948n != null) {
            Bitmap bitmap2 = this.f39957w;
            if (bitmap2 != bitmap) {
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.f39957w = bitmap;
            }
            try {
                this.f39948n.setImageBitmap(this.f39957w);
                return;
            } catch (Exception unused) {
                GDTLogger.e("\u8bbe\u7f6e\u56fe\u7247bitmap\u5931\u8d25");
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310334, this.f39939e, this.f39941g, this.f39940f);
                return;
            }
        }
        GDTLogger.e("setSplashImageBitmap error : bitmap == null || imageView == null");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c implements com.qq.e.comm.plugin.tangramsplash.interactive.b {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<f> f39997a;

        public c(WeakReference<f> weakReference) {
            this.f39997a = weakReference;
        }

        private void b(View view) {
            f fVar = this.f39997a.get();
            SlideGestureViewHelper slideGestureViewHelper = fVar != null ? fVar.f39935ax : null;
            if (slideGestureViewHelper != null) {
                slideGestureViewHelper.setGestureClickView(fVar.f39951q, fVar.f39944j, fVar.f39945k, fVar.aC, fVar.aA, fVar.aB, fVar.f39937az, fVar.f39936ay, fVar.aD, fVar.B, fVar.F, fVar.aF, fVar.f39960z, fVar.R);
            }
        }

        private boolean c() {
            WeakReference<f> weakReference = this.f39997a;
            if (weakReference != null && weakReference.get() != null) {
                return false;
            }
            return true;
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void a(View view, ViewGroup.LayoutParams layoutParams) {
            if (c() || this.f39997a.get().f39941g == null || this.f39997a.get().f39941g.bJ() == null || view == null) {
                return;
            }
            GDTLogger.d("onAttachInteractiveView");
            b(view);
            if (this.f39997a.get().f39941g.bJ().n() >= com.qq.e.comm.plugin.tangramsplash.interactive.a.f40089a) {
                int childCount = this.f39997a.get().getChildCount();
                if (childCount > 0) {
                    if (view.getParent() != null) {
                        ba.a(view);
                    }
                    if (childCount != 1) {
                        if (this.f39997a.get().f39949o != null && this.f39997a.get().f39949o.c() && this.f39997a.get().indexOfChild(this.f39997a.get().f39949o.b()) > 0) {
                            this.f39997a.get().addView(view, 2, layoutParams);
                            return;
                        } else {
                            this.f39997a.get().addView(view, 1, layoutParams);
                            return;
                        }
                    }
                    this.f39997a.get().addView(view, 1, layoutParams);
                    return;
                }
                return;
            }
            if (view.getParent() != null) {
                ba.a(view);
            }
            this.f39997a.get().addView(view, layoutParams);
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void b(boolean z16) {
            if (c()) {
                return;
            }
            long currentTimeMillis = this.f39997a.get().f39918ag > 0 ? System.currentTimeMillis() - this.f39997a.get().f39918ag : 0L;
            if (this.f39997a.get().f39941g != null && this.f39997a.get().f39941g.bJ() != null) {
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310368, this.f39997a.get().f39939e, this.f39997a.get().f39941g, currentTimeMillis, this.f39997a.get().f39941g.bJ().n(), this.f39997a.get().f39940f, this.f39997a.get().M);
            }
            if (this.f39997a.get().a(false, z16)) {
                com.qq.e.comm.plugin.tangramsplash.interactive.d.a().f();
            }
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void a(final View view) {
            if (c()) {
                return;
            }
            if (this.f39997a.get().V != null) {
                this.f39997a.get().V.c();
            }
            if (this.f39997a.get().U != null) {
                this.f39997a.get().U.c();
            }
            this.f39997a.get().f39916ae = true;
            this.f39997a.get().a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f39997a.get().f39949o != null) {
                        c.this.f39997a.get().f39949o.e();
                    }
                }
            });
            if (this.f39997a.get().f39941g != null && this.f39997a.get().f39941g.bJ() != null) {
                this.f39997a.get().f39941g.bJ().i();
            }
            if (view == null) {
                return;
            }
            this.f39997a.get().a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.c.2
                @Override // java.lang.Runnable
                public void run() {
                    ba.a(view);
                    c.this.f39997a.get().addView(view, new FrameLayout.LayoutParams(-1, -1));
                    view.setId(9);
                    c.this.f39997a.get().w();
                }
            });
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void a(boolean z16) {
            if (c()) {
                return;
            }
            if (!z16) {
                this.f39997a.get().f39913ab = 2;
                this.f39997a.get().i(this.f39997a.get().f39913ab);
                this.f39997a.get().f(12);
            } else {
                this.f39997a.get().a((View) this.f39997a.get(), false);
                if (this.f39997a.get().f39941g == null || this.f39997a.get().f39941g.bJ() == null || this.f39997a.get().f39941g.bJ().n() < com.qq.e.comm.plugin.tangramsplash.interactive.a.f40090b) {
                    return;
                }
                this.f39997a.get().r();
            }
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void b() {
            WeakReference<f> weakReference = this.f39997a;
            f fVar = weakReference != null ? weakReference.get() : null;
            if (fVar != null) {
                fVar.g(false);
            }
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void a(int i3, String str) {
            if (c()) {
                return;
            }
            GDTLogger.e("Interactive ad exception error code =" + i3 + " ; " + str);
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310380, this.f39997a.get().f39941g.s(), this.f39997a.get().f39941g, i3, this.f39997a.get().f39940f);
            this.f39997a.get().g();
        }

        @Override // com.qq.e.comm.plugin.tangramsplash.interactive.b
        public void a() {
            WeakReference<f> weakReference = this.f39997a;
            f fVar = weakReference != null ? weakReference.get() : null;
            if (fVar == null || !com.qq.e.comm.plugin.j.c.a("splashAnimationStart", 1, 1)) {
                return;
            }
            if (fVar.U != null) {
                fVar.U.d();
            }
            if (fVar.V == null || fVar.f39941g == null) {
                return;
            }
            if (!fVar.f39941g.cc() || fVar.f39923al) {
                fVar.V.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Bitmap bitmap) {
        b(bitmap);
        ad();
    }

    private void i(final View view) {
        if (view == null) {
            return;
        }
        this.f39931at = view;
        view.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.4
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                View view2 = view;
                if (view2 != null && view2.getHeight() > 0 && f.this.f39930as != null && f.this.f39930as.getLayoutParams() != null && (f.this.f39930as.getLayoutParams() instanceof FrameLayout.LayoutParams) && f.this.f39941g != null && f.this.f39933av != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) f.this.f39930as.getLayoutParams();
                    int height = view.getHeight();
                    if (f.this.f39933av.e() > 0) {
                        i3 = f.this.f39933av.e();
                    } else {
                        i3 = 17241;
                    }
                    int d16 = ak.d(f.this.getContext(), i3);
                    if (height <= 0) {
                        height = ak.a(f.this.getContext(), 58);
                    }
                    layoutParams.bottomMargin = d16 + height + ak.a(f.this.getContext(), 4);
                    f.this.f39930as.setLayoutParams(layoutParams);
                }
            }
        });
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.selector.c.a
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            a(-1110, false);
            return;
        }
        Bitmap bitmap2 = this.f39957w;
        if (bitmap2 != bitmap) {
            if (bitmap2 != null) {
                try {
                    bitmap2.recycle();
                } catch (Throwable th5) {
                    GDTLogger.e("recycle bitmap error:", th5);
                }
            }
            this.f39957w = bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(14)
    /* loaded from: classes3.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<f> f39993a;

        public a(f fVar) {
            this.f39993a = new WeakReference<>(fVar);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            f fVar;
            WeakReference<f> weakReference = this.f39993a;
            if (weakReference != null && (fVar = weakReference.get()) != null) {
                if (!fVar.f39934aw) {
                    fVar.f(14);
                }
                com.qq.e.comm.plugin.tangramsplash.interactive.d.a().c();
                com.qq.e.comm.plugin.tangramsplash.interactive.d.a().d();
                if (fVar.f39949o != null) {
                    r rVar = fVar.f39941g;
                    if (fVar.f39922ak && GDTADManager.getInstance().getSM().getInteger("backgroundStopTopviewSplash", 1) == 1 && fVar.f39949o != null && com.qq.e.comm.plugin.tangramsplash.d.f.a(fVar, activity) && (rVar == null || !rVar.cc())) {
                        fVar.N = false;
                        fVar.f39949o.e();
                        fVar.ah();
                        return;
                    }
                    if (rVar != null && rVar.w() == 0 && GDTADManager.getInstance().getSM().getInteger("backgroundStopImgSplash", 0) == 1) {
                        fVar.N = false;
                        return;
                    }
                    if (rVar != null && rVar.w() == 1 && fVar.f39949o != null && com.qq.e.comm.plugin.tangramsplash.d.f.a(fVar, activity)) {
                        if (GDTADManager.getInstance().getSM().getInteger("backgroundStopVideoSplash", 0) == 1) {
                            fVar.f39949o.e();
                            fVar.ah();
                            fVar.N = false;
                            return;
                        }
                        fVar.f39949o.i();
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            WeakReference<f> weakReference = this.f39993a;
            if (weakReference != null) {
                try {
                    f fVar = weakReference.get();
                    if (fVar != null) {
                        fVar.N = true;
                        com.qq.e.comm.plugin.tangramsplash.interactive.d.a().e();
                        if (fVar.f39941g.bJ() != null) {
                            if (fVar.f39941g.bJ().n() >= com.qq.e.comm.plugin.tangramsplash.interactive.a.f40090b && fVar.f39941g.bJ().h() >= 2) {
                                com.qq.e.comm.plugin.tangramsplash.interactive.d.a().b();
                            } else if (fVar.f39941g.bJ().h() != 3) {
                                fVar.f39941g.bJ().h();
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public void i() {
        if (this.f39954t) {
            GDTLogger.d("\u5f00\u53d1\u8005\u4f7f\u7528\u81ea\u5b9a\u4e49\u52a8\u6001\u6d6e\u5c42");
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.e.b bVar = new com.qq.e.comm.plugin.tangramsplash.e.b(getContext());
        this.aB = bVar;
        if (bVar.getParent() != null) {
            ba.a(this.aB);
        }
        this.aB.a(this.f39941g.g());
        this.aB.setId(7);
        this.aB.setOnClickListener(this.f39912aa);
        this.aB.setPadding(ak.a(getContext(), 14), 0, ak.a(getContext(), 14), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, ak.a(getContext(), 40));
        v vVar = this.f39933av;
        layoutParams.bottomMargin = ak.d(getContext(), (vVar == null || vVar.e() <= 0) ? 17241 : this.f39933av.e());
        layoutParams.gravity = 85;
        addView(this.aB, layoutParams);
        i(this.aB);
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.f39923al && this.K != null && motionEvent.getAction() == 1) {
            GDTLogger.d("TangramSplashAdView: processAlphaVideoClick: " + this.K.toString() + " x: " + motionEvent.getX() + " y: " + motionEvent.getY());
            if (this.J != null) {
                Rect rect = new Rect();
                this.J.getGlobalVisibleRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    GDTLogger.d("TangramSplashAdViewprocessAlphaVideoClick: hit close view rect");
                    return false;
                }
            }
            if (this.K.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                SplashLinkReporter.a(7010014, this.f39941g);
                a((View) this, false);
                GDTLogger.d("TangramSplashAdViewprocessAlphaVideoClick: hit oneshot focus view rect");
                return true;
            }
            SplashLinkReporter.a(7010015, this.f39941g);
        }
        return false;
    }

    public void g(boolean z16) {
        this.S = z16;
    }

    public void g(int i3) {
        if (i3 == 0 && this.aH != 0) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1319053, this.f39939e, this.f39941g, System.currentTimeMillis() - this.aH);
        }
        this.f39950p = i3;
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        this.f39945k = view;
    }

    public void b(boolean z16) {
        this.f39955u = z16;
    }

    public void b(int i3) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310298, this.f39939e, this.f39941g, i3, this.f39940f);
    }

    private boolean a(Point point) {
        if (point == null || this.f39929ar == null || this.f39924am == null || !this.f39928aq) {
            return false;
        }
        GDTLogger.d("slide end = " + point.toString());
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("startX", Integer.valueOf(this.f39924am.x));
            hashMap.put("startY", Integer.valueOf(this.f39924am.y));
            hashMap.put("endX", Integer.valueOf(point.x));
            hashMap.put("endY", Integer.valueOf(point.y));
            hashMap.put("screenWidth", Integer.valueOf(n.c(getContext())));
            hashMap.put("screenHeight", Integer.valueOf(n.d(getContext())));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        boolean a16 = com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39924am, point, this.f39941g, hashMap);
        if (a16) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310812, this.f39941g, this.f39940f, hashMap);
            ADListener aDListener = this.f39947m;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(4));
            }
            this.f39927ap = true;
            i(1);
        } else {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310813, this.f39941g, this.f39940f, hashMap);
        }
        return a16;
    }

    private void b(Bitmap bitmap) {
        S();
        if (bitmap != null) {
            c(bitmap);
        }
    }

    private void i(boolean z16) {
        InteractiveInfo.a f16;
        int i3;
        FrameLayout.LayoutParams layoutParams;
        r rVar = this.f39941g;
        if (rVar == null || rVar.bJ() == null || (f16 = this.f39941g.bJ().f()) == null) {
            return;
        }
        if (f16.f38881b == 1 || !f16.f38893n) {
            int i16 = -1;
            try {
                i16 = Color.parseColor(f16.f38884e);
                i3 = Color.parseColor(f16.f38886g);
            } catch (Exception e16) {
                GDTLogger.e(e16.getMessage());
                i3 = 16736290;
            }
            String str = f16.f38885f;
            TextView textView = this.F;
            if (textView != null) {
                ba.a(textView);
            } else {
                TextView textView2 = new TextView(getContext());
                this.F = textView2;
                textView2.setTypeface(Typeface.defaultFromStyle(1));
                this.F.setPadding(ak.a(getContext(), 8), ak.a(getContext(), 3), ak.a(getContext(), 8), ak.a(getContext(), 3));
                this.F.setText(str);
                this.F.setTextColor(i16);
                this.F.setTextSize(14.0f);
                this.F.setGravity(17);
                this.F.setId(10);
                this.F.setOnClickListener(this.f39912aa);
            }
            if (z16) {
                this.F.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(ak.a(getContext(), 18), i3, 255));
                layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 200), ak.a(getContext(), 36));
                layoutParams.gravity = 17;
            } else {
                this.F.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(ak.a(getContext(), 23), i3, 255));
                layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 250), ak.a(getContext(), 46));
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = ak.a(getContext(), 60);
            }
            this.F.setVisibility(0);
            addView(this.F, layoutParams);
        }
    }

    public void b(String str) {
        GDTLogger.i("reportEmptyOrder with url:" + str);
        af.b(com.qq.e.comm.plugin.k.b.d(str));
    }

    @Override // com.qq.e.comm.plugin.k.e.a
    public void b(View view, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ab record host ");
        sb5.append(view != null ? Integer.valueOf(view.getId()) : "");
        sb5.append("hitAccessibilityClick = ");
        sb5.append(z16);
        GDTLogger.i(sb5.toString());
        r rVar = this.f39941g;
        if (rVar != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310910, rVar.s(), this.f39941g, f(), this.f39919ah, z16 ? 1 : 0, this.f39940f, this.M);
        }
    }

    public void a(Map<String, String> map) {
        this.Q = map;
    }

    public void a(ADListener aDListener) {
        this.f39947m = aDListener;
    }

    public ADListener a() {
        return this.f39947m;
    }

    public void a(View view) {
        if (view == null) {
            return;
        }
        this.f39944j = view;
    }

    public void a(LoadAdParams loadAdParams) {
        this.f39914ac = loadAdParams;
        this.f39940f = com.qq.e.comm.plugin.tangramsplash.d.a.a(loadAdParams);
        if (loadAdParams != null) {
            com.qq.e.comm.plugin.j.e.a().a(loadAdParams.getExperimentType(), loadAdParams.getExperimentId(), this.f39939e);
        }
        this.f39938d.a(loadAdParams);
    }

    public void a(ViewGroup viewGroup, int i3) {
        com.qq.e.comm.plugin.tangramsplash.c.a().b();
        if (GDTADManager.getInstance().getSM().getInteger("tangram_splash_switch", 0) == 1) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310202, this.f39939e, (r) null, this.f39940f);
            h(-999);
            return;
        }
        if (com.qq.e.comm.plugin.tangramsplash.d.f.a(getContext())) {
            com.qq.e.comm.plugin.tangramsplash.a.c.a().b();
        }
        boolean z16 = this.M;
        if (!z16) {
            if (viewGroup == null) {
                GDTLogger.e("Container param for fetchAndShowIn Method should not be null");
                h(-1100);
                return;
            }
            this.f39943i = viewGroup;
        }
        this.f39938d.a(z16, i3);
    }

    public void a(Rect rect) {
        this.K = rect;
    }

    public void a(ITangramDecoderPlayer iTangramDecoderPlayer) {
        this.L = iTangramDecoderPlayer;
    }

    public void a(com.qq.e.comm.plugin.tangramsplash.video.b bVar) {
        if (bVar != null) {
            this.f39949o = bVar;
            this.f39952r = bVar.a();
            GDTLogger.d("splash_tangram setTgPlayer tgPlayer come from OutSide and isNeedAddToContainer :" + this.f39952r);
            this.f39953s = false;
            return;
        }
        this.f39949o = new com.qq.e.comm.plugin.tangramsplash.video.b(GDTADManager.getInstance().getAppContext(), (WeakReference<f>) new WeakReference(this));
        GDTLogger.d("splash_tangram setTgPlayer tgPlayer come from inSide");
        this.f39953s = true;
    }

    public void a(boolean z16) {
        this.f39954t = z16;
    }

    public void a(int i3) {
        this.C = i3;
    }

    public void a(int i3, int i16, Map map) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(this.f39941g, this.f39940f, i3, i16, map);
    }

    public void a(TGSplashAD.ReportParams reportParams) {
        if (reportParams != null) {
            SplashLinkReporter.a(reportParams.eventId, reportParams.posId, reportParams.adJson);
        }
    }

    public void a(final TGSplashAD.SplashDisplayParams splashDisplayParams) {
        GDTLogger.i("splash call show");
        com.qq.e.comm.plugin.tangramsplash.report.c.c(13100200, this.f39939e, null, 0, this.f39940f);
        if (splashDisplayParams != null && splashDisplayParams.isValid()) {
            String aid = splashDisplayParams.splashAd.getAid();
            if (this.f39914ac != null && !TextUtils.isEmpty(aid)) {
                List<String> blackAidList = this.f39914ac.getBlackAidList();
                if (g.a(blackAidList)) {
                    Iterator<String> it = blackAidList.iterator();
                    while (it.hasNext()) {
                        if (aid.equals(it.next())) {
                            com.qq.e.comm.plugin.tangramsplash.report.c.a(13100206, this.f39939e, (r) null, this.f39940f);
                            h(5027);
                            return;
                        }
                    }
                }
            }
            com.qq.e.comm.plugin.tangramsplash.report.c.a(13100202, this.f39939e, (r) null, this.f39940f);
            long currentTimeMillis = System.currentTimeMillis();
            int a16 = a(splashDisplayParams.splashAd.getUoid(), splashDisplayParams.splashAd.getPreloadData());
            if (a16 == 0) {
                GDTLogger.i("splash matchOrder success");
                this.f39957w = splashDisplayParams.bitmap;
                GDTLogger.i("set splash bitmap :" + this.f39957w);
                HashMap hashMap = new HashMap();
                hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f39940f));
                com.qq.e.comm.plugin.tangramsplash.report.c.a(13100203, this.f39939e, this.f39941g, hashMap);
                if (a(splashDisplayParams.container) && E()) {
                    a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                GDTLogger.i("splash ready to show");
                                f.this.D();
                                File a17 = k.a(2, splashDisplayParams.splashAd.getVideo());
                                if (a17.exists()) {
                                    f.this.f39959y = 2;
                                    f.this.f39919ah = f.f39910b;
                                    f.this.aH = System.currentTimeMillis();
                                    f.this.a(a17);
                                    f fVar = f.this;
                                    TGSplashAD.SplashDisplayParams splashDisplayParams2 = splashDisplayParams;
                                    fVar.a(splashDisplayParams2.bitmap, splashDisplayParams2.firstFrameTimeout);
                                } else {
                                    f.this.f39919ah = f.f39909a;
                                    f.this.d(splashDisplayParams.bitmap);
                                    com.qq.e.comm.plugin.tangramsplash.report.c.c(13100205, f.this.f39939e, f.this.f39941g, 1, f.this.f39940f);
                                }
                            } catch (Throwable unused) {
                                f.this.h(5007);
                            }
                        }
                    });
                    C();
                    return;
                }
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            hashMap2.put("error_code", Integer.valueOf(a16));
            hashMap2.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f39940f));
            com.qq.e.comm.plugin.tangramsplash.report.c.a(13100204, this.f39939e, this.f39941g, hashMap2);
            h(5004);
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100201, this.f39939e, (r) null, this.f39940f);
        h(5004);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, long j3) {
        if (this.f39941g == null || bitmap == null) {
            return;
        }
        if (j3 > 0) {
            d(bitmap);
            this.aG = true;
            com.qq.e.comm.plugin.tangramsplash.report.c.c(13100205, this.f39939e, this.f39941g, 3, this.f39940f);
        }
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.11
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f39949o != null && f.this.f39949o.k()) {
                    GDTLogger.e("first frame img show timeout, video isRendered return.");
                    return;
                }
                com.qq.e.comm.plugin.tangramsplash.report.c.c(13100250, f.this.f39939e, f.this.f39941g, 3, f.this.f39940f);
                GDTLogger.e("first frame img show timeout!");
                f.this.g();
            }
        }, j3);
    }

    private int a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.qq.e.comm.plugin.tangramsplash.selector.c cVar = this.f39938d;
            if (cVar != null && cVar.c() != null) {
                GDTLogger.i(" [matchOrder] start ");
                ArrayList<r> arrayList = new ArrayList();
                JSONObject a16 = y.a(str2);
                if (!y.a(a16)) {
                    GDTLogger.e(" [matchOrder] error with null ad json");
                    return 2;
                }
                com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(a16, com.qq.e.comm.plugin.base.ad.b.SPLASH, this.f39938d.c().f40334a, this.f39939e, this.f39938d.c().f40336c, null, arrayList, false);
                if (arrayList.size() <= 0) {
                    GDTLogger.e(" [matchOrder] error with null ad list");
                    return 3;
                }
                for (r rVar : arrayList) {
                    if (rVar != null) {
                        if (com.qq.e.comm.plugin.j.c.a("checkSplashAdModeBeforeShow", 1, 1) && !com.qq.e.comm.plugin.tangramsplash.selector.b.a(rVar)) {
                            GDTLogger.e("before show not support this ad mode:" + rVar.bP());
                            com.qq.e.comm.plugin.tangramsplash.report.c.a(13100211, rVar, this.f39940f);
                        } else if (str.equals(rVar.bn())) {
                            GDTLogger.i(" [matchOrder] success cost:" + (System.currentTimeMillis() - currentTimeMillis));
                            GDTLogger.i(" [matchOrder] success uoid :" + str + " aid :" + rVar.f());
                            com.qq.e.comm.plugin.tangramsplash.a.a().a(rVar);
                            this.f39938d.a(7);
                            return 0;
                        }
                    }
                }
                GDTLogger.i(" [matchOrder] fail cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return 4;
            }
            GDTLogger.e(" [matchOrder] error with null paramsHolder");
            return 1;
        }
        GDTLogger.e(" [matchOrder] error with null uoid or preloadJson :" + str);
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ViewGroup viewGroup, final long j3) {
        boolean z16;
        int w3;
        com.qq.e.comm.plugin.tangramsplash.report.c.c(13100200, this.f39939e, this.f39941g, 5, this.f39940f);
        this.aI = true;
        try {
            r rVar = this.f39941g;
            String f16 = rVar != null ? rVar.f() : "";
            if (this.f39914ac != null && !TextUtils.isEmpty(f16) && g.a(this.f39914ac.getBlackAidList())) {
                ArrayList arrayList = new ArrayList(this.f39914ac.getBlackAidList());
                if (g.a(arrayList)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (f16.equals((String) it.next())) {
                            com.qq.e.comm.plugin.tangramsplash.report.c.a(13100206, this.f39939e, this.f39941g, this.f39940f);
                            h(5027);
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e("blackAidList parse error:", th5);
        }
        if (!a(viewGroup)) {
            return;
        }
        if (this.f39941g.bI() != null && this.f39941g.bI().size() != 0) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310331, this.f39939e, this.f39941g, this.f39940f);
            r.a b16 = com.qq.e.comm.plugin.tangramsplash.d.a.b(this.f39941g);
            if (b16 != null) {
                this.f39941g.a(b16);
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310332, this.f39939e, this.f39941g, this.f39940f);
                z16 = true;
                w3 = this.f39941g.w();
                if (w3 != 0) {
                    if (this.f39957w != null) {
                        this.f39919ah = f39909a;
                        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.12
                            @Override // java.lang.Runnable
                            public void run() {
                                b bVar = new b();
                                bVar.f39995b = f.this.f39957w;
                                bVar.f39996c = j3;
                                f.this.a(bVar);
                            }
                        });
                        return;
                    } else if (this.f39920ai) {
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -11, this.f39940f);
                        h(4018);
                        return;
                    } else {
                        int i3 = !z16 ? -12 : -13;
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, i3, this.f39940f);
                        h(i3);
                        return;
                    }
                }
                if (w3 != 1) {
                    return;
                }
                final File a16 = !TextUtils.isEmpty(this.f39941g.bt()) ? at.a(2, this.f39939e, this.f39941g.bt()) : null;
                if (a16 == null || !a16.exists()) {
                    a16 = at.a(2, this.f39939e, this.f39941g.x());
                }
                File a17 = k.a(1, this.f39939e, this.f39941g.ag());
                File a18 = at.a(1, this.f39939e, this.f39941g.h());
                if (a17.exists() && a16.exists()) {
                    this.f39959y = 2;
                    this.f39919ah = f39910b;
                    a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.13
                        @Override // java.lang.Runnable
                        public void run() {
                            b bVar = new b();
                            bVar.f39994a = a16;
                            bVar.f39995b = f.this.f39957w;
                            bVar.f39996c = j3;
                            f.this.a(bVar);
                        }
                    });
                    return;
                } else if (a18.exists()) {
                    this.f39919ah = f39911c;
                    a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.14
                        @Override // java.lang.Runnable
                        public void run() {
                            b bVar = new b();
                            bVar.f39995b = f.this.f39957w;
                            bVar.f39996c = j3;
                            f.this.a(bVar);
                        }
                    });
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, !z16 ? -21 : -24, this.f39940f);
                    return;
                } else if (this.f39920ai) {
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -22, this.f39940f);
                    h(4018);
                    return;
                } else {
                    int i16 = !z16 ? -23 : -25;
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, i16, this.f39940f);
                    h(i16);
                    return;
                }
            }
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310333, this.f39939e, this.f39941g, this.f39940f);
        } else {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310330, this.f39939e, this.f39941g, this.f39940f);
        }
        z16 = false;
        w3 = this.f39941g.w();
        if (w3 != 0) {
        }
    }

    private boolean a(ViewGroup viewGroup) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310301, this.f39939e, this.f39941g, this.f39940f);
        SplashLinkReporter.a(7010001, this.f39941g);
        if (this.M) {
            au.a(1310504, this.f39939e, this.f39940f, this.f39914ac, this.f39953s, this.f39915ad);
        } else {
            au.a(1310502, this.f39939e, this.f39940f, this.f39914ac, this.f39953s, this.f39915ad);
        }
        if (this.f39938d.a() == 7) {
            GDTLogger.e("curState need to show now let go!");
        } else if (viewGroup == null || (this.f39938d.a() != 5 && this.f39938d.a() != 4)) {
            GDTLogger.e("Container for showAd method is null or state is not loading or shownBlock");
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310308, this.f39939e, this.f39941g, this.f39940f);
            h(-1100);
            return false;
        }
        this.f39941g = com.qq.e.comm.plugin.tangramsplash.a.a().b();
        this.f39920ai = com.qq.e.comm.plugin.tangramsplash.a.a().d(this.f39941g);
        this.f39921aj = com.qq.e.comm.plugin.tangramsplash.a.a().e(this.f39941g);
        this.f39922ak = com.qq.e.comm.plugin.tangramsplash.a.a().c(this.f39941g);
        r rVar = this.f39941g;
        if (rVar == null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310309, this.f39939e, (r) null, this.f39940f);
            h(WeakNetLearner.PROBE_REASON.INVALID_DATA);
            return false;
        }
        if (this.f39957w == null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310313, this.f39939e, rVar, this.f39940f);
            h(-1110);
            return false;
        }
        this.f39943i = viewGroup;
        this.f39933av = rVar.H(1);
        if (this.f39920ai && !this.f39921aj) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -30, this.f39940f);
            h(4018);
            return false;
        }
        if (this.f39941g.bG() && !com.qq.e.comm.plugin.tangramsplash.d.f.a(this.f39941g, this.f39940f)) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -31, this.f39940f);
            h(4020);
            return false;
        }
        if (!com.qq.e.comm.plugin.tangramsplash.b.c.e(this.f39941g)) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -32, this.f39940f);
            h(4021);
            return false;
        }
        if (!com.qq.e.comm.plugin.tangramsplash.b.c.f(this.f39941g)) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -33, this.f39940f);
            h(4022);
            return false;
        }
        if (com.qq.e.comm.plugin.tangramsplash.b.c.d(this.f39941g)) {
            return true;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310302, this.f39939e, this.f39941g, -33, this.f39940f);
        h(InnerShareData.SUB_SCENE_ARK_INVITE_API);
        return false;
    }

    private void a(final int i3, boolean z16) {
        GDTLogger.e("splash fail :" + i3 + " curState :" + this.f39938d.a());
        if (this.f39938d.a() != 6) {
            this.f39938d.a(6);
            GDTLogger.i("splash fail : adListener " + this.f39947m + " needPostToMainThread:" + z16);
            ADListener aDListener = this.f39947m;
            if (aDListener != null) {
                if (z16) {
                    a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.15
                        @Override // java.lang.Runnable
                        public void run() {
                            GDTLogger.i("drawPost " + f.this.f39947m + " errCode:" + i3);
                            f.this.f39947m.onADEvent(new ADEvent(2, new Object[]{Integer.valueOf(i3)}));
                        }
                    });
                } else {
                    aDListener.onADEvent(new ADEvent(2, new Object[]{Integer.valueOf(i3)}));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.a()) {
            if ((this.f39938d.a() == 5 || this.f39938d.a() == 4 || this.f39938d.a() == 7) && E()) {
                D();
                int i3 = this.f39959y;
                if (i3 == 1) {
                    d(bVar.f39995b);
                } else if (i3 == 2) {
                    a(bVar.f39994a);
                    a(bVar.f39995b, bVar.f39996c);
                }
                ai();
                C();
                return;
            }
            return;
        }
        GDTLogger.e("show params invalid");
    }

    public void a(View view, boolean z16) {
        if (com.qq.e.comm.plugin.tangramsplash.d.f.a()) {
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.video.b bVar = this.f39949o;
        if (bVar != null && bVar.f()) {
            this.f39949o.e();
        }
        if (this.f39941g != null) {
            G();
            String af5 = af();
            int i3 = 1;
            this.f39934aw = true;
            com.qq.e.comm.plugin.base.ad.e.g.a(view, this.f39941g, af5, null, 0, -1, this);
            this.S = false;
            if (this.f39919ah == f39910b) {
                i3 = this.aG ? 3 : 2;
            }
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310312, this.f39939e, this.f39941g, f(), this.f39919ah, i3, this.f39940f, this.M);
            if (this.f39941g.bJ() != null && z16) {
                String str = this.f39939e;
                r rVar = this.f39941g;
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310341, str, rVar, rVar.bJ().n(), this.f39940f);
            }
            ADListener aDListener = this.f39947m;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(4));
            }
        }
    }

    @Override // com.qq.e.comm.plugin.base.adevent.a
    public void a(ADLifeEvent aDLifeEvent) {
        GDTLogger.d("SplashAdView OnADLifeEvent:" + aDLifeEvent.a());
        String a16 = aDLifeEvent.a();
        a16.hashCode();
        if (a16.equals("Clicked")) {
            if (this.f39913ab == 2) {
                this.f39913ab = 1;
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("splash finish by 'splash click'  with ");
            sb5.append(this.S ? "normal" : "not normal");
            GDTLogger.d(sb5.toString());
            r rVar = this.f39941g;
            boolean z16 = false;
            if (rVar != null && rVar.bJ() != null) {
                z16 = this.f39941g.bJ().h() >= 2;
            }
            if (!z16) {
                f(12);
            }
            g();
        }
    }

    private void a(final View view, int i3) {
        if (view != null) {
            if (i3 > 0) {
                view.setVisibility(4);
                view.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setVisibility(0);
                    }
                }, i3);
            } else {
                view.setVisibility(0);
            }
        }
    }

    private void a(long j3) {
        r rVar = this.f39941g;
        if (rVar == null || !rVar.cc()) {
            return;
        }
        av avVar = new av(j3, com.qq.e.comm.plugin.j.c.a("splashAlphaVideoCountdownInterval", 10), false) { // from class: com.qq.e.comm.plugin.tangramsplash.f.7
            @Override // com.qq.e.comm.plugin.k.av
            public void a() {
            }

            @Override // com.qq.e.comm.plugin.k.av
            public void a(long j16) {
                int h16 = f.this.f39949o.h();
                GDTLogger.d("mAlphaVideoUISwitchTimer onTick" + h16);
                if (f.this.f39923al || h16 < f.this.f39941g.cd() || !com.qq.e.comm.plugin.tangramsplash.video.d.b()) {
                    return;
                }
                GDTLogger.d("mAlphaVideoUISwitchTimer Component switch int time= " + h16);
                SplashLinkReporter.a(7010008, f.this.f39941g);
                f.this.o();
                f.this.e(true);
            }
        };
        this.W = avVar;
        avVar.b();
    }

    public SplashOrder a(String str) {
        com.qq.e.comm.plugin.tangramsplash.selector.c cVar;
        if (SDKStatus.getSDKVersionCode() >= 370 && (cVar = this.f39938d) != null) {
            return cVar.a(str);
        }
        GDTLogger.e("getSelectResultImmediately error .");
        return null;
    }

    public boolean a(boolean z16, boolean z17) {
        r rVar = this.f39941g;
        if (rVar == null || rVar.bJ() == null) {
            return false;
        }
        long currentTimeMillis = this.f39918ag > 0 ? System.currentTimeMillis() - this.f39918ag : 0L;
        if (this.f39941g.bJ().h() == 2) {
            String str = this.f39939e;
            r rVar2 = this.f39941g;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310350, str, rVar2, currentTimeMillis, rVar2.bJ().n(), this.f39940f, this.M);
        }
        InteractiveInfo.a f16 = this.f39941g.bJ().f();
        boolean z18 = f16 != null && f16.f38893n;
        if (!z17 && !z18) {
            if (z16 && this.f39941g.bJ().n() < com.qq.e.comm.plugin.tangramsplash.interactive.a.f40090b) {
                this.f39941g.bJ().i();
                Z();
            } else {
                GDTLogger.d("easter egg page hold there!");
            }
            return false;
        }
        String str2 = this.f39939e;
        r rVar3 = this.f39941g;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310351, str2, rVar3, currentTimeMillis, rVar3.bJ().n(), this.f39940f, this.M);
        ADListener aDListener = this.f39947m;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(4));
        }
        i(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        View view;
        B();
        com.qq.e.comm.plugin.tangramsplash.video.b bVar = this.f39949o;
        if (bVar == null) {
            GDTLogger.e("tgPlayer obj is null!");
            return;
        }
        this.aE = bVar.b();
        if (this.f39952r && this.f39949o.c() && (view = this.aE) != null) {
            ba.a(view);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.aE.setAlpha(0.0f);
            addView(this.aE, layoutParams);
            this.aE.setId(5);
            this.aE.setOnClickListener(this.f39912aa);
        } else {
            this.f39943i.setOnClickListener(this.f39912aa);
        }
        com.qq.e.comm.plugin.base.ad.c cVar = new com.qq.e.comm.plugin.base.ad.c();
        this.f39958x = cVar;
        cVar.a(this.f39943i);
        this.f39958x.a(System.currentTimeMillis());
        if (file != null && file.exists()) {
            GDTLogger.i("setDataSource to tgPlayer: " + file.getAbsolutePath());
            this.f39949o.a(file.getAbsolutePath());
            if (this.f39920ai && this.f39921aj && this.f39949o.c()) {
                this.f39949o.b(false);
            }
            this.f39949o.i();
            this.f39949o.d();
            return;
        }
        this.f39950p = 2;
    }

    public void a(Runnable runnable) {
        ViewGroup viewGroup = this.f39943i;
        if (viewGroup != null) {
            viewGroup.post(runnable);
        }
    }

    public void a(Runnable runnable, long j3) {
        ViewGroup viewGroup = this.f39943i;
        if (viewGroup != null) {
            viewGroup.postDelayed(runnable, j3);
        }
    }

    private View a(v vVar) {
        int f16;
        if (vVar == null || (f16 = vVar.f()) == 0) {
            return null;
        }
        int c16 = ak.c(getContext(), vVar.c());
        int c17 = ak.c(getContext(), vVar.d());
        int b16 = (ak.b(getContext()) - c16) - c17;
        int ceil = (int) Math.ceil((b16 * 100000.0f) / f16);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ceil);
        layoutParams.leftMargin = c16;
        layoutParams.rightMargin = c17;
        layoutParams.bottomMargin = ak.d(getContext(), vVar.e());
        layoutParams.gravity = 81;
        View view = new View(getContext());
        view.setBackgroundColor(0);
        addView(view, layoutParams);
        GDTLogger.d("createHotArea type :" + vVar.a() + " leftMargin " + c16 + " rightMargin " + c17 + " width " + b16 + " height " + ceil + " bottomMargin " + layoutParams.bottomMargin);
        return view;
    }

    private void a(AnimationPlayInfo animationPlayInfo) {
        if (animationPlayInfo == null) {
            GDTLogger.d("calculateAndSetPileUpArea fail");
            return;
        }
        View view = this.f39931at;
        if (view != null) {
            animationPlayInfo.setPileUpAreaLeft(view.getLeft());
            animationPlayInfo.setPileUpAreaRight(this.f39931at.getRight());
            animationPlayInfo.setPileUpAreaY(this.f39931at.getTop());
        } else {
            animationPlayInfo.setPileUpAreaLeft(0);
            animationPlayInfo.setPileUpAreaRight(n.c(GDTADManager.getInstance().getAppContext()));
            animationPlayInfo.setPileUpAreaY(getHeight());
        }
    }

    private void a(View view, List<Rect> list) {
        if (view != null && list != null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            list.add(rect);
            GDTLogger.d("FilterRects local rect =" + rect.toString());
            return;
        }
        GDTLogger.d("addRectFromViewToList invalid parameters");
    }
}
