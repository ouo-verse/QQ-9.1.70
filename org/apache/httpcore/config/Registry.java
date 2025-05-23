package org.apache.httpcore.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes29.dex */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    @Override // org.apache.httpcore.config.Lookup
    public I lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
