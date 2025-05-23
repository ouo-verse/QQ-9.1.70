package com.tencent.luggage.wxa.lj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.lj.s;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s extends f {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f133554a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends LinkedList {
        public a() {
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public boolean remove(Object obj) {
            boolean remove = super.remove(obj);
            w.b("MicroMsg.StackedBlinkingCapsuleBarPart", "resetBlinkState");
            s.this.d();
            return remove;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b implements j.b {

        /* renamed from: c, reason: collision with root package name */
        public a.d f133558c;

        /* renamed from: e, reason: collision with root package name */
        public Map f133560e;

        /* renamed from: g, reason: collision with root package name */
        public int f133562g;

        /* renamed from: a, reason: collision with root package name */
        public Drawable f133556a = null;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f133557b = null;

        /* renamed from: d, reason: collision with root package name */
        public String f133559d = "";

        /* renamed from: f, reason: collision with root package name */
        public int f133561f = Integer.MIN_VALUE;

        /* renamed from: h, reason: collision with root package name */
        public Runnable f133563h = null;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f133565a;

            public a(Drawable drawable) {
                this.f133565a = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f133556a = this.f133565a;
                if (b.this.b()) {
                    b bVar = b.this;
                    s.this.a(bVar.f133556a);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lj.s$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6446b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CharSequence f133567a;

            public RunnableC6446b(CharSequence charSequence) {
                this.f133567a = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f133557b = this.f133567a;
                if (b.this.b()) {
                    s.this.b(this.f133567a);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f133569a;

            public c(int i3) {
                this.f133569a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b bVar = b.this;
                    bVar.a((CharSequence) s.this.c().getResources().getString(this.f133569a));
                } catch (Resources.NotFoundException unused) {
                    b.this.a((CharSequence) null);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f133571a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f133572b;

            public d(int i3, boolean z16) {
                this.f133571a = i3;
                this.f133572b = z16;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f133561f = this.f133571a;
                if (b.this.b()) {
                    s.this.b(this.f133571a, this.f133572b);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d("mountliTest", "dismiss");
                s.this.f133554a.remove(b.this);
            }
        }

        public b(a.d dVar, int i3) {
            this.f133558c = dVar;
            this.f133562g = i3;
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        /* renamed from: dismiss, reason: merged with bridge method [inline-methods] */
        public void c() {
            s.this.a(new e());
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void setLogo(Drawable drawable) {
            s.this.a(new a(drawable));
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void setLogo(final int i3) {
            s.this.a(new Runnable() { // from class: f31.a
                @Override // java.lang.Runnable
                public final void run() {
                    s.b.this.b(i3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3) {
            Context c16 = s.this.c();
            if (c16 == null) {
                c16 = z.c();
            }
            try {
                setLogo(ContextCompat.getDrawable(c16, i3));
            } catch (Resources.NotFoundException unused) {
                setLogo((Drawable) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Map map) {
            this.f133560e = map;
            if (b()) {
                s.this.b(map);
                a(((Long) map.get("key_show_duration")).longValue());
            }
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void a(CharSequence charSequence) {
            s.this.a(new RunnableC6446b(charSequence));
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void a(int i3) {
            s.this.a(new c(i3));
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void a(int i3, boolean z16) {
            s.this.a(new d(i3, z16));
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void a(String str) {
            this.f133559d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16) {
            s.this.a(z16);
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void a(final Map map) {
            s.this.a(new Runnable() { // from class: f31.d
                @Override // java.lang.Runnable
                public final void run() {
                    s.b.this.b(map);
                }
            });
        }

        @Override // com.tencent.luggage.wxa.lj.j.b
        public void a(final boolean z16) {
            s.this.a(new Runnable() { // from class: f31.c
                @Override // java.lang.Runnable
                public final void run() {
                    s.b.this.b(z16);
                }
            });
        }

        public final boolean b() {
            return s.this.f133554a.peekFirst() == this;
        }

        public final void a(long j3) {
            w.g("MicroMsg.StackedBlinkingCapsuleBarPart", "dismissByPostDelay %d ms", Long.valueOf(j3));
            Runnable runnable = new Runnable() { // from class: f31.b
                @Override // java.lang.Runnable
                public final void run() {
                    s.b.this.c();
                }
            };
            this.f133563h = runnable;
            c0.a(runnable, j3);
        }

        public void a() {
            Runnable runnable = this.f133563h;
            if (runnable == null) {
                return;
            }
            c0.b(runnable);
            this.f133563h = null;
        }
    }

    public final void d() {
        CharSequence charSequence;
        int i3;
        b bVar = (b) this.f133554a.peekFirst();
        if (bVar != null && bVar.f133562g == 1) {
            a(false);
            if (bVar.f133560e != null) {
                b(bVar.f133561f, true);
                b(bVar.f133560e);
                bVar.a(((Long) bVar.f133560e.get("key_show_duration")).longValue());
                return;
            }
            return;
        }
        Drawable drawable = null;
        if (bVar != null) {
            charSequence = bVar.f133557b;
        } else {
            charSequence = null;
        }
        b(charSequence);
        if (bVar != null) {
            drawable = bVar.f133556a;
        }
        a(drawable);
        if (bVar != null) {
            i3 = bVar.f133561f;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        b(i3, false);
    }

    public j.b a(a.d dVar) {
        return a(dVar, 0);
    }

    public j.b a(a.d dVar, int i3) {
        b bVar = new b(dVar, i3);
        LinkedList linkedList = new LinkedList();
        a(bVar);
        if (dVar == a.d.HIGH) {
            this.f133554a.addFirst(bVar);
        } else if (dVar == a.d.LOW) {
            a(bVar);
            while (this.f133554a.peekFirst() != null && ((b) this.f133554a.peekFirst()).f133558c == a.d.HIGH) {
                linkedList.addFirst((b) this.f133554a.pollFirst());
            }
            this.f133554a.addFirst(bVar);
            while (linkedList.peekFirst() != null) {
                this.f133554a.addFirst((b) linkedList.pollFirst());
            }
        } else {
            this.f133554a.addLast(bVar);
        }
        return bVar;
    }

    public final void a(b bVar) {
        b bVar2;
        long j3;
        a.d dVar = bVar.f133558c;
        a.d dVar2 = a.d.TAIL;
        if (dVar == dVar2 || (bVar2 = (b) this.f133554a.peekFirst()) == null || bVar2.f133558c != dVar2 || bVar.f133561f == bVar2.f133561f) {
            return;
        }
        w.e("MicroMsg.StackedBlinkingCapsuleBarPart", "checkInterceptTheTailPrior intercepted");
        bVar2.a();
        this.f133554a.removeFirst();
        if (bVar2.f133562g == 1 && bVar2.f133560e != null && bVar2.f133560e.containsKey("key_show_duration_after_intercepted")) {
            try {
                j3 = ((Long) bVar2.f133560e.get("key_show_duration_after_intercepted")).longValue();
            } catch (Exception e16) {
                w.b("MicroMsg.StackedBlinkingCapsuleBarPart", "checkInterceptTheTailPrior get duration exp:%s", e16);
                j3 = 0;
            }
            if (j3 > 0) {
                bVar2.f133560e.put("key_show_duration", Long.valueOf(j3));
                this.f133554a.addLast(bVar2);
                w.g("MicroMsg.StackedBlinkingCapsuleBarPart", "checkInterceptTheTailPrior intercept addLast again duration:%d size:%d", Long.valueOf(j3), Integer.valueOf(this.f133554a.size()));
            }
        }
    }
}
