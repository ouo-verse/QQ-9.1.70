package com.tencent.mobileqq.gamecenter.nt.aio.bottom;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgNotifyDataEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GameTypeReceived", "Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgNotifyDataEvent$GameTypeReceived;", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public abstract class GameMsgNotifyDataEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgNotifyDataEvent$GameTypeReceived;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgNotifyDataEvent;", "", "d", "I", "a", "()I", "gameType", "<init>", "(I)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class GameTypeReceived extends GameMsgNotifyDataEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int gameType;

        public GameTypeReceived(int i3) {
            super(null);
            this.gameType = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getGameType() {
            return this.gameType;
        }
    }

    public /* synthetic */ GameMsgNotifyDataEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GameMsgNotifyDataEvent() {
    }
}
