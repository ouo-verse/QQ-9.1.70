package com.tencent.filament.zplanservice.cpp;

import com.tencent.filament.zplanservice.util.log.FLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplanservice.cpp.ZPlanFilamentDownloader$saveToFilePath$2", f = "ZPlanFilamentDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class ZPlanFilamentDownloader$saveToFilePath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
    final /* synthetic */ InputStream $inputStream;
    final /* synthetic */ String $saveDir;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentDownloader$saveToFilePath$2(InputStream inputStream, String str, Continuation continuation) {
        super(2, continuation);
        this.$inputStream = inputStream;
        this.$saveDir = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanFilamentDownloader$saveToFilePath$2(this.$inputStream, this.$saveDir, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends String>> continuation) {
        return ((ZPlanFilamentDownloader$saveToFilePath$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        File parentFile;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$inputStream == null) {
                return new Pair(null, "inputStream is null");
            }
            String str = this.$saveDir + '/' + UUID.randomUUID();
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                File parentFile2 = file.getParentFile();
                if (parentFile2 != null && !parentFile2.exists() && (parentFile = file.getParentFile()) != null && !parentFile.mkdirs()) {
                    FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "saveToFilePath create parentFile dir error");
                    return new Pair(null, "parentFile create failed");
                }
                if (!file.createNewFile()) {
                    FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "saveToFilePath create file error");
                    return new Pair(null, "saveToFilePath create failed");
                }
                try {
                    InputStream inputStream = this.$inputStream;
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                Integer boxInt = Boxing.boxInt(inputStream.read(bArr));
                                int intValue = boxInt.intValue();
                                if (boxInt.intValue() != -1) {
                                    fileOutputStream.write(bArr, 0, intValue);
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    CloseableKt.closeFinally(inputStream, null);
                                    return new Pair(str, null);
                                }
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th5) {
                    FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "saveToFilePath write error, " + th5);
                    return new Pair(null, th5.getLocalizedMessage());
                }
            } catch (IOException e16) {
                FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "saveToFilePath create file error, " + e16);
                return new Pair(null, e16.getLocalizedMessage());
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
