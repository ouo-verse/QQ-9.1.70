package com.tencent.mobileqq.icgame.base.baseroom.enterexitroom;

import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@ComponentEvent(eventList = {EnterRoomSuccessEvent.class, b.class, ExitRoomSuccessEvent.class, f.class, com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.a.class, ExitRoomEvent.class})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/EnterExitRoomComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "k", "i", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/i;", "enterExitRoomSupport", "Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/i;", "Lcom/tencent/mobileqq/icgame/api/room/AudienceRoomConfig$VideoFormat;", "e", "Lcom/tencent/mobileqq/icgame/api/room/AudienceRoomConfig$VideoFormat;", "videoFormat", "Lfu0/c;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "getLiveRoomService", "()Lfu0/c;", "liveRoomService", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", tl.h.F, "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class EnterExitRoomComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f237129h = new a(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AudienceRoomConfig.VideoFormat videoFormat;

    @InjectService(key = i.class)
    private i enterExitRoomSupport;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/EnterExitRoomComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterExitRoomComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.videoFormat = AudienceRoomConfig.VideoFormat.RTMP;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterExitRoomComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
