package com.tencent.luggage.wxa.ro;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.ro.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f139896a;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f139898c;

    /* renamed from: d, reason: collision with root package name */
    public String f139899d;

    /* renamed from: e, reason: collision with root package name */
    public int f139900e;

    /* renamed from: f, reason: collision with root package name */
    public int f139901f;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f139903h;

    /* renamed from: i, reason: collision with root package name */
    public a f139904i;

    /* renamed from: b, reason: collision with root package name */
    public boolean f139897b = true;

    /* renamed from: g, reason: collision with root package name */
    public a.EnumC6654a f139902g = a.EnumC6654a.MODE_CHINESE_AS_2;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(String str);

        void b(String str);

        void c(String str);
    }

    public b(WeakReference weakReference) {
        this.f139896a = true;
        this.f139898c = weakReference;
        this.f139896a = false;
    }

    public static b a(String str) {
        return new b(str);
    }

    public b b(int i3) {
        this.f139901f = 0;
        this.f139900e = i3;
        return this;
    }

    public b a(a.EnumC6654a enumC6654a) {
        this.f139902g = enumC6654a;
        return this;
    }

    public b a(boolean z16) {
        this.f139896a = z16;
        return this;
    }

    public void b() {
        if (!this.f139896a) {
            if (this.f139898c == null) {
                w.f("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                return;
            } else if (w0.a((List) this.f139903h)) {
                ((EditText) this.f139898c.get()).setFilters(new InputFilter[]{a(this.f139900e, this.f139902g)});
            } else {
                this.f139903h.add(a(this.f139900e, this.f139902g));
                ArrayList arrayList = this.f139903h;
                ((EditText) this.f139898c.get()).setFilters((InputFilter[]) arrayList.toArray(new InputFilter[arrayList.size()]));
            }
        }
        if (this.f139904i != null) {
            int a16 = a();
            if (a16 == 0) {
                this.f139904i.b(this.f139899d);
            } else if (a16 == 1) {
                this.f139904i.c(this.f139899d);
            } else {
                if (a16 != 2) {
                    return;
                }
                this.f139904i.a(this.f139899d);
            }
        }
    }

    public void a(a aVar) {
        this.f139904i = aVar;
        b();
    }

    public int a() {
        if (w0.c(this.f139899d)) {
            WeakReference weakReference = this.f139898c;
            if (weakReference == null) {
                return 1;
            }
            this.f139899d = ((EditText) weakReference.get()).getText().toString().trim();
        }
        int a16 = com.tencent.luggage.wxa.qo.a.a(this.f139899d, this.f139902g);
        if (a(a16)) {
            w.f("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            return 2;
        }
        if (a16 < this.f139901f) {
            return 1;
        }
        return a16 > this.f139900e ? 2 : 0;
    }

    public b(String str) {
        this.f139896a = true;
        this.f139899d = str;
        this.f139896a = false;
    }

    public com.tencent.luggage.wxa.qo.a a(int i3, a.EnumC6654a enumC6654a) {
        return new com.tencent.luggage.wxa.qo.a(i3, enumC6654a, this.f139897b);
    }
}
