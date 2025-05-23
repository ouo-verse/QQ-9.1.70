package com.tencent.qfsmonet.api.data;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class MonetImagePacket extends MonetPacket {
    static IPatchRedirector $redirector_;
    private byte[] mDataBuffer;

    public MonetImagePacket(@IntRange(from = 1) int i3, @IntRange(from = 1) int i16, int i17, @NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bArr);
            return;
        }
        this.mDataBuffer = (byte[]) bArr.clone();
        this.mFormat = i17;
        this.mWidth = i3;
        this.mHeight = i16;
    }

    @Override // com.tencent.qfsmonet.api.data.MonetPacket
    public int packetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Nullable
    public byte[] readData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mDataBuffer;
    }
}
