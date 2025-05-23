package a25;

import a25.a;
import a25.d;
import a25.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f25419a = Logger.getLogger(b.class.getName());

    /* compiled from: P */
    /* renamed from: a25.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static final class C0005b implements e {
        private void b(c cVar, e.a aVar) {
            a.C0004a b16 = a25.a.b(cVar);
            String c16 = c(b16.f25417a);
            ArrayList arrayList = new ArrayList(Arrays.asList(b16.f25418b));
            arrayList.add(0, c16);
            aVar.call(arrayList.toArray());
        }

        private String c(c cVar) {
            StringBuilder sb5 = new StringBuilder("" + cVar.f25420a);
            int i3 = cVar.f25420a;
            if (5 == i3 || 6 == i3) {
                sb5.append(cVar.f25424e);
                sb5.append("-");
            }
            String str = cVar.f25422c;
            if (str != null && str.length() != 0 && !"/".equals(cVar.f25422c)) {
                sb5.append(cVar.f25422c);
                sb5.append(",");
            }
            int i16 = cVar.f25421b;
            if (i16 >= 0) {
                sb5.append(i16);
            }
            Object obj = cVar.f25423d;
            if (obj != null) {
                sb5.append(obj);
            }
            if (b.f25419a.isLoggable(Level.FINE)) {
                b.f25419a.fine(String.format("encoded %s as %s", cVar, sb5));
            }
            return sb5.toString();
        }

        @Override // a25.e
        public void a(c cVar, e.a aVar) {
            int i3;
            int i16 = cVar.f25420a;
            if ((i16 == 2 || i16 == 3) && z15.a.b(cVar.f25423d)) {
                if (cVar.f25420a == 2) {
                    i3 = 5;
                } else {
                    i3 = 6;
                }
                cVar.f25420a = i3;
            }
            if (b.f25419a.isLoggable(Level.FINE)) {
                b.f25419a.fine(String.format("encoding packet %s", cVar));
            }
            int i17 = cVar.f25420a;
            if (5 != i17 && 6 != i17) {
                aVar.call(new String[]{c(cVar)});
            } else {
                b(cVar, aVar);
            }
        }
    }

    b() {
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a implements d {
        @Override // a25.d
        public void destroy() {
        }

        @Override // a25.d
        public void a(d.a aVar) {
        }
    }
}
