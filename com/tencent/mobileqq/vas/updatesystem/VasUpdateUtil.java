package com.tencent.mobileqq.vas.updatesystem;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.stream.JsonReader;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasUpdateUtil {
    private static final String TAG = "VasUpdateUtil";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallBacker f311146a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f311147b;

        a(CallBacker callBacker, String str) {
            this.f311146a = callBacker;
            this.f311147b = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            VasUpdateUtil.vasPokeCallback(this.f311146a, updateListenerParams, this.f311147b);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            VasUpdateUtil.vasPokeCallback(this.f311146a, updateListenerParams, this.f311147b);
        }
    }

    public static File getFileFromLocal(AppRuntime appRuntime, long j3, String str, String str2, boolean z16, CallBacker callBacker) {
        if (TextUtils.isEmpty(str2) && appRuntime != null) {
            str2 = appRuntime.getApplication().getFilesDir() + File.separator + str;
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str3)) {
            QLog.e(TAG, 1, "getFileFromLocal err filePath, bid=" + j3 + ",scid:" + str + ", app=" + appRuntime + ", filePaht=" + str3);
            return null;
        }
        File file = new File(str3);
        if (!file.exists()) {
            if (!z16) {
                return null;
            }
            QQVasUpdateBusiness newBusiness = getNewBusiness(j3);
            if (newBusiness != null) {
                newBusiness.addDownLoadListener(str, new a(callBacker, str));
                newBusiness.startDownload(str);
                return null;
            }
            ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(appRuntime, j3, str, str3, callBacker);
            return null;
        }
        return file;
    }

    public static TagItemInfo getItemInfo(long j3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getItemInfo bid = " + j3 + " scid = " + str);
        }
        BaseUpdateCallback callback = UpdateCallbackSelector.getCallback(j3);
        if (callback == null) {
            return null;
        }
        return callback.getItemInfo(j3, str);
    }

    public static JSONObject getJSONFromLocal(AppRuntime appRuntime, String str, boolean z16, CallBacker callBacker) {
        if (appRuntime == null) {
            QLog.e(TAG, 1, "getJSONFromLocal, app == null; scid:" + str + ", app=" + appRuntime);
            return null;
        }
        String str2 = appRuntime.getApplication().getFilesDir() + File.separator + str;
        File file = new File(str2);
        if (file.exists()) {
            try {
                return new JSONObject(FileUtils.readFileContent(file));
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getJsonOOM,json_name:" + str, th5);
                }
                file.delete();
            }
        }
        if (z16) {
            ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(appRuntime, 1000L, str, str2, callBacker);
        }
        return null;
    }

    public static JsonReader getJSONFromLocalByStreamRead(AppRuntime appRuntime, String str, boolean z16, CallBacker callBacker) {
        if (appRuntime == null) {
            QLog.e(TAG, 1, "getJSONFromLocalByStreamRead, app == null; scid:" + str + ", app=" + appRuntime);
            return null;
        }
        String str2 = appRuntime.getApplication().getFilesDir() + File.separator + str;
        File file = new File(str2);
        if (file.exists()) {
            try {
                return new JsonReader(new FileReader(file));
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getJSONFromLocalByStreamRead error,json_name:" + str, th5);
                }
                file.delete();
            }
        }
        if (z16) {
            ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).downloadItem(appRuntime, 1000L, str, str2, callBacker);
        }
        return null;
    }

    public static QQVasUpdateBusiness getNewBusiness(long j3) {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(j3).booleanValue()) {
            try {
                return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(j3));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean safeDeleteFile(File file) {
        return safeDeleteFile(file, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0174 A[Catch: Exception -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x0119, blocks: (B:59:0x0150, B:38:0x0174, B:110:0x0114), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0150 A[Catch: Exception -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x0119, blocks: (B:59:0x0150, B:38:0x0174, B:110:0x0114), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x011a -> B:43:0x0177). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String unZipFile(File file, String str) {
        InputStream inputStream;
        QZipFile qZipFile;
        ?? r85;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    qZipFile = new QZipFile(file);
                } catch (Exception e16) {
                    e = e16;
                    qZipFile = null;
                    inputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    qZipFile = null;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    qZipFile = null;
                    inputStream = null;
                }
                try {
                    Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                    byte[] bArr = new byte[8192];
                    inputStream = null;
                    r85 = 0;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.getName().contains("..")) {
                                if (nextElement.isDirectory()) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("upZipFile", 4, "ze.getName() = " + nextElement.getName());
                                    }
                                    String str2 = new String((str + nextElement.getName()).getBytes("8859_1"), "GB2312");
                                    if (QLog.isColorLevel()) {
                                        QLog.d("upZipFile", 2, "str = " + str2);
                                    }
                                    new File(str2).mkdir();
                                    r85 = str2;
                                } else {
                                    r85 = nextElement.getName();
                                    File file2 = new File(str + nextElement.getName());
                                    file2.getParentFile().mkdirs();
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                                    try {
                                        inputStream = qZipFile.getInputStream(nextElement);
                                        while (true) {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream2.write(bArr, 0, read);
                                        }
                                        inputStream.close();
                                        bufferedOutputStream2.close();
                                        bufferedOutputStream = bufferedOutputStream2;
                                    } catch (Exception e18) {
                                        e = e18;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        QLog.e(TAG, 1, "unZipFile error: ", e);
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (qZipFile != null) {
                                        }
                                        return r85;
                                    } catch (OutOfMemoryError e19) {
                                        e = e19;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        QLog.e(TAG, 1, "unZipFile oom: ", e);
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (qZipFile != null) {
                                        }
                                        return r85;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (Exception e26) {
                                                QLog.e(TAG, 1, "unZipFile close error: ", e26);
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e27) {
                                                QLog.e(TAG, 1, "unZipFile close error: ", e27);
                                            }
                                        }
                                        if (qZipFile != null) {
                                            try {
                                                qZipFile.close();
                                                throw th;
                                            } catch (Exception e28) {
                                                QLog.e(TAG, 1, "unZipFile close error: ", e28);
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Exception e29) {
                            e = e29;
                        } catch (OutOfMemoryError e36) {
                            e = e36;
                        }
                    }
                    qZipFile.close();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e37) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e37);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e38) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e38);
                        }
                    }
                    qZipFile.close();
                    r85 = r85;
                } catch (Exception e39) {
                    e = e39;
                    inputStream = null;
                    r85 = inputStream;
                    QLog.e(TAG, 1, "unZipFile error: ", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e46) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e46);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e47) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e47);
                        }
                    }
                    if (qZipFile != null) {
                        qZipFile.close();
                        r85 = r85;
                    }
                    return r85;
                } catch (OutOfMemoryError e48) {
                    e = e48;
                    inputStream = null;
                    r85 = inputStream;
                    QLog.e(TAG, 1, "unZipFile oom: ", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e49) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e49);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e56) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e56);
                        }
                    }
                    if (qZipFile != null) {
                        qZipFile.close();
                        r85 = r85;
                    }
                    return r85;
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = null;
                }
            } catch (Exception e57) {
                QLog.e(TAG, 1, "unZipFile close error: ", e57);
                r85 = r85;
            }
            return r85;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static void vasPokeCallback(CallBacker callBacker, UpdateListenerParams updateListenerParams, String str) {
        if (callBacker != null && TextUtils.equals(updateListenerParams.mBusinessUpdateParams.mScid, str)) {
            BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
            callBacker.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
        }
    }

    public static boolean safeDeleteFile(File file, String str) {
        File[] listFiles;
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                safeDeleteFile(file2, str);
            }
        }
        File file3 = new File(file.getParent() + File.separator + str + System.currentTimeMillis());
        file.renameTo(file3);
        return file3.delete();
    }
}
