package org.jbox2d.dynamics;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Filter {
    public int categoryBits = 1;
    public int maskBits = 65535;
    public int groupIndex = 0;

    public void set(Filter filter) {
        this.categoryBits = filter.categoryBits;
        this.maskBits = filter.maskBits;
        this.groupIndex = filter.groupIndex;
    }
}
