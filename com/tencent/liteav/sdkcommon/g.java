package com.tencent.liteav.sdkcommon;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    final Context f119120c;

    /* renamed from: e, reason: collision with root package name */
    final ArrayAdapter<String> f119122e;

    /* renamed from: f, reason: collision with root package name */
    WindowManager f119123f;

    /* renamed from: g, reason: collision with root package name */
    View f119124g;

    /* renamed from: h, reason: collision with root package name */
    TextView f119125h;

    /* renamed from: i, reason: collision with root package name */
    TextView f119126i;

    /* renamed from: j, reason: collision with root package name */
    Spinner f119127j;

    /* renamed from: k, reason: collision with root package name */
    ScrollView f119128k;

    /* renamed from: l, reason: collision with root package name */
    String f119129l;

    /* renamed from: o, reason: collision with root package name */
    final a f119132o;

    /* renamed from: a, reason: collision with root package name */
    final DisplayMetrics f119118a = new DisplayMetrics();

    /* renamed from: b, reason: collision with root package name */
    final WindowManager.LayoutParams f119119b = new WindowManager.LayoutParams();

    /* renamed from: p, reason: collision with root package name */
    private final int f119133p = SupportMenu.CATEGORY_MASK;

    /* renamed from: q, reason: collision with root package name */
    private boolean f119134q = false;

    /* renamed from: m, reason: collision with root package name */
    boolean f119130m = false;

    /* renamed from: n, reason: collision with root package name */
    int f119131n = 1920;

    /* renamed from: d, reason: collision with root package name */
    final Handler f119121d = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        private int f119136b;

        /* renamed from: c, reason: collision with root package name */
        private int f119137c;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int i3 = rawX - this.f119136b;
                    int i16 = rawY - this.f119137c;
                    WindowManager.LayoutParams layoutParams = g.this.f119119b;
                    int i17 = layoutParams.x + i3;
                    layoutParams.x = i17;
                    layoutParams.y += i16;
                    this.f119136b = rawX;
                    this.f119137c = rawY;
                    layoutParams.x = Math.max(i17, 0);
                    WindowManager.LayoutParams layoutParams2 = g.this.f119119b;
                    layoutParams2.y = Math.max(layoutParams2.y, 0);
                    g gVar = g.this;
                    WindowManager.LayoutParams layoutParams3 = gVar.f119119b;
                    int i18 = layoutParams3.x;
                    DisplayMetrics displayMetrics = gVar.f119118a;
                    int i19 = displayMetrics.widthPixels;
                    if (i18 + i19 > i19) {
                        layoutParams3.width = i19 - i18;
                    } else {
                        layoutParams3.width = i19;
                    }
                    int i26 = gVar.f119131n;
                    layoutParams3.height = i26;
                    if (gVar.f119130m) {
                        layoutParams3.height = i26 / 2;
                    }
                    int i27 = layoutParams3.y;
                    int i28 = layoutParams3.height + i27;
                    int i29 = displayMetrics.heightPixels;
                    if (i28 > i29) {
                        layoutParams3.height = i29 - i27;
                    }
                    ViewGroup.LayoutParams layoutParams4 = gVar.f119128k.getLayoutParams();
                    layoutParams4.height = g.this.b();
                    g.this.f119128k.setLayoutParams(layoutParams4);
                    g gVar2 = g.this;
                    gVar2.f119123f.updateViewLayout(view, gVar2.f119119b);
                }
            } else {
                this.f119136b = (int) motionEvent.getRawX();
                this.f119137c = (int) motionEvent.getRawY();
            }
            view.performClick();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(g gVar, byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (view == null) {
                return;
            }
            ((TextView) view).setTextColor(SupportMenu.CATEGORY_MASK);
            g gVar = g.this;
            gVar.f119129l = gVar.f119122e.getItem(i3);
            g.this.f119132o.a(i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(g gVar, byte b16) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public g(Context context, a aVar) {
        this.f119120c = context;
        this.f119132o = aVar;
        this.f119122e = new ArrayAdapter<>(context, R.layout.simple_spinner_item);
    }

    public final void a(boolean z16) {
        if (z16 == this.f119134q) {
            return;
        }
        if (z16) {
            this.f119123f.addView(this.f119124g, this.f119119b);
        } else {
            this.f119123f.removeView(this.f119124g);
        }
        this.f119134q = z16;
    }

    public final void b(String str) {
        TextView textView = this.f119125h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return Math.max((this.f119119b.height - a(230)) - a(20), 0);
    }

    public final void a(String str) {
        TextView textView = this.f119126i;
        if (textView != null) {
            textView.setText(str);
        }
        this.f119121d.post(h.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        TextView textView;
        Spinner spinner = this.f119127j;
        if (spinner == null || (textView = (TextView) spinner.getChildAt(spinner.getSelectedItemPosition())) == null) {
            return;
        }
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(int i3) {
        return (int) ((i3 * this.f119120c.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
