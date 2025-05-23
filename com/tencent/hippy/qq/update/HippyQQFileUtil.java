package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQFileUtil {
    private static final String DIFF_DOWNLOAD_FILE_NAME = "diff.zip";
    public static final String HIPPY_BUNDLE_ROOT_DIR = "bundle";
    public static final String HIPPY_BUSINESS_DATA_DIR = "business_data";
    public static final String HIPPY_CODE_CACHE_DIR = "codecache";
    public static final String HIPPY_JS_BUNDLE_DOWNLOAD_ROOT_DIR = "pkg";
    private static final String HIPPY_ROOT_DIR = "hippy";
    private static final String HIPPY_SSR_COMMON_DIR = "common";
    private static final String HIPPY_SSR_DIR = "ssr";
    public static final String HIPPY_TAB_CONFIG_CACHE_DIR = "tabconfig";
    private static final String JS_BUNDLE_DOWNLOAD_FILE_NAME = "jsbundle.zip";
    private static final String TAG = "HippyQQFileUtil";
    private static final String UNZIP_TEMP_PATH_START = "_tmp_";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface DownLoadCallBack {
        void onDownloadResult(int i3, File file);
    }

    public static void cleanHistoryPkg(String str, int i3) {
        File[] listFiles;
        File moduleDownloadRootDir = getModuleDownloadRootDir(str);
        if (!moduleDownloadRootDir.exists() || (listFiles = moduleDownloadRootDir.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file != null && file.isDirectory() && file.getName() != null) {
                try {
                    if (Integer.parseInt(file.getName()) < i3) {
                        FileUtils.deleteDirectory(file.getAbsolutePath());
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 1, "cleanHistoryPkg deleteDirectory:" + file.getName());
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "cleanHistoryPkg failed " + th5);
                }
            }
        }
    }

    public static void cleanHistoryVersion(String str, int i3) {
        String name;
        String[] split;
        try {
            File[] listFiles = getModuleFile(str).listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (file != null && file.isDirectory() && file.getName() != null && (split = (name = file.getName()).split("_")) != null && split.length > 0 && Integer.parseInt(split[0]) < i3) {
                    FileUtils.deleteDirectory(file.getAbsolutePath());
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "cleanHistoryVersion deleteDirectory:" + name);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "cleanHistoryVersion failed " + th5);
        }
    }

    public static void clearJsBundles() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(getHippyFile(), "bundle"));
        arrayList.add(new File(getHippyFile(), HIPPY_BUSINESS_DATA_DIR));
        arrayList.add(new File(getHippyFile(), HIPPY_CODE_CACHE_DIR));
        arrayList.add(new File(getHippyFile(), "pkg"));
        arrayList.add(new File(getHippyFile(), HIPPY_TAB_CONFIG_CACHE_DIR));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.exists()) {
                FileUtils.deleteFilesInDirectory(file.getAbsolutePath());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0069 -> B:18:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void downLoad(String str, File file, DownLoadCallBack downLoadCallBack) {
        FileOutputStream fileOutputStream;
        Exception e16;
        InputStream inputStream;
        InputStream inputStream2 = null;
        int i3 = 0;
        try {
            try {
                HttpURLConnection openConnection = HippyUtils.openConnection(new URL(str));
                openConnection.setDoInput(true);
                inputStream = openConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e17) {
                    fileOutputStream = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (Exception e18) {
                fileOutputStream = null;
                e16 = e18;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                if (downLoadCallBack != null) {
                }
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                inputStream.close();
                fileOutputStream.close();
                if (downLoadCallBack != null) {
                    downLoadCallBack.onDownloadResult(0, file);
                }
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                fileOutputStream.close();
            } catch (Exception e26) {
                e16 = e26;
                try {
                    e16.printStackTrace();
                    if (downLoadCallBack != null) {
                        downLoadCallBack.onDownloadResult(-1, file);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th7) {
                    i3 = -1;
                    th = th7;
                    inputStream2 = inputStream;
                    if (downLoadCallBack != null) {
                        downLoadCallBack.onDownloadResult(i3, file);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                inputStream2 = inputStream;
                if (downLoadCallBack != null) {
                }
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (IOException e36) {
            e36.printStackTrace();
        }
    }

    public static File getBusinessDataDir(String str) {
        return new File(new File(getHippyRootDir(), HIPPY_BUSINESS_DATA_DIR), str);
    }

    @Deprecated
    public static File getDiffFile(String str, int i3) {
        File file;
        synchronized (HippyQQFileUtil.class) {
            file = new File(getHippyFileByType("dif"), str + i3 + ".dif");
        }
        return file;
    }

    public static File getDiffPkgFile(String str, int i3) {
        return new File(new File(getModuleDownloadRootDir(str), String.valueOf(i3)), DIFF_DOWNLOAD_FILE_NAME);
    }

    public static File getHippyFile() {
        String str = MobileQQ.QQ_PACKAGE_NAME;
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            File file = new File(context.getFilesDir(), "hippy");
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
        return null;
    }

    public static File getHippyFileByType(String str) {
        File hippyFile = getHippyFile();
        if (hippyFile == null) {
            return null;
        }
        File file = new File(hippyFile, str);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getHippyRootDir() {
        return new File(BaseApplication.getContext().getFilesDir(), "hippy");
    }

    public static File getJsBundleZipFile(String str, int i3) {
        return new File(new File(getModuleDownloadRootDir(str), String.valueOf(i3)), JS_BUNDLE_DOWNLOAD_FILE_NAME);
    }

    public static File getModuleDownloadRootDir(String str) {
        return new File(new File(getHippyRootDir(), "pkg"), str);
    }

    public static File getModuleFile(String str, int i3) {
        synchronized (HippyQQFileUtil.class) {
            File moduleFile = getModuleFile(str);
            if (i3 < 0) {
                return moduleFile;
            }
            File file = new File(moduleFile, i3 + "");
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
    }

    public static File getModuleIndex(String str, int i3) {
        return new File(getModuleFile(str, i3), HippyQQConstants.MAIN_BUNDLE_NAME);
    }

    public static File getSSRCommonDir() {
        return new File(new File(getHippyRootDir(), "ssr"), "common");
    }

    public static File getTabConfigDir() {
        return new File(getHippyFile(), HIPPY_TAB_CONFIG_CACHE_DIR);
    }

    @Deprecated
    public static File getZipFile(String str, int i3) {
        File file;
        synchronized (HippyQQFileUtil.class) {
            file = new File(getHippyFileByType("zip"), str + i3 + ".zip");
        }
        return file;
    }

    public static boolean unzipModulePackage(File file, String str, int i3) {
        String absolutePath;
        String str2;
        try {
            absolutePath = getModuleFile(str).getAbsolutePath();
            str2 = absolutePath + File.separator + (i3 + UNZIP_TEMP_PATH_START + System.currentTimeMillis());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "unzipModulePackage failed " + th5);
        }
        if (!cooperation.qzone.util.FileUtils.unzip(file, new File(str2))) {
            QLog.e(TAG, 1, "unzipModulePackage unzip failure:" + str + " version:" + i3);
            return false;
        }
        File file2 = new File(str2, HippyQQConstants.MAIN_BUNDLE_NAME);
        if (file2.exists() && file2.length() > 0) {
            File file3 = new File(absolutePath, String.valueOf(i3));
            if (file3.exists()) {
                FileUtils.deleteDirectory(file3.getAbsolutePath());
            }
            if (new File(str2).renameTo(file3)) {
                return UpdateSetting.getInstance().isModuleVersionFileExists(str, i3);
            }
            QLog.e(TAG, 1, "unzipModulePackage renameTo failure");
            return false;
        }
        QLog.e(TAG, 1, "unzipModulePackage main bundle no exists");
        return false;
    }

    public static File getModuleFile(String str) {
        synchronized (HippyQQFileUtil.class) {
            File hippyFileByType = getHippyFileByType("bundle");
            if (hippyFileByType == null) {
                return null;
            }
            File file = new File(hippyFileByType, str);
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
    }
}
