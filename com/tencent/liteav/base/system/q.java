package com.tencent.liteav.base.system;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;
import org.jf.dexlib2.analysis.RegisterType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f119000a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:52:0x01d0, code lost:
    
        if (r3 == null) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017c A[Catch: all -> 0x01b2, Exception -> 0x01b5, TryCatch #13 {Exception -> 0x01b5, all -> 0x01b2, blocks: (B:36:0x015b, B:38:0x017c, B:39:0x017f, B:41:0x019d, B:42:0x01a0), top: B:35:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019d A[Catch: all -> 0x01b2, Exception -> 0x01b5, TryCatch #13 {Exception -> 0x01b5, all -> 0x01b2, blocks: (B:36:0x015b, B:38:0x017c, B:39:0x017f, B:41:0x019d, B:42:0x01a0), top: B:35:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7 A[LOOP:0: B:67:0x00c1->B:69:0x00c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f6 A[EDGE_INSN: B:70:0x00f6->B:71:0x00f6 BREAK  A[LOOP:0: B:67:0x00c1->B:69:0x00c7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f9 A[LOOP:1: B:72:0x00f7->B:73:0x00f9, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        FileInputStream fileInputStream;
        String str2;
        String str3;
        long currentTimeMillis;
        int i3;
        int i16;
        int i17;
        File file;
        String sb5;
        FileOutputStream fileOutputStream;
        File file2;
        File file3;
        Context applicationContext = ContextUtils.getApplicationContext();
        String str4 = "";
        if (applicationContext == null) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        File externalFilesDir = applicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            Log.e("UUID", "getDeviceUuid: sdcardDir is null.", new Object[0]);
            return "";
        }
        PersistStorage persistStorage = new PersistStorage("com.tencent.liteav.dev_uuid");
        String string = persistStorage.getString("com.tencent.liteav.key_dev_uuid");
        try {
            File file4 = new File(externalFilesDir.getAbsolutePath() + "/liteav/spuid");
            if (file4.exists()) {
                fileInputStream = new FileInputStream(file4);
                try {
                    try {
                        int available = fileInputStream.available();
                        if (available > 0) {
                            byte[] bArr = new byte[available];
                            fileInputStream.read(bArr);
                            str2 = new String(bArr, "UTF-8");
                        } else {
                            str2 = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    Log.e("UUID", "Read UUID from file failed." + e.getMessage(), new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    str2 = null;
                    if (string == null) {
                    }
                    if (str2 == null) {
                    }
                    str3 = null;
                    if (str3 == null) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    i3 = 5;
                    while (true) {
                        i16 = 1;
                        if (i3 >= 0) {
                        }
                        str4 = str4 + String.format("%02x", Byte.valueOf((byte) ((currentTimeMillis >> (i3 * 8)) & 255)));
                        i3--;
                        currentTimeMillis = currentTimeMillis;
                    }
                    i17 = 3;
                    while (i17 >= 0) {
                    }
                    file = externalFilesDir;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str4);
                    sb6.append(b(str + UUID.randomUUID().toString()));
                    sb5 = sb6.toString();
                    if (str2 != null) {
                    }
                    try {
                        file2 = new File(file.getAbsolutePath() + "/liteav");
                        if (!file2.exists()) {
                        }
                        file3 = new File(file.getAbsolutePath() + "/liteav/spuid");
                        if (!file3.exists()) {
                        }
                        fileOutputStream = new FileOutputStream(file3);
                    } catch (Exception e17) {
                        e = e17;
                        fileOutputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            fileOutputStream.write(sb5.getBytes());
                        } catch (Throwable th7) {
                            th = th7;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        Log.e("UUID", "Write UUID to file failed." + e.getMessage(), new Object[0]);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } else {
                str2 = null;
                fileInputStream = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused5) {
                }
            }
        } catch (Exception e19) {
            e = e19;
            fileInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        if (string == null && string.length() > 0) {
            str3 = string;
        } else if (str2 == null && str2.length() > 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        if (str3 == null && str3.length() != 0) {
            sb5 = str3;
            file = externalFilesDir;
        } else {
            currentTimeMillis = System.currentTimeMillis();
            long uptimeMillis2 = SystemClock.uptimeMillis();
            i3 = 5;
            while (true) {
                i16 = 1;
                if (i3 >= 0) {
                    break;
                }
                str4 = str4 + String.format("%02x", Byte.valueOf((byte) ((currentTimeMillis >> (i3 * 8)) & 255)));
                i3--;
                currentTimeMillis = currentTimeMillis;
            }
            i17 = 3;
            while (i17 >= 0) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str4);
                Object[] objArr = new Object[i16];
                objArr[0] = Byte.valueOf((byte) ((uptimeMillis2 >> (i17 * 8)) & 255));
                sb7.append(String.format("%02x", objArr));
                str4 = sb7.toString();
                i17--;
                externalFilesDir = externalFilesDir;
                i16 = 1;
            }
            file = externalFilesDir;
            StringBuilder sb62 = new StringBuilder();
            sb62.append(str4);
            sb62.append(b(str + UUID.randomUUID().toString()));
            sb5 = sb62.toString();
        }
        if (str2 != null || !str2.equals(sb5)) {
            file2 = new File(file.getAbsolutePath() + "/liteav");
            if (!file2.exists()) {
                file2.mkdir();
            }
            file3 = new File(file.getAbsolutePath() + "/liteav/spuid");
            if (!file3.exists()) {
                file3.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file3);
            fileOutputStream.write(sb5.getBytes());
            fileOutputStream.close();
        }
        if (string == null || !string.equals(sb5)) {
            persistStorage.put("com.tencent.liteav.key_dev_uuid", sb5);
            persistStorage.commit();
        }
        return sb5;
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            char[] cArr = new char[digest.length << 1];
            int i3 = 0;
            for (byte b16 : digest) {
                int i16 = i3 + 1;
                char[] cArr2 = f119000a;
                cArr[i3] = cArr2[(b16 & 240) >>> 4];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        } catch (Exception e16) {
            Log.e("UUID", "stringToMd5 failed.", e16);
            return "";
        }
    }
}
