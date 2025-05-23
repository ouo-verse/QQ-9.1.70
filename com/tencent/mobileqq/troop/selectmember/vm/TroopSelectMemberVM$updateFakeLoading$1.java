package com.tencent.mobileqq.troop.selectmember.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$updateFakeLoading$1", f = "TroopSelectMemberVM.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopSelectMemberVM$updateFakeLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopSelectMemberVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSelectMemberVM$updateFakeLoading$1(TroopSelectMemberVM troopSelectMemberVM, Continuation<? super TroopSelectMemberVM$updateFakeLoading$1> continuation) {
        super(2, continuation);
        this.this$0 = troopSelectMemberVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberVM, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSelectMemberVM$updateFakeLoading$1(this.this$0, continuation);
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0086 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TroopSelectMemberConfig troopSelectMemberConfig;
        int i3;
        int i16;
        int g26;
        int i17;
        int g27;
        int g28;
        MutableLiveData mutableLiveData;
        int i18;
        int i19;
        int coerceAtMost;
        int i26;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i27 = this.label;
            if (i27 != 0) {
                if (i27 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                TroopSelectMemberVM troopSelectMemberVM = this.this$0;
                ITroopInfoRepoApi iTroopInfoRepoApi = (ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class);
                troopSelectMemberConfig = this.this$0.innerLaunchConfig;
                TroopInfo troopInfoFromCache = iTroopInfoRepoApi.getTroopInfoFromCache(troopSelectMemberConfig.q());
                if (troopInfoFromCache != null) {
                    i3 = troopInfoFromCache.wMemberNum;
                } else {
                    i3 = 0;
                }
                troopSelectMemberVM.loadingShowMemberCount = i3;
                TroopSelectMemberVM troopSelectMemberVM2 = this.this$0;
                if (QLog.isDebugVersion()) {
                    i16 = troopSelectMemberVM2.loadingShowMemberCount;
                    g26 = troopSelectMemberVM2.g2();
                    QLog.d("TroopSelectMemberFrag.VM", 4, "[updateFakeLoading] count:" + i16 + ", curProgress:" + g26);
                }
            }
            while (i17 != 0) {
                g27 = this.this$0.g2();
                if (g27 >= 90) {
                    break;
                }
                g28 = this.this$0.g2();
                int i28 = g28 + 10;
                mutableLiveData = this.this$0._loadingProgress;
                mutableLiveData.postValue(Boxing.boxInt(i28));
                TroopSelectMemberVM troopSelectMemberVM3 = this.this$0;
                if (QLog.isDebugVersion()) {
                    mutableLiveData3 = troopSelectMemberVM3._loadingProgress;
                    QLog.d("TroopSelectMemberFrag.VM", 4, "[updateFakeLoading] loadingProgress:" + mutableLiveData3.getValue());
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String qqStr = HardCodeUtil.qqStr(R.string.ume);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopmem_90085f51)");
                i18 = this.this$0.loadingShowMemberCount;
                int i29 = (int) ((i18 * i28) / 100);
                i19 = this.this$0.loadingShowMemberCount;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i29, i19);
                i26 = this.this$0.loadingShowMemberCount;
                String format = String.format(qqStr, Arrays.copyOf(new Object[]{Boxing.boxInt(coerceAtMost), Boxing.boxInt(i26)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                mutableLiveData2 = this.this$0._loadingText;
                mutableLiveData2.postValue(format);
                this.label = 1;
                if (DelayKt.delay(800L, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSelectMemberVM$updateFakeLoading$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
