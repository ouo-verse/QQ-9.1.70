package com.tencent.localedit.fakenative.convert;

import com.tencent.localedit.JNI;
import com.tencent.localedit.fakenative.meta.ChunkConvertResult;
import kotlin.Metadata;
import kotlin.Result;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/localedit/fakenative/meta/ChunkConvertResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.convert.FileConvertDelegate$chunkImport$2", f = "FileConvertDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FileConvertDelegate$chunkImport$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChunkConvertResult>, Object> {
    final /* synthetic */ int $chunkIndex;
    final /* synthetic */ int $chunkSize;
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileConvertDelegate$chunkImport$2(int i3, int i16, String str, Continuation<? super FileConvertDelegate$chunkImport$2> continuation) {
        super(2, continuation);
        this.$chunkIndex = i3;
        this.$chunkSize = i16;
        this.$srcPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileConvertDelegate$chunkImport$2 fileConvertDelegate$chunkImport$2 = new FileConvertDelegate$chunkImport$2(this.$chunkIndex, this.$chunkSize, this.$srcPath, continuation);
        fileConvertDelegate$chunkImport$2.L$0 = obj;
        return fileConvertDelegate$chunkImport$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.$chunkIndex;
            int i16 = this.$chunkSize;
            String str = this.$srcPath;
            try {
                Result.Companion companion = Result.INSTANCE;
                ChunkConvertResult chunkImport = JNI.chunkImport(i3, i16, str);
                x11.b.f446855a.a("FileConvertDelegate", Intrinsics.stringPlus("Local_edit chunkImport finalResult=", chunkImport));
                m476constructorimpl = Result.m476constructorimpl(chunkImport);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("FileConvertDelegate", Intrinsics.stringPlus("Local_edit chunkImport Exception: ", m479exceptionOrNullimpl));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            ChunkConvertResult chunkConvertResult = (ChunkConvertResult) m476constructorimpl;
            if (chunkConvertResult == null) {
                return new ChunkConvertResult();
            }
            return chunkConvertResult;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ChunkConvertResult> continuation) {
        return ((FileConvertDelegate$chunkImport$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
