package cooperation.qzone.statistic.access.concept;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Statistic {
    protected Key[] keys = null;
    protected Object[] values = null;

    public Statistic(Key[] keyArr) {
        setKeys(keyArr);
    }

    public Key[] getKeys() {
        return this.keys;
    }

    public Object getValue(Key key) {
        int i3;
        if (key == null || (i3 = key.index) < 0 || i3 > this.keys.length - 1) {
            return null;
        }
        return this.values[i3];
    }

    public Object[] getValues() {
        return this.values;
    }

    public void setKeys(Key[] keyArr) {
        this.keys = keyArr;
        this.values = new Object[keyArr.length];
    }

    public Statistic setValue(Key key, Object obj) {
        int i3;
        if (key != null && (i3 = key.index) >= 0 && i3 <= this.keys.length - 1) {
            this.values[i3] = obj;
            return this;
        }
        return null;
    }

    public void setValues(Object[] objArr) {
        this.values = objArr;
    }

    public Object getValue(int i3) {
        if (i3 < 0 || i3 > this.keys.length - 1) {
            return null;
        }
        return this.values[i3];
    }
}
