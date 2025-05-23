package cooperation.qzone.statistic.access.concept;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Sampler {
    public static Sampler All = new Sampler() { // from class: cooperation.qzone.statistic.access.concept.Sampler.1
        @Override // cooperation.qzone.statistic.access.concept.Sampler
        public boolean sample() {
            return true;
        }
    };

    public int getFrequency() {
        return 1;
    }

    public abstract boolean sample();
}
