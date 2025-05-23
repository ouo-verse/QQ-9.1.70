package com.tencent.mobileqq.widget.tip;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUIAppSetting;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;
import l53.e;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    private static final List<String> T = new CopyOnWriteArrayList();
    private static final List<WeakReference<a>> U = new CopyOnWriteArrayList();
    private Drawable[] A;
    private Drawable B;
    private c D;
    private ViewTreeObserverOnGlobalLayoutListenerC9004a E;
    private d G;
    protected String K;
    private View M;

    @LayoutRes
    private int N;
    private int O;
    private int P;
    protected final AnchorRelativePopupWindow Q;

    /* renamed from: c */
    protected int f317519c;

    /* renamed from: d */
    protected final WeakReference<Context> f317520d;

    /* renamed from: e */
    private WeakReference<View> f317521e;

    /* renamed from: f */
    private int f317522f;

    /* renamed from: g */
    private int f317523g;

    /* renamed from: h */
    protected int f317524h;

    /* renamed from: i */
    protected int f317525i;

    /* renamed from: j */
    private String f317526j;

    /* renamed from: k */
    private long f317527k;

    /* renamed from: l */
    private Drawable f317528l;

    /* renamed from: m */
    private Drawable f317529m;

    /* renamed from: n */
    private int f317530n;

    /* renamed from: p */
    private boolean f317532p;

    /* renamed from: q */
    private boolean f317533q;

    /* renamed from: r */
    private int f317534r;

    /* renamed from: s */
    private int f317535s;

    /* renamed from: t */
    private int f317536t;

    /* renamed from: u */
    private int f317537u;

    /* renamed from: v */
    private int f317538v;

    /* renamed from: w */
    private int f317539w;

    /* renamed from: x */
    private float f317540x;

    /* renamed from: y */
    private int f317541y;

    /* renamed from: z */
    private boolean f317542z;

    /* renamed from: a */
    private int f317517a = 0;

    /* renamed from: b */
    private final WeakReference<a> f317518b = new WeakReference<>(this);

    /* renamed from: o */
    protected int f317531o = 1;
    protected boolean C = true;
    private final Runnable F = new Runnable() { // from class: l53.a
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.mobileqq.widget.tip.a.this.o();
        }
    };
    private int H = 2;
    private int I = 0;
    private int J = 0;
    protected int L = Integer.MIN_VALUE;
    private boolean S = true;
    private List<b> R = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.tip.a$a */
    /* loaded from: classes20.dex */
    public static class ViewTreeObserverOnGlobalLayoutListenerC9004a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d */
        WeakReference<a> f317543d;

        public ViewTreeObserverOnGlobalLayoutListenerC9004a(a aVar) {
            this.f317543d = new WeakReference<>(aVar);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WeakReference<a> weakReference = this.f317543d;
            if (weakReference != null && weakReference.get() != null) {
                this.f317543d.get().z0(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onClick(View view);

        void onDismiss();

        void onShow();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: d */
        WeakReference<a> f317544d;

        public c(a aVar) {
            this.f317544d = new WeakReference<>(aVar);
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            WeakReference<a> weakReference = this.f317544d;
            if (weakReference != null && weakReference.get() != null) {
                this.f317544d.get().z0(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d */
        WeakReference<a> f317545d;

        public d(a aVar) {
            this.f317545d = new WeakReference<>(aVar);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            WeakReference<a> weakReference = this.f317545d;
            if (weakReference != null && weakReference.get() != null) {
                this.f317545d.get().O();
            }
            return true;
        }
    }

    public a(Context context) {
        this.f317520d = new WeakReference<>(context);
        this.Q = new AnchorRelativePopupWindow(context);
        n(context);
    }

    private void A() {
        if (t() != null && t().getVisibility() != 0) {
            QLog.d("QUIBubbleTip", 1, "[updatePopupWindow] invisible");
            o();
        }
    }

    private void B() {
        if (t() != null && this.Q != null) {
            if (t().isAttachedToWindow() && t().getWindowToken() != null) {
                int[] iArr = new int[2];
                t().getLocationInWindow(iArr);
                if (iArr[0] == 0 && iArr[1] == 0) {
                    QLog.d("QUIBubbleTip", 1, "[updatePopupWindow] anchor is invalid. ");
                    return;
                }
                int[] f16 = this.Q.f(t(), this.I, this.J, this.f317524h, this.f317525i);
                try {
                    this.Q.update(t(), f16[0], f16[1], -1, -1);
                    return;
                } catch (Exception e16) {
                    QLog.e("QUIBubbleTip", 1, "update failed. " + e16);
                    return;
                }
            }
            QLog.d("QUIBubbleTip", 1, "[updatePopupWindow] anchor is not attach to window. ");
            o();
            return;
        }
        QLog.d("QUIBubbleTip", 1, "[updatePopupWindow] anchor or popupWindow are null. ");
    }

    private void C() {
        List<b> list = this.R;
        if (list == null) {
            QLog.e("QUIBubbleTip", 1, "callback list is null");
            return;
        }
        for (b bVar : list) {
            if (bVar != null) {
                bVar.onShow();
            }
        }
    }

    private boolean D() {
        Drawable[] drawableArr = this.A;
        if (drawableArr != null && drawableArr.length > 0) {
            return true;
        }
        return false;
    }

    private boolean E() {
        if (this.B != null) {
            return true;
        }
        return false;
    }

    private static boolean F(a aVar) {
        return T.contains(s(aVar));
    }

    private void G() {
        if (this.N == 0) {
            return;
        }
        if (this.M != null) {
            QLog.d("QUIBubbleTip", 1, "inflater error. custom view already exist.");
            return;
        }
        try {
            this.M = LayoutInflater.from(this.f317520d.get()).inflate(this.N, (ViewGroup) null, false);
        } catch (Exception e16) {
            QLog.e("QUIBubbleTip", 1, "inflater custom view error.", e16);
        }
    }

    private void H(a aVar) {
        final String s16 = s(aVar);
        this.Q.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: l53.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                com.tencent.mobileqq.widget.tip.a.this.M(s16);
            }
        });
    }

    private boolean K(@NonNull View view) {
        boolean z16;
        boolean z17;
        if (view.getHeight() == 0 && view.getWidth() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || z16) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void M(String str) {
        T.remove(str);
        z();
    }

    public void O() {
        if (t() == null) {
            U.remove(this.f317518b);
            return;
        }
        if (!K(t())) {
            QLog.d("QUIBubbleTip", 1, "[onSizeReady] anchor | w: " + t().getWidth() + ", h: " + t().getHeight());
            t().getViewTreeObserver().removeOnPreDrawListener(this.G);
            U.remove(this.f317518b);
            q();
        }
    }

    private static void P(a aVar) {
        if (aVar == null) {
            return;
        }
        T.add(s(aVar));
    }

    private void Q() {
        if (t() == null) {
            return;
        }
        t().getViewTreeObserver().removeOnScrollChangedListener(this.D);
        t().getViewTreeObserver().removeOnPreDrawListener(this.G);
        t().getViewTreeObserver().removeOnGlobalLayoutListener(this.E);
    }

    private void V(@NotNull View view, Drawable drawable) {
        view.setBackground(null);
        view.setBackground(drawable);
    }

    private void e(View view, int i3, int i16) {
        if (view == null) {
            QLog.e("QUIBubbleTip", 1, "addOnArrowViewMargin | arrow is null");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        int i17 = this.f317522f;
        if (i17 != 0 && i17 != 1) {
            layoutParams.topMargin += i16;
        } else {
            layoutParams.leftMargin += i3;
        }
        view.setLayoutParams(layoutParams);
    }

    private void g(@NonNull FrameLayout frameLayout) {
        int i3;
        if (this.f317532p) {
            i3 = 12;
        } else {
            i3 = 0;
        }
        int c16 = x.c(frameLayout.getContext(), 6.0f) + i3;
        int i16 = this.I;
        if (i16 == 1) {
            frameLayout.setPadding(i3, i3, i3, c16);
            return;
        }
        if (i16 == 2) {
            frameLayout.setPadding(i3, c16, i3, i3);
            return;
        }
        int i17 = this.J;
        if (i17 == 1) {
            frameLayout.setPadding(i3, i3, c16, i3);
        } else if (i17 == 2) {
            frameLayout.setPadding(c16, i3, i3, i3);
        }
    }

    private boolean h() {
        if (t() != null && t().getWindowToken() != null) {
            return false;
        }
        return true;
    }

    private void i() {
        List<b> list = this.R;
        if (list != null) {
            list.clear();
        }
    }

    private void j(@NonNull View view) {
        if (E()) {
            view.setVisibility(0);
            ImageView imageView = (ImageView) view.findViewById(R.id.ti7);
            imageView.setImageDrawable(this.B);
            imageView.setVisibility(0);
            return;
        }
        if (D()) {
            view.setVisibility(0);
            int[] iArr = {R.id.thy, R.id.thz, R.id.f164689ti0};
            for (int i3 = 0; i3 < 3 && i3 < this.A.length; i3++) {
                RoundImageView roundImageView = (RoundImageView) view.findViewById(iArr[i3]);
                roundImageView.setImageDrawable(this.A[i3]);
                roundImageView.setVisibility(0);
            }
        }
    }

    @NonNull
    private void k(FrameLayout frameLayout, QUICustomBubbleView qUICustomBubbleView) {
        x0();
        g(frameLayout);
        qUICustomBubbleView.setBubbleColor(this.f317530n);
        qUICustomBubbleView.setArrowPosition(this.f317522f);
        qUICustomBubbleView.setEnableShadow(this.f317532p);
        qUICustomBubbleView.setEnableBound(this.f317533q);
    }

    private void l(@NonNull View view) {
        int i3 = this.f317534r;
        if (i3 != 0 || this.f317536t != 0 || this.f317535s != 0 || this.f317537u != 0) {
            view.setPadding(i3, this.f317535s, this.f317536t, this.f317537u);
        }
    }

    private void m(@NonNull TextView textView) {
        textView.setText(x());
        textView.setTextSize(1, this.f317540x);
        textView.setTextColor(this.f317541y);
    }

    private void n(Context context) {
        QLog.d("QUIBubbleTip", 1, "[configureDefault] ");
        this.f317521e = null;
        this.f317522f = 1;
        this.f317523g = 1;
        this.f317524h = 0;
        this.f317525i = 0;
        this.f317528l = null;
        this.f317529m = null;
        this.M = null;
        this.O = 2;
        this.P = 3;
        this.f317527k = 3000L;
        this.Q.setBackgroundDrawable(new ColorDrawable(0));
        this.Q.setOutsideTouchable(true);
        this.Q.setFocusable(true);
        this.Q.setTouchable(true);
        if (context == null) {
            this.f317519c = 0;
        } else {
            this.f317519c = context.hashCode();
        }
        this.f317540x = 14.0f;
        this.f317541y = -1;
        this.f317542z = true;
        this.D = new c(this);
        this.E = new ViewTreeObserverOnGlobalLayoutListenerC9004a(this);
        this.G = new d(this);
    }

    private void q() {
        this.H = 2;
        try {
            if (t() != null && !h()) {
                if (this.S) {
                    t().getViewTreeObserver().addOnScrollChangedListener(this.D);
                    t().getViewTreeObserver().addOnGlobalLayoutListener(this.E);
                }
                H(this);
                G();
                if (this.M != null) {
                    t0();
                } else if (this.f317530n != 0) {
                    u0();
                } else {
                    w0();
                }
                C();
                if (this.f317527k > 0) {
                    ThreadManager.getUIHandler().postDelayed(this.F, this.f317527k);
                    return;
                }
                return;
            }
            QLog.e("QUIBubbleTip", 1, "anchor is null or not attach to window. ");
        } catch (Exception e16) {
            if (!QQUIAppSetting.isDebugVersion()) {
                QLog.e("QUIBubbleTip", 1, "show bubble error. ", e16);
                return;
            }
            throw e16;
        }
    }

    public static a r(Context context) {
        return new a(context);
    }

    @NonNull
    private static String s(a aVar) {
        if (aVar == null) {
            QLog.e("QUIBubbleTip", 1, "generateTipKey: tip is null");
            return "";
        }
        String valueOf = String.valueOf(aVar.f317519c);
        if (aVar.J()) {
            valueOf = valueOf + aVar.K;
        }
        QLog.d("QUIBubbleTip", 1, "generateTipKey: " + valueOf);
        return valueOf;
    }

    private View t() {
        WeakReference<View> weakReference = this.f317521e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void t0() {
        View t16 = t();
        if (t16 == null) {
            return;
        }
        int height = t16.getHeight();
        int width = t16.getWidth();
        QLog.d("QUIBubbleTip", 1, "anchor w | " + width + ", h | " + height);
        this.M.setOnClickListener(new l53.b(this));
        if (this.f317530n != 0) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(t16.getContext()).inflate(R.layout.hfw, (ViewGroup) null);
            QUICustomBubbleView qUICustomBubbleView = (QUICustomBubbleView) frameLayout.findViewById(R.id.f164690ti1);
            ViewGroup viewGroup = (ViewGroup) this.M.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.M);
            }
            qUICustomBubbleView.addView(this.M);
            k(frameLayout, qUICustomBubbleView);
            v0(frameLayout, t16, N(t16, height, width, frameLayout, qUICustomBubbleView));
            return;
        }
        this.Q.setContentView(this.M);
        this.Q.i(t16, this.O, this.P, this.f317524h, this.f317525i);
    }

    private int u() {
        int i3 = this.I;
        if (i3 == 1) {
            return R.id.svo;
        }
        if (i3 == 2) {
            return R.id.svt;
        }
        int i16 = this.J;
        if (i16 == 1) {
            return R.id.svs;
        }
        if (i16 == 2) {
            return R.id.svr;
        }
        return 0;
    }

    private void u0() {
        View t16 = t();
        if (t16 == null) {
            return;
        }
        int height = t16.getHeight();
        int width = t16.getWidth();
        QLog.d("QUIBubbleTip", 1, "anchor w | " + width + ", h | " + height);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(t16.getContext()).inflate(R.layout.hfv, (ViewGroup) null);
        QUICustomBubbleView qUICustomBubbleView = (QUICustomBubbleView) frameLayout.findViewById(R.id.f164690ti1);
        k(frameLayout, qUICustomBubbleView);
        TextView textView = (TextView) frameLayout.findViewById(R.id.f1063668i);
        View findViewById = frameLayout.findViewById(R.id.ywb);
        View findViewById2 = frameLayout.findViewById(R.id.t1i);
        frameLayout.setOnClickListener(new l53.b(this));
        m(textView);
        j(findViewById2);
        l(findViewById);
        this.Q.setContentView(frameLayout);
        v0(frameLayout, t16, N(t16, height, width, frameLayout, qUICustomBubbleView));
    }

    private void w0() {
        int i3;
        View t16 = t();
        if (t16 == null) {
            return;
        }
        int height = t16.getHeight();
        int width = t16.getWidth();
        QLog.d("QUIBubbleTip", 1, "anchor w | " + width + ", h | " + height);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(t16.getContext()).inflate(R.layout.hfx, (ViewGroup) null);
        x0();
        int u16 = u();
        if (u16 == 0) {
            return;
        }
        View findViewById = relativeLayout.findViewById(u16);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.f1063668i);
        View findViewById2 = relativeLayout.findViewById(R.id.ywb);
        View findViewById3 = relativeLayout.findViewById(R.id.t1i);
        if (findViewById != null && textView != null && findViewById2 != null) {
            Drawable drawable = this.f317528l;
            if (drawable != null) {
                V(findViewById2, drawable);
                ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                int i16 = this.f317538v;
                if (i16 != 0 && (i3 = this.f317539w) != 0 && layoutParams != null) {
                    layoutParams.width = i16;
                    layoutParams.height = i3;
                    findViewById2.setLayoutParams(layoutParams);
                }
            }
            Drawable drawable2 = this.f317529m;
            if (drawable2 != null) {
                V(findViewById, drawable2);
            }
            findViewById.setVisibility(0);
            relativeLayout.setOnClickListener(new l53.b(this));
            m(textView);
            j(findViewById3);
            l(findViewById2);
            this.Q.setContentView(relativeLayout);
            int[] f16 = this.Q.f(t16, this.I, this.J, this.f317524h, this.f317525i);
            int[] iArr = new int[2];
            e.a(t16, relativeLayout.getMeasuredWidth(), relativeLayout.getMeasuredHeight(), f16[0], f16[1], iArr);
            e(findViewById, ((width / 2) - iArr[0]) - (findViewById.getMeasuredWidth() / 2), (((-height) / 2) - iArr[1]) - (findViewById.getMeasuredWidth() / 2));
            v0(relativeLayout, t16, iArr);
            return;
        }
        QLog.e("QUIBubbleTip", 1, "showOriginInner | " + findViewById + textView + findViewById2);
    }

    private String x() {
        if (TextUtils.isEmpty(this.f317526j)) {
            QLog.d("QUIBubbleTip", 1, "text is empty");
            return "";
        }
        if (!this.f317542z) {
            QLog.d("QUIBubbleTip", 1, "text length limit not enable");
            return this.f317526j;
        }
        int i3 = this.f317517a;
        if (i3 == 0) {
            i3 = 10;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(this.f317526j, "\n");
        StringBuilder sb5 = new StringBuilder();
        if (stringTokenizer.countTokens() == 1) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() <= i3) {
                sb5.append(nextToken);
            } else {
                sb5.append(nextToken.substring(0, i3));
                sb5.append("\n");
                sb5.append(y0(nextToken.substring(i3), i3));
            }
        } else {
            if (stringTokenizer.hasMoreTokens()) {
                sb5.append(y0(stringTokenizer.nextToken(), i3));
            }
            if (stringTokenizer.hasMoreTokens()) {
                String nextToken2 = stringTokenizer.nextToken();
                sb5.append("\n");
                sb5.append(y0(nextToken2, i3));
            }
        }
        return sb5.toString();
    }

    private void x0() {
        boolean z16;
        int i3 = this.f317522f;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.J = 2;
                    }
                } else {
                    this.J = 1;
                }
            } else {
                this.I = 2;
            }
        } else {
            this.I = 1;
        }
        if (i3 != 0 && i3 != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        int i16 = this.f317523g;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    if (z16) {
                        this.J = 4;
                        return;
                    } else {
                        this.I = 4;
                        return;
                    }
                }
                return;
            }
            if (z16) {
                this.J = 3;
                return;
            } else {
                this.I = 3;
                return;
            }
        }
        if (z16) {
            this.J = 0;
        } else {
            this.I = 0;
        }
    }

    public void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        List<b> list = this.R;
        if (list == null) {
            QLog.e("QUIBubbleTip", 1, "callback list is null");
        } else {
            for (b bVar : list) {
                if (bVar != null) {
                    bVar.onClick(view);
                }
            }
            if (this.C) {
                o();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private String y0(String str, int i3) {
        if (str.length() <= i3) {
            return str;
        }
        return str.substring(0, i3);
    }

    private void z() {
        List<b> list = this.R;
        if (list == null) {
            QLog.e("QUIBubbleTip", 1, "callback list is null");
            return;
        }
        for (b bVar : list) {
            if (bVar != null) {
                bVar.onDismiss();
            }
        }
    }

    public void z0(boolean z16) {
        if (L() && !h()) {
            if (z16) {
                A();
            } else {
                B();
            }
        }
    }

    public boolean I() {
        if (w() == null) {
            return false;
        }
        if (this.f317520d.get() instanceof Activity) {
            return !((Activity) this.f317520d.get()).isDestroyed();
        }
        if (t() == null) {
            return false;
        }
        return !((Activity) t().getContext()).isDestroyed();
    }

    protected boolean J() {
        return !TextUtils.isEmpty(this.K);
    }

    public boolean L() {
        AnchorRelativePopupWindow anchorRelativePopupWindow = this.Q;
        if (anchorRelativePopupWindow == null) {
            QLog.e("QUIBubbleTip", 1, "mPopupWindow == null");
            return false;
        }
        return anchorRelativePopupWindow.isShowing();
    }

    @NonNull
    protected int[] N(@NonNull View view, int i3, int i16, @NonNull FrameLayout frameLayout, @NonNull QUICustomBubbleView qUICustomBubbleView) {
        this.Q.setContentView(frameLayout);
        int[] f16 = this.Q.f(view, this.I, this.J, this.f317524h, this.f317525i);
        int[] iArr = new int[2];
        e.a(view, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight(), f16[0], f16[1], iArr);
        int g16 = (((i16 / 2) - iArr[0]) - (qUICustomBubbleView.g() / 2)) - frameLayout.getPaddingLeft();
        int g17 = ((((-i3) / 2) - iArr[1]) - (qUICustomBubbleView.g() / 2)) - frameLayout.getPaddingTop();
        int i17 = this.f317522f;
        if (i17 != 0 && i17 != 1) {
            qUICustomBubbleView.setArrowOffsetY(g17);
        } else {
            qUICustomBubbleView.setArrowOffsetX(g16);
        }
        return iArr;
    }

    public a R(int i3) {
        this.f317523g = i3;
        return this;
    }

    public a S(View view) {
        this.f317521e = new WeakReference<>(view);
        return this;
    }

    public a T(Drawable drawable) {
        this.f317529m = drawable;
        return this;
    }

    public a U(Drawable[] drawableArr) {
        if (this.B != null) {
            return this;
        }
        if (drawableArr != null && drawableArr.length != 0) {
            if (drawableArr.length > 3) {
                return this;
            }
            this.A = drawableArr;
            return this;
        }
        this.A = null;
        return this;
    }

    public a W(int i3) {
        this.f317530n = i3;
        return this;
    }

    public a X(Drawable drawable) {
        this.f317528l = drawable;
        return this;
    }

    public a Y(int i3, int i16) {
        this.f317538v = ViewUtils.dip2px(i3);
        this.f317539w = ViewUtils.dip2px(i16);
        return this;
    }

    public a Z(int i3, int i16) {
        this.O = i3;
        this.P = i16;
        return this;
    }

    public a a0(@NotNull View view) {
        this.M = view;
        return this;
    }

    public a b0(long j3) {
        this.f317527k = j3;
        return this;
    }

    public a c0(boolean z16) {
        this.f317533q = z16;
        return this;
    }

    public a d0(boolean z16) {
        this.C = z16;
        return this;
    }

    public a e0(boolean z16) {
        this.f317532p = z16;
        return this;
    }

    public a f(b bVar) {
        if (this.R == null) {
            QLog.e("QUIBubbleTip", 1, "callback list is null");
            this.R = new ArrayList();
        }
        this.R.add(bVar);
        return this;
    }

    public a f0(boolean z16) {
        this.f317542z = z16;
        return this;
    }

    public a g0(boolean z16) {
        this.Q.setFocusable(z16);
        return this;
    }

    public a h0(String str) {
        this.K = str;
        return this;
    }

    public a i0(float f16, float f17) {
        this.f317524h = ViewUtils.dip2px(f16);
        this.f317525i = ViewUtils.dip2px(f17);
        return this;
    }

    public a j0(float f16, float f17, float f18, float f19) {
        this.f317534r = ViewUtils.dip2px(f16);
        this.f317535s = ViewUtils.dip2px(f17);
        this.f317536t = ViewUtils.dip2px(f18);
        this.f317537u = ViewUtils.dip2px(f19);
        return this;
    }

    public a k0(int i3) {
        this.f317522f = i3;
        return this;
    }

    public a l0(int i3) {
        this.L = i3;
        return this;
    }

    public a m0(int i3) {
        this.f317531o = i3;
        return this;
    }

    public a n0(int i3) {
        this.f317517a = i3;
        return this;
    }

    public void o() {
        Q();
        if (this.Q == null) {
            QLog.e("QUIBubbleTip", 1, "mPopupWindow == null");
            i();
            return;
        }
        QLog.d("QUIBubbleTip", 1, "auto dismiss after " + this.f317527k + ", hashcode: " + this.f317519c);
        ThreadManager.getUIHandler().removeCallbacks(this.F);
        this.Q.dismiss();
        i();
    }

    public a o0(String str) {
        if (str == null) {
            str = "";
        }
        this.f317526j = str;
        return this;
    }

    public a p(boolean z16) {
        this.S = z16;
        return this;
    }

    public a p0(@ColorInt int i3) {
        this.f317541y = i3;
        return this;
    }

    public a q0(float f16) {
        this.f317540x = f16;
        return this;
    }

    public a r0(boolean z16) {
        this.Q.setOutsideTouchable(z16);
        return this;
    }

    public void s0() {
        if (F(this)) {
            QLog.d("QUIBubbleTip", 1, "show | has showing tip. hashCode: " + this.f317519c);
            return;
        }
        P(this);
        View t16 = t();
        if (t16 == null) {
            QLog.e("QUIBubbleTip", 1, "show | anchor = null");
            return;
        }
        if (K(t16)) {
            QLog.d("QUIBubbleTip", 1, "anchor seems not inflated. w | " + t16.getWidth() + ", h | " + t16.getHeight());
            t16.getViewTreeObserver().addOnPreDrawListener(this.G);
            this.H = 1;
            U.add(this.f317518b);
            return;
        }
        q();
    }

    public View v() {
        AnchorRelativePopupWindow anchorRelativePopupWindow = this.Q;
        if (anchorRelativePopupWindow == null) {
            return null;
        }
        return anchorRelativePopupWindow.getContentView();
    }

    protected void v0(View view, View view2, int[] iArr) {
        if (!I()) {
            QLog.d("QUIBubbleTip", 1, "isActivityAlive: false");
        } else {
            this.Q.setContentView(view);
            this.Q.h(view2, iArr[0], iArr[1]);
        }
    }

    protected Context w() {
        WeakReference<Context> weakReference = this.f317520d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
