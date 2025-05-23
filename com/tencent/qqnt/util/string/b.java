package com.tencent.qqnt.util.string;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/util/string/b;", "", "Ljava/io/InputStream;", "stream", "", "f", "", "bytes", "b", "", "offset", "size", "c", "", "bt", "Ljava/lang/StringBuffer;", "stringBuffer", "", "a", "dataSource", "e", "str", "d", "Ljava/security/MessageDigest;", "Ljava/security/MessageDigest;", "messagedigest", "", "[C", "hexDigits", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f362987a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MessageDigest messagedigest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static char[] hexDigits;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38831);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f362987a = new b();
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            messagedigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(byte bt5, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c16 = cArr[(bt5 & 240) >> 4];
        char c17 = cArr[bt5 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    private final String b(byte[] bytes) {
        return c(bytes, 0, bytes.length);
    }

    private final String c(byte[] bytes, int offset, int size) {
        StringBuffer stringBuffer = new StringBuffer(size * 2);
        int i3 = size + offset;
        while (offset < i3) {
            a(bytes[offset], stringBuffer);
            offset++;
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "stringBuffer.toString()");
        return stringBuffer2;
    }

    private final String f(InputStream stream) {
        try {
            if (stream != null) {
                try {
                    long available = stream.available();
                    byte[] bArr = new byte[4096];
                    while (available > 0) {
                        int read = stream.read(bArr);
                        long j3 = read;
                        if (read == -1) {
                            break;
                        }
                        if (j3 > available) {
                            j3 = available;
                        }
                        available -= j3;
                        MessageDigest messageDigest = messagedigest;
                        Intrinsics.checkNotNull(messageDigest);
                        messageDigest.update(ByteBuffer.wrap(bArr, 0, (int) j3));
                    }
                    MessageDigest messageDigest2 = messagedigest;
                    Intrinsics.checkNotNull(messageDigest2);
                    byte[] digest = messageDigest2.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest");
                    String b16 = b(digest);
                    try {
                        stream.close();
                        return b16;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return b16;
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                    try {
                        stream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
            }
            return null;
        } catch (Throwable th5) {
            try {
                stream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            throw th5;
        }
    }

    @Nullable
    public final byte[] d(@Nullable String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (str != null) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                MessageDigest messageDigest = messagedigest;
                Intrinsics.checkNotNull(messageDigest);
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                MessageDigest messageDigest2 = messagedigest;
                Intrinsics.checkNotNull(messageDigest2);
                return messageDigest2.digest();
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(@Nullable Object dataSource) {
        InputStream inputStream;
        String str = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, dataSource);
        }
        try {
            if (dataSource instanceof String) {
                inputStream = new FileInputStream((String) dataSource);
            } else if (dataSource instanceof FileDescriptor) {
                inputStream = new FileInputStream((FileDescriptor) dataSource);
            } else if (dataSource instanceof byte[]) {
                inputStream = new ByteArrayInputStream((byte[]) dataSource);
            } else {
                inputStream = null;
            }
            if (inputStream != null) {
                try {
                    try {
                        String f16 = f362987a.f(inputStream);
                        if (f16 != null) {
                            str = f16;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                            try {
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStream, null);
                            } finally {
                                try {
                                    throw th;
                                } finally {
                                }
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(inputStream, null);
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    return str;
                }
            }
        } catch (FileNotFoundException e17) {
            e = e17;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
        if (inputStream != null) {
            try {
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStream, null);
            } finally {
            }
        }
        return str;
    }
}
