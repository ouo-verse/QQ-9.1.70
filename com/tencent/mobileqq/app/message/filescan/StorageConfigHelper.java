package com.tencent.mobileqq.app.message.filescan;

import com.tencent.mobileqq.app.message.config.FileMonitorConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/StorageConfigHelper;", "", "", "f", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", QzoneZipCacheHelper.DIR, "", "e", "d", "b", "Lcom/tencent/mobileqq/app/message/config/FileMonitorConfigBean;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/app/message/config/FileMonitorConfigBean;", "fileMonitorConfigBean", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class StorageConfigHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StorageConfigHelper f195972a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fileMonitorConfigBean;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18986);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f195972a = new StorageConfigHelper();
        lazy = LazyKt__LazyJVMKt.lazy(StorageConfigHelper$fileMonitorConfigBean$2.INSTANCE);
        fileMonitorConfigBean = lazy;
    }

    StorageConfigHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FileMonitorConfigBean c() {
        return (FileMonitorConfigBean) fileMonitorConfigBean.getValue();
    }

    @NotNull
    public final ArrayList<String> a() {
        ArrayList<String> c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        FileMonitorConfigBean c17 = c();
        if (c17 == null || (c16 = c17.c()) == null) {
            return new ArrayList<>();
        }
        return c16;
    }

    public final int b(@NotNull String dir) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) dir)).intValue();
        }
        Intrinsics.checkNotNullParameter(dir, "dir");
        d dVar = d.f195978a;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(dir, dVar.a(), false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(dir, dVar.d(), false, 2, null);
            if (startsWith$default2) {
                return 2;
            }
            for (String str : dVar.l()) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(dir, str, false, 2, null);
                if (startsWith$default3) {
                    return 1;
                }
            }
            return 0;
        }
        return 3;
    }

    public final boolean d(@NotNull String dir) {
        Set<String> b16;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) dir)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dir, "dir");
        FileMonitorConfigBean c16 = c();
        if (c16 != null && (b16 = c16.b()) != null) {
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(dir, (String) it.next(), false, 2, null);
                if (startsWith$default) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean e(@NotNull String dir) {
        CopyOnWriteArraySet<String> d16;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dir)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dir, "dir");
        FileMonitorConfigBean c16 = c();
        if (c16 != null && (d16 = c16.d()) != null) {
            for (String it : d16) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(dir, it, false, 2, null);
                if (startsWith$default) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        FileMonitorConfigBean c16 = c();
        if (c16 != null) {
            return c16.e();
        }
        return 10;
    }
}
