package com.tencent.mobileqq.tvideo.parts;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ai {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<a> f304533b;

    /* renamed from: a, reason: collision with root package name */
    private List<b> f304532a = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Observer<Integer> f304534c = new Observer() { // from class: com.tencent.mobileqq.tvideo.parts.ah
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            ai.this.e((Integer) obj);
        }
    };

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(int i3, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f304535a;

        /* renamed from: b, reason: collision with root package name */
        public int f304536b;

        /* renamed from: c, reason: collision with root package name */
        public String f304537c;

        /* renamed from: d, reason: collision with root package name */
        public String f304538d;

        public b() {
        }
    }

    public ai(a aVar) {
        this.f304533b = new WeakReference<>(aVar);
    }

    private void c(int i3) {
        WeakReference<a> weakReference;
        Iterator<b> it = this.f304532a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && i3 == next.f304535a && (weakReference = this.f304533b) != null && weakReference.get() != null) {
                QLog.d("QFSTVideoPrWebViewShowHelper", 4, "checkDelayShowData viewType = " + next.f304536b);
                this.f304533b.get().a(next.f304536b, next.f304537c, next.f304538d);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Integer num) {
        if (num.intValue() > 0) {
            try {
                QLog.d("QFSTVideoPrWebViewShowHelper", 4, "duration = " + num);
                c(num.intValue());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void b(int i3, int i16, String str, String str2) {
        if (this.f304532a.isEmpty()) {
            fy2.b.f400938a.c().observeForever(this.f304534c);
        }
        b bVar = new b();
        bVar.f304535a = i3 + fy2.b.f400938a.b();
        bVar.f304536b = i16;
        bVar.f304537c = str;
        bVar.f304538d = str2;
        this.f304532a.add(bVar);
    }

    public void d() {
        fy2.b.f400938a.c().removeObserver(this.f304534c);
        this.f304532a.clear();
    }
}
