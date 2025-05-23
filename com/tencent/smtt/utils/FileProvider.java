package com.tencent.smtt.utils;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes25.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f369631a = {InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_size"};

    /* renamed from: b, reason: collision with root package name */
    private static final File f369632b = new File("/");

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, a> f369633c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private a f369634d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    public static Uri a(Context context, String str, File file) {
        return b(context, str).a(file);
    }

    private static a b(Context context, String str) {
        a aVar;
        synchronized (f369633c) {
            aVar = f369633c.get(str);
            if (aVar == null) {
                try {
                    aVar = c(context, str);
                    f369633c.put(str, aVar);
                } catch (IOException e16) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e16);
                } catch (XmlPullParserException e17) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e17);
                }
            }
        }
        return aVar;
    }

    private static a c(Context context, String str) throws IOException, XmlPullParserException {
        b bVar = new b(str);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider != null) {
            XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = loadXmlMetaData.next();
                if (next != 1) {
                    if (next == 2) {
                        String name = loadXmlMetaData.getName();
                        File file = null;
                        String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                        String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            file = a(f369632b, attributeValue2);
                        } else if ("files-path".equals(name)) {
                            file = a(context.getFilesDir(), attributeValue2);
                        } else if ("cache-path".equals(name)) {
                            file = a(context.getCacheDir(), attributeValue2);
                        } else if ("external-path".equals(name)) {
                            if (context.getApplicationInfo().packageName.contains("com.tencent.mobileqq")) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(Environment.getExternalStorageDirectory());
                                String str2 = File.separator;
                                sb5.append(str2);
                                sb5.append("Android");
                                sb5.append(str2);
                                sb5.append("data");
                                sb5.append(str2);
                                sb5.append(context.getApplicationInfo().packageName);
                                file = a(new File(sb5.toString()), attributeValue2);
                            } else {
                                file = a(Environment.getExternalStorageDirectory(), attributeValue2);
                            }
                        }
                        if (file != null) {
                            bVar.a(attributeValue, file);
                        }
                    }
                } else {
                    return bVar;
                }
            }
        } else {
            throw new RuntimeException("Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                this.f369634d = b(context, providerInfo.authority);
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f369634d.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a16 = this.f369634d.a(uri);
        int lastIndexOf = a16.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a16.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
            return "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f369634d.a(uri), a(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        File a16 = this.f369634d.a(uri);
        if (strArr == null) {
            strArr = f369631a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i16 = 0;
        for (String str3 : strArr) {
            if (InputMethodUtil.SOUGOU_URI_DISPLAYNAME.equals(str3)) {
                strArr3[i16] = InputMethodUtil.SOUGOU_URI_DISPLAYNAME;
                i3 = i16 + 1;
                objArr[i16] = a16.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i16] = "_size";
                i3 = i16 + 1;
                objArr[i16] = Long.valueOf(a16.length());
            }
            i16 = i3;
        }
        String[] a17 = a(strArr3, i16);
        Object[] a18 = a(objArr, i16);
        MatrixCursor matrixCursor = new MatrixCursor(a17, 1);
        matrixCursor.addRow(a18);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    private static int a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final String f369635a;

        /* renamed from: b, reason: collision with root package name */
        private final HashMap<String, File> f369636b = new HashMap<>();

        public b(String str) {
            this.f369635a = str;
        }

        public void a(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f369636b.put(str, file.getCanonicalFile());
                    return;
                } catch (IOException e16) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e16);
                }
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // com.tencent.smtt.utils.FileProvider.a
        public Uri a(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f369636b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith("/")) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f369635a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.tencent.smtt.utils.FileProvider.a
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f369636b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] a(String[] strArr, int i3) {
        String[] strArr2 = new String[i3];
        System.arraycopy(strArr, 0, strArr2, 0, i3);
        return strArr2;
    }

    private static Object[] a(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        return objArr2;
    }

    static Uri a(Context context, File file) {
        String str;
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            str = context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "android.support.v4.content.FileProvider"), 0).authority;
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int i3 = android.support.v4.content.FileProvider.f26397d;
            Method declaredMethod = android.support.v4.content.FileProvider.class.getDeclaredMethod("getUriForFile", Context.class, String.class, File.class);
            if (declaredMethod == null) {
                return null;
            }
            Object invoke = declaredMethod.invoke(null, context, str, file);
            if (invoke instanceof Uri) {
                return (Uri) invoke;
            }
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static Uri a(Context context, String str) {
        Uri uri = null;
        if (context != null && context.getApplicationContext() != null && "com.tencent.mobileqq".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            try {
                Boolean bool = FileProvider7Helper.sIsTargetThanN;
                return (Uri) k.a((Class<?>) FileProvider7Helper.class, "getUriForFile", (Class<?>[]) new Class[]{Context.class, File.class}, context, new File(str));
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24 && (uri = a(context, new File(str))) == null && QbSdk.checkContentProviderPrivilage(context)) {
            uri = a(context, context.getApplicationInfo().packageName + ".provider", new File(str));
        }
        if (uri != null) {
            return uri;
        }
        try {
            return Uri.fromFile(new File(str));
        } catch (Exception e17) {
            e17.printStackTrace();
            Log.e("FileProvider", "create uri failed,please check again");
            return uri;
        }
    }
}
