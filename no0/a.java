package no0;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ String a(CharSequence charSequence, Iterable iterable) {
        if (charSequence != null) {
            StringBuilder sb5 = new StringBuilder();
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb5.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb5.append(charSequence);
                }
            }
            return sb5.toString();
        }
        throw new NullPointerException("delimiter");
    }
}
