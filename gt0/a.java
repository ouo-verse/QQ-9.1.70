package gt0;

/* compiled from: P */
/* loaded from: classes38.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ int a(double d16) {
        long doubleToLongBits = Double.doubleToLongBits(d16);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
