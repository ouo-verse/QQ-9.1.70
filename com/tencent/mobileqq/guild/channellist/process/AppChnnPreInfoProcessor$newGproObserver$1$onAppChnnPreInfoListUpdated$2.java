package com.tencent.mobileqq.guild.channellist.process;

import com.tencent.mobileqq.guild.channellist.process.AppChnnPreInfoProcessor;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.process.AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2", f = "AppChnnPreInfoProcessor.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $changeIds;
    final /* synthetic */ List<String> $removeIds;
    int label;
    final /* synthetic */ AppChnnPreInfoProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2(List<String> list, List<String> list2, AppChnnPreInfoProcessor appChnnPreInfoProcessor, Continuation<? super AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2> continuation) {
        super(2, continuation);
        this.$removeIds = list;
        this.$changeIds = list2;
        this.this$0 = appChnnPreInfoProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2(this.$removeIds, this.$changeIds, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        byte b16;
        byte b17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList(this.$removeIds.size() + this.$changeIds.size());
            Iterator<String> it = this.$changeIds.iterator();
            while (true) {
                String str = null;
                b17 = 0;
                b16 = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                IGProAppChnnPreInfo appChnnPreInfo = this.this$0.u().getAppChnnPreInfo(this.this$0.activateGuildId, next);
                if (appChnnPreInfo != null) {
                    str = appChnnPreInfo.getText();
                }
                arrayList.add(TuplesKt.to(next, new AppChnnPreInfoProcessor.PreInfoData(str)));
            }
            Iterator<String> it5 = this.$removeIds.iterator();
            while (it5.hasNext()) {
                arrayList.add(TuplesKt.to(it5.next(), new AppChnnPreInfoProcessor.PreInfoData(b16 == true ? 1 : 0, i16, b17 == true ? 1 : 0)));
            }
            ItemsProcessEvent itemsProcessEvent = new ItemsProcessEvent(this.this$0.activateGuildId, this.this$0, arrayList);
            Logger.f235387a.d().i("AppChnnPreInfoProcessor", 1, "preInfoUpdate: event=" + itemsProcessEvent);
            mutableSharedFlow = this.this$0._flow;
            this.label = 1;
            if (mutableSharedFlow.emit(itemsProcessEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppChnnPreInfoProcessor$newGproObserver$1$onAppChnnPreInfoListUpdated$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
