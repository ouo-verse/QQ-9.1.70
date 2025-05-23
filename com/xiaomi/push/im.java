package com.xiaomi.push;

import android.util.Log;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class im {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f389424a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f389424a = hashMap;
        hashMap.put(HippyImageInfo.IMAGE_FLAG_JPG, "jpg");
        hashMap.put("89504E47", "png");
        hashMap.put(HippyImageInfo.IMAGE_FLAG_GIF, "gif");
        hashMap.put("474946", "gif");
        hashMap.put(HippyImageInfo.IMAGE_FLAG_BMP, "bmp");
    }

    public static long a(File file) {
        long length;
        long j3 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    length = a(listFiles[i3]);
                } else {
                    length = listFiles[i3].length();
                }
                j3 += length;
            }
        } catch (Exception e16) {
            Log.e("FileUtils", "Get folder size error: " + e16.getMessage());
        }
        return j3;
    }

    public static boolean b(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = a(file);
            } else {
                length = file.length();
            }
            if (length >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            Log.e("FileUtils", "Check if internal file can be written error :" + e16.getMessage());
            return false;
        }
    }
}
