package com.tencent.qfsmonet.api.data;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes22.dex */
public class MonetGLTexturePacket extends MonetPacket {
    static IPatchRedirector $redirector_;

    @IntRange(from = 0)
    private int mFramebufferId;

    @IntRange(from = 0)
    private int mTextureId;

    public MonetGLTexturePacket(@IntRange(from = 1) int i3, @NonNull MonetPacketDescriptor monetPacketDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) monetPacketDescriptor);
            return;
        }
        this.mWidth = monetPacketDescriptor.width();
        this.mHeight = monetPacketDescriptor.height();
        this.mFormat = monetPacketDescriptor.format();
        this.mTextureId = i3;
    }

    public int fboId() throws IllegalAccessException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.mFramebufferId;
        if (i3 != 0) {
            return i3;
        }
        throw new IllegalAccessException("frameBufferId is invalid!");
    }

    @Override // com.tencent.qfsmonet.api.data.MonetPacket
    public int packetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    public int textureId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mTextureId;
    }

    public MonetGLTexturePacket(@IntRange(from = 1) int i3, @IntRange(from = 1) int i16, @NonNull MonetPacketDescriptor monetPacketDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), monetPacketDescriptor);
            return;
        }
        this.mWidth = monetPacketDescriptor.width();
        this.mHeight = monetPacketDescriptor.height();
        this.mFormat = monetPacketDescriptor.format();
        this.mTextureId = i3;
        this.mFramebufferId = i16;
    }
}
