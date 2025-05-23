package com.tencent.tdf.filepicker;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.tdf.filepicker.FileInfo;
import com.tencent.util.InputMethodUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String PRIMARY_VOLUME_NAME = "primary";
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = FileUtils.class.getName();
        }
    }

    public FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean clearCache(Context context) {
        try {
            File[] listFiles = new File(context.getCacheDir() + "/file_picker/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
                return true;
            }
            return true;
        } catch (Exception e16) {
            Log.e(TAG, "There was an error while clearing cached files: " + e16.toString());
            return false;
        }
    }

    @Nullable
    private static String getDirectoryPath(Class<?> cls, Object obj) {
        if (Build.VERSION.SDK_INT <= 29) {
            return (String) cls.getMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
        }
        File file = (File) cls.getMethod("getDirectory", new Class[0]).invoke(obj, new Object[0]);
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    @TargetApi(21)
    private static String getDocumentPathFromTreeUri(Uri uri) {
        String str;
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(":");
        if (split.length >= 2 && (str = split[1]) != null) {
            return str;
        }
        return File.separator;
    }

    public static String getFileName(Uri uri, Context context) {
        String str = null;
        try {
            if (uri.getScheme().equals("content")) {
                Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{InputMethodUtil.SOUGOU_URI_DISPLAYNAME}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME));
                        }
                    } finally {
                        query.close();
                    }
                }
            }
            if (str == null) {
                String path = uri.getPath();
                int lastIndexOf = path.lastIndexOf(47);
                if (lastIndexOf != -1) {
                    return path.substring(lastIndexOf + 1);
                }
                return path;
            }
            return str;
        } catch (Exception e16) {
            Log.e(TAG, "Failed to handle file name: " + e16.toString());
            return null;
        }
    }

    @Nullable
    @RequiresApi(api = 19)
    public static String getFullPathFromTreeUri(@Nullable Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT <= 29 && isDownloadsDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            if (documentId.equals("downloads")) {
                return path;
            }
            if (documentId.matches("^ms[df]\\:.*")) {
                return path + "/" + getFileName(uri, context);
            }
            if (!documentId.startsWith("raw:")) {
                return null;
            }
            return documentId.split(":")[1];
        }
        String volumePath = getVolumePath(getVolumeIdFromTreeUri(uri), context);
        new FileInfo.Builder();
        if (volumePath == null) {
            return File.separator;
        }
        String str = File.separator;
        if (volumePath.endsWith(str)) {
            volumePath = volumePath.substring(0, volumePath.length() - 1);
        }
        String documentPathFromTreeUri = getDocumentPathFromTreeUri(uri);
        if (documentPathFromTreeUri.endsWith(str)) {
            documentPathFromTreeUri = documentPathFromTreeUri.substring(0, documentPathFromTreeUri.length() - 1);
        }
        if (documentPathFromTreeUri.length() > 0) {
            if (documentPathFromTreeUri.startsWith(str)) {
                return volumePath + documentPathFromTreeUri;
            }
            return volumePath + str + documentPathFromTreeUri;
        }
        return volumePath;
    }

    public static String[] getMimeTypes(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(arrayList.get(i3));
                if (mimeTypeFromExtension == null) {
                    Log.w(TAG, "Custom file type " + arrayList.get(i3) + " is unsupported and will be ignored.");
                } else {
                    arrayList2.add(mimeTypeFromExtension);
                }
            }
            Log.d(TAG, "Allowed file extensions mimes: " + arrayList2);
            return (String[]) arrayList2.toArray(new String[0]);
        }
        return null;
    }

    @TargetApi(21)
    private static String getVolumeIdFromTreeUri(Uri uri) {
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(":");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private static String getVolumePath(String str, Context context) {
        Class<?> cls;
        Method method;
        Method method2;
        Object invoke;
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService(QQPermissionConstants.Permission.STORAGE_GROUP);
            cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            method = cls.getMethod("getUuid", new Class[0]);
            method2 = cls.getMethod("isPrimary", new Class[0]);
            invoke = method3.invoke(storageManager, new Object[0]);
        } catch (Exception unused) {
        }
        if (invoke == null) {
            return null;
        }
        int length = Array.getLength(invoke);
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = Array.get(invoke, i3);
            String str2 = (String) method.invoke(obj, new Object[0]);
            if (((Boolean) method2.invoke(obj, new Object[0])) != null && PRIMARY_VOLUME_NAME.equals(str)) {
                return getDirectoryPath(cls, obj);
            }
            if (str2 != null && str2.equals(str)) {
                return getDirectoryPath(cls, obj);
            }
        }
        return null;
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void loadData(File file, FileInfo.Builder builder) {
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
            } catch (FileNotFoundException e16) {
                Log.e(TAG, "File not found: " + e16.getMessage(), null);
            } catch (IOException e17) {
                Log.e(TAG, "Failed to close file streams: " + e17.getMessage(), null);
            }
            builder.withData(bArr);
        } catch (Exception e18) {
            Log.e(TAG, "Failed to load bytes into memory with error " + e18.toString());
        }
    }

    public static FileInfo openFileStream(Context context, Uri uri, boolean z16) {
        Object valueOf;
        FileOutputStream fileOutputStream;
        Log.i(TAG, "Caching from URI: " + uri.toString());
        FileInfo.Builder builder = new FileInfo.Builder();
        String fileName = getFileName(uri, context);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getCacheDir().getAbsolutePath());
        sb5.append("/file_picker/");
        if (fileName != null) {
            valueOf = fileName;
        } else {
            valueOf = Integer.valueOf(new Random().nextInt(100000));
        }
        sb5.append(valueOf);
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                try {
                    fileOutputStream = new FileOutputStream(sb6);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = openInputStream.read(bArr);
                            if (read < 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        fileOutputStream.getFD().sync();
                    } catch (Throwable th5) {
                        fileOutputStream.getFD().sync();
                        throw th5;
                    }
                } catch (Exception e16) {
                    e = e16;
                    try {
                        fileOutputStream.close();
                        Log.e(TAG, "Failed to retrieve path: " + e.getMessage(), null);
                        return null;
                    } catch (IOException | NullPointerException unused) {
                        Log.e(TAG, "Failed to close file streams: " + e.getMessage(), null);
                        return null;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
                fileOutputStream.close();
                Log.e(TAG, "Failed to retrieve path: " + e.getMessage(), null);
                return null;
            }
        }
        Log.d(TAG, "File loaded and cached at:" + sb6);
        if (z16) {
            loadData(file, builder);
        }
        builder.withPath(sb6).withName(fileName).withSize(Long.parseLong(String.valueOf(file.length())));
        return builder.build();
    }
}
