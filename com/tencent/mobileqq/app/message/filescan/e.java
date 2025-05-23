package com.tencent.mobileqq.app.message.filescan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/e;", "", "", "path", "", "a", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f195993a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18988);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195993a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final long a(@NotNull String path) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path)).longValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (file.isFile()) {
            return file.length();
        }
        Stack stack = new Stack();
        stack.push(path);
        long j3 = 0;
        while (!stack.isEmpty()) {
            File file2 = new File((String) stack.pop());
            j3 += file2.length();
            String[] list = file2.list();
            if (list != null) {
                if (list.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    for (String str : list) {
                        File file3 = new File(file2, str);
                        if (file3.isDirectory()) {
                            stack.push(file3.getAbsolutePath());
                        } else {
                            j3 += file3.length();
                        }
                    }
                }
            }
        }
        return j3;
    }
}
