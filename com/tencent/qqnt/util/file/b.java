package com.tencent.qqnt.util.file;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/util/file/b;", "", "", "filePath", "", "e", "c", "Ljava/io/FileInputStream;", "inputStream", "Ljava/nio/MappedByteBuffer;", "a", "b", "d", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f362981a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362981a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MappedByteBuffer a(FileInputStream inputStream) {
        FileChannel channel = inputStream.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
        Intrinsics.checkNotNullExpressionValue(map, "fileChannel.map(FileChan\u2026e.READ_ONLY, 0, fileSize)");
        return map;
    }

    private final byte[] c(String filePath) {
        boolean z16;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            try {
                byte[] bArr = new byte[8192];
                MappedByteBuffer a16 = f362981a.a(fileInputStream);
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(\"MD5\")");
                while (a16.hasRemaining()) {
                    int min = Math.min(8192, a16.remaining());
                    a16.get(bArr, 0, min);
                    messageDigest.update(bArr, 0, min);
                }
                byte[] digest = messageDigest.digest();
                CloseableKt.closeFinally(fileInputStream, null);
                return digest;
            } finally {
            }
        } catch (Exception e16) {
            QLog.i("Md5Util", 1, "[md5] exception, exc=" + e16 + " path=" + filePath);
            return null;
        }
    }

    private final byte[] e(String filePath) {
        boolean z16;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            return cq.q(filePath);
        } catch (Throwable th5) {
            QLog.w("Md5Util", 1, "[nativeMd5] exception=" + th5 + " path=" + filePath);
            return null;
        }
    }

    @NotNull
    public final String b(@Nullable String filePath) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
        }
        boolean z17 = false;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !new File(filePath).exists()) {
            return "";
        }
        byte[] d16 = d(filePath);
        if (d16 != null) {
            if (d16.length == 0) {
                z17 = true;
            }
            if (!z17) {
                String bytes2HexStr = HexUtil.bytes2HexStr(d16);
                Intrinsics.checkNotNullExpressionValue(bytes2HexStr, "bytes2HexStr(it)");
                return bytes2HexStr;
            }
        }
        QLog.w("Md5Util", 1, "[hexMd5] fail, path is " + filePath);
        return "";
    }

    @Nullable
    public final byte[] d(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePath);
        }
        byte[] e16 = e(filePath);
        if (e16 != null) {
            return e16;
        }
        byte[] c16 = c(filePath);
        if (c16 != null) {
            return c16;
        }
        return MD5.getFileMd5(filePath);
    }
}
