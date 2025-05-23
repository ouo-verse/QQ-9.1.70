package m51;

import com.tencent.minibox.common.log.LogUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lm51/c;", "", "Ljava/io/File;", "file", "", "a", "Ljava/io/InputStream;", "inputStream", "b", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f416181a = new c();

    c() {
    }

    @Nullable
    public final String a(@NotNull File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (file.exists() && file.isFile() && file.length() > 0) {
            return b(new FileInputStream(file));
        }
        return null;
    }

    @Nullable
    public final String b(@NotNull InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        try {
            try {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int read = inputStream.read(bArr);
                    intRef.element = read;
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        return new BigInteger(1, messageDigest.digest()).toString(16);
                    }
                }
            } catch (IOException e16) {
                LogUtils.e("MD5Util", "getMD5 IOException", e16);
                b.a(inputStream);
                return null;
            } catch (NoSuchAlgorithmException e17) {
                LogUtils.e("MD5Util", "getMD5 NoSuchAlgorithmException", e17);
                b.a(inputStream);
                return null;
            }
        } finally {
            b.a(inputStream);
        }
    }
}
