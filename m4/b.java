package m4;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public long f416100a;

    /* renamed from: b, reason: collision with root package name */
    public String f416101b;

    public int hashCode() {
        return ((527 + (this.f416100a + "").hashCode()) * 31) + this.f416101b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.f416100a == this.f416100a && bVar.f416101b.equals(this.f416101b);
    }
}
