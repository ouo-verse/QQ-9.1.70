package com.xingin.xhssharesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.content.FileProvider;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;
import org.jf.dexlib2.analysis.RegisterType;
import yz4.a;
import yz4.b;
import yz4.c;
import yz4.d;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsShareSdkTools {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    private static final String TAG = "XhsShare_XhsShareSdkTools";
    private static String guid;

    public static String byteToString(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int length = bArr.length;
            char[] cArr = new char[length * 2];
            for (int i3 = 0; i3 < length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = HEX_DIGITS;
                cArr[i16] = cArr2[(b16 >>> 4) & 15];
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085 A[LOOP:0: B:8:0x0030->B:22:0x0085, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int compare(String str, String str2) {
        String[] strArr;
        String[] strArr2;
        int parseInt;
        int parseInt2;
        String trim = str.trim();
        if (trim.contains(".")) {
            strArr = trim.split("\\.");
        } else {
            strArr = new String[]{trim};
        }
        String trim2 = str2.trim();
        if (trim2.contains(".")) {
            strArr2 = trim2.split("\\.");
        } else {
            strArr2 = new String[]{trim2};
        }
        int i3 = 0;
        while (true) {
            if (strArr.length <= i3 && strArr2.length <= i3) {
                return 0;
            }
            if (strArr.length > i3) {
                try {
                    parseInt = Integer.parseInt(strArr[i3]);
                } catch (Exception e16) {
                    XhsShareSdk.d(TAG, "Compare version error! version1 is " + str + "version2 is " + str2, e16);
                }
                if (strArr2.length > i3) {
                    try {
                        parseInt2 = Integer.parseInt(strArr2[i3]);
                    } catch (Exception e17) {
                        XhsShareSdk.d(TAG, "Compare version error! version1 is " + str + "version2 is " + str2, e17);
                    }
                    if (parseInt == parseInt2) {
                        i3++;
                    } else {
                        if (parseInt > parseInt2) {
                            return 1;
                        }
                        return -1;
                    }
                }
                parseInt2 = 0;
                if (parseInt == parseInt2) {
                }
            }
            parseInt = 0;
            if (strArr2.length > i3) {
            }
            parseInt2 = 0;
            if (parseInt == parseInt2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        if (r1 == false) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [yz4.b] */
    /* JADX WARN: Type inference failed for: r0v3, types: [yz4.d] */
    /* JADX WARN: Type inference failed for: r0v4, types: [yz4.a] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri convertAvailableUri(@NonNull Context context, @NonNull String str, @NonNull File file) {
        Uri a16;
        boolean z16;
        if (c.f451652a == null) {
            ?? bVar = new b();
            boolean z17 = true;
            try {
                int i3 = FileProvider.f26474d;
                z16 = true;
            } catch (ClassNotFoundException e16) {
                XhsShareSdk.d("XhsShare_AndroidXFileProvider", "androidx.core.content.FileProvider find error.", e16);
                z16 = false;
            }
            if (!z16) {
                bVar = new a();
                try {
                    int i16 = android.support.v4.content.FileProvider.f26397d;
                    bVar.f451651a = android.support.v4.content.FileProvider.class.getMethod("getUriForFile", Context.class, String.class, File.class);
                } catch (ClassNotFoundException | NoSuchMethodException e17) {
                    XhsShareSdk.d("XhsShare_AndroidSupportFileProvider", "android.support.v4.content.FileProvider find error.", e17);
                    z17 = false;
                }
            }
            c.f451652a = bVar;
        }
        d dVar = c.f451652a;
        if (dVar == null) {
            a16 = null;
        } else {
            a16 = dVar.a(context, str, file);
        }
        grantUriPermission(context, a16);
        return a16;
    }

    @WorkerThread
    public static void copyFile(Context context, Uri uri, File file) {
        if (isUriExist(context, uri)) {
            try {
                ensureFileAvailable(file);
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        if (openInputStream != null) {
                            byte[] bArr = new byte[1000];
                            while (openInputStream.read(bArr, 0, 1000) >= 0) {
                                fileOutputStream.write(bArr, 0, 1000);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new InterruptedException("[copyFile] The thread be Interrupted!!");
                                }
                            }
                            fileOutputStream.close();
                            openInputStream.close();
                            return;
                        }
                        throw new com.xingin.xhssharesdk.l.a(3, "The inputStream from src is null!!!");
                    } finally {
                    }
                } catch (Throwable th5) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            } catch (com.xingin.xhssharesdk.l.a e16) {
                throw new com.xingin.xhssharesdk.l.a(e16.f389999a, "In function [createNewFile]: " + e16.getMessage());
            }
        }
        throw new com.xingin.xhssharesdk.l.a(1, "Src uri not exist! uri is " + uri);
    }

    public static File createTempFile(String str) {
        return new File(str, "temp_" + System.currentTimeMillis());
    }

    public static void deleteFile(File file, boolean z16) {
        if (file == null || Thread.currentThread().isInterrupted()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                deleteFile(file2, true);
            }
            if (!z16) {
                return;
            }
        } else if (!file.exists()) {
            return;
        }
        file.delete();
    }

    public static boolean ensureFileAvailable(File file) {
        if (file != null) {
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    throw new com.xingin.xhssharesdk.l.a(2, "The file's parent dir mkdirs failed!");
                }
                return file.createNewFile();
            }
            throw new com.xingin.xhssharesdk.l.a(2, "The file's parent dir can not be null!");
        }
        throw new com.xingin.xhssharesdk.l.a(2, "The file can not be null!");
    }

    public static String generateSessionId(@NonNull XhsNote xhsNote) {
        return Base64.encodeToString((xhsNote.hashCode() + "_" + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8), 2);
    }

    @NonNull
    public static String getAppVersionName(@Nullable Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo == null) {
            return "";
        }
        return packageInfo.versionName;
    }

    @NonNull
    public static String getCurrentAppPackageName(@Nullable Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageName();
    }

    public static int getCurrentAppVersionCode(@Nullable Context context) {
        PackageInfo packageInfo = getPackageInfo(context, getCurrentAppPackageName(context));
        if (packageInfo == null) {
            return -1;
        }
        return packageInfo.versionCode;
    }

    public static String getCurrentAppVersionName(@Nullable Context context) {
        return getAppVersionName(context, getCurrentAppPackageName(context));
    }

    public static String getDefaultCacheDirPath(@NonNull Context context) {
        return new File(context.getExternalCacheDir(), "xhs_share_cache_dir").getAbsolutePath();
    }

    public static String getDid(@Nullable Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(guid)) {
            return guid;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("XHS_SHARE_SDK_SP", 0);
        String string = sharedPreferences.getString("XHS_SHARE_SDK_SP_KEY_GUID", "");
        guid = string;
        if (TextUtils.isEmpty(string)) {
            guid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("XHS_SHARE_SDK_SP_KEY_GUID", guid).apply();
        }
        return guid;
    }

    public static Pair<Integer, Integer> getErrorCodeFromXhsShareResult(a05.b bVar) {
        int i3;
        int i16;
        int i17 = bVar.f25323b;
        if (i17 != 2) {
            if (i17 != 3) {
                if (i17 != 4) {
                    if (i17 != 5) {
                        i3 = -10000001;
                        if (i17 != 6) {
                            i16 = XhsShareConstants$XhsShareNoteNewErrorCode.UNKNOWN;
                        } else {
                            i16 = XhsShareConstants$XhsShareNoteNewErrorCode.DATA_PARSE_ERROR;
                        }
                    } else {
                        i3 = XhsShareConstants$XhsShareNoteErrorCode.POST_CANCEL;
                        i16 = XhsShareConstants$XhsShareNoteNewErrorCode.POST_CANCEL_IN_XHS;
                    }
                } else {
                    i3 = XhsShareConstants$XhsShareNoteErrorCode.CAN_NOT_POST;
                    i16 = XhsShareConstants$XhsShareNoteNewErrorCode.CAN_NOT_POST_IN_XHS;
                }
            } else {
                i3 = XhsShareConstants$XhsShareNoteErrorCode.SHARE_TYPE_ERROR;
                i16 = XhsShareConstants$XhsShareNoteNewErrorCode.SHARE_TYPE_ERROR_IN_XHS;
            }
        } else {
            i3 = XhsShareConstants$XhsShareNoteErrorCode.INTERRUPTED_BY_NEW_SHARE;
            i16 = XhsShareConstants$XhsShareNoteNewErrorCode.INTERRUPTED_BY_NEW_SHARE_IN_XHS;
        }
        return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    public static long getFileLength(@NonNull Context context, @NonNull Uri uri) {
        if (TextUtils.equals(uri.getScheme(), "file")) {
            return new File(uri.getPath()).length();
        }
        long j3 = -1;
        if (TextUtils.equals(uri.getScheme(), "content")) {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j3 = query.getLong(query.getColumnIndex("_size"));
                    }
                } catch (Throwable th5) {
                    try {
                        query.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return j3;
    }

    @Nullable
    private static PackageInfo getPackageInfo(@Nullable Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return InstalledAppListMonitor.getPackageInfo(context.getApplicationContext().getPackageManager(), str, 0);
        }
        return null;
    }

    public static String getSdkVersion() {
        return "1.1.6";
    }

    public static String getXhsPackageName() {
        return "com.xingin.xhs";
    }

    public static void grantUriPermission(@NonNull Context context, @Nullable Uri uri) {
        if (uri == null) {
            return;
        }
        context.grantUriPermission(getXhsPackageName(), uri, 1);
    }

    public static boolean isNetworkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        return true;
    }

    @NonNull
    public static VersionCheckResult isSupportShareNote(Context context) {
        try {
            String appVersionName = getAppVersionName(context, getXhsPackageName());
            if (!TextUtils.isEmpty(XhsSdkInject.getShareNoteMinXhsVersionName()) && compare(appVersionName, XhsSdkInject.getShareNoteMinXhsVersionName()) < 0) {
                return new VersionCheckResult(-2, "Xhs version is " + appVersionName + ", low than " + XhsSdkInject.getShareNoteMinXhsVersionName() + "!", null);
            }
            if (!TextUtils.isEmpty(XhsSdkInject.getShareNoteMaxXhsVersionName()) && compare(appVersionName, XhsSdkInject.getShareNoteMaxXhsVersionName()) > 0) {
                return new VersionCheckResult(-2, "Xhs version is " + appVersionName + ", large than " + XhsSdkInject.getShareNoteMaxXhsVersionName() + "!", null);
            }
            return new VersionCheckResult(0, "", null);
        } catch (PackageManager.NameNotFoundException e16) {
            XhsShareSdk.d(TAG, "Get Xhs PackageInfo error!", e16);
            return new VersionCheckResult(-1, "Xhs not install!", e16);
        }
    }

    public static boolean isUriExist(Context context, @Nullable Uri uri) {
        boolean z16 = false;
        if (uri == null) {
            return false;
        }
        if (TextUtils.equals(uri.getScheme(), "file")) {
            return new File(uri.getPath()).exists();
        }
        Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    z16 = true;
                }
            } catch (Throwable th5) {
                try {
                    query.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
        if (query != null) {
            query.close();
        }
        return z16;
    }

    public static boolean isXhsInstalled(Context context) {
        try {
            getAppVersionName(context, getXhsPackageName());
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            XhsShareSdk.d(TAG, "Get Xhs PackageInfo error!", e16);
            return false;
        }
    }

    public static String md5(String str) {
        return md5(str.getBytes(StandardCharsets.UTF_8));
    }

    @WorkerThread
    public static boolean saveBitmapToFile(Bitmap bitmap, File file) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (file != null && file.exists() && file.isFile() && file.canWrite()) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    bufferedOutputStream.close();
                    return compress;
                } catch (Throwable th5) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
            throw new com.xingin.xhssharesdk.l.a(-1, "The dstFile is unavailable!");
        }
        throw new com.xingin.xhssharesdk.l.a(-1, "Bitmap is null or has be recycled!");
    }

    public static String md5(byte[] bArr) {
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        messageDigest.update(bArr);
        return byteToString(messageDigest.digest()).toLowerCase();
    }
}
