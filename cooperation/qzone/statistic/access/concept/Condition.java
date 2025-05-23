package cooperation.qzone.statistic.access.concept;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Condition {
    public static Condition Always = new Condition() { // from class: cooperation.qzone.statistic.access.concept.Condition.1
        @Override // cooperation.qzone.statistic.access.concept.Condition
        public boolean meet(Collector collector) {
            return true;
        }
    };

    public abstract boolean meet(Collector collector);
}
