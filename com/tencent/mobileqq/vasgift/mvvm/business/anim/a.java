package com.tencent.mobileqq.vasgift.mvvm.business.anim;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPngAnimationViewImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import qh2.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class a implements com.tencent.mobileqq.qqgift.mvvm.business.anim.b {

    /* renamed from: d, reason: collision with root package name */
    protected QQGiftView f311694d;

    /* renamed from: f, reason: collision with root package name */
    protected nh2.c f311696f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f311697h;

    /* renamed from: e, reason: collision with root package name */
    protected CopyOnWriteArrayList<th2.a> f311695e = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    protected volatile boolean f311698i = false;

    /* renamed from: m, reason: collision with root package name */
    protected volatile boolean f311699m = true;
    protected final List<e> C = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.anim.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8935a implements th2.a {

        /* renamed from: a, reason: collision with root package name */
        private QQGiftPAGAnimationViewImpl f311700a = null;

        C8935a() {
        }

        @Override // th2.a
        public sh2.a a(Context context, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            int i3 = aVar.f264911b;
            if (i3 < 1 && (i3 != 0 || aVar.f264924o == 0)) {
                return null;
            }
            if (this.f311700a == null) {
                this.f311700a = new QQGiftPAGAnimationViewImpl(context);
            }
            return this.f311700a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements th2.a {

        /* renamed from: a, reason: collision with root package name */
        private QQGiftPngAnimationViewImpl f311702a = null;

        b() {
        }

        @Override // th2.a
        public sh2.a a(Context context, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            if (aVar.f264911b == 0 && aVar.f264924o == 0) {
                if (this.f311702a == null) {
                    this.f311702a = new QQGiftPngAnimationViewImpl(context);
                }
                return this.f311702a;
            }
            return null;
        }
    }

    public a(Context context, nh2.c cVar) {
        this.f311697h = context;
        this.f311696f = cVar;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public void d(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        l(aVar, -1);
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public sh2.a f(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        Iterator<th2.a> it = this.f311695e.iterator();
        while (it.hasNext()) {
            sh2.a a16 = it.next().a(this.f311697h, aVar);
            if (a16 != null) {
                return a16;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public View i() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public View k() {
        return this.f311694d;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public nh2.c m() {
        return this.f311696f;
    }

    public void n(th2.a aVar) {
        this.f311695e.add(0, aVar);
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public void prepare() {
        Context context = this.f311697h;
        if (context == null) {
            return;
        }
        QQGiftPAGAnimationViewImpl.f311895g.b(context, null);
        QQGiftView qQGiftView = new QQGiftView(this.f311697h, this);
        this.f311694d = qQGiftView;
        qQGiftView.setVisibility(4);
        this.f311695e.add(new C8935a());
        this.f311695e.add(new b());
        this.f311699m = false;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public void release() {
        this.f311699m = true;
        QQGiftView qQGiftView = this.f311694d;
        if (qQGiftView != null) {
            qQGiftView.p();
            this.f311694d = null;
        }
        this.C.clear();
        this.f311695e.clear();
        this.f311697h = null;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public void reset() {
    }
}
