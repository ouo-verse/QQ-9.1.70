package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.AbsSessionInputBuffer;
import java.io.IOException;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends AbsSessionInputBuffer {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.linebuffer = new ByteArrayBuffer(1024);
        this.charset = "US-ASCII";
        this.ascii = true;
        this.maxLineLen = -1;
        this.metrics = new HttpTransportMetricsImpl();
    }

    public void a(byte[] bArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        int i16 = this.bufferlen;
        if (i16 != 0 && (i3 = this.bufferpos) < i16) {
            int i17 = i16 - i3;
            byte[] bArr2 = new byte[bArr.length + i17];
            System.arraycopy(this.buffer, i3, bArr2, 0, i17);
            System.arraycopy(bArr, 0, bArr2, i17, bArr.length);
            this.buffer = bArr2;
        } else {
            byte[] bArr3 = new byte[bArr.length];
            this.buffer = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        }
        this.bufferpos = 0;
        this.bufferlen = this.buffer.length;
        ByteArrayBuffer byteArrayBuffer = this.linebuffer;
        if (byteArrayBuffer != null) {
            byteArrayBuffer.clear();
        }
        this.metrics.incrementBytesTransferred(bArr.length);
    }

    @Override // com.tencent.qphone.base.util.AbsSessionInputBuffer
    protected int fillBuffer() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        return hasBufferedData();
    }
}
