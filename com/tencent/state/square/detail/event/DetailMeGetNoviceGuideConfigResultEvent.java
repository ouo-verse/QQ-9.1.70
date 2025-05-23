package com.tencent.state.square.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/detail/event/DetailMeGetNoviceGuideConfigResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "registered", "", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "(ZLcom/tencent/state/square/guide/SquareNoviceGuideConfig;)V", "getConfig", "()Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "getRegistered", "()Z", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailMeGetNoviceGuideConfigResultEvent extends SimpleBaseEvent {
    private final SquareNoviceGuideConfig config;
    private final boolean registered;

    public DetailMeGetNoviceGuideConfigResultEvent(boolean z16, SquareNoviceGuideConfig squareNoviceGuideConfig) {
        this.registered = z16;
        this.config = squareNoviceGuideConfig;
    }

    public final SquareNoviceGuideConfig getConfig() {
        return this.config;
    }

    public final boolean getRegistered() {
        return this.registered;
    }
}
