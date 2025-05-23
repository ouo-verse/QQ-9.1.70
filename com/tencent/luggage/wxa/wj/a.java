package com.tencent.luggage.wxa.wj;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements d {

    /* renamed from: b, reason: collision with root package name */
    public c f144251b;

    /* renamed from: c, reason: collision with root package name */
    public d.a f144252c;

    /* renamed from: d, reason: collision with root package name */
    public View f144253d;

    /* renamed from: e, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f144254e;

    /* renamed from: f, reason: collision with root package name */
    public int f144255f;

    /* renamed from: g, reason: collision with root package name */
    public ViewGroup.LayoutParams f144256g;

    /* renamed from: h, reason: collision with root package name */
    public ViewGroup f144257h;

    /* renamed from: j, reason: collision with root package name */
    public View f144259j;

    /* renamed from: a, reason: collision with root package name */
    public final d.a f144250a = new C6886a();

    /* renamed from: i, reason: collision with root package name */
    public final Set f144258i = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: k, reason: collision with root package name */
    public boolean f144260k = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6886a implements d.a {
        public C6886a() {
        }

        @Override // com.tencent.luggage.wxa.wj.d.a
        public ViewGroup a(View view) {
            Activity activity;
            c cVar = a.this.f144251b;
            if (cVar instanceof WindowAndroidActivityImpl) {
                activity = ((WindowAndroidActivityImpl) cVar).j();
            } else {
                activity = null;
            }
            if (activity == null) {
                return (ViewGroup) view.getRootView();
            }
            return (ViewGroup) activity.getWindow().getDecorView();
        }
    }

    public a(c cVar, d.a aVar) {
        this.f144252c = aVar;
        this.f144251b = cVar;
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void a(View view, int i3) {
        this.f144260k = true;
        d.a aVar = this.f144252c;
        if (aVar == null) {
            aVar = this.f144250a;
        }
        View view2 = this.f144253d;
        this.f144259j = view2;
        this.f144253d = view;
        if (view2 == null) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                this.f144257h = viewGroup;
                this.f144255f = viewGroup.indexOfChild(view);
                this.f144256g = view.getLayoutParams();
                this.f144257h.removeView(view);
            } else {
                this.f144255f = 0;
                this.f144257h = null;
                this.f144256g = null;
            }
            ViewGroup a16 = aVar.a(view);
            a16.addView(view, new ViewGroup.LayoutParams(-1, -1));
            a16.bringChildToFront(view);
            ViewParent parent = a16.getParent();
            if (parent != null) {
                parent.bringChildToFront(a16);
            }
            view.setX(0.0f);
            view.setY(0.0f);
        }
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public final boolean b() {
        return this.f144260k;
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public boolean c() {
        if (this.f144253d == null) {
            return false;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.f144254e;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        if (this.f144253d.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f144253d.getParent()).removeView(this.f144253d);
        }
        ViewGroup viewGroup = this.f144257h;
        if (viewGroup != null) {
            viewGroup.addView(this.f144253d, this.f144255f, this.f144256g);
        }
        this.f144253d = null;
        this.f144254e = null;
        this.f144260k = false;
        return true;
    }

    public void d() {
        Iterator it = this.f144258i.iterator();
        while (it.hasNext()) {
            ((b) it.next()).i();
        }
    }

    public void e() {
        Iterator it = this.f144258i.iterator();
        while (it.hasNext()) {
            ((b) it.next()).j();
        }
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void release() {
        c();
        this.f144258i.clear();
        this.f144254e = null;
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f144258i.remove(bVar);
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void a(WebChromeClient.CustomViewCallback customViewCallback) {
        this.f144254e = customViewCallback;
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f144258i.add(bVar);
    }
}
