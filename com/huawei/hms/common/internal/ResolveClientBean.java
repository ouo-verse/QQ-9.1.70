package com.huawei.hms.common.internal;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResolveClientBean {

    /* renamed from: a, reason: collision with root package name */
    private final int f36880a;

    /* renamed from: b, reason: collision with root package name */
    private final AnyClient f36881b;

    /* renamed from: c, reason: collision with root package name */
    private int f36882c;

    public ResolveClientBean(AnyClient anyClient, int i3) {
        this.f36881b = anyClient;
        this.f36880a = Objects.hashCode(anyClient);
        this.f36882c = i3;
    }

    public void clientReconnect() {
        this.f36881b.connect(this.f36882c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ResolveClientBean)) {
            return this.f36881b.equals(((ResolveClientBean) obj).f36881b);
        }
        return false;
    }

    public AnyClient getClient() {
        return this.f36881b;
    }

    public int hashCode() {
        return this.f36880a;
    }
}
