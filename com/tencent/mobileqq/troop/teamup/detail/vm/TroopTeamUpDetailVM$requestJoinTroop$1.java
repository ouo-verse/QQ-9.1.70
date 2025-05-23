package com.tencent.mobileqq.troop.teamup.detail.vm;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$requestJoinTroop$1", f = "TroopTeamUpDetailVM.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailVM$requestJoinTroop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ TroopTeamUpDetailVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpDetailVM$requestJoinTroop$1(TroopTeamUpDetailVM troopTeamUpDetailVM, Activity activity, Continuation<? super TroopTeamUpDetailVM$requestJoinTroop$1> continuation) {
        super(2, continuation);
        this.this$0 = troopTeamUpDetailVM;
        this.$activity = activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopTeamUpDetailVM, activity, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopTeamUpDetailVM$requestJoinTroop$1(this.this$0, this.$activity, continuation);
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
        String str;
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
                this.label = 1;
                obj = f26.c(k26, i26, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.mobileqq.troop.teamup.detail.repo.b bVar = (com.tencent.mobileqq.troop.teamup.detail.repo.b) obj;
            if (bVar.c()) {
                mutableLiveData3 = this.this$0._detailData;
                TeamUpTeamDetail teamUpTeamDetail = (TeamUpTeamDetail) mutableLiveData3.getValue();
                if (teamUpTeamDetail == null || (str = Boxing.boxLong(teamUpTeamDetail.newGroupId).toString()) == null) {
                    str = "";
                }
                ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).tryLaunchJoinTroop(this.$activity, new com.tencent.mobileqq.troop.troopjoin.a(str, bVar.a(), 1025, false, null, false, 56, null), false, new Function2<TryJoinTroopResult, Integer, Unit>(str, bVar, this.this$0) { // from class: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$requestJoinTroop$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $newTroopUin;
                    final /* synthetic */ com.tencent.mobileqq.troop.teamup.detail.repo.b $result;
                    final /* synthetic */ TroopTeamUpDetailVM this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$newTroopUin = str;
                        this.$result = bVar;
                        this.this$0 = r10;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, str, bVar, r10);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(TryJoinTroopResult tryJoinTroopResult, Integer num) {
                        invoke(tryJoinTroopResult, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(@NotNull TryJoinTroopResult joinTroopResult, int i16) {
                        MutableLiveData mutableLiveData4;
                        MutableLiveData mutableLiveData5;
                        MutableLiveData mutableLiveData6;
                        MutableLiveData mutableLiveData7;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) joinTroopResult, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(joinTroopResult, "joinTroopResult");
                        QLog.d("TroopTeamUpDetailVM", 1, "requestJoinTroop: tryLaunchJoinTroop newTroopUin=" + this.$newTroopUin + ", result=" + joinTroopResult + ", errCode=" + i16 + ", auth=" + this.$result.a());
                        if (joinTroopResult == TryJoinTroopResult.HAS_JOINED) {
                            mutableLiveData5 = this.this$0._detailData;
                            TeamUpTeamDetail teamUpTeamDetail2 = (TeamUpTeamDetail) mutableLiveData5.getValue();
                            if (teamUpTeamDetail2 != null) {
                                teamUpTeamDetail2.isJoined = true;
                            }
                            mutableLiveData6 = this.this$0._detailData;
                            mutableLiveData7 = this.this$0._detailData;
                            mutableLiveData6.postValue(mutableLiveData7.getValue());
                        }
                        mutableLiveData4 = this.this$0._joinTroopResult;
                        mutableLiveData4.postValue(joinTroopResult);
                    }
                });
            } else {
                mutableLiveData2 = this.this$0._errMsg;
                mutableLiveData2.postValue(bVar.b());
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopTeamUpDetailVM$requestJoinTroop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
