package com.tencent.state.square.invite;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\"\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH&J\u001e\u0010\u0002\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/invite/ISquareInviteManager;", "", "getInviteStatus", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "", "isForceRequest", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "uin", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareInviteManager {
    SquareMultiMotionDetailData getInviteStatus();

    void getInviteStatus(String uin, ResultCallback<SquareMultiMotionDetailData> callback);

    void getInviteStatus(boolean isForceRequest, ResultCallback<SquareMultiMotionDetailData> callback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void getInviteStatus$default(ISquareInviteManager iSquareInviteManager, boolean z16, ResultCallback resultCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    resultCallback = null;
                }
                iSquareInviteManager.getInviteStatus(z16, (ResultCallback<SquareMultiMotionDetailData>) resultCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInviteStatus");
        }
    }
}
