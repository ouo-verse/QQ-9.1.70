package ex0;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000b\u0018\u0000 \n2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lex0/a;", "Lcx0/a;", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "liveRoom", "", "e", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "cb", "a", "b", "d", "ex0/a$b", "Lex0/a$b;", "pushCallback", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "mLiveRoom", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "c", "Ljava/util/HashSet;", "listenerPool", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a implements cx0.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ILiveRoom mLiveRoom;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b pushCallback = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<IQQCmdPushCallback> listenerPool = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ex0/a$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            Iterator it = new HashSet(a.this.listenerPool).iterator();
            while (it.hasNext()) {
                ((IQQCmdPushCallback) it.next()).onFail(errCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            if (data != null) {
                try {
                    dx0.a c16 = dx0.a.c(data);
                    Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                    Iterator it = new HashSet(a.this.listenerPool).iterator();
                    while (it.hasNext()) {
                        ((IQQCmdPushCallback) it.next()).onReceive(c16.f395146c);
                    }
                    return;
                } catch (InvalidProtocolBufferNanoException e16) {
                    g.c("ICGamePushServiceImpl_", 1, "parse data error", e16);
                    return;
                }
            }
            g.b("ICGamePushServiceImpl_", 4, "receive data null");
        }
    }

    @Override // cx0.a
    public void a(@NotNull IQQCmdPushCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.listenerPool.add(cb5);
        g.g("ICGamePushServiceImpl_", 1, "registerPushCallback cb:" + cb5);
    }

    @Override // cx0.a
    public void b(@NotNull IQQCmdPushCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.listenerPool.remove(cb5);
        g.g("ICGamePushServiceImpl_", 1, "unRegisterPushCallback cb:" + cb5);
    }

    public void d() {
        Long l3;
        BaseRoomInfo roomInfo;
        ILiveRoom iLiveRoom = this.mLiveRoom;
        if (iLiveRoom != null && (roomInfo = iLiveRoom.getRoomInfo()) != null) {
            l3 = Long.valueOf(roomInfo.getRoomId());
        } else {
            l3 = null;
        }
        g.g("ICGamePushServiceImpl_", 1, "destroy, roomId:" + l3);
        this.listenerPool.clear();
        ILiveRoom iLiveRoom2 = this.mLiveRoom;
        if (iLiveRoom2 != null) {
            iLiveRoom2.unRegisterLivePushChannel(this.pushCallback);
        }
        this.mLiveRoom = null;
    }

    public void e(@NotNull ILiveRoom liveRoom) {
        Long l3;
        Intrinsics.checkNotNullParameter(liveRoom, "liveRoom");
        ILiveRoom iLiveRoom = this.mLiveRoom;
        if (iLiveRoom != null) {
            iLiveRoom.unRegisterLivePushChannel(this.pushCallback);
        }
        this.mLiveRoom = liveRoom;
        liveRoom.registerLivePushChannel(239, this.pushCallback);
        BaseRoomInfo roomInfo = liveRoom.getRoomInfo();
        if (roomInfo != null) {
            l3 = Long.valueOf(roomInfo.getRoomId());
        } else {
            l3 = null;
        }
        g.g("ICGamePushServiceImpl_", 1, "init finish, roomId:" + l3);
    }
}
