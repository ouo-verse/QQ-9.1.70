package com.tencent.timi.game.liveroom.impl.room.follow;

import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J;\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rJ\u0006\u0010\u0010\u001a\u00020\fJ\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R;\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/follow/a;", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "roomId", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "a", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/timi/game/liveroom/impl/room/follow/FollowPushMsgReceiver;", "receiver", "b", "c", "followPushMessage", "onFollowReceive", "", "errCode", "", "errMsg", "onFail", "Lfp4/c;", "msgInfo", "onPush", "d", "J", "e", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "room", "Ljg4/b;", "f", "Ljg4/b;", "service", h.F, "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "i", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements IQQLiveReceiveFollowListener, g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ILiveRoom room;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private jg4.b service = (jg4.b) mm4.b.b(jg4.b.class);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super FollowPushMessage, Unit> receiver;

    private final ILiveRoom a(long roomId) {
        IQQLiveAnchorRoom iQQLiveAnchorRoom;
        ILiveRoom iLiveRoom = this.room;
        boolean z16 = false;
        if (iLiveRoom != null && !iLiveRoom.isDestroyed()) {
            z16 = true;
        }
        if (z16) {
            return this.room;
        }
        jg4.b bVar = this.service;
        IAudienceRoom iAudienceRoom = null;
        if (bVar != null) {
            iQQLiveAnchorRoom = bVar.J3(roomId);
        } else {
            iQQLiveAnchorRoom = null;
        }
        this.room = iQQLiveAnchorRoom;
        if (iQQLiveAnchorRoom == null) {
            jg4.b bVar2 = this.service;
            if (bVar2 != null) {
                iAudienceRoom = bVar2.y(roomId);
            }
            this.room = iAudienceRoom;
        }
        return this.room;
    }

    public final void b(long roomId, @Nullable Function1<? super FollowPushMessage, Unit> receiver) {
        c cVar = c.f272176a;
        if (cVar.d().t()) {
            this.receiver = receiver;
            f z16 = c.z(cVar, roomId, 0, 2, null);
            if (z16 != null) {
                z16.p(234, this);
            }
            f z17 = c.z(cVar, roomId, 0, 2, null);
            if (z17 != null) {
                z17.p(263, this);
                return;
            }
            return;
        }
        this.receiver = receiver;
        ILiveRoom a16 = a(roomId);
        if (a16 != null) {
            a16.registerFollowMessageListener(this);
        }
    }

    public final void c() {
        this.receiver = null;
        ILiveRoom iLiveRoom = this.room;
        if (iLiveRoom != null) {
            iLiveRoom.unRegisterFollowMessageListener(this);
        }
        this.room = null;
        f z16 = c.z(c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
    public void onFail(int errCode, @Nullable String errMsg) {
        AegisLogger.INSTANCE.w("Audience|FollowPushMgr", "onFail", "errCode=" + errCode + ", errMsg=" + errMsg);
    }

    @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
    public void onFollowReceive(@Nullable FollowPushMessage followPushMessage) {
        String str;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (followPushMessage != null) {
            str = followPushMessage.nick;
        } else {
            str = null;
        }
        companion.i("Audience|FollowPushMgr", "onFollowReceive", "nick=" + str);
        Function1<? super FollowPushMessage, Unit> function1 = this.receiver;
        if (function1 != null) {
            function1.invoke(followPushMessage);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        hr4.f j3 = com.tencent.mobileqq.qqlive.sail.push.a.j(msgInfo);
        if (j3 != null) {
            FollowPushMessage followPushMessage = new FollowPushMessage();
            followPushMessage.nick = j3.f406108b;
            followPushMessage.icon = j3.f406111e;
            followPushMessage.toUid = j3.f406109c;
            followPushMessage.uid = j3.f406107a;
            followPushMessage.type = j3.f406110d;
            AegisLogger.INSTANCE.i("Audience|FollowPushMgr", "onPush", "receive follow msg, " + followPushMessage);
            Function1<? super FollowPushMessage, Unit> function1 = this.receiver;
            if (function1 != null) {
                function1.invoke(followPushMessage);
            }
        }
    }
}
