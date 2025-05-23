package com.tencent.luggage.ui.presenter;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.g6.g;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.g6.q;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.u;
import com.tencent.luggage.wxa.k0.d;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.qk.b;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class UIContainerPageBase extends ContextWrapper implements u, com.tencent.luggage.wxa.g6.a, q {
    public static final a F = new a(null);
    public final UIContainerPageBase$nightModeListener$1 C;
    public Resources D;
    public LayoutInflater E;

    /* renamed from: a, reason: collision with root package name */
    public final g f120350a;

    /* renamed from: b, reason: collision with root package name */
    public Intent f120351b;

    /* renamed from: c, reason: collision with root package name */
    public r f120352c;

    /* renamed from: d, reason: collision with root package name */
    public final LifecycleRegistry f120353d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewModelStore f120354e;

    /* renamed from: f, reason: collision with root package name */
    public Configuration f120355f;

    /* renamed from: g, reason: collision with root package name */
    public int f120356g;

    /* renamed from: h, reason: collision with root package name */
    public Intent f120357h;

    /* renamed from: i, reason: collision with root package name */
    public List f120358i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f120359j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f120360k;

    /* renamed from: l, reason: collision with root package name */
    public Window f120361l;

    /* renamed from: m, reason: collision with root package name */
    public int f120362m;

    /* loaded from: classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.tencent.luggage.ui.presenter.UIContainerPageBase$nightModeListener$1] */
    public UIContainerPageBase(g container) {
        super(container.getContext());
        Intrinsics.checkNotNullParameter(container, "container");
        this.f120350a = container;
        this.f120353d = new LifecycleRegistry(this);
        this.f120354e = new ViewModelStore();
        this.f120358i = new ArrayList();
        this.f120362m = -1;
        this.C = new IListener<b>() { // from class: com.tencent.luggage.ui.presenter.UIContainerPageBase$nightModeListener$1
            {
                super(UIContainerPageBase.this);
            }

            public boolean a(b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                UIContainerPageBase.a(UIContainerPageBase.this, false, 1, null);
                return false;
            }

            @Override // com.tencent.mm.sdk.event.IListener
            public /* bridge */ /* synthetic */ boolean callback(c cVar) {
                d.a(cVar);
                return a((b) null);
            }
        };
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        getResources().updateConfiguration(a(baseContext, AppCompatDelegate.getDefaultNightMode(), getResources().getConfiguration()), getResources().getDisplayMetrics());
    }

    public final FrameLayout a() {
        View findViewById = c().findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById);
        return (FrameLayout) findViewById;
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void b() {
        Window window = this.f120361l;
        r rVar = null;
        if (window == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
            window = null;
        }
        window.setContentView(c());
        alive();
        a(false);
        this.f120353d.setCurrentState(Lifecycle.State.CREATED);
        r rVar2 = this.f120352c;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
        } else {
            rVar = rVar2;
        }
        rVar.b();
        this.f120355f = new Configuration(getContext().getResources().getConfiguration());
    }

    @Override // androidx.lifecycle.LifecycleOwner
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public LifecycleRegistry getLifecycle() {
        return this.f120353d;
    }

    public final void e() {
        if (this.f120353d.getCurrentState().isAtLeast(Lifecycle.State.STARTED) && !this.f120360k) {
            this.f120360k = true;
            this.f120350a.h(this);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public View findViewById(int i3) {
        return c().findViewById(i3);
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void finish() {
        if (this.f120360k) {
            return;
        }
        this.f120360k = true;
        this.f120350a.c((u) this);
    }

    @Override // com.tencent.luggage.wxa.g6.t, com.tencent.luggage.wxa.g6.a
    public Intent getIntent() {
        return this.f120351b;
    }

    @Override // com.tencent.luggage.wxa.g6.q
    public p getNavigator() {
        return this.f120350a;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public r getPage() {
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            return null;
        }
        return rVar;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public int getRequestedOrientation() {
        return this.f120362m;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.D == null) {
            this.D = new com.tencent.luggage.wxa.il.a(super.getResources());
        }
        Resources resources = this.D;
        Intrinsics.checkNotNull(resources);
        return resources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            LayoutInflater layoutInflater = this.E;
            if (layoutInflater != null) {
                Intrinsics.checkNotNull(layoutInflater);
                return layoutInflater;
            }
            Object systemService = super.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            LayoutInflater layoutInflater2 = (LayoutInflater) systemService;
            this.E = layoutInflater2;
            return layoutInflater2;
        }
        Object systemService2 = super.getSystemService(name);
        Intrinsics.checkNotNullExpressionValue(systemService2, "super.getSystemService(name)");
        return systemService2;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        return this.f120354e;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public Window getWindow() {
        Window window = this.f120361l;
        if (window == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
            return null;
        }
        return window;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public boolean isFinishing() {
        return this.f120360k;
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void n() {
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        rVar.n();
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void onDestroy() {
        if (this.f120359j) {
            return;
        }
        this.f120359j = true;
        this.f120353d.setCurrentState(Lifecycle.State.DESTROYED);
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        rVar.onDestroy();
        Iterator it = this.f120358i.iterator();
        while (it.hasNext()) {
            ((LuggageActivityHelper.d) it.next()).a(this.f120356g, this.f120357h);
        }
        this.f120358i.clear();
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void onPause() {
        this.f120353d.setCurrentState(Lifecycle.State.STARTED);
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        rVar.onPause();
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void onResume() {
        this.f120353d.setCurrentState(Lifecycle.State.RESUMED);
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        rVar.onResume();
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void onStart() {
        r rVar = null;
        a(this, false, 1, null);
        this.f120353d.setCurrentState(Lifecycle.State.STARTED);
        r rVar2 = this.f120352c;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
        } else {
            rVar = rVar2;
        }
        rVar.onStart();
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void onStop() {
        this.f120353d.setCurrentState(Lifecycle.State.CREATED);
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        rVar.onStop();
    }

    @Override // com.tencent.luggage.wxa.g6.t, com.tencent.luggage.wxa.g6.a
    public void overridePendingTransition(int i3, int i16) {
        this.f120350a.overridePendingTransition(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.g6.t, com.tencent.luggage.wxa.g6.a
    public void runOnUiThread(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        h.f146825d.a(action);
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public /* synthetic */ void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        o21.b.a(this, onMenuItemClickListener);
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setContentView(int i3) {
        a().removeAllViews();
        LayoutInflater.from(this).inflate(i3, a());
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setIntent(Intent intent) {
        this.f120351b = intent;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setResult(int i3) {
        this.f120356g = i3;
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void a(r page) {
        Intrinsics.checkNotNullParameter(page, "page");
        this.f120352c = page;
    }

    @Override // com.tencent.luggage.wxa.g6.t, com.tencent.luggage.wxa.g6.a
    public void setResult(int i3, Intent intent) {
        this.f120356g = i3;
        this.f120357h = intent;
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void a(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        this.f120361l = window;
    }

    public void a(Configuration newConf) {
        Intrinsics.checkNotNullParameter(newConf, "newConf");
        AppCompatDrawableManager.get().onConfigurationChanged(getContext());
        this.f120355f = new Configuration(getContext().getResources().getConfiguration());
        a(false);
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        rVar.a(newConf);
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public void a(LuggageActivityHelper.d resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        this.f120358i.add(resultCallback);
    }

    public static /* synthetic */ boolean a(UIContainerPageBase uIContainerPageBase, boolean z16, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyDayNight");
        }
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return uIContainerPageBase.a(z16);
    }

    public final boolean a(boolean z16) {
        if (this.f120359j) {
            return false;
        }
        return a(AppCompatDelegate.getDefaultNightMode(), z16);
    }

    public final Configuration a(Context context, int i3, Configuration configuration) {
        int i16;
        if (i3 != 1) {
            i16 = i3 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i16 = 16;
        }
        Configuration configuration2 = new Configuration();
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i16 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    public final boolean a(int i3, boolean z16) {
        boolean z17;
        Configuration a16 = a(getContext(), i3, (Configuration) null);
        r rVar = this.f120352c;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("page");
            rVar = null;
        }
        boolean h16 = rVar.h();
        Configuration configuration = this.f120355f;
        if (configuration == null) {
            configuration = getContext().getResources().getConfiguration();
        }
        int i16 = configuration.uiMode & 48;
        int i17 = a16.uiMode & 48;
        if (i16 == i17 || !z16 || h16 || !this.f120353d.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            z17 = false;
        } else {
            e();
            z17 = true;
        }
        if (z17 || i16 == i17) {
            return z17;
        }
        a(i17, h16, (Configuration) null);
        return true;
    }

    @Override // com.tencent.luggage.wxa.g6.t, com.tencent.luggage.wxa.g6.a
    public Context getContext() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void superOnBackPressed() {
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setActionBarColor(int i3) {
    }

    public final void a(int i3, boolean z16, Configuration configuration) {
        Resources resources = getContext().getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i3 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (z16 && this.f120353d.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            a(configuration2);
        }
    }
}
