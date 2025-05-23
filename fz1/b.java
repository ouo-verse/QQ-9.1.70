package fz1;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class b {
    public abstract int a();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && a() == ((b) obj).a()) {
            return true;
        }
        return false;
    }
}
