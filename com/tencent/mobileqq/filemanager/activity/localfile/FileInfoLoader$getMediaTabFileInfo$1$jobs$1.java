package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.CostData;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LoadParam;
import java.util.HashMap;
import java.util.HashSet;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a4\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0005*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mobileqq/filemanager/data/FileInfo;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.filemanager.activity.localfile.FileInfoLoader$getMediaTabFileInfo$1$jobs$1", f = "FileInfoLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class FileInfoLoader$getMediaTabFileInfo$1$jobs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, HashSet<FileInfo>>>, Object> {
    final /* synthetic */ CostData $costData;
    final /* synthetic */ LoadParam $loadParams;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileInfoLoader$getMediaTabFileInfo$1$jobs$1(LoadParam loadParam, CostData costData, Continuation<? super FileInfoLoader$getMediaTabFileInfo$1$jobs$1> continuation) {
        super(2, continuation);
        this.$loadParams = loadParam;
        this.$costData = costData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileInfoLoader$getMediaTabFileInfo$1$jobs$1(this.$loadParams, this.$costData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        HashMap B;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            B = FileInfoLoader.f206609a.B(this.$loadParams, this.$costData);
            return B;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super HashMap<String, HashSet<FileInfo>>> continuation) {
        return ((FileInfoLoader$getMediaTabFileInfo$1$jobs$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
