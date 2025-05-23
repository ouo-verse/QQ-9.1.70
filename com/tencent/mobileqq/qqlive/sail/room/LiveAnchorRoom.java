package com.tencent.mobileqq.qqlive.sail.room;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.push.LivePushRepository;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.request.LiveAnchorEnterRoomRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveAnchorSetRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveEndNewRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveLeaveRoomRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveStartNewRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import gr4.v;
import gr4.z;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00107\u001a\u00020\u000f\u00a2\u0006\u0004\bV\u0010WJ\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016JE\u0010'\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e21\u0010&\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070 j\b\u0012\u0004\u0012\u00020\u0014`%H\u0016J\u001c\u0010,\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0019\u0010.\u001a\b\u0012\u0004\u0012\u00020-0!H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u0006J\u0019\u00100\u001a\b\u0012\u0004\u0012\u00020/0!H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u0006J\u0019\u00102\u001a\b\u0012\u0004\u0012\u0002010!H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u0006J\u0019\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0006R\u0017\u00107\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u00106R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R&\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0?0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR \u0010D\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u001a\u0010J\u001a\u00020E8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010Q\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveAnchorRoom;", "Lcom/tencent/mobileqq/qqlive/sail/room/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/m;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lpt3/b;", "G", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "O", "E", "", "cmd", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/Job;", UserInfo.SEX_FEMALE, "", "N", "getAppID", "", "getRoomId", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "b", "", "isDestroyed", "Lcom/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive;", "o", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "listener", "p", "e", "", "extBytes", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mobileqq/qqlive/sail/room/Resulter;", "callback", "t", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "info", "B", "Lgr4/v;", "P", "Lgr4/e;", "H", "Lpt3/j;", BdhLogUtil.LogTag.Tag_Req, "I", "Ljava/lang/String;", "J", "()Ljava/lang/String;", "appId", "Lcom/tencent/mobileqq/qqlive/push/LivePushRepository;", "f", "Lkotlin/Lazy;", "K", "()Lcom/tencent/mobileqq/qqlive/push/LivePushRepository;", "push", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "pushCmdToListeners", "i", "pushCmdToJob", "Lcom/tencent/mobileqq/qqlive/sail/room/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/sail/room/a;", "M", "()Lcom/tencent/mobileqq/qqlive/sail/room/a;", "roomState", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "L", "()Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;)V", "roomInfo", "Lcom/tencent/mobileqq/qqlive/sail/room/LiveHeartbeatJob;", "D", "Lcom/tencent/mobileqq/qqlive/sail/room/LiveHeartbeatJob;", "heartbeatJob", "<init>", "(Ljava/lang/String;)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class LiveAnchorRoom extends m implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AnchorRoomInfo roomInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveHeartbeatJob heartbeatJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy push;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CopyOnWriteArraySet<g>> pushCmdToListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Job> pushCmdToJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.sail.room.a roomState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/room/LiveAnchorRoom$a", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Ljt3/b;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements ILiveNetRequest.Callback<jt3.b> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAnchorRoom.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<jt3.b> response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isFailed()) {
                AegisLogger.INSTANCE.w(LiveAnchorRoom.this.N(), "leaveRoom", "failed, result=" + response);
            }
        }
    }

    public LiveAnchorRoom(@NotNull String appId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(appId, "appId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appId);
            return;
        }
        this.appId = appId;
        lazy = LazyKt__LazyJVMKt.lazy(LiveAnchorRoom$push$2.INSTANCE);
        this.push = lazy;
        this.pushCmdToListeners = new ConcurrentHashMap<>();
        this.pushCmdToJob = new ConcurrentHashMap<>();
        this.roomState = new com.tencent.mobileqq.qqlive.sail.room.a();
        this.roomInfo = new AnchorRoomInfo(null, null, null, null, null, null, 0L, null, 0L, null, null, 2047, null);
        this.heartbeatJob = new LiveHeartbeatJob();
        this.roomInfo.x(appId);
    }

    private final void E() {
        K().c();
        Iterator<Map.Entry<Integer, CopyOnWriteArraySet<g>>> it = this.pushCmdToListeners.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
        this.pushCmdToListeners.clear();
        Iterator<Map.Entry<Integer, Job>> it5 = this.pushCmdToJob.entrySet().iterator();
        while (it5.hasNext()) {
            Job.DefaultImpls.cancel$default(it5.next().getValue(), (CancellationException) null, 1, (Object) null);
        }
        this.pushCmdToJob.clear();
    }

    private final Job F(final int cmd) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorRoom$createSubscribePushJob$job$1(this, cmd, null), 3, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>(cmd) { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAnchorRoom$createSubscribePushJob$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $cmd;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$cmd = cmd;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAnchorRoom.this, cmd);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
                    return;
                }
                AegisLogger.INSTANCE.i(LiveAnchorRoom.this.N(), "subscribePush", "complete, cmd=" + this.$cmd + ", roomId=" + LiveAnchorRoom.this.getRoomId());
            }
        });
        return launch$default;
    }

    private final Object G(Continuation<? super QQLiveResponse<pt3.b>> continuation) {
        String str;
        String str2 = this.appId;
        long g16 = this.roomInfo.p().g();
        z t16 = this.roomInfo.t();
        if (t16 != null) {
            str = t16.f403246a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveEndNewRequest(str2, g16, str, this.roomInfo.p().f()), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LivePushRepository K() {
        return (LivePushRepository) this.push.getValue();
    }

    private final void O() {
        String str;
        String str2 = this.appId;
        int g16 = (int) this.roomInfo.p().g();
        z t16 = this.roomInfo.t();
        if (t16 != null) {
            str = t16.f403246a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveLeaveRoomRequest(str2, g16, str), new a());
    }

    private final void S(int cmd) {
        if (!this.pushCmdToJob.containsKey(Integer.valueOf(cmd))) {
            this.pushCmdToJob.put(Integer.valueOf(cmd), F(cmd));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.c
    public void B(@Nullable AvConfig config, @Nullable SettingInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorRoom$updateRoomInfo$1(this, config, info, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) config, (Object) info);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(@NotNull Continuation<? super l<gr4.e>> continuation) {
        LiveAnchorRoom$enterRoom$1 liveAnchorRoom$enterRoom$1;
        Object coroutine_suspended;
        int i3;
        LiveAnchorRoom liveAnchorRoom;
        l<gr4.e> j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) continuation);
        }
        if (continuation instanceof LiveAnchorRoom$enterRoom$1) {
            liveAnchorRoom$enterRoom$1 = (LiveAnchorRoom$enterRoom$1) continuation;
            int i16 = liveAnchorRoom$enterRoom$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAnchorRoom$enterRoom$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAnchorRoom$enterRoom$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAnchorRoom$enterRoom$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        liveAnchorRoom = (LiveAnchorRoom) liveAnchorRoom$enterRoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    LiveAnchorEnterRoomRequest liveAnchorEnterRoomRequest = new LiveAnchorEnterRoomRequest(this.appId, this.roomInfo.p().g(), this.roomInfo.p().f(), this.roomInfo.r().m());
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    liveAnchorRoom$enterRoom$1.L$0 = this;
                    liveAnchorRoom$enterRoom$1.label = 1;
                    obj = iLiveNetRequest.sendRequestOnSuspend(liveAnchorEnterRoomRequest, liveAnchorRoom$enterRoom$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorRoom = this;
                }
                j3 = com.tencent.mobileqq.qqlive.sail.model.a.j((QQLiveResponse) obj);
                if (j3.b() != 0) {
                    liveAnchorRoom.roomInfo.z(System.currentTimeMillis());
                    LivePushRepository.g(liveAnchorRoom.K(), liveAnchorRoom.appId, liveAnchorRoom.roomInfo.p().g(), null, 4, null);
                    k.f272428a.e(liveAnchorRoom.roomInfo);
                    liveAnchorRoom.heartbeatJob.h(liveAnchorRoom.roomInfo);
                } else {
                    AegisLogger.INSTANCE.w(liveAnchorRoom.N(), "enterRoom", "failed, result=" + j3);
                }
                return j3;
            }
        }
        liveAnchorRoom$enterRoom$1 = new LiveAnchorRoom$enterRoom$1(this, continuation);
        Object obj2 = liveAnchorRoom$enterRoom$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAnchorRoom$enterRoom$1.label;
        if (i3 == 0) {
        }
        j3 = com.tencent.mobileqq.qqlive.sail.model.a.j((QQLiveResponse) obj2);
        if (j3.b() != 0) {
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object I(@NotNull Continuation<? super l<pt3.b>> continuation) {
        LiveAnchorRoom$exitRoom$1 liveAnchorRoom$exitRoom$1;
        Object coroutine_suspended;
        int i3;
        LiveAnchorRoom liveAnchorRoom;
        l<pt3.b> i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return iPatchRedirector.redirect((short) 19, (Object) this, (Object) continuation);
        }
        if (continuation instanceof LiveAnchorRoom$exitRoom$1) {
            liveAnchorRoom$exitRoom$1 = (LiveAnchorRoom$exitRoom$1) continuation;
            int i17 = liveAnchorRoom$exitRoom$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                liveAnchorRoom$exitRoom$1.label = i17 - Integer.MIN_VALUE;
                Object obj = liveAnchorRoom$exitRoom$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAnchorRoom$exitRoom$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        liveAnchorRoom = (LiveAnchorRoom) liveAnchorRoom$exitRoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.heartbeatJob.f();
                    this.roomInfo.A(0L);
                    this.roomInfo.z(0L);
                    E();
                    k.f272428a.d(this.roomInfo.m());
                    O();
                    liveAnchorRoom$exitRoom$1.L$0 = this;
                    liveAnchorRoom$exitRoom$1.label = 1;
                    obj = G(liveAnchorRoom$exitRoom$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorRoom = this;
                }
                i16 = com.tencent.mobileqq.qqlive.sail.model.a.i((QQLiveResponse) obj);
                if (i16.b() != 0) {
                    AegisLogger.INSTANCE.w(liveAnchorRoom.N(), "exitRoom", "failed, result=" + i16);
                }
                return i16;
            }
        }
        liveAnchorRoom$exitRoom$1 = new LiveAnchorRoom$exitRoom$1(this, continuation);
        Object obj2 = liveAnchorRoom$exitRoom$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAnchorRoom$exitRoom$1.label;
        if (i3 == 0) {
        }
        i16 = com.tencent.mobileqq.qqlive.sail.model.a.i((QQLiveResponse) obj2);
        if (i16.b() != 0) {
        }
        return i16;
    }

    @NotNull
    public final String J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AnchorRoomInfo L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AnchorRoomInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.roomInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.qqlive.sail.room.a M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.qqlive.sail.room.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.roomState;
    }

    @NotNull
    public String N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Open_Live|LiveAnchorRoom";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object P(@NotNull Continuation<? super l<v>> continuation) {
        LiveAnchorRoom$setRoom$1 liveAnchorRoom$setRoom$1;
        Object coroutine_suspended;
        int i3;
        LiveAnchorRoom liveAnchorRoom;
        l<v> m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return iPatchRedirector.redirect((short) 16, (Object) this, (Object) continuation);
        }
        if (continuation instanceof LiveAnchorRoom$setRoom$1) {
            liveAnchorRoom$setRoom$1 = (LiveAnchorRoom$setRoom$1) continuation;
            int i16 = liveAnchorRoom$setRoom$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAnchorRoom$setRoom$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAnchorRoom$setRoom$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAnchorRoom$setRoom$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        liveAnchorRoom = (LiveAnchorRoom) liveAnchorRoom$setRoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    LiveAnchorSetRequest liveAnchorSetRequest = new LiveAnchorSetRequest(this.appId, this.roomInfo);
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    liveAnchorRoom$setRoom$1.L$0 = this;
                    liveAnchorRoom$setRoom$1.label = 1;
                    obj = iLiveNetRequest.sendRequestOnSuspend(liveAnchorSetRequest, liveAnchorRoom$setRoom$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorRoom = this;
                }
                m3 = com.tencent.mobileqq.qqlive.sail.model.a.m((QQLiveResponse) obj);
                if (m3.b() != 0) {
                    AegisLogger.INSTANCE.w(liveAnchorRoom.N(), "setRoom", "failed, result=" + m3);
                }
                return m3;
            }
        }
        liveAnchorRoom$setRoom$1 = new LiveAnchorRoom$setRoom$1(this, continuation);
        Object obj2 = liveAnchorRoom$setRoom$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAnchorRoom$setRoom$1.label;
        if (i3 == 0) {
        }
        m3 = com.tencent.mobileqq.qqlive.sail.model.a.m((QQLiveResponse) obj2);
        if (m3.b() != 0) {
        }
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(@NotNull AnchorRoomInfo anchorRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anchorRoomInfo);
        } else {
            Intrinsics.checkNotNullParameter(anchorRoomInfo, "<set-?>");
            this.roomInfo = anchorRoomInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object R(@NotNull Continuation<? super l<pt3.j>> continuation) {
        LiveAnchorRoom$startNewStream$1 liveAnchorRoom$startNewStream$1;
        Object coroutine_suspended;
        int i3;
        String str;
        LiveAnchorRoom liveAnchorRoom;
        l<pt3.j> n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return iPatchRedirector.redirect((short) 18, (Object) this, (Object) continuation);
        }
        if (continuation instanceof LiveAnchorRoom$startNewStream$1) {
            liveAnchorRoom$startNewStream$1 = (LiveAnchorRoom$startNewStream$1) continuation;
            int i16 = liveAnchorRoom$startNewStream$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAnchorRoom$startNewStream$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAnchorRoom$startNewStream$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAnchorRoom$startNewStream$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        liveAnchorRoom = (LiveAnchorRoom) liveAnchorRoom$startNewStream$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String str2 = this.appId;
                    long g16 = this.roomInfo.p().g();
                    z t16 = this.roomInfo.t();
                    if (t16 != null) {
                        str = t16.f403246a;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    LiveStartNewRequest liveStartNewRequest = new LiveStartNewRequest(str2, g16, str, this.roomInfo.p().f());
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    liveAnchorRoom$startNewStream$1.L$0 = this;
                    liveAnchorRoom$startNewStream$1.label = 1;
                    obj = iLiveNetRequest.sendRequestOnSuspend(liveStartNewRequest, liveAnchorRoom$startNewStream$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorRoom = this;
                }
                n3 = com.tencent.mobileqq.qqlive.sail.model.a.n((QQLiveResponse) obj);
                if (n3.b() != 0) {
                    AegisLogger.INSTANCE.w(liveAnchorRoom.N(), "startNewStream", "failed, result=" + n3);
                }
                return n3;
            }
        }
        liveAnchorRoom$startNewStream$1 = new LiveAnchorRoom$startNewStream$1(this, continuation);
        Object obj2 = liveAnchorRoom$startNewStream$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAnchorRoom$startNewStream$1.label;
        if (i3 == 0) {
        }
        n3 = com.tencent.mobileqq.qqlive.sail.model.a.n((QQLiveResponse) obj2);
        if (n3.b() != 0) {
        }
        return n3;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void e(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else if (listener != null) {
            Iterator<Map.Entry<Integer, CopyOnWriteArraySet<g>>> it = this.pushCmdToListeners.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().remove(listener);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @NotNull
    public String getAppID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.appId;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.roomInfo.p().g();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.roomState.c() == 80) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @Nullable
    public LiveRoomInteractive o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveRoomInteractive) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (getRoomId() != 0) {
            return new LiveRoomInteractive(this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void p(int cmd, @Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, cmd, (Object) listener);
            return;
        }
        if (listener != null) {
            if (this.pushCmdToListeners.get(Integer.valueOf(cmd)) == null) {
                this.pushCmdToListeners.put(Integer.valueOf(cmd), new CopyOnWriteArraySet<>());
            }
            CopyOnWriteArraySet<g> copyOnWriteArraySet = this.pushCmdToListeners.get(Integer.valueOf(cmd));
            if (copyOnWriteArraySet != null) {
                copyOnWriteArraySet.add(listener);
            }
            S(cmd);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.c
    public void t(@Nullable byte[] extBytes, @NotNull Function1<? super l<AnchorRoomInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) extBytes, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorRoom$prepare$1(this, extBytes, callback, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @NotNull
    public AnchorRoomInfo b() {
        AnchorRoomInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AnchorRoomInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        a16 = r2.a((r28 & 1) != 0 ? r2.avConfig : null, (r28 & 2) != 0 ? r2.basicInfo : null, (r28 & 4) != 0 ? r2.settingInfo : null, (r28 & 8) != 0 ? r2.anchorInfo : null, (r28 & 16) != 0 ? r2.trtcInfo : null, (r28 & 32) != 0 ? r2.thirdPushInfo : null, (r28 & 64) != 0 ? r2.heartBeatTime : 0L, (r28 & 128) != 0 ? r2.appId : null, (r28 & 256) != 0 ? r2.enterRoomTime : 0L, (r28 & 512) != 0 ? r2.popupDialogUrl : null, (r28 & 1024) != 0 ? this.roomInfo.backgroundInfo : null);
        return a16;
    }
}
