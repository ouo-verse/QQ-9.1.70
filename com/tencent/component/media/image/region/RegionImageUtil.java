package com.tencent.component.media.image.region;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.libra.util.ImageContentType;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RegionImageUtil {
    private static final String TAG = "RegionImageUtil";
    private static ConcurrentHashMap<String, String> mImageTypeMap = new ConcurrentHashMap<>();

    public static int getRotation(String str) {
        int rotationDegree;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Integer imagePath2Rotation = DecodeImageTask.getImagePath2Rotation(str);
        if (imagePath2Rotation == null) {
            try {
                if (!new File(str).exists()) {
                    return -1;
                }
            } catch (Throwable th5) {
                ImageManagerEnv.getLogger().e(TAG, Log.getStackTraceString(th5));
            }
            rotationDegree = ImageManagerEnv.g().getRotationDegree(str);
            DecodeImageTask.putImagePath2Rotation(str, rotationDegree);
        } else {
            rotationDegree = imagePath2Rotation.intValue();
        }
        return rotationDegree % 360;
    }

    public static boolean isNeedPieceLoad(int i3, int i16) {
        if (i3 * i16 >= ((ImageManagerEnv.g().getScreenWidth() * ImageManagerEnv.g().getScreenHeight()) << 2) && ImageManagerEnv.g().isWNSSupportPieceLoad()) {
            return true;
        }
        return false;
    }

    public static boolean isValidRegionImageFormat(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (mImageTypeMap.containsKey(str)) {
            str2 = mImageTypeMap.get(str);
        } else {
            BitmapFactory.Options options = BitmapUtils.getOptions();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            String str3 = options.outMimeType;
            if (str != null && str3 != null) {
                mImageTypeMap.put(str, str3);
            }
            str2 = str3;
        }
        ImageManagerLog.i(TAG, "isValidRegionImageFormat for mimeType: " + str2);
        if (!"image/jpeg".equalsIgnoreCase(str2) && !"image/png".equalsIgnoreCase(str2) && !ImageContentType.MIME_TYPE_JPG.equalsIgnoreCase(str2)) {
            return false;
        }
        return true;
    }
}
