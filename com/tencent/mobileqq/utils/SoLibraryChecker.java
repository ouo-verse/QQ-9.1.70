package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SoLibraryChecker {

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Boolean> f307338f = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private Context f307339a;

    /* renamed from: b, reason: collision with root package name */
    private String f307340b;

    /* renamed from: c, reason: collision with root package name */
    private String f307341c;

    /* renamed from: d, reason: collision with root package name */
    int f307342d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f307343e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements com.tencent.biz.common.offline.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f307348a;

        b(long j3) {
            this.f307348a = j3;
        }

        @Override // com.tencent.biz.common.offline.b
        public void loaded(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + i3 + ", time:" + (System.currentTimeMillis() - this.f307348a));
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + str);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.biz.common.offline.c.c(SoLibraryChecker.this.f307340b));
            sb5.append(SoLibraryChecker.this.f307340b);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(SoLibraryChecker.this.f307341c);
            String sb6 = sb5.toString();
            if (!new File(sb6).exists()) {
                if (QLog.isColorLevel()) {
                    QLog.e("SoLibraryLoader", 2, "file not exist! path = " + sb6);
                    return;
                }
                return;
            }
            FileUtils.copyFile(sb6, SoLibraryChecker.this.f307339a.getFilesDir().getAbsolutePath() + str2 + SoLibraryChecker.this.f307341c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f307350a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f307351b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f307352c;

        c(String str, boolean z16, boolean z17) {
            this.f307350a = str;
            this.f307351b = z16;
            this.f307352c = z17;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            if (QLog.isColorLevel()) {
                QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + gVar.f313011i + " code = " + gVar.f313006d);
            }
            boolean o16 = SoLibraryChecker.this.o(this.f307350a, this.f307351b, this.f307352c);
            if (QLog.isColorLevel()) {
                QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + o16);
            }
            SoLibraryChecker.this.p();
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(com.tencent.mobileqq.vip.g gVar) {
            int i3 = (int) (gVar.f313015m * 100.0f);
            if ((i3 % 10 == 0 || i3 > 90) && QLog.isColorLevel()) {
                QLog.d("SoLibraryLoader", 2, "downding progress = " + i3);
            }
        }
    }

    public SoLibraryChecker(Context context, String str, String str2, String str3) {
        this.f307339a = context.getApplicationContext();
        this.f307340b = str;
        this.f307341c = str2;
        this.f307343e = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        boolean z16;
        this.f307342d = 0;
        HtmlOffline.D();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null && qQAppInterface.getLongAccountUin() % 10 == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        HtmlOffline.f78406i = z16;
        String z17 = HtmlOffline.z(this.f307340b);
        if (QLog.isColorLevel()) {
            QLog.d("SoLibraryLoader", 2, "checkSoUpdate version = " + z17);
        }
        if (!new File(com.tencent.biz.common.offline.c.c(this.f307340b) + this.f307340b + "/" + this.f307341c).exists() && !TextUtils.isEmpty(z17) && !"0".equals(z17)) {
            FileUtils.deleteDirectory(com.tencent.biz.common.offline.c.c(this.f307340b) + this.f307340b);
        }
        if (qQAppInterface == null) {
            return;
        }
        HtmlOffline.f(this.f307340b, qQAppInterface, new a(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(final JSONObject jSONObject) {
        final String str;
        boolean z16;
        boolean z17;
        int optInt = jSONObject.optInt("code");
        String d16 = com.tencent.biz.common.offline.c.d(this.f307340b);
        if (!TextUtils.isEmpty(d16)) {
            z17 = true;
            if (optInt == 4) {
                str = d16 + this.f307340b + ".7z";
                z16 = true;
                z17 = false;
            } else if (optInt != 3 && optInt != 2) {
                QLog.e("SoLibraryLoader", 1, "do not know what format, use default zip name!");
                str = d16 + this.f307340b + ".zip";
            } else {
                str = d16 + this.f307340b + ".zip";
                z16 = false;
            }
            final c cVar = new c(str, z17, z16);
            if (TextUtils.isEmpty(str)) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.SoLibraryChecker.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String optString = jSONObject.optString("url");
                        File file = new File(str);
                        Bundle bundle = new Bundle();
                        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(optString, file);
                        gVar.f313008f = 3;
                        SoLibraryChecker.this.l().startDownload(gVar, cVar, bundle);
                        if (QLog.isColorLevel()) {
                            QLog.d("SoLibraryLoader", 2, "start Download url = " + optString);
                        }
                    }
                }, 8, null, false);
                return;
            }
            return;
        }
        str = null;
        z16 = false;
        z17 = false;
        final com.tencent.mobileqq.vip.f cVar2 = new c(str, z17, z16);
        if (TextUtils.isEmpty(str)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.vip.h l() {
        return ((DownloaderFactory) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
    }

    public static String m(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + str;
    }

    public static boolean n(Context context, String str) {
        if (new File(context.getFilesDir().getAbsolutePath() + File.separator + str).exists()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean o(String str, boolean z16, boolean z17) {
        int lzmaDecode;
        int i3;
        String str2 = this.f307340b;
        boolean z18 = false;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(com.tencent.biz.common.offline.c.d(str2))) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.i("SoLibraryLoader", 2, "doUnzipZip: no zip ! : businessId:" + str2);
            }
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(file.getParent());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str2);
        String sb6 = sb5.toString();
        String c16 = BidDownloader.c(str);
        if (QLog.isColorLevel()) {
            QLog.i("SoLibraryLoader", 2, "fileFormat: " + c16 + ", path: " + str);
        }
        if (!TextUtils.isEmpty(c16)) {
            if (c16.equals("zip")) {
                lzmaDecode = ZipUtils.unZipFolder(str, sb6);
            } else {
                if (c16.equals("7z")) {
                    lzmaDecode = LzmaUtils.lzmaDecode(BaseApplicationImpl.getApplication().getApplicationContext(), str, sb6);
                }
                i3 = 1;
            }
            i3 = lzmaDecode;
        } else {
            QLog.w("SoLibraryLoader", 1, "can not recognize download compress file format, " + str);
            if (z16) {
                lzmaDecode = ZipUtils.unZipFolder(str, sb6);
            } else {
                if (z17) {
                    lzmaDecode = LzmaUtils.lzmaDecode(BaseApplicationImpl.getApplication().getApplicationContext(), str, sb6);
                }
                i3 = 1;
            }
            i3 = lzmaDecode;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SoLibraryLoader", 2, "now delete original download offline zip, path: " + str);
        }
        com.tencent.biz.common.util.k.c(str);
        if (i3 > 0) {
            HtmlOffline.J(str2, 13, 0L, i3, "lixian_update", "0");
            if (QLog.isColorLevel()) {
                QLog.i("SoLibraryLoader", 2, "unZipFolder fail!");
            }
        } else {
            String str4 = sb6 + str3 + str2 + ".zip";
            File file2 = new File(str4);
            String str5 = file.getParent() + str3 + str2 + ".zip";
            if (QLog.isColorLevel()) {
                QLog.i("SoLibraryLoader", 2, "now move zip file to location: " + str5);
            }
            if (file2.exists()) {
                boolean renameTo = file2.renameTo(new File(str5));
                z18 = !renameTo ? FileUtils.moveFile(str4, str5) : renameTo;
            }
        }
        com.tencent.biz.common.util.k.b(sb6);
        if (QLog.isColorLevel()) {
            QLog.i("SoLibraryLoader", 2, "time of unzip zip\uff1a" + (System.currentTimeMillis() - currentTimeMillis) + ", isSuccess: " + z18);
        }
        return z18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (!HtmlOffline.N(BaseApplication.getContext(), "https://" + this.f307341c + "?_bid=" + this.f307340b, new b(System.currentTimeMillis())) && QLog.isColorLevel()) {
            QLog.i("SoLibraryLoader", 2, "so file = " + this.f307341c + " transToLocalUrl: return false");
        }
    }

    public void k() {
        if (!f307338f.containsKey(this.f307340b)) {
            f307338f.put(this.f307340b, Boolean.FALSE);
        }
        if (!n(this.f307339a, this.f307341c) || !f307338f.get(this.f307340b).booleanValue()) {
            i();
            f307338f.put(this.f307340b, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + str + " code = " + i3);
            }
            if (i3 == 0) {
                try {
                    JSONObject optJSONObject = new JSONObject(str).optJSONArray("data").optJSONObject(0);
                    String optString = optJSONObject.optString("url");
                    int optInt = optJSONObject.optInt(MediaDBValues.FILESIZE);
                    if (optString != null && optString.endsWith("patch")) {
                        FileUtils.deleteDirectory(com.tencent.biz.common.offline.c.c(SoLibraryChecker.this.f307340b) + SoLibraryChecker.this.f307340b);
                        SoLibraryChecker.this.i();
                        return;
                    }
                    if (!TextUtils.isEmpty(optString) && optInt != 0) {
                        SoLibraryChecker.this.j(optJSONObject);
                        return;
                    } else {
                        if (!SoLibraryChecker.n(SoLibraryChecker.this.f307339a, SoLibraryChecker.this.f307341c)) {
                            SoLibraryChecker.this.p();
                            return;
                        }
                        return;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (!SoLibraryChecker.n(SoLibraryChecker.this.f307339a, SoLibraryChecker.this.f307341c)) {
                        SoLibraryChecker.this.p();
                        return;
                    }
                    return;
                }
            }
            if (!SoLibraryChecker.n(SoLibraryChecker.this.f307339a, SoLibraryChecker.this.f307341c)) {
                SoLibraryChecker.this.p();
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
