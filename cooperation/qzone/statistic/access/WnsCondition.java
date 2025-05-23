package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Collector;
import cooperation.qzone.statistic.access.concept.Condition;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WnsCondition extends Condition {
    protected long timespan = 30000;
    protected int maxsize = 50;
    protected boolean enableWorkOnExit = true;

    public WnsCondition(long j3, int i3, boolean z16) {
        setTimespan(j3);
        setMaxsize(i3);
        setWorkOnExitEnabled(z16);
    }

    public int getMaxsize() {
        return this.maxsize;
    }

    public long getTimespan() {
        return this.timespan;
    }

    public boolean isWorkOnExitEnabled() {
        return this.enableWorkOnExit;
    }

    @Override // cooperation.qzone.statistic.access.concept.Condition
    public boolean meet(Collector collector) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (collector.getStatistics().size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (System.currentTimeMillis() - collector.getLatestWorkTime() > this.timespan) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (collector.getStatistics().size() >= this.maxsize) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (this.enableWorkOnExit && collector.isStopped()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z16 && (z17 || z18 || z19)) {
            return true;
        }
        return false;
    }

    public void setMaxsize(int i3) {
        this.maxsize = i3;
    }

    public void setTimespan(long j3) {
        this.timespan = j3;
    }

    public void setWorkOnExitEnabled(boolean z16) {
        this.enableWorkOnExit = z16;
    }
}
