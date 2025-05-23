package com.tencent.component.hdasync;

import android.os.Handler;
import android.os.Message;
import com.tencent.component.hdasync.HdAsyncActionGroup;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes32.dex */
public class HdAsync {
    public static final String TAG = "HdAsync";
    private Object host;
    private boolean isCalling = false;
    private boolean isCanceled = false;
    private boolean isDone = false;
    private HdAsyncActionGroup actionGroup = new HdAsyncActionGroup();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Data {
        BaseAction action;
        Object args;

        Data() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class HandlerCallback implements Handler.Callback {
        HandlerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj = message.obj;
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            BaseResult call = data.action.call(data.args);
            HdAsync.this.actionGroup.finishOneAction();
            if (call != null) {
                HdAsync.this.executeAction(call.value, call.needNext);
            }
            return false;
        }
    }

    HdAsync(Object obj) {
        this.host = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void executeAction(Object obj, boolean z16) {
        executeActionWithoutLock(obj, z16);
    }

    private void executeActionWithoutLock(Object obj, boolean z16) {
        HdAsyncActionGroup.ActionArray poll;
        HdAsyncActionGroup hdAsyncActionGroup = this.actionGroup;
        if (hdAsyncActionGroup != null && !hdAsyncActionGroup.allActionFinish()) {
            if (!z16 || this.isCanceled || this.host == null || (poll = this.actionGroup.poll()) == null) {
                return;
            }
            for (BaseAction baseAction : poll.array) {
                if (baseAction.looper != null) {
                    baseAction.setHdAsync(this);
                    Handler handler = new Handler(baseAction.looper, new HandlerCallback());
                    Message obtain = Message.obtain();
                    Data data = new Data();
                    data.action = baseAction;
                    data.args = obj;
                    obtain.obj = data;
                    long j3 = baseAction.delay;
                    if (j3 == 0) {
                        handler.sendMessage(obtain);
                    } else {
                        handler.sendMessageDelayed(obtain, j3);
                    }
                }
            }
            return;
        }
        this.isCalling = false;
        this.isDone = true;
        destroyWithoutLock();
    }

    public static HdAsync with(Object obj) {
        return new HdAsync(obj);
    }

    public synchronized HdAsync append(HdAsync hdAsync) {
        if (hdAsync != null) {
            this.actionGroup.append(hdAsync.actionGroup);
        }
        return this;
    }

    public synchronized HdAsync both(HdAsyncAction... hdAsyncActionArr) {
        if (hdAsyncActionArr != null) {
            for (HdAsyncAction hdAsyncAction : hdAsyncActionArr) {
                if (hdAsyncAction != null) {
                    hdAsyncAction.setHost(this.host);
                }
            }
            this.actionGroup.both(hdAsyncActionArr);
        }
        return this;
    }

    public synchronized HdAsync call() {
        this.isCanceled = false;
        if (!this.isCalling) {
            this.isCalling = true;
            executeActionWithoutLock(null, true);
        }
        return this;
    }

    public synchronized void cancel() {
        this.isCanceled = true;
        this.isCalling = false;
        this.host = null;
    }

    public synchronized HdAsync delay(HdAsyncAction hdAsyncAction, long j3) {
        if (hdAsyncAction != null) {
            hdAsyncAction.setHost(this.host);
            this.actionGroup.delay(hdAsyncAction, j3);
        }
        return this;
    }

    public synchronized void destroy() {
        destroyWithoutLock();
    }

    public void destroyWithoutLock() {
        HdAsyncActionGroup hdAsyncActionGroup = this.actionGroup;
        if (hdAsyncActionGroup != null) {
            hdAsyncActionGroup.clear();
        }
    }

    public boolean isDone() {
        return this.isDone;
    }

    public HdAsync resume() {
        call();
        return this;
    }

    public synchronized HdAsync then(HdAsyncAction hdAsyncAction) {
        if (hdAsyncAction != null) {
            hdAsyncAction.setHost(this.host);
            this.actionGroup.then(hdAsyncAction);
        }
        return this;
    }

    public HdAsync resume(Object obj) {
        call(obj);
        return this;
    }

    public synchronized HdAsync both(int i3, HdAsyncCountDownAction... hdAsyncCountDownActionArr) {
        if (hdAsyncCountDownActionArr != null) {
            AtomicInteger atomicInteger = new AtomicInteger(i3);
            for (HdAsyncCountDownAction hdAsyncCountDownAction : hdAsyncCountDownActionArr) {
                hdAsyncCountDownAction.setHost(this.host);
                hdAsyncCountDownAction.setCountDownNum(atomicInteger);
            }
            this.actionGroup.both(hdAsyncCountDownActionArr);
        }
        return this;
    }

    public synchronized HdAsync call(Object obj) {
        this.isCanceled = false;
        if (!this.isCalling) {
            this.isCalling = true;
            executeActionWithoutLock(obj, true);
        }
        return this;
    }
}
