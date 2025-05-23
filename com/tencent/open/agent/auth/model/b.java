package com.tencent.open.agent.auth.model;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.agent.util.t;
import com.tencent.oskplayer.datasource.FileDataSource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.ThreeDes;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f340160a = AppConstants.SDCARD_PATH + "qqconnect/";

    private static String a() {
        return BaseApplication.getContext().getFilesDir() + File.separator + "qqconnect/";
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00e7: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:232), block:B:31:0x00e7 */
    public static byte[] b(String str, String str2) {
        DataInputStream dataInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                String string2HexString = HexUtil.string2HexString(str + "_" + str2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(a());
                sb5.append(string2HexString);
                File file = new File(sb5.toString());
                if (!file.exists()) {
                    t.b(FileDataSource.TAG, "loadAuthData nonexist file1=", file.getAbsolutePath());
                    file = new File(f340160a + string2HexString);
                }
                if (!file.exists()) {
                    t.b(FileDataSource.TAG, "loadAuthData nonexist file2=", file.getAbsolutePath());
                    com.tencent.open.agent.util.h.a(null);
                    return null;
                }
                t.b(FileDataSource.TAG, "loadAuthData from file=", file.getAbsolutePath());
                dataInputStream = new DataInputStream(new FileInputStream(file));
                try {
                    if (dataInputStream.readLong() <= System.currentTimeMillis() / 1000) {
                        t.b(FileDataSource.TAG, "loadAuthData expire");
                        com.tencent.open.agent.util.h.a(dataInputStream);
                        return null;
                    }
                    int available = dataInputStream.available();
                    if (available <= 0) {
                        com.tencent.open.agent.util.h.a(dataInputStream);
                        return null;
                    }
                    byte[] bArr = new byte[available];
                    dataInputStream.read(bArr);
                    dataInputStream.close();
                    byte[] decrypt = ThreeDes.decrypt(bArr, string2HexString.getBytes("UTF-8"));
                    com.tencent.open.agent.util.h.a(dataInputStream);
                    return decrypt;
                } catch (IOException e16) {
                    e = e16;
                    t.d(FileDataSource.TAG, "IOException", e);
                    com.tencent.open.agent.util.h.a(dataInputStream);
                    return null;
                }
            } catch (IOException e17) {
                e = e17;
                dataInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                com.tencent.open.agent.util.h.a(closeable2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            com.tencent.open.agent.util.h.a(closeable2);
            throw th;
        }
    }

    public static void c(String str, String str2, long j3, byte[] bArr) {
        DataOutputStream dataOutputStream = null;
        try {
            try {
                File file = new File(a());
                if (!file.exists()) {
                    file.mkdirs();
                } else if (file.isFile()) {
                    file.delete();
                    file.mkdirs();
                }
                String string2HexString = HexUtil.string2HexString(str + "_" + str2);
                File file2 = new File(file, string2HexString);
                if (file2.exists()) {
                    file2.delete();
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + j3;
                DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file2));
                try {
                    dataOutputStream2.writeLong(currentTimeMillis);
                    dataOutputStream2.write(ThreeDes.encrypt(bArr, string2HexString.getBytes("UTF-8")));
                    t.b(FileDataSource.TAG, "saveAuthData success file=", file2.getAbsolutePath());
                    com.tencent.open.agent.util.h.a(dataOutputStream2);
                } catch (IOException e16) {
                    e = e16;
                    dataOutputStream = dataOutputStream2;
                    t.d(FileDataSource.TAG, "IOException", e);
                    com.tencent.open.agent.util.h.a(dataOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = dataOutputStream2;
                    com.tencent.open.agent.util.h.a(dataOutputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
