package com.tencent.state.square.invite;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasMultiMotionService;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u001e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/invite/SquareInviteManager;", "Lcom/tencent/state/square/invite/ISquareInviteManager;", "()V", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "currentStatus", "isStatusRequesting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "forceGetInviteStatus", "", "callback", "getInviteStatus", "isForceRequest", "", "uin", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareInviteManager implements ISquareInviteManager {
    private static final String TAG = "SquareInviteManager";
    private SquareMultiMotionDetailData currentStatus;
    private final AtomicBoolean isStatusRequesting = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<ResultCallback<SquareMultiMotionDetailData>> callbacks = new CopyOnWriteArrayList<>();

    @Override // com.tencent.state.square.invite.ISquareInviteManager
    public void getInviteStatus(boolean isForceRequest, ResultCallback<SquareMultiMotionDetailData> callback) {
        if (isForceRequest) {
            this.currentStatus = null;
            forceGetInviteStatus(callback);
            return;
        }
        SquareMultiMotionDetailData squareMultiMotionDetailData = this.currentStatus;
        if (squareMultiMotionDetailData == null) {
            forceGetInviteStatus(callback);
        } else if (callback != null) {
            callback.onResultSuccess(squareMultiMotionDetailData);
        }
    }

    private final void forceGetInviteStatus(ResultCallback<SquareMultiMotionDetailData> callback) {
        if (callback != null) {
            this.callbacks.add(callback);
        }
        if (this.isStatusRequesting.compareAndSet(false, true)) {
            VasMultiMotionService.getInviteDetail$default(VasMultiMotionService.INSTANCE, null, null, new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.invite.SquareInviteManager$forceGetInviteStatus$2
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    CopyOnWriteArrayList copyOnWriteArrayList2;
                    AtomicBoolean atomicBoolean;
                    copyOnWriteArrayList = SquareInviteManager.this.callbacks;
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((ResultCallback) it.next()).onResultFailure(error, message);
                    }
                    copyOnWriteArrayList2 = SquareInviteManager.this.callbacks;
                    copyOnWriteArrayList2.clear();
                    atomicBoolean = SquareInviteManager.this.isStatusRequesting;
                    atomicBoolean.set(false);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(SquareMultiMotionDetailData result) {
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    CopyOnWriteArrayList copyOnWriteArrayList2;
                    AtomicBoolean atomicBoolean;
                    Intrinsics.checkNotNullParameter(result, "result");
                    SquareInviteManager.this.currentStatus = result;
                    copyOnWriteArrayList = SquareInviteManager.this.callbacks;
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((ResultCallback) it.next()).onResultSuccess(result);
                    }
                    copyOnWriteArrayList2 = SquareInviteManager.this.callbacks;
                    copyOnWriteArrayList2.clear();
                    atomicBoolean = SquareInviteManager.this.isStatusRequesting;
                    atomicBoolean.set(false);
                }
            }, 3, null);
        }
    }

    @Override // com.tencent.state.square.invite.ISquareInviteManager
    public void getInviteStatus(String uin, ResultCallback<SquareMultiMotionDetailData> callback) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasMultiMotionService vasMultiMotionService = VasMultiMotionService.INSTANCE;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        VasMultiMotionService.getInviteDetail$default(vasMultiMotionService, longOrNull, null, callback, 2, null);
    }

    @Override // com.tencent.state.square.invite.ISquareInviteManager
    /* renamed from: getInviteStatus, reason: from getter */
    public SquareMultiMotionDetailData getCurrentStatus() {
        return this.currentStatus;
    }
}
