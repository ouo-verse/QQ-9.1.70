package com.tencent.mobileqq.nsr;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nsr/a;", "", "", "c", "url", "d", "", "a", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f254411a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f254411a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        return PreDownloadScheduleUtil.getPreDownloadPathStatic("nsr", PreDownloadConstants.DEPARTMENT_VAS, false) + "/";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        if (r1.intValue() != (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String d(String url) {
        Integer num;
        int lastIndexOf$default;
        try {
            String path = Uri.parse(url).getPath();
            if (path != null) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, '.', 0, false, 6, (Object) null);
                num = Integer.valueOf(lastIndexOf$default);
            } else {
                num = null;
            }
            if (num != null) {
            }
            if (num == null) {
                return null;
            }
            String substring = path.substring(num.intValue() + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return "." + substring;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public final boolean a(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url)).booleanValue();
        }
        return new File(b(url)).exists();
    }

    @NotNull
    public final String b(@Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        return c() + MD5.toMD5(url) + d(url);
    }
}
