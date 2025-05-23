package com.tencent.cachedrawable.dynamicdrawable.utils;

import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\f\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/utils/d;", "", "", "c", "d", "Ljava/io/File;", "b", "()Ljava/io/File;", "fdInfoFile", "", "a", "()I", "fdCount", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f99062a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f99062a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final File b() {
        File file;
        Throwable th5;
        try {
            file = new File("/proc/self/fd");
        } catch (Throwable th6) {
            file = null;
            th5 = th6;
        }
        try {
            if (!file.exists()) {
                return null;
            }
            if (!file.isDirectory()) {
                return null;
            }
            return file;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                Log.e("FileDescriptorHelper", "getFDInfoFile has error!", th5);
            } catch (Throwable unused) {
            }
            return file;
        }
    }

    private final boolean c() {
        if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.c() && Build.VERSION.SDK_INT < 28) {
            return true;
        }
        return false;
    }

    public final int a() {
        File[] listFiles;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        File b16 = b();
        if (b16 == null || (listFiles = b16.listFiles()) == null) {
            return 0;
        }
        return listFiles.length;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (c() && f99062a.a() >= 900) {
            return true;
        }
        return false;
    }
}
