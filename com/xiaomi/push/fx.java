package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fx extends ByteArrayOutputStream {
    public fx(int i3) {
        super(i3);
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    public byte[] d() {
        return ((ByteArrayOutputStream) this).buf;
    }
}
