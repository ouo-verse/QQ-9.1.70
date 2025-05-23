package com.tencent.luggage.wxa.tn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {
    /* JADX WARN: Removed duplicated region for block: B:56:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2) {
        OutputStream outputStream;
        if (!w0.c(str) && !w0.c(str2)) {
            boolean z16 = true;
            if (str.equals(str2)) {
                return true;
            }
            InputStream inputStream = null;
            r1 = null;
            OutputStream outputStream2 = null;
            inputStream = null;
            try {
                InputStream n3 = com.tencent.luggage.wxa.cp.x.n(str);
                try {
                    outputStream2 = com.tencent.luggage.wxa.cp.x.o(str2);
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = n3.read(bArr);
                        if (read != -1) {
                            outputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e16) {
                                w.a("MicroMsg.SDK.FilesCopy", e16, "", new Object[0]);
                                z16 = false;
                            }
                        }
                    }
                    n3.close();
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e17) {
                            w.a("MicroMsg.SDK.FilesCopy", e17, "", new Object[0]);
                            return false;
                        }
                    }
                    return z16;
                } catch (Exception e18) {
                    e = e18;
                    OutputStream outputStream3 = outputStream2;
                    inputStream = n3;
                    outputStream = outputStream3;
                    try {
                        w.a("MicroMsg.SDK.FilesCopy", e, "", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e19) {
                                w.a("MicroMsg.SDK.FilesCopy", e19, "", new Object[0]);
                            }
                        }
                        if (outputStream == null) {
                            return false;
                        }
                        try {
                            outputStream.close();
                            return false;
                        } catch (IOException e26) {
                            w.a("MicroMsg.SDK.FilesCopy", e26, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e27) {
                                w.a("MicroMsg.SDK.FilesCopy", e27, "", new Object[0]);
                            }
                        }
                        if (outputStream == null) {
                            try {
                                outputStream.close();
                                throw th;
                            } catch (IOException e28) {
                                w.a("MicroMsg.SDK.FilesCopy", e28, "", new Object[0]);
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OutputStream outputStream4 = outputStream2;
                    inputStream = n3;
                    outputStream = outputStream4;
                    if (inputStream != null) {
                    }
                    if (outputStream == null) {
                    }
                }
            } catch (Exception e29) {
                e = e29;
                outputStream = null;
            } catch (Throwable th7) {
                th = th7;
                outputStream = null;
            }
        } else {
            w.f("MicroMsg.SDK.FilesCopy", "copy file but src path or dest path is null, return false.");
            return false;
        }
    }

    public static boolean a(String str, String str2, boolean z16) {
        if (w0.c(str)) {
            return false;
        }
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str);
        if (!vVar.e()) {
            return false;
        }
        com.tencent.luggage.wxa.cp.v vVar2 = new com.tencent.luggage.wxa.cp.v(str2);
        if (vVar.q()) {
            if (!vVar2.q() && vVar2.e()) {
                return false;
            }
            a(str, str2);
            if (!z16) {
                return true;
            }
            vVar.d();
            return true;
        }
        if (!vVar.p()) {
            return true;
        }
        if (!vVar2.e()) {
            vVar2.v();
        }
        if (!vVar2.p()) {
            return false;
        }
        String[] t16 = vVar.t();
        for (int i3 = 0; i3 < t16.length; i3++) {
            a(str + "/" + t16[i3], str2 + "/" + t16[i3], z16);
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:2|3|(2:4|(1:6)(1:7))|(1:9)(8:26|(2:28|29)|32|11|12|(2:17|18)|14|15)|10|11|12|(0)|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.SDK.FilesCopy", r8, "", new java.lang.Object[0]);
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0034, code lost:
    
        if (r4 == r10.s()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(InputStream inputStream, String str, boolean z16) {
        boolean z17;
        OutputStream outputStream = null;
        try {
            try {
                int available = inputStream.available();
                outputStream = com.tencent.luggage.wxa.cp.x.d(str, z16);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                if (!z16) {
                    com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str);
                    if (vVar.e()) {
                    }
                    z17 = false;
                    inputStream.close();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e16) {
                            w.a("MicroMsg.SDK.FilesCopy", e16, "", new Object[0]);
                            return false;
                        }
                    }
                    return z17;
                }
                z17 = true;
                inputStream.close();
                if (outputStream != null) {
                }
                return z17;
            } catch (Exception e17) {
                w.a("MicroMsg.SDK.FilesCopy", e17, "", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        w.a("MicroMsg.SDK.FilesCopy", e18, "", new Object[0]);
                    }
                }
                if (outputStream == null) {
                    return false;
                }
                try {
                    outputStream.close();
                    return false;
                } catch (IOException e19) {
                    w.a("MicroMsg.SDK.FilesCopy", e19, "", new Object[0]);
                    return false;
                }
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e26) {
                    w.a("MicroMsg.SDK.FilesCopy", e26, "", new Object[0]);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    throw th5;
                } catch (IOException e27) {
                    w.a("MicroMsg.SDK.FilesCopy", e27, "", new Object[0]);
                    throw th5;
                }
            }
            throw th5;
        }
    }
}
