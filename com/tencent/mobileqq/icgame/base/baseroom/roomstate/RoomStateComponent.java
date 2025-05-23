package com.tencent.mobileqq.icgame.base.baseroom.roomstate;

import b32.e;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateComponent$liveRoomStatusListener$2;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@ComponentEvent(eventList = {b.class, a.class, c.class, d.class})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/roomstate/RoomStateComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", DomainData.DOMAIN_NAME, "o", "k", "i", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lfu0/c;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "b", "()Lfu0/c;", "liveRoomService", "Lb32/e;", "f", "c", "()Lb32/e;", "liveRoomStatusListener", "Lf32/a;", "cc", "<init>", "(Lf32/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class RoomStateComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomStatusListener;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomStateComponent(@NotNull f32.a cc5) {
        super(cc5);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(cc5, "cc");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RoomStateComponent$liveRoomStatusListener$2.a>() { // from class: com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateComponent$liveRoomStatusListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/base/baseroom/roomstate/RoomStateComponent$liveRoomStatusListener$2$a", "Lb32/e;", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "", "onRoomOpen", "onRoomClose", "onRoomPause", "onRoomResume", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a implements e {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ RoomStateComponent f237140a;

                a(RoomStateComponent roomStateComponent) {
                    this.f237140a = roomStateComponent;
                }

                @Override // b32.e
                public void onRoomClose(@NotNull QQLiveRoomStatusInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    this.f237140a.getComponentContext().w0(new com.tencent.mobileqq.icgame.base.baseroom.roomstate.a(info));
                }

                @Override // b32.e
                public void onRoomOpen(@NotNull QQLiveRoomStatusInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    this.f237140a.getComponentContext().w0(new b(info));
                }

                @Override // b32.e
                public void onRoomPause(@NotNull QQLiveRoomStatusInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    this.f237140a.getComponentContext().w0(new c(info));
                }

                @Override // b32.e
                public void onRoomResume(@NotNull QQLiveRoomStatusInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    this.f237140a.getComponentContext().w0(new d(info));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RoomStateComponent.this);
            }
        });
        this.liveRoomStatusListener = lazy2;
    }

    private final fu0.c b() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    private final e c() {
        return (e) this.liveRoomStatusListener.getValue();
    }

    public final void n() {
        fu0.c b16 = b();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        IAudienceRoom N = b16.N(aVar.getRoomId());
        if (N != null) {
            N.registerRoomStatusListener(c());
        }
    }

    public final void o() {
        fu0.c b16 = b();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        IAudienceRoom N = b16.N(aVar.getRoomId());
        if (N != null) {
            N.unRegisterRoomStatusListener(c());
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
