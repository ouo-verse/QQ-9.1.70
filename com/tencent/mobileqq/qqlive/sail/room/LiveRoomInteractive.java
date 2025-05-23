package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.sail.error.a;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 \u00062\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002Ja\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f27\b\u0002\u0010\u0015\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b!\u0010\"R\u001b\u0010%\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u001b\u0010'\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b&\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive;", "", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lrq3/g;", "response", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "f", "", "c", "", "msg", "nick", "", "Lrq3/b;", "exts", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqlive/sail/room/Resulter;", "callback", "g", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "a", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "room", "", "b", "Lkotlin/Lazy;", "e", "()J", "roomId", "d", "()Ljava/lang/String;", "appId", "getAnchorId", "anchorId", "getProgramId", "programId", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/room/f;)V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveRoomInteractive {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f room;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy appId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy anchorId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy programId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive$a;", "", "", "INVALID_ROOM_ID", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lrq3/g;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ILiveNetRequest.Callback<rq3.g> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<l<rq3.g>, Unit> f272411a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LiveRoomInteractive f272412b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super l<rq3.g>, Unit> function1, LiveRoomInteractive liveRoomInteractive) {
            this.f272411a = function1;
            this.f272412b = liveRoomInteractive;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1, (Object) liveRoomInteractive);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<rq3.g> response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            Function1<l<rq3.g>, Unit> function1 = this.f272411a;
            if (function1 != null) {
                function1.invoke(this.f272412b.f(response));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32088);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveRoomInteractive(@NotNull f room) {
        Intrinsics.checkNotNullParameter(room, "room");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) room);
            return;
        }
        this.room = room;
        this.roomId = LazyKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive$roomId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveRoomInteractive.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                f fVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                fVar = LiveRoomInteractive.this.room;
                return Long.valueOf(fVar.getRoomId());
            }
        });
        this.appId = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive$appId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveRoomInteractive.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                f fVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                fVar = LiveRoomInteractive.this.room;
                return fVar.getAppID();
            }
        });
        this.anchorId = LazyKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive$anchorId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveRoomInteractive.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                f fVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                fVar = LiveRoomInteractive.this.room;
                UserInfo j3 = fVar.b().j();
                return Long.valueOf(j3 != null ? j3.f() : 0L);
            }
        });
        this.programId = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive$programId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveRoomInteractive.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                f fVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                fVar = LiveRoomInteractive.this.room;
                return fVar.b().getProgramId();
            }
        });
    }

    private final boolean c(QQLiveResponse<?> response) {
        if (!response.isFailed() && response.getRsp() != null) {
            return true;
        }
        return false;
    }

    private final String d() {
        return (String) this.appId.getValue();
    }

    private final long e() {
        return ((Number) this.roomId.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l<rq3.g> f(QQLiveResponse<rq3.g> response) {
        if (c(response)) {
            rq3.g rsp = response.getRsp();
            Intrinsics.checkNotNull(rsp);
            rq3.g gVar = rsp;
            if (gVar.f431954a == 0) {
                return new l<>(gVar, 0L, null, 0, 12, null);
            }
            return new l<>(gVar, gVar.f431954a, gVar.f431955b, 3);
        }
        return new l<>(response.getRsp(), response.getRetCode(), response.getErrMsg(), 2);
    }

    public final void g(@NotNull String msg2, @NotNull String nick, @Nullable List<rq3.b> exts, @Nullable final Function1<? super l<rq3.g>, Unit> callback) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg2, nick, exts, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(nick, "nick");
        if (e() == 0) {
            l c16 = a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000004L, null, null, 4, null);
            AegisLogger.INSTANCE.w("Interactive|LiveRoomInteractive", "sendMessage", "error, " + c16.b() + ", " + c16.c());
            if (callback != null) {
                callback.invoke(c16);
                return;
            }
            return;
        }
        f fVar = this.room;
        if (fVar instanceof e) {
            eVar = (e) fVar;
        } else {
            eVar = null;
        }
        if (eVar == null || !eVar.h()) {
            z16 = false;
        }
        if (!z16) {
            ((ILiveRoomInteractiveApi) QRoute.api(ILiveRoomInteractiveApi.class)).sendMessage(d(), e(), msg2, exts, new b(callback, this));
        } else {
            QQLiveHuYa.f271333a.o(new com.tencent.mobileqq.qqlive.huya.b(msg2, nick), new Function2<Boolean, Integer, Unit>(callback) { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive$sendMessage$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<l<rq3.g>, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z17), Integer.valueOf(i3));
                        return;
                    }
                    QLog.i("Interactive|LiveRoomInteractive", 2, "sendBarrage " + z17 + ", " + i3);
                    Function1<l<rq3.g>, Unit> function1 = this.$callback;
                    if (function1 != null) {
                        rq3.g gVar = new rq3.g();
                        gVar.f431954a = i3;
                        function1.invoke(new l<>(gVar, 0L, null, 0, 14, null));
                    }
                }
            });
        }
    }
}
