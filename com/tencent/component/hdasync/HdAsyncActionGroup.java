package com.tencent.component.hdasync;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes32.dex */
public class HdAsyncActionGroup {
    private LinkedList<ActionArray> actionList = new LinkedList<>();
    private AtomicInteger actionCount = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ActionArray {
        BaseAction[] array;

        public ActionArray() {
        }
    }

    public boolean allActionFinish() {
        return this.actionCount.get() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void both(HdAsyncAction... hdAsyncActionArr) {
        ActionArray actionArray = new ActionArray();
        actionArray.array = hdAsyncActionArr;
        this.actionCount.addAndGet(hdAsyncActionArr.length);
        this.actionList.add(actionArray);
    }

    public void clear() {
        LinkedList<ActionArray> linkedList = this.actionList;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void delay(HdAsyncAction hdAsyncAction, long j3) {
        this.actionCount.incrementAndGet();
        hdAsyncAction.delay = j3;
        ActionArray actionArray = new ActionArray();
        actionArray.array = r4;
        HdAsyncAction[] hdAsyncActionArr = {hdAsyncAction};
        this.actionList.add(actionArray);
    }

    public void finishOneAction() {
        this.actionCount.decrementAndGet();
    }

    public ActionArray poll() {
        if (this.actionList.isEmpty()) {
            return null;
        }
        return this.actionList.poll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void then(HdAsyncAction hdAsyncAction) {
        this.actionCount.incrementAndGet();
        ActionArray actionArray = new ActionArray();
        actionArray.array = r1;
        HdAsyncAction[] hdAsyncActionArr = {hdAsyncAction};
        this.actionList.add(actionArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void append(HdAsyncActionGroup hdAsyncActionGroup) {
        if (hdAsyncActionGroup != null) {
            this.actionCount.addAndGet(hdAsyncActionGroup.actionCount.get());
            this.actionList.addAll(hdAsyncActionGroup.actionList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void both(HdAsyncCountDownAction... hdAsyncCountDownActionArr) {
        ActionArray actionArray = new ActionArray();
        actionArray.array = hdAsyncCountDownActionArr;
        this.actionCount.addAndGet(hdAsyncCountDownActionArr.length);
        this.actionList.add(actionArray);
    }
}
