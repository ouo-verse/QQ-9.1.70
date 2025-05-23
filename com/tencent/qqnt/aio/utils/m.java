package com.tencent.qqnt.aio.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J$\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/utils/m;", "", "", "fromPath", "toPath", "", "j", "needLog", "k", "filePath", "", "b", "path", "e", "", tl.h.F, "d", "f", "strFilePath", "g", "i", "c", "Ljava/io/File;", "a", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f352305a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f352305a = new m();
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@Nullable String filePath) {
        if (!e(filePath)) {
            try {
                m mVar = f352305a;
                Intrinsics.checkNotNull(filePath);
                mVar.a(filePath);
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileUtils", 2, "createFileIfNotExists", e16);
                }
            }
        }
    }

    @JvmStatic
    public static final boolean e(@Nullable String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        Intrinsics.checkNotNull(path);
        return new File(path).exists();
    }

    @JvmStatic
    public static final long h(@Nullable String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return 0L;
        }
        Intrinsics.checkNotNull(filePath);
        return new File(filePath).length();
    }

    @JvmStatic
    public static final boolean j(@Nullable String fromPath, @Nullable String toPath) {
        return k(fromPath, toPath, false);
    }

    @JvmStatic
    public static final boolean k(@Nullable String fromPath, @Nullable String toPath, boolean needLog) {
        if (fromPath != null && toPath != null) {
            File file = new File(fromPath);
            if (file.exists()) {
                return file.renameTo(new File(toPath));
            }
            if (!needLog) {
                return false;
            }
            QLog.d("FileUtils", 1, "rename failed, file not exists, fromPath:" + fromPath);
            return false;
        }
        if (needLog) {
            QLog.d("FileUtils", 1, "rename failed, fromPath:" + fromPath + ", toPath:" + toPath);
        }
        return false;
    }

    @NotNull
    public final File a(@NotNull String path) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (File) iPatchRedirector.redirect((short) 7, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (file.exists()) {
            return file;
        }
        if (file.getParentFile() != null) {
            File parentFile = file.getParentFile();
            Intrinsics.checkNotNull(parentFile);
            if (!parentFile.exists()) {
                File parentFile2 = file.getParentFile();
                Intrinsics.checkNotNull(parentFile2);
                if (parentFile2.mkdirs()) {
                    file.createNewFile();
                }
                return file;
            }
        }
        file.createNewFile();
        return file;
    }

    public final boolean c(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) filePath)).booleanValue();
        }
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        Intrinsics.checkNotNull(filePath);
        File parentFile = new File(filePath).getParentFile();
        if (parentFile == null) {
            return false;
        }
        parentFile.mkdirs();
        return parentFile.exists();
    }

    public final boolean d(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path)).booleanValue();
        }
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        Intrinsics.checkNotNull(path);
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public final boolean f(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path)).booleanValue();
        }
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        Intrinsics.checkNotNull(path);
        File file = new File(path);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Incorrect condition in loop: B:31:0x00b6 */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(@Nullable String strFilePath) {
        int lastIndexOf$default;
        int lastIndexOf$default2;
        int i3;
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strFilePath);
        }
        if (TextUtils.isEmpty(strFilePath)) {
            if (QLog.isColorLevel()) {
                QLog.eAsync("FMERROR", 1, "getFileName but strFilePath is null");
            }
            i();
            return "";
        }
        Intrinsics.checkNotNull(strFilePath);
        int length = strFilePath.length();
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strFilePath, '/', 0, false, 6, (Object) null);
        lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strFilePath, '\\', 0, false, 6, (Object) null);
        if (lastIndexOf$default2 > lastIndexOf$default) {
            lastIndexOf$default = lastIndexOf$default2;
        }
        if (lastIndexOf$default < 0) {
            if (QLog.isColorLevel()) {
                QLog.w("FileUtils", 2, "filepath without /, path is " + strFilePath);
            }
            i3 = 0;
        } else {
            i3 = lastIndexOf$default + 1;
        }
        String substring = strFilePath.substring(i3, length);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        if (QLog.isColorLevel()) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(substring, ".", false, 2, null);
            if (startsWith$default2) {
                QLog.e("FileUtils", 2, "InvaildName ,filePath[" + strFilePath + "], subName[" + substring + "]");
            }
        }
        String str = substring;
        while (startsWith$default) {
            str = new Regex(".").replaceFirst(str, "");
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtils", 2, "InvaildName ,filePath[" + strFilePath + "], subName[" + substring + "]");
            }
            return "InvaildName";
        }
        return str;
    }

    @NotNull
    public final synchronized String i() {
        String trimIndent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = "";
        try {
            StackTraceElement[] stackTraceElementArr = Thread.getAllStackTraces().get(Thread.currentThread());
            Intrinsics.checkNotNull(stackTraceElementArr);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (QLog.isColorLevel()) {
                    QLog.eAsync("FMERROR", 1, stackTraceElement.toString());
                }
                trimIndent = StringsKt__IndentKt.trimIndent(String.valueOf(stackTraceElement));
                str = str + trimIndent;
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
