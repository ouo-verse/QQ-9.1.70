package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    Context f293432a;

    /* renamed from: b, reason: collision with root package name */
    LinearLayout f293433b;

    /* renamed from: c, reason: collision with root package name */
    LayoutInflater f293434c;

    /* renamed from: d, reason: collision with root package name */
    View.OnClickListener f293435d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<View> f293436e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    ArrayList<tr2.c> f293437f = new ArrayList<>(4);

    /* renamed from: g, reason: collision with root package name */
    ArrayList<InterfaceC8660b> f293438g = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements InterfaceC8660b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f293439a;

        a(c cVar) {
            this.f293439a = cVar;
        }

        @Override // com.tencent.mobileqq.together.ui.b.InterfaceC8660b
        public void onDestroy() {
            com.tencent.mobileqq.together.ui.a aVar;
            com.tencent.mobileqq.together.ui.a aVar2;
            d dVar = this.f293439a.f293441a;
            if (dVar != null && (aVar2 = dVar.f293449g) != null) {
                aVar2.f();
            }
            d dVar2 = this.f293439a.f293442b;
            if (dVar2 != null && (aVar = dVar2.f293449g) != null) {
                aVar.f();
            }
        }

        @Override // com.tencent.mobileqq.together.ui.b.InterfaceC8660b
        public void onDismiss() {
            com.tencent.mobileqq.together.ui.a aVar;
            com.tencent.mobileqq.together.ui.a aVar2;
            d dVar = this.f293439a.f293441a;
            if (dVar != null && (aVar2 = dVar.f293449g) != null) {
                aVar2.j();
            }
            d dVar2 = this.f293439a.f293442b;
            if (dVar2 != null && (aVar = dVar2.f293449g) != null) {
                aVar.j();
            }
        }

        @Override // com.tencent.mobileqq.together.ui.b.InterfaceC8660b
        public void onShow() {
            com.tencent.mobileqq.together.ui.a aVar;
            com.tencent.mobileqq.together.ui.a aVar2;
            d dVar = this.f293439a.f293441a;
            if (dVar != null && (aVar2 = dVar.f293449g) != null) {
                aVar2.g();
            }
            d dVar2 = this.f293439a.f293442b;
            if (dVar2 != null && (aVar = dVar2.f293449g) != null) {
                aVar.g();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.together.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC8660b {
        void onDestroy();

        void onDismiss();

        void onShow();
    }

    public b(Context context, View.OnClickListener onClickListener, LinearLayout linearLayout) {
        this.f293432a = context;
        this.f293434c = LayoutInflater.from(context);
        this.f293435d = onClickListener;
        this.f293433b = linearLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3) {
        tr2.c cVar;
        int i16;
        c cVar2 = new c();
        tr2.c cVar3 = null;
        View inflate = this.f293434c.inflate(R.layout.cbl, (ViewGroup) null);
        cVar2.a(inflate);
        cVar2.b(inflate);
        this.f293438g.add(new a(cVar2));
        int i17 = i3 * 2;
        if (i17 < this.f293437f.size()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                this.f293437f.get(i17).d(tr2.b.q((QQAppInterface) peekAppRuntime).p(this.f293437f.get(i17).f437177a));
                cVar = this.f293437f.get(i17);
                i16 = i17 + 1;
                if (i16 < this.f293437f.size()) {
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime2 instanceof QQAppInterface) {
                        this.f293437f.get(i16).d(tr2.b.q((QQAppInterface) peekAppRuntime2).p(this.f293437f.get(i16).f437177a));
                        cVar3 = this.f293437f.get(i16);
                    }
                }
                if (cVar != null) {
                    cVar2.f293441a.f293443a.setVisibility(4);
                } else {
                    cVar2.f293441a.f293443a.setVisibility(0);
                    cVar2.c(cVar, this.f293435d, this.f293432a);
                }
                if (cVar3 != null) {
                    cVar2.f293442b.f293443a.setVisibility(4);
                } else {
                    cVar2.f293442b.f293443a.setVisibility(0);
                    cVar2.d(cVar3, this.f293435d, this.f293432a);
                }
                this.f293433b.addView(inflate);
            }
        }
        cVar = null;
        i16 = i17 + 1;
        if (i16 < this.f293437f.size()) {
        }
        if (cVar != null) {
        }
        if (cVar3 != null) {
        }
        this.f293433b.addView(inflate);
    }

    public void b() {
        Iterator<InterfaceC8660b> it = this.f293438g.iterator();
        while (it.hasNext()) {
            InterfaceC8660b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
        this.f293438g.clear();
        LinearLayout linearLayout = this.f293433b;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.f293433b = null;
        }
    }

    public void c() {
        Iterator<InterfaceC8660b> it = this.f293438g.iterator();
        while (it.hasNext()) {
            InterfaceC8660b next = it.next();
            if (next != null) {
                next.onDismiss();
            }
        }
    }

    public void d() {
        Iterator<InterfaceC8660b> it = this.f293438g.iterator();
        while (it.hasNext()) {
            InterfaceC8660b next = it.next();
            if (next != null) {
                next.onShow();
            }
        }
    }

    public void e(ArrayList<tr2.c> arrayList) {
        this.f293437f.clear();
        this.f293437f.addAll(arrayList);
        f();
    }

    public void f() {
        LinearLayout linearLayout = this.f293433b;
        if (linearLayout != null && this.f293438g != null) {
            linearLayout.removeAllViews();
            Iterator<InterfaceC8660b> it = this.f293438g.iterator();
            while (it.hasNext()) {
                InterfaceC8660b next = it.next();
                if (next != null) {
                    next.onDestroy();
                }
            }
            this.f293438g.clear();
            int size = (this.f293437f.size() % 2) + (this.f293437f.size() / 2);
            for (int i3 = 0; i3 < size; i3++) {
                a(i3);
            }
        }
    }
}
