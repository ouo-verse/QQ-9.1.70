package com.tencent.thumbplayer.libloader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.common.ITPModuleLoader;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;

/* loaded from: classes26.dex */
public class TPLibraryLoader {
    private static final String ARCH_SUFFIX_ARM64_V8A = "-arm64-v8a";
    private static final String ARCH_SUFFIX_ARMEABI = "-armeabi";
    private static final String ARCH_SUFFIX_ARMEABI_V7A = "-armeabi-v7a";
    private static final String ARCH_SUFFIX_MIPS = "-mips";
    private static final String ARCH_SUFFIX_X86 = "-x86";
    private static final boolean ENABLE_THIRD_PARTIES_AND_FFMPEG_SEPARATE = false;
    private static final boolean IS_LIB_NAME_HAS_ARCH_SUFFIX = false;
    private static final String LIB_FFMPEG_PREFIX = "TPFFmpeg-master";
    private static final String LIB_PLAYER_CORE_PREFIX = "TPCore-master";
    private static final String LIB_THIRD_PARTIES_PREFIX = "TPThirdParties-master";
    private static final int MAIN_VERSION_SECTION_NUM = 3;
    private static final int PLAYER_CORE_SUPPORT_MIN_ANDROID_API_LEVEL = 14;
    private static final String TAG = "TPLibraryLoader";
    private static final String VERSION_DELIMITER = "\\.";
    private static volatile boolean sIsAllLibrariesSuccessfullyLoaded = false;
    private static ITPModuleLoader sModuleLoader;

    private static boolean doLoadAllLibraries(@Nullable Context context) {
        TPLogUtil.i(TAG, "loadLibrary cpu arch:" + TPSystemInfo.getCpuArchitecture());
        if (TPSystemInfo.getApiLevel() < 14) {
            TPLogUtil.w(TAG, "so load failed, current api level " + TPSystemInfo.getApiLevel() + " is less than 14");
            return false;
        }
        if (TPSystemInfo.getCpuArchitecture() != 3 && TPSystemInfo.getCpuArchitecture() != 4 && TPSystemInfo.getCpuArchitecture() != 0) {
            String archSuffix = getArchSuffix();
            if (!loadThirdPartiesAndFFMpegIfNeed(context, archSuffix)) {
                TPLogUtil.i(TAG, "Failed to load third parties and FFmpeg libs");
                return false;
            }
            if (!loadPlayerCore(context, archSuffix)) {
                TPLogUtil.e(TAG, "Failed to load player core libs");
                return false;
            }
            TPLogUtil.i(TAG, "Load all libs successfully");
            return true;
        }
        TPLogUtil.w(TAG, "Player core does not support armv5 and armv6 or can not recognize cpu architecture");
        return false;
    }

    @NonNull
    private static String getArchSuffix() {
        return "";
    }

    public static boolean isAllLibrariesSuccessfullyLoaded() {
        return sIsAllLibrariesSuccessfullyLoaded;
    }

    private static boolean isMatchJavaAndPlayerCore(String str, String str2) {
        TPLogUtil.i(TAG, "javaVersion:" + str + ", coreVersion:" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split(VERSION_DELIMITER);
            String[] split2 = str2.split(VERSION_DELIMITER);
            if (split.length >= 3 && split2.length >= 3) {
                for (int i3 = 0; i3 < 3; i3++) {
                    if (!split[i3].matches(split2[i3])) {
                        return false;
                    }
                }
                return true;
            }
            TPLogUtil.w(TAG, "javaVersion or coreVersion section num is wrong");
            return false;
        }
        TPLogUtil.w(TAG, "javaVersion or coreVersion is empty");
        return false;
    }

    public static synchronized boolean loadAllLibraries(@NonNull Context context) {
        synchronized (TPLibraryLoader.class) {
            if (sIsAllLibrariesSuccessfullyLoaded) {
                TPLogUtil.i(TAG, "TPLibraryLoader has load all libraries successfully");
                return true;
            }
            synchronized (TPLibraryLoader.class) {
                if (sIsAllLibrariesSuccessfullyLoaded) {
                    TPLogUtil.i(TAG, "TPLibraryLoader has load all libraries successfully");
                    return true;
                }
                sIsAllLibrariesSuccessfullyLoaded = doLoadAllLibraries(context);
                if (sIsAllLibrariesSuccessfullyLoaded) {
                    TPLogUtil.i(TAG, "TPLibraryLoader load all libraries successfully");
                } else {
                    TPLogUtil.e(TAG, "TPLibraryLoader load all libraries failed");
                }
                return sIsAllLibrariesSuccessfullyLoaded;
            }
        }
    }

    private static boolean loadLibrary(Context context, String str) {
        if (sModuleLoader != null) {
            TPLogUtil.i(TAG, "Load the library using module loader");
            try {
                sModuleLoader.loadLibrary(str);
                return true;
            } catch (Throwable th5) {
                TPLogUtil.e(TAG, "Failed to load " + str + ", exception: " + th5.getMessage());
                return false;
            }
        }
        TPLogUtil.i(TAG, "Load the library by default load method");
        if (loadLibraryByDefaultLoadMethod(str, context)) {
            return true;
        }
        TPLogUtil.e(TAG, "Failed to load " + str);
        return false;
    }

    private static boolean loadLibraryByDefaultLoadMethod(String str, Context context) {
        try {
            TPLogUtil.i(TAG, "System loadLibrary  loading " + str);
            System.loadLibrary(str);
            TPLogUtil.i(TAG, "System loadLibrary " + str + " loaded successfully");
            return true;
        } catch (Throwable th5) {
            TPLogUtil.e(TAG, "System loadLibrary failed to load " + str + "," + th5.getMessage());
            if (context != null && TPSystemInfo.getCpuArchitecture() >= 6) {
                TPLogUtil.i(TAG, "try to load " + str + " from APK");
                if (!TPFromApkLibraryLoader.loadLibrary(context, str)) {
                    TPLogUtil.e(TAG, "failed to load " + str + " from APK");
                    return false;
                }
                TPLogUtil.i(TAG, "load " + str + " from APK successfully");
                return true;
            }
            TPLogUtil.w(TAG, "context is null or cpu architecture:" + TPSystemInfo.getCpuArchitecture() + " is less than armv7 neno, not use load library from apk");
            return false;
        }
    }

    private static boolean loadPlayerCore(@Nullable Context context, String str) {
        String str2 = "TPCore-master" + str;
        if (!loadLibrary(context, str2)) {
            TPLogUtil.e(TAG, "Failed to load " + str2);
            return false;
        }
        String selfDevPlayerVersion = TPVersion.getSelfDevPlayerVersion();
        if (!isMatchJavaAndPlayerCore(TPVersion.getVersion(), selfDevPlayerVersion)) {
            TPLogUtil.e(TAG, "nativePlayerCoreVer(" + selfDevPlayerVersion + ") doesn't match javaPlayerCoreVer:(" + TPVersion.getVersion() + ")");
            return false;
        }
        return true;
    }

    private static boolean loadThirdPartiesAndFFMpegIfNeed(Context context, String str) {
        TPLogUtil.i(TAG, "Not need load third parties and ffmpeg");
        return true;
    }

    public static void setModuleLoader(ITPModuleLoader iTPModuleLoader) {
        sModuleLoader = iTPModuleLoader;
    }
}
