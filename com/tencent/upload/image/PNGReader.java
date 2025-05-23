package com.tencent.upload.image;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes27.dex */
public class PNGReader {
    static IPatchRedirector $redirector_ = null;
    private static final int IHDR = 1229472850;
    private static final long SIGNATURE = -8552249625308161526L;
    private byte bit_depth;
    private byte color_type;
    private int height;
    private int width;

    public PNGReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.width = 0;
            this.height = 0;
        }
    }

    private int readInt(byte[] bArr, int i3) throws Exception {
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i3] & 255) << 24) | ((bArr[i16] & 255) << 16);
        int i19 = i17 + 1;
        return (bArr[i19] & 255) | i18 | ((bArr[i17] & 255) << 8);
    }

    private long readLong(InputStream inputStream) throws Exception {
        inputStream.read(new byte[8], 0, 8);
        return (r1[7] & 255) | ((r1[0] & 255) << 56) | ((r1[1] & 255) << 48) | ((r1[2] & 255) << 40) | ((r1[3] & 255) << 32) | ((r1[4] & 255) << 24) | ((r1[5] & 255) << 16) | ((r1[6] & 255) << 8);
    }

    private boolean read_IHDR(InputStream inputStream) throws Exception {
        if (readInt(inputStream) != 13 || readInt(inputStream) != IHDR) {
            return false;
        }
        byte[] bArr = new byte[13];
        inputStream.read(bArr, 0, 13);
        this.width = readInt(bArr, 0);
        this.height = readInt(bArr, 4);
        this.bit_depth = bArr[8];
        this.color_type = bArr[9];
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3 */
    public boolean isTransparentPng(String str) {
        byte b16;
        String str2 = ImageProcessService.TAG;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        unpackImage(fileInputStream2);
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        Log.w(ImageProcessService.TAG, e.toString());
                        fileInputStream.close();
                        b16 = this.bit_depth;
                        str2 = 8;
                        if (b16 != 8) {
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            Log.w(str2, e17.toString());
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } catch (IOException e19) {
                Log.w(ImageProcessService.TAG, e19.toString());
            }
            b16 = this.bit_depth;
            str2 = 8;
            if ((b16 != 8 || b16 == 16) && this.color_type == 6) {
                return true;
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void unpackImage(InputStream inputStream) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) inputStream);
        } else if (readLong(inputStream) != SIGNATURE || read_IHDR(inputStream)) {
        } else {
            throw new IOException("Not a valid png image !!!");
        }
    }

    private int readInt(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[4];
        inputStream.read(bArr, 0, 4);
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }
}
