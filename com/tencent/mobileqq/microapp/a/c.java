package com.tencent.mobileqq.microapp.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f245820a;

    /* renamed from: b, reason: collision with root package name */
    public g f245821b;

    /* renamed from: c, reason: collision with root package name */
    public String f245822c;

    /* renamed from: d, reason: collision with root package name */
    public String f245823d;

    /* renamed from: e, reason: collision with root package name */
    public String f245824e;

    /* renamed from: f, reason: collision with root package name */
    public MiniAppConfig f245825f;

    /* renamed from: g, reason: collision with root package name */
    public String f245826g;

    /* renamed from: h, reason: collision with root package name */
    public String f245827h;

    /* renamed from: i, reason: collision with root package name */
    private String f245828i;

    /* renamed from: j, reason: collision with root package name */
    private Map f245829j;

    /* renamed from: k, reason: collision with root package name */
    private int f245830k;

    /* renamed from: l, reason: collision with root package name */
    private float f245831l;

    /* renamed from: m, reason: collision with root package name */
    private byte f245832m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f245833a;

        /* renamed from: b, reason: collision with root package name */
        int f245834b;

        /* renamed from: c, reason: collision with root package name */
        int f245835c;

        public a(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f245833a = str;
            this.f245834b = i3;
            this.f245835c = i16;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "WxapkgFile{name='" + this.f245833a + "', start=" + this.f245834b + ", length=" + this.f245835c + '}';
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    public static synchronized boolean a(String str, String str2) {
        boolean a16;
        synchronized (c.class) {
            a16 = a(str, str2, "");
        }
        return a16;
    }

    public static boolean b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                str2 = new File(str2).getAbsolutePath() + "Tmp";
            } else {
                str3 = new File(str3).getAbsolutePath();
            }
            RandomAccessFile randomAccessFile = null;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    if (randomAccessFile2.readByte() == -66) {
                        randomAccessFile2.seek(14L);
                        int readInt = randomAccessFile2.readInt();
                        ArrayList arrayList = new ArrayList(readInt);
                        for (int i3 = 0; i3 < readInt; i3++) {
                            int readInt2 = randomAccessFile2.readInt();
                            byte[] bArr = new byte[readInt2];
                            randomAccessFile2.read(bArr, 0, readInt2);
                            String absolutePath = new File(new String(bArr, 0, readInt2)).getAbsolutePath();
                            if (!TextUtils.isEmpty(str3)) {
                                if (!absolutePath.startsWith(str3)) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused) {
                                    }
                                    return false;
                                }
                                absolutePath = absolutePath.replaceFirst(str3, str3 + "Tmp");
                            }
                            arrayList.add(new a(absolutePath, randomAccessFile2.readInt(), randomAccessFile2.readInt()));
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            File file = new File(str2, aVar.f245833a);
                            randomAccessFile2.seek(aVar.f245834b);
                            int i16 = aVar.f245835c;
                            byte[] bArr2 = new byte[i16];
                            randomAccessFile2.read(bArr2, 0, i16);
                            a(file, bArr2);
                        }
                        try {
                            randomAccessFile2.close();
                            return true;
                        } catch (Exception unused2) {
                            return true;
                        }
                    }
                    throw new RuntimeException("File type error");
                } catch (Exception unused3) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return false;
    }

    private static boolean c(String str, String str2, String str3) {
        if (!new File(str).exists()) {
            return false;
        }
        String absolutePath = new File(str2, str3).getAbsolutePath();
        String str4 = absolutePath + "Tmp";
        a(str4, false);
        if (!b(str, str2, str3)) {
            return false;
        }
        File file = new File(str4);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(absolutePath);
        a(absolutePath, false);
        return a(file, file2) && file2.exists();
    }

    public static String l(String str) {
        String path = Uri.parse("file:///" + str).getPath();
        if (path != null && path.startsWith("/")) {
            path = path.substring(1);
        }
        if (path != null) {
            return path;
        }
        return "";
    }

    public static Map m(String str) {
        HashMap hashMap = new HashMap();
        Uri parse = Uri.parse("file:///" + str);
        for (String str2 : parse.getQueryParameterNames()) {
            hashMap.put(str2, parse.getQueryParameter(str2));
        }
        return hashMap;
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static int[] o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] iArr = new int[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            try {
                iArr[i3] = Integer.parseInt(split[i3]);
            } catch (NumberFormatException unused) {
            }
        }
        return iArr;
    }

    public static int p(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.length() == 7) {
            str = "#FF" + str.substring(1);
        }
        return Color.parseColor(str);
    }

    public static Bitmap q(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
            } catch (FileNotFoundException unused) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused2) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                bufferedInputStream = null;
            }
        } catch (FileNotFoundException unused3) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (OutOfMemoryError unused4) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            fileInputStream = null;
            th5 = th7;
            bufferedInputStream = null;
        }
        try {
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            fileInputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException unused5) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bitmap;
        } catch (OutOfMemoryError unused6) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bitmap;
        } catch (Throwable th8) {
            th5 = th8;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                    throw th5;
                }
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th5;
        }
        return bitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087 A[Catch: IOException -> 0x008b, TRY_ENTER, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[Catch: IOException -> 0x008b, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070 A[Catch: IOException -> 0x008b, TRY_ENTER, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[Catch: IOException -> 0x008b, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteArrayInputStream r(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? file = new File(str);
        ?? exists = file.exists();
        try {
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    exists = new FileInputStream((File) file);
                    try {
                        file = new BufferedInputStream(exists, 8192);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        file = 0;
                        exists = exists;
                        byteArrayOutputStream2 = file;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (file != 0) {
                        }
                        if (exists != 0) {
                        }
                        return null;
                    } catch (IOException e17) {
                        e = e17;
                        file = 0;
                        exists = exists;
                        byteArrayOutputStream2 = file;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (file != 0) {
                        }
                        if (exists != 0) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        byteArrayOutputStream = null;
                        th = th5;
                        file = 0;
                    }
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        byteArrayOutputStream2 = null;
                    } catch (IOException e19) {
                        e = e19;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th6) {
                        byteArrayOutputStream = null;
                        th = th6;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                throw th;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = file.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                        try {
                            byteArrayOutputStream2.close();
                            file.close();
                            exists.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                        return byteArrayInputStream;
                    } catch (FileNotFoundException e28) {
                        e = e28;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        return null;
                    } catch (IOException e29) {
                        e = e29;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException e36) {
                    e = e36;
                    exists = 0;
                    file = 0;
                } catch (IOException e37) {
                    e = e37;
                    exists = 0;
                    file = 0;
                } catch (Throwable th7) {
                    file = 0;
                    byteArrayOutputStream = null;
                    th = th7;
                    exists = 0;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (IOException e38) {
            e38.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #7 {IOException -> 0x00c9, blocks: (B:77:0x00c5, B:70:0x00cd), top: B:76:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteArrayInputStream s(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Bitmap copy;
        int length;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(new File(str));
                    try {
                        byte[] bArr = new byte[4096];
                        byte[] bArr2 = null;
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            if (bArr2 == null) {
                                length = 0;
                            } else {
                                length = bArr2.length;
                            }
                            byte[] bArr3 = new byte[length + read];
                            if (bArr2 != null) {
                                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                                System.arraycopy(bArr, 0, bArr3, bArr2.length, read);
                            } else {
                                System.arraycopy(bArr, 0, bArr3, 0, read);
                            }
                            bArr2 = bArr3;
                        }
                        copy = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length).copy(Bitmap.Config.ARGB_8888, true);
                        copy.setHasAlpha(true);
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        byteArrayOutputStream2 = null;
                    } catch (IOException e17) {
                        e = e17;
                        byteArrayOutputStream2 = null;
                    } catch (OutOfMemoryError unused) {
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream = null;
                        th = th;
                        if (byteArrayOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                    fileInputStream = null;
                    byteArrayOutputStream2 = null;
                } catch (IOException e19) {
                    e = e19;
                    fileInputStream = null;
                    byteArrayOutputStream2 = null;
                } catch (OutOfMemoryError unused2) {
                    fileInputStream = null;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    byteArrayOutputStream = null;
                }
                try {
                    copy.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                    try {
                        byteArrayOutputStream2.close();
                        fileInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    return byteArrayInputStream;
                } catch (FileNotFoundException e27) {
                    e = e27;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (IOException e28) {
                    e = e28;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (OutOfMemoryError unused3) {
                    if (QLog.isColorLevel()) {
                        QLog.w("ImageUtil", 2, "---get image out of memory");
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th7) {
                th = th7;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e36) {
                        e36.printStackTrace();
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e37) {
            e37.printStackTrace();
        }
    }

    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f245821b.a(str) : (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    public String e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return this.f245828i + "/app-service.js";
        }
        return new File(new File(this.f245828i, str), "app-service.js").getAbsolutePath();
    }

    public String f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? a(new File(e(str))) : (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
    }

    public String g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        String a16 = this.f245821b.a(str);
        if (TextUtils.isEmpty(a16)) {
            return "";
        }
        File file = new File(new File(this.f245828i, a16), "page-frame.js");
        return file.exists() ? a(file) : "";
    }

    public boolean h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        String n3 = n(str);
        k kVar = this.f245821b.f246136h;
        if (kVar == null) {
            return false;
        }
        Iterator it = kVar.f245869f.iterator();
        while (it.hasNext()) {
            if (((k.a) it.next()).f245870a.equals(n3)) {
                return true;
            }
        }
        return false;
    }

    public boolean i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String n3 = n(str);
        return h(n3) || n3.equals(this.f245821b.f246134f);
    }

    public String j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(this.f245828i, str).getAbsolutePath();
    }

    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? !TextUtils.isEmpty(str) && new File(j(n(str))).exists() : ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).booleanValue();
    }

    public static synchronized boolean a(String str, String str2, String str3) {
        synchronized (c.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (new File(str2, str3).exists()) {
                    return true;
                }
                return c(str, str2, str3);
            }
            return false;
        }
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        File file = new File(new File(this.f245828i), "app-wxss.js");
        return file.exists() ? a(file) : "";
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? com.tencent.mobileqq.microapp.apkg.g.a().c() : (String) iPatchRedirector.redirect((short) 13, (Object) this);
    }

    public float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? this.f245831l : ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
    }

    public byte i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.f245832m : ((Byte) iPatchRedirector.redirect((short) 22, (Object) this)).byteValue();
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? this.f245830k : ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? com.tencent.mobileqq.microapp.apkg.g.a().b() : (String) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.f245821b.f246133e : ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
    }

    private static void a(File file, byte[] bArr) throws IOException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new RuntimeException("Create folder fail:" + file.getParentFile().getAbsolutePath());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
        } finally {
            fileOutputStream.close();
        }
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? com.tencent.mobileqq.microapp.apkg.g.a().d() : (String) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public void a(MiniAppConfig miniAppConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppConfig);
            return;
        }
        int i3 = this.f245825f.config.mini_version;
        this.f245825f = miniAppConfig;
        miniAppConfig.config.mini_version = i3;
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        String d16 = d(str);
        if (TextUtils.isEmpty(d16)) {
            return true;
        }
        String absolutePath = new File(com.tencent.mobileqq.microapp.apkg.g.a(this.f245825f.config), d16).getAbsolutePath();
        boolean exists = new File(absolutePath).exists();
        if (QLog.isColorLevel()) {
            QLog.d("ApkgInfo", 1, "isUrlResReady | subFolderPath :" + absolutePath + "isExist:" + exists);
        }
        return exists;
    }

    public static String a(String str) {
        if (str == null) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f245828i + "/app-service.js";
    }

    public void a(String str, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            com.tencent.mobileqq.microapp.apkg.g.a().a(this, str, aVar);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) aVar);
        }
    }

    public f c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        File file = new File(this.f245828i, "page-frame.html");
        f fVar = new f();
        if (!file.exists()) {
            fVar.f245852a = b();
            return fVar;
        }
        String a16 = a(file);
        String substring = a16.substring(a16.indexOf("<script>") + 8, a16.indexOf("</script>"));
        fVar.f245852a = a16.replace(substring, "");
        fVar.f245853b = substring;
        return fVar;
    }

    public static boolean a(c cVar) {
        MiniAppConfig miniAppConfig;
        if (cVar == null || (miniAppConfig = cVar.f245825f) == null) {
            return false;
        }
        return miniAppConfig.isInnerUser();
    }

    public static void a(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                Map map2 = (Map) value;
                a(map2);
                map.put(key, new JSONObject(map2));
            }
        }
    }

    public static void a(WebView webView, String str) {
        String str2;
        try {
            str2 = b(new File(str));
        } catch (IOException e16) {
            e16.printStackTrace();
            str2 = null;
        }
        webView.evaluateJavascript(str2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
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
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                String str2 = new String(bArr, "utf8");
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                return str2;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            return null;
        }
    }

    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a16 = a(str);
        String str2 = (String) this.f245829j.get(a16);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            String b16 = b(new File(this.f245828i, a16));
            str2 = b16.substring(b16.indexOf("<script>") + 8, b16.indexOf("</script>"));
            this.f245829j.put(a16, str2);
            return str2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return str2;
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? com.tencent.mobileqq.microapp.apkg.g.a().e() : (String) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static void a(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.overridePendingTransition(R.anim.b, R.anim.c);
    }

    public static String b(String str, String str2) {
        String str3 = "";
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            int size = parse.size();
            for (int i3 = 0; i3 < size; i3++) {
                NameValuePair nameValuePair = parse.get(i3);
                if (nameValuePair.getName().equals(str2)) {
                    str3 = nameValuePair.getValue();
                }
            }
        } catch (URISyntaxException e16) {
            e16.printStackTrace();
        }
        return str3;
    }

    public static JSONObject a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return jSONObject == null ? new JSONObject() : jSONObject;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        jSONObject.put("errMsg", str + ":ok");
        return jSONObject;
    }

    public static JSONObject a(String str, JSONObject jSONObject, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return jSONObject == null ? new JSONObject() : jSONObject;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(":fail");
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " " + str2;
        }
        sb5.append(str3);
        jSONObject.put("errMsg", sb5.toString());
        return jSONObject;
    }

    public static void b(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(R.anim.a, R.anim.d);
        }
    }

    public static JSONObject b(String str, JSONObject jSONObject) {
        return a(str, jSONObject, (String) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        if (r2 == null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(File file) throws IOException {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        String str = null;
        if (file == null) {
            return null;
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                        } catch (Exception unused) {
                            inputStreamReader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = null;
                        }
                        try {
                            int length = (int) file.length();
                            if (length > 12288) {
                                char[] cArr = new char[4096];
                                StringBuilder sb5 = new StringBuilder(12288);
                                while (true) {
                                    int read = inputStreamReader.read(cArr);
                                    if (-1 == read) {
                                        break;
                                    }
                                    sb5.append(cArr, 0, read);
                                }
                                str = sb5.toString();
                            } else {
                                char[] cArr2 = new char[length];
                                str = new String(cArr2, 0, inputStreamReader.read(cArr2));
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused7) {
                        fileInputStream = null;
                        inputStreamReader = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader = null;
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused8) {
                        return str;
                    }
                } else {
                    throw new IOException("File '" + file + "' cannot be read");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static JSONObject a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th5) {
            QLog.e("JSONUtil", 1, th5, new Object[0]);
        }
        return jSONObject;
    }

    public static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        JSONArray jSONArray3 = new JSONArray();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            jSONArray3.mo162put(jSONArray.get(i3));
        }
        for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
            jSONArray3.mo162put(jSONArray2.get(i16));
        }
        return jSONArray3;
    }

    public static void a(String str, boolean z16) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                a(file2.getAbsolutePath(), z16);
            }
            if (z16) {
                return;
            }
            file.delete();
        }
    }

    public static boolean a(File file, File file2) {
        boolean delete = file2.exists() ? file2.delete() : true;
        return delete ? file.renameTo(file2) : delete;
    }

    public static String a(File file) {
        try {
            return b(file);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static void a(String str, com.tencent.mobileqq.microapp.widget.media.c cVar) {
        new com.tencent.mobileqq.microapp.widget.media.b(cVar).execute(str);
    }
}
