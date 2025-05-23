package com.sina.weibo.sdk.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class g implements f {

    /* renamed from: q, reason: collision with root package name */
    private int f61265q;

    /* renamed from: r, reason: collision with root package name */
    private InputStream f61266r;

    public g(int i3, InputStream inputStream) {
        this.f61265q = i3;
        this.f61266r = inputStream;
    }

    @Override // com.sina.weibo.sdk.net.f
    public final String j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.f61266r.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (IOException e16) {
            throw e16;
        }
    }
}
