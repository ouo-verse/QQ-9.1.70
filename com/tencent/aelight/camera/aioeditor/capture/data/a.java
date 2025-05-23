package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<b> f66705d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public int f66706e = 2;

    /* renamed from: f, reason: collision with root package name */
    public int f66707f;

    /* renamed from: h, reason: collision with root package name */
    protected SegmentKeeper f66708h;

    /* renamed from: i, reason: collision with root package name */
    public Object f66709i;

    public a(Object obj) {
        this.f66709i = obj;
    }

    public void f(b bVar) {
        synchronized (this.f66705d) {
            if (!this.f66705d.contains(bVar)) {
                this.f66705d.add(bVar);
            }
        }
    }

    public abstract int g(Activity activity, int i3);

    public int h() {
        return 1;
    }

    public abstract float i();

    public abstract int j();

    public String k() {
        return String.valueOf(this.f66709i.hashCode());
    }

    public void l() {
        synchronized (this.f66705d) {
            Iterator<b> it = this.f66705d.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    public void m(int i3) {
        synchronized (this.f66705d) {
            Iterator<b> it = this.f66705d.iterator();
            while (it.hasNext()) {
                it.next().c(this, i3);
            }
        }
    }

    public void n() {
        synchronized (this.f66705d) {
            Iterator<b> it = this.f66705d.iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
        }
    }

    public void p(SegmentKeeper segmentKeeper) {
        this.f66708h = segmentKeeper;
    }

    public abstract void q(Activity activity, int i3);

    public void o(Activity activity, int i3) {
    }
}
