package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceCoffee;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes27.dex */
class DeviceParser {
    private static final String TAG = "DeviceParser";

    DeviceParser() {
    }

    private static InputStream drinkACupOfCoffeeForCamera(InputStream inputStream, String str, String str2) throws IOException {
        byte[] drink = DeviceCoffee.drink(IOUtils.toByteArray(inputStream), str, str2);
        if (drink == null) {
            return null;
        }
        return new ByteArrayInputStream(drink);
    }

    private static InputStream drinkACupOfCoffeeForFast(InputStream inputStream, String str) throws IOException {
        return new ByteArrayInputStream(DeviceCoffee.drinkRawData(IOUtils.toByteArray(inputStream), str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0065, code lost:
    
        if (r7 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00b5, code lost:
    
        if (r6 != 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00a9, code lost:
    
        if (r6 == 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r7 != null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8 A[Catch: all -> 0x0103, Exception -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #23 {Exception -> 0x0107, all -> 0x0103, blocks: (B:16:0x0044, B:18:0x00c8, B:109:0x006b, B:110:0x006e), top: B:4:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0116 A[Catch: IOException -> 0x0112, TryCatch #18 {IOException -> 0x0112, blocks: (B:44:0x010e, B:31:0x0116, B:33:0x011b, B:35:0x0120), top: B:43:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b A[Catch: IOException -> 0x0112, TryCatch #18 {IOException -> 0x0112, blocks: (B:44:0x010e, B:31:0x0116, B:33:0x011b, B:35:0x0120), top: B:43:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0120 A[Catch: IOException -> 0x0112, TRY_LEAVE, TryCatch #18 {IOException -> 0x0112, blocks: (B:44:0x010e, B:31:0x0116, B:33:0x011b, B:35:0x0120), top: B:43:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148 A[Catch: IOException -> 0x0144, TryCatch #13 {IOException -> 0x0144, blocks: (B:65:0x0140, B:52:0x0148, B:54:0x014d, B:56:0x0152), top: B:64:0x0140 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d A[Catch: IOException -> 0x0144, TryCatch #13 {IOException -> 0x0144, blocks: (B:65:0x0140, B:52:0x0148, B:54:0x014d, B:56:0x0152), top: B:64:0x0140 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0152 A[Catch: IOException -> 0x0144, TRY_LEAVE, TryCatch #13 {IOException -> 0x0144, blocks: (B:65:0x0140, B:52:0x0148, B:54:0x014d, B:56:0x0152), top: B:64:0x0140 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0166 A[Catch: IOException -> 0x0162, TryCatch #29 {IOException -> 0x0162, blocks: (B:82:0x015e, B:71:0x0166, B:73:0x016b, B:75:0x0170), top: B:81:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016b A[Catch: IOException -> 0x0162, TryCatch #29 {IOException -> 0x0162, blocks: (B:82:0x015e, B:71:0x0166, B:73:0x016b, B:75:0x0170), top: B:81:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0170 A[Catch: IOException -> 0x0162, TRY_LEAVE, TryCatch #29 {IOException -> 0x0162, blocks: (B:82:0x015e, B:71:0x0166, B:73:0x016b, B:75:0x0170), top: B:81:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String parseCameraAttrsFile(Context context, String str, String str2, String str3) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream2;
        InputStream inputStream2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ?? r95;
        InputStream inputStream3;
        FileInputStream fileInputStream3;
        InputStream inputStream4;
        FileInputStream fileInputStream4;
        InputStreamReader inputStreamReader2;
        String str4;
        BufferedReader bufferedReader3;
        String str5 = TAG;
        LogUtils.v(str5, "[parseCameraAttrsFile] filePath = " + ((String) str));
        BufferedReader bufferedReader4 = null;
        try {
            File file = new File((String) str);
            try {
                if (file.exists() && file.isFile()) {
                    try {
                        LogUtils.v(str5, "[parseCameraAttrsFile] parseFile file exists and isFile");
                        try {
                            fileInputStream4 = new FileInputStream(file);
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream4 = null;
                            inputStream4 = null;
                        } catch (UnsatisfiedLinkError e17) {
                            e = e17;
                            fileInputStream4 = null;
                            inputStream4 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            str = 0;
                        }
                        try {
                            inputStream4 = drinkACupOfCoffeeForCamera(fileInputStream4, str2, str3);
                            if (inputStream4 != null) {
                                try {
                                    IOUtils.closeQuietly(fileInputStream4);
                                } catch (Exception e18) {
                                    e = e18;
                                    e.printStackTrace();
                                    if (inputStream4 != null) {
                                        inputStream4.close();
                                    }
                                    if (inputStream4 != null) {
                                    }
                                    if (bufferedReader4 != null) {
                                    }
                                    if (inputStreamReader2 != null) {
                                    }
                                    if (inputStream4 != null) {
                                    }
                                    if (fileInputStream4 != null) {
                                    }
                                    return str4;
                                } catch (UnsatisfiedLinkError e19) {
                                    e = e19;
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e26) {
                            e = e26;
                            inputStream4 = null;
                        } catch (UnsatisfiedLinkError e27) {
                            e = e27;
                            inputStream4 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            str = 0;
                            if (str != 0) {
                                str.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } else {
                    LogUtils.v(str5, "[parseCameraAttrsFile] parseFile file is in Assets directory");
                    try {
                        try {
                            if (context != 0) {
                                try {
                                    context = context.getAssets().open(str);
                                } catch (IOException e28) {
                                    e = e28;
                                    context = 0;
                                    inputStream4 = null;
                                } catch (UnsatisfiedLinkError e29) {
                                    e = e29;
                                    context = 0;
                                    inputStream4 = null;
                                } catch (Throwable th8) {
                                    th = th8;
                                    context = 0;
                                }
                                try {
                                    inputStream4 = drinkACupOfCoffeeForCamera(context, str2, str3);
                                    context = context;
                                    inputStream4 = inputStream4;
                                    if (inputStream4 != null) {
                                        try {
                                            IOUtils.closeQuietly((InputStream) context);
                                            context = context;
                                            inputStream4 = inputStream4;
                                        } catch (IOException e36) {
                                            e = e36;
                                            e.printStackTrace();
                                            if (context != 0) {
                                                context.close();
                                            }
                                            fileInputStream4 = null;
                                            if (inputStream4 != null) {
                                            }
                                            if (bufferedReader4 != null) {
                                            }
                                            if (inputStreamReader2 != null) {
                                            }
                                            if (inputStream4 != null) {
                                            }
                                            if (fileInputStream4 != null) {
                                            }
                                            return str4;
                                        } catch (UnsatisfiedLinkError e37) {
                                            e = e37;
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (IOException e38) {
                                    e = e38;
                                    inputStream4 = null;
                                } catch (UnsatisfiedLinkError e39) {
                                    e = e39;
                                    inputStream4 = null;
                                } catch (Throwable th9) {
                                    th = th9;
                                    if (context != 0) {
                                        context.close();
                                    }
                                    throw th;
                                }
                            } else {
                                context = 0;
                                inputStream4 = null;
                            }
                        } catch (Exception e46) {
                            e = e46;
                            fileInputStream2 = null;
                            bufferedReader = null;
                            inputStream2 = str;
                            bufferedReader2 = bufferedReader;
                            fileInputStream3 = fileInputStream2;
                            inputStream3 = inputStream2;
                            r95 = bufferedReader;
                            try {
                                LogUtils.e(TAG, "parseCameraAttrsFile exception", e, new Object[0]);
                                if (bufferedReader2 != null) {
                                }
                                if (r95 != 0) {
                                }
                                if (inputStream3 != null) {
                                }
                                if (fileInputStream3 != null) {
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                bufferedReader4 = bufferedReader2;
                                fileInputStream = fileInputStream3;
                                inputStream = inputStream3;
                                inputStreamReader = r95;
                                if (bufferedReader4 != null) {
                                    try {
                                        bufferedReader4.close();
                                    } catch (IOException e47) {
                                        LogUtils.e(e47);
                                        throw th;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            fileInputStream = null;
                            inputStreamReader = null;
                            inputStream = str;
                            if (bufferedReader4 != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                    }
                }
                if (inputStream4 != null) {
                    inputStreamReader2 = new InputStreamReader(inputStream4);
                    try {
                        bufferedReader3 = new BufferedReader(inputStreamReader2, 1024);
                    } catch (Exception e48) {
                        bufferedReader2 = null;
                        r95 = inputStreamReader2;
                        e = e48;
                        fileInputStream3 = fileInputStream4;
                        inputStream3 = inputStream4;
                    } catch (Throwable th13) {
                        inputStreamReader = inputStreamReader2;
                        th = th13;
                        fileInputStream = fileInputStream4;
                        inputStream = inputStream4;
                    }
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        }
                        bufferedReader4 = bufferedReader3;
                        str4 = stringBuffer.toString();
                    } catch (Exception e49) {
                        r95 = inputStreamReader2;
                        e = e49;
                        bufferedReader2 = bufferedReader3;
                        fileInputStream3 = fileInputStream4;
                        inputStream3 = inputStream4;
                        LogUtils.e(TAG, "parseCameraAttrsFile exception", e, new Object[0]);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e56) {
                                LogUtils.e(e56);
                                return null;
                            }
                        }
                        if (r95 != 0) {
                            r95.close();
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (fileInputStream3 != null) {
                            return null;
                        }
                        fileInputStream3.close();
                        return null;
                    } catch (Throwable th14) {
                        bufferedReader4 = bufferedReader3;
                        inputStreamReader = inputStreamReader2;
                        th = th14;
                        fileInputStream = fileInputStream4;
                        inputStream = inputStream4;
                        if (bufferedReader4 != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    inputStreamReader2 = null;
                    str4 = null;
                }
                if (bufferedReader4 != null) {
                    try {
                        bufferedReader4.close();
                    } catch (IOException e57) {
                        LogUtils.e(e57);
                    }
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (inputStream4 != null) {
                    inputStream4.close();
                }
                if (fileInputStream4 != null) {
                    fileInputStream4.close();
                }
                return str4;
            } catch (Exception e58) {
                e = e58;
                bufferedReader = null;
                fileInputStream2 = context;
                inputStream2 = str;
            } catch (Throwable th15) {
                th = th15;
                inputStreamReader = null;
                fileInputStream = context;
                inputStream = str;
            }
        } catch (Exception e59) {
            e = e59;
            fileInputStream2 = null;
            inputStream2 = null;
            bufferedReader = null;
        } catch (Throwable th16) {
            th = th16;
            fileInputStream = null;
            inputStream = null;
            inputStreamReader = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0061, code lost:
    
        r4 = new java.io.InputStreamReader(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
    
        r6 = new java.io.BufferedReader(r4, 1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        r0 = new java.lang.StringBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0072, code lost:
    
        r2 = r6.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
    
        if (r2 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
    
        r0.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        r1 = r6;
        r6 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00aa, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ad, code lost:
    
        if (r5 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b3, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a2, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008c, code lost:
    
        r3 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
    
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c0, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if (r0 != null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cb, code lost:
    
        if (r5 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cd, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d0, code lost:
    
        if (r6 != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d2, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d6, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c5, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00da, code lost:
    
        r4 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00db, code lost:
    
        r1 = r0;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00dc, code lost:
    
        if (r1 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e4, code lost:
    
        if (r5 != null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e6, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        if (r6 != 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00eb, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e2, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ef, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f2, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00de, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0084, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0085, code lost:
    
        r1 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0097, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0098, code lost:
    
        r0 = null;
        r3 = r5;
        r5 = r4;
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0091, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0092, code lost:
    
        r3 = r5;
        r5 = r4;
        r4 = r6;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x009e, code lost:
    
        r4 = null;
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004e, code lost:
    
        if (r4 != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0042, code lost:
    
        if (r4 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0050, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005f, code lost:
    
        if (r5 == null) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e6 A[Catch: IOException -> 0x00e2, TryCatch #15 {IOException -> 0x00e2, blocks: (B:69:0x00de, B:60:0x00e6, B:62:0x00eb), top: B:68:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb A[Catch: IOException -> 0x00e2, TRY_LEAVE, TryCatch #15 {IOException -> 0x00e2, blocks: (B:69:0x00de, B:60:0x00e6, B:62:0x00eb), top: B:68:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v24, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String parseFastCaptureFile(Context context, String str, String str2) {
        InputStreamReader inputStreamReader;
        ?? r65;
        ?? r66;
        BufferedReader bufferedReader;
        InputStream inputStream;
        String str3 = TAG;
        LogUtils.v(str3, "[parseFastCaptureFile] filePath = " + str);
        BufferedReader bufferedReader2 = null;
        try {
            LogUtils.v(str3, "[parseFastCaptureFile] parseFile file is in Assets directory");
            try {
                try {
                    if (context != 0) {
                        try {
                            context = context.getAssets().open(str);
                        } catch (IOException e16) {
                            e = e16;
                            context = 0;
                            inputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            context = 0;
                        }
                        try {
                            inputStream = drinkACupOfCoffeeForFast(context, str2);
                        } catch (IOException e17) {
                            e = e17;
                            inputStream = null;
                        } catch (Throwable th6) {
                            th = th6;
                            if (context != 0) {
                                context.close();
                            }
                            throw th;
                        }
                        try {
                            IOUtils.closeQuietly((InputStream) context);
                            context = context;
                        } catch (IOException e18) {
                            e = e18;
                            e.printStackTrace();
                        }
                    } else {
                        context = 0;
                        inputStream = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    r66 = str;
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    th = th7;
                    r65 = str;
                    inputStreamReader = null;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Exception e26) {
            e = e26;
            inputStreamReader = null;
            r66 = 0;
            bufferedReader = null;
        } catch (Throwable th9) {
            th = th9;
            inputStreamReader = null;
            r65 = 0;
        }
    }
}
