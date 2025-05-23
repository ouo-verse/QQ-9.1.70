package com.tencent.qqnt.notification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.trace.INotifyTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.notification.NotificationFacade$showMessageNotification$showFunc$1$invoke$1", f = "NotificationFacade.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
public final class NotificationFacade$showMessageNotification$showFunc$1$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ NotificationCommonInfo $commonInfo;
    final /* synthetic */ boolean $forRevoke;
    final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.a $friendOtherInfo;
    final /* synthetic */ RecentContactInfo $msgRecord;
    int label;
    final /* synthetic */ NotificationFacade this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationFacade$showMessageNotification$showFunc$1$invoke$1(NotificationFacade notificationFacade, AppRuntime appRuntime, RecentContactInfo recentContactInfo, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar, NotificationCommonInfo notificationCommonInfo, boolean z16, Continuation<? super NotificationFacade$showMessageNotification$showFunc$1$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = notificationFacade;
        this.$app = appRuntime;
        this.$msgRecord = recentContactInfo;
        this.$friendOtherInfo = aVar;
        this.$commonInfo = notificationCommonInfo;
        this.$forRevoke = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, notificationFacade, appRuntime, recentContactInfo, aVar, notificationCommonInfo, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new NotificationFacade$showMessageNotification$showFunc$1$invoke$1(this.this$0, this.$app, this.$msgRecord, this.$friendOtherInfo, this.$commonInfo, this.$forRevoke, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a aVar;
        INotifyTracker iNotifyTracker;
        a aVar2;
        a aVar3;
        com.tencent.qqnt.global.settings.notification.a aVar4;
        boolean J;
        a aVar5;
        a aVar6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.F(this.$app);
                com.tencent.qqnt.notification.util.a aVar7 = com.tencent.qqnt.notification.util.a.f359909a;
                aVar7.a(new Function0<String>(this.this$0, this.$msgRecord) { // from class: com.tencent.qqnt.notification.NotificationFacade$showMessageNotification$showFunc$1$invoke$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ RecentContactInfo $msgRecord;
                    final /* synthetic */ NotificationFacade this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = r9;
                        this.$msgRecord = r10;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, NotificationCommonInfo.this, r9, r10);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        String B;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        NotificationCommonInfo notificationCommonInfo = NotificationCommonInfo.this;
                        Long valueOf = notificationCommonInfo != null ? Long.valueOf(notificationCommonInfo.msgListUnreadCnt) : null;
                        B = this.this$0.B(this.$msgRecord);
                        return "start handle message notification, unreadCnt:" + valueOf + " record:{" + B + "}";
                    }
                });
                aVar = this.this$0.injector;
                a aVar8 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("injector");
                    aVar = null;
                }
                com.tencent.qqnt.notification.inject.e f16 = aVar.f();
                if (f16 != null) {
                    iNotifyTracker = f16.a(this.$app, this.$msgRecord);
                } else {
                    iNotifyTracker = null;
                }
                aVar2 = this.this$0.injector;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("injector");
                    aVar2 = null;
                }
                if (aVar2.b().a(this.$app, this.$msgRecord, iNotifyTracker)) {
                    aVar3 = this.this$0.injector;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("injector");
                        aVar3 = null;
                    }
                    aVar3.b().i(this.$app, this.$msgRecord);
                    com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar9 = this.$friendOtherInfo;
                    if (aVar9 != null) {
                        aVar4 = new com.tencent.qqnt.global.settings.notification.a(aVar9.G());
                    } else {
                        aVar4 = null;
                    }
                    J = this.this$0.J(this.$app, this.$msgRecord, this.$commonInfo, this.$forRevoke, iNotifyTracker, aVar4);
                    if (!this.$forRevoke) {
                        aVar5 = this.this$0.injector;
                        if (aVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("injector");
                            aVar5 = null;
                        }
                        if (aVar5.b().c(this.$app, this.$msgRecord, J, iNotifyTracker)) {
                            aVar6 = this.this$0.injector;
                            if (aVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("injector");
                            } else {
                                aVar8 = aVar6;
                            }
                            aVar8.e().c(this.$msgRecord);
                            if (iNotifyTracker != null) {
                                iNotifyTracker.s(true);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    if (iNotifyTracker != null) {
                        iNotifyTracker.s(false);
                    }
                    return Unit.INSTANCE;
                }
                aVar7.a(new Function0<String>() { // from class: com.tencent.qqnt.notification.NotificationFacade$showMessageNotification$showFunc$1$invoke$1.2
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "failed to pass business check, msgId=" + RecentContactInfo.this.msgId;
                    }
                });
                if (iNotifyTracker != null) {
                    iNotifyTracker.t();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NotificationFacade$showMessageNotification$showFunc$1$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
