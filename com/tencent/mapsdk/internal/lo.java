package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.ll;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lo {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f149228a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    private final lh<String, String> f149229b = new lh<>(1000);

    /* renamed from: c, reason: collision with root package name */
    private final ll.g<ll.i<MessageDigest>> f149230c = ll.a(10, new ll.e<ll.i<MessageDigest>>() { // from class: com.tencent.mapsdk.internal.lo.1
        private static ll.i<MessageDigest> b() {
            try {
                return new ll.i<>(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256));
            } catch (NoSuchAlgorithmException e16) {
                throw new RuntimeException(e16);
            }
        }

        @Override // com.tencent.mapsdk.internal.ll.e
        public final /* synthetic */ ll.i<MessageDigest> a() {
            return b();
        }
    });

    public final String a(String str) {
        String b16;
        synchronized (this.f149229b) {
            b16 = this.f149229b.b((lh<String, String>) str);
        }
        if (b16 == null) {
            ll.i<MessageDigest> a16 = this.f149230c.a();
            try {
                a16.f149217a.update(str.getBytes());
                byte[] digest = a16.f149217a.digest();
                if (digest == null || digest.length == 0) {
                    b16 = null;
                } else {
                    char[] cArr = new char[digest.length * 2];
                    for (int i3 = 0; i3 < digest.length; i3++) {
                        byte b17 = digest[i3];
                        int i16 = i3 * 2;
                        char[] cArr2 = f149228a;
                        cArr[i16 + 1] = cArr2[b17 & RegisterType.DOUBLE_HI];
                        cArr[i16 + 0] = cArr2[((byte) (b17 >>> 4)) & RegisterType.DOUBLE_HI];
                    }
                    b16 = new String(cArr);
                }
            } finally {
                this.f149230c.a(a16);
            }
        }
        synchronized (this.f149229b) {
            this.f149229b.a(str, b16);
        }
        return b16;
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b16 = bArr[i3];
            int i16 = i3 * 2;
            char[] cArr2 = f149228a;
            cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
            cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }
}
