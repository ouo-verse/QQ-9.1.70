package com.tencent.qqnt.util.bitmap;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/util/bitmap/a;", "", "Ljava/io/File;", "file", "", "b", "dataSource", "a", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362978a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362978a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@NotNull Object dataSource) {
        InputStream inputStream;
        byte[] copyOfRange;
        byte[] copyOfRange2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, dataSource)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        try {
            try {
                if (dataSource instanceof String) {
                    inputStream = new FileInputStream((String) dataSource);
                } else if (dataSource instanceof FileDescriptor) {
                    inputStream = new FileInputStream((FileDescriptor) dataSource);
                } else {
                    if (!(dataSource instanceof byte[])) {
                        return false;
                    }
                    inputStream = new ByteArrayInputStream((byte[]) dataSource);
                }
            } catch (FileNotFoundException e16) {
                e = e16;
                inputStream = null;
            } catch (IOException e17) {
                e = e17;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (0 != 0) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[29];
                inputStream.read(bArr);
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr, 1, 4);
                Charset charset = Charsets.UTF_8;
                if (Intrinsics.areEqual(new String(copyOfRange, charset), "PNG") && bArr[28] == 1) {
                    try {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                        return true;
                    } finally {
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        copyOfRange2 = ArraysKt___ArraysJvmKt.copyOfRange(bArr, 1, 4);
                        QLog.d("ImageUtil", 2, "not base png, " + new String(copyOfRange2, charset));
                    }
                    try {
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                        return false;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                QLog.e("ImageUtil", 1, "checkBasePng fail", e);
                if (inputStream != null) {
                    try {
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                return false;
            } catch (IOException e19) {
                e = e19;
                QLog.e("ImageUtil", 1, "checkBasePng fail", e);
                if (inputStream != null) {
                    try {
                        Unit unit4 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                try {
                    Unit unit5 = Unit.INSTANCE;
                    CloseableKt.closeFinally(null, null);
                } finally {
                }
            }
            throw th;
        }
    }

    public final boolean b(@Nullable File file) {
        File file2;
        byte[] copyOfRange;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file)).booleanValue();
        }
        if (file == null) {
            return false;
        }
        try {
            if (file.exists()) {
                file2 = file;
            } else {
                file2 = null;
            }
            if (file2 == null) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[3];
                randomAccessFile.read(bArr);
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr, 0, 3);
                boolean areEqual = Intrinsics.areEqual(new String(copyOfRange, Charsets.UTF_8), "GIF");
                CloseableKt.closeFinally(randomAccessFile, null);
                return areEqual;
            } finally {
            }
        } catch (Exception e16) {
            QLog.e("ImageUtil", 1, "isGifFile error: ", e16);
            return false;
        }
    }
}
