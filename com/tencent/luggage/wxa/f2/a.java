package com.tencent.luggage.wxa.f2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.lo.f;
import com.tencent.luggage.wxa.lo.k;
import com.tencent.luggage.wxa.ok.g;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mobileqq.R;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends f0 {
    public static final int Q = 2131363109;
    public static boolean R = false;
    public c N;
    public WAGamePanelInputEditText O;
    public View.OnClickListener P;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC6183a implements View.OnClickListener {
        public ViewOnClickListenerC6183a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.P != null) {
                a.this.P.onClick(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f125196a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.vl.c.values().length];
            f125196a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.vl.c.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f125196a[com.tencent.luggage.wxa.vl.c.SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f125196a[com.tencent.luggage.wxa.vl.c.NEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f125196a[com.tencent.luggage.wxa.vl.c.GO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f125196a[com.tencent.luggage.wxa.vl.c.SEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
    }

    public a(Context context, boolean z16) {
        super(context, null, z16);
    }

    public static a d(View view) {
        return (a) view.getRootView().findViewById(Q);
    }

    public static /* synthetic */ d y() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final c h() {
        c cVar = new c(getContext());
        this.O = (WAGamePanelInputEditText) cVar.findViewById(R.id.vix);
        cVar.a().setOnClickListener(new ViewOnClickListenerC6183a());
        a(this.O);
        a(c(cVar));
        cVar.b(l());
        cVar.a(getContext());
        this.N = cVar;
        return cVar;
    }

    public final boolean B() {
        if ((this.O.getInputType() & 131072) > 0) {
            return true;
        }
        return false;
    }

    public void b(boolean z16) {
        com.tencent.luggage.wxa.ul.a aVar;
        if (l() && (aVar = this.f136728j) != null) {
            aVar.b(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public final int f() {
        return Q;
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public void n() {
        int i3;
        ImageButton imageButton;
        View a16 = this.N.a();
        if (!B() && ((imageButton = this.f136731m) == null || imageButton.getVisibility() != 0)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        a16.setVisibility(i3);
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public void q() {
        a(this, R);
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public void s() {
        if (this.H.f() != null) {
            try {
                x xVar = (x) q.b(this).getOnLayoutListener();
                if (!g.a(this.H.f()) && !g.i(this.H.f())) {
                    this.H.f().getWindow().setSoftInputMode(48);
                    xVar.e(2);
                }
                this.H.f().getWindow().setSoftInputMode(16);
                xVar.e(1);
            } catch (Exception e16) {
                w.b("MicroMsg.WAGameInputPanel", "show() fix SoftInputMode for game, get exception:%s", e16);
            }
        }
        a((EditText) this.O);
        this.O.requestFocus();
        super.s();
    }

    public void setOnConfirmClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnEmoticonOperationListener(com.tencent.luggage.wxa.ul.b bVar) {
        com.tencent.luggage.wxa.ul.a aVar = this.f136728j;
        if (aVar != null) {
            aVar.setOnEmoticonOperationListener(bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public void v() {
        this.N.a(false);
    }

    public static a a(View view, boolean z16) {
        q b16 = q.b(view);
        q.c(view);
        f0 a16 = f0.a(view);
        if (a16 != null && (a16.getParent() instanceof ViewGroup)) {
            ((ViewGroup) a16.getParent()).removeView(a16);
        }
        a d16 = d(view);
        if (R != z16 && d16 != null) {
            b16.removeView(d16);
            d16 = null;
        }
        R = z16;
        if (d16 == null) {
            if (view instanceof a) {
                d16 = (a) view;
            } else {
                d16 = new a(view.getContext(), z16);
            }
            b16.a(d16);
        }
        return d16;
    }

    public void d(boolean z16) {
        com.tencent.luggage.wxa.ul.a aVar;
        if (!l() || (aVar = this.f136728j) == null) {
            return;
        }
        aVar.d(z16);
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public WAGamePanelInputEditText getAttachedEditText() {
        return (WAGamePanelInputEditText) super.getAttachedEditText();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends FrameLayout implements f0.h {

        /* renamed from: a, reason: collision with root package name */
        public View f125197a;

        public c(Context context) {
            super(context);
            a.y();
            LayoutInflater.from(context).inflate(R.layout.dxz, (ViewGroup) this, true);
            ((Button) findViewById(R.id.viw)).setText(R.string.z3a);
            setClickable(true);
        }

        public View a() {
            if (this.f125197a == null) {
                this.f125197a = findViewById(R.id.viw);
            }
            return this.f125197a;
        }

        public void b(boolean z16) {
            int i3;
            View findViewById = findViewById(R.id.f86464rq);
            if (findViewById != null) {
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                findViewById.setVisibility(i3);
            }
        }

        @Override // com.tencent.luggage.wxa.ol.f0.h
        public void a(boolean z16) {
            setVisibility(z16 ? 8 : 0);
        }

        public void a(int i3) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f125197a.getLayoutParams();
            w.d("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", Integer.valueOf(i3), Integer.valueOf(layoutParams.rightMargin));
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin + i3, layoutParams.bottomMargin);
            this.f125197a.setLayoutParams(layoutParams);
        }

        public void a(Context context) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.viv);
            WeImageButton weImageButton = (WeImageButton) findViewById(R.id.f86464rq);
            if (a.R) {
                linearLayout.setBackground(com.tencent.luggage.wxa.kn.a.e(context, R.color.aqs));
                if (weImageButton != null) {
                    weImageButton.setIconColor(com.tencent.luggage.wxa.kn.a.b(context, R.color.anp));
                    return;
                }
                return;
            }
            linearLayout.setBackground(com.tencent.luggage.wxa.kn.a.e(context, R.color.ao5));
            if (weImageButton != null) {
                weImageButton.setIconColor(com.tencent.luggage.wxa.kn.a.b(context, R.color.ar9));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ol.f0, com.tencent.luggage.wxa.ol.x.i
    public void a(int i3) {
        WindowInsets a16;
        int stableInsetBottom;
        int navigationBars;
        Insets insets;
        if (i3 > 0 && 2 == ((x) q.b(this).getOnLayoutListener()).b()) {
            Activity f16 = this.H.f();
            if (g.h(f16) && (a16 = k.a(f16)) != null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    navigationBars = WindowInsets.Type.navigationBars();
                    insets = a16.getInsets(navigationBars);
                    stableInsetBottom = insets.bottom;
                } else {
                    stableInsetBottom = a16.getStableInsetBottom();
                }
                w.a("MicroMsg.WAGameInputPanel", "refreshHeight height:%d, append insetBottom:%d", Integer.valueOf(i3), Integer.valueOf(stableInsetBottom));
                i3 += stableInsetBottom;
            }
        }
        super.a(i3);
    }

    @Override // com.tencent.luggage.wxa.ol.f0
    public void m() {
    }

    @Override // com.tencent.luggage.wxa.ol.f0, com.tencent.luggage.wxa.ol.x.i
    public void a(boolean z16) {
        super.a(z16);
        if (z16) {
            return;
        }
        com.tencent.mm.ui.statusbar.a.a(this.H.f()).d();
    }

    public void a(com.tencent.luggage.wxa.vl.c cVar, com.tencent.luggage.wxa.x1.a aVar, Context context, e.b bVar, boolean z16) {
        setCanSmileyInput(aVar == com.tencent.luggage.wxa.x1.a.EMOJI);
        if (bVar == e.b.LANDSCAPE_SENSOR || bVar == e.b.LANDSCAPE_LOCKED || e.b.LANDSCAPE_LEFT == bVar || e.b.LANDSCAPE_RIGHT == bVar) {
            int b16 = f.b(context);
            int a16 = l.f126905a.a(context);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O.getLayoutParams();
            w.d("MicroMsg.WAGameInputPanel", "EditBar setEditText cutoutHeight(%d),leftMargin(%d).", Integer.valueOf(a16), Integer.valueOf(layoutParams.leftMargin));
            if (a16 > 0) {
                layoutParams.setMargins(a16, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            this.O.setLayoutParams(layoutParams);
            this.N.a(b16);
        }
        if (cVar == null) {
            cVar = com.tencent.luggage.wxa.vl.c.DONE;
        }
        getAttachedEditText().setImeOptions(cVar.f143658a);
        getAttachedEditText().setSingleLine(!z16);
        if (!z16) {
            getAttachedEditText().setInputType(1);
        } else {
            getAttachedEditText().setInputType(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
        }
        getAttachedEditText().setFocusable(true);
        getAttachedEditText().setFocusableInTouchMode(true);
        s();
        int i3 = b.f125196a[cVar.ordinal()];
        if (i3 == 1) {
            ((Button) this.N.a()).setText(R.string.z3a);
            return;
        }
        if (i3 == 2) {
            ((Button) this.N.a()).setText(R.string.z3d);
            return;
        }
        if (i3 == 3) {
            ((Button) this.N.a()).setText(R.string.z3c);
        } else if (i3 == 4) {
            ((Button) this.N.a()).setText(R.string.z3b);
        } else {
            if (i3 != 5) {
                return;
            }
            ((Button) this.N.a()).setText(R.string.z3e);
        }
    }

    public static void setGameInputEditBarLayoutFactory(d dVar) {
    }
}
