package com.tencent.mobileqq.zplan.web;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes34.dex */
public class d extends InputStream {

    /* renamed from: d, reason: collision with root package name */
    private BufferedInputStream f336039d;

    /* renamed from: e, reason: collision with root package name */
    private BufferedInputStream f336040e;

    /* renamed from: f, reason: collision with root package name */
    private ByteArrayOutputStream f336041f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f336042h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f336043i;

    /* renamed from: m, reason: collision with root package name */
    private final WeakReference<a> f336044m;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface a {
        void onClose(boolean z16, ByteArrayOutputStream byteArrayOutputStream);
    }

    public d(a aVar, ByteArrayOutputStream byteArrayOutputStream, BufferedInputStream bufferedInputStream) {
        this.f336042h = true;
        this.f336043i = true;
        if (bufferedInputStream != null) {
            this.f336039d = bufferedInputStream;
            this.f336042h = false;
        }
        if (byteArrayOutputStream != null) {
            this.f336041f = byteArrayOutputStream;
            this.f336040e = new BufferedInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            this.f336043i = false;
        } else {
            this.f336041f = new ByteArrayOutputStream();
        }
        this.f336044m = new WeakReference<>(aVar);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]Apollo_client_BridgeStream", 2, "close: memory stream and socket stream, netStreamReadComplete=" + this.f336042h + ", memStreamReadComplete=" + this.f336043i);
        }
        try {
            BufferedInputStream bufferedInputStream = this.f336040e;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
                this.f336040e = null;
            }
            BufferedInputStream bufferedInputStream2 = this.f336039d;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
                this.f336039d = null;
            }
            a aVar = this.f336044m.get();
            if (aVar != null) {
                aVar.onClose(this.f336042h && this.f336043i, this.f336041f);
            }
            this.f336041f = null;
        } catch (Throwable th5) {
            QLog.e("[zplan]Apollo_client_BridgeStream", 2, "close error:" + th5.getMessage());
            if (th5 instanceof IOException) {
                throw th5;
            }
            throw new IOException(th5);
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        try {
            BufferedInputStream bufferedInputStream = this.f336040e;
            read = (bufferedInputStream == null || this.f336043i) ? -1 : bufferedInputStream.read();
            if (-1 == read) {
                this.f336043i = true;
                BufferedInputStream bufferedInputStream2 = this.f336039d;
                if (bufferedInputStream2 != null && !this.f336042h) {
                    read = bufferedInputStream2.read();
                    if (-1 != read) {
                        this.f336041f.write(read);
                    } else {
                        this.f336042h = true;
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("[zplan]Apollo_client_BridgeStream", 2, "read error:" + th5.getMessage());
            if (th5 instanceof IOException) {
                throw th5;
            }
            throw new IOException(th5);
        }
        return read;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i16) throws IOException {
        int length = bArr.length;
        if ((i3 | i16) < 0 || i3 > length || length - i3 < i16) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i17 = 0;
        while (i17 < i16) {
            try {
                int read = read();
                if (read == -1) {
                    if (i17 == 0) {
                        i17 = -1;
                    }
                    return i17;
                }
                bArr[i3 + i17] = (byte) read;
                i17++;
            } catch (IOException e16) {
                if (i17 != 0) {
                    return i17;
                }
                throw e16;
            }
        }
        return i16;
    }
}
