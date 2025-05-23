package com.tencent.icgame.game.liveroom.impl.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.icgame.api.impl.TimiGameApiImpl;
import com.tencent.icgame.api.ipc.ITGIPCServerApi;
import com.tencent.icgame.game.floatwindow.FloatPosFixHelper$FloatPosItem;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.game.utils.k;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveServerQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "moduleName", "<init>", "(Ljava/lang/String;)V", "e", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TGLiveServerQIPCModule extends QIPCModule {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<TGLiveServerQIPCModule> f115123f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveServerQIPCModule$a;", "", "Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveServerQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/icgame/game/liveroom/impl/ipc/TGLiveServerQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "isRegisterModule", "Z", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.ipc.TGLiveServerQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TGLiveServerQIPCModule a() {
            return (TGLiveServerQIPCModule) TGLiveServerQIPCModule.f115123f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<TGLiveServerQIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TGLiveServerQIPCModule>() { // from class: com.tencent.icgame.game.liveroom.impl.ipc.TGLiveServerQIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TGLiveServerQIPCModule invoke() {
                return new TGLiveServerQIPCModule(ITGIPCServerApi.MODULE_NAME_LIVE);
            }
        });
        f115123f = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TGLiveServerQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.TAG = "ICGameServerQIPCModule";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List, T] */
    public static final void e(Ref.LongRef startTime, String str, Bundle bundle, TGLiveServerQIPCModule this$0, int i3, boolean z16) {
        ?? mutableListOf;
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g.h(TimiGameApiImpl.TAG, "initLiveModule syncEnsureInit costTime = " + (System.currentTimeMillis() - startTime.element));
        if (TextUtils.equals(str, "action_floating_touch_up") && bundle != null) {
            Serializable serializable = bundle.getSerializable("param_float_json_string");
            if (serializable instanceof FloatPosFixHelper$FloatPosItem) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((FloatPosFixHelper$FloatPosItem) serializable);
                objectRef.element = mutableListOf;
                k.b(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.ipc.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TGLiveServerQIPCModule.f(Ref.ObjectRef.this);
                    }
                });
            }
            this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Ref.ObjectRef list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        wu0.b.c(wu0.b.INSTANCE.a(), (List) list.element, false, 2, null);
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable final String action, @Nullable final Bundle params, final int callbackId) {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        ((ev0.b) qx0.a.b(ev0.b.class)).v3(new ev0.a() { // from class: com.tencent.icgame.game.liveroom.impl.ipc.c
            @Override // ev0.a
            public final void a(boolean z16) {
                TGLiveServerQIPCModule.e(Ref.LongRef.this, action, params, this, callbackId, z16);
            }
        });
        return null;
    }
}
