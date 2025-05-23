package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.utils;

import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/utils/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$b;", "", "a", "", "b", "url", "getCacheFilePath", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/atomic/AtomicReference;", "cacheFilePath", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191403a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicReference<String> cacheFilePath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62730);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f191403a = new a();
            cacheFilePath = new AtomicReference<>("");
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a() {
        b();
        String str = cacheFilePath.get();
        Intrinsics.checkNotNullExpressionValue(str, "cacheFilePath.get()");
        return str;
    }

    public final void b() {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AtomicReference<String> atomicReference = cacheFilePath;
        String str2 = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(str2, "cacheFilePath.get()");
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        File externalFilesDir = BaseApplication.getContext().getExternalFilesDir("troopAio");
        if (externalFilesDir != null) {
            String absolutePath = externalFilesDir.getAbsolutePath();
            String str3 = File.separator;
            str = absolutePath + str3 + "cache" + str3;
        } else {
            String absolutePath2 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
            String str4 = File.separator;
            str = absolutePath2 + str4 + "troopAio" + str4 + "cache" + str4;
        }
        atomicReference.set(str);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.b
    @NotNull
    public String getCacheFilePath(@NotNull String url) {
        boolean endsWith$default;
        boolean endsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, "avif", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(url, "png", false, 2, null);
            if (endsWith$default2) {
                return a() + url.hashCode() + ".png";
            }
            return a() + url.hashCode();
        }
        return a() + url.hashCode() + BasePicDownloadProcessor.AVIF_FILE_SUFFIX;
    }
}
