package org.apache.httpcore.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes29.dex */
public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this(null);
    }

    public void clear() {
        this.map.clear();
    }

    @Override // org.apache.httpcore.protocol.HttpContext
    public Object getAttribute(String str) {
        HttpContext httpContext;
        Args.notNull(str, "Id");
        Object obj = this.map.get(str);
        if (obj == null && (httpContext = this.parentContext) != null) {
            return httpContext.getAttribute(str);
        }
        return obj;
    }

    @Override // org.apache.httpcore.protocol.HttpContext
    public Object removeAttribute(String str) {
        Args.notNull(str, "Id");
        return this.map.remove(str);
    }

    @Override // org.apache.httpcore.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        Args.notNull(str, "Id");
        if (obj != null) {
            this.map.put(str, obj);
        } else {
            this.map.remove(str);
        }
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }
}
