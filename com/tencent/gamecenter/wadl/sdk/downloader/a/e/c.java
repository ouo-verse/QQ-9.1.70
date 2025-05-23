package com.tencent.gamecenter.wadl.sdk.downloader.a.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public List<b> f107302a = new ArrayList();

    public b a() {
        if (this.f107302a.size() > 0) {
            return this.f107302a.get(0);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("bytes=");
        for (b bVar : this.f107302a) {
            sb5.append(bVar.f107300a);
            sb5.append("-");
            long j3 = bVar.f107301b;
            if (j3 != -1) {
                sb5.append(j3);
            }
            sb5.append(",");
        }
        sb5.deleteCharAt(sb5.length() - 1);
        return sb5.toString();
    }

    public void a(b bVar) {
        boolean z16;
        Iterator<b> it = this.f107302a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            } else if (it.next().equals(bVar)) {
                z16 = true;
                break;
            }
        }
        if (z16) {
            return;
        }
        this.f107302a.add(bVar);
    }
}
