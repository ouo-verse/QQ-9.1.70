package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

/* loaded from: classes2.dex */
public class PushProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (uri != null && uri.toString().endsWith(".xml")) {
            return "xml";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Context createDeviceProtectedStorageContext;
        File dataDir;
        File dataDir2;
        HMSLog.i("PushProvider", "use sdk PushProvider openFile");
        if ("xml".equals(getType(uri))) {
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb5 = new StringBuilder();
                Context context = getContext();
                Objects.requireNonNull(context);
                createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                dataDir = createDeviceProtectedStorageContext.getDataDir();
                sb5.append(dataDir);
                sb5.append("/shared_prefs/push_notify_flag.xml");
                File file = new File(sb5.toString());
                if (file.exists()) {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
                StringBuilder sb6 = new StringBuilder();
                dataDir2 = getContext().getDataDir();
                sb6.append(dataDir2);
                sb6.append("/shared_prefs/push_notify_flag.xml");
                File file2 = new File(sb6.toString());
                if (file2.exists()) {
                    return ParcelFileDescriptor.open(file2, 268435456);
                }
            } else {
                String str2 = getContext().getFilesDir() + "";
                if (!TextUtils.isEmpty(str2)) {
                    File file3 = new File(str2.substring(0, str2.length() - 6) + "/shared_prefs/push_notify_flag.xml");
                    if (file3.exists()) {
                        return ParcelFileDescriptor.open(file3, 268435456);
                    }
                }
            }
            throw new FileNotFoundException(uri.getPath());
        }
        HMSLog.w("PushProvider", "Incorrect file uri");
        throw new FileNotFoundException(uri.getPath());
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
