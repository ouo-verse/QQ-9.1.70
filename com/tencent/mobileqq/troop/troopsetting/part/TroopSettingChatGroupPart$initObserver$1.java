package com.tencent.mobileqq.troop.troopsetting.part;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatGroupPart$initObserver$1", f = "TroopSettingChatGroupPart.kt", i = {}, l = {766}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopSettingChatGroupPart$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopSettingChatGroupPart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.troop.troopsetting.event.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopSettingChatGroupPart f301266d;

        public a(TroopSettingChatGroupPart troopSettingChatGroupPart) {
            this.f301266d = troopSettingChatGroupPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingChatGroupPart);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.widget.listitem.x] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.troop.troopsetting.event.a aVar, @NotNull Continuation<? super Unit> continuation) {
            boolean areEqual;
            boolean z16;
            boolean z17;
            com.tencent.mobileqq.troop.troopsetting.customconfig.b bVar;
            com.tencent.mobileqq.widget.listitem.x xVar;
            ?? r16;
            com.tencent.mobileqq.troop.troopsetting.customconfig.b bVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
            }
            com.tencent.mobileqq.troop.troopsetting.event.a aVar2 = aVar;
            if (aVar2 instanceof a.ad) {
                this.f301266d.Qa(((a.ad) aVar2).a());
            } else {
                com.tencent.mobileqq.troop.troopsetting.customconfig.b bVar3 = null;
                if (aVar2 instanceof a.ae) {
                    bVar2 = this.f301266d.troopNoticeConfig;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopNoticeConfig");
                    } else {
                        bVar3 = bVar2;
                    }
                    com.tencent.mobileqq.troop.troopsetting.activity.a.k(bVar3.K(), ((a.ae) aVar2).a());
                } else if (aVar2 instanceof a.aa) {
                    this.f301266d.ja();
                } else if (aVar2 instanceof a.c) {
                    this.f301266d.Sa();
                    TroopSettingChatGroupPart troopSettingChatGroupPart = this.f301266d;
                    troopSettingChatGroupPart.Ra(troopSettingChatGroupPart.B9().S2().troopRemark);
                } else if (aVar2 instanceof a.d) {
                    xVar = this.f301266d.groupNameConfig;
                    if (xVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupNameConfig");
                        xVar = null;
                    }
                    xVar.x(null);
                    TroopSettingChatGroupPart troopSettingChatGroupPart2 = this.f301266d;
                    r16 = troopSettingChatGroupPart2.groupNameConfig;
                    if (r16 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupNameConfig");
                    } else {
                        bVar3 = r16;
                    }
                    troopSettingChatGroupPart2.D9(bVar3);
                } else {
                    if (aVar2 instanceof a.ai) {
                        areEqual = true;
                    } else {
                        areEqual = Intrinsics.areEqual(aVar2, a.t.f301133a);
                    }
                    if (areEqual) {
                        this.f301266d.Sa();
                    } else if (aVar2 instanceof a.ab) {
                        ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.f301266d.z9(), this.f301266d.B9().T2().troopUin, "troop", 3, 0);
                        bVar = this.f301266d.myTroopMemberCardConfig;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("myTroopMemberCardConfig");
                        } else {
                            bVar3 = bVar;
                        }
                        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, (TextView) ((FormItemRelativeLayout) bVar3.K()).findViewById(R.id.i_f));
                    } else if (aVar2 instanceof a.b) {
                        this.f301266d.Ka();
                    } else if (aVar2 instanceof a.k) {
                        z16 = this.f301266d.isHomeworkTroop;
                        a.k kVar = (a.k) aVar2;
                        if (z16 != kVar.a().isHomeworkTroop()) {
                            this.f301266d.isHomeworkTroop = kVar.a().isHomeworkTroop();
                            TroopSettingChatGroupPart troopSettingChatGroupPart3 = this.f301266d;
                            z17 = troopSettingChatGroupPart3.isHomeworkTroop;
                            troopSettingChatGroupPart3.Pa(z17);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSettingChatGroupPart$initObserver$1(TroopSettingChatGroupPart troopSettingChatGroupPart, Continuation<? super TroopSettingChatGroupPart$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = troopSettingChatGroupPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingChatGroupPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSettingChatGroupPart$initObserver$1(this.this$0, continuation);
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
                StateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> V2 = this.this$0.B9().V2();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (V2.collect(aVar, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSettingChatGroupPart$initObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
