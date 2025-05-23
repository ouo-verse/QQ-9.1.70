package com.tencent.videocut.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\nJ\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n\u00a2\u0006\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/videocut/utils/g;", "", "Ljava/io/InputStream;", "inputStream", "Ljava/io/OutputStream;", "os", "", "c", "Landroid/content/Context;", "context", "", "assetFile", "destFile", "a", "path", "", "g", "Ljava/io/File;", "file", "f", "i", tl.h.F, "filePath", "d", "e", "fromPath", "toPath", "b", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f384239a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7996);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            f384239a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    private final boolean c(InputStream inputStream, OutputStream os5) {
        if (inputStream == null || os5 == null) {
            return false;
        }
        try {
            byte[] bArr = new byte[2097152];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    os5.write(bArr, 0, read);
                } else {
                    os5.flush();
                    return true;
                }
            }
        } catch (Exception e16) {
            com.tencent.videocut.utils.log.b.a("FileUtils", String.valueOf(e16.getMessage()));
            return true;
        }
    }

    public final boolean a(@NotNull Context context, @NotNull String assetFile, @NotNull String destFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, context, assetFile, destFile)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetFile, "assetFile");
        Intrinsics.checkNotNullParameter(destFile, "destFile");
        try {
            InputStream open = context.getAssets().open(assetFile);
            try {
                File file = new File(destFile);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    com.tencent.videocut.utils.log.b.e("FileUtils", "[copyAssets] isMKDirs: " + parentFile.mkdirs());
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    f384239a.c(open, fileOutputStream);
                    fileOutputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(open, null);
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (IOException e16) {
            com.tencent.videocut.utils.log.b.c("FileUtils", e16);
            return false;
        }
    }

    @Nullable
    public final Boolean b(@NotNull String fromPath, @NotNull String toPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) fromPath, (Object) toPath);
        }
        Intrinsics.checkNotNullParameter(fromPath, "fromPath");
        Intrinsics.checkNotNullParameter(toPath, "toPath");
        File d16 = d(toPath);
        if (d16 != null) {
            File file = new File(fromPath);
            if (file.exists() && !d16.isDirectory() && !file.isDirectory()) {
                boolean z16 = false;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(d16);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            z16 = f384239a.c(fileInputStream, fileOutputStream);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileInputStream, null);
                            CloseableKt.closeFinally(fileOutputStream, null);
                        } finally {
                        }
                    } finally {
                    }
                } catch (FileNotFoundException e16) {
                    com.tencent.videocut.utils.log.b.c("FileUtils", e16);
                }
                return Boolean.valueOf(z16);
            }
            com.tencent.videocut.utils.log.b.a("FileUtils", "copy failed, from " + fromPath + ", to " + toPath);
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    @Nullable
    public final File d(@NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (File) iPatchRedirector.redirect((short) 21, (Object) this, (Object) filePath);
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File e16 = e(filePath);
        if (e16.exists()) {
            return e16;
        }
        try {
            e16.createNewFile();
            return e16;
        } catch (IOException e17) {
            com.tencent.videocut.utils.log.b.b("FileUtils", "Create file failed", e17);
            return null;
        }
    }

    @NotNull
    public final File e(@NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (File) iPatchRedirector.redirect((short) 22, (Object) this, (Object) filePath);
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return file;
    }

    public final void f(@Nullable File file) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) file);
            return;
        }
        if (file == null) {
            com.tencent.videocut.utils.log.b.a("FileUtils", "file delete file error, file null");
            return;
        }
        if (file.isFile()) {
            com.tencent.videocut.utils.log.b.a("FileUtils", "file delete file:" + file.getAbsolutePath() + ",result:" + file.delete());
            return;
        }
        if (file.isDirectory()) {
            com.tencent.videocut.utils.log.b.a("FileUtils", "file delete file is directory:" + file.getAbsolutePath());
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (listFiles.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    for (File file2 : listFiles) {
                        f(file2);
                    }
                    com.tencent.videocut.utils.log.b.a("FileUtils", "file finally delete directory:" + file.getAbsolutePath() + ",result:" + file.delete());
                    return;
                }
            }
            com.tencent.videocut.utils.log.b.a("FileUtils", "file delete directory:" + file.getAbsolutePath() + ",result:" + file.delete());
        }
    }

    public final void g(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            com.tencent.videocut.utils.log.b.a("FileUtils", "file delete:" + path);
            return;
        }
        com.tencent.videocut.utils.log.b.a("FileUtils", "file delete:" + path);
        f(new File(path));
    }

    public final boolean h(@Nullable String path) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) path)).booleanValue();
        }
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(path).exists();
    }

    @NotNull
    public final String i(@NotNull Context context, @Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) path);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb5 = new StringBuilder();
        if (path != null) {
            InputStream open = context.getAssets().open(path);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                        sb5.append("\n");
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(open, null);
            } finally {
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "buf.toString()");
        return sb6;
    }
}
