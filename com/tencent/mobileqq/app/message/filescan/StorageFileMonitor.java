package com.tencent.mobileqq.app.message.filescan;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/StorageFileMonitor;", "", "", "path", "b", "", "operateType", "", "c", "Ljava/util/Random;", "Lkotlin/Lazy;", "a", "()Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class StorageFileMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StorageFileMonitor f195974a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy random;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18996);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f195974a = new StorageFileMonitor();
        lazy = LazyKt__LazyJVMKt.lazy(StorageFileMonitor$random$2.INSTANCE);
        random = lazy;
    }

    StorageFileMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Random a() {
        return (Random) random.getValue();
    }

    private final String b(String path) {
        File file = new File(path);
        if (file.exists() && !file.isFile()) {
            return path;
        }
        String parent = file.getParent();
        if (parent != null) {
            return parent;
        }
        return path;
    }

    public final void c(@NotNull String path, int operateType) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) path, operateType);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        if (MobileQQ.sProcessId == 1 && !MobileQQ.sMobileQQ.isRuntimeReady()) {
            return;
        }
        Iterator<T> it = StorageConfigHelper.f195972a.a().iterator();
        while (it.hasNext()) {
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(path, (String) it.next(), false, 2, null);
            if (startsWith$default3) {
                b.f195977a.c(path, operateType, false, new Throwable());
                return;
            }
        }
        int f16 = StorageConfigHelper.f195972a.f() * 100000;
        d dVar = d.f195978a;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, dVar.j(), false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(path, dVar.f(), false, 2, null);
            if (startsWith$default2 || a().nextInt(f16) > 1) {
                return;
            }
            boolean isFileUnderPublicDir = ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).isFileUnderPublicDir(path);
            QLog.d("StorageFileMonitor", 1, "onFileOperate isPublicFile: " + isFileUnderPublicDir + ", path: " + path);
            if (isFileUnderPublicDir) {
                b.f195977a.c(path, operateType, true, new Throwable());
            } else {
                b.f195977a.c(b(path), operateType, false, new Throwable());
            }
        }
    }
}
