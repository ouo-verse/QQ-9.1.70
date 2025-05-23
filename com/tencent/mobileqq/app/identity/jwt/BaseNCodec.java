package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class BaseNCodec {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class Context {
        static IPatchRedirector $redirector_;
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNCodec(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.pad = PAD_DEFAULT;
        this.unencodedBlockSize = i3;
        this.encodedBlockSize = i16;
        this.lineLength = i17 > 0 && i18 > 0 ? (i17 / i16) * i16 : 0;
        this.chunkSeparatorLength = i18;
    }

    private byte[] resizeBuffer(Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            context.buffer = bArr2;
        }
        return context.buffer;
    }

    int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean containsAlphabetOrPad(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr)).booleanValue();
        }
        if (bArr == null) {
            return false;
        }
        for (byte b16 : bArr) {
            if (61 == b16 || isInAlphabet(b16)) {
                return true;
            }
        }
        return false;
    }

    abstract void decode(byte[] bArr, int i3, int i16, Context context);

    public byte[] decode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? decode(str.getBytes()) : (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] ensureBufferSize(int i3, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) context);
        }
        byte[] bArr = context.buffer;
        if (bArr != null && bArr.length >= context.pos + i3) {
            return bArr;
        }
        return resizeBuffer(context);
    }

    protected int getDefaultBufferSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 8192;
    }

    protected abstract boolean isInAlphabet(byte b16);

    int readResults(byte[] bArr, int i3, int i16, Context context) {
        if (context.buffer != null) {
            int min = Math.min(available(context), i16);
            System.arraycopy(context.buffer, context.readPos, bArr, i3, min);
            int i17 = context.readPos + min;
            context.readPos = i17;
            if (i17 >= context.pos) {
                context.buffer = null;
            }
            return min;
        }
        if (context.eof) {
            return -1;
        }
        return 0;
    }

    public byte[] decode(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        }
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i3 = context.pos;
        byte[] bArr2 = new byte[i3];
        readResults(bArr2, 0, i3, context);
        return bArr2;
    }
}
