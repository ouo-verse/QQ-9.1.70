package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Subscriber;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JobController extends Subscriber.EventBatchSubscriber {
    private static final String TAG = "async.boss.JobController";
    private Boss mBoss;
    private JobControlHandler mDefaultHandler;
    private final CopyOnWriteArrayList<JobControlHandler> mHandlers = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CancelCommand implements Dispatcher.Command {
        public final Future future;
        public final boolean mayInterrupt;

        public CancelCommand(Future future, boolean z16) {
            AssertUtils.checkNotNull(future);
            this.future = future;
            this.mayInterrupt = z16;
        }

        public String toString() {
            return "CancelCommand{job=" + ((Worker) this.future).getJob() + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DoneEvent implements Dispatcher.Event {
        public final Worker worker;

        public DoneEvent(Worker worker) {
            this.worker = worker;
        }
    }

    public JobController(Boss boss) {
        AssertUtils.checkNotNull(boss);
        this.mBoss = boss;
        this.mDefaultHandler = new DefaultJobControlHandler();
    }

    @Override // com.tribe.async.dispatch.Subscriber
    public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list) {
        list.add(Worker.class);
        list.add(CancelCommand.class);
        list.add(DoneEvent.class);
    }

    public JobControlHandler getDefaultHandler() {
        return this.mDefaultHandler;
    }

    @Override // com.tribe.async.dispatch.Subscriber.IDispatchableListener
    public void onDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
        boolean z16 = true;
        if (dispatchable instanceof Worker) {
            Worker worker = (Worker) dispatchable;
            Job job = worker.getJob();
            AssertUtils.checkNotNull(job);
            Iterator<JobControlHandler> it = this.mHandlers.iterator();
            while (true) {
                if (it.hasNext()) {
                    JobControlHandler next = it.next();
                    if (next.accept(job)) {
                        next.handleExecute(this.mBoss.getExecutors(), worker);
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.mDefaultHandler.handleExecute(this.mBoss.getExecutors(), worker);
                return;
            }
            return;
        }
        if (dispatchable instanceof CancelCommand) {
            CancelCommand cancelCommand = (CancelCommand) dispatchable;
            AssertUtils.checkNotNull(cancelCommand.future);
            Job job2 = ((Worker) cancelCommand.future).getJob();
            AssertUtils.checkNotNull(job2);
            Iterator<JobControlHandler> it5 = this.mHandlers.iterator();
            while (true) {
                if (it5.hasNext()) {
                    JobControlHandler next2 = it5.next();
                    if (next2.accept(job2)) {
                        next2.handleCancel(cancelCommand);
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.mDefaultHandler.handleCancel(cancelCommand);
                return;
            }
            return;
        }
        if (dispatchable instanceof DoneEvent) {
            Worker worker2 = ((DoneEvent) dispatchable).worker;
            AssertUtils.checkNotNull(worker2);
            Job job3 = worker2.getJob();
            AssertUtils.checkNotNull(job3);
            Iterator<JobControlHandler> it6 = this.mHandlers.iterator();
            while (true) {
                if (it6.hasNext()) {
                    JobControlHandler next3 = it6.next();
                    if (next3.accept(job3)) {
                        next3.handleDone(worker2);
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.mDefaultHandler.handleDone(worker2);
            }
        }
    }

    public void registerJobControlHandler(JobControlHandler jobControlHandler) {
        AssertUtils.checkNotNull(jobControlHandler);
        if (!this.mHandlers.contains(jobControlHandler)) {
            this.mHandlers.add(jobControlHandler);
        }
    }

    public void unRegisterDispatchHandler(JobControlHandler jobControlHandler) {
        AssertUtils.checkNotNull(jobControlHandler);
        this.mHandlers.remove(jobControlHandler);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DefaultJobControlHandler implements JobControlHandler {
        @Override // com.tribe.async.async.JobControlHandler
        public boolean accept(@NonNull Job job) {
            return true;
        }

        @Override // com.tribe.async.async.JobControlHandler
        public void handleCancel(@NonNull CancelCommand cancelCommand) {
            Future future = cancelCommand.future;
            boolean z16 = cancelCommand.mayInterrupt;
            if (future != null) {
                future.cancel(z16);
            }
        }

        @Override // com.tribe.async.async.JobControlHandler
        public void handleExecute(@NonNull Executor[] executorArr, @NonNull Worker worker) {
            boolean z16;
            if (executorArr.length > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            AssertUtils.assertTrue(z16);
            Bosses.get().getExecutor(worker.getJobType()).execute(worker);
        }

        @Override // com.tribe.async.async.JobControlHandler
        public void handleDone(@NonNull Worker worker) {
        }
    }
}
