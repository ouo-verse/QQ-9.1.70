package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.luggage.wxa.p003do.e;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f152668g;

    /* renamed from: h, reason: collision with root package name */
    public static c f152669h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f152670i;

    /* renamed from: j, reason: collision with root package name */
    public static final WeakHashMap f152671j;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f152672a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f152673b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f152674c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f152675d;

    /* renamed from: e, reason: collision with root package name */
    public int f152676e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f152677f;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.ui.statusbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class ViewOnApplyWindowInsetsListenerC7067a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f152678a;

        public ViewOnApplyWindowInsetsListenerC7067a(ViewGroup viewGroup) {
            this.f152678a = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            int systemBars;
            Insets insets;
            int i3;
            int tappableElement;
            Insets insets2;
            int i16;
            if (Build.VERSION.SDK_INT >= 31 && a.this.f152674c) {
                systemBars = WindowInsets.Type.systemBars();
                insets = windowInsets.getInsets(systemBars);
                i3 = insets.top;
                tappableElement = WindowInsets.Type.tappableElement();
                insets2 = windowInsets.getInsets(tappableElement);
                i16 = insets2.top;
                a.this.f152676e = Math.max(i3, i16);
            } else {
                a.this.f152676e = windowInsets.getSystemWindowInsetTop();
            }
            a aVar = a.this;
            aVar.a(aVar.f152676e);
            WindowInsets a16 = a.f152669h.a(windowInsets);
            if (view != this.f152678a) {
                view.onApplyWindowInsets(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {

        /* compiled from: P */
        /* renamed from: com.tencent.mm.ui.statusbar.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public enum EnumC7068a implements c {
            INSTANCE;

            @Override // com.tencent.mm.ui.statusbar.a.c
            public WindowInsets a(WindowInsets windowInsets) {
                return windowInsets.consumeSystemWindowInsets();
            }
        }

        WindowInsets a(WindowInsets windowInsets);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(int i3);
    }

    static {
        boolean z16;
        if (!e.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        f152668g = z16;
        f152669h = c.EnumC7068a.INSTANCE;
        f152670i = new b(null);
        f152671j = new WeakHashMap();
    }

    public /* synthetic */ a(Activity activity, ViewOnApplyWindowInsetsListenerC7067a viewOnApplyWindowInsetsListenerC7067a) {
        this(activity);
    }

    public int c() {
        return this.f152676e;
    }

    public void d() {
        WeakReference weakReference = this.f152677f;
        if (weakReference != null && weakReference.get() != null) {
            ((View) this.f152677f.get()).requestApplyInsets();
        }
    }

    public final void e() {
        View view;
        if (!this.f152675d) {
            this.f152675d = true;
            Activity activity = (Activity) this.f152672a.get();
            if (activity != null && activity.getWindow() != null) {
                a b16 = b(activity);
                if (b16 != null) {
                    b16.b();
                }
                try {
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    int i3 = 0;
                    while (true) {
                        if (i3 < viewGroup.getChildCount()) {
                            view = viewGroup.getChildAt(i3);
                            if (!"android:status:background".equals(view.getTransitionName()) && !"android:navigation:background".equals(view.getTransitionName())) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            view = null;
                            break;
                        }
                    }
                    if (view == null) {
                        view = viewGroup;
                    }
                    view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC7067a(viewGroup));
                    view.requestApplyInsets();
                    this.f152677f = new WeakReference(view);
                } catch (Exception e16) {
                    this.f152675d = false;
                    w.b("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", e16);
                }
            }
        }
    }

    public a(Activity activity) {
        this.f152673b = new HashSet();
        this.f152675d = false;
        this.f152676e = 0;
        this.f152672a = new WeakReference(activity);
        this.f152674c = false;
    }

    public void b(d dVar) {
        if (dVar != null) {
            Iterator it = new LinkedList(this.f152673b).iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (dVar == weakReference.get() || weakReference.get() == null) {
                    this.f152673b.remove(weakReference);
                }
            }
        }
    }

    public void a(d dVar) {
        e();
        if (dVar != null) {
            this.f152673b.add(new WeakReference(dVar));
            int i3 = this.f152676e;
            if (i3 > 0) {
                dVar.a(i3);
            }
        }
    }

    public void b() {
        WeakReference weakReference = this.f152677f;
        View view = weakReference == null ? null : (View) weakReference.get();
        if (view != null) {
            view.setOnApplyWindowInsetsListener(null);
        }
    }

    public static a b(Activity activity) {
        if (f152668g && activity != null) {
            return (a) f152671j.get(activity);
        }
        return f152670i;
    }

    public final void a(int i3) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f152673b);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            d dVar = (d) weakReference.get();
            if (dVar != null) {
                dVar.a(i3);
            } else {
                this.f152673b.remove(weakReference);
            }
        }
    }

    public static a a(Activity activity) {
        if (f152668g && activity != null) {
            WeakHashMap weakHashMap = f152671j;
            a aVar = (a) weakHashMap.get(activity);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a(activity);
            weakHashMap.put(activity, aVar2);
            return aVar2;
        }
        return f152670i;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends a {
        public b(Activity activity) {
            super(activity, null);
        }

        @Override // com.tencent.mm.ui.statusbar.a
        public void a(d dVar) {
        }

        @Override // com.tencent.mm.ui.statusbar.a
        public void b(d dVar) {
        }
    }
}
