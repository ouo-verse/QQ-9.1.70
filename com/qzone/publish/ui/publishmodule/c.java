package com.qzone.publish.ui.publishmodule;

import android.content.Intent;
import android.os.Message;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.event.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected List<b> f51996a;

    /* renamed from: b, reason: collision with root package name */
    protected PhotoActivity f51997b;

    public c(PhotoActivity photoActivity) {
        this.f51997b = photoActivity;
        e();
    }

    public static c d(PhotoActivity photoActivity) {
        return new c(photoActivity);
    }

    public <T extends b> T a(Class<T> cls) {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (t16.getClass().equals(cls)) {
                return t16;
            }
        }
        return null;
    }

    public void b() {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    public void c() {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f51996a = new ArrayList();
        if (this.f51997b.getAppId() == 100203) {
            this.f51996a.add(new d());
            this.f51996a.add(new a());
        }
        this.f51996a.add(new LBSModule());
        for (b bVar : this.f51996a) {
            bVar.r(this.f51997b);
            bVar.s(this);
        }
    }

    public void f(int i3, int i16, Intent intent) {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().i(i3, i16, intent);
        }
    }

    public void g() {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    public void h(Intent intent) {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().k(intent);
        }
    }

    public void i() {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    public void j() {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    public void k(Event event) {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().n(event);
        }
    }

    public void l(Message message) {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().o(message);
        }
    }

    public void m(Intent intent) {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().p(intent);
        }
    }

    public void n() {
        Iterator<b> it = this.f51996a.iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }
}
