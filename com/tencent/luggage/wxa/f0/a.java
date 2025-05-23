package com.tencent.luggage.wxa.f0;

import android.net.Uri;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.l0.g {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f125097a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f125098b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f125099c;

    /* renamed from: d, reason: collision with root package name */
    public CipherInputStream f125100d;

    public a(com.tencent.luggage.wxa.l0.g gVar, byte[] bArr, byte[] bArr2) {
        this.f125097a = gVar;
        this.f125098b = bArr;
        this.f125099c = bArr2;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(com.tencent.luggage.wxa.l0.j jVar) {
        try {
            Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
            try {
                cipher.init(2, new SecretKeySpec(this.f125098b, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(this.f125099c));
                this.f125100d = new CipherInputStream(new com.tencent.luggage.wxa.l0.i(this.f125097a, jVar), cipher);
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e16) {
                throw new RuntimeException(e16);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e17) {
            throw new RuntimeException(e17);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        this.f125100d = null;
        this.f125097a.close();
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        return this.f125097a.getUri();
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        boolean z16;
        if (this.f125100d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        int read = this.f125100d.read(bArr, i3, i16);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
