package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.lo.m;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public int C;
    public int D;
    public OptionMenuStyle E;
    public View H;
    public ViewGroup.LayoutParams I;
    public int K;
    public int L;

    /* renamed from: a, reason: collision with root package name */
    public ActionBar f152586a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152587b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f152588c;

    /* renamed from: d, reason: collision with root package name */
    public View f152589d;

    /* renamed from: e, reason: collision with root package name */
    public View f152590e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f152591f;

    /* renamed from: g, reason: collision with root package name */
    public Context f152592g;

    /* renamed from: i, reason: collision with root package name */
    public WeImageView f152594i;

    /* renamed from: j, reason: collision with root package name */
    public WeImageView f152595j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f152596k;

    /* renamed from: l, reason: collision with root package name */
    public MenuItem f152597l;

    /* renamed from: m, reason: collision with root package name */
    public MenuItem f152598m;

    /* renamed from: h, reason: collision with root package name */
    public int f152593h = 0;
    public h F = h.BACK;
    public boolean G = false;
    public LinkedList M = new LinkedList();
    public int J;
    public int N = this.J;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum OptionMenuStyle {
        CUSTOM,
        TEXT,
        GREEN_TEXT,
        ADD,
        MORE,
        SEARCH,
        NONE
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements MenuItem.OnMenuItemClickListener {
        public a() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            BaseActivity.this.finish();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem.OnMenuItemClickListener f152600a;

        public b(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f152600a = onMenuItemClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f152600a.onMenuItemClick(new com.tencent.luggage.wxa.mo.i(BaseActivity.this.f152592g, 0, 0));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f152602a;

        public c(i iVar) {
            this.f152602a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseActivity baseActivity = BaseActivity.this;
            baseActivity.a(baseActivity.f152597l, this.f152602a);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f152604a;

        public d(i iVar) {
            this.f152604a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseActivity baseActivity = BaseActivity.this;
            baseActivity.a(baseActivity.f152598m, this.f152604a);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f152606a;

        public e(i iVar) {
            this.f152606a = iVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean a16 = BaseActivity.this.a(view, this.f152606a);
            EventCollector.getInstance().onViewLongClicked(view);
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseActivity.this.setActionbarHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseActivity.this.supportInvalidateOptionsMenu();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum h {
        CUSTOM,
        BACK,
        CLOSE,
        NONE
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class i {

        /* renamed from: b, reason: collision with root package name */
        public int f152616b;

        /* renamed from: e, reason: collision with root package name */
        public String f152619e;

        /* renamed from: f, reason: collision with root package name */
        public View f152620f;

        /* renamed from: g, reason: collision with root package name */
        public View f152621g;

        /* renamed from: h, reason: collision with root package name */
        public View f152622h;

        /* renamed from: j, reason: collision with root package name */
        public MenuItem.OnMenuItemClickListener f152624j;

        /* renamed from: k, reason: collision with root package name */
        public View.OnLongClickListener f152625k;

        /* renamed from: a, reason: collision with root package name */
        public int f152615a = -1;

        /* renamed from: c, reason: collision with root package name */
        public boolean f152617c = true;

        /* renamed from: d, reason: collision with root package name */
        public boolean f152618d = true;

        /* renamed from: i, reason: collision with root package name */
        public OptionMenuStyle f152623i = OptionMenuStyle.CUSTOM;
    }

    public void addIconOptionMenu(int i3, OptionMenuStyle optionMenuStyle, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        addOptionMenuImpl(i3, 0, "", onMenuItemClickListener, null, optionMenuStyle);
    }

    public void addOptionMenuImpl(int i3, int i16, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener, OptionMenuStyle optionMenuStyle) {
        i iVar = new i();
        iVar.f152615a = i3;
        iVar.f152616b = i16;
        iVar.f152619e = str;
        iVar.f152624j = onMenuItemClickListener;
        iVar.f152625k = onLongClickListener;
        iVar.f152623i = optionMenuStyle;
        if (i16 == R.drawable.ofp && (str == null || str.length() <= 0)) {
            iVar.f152619e = getString(R.string.yjr);
        }
        a(iVar.f152615a);
        this.M.add(iVar);
        new Handler().postDelayed(new g(), 200L);
    }

    public void addTextOptionMenu(int i3, String str, OptionMenuStyle optionMenuStyle, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        addOptionMenuImpl(i3, 0, str, onMenuItemClickListener, onLongClickListener, optionMenuStyle);
    }

    public final void d() {
        int i3;
        View decorView = getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (this.G) {
            i3 = systemUiVisibility & (-8193);
        } else {
            i3 = systemUiVisibility | 8192;
        }
        decorView.setSystemUiVisibility(i3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public final void e() {
        if (this.G) {
            this.f152591f.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        } else {
            this.f152591f.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void enableOptionMenu(int i3, boolean z16) {
        Iterator it = this.M.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar.f152615a == i3 && iVar.f152617c != z16) {
                iVar.f152617c = z16;
            }
        }
        invalidateOptionsMenu();
    }

    public void expendActionbar() {
        int i3 = this.N;
        int i16 = this.J;
        if (i3 >= i16) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(i3, i16).setDuration(200L);
        duration.addUpdateListener(new f());
        duration.start();
    }

    public final void f() {
        int i3;
        OptionMenuStyle optionMenuStyle = this.E;
        if (optionMenuStyle == OptionMenuStyle.TEXT) {
            TextView textView = this.f152596k;
            if (textView == null) {
                return;
            }
            if (this.G) {
                textView.setTextColor(this.f152592g.getResources().getColorStateList(R.color.czp));
                return;
            } else {
                textView.setTextColor(this.f152592g.getResources().getColorStateList(R.color.b9g));
                return;
            }
        }
        if (optionMenuStyle == OptionMenuStyle.ADD) {
            this.D = R.drawable.ofl;
        } else if (optionMenuStyle == OptionMenuStyle.MORE) {
            this.D = R.drawable.ofp;
        } else if (optionMenuStyle == OptionMenuStyle.SEARCH) {
            this.D = R.drawable.ofq;
        }
        WeImageView weImageView = this.f152594i;
        if (weImageView != null && (i3 = this.D) != 0) {
            weImageView.setImageResource(i3);
            if (this.G) {
                this.f152594i.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            } else {
                this.f152594i.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    public final void g() {
        WeImageView weImageView = this.f152595j;
        if (weImageView == null) {
            return;
        }
        if (this.G) {
            weImageView.setImageResource(R.drawable.ofu);
        } else {
            weImageView.setImageResource(R.drawable.ofq);
        }
    }

    public abstract int getLayoutId();

    public final void h() {
        TextView textView = this.f152588c;
        if (textView == null) {
            return;
        }
        if (this.G) {
            textView.setTextColor(this.f152592g.getResources().getColor(R.color.b3p));
        } else {
            textView.setTextColor(this.f152592g.getResources().getColor(R.color.b3o));
        }
    }

    public final void i() {
        TextView textView = this.f152587b;
        if (textView == null) {
            return;
        }
        if (this.G) {
            textView.setTextColor(this.f152592g.getResources().getColor(R.color.b3t));
        } else {
            textView.setTextColor(this.f152592g.getResources().getColor(R.color.b3s));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int i3 = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", -16777216);
        if (i3 != -16777216) {
            if (i3 == -16711936) {
                this.L = R.style.ajs;
            }
        } else {
            this.L = R.style.ajr;
        }
        setTheme(i3);
        setContentView(getLayoutId());
        this.f152592g = this;
        this.f152586a = getSupportActionBar();
        a();
        setupStatuBar(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (a(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void removeAllOptionMenu() {
        if (this.M.isEmpty()) {
            return;
        }
        this.M.clear();
        supportInvalidateOptionsMenu();
    }

    public void setActionBarColor(int i3) {
        if (this.f152586a == null) {
            return;
        }
        this.f152593h = i3;
        this.G = m.a(i3);
        this.f152586a.setBackgroundDrawable(new ColorDrawable(this.f152593h));
        getWindow().setStatusBarColor(this.f152593h);
        d();
        e();
        f();
        i();
        h();
        g();
    }

    public void setActionbarHeight(int i3) {
        ViewGroup.LayoutParams layoutParams;
        int i16 = this.J;
        if (i3 > i16) {
            i3 = i16;
        }
        int i17 = this.K;
        if (i3 < i17) {
            i3 = i17;
        }
        this.N = i3;
        View findViewById = getWindow().getDecorView().findViewById(R.id.f163913s91);
        this.H = findViewById;
        if (findViewById != null) {
            this.I = findViewById.getLayoutParams();
        }
        View view = this.H;
        if (view != null && (layoutParams = this.I) != null) {
            layoutParams.height = view.getPaddingTop() + i3 + this.H.getPaddingBottom();
            this.H.setLayoutParams(this.I);
        }
        int c16 = o.c(this.f152592g, R.dimen.bp_);
        int c17 = o.c(this.f152592g, R.dimen.bla);
        int a16 = o.a(this.f152592g, 14);
        int i18 = this.K;
        float f16 = (i3 - i18) / (this.J - i18);
        float f17 = c16 + ((c17 - c16) * f16);
        setIconAlpha(f16);
        int a17 = (int) ((a16 - o.a(this.f152592g, 40)) * (1.0f - f16));
        TextView textView = this.f152587b;
        if (textView != null) {
            textView.setTextSize(0, f17);
            View view2 = this.f152589d;
            if (view2 != null) {
                view2.setTranslationX(a17);
            }
        }
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        setBackBtn(onMenuItemClickListener, 0, h.BACK);
    }

    public void setBackBtnVisible(boolean z16) {
        ImageView imageView = this.f152591f;
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void setIconAlpha(float f16) {
        View view = this.f152590e;
        if (view != null) {
            view.setAlpha(f16);
            if (f16 == 0.0f) {
                this.f152590e.setEnabled(false);
            } else {
                this.f152590e.setEnabled(true);
            }
        }
        WeImageView weImageView = this.f152594i;
        if (weImageView != null) {
            weImageView.setAlpha(f16);
            if (f16 == 0.0f) {
                this.f152594i.setEnabled(false);
            } else {
                this.f152594i.setEnabled(true);
            }
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        TextView textView;
        if (this.f152586a != null && (textView = this.f152588c) != null) {
            if (charSequence == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            this.f152588c.setText(charSequence.toString());
            h();
        }
    }

    @Override // android.app.Activity, com.tencent.luggage.wxa.g6.t
    public void setTitle(CharSequence charSequence) {
        TextView textView;
        if (this.f152586a != null && (textView = this.f152587b) != null) {
            textView.setText(charSequence.toString());
            i();
        }
    }

    public void setupStatuBar(Activity activity) {
        if (this.f152593h == 0) {
            this.f152593h = o.b(this.f152592g, R.attr.f50485);
        }
        Window window = activity.getWindow();
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(this.f152593h);
        d();
    }

    public void showVKB(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus;
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null || (currentFocus = activity.getCurrentFocus()) == null || currentFocus.getWindowToken() == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 2);
    }

    public void addIconOptionMenu(int i3, int i16, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        addOptionMenuImpl(i3, i16, "", onMenuItemClickListener, null, OptionMenuStyle.CUSTOM);
    }

    public void setBackBtn(h hVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        setBackBtn(onMenuItemClickListener, 0, hVar);
    }

    public void setBackBtn(int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        setBackBtn(onMenuItemClickListener, i3, h.CUSTOM);
    }

    public final void a() {
        ActionBar actionBar = this.f152586a;
        if (actionBar != null) {
            actionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.f152586a.setDisplayShowTitleEnabled(false);
            this.f152586a.setDisplayHomeAsUpEnabled(false);
            this.f152586a.setDisplayShowHomeEnabled(false);
            this.f152586a.setDisplayShowCustomEnabled(true);
            this.f152586a.setCustomView(LayoutInflater.from(this).inflate(R.layout.dqi, (ViewGroup) null));
            if (this.f152593h == 0) {
                this.f152593h = o.b(this.f152592g, R.attr.f50485);
            }
            this.G = m.a(this.f152593h);
            this.f152586a.setBackgroundDrawable(new ColorDrawable(this.f152593h));
            this.f152587b = (TextView) findViewById(android.R.id.text1);
            this.f152588c = (TextView) findViewById(android.R.id.text2);
            this.f152589d = findViewById(R.id.f98705nt);
            this.f152590e = findViewById(R.id.s_y);
            this.f152591f = (ImageView) findViewById(R.id.s_z);
            setBackBtn(new a());
        }
        this.J = o.c(this.f152592g, R.dimen.bfj);
        this.K = o.c(this.f152592g, R.dimen.f158114bp0);
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i3, h hVar) {
        ActionBar actionBar = this.f152586a;
        if (actionBar == null) {
            return;
        }
        if (onMenuItemClickListener == null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        } else {
            actionBar.setDisplayHomeAsUpEnabled(false);
            View view = this.f152590e;
            if (view != null) {
                view.setVisibility(0);
                this.f152590e.setOnClickListener(new b(onMenuItemClickListener));
            }
        }
        this.F = hVar;
        if (i3 != 0) {
            this.C = i3;
        }
        if (hVar == h.NONE) {
            this.C = 0;
        }
        if (hVar == h.BACK) {
            this.C = R.drawable.ofm;
        } else if (hVar == h.CLOSE) {
            this.C = R.drawable.ofo;
        }
        if (this.f152591f != null && this.C != 0) {
            setBackBtnVisible(true);
            this.f152591f.setImageResource(this.C);
        }
        e();
    }

    public final boolean a(Menu menu) {
        n.a("BaseActivity", "on create option menu, menuCache size:%d", Integer.valueOf(this.M.size()));
        if (this.f152586a == null || this.M.size() == 0) {
            n.e("BaseActivity", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.M.size()));
            return false;
        }
        Iterator it = this.M.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            int i3 = iVar.f152615a;
            if (i3 != 16908332) {
                if (iVar.f152623i == OptionMenuStyle.SEARCH) {
                    this.f152597l = menu.add(0, i3, 0, iVar.f152619e);
                    c cVar = new c(iVar);
                    if (iVar.f152622h == null) {
                        iVar.f152622h = View.inflate(this.f152592g, R.layout.dq8, null);
                    }
                    WeImageView weImageView = (WeImageView) iVar.f152622h.findViewById(R.id.s9o);
                    this.f152595j = weImageView;
                    weImageView.setVisibility(0);
                    g();
                    this.f152595j.setOnClickListener(cVar);
                    this.f152595j.setEnabled(iVar.f152617c);
                    MenuItemCompat.setActionView(this.f152597l, iVar.f152622h);
                    this.f152597l.setEnabled(iVar.f152617c);
                    this.f152597l.setVisible(iVar.f152618d);
                } else {
                    this.f152598m = menu.add(0, i3, 0, iVar.f152619e);
                    d dVar = new d(iVar);
                    e eVar = new e(iVar);
                    OptionMenuStyle optionMenuStyle = iVar.f152623i;
                    this.E = optionMenuStyle;
                    OptionMenuStyle optionMenuStyle2 = OptionMenuStyle.GREEN_TEXT;
                    if (optionMenuStyle != optionMenuStyle2 && optionMenuStyle != OptionMenuStyle.TEXT) {
                        int i16 = iVar.f152616b;
                        if (i16 != 0) {
                            this.D = i16;
                        }
                        if (optionMenuStyle == OptionMenuStyle.NONE) {
                            this.D = 0;
                        }
                        if (iVar.f152621g == null) {
                            iVar.f152621g = View.inflate(this.f152592g, R.layout.dq8, null);
                        }
                        this.f152594i = (WeImageView) iVar.f152621g.findViewById(R.id.s9o);
                        f();
                        if (this.D != 0) {
                            this.f152594i.setVisibility(0);
                            this.f152594i.setOnClickListener(dVar);
                            this.f152594i.setOnLongClickListener(eVar);
                            this.f152594i.setEnabled(iVar.f152617c);
                            MenuItemCompat.setActionView(this.f152598m, iVar.f152621g);
                        }
                    } else {
                        if (iVar.f152620f == null) {
                            iVar.f152620f = View.inflate(this.f152592g, R.layout.dq8, null);
                        }
                        TextView textView = (TextView) iVar.f152620f.findViewById(R.id.s9s);
                        this.f152596k = textView;
                        textView.setVisibility(0);
                        this.f152596k.setText(iVar.f152619e);
                        if (iVar.f152623i == optionMenuStyle2) {
                            this.f152596k.setTextColor(this.f152592g.getResources().getColorStateList(R.color.b_5));
                        } else {
                            f();
                        }
                        this.f152596k.setOnClickListener(dVar);
                        this.f152596k.setOnLongClickListener(eVar);
                        this.f152596k.setEnabled(iVar.f152617c);
                        MenuItemCompat.setActionView(this.f152598m, iVar.f152620f);
                    }
                    this.f152598m.setEnabled(iVar.f152617c);
                    this.f152598m.setVisible(iVar.f152618d);
                    MenuItem menuItem = this.f152598m;
                    if (menuItem != null) {
                        MenuItemCompat.setShowAsAction(menuItem, 2);
                    }
                }
            }
        }
        MenuItem menuItem2 = this.f152597l;
        if (menuItem2 != null) {
            MenuItemCompat.setShowAsAction(menuItem2, 2);
        }
        return true;
    }

    public final void a(MenuItem menuItem, i iVar) {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = iVar.f152624j;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onMenuItemClick(menuItem);
        }
    }

    public final boolean a(View view, i iVar) {
        View.OnLongClickListener onLongClickListener = iVar.f152625k;
        if (onLongClickListener != null) {
            return onLongClickListener.onLongClick(view);
        }
        return false;
    }

    public final boolean a(int i3) {
        for (int i16 = 0; i16 < this.M.size(); i16++) {
            if (((i) this.M.get(i16)).f152615a == i3) {
                n.a("BaseActivity", "match menu, id \uff1a" + i3 + ", remove it", new Object[0]);
                this.M.remove(i16);
                return true;
            }
        }
        return false;
    }
}
