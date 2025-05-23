package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f68572a = new ArrayList();

    public void a() {
        Iterator<a> it = this.f68572a.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public void b(int i3) {
        Iterator<a> it = this.f68572a.iterator();
        while (it.hasNext()) {
            it.next().c(i3);
        }
    }

    public void c(a aVar) {
        if (aVar != null) {
            if (!this.f68572a.contains(aVar)) {
                this.f68572a.add(aVar);
                return;
            }
            throw new IllegalStateException("Observer " + aVar + " is already registered.");
        }
        throw new IllegalArgumentException("the observer is null.");
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f68572a) {
                int indexOf = this.f68572a.indexOf(aVar);
                if (indexOf != -1) {
                    this.f68572a.remove(indexOf);
                }
            }
            return;
        }
        throw new IllegalArgumentException("The observer is null.");
    }
}
