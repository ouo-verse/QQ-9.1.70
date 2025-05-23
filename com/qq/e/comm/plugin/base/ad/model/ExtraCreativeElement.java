package com.qq.e.comm.plugin.base.ad.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.olympic2024.OlympicResDecryptionUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ExtraCreativeElement {

    /* renamed from: a, reason: collision with root package name */
    private int f38830a;

    /* renamed from: b, reason: collision with root package name */
    private a f38831b;

    /* renamed from: c, reason: collision with root package name */
    private List<b> f38832c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface CardAnimationType {
        public static final int CARD_ANIMATION_TYPE_TILT = 1;
        public static final int CARD_ANIMATION_TYPE_UNKNOWN = 0;
        public static final int CARD_ANIMATION_TYPE_VERTICAL = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface EncryptionType {
        public static final int ENCRYPTION_TYPE_AES_128_ECB = 1;
        public static final int ENCRYPTION_TYPE_BASE64 = 2;
        public static final int ENCRYPTION_TYPE_NONE = 3;
        public static final int ENCRYPTION_TYPE_UNKNOWN = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f38836a;

        /* renamed from: b, reason: collision with root package name */
        private String f38837b;

        /* renamed from: c, reason: collision with root package name */
        private String f38838c;

        /* renamed from: d, reason: collision with root package name */
        private String f38839d;

        /* renamed from: e, reason: collision with root package name */
        private String f38840e;

        /* renamed from: f, reason: collision with root package name */
        private String f38841f;

        /* renamed from: g, reason: collision with root package name */
        private volatile Bitmap f38842g;

        /* renamed from: h, reason: collision with root package name */
        private volatile String f38843h;

        public a(JSONObject jSONObject, boolean z16, String str, String str2) {
            this.f38836a = z16;
            this.f38837b = str;
            this.f38838c = str2;
            if (y.a(jSONObject)) {
                this.f38839d = y.e(jSONObject, "file_url");
                this.f38840e = y.e(jSONObject, "file_url_encrypted");
                this.f38841f = y.e(jSONObject, "encrypted_content_file_url");
            }
        }

        public Bitmap a() {
            return this.f38842g;
        }

        public String b() {
            return this.f38839d;
        }

        public String c() {
            return this.f38840e;
        }

        public String d() {
            return this.f38841f;
        }

        public String e() {
            return this.f38843h;
        }

        private File c(String str, int i3) {
            if (!TextUtils.isEmpty(this.f38841f)) {
                File a16 = com.qq.e.comm.plugin.k.k.a(this.f38836a ? 2 : 1, str, this.f38841f);
                String str2 = i3 == 1 ? "_decryptAES" : i3 == 2 ? "_decryptBASE64" : null;
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(a16.getAbsolutePath() + str2);
                    if (file.exists()) {
                        GDTLogger.i("decryptedFile exists:" + a16.getAbsolutePath() + str2);
                        return file;
                    }
                }
                if (a16.exists()) {
                    String absolutePath = a16.getAbsolutePath();
                    if (TextUtils.isEmpty(absolutePath)) {
                        GDTLogger.e(" getFileWithEncryptContent inputFilePath null");
                        return null;
                    }
                    if (i3 == 1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean decryptFileByAES = OlympicResDecryptionUtils.decryptFileByAES(absolutePath, absolutePath + "_decryptAES");
                        a(this.f38841f, i3, decryptFileByAES, currentTimeMillis, this.f38836a);
                        if (decryptFileByAES) {
                            return new File(absolutePath + "_decryptAES");
                        }
                    } else if (i3 == 2) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        boolean decryptFileByBase64 = OlympicResDecryptionUtils.decryptFileByBase64(absolutePath, absolutePath + "_decryptBASE64");
                        a(this.f38841f, i3, decryptFileByBase64, currentTimeMillis2, this.f38836a);
                        if (decryptFileByBase64) {
                            return new File(absolutePath + "_decryptBASE64");
                        }
                    }
                    GDTLogger.e("unknown encryptionType");
                    return null;
                }
            }
            GDTLogger.e("EncryptedContentFileUrl null");
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private File d(String str, int i3) {
            String str2;
            String decryptUrlByBase64;
            boolean z16;
            if (!TextUtils.isEmpty(this.f38840e)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (i3 == 1) {
                    decryptUrlByBase64 = OlympicResDecryptionUtils.decryptUrlByAES(this.f38840e);
                } else if (i3 == 2) {
                    decryptUrlByBase64 = OlympicResDecryptionUtils.decryptUrlByBase64(this.f38840e);
                } else {
                    str2 = null;
                    z16 = !TextUtils.isEmpty(str2);
                    a(this.f38840e, i3, z16, currentTimeMillis, this.f38836a);
                    if (z16) {
                        return com.qq.e.comm.plugin.k.k.a(this.f38836a ? 2 : 1, str, str2);
                    }
                }
                str2 = decryptUrlByBase64;
                z16 = !TextUtils.isEmpty(str2);
                a(this.f38840e, i3, z16, currentTimeMillis, this.f38836a);
                if (z16) {
                }
            }
            return null;
        }

        public void a(Bitmap bitmap) {
            this.f38842g = bitmap;
        }

        public String b(int i3) {
            if (!TextUtils.isEmpty(b())) {
                return b();
            }
            if (TextUtils.isEmpty(c())) {
                return null;
            }
            if (i3 == 1) {
                return OlympicResDecryptionUtils.decryptUrlByAES(c());
            }
            if (i3 == 2) {
                return OlympicResDecryptionUtils.decryptUrlByBase64(c());
            }
            return null;
        }

        public void a(String str) {
            this.f38839d = str;
        }

        public String a(int i3) {
            if (i3 != 1 && i3 != 2) {
                return b();
            }
            return d();
        }

        public File a(String str, int i3) {
            GDTLogger.d("tryGetRealFile :" + i3);
            File a16 = com.qq.e.comm.plugin.k.k.a(this.f38836a ? 2 : 1, str, this.f38839d);
            if (a16.exists()) {
                GDTLogger.i("get origin file :" + a16.getAbsolutePath());
                return a16;
            }
            File d16 = d(str, i3);
            if (d16 != null && d16.exists()) {
                GDTLogger.i("getFileWithEncryptUrl file :" + d16.getAbsolutePath());
                return d16;
            }
            return c(str, i3);
        }

        public Bitmap b(String str, int i3) {
            GDTLogger.d("tryGetBitmap :" + i3);
            File a16 = com.qq.e.comm.plugin.k.k.a(this.f38836a ? 2 : 1, str, this.f38839d);
            if (a16.exists()) {
                GDTLogger.i("get origin file :" + a16.getAbsolutePath());
                return com.qq.e.comm.plugin.k.h.a(a16, (ImageView) null);
            }
            File d16 = d(str, i3);
            if (d16 != null && d16.exists()) {
                GDTLogger.i("getFileWithEncryptUrl file :" + d16.getAbsolutePath());
                return com.qq.e.comm.plugin.k.h.a(d16, (ImageView) null);
            }
            File c16 = c(str, i3);
            if (c16 != null && c16.exists()) {
                GDTLogger.i("getFileWithEncryptContent file :" + c16.getAbsolutePath());
                return com.qq.e.comm.plugin.k.h.a(c16, (ImageView) null);
            }
            GDTLogger.e("getFileWithEncryptContent file not exist");
            return null;
        }

        private void a(String str, int i3, boolean z16, long j3, boolean z17) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - j3;
            GDTLogger.e("reportDecryptResult encryptionType:" + i3 + " decryptSuccess:" + z16 + " url:" + str + " costTime :" + currentTimeMillis);
            com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
            bVar.a(this.f38837b);
            bVar.b(this.f38838c);
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("encryptUrl", str);
            cVar.a("encryptionType", Integer.valueOf(i3));
            cVar.a("cost_time", Long.valueOf(currentTimeMillis));
            cVar.a("error_code", Integer.valueOf(z16 ? 1 : 0));
            cVar.a("res_type", Integer.valueOf(z17 ? 1 : 0));
            StatTracer.trackEvent(1310303, 0, bVar, cVar);
        }

        public boolean b(String str) {
            if (!TextUtils.isEmpty(this.f38839d)) {
                return com.qq.e.comm.plugin.k.k.a(this.f38836a ? 2 : 1, str, this.f38839d).exists();
            }
            if (TextUtils.isEmpty(this.f38841f)) {
                return false;
            }
            return com.qq.e.comm.plugin.k.k.a(this.f38836a ? 2 : 1, str, this.f38841f).exists();
        }

        public void c(String str) {
            this.f38843h = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private a f38844a;

        /* renamed from: b, reason: collision with root package name */
        private a f38845b;

        /* renamed from: c, reason: collision with root package name */
        private a[] f38846c;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f38847a;

            /* renamed from: b, reason: collision with root package name */
            private int f38848b;

            /* renamed from: c, reason: collision with root package name */
            private String f38849c;

            public a(JSONObject jSONObject) {
                if (y.a(jSONObject)) {
                    this.f38847a = y.e(jSONObject, "image_url");
                    this.f38848b = y.c(jSONObject, "position_type");
                }
            }

            public String a() {
                return this.f38847a;
            }

            public int b() {
                return this.f38848b;
            }

            public String c() {
                return this.f38849c;
            }

            public void a(String str) {
                this.f38849c = str;
            }
        }

        public b(JSONObject jSONObject, String str, String str2) {
            if (y.a(jSONObject)) {
                JSONObject g16 = y.g(jSONObject, "image");
                if (y.a(g16)) {
                    this.f38844a = new a(g16, false, str, str2);
                }
                JSONObject g17 = y.g(jSONObject, "video");
                if (y.a(g17)) {
                    this.f38845b = new a(g17, true, str, str2);
                }
                JSONObject g18 = y.g(jSONObject, DownloadInfo.spKey_Config);
                if (y.a(g18)) {
                    JSONArray f16 = y.f(g18, "broken_infos");
                    if (!y.a(f16)) {
                        int length = f16.length();
                        this.f38846c = new a[length];
                        for (int i3 = 0; i3 < length; i3++) {
                            this.f38846c[i3] = new a(y.a(f16, i3));
                        }
                    }
                }
            }
        }

        public a a() {
            return this.f38844a;
        }

        public a b() {
            return this.f38845b;
        }

        public a[] c() {
            return this.f38846c;
        }
    }

    public ExtraCreativeElement(JSONObject jSONObject, String str, String str2) {
        if (y.a(jSONObject)) {
            this.f38830a = y.c(jSONObject, "encryption_type");
            JSONObject g16 = y.g(jSONObject, "background_image");
            if (y.a(g16)) {
                this.f38831b = new a(g16, false, str, str2);
            }
            JSONArray f16 = y.f(jSONObject, "group_list");
            if (!y.a(f16)) {
                this.f38832c = new ArrayList();
                for (int i3 = 0; i3 < f16.length(); i3++) {
                    JSONObject a16 = y.a(f16, i3);
                    if (y.a(a16)) {
                        this.f38832c.add(new b(a16, str, str2));
                    }
                }
            }
        }
    }

    public int a() {
        return this.f38830a;
    }

    public List<b> b() {
        return this.f38832c;
    }

    public a c() {
        return this.f38831b;
    }

    public Bitmap d() {
        a c16 = c();
        if (c16 == null) {
            return null;
        }
        return c16.a();
    }

    public File a(String str) {
        a c16 = c();
        if (c16 == null) {
            return null;
        }
        return c16.a(str, a());
    }

    public boolean b(String str) {
        a a16;
        boolean z16 = false;
        if (com.qq.e.comm.plugin.k.g.b(this.f38832c)) {
            return false;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f38832c.size()) {
                break;
            }
            b bVar = this.f38832c.get(i3);
            if (bVar != null && (a16 = bVar.a()) != null && !a16.b(str)) {
                z16 = true;
                break;
            }
            i3++;
        }
        return !z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(final String str) {
        boolean z16;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            GDTLogger.e("can decrypt in main thread");
            return -100;
        }
        GDTLogger.i(" decryptAllSrc ");
        a aVar = this.f38831b;
        if (aVar != null) {
            Bitmap b16 = aVar.b(str, this.f38830a);
            this.f38831b.a(b16);
            if (b16 != null) {
                z16 = true;
                if (z16) {
                    return -101;
                }
                if (com.qq.e.comm.plugin.k.g.a(this.f38832c)) {
                    for (int i3 = 0; i3 < this.f38832c.size(); i3++) {
                        final b bVar = this.f38832c.get(i3);
                        if (bVar != null) {
                            if (bVar.a() != null) {
                                Bitmap b17 = bVar.a().b(str, this.f38830a);
                                if (b17 != null) {
                                    bVar.a().a(b17);
                                }
                                z16 = b17 != null;
                            }
                            if (bVar.b() != null) {
                                File a16 = bVar.b().a(str, this.f38830a);
                                bVar.b().c(a16 != null ? a16.getAbsolutePath() : "");
                            }
                            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.model.ExtraCreativeElement.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.a[] c16 = bVar.c();
                                    if (com.qq.e.comm.plugin.k.g.b(c16)) {
                                        return;
                                    }
                                    for (b.a aVar2 : c16) {
                                        if (aVar2 != null) {
                                            File a17 = com.qq.e.comm.plugin.k.k.a(1, str, aVar2.a());
                                            if (a17.exists()) {
                                                aVar2.a(a17.getAbsolutePath());
                                            }
                                        }
                                    }
                                }
                            });
                            if (!z16) {
                                return -102;
                            }
                        }
                    }
                }
                return 0;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
