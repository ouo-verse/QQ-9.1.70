package com.tencent.mobileqq.wink.magicstudio;

import android.text.TextUtils;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$saveAIGCHistory$1", f = "MagicStudioMultiViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$saveAIGCHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GenerateInfo> $generates;
    int label;
    final /* synthetic */ MagicStudioMultiViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$saveAIGCHistory$1(List<GenerateInfo> list, MagicStudioMultiViewModel magicStudioMultiViewModel, Continuation<? super MagicStudioMultiViewModel$saveAIGCHistory$1> continuation) {
        super(2, continuation);
        this.$generates = list;
        this.this$0 = magicStudioMultiViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioMultiViewModel$saveAIGCHistory$1(this.$generates, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int collectionSizeOrDefault;
        List listOf;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<GenerateInfo> list = this.$generates;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (!TextUtils.isEmpty(((GenerateInfo) obj2).getAigcImgPath())) {
                    arrayList.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((GenerateInfo) it.next()).getAigcImgPath());
            }
            MagicStudioUploadImgInfo currentImg = this.this$0.getCurrentImg();
            if (currentImg != null) {
                m83.a aVar = m83.a.f416440a;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new MagicStudioHistoryImageModel(currentImg.getOriginFilePath(), currentImg.getOriginFileMd5(), currentImg.getCompressUrl(), currentImg.getCropFaceUrl(), System.currentTimeMillis(), arrayList2));
                m83.a.i(aVar, listOf, null, 2, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioMultiViewModel$saveAIGCHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
