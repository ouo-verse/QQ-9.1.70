package com.tencent.mobileqq.nearbypro.repository.service;

import android.util.Base64;
import com.google.protobuf.nano.MessageNano;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.nearbypro.avatar.NearbyProAvatarActionHelper;
import com.tencent.mobileqq.nearbypro.base.NearbyNetError;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.l;
import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseProxyRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import com.tencent.xweb.internal.ConstValue;
import hq4.d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rp4.h;
import zb3.FriendsRespData;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u000201B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J%\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ>\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J?\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\tJ\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u001c\u0010\"\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020!0 R\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R(\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/AvatarService;", "Lcom/tencent/mobileqq/nearbypro/api/IAvatarService;", "Lkotlinx/coroutines/CoroutineScope;", "", "tinyId", "", ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, "Lorg/json/JSONObject;", "doReqOtherAvatarInfo", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reqAvatarInfo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "motionId", "motionAssetMD5", "coverUrl", "recordDressKey", "Lkotlin/Function0;", "", "callback", "setMotionCover", "hostUin", "guestUin", "url", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "loadMotionPlayParams", "(JLjava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reqOtherAvatarInfo", "cleanup", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "getSingleFriendZPlanInfo", "TAG", "Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Deferred;", "avatarInfoFutureMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "NBPAvatarInfoReq", "NBPFriendAvatarInfoReq", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AvatarService implements IAvatarService, CoroutineScope {

    @NotNull
    private static final String TAG = "NBP.FeedsCheckPart.AvatarService";

    @NotNull
    public static final AvatarService INSTANCE = new AvatarService();

    @NotNull
    private static final CoroutineDispatcher coroutineContext = Dispatchers.getIO();

    @NotNull
    private static final ConcurrentHashMap<Long, Deferred<JSONObject>> avatarInfoFutureMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/AvatarService$NBPAvatarInfoReq;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "Lhq4/c;", "Lhq4/d;", "pbReq", "Lhq4/c;", "getPbReq", "()Lhq4/c;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "cmd", "Ljava/lang/String;", "getCmd", "()Ljava/lang/String;", "", "tinyId", ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, "<init>", "(JLjava/lang/String;Lhq4/c;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class NBPAvatarInfoReq extends NearbyProBasePBRequest<hq4.c, d> {

        @NotNull
        private final String cmd;

        @NotNull
        private final hq4.c pbReq;

        @NotNull
        private final Function0<d> pbRspConstructor;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ NBPAvatarInfoReq(long j3, String str, hq4.c cVar, Function0 function0, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, str, cVar, (i3 & 8) != 0 ? new Function0<d>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.AvatarService.NBPAvatarInfoReq.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final d invoke() {
                    return new d();
                }
            } : function0, (i3 & 16) != 0 ? "trpc.lplan.user_manager_svr.User.SsoGetAvatarInfo" : str2);
            if ((i3 & 4) != 0) {
                cVar = new hq4.c();
                cVar.f405959b = j3;
                cVar.f405960c = str;
                cVar.f405958a = com.tencent.mobileqq.nearbypro.request.a.a();
            }
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public String getCmd() {
            return this.cmd;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public Function0<d> getPbRspConstructor() {
            return this.pbRspConstructor;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public hq4.c getPbReq() {
            return this.pbReq;
        }

        public NBPAvatarInfoReq(long j3, @NotNull String clientVersion, @NotNull hq4.c pbReq, @NotNull Function0<d> pbRspConstructor, @NotNull String cmd) {
            Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
            Intrinsics.checkNotNullParameter(pbReq, "pbReq");
            Intrinsics.checkNotNullParameter(pbRspConstructor, "pbRspConstructor");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            this.pbReq = pbReq;
            this.pbRspConstructor = pbRspConstructor;
            this.cmd = cmd;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/AvatarService$NBPFriendAvatarInfoReq;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseProxyRequest;", "Lcom/google/protobuf/nano/MessageNano;", "Laq4/b;", "Lcom/tencent/mobileqq/zplan/resource/api/IZPlanAvatarInfoHelper;", "helper", "Lcom/tencent/mobileqq/zplan/resource/api/IZPlanAvatarInfoHelper;", "pbReq", "Lcom/google/protobuf/nano/MessageNano;", "getPbReq", "()Lcom/google/protobuf/nano/MessageNano;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "proxyed_method", "Ljava/lang/String;", "getProxyed_method", "()Ljava/lang/String;", "proxyed_service", "getProxyed_service", "", "tinyId", "<init>", "(J)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    private static final class NBPFriendAvatarInfoReq extends NearbyProBaseProxyRequest<MessageNano, aq4.b> {

        @NotNull
        private final IZPlanAvatarInfoHelper helper;

        @NotNull
        private final MessageNano pbReq;

        @NotNull
        private final Function0<aq4.b> pbRspConstructor;

        @NotNull
        private final String proxyed_method;

        @NotNull
        private final String proxyed_service;

        public NBPFriendAvatarInfoReq(long j3) {
            QRouteApi api = QRoute.api(IZPlanAvatarInfoHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAvatarInfoHelper::class.java)");
            IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) api;
            this.helper = iZPlanAvatarInfoHelper;
            this.pbReq = iZPlanAvatarInfoHelper.getSingleFriendZplanInfoReq(j3, com.tencent.mobileqq.nearbypro.utils.c.a(j.b()));
            this.pbRspConstructor = new Function0<aq4.b>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.AvatarService$NBPFriendAvatarInfoReq$pbRspConstructor$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final aq4.b invoke() {
                    return new aq4.b();
                }
            };
            this.proxyed_method = "SsoGetSingleFriendZplanInfo";
            this.proxyed_service = "trpc.zplan.spring_festival.Portal";
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public MessageNano getPbReq() {
            return this.pbReq;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public Function0<aq4.b> getPbRspConstructor() {
            return this.pbRspConstructor;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseProxyRequest
        @NotNull
        public String getProxyed_method() {
            return this.proxyed_method;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseProxyRequest
        @NotNull
        public String getProxyed_service() {
            return this.proxyed_service;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "<anonymous parameter 0>", "Lcom/tencent/mobileqq/nearbypro/request/d;", "rspStatus", "Lhq4/d;", "rsp", "", "b", "(Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;Lcom/tencent/mobileqq/nearbypro/request/d;Lhq4/d;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a<Req, Rsp> implements com.tencent.mobileqq.nearbypro.request.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<JSONObject> f253916a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super JSONObject> continuation) {
            this.f253916a = continuation;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(@NotNull NearbyProBaseRequest nearbyProBaseRequest, @NotNull RspStatus rspStatus, @Nullable d dVar) {
            Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
            if (rspStatus.c() && dVar != null) {
                j.c().c(AvatarService.TAG, "rsp.zplanInfo " + dVar.f405962b);
                byte[] byteValue = Base64.decode(dVar.f405962b, 0);
                IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                Intrinsics.checkNotNullExpressionValue(byteValue, "byteValue");
                this.f253916a.resumeWith(Result.m476constructorimpl(iZPlanAvatarInfoHelper.getOtherAvatarInfoForLPlan(byteValue)));
                return;
            }
            j.c().d(AvatarService.TAG, "fetch dressinfo failed err=" + rspStatus);
            this.f253916a.resumeWith(Result.m476constructorimpl(null));
        }
    }

    AvatarService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doReqOtherAvatarInfo(long j3, String str, Continuation<? super JSONObject> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        j.e().b(new NBPAvatarInfoReq(j3, str, null, null, null, 28, null), new a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSingleFriendZPlanInfo$lambda$8(com.tencent.mobileqq.zootopia.d callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, aq4.b bVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        j.c().c(TAG, "getSingleFriendLPlanInfo " + rspStatus + " rsp=" + bVar);
        Intrinsics.checkNotNull(bVar);
        byte[] byteValue = Base64.decode(bVar.f26760d, 0);
        IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
        Intrinsics.checkNotNullExpressionValue(byteValue, "byteValue");
        iZPlanAvatarInfoHelper.getSingleFriendZplanInfoRsp(byteValue, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMotionCover$lambda$4(NearbyNetError error, Unit unit) {
        Intrinsics.checkNotNullParameter(error, "error");
        j.c().c(TAG, "onResult error: " + error + " result: " + unit);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    public void cleanup() {
        j.c().e(TAG, "clean nearby AvatarInfoFutureMap");
        try {
            try {
                if (JobKt.isActive(getCoroutineContext())) {
                    CoroutineScopeKt.cancel$default(this, null, 1, null);
                }
            } catch (Exception e16) {
                j.c().d(TAG, "clean, e=" + e16);
            }
        } finally {
            avatarInfoFutureMap.clear();
        }
    }

    public final void getSingleFriendZPlanInfo(long tinyId, @NotNull final com.tencent.mobileqq.zootopia.d<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new NBPFriendAvatarInfoReq(tinyId), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.repository.service.a
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                AvatarService.getSingleFriendZPlanInfo$lambda$8(com.tencent.mobileqq.zootopia.d.this, (NearbyProBaseRequest) obj, rspStatus, (aq4.b) obj2);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    @Nullable
    public Object loadMotionPlayParams(long j3, @Nullable Long l3, @NotNull String str, @NotNull Continuation<? super Triple<MoodConfig, SquareAvatarData, LoadFilamentAssetsStatistics>> continuation) {
        return NearbyProAvatarActionHelper.f253199a.loadPlayParams(j3, l3, str, continuation);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    @Nullable
    public Object reqAvatarInfo(long j3, @NotNull Continuation<? super JSONObject> continuation) {
        Object coroutine_suspended;
        if (j3 != s.a() && !Intrinsics.areEqual(String.valueOf(j3), SquareBaseKt.getSquareCommon().getCurrentAccountUin())) {
            Object reqOtherAvatarInfo = reqOtherAvatarInfo(j3, "0.2.23.0", continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (reqOtherAvatarInfo == coroutine_suspended) {
                return reqOtherAvatarInfo;
            }
            return (JSONObject) reqOtherAvatarInfo;
        }
        return ((IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class)).fetchMyAvatarInfo(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.concurrent.ConcurrentMap] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reqOtherAvatarInfo(long j3, @NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        AvatarService$reqOtherAvatarInfo$1 avatarService$reqOtherAvatarInfo$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        Deferred<JSONObject> deferred;
        Long l3;
        ConcurrentHashMap<Long, Deferred<JSONObject>> concurrentHashMap;
        Deferred<JSONObject> putIfAbsent;
        JSONObject jSONObject;
        if (continuation instanceof AvatarService$reqOtherAvatarInfo$1) {
            avatarService$reqOtherAvatarInfo$1 = (AvatarService$reqOtherAvatarInfo$1) continuation;
            int i16 = avatarService$reqOtherAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                avatarService$reqOtherAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                obj = avatarService$reqOtherAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = avatarService$reqOtherAvatarInfo$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            j3 = avatarService$reqOtherAvatarInfo$1.J$0;
                            ResultKt.throwOnFailure(obj);
                            jSONObject = (JSONObject) obj;
                            if (jSONObject != null) {
                                j.c().d(TAG, "getAvatarInfo, result = null");
                                JSONObject jSONObject2 = new JSONObject();
                                avatarInfoFutureMap.remove(Boxing.boxLong(j3));
                                return jSONObject2;
                            }
                            return jSONObject;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = avatarService$reqOtherAvatarInfo$1.J$0;
                    l3 = (Long) avatarService$reqOtherAvatarInfo$1.L$1;
                    ?? r26 = (ConcurrentMap) avatarService$reqOtherAvatarInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    concurrentHashMap = r26;
                } else {
                    ResultKt.throwOnFailure(obj);
                    ConcurrentHashMap<Long, Deferred<JSONObject>> concurrentHashMap2 = avatarInfoFutureMap;
                    boolean containsKey = concurrentHashMap2.containsKey(Boxing.boxLong(j3));
                    j.c().c(TAG, "reqOtherAvatarInfo: init tinyId=" + j3 + " cacheHit=" + containsKey);
                    Long boxLong = Boxing.boxLong(j3);
                    deferred = concurrentHashMap2.get(boxLong);
                    if (deferred == null) {
                        j.c().e(TAG, "avatarInfoFutureMap: add tinyId=" + j3);
                        AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1 avatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1 = new AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1(j3, str, null);
                        avatarService$reqOtherAvatarInfo$1.L$0 = concurrentHashMap2;
                        avatarService$reqOtherAvatarInfo$1.L$1 = boxLong;
                        avatarService$reqOtherAvatarInfo$1.J$0 = j3;
                        avatarService$reqOtherAvatarInfo$1.label = 1;
                        Object coroutineScope = CoroutineScopeKt.coroutineScope(avatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1, avatarService$reqOtherAvatarInfo$1);
                        if (coroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = coroutineScope;
                        l3 = boxLong;
                        concurrentHashMap = concurrentHashMap2;
                    }
                    avatarService$reqOtherAvatarInfo$1.L$0 = null;
                    avatarService$reqOtherAvatarInfo$1.L$1 = null;
                    avatarService$reqOtherAvatarInfo$1.J$0 = j3;
                    avatarService$reqOtherAvatarInfo$1.label = 2;
                    obj = deferred.await(avatarService$reqOtherAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                    }
                }
                Deferred<JSONObject> deferred2 = (Deferred) obj;
                putIfAbsent = concurrentHashMap.putIfAbsent(l3, deferred2);
                if (putIfAbsent != null) {
                    deferred = deferred2;
                } else {
                    deferred = putIfAbsent;
                }
                avatarService$reqOtherAvatarInfo$1.L$0 = null;
                avatarService$reqOtherAvatarInfo$1.L$1 = null;
                avatarService$reqOtherAvatarInfo$1.J$0 = j3;
                avatarService$reqOtherAvatarInfo$1.label = 2;
                obj = deferred.await(avatarService$reqOtherAvatarInfo$1);
                if (obj == coroutine_suspended) {
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                }
            }
        }
        avatarService$reqOtherAvatarInfo$1 = new AvatarService$reqOtherAvatarInfo$1(this, continuation);
        obj = avatarService$reqOtherAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = avatarService$reqOtherAvatarInfo$1.label;
        if (i3 == 0) {
        }
        Deferred<JSONObject> deferred22 = (Deferred) obj;
        putIfAbsent = concurrentHashMap.putIfAbsent(l3, deferred22);
        if (putIfAbsent != null) {
        }
        avatarService$reqOtherAvatarInfo$1.L$0 = null;
        avatarService$reqOtherAvatarInfo$1.L$1 = null;
        avatarService$reqOtherAvatarInfo$1.J$0 = j3;
        avatarService$reqOtherAvatarInfo$1.label = 2;
        obj = deferred.await(avatarService$reqOtherAvatarInfo$1);
        if (obj == coroutine_suspended) {
        }
        jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    public void setMotionCover(long tinyId, int motionId, @NotNull String motionAssetMD5, @NotNull String coverUrl, @NotNull String recordDressKey, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(motionAssetMD5, "motionAssetMD5");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(recordDressKey, "recordDressKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.c().c(TAG, "setMotionCover tinyId=" + tinyId + " motionId=" + motionId + " motionAssetMD5=" + motionAssetMD5 + " coverUrl=" + coverUrl + " recordDressKey=" + recordDressKey);
        PanelDataService panelDataService = new PanelDataService();
        h hVar = new h();
        hVar.f431888a = recordDressKey;
        Unit unit = Unit.INSTANCE;
        panelDataService.b(tinyId, motionId, motionAssetMD5, coverUrl, hVar, new l() { // from class: com.tencent.mobileqq.nearbypro.repository.service.b
            @Override // com.tencent.mobileqq.nearbypro.base.l
            public final void a(NearbyNetError nearbyNetError, Object obj) {
                AvatarService.setMotionCover$lambda$4(nearbyNetError, (Unit) obj);
            }
        });
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineDispatcher getCoroutineContext() {
        return coroutineContext;
    }
}
