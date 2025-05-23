package com.tencent.qqnt.emotion.stickerrecommended.config;

import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.utils.i;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0003J\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0003J\u0012\u0010\n\u001a\u00020\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003J\f\u0010\r\u001a\u00020\f*\u0004\u0018\u00010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/c;", "", "", "Ljava/io/File;", "e", "", "b", "c", "Ljava/io/InputStream;", l0.NAME, "d", "Ljava/io/Closeable;", "", "a", "filePath", "configMd5", "g", "folderPath", "f", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f356514a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f356514a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable Closeable closeable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) closeable);
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e("FileUtil", 1, e16, new Object[0]);
            }
        }
    }

    public final boolean b(@NotNull File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public final boolean c(@NotNull File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) file)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(files, "files");
            boolean z16 = true;
            for (File file2 : files) {
                if (z16) {
                    Intrinsics.checkNotNullExpressionValue(file2, "file");
                    if (c(file2)) {
                        z16 = true;
                    }
                }
                z16 = false;
            }
            if (z16 && file.delete()) {
                return true;
            }
            return false;
        }
        return file.delete();
    }

    public final boolean d(@NotNull InputStream inputStream, @NotNull File saveFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) inputStream, (Object) saveFile)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(saveFile, "saveFile");
        Closeable closeable = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
                try {
                    byte[] bArr = new byte[2048];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = inputStream.read(bArr);
                        intRef.element = read;
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            a(fileOutputStream);
                            a(inputStream);
                            return true;
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    closeable = fileOutputStream;
                    QLog.e("FileUtil", 1, e, new Object[0]);
                    a(closeable);
                    a(inputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    closeable = fileOutputStream;
                    a(closeable);
                    a(inputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @NotNull
    public final File e(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new File(str);
    }

    public final boolean f(@NotNull String filePath, @NotNull String folderPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) filePath, (Object) folderPath)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        try {
            FileUtils.uncompressZip(filePath, folderPath, false);
            return true;
        } catch (IOException e16) {
            QLog.e("FileUtil", 1, "unzipFile error ", e16);
            return false;
        }
    }

    public final boolean g(@Nullable String filePath, @NotNull String configMd5) {
        String str;
        boolean equals;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) filePath, (Object) configMd5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configMd5, "configMd5");
        if (TextUtils.isEmpty(filePath)) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtil", 2, "verifyFileMD5 filePath is empty");
            }
            return false;
        }
        if (TextUtils.isEmpty(configMd5)) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtil", 2, "verifyFileMD5 configMd5 is empty");
            }
            return false;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtil", 2, "verifyFileMD5 file not exist!");
            }
            return false;
        }
        try {
            try {
                str = HexUtil.bytes2HexStr(MD5.getFileMd5(filePath));
            } catch (IOException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("FileUtil", 4, e16, new Object[0]);
                }
                str = null;
            }
        } catch (UnsatisfiedLinkError unused) {
            str = i.d(file);
        }
        if (QLog.isColorLevel()) {
            if (QLog.isColorLevel()) {
                QLog.d("FileUtil", 2, "verifyFileMD5 configMd5:" + configMd5 + ", calMd5:" + str);
            }
        }
        equals = StringsKt__StringsJVMKt.equals(configMd5, str, true);
        return equals;
    }
}
