package cooperation.qzone.statistic.access.concept;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Key {
    protected String name = null;
    protected int index = -1;

    public Key(String str) {
        setName(str);
    }

    public static void initializeOrders(Key[] keyArr) {
        for (int i3 = 0; i3 < keyArr.length; i3++) {
            keyArr[i3].index = i3;
        }
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
