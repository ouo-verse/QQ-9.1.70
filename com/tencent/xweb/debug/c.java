package com.tencent.xweb.debug;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.luggage.wxa.ar.e0;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.r0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.qq.m;
import com.tencent.luggage.wxa.qq.n;
import com.tencent.luggage.wxa.qq.o;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebView;
import com.tencent.xweb.debug.b;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c implements com.tencent.xweb.debug.b {

    /* renamed from: a, reason: collision with root package name */
    public Context f385107a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f385108b;

    /* renamed from: c, reason: collision with root package name */
    public final WebView f385109c;

    /* renamed from: d, reason: collision with root package name */
    public b.a f385110d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f385111e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f385112f;

    /* renamed from: g, reason: collision with root package name */
    public View f385113g;

    /* renamed from: h, reason: collision with root package name */
    public ViewPager f385114h;

    /* renamed from: i, reason: collision with root package name */
    public TabLayout f385115i;

    /* renamed from: j, reason: collision with root package name */
    public Button f385116j;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f385118a;

        public b(Context context) {
            this.f385118a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            e0.b(this.f385118a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.xweb.debug.c$c, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public class C10046c implements ValueCallback {
        public C10046c() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x0.d("XWebDebugView", "evaluate show fps js done");
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.f385113g.setVisibility(8);
            if (c.this.f385110d != null) {
                c.this.f385110d.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class f implements View.OnLongClickListener {
        public f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            c.this.e();
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class g implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f385126a;

        public g(String str) {
            this.f385126a = str;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            p0.a(c.this.getContext(), "xweb_debug_info", this.f385126a);
            Toast.makeText(c.this.getContext(), "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f", 0).show();
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    public c(Context context, ViewGroup viewGroup) {
        this.f385111e = null;
        this.f385112f = null;
        this.f385113g = null;
        this.f385114h = null;
        this.f385115i = null;
        this.f385116j = null;
        this.f385107a = context;
        this.f385108b = viewGroup;
        this.f385109c = null;
        h();
    }

    @Override // com.tencent.xweb.debug.b
    public WebView d() {
        return this.f385109c;
    }

    @Override // com.tencent.xweb.debug.b
    public void e() {
        View view = this.f385113g;
        if (view != null) {
            view.setVisibility(0);
            return;
        }
        boolean i3 = i();
        x0.d("XWebDebugView", "refreshDebugView, context:" + this.f385107a + ", isAppCompatActivity:" + i3 + ", appCompatActivity:" + g());
        if (!i3) {
            Toast.makeText(this.f385107a, "\u5f53\u524d\u754c\u9762\u4e0d\u652f\u6301\u663e\u793a\u8c03\u8bd5\u7ec4\u4ef6", 0).show();
            return;
        }
        View inflate = View.inflate(this.f385107a, R.layout.i8l, null);
        this.f385113g = inflate;
        this.f385108b.addView(inflate);
        this.f385114h = (ViewPager) this.f385113g.findViewById(R.id.kwk);
        AppCompatActivity g16 = g();
        Objects.requireNonNull(g16);
        this.f385114h.setAdapter(new com.tencent.luggage.wxa.qq.d(g16.getSupportFragmentManager(), this));
        TabLayout tabLayout = (TabLayout) this.f385113g.findViewById(R.id.j_o);
        this.f385115i = tabLayout;
        tabLayout.setupWithViewPager(this.f385114h);
        ((Button) this.f385113g.findViewById(R.id.tj6)).setOnClickListener(new e());
    }

    @Override // com.tencent.xweb.debug.b
    public void f() {
        if (!WebDebugCfg.getInst().getEnableShowFps()) {
            x0.d("XWebDebugView", "refreshFpsView, show fps is disabled");
        } else if (this.f385109c != null) {
            this.f385109c.evaluateJavascript(p0.a(getContext(), "xweb_show_fps.js"), new C10046c());
        }
    }

    public AppCompatActivity g() {
        if (!i()) {
            return null;
        }
        Context context = this.f385107a;
        if (context instanceof MutableContextWrapper) {
            return (AppCompatActivity) ((MutableContextWrapper) context).getBaseContext();
        }
        return (AppCompatActivity) context;
    }

    @Override // com.tencent.xweb.debug.b
    public Context getContext() {
        WebView webView = this.f385109c;
        if (webView != null) {
            this.f385107a = webView.getContext();
            AppCompatActivity g16 = g();
            if (g16 != null) {
                this.f385107a = g16;
                return g16;
            }
        }
        return this.f385107a;
    }

    public final void h() {
        if (this.f385109c != null) {
            c();
            f();
            a();
            return;
        }
        e();
    }

    public boolean i() {
        Context context = this.f385107a;
        if (context instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) context).getBaseContext() instanceof AppCompatActivity;
        }
        return context instanceof AppCompatActivity;
    }

    @Override // com.tencent.xweb.debug.b
    public void a(b.a aVar) {
        this.f385110d = aVar;
    }

    @Override // com.tencent.xweb.debug.b
    public boolean b(String str) {
        return r0.b(str);
    }

    @Override // com.tencent.xweb.debug.b
    public void c() {
        if (!WebDebugCfg.getInst().getEnableShowVersion()) {
            x0.d("XWebDebugView", "refreshVersionView, show version is disabled");
            TextView textView = this.f385111e;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f385109c == null) {
            TextView textView2 = this.f385111e;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = this.f385111e;
        if (textView3 != null) {
            textView3.setVisibility(0);
            return;
        }
        this.f385111e = new TextView(getContext());
        this.f385111e.setText(n.b(d()));
        this.f385111e.setOnLongClickListener(new f());
        this.f385108b.addView(this.f385111e);
    }

    @Override // com.tencent.xweb.debug.b
    public boolean a(String str) {
        x0.d("XWebDebugView", "onInterceptTestUrl, url:" + str);
        Bundle bundle = new Bundle();
        bundle.putInt("source", com.tencent.luggage.wxa.qq.b.DEBUG_URL.ordinal());
        bundle.putString("command", str);
        com.tencent.luggage.wxa.qq.a a16 = r0.a(bundle, this);
        return a16.f138959a && a(getContext(), a16);
    }

    @Override // com.tencent.xweb.debug.b
    public void b() {
        TextView textView = this.f385112f;
        if (textView != null) {
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = new TextView(getContext());
        this.f385112f = textView2;
        textView2.setTextColor(-16777216);
        this.f385112f.setBackgroundColor(-1);
        String str = n.b(d()) + "\n" + n.a(d()) + "\n" + m.b();
        this.f385112f.setText(str);
        this.f385112f.setOnLongClickListener(new g(str));
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.addView(this.f385112f);
        this.f385108b.addView(scrollView);
    }

    @Override // com.tencent.xweb.debug.b
    public boolean a(Context context, com.tencent.luggage.wxa.qq.a aVar) {
        if (aVar.f138959a) {
            if (aVar.f138960b) {
                new AlertDialog.Builder(getContext()).setTitle("\u6267\u884c\u6210\u529f").setMessage("\u90e8\u5206\u914d\u7f6e\u9700\u91cd\u542f\u751f\u6548\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u7acb\u5373\u91cd\u542f?").setPositiveButton("\u786e\u5b9a", new b(context)).setNegativeButton("\u53d6\u6d88", new a()).show();
                return true;
            }
            Toast.makeText(context, "\u6267\u884c\u6210\u529f", 0).show();
            return true;
        }
        Toast.makeText(context, "\u6267\u884c\u5931\u8d25", 0).show();
        return false;
    }

    public c(WebView webView) {
        this.f385111e = null;
        this.f385112f = null;
        this.f385113g = null;
        this.f385114h = null;
        this.f385115i = null;
        this.f385116j = null;
        this.f385109c = webView;
        this.f385107a = webView.getContext();
        this.f385108b = webView.getTopView();
        h();
    }

    @Override // com.tencent.xweb.debug.b
    public void a() {
        if (!WebDebugCfg.getInst().getEnableShowSavePage()) {
            x0.d("XWebDebugView", "refreshSavePageView, show save page is disabled");
            Button button = this.f385116j;
            if (button != null) {
                button.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f385109c == null) {
            Button button2 = this.f385116j;
            if (button2 != null) {
                button2.setVisibility(8);
                return;
            }
            return;
        }
        Button button3 = this.f385116j;
        if (button3 != null) {
            button3.setVisibility(0);
            return;
        }
        Button button4 = new Button(getContext());
        this.f385116j = button4;
        button4.setText("\u4fdd\u5b58\u9875\u9762");
        this.f385116j.setOnClickListener(new d());
        this.f385108b.addView(this.f385116j, new ViewGroup.LayoutParams(-2, -2));
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class d implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                o.a(c.this.getContext(), c.this.f385109c);
            }
        }

        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.xweb.debug.c$d$a, android.content.DialogInterface$OnClickListener, android.view.View] */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(c.this.getContext()).setTitle("\u4fdd\u5b58\u9875\u9762").setMessage("\u786e\u5b9a\u4fdd\u5b58\u9875\u9762?").setPositiveButton("\u786e\u5b9a", new b());
            ?? aVar = new a();
            positiveButton.setNegativeButton("\u53d6\u6d88", (DialogInterface.OnClickListener) aVar).show();
            EventCollector.getInstance().onViewClicked(aVar);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
