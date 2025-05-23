package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Sampler;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LinearSampler extends Sampler {
    protected Random random = new Random(System.currentTimeMillis());
    protected int frequency = 1;

    public LinearSampler(int i3) {
        setFrequency(i3);
    }

    @Override // cooperation.qzone.statistic.access.concept.Sampler
    public int getFrequency() {
        return this.frequency;
    }

    @Override // cooperation.qzone.statistic.access.concept.Sampler
    public boolean sample() {
        if (this.random.nextInt(this.frequency) < 1) {
            return true;
        }
        return false;
    }

    public void setFrequency(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        this.frequency = i3;
    }
}
