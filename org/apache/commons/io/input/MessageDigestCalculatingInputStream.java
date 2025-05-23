package org.apache.commons.io.input;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.input.ObservableInputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MessageDigestCalculatingInputStream extends ObservableInputStream {
    private final MessageDigest messageDigest;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MessageDigestMaintainingObserver extends ObservableInputStream.Observer {

        /* renamed from: md, reason: collision with root package name */
        private final MessageDigest f423533md;

        public MessageDigestMaintainingObserver(MessageDigest messageDigest) {
            this.f423533md = messageDigest;
        }

        @Override // org.apache.commons.io.input.ObservableInputStream.Observer
        void data(int i3) throws IOException {
            this.f423533md.update((byte) i3);
        }

        @Override // org.apache.commons.io.input.ObservableInputStream.Observer
        void data(byte[] bArr, int i3, int i16) throws IOException {
            this.f423533md.update(bArr, i3, i16);
        }
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream);
        this.messageDigest = messageDigest;
        add(new MessageDigestMaintainingObserver(messageDigest));
    }

    public MessageDigest getMessageDigest() {
        return this.messageDigest;
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream, String str) throws NoSuchAlgorithmException {
        this(inputStream, MessageDigest.getInstance(str));
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream) throws NoSuchAlgorithmException {
        this(inputStream, MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5));
    }
}
