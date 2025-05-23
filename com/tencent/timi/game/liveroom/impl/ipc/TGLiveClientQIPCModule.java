package com.tencent.timi.game.liveroom.impl.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqlive.api.room.HideFloatingWindowEvent;
import com.tencent.mobileqq.qqlive.api.room.QQLiveFloatWindowEvent;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.floatwindow.FloatPosFixHelper;
import com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\b\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0002R\u001a\u0010\u001f\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "registerModule", "unregister", "Ljava/io/Serializable;", "jsonString", "k", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "", "teamRoomId", "Ljava/util/concurrent/ConcurrentHashMap;", "l", "t", DomainData.DOMAIN_NAME, "fetchFloatWindowStatus", "Lcom/tencent/mobileqq/qqlive/api/room/QQLiveFloatWindowEvent;", "ev", "o", "hideFloatingWindow", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "moduleName", "<init>", "(Ljava/lang/String;)V", "e", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveClientQIPCModule extends QIPCModule {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f377286f = "com.tencent.mobileqq:tool";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f377287h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<TGLiveClientQIPCModule> f377288i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule$a;", "", "", "action", "Landroid/os/Bundle;", "params", "Leipc/EIPCResultCallback;", "callback", "", "a", "Leipc/EIPCResult;", "b", "PROCESS_NAME", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "isRegisterDeathRecipient", "Z", "isRegisterModule", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String action, @Nullable Bundle params, @Nullable EIPCResultCallback callback) {
            QIPCServerHelper.getInstance().callClient(d(), "TGLiveClientQIPCModule", action, params, callback);
        }

        @Nullable
        public final EIPCResult b(@Nullable String action, @Nullable Bundle params) {
            return QIPCServerHelper.getInstance().getServer().callClient(d(), 1, "TGLiveClientQIPCModule", action, params);
        }

        @NotNull
        public final TGLiveClientQIPCModule c() {
            return (TGLiveClientQIPCModule) TGLiveClientQIPCModule.f377288i.getValue();
        }

        @NotNull
        public final String d() {
            return TGLiveClientQIPCModule.f377286f;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<EndPageRealTimeInfo> {
        d() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable EndPageRealTimeInfo result) {
            com.tencent.timi.game.utils.l.e(TGLiveClientQIPCModule.this.getTAG(), "stopLive success with IPC");
            rj4.a.f431587a.b(false);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            com.tencent.timi.game.utils.l.e(TGLiveClientQIPCModule.this.getTAG(), "stopLive failed  with IPC");
            if (TextUtils.isEmpty(errorMessage)) {
                errorMessage = "\u4e0b\u64ad\u5931\u8d25";
            }
            com.tencent.timi.game.ui.widget.f.c(errorMessage);
        }
    }

    static {
        Lazy<TGLiveClientQIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TGLiveClientQIPCModule>() { // from class: com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TGLiveClientQIPCModule invoke() {
                return new TGLiveClientQIPCModule("TGLiveClientQIPCModule");
            }
        });
        f377288i = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TGLiveClientQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.TAG = "TGLiveClientQIPCModule";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TGLiveClientQIPCModule this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "fetchFloatWindowStatus result " + eIPCResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TGLiveClientQIPCModule this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "notifyOuterPlayerEvent result " + eIPCResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Ref.ObjectRef list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        vh4.d.n(vh4.d.INSTANCE.a(), (List) list.element, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(long j3, jg4.b bVar, TGLiveClientQIPCModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TGLiveFloatManager.f377649d.g(j3, true);
        if (bVar.J3(j3) != null) {
            bVar.x3(j3, new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        SimpleEventBus.getInstance().dispatchEvent(new HideFloatingWindowEvent());
    }

    public final void fetchFloatWindowStatus() {
        INSTANCE.a("action_fetch_float_status", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.timi.game.liveroom.impl.ipc.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                TGLiveClientQIPCModule.j(TGLiveClientQIPCModule.this, eIPCResult);
            }
        });
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final void hideFloatingWindow() {
        INSTANCE.a("action_hide_floating_window", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.timi.game.liveroom.impl.ipc.e
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                TGLiveClientQIPCModule.m(eIPCResult);
            }
        });
    }

    public final void k(@NotNull Serializable jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Bundle bundle = new Bundle();
        bundle.putSerializable("param_float_json_string", jsonString);
        INSTANCE.a("action_floating_touch_up", bundle, new b());
    }

    @Nullable
    public final ConcurrentHashMap<String, String> l(long teamRoomId) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putLong("param_team_room_id", teamRoomId);
        EIPCResult b16 = INSTANCE.b("action_get_data_report_param", bundle2);
        if (b16 != null && (bundle = b16.data) != null) {
            Serializable serializable = bundle.getSerializable("param_report_param");
            bundle.getLong("param_team_room_id");
            if (serializable instanceof HashMap) {
                ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.putAll((HashMap) serializable);
                return concurrentHashMap;
            }
            return null;
        }
        return null;
    }

    public final void n() {
        INSTANCE.a("action_expand_hall_join", new Bundle(), new c());
    }

    public final void o(@NotNull QQLiveFloatWindowEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Bundle bundle = new Bundle();
        bundle.putBoolean("param_float_has_audience", ev5.isHasAudienceFloat());
        bundle.putBoolean("param_float_has_anchor", ev5.isHasAnchorFloat());
        if (ev5.getCurOperateFloatWindow() != null) {
            bundle.putSerializable("param_float_current_operate_float", ev5.getCurOperateFloatWindow());
        }
        TGLiveServerQIPCModule.INSTANCE.a("action_float_window_status", bundle, new EIPCResultCallback() { // from class: com.tencent.timi.game.liveroom.impl.ipc.f
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                TGLiveClientQIPCModule.p(TGLiveClientQIPCModule.this, eIPCResult);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r4v27, types: [java.util.List, T] */
    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        ?? mutableListOf;
        if (TextUtils.equals(action, "action_floating_touch_up")) {
            if (params != null) {
                Serializable serializable = params.getSerializable("param_float_json_string");
                if (serializable instanceof FloatPosFixHelper.FloatPosItem) {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((FloatPosFixHelper.FloatPosItem) serializable);
                    objectRef.element = mutableListOf;
                    w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            TGLiveClientQIPCModule.q(Ref.ObjectRef.this);
                        }
                    });
                }
            }
            callbackResult(callbackId, EIPCResult.createSuccessResult(params));
            return null;
        }
        if (TextUtils.equals(action, "action_request_data_report_param")) {
            if (params != null) {
                TGLiveServerQIPCModule.INSTANCE.b().D(params.getLong("param_team_room_id"));
            }
            callbackResult(callbackId, EIPCResult.createSuccessResult(params));
            return null;
        }
        if (TextUtils.equals(action, "action_get_data_report_param")) {
            if (params != null) {
                return EIPCResult.createSuccessResult(TGLiveServerQIPCModule.INSTANCE.b().o(params.getLong("param_team_room_id")));
            }
            return null;
        }
        if (TextUtils.equals(action, "action_expand_hall_join")) {
            com.tencent.timi.game.utils.l.e(this.TAG, " IPC ACTION_EXPAND_HALL_JOIN");
            final jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
            BaseRoomInfo q16 = bVar.q(0L);
            if (q16 != null) {
                final long roomId = q16.getRoomId();
                if (roomId > 0) {
                    w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            TGLiveClientQIPCModule.r(roomId, bVar, this);
                        }
                    });
                    return null;
                }
                return null;
            }
            return null;
        }
        if (TextUtils.equals(action, "action_fetch_float_status")) {
            TGLiveFloatManager.f377649d.c();
            return null;
        }
        if (TextUtils.equals(action, "action_hide_floating_window")) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.d
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveClientQIPCModule.s();
                }
            });
            return null;
        }
        return null;
    }

    public final void registerModule() {
        if (!f377287h) {
            try {
                com.tencent.timi.game.utils.l.e(this.TAG, "registerModule MobileQQ.sProcessId\uff1a" + MobileQQ.sProcessId);
                QIPCClientHelper.getInstance().register(INSTANCE.c());
            } catch (Exception e16) {
                com.tencent.timi.game.utils.l.f(this.TAG, "registerModule MobileQQ error .sProcessId\uff1a" + MobileQQ.sProcessId, e16);
            }
            f377287h = true;
        }
    }

    public final void t(long teamRoomId) {
        Bundle bundle = new Bundle();
        bundle.putLong("param_team_room_id", teamRoomId);
        INSTANCE.a("action_request_data_report_param", bundle, new e());
    }

    public final void unregister() {
        try {
            if (QIPCClientHelper.getInstance().getClient() != null) {
                com.tencent.timi.game.utils.l.e(this.TAG, "unregister MobileQQ.sProcessId\uff1a" + MobileQQ.sProcessId);
                QIPCClientHelper.getInstance().getClient().unRegisterModule(INSTANCE.c());
                f377287h = false;
            }
        } catch (Exception e16) {
            com.tencent.timi.game.utils.l.f(this.TAG, "unregister MobileQQ error .sProcessId\uff1a" + MobileQQ.sProcessId, e16);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule$b", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements EIPCResultCallback {
        b() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule$c", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements EIPCResultCallback {
        c() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveClientQIPCModule$e", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements EIPCResultCallback {
        e() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(EIPCResult eIPCResult) {
    }
}
