package com.tencent.mobileqq.troop.teamup.detail.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.detail.repo.c;
import com.tencent.mobileqq.troop.teamup.member.event.TroopTeamUpUpdateEvent;
import com.tencent.mobileqq.troop.utils.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.util.ArrayList;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$applyTeamUp$1", f = "TroopTeamUpDetailVM.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailVM$applyTeamUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ArrayList<TeamUpImage> $pictures;
    int label;
    final /* synthetic */ TroopTeamUpDetailVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpDetailVM$applyTeamUp$1(TroopTeamUpDetailVM troopTeamUpDetailVM, ArrayList<TeamUpImage> arrayList, Continuation<? super TroopTeamUpDetailVM$applyTeamUp$1> continuation) {
        super(2, continuation);
        this.this$0 = troopTeamUpDetailVM;
        this.$pictures = arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopTeamUpDetailVM, arrayList, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopTeamUpDetailVM$applyTeamUp$1(this.this$0, this.$pictures, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        com.tencent.mobileqq.troop.teamup.detail.repo.c f26;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
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
                mutableLiveData = this.this$0._detailData;
                if (mutableLiveData.getValue() == 0) {
                    QLog.e("TroopTeamUpDetailVM", 1, "applyTeamUp: detailData is null");
                }
                f26 = this.this$0.f2();
                String k26 = this.this$0.k2();
                String i26 = this.this$0.i2();
                ArrayList<TeamUpImage> arrayList = this.$pictures;
                this.label = 1;
                obj = f26.a(k26, i26, arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            c.a aVar = (c.a) obj;
            if (aVar.b()) {
                mutableLiveData3 = this.this$0._detailData;
                final TeamUpTeamDetail teamUpTeamDetail = (TeamUpTeamDetail) mutableLiveData3.getValue();
                if (teamUpTeamDetail != null) {
                    TroopTeamUpDetailVM troopTeamUpDetailVM = this.this$0;
                    teamUpTeamDetail.isJoined = true;
                    teamUpTeamDetail.joinedCnt++;
                    mutableLiveData5 = troopTeamUpDetailVM._detailData;
                    mutableLiveData5.postValue(teamUpTeamDetail);
                    p.f302196a.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$applyTeamUp$1$1$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TeamUpTeamDetail.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                            String str = TeamUpTeamDetail.this.teamId;
                            Intrinsics.checkNotNullExpressionValue(str, "detail.teamId");
                            simpleEventBus.dispatchEvent(new TroopTeamUpUpdateEvent.ApplyTeamUpSuccess(str));
                        }
                    });
                }
                mutableLiveData4 = this.this$0._applyResult;
                mutableLiveData4.postValue(new com.tencent.mobileqq.troop.teamup.detail.vm.data.a(true, aVar.a(), !this.$pictures.isEmpty()));
            } else {
                mutableLiveData2 = this.this$0._applyResult;
                mutableLiveData2.postValue(new com.tencent.mobileqq.troop.teamup.detail.vm.data.a(false, aVar.a(), true ^ this.$pictures.isEmpty()));
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopTeamUpDetailVM$applyTeamUp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
