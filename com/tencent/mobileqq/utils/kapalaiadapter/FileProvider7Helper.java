package com.tencent.mobileqq.utils.kapalaiadapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes20.dex */
public class FileProvider7Helper {
    public static String sAuthority;
    public static Boolean sIsTargetThanN;

    public static String getPathFromUri(Context context, String str, List<String> list) {
        if (isTargetBeyondN(context) && list != null && list.size() > 0) {
            return str.replace(File.separator + list.get(0), "");
        }
        return str;
    }

    public static FileProvider.PathStrategy getPathStrategy(Context context) {
        if (sAuthority == null) {
            sAuthority = context.getApplicationContext().getPackageName() + ".fileprovider";
        }
        return FileProvider.getPathStrategy(context, sAuthority);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getRealPathFromContentURI(Context context, Uri uri) {
        String pathFromUri;
        String str = "";
        if (uri == null || "".equals(uri.toString())) {
            return "";
        }
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if ("content".equals(scheme)) {
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            str = cursor.getString(columnIndexOrThrow);
                        }
                    } catch (Exception unused) {
                        if (isTargetBeyondN(context)) {
                            pathFromUri = getPathStrategy(context).getFileForUri(uri).getAbsolutePath();
                        } else {
                            pathFromUri = getPathFromUri(context, uri.getPath(), uri.getPathSegments());
                        }
                        str = pathFromUri;
                        return str;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (cursor == null) {
                        return str;
                    }
                    return str;
                }
                return str;
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        return uri.toString();
    }

    public static Uri getUriForFile(Context context, File file) {
        if (isTargetBeyondN(context)) {
            return getUriForFile24(context, file);
        }
        return Uri.fromFile(file);
    }

    private static Uri getUriForFile24(Context context, File file) {
        if (sAuthority == null) {
            sAuthority = context.getApplicationContext().getPackageName() + ".fileprovider";
        }
        return FileProvider.getUriForFile(context, sAuthority, file);
    }

    public static void grantPermissions(Context context, Intent intent, Uri uri, boolean z16) {
        int i3;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        intent.addFlags(i3);
        Iterator<ResolveInfo> it = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uri, i3);
        }
    }

    public static void installApkFile(Context context, String str) {
        context.startActivity(openApkIntent(context, str));
    }

    public static void intentCompatForN(Context context, Intent intent) {
        ArrayList parcelableArrayListExtra;
        if (isTargetBeyondN(context)) {
            intent.getAction();
            Uri data = intent.getData();
            if (data != null && "file".equals(data.getScheme())) {
                intent.setDataAndType(getUriForFile24(context, new File(getRealPathFromContentURI(context, data))), intent.getType());
                intent.addFlags(1);
                intent.addFlags(2);
            }
            String[] strArr = {"output", "android.intent.extra.STREAM"};
            for (int i3 = 0; i3 < 2; i3++) {
                String str = strArr[i3];
                Parcelable parcelableExtra = intent.getParcelableExtra(str);
                if (parcelableExtra instanceof Uri) {
                    Uri uri = (Uri) parcelableExtra;
                    if ("file".equals(uri.getScheme())) {
                        intent.putExtra(str, getUriForFile24(context, new File(getRealPathFromContentURI(context, uri))));
                        intent.addFlags(1);
                        intent.addFlags(2);
                    }
                }
                if (parcelableExtra == null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(str)) != null) {
                    ArrayList arrayList = new ArrayList(parcelableArrayListExtra.size());
                    intent.addFlags(1);
                    intent.addFlags(2);
                    Iterator it = parcelableArrayListExtra.iterator();
                    while (it.hasNext()) {
                        Parcelable parcelable = (Parcelable) it.next();
                        if (parcelable instanceof Uri) {
                            Uri uri2 = (Uri) parcelable;
                            if ("file".equals(uri2.getScheme())) {
                                Uri uriForFile24 = getUriForFile24(context, new File(getRealPathFromContentURI(context, uri2)));
                                intent.putExtra(str, uriForFile24);
                                arrayList.add(uriForFile24);
                            } else {
                                arrayList.add(parcelable);
                            }
                        } else {
                            arrayList.add(parcelable);
                        }
                    }
                    intent.putExtra(str, arrayList);
                }
            }
        }
    }

    public static boolean isTargetBeyondN(Context context) {
        boolean z16;
        if (sIsTargetThanN == null) {
            if (Build.VERSION.SDK_INT >= 24 && context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 24) {
                z16 = true;
            } else {
                z16 = false;
            }
            sIsTargetThanN = Boolean.valueOf(z16);
        }
        return sIsTargetThanN.booleanValue();
    }

    public static Intent openApkIntent(Context context, String str) {
        if (!new File(str).exists()) {
            return null;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        setIntentDataAndType(context, intent, "application/vnd.android.package-archive", new File(str));
        return intent;
    }

    public static Uri savePhotoToSysAlbum(Context context, String str) {
        return savePhotoToSysAlbum(context, new File(str));
    }

    public static void setIntentDataAndType(Context context, Intent intent, String str, File file) {
        if (isTargetBeyondN(context)) {
            intent.setDataAndType(getUriForFile24(context, file), str);
            intent.addFlags(1);
            intent.addFlags(2);
            return;
        }
        intent.setDataAndType(Uri.fromFile(file), str);
    }

    public static Uri setSystemCapture(Context context, File file, Intent intent) {
        Uri fromFile;
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        if (isTargetBeyondN(context)) {
            fromFile = getUriForFile24(context, file);
            intent.addFlags(3);
        } else {
            fromFile = Uri.fromFile(file);
        }
        intent.putExtra("output", fromFile);
        intent.putExtra("android.intent.extra.videoQuality", 100);
        return fromFile;
    }

    public static Uri savePhotoToSysAlbum(Context context, File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        Uri fromFile = Uri.fromFile(file);
        intent.setData(fromFile);
        context.sendBroadcast(intent);
        return fromFile;
    }
}
