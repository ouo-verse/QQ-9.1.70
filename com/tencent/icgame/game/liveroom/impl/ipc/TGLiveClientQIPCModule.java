package com.tencent.icgame.game.liveroom.impl.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.icgame.game.floatwindow.FloatPosFixHelper$FloatPosItem;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.game.utils.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.HideFloatingWindowEvent;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveClientQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "registerModule", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "moduleName", "<init>", "(Ljava/lang/String;)V", "e", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TGLiveClientQIPCModule extends QIPCModule {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f115118f = "com.tencent.mobileqq:tool";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f115119h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<TGLiveClientQIPCModule> f115120i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveClientQIPCModule$a;", "", "Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveClientQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveClientQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "isRegisterDeathRecipient", "Z", "isRegisterModule", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.ipc.TGLiveClientQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TGLiveClientQIPCModule a() {
            return (TGLiveClientQIPCModule) TGLiveClientQIPCModule.f115120i.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<TGLiveClientQIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TGLiveClientQIPCModule>() { // from class: com.tencent.icgame.game.liveroom.impl.ipc.TGLiveClientQIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TGLiveClientQIPCModule invoke() {
                return new TGLiveClientQIPCModule("TGLiveClientQIPCModule");
            }
        });
        f115120i = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TGLiveClientQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.TAG = "TGLiveClientQIPCModule";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Ref.ObjectRef list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        wu0.b.c(wu0.b.INSTANCE.a(), (List) list.element, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        SimpleEventBus.getInstance().dispatchEvent(new HideFloatingWindowEvent());
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.List, T] */
    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        ?? mutableListOf;
        if (TextUtils.equals(action, "action_floating_touch_up")) {
            if (params != null) {
                Serializable serializable = params.getSerializable("param_float_json_string");
                if (serializable instanceof FloatPosFixHelper$FloatPosItem) {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((FloatPosFixHelper$FloatPosItem) serializable);
                    objectRef.element = mutableListOf;
                    k.b(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.ipc.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            TGLiveClientQIPCModule.e(Ref.ObjectRef.this);
                        }
                    });
                }
            }
            callbackResult(callbackId, EIPCResult.createSuccessResult(params));
            return null;
        }
        if (TextUtils.equals(action, "action_hide_floating_window")) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.ipc.b
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveClientQIPCModule.f();
                }
            });
            return null;
        }
        return null;
    }

    public final void registerModule() {
        if (!f115119h) {
            try {
                g.d(this.TAG, "registerModule MobileQQ.sProcessId\uff1a" + MobileQQ.sProcessId);
                QIPCClientHelper.getInstance().register(INSTANCE.a());
            } catch (Exception e16) {
                g.e(this.TAG, "registerModule MobileQQ error .sProcessId\uff1a" + MobileQQ.sProcessId, e16);
            }
            f115119h = true;
        }
    }
}
