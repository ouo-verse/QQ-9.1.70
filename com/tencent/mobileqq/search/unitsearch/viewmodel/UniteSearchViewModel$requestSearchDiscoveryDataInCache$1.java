package com.tencent.mobileqq.search.unitsearch.viewmodel;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.api.ISearchEntryRuntimeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.unitsearch.viewmodel.UniteSearchViewModel$requestSearchDiscoveryDataInCache$1", f = "UniteSearchViewModel.kt", i = {0}, l = {68}, m = "invokeSuspend", n = {IProfileCardConst.KEY_FROM_TYPE}, s = {"I$0"})
/* loaded from: classes18.dex */
public final class UniteSearchViewModel$requestSearchDiscoveryDataInCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ UniteSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniteSearchViewModel$requestSearchDiscoveryDataInCache$1(UniteSearchViewModel uniteSearchViewModel, Continuation<? super UniteSearchViewModel$requestSearchDiscoveryDataInCache$1> continuation) {
        super(2, continuation);
        this.this$0 = uniteSearchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UniteSearchViewModel$requestSearchDiscoveryDataInCache$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int O1;
        int i3;
        Throwable th5;
        Object m476constructorimpl;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = this.I$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th6) {
                    th5 = th6;
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    UniteSearchViewModel uniteSearchViewModel = this.this$0;
                    if (Result.m483isSuccessimpl(m476constructorimpl)) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            O1 = this.this$0.O1();
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch..UniteSearchViewModel", 2, "reqCache change type origin " + this.this$0.getMFrom() + " after" + O1);
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISearchEntryRuntimeService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            ISearchEntryRuntimeService iSearchEntryRuntimeService = (ISearchEntryRuntimeService) runtimeService;
            try {
                Result.Companion companion2 = Result.INSTANCE;
                this.I$0 = O1;
                this.label = 1;
                Object requestSearchDiscoveryData = iSearchEntryRuntimeService.requestSearchDiscoveryData(O1, true, this);
                if (requestSearchDiscoveryData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3 = O1;
                obj = requestSearchDiscoveryData;
            } catch (Throwable th7) {
                i3 = O1;
                th5 = th7;
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                UniteSearchViewModel uniteSearchViewModel2 = this.this$0;
                if (Result.m483isSuccessimpl(m476constructorimpl)) {
                }
                return Unit.INSTANCE;
            }
        }
        m476constructorimpl = Result.m476constructorimpl((UfsDisRspBody) obj);
        UniteSearchViewModel uniteSearchViewModel22 = this.this$0;
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            UfsDisRspBody ufsDisRspBody = (UfsDisRspBody) m476constructorimpl;
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch..UniteSearchViewModel", 2, "reqCache success");
            }
            uniteSearchViewModel22.P1(ufsDisRspBody, i3);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UniteSearchViewModel$requestSearchDiscoveryDataInCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
