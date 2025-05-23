package com.tencent.mobileqq.emoticonview.ai.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.l;
import com.tencent.qqnt.kernel.nativeinterface.PicMaterial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PicMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1", f = "AiEmoticonUploadHelper.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PicMaterial>>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ l $bdhUploadService;
    final /* synthetic */ List<Pair<String, String>> $pathMd5List;
    final /* synthetic */ List<PicModel> $picModelList;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1(List<Pair<String, String>> list, l lVar, List<PicModel> list2, Continuation<? super AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1> continuation) {
        super(2, continuation);
        this.$pathMd5List = list;
        this.$bdhUploadService = lVar;
        this.$picModelList = list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, lVar, list2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1 aiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1 = new AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1(this.$pathMd5List, this.$bdhUploadService, this.$picModelList, continuation);
        aiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1.L$0 = obj;
        return aiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PicMaterial>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<PicMaterial>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        Deferred async$default;
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
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                List<Pair<String, String>> list = this.$pathMd5List;
                l lVar = this.$bdhUploadService;
                List<PicModel> list2 = this.$picModelList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1((Pair) it.next(), lVar, list2, null), 3, null);
                    arrayList.add(async$default);
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<PicMaterial>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
