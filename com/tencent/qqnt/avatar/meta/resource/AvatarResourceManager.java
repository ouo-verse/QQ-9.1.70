package com.tencent.qqnt.avatar.meta.resource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqnt.avatar.g;
import com.tencent.qqnt.avatar.meta.task.TaskManager;
import com.tencent.qqnt.avatar.util.d;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0002J-\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/resource/AvatarResourceManager;", "", "", "filePath", "", "size", "Landroid/graphics/Bitmap;", "c", "Lcom/tencent/qqnt/avatar/meta/resource/b;", "resourceHelper", "", "j", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfo", "Landroid/content/Context;", "context", "f", "url", "Ljava/io/File;", h.F, "g", "e", "(Lcom/tencent/qqnt/avatar/meta/info/a;Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyControllerProps.STRING, "d", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<set-?>", "b", "Lcom/tencent/qqnt/avatar/meta/resource/b;", "i", "()Lcom/tencent/qqnt/avatar/meta/resource/b;", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "downloadTaskManager", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AvatarResourceManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarResourceManager f352954a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static b resourceHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final TaskManager downloadTaskManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f352954a = new AvatarResourceManager();
            downloadTaskManager = new TaskManager("AvatarResourceManager", null, 6, 0L, 0, 6, false, 90, null);
        }
    }

    AvatarResourceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap c(String filePath, int size) {
        byte[] readBytes;
        float coerceAtMost;
        try {
            readBytes = FilesKt__FileReadWriteKt.readBytes(new File(filePath));
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(readBytes, 0, readBytes.length);
            if (decodeByteArray == null) {
                d.d(d.f352991a, "AvatarResourceManager", "decodeAvatarNew decodeByteArray return null. filePath:" + filePath, null, 4, null);
                return null;
            }
            if (size <= 0) {
                return decodeByteArray;
            }
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            if (width != 0 && height != 0) {
                if (size < height && size < width) {
                    float f16 = size;
                    float f17 = f16 / width;
                    float f18 = f16 / height;
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(f17, f18);
                    Matrix matrix = new Matrix();
                    matrix.postScale(coerceAtMost, coerceAtMost);
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, width, height, matrix, true);
                    if (decodeByteArray == null) {
                        d.d(d.f352991a, "AvatarResourceManager", "decodeAvatarNew createBitmap return null. ori[" + width + ", " + height + "], scale[" + f17 + ", " + f18 + "], filePath:" + filePath, null, 4, null);
                    }
                }
                return decodeByteArray;
            }
            d.d(d.f352991a, "AvatarResourceManager", "decodeAvatarNew width:" + width + ", height:" + height, null, 4, null);
            return null;
        } catch (IOException e16) {
            d.f352991a.c("AvatarResourceManager", "decodeAvatar ioException:", e16);
            return null;
        } catch (IllegalArgumentException e17) {
            d.f352991a.c("AvatarResourceManager", "decodeAvatar illegalExp:", e17);
            return null;
        } catch (OutOfMemoryError e18) {
            d.f352991a.c("AvatarResourceManager", "decodeAvatar bitmap oom:", e18);
            return null;
        }
    }

    @Nullable
    public final Object d(@NotNull final String str, @NotNull final Context context, @NotNull Continuation<? super File> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            TaskManager.p(downloadTaskManager, new AvatarDownloadTask(str, context, new Function0<Unit>(str, context, cancellableContinuationImpl) { // from class: com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager$downloadFile$2$downloadTask$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ CancellableContinuation<File> $continuation;
                final /* synthetic */ String $string;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.$string = str;
                    this.$context = context;
                    this.$continuation = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, str, context, cancellableContinuationImpl);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    File h16 = AvatarResourceManager.f352954a.h(this.$string, this.$context);
                    CancellableContinuation<File> cancellableContinuation = this.$continuation;
                    String str2 = this.$string;
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(h16));
                        return;
                    }
                    d.d(d.f352991a, "AvatarResourceManager", "downloadFile already resumed:" + str2, null, 4, null);
                }
            }), false, 2, null);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 9, this, str, context, continuation);
    }

    @Nullable
    public final Object e(@NotNull com.tencent.qqnt.avatar.meta.info.a aVar, @NotNull final Context context, final int i3, @NotNull Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            final String c16 = aVar.c();
            TaskManager.p(downloadTaskManager, new AvatarDownloadTask(c16, context, new Function0<Unit>(c16, context, cancellableContinuationImpl, i3) { // from class: com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager$downloadResource$2$downloadTask$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ CancellableContinuation<Bitmap> $continuation;
                final /* synthetic */ String $resourceUrl;
                final /* synthetic */ int $size;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$resourceUrl = c16;
                    this.$context = context;
                    this.$continuation = cancellableContinuationImpl;
                    this.$size = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, c16, context, cancellableContinuationImpl, Integer.valueOf(i3));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Bitmap c17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AvatarResourceManager avatarResourceManager = AvatarResourceManager.f352954a;
                    File h16 = avatarResourceManager.h(this.$resourceUrl, this.$context);
                    boolean z16 = false;
                    if (h16 != null && true == h16.exists()) {
                        z16 = true;
                    }
                    if (!z16) {
                        d dVar = d.f352991a;
                        d.d(dVar, "AvatarResourceManager", "downloadResource file not exists: " + (h16 != null ? Boolean.valueOf(h16.exists()) : "null"), null, 4, null);
                        CancellableContinuation<Bitmap> cancellableContinuation = this.$continuation;
                        String str = this.$resourceUrl;
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(null));
                            return;
                        }
                        d.d(dVar, "AvatarResourceManager", "downloadResource file not exists already resumed:" + str, null, 4, null);
                        return;
                    }
                    String path = h16.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "file.path");
                    c17 = avatarResourceManager.c(path, this.$size);
                    CancellableContinuation<Bitmap> cancellableContinuation2 = this.$continuation;
                    String str2 = this.$resourceUrl;
                    if (cancellableContinuation2.isActive()) {
                        cancellableContinuation2.resumeWith(Result.m476constructorimpl(c17));
                        return;
                    }
                    d.d(d.f352991a, "AvatarResourceManager", "downloadResource already resumed:" + str2, null, 4, null);
                }
            }), false, 2, null);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 8, this, aVar, context, Integer.valueOf(i3), continuation);
    }

    @Nullable
    public final Bitmap f(@NotNull com.tencent.qqnt.avatar.meta.info.a avatarInfo, @NotNull Context context, int size) {
        Bitmap b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, avatarInfo, context, Integer.valueOf(size));
        }
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        File h16 = h(avatarInfo.c(), context);
        if (h16 == null || true != h16.exists()) {
            z16 = false;
        }
        if (z16) {
            String path = h16.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "file.path");
            Bitmap c16 = c(path, size);
            if (c16 != null) {
                return c16;
            }
        }
        if (System.currentTimeMillis() - avatarInfo.d() > g.f352801a.f()) {
            d.f352991a.a("AvatarResourceManager", AvatarResourceManager$getBitmapInDisk$2.INSTANCE);
            return null;
        }
        b bVar = resourceHelper;
        if (bVar == null || (b16 = bVar.b(avatarInfo, size)) == null) {
            return null;
        }
        return b16;
    }

    @Nullable
    public final File g(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (File) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        b bVar = resourceHelper;
        if (bVar != null) {
            return bVar.a(url);
        }
        return null;
    }

    @Nullable
    public final File h(@NotNull String url, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (File) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url, (Object) context);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        File g16 = g(url);
        if (g16 == null) {
            return com.tencent.qqnt.avatar.cache.b.INSTANCE.a(context).c(url);
        }
        return g16;
    }

    @Nullable
    public final b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return resourceHelper;
    }

    public final void j(@NotNull b resourceHelper2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) resourceHelper2);
        } else {
            Intrinsics.checkNotNullParameter(resourceHelper2, "resourceHelper");
            resourceHelper = resourceHelper2;
        }
    }
}
