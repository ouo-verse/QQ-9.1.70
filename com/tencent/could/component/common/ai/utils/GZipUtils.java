package com.tencent.could.component.common.ai.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GZipUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GZipUtils";

    public GZipUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0098: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:153), block:B:56:0x0098 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] compress(String str) {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        OutputStream outputStream2 = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    try {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            try {
                                gZIPOutputStream.write(str.getBytes("UTF-8"));
                                gZIPOutputStream.close();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e16) {
                                    Log.e(TAG, " gzip.close(): " + e16.getLocalizedMessage());
                                }
                                return byteArray;
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    throw th;
                                } catch (Throwable th7) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th8) {
                                        th.addSuppressed(th8);
                                    }
                                    throw th7;
                                }
                            }
                        } catch (IOException e17) {
                            e = e17;
                            Log.e(TAG, "compress Exception e: " + e.getLocalizedMessage());
                            if (0 != 0) {
                            }
                            return null;
                        } catch (Throwable th9) {
                            th = th9;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e18) {
                                    Log.e(TAG, " gzip.close(): " + e18.getLocalizedMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        Log.e(TAG, "compress Exception e: " + e.getLocalizedMessage());
                        if (0 != 0) {
                            try {
                                outputStream2.close();
                            } catch (IOException e26) {
                                Log.e(TAG, " gzip.close(): " + e26.getLocalizedMessage());
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                outputStream2 = outputStream;
            }
        }
        return null;
    }

    public static boolean isGzip(byte[] bArr) {
        if (((bArr[1] & 255) | (bArr[0] << 8)) != 8075) {
            return false;
        }
        return true;
    }

    public static String uncompressToString(byte[] bArr) {
        String str = null;
        if (bArr != null && bArr.length != 0) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        try {
                            byte[] bArr2 = new byte[256];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read >= 0) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                } else {
                                    str = byteArrayOutputStream.toString("UTF-8");
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    byteArrayOutputStream.close();
                                    return str;
                                }
                            }
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e16) {
                Log.e(TAG, "uncompressToString Exception e: " + e16.getLocalizedMessage());
            }
        }
        return str;
    }
}
