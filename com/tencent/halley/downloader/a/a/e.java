package com.tencent.halley.downloader.a.a;

import com.tencent.halley.downloader.task.d.a;
import com.tencent.halley.downloader.task.section.DataSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e extends a {
    static IPatchRedirector $redirector_;

    public e(com.tencent.halley.downloader.task.d.a aVar, Map<String, String> map, DataSection.a aVar2, boolean z16, com.tencent.halley.downloader.a.c cVar, boolean z17, com.tencent.halley.downloader.task.d.b bVar, int i3, boolean z18) {
        Map<String, String> map2;
        Map<Integer, Map<String, String>> map3;
        int i16;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, map, aVar2, Boolean.valueOf(z16), cVar, Boolean.valueOf(z17), bVar, Integer.valueOf(i3), Boolean.valueOf(z18));
            return;
        }
        this.f113587c = cVar;
        this.f113589e = aVar;
        this.f113591g = map;
        this.f113586b = z16;
        this.f113590f = z17;
        if (aVar2 != null) {
            DataSection.b bVar2 = this.f113597m;
            Iterator<DataSection.a> it = bVar2.f113944a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(aVar2)) {
                        z19 = true;
                        break;
                    }
                } else {
                    z19 = false;
                    break;
                }
            }
            if (!z19) {
                bVar2.f113944a.add(aVar2);
            }
        }
        this.f113594j = bVar.f113923n;
        a.EnumC1249a enumC1249a = aVar.f113891d;
        Map<Integer, Map<String, String>> map4 = bVar.f113925p;
        if (map4 != null && map4.size() > 0) {
            if (enumC1249a == a.EnumC1249a.f113901f) {
                map3 = bVar.f113925p;
                i16 = 0;
            } else if (enumC1249a == a.EnumC1249a.f113905j) {
                map3 = bVar.f113925p;
                i16 = 1;
            }
            map2 = map3.get(i16);
            this.f113595k = map2;
            this.f113588d = i3;
            this.f113596l = z18;
        }
        map2 = null;
        this.f113595k = map2;
        this.f113588d = i3;
        this.f113596l = z18;
    }
}
