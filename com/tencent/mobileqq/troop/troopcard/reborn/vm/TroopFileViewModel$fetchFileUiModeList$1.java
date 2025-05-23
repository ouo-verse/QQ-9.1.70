package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopFileViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopFileViewModel$fetchFileUiModeList$1", f = "TroopFileViewModel.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopFileViewModel$fetchFileUiModeList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $cookie;
    int label;
    final /* synthetic */ TroopFileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileViewModel$fetchFileUiModeList$1(TroopFileViewModel troopFileViewModel, String str, Continuation<? super TroopFileViewModel$fetchFileUiModeList$1> continuation) {
        super(2, continuation);
        this.this$0 = troopFileViewModel;
        this.$cookie = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopFileViewModel, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopFileViewModel$fetchFileUiModeList$1(this.this$0, this.$cookie, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TroopCardRepo troopCardRepo;
        long j3;
        int i3;
        List list;
        MutableLiveData mutableLiveData;
        List list2;
        List list3;
        MutableLiveData mutableLiveData2;
        List list4;
        List list5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            if (i16 != 0) {
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                troopCardRepo = this.this$0.repo;
                j3 = this.this$0.troopUin;
                i3 = this.this$0.source;
                String str = this.$cookie;
                this.label = 1;
                obj = troopCardRepo.n(j3, i3, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.mobileqq.troop.troopcard.reborn.repo.model.c cVar = (com.tencent.mobileqq.troop.troopcard.reborn.repo.model.c) obj;
            if (cVar.a() == null) {
                mutableLiveData2 = this.this$0._state;
                list4 = this.this$0.fileList;
                list5 = CollectionsKt___CollectionsKt.toList(list4);
                mutableLiveData2.setValue(new TroopFileViewModel.b.a(list5));
                return Unit.INSTANCE;
            }
            this.this$0.cookie = cVar.a().a();
            this.this$0.isEnd = cVar.a().c();
            list = this.this$0.fileList;
            list.addAll(cVar.a().b());
            mutableLiveData = this.this$0._state;
            list2 = this.this$0.fileList;
            list3 = CollectionsKt___CollectionsKt.toList(list2);
            mutableLiveData.setValue(new TroopFileViewModel.b.c(list3));
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopFileViewModel$fetchFileUiModeList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
