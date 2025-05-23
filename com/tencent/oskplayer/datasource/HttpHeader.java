package com.tencent.oskplayer.datasource;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class HttpHeader {
    private static AtomicInteger sId = new AtomicInteger(10);
    private Map<String, String> headerSnapshot;
    private final Map<String, String> headers = new HashMap();
    private int mId;

    public HttpHeader() {
        this.mId = -1;
        this.mId = sId.getAndIncrement();
    }

    public synchronized void clear() {
        this.headerSnapshot = null;
        this.headers.clear();
    }

    public synchronized void clearAndSet(Map<String, String> map) {
        this.headerSnapshot = null;
        this.headers.clear();
        this.headers.putAll(map);
    }

    public int getId() {
        return this.mId;
    }

    public synchronized Map<String, String> getSnapshot() {
        if (this.headerSnapshot == null) {
            this.headerSnapshot = Collections.unmodifiableMap(new HashMap(this.headers));
        }
        return this.headerSnapshot;
    }

    public synchronized void remove(String str) {
        this.headerSnapshot = null;
        this.headers.remove(str);
    }

    public synchronized void set(String str, String str2) {
        this.headerSnapshot = null;
        this.headers.put(str, str2);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("HttpHeader[");
        sb5.append("id=");
        sb5.append(this.mId);
        sb5.append(",");
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            sb5.append((Object) entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append((Object) entry.getValue());
            sb5.append(",");
        }
        sb5.append("]");
        return sb5.toString();
    }

    public synchronized void set(Map<String, String> map) {
        this.headerSnapshot = null;
        this.headers.putAll(map);
    }
}
