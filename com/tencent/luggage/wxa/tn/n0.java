package com.tencent.luggage.wxa.tn;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.luggage.wxa.w9.a;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f141661a = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tn.n0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6772a extends b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.a f141662a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f141663b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f141664c;

            public C6772a(b.a aVar, String str, Context context) {
                this.f141662a = aVar;
                this.f141663b = str;
                this.f141664c = context;
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public boolean a() {
                return true;
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public void b(b.C6773b c6773b) {
                this.f141662a.b(c6773b);
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public void a(b.C6773b c6773b) {
                if (this.f141663b.contains("/" + this.f141664c.getPackageName() + "/")) {
                    b(new b.C6773b.a(this.f141663b));
                } else {
                    super.a(c6773b);
                    this.f141662a.a(c6773b);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b extends b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.a f141665a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f141666b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f141667c;

            public b(b.a aVar, String str, Context context) {
                this.f141665a = aVar;
                this.f141666b = str;
                this.f141667c = context;
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public boolean a() {
                return true;
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public void b(b.C6773b c6773b) {
                this.f141665a.b(c6773b);
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public void a(b.C6773b c6773b) {
                if (this.f141666b.contains("/" + this.f141667c.getPackageName() + "/")) {
                    b(new b.C6773b.a(this.f141666b));
                } else {
                    super.a(c6773b);
                    this.f141665a.a(c6773b);
                }
            }
        }

        public static void a(Context context, String str, b.a aVar) {
            b.b(context, str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new C6772a(aVar, str, context));
        }

        public static void b(Context context, String str, b.a aVar) {
            b.b(context, str, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new b(aVar, str, context));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static abstract class a {
            public boolean a() {
                return false;
            }

            public abstract void b(C6773b c6773b);

            public void a(C6773b c6773b) {
                if (c6773b != null) {
                    c6773b.a();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x022f  */
        /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void b(Context context, String str, Uri uri, a aVar) {
            Uri uri2;
            String str2;
            String str3;
            Uri uri3;
            int indexOf;
            int lastIndexOf;
            w.d("MicroMsg.ScopedStorageUtil", "#tryInsert with MediaStore: " + str);
            int i3 = Build.VERSION.SDK_INT;
            C6773b c6773b = null;
            if (i3 < 29) {
                w.f("MicroMsg.ScopedStorageUtil", "MediaStore SDK_INT not meet");
                aVar.a(null);
                return;
            }
            boolean z16 = true;
            if (x0.a() || x0.b()) {
                a.C6868a.C6869a.a("MediaStoreInsert", new Throwable(), (Map) null, uri.toString(), str);
            }
            if (MediaStore.Images.Media.EXTERNAL_CONTENT_URI.equals(uri)) {
                str2 = Environment.DIRECTORY_PICTURES;
            } else if (!MediaStore.Video.Media.EXTERNAL_CONTENT_URI.equals(uri)) {
                uri2 = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                str2 = uri2.equals(uri) ? Environment.DIRECTORY_DOWNLOADS : null;
            } else if (i3 > 29) {
                str2 = Environment.DIRECTORY_PICTURES;
            } else {
                str2 = Environment.DIRECTORY_DCIM;
            }
            if (TextUtils.isEmpty(str2)) {
                w.f("MicroMsg.ScopedStorageUtil", "MediaStore CONTENT_URI not meet: " + uri + ", dest=" + str);
                aVar.a(null);
                return;
            }
            String d16 = com.tencent.luggage.wxa.bo.e.d(str);
            String str4 = com.tencent.luggage.wxa.cp.x.j(str) + "." + com.tencent.luggage.wxa.cp.x.g(str);
            if (TextUtils.isEmpty(d16)) {
                w.f("MicroMsg.ScopedStorageUtil", "#getOutputStream unsupported media type, path = " + str);
                d16 = "application/octet-stream";
            }
            if (!str.contains(str2) || (indexOf = str.indexOf(str2) + str2.length()) >= (lastIndexOf = str.lastIndexOf(File.separator))) {
                str3 = null;
            } else {
                str3 = str2 + str.substring(indexOf, lastIndexOf);
            }
            if (TextUtils.isEmpty(str3)) {
                w.f("MicroMsg.ScopedStorageUtil", "MediaStore RELATIVE_PATH not meet");
                aVar.a(null);
                if (x0.a() || x0.b()) {
                    a.C6868a.C6869a.a("MediaStoreUnsupported", new Throwable(), (Map) null, uri.toString(), str);
                    if (x0.a()) {
                        throw new UnsupportedOperationException("MediaStore is unsupported for path: " + str);
                    }
                    return;
                }
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, d16);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str4);
            contentValues.put("relative_path", str3);
            if (aVar.a() && i3 >= 30) {
                contentValues.put("is_pending", (Integer) 1);
            }
            ContentResolver contentResolver = context.getContentResolver();
            try {
                uri3 = contentResolver.insert(uri, contentValues);
            } catch (Throwable th5) {
                w.a("MicroMsg.ScopedStorageUtil", th5, "MediaStore insert err", new Object[0]);
                uri3 = null;
            }
            if (uri3 == null) {
                w.f("MicroMsg.ScopedStorageUtil", "MediaStore insert fail: uri is null");
            } else {
                w.d("MicroMsg.ScopedStorageUtil", "MediaStore insert success: " + uri3);
                C6773b c6773b2 = new C6773b(contentResolver, uri3);
                aVar.b(c6773b2);
                if (n0.f141661a) {
                    String a16 = c6773b2.a(context);
                    if (!TextUtils.isEmpty(a16) && !a(str, a16)) {
                        w.d("MicroMsg.ScopedStorageUtil", "MediaStore Ops is COMPATIBLE: " + str);
                    } else {
                        w.f("MicroMsg.ScopedStorageUtil", "MediaStore RENAME dest path: " + a16);
                        a.C6868a.C6869a.a("MediaStoreMismatch", new Throwable(), (Map) null, str, a16, c.b(context), c.a(context), String.valueOf(c.a()));
                        c6773b = c6773b2;
                    }
                }
                c6773b = c6773b2;
                if (z16) {
                    w.f("MicroMsg.ScopedStorageUtil", "MediaStore insert fail: " + uri3);
                    aVar.a(c6773b);
                    return;
                }
                return;
            }
            z16 = false;
            if (z16) {
            }
        }

        public static boolean c(Uri uri) {
            return "com.google.android.apps.photos.content".equals(uri.getAuthority());
        }

        public static boolean d(Uri uri) {
            return "com.android.providers.media.documents".equals(uri.getAuthority());
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tn.n0$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6773b {

            /* renamed from: a, reason: collision with root package name */
            public final ContentResolver f141668a;

            /* renamed from: b, reason: collision with root package name */
            public final Uri f141669b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.tn.n0$b$b$a */
            /* loaded from: classes8.dex */
            public static class a extends C6773b {

                /* renamed from: c, reason: collision with root package name */
                public final String f141670c;

                public a(String str) {
                    super(null, null);
                    this.f141670c = str;
                }

                @Override // com.tencent.luggage.wxa.tn.n0.b.C6773b
                public String a(Context context) {
                    return this.f141670c;
                }

                @Override // com.tencent.luggage.wxa.tn.n0.b.C6773b
                public OutputStream b() {
                    try {
                        return com.tencent.luggage.wxa.cp.x.o(this.f141670c);
                    } catch (FileNotFoundException e16) {
                        w.f("MicroMsg.ScopedStorageUtil", "VFSFileOp openWrite fail: " + e16.getMessage());
                        return null;
                    }
                }

                @Override // com.tencent.luggage.wxa.tn.n0.b.C6773b
                public void a() {
                    com.tencent.luggage.wxa.cp.x.c(this.f141670c);
                }

                @Override // com.tencent.luggage.wxa.tn.n0.b.C6773b
                public void c() {
                }
            }

            public C6773b(ContentResolver contentResolver, Uri uri) {
                this.f141668a = contentResolver;
                this.f141669b = uri;
            }

            public String a(Context context) {
                String b16 = b.b(context, this.f141669b);
                w.d("MicroMsg.ScopedStorageUtil", "uri2path: " + this.f141669b + " >> " + b16);
                return b16;
            }

            public OutputStream b() {
                try {
                    return this.f141668a.openOutputStream(this.f141669b);
                } catch (FileNotFoundException e16) {
                    w.f("MicroMsg.ScopedStorageUtil", "MediaStore getOutputStream fail: " + e16.getMessage());
                    return null;
                }
            }

            public void c() {
                if (Build.VERSION.SDK_INT >= 30) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_pending", (Integer) 0);
                        this.f141668a.update(this.f141669b, contentValues, null);
                    } catch (Exception e16) {
                        w.f("MicroMsg.ScopedStorageUtil", "MediaStore update uri pending failed: " + e16.getMessage());
                    }
                }
            }

            public void a() {
                try {
                    w.f("MicroMsg.ScopedStorageUtil", "item should not be actively deleted");
                } catch (Throwable th5) {
                    w.f("MicroMsg.ScopedStorageUtil", "MediaStore delete fail: " + th5.getMessage());
                }
            }
        }

        public static boolean a(String str, String str2) {
            int indexOf;
            int i3;
            if (new File(str).equals(new File(str2))) {
                return false;
            }
            return !str.startsWith("/sdcard/") || (indexOf = str.indexOf("/sdcard/")) < 0 || (i3 = indexOf + 8) >= str.length() || !str2.endsWith(str.substring(i3));
        }

        public static boolean a(Uri uri) {
            return "com.android.providers.downloads.documents".equals(uri.getAuthority());
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00a5 A[Catch: all -> 0x0103, TryCatch #0 {all -> 0x0103, blocks: (B:3:0x0005, B:5:0x000f, B:8:0x0019, B:11:0x003d, B:13:0x0043, B:14:0x0057, B:16:0x005d, B:18:0x0070, B:19:0x008a, B:20:0x0098, B:22:0x00a5, B:24:0x00ab, B:26:0x00b0, B:29:0x00c2, B:38:0x00df, B:40:0x00e3, B:45:0x00f0, B:48:0x00ed, B:49:0x00f1, B:51:0x00fe, B:53:0x0073, B:55:0x007c, B:56:0x007f, B:58:0x0088, B:32:0x00c6, B:34:0x00d0, B:36:0x00da, B:44:0x00e8), top: B:2:0x0005, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f1 A[Catch: all -> 0x0103, TryCatch #0 {all -> 0x0103, blocks: (B:3:0x0005, B:5:0x000f, B:8:0x0019, B:11:0x003d, B:13:0x0043, B:14:0x0057, B:16:0x005d, B:18:0x0070, B:19:0x008a, B:20:0x0098, B:22:0x00a5, B:24:0x00ab, B:26:0x00b0, B:29:0x00c2, B:38:0x00df, B:40:0x00e3, B:45:0x00f0, B:48:0x00ed, B:49:0x00f1, B:51:0x00fe, B:53:0x0073, B:55:0x007c, B:56:0x007f, B:58:0x0088, B:32:0x00c6, B:34:0x00d0, B:36:0x00da, B:44:0x00e8), top: B:2:0x0005, inners: #1, #2 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String b(Context context, Uri uri) {
            String str;
            String[] strArr;
            try {
            } catch (Throwable th5) {
                w.a("MicroMsg.ScopedStorageUtil", th5, "convert uri 2 path fail", new Object[0]);
            }
            if (DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
                if (b(uri)) {
                    return Environment.getExternalStorageDirectory() + "/" + DocumentsContract.getDocumentId(uri).split(":")[1];
                }
                if (a(uri)) {
                    uri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri)));
                } else if (d(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = split[0];
                    if ("image".equals(str2)) {
                        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    strArr = new String[]{split[1]};
                    str = "_id=?";
                    if (!"content".equalsIgnoreCase(uri.getScheme())) {
                        if (c(uri)) {
                            return uri.getLastPathSegment();
                        }
                        Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, str, strArr, null);
                        if (query == null) {
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        }
                        try {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                            if (query.moveToFirst()) {
                                String string = query.getString(columnIndexOrThrow);
                                if (!TextUtils.isEmpty(string)) {
                                    v0.f141726a.a(uri, string);
                                }
                                query.close();
                                return string;
                            }
                            query.close();
                        } finally {
                        }
                    } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                        return uri.getPath();
                    }
                    return null;
                }
            }
            str = null;
            strArr = null;
            if (!"content".equalsIgnoreCase(uri.getScheme())) {
            }
            return null;
        }

        public static boolean b(Uri uri) {
            return "com.android.externalstorage.documents".equals(uri.getAuthority());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public static int a() {
            return Process.myUserHandle().hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String b(Context context) {
            int i3;
            UserManager userManager;
            int a16 = a();
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(a16));
            try {
                userManager = (UserManager) context.getSystemService(QCircleAlphaUserReporter.KEY_USER);
            } catch (Throwable unused) {
            }
            if (userManager != null) {
                for (UserHandle userHandle : userManager.getUserProfiles()) {
                    if (!arrayList.contains(Integer.valueOf(userHandle.hashCode()))) {
                        arrayList.add(Integer.valueOf(userHandle.hashCode()));
                    }
                }
                i3 = userManager.isSystemUser();
                String str = "";
                for (Integer num : arrayList) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + "|";
                    }
                    str = str + num;
                }
                return str + " sys(" + i3 + ")";
            }
            i3 = -1;
            String str2 = "";
            while (r0.hasNext()) {
            }
            return str2 + " sys(" + i3 + ")";
        }

        public static String a(Context context) {
            List<ComponentName> activeAdmins;
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
                if (devicePolicyManager == null || (activeAdmins = devicePolicyManager.getActiveAdmins()) == null) {
                    return "host";
                }
                Iterator<ComponentName> it = activeAdmins.iterator();
                while (it.hasNext()) {
                    if (devicePolicyManager.isProfileOwnerApp(it.next().getPackageName())) {
                        return WidgetCacheConstellationData.WORK;
                    }
                }
                return "host";
            } catch (Exception unused) {
                return "host";
            }
        }
    }
}
