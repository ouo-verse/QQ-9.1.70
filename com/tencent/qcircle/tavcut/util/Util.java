package com.tencent.qcircle.tavcut.util;

import android.content.Context;
import android.util.TypedValue;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Util {
    public static Size constrainMaxSize(Size size, int i3) {
        int i16;
        int width = size.getWidth();
        int height = size.getHeight();
        if (size.getWidth() > size.getHeight()) {
            if (size.getWidth() > i3) {
                i16 = (int) ((i3 / ((size.getWidth() * 1.0f) / size.getHeight())) + 0.5d);
            }
            i3 = width;
            i16 = height;
        } else {
            if (size.getHeight() > i3) {
                i3 = (int) ((i3 * ((size.getWidth() * 1.0f) / size.getHeight())) + 0.5d);
                i16 = i3;
            }
            i3 = width;
            i16 = height;
        }
        return new Size(i3, i16);
    }

    public static Size constrainMinSize(Size size, int i3) {
        int i16;
        int width = size.getWidth();
        int height = size.getHeight();
        if (size.getWidth() < size.getHeight()) {
            if (size.getWidth() < i3) {
                i16 = (int) ((i3 / ((size.getWidth() * 1.0f) / size.getHeight())) + 0.5d);
            }
            i3 = width;
            i16 = height;
        } else {
            if (size.getHeight() < i3) {
                i3 = (int) ((i3 * ((size.getWidth() * 1.0f) / size.getHeight())) + 0.5d);
                i16 = i3;
            }
            i3 = width;
            i16 = height;
        }
        return new Size(i3, i16);
    }

    public static float dp2px(Context context, float f16) {
        return TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }

    public static List<String> getDirFilePaths(String str, final String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            for (File file : new File(str).listFiles(new FilenameFilter() { // from class: com.tencent.qcircle.tavcut.util.Util.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str3) {
                    return str3.endsWith(str2);
                }
            })) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception e16) {
            Logger.e(e16);
        }
        return arrayList;
    }

    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb5 = new StringBuilder(digest.length * 2);
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append("0");
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString();
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UnsupportedEncodingException", e16);
        } catch (NoSuchAlgorithmException e17) {
            throw new RuntimeException("NoSuchAlgorithmException", e17);
        }
    }

    public static float sp2px(Context context, float f16) {
        return TypedValue.applyDimension(2, f16, context.getResources().getDisplayMetrics());
    }
}
