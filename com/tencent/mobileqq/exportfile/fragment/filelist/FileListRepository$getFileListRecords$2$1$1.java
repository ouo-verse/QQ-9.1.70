package com.tencent.mobileqq.exportfile.fragment.filelist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.FileListRepository$getFileListRecords$2$1$1", f = "FileListRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class FileListRepository$getFileListRecords$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function2<Integer, List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> $callback;
    final /* synthetic */ ArrayList<FileBridgeNodeInfo> $content;
    final /* synthetic */ int $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileListRepository$getFileListRecords$2$1$1(Function2<? super Integer, ? super List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> function2, int i3, ArrayList<FileBridgeNodeInfo> arrayList, Continuation<? super FileListRepository$getFileListRecords$2$1$1> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.$result = i3;
        this.$content = arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, function2, Integer.valueOf(i3), arrayList, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new FileListRepository$getFileListRecords$2$1$1(this.$callback, this.$result, this.$content, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<Integer, List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> function2 = this.$callback;
                Integer boxInt = Boxing.boxInt(this.$result);
                ArrayList<FileBridgeNodeInfo> content = this.$content;
                Intrinsics.checkNotNullExpressionValue(content, "content");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(content, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (FileBridgeNodeInfo it : content) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(new com.tencent.mobileqq.exportfile.fragment.filelist.data.c(it, null, false, false, null, 30, null));
                }
                function2.invoke(boxInt, arrayList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((FileListRepository$getFileListRecords$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
