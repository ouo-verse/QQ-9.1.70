package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bg {

    /* renamed from: d, reason: collision with root package name */
    private final bf f147795d;

    /* renamed from: a, reason: collision with root package name */
    final CopyOnWriteArrayList<fb> f147792a = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<fb> f147794c = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    final CopyOnWriteArrayList<fb> f147793b = new CopyOnWriteArrayList<>();

    public bg(bf bfVar) {
        this.f147795d = bfVar;
    }

    private void a(fb fbVar) {
        synchronized (this.f147792a) {
            if (this.f147792a.contains(fbVar)) {
                return;
            }
            this.f147792a.add(fbVar);
        }
    }

    private void b(fb fbVar) {
        if (fbVar == null) {
            return;
        }
        synchronized (this.f147792a) {
            this.f147792a.remove(fbVar);
            this.f147793b.add(fbVar);
        }
    }

    private void a() {
        int a16;
        synchronized (this.f147792a) {
            ArrayList arrayList = new ArrayList();
            int size = this.f147793b.size();
            for (int i3 = 0; i3 < size; i3++) {
                fb fbVar = this.f147793b.get(i3);
                if ((fbVar instanceof qx) && (a16 = ((qx) fbVar).a()) >= 0) {
                    arrayList.add(Integer.valueOf(a16));
                }
            }
            int size2 = arrayList.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = ((Integer) arrayList.get(i16)).intValue();
            }
            this.f147795d.g().a(iArr, size2);
            this.f147793b.clear();
        }
    }

    public final boolean a(float f16, float f17) {
        synchronized (this.f147792a) {
            for (int size = this.f147792a.size() - 1; size >= 0; size--) {
                fb fbVar = this.f147792a.get(size);
                if (fbVar != null && fbVar.onTap(f16, f17)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Deprecated
    public final boolean a(GL10 gl10) {
        int a16;
        synchronized (this.f147792a) {
            ArrayList arrayList = new ArrayList();
            int size = this.f147793b.size();
            for (int i3 = 0; i3 < size; i3++) {
                fb fbVar = this.f147793b.get(i3);
                if ((fbVar instanceof qx) && (a16 = ((qx) fbVar).a()) >= 0) {
                    arrayList.add(Integer.valueOf(a16));
                }
            }
            int size2 = arrayList.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = ((Integer) arrayList.get(i16)).intValue();
            }
            this.f147795d.g().a(iArr, size2);
            this.f147793b.clear();
        }
        this.f147794c.clear();
        synchronized (this.f147792a) {
            this.f147794c.addAll(this.f147792a);
        }
        Iterator<fb> it = this.f147794c.iterator();
        while (it.hasNext()) {
            it.next().a(gl10);
        }
        return true;
    }
}
