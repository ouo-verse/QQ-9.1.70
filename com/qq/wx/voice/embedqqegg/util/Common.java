package com.qq.wx.voice.embedqqegg.util;

import android.os.Environment;
import com.heytap.databaseengine.utils.DateUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Common {
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

    public static void saveFile(byte[] bArr, String str, boolean z16) {
        String str2;
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return;
        }
        String str3 = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/wxvoicerecord/";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder(String.valueOf(new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date())));
        if (z16) {
            str2 = "_success";
        } else {
            str2 = "_fail";
        }
        sb5.append(str2);
        sb5.append(".");
        sb5.append(str);
        File file2 = new File(str3, sb5.toString());
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
}
