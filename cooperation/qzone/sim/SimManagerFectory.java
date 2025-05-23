package cooperation.qzone.sim;

/* compiled from: P */
/* loaded from: classes38.dex */
public class SimManagerFectory {
    public static SimManager createProduct(String str, int i3) {
        if (i3 >= 24) {
            return new SimManagerOfAPI24();
        }
        return new SimManagerDefault();
    }
}
