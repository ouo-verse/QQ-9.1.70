package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    BufferedInputStream f197046a;

    /* renamed from: b, reason: collision with root package name */
    private int f197047b;

    /* renamed from: c, reason: collision with root package name */
    private int f197048c;

    /* renamed from: d, reason: collision with root package name */
    private int f197049d;

    /* renamed from: f, reason: collision with root package name */
    private int f197051f = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f197050e = 0;

    public c(String str, int i3, int i16, int i17) throws FileNotFoundException {
        this.f197046a = new BufferedInputStream(new FileInputStream(str));
        this.f197047b = i3;
        this.f197048c = i16;
        this.f197049d = i17;
        if (i17 != 8 && i17 != 16) {
            throw new RuntimeException(String.format("bit deepth must be 8 or 16, current is %s", Integer.valueOf(this.f197049d)));
        }
    }

    public byte[] a(long j3) throws IOException {
        int i3 = ((int) ((j3 * this.f197047b) / 1000)) * this.f197048c * (this.f197049d / 8);
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i3];
        int read = this.f197046a.read(bArr, this.f197050e, i3);
        if (read != -1) {
            System.arraycopy(bArr, 0, bArr2, 0, read);
        }
        QLog.d("AudioGenerator", 4, String.format("read index:%s, len: %s", Integer.valueOf(this.f197051f), Integer.valueOf(read)));
        return bArr2;
    }

    public void b() {
        BufferedInputStream bufferedInputStream = this.f197046a;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }
}
