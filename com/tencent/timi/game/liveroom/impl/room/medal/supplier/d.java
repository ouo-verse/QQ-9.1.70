package com.tencent.timi.game.liveroom.impl.room.medal.supplier;

import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.h;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/supplier/d;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/supplier/BaseMsgMedalInfoSupplier;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "Lcom/tencent/timi/game/liveroom/impl/room/medal/e$a;", "callback", "", "a", "Lvj4/a;", "f", "Lvj4/a;", "msgParser", "", "roomId", "", "roomType", "", "appId", "<init>", "(JILjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d extends BaseMsgMedalInfoSupplier {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final vj4.a msgParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(long j3, int i3, @NotNull String appId) {
        super(j3, i3, appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.msgParser = new vj4.a();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.e
    public void a(@NotNull f msg2, @NotNull e.a callback) {
        Long l3;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(msg2 instanceof h)) {
            AegisLogger.INSTANCE.i(e(), "getMedalInfoAsync", "not NormalLiveMessage=" + msg2);
            callback.a(msg2, null);
            return;
        }
        h hVar = (h) msg2;
        LiveMessageData.SpeakerInfo speakerInfo = hVar.b().mSpeakerInfo;
        if (speakerInfo != null) {
            l3 = Long.valueOf(speakerInfo.mSpeakId);
        } else {
            l3 = null;
        }
        if (l3 == null) {
            callback.a(msg2, null);
            AegisLogger.INSTANCE.e(e(), "getMedalInfoAsync", "uid is null");
            return;
        }
        AegisLogger.INSTANCE.i(e(), "getMedalInfoAsync", "getMedalInfoFromMsg: userId=" + l3 + ",roomType=" + getRoomType());
        com.tencent.mobileqq.qqlive.widget.chat.data.b a16 = this.msgParser.a(l3.longValue(), hVar.b());
        if (a16 != null) {
            g(msg2, a16);
            callback.a(msg2, a16);
        } else {
            c(l3.longValue(), msg2, callback);
        }
    }
}
