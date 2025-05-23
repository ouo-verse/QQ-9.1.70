package km2;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private final List<g> f412695a = new ArrayList();

    @Override // km2.g
    public void a(com.tencent.mobileqq.richmedia.particlesystem.a aVar, jm2.a aVar2, int i3) {
        if (!b(aVar, aVar2)) {
            return;
        }
        Iterator<g> it = this.f412695a.iterator();
        while (it.hasNext()) {
            it.next().a(aVar, aVar2, i3);
        }
    }

    public void c(@NonNull g gVar) {
        this.f412695a.add(gVar);
    }
}
