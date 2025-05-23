package com.tencent.component.hdasync;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class HdAsyncCountDownAction extends BaseAction {
    private AtomicInteger countDownNum;

    public HdAsyncCountDownAction(Looper looper) {
        super(looper);
    }

    @Override // com.tencent.component.hdasync.BaseAction
    public abstract HdAsyncCountDownResult call(Object obj);

    public HdAsyncCountDownResult doNextByCountDown(boolean z16, Object obj) {
        AtomicInteger atomicInteger;
        if (z16 && (atomicInteger = this.countDownNum) != null) {
            if (atomicInteger.decrementAndGet() == 0) {
                return new HdAsyncCountDownResult(true, obj);
            }
            return new HdAsyncCountDownResult(false, obj);
        }
        return new HdAsyncCountDownResult(false, obj);
    }

    public void setCountDownNum(AtomicInteger atomicInteger) {
        this.countDownNum = atomicInteger;
    }

    public HdAsyncCountDownResult doNextByCountDown(boolean z16) {
        return doNextByCountDown(z16, null);
    }
}
