package com.tencent.mobileqq.testassister;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.LogManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShareAppLogHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Pattern f292639a;

    /* renamed from: b, reason: collision with root package name */
    private String f292640b;

    /* renamed from: c, reason: collision with root package name */
    private String f292641c;

    /* renamed from: d, reason: collision with root package name */
    private String f292642d;

    /* renamed from: e, reason: collision with root package name */
    private Time f292643e;

    /* renamed from: f, reason: collision with root package name */
    private Time f292644f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f292645g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<LogFile> f292646h;

    /* renamed from: i, reason: collision with root package name */
    private String f292647i;

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f292648j;

    /* renamed from: k, reason: collision with root package name */
    volatile Object f292649k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f292650l;

    /* renamed from: m, reason: collision with root package name */
    private d f292651m;

    /* renamed from: n, reason: collision with root package name */
    private Handler f292652n;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareAppLogHelper.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 1000:
                    if (ShareAppLogHelper.this.f292651m != null) {
                        ShareAppLogHelper.this.f292651m.a((String) message.obj);
                        return;
                    }
                    return;
                case 1001:
                    if (ShareAppLogHelper.this.f292651m != null) {
                        ShareAppLogHelper.this.f292651m.onError(((Integer) message.obj).intValue());
                        return;
                    }
                    return;
                case 1002:
                    if (ShareAppLogHelper.this.f292651m != null) {
                        ShareAppLogHelper.this.f292651m.onWarning(((Integer) message.obj).intValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements FilenameFilter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareAppLogHelper.this);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            Time q16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            if ((!str.endsWith(".qqxlog") && !str.endsWith(".log") && !str.endsWith(".zip") && !str.endsWith(".qlog")) || str.startsWith(LogManager.PRIVATE_LOG_PREFIX) || (q16 = ShareAppLogHelper.this.q(str)) == null || q16.toMillis(false) < ShareAppLogHelper.this.f292643e.toMillis(false) || q16.toMillis(false) > ShareAppLogHelper.this.f292644f.toMillis(false)) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements FilenameFilter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareAppLogHelper.this);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            Time q16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            if (!str.endsWith(".log") || (q16 = ShareAppLogHelper.this.q(str)) == null || q16.toMillis(false) < ShareAppLogHelper.this.f292643e.toMillis(false) || q16.toMillis(false) > ShareAppLogHelper.this.f292644f.toMillis(false)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(String str);

        void onError(int i3);

        void onWarning(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f292657a;

        /* renamed from: b, reason: collision with root package name */
        private String f292658b;

        public e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f292658b = str;
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareAppLogHelper.TimeLogger", 4, this.f292658b, " costTime: ", Long.valueOf(currentTimeMillis - this.f292657a));
                        return;
                    }
                    return;
                }
                return;
            }
            this.f292657a = System.currentTimeMillis();
        }
    }

    public ShareAppLogHelper(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f292639a = Pattern.compile("\\d{2}.\\d{2}.\\d{2}.\\d{2}");
        this.f292646h = new ArrayList<>();
        this.f292648j = new AtomicBoolean(false);
        this.f292649k = new Object();
        this.f292652n = new a(Looper.getMainLooper());
        this.f292640b = MobileQQ.getLogExternalPath(MobileQQ.sMobileQQ) + "/tencent/msflogs/com/tencent/mobileqq/";
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null && externalFilesDir.exists()) {
            this.f292641c = externalFilesDir.getAbsolutePath() + "/tencent/msflogs/com/tencent/mobileqq/";
        }
        this.f292642d = Environment.getExternalStorageDirectory().getPath() + "/tencent/com/tencent/mobileqq/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.f292643e = null;
        this.f292644f = null;
        this.f292646h.clear();
        this.f292647i = null;
        this.f292650l = false;
        this.f292648j.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C() {
        File file = new File(this.f292640b);
        if (!file.exists()) {
            return -1;
        }
        z();
        n(file, false);
        File file2 = new File(this.f292641c);
        if (!Objects.equals(this.f292641c, this.f292640b) && file2.exists()) {
            n(file2, true);
        }
        if (this.f292645g) {
            LogFile logFile = new LogFile("/data/anr/traces.txt");
            long length = logFile.length();
            if (logFile.exists() && logFile.canRead() && length != 0) {
                ArrayList<LogFile> arrayList = this.f292646h;
                if (arrayList != null) {
                    arrayList.add(logFile);
                } else {
                    ArrayList<LogFile> arrayList2 = new ArrayList<>();
                    this.f292646h = arrayList2;
                    arrayList2.add(logFile);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("LOGFILE", 2, "traces.txt can not read or not exist");
            }
        }
        ArrayList<LogFile> arrayList3 = this.f292646h;
        if (arrayList3 != null && arrayList3.size() > 0) {
            return 0;
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(@Nullable String str) {
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        if (str == null) {
            this.f292647i = this.f292640b + t(this.f292643e, this.f292644f);
        } else {
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                this.f292647i = str + t(this.f292643e, this.f292644f);
            } else {
                this.f292647i = str + str2 + t(this.f292643e, this.f292644f);
            }
        }
        File file = new File(this.f292647i);
        File parentFile = file.getParentFile();
        Objects.requireNonNull(parentFile);
        if (!parentFile.exists()) {
            file.getParentFile().mkdirs();
        }
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    ZipOutputStream zipOutputStream2 = new ZipOutputStream(bufferedOutputStream);
                    try {
                        byte[] bArr = new byte[8192];
                        Iterator<LogFile> it = this.f292646h.iterator();
                        long j3 = 0;
                        while (it.hasNext()) {
                            LogFile next = it.next();
                            if (QLog.isColorLevel()) {
                                QLog.d("ShareAppLogHelper", 4, "logPath: ", next.getPath(), " logSize: ", Long.valueOf(next.length() / 1024));
                            }
                            j3 += next.length();
                            e eVar = new e(next.getName());
                            eVar.a(0);
                            ZipEntry zipEntry = new ZipEntry(next.getName() + next.stuffix);
                            zipEntry.setSize(next.length());
                            zipEntry.setTime(next.lastModified());
                            zipOutputStream2.putNextEntry(zipEntry);
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(next));
                            while (true) {
                                try {
                                    int read = bufferedInputStream.read(bArr, 0, 8192);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream2.write(bArr, 0, read);
                                } catch (Throwable th6) {
                                    bufferedInputStream.close();
                                    zipOutputStream2.flush();
                                    zipOutputStream2.closeEntry();
                                    throw th6;
                                }
                            }
                            bufferedInputStream.close();
                            zipOutputStream2.flush();
                            zipOutputStream2.closeEntry();
                            if (next.getName().startsWith(LogManager.PRIVATE_LOG_PREFIX)) {
                                next.delete();
                            }
                            eVar.a(1);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareAppLogHelper", 4, "size: ", Long.valueOf(j3 / 1024));
                        }
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        if (file.length() >= 10485760) {
                            return 1;
                        }
                        return 0;
                    } catch (Exception e18) {
                        e = e18;
                        zipOutputStream = zipOutputStream2;
                        e.printStackTrace();
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                return -3;
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                return -3;
                            }
                        }
                        return -3;
                    } catch (Throwable th7) {
                        th5 = th7;
                        zipOutputStream = zipOutputStream2;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                throw th5;
                            } catch (IOException e28) {
                                e28.printStackTrace();
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (Exception e29) {
                    e = e29;
                }
            } catch (Exception e36) {
                e = e36;
                bufferedOutputStream = null;
            } catch (Throwable th8) {
                th5 = th8;
                bufferedOutputStream = null;
            }
        } catch (Throwable th9) {
            th5 = th9;
        }
    }

    private void n(File file, boolean z16) {
        File[] listFiles = file.listFiles(new b());
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                LogFile logFile = new LogFile(file2.getPath());
                if (z16) {
                    LogFile logFile2 = new LogFile(y(logFile.getAbsolutePath()));
                    FileUtils.copyFile(logFile, logFile2);
                    this.f292646h.add(logFile2);
                } else {
                    this.f292646h.add(logFile);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Time q(String str) {
        Time r16;
        Matcher matcher = this.f292639a.matcher(str);
        if (matcher.find() && (r16 = r(matcher.group(), "\\.")) != null) {
            int i3 = r16.year;
            if (i3 < 100) {
                r16.year = i3 + 2000;
            }
            return r16;
        }
        return null;
    }

    public static Time r(String str, String str2) {
        try {
            String[] split = str.split(str2);
            if (split.length == 4) {
                Time time = new Time();
                time.year = Integer.parseInt(split[0]);
                time.month = Integer.parseInt(split[1]) - 1;
                time.monthDay = Integer.parseInt(split[2]);
                time.hour = Integer.parseInt(split[3]);
                return time;
            }
            if (split.length == 3) {
                Time time2 = new Time();
                time2.year = Integer.parseInt(split[0]);
                time2.month = Integer.parseInt(split[1]) - 1;
                time2.monthDay = Integer.parseInt(split[2]);
                return time2;
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private String s(Time time) {
        return String.format("%4d_%2d_%2d_%2d", Integer.valueOf(time.year), Integer.valueOf(time.month + 1), Integer.valueOf(time.monthDay), Integer.valueOf(time.hour));
    }

    private String t(Time time, Time time2) {
        return "logs_zip_" + s(time) + "-" + s(time2) + ".zip";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3) {
        Message obtainMessage = this.f292652n.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.obj = Integer.valueOf(i3);
        this.f292652n.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        Message obtainMessage = this.f292652n.obtainMessage();
        obtainMessage.what = 1000;
        if (str == null) {
            obtainMessage.obj = "";
        } else {
            obtainMessage.obj = str;
        }
        this.f292652n.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3) {
        Message obtainMessage = this.f292652n.obtainMessage();
        obtainMessage.what = 1002;
        obtainMessage.obj = Integer.valueOf(i3);
        this.f292652n.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        synchronized (this.f292649k) {
            try {
                LockMethodProxy.wait(this.f292649k);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    private String y(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf) + "/" + LogManager.PRIVATE_LOG_PREFIX + str.substring(lastIndexOf + 1);
    }

    private void z() {
        File[] listFiles;
        File file = new File(this.f292642d);
        if (file.exists() && (listFiles = file.listFiles(new c())) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                LogFile logFile = new LogFile(file2.getPath());
                logFile.stuffix = ".old";
                this.f292646h.add(logFile);
            }
        }
    }

    public void A(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        } else {
            this.f292651m = dVar;
        }
    }

    public void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        this.f292650l = z16;
        synchronized (this.f292649k) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareAppLogHelper", 4, "status is size warning, user confirm");
            }
            this.f292649k.notifyAll();
        }
    }

    public boolean o(Time time, Time time2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, time, time2, Boolean.valueOf(z16))).booleanValue();
        }
        return p(time, time2, z16, null);
    }

    public boolean p(Time time, Time time2, boolean z16, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, time, time2, Boolean.valueOf(z16), str)).booleanValue();
        }
        if (this.f292648j.get()) {
            return false;
        }
        this.f292648j.set(true);
        this.f292643e = time;
        this.f292644f = time2;
        this.f292645g = z16;
        ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.testassister.ShareAppLogHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f292653d;

            {
                this.f292653d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShareAppLogHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                e eVar = new e("allCost");
                eVar.a(0);
                int C = ShareAppLogHelper.this.C();
                if (C != 0) {
                    ShareAppLogHelper.this.u(C);
                    ShareAppLogHelper.this.B();
                    return;
                }
                int D = ShareAppLogHelper.this.D(this.f292653d);
                eVar.a(1);
                if (D == 1) {
                    ShareAppLogHelper.this.w(D);
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareAppLogHelper", 4, "status is size warning, show dialog");
                    }
                    ShareAppLogHelper.this.x();
                    if (!ShareAppLogHelper.this.f292650l) {
                        ShareAppLogHelper shareAppLogHelper = ShareAppLogHelper.this;
                        shareAppLogHelper.v(shareAppLogHelper.f292647i);
                    } else {
                        try {
                            File file = new File(ShareAppLogHelper.this.f292647i);
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                } else if (D != 0) {
                    ShareAppLogHelper.this.u(D);
                } else {
                    ShareAppLogHelper shareAppLogHelper2 = ShareAppLogHelper.this;
                    shareAppLogHelper2.v(shareAppLogHelper2.f292647i);
                }
                ShareAppLogHelper.this.B();
            }
        }, 10, null, true);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class LogFile extends File {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public String stuffix;

        public LogFile(File file, String str) {
            super(file, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.stuffix = "";
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) str);
            }
        }

        public LogFile(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.stuffix = "";
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }
}
