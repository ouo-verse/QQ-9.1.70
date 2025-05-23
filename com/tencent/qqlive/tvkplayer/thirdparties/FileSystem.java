package com.tencent.qqlive.tvkplayer.thirdparties;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKIOUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileSystem {
    public static void clearCache(Context context) {
        clearInternalCache(context);
        clearExternalCache(context);
    }

    public static void clearExternalCache(Context context) {
        TVKIOUtil.recursiveDelete(getExternalCacheDirectory(context));
    }

    public static void clearInternalCache(Context context) {
        TVKIOUtil.recursiveDelete(getInternalCacheDirectory(context));
    }

    public static void deleteDirectory(Context context, String str) {
        deleteInternalDirectory(context, str);
        deleteExternalDirectory(context, str);
    }

    public static void deleteExternalDirectory(Context context, String str) {
        TVKIOUtil.recursiveDelete(getExternalDirectory(context, str));
    }

    public static void deleteInternalDirectory(Context context, String str) {
        TVKIOUtil.recursiveDelete(getInternalDirectory(context, str));
    }

    public static File getExternalCacheDirectory(Context context) {
        return context.getExternalCacheDir();
    }

    public static File getExternalCacheFile(Context context, String str, String str2) {
        File externalCacheDirectory = getExternalCacheDirectory(context, str);
        if (externalCacheDirectory == null) {
            return null;
        }
        return new File(externalCacheDirectory, str2);
    }

    public static File getExternalDirectory(Context context) {
        return context.getExternalFilesDir(null);
    }

    public static File getExternalFile(Context context, String str, String str2) {
        File externalDirectory = getExternalDirectory(context, str);
        if (externalDirectory == null) {
            return null;
        }
        return new File(externalDirectory, str2);
    }

    public static File getInternalCacheDirectory(Context context) {
        return context.getCacheDir();
    }

    public static File getInternalCacheFile(Context context, String str, String str2) {
        File internalCacheDirectory = getInternalCacheDirectory(context, str);
        if (internalCacheDirectory == null) {
            return null;
        }
        return new File(internalCacheDirectory, str2);
    }

    public static File getInternalDirectory(Context context) {
        try {
            return context.getCacheDir();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static File getInternalFile(Context context, String str, String str2) {
        File internalDirectory = getInternalDirectory(context, str);
        if (internalDirectory == null) {
            return null;
        }
        return new File(internalDirectory, str2);
    }

    public static File getNewerCacheFile(Context context, String str, String str2) {
        return TVKIOUtil.compare(getInternalCacheFile(context, str, str2), getExternalCacheFile(context, str, str2));
    }

    public static File getNewerFile(Context context, String str, String str2) {
        return TVKIOUtil.compare(getInternalFile(context, str, str2), getExternalFile(context, str, str2));
    }

    public static File getProperCacheDirectory(Context context, String str) {
        if (TVKIOUtil.isExternalStorageMounted()) {
            return getExternalCacheDirectory(context, str);
        }
        return getInternalCacheDirectory(context, str);
    }

    public static File getProperCacheFile(Context context, String str, String str2) {
        if (TVKIOUtil.isExternalStorageMounted()) {
            return getExternalCacheFile(context, str, str2);
        }
        return getInternalCacheFile(context, str, str2);
    }

    public static File getProperDirectory(Context context, String str) {
        if (TVKIOUtil.isExternalStorageMounted()) {
            return getExternalDirectory(context, str);
        }
        return getInternalDirectory(context, str);
    }

    public static File getProperFile(Context context, String str, String str2) {
        if (TVKIOUtil.isExternalStorageMounted()) {
            return getExternalFile(context, str, str2);
        }
        return getInternalFile(context, str, str2);
    }

    public static void clearExternalCache(Context context, String str) {
        TVKIOUtil.recursiveDelete(getExternalCacheDirectory(context, str));
    }

    public static void clearInternalCache(Context context, String str) {
        TVKIOUtil.recursiveDelete(getInternalCacheDirectory(context, str));
    }

    public static File getExternalCacheDirectory(Context context, String str) {
        File externalCacheDirectory = getExternalCacheDirectory(context);
        if (externalCacheDirectory == null) {
            return null;
        }
        return new File(externalCacheDirectory.getAbsolutePath() + File.separator + str);
    }

    public static File getExternalDirectory(Context context, String str) {
        File externalDirectory = getExternalDirectory(context);
        if (externalDirectory == null) {
            return null;
        }
        return new File(externalDirectory.getAbsolutePath() + File.separator + str);
    }

    public static File getInternalCacheDirectory(Context context, String str) {
        File internalCacheDirectory = getInternalCacheDirectory(context);
        if (internalCacheDirectory == null) {
            return null;
        }
        return new File(internalCacheDirectory.getAbsolutePath() + File.separator + str);
    }

    public static File getInternalDirectory(Context context, String str) {
        File internalDirectory = getInternalDirectory(context);
        if (internalDirectory == null) {
            return null;
        }
        return new File(internalDirectory.getAbsolutePath() + File.separator + str);
    }

    public static void clearCache(Context context, String str) {
        clearInternalCache(context, str);
        clearExternalCache(context, str);
    }
}
