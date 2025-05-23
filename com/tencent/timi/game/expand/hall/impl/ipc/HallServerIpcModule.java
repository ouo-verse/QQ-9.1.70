package com.tencent.timi.game.expand.hall.impl.ipc;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.timi.game.expand.hall.impl.ipc.param.HallInfo;
import com.tencent.timi.game.utils.l;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import fm4.g;
import gh4.e;
import gh4.f;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mm4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/ipc/HallServerIpcModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Lcom/tencent/timi/game/expand/hall/impl/ipc/param/HallInfo;", "c", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class HallServerIpcModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<HallServerIpcModule> f376904e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/ipc/HallServerIpcModule$a;", "", "", "action", "Landroid/os/Bundle;", "params", "Leipc/EIPCResultCallback;", "callback", "", "a", "Lcom/tencent/timi/game/expand/hall/impl/ipc/HallServerIpcModule;", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/timi/game/expand/hall/impl/ipc/HallServerIpcModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.expand.hall.impl.ipc.HallServerIpcModule$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String action, @Nullable Bundle params, @Nullable EIPCResultCallback callback) {
            QIPCClientHelper.getInstance().callServer("TGHallServerQIPCModule", action, params, callback);
        }

        @NotNull
        public final HallServerIpcModule b() {
            return (HallServerIpcModule) HallServerIpcModule.f376904e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<HallServerIpcModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HallServerIpcModule>() { // from class: com.tencent.timi.game.expand.hall.impl.ipc.HallServerIpcModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HallServerIpcModule invoke() {
                return new HallServerIpcModule();
            }
        });
        f376904e = lazy;
    }

    public HallServerIpcModule() {
        super("TGHallServerQIPCModule");
    }

    private final HallInfo c() {
        HallInfo hallInfo = new HallInfo();
        e I0 = ((f) b.b(f.class)).I0();
        if (I0 != null) {
            hallInfo.f376905d = I0.ue();
            hallInfo.f376906e = I0.o1();
        } else {
            YoloRoomOuterClass$YoloRoomInfo j06 = ((g) b.b(g.class)).j0(5);
            if (j06 != null) {
                hallInfo.f376905d = j06.room_id.get();
                hallInfo.f376906e = j06.room_data_info.game_id.get();
            }
        }
        return hallInfo;
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        EIPCResult eIPCResult = new EIPCResult();
        if (Intrinsics.areEqual(action, "get_hall_info")) {
            eIPCResult.data = new Bundle();
            HallInfo c16 = c();
            eIPCResult.data.putParcelable("hall_info", c16);
            l.i("HallServerIpcModule_", "onCall hallInfo.roomId:" + c16.f376905d + ", hallInfo.yesGameId:" + c16.f376906e);
        }
        callbackResult(callbackId, eIPCResult);
        return eIPCResult;
    }
}
