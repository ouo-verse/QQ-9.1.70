package com.tencent.state.service;

import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ:\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/service/VasPublishStatusService;", "", "()V", "setCustomTextService", "Lcom/tencent/state/service/VasSetCustomTextService;", "statusService", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "destroy", "", "init", "requestSetStatus", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "motionId", "", "customText", "", "avatarLocation", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/service/SetStatusResult;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasPublishStatusService {
    private static final String TAG = "VasPublishStatusService";
    private final VasSetCustomTextService setCustomTextService = new VasSetCustomTextService();
    private ISquareOnlineStatusService statusService;

    public final void destroy() {
        ISquareOnlineStatusService iSquareOnlineStatusService = this.statusService;
        if (iSquareOnlineStatusService != null) {
            iSquareOnlineStatusService.destroy();
        }
    }

    public final void init() {
        ISquareOnlineStatusService createStatusService = Square.INSTANCE.getConfig().getServiceProvider().createStatusService();
        this.statusService = createStatusService;
        if (createStatusService != null) {
            createStatusService.init();
        }
    }

    public final void requestSetStatus(OnlineStatus status, int motionId, String customText, AvatarLocationInfo avatarLocation, Function1<? super SetStatusResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(avatarLocation, "avatarLocation");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.setCustomTextService.requestSetCustomText(status, motionId, customText, avatarLocation, new VasPublishStatusService$requestSetStatus$1(this, callback, status));
    }
}
