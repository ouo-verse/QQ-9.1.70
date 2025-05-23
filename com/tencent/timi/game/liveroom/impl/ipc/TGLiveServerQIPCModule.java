package com.tencent.timi.game.liveroom.impl.ipc;

import ag4.i;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.room.FloatWindow;
import com.tencent.mobileqq.qqlive.api.room.QQLiveFloatWindowEvent;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.impl.TimiGameApiImpl;
import com.tencent.timi.game.api.ipc.ITGIPCServerApi;
import com.tencent.timi.game.app.event.TGDialogHelpCloseEvent;
import com.tencent.timi.game.floatwindow.FloatPosFixHelper;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule;
import com.tencent.timi.game.liveroom.impl.room.playtogether.LiveTeamStatusInfo;
import com.tencent.timi.game.ui.TGDialogHelperFragment;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import fm4.TeamCreatePageParam;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameOneSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\"\u001a\u00020\f\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00062\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015R\u001a\u0010!\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "callbackId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Runnable;", "task", "E", BdhLogUtil.LogTag.Tag_Conn, "", "action", "Leipc/EIPCResult;", "onCall", "Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$b;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/LiveTeamStatusInfo;", "", "callback", "p", "", "teamId", "D", "Ljava/io/Serializable;", "jsonString", DomainData.DOMAIN_NAME, "teamRoomId", "o", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "moduleName", "<init>", "(Ljava/lang/String;)V", "e", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveServerQIPCModule extends QIPCModule {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<TGLiveServerQIPCModule> f377292f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$a;", "", "", "action", "Landroid/os/Bundle;", "params", "Leipc/EIPCResultCallback;", "callback", "", "a", "Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "isRegisterModule", "Z", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String action, @Nullable Bundle params, @Nullable EIPCResultCallback callback) {
            QIPCClientHelper.getInstance().callServer(ITGIPCServerApi.MODULE_NAME_LIVE, action, params, callback);
        }

        @NotNull
        public final TGLiveServerQIPCModule b() {
            return (TGLiveServerQIPCModule) TGLiveServerQIPCModule.f377292f.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$b;", "T", BdhLogUtil.LogTag.Tag_Req, "", "t", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b<T, R> {
        R a(T t16);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$d", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "it", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<LiveTeamStatusInfo, Object> f377294d;

        d(b<LiveTeamStatusInfo, Object> bVar) {
            this.f377294d = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(EIPCResult eIPCResult, b bVar) {
            Serializable serializable;
            Bundle bundle;
            boolean z16 = false;
            if (eIPCResult != null && eIPCResult.isSuccess()) {
                z16 = true;
            }
            if (z16) {
                if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
                    serializable = bundle.getSerializable("param_live_team_status_info");
                } else {
                    serializable = null;
                }
                if (serializable instanceof LiveTeamStatusInfo) {
                    if (bVar != null) {
                        bVar.a(serializable);
                        return;
                    }
                    return;
                } else {
                    if (bVar != null) {
                        bVar.a(null);
                        return;
                    }
                    return;
                }
            }
            if (bVar != null) {
                bVar.a(null);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable final EIPCResult it) {
            final b<LiveTeamStatusInfo, Object> bVar = this.f377294d;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.r
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveServerQIPCModule.d.b(EIPCResult.this, bVar);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$e", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomLeaveRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f377296b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f377297c;

        e(int i3, Bundle bundle) {
            this.f377296b = i3;
            this.f377297c = bundle;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomLeaveRsp result) {
            TGLiveServerQIPCModule.this.callbackResult(this.f377296b, EIPCResult.createSuccessResult(this.f377297c));
            SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            TGLiveServerQIPCModule.this.callbackResult(this.f377296b, EIPCResult.createResult(errorCode, new Bundle()));
            SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$f", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f377299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f377300c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f377301d;

        f(int i3, Bundle bundle, long j3) {
            this.f377299b = i3;
            this.f377300c = bundle;
            this.f377301d = j3;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomInfo result) {
            SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
            TGLiveServerQIPCModule.this.callbackResult(this.f377299b, EIPCResult.createSuccessResult(this.f377300c));
            YoloRoomOuterClass$YoloCommonGameOneSchema C = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f377301d).C();
            if (C != null && !TextUtils.isEmpty(C.schema.get())) {
                ((fm4.g) mm4.b.b(fm4.g.class)).j2(this.f377301d, TGLiveServerQIPCModule.this.getTAG() + " qqlive_onekeylive_join");
                nm4.a.a(C.schema.get());
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            TGLiveServerQIPCModule.this.callbackResult(this.f377299b, EIPCResult.createResult(errorCode, this.f377300c));
            if (-1244 != errorCode) {
                SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
            }
        }
    }

    static {
        Lazy<TGLiveServerQIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TGLiveServerQIPCModule>() { // from class: com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TGLiveServerQIPCModule invoke() {
                return new TGLiveServerQIPCModule(ITGIPCServerApi.MODULE_NAME_LIVE);
            }
        });
        f377292f = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TGLiveServerQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.TAG = ITGIPCServerApi.MODULE_NAME_LIVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final Ref.IntRef yesGameId, final QBaseActivity qBaseActivity, final Ref.ObjectRef teamLIveParam, boolean z16, int i3, String str, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(yesGameId, "$yesGameId");
        Intrinsics.checkNotNullParameter(teamLIveParam, "$teamLIveParam");
        ((ag4.i) mm4.b.b(ag4.i.class)).J2(yesGameId.element, new i.b() { // from class: com.tencent.timi.game.liveroom.impl.ipc.h
            @Override // ag4.i.b
            public final void i(boolean z17, int i16, String str2, Object obj) {
                TGLiveServerQIPCModule.B(QBaseActivity.this, yesGameId, teamLIveParam, z17, i16, str2, (GameAuthOuterClass$GetGameAuthRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void B(QBaseActivity qBaseActivity, Ref.IntRef yesGameId, Ref.ObjectRef teamLIveParam, boolean z16, int i3, String str, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
        Intrinsics.checkNotNullParameter(yesGameId, "$yesGameId");
        Intrinsics.checkNotNullParameter(teamLIveParam, "$teamLIveParam");
        ((sm4.a) mm4.b.b(sm4.a.class)).j1(qBaseActivity, yesGameId.element, 1, 1, 0L, null, (fm4.h) teamLIveParam.element, new TeamCreatePageParam(false, 1, null));
    }

    private final void C(Bundle params) {
        QLog.i(this.TAG, 1, "onNotifyFloatWindowStatus: " + params);
        if (params != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QQLiveFloatWindowEvent(params.getBoolean("param_float_has_audience"), params.getBoolean("param_float_has_anchor"), (FloatWindow) params.getSerializable("param_float_current_operate_float")));
        }
    }

    private final void E(Runnable task) {
        TGDialogHelperFragment.INSTANCE.d(task);
    }

    private final void q(Bundle params, int callbackId) {
        String str;
        boolean z16;
        com.tencent.timi.game.utils.l.i(this.TAG, "handleJumpTask params:" + params);
        BaseQQAppInterface baseQQAppInterface = null;
        if (params != null) {
            str = params.getString("param_jump_url");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.timi.game.utils.l.e(this.TAG, "handleJumpTask jump url empty");
            EIPCResult eIPCResult = new EIPCResult();
            eIPCResult.code = -1;
            Unit unit = Unit.INSTANCE;
            callbackResult(callbackId, eIPCResult);
            return;
        }
        AppRuntime a16 = vf4.a.a();
        if (a16 instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) a16;
        }
        if (baseQQAppInterface == null) {
            com.tencent.timi.game.utils.l.e(this.TAG, "handleJumpTask baseQQInterface is null");
            EIPCResult eIPCResult2 = new EIPCResult();
            eIPCResult2.code = -2;
            Unit unit2 = Unit.INSTANCE;
            callbackResult(callbackId, eIPCResult2);
            return;
        }
        ax c16 = bi.c(baseQQAppInterface, vf4.a.b(), str);
        com.tencent.timi.game.utils.l.h(this.TAG, 1, "handleJumpTask doJumpTask action:" + c16);
        if (c16 != null) {
            c16.b();
        }
        EIPCResult eIPCResult3 = new EIPCResult();
        eIPCResult3.code = 0;
        Unit unit3 = Unit.INSTANCE;
        callbackResult(callbackId, eIPCResult3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v64, types: [java.util.List, T] */
    public static final void r(Ref.LongRef startTime, String str, final Bundle bundle, final TGLiveServerQIPCModule this$0, final int i3, boolean z16) {
        YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo;
        YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo;
        YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config;
        PBUInt64Field pBUInt64Field;
        ?? mutableListOf;
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.utils.l.i(TimiGameApiImpl.TAG, "initLiveModule syncEnsureInit costTime = " + (System.currentTimeMillis() - startTime.element));
        if (TextUtils.equals(str, "action_floating_touch_up")) {
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("param_float_json_string");
                if (serializable instanceof FloatPosFixHelper.FloatPosItem) {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((FloatPosFixHelper.FloatPosItem) serializable);
                    objectRef.element = mutableListOf;
                    w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            TGLiveServerQIPCModule.s(Ref.ObjectRef.this);
                        }
                    });
                }
                this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
                return;
            }
            return;
        }
        if (TextUtils.equals(str, "action_create_smoba_team")) {
            this$0.E(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.j
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveServerQIPCModule.z(bundle, this$0, i3);
                }
            });
            return;
        }
        if (TextUtils.equals(str, "action_join_smoba_team")) {
            this$0.E(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.k
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveServerQIPCModule.t(bundle, this$0, i3);
                }
            });
            return;
        }
        if (TextUtils.equals(str, "action_leave_smoba_team")) {
            if (bundle != null) {
                final long j3 = bundle.getLong("param_team_room_id");
                this$0.E(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        TGLiveServerQIPCModule.w(j3, this$0, i3, bundle);
                    }
                });
                return;
            }
            return;
        }
        if (TextUtils.equals(str, "action_open_smoba_team")) {
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.m
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveServerQIPCModule.x(bundle, this$0, i3);
                }
            });
            return;
        }
        if (TextUtils.equals(str, "action_response_data_report_param")) {
            if (bundle != null) {
                Serializable serializable2 = bundle.getSerializable("param_report_param");
                long j16 = bundle.getLong("param_team_room_id");
                if (serializable2 instanceof HashMap) {
                    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                    concurrentHashMap.putAll((HashMap) serializable2);
                    ((fm4.g) mm4.b.b(fm4.g.class)).K0(j16).N(concurrentHashMap);
                }
                this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
                return;
            }
            return;
        }
        long j17 = 0;
        if (TextUtils.equals(str, "action_get_live_team_status_info")) {
            if (bundle != null && ((sm4.a) mm4.b.b(sm4.a.class)).y3()) {
                YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(1);
                LiveTeamStatusInfo liveTeamStatusInfo = new LiveTeamStatusInfo();
                if (j06 != null && (pBUInt64Field = j06.room_id) != null) {
                    j17 = pBUInt64Field.get();
                }
                liveTeamStatusInfo.teamId = j17;
                liveTeamStatusInfo.isTeamOwner = ((sm4.a) mm4.b.b(sm4.a.class)).a2(liveTeamStatusInfo.teamId);
                liveTeamStatusInfo.isVolumeOpen = ((fm4.g) mm4.b.b(fm4.g.class)).m0(liveTeamStatusInfo.teamId).a();
                if (j06 != null && (yoloRoomOuterClass$YoloGameDataInfo = j06.game_data_info) != null && (yoloRoomOuterClass$YoloCommonGameDataInfo = yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info) != null && (qq_live_room_config = yoloRoomOuterClass$YoloCommonGameDataInfo.qq_live_room_config) != null) {
                    Intrinsics.checkNotNullExpressionValue(qq_live_room_config, "qq_live_room_config");
                    String str2 = qq_live_room_config.qq_live_room_id.get();
                    if (str2 == null) {
                        str2 = "";
                    }
                    liveTeamStatusInfo.liveRoomId = str2;
                    liveTeamStatusInfo.teamPlayStatus = ((fm4.g) mm4.b.b(fm4.g.class)).K0(liveTeamStatusInfo.teamId).M();
                }
                bundle.putSerializable("param_live_team_status_info", liveTeamStatusInfo);
            }
            this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
            return;
        }
        if (TextUtils.equals(str, "action_live_room_join")) {
            YoloRoomOuterClass$YoloRoomInfo j07 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
            if (j07 != null) {
                final long j18 = j07.room_id.get();
                if (j18 > 0) {
                    w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.ipc.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            TGLiveServerQIPCModule.y(j18);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (TextUtils.equals("action_float_window_status", str)) {
            this$0.C(bundle);
        } else if (TextUtils.equals("action_jump_url", str)) {
            this$0.q(bundle, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Ref.ObjectRef list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        vh4.d.n(vh4.d.INSTANCE.a(), (List) list.element, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final Bundle bundle, final TGLiveServerQIPCModule this$0, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bundle != null) {
            final QBaseActivity b16 = vf4.a.b();
            if (b16 instanceof Activity) {
                final int i16 = 3;
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final long j3 = bundle.getLong("param_team_self_live_uid");
                final long j16 = bundle.getLong("param_team_room_id");
                byte[] byteArray = bundle.getByteArray("param_team_info_byte");
                final PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo = new PremadesTeamServerOuterClass$YesGamePremadesTeamInfo();
                try {
                    premadesTeamServerOuterClass$YesGamePremadesTeamInfo.mergeFrom(byteArray);
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.timi.game.utils.l.e(this$0.TAG, "YesGamePremadesTeamInfo conver error");
                }
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 101;
                ((ag4.i) mm4.b.b(ag4.i.class)).s0(intRef.element, new i.b() { // from class: com.tencent.timi.game.liveroom.impl.ipc.o
                    @Override // ag4.i.b
                    public final void i(boolean z16, int i17, String str, Object obj) {
                        TGLiveServerQIPCModule.u(Ref.IntRef.this, j16, i16, objectRef, j3, premadesTeamServerOuterClass$YesGamePremadesTeamInfo, b16, this$0, i3, bundle, z16, i17, str, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Ref.IntRef yesGameId, final long j3, final int i3, final Ref.ObjectRef guildShequnParams, final long j16, final PremadesTeamServerOuterClass$YesGamePremadesTeamInfo teamInfo, final QBaseActivity qBaseActivity, final TGLiveServerQIPCModule this$0, final int i16, final Bundle bundle, boolean z16, int i17, String str, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(yesGameId, "$yesGameId");
        Intrinsics.checkNotNullParameter(guildShequnParams, "$guildShequnParams");
        Intrinsics.checkNotNullParameter(teamInfo, "$teamInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ag4.i) mm4.b.b(ag4.i.class)).J2(yesGameId.element, new i.b() { // from class: com.tencent.timi.game.liveroom.impl.ipc.q
            @Override // ag4.i.b
            public final void i(boolean z17, int i18, String str2, Object obj) {
                TGLiveServerQIPCModule.v(j3, i3, guildShequnParams, j16, teamInfo, qBaseActivity, this$0, i16, bundle, z17, i18, str2, (GameAuthOuterClass$GetGameAuthRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(long j3, int i3, Ref.ObjectRef guildShequnParams, long j16, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo teamInfo, QBaseActivity qBaseActivity, TGLiveServerQIPCModule this$0, int i16, Bundle bundle, boolean z16, int i17, String str, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
        Intrinsics.checkNotNullParameter(guildShequnParams, "$guildShequnParams");
        Intrinsics.checkNotNullParameter(teamInfo, "$teamInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
        dVar.f379324a = j3;
        dVar.f379325b = i3;
        dVar.f379326c = 0;
        dVar.f379328e = 1;
        dVar.f379329f = (fm4.c) guildShequnParams.element;
        dVar.f379327d = false;
        dVar.f379330g = 0L;
        dVar.f379331h = j16;
        com.tencent.timi.game.room.impl.util.c cVar = new com.tencent.timi.game.room.impl.util.c();
        cVar.f379322a = teamInfo.game_mode.get();
        cVar.f379323b = teamInfo.grade_list.get();
        ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, qBaseActivity, dVar, cVar, new f(i16, bundle, j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(long j3, TGLiveServerQIPCModule this$0, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity b16 = vf4.a.b();
        if (b16 instanceof Activity) {
            com.tencent.timi.game.team.impl.main.f.c(j3, b16, new e(i3, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Bundle bundle, TGLiveServerQIPCModule this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bundle != null) {
            long j3 = bundle.getLong("param_team_room_id");
            if (j3 > 0) {
                ((sm4.a) mm4.b.b(sm4.a.class)).q0(BaseApplication.getContext(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).getRoomInfo(), 3);
            } else {
                com.tencent.timi.game.utils.l.e(this$0.TAG, "resume with error " + j3);
            }
        }
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(long j3) {
        ((fm4.g) mm4.b.b(fm4.g.class)).T2(j3, true, 0, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, fm4.h] */
    public static final void z(Bundle bundle, TGLiveServerQIPCModule this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final QBaseActivity b16 = vf4.a.b();
        if ((b16 instanceof Activity) && bundle != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new fm4.h(String.valueOf(bundle.getLong("param_team_create_anchor_roomid")), bundle.getLong("param_team_create_anchor_platform_uid"), bundle.getLong("param_team_create_anchoruid"), String.valueOf(bundle.getLong("param_team_create_trtc_roomid")), bundle.getInt("param_team_create_entercondition"), bundle.getBoolean("param_team_is_screen_capture"), bundle.getString("param_team_create_anchor_bus_id"));
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 101;
            ((ag4.i) mm4.b.b(ag4.i.class)).s0(intRef.element, new i.b() { // from class: com.tencent.timi.game.liveroom.impl.ipc.p
                @Override // ag4.i.b
                public final void i(boolean z16, int i16, String str, Object obj) {
                    TGLiveServerQIPCModule.A(Ref.IntRef.this, b16, objectRef, z16, i16, str, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
                }
            });
            this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
        }
    }

    public final void D(long teamId) {
        INSTANCE.a("action_response_data_report_param", o(teamId), new g());
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final void n(@NotNull Serializable jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Bundle bundle = new Bundle();
        bundle.putSerializable("param_float_json_string", jsonString);
        INSTANCE.a("action_floating_touch_up", bundle, new c());
    }

    @NotNull
    public final Bundle o(long teamRoomId) {
        Boolean bool;
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        Bundle bundle = new Bundle();
        bundle.putLong("param_team_room_id", teamRoomId);
        jg4.c s16 = ((jg4.b) b16).s();
        if (s16 != null) {
            bool = Boolean.valueOf(s16.b());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            bundle.putSerializable("param_report_param", tk4.d.f436481a.d());
        } else {
            bundle.putSerializable("param_report_param", tk4.c.INSTANCE.a().b());
        }
        return bundle;
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable final String action, @Nullable final Bundle params, final int callbackId) {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: com.tencent.timi.game.liveroom.impl.ipc.g
            @Override // hi4.a
            public final void a(boolean z16) {
                TGLiveServerQIPCModule.r(Ref.LongRef.this, action, params, this, callbackId, z16);
            }
        });
        return null;
    }

    public final void p(@Nullable b<LiveTeamStatusInfo, Object> callback) {
        INSTANCE.a("action_get_live_team_status_info", new Bundle(), new d(callback));
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$c", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements EIPCResultCallback {
        c() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$g", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements EIPCResultCallback {
        g() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
        }
    }
}
