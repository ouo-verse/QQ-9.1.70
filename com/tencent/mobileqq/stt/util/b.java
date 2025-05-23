package com.tencent.mobileqq.stt.util;

import android.media.MediaFormat;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stt.util.c;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final a f290862a;

    /* renamed from: b, reason: collision with root package name */
    private final OutputStream f290863b;

    public b(OutputStream outputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) outputStream);
        } else {
            this.f290862a = new a();
            this.f290863b = outputStream;
        }
    }

    static int c(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 3) {
                return 2;
            }
            return -1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.stt.util.c.a
    public boolean a(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        byte[] b16 = this.f290862a.b(i16);
        if (b16 == null) {
            Log.i("ADTSStream", "onDecode, get header fail");
            return false;
        }
        try {
            this.f290863b.write(b16);
            this.f290863b.write(bArr, i3, i16);
            return true;
        } catch (IOException e16) {
            Log.i("ADTSStream", "onDecode, write FAIL, + " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.stt.util.c.a
    public boolean b(MediaFormat mediaFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaFormat)).booleanValue();
        }
        if (!"audio/mp4a-latm".equals(mediaFormat.getString("mime"))) {
            Log.i("ADTSStream", "format not support, format=" + mediaFormat);
            return false;
        }
        int c16 = c(mediaFormat.getInteger("aac-profile"));
        if (c16 != 1) {
            Log.i("ADTSStream", "profile not support, format=" + mediaFormat);
            return false;
        }
        this.f290862a.d(c16);
        this.f290862a.c(mediaFormat.getInteger("channel-count"));
        this.f290862a.e(mediaFormat.getInteger("sample-rate"));
        return true;
    }
}
