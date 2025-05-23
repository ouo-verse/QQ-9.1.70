package com.tencent.mobileqq.guild.media.core.data;

import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private volatile List<k> f228080a = Collections.synchronizedList(new ArrayList());

    public void a(String str) {
        Iterator<k> it = this.f228080a.iterator();
        while (it.hasNext()) {
            if (it.next().f228074a.equals(str)) {
                return;
            }
        }
        k kVar = new k();
        kVar.f228074a = str;
        this.f228080a.add(kVar);
    }

    public void b() {
        this.f228080a.clear();
    }

    public final List<k> c() {
        return this.f228080a;
    }

    public void d(String str) {
        for (int i3 = 0; i3 < this.f228080a.size(); i3++) {
            if (this.f228080a.get(i3).f228074a.equals(str)) {
                this.f228080a.remove(i3);
                return;
            }
        }
    }

    public void e(String str, boolean z16) {
        for (k kVar : this.f228080a) {
            if (kVar.f228074a.equals(str)) {
                kVar.f228075b = z16;
                return;
            }
        }
    }

    public void f(String str, boolean z16) {
        for (k kVar : this.f228080a) {
            if (kVar.f228074a.equals(str)) {
                kVar.f228076c = z16;
                return;
            }
        }
    }

    public void g(String str, int i3, int i16) {
        for (k kVar : this.f228080a) {
            if (kVar.f228074a.equals(str)) {
                kVar.f228077d = i3;
                kVar.f228078e = i16;
                return;
            }
        }
    }

    public void h(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList) {
        Iterator<ITRTCAudioRoom.TRTCVolumeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.TRTCVolumeInfo next = it.next();
            Iterator<k> it5 = this.f228080a.iterator();
            while (true) {
                if (it5.hasNext()) {
                    k next2 = it5.next();
                    if (next.f228504d.equals(next2.f228074a)) {
                        next2.f228079f = next.f228505e;
                        break;
                    }
                }
            }
        }
    }
}
