package com.tencent.qfsmonet.api.data;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

@Keep
/* loaded from: classes22.dex */
public abstract class MonetPacket {
    static IPatchRedirector $redirector_;
    protected int mFormat;

    @IntRange(from = 0)
    protected int mHeight;
    private HashMap<String, String> mParams;

    @IntRange(from = 0)
    protected int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface MonetPacketType {
        public static final int GL_TEXTURE_PACKET = 1;
        public static final int RAW_DATA_PACKET = 2;
    }

    public MonetPacket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mParams = new HashMap<>();
        }
    }

    public int format() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mFormat;
    }

    @NonNull
    public Map<String, String> getPacketParameter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mParams;
    }

    public int height() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    public abstract int packetType();

    public void setPacketParameter(@NonNull String str, @NonNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mParams.put(str, str2);
        }
    }

    public int width() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mWidth;
    }
}
