package cooperation.qzone.statistic.access.concept;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Deliverer {
    public static Deliverer Console = new Deliverer() { // from class: cooperation.qzone.statistic.access.concept.Deliverer.1
        @Override // cooperation.qzone.statistic.access.concept.Deliverer
        public int deliver(String str, int i3) {
            if (str != null && str.length() != 0 && i3 >= 1) {
                return 0;
            }
            return -1;
        }
    };
    public static final int NODATA = -1;
    public static final int SUCCESS = 0;

    public abstract int deliver(String str, int i3);
}
