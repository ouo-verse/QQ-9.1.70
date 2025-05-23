package com.tencent.luggage.wxa.mr;

import com.tencent.luggage.wxa.fn.b;
import com.tencent.luggage.wxa.fn.c;
import java.io.OutputStream;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f134886a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f134887b;

    /* renamed from: c, reason: collision with root package name */
    public final OutputStream f134888c = null;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.lr.a f134889d;

    public a(byte[] bArr) {
        this.f134886a = bArr;
        this.f134889d = com.tencent.luggage.wxa.lr.a.a(bArr);
    }

    public void a(int i3, boolean z16) {
        this.f134889d.b(i3, z16);
    }

    public void b(int i3, int i16) {
        a(i3, i16);
    }

    public void c(int i3, int i16) {
        this.f134889d.c(i3, i16);
    }

    public void a(int i3, c cVar) {
        this.f134889d.b(i3, cVar);
    }

    public void b() {
        OutputStream outputStream = this.f134888c;
        if (outputStream != null) {
            outputStream.write(this.f134886a);
            this.f134888c.flush();
        }
    }

    public void c() {
        OutputStream outputStream = this.f134888c;
        if (outputStream != null) {
            byte[] bArr = this.f134887b;
            if (bArr != null && bArr.length > 0) {
                outputStream.write(bArr);
                this.f134888c.flush();
            } else {
                b();
            }
        }
    }

    public void a(int i3, double d16) {
        this.f134889d.b(i3, d16);
    }

    public void a(int i3, float f16) {
        this.f134889d.b(i3, f16);
    }

    public void a(int i3, int i16) {
        this.f134889d.b(i3, i16);
    }

    public void a(int i3, long j3) {
        this.f134889d.b(i3, j3);
    }

    public void a(int i3, String str) {
        this.f134889d.b(i3, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0003. Please report as an issue. */
    public void a(int i3, int i16, LinkedList linkedList) {
        if (linkedList != null) {
            int i17 = 0;
            switch (i16) {
                case 1:
                    while (i17 < linkedList.size()) {
                        a(i3, (String) linkedList.get(i17));
                        i17++;
                    }
                    return;
                case 2:
                    while (i17 < linkedList.size()) {
                        a(i3, ((Integer) linkedList.get(i17)).intValue());
                        i17++;
                    }
                    return;
                case 3:
                    while (i17 < linkedList.size()) {
                        a(i3, ((Long) linkedList.get(i17)).longValue());
                        i17++;
                    }
                    return;
                case 4:
                    while (i17 < linkedList.size()) {
                        a(i3, ((Double) linkedList.get(i17)).doubleValue());
                        i17++;
                    }
                    return;
                case 5:
                    while (i17 < linkedList.size()) {
                        a(i3, ((Float) linkedList.get(i17)).floatValue());
                        i17++;
                    }
                    return;
                case 6:
                    while (i17 < linkedList.size()) {
                        a(i3, (c) linkedList.get(i17));
                        i17++;
                    }
                    return;
                case 7:
                    while (i17 < linkedList.size()) {
                        a(i3, ((Boolean) linkedList.get(i17)).booleanValue());
                        i17++;
                    }
                    return;
                case 8:
                    while (i17 < linkedList.size()) {
                        b bVar = (b) linkedList.get(i17);
                        c(i3, bVar.a());
                        bVar.a(this);
                        i17++;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("The data type was not found, the id used was " + i16);
            }
        }
    }

    public byte[] a() {
        this.f134887b = null;
        if (this.f134889d.b() != 0) {
            int a16 = this.f134889d.a();
            byte[] bArr = new byte[a16];
            System.arraycopy(this.f134886a, 0, bArr, 0, a16);
            this.f134887b = bArr;
            return bArr;
        }
        return this.f134886a;
    }
}
