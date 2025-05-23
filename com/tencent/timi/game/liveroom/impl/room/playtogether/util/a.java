package com.tencent.timi.game.liveroom.impl.room.playtogether.util;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a,\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a8\u0006\t"}, d2 = {"", VirtualAppProxy.KEY_GAME_ID, "", "roomId", "Lkotlin/Function1;", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "", "cb", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/util/a$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.playtogether.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9950a implements IResultListener<GetAnchorRoomInfoRequest.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<GetAnchorRoomInfoRequest.a, Unit> f378359a;

        /* JADX WARN: Multi-variable type inference failed */
        C9950a(Function1<? super GetAnchorRoomInfoRequest.a, Unit> function1) {
            this.f378359a = function1;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GetAnchorRoomInfoRequest.a result) {
            this.f378359a.invoke(result);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            this.f378359a.invoke(null);
            QLog.e("AnchorUtils", 1, "errorCode: " + errorCode + "; errorMessage: " + errorMessage);
        }
    }

    public static final void a(int i3, long j3, @NotNull Function1<? super GetAnchorRoomInfoRequest.a, Unit> cb5) {
        long j16;
        Intrinsics.checkNotNullParameter(cb5, "cb");
        jg4.h n3 = ((jg4.b) mm4.b.b(jg4.b.class)).n(j3);
        if (n3 != null) {
            j16 = n3.getAnchorUid();
        } else {
            j16 = 0;
        }
        GetAnchorRoomInfoRequest.f377853a.a(j16, i3, j3, new C9950a(cb5));
    }
}
