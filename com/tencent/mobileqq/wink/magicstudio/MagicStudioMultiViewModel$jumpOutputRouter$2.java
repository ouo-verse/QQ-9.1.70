package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$jumpOutputRouter$2", f = "MagicStudioMultiViewModel.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$jumpOutputRouter$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicStudioMultiViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$jumpOutputRouter$2(MagicStudioMultiViewModel magicStudioMultiViewModel, Continuation<? super MagicStudioMultiViewModel$jumpOutputRouter$2> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioMultiViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioMultiViewModel$jumpOutputRouter$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List emptyList;
        MutableSharedFlow mutableSharedFlow;
        ArrayList<GenerateInfo> c16;
        int collectionSizeOrDefault;
        HashMap<String, Serializable> hashMapOf;
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
            JumpInfo a26 = this.this$0.a2();
            if (a26 == null || (c16 = a26.c()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : c16) {
                    if (((GenerateInfo) obj2).getIsSelected()) {
                        arrayList.add(obj2);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                emptyList = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    LocalMediaInfo c17 = ba3.a.c(((GenerateInfo) it.next()).getAigcImgPath());
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT));
                    c17.extData = hashMapOf;
                    emptyList.add(c17);
                }
            }
            mutableSharedFlow = this.this$0._event;
            MagicStudioMultiViewModel.b.GotoOutputRouter gotoOutputRouter = new MagicStudioMultiViewModel.b.GotoOutputRouter(emptyList);
            this.label = 1;
            if (mutableSharedFlow.emit(gotoOutputRouter, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioMultiViewModel$jumpOutputRouter$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
