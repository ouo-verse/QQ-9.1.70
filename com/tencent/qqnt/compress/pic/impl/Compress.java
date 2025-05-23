package com.tencent.qqnt.compress.pic.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.pic.impl.constraint.a;
import com.tencent.qqnt.compress.pic.impl.constraint.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JH\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\u0002\b\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\u0002\b\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/Compress;", "", "Landroid/content/Context;", "context", "", "b", "Ljava/io/File;", "imageFile", "g", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/Function1;", "Lcom/tencent/qqnt/compress/pic/impl/constraint/a;", "", "Lkotlin/ExtensionFunctionType;", "compressionPatch", "c", "(Landroid/content/Context;Ljava/io/File;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class Compress {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final Compress f355729a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39411);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355729a = new Compress();
        }
    }

    Compress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(Context context) {
        String path = context.getCacheDir().getPath();
        String str = File.separator;
        return path + str + "compressor" + str;
    }

    public static /* synthetic */ Object d(Compress compress, Context context, File file, CoroutineContext coroutineContext, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i3 & 8) != 0) {
            function1 = Compress$compress$2.INSTANCE;
        }
        return compress.c(context, file, coroutineContext2, function1, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ File f(Compress compress, Context context, File file, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = Compress$compressV2$1.INSTANCE;
        }
        return compress.e(context, file, function1);
    }

    public final File g(Context context, File imageFile) {
        File copyTo$default;
        copyTo$default = FilesKt__UtilsKt.copyTo$default(imageFile, new File(b(context) + imageFile.getName()), true, 0, 4, null);
        return copyTo$default;
    }

    @Nullable
    public final Object c(@NotNull Context context, @NotNull File file, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super a, Unit> function1, @NotNull Continuation<? super File> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context, file, coroutineContext, function1, continuation);
        }
        return BuildersKt.withContext(coroutineContext, new Compress$compress$3(function1, context, file, null), continuation);
    }

    @Nullable
    public final File e(@NotNull Context context, @NotNull File imageFile, @NotNull Function1<? super a, Unit> compressionPatch) {
        File b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, context, imageFile, compressionPatch);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(compressionPatch, "compressionPatch");
        try {
            a aVar = new a();
            compressionPatch.invoke(aVar);
            File g16 = g(context, imageFile);
            for (b bVar : aVar.b()) {
                while (!bVar.a(g16) && (b16 = bVar.b(g16)) != null) {
                    g16 = b16;
                }
            }
            return g16;
        } catch (Exception e16) {
            QLog.w("PicCompress_", 1, "[compressV2] failed, exc=" + e16 + ", file=" + imageFile);
            return null;
        }
    }
}
