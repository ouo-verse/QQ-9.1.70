package com.tencent.qphone.base.util.log.encrypt;

import java.security.SecureRandom;

/* compiled from: P */
/* loaded from: classes22.dex */
public class XorKey {
    private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA+qHDOmeTf26b/E/J3wFL\nqEYPlEivQJnP6D5MyExZKMhPTK5VN23KjLRg3plqSGduH6gRrNZQsYIuawlnk2Vl\njFKjFIt9+vMxMHh7E/FDBrMMqI/NqYcNhlpGNxnWrFkP8s6f1Jqnv/FDxrroBRd6\nPfAd/lawnC0oGl1uCLelGMnvBGWAyPgnpBU0SVkerkSkEYE+AXMzQavt8je4ersz\nJkFlb7Q8Sk/5IDYu4BvYrzSKuFFymrIOnWcaUs94IY2rz6hcFqWXjsbGGTLDXB1A\nNqQCbQBdG2SoLGHa5sJOM36SAFJIjM1BETDBv3BpFpet0J5ji1ni5UW5KsNhtlbD\nHwIDAQAB";

    public static String encryptedKey(String str) {
        return RSA.encryptByPublic(str, publicKey);
    }

    public static String genRandomKey() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        return Base64.encode(bArr);
    }
}
