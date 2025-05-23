package ku2;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import pw2.n;
import rv2.c;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static void a(int i3, int i16) {
        n.a("QAdInsideVideoCache", "maxVideoCacheCount: " + i3 + ", cacheExpiredDay: " + i16);
        long longValue = Long.valueOf((long) i16).longValue() * 24 * 60 * 60 * 1000;
        ArrayList<File> c16 = c.c(c.a());
        long currentTimeMillis = System.currentTimeMillis();
        if (c16 == null) {
            return;
        }
        int size = c16.size();
        Iterator<File> it = c16.iterator();
        while (it.hasNext()) {
            File next = it.next();
            if (next != null) {
                if (size > i3) {
                    n.a("QAdInsideVideoCache", "file deleted: " + next.getName());
                    next.delete();
                } else if (currentTimeMillis - next.lastModified() > longValue) {
                    n.a("QAdInsideVideoCache", "file deleted: " + next.getName());
                    next.delete();
                }
                size--;
            }
        }
    }
}
