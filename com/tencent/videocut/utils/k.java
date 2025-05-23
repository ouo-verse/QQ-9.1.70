package com.tencent.videocut.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/utils/k;", "", "", "md", "", "b", "str", "a", "", "[C", "hexDigits", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final char[] hexDigits;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final k f384249b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9340);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384249b = new k();
            hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    private final String b(byte[] md5) {
        if (md5 == null) {
            return null;
        }
        int length = md5.length;
        char[] cArr = new char[length * 2];
        for (int i3 = 0; i3 < length; i3++) {
            byte b16 = md5[i3];
            int i16 = i3 * 2;
            char[] cArr2 = hexDigits;
            cArr[i16] = cArr2[(b16 >>> 4) & 15];
            cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }

    @Nullable
    public final String a(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        try {
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "Charset.defaultCharset()");
            byte[] bytes = str.getBytes(defaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bytes);
            return b(messageDigest.digest());
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
            return null;
        }
    }
}
