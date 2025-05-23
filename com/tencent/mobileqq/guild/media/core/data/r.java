package com.tencent.mobileqq.guild.media.core.data;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public volatile List<p> f228125a = new CopyOnWriteArrayList();

    private int i(int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < this.f228125a.size(); i17++) {
            if (this.f228125a.get(i17).f228099g == i3) {
                i16++;
            }
        }
        return i16;
    }

    private int j(int i3) {
        if (i3 == 1) {
            return com.tencent.mobileqq.guild.media.core.j.c().getMaxPlayerCacheNum();
        }
        return com.tencent.mobileqq.guild.media.core.j.c().getMaxViewerCacheNum();
    }

    private void m(p pVar, int i3) {
        long sortKey = pVar.C.getSortKey();
        boolean z16 = true;
        int size = this.f228125a.size() - 1;
        while (true) {
            if (size >= 0) {
                p pVar2 = this.f228125a.get(size);
                if (pVar2.f228099g == i3 && pVar2.C.getSortKey() < sortKey) {
                    this.f228125a.remove(size);
                    break;
                }
                size--;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            return;
        }
        this.f228125a.add(pVar);
    }

    public void a(p pVar) {
        int i3 = pVar.f228099g;
        if (i(i3) < j(i3)) {
            this.f228125a.add(pVar);
        } else {
            m(pVar, i3);
        }
    }

    public void b(IGProUserInfo iGProUserInfo) {
        for (p pVar : this.f228125a) {
            if (pVar.f228093a.equals(iGProUserInfo.getTinyId())) {
                pVar.f(iGProUserInfo);
                return;
            }
        }
        p j3 = p.j();
        j3.f(iGProUserInfo);
        a(j3);
    }

    public void c(List<p> list) {
        Iterator<p> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public r d() {
        ArrayList arrayList = new ArrayList(this.f228125a.size());
        Iterator<p> it = this.f228125a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        r rVar = new r();
        rVar.f228125a.addAll(arrayList);
        return rVar;
    }

    public void e(l lVar) {
        for (k kVar : lVar.c()) {
            p g16 = g(kVar.f228074a);
            if (g16 != null) {
                g16.d(kVar);
            }
        }
    }

    public boolean f() {
        if (this.f228125a == null || this.f228125a.size() == 0) {
            return false;
        }
        for (p pVar : this.f228125a) {
            if (MediaChannelUtils.f228046a.t(pVar) && pVar.f228098f == 0) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public p g(String str) {
        if (str != null && !str.isEmpty()) {
            for (p pVar : this.f228125a) {
                if (str.equals(pVar.f228093a)) {
                    return pVar;
                }
            }
        }
        return null;
    }

    public p h() {
        for (p pVar : this.f228125a) {
            if (pVar.f228103k) {
                return pVar;
            }
        }
        return null;
    }

    public int k(int i3) {
        int size = this.f228125a.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            if (this.f228125a.get(i17).f228099g == i3) {
                i16++;
            }
        }
        return i16;
    }

    public void l(String str) {
        for (int i3 = 0; i3 < this.f228125a.size(); i3++) {
            if (this.f228125a.get(i3).f228093a.equals(str)) {
                this.f228125a.remove(i3);
                return;
            }
        }
    }
}
