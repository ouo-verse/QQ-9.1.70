package com.tencent.localedit.fakenative.convert;

import com.tencent.localedit.fakenative.meta.ChunkConvertResult;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.LoadConvertOptions;
import com.tencent.localedit.fakenative.meta.SaveConvertOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/localedit/fakenative/convert/a;", "", "Lcom/tencent/localedit/fakenative/meta/LoadConvertOptions;", "options", "Lcom/tencent/localedit/fakenative/meta/CommonConvertResult;", "c", "(Lcom/tencent/localedit/fakenative/meta/LoadConvertOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/localedit/fakenative/meta/SaveConvertOptions;", "f", "(Lcom/tencent/localedit/fakenative/meta/SaveConvertOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "srcPath", "", "chunkIndex", "chunkSize", "Lcom/tencent/localedit/fakenative/meta/ChunkConvertResult;", "a", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "e", "filePath", "d", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class a {
    @Nullable
    public abstract Object a(@NotNull String str, int i3, int i16, @NotNull Continuation<? super ChunkConvertResult> continuation);

    public abstract void b(@NotNull LoadConvertOptions options);

    @Nullable
    public abstract Object c(@NotNull LoadConvertOptions loadConvertOptions, @NotNull Continuation<? super CommonConvertResult> continuation);

    public abstract void e(@NotNull String srcPath);

    @Nullable
    public abstract Object f(@NotNull SaveConvertOptions saveConvertOptions, @NotNull Continuation<? super CommonConvertResult> continuation);

    public void d(@Nullable String filePath) {
    }
}
