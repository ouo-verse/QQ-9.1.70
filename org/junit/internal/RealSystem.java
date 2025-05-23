package org.junit.internal;

import java.io.PrintStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RealSystem implements JUnitSystem {
    @Override // org.junit.internal.JUnitSystem
    @Deprecated
    public void exit(int i3) {
        System.exit(i3);
    }

    @Override // org.junit.internal.JUnitSystem
    public PrintStream out() {
        return System.out;
    }
}
