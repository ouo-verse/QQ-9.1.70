package com.tencent.mobileqq.exportfile.fragment.filelist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJE\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0006H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListRepository;", "", "", "fileId", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/Function2;", "", "", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/c;", "", "callback", "a", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileListRepository {
    static IPatchRedirector $redirector_;

    public FileListRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Object b(FileListRepository fileListRepository, String str, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            coroutineDispatcher = b.b(32);
        }
        return fileListRepository.a(str, coroutineDispatcher, function2, continuation);
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function2<? super Integer, ? super List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, str, coroutineDispatcher, function2, continuation);
        }
        return BuildersKt.withContext(coroutineDispatcher, new FileListRepository$getFileListRecords$2(str, function2, null), continuation);
    }
}
