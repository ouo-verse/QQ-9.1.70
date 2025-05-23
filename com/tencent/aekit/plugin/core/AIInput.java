package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AIInput {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_FRAME = "frame";
    private Map<String, Object> aiInputs;
    private Map<Float, byte[]> frameBytes;
    private int inputTexture;
    private Map<DataSize, byte[]> sizeFrameBytes;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DataSize {
        static IPatchRedirector $redirector_;
        public int height;
        public int width;

        public DataSize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.width = i3;
                this.height = i16;
            }
        }
    }

    public AIInput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.inputTexture = -1;
        this.frameBytes = new HashMap();
        this.sizeFrameBytes = new HashMap();
        this.aiInputs = new HashMap();
    }

    public final byte[] getBytes(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        }
        return this.frameBytes.get(Float.valueOf(f16));
    }

    public Object getInput(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return this.aiInputs.get(str);
    }

    public int getInputTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.inputTexture;
    }

    public final byte[] getSizedBytes(DataSize dataSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) dataSize);
        }
        for (DataSize dataSize2 : this.sizeFrameBytes.keySet()) {
            if (dataSize2.width == dataSize.width && dataSize2.height == dataSize.height) {
                return this.sizeFrameBytes.get(dataSize2);
            }
        }
        return this.sizeFrameBytes.get(dataSize);
    }

    public void setBytes(float f16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), bArr);
        } else {
            this.frameBytes.put(Float.valueOf(f16), bArr);
        }
    }

    public void setInput(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, obj);
        } else {
            this.aiInputs.put(str, obj);
        }
    }

    public void setInputTexture(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.inputTexture = i3;
        }
    }

    public void setSizedBytes(DataSize dataSize, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dataSize, (Object) bArr);
            return;
        }
        for (DataSize dataSize2 : this.sizeFrameBytes.keySet()) {
            if (dataSize2.width == dataSize.width && dataSize2.height == dataSize.height) {
                this.sizeFrameBytes.put(dataSize2, bArr);
                return;
            }
        }
        this.sizeFrameBytes.put(dataSize, bArr);
    }
}
