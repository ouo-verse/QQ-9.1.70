package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ht extends hy {

    /* renamed from: a, reason: collision with root package name */
    protected InputStream f389377a = null;

    /* renamed from: b, reason: collision with root package name */
    protected OutputStream f389378b;

    public ht(OutputStream outputStream) {
        this.f389378b = outputStream;
    }

    @Override // com.xiaomi.push.hy
    public int a(byte[] bArr, int i3, int i16) {
        InputStream inputStream = this.f389377a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i3, i16);
                if (read >= 0) {
                    return read;
                }
                throw new il(4);
            } catch (IOException e16) {
                throw new il(0, e16);
            }
        }
        throw new il(1, "Cannot read from null inputStream");
    }

    @Override // com.xiaomi.push.hy
    public void c(byte[] bArr, int i3, int i16) {
        OutputStream outputStream = this.f389378b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i3, i16);
                return;
            } catch (IOException e16) {
                throw new il(0, e16);
            }
        }
        throw new il(1, "Cannot write to null outputStream");
    }
}
