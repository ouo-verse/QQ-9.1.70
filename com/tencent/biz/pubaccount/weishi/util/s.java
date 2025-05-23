package com.tencent.biz.pubaccount.weishi.util;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s {
    public static <T extends JceStruct> T c(T t16, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) a(t16, FileUtils.readFile(str));
    }

    public static byte[] b(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        try {
            JceOutputStream jceOutputStream = new JceOutputStream();
            jceOutputStream.setServerEncoding("utf8");
            jceStruct.writeTo(jceOutputStream);
            return jceOutputStream.toByteArray();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static <T extends JceStruct> T a(T t16, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf8");
                t16.readFrom(jceInputStream);
                return t16;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static boolean d(JceStruct jceStruct, String str) {
        byte[] b16;
        if (jceStruct == null || TextUtils.isEmpty(str) || (b16 = b(jceStruct)) == null || b16.length <= 0) {
            return false;
        }
        boolean writeFile = FileUtils.writeFile(b16, str, false);
        x.i("WSFileUtils", "[WSFileUtils.java][saveDataToFile] path:" + str);
        x.f("WSFileUtils", "[WSFileUtils.java][saveDataToFile] writeSuccess:" + writeFile + ", bytesLength:" + b16.length);
        return writeFile;
    }
}
