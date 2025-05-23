package com.tencent.localedit.fakenative.preload;

import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.resource.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x11.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/localedit/fakenative/preload/PreloadDocsTask;", "Lcom/tencent/localedit/fakenative/resource/c;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableDeferred;", "deferred", "Lcom/tencent/localedit/fakenative/meta/FileIORequestData;", "info", "<init>", "(Lcom/tencent/localedit/fakenative/meta/FileIORequestData;Lkotlinx/coroutines/CompletableDeferred;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class PreloadDocsTask extends c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompletableDeferred<Object> deferred;

    public /* synthetic */ PreloadDocsTask(FileIORequestData fileIORequestData, CompletableDeferred completableDeferred, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileIORequestData, (i3 & 2) != 0 ? CompletableDeferredKt.CompletableDeferred$default(null, 1, null) : completableDeferred);
    }

    @Nullable
    public final synchronized Object c(@NotNull Continuation<Object> continuation) {
        return this.deferred.await(continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadDocsTask(@NotNull final FileIORequestData info, @NotNull final CompletableDeferred<Object> deferred) {
        super(new Function0<Object>() { // from class: com.tencent.localedit.fakenative.preload.PreloadDocsTask.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Object invoke() {
                b.f446855a.a("Local_edit_preload", Intrinsics.stringPlus("start run task: ", FileIORequestData.this.getLocalFilePath()));
                return ((FilePreloadManager) LocalEditSDK.INSTANCE.getManager(FilePreloadManager.class)).loadDocs(FileIORequestData.this);
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.localedit.fakenative.preload.PreloadDocsTask.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object res) {
                Intrinsics.checkNotNullParameter(res, "res");
                b.f446855a.a("Local_edit_preload", Intrinsics.stringPlus("task finish: ", FileIORequestData.this.getLocalFilePath()));
                deferred.complete(res);
            }
        });
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(deferred, "deferred");
        this.deferred = deferred;
    }
}
