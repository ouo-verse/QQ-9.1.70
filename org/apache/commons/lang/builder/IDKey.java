package org.apache.commons.lang.builder;

/* compiled from: P */
/* loaded from: classes29.dex */
final class IDKey {

    /* renamed from: id, reason: collision with root package name */
    private final int f423535id;
    private final Object value;

    public IDKey(Object obj) {
        this.f423535id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.f423535id != iDKey.f423535id || this.value != iDKey.value) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f423535id;
    }
}
