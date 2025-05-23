package com.tencent.mobileqq.wink.templatelibrary.viewmodel;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.utils.WinkTemplateFavouriteIdUtils2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qa3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.viewmodel.WinkTemplateViewModel$onUpdate$1", f = "WinkTemplateViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkTemplateViewModel$onUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<MetaCategory> $templateCategory;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkTemplateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateViewModel$onUpdate$1(WinkTemplateViewModel winkTemplateViewModel, ArrayList<MetaCategory> arrayList, Continuation<? super WinkTemplateViewModel$onUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = winkTemplateViewModel;
        this.$templateCategory = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkTemplateViewModel$onUpdate$1(this.this$0, this.$templateCategory, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkTemplateViewModel winkTemplateViewModel;
        List list;
        List<MetaCategory> O1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                list = (List) this.L$1;
                winkTemplateViewModel = (WinkTemplateViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            winkTemplateViewModel = this.this$0;
            ArrayList<MetaCategory> arrayList = this.$templateCategory;
            WinkTemplateFavouriteIdUtils2 winkTemplateFavouriteIdUtils2 = WinkTemplateFavouriteIdUtils2.f326648a;
            this.L$0 = winkTemplateViewModel;
            this.L$1 = arrayList;
            this.label = 1;
            Object h16 = winkTemplateFavouriteIdUtils2.h(this);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList;
            obj = h16;
        }
        O1 = winkTemplateViewModel.O1(list, (List) obj);
        this.this$0.X1(O1);
        b.f428767a.b(O1, true);
        this.this$0.Q1().postValue(O1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkTemplateViewModel$onUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
