package com.huawei.secure.android.common.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HiCloudX509TrustManager extends SecureX509TrustManager {
    public HiCloudX509TrustManager(InputStream inputStream, String str) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, IllegalArgumentException {
        super(inputStream, str);
    }
}
