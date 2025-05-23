package com.tencent.filament.zplan.plugin;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.plugin.FilamentZipPlugin$unzip$1", f = "FilamentZipPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilamentZipPlugin$unzip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $folderPath;
    final /* synthetic */ com.tencent.filament.zplan.engine.js.a $req;
    final /* synthetic */ String $zipFilePath;
    int label;
    final /* synthetic */ FilamentZipPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentZipPlugin$unzip$1(FilamentZipPlugin filamentZipPlugin, String str, String str2, com.tencent.filament.zplan.engine.js.a aVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentZipPlugin;
        this.$zipFilePath = str;
        this.$folderPath = str2;
        this.$req = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentZipPlugin$unzip$1(this.this$0, this.$zipFilePath, this.$folderPath, this.$req, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentZipPlugin$unzip$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String b16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FilamentZipPlugin filamentZipPlugin = this.this$0;
            String zipFilePath = this.$zipFilePath;
            Intrinsics.checkNotNullExpressionValue(zipFilePath, "zipFilePath");
            String folderPath = this.$folderPath;
            Intrinsics.checkNotNullExpressionValue(folderPath, "folderPath");
            b16 = filamentZipPlugin.b(zipFilePath, folderPath);
            if (b16 == null) {
                this.$req.f();
            } else {
                this.$req.b(b16);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
