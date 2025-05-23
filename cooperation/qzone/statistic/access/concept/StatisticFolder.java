package cooperation.qzone.statistic.access.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes28.dex */
public class StatisticFolder {
    protected volatile ConcurrentLinkedQueue<Statistic> statistics = new ConcurrentLinkedQueue<>();

    public Statistic poll() {
        return this.statistics.poll();
    }

    public List<Statistic> pollAll() {
        return poll(size());
    }

    public void put(Statistic statistic) {
        this.statistics.add(statistic);
    }

    public int size() {
        return this.statistics.size();
    }

    public List<Statistic> poll(int i3) {
        if (i3 < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(i3, size());
        for (int i16 = 0; i16 < min; i16++) {
            Statistic poll = poll();
            if (poll != null) {
                arrayList.add(poll);
            }
        }
        return arrayList;
    }
}
