package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static String f305893n;

    /* renamed from: a, reason: collision with root package name */
    private final String f305894a;

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f305895b;

    /* renamed from: c, reason: collision with root package name */
    final long f305896c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f305897d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f305898e;

    /* renamed from: f, reason: collision with root package name */
    private int f305899f;

    /* renamed from: g, reason: collision with root package name */
    private Bundle f305900g;

    /* renamed from: h, reason: collision with root package name */
    private int f305901h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.uniformdownload.util.b f305902i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.uniformdownload.util.d f305903j;

    /* renamed from: k, reason: collision with root package name */
    private List<com.tencent.mobileqq.uniformdownload.util.d> f305904k;

    /* renamed from: l, reason: collision with root package name */
    private Object f305905l;

    /* renamed from: m, reason: collision with root package name */
    private Object f305906m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements com.tencent.mobileqq.uniformdownload.util.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniformDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void R0(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
                return;
            }
            QLog.i(UniformDownloader.f305893n, 1, "[UniformDL][" + UniformDownloader.this.f305896c + "]. onDownloadPause. progress:" + i3);
            if (bundle != null) {
                bundle.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
            }
            for (com.tencent.mobileqq.uniformdownload.util.d dVar : UniformDownloader.this.m()) {
                if (dVar != null) {
                    dVar.R0(i3, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
                return;
            }
            if (bundle != null) {
                bundle.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
            }
            for (com.tencent.mobileqq.uniformdownload.util.d dVar : UniformDownloader.this.m()) {
                if (dVar != null) {
                    dVar.a(i3, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.i(UniformDownloader.f305893n, 1, "[UniformDL][" + UniformDownloader.this.f305896c + "]. onDownloadFailed. errcode:" + i3 + "errStr:" + str);
            if (UniformDownloader.this.f305899f < 1 && 1 == UniformDownloader.this.f305901h) {
                QLog.i(UniformDownloader.f305893n, 1, "[UniformDL][" + UniformDownloader.this.f305896c + "]. onDownloadFailed. errorRetry");
                UniformDownloader.h(UniformDownloader.this);
                UniformDownloader.this.k(i3, str, bundle);
                return;
            }
            if (bundle != null) {
                bundle.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
            }
            for (com.tencent.mobileqq.uniformdownload.util.d dVar : UniformDownloader.this.m()) {
                if (dVar != null) {
                    dVar.c(i3, str, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c2(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
                return;
            }
            QLog.i(UniformDownloader.f305893n, 1, "[UniformDL][" + UniformDownloader.this.f305896c + "]. onDownloadResume. progress:" + i3);
            if (bundle != null) {
                bundle.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
            }
            for (com.tencent.mobileqq.uniformdownload.util.d dVar : UniformDownloader.this.m()) {
                if (dVar != null) {
                    dVar.c2(i3, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void g0(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
                return;
            }
            boolean n3 = UniformDownloader.this.n();
            QLog.i(UniformDownloader.f305893n, 1, "[UniformDL][" + UniformDownloader.this.f305896c + "]. onDownloadStart. start:" + n3 + "progress:" + i3);
            if (n3) {
                return;
            }
            UniformDownloader.this.z(true);
            List<com.tencent.mobileqq.uniformdownload.util.d> m3 = UniformDownloader.this.m();
            if (bundle != null) {
                bundle.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
            }
            for (com.tencent.mobileqq.uniformdownload.util.d dVar : m3) {
                if (dVar != null) {
                    dVar.g0(i3, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void h(String str, long j3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), bundle);
                return;
            }
            QLog.i(UniformDownloader.f305893n, 1, "[UniformDL][" + UniformDownloader.this.f305896c + "]. onDownloadSucess. filePath:" + str);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("_CB_SID", UniformDownloader.this.f305901h);
            bundle2.putString("_CB_URL", UniformDownloader.this.f305894a);
            bundle2.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
            for (com.tencent.mobileqq.uniformdownload.util.d dVar : UniformDownloader.this.m()) {
                if (dVar != null) {
                    dVar.h(str, j3, bundle2);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f305893n = "UDownloader";
        }
    }

    public UniformDownloader(long j3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, bundle);
            return;
        }
        this.f305897d = false;
        this.f305899f = 0;
        this.f305901h = 0;
        this.f305902i = null;
        this.f305903j = null;
        this.f305904k = new ArrayList();
        this.f305905l = new Object();
        this.f305906m = new Object();
        this.f305894a = str;
        this.f305895b = bundle;
        this.f305896c = j3;
        this.f305897d = false;
        this.f305898e = false;
    }

    static /* synthetic */ int h(UniformDownloader uniformDownloader) {
        int i3 = uniformDownloader.f305899f;
        uniformDownloader.f305899f = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3, String str, Bundle bundle) {
        ThreadManager.getSubThreadHandler().post(new Runnable(bundle, i3, str) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f305907d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f305908e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f305909f;

            {
                this.f305907d = bundle;
                this.f305908e = i3;
                this.f305909f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, UniformDownloader.this, bundle, Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                UniformDownloader uniformDownloader = UniformDownloader.this;
                if (uniformDownloader.s(false, uniformDownloader.f305900g)) {
                    UniformDownloader.this.A();
                    return;
                }
                Bundle bundle2 = this.f305907d;
                if (bundle2 != null) {
                    bundle2.putBundle("_CB_USERDATA", UniformDownloader.this.f305895b);
                }
                for (com.tencent.mobileqq.uniformdownload.util.d dVar : UniformDownloader.this.m()) {
                    if (dVar != null) {
                        dVar.c(this.f305908e, this.f305909f, this.f305907d);
                    }
                }
            }
        });
    }

    private com.tencent.mobileqq.uniformdownload.util.d l() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.uniformdownload.util.d> m() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f305906m) {
            int size = this.f305904k.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(this.f305904k.get(i3));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean s(boolean z16, Bundle bundle) {
        com.tencent.mobileqq.uniformdownload.util.b bVar = this.f305902i;
        if (bVar != null) {
            bVar.a(null);
            this.f305902i.stop();
        }
        if (z16) {
            this.f305901h = 1;
            this.f305902i = new b(this.f305896c);
        } else {
            this.f305901h = 2;
            this.f305902i = new d(this.f305896c);
        }
        if (this.f305903j == null) {
            this.f305903j = l();
        }
        this.f305902i.a(this.f305903j);
        if (this.f305902i.c(this.f305894a, bundle) == 0) {
            return true;
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. mDownloadler init error.");
        return false;
    }

    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.f305902i != null) {
            QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. start. ");
            return this.f305902i.start();
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. start. mDownloadler = null.");
        return -1;
    }

    public int B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (this.f305902i != null) {
            QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. stop. ");
            return this.f305902i.stop();
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. stop. mDownloadler = null.");
        return -1;
    }

    public void j(com.tencent.mobileqq.uniformdownload.util.d dVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, dVar, Boolean.valueOf(z16));
            return;
        }
        synchronized (this.f305906m) {
            int size = this.f305904k.size();
            while (true) {
                if (i3 < size) {
                    if (this.f305904k.get(i3) == dVar) {
                        if (!z16) {
                            return;
                        }
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (z16 && i3 >= 0) {
                this.f305904k.add(this.f305904k.remove(i3));
                this.f305897d = true;
                return;
            }
            if (dVar != null) {
                if (this.f305897d) {
                    com.tencent.mobileqq.uniformdownload.util.d remove = this.f305904k.remove(this.f305904k.size() - 1);
                    this.f305904k.add(dVar);
                    this.f305904k.add(remove);
                } else {
                    this.f305904k.add(dVar);
                }
                QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. addListenser. size=" + this.f305904k.size());
            }
            if (z16) {
                this.f305897d = true;
            }
        }
    }

    public boolean n() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        synchronized (this.f305905l) {
            z16 = this.f305898e;
        }
        return z16;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uniformdownload.util.b bVar = this.f305902i;
        if (bVar != null) {
            return bVar.getStatus();
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. getStatus. mDownloadler = null.");
        return 0;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f305901h;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305894a;
    }

    public boolean r(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. >>>init UniformDownloader");
        String string = bundle.getString("_PARAM_FILENAME");
        long j3 = bundle.getLong("_PARAM_FILESIZE");
        if (string == null) {
            QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. init err. filename=null");
            string = "unnamefile";
        }
        if (0 == j3) {
            QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. init err. filesize=0");
            return false;
        }
        Bundle bundle2 = new Bundle();
        String w16 = ah.w1(AppConstants.SDCARD_FILE_SAVE_TMP_PATH + string);
        String str = AppConstants.SDCARD_FILE_SAVE_PATH + string;
        bundle2.putString("_PARAM_FILENAME", string);
        bundle2.putString("_PARAM_TMP_FILEPATH", w16);
        bundle2.putString("_PARAM_FILEPATH", str);
        bundle2.putLong("_PARAM_FILESIZE", j3);
        bundle2.putLong("_PARAM_POS", 0L);
        Bundle bundle3 = bundle.getBundle("_PARAM_USER_DATA");
        if (bundle3 != null) {
            String string2 = bundle3.getString("COOKIE");
            if (!TextUtils.isEmpty(string2)) {
                bundle2.putString("_PARAM_COOKIE", string2);
            }
        }
        this.f305900g = bundle2;
        QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. >>>init UniformDownload info :: filename:[" + string + "] fileSize:[" + j3 + "] tmpPath(maybe change):[" + w16 + "] savePath(maybe change):[" + str + "] url:[" + this.f305894a + "]");
        return s(UniformDownloadUtil.i(string), bundle2);
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (2 == o()) {
            return true;
        }
        return false;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        int o16 = o();
        if (1 == o16 || 6 == o16) {
            return true;
        }
        if (2 == this.f305901h && 8 == o16) {
            return true;
        }
        return false;
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.f305902i != null) {
            QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. pause. ");
            return this.f305902i.pause();
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. pause. mDownloadler = null.");
        return -1;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (this.f305902i != null) {
            QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. pauseSlience. ");
            return this.f305902i.b();
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. pauseSlience. mDownloadler = null.");
        return -1;
    }

    public void x(com.tencent.mobileqq.uniformdownload.util.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
            return;
        }
        synchronized (this.f305906m) {
            if (this.f305904k.contains(dVar)) {
                this.f305904k.remove(dVar);
            }
        }
    }

    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (this.f305902i != null) {
            QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. resume. ");
            return this.f305902i.resume();
        }
        QLog.e(f305893n, 1, "[UniformDL][" + this.f305896c + "]. resume. mDownloadler = null.");
        return -1;
    }

    public void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        synchronized (this.f305905l) {
            QLog.i(f305893n, 1, "[UniformDL][" + this.f305896c + "]. setNotifyUserStarted." + this.f305898e + "->" + z16);
            this.f305898e = z16;
        }
    }
}
