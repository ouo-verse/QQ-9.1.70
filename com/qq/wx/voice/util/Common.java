package com.qq.wx.voice.util;

import android.os.Environment;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Common {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f41102a = parseScreKey("5c42508c5bb7cd318c9aacf33513c7f3");

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f41103b = new byte[16];

    public static byte[] AES(byte[] bArr) {
        int i3;
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = f41102a;
            if (bArr3 != null) {
                i3 = bArr3.length;
            } else {
                i3 = 0;
            }
            for (int i16 = 0; i16 < 16; i16++) {
                if (i16 < i3) {
                    bArr2[i16] = f41102a[i16];
                } else {
                    bArr2[i16] = 123;
                }
                f41103b[i16] = 0;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(f41103b));
            return cipher.doFinal(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static int calculateSum(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17 += 2) {
            i16 += Math.abs((int) ((short) (((bArr[i17 + 1] & 255) << 8) | (bArr[i17] & 255)))) / (i3 / 2);
        }
        return i16;
    }

    public static int calculateVolumn(int i3) {
        return (int) (i3 < 30 ? 0.0d : i3 > 16383 ? 64.0d : ((i3 - 30.0d) / 12737.0d) * 64.0d);
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                return;
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
    }

    public static String genVoiceId(String str) {
        return Hex.encode(Hex.generateMD5((String.valueOf(str) + String.valueOf(System.currentTimeMillis()) + String.valueOf(new Random().nextLong())).getBytes()));
    }

    public static byte[] parseScreKey(String str) {
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[16];
        Key.convertKey(str, bArr);
        return bArr;
    }

    public static void saveFile(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return;
        }
        String str2 = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/wxvoicerecord/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str2, String.valueOf(new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date())) + "." + str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (FileNotFoundException e17) {
            e17.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
        } catch (IOException e18) {
            e18.printStackTrace();
        }
    }

    public static int calculateVolumn(byte[] bArr, int i3) {
        return calculateVolumn(calculateSum(bArr, i3));
    }

    public static byte[] compress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        compress(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }
}
