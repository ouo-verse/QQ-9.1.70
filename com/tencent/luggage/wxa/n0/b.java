package com.tencent.luggage.wxa.n0;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final File f135048a;

    /* renamed from: b, reason: collision with root package name */
    public final File f135049b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        public final FileOutputStream f135050a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f135051b = false;

        public a(File file) {
            this.f135050a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f135051b) {
                return;
            }
            this.f135051b = true;
            flush();
            try {
                this.f135050a.getFD().sync();
            } catch (IOException e16) {
                Log.w("AtomicFile", "Failed to sync file descriptor:", e16);
            }
            this.f135050a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f135050a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i3) {
            this.f135050a.write(i3);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f135050a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) {
            this.f135050a.write(bArr, i3, i16);
        }
    }

    public b(File file) {
        this.f135048a = file;
        this.f135049b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.f135048a.delete();
        this.f135049b.delete();
    }

    public InputStream b() {
        c();
        return new FileInputStream(this.f135048a);
    }

    public final void c() {
        if (this.f135049b.exists()) {
            this.f135048a.delete();
            this.f135049b.renameTo(this.f135048a);
        }
    }

    public OutputStream d() {
        if (this.f135048a.exists()) {
            if (!this.f135049b.exists()) {
                if (!this.f135048a.renameTo(this.f135049b)) {
                    Log.w("AtomicFile", "Couldn't rename file " + this.f135048a + " to backup file " + this.f135049b);
                }
            } else {
                this.f135048a.delete();
            }
        }
        try {
            return new a(this.f135048a);
        } catch (FileNotFoundException unused) {
            if (this.f135048a.getParentFile().mkdirs()) {
                try {
                    return new a(this.f135048a);
                } catch (FileNotFoundException unused2) {
                    throw new IOException("Couldn't create " + this.f135048a);
                }
            }
            throw new IOException("Couldn't create directory " + this.f135048a);
        }
    }

    public void a(OutputStream outputStream) {
        outputStream.close();
        this.f135049b.delete();
    }
}
