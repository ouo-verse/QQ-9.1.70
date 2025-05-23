package com.tencent.component.hdasync;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class HdAsyncAction extends BaseAction {
    public HdAsyncAction(Looper looper) {
        super(looper);
    }

    @Override // com.tencent.component.hdasync.BaseAction
    public abstract HdAsyncResult call(Object obj);

    public HdAsyncResult doNext(boolean z16, Object obj) {
        return new HdAsyncResult(z16, obj);
    }

    public HdAsyncAction(ExecutorService executorService) {
        super(executorService);
    }

    public HdAsyncResult doNext(boolean z16) {
        return doNext(z16, null);
    }
}
