package org.apache.commons.lang.mutable;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableObject implements Mutable, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private Object value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableObject)) {
            return false;
        }
        Object obj2 = ((MutableObject) obj).value;
        Object obj3 = this.value;
        if (obj3 != obj2 && (obj3 == null || !obj3.equals(obj2))) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        Object obj = this.value;
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public MutableObject(Object obj) {
        this.value = obj;
    }
}
