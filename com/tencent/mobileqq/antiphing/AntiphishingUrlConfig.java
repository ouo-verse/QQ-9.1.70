package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AntiphishingUrlConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f194333a;

    /* renamed from: b, reason: collision with root package name */
    private int f194334b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f194335c;

    /* renamed from: d, reason: collision with root package name */
    private long f194336d;

    /* renamed from: e, reason: collision with root package name */
    private int f194337e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f194338f;

    /* renamed from: g, reason: collision with root package name */
    private int f194339g;

    /* renamed from: h, reason: collision with root package name */
    private int f194340h;

    /* renamed from: i, reason: collision with root package name */
    private String f194341i;

    /* renamed from: j, reason: collision with root package name */
    private Context f194342j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f194343k;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AntiphishingUrlConfig.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            try {
                if (message.what == AntiphishingUrlConfig.this.f194339g) {
                    QLog.d(AntiphishingUrlConfig.this.f194333a, 4, "Receive Message!");
                    AntiphishingUrlConfig.this.h();
                    ReportController.o(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", DownloadInfo.spKey_Config, 0, 1, "", "", "", "");
                } else if (message.what == AntiphishingUrlConfig.this.f194340h) {
                    QLog.d(AntiphishingUrlConfig.this.f194333a, 4, "Receive Message!");
                    ReportController.o(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", DownloadInfo.spKey_Config, 0, 0, "", "", "", "");
                }
            } catch (Exception unused) {
            }
        }
    }

    public AntiphishingUrlConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f194333a = "antiphishingConfig";
        this.f194334b = 0;
        this.f194335c = null;
        this.f194336d = 0L;
        this.f194337e = 0;
        this.f194338f = false;
        this.f194339g = 1;
        this.f194340h = 2;
        this.f194341i = null;
        this.f194342j = null;
        this.f194343k = new a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        Environment.getExternalStorageDirectory().getAbsolutePath();
        return this.f194341i;
    }

    public static long j() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public ArrayList<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f194335c == null && !this.f194338f) {
            h();
        }
        return this.f194335c;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QLog.d(this.f194333a, 2, "Parase Config!");
        String f16 = f();
        if (f16 == null) {
            return false;
        }
        File file = new File(f16);
        d dVar = new d();
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream(file), "UTF-8")), dVar);
            this.f194334b = dVar.a();
            this.f194335c = dVar.b();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void i(int i3, String str, String str2, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2, context);
            return;
        }
        if (i3 <= this.f194334b) {
            QLog.d(this.f194333a, 4, "nNewVersion:" + i3 + "nLocalConfigVer:" + this.f194334b + "Do not Need Update!");
            return;
        }
        if (this.f194336d != 0 && this.f194337e == i3 && System.currentTimeMillis() - this.f194336d < 7200000) {
            QLog.d(this.f194333a, 1, "Config Updata, Frequence limited!");
            return;
        }
        this.f194336d = System.currentTimeMillis();
        this.f194337e = i3;
        QLog.d(this.f194333a, 1, "filehash:" + str2 + "downloadurl:" + str);
        ThreadManagerV2.post(new Runnable(context, str, str2) { // from class: com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f194344d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f194345e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f194346f;

            {
                this.f194344d = context;
                this.f194345e = str;
                this.f194346f = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AntiphishingUrlConfig.this, context, str, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (AntiphishingUrlConfig.j() > 3000000) {
                    if (new c(this.f194344d).a(this.f194345e, AntiphishingUrlConfig.this.f(), this.f194346f, false)) {
                        QLog.d(AntiphishingUrlConfig.this.f194333a, 1, "Successfully Update Config!");
                        AntiphishingUrlConfig.this.f194343k.sendEmptyMessage(AntiphishingUrlConfig.this.f194339g);
                    } else {
                        AntiphishingUrlConfig.this.f194343k.sendEmptyMessage(AntiphishingUrlConfig.this.f194340h);
                        QLog.d(AntiphishingUrlConfig.this.f194333a, 1, "Update Config Error!");
                    }
                }
            }
        }, 5, null, true);
    }

    public void k(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) context);
        } else {
            this.f194341i = str;
            this.f194342j = context;
        }
    }
}
