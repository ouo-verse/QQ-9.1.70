package com.tencent.state.square.location;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasStatusTaskInfoService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.status.FinishStatusInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/location/MotionObserver;", "", "()V", "requestMotionUnlock", "", "status", "", "richStatus", "observer", "Lcom/tencent/state/square/location/IMotionObserver;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MotionObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MotionObserver";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/location/MotionObserver$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final String getTAG() {
            return MotionObserver.TAG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void requestMotionUnlock(int status, int richStatus, final IMotionObserver observer) {
        new VasStatusTaskInfoService().request(status, richStatus, new ResultCallback<FinishStatusInfo>() { // from class: com.tencent.state.square.location.MotionObserver$requestMotionUnlock$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), MotionObserver.INSTANCE.getTAG(), "error: " + error + ", message: " + message, null, 4, null);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(FinishStatusInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                IMotionObserver iMotionObserver = IMotionObserver.this;
                if (iMotionObserver != null) {
                    iMotionObserver.notification(result.getTaskInfo(), result.getFinish());
                }
            }
        });
    }
}
