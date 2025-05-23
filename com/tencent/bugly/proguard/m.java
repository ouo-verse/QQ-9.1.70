package com.tencent.bugly.proguard;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class m implements Serializable {
    public abstract void a(k kVar);

    public abstract void a(l lVar);

    public abstract void a(StringBuilder sb5, int i3);

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        a(sb5, 0);
        return sb5.toString();
    }
}
