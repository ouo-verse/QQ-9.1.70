package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class g implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    private final FileOutputStream f32839d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final FileLock f32840e;

    g(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.f32839d = fileOutputStream;
        try {
            FileLock lock = fileOutputStream.getChannel().lock();
            if (lock == null) {
                fileOutputStream.close();
            }
            this.f32840e = lock;
        } catch (Throwable th5) {
            this.f32839d.close();
            throw th5;
        }
    }

    public static g a(File file) throws IOException {
        return new g(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.f32840e;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.f32839d.close();
        }
    }
}
