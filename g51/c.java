package g51;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f401272a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<MessageDigest> f401273b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<MessageDigest> f401274c = new b();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a extends ThreadLocal<MessageDigest> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            } catch (NoSuchAlgorithmException e16) {
                throw new RuntimeException("Initialize MD5 failed.", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class b extends ThreadLocal<MessageDigest> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            } catch (NoSuchAlgorithmException e16) {
                throw new RuntimeException("Initialize SHA256-DIGEST failed.", e16);
            }
        }
    }

    private static void a(byte b16, StringBuffer stringBuffer) {
        char[] cArr = f401272a;
        char c16 = cArr[(b16 & 240) >> 4];
        char c17 = cArr[b16 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    private static String b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    private static String c(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            a(bArr[i3], stringBuffer);
            i3++;
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        return e(str.getBytes());
    }

    public static String e(byte[] bArr) {
        return b(f401273b.get().digest(bArr));
    }
}
