package com.tencent.mobileqq.qqexpand.bean.common;

import java.io.Serializable;

/* loaded from: classes16.dex */
public class Pair<F, S> implements Serializable {
    public final F first;
    public final S second;

    public Pair(F f16, S s16) {
        this.first = f16;
        this.second = s16;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        try {
            Pair pair = (Pair) obj;
            if (this.first.equals(pair.first) && this.second.equals(pair.second)) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return ((527 + this.first.hashCode()) * 31) + this.second.hashCode();
    }
}
