package org.apache.commons.lang.mutable;

import java.io.Serializable;
import org.apache.commons.lang.BooleanUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableBoolean implements Mutable, Serializable, Comparable {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    public MutableBoolean() {
    }

    public boolean booleanValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        boolean z16 = ((MutableBoolean) obj).value;
        boolean z17 = this.value;
        if (z17 == z16) {
            return 0;
        }
        if (z17) {
            return 1;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableBoolean) || this.value != ((MutableBoolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public Object getValue() {
        return BooleanUtils.toBooleanObject(this.value);
    }

    public int hashCode() {
        Boolean bool;
        if (this.value) {
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        return bool.hashCode();
    }

    public boolean isFalse() {
        return !this.value;
    }

    public boolean isTrue() {
        if (this.value) {
            return true;
        }
        return false;
    }

    public void setValue(boolean z16) {
        this.value = z16;
    }

    public Boolean toBoolean() {
        return BooleanUtils.toBooleanObject(this.value);
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableBoolean(boolean z16) {
        this.value = z16;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Boolean) obj).booleanValue());
    }

    public MutableBoolean(Boolean bool) {
        this.value = bool.booleanValue();
    }
}
