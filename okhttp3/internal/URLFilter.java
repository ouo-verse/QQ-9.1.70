package okhttp3.internal;

import java.io.IOException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface URLFilter {
    void checkURLPermitted(URL url) throws IOException;
}
