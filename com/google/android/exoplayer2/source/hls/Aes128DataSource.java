package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Aes128DataSource implements DataSource {
    private CipherInputStream cipherInputStream;
    private final byte[] encryptionIv;
    private final byte[] encryptionKey;
    private final DataSource upstream;

    public Aes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.upstream = dataSource;
        this.encryptionKey = bArr;
        this.encryptionIv = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.cipherInputStream = null;
        this.upstream.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
            try {
                cipher.init(2, new SecretKeySpec(this.encryptionKey, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(this.encryptionIv));
                this.cipherInputStream = new CipherInputStream(new DataSourceInputStream(this.upstream, dataSpec), cipher);
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e16) {
                throw new RuntimeException(e16);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e17) {
            throw new RuntimeException(e17);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        boolean z16;
        if (this.cipherInputStream != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        int read = this.cipherInputStream.read(bArr, i3, i16);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
