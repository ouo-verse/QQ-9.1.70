package org.junit.experimental;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.runner.Computer;
import org.junit.runner.Runner;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.RunnerScheduler;

/* loaded from: classes29.dex */
public class ParallelComputer extends Computer {
    private final boolean classes;
    private final boolean methods;

    public ParallelComputer(boolean z16, boolean z17) {
        this.classes = z16;
        this.methods = z17;
    }

    public static Computer classes() {
        return new ParallelComputer(true, false);
    }

    public static Computer methods() {
        return new ParallelComputer(false, true);
    }

    private static Runner parallelize(Runner runner) {
        if (runner instanceof ParentRunner) {
            ((ParentRunner) runner).setScheduler(new RunnerScheduler() { // from class: org.junit.experimental.ParallelComputer.1
                private final ExecutorService fService = ProxyExecutors.newCachedThreadPool();

                @Override // org.junit.runners.model.RunnerScheduler
                public void finished() {
                    try {
                        this.fService.shutdown();
                        this.fService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace(System.err);
                    }
                }

                @Override // org.junit.runners.model.RunnerScheduler
                public void schedule(Runnable runnable) {
                    this.fService.submit(runnable);
                }
            });
        }
        return runner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runner.Computer
    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> cls) throws Throwable {
        Runner runner = super.getRunner(runnerBuilder, cls);
        if (this.methods) {
            return parallelize(runner);
        }
        return runner;
    }

    @Override // org.junit.runner.Computer
    public Runner getSuite(RunnerBuilder runnerBuilder, Class<?>[] clsArr) throws InitializationError {
        Runner suite = super.getSuite(runnerBuilder, clsArr);
        if (this.classes) {
            return parallelize(suite);
        }
        return suite;
    }
}
