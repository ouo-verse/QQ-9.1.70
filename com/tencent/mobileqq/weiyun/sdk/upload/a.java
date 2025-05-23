package com.tencent.mobileqq.weiyun.sdk.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends ByteArrayEntity {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected final int f315257d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f315258e;

    public a(byte[] bArr, int i3, int i16) {
        super(bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f315257d = i3;
            this.f315258e = i16;
        }
    }

    @Override // org.apache.http.entity.ByteArrayEntity, org.apache.http.HttpEntity
    public InputStream getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InputStream) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new ByteArrayInputStream(this.content, this.f315257d, this.f315258e);
    }

    @Override // org.apache.http.entity.ByteArrayEntity, org.apache.http.HttpEntity
    public long getContentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f315258e;
    }

    @Override // org.apache.http.entity.ByteArrayEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) outputStream);
        } else {
            if (outputStream != null) {
                outputStream.write(this.content, this.f315257d, this.f315258e);
                outputStream.flush();
                return;
            }
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }
}
