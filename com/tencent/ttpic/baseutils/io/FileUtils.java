package com.tencent.ttpic.baseutils.io;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileUtils {
    public static final String MD5_SALT = "aekit";
    public static final String PIC_POSTFIX_JPEG = ".jpg";
    public static final String PIC_POSTFIX_MP4 = ".mp4";
    public static final String PIC_POSTFIX_PNG = ".png";
    public static final String PIC_POSTFIX_WEBP = ".webp";
    public static final String RES_POSTFIX_ENCRYPTED_GLB = ".dat";
    public static final String RES_POSTFIX_ENCRYPTED_GLTF = ".datf";
    public static final String RES_POSTFIX_GLB = ".glb";
    public static final String RES_POSTFIX_GLTF = ".gltf";
    public static final String RES_PREFIX_ASSETS = "assets://";
    public static final String RES_PREFIX_HTTP = "http://";
    public static final String RES_PREFIX_HTTPS = "https://";
    public static final String RES_PREFIX_STORAGE = "/";
    public static final AssetFileComparator SIMPLE_ASSET_COMPARATOR = new AssetFileComparator() { // from class: com.tencent.ttpic.baseutils.io.FileUtils.2
        @Override // com.tencent.ttpic.baseutils.io.FileUtils.AssetFileComparator
        public boolean equals(Context context, String str, File file) {
            long assetLength = FileUtils.getAssetLength(context, str);
            if (assetLength != -1 && assetLength == file.length()) {
                return true;
            }
            return false;
        }
    };
    public static final AssetFileComparator SIMPLE_ASSET_MD5_COMPARATOR = new AssetFileComparator() { // from class: com.tencent.ttpic.baseutils.io.FileUtils.3
        @Override // com.tencent.ttpic.baseutils.io.FileUtils.AssetFileComparator
        public boolean equals(Context context, String str, File file) {
            String assetsMD5 = FileUtils.getAssetsMD5(context, str, "aekit");
            String md5 = FileUtils.getMD5(file.getAbsolutePath(), "aekit");
            if (!TextUtils.isEmpty(assetsMD5) && !TextUtils.isEmpty(md5)) {
                return assetsMD5.equals(md5);
            }
            return false;
        }
    };
    public static final FileComparator SIMPLE_FILE_COMPARATOR = new FileComparator() { // from class: com.tencent.ttpic.baseutils.io.FileUtils.4
        @Override // com.tencent.ttpic.baseutils.io.FileUtils.FileComparator
        public boolean equals(String str, File file) {
            long fileLength = FileUtils.getFileLength(str);
            if (fileLength != -1 && fileLength == file.length()) {
                return true;
            }
            return false;
        }
    };
    private static final String TAG = "FileUtils";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface AssetFileComparator {
        boolean equals(Context context, String str, File file);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface FileComparator {
        boolean equals(String str, File file);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class FileCopyTask extends AsyncTask<String, String, Boolean> {
        String mDestPath;
        OnFileCopyListener mListener;
        InputStream mSrcInputStream;

        FileCopyTask(InputStream inputStream, String str) {
            this.mSrcInputStream = inputStream;
            this.mDestPath = str;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            OnFileCopyListener onFileCopyListener = this.mListener;
            if (onFileCopyListener != null) {
                onFileCopyListener.onCopyStart();
            }
        }

        public void setOnFileCopyListener(OnFileCopyListener onFileCopyListener) {
            this.mListener = onFileCopyListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(FileUtils.copyFile(this.mSrcInputStream, this.mDestPath));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((FileCopyTask) bool);
            if (this.mListener != null) {
                if (bool.booleanValue()) {
                    this.mListener.onCopySuccess();
                } else {
                    this.mListener.onCopyFailed();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnFileCopyListener {
        void onCopyFailed();

        void onCopyStart();

        void onCopySuccess();
    }

    public static void CopyAssetsMaterialToExternalStorage(Context context, String str) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(context.getExternalFilesDir(null).getAbsolutePath() + File.separator + str).mkdirs();
                int length = list.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str2 = list[i3];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    String str3 = File.separator;
                    sb5.append(str3);
                    sb5.append(str2);
                    String sb6 = sb5.toString();
                    CopyAssetsMaterialToExternalStorage(context, sb6);
                    str = sb6.substring(0, sb6.lastIndexOf(str3));
                }
                return;
            }
            copyAssets(context, str, context.getExternalFilesDir(null).getAbsolutePath() + File.separator + str);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean assetAndPathExist(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("assets")) {
            AssetManager assets = context.getAssets();
            try {
                String substring = str.substring(str.lastIndexOf("/") + 1);
                String[] list = assets.list(str.substring(0, str.lastIndexOf("/")).replace("assets://", ""));
                if (list != null) {
                    for (String str2 : list) {
                        if (TextUtils.equals(str2.substring(str2.lastIndexOf("/") + 1), substring)) {
                            return true;
                        }
                    }
                }
            } catch (IOException unused) {
            }
            return false;
        }
        return new File(str).exists();
    }

    public static void asyncCopyFile(InputStream inputStream, String str, OnFileCopyListener onFileCopyListener) {
        FileCopyTask fileCopyTask = new FileCopyTask(inputStream, str);
        fileCopyTask.setOnFileCopyListener(onFileCopyListener);
        fileCopyTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
    }

    public static boolean canWriteFile(String str, boolean z16) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ((z16 || str.endsWith(File.separator)) && (lastIndexOf = str.lastIndexOf(File.separator)) > -1) {
            str = str.substring(0, lastIndexOf);
        }
        File file = new File(str + File.separator + "test_temp.txt");
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            file.delete();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static String checkAssetsPhoto(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AssetManager assets = context.getAssets();
        try {
            IOUtils.closeQuietly(assets.open(str));
            return str;
        } catch (IOException unused) {
            IOUtils.closeQuietly((InputStream) null);
            if (str.lastIndexOf(".") != -1) {
                String str2 = str.substring(0, str.lastIndexOf(46) + 1) + "webp";
                try {
                    IOUtils.closeQuietly(assets.open(str2));
                    return str2;
                } catch (IOException unused2) {
                    return null;
                } finally {
                }
            }
            String str3 = str + ".jpg";
            try {
                IOUtils.closeQuietly(assets.open(str3));
                return str3;
            } catch (IOException unused3) {
                IOUtils.closeQuietly((InputStream) null);
                String str4 = str + ".webp";
                try {
                    IOUtils.closeQuietly(assets.open(str4));
                    return str4;
                } catch (IOException unused4) {
                    IOUtils.closeQuietly((InputStream) null);
                    String str5 = str + ".png";
                    try {
                        IOUtils.closeQuietly(assets.open(str5));
                        return str5;
                    } catch (IOException unused5) {
                        return null;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static String checkPhoto(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (new File(str).exists()) {
            return str;
        }
        if (str.substring(str.lastIndexOf("/")).lastIndexOf(".") == -1) {
            String str2 = str + ".jpg";
            if (new File(str2).exists()) {
                return str2;
            }
            String str3 = str + ".png";
            if (new File(str3).exists()) {
                return str3;
            }
        }
        return str;
    }

    public static void clearDir(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                clearDir(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static void clearDirs(File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            clearDir(file);
        }
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean copyAssets(Context context, String str, String str2) {
        return copyAssets(context, str, str2, SIMPLE_ASSET_MD5_COMPARATOR);
    }

    public static void copyAssetsToSDCard(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2 + File.separator + str).mkdirs();
                int length = list.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str3 = list[i3];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    String str4 = File.separator;
                    sb5.append(str4);
                    sb5.append(str3);
                    String sb6 = sb5.toString();
                    copyAssetsToSDCard(context, sb6, str2);
                    str = sb6.substring(0, sb6.lastIndexOf(str4));
                }
                return;
            }
            copyAssets(context, str, str2 + File.separator + str);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(str, str2, SIMPLE_FILE_COMPARATOR);
    }

    public static void copyRawSafe(Context context, int i3, String str) {
        FileOutputStream fileOutputStream;
        Exception e16;
        InputStream openRawResource = context.getResources().openRawResource(i3);
        FileOutputStream fileOutputStream2 = null;
        try {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                try {
                    File file = new File(str);
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        byte[] byteArray = IOUtils.toByteArray(openRawResource);
                        if (file.length() != byteArray.length) {
                            IOUtils.write(byteArray, fileOutputStream);
                            fileOutputStream.flush();
                        }
                        openRawResource.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e17) {
                        e16 = e17;
                        e16.printStackTrace();
                        openRawResource.close();
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    } catch (OutOfMemoryError unused) {
                        fileOutputStream2 = fileOutputStream;
                        try {
                            openRawResource.reset();
                            copyFile(openRawResource, fileOutputStream2);
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        openRawResource.close();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        }
                    }
                } catch (Exception e19) {
                    fileOutputStream = null;
                    e16 = e19;
                } catch (OutOfMemoryError unused2) {
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        } catch (Throwable th6) {
            FileOutputStream fileOutputStream3 = fileOutputStream2;
            th = th6;
            try {
                openRawResource.close();
                if (fileOutputStream3 != null) {
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                }
            } catch (IOException e27) {
                e27.printStackTrace();
            }
            throw th;
        }
    }

    public static File createFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        delete(new File(str));
    }

    public static void deleteAllFilesOfDir(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                deleteAllFilesOfDir(file2);
            }
        }
        file.delete();
    }

    public static void deleteFiles(String str, final String str2) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str) && (listFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.tencent.ttpic.baseutils.io.FileUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str3) {
                if (TextUtils.isEmpty(str2)) {
                    return true;
                }
                return str3.endsWith(str2);
            }
        })) != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.indexOf("assets") < 0 && !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static String genSeperateFileDir(String str) {
        if (str != null) {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                return str + str2;
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getAssetLength(Context context, String str) {
        AssetFileDescriptor assetFileDescriptor;
        AssetManager assets = context.getAssets();
        AssetFileDescriptor assetFileDescriptor2 = null;
        r0 = null;
        InputStream inputStream = null;
        try {
            assetFileDescriptor = assets.openFd(str);
            try {
                long length = assetFileDescriptor.getLength();
                try {
                    assetFileDescriptor.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return length;
            } catch (IOException unused) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                try {
                    inputStream = assets.open(str);
                    long available = inputStream.available();
                    closeSilently(inputStream);
                    return available;
                } catch (IOException unused2) {
                    closeSilently(inputStream);
                    return -1L;
                } catch (Throwable th5) {
                    closeSilently(inputStream);
                    throw th5;
                }
            } catch (Throwable th6) {
                th = th6;
                assetFileDescriptor2 = assetFileDescriptor;
                if (assetFileDescriptor2 != null) {
                    try {
                        assetFileDescriptor2.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
            assetFileDescriptor = null;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAssetsMD5(Context context, String str, String str2) {
        InputStream inputStream;
        int i3;
        String str3;
        InputStream inputStream2 = null;
        if (context == null || TextUtils.isEmpty(str) || str2 == null) {
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
        } catch (Exception e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (inputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                if (inputStream.available() <= 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e17) {
                        LogUtils.e(e17);
                    }
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                messageDigest.update(str2.getBytes());
                StringBuilder sb5 = new StringBuilder();
                for (byte b16 : messageDigest.digest()) {
                    int i16 = b16 & 255;
                    if (i16 < 16) {
                        str3 = "0";
                    } else {
                        str3 = "";
                    }
                    sb5.append(str3);
                    sb5.append(Integer.toHexString(i16).toLowerCase());
                }
                String sb6 = sb5.toString();
                try {
                    inputStream.close();
                } catch (Exception e18) {
                    LogUtils.e(e18);
                }
                return sb6;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e19) {
                        LogUtils.e(e19);
                    }
                }
                throw th;
            }
        } catch (Exception e26) {
            e = e26;
            LogUtils.e(e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e27) {
                    LogUtils.e(e27);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getFileLength(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return -1L;
        }
        return file.length();
    }

    public static String getFileName(String str) {
        String str2;
        String str3 = TAG;
        LogUtils.v(str3, "[getFileName] path = " + str);
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf("/");
            if (lastIndexOf2 >= 0 && lastIndexOf > lastIndexOf2) {
                str2 = str.substring(lastIndexOf2 + 1, lastIndexOf);
                LogUtils.v(str3, "[getFileName] return title = " + str2);
                return str2;
            }
        }
        str2 = null;
        LogUtils.v(str3, "[getFileName] return title = " + str2);
        return str2;
    }

    public static String getFileNameFromUrl(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf("/")) == -1 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String getFileNameWithSuffixByPath(String str) {
        String str2;
        String str3 = TAG;
        LogUtils.v(str3, "[getFileNameWithSuffixByPath] path = " + str);
        if (!TextUtils.isEmpty(str)) {
            str2 = str.substring(str.lastIndexOf("/") + 1);
        } else {
            str2 = null;
        }
        LogUtils.v(str3, "[getFileNameWithSuffixByPath] return title = " + str2);
        return str2;
    }

    public static String getFileSuffixFromUrl(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String getFinalVideoName() {
        return String.format("selfiee_%s.mp4", new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date()));
    }

    public static long getFolderSize(File file) {
        long length;
        long j3 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    length = getFolderSize(listFiles[i3]);
                } else {
                    length = listFiles[i3].length();
                }
                j3 += length;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return j3;
    }

    public static String getMD5(String str, String str2) {
        int i3;
        String str3;
        if (new File(str).exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                messageDigest.update(str2.getBytes());
                fileInputStream.close();
                StringBuilder sb5 = new StringBuilder();
                for (byte b16 : messageDigest.digest()) {
                    int i16 = b16 & 255;
                    if (i16 < 16) {
                        str3 = "0";
                    } else {
                        str3 = "";
                    }
                    sb5.append(str3);
                    sb5.append(Integer.toHexString(i16).toLowerCase());
                }
                return sb5.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getPostfix(String str) {
        return str.substring(str.lastIndexOf("."));
    }

    public static String getRealDirPath(String str) {
        return getRealPath(str.substring(0, str.lastIndexOf(File.separator)));
    }

    public static String getRealPath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("assets://")) {
            return str.substring(9);
        }
        return str;
    }

    public static String getSHA1(String str) {
        int i3;
        String str2;
        if (new File(str).exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                StringBuilder sb5 = new StringBuilder();
                for (byte b16 : messageDigest.digest()) {
                    int i16 = b16 & 255;
                    if (i16 < 16) {
                        str2 = "0";
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    sb5.append(Integer.toHexString(i16).toLowerCase());
                }
                return sb5.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getWritableDir(String... strArr) {
        for (String str : strArr) {
            if (canWriteFile(str, false)) {
                return str;
            }
        }
        return "";
    }

    public static boolean hasFiles(String str) {
        if (!exists(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.isDirectory()) {
            return true;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isDirectoryWritable(String str) {
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            try {
                return file.canWrite();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static String load(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str.startsWith("assets://")) {
            return loadAssetsString(context, getRealPath(str) + File.separator + str2);
        }
        return loadSdCardFileString(str + File.separator + str2);
    }

    public static byte[] loadAssetsByteArray(Context context, String str) {
        byte[] bArr = null;
        try {
            InputStream open = context.getAssets().open(str);
            bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (Exception e16) {
            LogUtils.e(e16);
            return bArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.InputStream] */
    public static String loadAssetsString(Context context, String str) {
        BufferedReader bufferedReader;
        IOException e16;
        StringBuilder sb5 = new StringBuilder();
        ?? r16 = 0;
        r16 = 0;
        try {
            try {
                context = context.getAssets().open(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader((InputStream) context, "UTF-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                            sb5.append("\n");
                        } catch (IOException e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            IOUtils.closeQuietly(bufferedReader);
                            IOUtils.closeQuietly((InputStream) context);
                            return sb5.toString();
                        }
                    }
                } catch (IOException e18) {
                    e16 = e18;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    IOUtils.closeQuietly((Reader) r16);
                    IOUtils.closeQuietly((InputStream) context);
                    throw th;
                }
            } catch (IOException e19) {
                bufferedReader = null;
                e16 = e19;
                context = 0;
            } catch (Throwable th6) {
                th = th6;
                context = 0;
            }
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly((InputStream) context);
            return sb5.toString();
        } catch (Throwable th7) {
            th = th7;
            r16 = str;
        }
    }

    public static byte[] loadByteArray(Context context, String str) {
        InputStream fileInputStream;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            try {
                if (str.startsWith("assets://")) {
                    fileInputStream = context.getAssets().open(getRealPath(str));
                } else {
                    fileInputStream = new FileInputStream(str);
                }
                inputStream = fileInputStream;
                bArr = loadByteArray(inputStream);
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return bArr;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static String loadRawResourceString(Context context, int i3) {
        InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(i3));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                    sb5.append('\n');
                } else {
                    IOUtils.closeQuietly(inputStreamReader);
                    IOUtils.closeQuietly(bufferedReader);
                    return sb5.toString();
                }
            } catch (IOException unused) {
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(bufferedReader);
                return null;
            } catch (Throwable th5) {
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(bufferedReader);
                throw th5;
            }
        }
    }

    public static String loadSdCardFileString(String str) {
        FileInputStream fileInputStream;
        IOException e16;
        BufferedReader bufferedReader;
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                            sb5.append("\n");
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedReader;
                            IOUtils.closeQuietly(bufferedReader2);
                            IOUtils.closeQuietly(fileInputStream);
                            throw th;
                        }
                    } catch (IOException e17) {
                        e16 = e17;
                        LogUtils.i(TAG, e16.getMessage());
                        IOUtils.closeQuietly(bufferedReader);
                        IOUtils.closeQuietly(fileInputStream);
                        return sb5.toString();
                    }
                }
            } catch (IOException e18) {
                e16 = e18;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                IOUtils.closeQuietly(bufferedReader2);
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (IOException e19) {
            fileInputStream = null;
            e16 = e19;
            bufferedReader = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
        IOUtils.closeQuietly(bufferedReader);
        IOUtils.closeQuietly(fileInputStream);
        return sb5.toString();
    }

    public static String md5ForBase64Data(String str) {
        char[] cArr = {'r', 'D', 'z', 'o', 'i', 'e', '5', 'e', '3', 'o', 'n', 'g', 'f', 'z', '1', 'l'};
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i3 = 0; i3 < 16; i3++) {
            stringBuffer.append(cArr[i3]);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(stringBuffer.toString().getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (byte b16 : digest) {
                stringBuffer2.append(String.format("%02x", Integer.valueOf(b16 & 255)));
            }
            return stringBuffer2.toString();
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static void merge(List<String> list, File file) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            FileInputStream fileInputStream = new FileInputStream(new File(it.next()));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            fileOutputStream.flush();
            fileInputStream.close();
        }
        fileOutputStream.close();
    }

    public static boolean move(File file, String str) {
        return file.renameTo(new File(new File(str), file.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    private static boolean performCopyAssetsFile(Context context, String str, String str2, AssetFileComparator assetFileComparator) {
        Closeable closeable;
        File parentFile;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            AssetManager assets = context.getAssets();
            File file = new File(str2);
            InputStream inputStream = null;
            try {
                if (file.exists()) {
                    if (assetFileComparator != null && assetFileComparator.equals(context, str, file)) {
                        LogUtils.i(TAG, "comparator != null && comparator.equals(context, assetPath, dstFile)");
                        closeSilently(null);
                        closeSilently(null);
                        return true;
                    }
                    if (file.isDirectory()) {
                        delete(file);
                    }
                }
                parentFile = file.getParentFile();
                if (parentFile.isFile()) {
                    delete(parentFile);
                }
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                LogUtils.e(TAG, "!parent.exists() && !parent.mkdirs(), parent dir = " + parentFile.getAbsolutePath());
                closeSilently(null);
                closeSilently(null);
                return false;
            }
            InputStream open = assets.open(str);
            try {
                if (open.available() > 0) {
                    ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = open.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        inputStream = bufferedOutputStream;
                        z16 = true;
                    } catch (Throwable th6) {
                        inputStream = open;
                        th = th6;
                        closeable = bufferedOutputStream;
                        try {
                            LogUtils.e(TAG, String.format("performCopyAssetsFile exception catched, info = %s", th.toString()));
                            delete(file);
                            return z16;
                        } finally {
                            closeSilently(inputStream);
                            closeSilently(closeable);
                        }
                    }
                }
                closeSilently(open);
                closeSilently(inputStream);
            } catch (Throwable th7) {
                inputStream = open;
                th = th7;
                closeable = null;
            }
            return z16;
        }
        LogUtils.e(TAG, "TextUtils.isEmpty(assetPath) || TextUtils.isEmpty(dstPath)");
        return false;
    }

    public static byte[] readBytes(InputStream inputStream, int i3) {
        byte[] bArr = new byte[i3];
        int i16 = 0;
        while (i16 < i3) {
            try {
                int read = inputStream.read(bArr, i16, i3 - i16);
                if (read == -1) {
                    break;
                }
                i16 += read;
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9 A[Catch: IOException -> 0x00a5, TRY_LEAVE, TryCatch #3 {IOException -> 0x00a5, blocks: (B:60:0x00a1, B:53:0x00a9), top: B:59:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v15, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.tencent.ttpic.baseutils.io.ByteArrayPool] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.tencent.ttpic.baseutils.io.ByteArrayPool] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readFile(String str) {
        FileInputStream fileInputStream;
        ?? r46;
        ?? r56;
        int length;
        ?? r16;
        ByteArrayOutputStream byteArrayOutputStream = null;
        r2 = null;
        r2 = null;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                length = (int) file.length();
                r46 = new ByteArrayOutputStream(length);
            } catch (Exception e16) {
                e = e16;
                r46 = 0;
                r56 = 0;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            try {
                r56 = new FileInputStream(file);
                r16 = 4096;
            } catch (Exception e17) {
                e = e17;
                r56 = 0;
            } catch (Throwable th6) {
                th = th6;
                r56 = 0;
                byteArrayOutputStream = r46;
                fileInputStream = r56;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e18) {
                        LogUtils.e(TAG, "readFileContent", e18, new Object[0]);
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            try {
                try {
                    if (length < 4096) {
                        r16 = ByteArrayPool.getGenericInstance().getBuf(4096);
                    } else {
                        r16 = ByteArrayPool.getGenericInstance().getBuf(12288);
                    }
                } catch (OutOfMemoryError unused) {
                    r16 = ByteArrayPool.getGenericInstance().getBuf(r16);
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = r56.read(r16);
                    r46.write(r16, 0, read);
                    i3 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(r16);
                bArr = r46.toByteArray();
                try {
                    r46.close();
                    r56.close();
                } catch (IOException e19) {
                    LogUtils.e(TAG, "readFileContent", e19, new Object[0]);
                }
            } catch (Exception e26) {
                e = e26;
                LogUtils.e(TAG, "readFileContent e:", e, new Object[0]);
                if (r46 != 0) {
                    try {
                        r46.close();
                    } catch (IOException e27) {
                        LogUtils.e(TAG, "readFileContent", e27, new Object[0]);
                    }
                }
                if (r56 != 0) {
                    r56.close();
                }
                return bArr;
            }
            return bArr;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static String readTextFileFromRaw(Context context, int i3) {
        InputStream openRawResource = context.getResources().openRawResource(i3);
        InputStreamReader inputStreamReader = new InputStreamReader(openRawResource);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                    sb5.append('\n');
                } else {
                    IOUtils.closeQuietly(openRawResource);
                    IOUtils.closeQuietly(inputStreamReader);
                    IOUtils.closeQuietly(bufferedReader);
                    return sb5.toString();
                }
            } catch (IOException unused) {
                IOUtils.closeQuietly(openRawResource);
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(bufferedReader);
                return null;
            } catch (Throwable th5) {
                IOUtils.closeQuietly(openRawResource);
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(bufferedReader);
                throw th5;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x00b1 -> B:16:0x00b4). Please report as a decompilation issue!!! */
    public static String readTxtFile(Context context, String str) {
        BufferedReader bufferedReader;
        IOException e16;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        r1 = 0;
        ?? r16 = 0;
        bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            try {
                try {
                    try {
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r16 = str;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            if (str.startsWith("assets://")) {
                try {
                    context = context.getAssets().open(str.substring(9));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(context));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb5.append(readLine);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                    }
                                }
                            } catch (IOException e26) {
                                e16 = e26;
                                e16.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e27) {
                                        e27.printStackTrace();
                                    }
                                }
                                if (context != 0) {
                                    context.close();
                                }
                                return sb5.toString();
                            }
                        }
                        bufferedReader.close();
                    } catch (IOException e28) {
                        e16 = e28;
                        bufferedReader = null;
                    } catch (Throwable th6) {
                        th = th6;
                        if (r16 != 0) {
                            try {
                                r16.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                            }
                        }
                        if (context != 0) {
                            try {
                                context.close();
                                throw th;
                            } catch (IOException e36) {
                                e36.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e37) {
                    bufferedReader = null;
                    e16 = e37;
                    context = 0;
                } catch (Throwable th7) {
                    th = th7;
                    context = 0;
                }
                if (context != 0) {
                    context.close();
                }
                return sb5.toString();
            }
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine2 = bufferedReader3.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb5.append(readLine2);
                    } catch (IOException e38) {
                        e = e38;
                        bufferedReader2 = bufferedReader3;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return sb5.toString();
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedReader2 = bufferedReader3;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e39) {
                                e39.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader3.close();
            } catch (IOException e46) {
                e = e46;
            }
            return sb5.toString();
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static void save(File file, String str) {
        BufferedWriter bufferedWriter;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            } catch (Exception e16) {
                e = e16;
                bufferedWriter = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedWriter = null;
            }
        } catch (Exception e17) {
            e = e17;
            bufferedWriter = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(str);
            IOUtils.closeQuietly(fileOutputStream);
        } catch (Exception e18) {
            e = e18;
            fileOutputStream2 = fileOutputStream;
            try {
                LogUtils.e(e);
                IOUtils.closeQuietly(fileOutputStream2);
                IOUtils.closeQuietly(bufferedWriter);
            } catch (Throwable th7) {
                th = th7;
                IOUtils.closeQuietly(fileOutputStream2);
                IOUtils.closeQuietly(bufferedWriter);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream2 = fileOutputStream;
            IOUtils.closeQuietly(fileOutputStream2);
            IOUtils.closeQuietly(bufferedWriter);
            throw th;
        }
        IOUtils.closeQuietly(bufferedWriter);
    }

    public static void saveFile(String str, String str2) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str));
                try {
                    bufferedWriter2.write(str2);
                    IOUtils.closeQuietly(bufferedWriter2);
                } catch (IOException e16) {
                    e = e16;
                    bufferedWriter = bufferedWriter2;
                    LogUtils.e(e);
                    IOUtils.closeQuietly(bufferedWriter);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.closeQuietly(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    public static String toBase64(String str) {
        String str2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read >= 0) {
                    base64OutputStream.write(bArr, 0, read);
                } else {
                    base64OutputStream.flush();
                    base64OutputStream.close();
                    String str3 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    try {
                        byteArrayOutputStream.close();
                        fileInputStream.close();
                        return str3;
                    } catch (Exception unused) {
                        str2 = str3;
                        return str2;
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static boolean copyAssets(Context context, String str, String str2, AssetFileComparator assetFileComparator) {
        return performCopyAssetsFile(context, str, str2, assetFileComparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    private static boolean copyFile(String str, String str2, FileComparator fileComparator) {
        Closeable closeable;
        File parentFile;
        FileInputStream fileInputStream;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            FileInputStream fileInputStream2 = null;
            try {
                if (file.exists()) {
                    if (fileComparator != null && fileComparator.equals(str, file)) {
                        LogUtils.i(TAG, "comparator != null && comparator.equals(context, assetPath, dstFile)");
                        closeSilently(null);
                        closeSilently(null);
                        return true;
                    }
                    if (file.isDirectory()) {
                        delete(file);
                    }
                }
                parentFile = file.getParentFile();
                if (parentFile.isFile()) {
                    delete(parentFile);
                }
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                LogUtils.e(TAG, "!parent.exists() && !parent.mkdirs(), parent dir = " + parentFile.getAbsolutePath());
                closeSilently(null);
                closeSilently(null);
                return false;
            }
            FileInputStream fileInputStream3 = new FileInputStream(str);
            try {
                if (fileInputStream3.available() > 0) {
                    ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream3.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream2 = bufferedOutputStream;
                        z16 = true;
                    } catch (Throwable th6) {
                        fileInputStream = fileInputStream3;
                        closeable = bufferedOutputStream;
                        th = th6;
                        fileInputStream2 = fileInputStream;
                        try {
                            LogUtils.e(TAG, String.format("performCopyFile exception catched, info = %s", th.toString()));
                            delete(file);
                            return z16;
                        } finally {
                            closeSilently(fileInputStream2);
                            closeSilently(closeable);
                        }
                    }
                }
                closeSilently(fileInputStream3);
                closeSilently(fileInputStream2);
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream3;
                closeable = null;
            }
            return z16;
        }
        LogUtils.e(TAG, "TextUtils.isEmpty(assetPath) || TextUtils.isEmpty(dstPath)");
        return false;
    }

    public static void delete(@Nullable File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    delete(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static String load(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("assets://")) {
            return loadAssetsString(context, getRealPath(str));
        }
        return loadSdCardFileString(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static byte[] loadByteArray(InputStream inputStream) {
        int read;
        byte[] bArr = new byte[0];
        ?? r36 = 0;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    try {
                        read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    } catch (IOException e16) {
                        e = e16;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        e.printStackTrace();
                        IOUtils.closeQuietly(byteArrayOutputStream);
                        r36 = byteArrayOutputStream;
                        return bArr;
                    } catch (Throwable th5) {
                        th = th5;
                        r36 = byteArrayOutputStream2;
                        IOUtils.closeQuietly((OutputStream) r36);
                        throw th;
                    }
                }
                byteArrayOutputStream2.flush();
                bArr = byteArrayOutputStream2.toByteArray();
                IOUtils.closeQuietly(byteArrayOutputStream2);
                r36 = read;
            } catch (IOException e17) {
                e = e17;
            }
            return bArr;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static BitmapUtils.SAVE_STATUS save(String str, byte[] bArr) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    BitmapUtils.SAVE_STATUS save_status = BitmapUtils.SAVE_STATUS.SAVE_SUCCESS;
                    IOUtils.closeQuietly(fileOutputStream2);
                    return save_status;
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    LogUtils.e(e);
                    BitmapUtils.SAVE_STATUS save_status2 = BitmapUtils.SAVE_STATUS.SAVE_FAILED;
                    IOUtils.closeQuietly(fileOutputStream);
                    return save_status2;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void delete(File file, boolean z16) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            delete(file2, z16);
        }
        if (z16) {
            return;
        }
        file.delete();
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return false;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return true;
                }
            }
        } catch (Exception e16) {
            LogUtils.e(e16);
            return true;
        }
    }

    public static boolean copyFile(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream2);
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    public static boolean copyFile(File file, File file2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException unused) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused2) {
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
        } catch (IOException unused3) {
            bufferedInputStream = null;
        } catch (OutOfMemoryError unused4) {
            bufferedInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
            while (true) {
                int read = bufferedInputStream.read(buf);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(buf, 0, read);
                fileOutputStream.flush();
            }
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused6) {
            }
            return true;
        } catch (IOException unused7) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused8) {
                }
            }
            if (bufferedInputStream == null) {
                return false;
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused9) {
                return false;
            }
        } catch (OutOfMemoryError unused10) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused11) {
                }
            }
            if (bufferedInputStream == null) {
                return false;
            }
            bufferedInputStream.close();
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused12) {
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                    throw th;
                } catch (IOException unused13) {
                    throw th;
                }
            }
            throw th;
        }
    }
}
