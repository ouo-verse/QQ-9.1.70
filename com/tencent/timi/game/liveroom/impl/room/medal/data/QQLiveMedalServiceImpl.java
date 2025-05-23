package com.tencent.timi.game.liveroom.impl.room.medal.data;

import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/data/QQLiveMedalServiceImpl;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/d;", "", "userId", "roomId", "", "roomType", "Lcom/tencent/timi/game/liveroom/impl/room/medal/d$a;", "callback", "", "a", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "b", "destroy", "Lcom/tencent/timi/game/liveroom/impl/room/medal/data/MedalRemoteDataSource;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/data/MedalRemoteDataSource;", "remoteDataSource", "Lcom/tencent/timi/game/liveroom/impl/room/medal/data/a;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/data/a;", "localDataSource", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveMedalServiceImpl implements com.tencent.timi.game.liveroom.impl.room.medal.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MedalRemoteDataSource remoteDataSource = new MedalRemoteDataSource();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a localDataSource = new a();

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.d
    public void a(final long userId, long roomId, final int roomType, @Nullable final d.a callback) {
        QLog.d("QQLiveMedalServiceImpl", 1, "getUserMedalAsync userId=" + userId + ",roomId:" + roomId + ",roomType=" + roomType);
        this.remoteDataSource.b(userId, roomId, roomType, new Function1<com.tencent.mobileqq.qqlive.widget.chat.data.b, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.data.QQLiveMedalServiceImpl$getUserMedalAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                a aVar;
                if (bVar != null) {
                    aVar = QQLiveMedalServiceImpl.this.localDataSource;
                    aVar.d(userId, roomType, bVar);
                }
                d.a aVar2 = callback;
                if (aVar2 != null) {
                    aVar2.a(bVar);
                }
            }
        });
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.d
    @Nullable
    public com.tencent.mobileqq.qqlive.widget.chat.data.b b(long userId, long roomId, int roomType) {
        QLog.d("QQLiveMedalServiceImpl", 1, "getUserMedalSync userId=" + userId + ",roomId:" + roomId + ",roomType=" + roomType);
        return this.localDataSource.b(userId, roomType);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.d
    public void destroy() {
        QLog.d("QQLiveMedalServiceImpl", 1, "destroy");
        this.localDataSource.a();
    }
}
