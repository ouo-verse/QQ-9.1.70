package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$fetchPskey$1", f = "DSSearchDepositary.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class DSSearchDepositary$fetchPskey$1 extends SuspendLambda implements Function2<ProducerScope<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary$fetchPskey$1$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProducerScope<String> f231660a;

        /* JADX WARN: Multi-variable type inference failed */
        a(ProducerScope<? super String> producerScope) {
            this.f231660a = producerScope;
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().d("QQGuildInSearchTag.DSSearchDepositary", 1, "[onFail] getPskey error " + errMsg);
            CoroutineScopeKt.cancel(this.f231660a, new CancellationException("getPskey error"));
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            boolean z16;
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str = domainToKeyMap.get(FlockBaseRequest.QUN_DOMAIN);
            if (str == null) {
                str = "";
            }
            Logger.a d16 = Logger.f235387a.d();
            boolean z17 = false;
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("QQGuildInSearchTag.DSSearchDepositary", 1, "[onSuccess] pskey " + z16);
            if (str.length() > 0) {
                z17 = true;
            }
            if (z17) {
                Object mo2003trySendJP2dKIU = this.f231660a.mo2003trySendJP2dKIU(str);
                if (mo2003trySendJP2dKIU instanceof ChannelResult.Failed) {
                    Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU);
                    Logger.b bVar = new Logger.b();
                    String str2 = "[flow] send pSKey failed " + m2012exceptionOrNullimpl;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QQGuildInSearchTag.DSSearchDepositary", 1, (String) it.next(), null);
                    }
                }
                SendChannel.DefaultImpls.close$default(this.f231660a, null, 1, null);
                return;
            }
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("[onSuccess] getPskey error pSKey is empty!");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QQGuildInSearchTag.DSSearchDepositary", 1, (String) it5.next(), null);
            }
            CoroutineScopeKt.cancel(this.f231660a, new CancellationException("pskey is empty"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DSSearchDepositary$fetchPskey$1(Continuation<? super DSSearchDepositary$fetchPskey$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSSearchDepositary$fetchPskey$1 dSSearchDepositary$fetchPskey$1 = new DSSearchDepositary$fetchPskey$1(continuation);
        dSSearchDepositary$fetchPskey$1.L$0 = obj;
        return dSSearchDepositary$fetchPskey$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S0 = ch.S0(IPskeyManager.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            ((IPskeyManager) S0).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new a(producerScope));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super String> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DSSearchDepositary$fetchPskey$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
