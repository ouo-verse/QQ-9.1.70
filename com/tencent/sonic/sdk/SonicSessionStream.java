package com.tencent.sonic.sdk;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicSessionStream extends InputStream {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SonicSdk_SonicSessionStream";
    private final WeakReference<Callback> callbackWeakReference;
    private BufferedInputStream memStream;
    private boolean memStreamReadComplete;
    private BufferedInputStream netStream;
    private boolean netStreamReadComplete;
    private ByteArrayOutputStream outputStream;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Callback {
        void onClose(boolean z16, ByteArrayOutputStream byteArrayOutputStream);
    }

    public SonicSessionStream(Callback callback, ByteArrayOutputStream byteArrayOutputStream, BufferedInputStream bufferedInputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, byteArrayOutputStream, bufferedInputStream);
            return;
        }
        this.netStreamReadComplete = true;
        this.memStreamReadComplete = true;
        if (bufferedInputStream != null) {
            this.netStream = bufferedInputStream;
            this.netStreamReadComplete = false;
        }
        if (byteArrayOutputStream != null) {
            this.outputStream = byteArrayOutputStream;
            this.memStream = new BufferedInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            this.memStreamReadComplete = false;
        } else {
            this.outputStream = new ByteArrayOutputStream();
        }
        this.callbackWeakReference = new WeakReference<>(callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd A[RETURN] */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws IOException {
        Callback callback;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (SonicUtils.shouldLog(4)) {
            SonicUtils.log(TAG, 4, "close: memory stream and socket stream, netStreamReadComplete=" + this.netStreamReadComplete + ", memStreamReadComplete=" + this.memStreamReadComplete);
        }
        try {
            BufferedInputStream bufferedInputStream = this.memStream;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            this.memStream = null;
            th = null;
        } catch (Throwable th5) {
            th = th5;
            try {
                SonicUtils.log(TAG, 6, "close memStream error:" + th.getMessage());
            } finally {
                this.memStream = null;
            }
        }
        try {
            BufferedInputStream bufferedInputStream2 = this.netStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
        } finally {
            th = th;
            try {
                callback = this.callbackWeakReference.get();
                if (callback != null) {
                }
                this.outputStream = null;
                if (th == null) {
                }
            } finally {
            }
        }
        callback = this.callbackWeakReference.get();
        if (callback != null) {
            if (this.netStreamReadComplete && this.memStreamReadComplete) {
                z16 = true;
            } else {
                z16 = false;
            }
            callback.onClose(z16, this.outputStream);
        }
        this.outputStream = null;
        if (th == null) {
            SonicUtils.log(TAG, 6, "throw error:" + th.getMessage());
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException(th);
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        SonicSession sonicSession;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        try {
            Callback callback = this.callbackWeakReference.get();
            SonicSessionStatistics sonicSessionStatistics = null;
            if ((callback instanceof SonicServer) && (sonicSession = ((SonicServer) callback).session) != null) {
                sonicSessionStatistics = sonicSession.statistics;
            }
            BufferedInputStream bufferedInputStream = this.memStream;
            int read = (bufferedInputStream == null || this.memStreamReadComplete) ? -1 : bufferedInputStream.read();
            if (-1 == read) {
                this.memStreamReadComplete = true;
                BufferedInputStream bufferedInputStream2 = this.netStream;
                if (bufferedInputStream2 != null && !this.netStreamReadComplete) {
                    read = bufferedInputStream2.read();
                    if (-1 != read) {
                        this.outputStream.write(read);
                    } else {
                        this.netStreamReadComplete = true;
                    }
                }
            }
            if (read == -1) {
                if (sonicSessionStatistics != null && sonicSessionStatistics.connectionRecDataEndTime <= 0) {
                    sonicSessionStatistics.connectionRecDataEndTime = System.currentTimeMillis();
                    SonicUtils.log(TAG, 4, "SonicSessionStream_from_SonicStart_to_RecLastData, cost=" + (sonicSessionStatistics.connectionRecDataEndTime - sonicSessionStatistics.connectionFlowStartTime));
                }
            } else if (sonicSessionStatistics != null && sonicSessionStatistics.connectionRecDataStartTime <= 0) {
                sonicSessionStatistics.connectionRecDataStartTime = System.currentTimeMillis();
                SonicUtils.log(TAG, 4, "SonicSessionStream_from_SonicStart_to_RecFirstData, cost=" + (sonicSessionStatistics.connectionRecDataStartTime - sonicSessionStatistics.connectionFlowStartTime));
            }
            return read;
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "read error:" + th5.getMessage());
            if (th5 instanceof IOException) {
                throw th5;
            }
            throw new IOException(th5);
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return read(bArr, 0, bArr.length);
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr)).intValue();
    }

    @Override // java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int length = bArr.length;
        if ((i3 | i16) < 0 || i3 > length || length - i3 < i16) {
            throw new ArrayIndexOutOfBoundsException();
        }
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
