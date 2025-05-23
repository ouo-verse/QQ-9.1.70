package com.tencent.icgame.game.liveroom.impl.room.unitedialog;

import android.app.Activity;
import android.content.Context;
import com.tencent.icgame.game.liveroom.impl.room.payguide.UniteDialogManager;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.icgame.framework.component.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import f32.a;
import fu0.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/unitedialog/BaseUniteDialogComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "k", "i", "b", "c", DomainData.DOMAIN_NAME, "o", "Lfx0/a;", "r", "Lh22/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/icgame/game/liveroom/impl/room/payguide/UniteDialogManager;", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/payguide/UniteDialogManager;", "getUniteDialogManager", "()Lcom/tencent/icgame/game/liveroom/impl/room/payguide/UniteDialogManager;", "setUniteDialogManager", "(Lcom/tencent/icgame/game/liveroom/impl/room/payguide/UniteDialogManager;)V", "uniteDialogManager", "Lfu0/c;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "p", "()Lfu0/c;", "liveRoomService", "Lf32/a;", "cc", "<init>", "(Lf32/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class BaseUniteDialogComponent extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UniteDialogManager uniteDialogManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUniteDialogComponent(@NotNull a cc5) {
        super(cc5);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(cc5, "cc");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.unitedialog.BaseUniteDialogComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) qx0.a.b(c.class);
            }
        });
        this.liveRoomService = lazy;
    }

    private final c p() {
        return (c) this.liveRoomService.getValue();
    }

    public final void b() {
        UniteDialogManager uniteDialogManager = this.uniteDialogManager;
        if (uniteDialogManager != null) {
            uniteDialogManager.o();
        }
    }

    public final void c() {
        UniteDialogManager uniteDialogManager = this.uniteDialogManager;
        if (uniteDialogManager != null) {
            uniteDialogManager.p();
        }
    }

    public final void n() {
        IQQLiveSsoProxyModule iQQLiveSsoProxyModule;
        if (this.uniteDialogManager == null) {
            int roomType = q().getRoomType();
            long roomId = q().getRoomId();
            IQQLiveSDK f16 = p().f();
            if (f16 != null) {
                iQQLiveSsoProxyModule = f16.getProxySsoService();
            } else {
                iQQLiveSsoProxyModule = null;
            }
            this.uniteDialogManager = new UniteDialogManager(roomType, roomId, iQQLiveSsoProxyModule);
        }
        UniteDialogManager uniteDialogManager = this.uniteDialogManager;
        if (uniteDialogManager != null) {
            uniteDialogManager.v(r());
        }
        UniteDialogManager uniteDialogManager2 = this.uniteDialogManager;
        if (uniteDialogManager2 != null) {
            Context d16 = q().d();
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.app.Activity");
            uniteDialogManager2.q((Activity) d16);
        }
    }

    public final void o() {
        UniteDialogManager uniteDialogManager = this.uniteDialogManager;
        if (uniteDialogManager != null) {
            uniteDialogManager.r();
        }
    }

    @NotNull
    public abstract h22.a q();

    @NotNull
    public abstract fx0.a r();

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
