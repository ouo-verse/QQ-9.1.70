package com.tencent.mobileqq.perf.upload.cos;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/a;", "", "", "bytes", "", "d", "data", "key", "a", "input", "c", "Ljava/io/File;", "file", "b", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f258277a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f258277a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b16 : bytes) {
            formatter.format("%02x", Byte.valueOf(b16));
        }
        String formatter2 = formatter.toString();
        Intrinsics.checkNotNullExpressionValue(formatter2, "formatter.toString()");
        return formatter2;
    }

    @NotNull
    public final String a(@NotNull String data, @NotNull String key) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) key);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = key.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        mac.init(secretKeySpec);
        byte[] bytes2 = data.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal = mac.doFinal(bytes2);
        Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data.toByteArray())");
        return d(doFinal);
    }

    @NotNull
    public final String b(@NotNull File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file);
        }
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        a aVar = f258277a;
                        byte[] digest = messageDigest.digest();
                        Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                        String d16 = aVar.d(digest);
                        CloseableKt.closeFinally(fileInputStream, null);
                        return d16;
                    }
                }
            } finally {
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
            return "";
        }
    }

    @NotNull
    public final String c(@NotNull String input) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) input);
        }
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            byte[] bytes = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = byteArrayInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        a aVar = f258277a;
                        byte[] digest = messageDigest.digest();
                        Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                        String d16 = aVar.d(digest);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return d16;
                    }
                }
            } finally {
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
