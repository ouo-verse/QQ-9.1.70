package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.util.JumpUriUtils;
import com.tencent.mobileqq.haoliyou.util.UriQueryFileInfo;
import com.tencent.mobileqq.haoliyou.util.UriToFileCacheInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* loaded from: classes7.dex */
public class UriParserPathHelper implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int FILE_MAX_SIZE = 209715200;
    private static final int MSG_COPY_FILE_FAILED = 1;
    private static final int MSG_COPY_FILE_FINISHED = 2;
    private static final int MSG_UPDATE_PROGRESS = 3;
    public static final String TAG = "UriParserPathHelper";
    private static final int TEMP_FILE_KEEP_TIME = 86400000;

    /* renamed from: msg, reason: collision with root package name */
    public static String f236761msg = null;
    private static ConcurrentHashMap<String, UriToFileCacheInfo> sCopyedFileList = null;
    private static final String shareTempDir = "share";
    private Activity mActivity;
    public Context mAppContext;
    private AtomicInteger mCopyCount;
    private boolean mCopyNonAppStorageFileSwitch;
    private IOnFileCopyFinishListener mFileCopyListener;
    private final boolean mNeedCompareCacheFileModified;
    private boolean mNeedDialog;
    private QQCustomDialog progressDialog;
    private final MqqHandler uiHandler;
    public boolean waiting;

    /* loaded from: classes7.dex */
    public interface GetPathFromUriCallback {
        void onFinish(@Nullable String str);
    }

    /* loaded from: classes7.dex */
    public interface IOnFileCopyFinishListener {
        void onFaild(Uri uri);

        void onFinish(String str, String str2, long j3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72509);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            sCopyedFileList = new ConcurrentHashMap<>();
        }
    }

    public UriParserPathHelper(Activity activity, boolean z16, IOnFileCopyFinishListener iOnFileCopyFinishListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Boolean.valueOf(z16), iOnFileCopyFinishListener);
            return;
        }
        this.uiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.mCopyCount = new AtomicInteger(0);
        this.mCopyNonAppStorageFileSwitch = false;
        this.mActivity = activity;
        this.mAppContext = BaseApplicationImpl.getApplication().getApplicationContext();
        this.mNeedDialog = z16;
        this.mFileCopyListener = iOnFileCopyFinishListener;
        this.mCopyNonAppStorageFileSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("system_file_share_copy_switch", false);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("open_connect_uri_parser_copy_cache_compare_modified_switch", true);
        this.mNeedCompareCacheFileModified = isSwitchOn;
        QLog.i(TAG, 1, "UriParserPathHelper switch: " + this.mCopyNonAppStorageFileSwitch + ", mNeedCompareCacheFileModified: " + isSwitchOn);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean canReadFileFromUri(Uri uri, Context context) {
        boolean z16;
        Cursor query;
        Cursor cursor;
        String string;
        boolean z17;
        boolean z18;
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        StringBuilder sb5 = new StringBuilder("system share.canReadFileFromUri()");
        ?? r26 = ",uri=";
        sb5.append(",uri=");
        sb5.append(uri);
        Cursor cursor2 = null;
        String string2 = null;
        cursor2 = null;
        try {
        } catch (Exception e16) {
            e = e16;
        }
        if (scheme != null) {
            try {
            } catch (Exception e17) {
                e = e17;
                r26 = 0;
                QLog.e(TAG, 1, "system share.doShareCheckPermission() e=", e);
                z16 = r26;
                if (!z16) {
                }
                QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
                return z16;
            }
            if (!scheme.equals("file")) {
                if (scheme.equals("content")) {
                    try {
                        cursor = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = null;
                    }
                    try {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                        cursor.moveToFirst();
                        string = cursor.getString(columnIndexOrThrow);
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            QLog.e(TAG, 1, "system share.doShareCheckPermission.e=", th);
                            sb5.append(",is content path->can read:");
                            sb5.append(false);
                            if (cursor != null) {
                                cursor.close();
                            }
                            r26 = 0;
                            z16 = r26;
                            if (!z16) {
                            }
                            QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
                            return z16;
                        } catch (Throwable th7) {
                            sb5.append(",is content path->can read:");
                            sb5.append(false);
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th7;
                        }
                    }
                    if (!TextUtils.isEmpty(string)) {
                        QLog.d(TAG, 1, "system share.canReadFileFromUri().path=", string);
                        if (new File(string).canRead()) {
                            z17 = true;
                            sb5.append(",is content path->can read:");
                            sb5.append(z17);
                            cursor.close();
                            r26 = z17;
                            z16 = r26;
                            if (!z16 && context != null) {
                                try {
                                    try {
                                        ContentResolver contentResolver = context.getContentResolver();
                                        query = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
                                        if (query != null) {
                                            try {
                                                int columnIndex = query.getColumnIndex(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                                                query.moveToFirst();
                                                if (columnIndex != -1) {
                                                    string2 = query.getString(columnIndex);
                                                }
                                                InputStream openInputStream = contentResolver.openInputStream(uri);
                                                if (openInputStream != null && !TextUtils.isEmpty(string2)) {
                                                    QLog.e(TAG, 1, "system share.doShareCheckPermission() can get file provider name=", string2);
                                                    z16 = true;
                                                }
                                                if (openInputStream != null) {
                                                    openInputStream.close();
                                                }
                                            } catch (Exception e18) {
                                                e = e18;
                                                cursor2 = query;
                                                QLog.e(TAG, 1, "system share.doShareCheckPermission() file provider e=", e);
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                sb5.append(",file provider->can read:");
                                                sb5.append(z16);
                                                QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
                                                return z16;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                cursor2 = query;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                sb5.append(",file provider->can read:");
                                                sb5.append(z16);
                                                throw th;
                                            }
                                        }
                                        if (query != null) {
                                            query.close();
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                }
                                sb5.append(",file provider->can read:");
                                sb5.append(z16);
                            }
                            QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
                            return z16;
                        }
                    }
                    z17 = false;
                    sb5.append(",is content path->can read:");
                    sb5.append(z17);
                    cursor.close();
                    r26 = z17;
                    z16 = r26;
                    if (!z16) {
                        ContentResolver contentResolver2 = context.getContentResolver();
                        query = ContactsMonitor.query(contentResolver2, uri, null, null, null, null);
                        if (query != null) {
                        }
                        if (query != null) {
                        }
                        sb5.append(",file provider->can read:");
                        sb5.append(z16);
                    }
                    QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
                    return z16;
                }
                r26 = 0;
                z16 = r26;
                if (!z16) {
                }
                QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
                return z16;
            }
        }
        if (new File(uri.getPath()).canRead()) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(",is file path->can read=");
        sb5.append(z18);
        r26 = z18;
        z16 = r26;
        if (!z16) {
        }
        QLog.d(TAG, 4, "canReadFileFromUri " + ((Object) sb5));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyFile(Uri uri, String str, InputStream inputStream, long j3, long j16, GetPathFromUriCallback getPathFromUriCallback) {
        this.mCopyCount.incrementAndGet();
        ThreadManagerV2.post(new Runnable(str, getPathFromUriCallback, inputStream, j3, uri, j16) { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ GetPathFromUriCallback val$callback;
            final /* synthetic */ long val$fileSize;
            final /* synthetic */ InputStream val$is;
            final /* synthetic */ long val$lastModified;
            final /* synthetic */ String val$path;
            final /* synthetic */ Uri val$uri;

            {
                this.val$path = str;
                this.val$callback = getPathFromUriCallback;
                this.val$is = inputStream;
                this.val$fileSize = j3;
                this.val$uri = uri;
                this.val$lastModified = j16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, UriParserPathHelper.this, str, getPathFromUriCallback, inputStream, Long.valueOf(j3), uri, Long.valueOf(j16));
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:57:0x01fb  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0218  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FileOutputStream fileOutputStream;
                byte[] bArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                byte[] bArr2 = null;
                try {
                    File file = new File(this.val$path);
                    if (!file.exists()) {
                        try {
                            if (!file.createNewFile()) {
                                UriParserPathHelper.this.uiHandler.sendEmptyMessage(1);
                                UriParserPathHelper.this.invokeCallback(this.val$callback, null, "copy target file create fail");
                                UriParserPathHelper.this.mCopyCount.decrementAndGet();
                                IOUtils.closeQuietly(this.val$is);
                                IOUtils.closeQuietly((OutputStream) null);
                                return;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = null;
                            bArr = null;
                            QLog.e(UriParserPathHelper.TAG, 1, "system share.copyFile.resolve file error", e);
                            UriParserPathHelper.this.uiHandler.sendEmptyMessage(1);
                            UriParserPathHelper.this.invokeCallback(this.val$callback, null, "copy file catch exception: " + e.getMessage());
                            if (bArr != null) {
                            }
                            UriParserPathHelper.this.mCopyCount.decrementAndGet();
                            IOUtils.closeQuietly(this.val$is);
                            IOUtils.closeQuietly(fileOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                            if (bArr2 != null) {
                            }
                            UriParserPathHelper.this.mCopyCount.decrementAndGet();
                            IOUtils.closeQuietly(this.val$is);
                            IOUtils.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream = new FileOutputStream(this.val$path);
                    try {
                        bArr = ByteArrayPool.getGenericInstance().getBuf(8192);
                        long j17 = 0;
                        long j18 = 0;
                        long j19 = 0;
                        while (true) {
                            try {
                                try {
                                    int read = this.val$is.read(bArr);
                                    if (read == -1 || !UriParserPathHelper.this.isCopying()) {
                                        break;
                                    }
                                    j18 += read;
                                    fileOutputStream.write(bArr, 0, read);
                                    if (j18 > j17) {
                                        long j26 = this.val$fileSize;
                                        if (j18 <= j26) {
                                            if ((j18 - j19) / j26 > 0.1d) {
                                                UriParserPathHelper.this.uiHandler.sendMessage(UriParserPathHelper.this.uiHandler.obtainMessage(3, (int) ((j18 / this.val$fileSize) * 100.0d), 0));
                                                j19 = j18;
                                            }
                                            j17 = 0;
                                        }
                                    }
                                    QLog.e(UriParserPathHelper.TAG, 1, "copyFile process error. fileSize: " + this.val$fileSize + ", size: " + j18);
                                    j17 = 0;
                                } catch (Throwable th6) {
                                    th = th6;
                                    bArr2 = bArr;
                                    if (bArr2 != null) {
                                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                    }
                                    UriParserPathHelper.this.mCopyCount.decrementAndGet();
                                    IOUtils.closeQuietly(this.val$is);
                                    IOUtils.closeQuietly(fileOutputStream);
                                    throw th;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                QLog.e(UriParserPathHelper.TAG, 1, "system share.copyFile.resolve file error", e);
                                UriParserPathHelper.this.uiHandler.sendEmptyMessage(1);
                                UriParserPathHelper.this.invokeCallback(this.val$callback, null, "copy file catch exception: " + e.getMessage());
                                if (bArr != null) {
                                    ByteArrayPool.getGenericInstance().returnBuf(bArr);
                                }
                                UriParserPathHelper.this.mCopyCount.decrementAndGet();
                                IOUtils.closeQuietly(this.val$is);
                                IOUtils.closeQuietly(fileOutputStream);
                            }
                        }
                        if (j18 == j17) {
                            if (this.val$uri.toString().contains("mms/part")) {
                                UriParserPathHelper.f236761msg = UriParserPathHelper.this.mAppContext.getString(R.string.b8k);
                            } else {
                                UriParserPathHelper.f236761msg = UriParserPathHelper.this.mAppContext.getString(R.string.b85);
                            }
                            UriParserPathHelper.this.uiHandler.sendEmptyMessage(1);
                            UriParserPathHelper.this.invokeCallback(this.val$callback, null, UriParserPathHelper.f236761msg);
                        }
                        if (UriParserPathHelper.this.isCopying()) {
                            if (UriParserPathHelper.this.mFileCopyListener != null) {
                                UriParserPathHelper.this.mFileCopyListener.onFinish(file.getAbsolutePath(), file.getName(), j18);
                                UriParserPathHelper.this.mFileCopyListener = null;
                            }
                            UriParserPathHelper.this.invokeCallback(this.val$callback, file.getAbsolutePath());
                            UriParserPathHelper.sCopyedFileList.put(this.val$uri.toString(), new UriToFileCacheInfo(this.val$uri, file.getAbsolutePath(), this.val$lastModified));
                            UriParserPathHelper.this.uiHandler.sendMessage(UriParserPathHelper.this.uiHandler.obtainMessage(3, 100, 0));
                            UriParserPathHelper.this.uiHandler.sendEmptyMessageDelayed(2, 200L);
                            QLog.i(UriParserPathHelper.TAG, 1, "copy file finish. length: " + file.length());
                        } else {
                            IOUtils.closeQuietly(fileOutputStream);
                            file.delete();
                        }
                        if (bArr != null) {
                            ByteArrayPool.getGenericInstance().returnBuf(bArr);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        bArr = null;
                        QLog.e(UriParserPathHelper.TAG, 1, "system share.copyFile.resolve file error", e);
                        UriParserPathHelper.this.uiHandler.sendEmptyMessage(1);
                        UriParserPathHelper.this.invokeCallback(this.val$callback, null, "copy file catch exception: " + e.getMessage());
                        if (bArr != null) {
                        }
                        UriParserPathHelper.this.mCopyCount.decrementAndGet();
                        IOUtils.closeQuietly(this.val$is);
                        IOUtils.closeQuietly(fileOutputStream);
                    } catch (Throwable th7) {
                        th = th7;
                        bArr2 = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    bArr2 = null;
                    fileOutputStream = null;
                }
                UriParserPathHelper.this.mCopyCount.decrementAndGet();
                IOUtils.closeQuietly(this.val$is);
                IOUtils.closeQuietly(fileOutputStream);
            }
        }, 5, null, true);
        runOnUIThread(this.uiHandler, new Runnable() { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UriParserPathHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!UriParserPathHelper.this.mNeedDialog) {
                    return;
                }
                if (UriParserPathHelper.this.progressDialog == null) {
                    UriParserPathHelper uriParserPathHelper = UriParserPathHelper.this;
                    uriParserPathHelper.progressDialog = DialogUtil.createCustomProgressDialog(uriParserPathHelper.mActivity, UriParserPathHelper.this.mAppContext.getString(R.string.aex), HardCodeUtil.qqStr(R.string.j6l), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                UriParserPathHelper.this.mCopyCount.set(0);
                                UriParserPathHelper.this.mActivity.finish();
                            }
                        }
                    });
                    UriParserPathHelper.this.progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.4.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface);
                            } else if (UriParserPathHelper.this.isCopying()) {
                                UriParserPathHelper.this.mCopyCount.set(0);
                                UriParserPathHelper.this.mActivity.finish();
                            }
                        }
                    });
                }
                UriParserPathHelper.this.progressDialog.show();
            }
        });
    }

    private static void deleteOldFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (System.currentTimeMillis() - file2.lastModified() > 86400000) {
                file2.delete();
            }
        }
    }

    private void dismissDialog() {
        QQCustomDialog qQCustomDialog = this.progressDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doGetPathFromUri(Uri uri, boolean z16, boolean z17, GetPathFromUriCallback getPathFromUriCallback) {
        QLog.d(TAG, 1, "getPathFromUri uri= " + uri);
        this.waiting = false;
        if (VersionUtils.isNougat() && "com.android.fileexplorer.fileprovider".equalsIgnoreCase(uri.getAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() >= 2 && "external_files".equalsIgnoreCase(pathSegments.get(0))) {
                String replaceFirst = uri.getPath().replaceFirst("\\/external_files", AppConstants.SDCARD_ROOT);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Nougat path: " + replaceFirst);
                }
                invokeCallback(getPathFromUriCallback, replaceFirst);
                return replaceFirst;
            }
        } else if (VersionUtils.isKITKAT()) {
            List<String> pathSegments2 = uri.getPathSegments();
            if (pathSegments2.size() >= 2 && "document".equals(pathSegments2.get(0))) {
                String str = pathSegments2.get(1);
                try {
                    if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                        String[] split = str.split(":");
                        if ("primary".equalsIgnoreCase(split[0])) {
                            String str2 = Environment.getExternalStorageDirectory() + "/" + split[1];
                            File file = new File(str2);
                            if (file.exists() && file.canRead()) {
                                invokeCallback(getPathFromUriCallback, str2);
                                return str2;
                            }
                            QLog.e(TAG, 1, "getPathFromUri documents uri file exist? " + file.exists() + ", canRead? " + file.canRead() + ", path:" + str2);
                        }
                    } else {
                        Uri uri2 = null;
                        if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                            String dataColumn = getDataColumn(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(str).longValue()), null, null);
                            invokeCallback(getPathFromUriCallback, dataColumn);
                            return dataColumn;
                        }
                        if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                            String[] split2 = str.split(":");
                            String str3 = split2[0];
                            if ("image".equals(str3)) {
                                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            } else if ("video".equals(str3)) {
                                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            } else if ("audio".equals(str3)) {
                                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                            }
                            String[] strArr = {split2[1]};
                            if (uri2 != null) {
                                String dataColumn2 = getDataColumn(uri2, "_id=?", strArr);
                                invokeCallback(getPathFromUriCallback, dataColumn2);
                                return dataColumn2;
                            }
                            QLog.e(TAG, 1, "getPathFromUri null == contentUri");
                        } else {
                            "com.google.android.apps.photos.content".equals(uri.getAuthority());
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handle exeption ", e16);
                    }
                }
            } else if (pathSegments2.size() >= 2 && "my_external".equals(pathSegments2.get(0)) && "com.android.contacts.files".equals(uri.getAuthority())) {
                StringBuilder sb5 = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
                for (int i3 = 1; i3 < pathSegments2.size(); i3++) {
                    sb5.append('/');
                    sb5.append(pathSegments2.get(i3));
                }
                String sb6 = sb5.toString();
                invokeCallback(getPathFromUriCallback, sb6);
                return sb6;
            }
        }
        return getFilePathAsync(uri, z16, z17, getPathFromUriCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r9 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
    
        if (r9 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0035, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        r9.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDataColumn(Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        cursor.close();
                        return string;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    private UriToFileCacheInfo getFileCacheInfo(ContentResolver contentResolver, Uri uri) {
        UriToFileCacheInfo uriToFileCacheInfo = sCopyedFileList.get(uri.toString());
        if (uriToFileCacheInfo != null && !TextUtils.isEmpty(uriToFileCacheInfo.path)) {
            File file = new File(uriToFileCacheInfo.path);
            if (file.exists() && file.canRead()) {
                if (this.mNeedCompareCacheFileModified) {
                    if (uriToFileCacheInfo.lastModified <= 0) {
                        QLog.e(TAG, 1, "getFileCacheInfo cache lastModified is invalid. " + uriToFileCacheInfo.lastModified);
                        return null;
                    }
                    long queryLastModified = JumpUriUtils.queryLastModified(contentResolver, uri);
                    if (queryLastModified != uriToFileCacheInfo.lastModified) {
                        QLog.e(TAG, 1, "getFileCacheInfo compare lastModified failed. " + queryLastModified + "/" + uriToFileCacheInfo.lastModified);
                        return null;
                    }
                }
                return uriToFileCacheInfo;
            }
            QLog.e(TAG, 1, "getFileCacheInfo cache is invalid. exists?" + file.exists() + ", canRead? " + file.canRead());
        }
        return null;
    }

    private String getFilePathAsync(Uri uri, boolean z16, boolean z17, GetPathFromUriCallback getPathFromUriCallback) {
        QLog.e(TAG, 2, "getFilePathAsync copy: ", Boolean.valueOf(z16));
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file")) {
            if (scheme.equals("content")) {
                try {
                    String path = getPath(uri);
                    if (TextUtils.isEmpty(path)) {
                        QLog.e(TAG, 1, "getFilePathAsync getPath return null or empty. copy? " + z16 + ", uri authority: " + uri.getAuthority());
                        if (z16 && !MobileQQ.PACKAGE_NAME.equalsIgnoreCase(uri.getAuthority())) {
                            return getPathFromFileProvider(uri, z17, getPathFromUriCallback);
                        }
                        invokeCallback(getPathFromUriCallback, null, "getFilePathAsync getPath return null or empty");
                        return null;
                    }
                    File file = new File(path);
                    if (this.mCopyNonAppStorageFileSwitch) {
                        if (z16 && !isAppExternalFile(file.getPath())) {
                            return getPathFromFileProvider(uri, z17, getPathFromUriCallback);
                        }
                    } else if (!file.canRead() && z16) {
                        return getPathFromFileProvider(uri, z17, getPathFromUriCallback);
                    }
                    return path;
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "Exception", th5);
                    }
                    if (z16) {
                        return getPathFromFileProvider(uri, z17, getPathFromUriCallback);
                    }
                }
            }
            invokeCallback(getPathFromUriCallback, null, "getFilePathAsync return null");
            return null;
        }
        String absolutePath = new File(uri.getPath()).getAbsolutePath();
        invokeCallback(getPathFromUriCallback, absolutePath);
        return absolutePath;
    }

    private String getPath(Uri uri) {
        Cursor cursor = null;
        try {
            try {
                Cursor query = ContactsMonitor.query(this.mActivity.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
                if (query == null) {
                    QLog.e(TAG, 1, "getPath cursor is null ");
                    if (query != null) {
                        query.close();
                    }
                    return "";
                }
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                String string = query.getString(columnIndexOrThrow);
                query.close();
                return string;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getPath Exception", e16);
                if (0 != 0) {
                    cursor.close();
                }
                return "";
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    private String getPathFromFileProvider(Uri uri, boolean z16, GetPathFromUriCallback getPathFromUriCallback) {
        UriToFileCacheInfo fileCacheInfo;
        ContentResolver contentResolver = this.mActivity.getContentResolver();
        if (z16 && (fileCacheInfo = getFileCacheInfo(contentResolver, uri)) != null && fileCacheInfo.path != null) {
            QLog.i(TAG, 1, "getPathFromFileProvider return cacheFileInfo: " + fileCacheInfo.path);
            invokeCallback(getPathFromUriCallback, fileCacheInfo.path);
            return fileCacheInfo.path;
        }
        f236761msg = null;
        UriQueryFileInfo uriFileNameAndLength = JumpUriUtils.getUriFileNameAndLength(contentResolver, uri);
        if (uriFileNameAndLength == null) {
            invokeCallback(getPathFromUriCallback, null, "getPathFromFileProvider getUriFileNameAndLength return null");
            return null;
        }
        String str = uriFileNameAndLength.name;
        long j3 = uriFileNameAndLength.size;
        long j16 = uriFileNameAndLength.lastModified;
        if (TextUtils.isEmpty(str)) {
            invokeCallback(getPathFromUriCallback, null, "getPathFromFileProvider getUriFileNameAndLength name is null");
            return null;
        }
        if (((float) j3) > FileUtils.getAvailableExternalMemorySize()) {
            String string = this.mActivity.getString(R.string.hiw);
            f236761msg = string;
            invokeCallback(getPathFromUriCallback, null, string);
            return null;
        }
        try {
            String str2 = this.mActivity.getExternalCacheDir() + "/share/";
            String str3 = str2 + FileUtils.getUnitFileName(str2, str);
            deleteOldFile(str2);
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                String qqStr = HardCodeUtil.qqStr(R.string.uuz);
                f236761msg = qqStr;
                invokeCallback(getPathFromUriCallback, null, qqStr);
                return null;
            }
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream == null) {
                QLog.i(TAG, 1, "system share.getPathFromFileProvider:open input stream failed");
                invokeCallback(getPathFromUriCallback, null, "open input stream failed");
                return null;
            }
            if (j3 > 209715200) {
                runOnUIThread(this.uiHandler, new Runnable(openInputStream, getPathFromUriCallback, uri, str3, j3, j16) { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GetPathFromUriCallback val$callback;
                    final /* synthetic */ long val$fileSize;
                    final /* synthetic */ InputStream val$is;
                    final /* synthetic */ long val$lastModified;
                    final /* synthetic */ String val$path;
                    final /* synthetic */ Uri val$uri;

                    {
                        this.val$is = openInputStream;
                        this.val$callback = getPathFromUriCallback;
                        this.val$uri = uri;
                        this.val$path = str3;
                        this.val$fileSize = j3;
                        this.val$lastModified = j16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, UriParserPathHelper.this, openInputStream, getPathFromUriCallback, uri, str3, Long.valueOf(j3), Long.valueOf(j16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        UriParserPathHelper.this.waiting = true;
                        QQCustomDialog qQCustomDialog = new QQCustomDialog(UriParserPathHelper.this.mActivity, R.style.qZoneInputDialog);
                        qQCustomDialog.setContentView(R.layout.f167856jn);
                        qQCustomDialog.setTitle(UriParserPathHelper.this.mAppContext.getString(R.string.f173206i10));
                        qQCustomDialog.setMessage(UriParserPathHelper.this.mAppContext.getString(R.string.b8t));
                        qQCustomDialog.setCanceledOnTouchOutside(false);
                        qQCustomDialog.setCancelable(false);
                        qQCustomDialog.setNegativeButton(UriParserPathHelper.this.mAppContext.getString(R.string.f170647xd), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                    return;
                                }
                                try {
                                    AnonymousClass2.this.val$is.close();
                                } catch (IOException e16) {
                                    QLog.e(UriParserPathHelper.TAG, 1, "system share.exception.e=", e16);
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UriParserPathHelper.this.invokeCallback(anonymousClass2.val$callback, null, "user cancel copy file");
                                UriParserPathHelper.this.mActivity.finish();
                            }
                        });
                        qQCustomDialog.setPositiveButton(UriParserPathHelper.this.mAppContext.getString(R.string.ans), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.2.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                    return;
                                }
                                try {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    UriParserPathHelper.this.copyFile(anonymousClass2.val$uri, anonymousClass2.val$path, anonymousClass2.val$is, anonymousClass2.val$fileSize, anonymousClass2.val$lastModified, anonymousClass2.val$callback);
                                    UriParserPathHelper.this.waiting = false;
                                } catch (Exception e16) {
                                    QLog.e(UriParserPathHelper.TAG, 1, "system share.copy file error", e16);
                                    String str4 = UriParserPathHelper.f236761msg;
                                    if (str4 == null) {
                                        str4 = UriParserPathHelper.this.mAppContext.getString(R.string.hiy);
                                    }
                                    UriParserPathHelper.this.showErrorMsg(str4);
                                    if (UriParserPathHelper.this.mFileCopyListener != null) {
                                        UriParserPathHelper.this.mFileCopyListener.onFaild(AnonymousClass2.this.val$uri);
                                        UriParserPathHelper.this.mFileCopyListener = null;
                                    }
                                }
                            }
                        });
                        qQCustomDialog.show();
                    }
                });
            } else {
                copyFile(uri, str3, openInputStream, j3, j16, getPathFromUriCallback);
            }
            return str3;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "system share.getPathFromFileProvider:query file error", e16);
            invokeCallback(getPathFromUriCallback, null, "getPathFromFileProvider exception: " + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallback(GetPathFromUriCallback getPathFromUriCallback, String str) {
        invokeCallback(getPathFromUriCallback, str, null);
    }

    private boolean isAppExternalFile(String str) {
        if (str == null) {
            return false;
        }
        if (!str.isEmpty()) {
            try {
                File externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
                if (externalFilesDir != null && str.startsWith(externalFilesDir.getPath())) {
                    return true;
                }
                File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
                if (externalCacheDir == null) {
                    return false;
                }
                if (!str.startsWith(externalCacheDir.getPath())) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    private static void runOnUIThread(MqqHandler mqqHandler, Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            mqqHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorMsg(String str) {
        if (!this.mNeedDialog) {
            return;
        }
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this.mActivity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(this.mAppContext.getString(R.string.f173206i10));
        qQCustomDialog.setMessage(str);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setNegativeButton(this.mAppContext.getString(R.string.button_back), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UriParserPathHelper.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    UriParserPathHelper.this.mActivity.finish();
                }
            }
        });
        if (!this.mActivity.isFinishing()) {
            qQCustomDialog.show();
        }
    }

    public void asyncGetPathFromUri(Uri uri, GetPathFromUriCallback getPathFromUriCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            asyncGetPathFromUri(uri, true, getPathFromUriCallback);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri, (Object) getPathFromUriCallback);
        }
    }

    protected String getAlertMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String str = f236761msg;
        if (str == null) {
            return this.mAppContext.getString(R.string.hiy);
        }
        return str;
    }

    public String getPathFromUri(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? getPathFromUri(uri, true) : (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uri);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(TAG, 1, "handleMessage.progress: " + message.arg1);
                    }
                    QQCustomDialog qQCustomDialog = this.progressDialog;
                    if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                        this.progressDialog.setProgress(message.arg1);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            dismissDialog();
            return false;
        }
        dismissDialog();
        showErrorMsg(getAlertMsg());
        IOnFileCopyFinishListener iOnFileCopyFinishListener = this.mFileCopyListener;
        if (iOnFileCopyFinishListener != null) {
            iOnFileCopyFinishListener.onFaild(null);
            this.mFileCopyListener = null;
            return false;
        }
        return false;
    }

    public boolean isCopying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.mCopyCount.get() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallback(GetPathFromUriCallback getPathFromUriCallback, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, str2);
        }
        StringBuilder sb5 = new StringBuilder("invokeCallback: ");
        if (str != null) {
            File file = new File(str);
            sb5.append("[");
            sb5.append("exists? ");
            sb5.append(file.exists());
            sb5.append(", canRead? ");
            sb5.append(file.canRead());
            sb5.append(", length: ");
            sb5.append(file.length());
            sb5.append("]");
        }
        sb5.append(", callback null? ");
        sb5.append(getPathFromUriCallback == null);
        sb5.append(", path: ");
        sb5.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(", msg: ");
            sb5.append(str2);
        }
        QLog.i(TAG, 1, sb5.toString());
        if (getPathFromUriCallback != null) {
            getPathFromUriCallback.onFinish(str);
        }
    }

    public void asyncGetPathFromUri(Uri uri, boolean z16, GetPathFromUriCallback getPathFromUriCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            asyncGetPathFromUri(uri, z16, true, getPathFromUriCallback);
        } else {
            iPatchRedirector.redirect((short) 3, this, uri, Boolean.valueOf(z16), getPathFromUriCallback);
        }
    }

    public String getPathFromUri(Uri uri, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? getPathFromUri(uri, z16, true) : (String) iPatchRedirector.redirect((short) 6, this, uri, Boolean.valueOf(z16));
    }

    public void asyncGetPathFromUri(Uri uri, boolean z16, boolean z17, GetPathFromUriCallback getPathFromUriCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uri, Boolean.valueOf(z16), Boolean.valueOf(z17), getPathFromUriCallback);
            return;
        }
        if (getPathFromUriCallback == null) {
            QLog.e(TAG, 1, "asyncGetPathFromUri callback is null");
            return;
        }
        if (uri == null) {
            QLog.e(TAG, 1, "asyncGetPathFromUri uri is null");
            getPathFromUriCallback.onFinish("");
            return;
        }
        QLog.i(TAG, 1, "asyncGetPathFromUri: " + uri);
        ThreadManagerV2.excute(new Runnable(uri, z16, z17, getPathFromUriCallback) { // from class: com.tencent.mobileqq.haoliyou.UriParserPathHelper.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ GetPathFromUriCallback val$callback;
            final /* synthetic */ boolean val$copy;
            final /* synthetic */ Uri val$uri;
            final /* synthetic */ boolean val$useCache;

            {
                this.val$uri = uri;
                this.val$copy = z16;
                this.val$useCache = z17;
                this.val$callback = getPathFromUriCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UriParserPathHelper.this, uri, Boolean.valueOf(z16), Boolean.valueOf(z17), getPathFromUriCallback);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QLog.i(UriParserPathHelper.TAG, 2, "asyncGetPathFromUri path: " + UriParserPathHelper.this.doGetPathFromUri(this.val$uri, this.val$copy, this.val$useCache, this.val$callback));
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        }, 16, null, true);
    }

    public String getPathFromUri(Uri uri, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? doGetPathFromUri(uri, z16, z17, null) : (String) iPatchRedirector.redirect((short) 7, this, uri, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }
}
