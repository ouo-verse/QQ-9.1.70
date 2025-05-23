package com.tencent.qqnt.chathistory.ui.date.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.date.data.datasource.PlatformDateDataSource;
import com.tencent.qqnt.chathistory.ui.date.data.model.b;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/tencent/qqnt/chathistory/ui/date/data/model/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.date.data.datasource.PlatformDateDataSource$searchHistoryDate$1", f = "PlatformDateDataSource.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class PlatformDateDataSource$searchHistoryDate$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends b>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $chatType;
    final /* synthetic */ long $curDate;
    final /* synthetic */ String $peerId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformDateDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformDateDataSource$searchHistoryDate$1(int i3, long j3, PlatformDateDataSource platformDateDataSource, String str, Continuation<? super PlatformDateDataSource$searchHistoryDate$1> continuation) {
        super(2, continuation);
        this.$chatType = i3;
        this.$curDate = j3;
        this.this$0 = platformDateDataSource;
        this.$peerId = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), platformDateDataSource, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PlatformDateDataSource$searchHistoryDate$1 platformDateDataSource$searchHistoryDate$1 = new PlatformDateDataSource$searchHistoryDate$1(this.$chatType, this.$curDate, this.this$0, this.$peerId, continuation);
        platformDateDataSource$searchHistoryDate$1.L$0 = obj;
        return platformDateDataSource$searchHistoryDate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super List<? extends b>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super List<b>>) producerScope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        w c16;
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
                ProducerScope producerScope = (ProducerScope) this.L$0;
                d.f354054a.a("PlatformDateDataSource", "searchHistoryDate result " + this.$chatType + "  " + this.$curDate);
                c16 = this.this$0.c();
                if (c16 != null) {
                    Contact contact = new Contact();
                    int i16 = this.$chatType;
                    String str = this.$peerId;
                    contact.chatType = i16;
                    contact.peerUid = str;
                    c16.queryRoamCalendar(contact, this.$curDate, new PlatformDateDataSource.b(new WeakReference(producerScope), new WeakReference(this.this$0)));
                }
                AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super List<b>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PlatformDateDataSource$searchHistoryDate$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
