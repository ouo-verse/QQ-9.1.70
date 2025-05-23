package com.tencent.mobileqq.richstatus;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashSet<String> f282309a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC8524b f282310b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f282311c;

    /* renamed from: d, reason: collision with root package name */
    private String f282312d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends AsyncTask<Void, Bitmap, Bitmap> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f282313a;

        /* renamed from: b, reason: collision with root package name */
        private String f282314b;

        /* renamed from: c, reason: collision with root package name */
        private String f282315c;

        public a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, str2, str3);
                return;
            }
            this.f282313a = str;
            this.f282314b = str2;
            this.f282315c = str3;
        }

        private Bitmap a(File file) {
            Bitmap bitmap = null;
            if (file.exists()) {
                try {
                    bitmap = SafeBitmapFactory.decodeFile(file.getAbsolutePath());
                    if (bitmap == null) {
                        file.delete();
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            File j3 = b.j();
            Bitmap bitmap = null;
            if (j3 != null) {
                File file = new File(j3, this.f282313a);
                boolean z16 = true;
                if (!file.exists()) {
                    if (!TextUtils.isEmpty(this.f282314b) && (a16 = a(new File(j3, this.f282314b))) != null) {
                        publishProgress(a16);
                    }
                    if (this.f282315c != null) {
                        if (b.this.f282311c > 3 && Math.abs(SystemClock.uptimeMillis() - b.this.f282311c) > 60000) {
                            b.this.f282311c = 0L;
                        }
                        if (b.this.f282311c < 3) {
                            z16 = b.this.h(this.f282315c, file);
                        }
                    }
                }
                if (z16) {
                    bitmap = a(file);
                }
                if (z16 && bitmap != null) {
                    b.this.f282311c = 0L;
                } else if (!TextUtils.isEmpty(this.f282315c)) {
                    b bVar = b.this;
                    long j16 = bVar.f282311c + 1;
                    bVar.f282311c = j16;
                    if (j16 == 3) {
                        b.this.f282311c = SystemClock.uptimeMillis();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.img", 2, "decodeBitmap finish with " + bitmap + ", " + b.this.f282311c);
            }
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
                return;
            }
            if (bitmap != null) {
                ImageCacheHelper.f98636a.i(b.this.f282312d + this.f282313a, bitmap, Business.Conversation);
            }
            b.this.f282309a.remove(this.f282313a);
            if (b.this.f282310b != null) {
                b.this.f282310b.a(this.f282313a, this.f282315c, bitmap, 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Bitmap... bitmapArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmapArr);
                return;
            }
            Bitmap bitmap = bitmapArr[0];
            ImageCacheHelper.f98636a.i(b.this.f282312d + this.f282314b, bitmap, Business.Conversation);
            if (b.this.f282310b != null) {
                b.this.f282310b.a(this.f282313a, this.f282315c, bitmap, 0);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richstatus.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8524b {
        void a(String str, String str2, Bitmap bitmap, int i3);
    }

    public b(String str, InterfaceC8524b interfaceC8524b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) interfaceC8524b);
        } else {
            this.f282310b = interfaceC8524b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(String str, File file) {
        boolean z16;
        int downloadData = HttpDownloadUtil.downloadData((AppRuntime) null, str, file);
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.img", 2, "download " + str + "result " + downloadData);
        }
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("result", String.valueOf(downloadData));
        hashMap.put("url", str);
        if (downloadData == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance("", "RichStatusIcon", z16, 0L, 0L, hashMap, "");
        if (downloadData == 0) {
            return true;
        }
        return false;
    }

    public static File j() {
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isRichStatusToggleEnable()) {
            String str = MobileQQ.sMobileQQ.getExternalCacheDir() + File.separator + "status_ic";
            if (QLog.isColorLevel()) {
                QLog.i("Q.richstatus.img", 1, "[richstatus_sdcard_migrate]new_path=" + str);
            }
            return new File(str);
        }
        if (cu.e()) {
            return new File(AppConstants.SDCARD_PATH + "status_ic");
        }
        return null;
    }

    public Bitmap g(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, str, str2, str3);
        }
        Bitmap i3 = i(str);
        if (i3 == null) {
            if (this.f282309a == null) {
                this.f282309a = new HashSet<>();
            }
            if (!this.f282309a.contains(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.richstatus.img", 2, "decodeBitmap " + str + ", " + str2 + ", " + str3);
                }
                this.f282309a.add(str);
                new a(str, str2, str3).execute((Object[]) null);
            }
        }
        return i3;
    }

    public Bitmap i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return ImageCacheHelper.f98636a.f(this.f282312d + str);
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f282309a.clear();
        }
    }
}
