package com.tencent.rmonitor.natmem;

import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, int i3) {
        Iterator<IBaseListener> it = i04.a.natMemListener.c().iterator();
        while (it.hasNext()) {
            IBaseListener next = it.next();
            if (next instanceof a) {
                ((a) next).d(str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(int i3) {
        Iterator<IBaseListener> it = i04.a.natMemListener.c().iterator();
        while (it.hasNext()) {
            IBaseListener next = it.next();
            if (next instanceof a) {
                ((a) next).onFail(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c() {
        Iterator<IBaseListener> it = i04.a.natMemListener.c().iterator();
        while (it.hasNext()) {
            IBaseListener next = it.next();
            if (next instanceof a) {
                ((a) next).onSuccess();
            }
        }
    }
}
