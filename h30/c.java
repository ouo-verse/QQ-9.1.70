package h30;

import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c {
    protected abstract Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed);

    protected abstract ArrayList<String> b();

    protected boolean c(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return true;
    }

    public void d(e30.b bVar) {
        ArrayList<String> b16 = b();
        if (bVar != null && b() != null && bVar.g() != null) {
            Iterator<String> it = b16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (c(next, bVar.g())) {
                    bVar.o(next, a(bVar.g()));
                }
            }
        }
    }
}
