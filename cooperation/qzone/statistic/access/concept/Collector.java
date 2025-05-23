package cooperation.qzone.statistic.access.concept;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.statistic.access.WnsKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Collector implements Runnable {
    public static final String TAG = "Statistic.Collector";
    protected Thread thread;
    protected Condition condition = Condition.Always;
    protected Sampler sampler = Sampler.All;
    protected Assembler assembler = Assembler.Array;
    protected Deliverer deliverer = Deliverer.Console;
    protected List<Statistic> lastStatistics = new ArrayList();
    protected volatile boolean isWorking = true;
    protected volatile long latestWorkTime = 0;
    protected long sleepTimespan = 3000;
    protected volatile boolean needForceDeliver = false;
    protected volatile boolean flush = false;
    protected StatisticFolder statisticFolder = new StatisticFolder();

    public void collect(Statistic statistic) {
        this.statisticFolder.put(statistic);
    }

    public void doWork() {
        int frequency;
        haveArest();
        if (this.condition.meet(this) || this.flush) {
            int i3 = 0;
            this.flush = false;
            List<Statistic> pollAll = this.statisticFolder.pollAll();
            if (pollAll != null && pollAll.size() > 0) {
                boolean z16 = true;
                if (this.needForceDeliver || getSampler() == null) {
                    frequency = 1;
                } else {
                    frequency = getSampler().getFrequency();
                }
                Iterator<Statistic> it = pollAll.iterator();
                while (it.hasNext()) {
                    it.next().setValue(WnsKeys.Frequency, Integer.valueOf(frequency));
                }
                Object[] array = pollAll.toArray();
                if (this.lastStatistics.size() > 0) {
                    pollAll.addAll(this.lastStatistics);
                }
                this.lastStatistics.clear();
                for (Object obj : array) {
                    this.lastStatistics.add((Statistic) obj);
                }
                String assemble = getAssembler().assemble(pollAll);
                if (assemble != null && assemble.length() > 0) {
                    if (!this.needForceDeliver && getSampler() != null) {
                        z16 = getSampler().sample();
                    }
                    this.needForceDeliver = false;
                    if (z16) {
                        i3 = getDeliverer().deliver(assemble, pollAll.size());
                    }
                    if (i3 == 0) {
                        this.lastStatistics.clear();
                    }
                    recordLatestWorkTime();
                }
            }
        }
    }

    public void flush() {
        this.flush = true;
        Thread thread = this.thread;
        if (thread != null && thread.isAlive()) {
            this.thread.interrupt();
        }
    }

    public synchronized void forceDeliver() {
        this.needForceDeliver = true;
    }

    public Assembler getAssembler() {
        return this.assembler;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public Deliverer getDeliverer() {
        return this.deliverer;
    }

    public long getLatestWorkTime() {
        return this.latestWorkTime;
    }

    public Sampler getSampler() {
        return this.sampler;
    }

    public long getSleepTimespan() {
        return this.sleepTimespan;
    }

    public StatisticFolder getStatistics() {
        return this.statisticFolder;
    }

    public void haveArest() {
        long j3 = this.sleepTimespan;
        if (j3 > 0) {
            try {
                LockMethodProxy.sleep(j3);
            } catch (InterruptedException unused) {
            }
        }
    }

    public boolean isStopped() {
        return !this.isWorking;
    }

    public void onStop() {
        doWork();
    }

    public void recordLatestWorkTime() {
        this.latestWorkTime = System.currentTimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.isWorking) {
            doWork();
        }
        onStop();
    }

    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public void setSampler(Sampler sampler) {
        this.sampler = sampler;
    }

    public void setSleepTimespan(long j3) {
        this.sleepTimespan = j3;
    }

    public void setStatistics(StatisticFolder statisticFolder) {
        this.statisticFolder = statisticFolder;
    }

    public void startWork() {
        Thread thread = this.thread;
        if (thread != null && thread.isAlive()) {
            this.isWorking = false;
            this.thread.interrupt();
        }
        this.thread = new BaseThread(this, "com.qzone.statistic.access.concept");
        this.isWorking = true;
        this.thread.setName(TAG);
        if (!this.thread.isAlive()) {
            this.thread.start();
        }
        this.latestWorkTime = System.currentTimeMillis();
    }
}
