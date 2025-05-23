package com.tencent.mobileqq.search.unitsearch.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.api.ISearchEntryRuntimeService;
import com.tencent.mobileqq.search.business.activatepage.ActivatePageRepo;
import com.tencent.mobileqq.search.model.DiscoveryResultData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import kotlin.Metadata;
import kotlin.Result;
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
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.unitsearch.viewmodel.UniteSearchViewModel$requestSearchDiscoveryData$1", f = "UniteSearchViewModel.kt", i = {0, 0}, l = {89}, m = "invokeSuspend", n = {"$this$qLaunch", IProfileCardConst.KEY_FROM_TYPE}, s = {"L$0", "I$0"})
/* loaded from: classes18.dex */
public final class UniteSearchViewModel$requestSearchDiscoveryData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UniteSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniteSearchViewModel$requestSearchDiscoveryData$1(UniteSearchViewModel uniteSearchViewModel, Continuation<? super UniteSearchViewModel$requestSearchDiscoveryData$1> continuation) {
        super(2, continuation);
        this.this$0 = uniteSearchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UniteSearchViewModel$requestSearchDiscoveryData$1 uniteSearchViewModel$requestSearchDiscoveryData$1 = new UniteSearchViewModel$requestSearchDiscoveryData$1(this.this$0, continuation);
        uniteSearchViewModel$requestSearchDiscoveryData$1.L$0 = obj;
        return uniteSearchViewModel$requestSearchDiscoveryData$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int O1;
        int i3;
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = this.I$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th5) {
                    th = th5;
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                    UniteSearchViewModel uniteSearchViewModel = this.this$0;
                    if (Result.m483isSuccessimpl(m476constructorimpl)) {
                    }
                    UniteSearchViewModel uniteSearchViewModel2 = this.this$0;
                    m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                    }
                    if (Result.m482isFailureimpl(m476constructorimpl)) {
                    }
                    if (((UfsDisRspBody) m476constructorimpl) == null) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            O1 = this.this$0.O1();
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch..UniteSearchViewModel", 2, "change type origin " + this.this$0.getMFrom() + " after" + O1);
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISearchEntryRuntimeService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            ISearchEntryRuntimeService iSearchEntryRuntimeService = (ISearchEntryRuntimeService) runtimeService;
            try {
                Result.Companion companion2 = Result.INSTANCE;
                this.L$0 = coroutineScope;
                this.I$0 = O1;
                this.label = 1;
                obj = ISearchEntryRuntimeService.a.a(iSearchEntryRuntimeService, O1, false, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3 = O1;
            } catch (Throwable th6) {
                th = th6;
                i3 = O1;
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                UniteSearchViewModel uniteSearchViewModel3 = this.this$0;
                if (Result.m483isSuccessimpl(m476constructorimpl)) {
                }
                UniteSearchViewModel uniteSearchViewModel22 = this.this$0;
                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                }
                if (((UfsDisRspBody) m476constructorimpl) == null) {
                }
                return Unit.INSTANCE;
            }
        }
        m476constructorimpl = Result.m476constructorimpl((UfsDisRspBody) obj);
        UniteSearchViewModel uniteSearchViewModel32 = this.this$0;
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            uniteSearchViewModel32.P1((UfsDisRspBody) m476constructorimpl, i3);
        }
        UniteSearchViewModel uniteSearchViewModel222 = this.this$0;
        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("Q.uniteSearch..UniteSearchViewModel", 1, "error when requestSearchDiscoveryData:" + m479exceptionOrNullimpl);
            if (m479exceptionOrNullimpl instanceof ActivatePageRepo.ThrowableWithError) {
                mutableLiveData2 = uniteSearchViewModel222._searchDiscoveryResult;
                ActivatePageRepo.ThrowableWithError throwableWithError = (ActivatePageRepo.ThrowableWithError) m479exceptionOrNullimpl;
                mutableLiveData2.postValue(new DiscoveryResultData(false, null, Boxing.boxInt(i3), null, throwableWithError.getErrorCode(), throwableWithError.getErrorMsg(), 10, null));
            }
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        if (((UfsDisRspBody) m476constructorimpl) == null) {
            UniteSearchViewModel uniteSearchViewModel4 = this.this$0;
            QLog.e("Q.uniteSearch..UniteSearchViewModel", 1, "discoveryData got null");
            mutableLiveData = uniteSearchViewModel4._searchDiscoveryResult;
            mutableLiveData.postValue(new DiscoveryResultData(false, null, Boxing.boxInt(i3), null, 0, null, 58, null));
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UniteSearchViewModel$requestSearchDiscoveryData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
