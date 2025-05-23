package com.tencent.avcore.jni.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
@RequiresApi(api = 16)
/* loaded from: classes3.dex */
public class BufferData {
    static IPatchRedirector $redirector_;
    public ByteBuffer buffer;
    public MediaFormat format;
    public int index;
    public MediaCodec.BufferInfo info;
    public boolean success;

    public BufferData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.info = new MediaCodec.BufferInfo();
            this.success = true;
        }
    }
}
