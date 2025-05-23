package com.tencent.luggage.wxa.ri;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends c {

    /* renamed from: h, reason: collision with root package name */
    public OutputStream f139768h;

    /* renamed from: i, reason: collision with root package name */
    public v f139769i;

    @Override // com.tencent.luggage.wxa.ri.d
    public boolean a(String str, int i3, int i16, int i17) {
        a(str);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void close() {
        a();
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void flush() {
        a(new byte[0], 0, true);
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public boolean a(boolean z16, byte[] bArr, int i3) {
        a(bArr, i3, z16);
        a(bArr);
        return true;
    }

    public final boolean a(String str) {
        try {
            v vVar = new v(str);
            this.f139769i = vVar;
            if (vVar.e()) {
                this.f139769i.d();
            }
            this.f139769i.c();
            this.f139768h = new DataOutputStream(x.o(str));
            return true;
        } catch (Exception e16) {
            w.f("Luggage.PCMAudioEncoder", "", e16);
            return false;
        }
    }

    public final void a(byte[] bArr) {
        try {
            OutputStream outputStream = this.f139768h;
            if (outputStream != null) {
                outputStream.write(bArr);
            }
        } catch (Exception unused) {
        }
    }

    public final void a() {
        OutputStream outputStream = this.f139768h;
        if (outputStream != null) {
            try {
                outputStream.flush();
                this.f139768h.close();
            } catch (IOException unused) {
            }
            this.f139768h = null;
        }
    }
}
