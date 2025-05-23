package com.tencent.mobileqq.wink.magicstudio;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$onImgClicked$1", f = "MagicStudioMultiViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$onImgClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pos;
    int label;
    final /* synthetic */ MagicStudioMultiViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$onImgClicked$1(MagicStudioMultiViewModel magicStudioMultiViewModel, int i3, Continuation<? super MagicStudioMultiViewModel$onImgClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioMultiViewModel;
        this.$pos = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioMultiViewModel$onImgClicked$1(this.this$0, this.$pos, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object orNull;
        ArrayList arrayList;
        MutableLiveData mutableLiveData;
        ArrayList<GenerateInfo> c16;
        int collectionSizeOrDefault;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<GenerateInfo> value = this.this$0.T1().getValue();
            if (value != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(value, this.$pos);
                GenerateInfo generateInfo = (GenerateInfo) orNull;
                if (generateInfo == null) {
                    return Unit.INSTANCE;
                }
                if (this.this$0.getIsSupportMultiSelected()) {
                    generateInfo.k(!generateInfo.getIsSelected());
                } else {
                    generateInfo.k(true);
                }
                List<GenerateInfo> value2 = this.this$0.T1().getValue();
                if (value2 != null) {
                    List<GenerateInfo> list = value2;
                    int i3 = this.$pos;
                    MagicStudioMultiViewModel magicStudioMultiViewModel = this.this$0;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    int i16 = 0;
                    for (Object obj2 : list) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        GenerateInfo generateInfo2 = (GenerateInfo) obj2;
                        if (i16 != i3 && !magicStudioMultiViewModel.getIsSupportMultiSelected()) {
                            generateInfo2.k(false);
                        }
                        arrayList.add(GenerateInfo.b(generateInfo2, null, null, false, null, null, null, null, 0, 0, 511, null));
                        i16 = i17;
                    }
                } else {
                    arrayList = null;
                }
                JumpInfo Q = MagicStudioDataSource.f323652a.Q();
                if (Q != null && (c16 = Q.c()) != null) {
                    c16.clear();
                    if (arrayList != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj3 : arrayList) {
                            if (((GenerateInfo) obj3).getIsSelected()) {
                                arrayList2.add(obj3);
                            }
                        }
                        c16.addAll(arrayList2);
                    }
                }
                mutableLiveData = this.this$0._allAigcFlow;
                mutableLiveData.postValue(arrayList);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioMultiViewModel$onImgClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
