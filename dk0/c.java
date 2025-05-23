package dk0;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void onHeadersReceived(int i3, Map<String, List<String>> map);

        void onHttpFinish(b bVar);

        void onHttpStart();
    }

    void sendRequest(dk0.a aVar, a aVar2, boolean z16);
}
