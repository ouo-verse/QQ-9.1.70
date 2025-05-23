package com.tencent.mobileqq.troop.edittroopinfo;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.troop.TroopInfoRepo;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$fetchTroopInfo$1", f = "TroopEditInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopEditInfoViewModel$fetchTroopInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    int label;
    final /* synthetic */ TroopEditInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopEditInfoViewModel$fetchTroopInfo$1(TroopEditInfoViewModel troopEditInfoViewModel, LifecycleOwner lifecycleOwner, Continuation<? super TroopEditInfoViewModel$fetchTroopInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = troopEditInfoViewModel;
        this.$lifecycleOwner = lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopEditInfoViewModel, lifecycleOwner, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopEditInfoViewModel$fetchTroopInfo$1(this.this$0, this.$lifecycleOwner, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.S1();
                if (this.this$0.Z1() == 28) {
                    TroopInfoRepo.INSTANCE.fetchLowCreditTroopBasicInfo(this.this$0.m2(), "EditTroopInfoFragment-VM", this.$lifecycleOwner, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$fetchTroopInfo$1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(2);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEditInfoViewModel.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                            invoke(bool.booleanValue(), troopInfo);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, @NotNull TroopInfo troopInfo) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
                            } else {
                                Intrinsics.checkNotNullParameter(troopInfo, "<anonymous parameter 1>");
                                TroopEditInfoViewModel.this.y2(z16);
                            }
                        }
                    });
                } else {
                    TroopInfoRepo.INSTANCE.fetchTroopBasicInfo(this.this$0.m2(), "EditTroopInfoFragment-VM", this.$lifecycleOwner, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$fetchTroopInfo$1.2
                        static IPatchRedirector $redirector_;

                        {
                            super(2);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEditInfoViewModel.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                            invoke(bool.booleanValue(), troopInfo);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, @NotNull TroopInfo troopInfo) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
                            } else {
                                Intrinsics.checkNotNullParameter(troopInfo, "<anonymous parameter 1>");
                                TroopEditInfoViewModel.this.y2(z16);
                            }
                        }
                    });
                }
                ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).refreshTroopFace(bg.e(), this.this$0.m2());
                this.this$0.U1(this.$lifecycleOwner);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopEditInfoViewModel$fetchTroopInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
