package org.jbox2d.collision.broadphase;

/* loaded from: classes29.dex */
public class Pair implements Comparable<Pair> {
    public int proxyIdA;
    public int proxyIdB;

    @Override // java.lang.Comparable
    public int compareTo(Pair pair) {
        int i3 = this.proxyIdA;
        int i16 = pair.proxyIdA;
        if (i3 < i16) {
            return -1;
        }
        if (i3 != i16) {
            return 1;
        }
        int i17 = this.proxyIdB;
        int i18 = pair.proxyIdB;
        if (i17 < i18) {
            return -1;
        }
        return i17 == i18 ? 0 : 1;
    }
}
