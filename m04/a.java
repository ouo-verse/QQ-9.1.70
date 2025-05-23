package m04;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements b {
    @Override // m04.b
    public Boolean a(int i3, int i16, int i17, int i18) {
        boolean z16;
        float a16 = l04.a.a();
        if (i3 <= i17 * a16 && i16 <= i18 * a16) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }
}
