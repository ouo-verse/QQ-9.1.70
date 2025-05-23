package com.tencent.mobileqq.troop.halfscreennotification.processor;

import android.content.Intent;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationDialog;
import com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationRepository;
import com.tencent.mobileqq.troop.halfscreennotification.b;
import com.tencent.mobileqq.troop.halfscreennotification.c;
import com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor;
import com.tencent.mobileqq.troop.shortcut.util.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/processor/TroopHalfScreenNotificationProcessor;", "Lcom/tencent/mobileqq/troop/halfscreennotification/c;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/troop/halfscreennotification/a;", "data", "", "a", "(Lcom/tencent/aio/api/runtime/a;Lcom/tencent/mobileqq/troop/halfscreennotification/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationProcessor implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0002R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/processor/TroopHalfScreenNotificationProcessor$a;", "", "Lcom/tencent/mobileqq/troop/halfscreennotification/b;", "buttonData", "", "isMain", "Lcom/tencent/mobileqq/troop/halfscreennotification/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", h.F, "e", "Landroid/widget/ImageView;", "target", "Lkotlin/Function1;", "callback", "f", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean e(com.tencent.aio.api.runtime.a context) {
            Intent intent;
            FragmentActivity activity = context.c().getActivity();
            if (activity == null || (intent = activity.getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra("key_is_scale_chat", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(com.tencent.mobileqq.troop.halfscreennotification.a data, ImageView target, final Function1<? super Boolean, Unit> callback) {
            Option option = Option.obtain().setUrl(data.c()).setTargetView(target).setRequestHeight(data.b()).setRequestWidth(data.d());
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.processor.a
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option2) {
                    TroopHalfScreenNotificationProcessor.Companion.g(Function1.this, loadState, option2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Function1 function1, LoadState loadState, Option option) {
            if (loadState.isFinish() && function1 != null) {
                function1.invoke(Boolean.valueOf(loadState.isFinishSuccess()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(b buttonData, boolean isMain, com.tencent.mobileqq.troop.halfscreennotification.a data, com.tencent.aio.api.runtime.a context) {
            AppRuntime peekAppRuntime;
            TroopInfo troopInfoFromCache;
            FragmentActivity activity;
            if (isMain) {
                TroopHalfScreenNotificationRepository.f296194a.j(data.i(), data.f());
            }
            String b16 = buttonData.b();
            if (b16 == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(String.valueOf(data.i()))) == null || (activity = context.c().getActivity()) == null) {
                return;
            }
            com.tencent.mobileqq.troop.shortcut.util.a.d(new a.C8774a(activity, peekAppRuntime, activity, troopInfoFromCache, String.valueOf(data.i()), b16, "", false, LaunchScene.LAUNCH_HALF_SCREEN_NOTIFICATION));
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopHalfScreenNotificationProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    @Override // com.tencent.mobileqq.troop.halfscreennotification.c
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull final com.tencent.aio.api.runtime.a aVar, @NotNull final com.tencent.mobileqq.troop.halfscreennotification.a aVar2, @NotNull Continuation<? super Boolean> continuation) {
        TroopHalfScreenNotificationProcessor$consume$1 troopHalfScreenNotificationProcessor$consume$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        final TroopHalfScreenNotificationDialog troopHalfScreenNotificationDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, aVar, aVar2, continuation);
        }
        if (continuation instanceof TroopHalfScreenNotificationProcessor$consume$1) {
            troopHalfScreenNotificationProcessor$consume$1 = (TroopHalfScreenNotificationProcessor$consume$1) continuation;
            int i16 = troopHalfScreenNotificationProcessor$consume$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopHalfScreenNotificationProcessor$consume$1.label = i16 - Integer.MIN_VALUE;
                obj = troopHalfScreenNotificationProcessor$consume$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopHalfScreenNotificationProcessor$consume$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        troopHalfScreenNotificationDialog = (TroopHalfScreenNotificationDialog) troopHalfScreenNotificationProcessor$consume$1.L$2;
                        aVar2 = (com.tencent.mobileqq.troop.halfscreennotification.a) troopHalfScreenNotificationProcessor$consume$1.L$1;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Companion companion = INSTANCE;
                    if (companion.e(aVar)) {
                        return Boxing.boxBoolean(false);
                    }
                    Function2<b, Boolean, Unit> function2 = new Function2<b, Boolean, Unit>(aVar) { // from class: com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$consume$actionOnClick$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.aio.api.runtime.a $context;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$context = aVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.halfscreennotification.a.this, (Object) aVar);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(b bVar, Boolean bool) {
                            invoke(bVar, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull b buttonData, boolean z16) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, buttonData, Boolean.valueOf(z16));
                            } else {
                                Intrinsics.checkNotNullParameter(buttonData, "buttonData");
                                TroopHalfScreenNotificationProcessor.INSTANCE.h(buttonData, z16, com.tencent.mobileqq.troop.halfscreennotification.a.this, this.$context);
                            }
                        }
                    };
                    final Channel Channel$default = ChannelKt.Channel$default(1, BufferOverflow.DROP_LATEST, null, 4, null);
                    FragmentActivity activity = aVar.c().getActivity();
                    if (activity == null) {
                        return Boxing.boxBoolean(false);
                    }
                    TroopHalfScreenNotificationDialog troopHalfScreenNotificationDialog2 = new TroopHalfScreenNotificationDialog(activity, aVar.c().getView(), aVar2, function2);
                    companion.f(aVar2, troopHalfScreenNotificationDialog2.j0(), new Function1<Boolean, Unit>(Channel$default) { // from class: com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$consume$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Channel<Unit> $fetchEndSignal;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                        @DebugMetadata(c = "com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$consume$2$1", f = "TroopHalfScreenNotificationProcessor.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$consume$2$1, reason: invalid class name */
                        /* loaded from: classes19.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Channel<Unit> $fetchEndSignal;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Channel<Unit> channel, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$fetchEndSignal = channel;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) channel, (Object) continuation);
                                }
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                    return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                                }
                                return new AnonymousClass1(this.$fetchEndSignal, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                Object coroutine_suspended;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i3 = this.label;
                                    if (i3 != 0) {
                                        if (i3 == 1) {
                                            ResultKt.throwOnFailure(obj);
                                        } else {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    } else {
                                        ResultKt.throwOnFailure(obj);
                                        Channel<Unit> channel = this.$fetchEndSignal;
                                        Unit unit = Unit.INSTANCE;
                                        this.label = 1;
                                        if (channel.send(unit, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            @Nullable
                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$fetchEndSignal = Channel$default;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Channel$default);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getUnconfined()), null, null, new AnonymousClass1(this.$fetchEndSignal, null), 3, null);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                            }
                        }
                    });
                    TroopHalfScreenNotificationProcessor$consume$3 troopHalfScreenNotificationProcessor$consume$3 = new TroopHalfScreenNotificationProcessor$consume$3(Channel$default, null);
                    troopHalfScreenNotificationProcessor$consume$1.L$0 = this;
                    troopHalfScreenNotificationProcessor$consume$1.L$1 = aVar2;
                    troopHalfScreenNotificationProcessor$consume$1.L$2 = troopHalfScreenNotificationDialog2;
                    troopHalfScreenNotificationProcessor$consume$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(500L, troopHalfScreenNotificationProcessor$consume$3, troopHalfScreenNotificationProcessor$consume$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    troopHalfScreenNotificationDialog = troopHalfScreenNotificationDialog2;
                }
                if (((Unit) obj) == null) {
                    QLog.e("TroopHalfScreenNotificationProcessor", 1, "timeout when fetch img");
                }
                INSTANCE.f(aVar2, troopHalfScreenNotificationDialog.j0(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$consume$5
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHalfScreenNotificationDialog.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        } else {
                            if (z16) {
                                return;
                            }
                            TroopHalfScreenNotificationDialog.this.B0();
                        }
                    }
                });
                if (JobKt.isActive(troopHalfScreenNotificationProcessor$consume$1.get$context())) {
                    QLog.i("TroopHalfScreenNotificationProcessor", 1, "cancelled when fetch result");
                    return Boxing.boxBoolean(false);
                }
                troopHalfScreenNotificationDialog.show();
                return Boxing.boxBoolean(true);
            }
        }
        troopHalfScreenNotificationProcessor$consume$1 = new TroopHalfScreenNotificationProcessor$consume$1(this, continuation);
        obj = troopHalfScreenNotificationProcessor$consume$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopHalfScreenNotificationProcessor$consume$1.label;
        if (i3 == 0) {
        }
        if (((Unit) obj) == null) {
        }
        INSTANCE.f(aVar2, troopHalfScreenNotificationDialog.j0(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor$consume$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHalfScreenNotificationDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                } else {
                    if (z16) {
                        return;
                    }
                    TroopHalfScreenNotificationDialog.this.B0();
                }
            }
        });
        if (JobKt.isActive(troopHalfScreenNotificationProcessor$consume$1.get$context())) {
        }
    }
}
