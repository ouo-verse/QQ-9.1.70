package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import d73.e;
import d73.g;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {
    public static final d73.b a(d73.b bVar) {
        if (bVar == null) {
            return new d73.b(2, 0, null);
        }
        d73.b bVar2 = new d73.b(2, bVar.f393167g, new ArrayList());
        bVar2.f393161a = bVar.f393161a;
        Iterator<e> it = bVar.f393162b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                Iterator<g> it5 = next.f393183d.iterator();
                while (it5.hasNext()) {
                    bVar2.f393162b.add(new e(it5.next()));
                }
            }
        }
        return bVar2;
    }
}
