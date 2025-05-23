package com.tencent.mobileqq.msf.core.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.qq.e.comm.constants.Constants;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.r;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_ = null;
    public static final String I = "MSF.C.NetConnTag.";
    public static final int J = 2;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 300000;
    public static final String N = "sp_name_complex_connect";
    public static final String O = "key_loop_time_out_count";
    public static final String P = "key_connect_error_count";
    private static long Q = -1;
    public static byte R = -1;
    private static final int S = -1;
    private static final int T = 0;
    private static final int U = 1;
    private static final int V = 2;
    public static String W = "";
    public static final int X = -1;
    public static final int Y = 0;
    public static final int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f248845a0 = 2;

    /* renamed from: b0, reason: collision with root package name */
    public static final int f248846b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    public static final int f248847c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    public static final int f248848d0 = 1;

    /* renamed from: e0, reason: collision with root package name */
    public static final int f248849e0 = 2;

    /* renamed from: f0, reason: collision with root package name */
    public static final int f248850f0 = 3;
    private Thread A;
    private long B;
    private AtomicBoolean C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private k H;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f248851a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f248852b;

    /* renamed from: c, reason: collision with root package name */
    private final MsfCore f248853c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f248854d;

    /* renamed from: e, reason: collision with root package name */
    private final t f248855e;

    /* renamed from: f, reason: collision with root package name */
    Runnable f248856f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f248857g;

    /* renamed from: h, reason: collision with root package name */
    public final j f248858h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<n> f248859i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f248860j;

    /* renamed from: k, reason: collision with root package name */
    public volatile long[] f248861k;

    /* renamed from: l, reason: collision with root package name */
    public volatile long[] f248862l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f248863m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f248864n;

    /* renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f248865o;

    /* renamed from: p, reason: collision with root package name */
    private long f248866p;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.msf.core.net.b> f248867q;

    /* renamed from: r, reason: collision with root package name */
    private long f248868r;

    /* renamed from: s, reason: collision with root package name */
    long f248869s;

    /* renamed from: t, reason: collision with root package name */
    public long f248870t;

    /* renamed from: u, reason: collision with root package name */
    private long f248871u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<i> f248872v;

    /* renamed from: w, reason: collision with root package name */
    private ArrayList<i> f248873w;

    /* renamed from: x, reason: collision with root package name */
    private Thread f248874x;

    /* renamed from: y, reason: collision with root package name */
    private long f248875y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f248876z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements n.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f248877a;

        a(n nVar) {
            this.f248877a = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this, (Object) nVar);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.n.c
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            o.this.f248853c.setGatewayIp(str);
            this.f248877a.b(this);
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "onGatewayIpSet, mainSocketEngineId:" + this.f248877a.e() + ", GatewayIp:" + str);
                return;
            }
            QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "onGatewayIpSet, mainSocketEngineId:" + this.f248877a.e() + ", GatewayIp=" + com.tencent.mobileqq.msf.core.z.a.a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f248879a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f248880b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f248881c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f248882d;

        b(int i3, CopyOnWriteArrayList copyOnWriteArrayList, CopyOnWriteArrayList copyOnWriteArrayList2, ArrayList arrayList) {
            this.f248879a = i3;
            this.f248880b = copyOnWriteArrayList;
            this.f248881c = copyOnWriteArrayList2;
            this.f248882d = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, Integer.valueOf(i3), copyOnWriteArrayList, copyOnWriteArrayList2, arrayList);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "asyncSelectAndConnect threadId: " + Thread.currentThread().getId() + ", threadName" + Thread.currentThread().getName() + ", connID" + this.f248879a);
            if (!o.this.b(this.f248880b, this.f248881c, this.f248882d, this.f248879a)) {
                o.this.f248858h.b(-1, this.f248879a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f248884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f248885b;

        c(String str, int i3) {
            this.f248884a = str;
            this.f248885b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    o.this.F = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "start send checkNetConnectBySocket server:" + this.f248884a + " port:" + this.f248885b);
                    }
                    Socket socket = new Socket();
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f248884a, this.f248885b);
                    socket.setSoTimeout(10000);
                    socket.setTcpNoDelay(true);
                    socket.setKeepAlive(true);
                    socket.connect(inetSocketAddress, 10000);
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "checkNetConnectBySocket connect server:" + this.f248884a + " port:" + this.f248885b + " success");
                    }
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("GET https://3gimg.qq.com/qq_product_operations/nettest/index.html?mType=connCheck HTTP/1.1\r\n");
                    stringBuffer.append("Host: 3gimg.qq.com \r\n");
                    stringBuffer.append("Connection: close\r\n");
                    stringBuffer.append("\r\n");
                    outputStreamWriter.write(stringBuffer.toString());
                    outputStreamWriter.flush();
                    InputStream inputStream = socket.getInputStream();
                    byte[] bArr = new byte[64];
                    if (inputStream.read(bArr) != -1) {
                        str = new String(bArr, "UTF-8");
                    } else {
                        str = null;
                    }
                    if (str.indexOf("302") != -1) {
                        o.this.F = true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "checkNetConnectBySocket get header:" + str);
                    } else {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "checkNetConnectBySocket " + str.hashCode() + " len: " + str.length());
                    }
                    inputStream.close();
                    return;
                } catch (UnknownHostException e16) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "checkNetConnectBySocket connect server UnknownHostException:" + this.f248884a + " port:" + this.f248885b + " failed" + e16, e16);
                    return;
                } catch (IOException e17) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "checkNetConnectBySocket connect server IOException:" + this.f248884a + " port:" + this.f248885b + " failed" + e17, e17);
                    return;
                } catch (Exception e18) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "checkNetConnectBySocket connect server:" + this.f248884a + " port:" + this.f248885b + " failed" + e18, e18);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d extends BaseThread {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Iterator it = o.this.f248872v.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a();
            }
            o.this.f248873w.addAll(o.this.f248872v);
            o.this.f248872v.clear();
            o.this.f248874x = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e extends BaseThread {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Runnable {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    e.this.a();
                }
            }
        }

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                Looper.myLooper().quit();
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                Looper.prepare();
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "tcpdump Report show toast begin");
                }
                Toast.makeText(BaseApplication.getContext(), "\u6709\u7f51\u7edc\u5f02\u5e38\u6293\u5305\u6587\u4ef6\uff0c\u8bf7rtx bobbyzhang,thx!", 1).show();
                new Handler().postDelayed(new a(), 20000L);
                Looper.loop();
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "tcpdump Report show toast end");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "tcpdump Report exception" + e16, e16);
                }
            }
            o.this.f248876z = false;
            o.this.A = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f extends BaseThread {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        void a() {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag.", 2, "start tcpdump now");
            }
            try {
                String str = null;
                try {
                    for (String str2 : BaseApplication.getContext().getAssets().list("")) {
                        if (str2.indexOf("tcpdump") != -1) {
                            str = str2;
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (str == null) {
                    return;
                }
                BaseApplication.getContext().getDir("assets", 0).toString();
                StringBuilder sb5 = new StringBuilder();
                o.b(BaseApplication.getContext());
                new ProcessBuilder(new String[0]).command("chmod", "777", BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump").redirectErrorStream(true).start();
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "start tcpdump");
                }
                sb5.setLength(0);
                String str3 = Environment.getExternalStorageDirectory().getPath() + "/tencent/" + BaseApplication.getContext().getPackageName().replace(".", "/") + "/";
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format((Date) new java.sql.Date(System.currentTimeMillis()));
                sb5.append(str3);
                sb5.append(format);
                sb5.append(".pcap");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"su", LogCmdOptions.CLEAR, BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump  -p -l -vv -i any -s 0 -w " + ((Object) sb5)}).getErrorStream()));
                    if (bufferedReader.readLine().toLowerCase().contains("syntax error")) {
                        bufferedReader.close();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag.", 2, "tcpdump started Sleep for 10 minutes");
                    }
                    o.this.B = System.currentTimeMillis();
                    LockMethodProxy.sleep(com.tencent.mobileqq.msf.core.x.b.R0());
                    bufferedReader.close();
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag.", 2, "tcpdump end Sleep for 10 minutes");
                    }
                    o.s();
                    o.this.f248876z = true;
                } catch (IOException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag.", 2, "Error running tcpdump, msg=" + e17.getMessage());
                    }
                }
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "tcpdump: readLine Exception" + e18);
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                try {
                    a();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f248891a;

        g(String str) {
            this.f248891a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this, (Object) str);
            }
        }

        void a(int i3, String str) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "start pingServer:" + this.f248891a);
                }
                Process start = new ProcessBuilder(new String[0]).command("/system/bin/ping", "-c " + i3, str).redirectErrorStream(true).start();
                try {
                    start.getInputStream();
                    start.getOutputStream();
                    new String();
                    new String();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
                    new String();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "pingServer:" + this.f248891a + " out:" + readLine);
                            }
                        } else {
                            start.destroy();
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    start.destroy();
                    throw th5;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "pingServer:" + this.f248891a + " readLine Exception" + e16);
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a(5, this.f248891a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class h extends BaseThread {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            URL url;
            long currentTimeMillis;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                o.this.D = 0;
                o.this.E = false;
                byte[] bArr = new byte[128];
                HttpURLConnection httpURLConnection2 = null;
                try {
                    url = new URL("https://3gimg.qq.com/qq_product_operations/nettest/index.html?mType=connCheck");
                    currentTimeMillis = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "start send checkNetConnectByHttp msg");
                    }
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    int read = httpURLConnection.getInputStream().read(bArr);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 && url.getHost().equals(httpURLConnection.getURL().getHost())) {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "send checkNetConnectByHttp resp code:" + responseCode + " , costTime " + (System.currentTimeMillis() - currentTimeMillis) + ", resp len: " + read);
                        o.this.D = responseCode;
                        o.this.E = true;
                    } else {
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "send checkNetConnectByHttp msg , resp code is " + responseCode + ", resp len: " + read);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        String th7 = th.toString();
                        o.this.D = 0;
                        o.this.E = false;
                        QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 1, "send checkNetConnectByHttp msg exception" + th7, th);
                        if (httpURLConnection2 != null) {
                            httpURLConnection = httpURLConnection2;
                            httpURLConnection.disconnect();
                        }
                        o.this.G = System.currentTimeMillis();
                        return;
                    } catch (Throwable th8) {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        o.this.G = System.currentTimeMillis();
                        throw th8;
                    }
                }
                httpURLConnection.disconnect();
                o.this.G = System.currentTimeMillis();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f248894a;

        /* renamed from: b, reason: collision with root package name */
        public byte f248895b;

        /* renamed from: c, reason: collision with root package name */
        public String f248896c;

        public i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                return;
            }
            this.f248894a = "";
            this.f248895b = (byte) 1;
            this.f248896c = "";
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f248895b = (byte) 1;
            this.f248896c = "";
            String str = this.f248894a;
            if (str == null) {
                return;
            }
            String trim = str.split(":")[0].trim();
            int parseInt = Integer.parseInt(str.split(":")[1].trim());
            this.f248895b = (byte) 2;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "start send checkNetConnectByConnectSSO server:" + trim + " port:" + parseInt);
                }
                Socket socket = new Socket();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(trim, parseInt);
                socket.setSoTimeout(10000);
                socket.setTcpNoDelay(true);
                socket.setKeepAlive(true);
                socket.connect(inetSocketAddress, 10000);
                this.f248895b = (byte) 3;
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "checkNetConnectByConnectSSO connect server:" + trim + " port:" + parseInt + " success");
                }
                socket.close();
            } catch (Throwable th5) {
                String lowerCase = th5.toString().toLowerCase();
                this.f248896c = lowerCase;
                if (lowerCase.indexOf("timeoutexception") <= -1 && this.f248896c.indexOf(") after") <= -1) {
                    this.f248895b = (byte) 4;
                } else {
                    this.f248895b = (byte) 5;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + o.this.f248855e.p(), 2, "checkNetConnectByConnectSSO Throwable connect server:" + trim + " port:" + parseInt + " failed" + th5, th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f248898a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f248899b;

        /* renamed from: c, reason: collision with root package name */
        public a[] f248900c;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public class a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private int f248902a;

            public a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, i3);
                } else {
                    this.f248902a = i3;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "checkDualConnPing: wait timeout: " + this.f248902a);
                j.this.b(-1, this.f248902a);
            }
        }

        public j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                return;
            }
            this.f248898a = 0;
            this.f248899b = new int[2];
            this.f248900c = new a[2];
            int i3 = 0;
            while (true) {
                int[] iArr = this.f248899b;
                if (i3 < iArr.length) {
                    iArr[i3] = 0;
                    this.f248900c[i3] = new a(i3);
                    i3++;
                } else {
                    return;
                }
            }
        }

        private void c(int i3, int i16) {
            int i17 = i16;
            int i18 = i17 == 0 ? 1 : 0;
            try {
                if (((n) o.this.f248859i.get(i17)).f() != 1) {
                    int i19 = i18;
                    i18 = i17;
                    i17 = i19;
                }
                long b16 = o.this.b(i17);
                long b17 = o.this.b(i18);
                int[] iArr = this.f248899b;
                boolean z16 = iArr[i17] == 3;
                boolean z17 = iArr[i18] == 3;
                String b18 = o.this.i().f248801c.b();
                if (o.this.f248853c.getStatReporter() != null) {
                    o.this.f248853c.getStatReporter().a(i3 == 2, b16, z16, b17, z17, b18);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "reportDualEvent fail!", e16);
                }
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f248898a : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            synchronized (this) {
                if (this.f248898a == 1) {
                    try {
                        QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "tryDualConn wait");
                        LockMethodProxy.wait(this);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        private String a(int i3) {
            StringBuilder sb5 = new StringBuilder();
            if (i3 == -1) {
                sb5.append("error");
            } else if (i3 == 0) {
                sb5.append(HippyPagerPageChangeListener.IDLE);
            } else if (i3 == 1) {
                sb5.append("checking");
            } else if (i3 != 2) {
                sb5.append("Socket unknown");
            } else {
                sb5.append("success");
            }
            return sb5.toString();
        }

        private void b(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList3, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList4, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList2) {
            t.f250069a0 = true;
            o.this.a(copyOnWriteArrayList3, copyOnWriteArrayList4, arrayList2, 1);
            o.this.a(copyOnWriteArrayList, copyOnWriteArrayList2, arrayList, 0);
        }

        private String b(int i3) {
            StringBuilder sb5 = new StringBuilder();
            if (i3 == -1) {
                sb5.append("Socket error");
            } else if (i3 == 0) {
                sb5.append("Socket idle");
            } else if (i3 == 1) {
                sb5.append("Socket connecting");
            } else if (i3 == 2) {
                sb5.append("Socket pinging");
            } else if (i3 != 3) {
                sb5.append("Socket unknown");
            } else {
                sb5.append("Socket success");
            }
            return sb5.toString();
        }

        public boolean a(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList3, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList4, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList2) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, copyOnWriteArrayList, copyOnWriteArrayList2, copyOnWriteArrayList3, copyOnWriteArrayList4, arrayList, arrayList2)).booleanValue();
            }
            synchronized (this) {
                QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "ensureDualConn start, mDualConnState = " + a(this.f248898a) + ", isConnected:" + o.this.l());
                int i3 = this.f248898a;
                if (i3 == 0 || i3 == -1 || (i3 == 2 && !o.this.f248853c.isConnected())) {
                    a(false);
                    this.f248898a = 1;
                }
                if (this.f248898a == 1) {
                    try {
                        b(copyOnWriteArrayList, copyOnWriteArrayList2, copyOnWriteArrayList3, copyOnWriteArrayList4, arrayList, arrayList2);
                        LockMethodProxy.wait(this);
                    } catch (Exception e16) {
                        QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "ensureDualConn wait fail", e16);
                    }
                }
                z16 = 2 == this.f248898a;
            }
            return z16;
        }

        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
                return;
            }
            QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "removeConnectionChecker: remove connId = " + i3);
            o.this.f248857g.removeCallbacks(this.f248900c[i3]);
        }

        public boolean b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? a(i3, i16, 10000L) : ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }

        public boolean a(int i3, int i16, long j3) {
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).booleanValue();
            }
            synchronized (this) {
                int i18 = this.f248899b[i16];
                QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "onNextState connId = " + i16 + ", connState = " + b(i3) + ", preState = " + b(i18) + ", remainTime = " + j3);
                if (i18 != i3) {
                    int i19 = i16 == 0 ? 1 : 0;
                    if (i3 == -1) {
                        c(i16);
                        o.this.a(i16);
                        this.f248899b[i16] = i3;
                    } else if (i3 == 1) {
                        this.f248899b[i16] = i3;
                    } else if (i3 == 2) {
                        this.f248899b[i16] = i3;
                        a(i16, j3);
                    } else if (i3 != 3) {
                        i17 = this.f248899b[i19];
                        if (i3 != 3 && i17 == -1) {
                            a(2, i16);
                        } else if (i17 != 3 && i3 == -1) {
                            a(2, i19);
                        } else if (i17 == -1 && i3 == -1) {
                            a(-1, o.this.j());
                        }
                        z17 = z16;
                    } else if (i18 == 2) {
                        this.f248899b[i16] = i3;
                        a(i19, j3);
                    }
                    z16 = true;
                    i17 = this.f248899b[i19];
                    if (i3 != 3) {
                    }
                    if (i17 != 3) {
                    }
                    if (i17 == -1) {
                        a(-1, o.this.j());
                    }
                    z17 = z16;
                }
            }
            return z17;
        }

        public boolean a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, z16)).booleanValue();
            }
            synchronized (this) {
                QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, " reset");
                this.f248898a = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr = this.f248899b;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    iArr[i3] = 0;
                    i3++;
                }
                for (int i16 = 0; i16 < this.f248899b.length; i16++) {
                    a[] aVarArr = this.f248900c;
                    if (aVarArr[i16] != null) {
                        c(i16);
                    } else {
                        aVarArr[i16] = new a(i16);
                    }
                }
                if (z16) {
                    notifyAll();
                }
            }
            return true;
        }

        private void a(int i3, int i16) {
            QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, " onEnd : " + i3);
            for (int i17 = 0; i17 < this.f248899b.length; i17++) {
                c(i17);
            }
            synchronized (this) {
                if (o.this.j() != i16) {
                    QLog.d("MSF.C.NetConnTag.DualConnContext." + o.this.f248855e.p(), 1, "checkDualConnPing: setMainSocketEngineId" + i16);
                    o.this.f(i16);
                }
                this.f248898a = i3;
                try {
                    t.f250069a0 = false;
                    notifyAll();
                } catch (Exception unused) {
                }
            }
            o.this.b(false);
            c(i3, i16);
        }

        private void a(int i3, long j3) {
            c(i3);
            o.this.f248857g.postDelayed(this.f248900c[i3], j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class k implements Runnable {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            n i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (o.this.f248853c.getStatReporter() != null && (i3 = o.this.i()) != null) {
                o.this.f248853c.getStatReporter().a(i3.m(), i3.s());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public o(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar, t tVar, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfCore, aVar, tVar, handler);
            return;
        }
        this.f248851a = null;
        this.f248852b = null;
        this.f248856f = null;
        this.f248858h = new j();
        this.f248859i = new ArrayList<>();
        this.f248860j = new AtomicInteger(0);
        this.f248861k = new long[2];
        this.f248862l = new long[2];
        this.f248863m = false;
        this.f248864n = false;
        this.f248865o = new AtomicBoolean(false);
        this.f248866p = 0L;
        this.f248867q = new ArrayList<>();
        this.f248868r = 0L;
        this.f248869s = 0L;
        this.f248870t = 0L;
        this.f248871u = 0L;
        this.f248872v = new ArrayList<>();
        this.f248873w = new ArrayList<>();
        this.f248874x = null;
        this.f248875y = 0L;
        this.f248876z = false;
        this.A = null;
        this.B = 0L;
        this.C = new AtomicBoolean(false);
        this.D = 0;
        this.E = false;
        this.F = false;
        this.G = 0L;
        this.H = new k();
        this.f248853c = msfCore;
        this.f248854d = aVar;
        this.f248855e = tVar;
        int b16 = (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || com.tencent.mobileqq.msf.core.b.f().g()) ? com.tencent.mobileqq.msf.core.b.f().b() : 2;
        for (int i3 = 0; i3 < b16; i3++) {
            this.f248859i.add(i3, new n(msfCore, aVar, tVar, i3));
        }
        this.f248857g = handler;
    }

    private static String k() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), Constants.KEYS.PLACEMENTS).getInputStream()));
            int i3 = 0;
            int i16 = 1;
            for (String str : bufferedReader.readLine().split("\\s+")) {
                if (str.equalsIgnoreCase("PID")) {
                    i16 = i3;
                }
                i3++;
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.contains(BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump") && !readLine.contains("sh -c")) {
                        String[] split = readLine.split("\\s+");
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.NetConnTag.", 2, "tcpdump uid:" + split[i16]);
                        }
                        bufferedReader.close();
                        return split[i16];
                    }
                } else {
                    bufferedReader.close();
                    return null;
                }
            }
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag.", 2, "Error killing tcpdump, msg=" + e16.getMessage());
                return null;
            }
            return null;
        }
    }

    private static boolean o() {
        if (k() != null) {
            return true;
        }
        return false;
    }

    private boolean q() throws Exception {
        return a((com.tencent.mobileqq.msf.core.d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag.", 2, "tcpdump: stopTCPDump begin");
        }
        try {
            String k3 = k();
            if (k3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "tcpdump: stopTCPDump pid not find");
                    return;
                }
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"su", LogCmdOptions.CLEAR, "kill " + k3}).getErrorStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag.", 2, "tcpdump kill error=" + readLine);
                    }
                } else {
                    bufferedReader.close();
                    return;
                }
            }
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag.", 2, "tcpdump Error killing tcpdump, msg=" + e16.getMessage());
            }
        }
    }

    private void u() {
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag.", 2, "tcpdump Report begin");
        }
        if (this.A != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag.", 2, "tcpdump tcpDumpReportThread started return");
            }
        } else {
            e eVar = new e();
            this.A = eVar;
            eVar.setName("tcpDumpReportThread");
            this.A.start();
        }
    }

    public InetSocketAddress g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (InetSocketAddress) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return i().t();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        try {
            return i().k();
        } catch (Exception unused) {
            QLog.e("MSF.C.NetConnTag.", 1, "[getIsPingOk] error");
            return false;
        }
    }

    public n i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (n) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return c(j());
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248860j.get();
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            return i().j();
        } catch (Exception unused) {
            QLog.e("MSF.C.NetConnTag.", 1, "[isConned] error");
            return false;
        }
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (l() && this.f248868r == 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.f248858h.a() == 1) {
            return true;
        }
        return false;
    }

    public void p() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.f248868r != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "loginConnectTimeOut Report now");
            }
            long j16 = this.f248869s;
            long j17 = this.f248868r;
            if (j16 >= j17) {
                if (this.f248871u == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
                    }
                    r();
                    this.f248870t = 0L;
                    return;
                }
                j3 = j16 - j17;
                com.tencent.mobileqq.msf.core.net.s.k t16 = this.f248854d.t();
                if (t16 != null) {
                    t16.b();
                }
            } else {
                j3 = -1;
            }
            long j18 = j3;
            if (this.f248853c.getStatReporter() != null) {
                this.f248853c.getStatReporter().a(false, j18, -1L, -1L, this.f248870t, false, this.f248867q, this.f248854d.s().h(), this.f248854d.s().f(), this.f248854d.s().e());
            }
            r();
            this.f248870t = 0L;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "loginConnectTimeOut m_startConnectTime : " + this.f248868r + "no need Report");
        }
        r();
        this.f248870t = 0L;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.f248871u = 0L;
        this.f248868r = 0L;
        this.f248869s = 0L;
        this.f248870t = 0L;
        this.f248867q.clear();
        if (this.f248854d.s() != null) {
            this.f248854d.s().b(2);
        }
        if (this.f248856f != null) {
            this.f248854d.p().b(this.f248856f);
            this.f248856f = null;
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (o()) {
            if (System.currentTimeMillis() - this.B > com.tencent.mobileqq.msf.core.x.b.R0()) {
                s();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag.", 2, "tcpdump is running return");
                return;
            }
            return;
        }
        f fVar = new f();
        fVar.setName("tcpDumpThread");
        fVar.start();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? i().f248818t : ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 < 0 || i3 >= this.f248859i.size()) {
            return;
        }
        QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "[setMainSocketEngineId] mainConnID: " + i3);
        this.f248860j.set(i3);
    }

    public n c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (n) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 < 0 || i3 >= this.f248859i.size()) {
            return null;
        }
        return this.f248859i.get(i3);
    }

    public boolean d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        try {
            return c(i3).j();
        } catch (Exception unused) {
            QLog.e("MSF.C.NetConnTag.", 1, "[isConned] error");
            return false;
        }
    }

    public void e(int i3) {
        int i16 = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i16);
            return;
        }
        b(i16, true);
        this.f248862l[i16] = SystemClock.elapsedRealtime();
        if (this.f248858h.a() != 1) {
            QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "onSingleConnPing");
            return;
        }
        int i17 = i16 == 0 ? 1 : 0;
        int f16 = this.f248859i.get(i16).f();
        if (f16 != 1) {
            int i18 = i17;
            i17 = i16;
            i16 = i18;
        }
        long b16 = b(i16);
        long b17 = b(i17);
        long g16 = this.f248854d.s().g();
        QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: delayIpRace: " + g16 + ", curIpFamily: " + f16 + ", v4ConnId = " + i16 + ", v6ConnId" + i17);
        if (b16 > 0 && b17 > 0) {
            QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: all ok");
            if (b16 + g16 <= b17) {
                QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: choose v4");
                this.f248858h.b(-1, i17);
                this.f248858h.b(3, i16);
                return;
            }
            QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: choose v6");
            this.f248858h.b(-1, i16);
            this.f248858h.b(3, i17);
            return;
        }
        if (g16 > 0) {
            if (b16 > 0 && b17 <= 0) {
                QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: v4 ok, wait v6..");
                this.f248858h.a(3, i16, g16);
                return;
            }
            if (b17 <= 0 || b16 > 0) {
                return;
            }
            QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: v6 ok, close v4");
            this.f248858h.b(-1, i16);
            this.f248858h.b(3, i17);
            return;
        }
        if (b16 > 0 && b17 <= 0) {
            QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: v4 ok, close v6");
            this.f248858h.b(-1, i17);
            this.f248858h.b(3, i16);
            return;
        }
        if (b17 <= 0 || b16 > 0) {
            return;
        }
        QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "checkDualConnPing: v6 ok, wait v4..");
        this.f248858h.a(3, i17, -g16);
    }

    private void c() {
        h hVar = new h();
        hVar.setName("checkNetConnectByHttpThread");
        hVar.start();
        this.C.set(true);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.f248867q.size() > 0) {
            ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList = this.f248867q;
            com.tencent.mobileqq.msf.core.net.b bVar = arrayList.get(arrayList.size() - 1);
            if (bVar != null) {
                bVar.f248722e = q.f248947y;
                bVar.f248721d = false;
                bVar.f248729l = 0;
                bVar.f248730m = 1;
            }
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? i().f248817s : ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
    }

    public long b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f248862l[i3] - this.f248861k[i3] : ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
    }

    public void b(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            if (c(i3) == null) {
                return;
            }
            c(i3).b(z16);
        }
    }

    public void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        long j3;
        long j16;
        com.tencent.mobileqq.msf.core.net.s.k t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fromServiceMsg, (Object) toServiceMsg);
            return;
        }
        if (this.f248868r != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "firstResponseGetted getted Report now");
            }
            long j17 = this.f248869s;
            long j18 = this.f248868r;
            long j19 = j17 >= j18 ? j17 - j18 : -1L;
            if (fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF) == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "from msg TIMESTAMP_NET2MSF not find return");
                }
                r();
                this.f248870t = 0L;
                return;
            }
            long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - this.f248869s;
            if (toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
                }
                j16 = 0;
                j3 = longValue;
            } else {
                long longValue2 = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                j3 = longValue;
                long longValue3 = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - longValue2;
                if (longValue3 < 0 || longValue2 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "nFirstPacketTimeElapse:" + longValue3 + " reset 0 now TIMESTAMP_NET2MSF:" + this.f248853c.timeFormatter.format(fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)) + " TIMESTAMP_MSF2NET:" + this.f248853c.timeFormatter.format(toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)));
                    }
                    j16 = 0;
                } else {
                    j16 = longValue3;
                }
            }
            boolean equals = fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_AUTH);
            if (this.f248867q.size() > 0) {
                ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList = this.f248867q;
                com.tencent.mobileqq.msf.core.net.b bVar = arrayList.get(arrayList.size() - 1);
                bVar.f248730m = 1;
                bVar.f248729l = 1;
                if (this.f248853c.getStatReporter() != null) {
                    this.f248853c.getStatReporter().a(true, j19, j3, j16, this.f248870t, equals, this.f248867q, this.f248854d.s().h(), this.f248854d.s().f(), this.f248854d.s().e());
                }
            }
            r();
            this.f248870t = 0L;
            if (this.f248855e.p()) {
                NetConnInfoCenter.onRecvFirstResp();
                if (!r.l().B() || (t16 = this.f248854d.t()) == null) {
                    return;
                }
                t16.a(r.l().r());
            }
        }
    }

    private synchronized void b() {
        if (this.f248874x != null) {
            return;
        }
        if (com.tencent.mobileqq.msf.core.x.b.S0() == 0) {
            return;
        }
        String T0 = com.tencent.mobileqq.msf.core.x.b.T0();
        if (T0 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "TcpdumpSSOVip is empty");
            }
            return;
        }
        this.f248872v.clear();
        for (String str : T0.split(";")) {
            i iVar = new i();
            iVar.f248894a = str;
            iVar.f248895b = (byte) 1;
            iVar.f248896c = "";
            this.f248872v.add(iVar);
        }
        d dVar = new d();
        this.f248874x = dVar;
        dVar.setName("checkNetConnectByConnectSSOThread");
        this.f248874x.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag.", 2, "copy tcpdump file...");
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                inputStream = context.getAssets().open("tcpdump");
                try {
                    fileOutputStream = new FileOutputStream(context.getFilesDir().getParent() + "/txlib/tcpdump");
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        inputStream.close();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream2 = fileOutputStream;
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.NetConnTag.", 2, "tcpdump: copyTcpdumpFile exception" + e, e);
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream = fileOutputStream2;
                            fileOutputStream.close();
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Exception e18) {
                e = e18;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
            fileOutputStream.close();
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private void b(String str) {
        g gVar = new g(str);
        gVar.setName("pingServerThread");
        gVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "NetChanged selectAndConnect...");
        }
        long[] jArr = this.f248861k;
        long[] jArr2 = this.f248862l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        jArr2[i3] = elapsedRealtime;
        jArr[i3] = elapsedRealtime;
        NetConnInfoCenter.checkConnInfo();
        boolean z19 = true;
        loop0: while (true) {
            z16 = false;
            while (z19) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "NetChanged start connect...");
                }
                try {
                    if (com.tencent.mobileqq.msf.core.net.k.e() && copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                        R = com.tencent.mobileqq.msf.core.c0.j.b(false, Q, SystemClock.elapsedRealtime());
                        int a16 = a(copyOnWriteArrayList, arrayList, i3, true);
                        z18 = a16 == 0;
                        if (a16 == 1) {
                            z19 = z18;
                            z16 = true;
                        }
                    } else if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                        z19 = false;
                    } else {
                        R = com.tencent.mobileqq.msf.core.c0.j.b(false, Q, SystemClock.elapsedRealtime());
                        if (com.tencent.mobileqq.msf.core.net.k.c() != null) {
                            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
                            Iterator<com.tencent.mobileqq.msf.core.d> it = copyOnWriteArrayList2.iterator();
                            while (it.hasNext()) {
                                com.tencent.mobileqq.msf.core.d next = it.next();
                                if (next.f247933j == 1) {
                                    copyOnWriteArrayList3.add(next);
                                }
                            }
                            int a17 = a(copyOnWriteArrayList3, arrayList, i3, false);
                            boolean z26 = a17 == 0;
                            boolean z27 = a17 == 1;
                            if (a17 == -1) {
                                try {
                                    int a18 = a(copyOnWriteArrayList2, arrayList, i3, false);
                                    z18 = a18 == 0;
                                    if (a18 != 1) {
                                        break;
                                    }
                                    z19 = z18;
                                    z16 = true;
                                } catch (Exception e16) {
                                    e = e16;
                                    boolean z28 = z27;
                                    z17 = z26;
                                    z16 = z28;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "selectAndConnect error " + e, e);
                                    }
                                    z19 = z17;
                                }
                            } else {
                                z19 = z26;
                                z16 = z27;
                            }
                        } else {
                            int a19 = a(copyOnWriteArrayList2, arrayList, i3, false);
                            z18 = a19 == 0;
                            if (a19 != 1) {
                                break;
                            }
                            z19 = z18;
                            z16 = true;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    z17 = false;
                }
            }
            z19 = z18;
        }
        if (this.C.get() && this.E && !this.F && this.f248873w.size() > 0) {
            this.C.set(false);
            this.E = false;
            this.F = false;
            long currentTimeMillis = System.currentTimeMillis() - this.G;
            if (this.f248853c.getStatReporter() != null) {
                this.f248853c.getStatReporter().a(l(), this.D, currentTimeMillis, this.f248873w);
            }
            this.f248873w.clear();
        }
        return z16;
    }

    private boolean a(com.tencent.mobileqq.msf.core.d dVar) throws Exception {
        long j3;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a16;
        boolean z16;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList3;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList4;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList5;
        boolean z17;
        String str;
        String str2;
        String str3;
        ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList;
        boolean a17;
        long elapsedRealtime;
        long j16;
        boolean z18;
        ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList2;
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList6;
        if (!AppNetConnInfo.isNetSupport() && com.tencent.mobileqq.msf.core.m.i().b() && MsfSdkUtils.isAirplaneModeOn(BaseApplication.getContext())) {
            QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "block open connect because of airplane mode");
            return false;
        }
        com.tencent.mobileqq.msf.core.h0.c wakeUpLockManager = this.f248853c.getWakeUpLockManager();
        if (wakeUpLockManager != null) {
            wakeUpLockManager.b();
        }
        String a18 = com.tencent.mobileqq.msf.core.e0.k.c().a();
        if (a18.length() > 0) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f248868r = currentTimeMillis;
                this.f248869s = currentTimeMillis;
                com.tencent.mobileqq.msf.core.net.b bVar = new com.tencent.mobileqq.msf.core.net.b();
                bVar.f248719b = a18;
                bVar.f248724g = NetConnInfoCenter.getSystemNetworkType();
                bVar.f248727j = 0;
                bVar.f248728k = 0;
                bVar.f248729l = 0;
                bVar.f248730m = 0;
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "conn assigned server " + a18);
                }
                com.tencent.mobileqq.msf.core.d a19 = com.tencent.mobileqq.msf.core.d.a(a18);
                a19.b(true);
                a19.c(true);
                a(a19, bVar, 0);
                this.f248855e.g();
                if (this.f248855e.p() && bVar.f248722e == q.f248925c) {
                    com.tencent.mobileqq.msf.core.e0.i.t();
                    NetConnInfoCenter.onConnOpened();
                    return true;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "conn assigned server " + a18 + " error " + e16, e16);
                }
            }
            return false;
        }
        if (dVar != null) {
            try {
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "[mainSocketEngineOpenConn] info: ", dVar);
                com.tencent.mobileqq.msf.core.net.b bVar2 = new com.tencent.mobileqq.msf.core.net.b();
                bVar2.f248719b = dVar.b();
                bVar2.f248724g = NetConnInfoCenter.getSystemNetworkType();
                bVar2.f248727j = 0;
                bVar2.f248728k = 0;
                bVar2.f248729l = 0;
                bVar2.f248730m = 0;
                a(dVar, bVar2, 0);
                this.f248855e.g();
            } catch (Throwable th5) {
                QLog.e("MSF.C.NetConnTag." + this.f248855e.p(), 1, "[mainSocketEngineOpenConn] error: ", th5);
            }
            return false;
        }
        this.f248864n = false;
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        boolean z19 = this.f248863m;
        ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList3 = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList4 = new ArrayList<>();
        long currentTimeMillis2 = System.currentTimeMillis();
        this.f248868r = currentTimeMillis2;
        this.f248869s = currentTimeMillis2;
        NetConnInfoCenter.checkConnInfo();
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        this.f248865o.set(false);
        String str4 = com.tencent.mobileqq.msf.core.x.q.f250394z;
        if (3 == activeNetIpFamily && !z19) {
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a26 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a27 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a28 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), false);
            j3 = elapsedRealtime2;
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a29 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), false);
            boolean z26 = (a28 == null || a28.size() <= 0) && (a29 == null || a29.size() <= 0);
            copyOnWriteArrayList3 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250394z), z26);
            copyOnWriteArrayList2 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250394z), z26);
            z16 = (NetConnInfoCenter.isWifiConn() && a26 != null && a26.size() > 0 && copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) || !(NetConnInfoCenter.isWifiConn() || a27 == null || a27.size() <= 0 || copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0);
            boolean z27 = (a26 == null || a26.size() <= 0) && (a27 == null || a27.size() <= 0) && ((copyOnWriteArrayList3 == null || copyOnWriteArrayList3.size() <= 0) && (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0));
            if (z16 || z27) {
                a16 = null;
                copyOnWriteArrayList6 = null;
            } else {
                a16 = (copyOnWriteArrayList3 == null || copyOnWriteArrayList3.size() <= 0) ? null : copyOnWriteArrayList3;
                if (a26 != null && a26.size() > 0) {
                    a16 = a26;
                }
                copyOnWriteArrayList6 = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : copyOnWriteArrayList2;
                if (a27 != null && a27.size() > 0) {
                    copyOnWriteArrayList6 = a27;
                }
            }
            copyOnWriteArrayList4 = a26;
            copyOnWriteArrayList = copyOnWriteArrayList6;
            z17 = z27;
            copyOnWriteArrayList5 = a27;
        } else {
            j3 = elapsedRealtime2;
            if (2 != activeNetIpFamily) {
                str4 = com.tencent.mobileqq.msf.core.x.q.f250393y;
            }
            a16 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250391w, str4), true);
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a36 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250392x, str4), true);
            if ((a16 == null || a16.size() <= 0) && (a36 == null || a36.size() <= 0)) {
                z16 = false;
                copyOnWriteArrayList = a36;
                copyOnWriteArrayList2 = null;
                copyOnWriteArrayList3 = null;
                copyOnWriteArrayList4 = null;
                copyOnWriteArrayList5 = null;
                z17 = true;
            } else {
                z16 = false;
                copyOnWriteArrayList = a36;
                copyOnWriteArrayList2 = null;
                copyOnWriteArrayList3 = null;
                copyOnWriteArrayList4 = null;
                copyOnWriteArrayList5 = null;
                z17 = false;
            }
        }
        if (z17) {
            QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "mainSocketEngineOpenConn with ipFamily = " + activeNetIpFamily + "but no available sso list");
            j16 = 0L;
            str = com.tencent.mobileqq.msf.core.x.q.f250393y;
            str2 = com.tencent.mobileqq.msf.core.x.q.f250391w;
            str3 = com.tencent.mobileqq.msf.core.x.q.f250392x;
            a17 = false;
            z18 = false;
            arrayList = arrayList3;
        } else {
            if (z16) {
                String str5 = "MSF.C.NetConnTag." + this.f248855e.p();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mainSocketEngineOpenConn with ipFamily = ");
                sb5.append(activeNetIpFamily);
                sb5.append(", wifiIpv4SsoListSize=");
                sb5.append(copyOnWriteArrayList4 == null ? "null" : Integer.valueOf(copyOnWriteArrayList4.size()));
                sb5.append(", mobileIpv4SsoListSize=");
                sb5.append(copyOnWriteArrayList5 == null ? "null" : Integer.valueOf(copyOnWriteArrayList5.size()));
                sb5.append(", wifiIpv6SsoListSize=");
                sb5.append(copyOnWriteArrayList3 == null ? "null" : Integer.valueOf(copyOnWriteArrayList3.size()));
                sb5.append(", mobileIpv6SsoListSize=");
                sb5.append(copyOnWriteArrayList2 != null ? Integer.valueOf(copyOnWriteArrayList2.size()) : "null");
                sb5.append(", try dual conn");
                QLog.d(str5, 1, sb5.toString());
                j jVar = this.f248858h;
                CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList7 = copyOnWriteArrayList3;
                str = com.tencent.mobileqq.msf.core.x.q.f250393y;
                CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList8 = copyOnWriteArrayList2;
                str2 = com.tencent.mobileqq.msf.core.x.q.f250391w;
                str3 = com.tencent.mobileqq.msf.core.x.q.f250392x;
                a17 = jVar.a(copyOnWriteArrayList4, copyOnWriteArrayList5, copyOnWriteArrayList7, copyOnWriteArrayList8, arrayList3, arrayList4);
                elapsedRealtime = SystemClock.elapsedRealtime() - j3;
                arrayList = arrayList3;
            } else {
                str = com.tencent.mobileqq.msf.core.x.q.f250393y;
                str2 = com.tencent.mobileqq.msf.core.x.q.f250391w;
                str3 = com.tencent.mobileqq.msf.core.x.q.f250392x;
                arrayList = arrayList3;
                a17 = a(activeNetIpFamily, a16, copyOnWriteArrayList, arrayList);
                elapsedRealtime = SystemClock.elapsedRealtime() - j3;
                b(false);
            }
            j16 = elapsedRealtime;
            z18 = true;
        }
        if (this.f248853c.getStatReporter() != null) {
            arrayList2 = arrayList;
            this.f248853c.getStatReporter().a(a17, z16, this.f248865o.get(), j16, this.f248860j.get(), arrayList2, arrayList4);
        } else {
            arrayList2 = arrayList;
        }
        Iterator<com.tencent.mobileqq.msf.core.net.b> it = arrayList2.iterator();
        loop0: while (true) {
            boolean z28 = false;
            while (it.hasNext()) {
                com.tencent.mobileqq.msf.core.net.b next = it.next();
                q qVar = next.f248722e;
                if (qVar != q.f248935m && qVar != q.f248941s && qVar != q.f248931i && qVar != q.f248937o && qVar != q.f248938p && qVar != q.f248939q && qVar != q.f248947y) {
                    if (this.f248868r == 0) {
                        long j17 = next.f248726i;
                        this.f248868r = j17;
                        this.f248869s = j17;
                    }
                    if (!z28) {
                        this.f248870t = this.f248869s - this.f248868r;
                    }
                    if (this.f248856f == null) {
                        this.f248856f = this.f248854d.p().a(this, MiniBoxNoticeInfo.MIN_5);
                    }
                    this.f248867q.add(next);
                } else {
                    this.f248870t = this.f248869s - this.f248868r;
                    r();
                    z28 = true;
                }
            }
            break loop0;
        }
        if (!a17) {
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - j3;
            if (NetConnInfoCenter.isWifiOrMobileConn() && z18) {
                a(true);
                if (this.f248853c.getStatReporter() != null) {
                    this.f248853c.getStatReporter().a(false, false, false, elapsedRealtime3, arrayList2);
                }
            }
            if (this.f248855e.p()) {
                NetConnInfoCenter.onOepnConnAllFailed();
                this.f248854d.t().a();
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (NetConnInfoCenter.isWifiConn() || (!NetConnInfoCenter.isWifiOrMobileConn() && NetConnInfoCenter.getCurrentAPN() == null)) {
                if (currentTimeMillis3 - this.f248854d.s().j() < 60000) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<com.tencent.mobileqq.msf.core.d> it5 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, str2, str), true).iterator();
                    while (it5.hasNext()) {
                        com.tencent.mobileqq.msf.core.d next2 = it5.next();
                        if (next2 != null) {
                            stringBuffer.append(next2.toString() + ";");
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (this.f248853c.getStatReporter() != null) {
                        this.f248853c.getStatReporter().a(false, currentTimeMillis3 - this.f248854d.s().j(), stringBuffer2);
                    }
                    this.f248854d.s().c(0L);
                }
            } else if (currentTimeMillis3 - this.f248854d.s().i() < 60000) {
                StringBuffer stringBuffer3 = new StringBuffer();
                Iterator<com.tencent.mobileqq.msf.core.d> it6 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, str3, str), true).iterator();
                while (it6.hasNext()) {
                    com.tencent.mobileqq.msf.core.d next3 = it6.next();
                    if (next3 != null) {
                        stringBuffer3.append(next3.toString() + ";");
                    }
                }
                String stringBuffer4 = stringBuffer3.toString();
                if (this.f248853c.getStatReporter() != null) {
                    this.f248853c.getStatReporter().a(false, currentTimeMillis3 - this.f248854d.s().i(), stringBuffer4);
                }
                this.f248854d.s().b(0L);
            }
            QLog.e("MSF.C.NetConnTag." + this.f248855e.p(), 1, "mainSocketEngineOpenConn fail, netType:" + NetConnInfoCenter.getActiveNetworkType() + ", IpFamily:" + NetConnInfoCenter.getActiveNetIpFamily(true));
            return a17;
        }
        if (this.f248855e.p()) {
            com.tencent.mobileqq.msf.core.e0.i.t();
            NetConnInfoCenter.onConnOpened();
        }
        NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
        this.f248855e.g();
        if (!NetConnInfoCenter.isWifiOrMobileConn()) {
            NetConnInfoCenter.setLastConnSuccWithoutNet();
        }
        if (NetConnInfoCenter.isWifiOrMobileConn() && this.f248853c.getStatReporter() != null) {
            this.f248853c.getStatReporter().a(false, false, a17, j16, arrayList2);
        }
        n i3 = i();
        if (i3 != null) {
            String i16 = i3.i();
            if (!TextUtils.isEmpty(i16)) {
                this.f248853c.setGatewayIp(i16);
            } else {
                i3.a(new a(i3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "mainSocketEngineOpenConn success, server:" + i3.t().toString() + ", GatewayIp:" + i16 + ", connSeq:" + MsfService.getCore().getMsfNetService().l() + ", mainSocketEngineId:" + i3.e() + ", mainSocketEngineHashCode:" + Integer.toHexString(i3.hashCode()));
                return true;
            }
            QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "mainSocketEngineOpenConn success, server=" + com.tencent.mobileqq.msf.core.z.a.a(i3.t().toString()) + ", GatewayIp=" + com.tencent.mobileqq.msf.core.z.a.a(i16) + ", connSeq:" + MsfService.getCore().getMsfNetService().l() + ", mainSocketEngineId:" + i3.e() + ", mainSocketEngineHashCode:" + Integer.toHexString(i3.hashCode()));
            return true;
        }
        QLog.e("MSF.C.NetConnTag." + this.f248855e.p(), 1, "mainSocketEngineOpenConn success, but mainSocketEngine is null, mainSocketEngineId:" + j());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z16) {
        if (this.f248864n) {
            return;
        }
        this.f248864n = true;
        this.f248857g.removeCallbacks(this.H);
        if (z16) {
            n i3 = i();
            if (i3 != null) {
                this.f248853c.getStatReporter().a(i3.m(), i3.s());
                return;
            }
            return;
        }
        this.f248857g.postDelayed(this.H, 120000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i3, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList) {
        String str;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        Object valueOf;
        com.tencent.mobileqq.msf.core.net.a aVar;
        int a16;
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(N, 0);
        int i16 = sharedPreferences.getInt(P, 0);
        int i17 = sharedPreferences.getInt(O, 0);
        if (a(i16, i17)) {
            String str4 = "MSF.C.NetConnTag." + this.f248855e.p();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mainSocketEngineOpenConn with ipFamily = ");
            sb5.append(i3);
            sb5.append(", wifiSsoList=");
            if (copyOnWriteArrayList == null) {
                str3 = ", wifiSsoList=";
                valueOf = "null";
            } else {
                str3 = ", wifiSsoList=";
                valueOf = Integer.valueOf(copyOnWriteArrayList.size());
            }
            sb5.append(valueOf);
            sb5.append(", mobileSsoList=");
            sb5.append(copyOnWriteArrayList2 == null ? "null" : Integer.valueOf(copyOnWriteArrayList2.size()));
            sb5.append(", loopTimeOutCnt: ");
            sb5.append(i17);
            sb5.append(", errorCnt: ");
            sb5.append(i16);
            sb5.append(", try complex conn");
            QLog.d(str4, 1, sb5.toString());
            try {
                if (this.f248852b == null) {
                    this.f248852b = ProxyExecutors.newFixedThreadPool(com.tencent.mobileqq.msf.core.b.f().b());
                }
                str = ", errorCnt: ";
                try {
                    str2 = ", loopTimeOutCnt: ";
                    try {
                        aVar = new com.tencent.mobileqq.msf.core.net.a(this.f248853c, this.f248855e, this.f248852b, this.f248859i);
                        a16 = aVar.a(copyOnWriteArrayList, copyOnWriteArrayList2);
                    } catch (Exception e16) {
                        e = e16;
                        arrayList.clear();
                        QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "mainSocketEngineOpenConn try complex error, ", e);
                        z17 = false;
                        if (!z17) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    str2 = ", loopTimeOutCnt: ";
                    arrayList.clear();
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "mainSocketEngineOpenConn try complex error, ", e);
                    z17 = false;
                    if (!z17) {
                    }
                }
            } catch (Exception e18) {
                e = e18;
                str = ", errorCnt: ";
            }
            if (a16 == 3 && aVar.c() != -1) {
                this.f248865o.set(true);
                W = n.V;
                f(aVar.c());
                arrayList.addAll(aVar.b());
                if (i16 != 0) {
                    sharedPreferences.edit().putInt(P, 0).apply();
                }
                if (i17 != 0) {
                    sharedPreferences.edit().putInt(O, 0).apply();
                }
                z16 = true;
                z17 = z16;
                if (!z17) {
                    return z17;
                }
                String str5 = "MSF.C.NetConnTag." + this.f248855e.p();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("mainSocketEngineOpenConn with ipFamily = ");
                sb6.append(i3);
                sb6.append(str3);
                sb6.append(copyOnWriteArrayList == null ? "null" : Integer.valueOf(copyOnWriteArrayList.size()));
                sb6.append(", mobileSsoList=");
                sb6.append(copyOnWriteArrayList2 != null ? Integer.valueOf(copyOnWriteArrayList2.size()) : "null");
                sb6.append(str2);
                sb6.append(i17);
                sb6.append(str);
                sb6.append(i16);
                sb6.append(", try single conn");
                QLog.d(str5, 1, sb6.toString());
                this.f248865o.set(false);
                f(0);
                return b(copyOnWriteArrayList, copyOnWriteArrayList2, arrayList, 0);
            }
            if (a16 == -2) {
                i16++;
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "complex connect error, errorCnt: " + i16);
                sharedPreferences.edit().putInt(P, i16).apply();
            } else if (a16 == -3) {
                i17++;
                QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "complex connect loopTimeOut, loopTimeOutCnt: " + i17);
                sharedPreferences.edit().putInt(O, i17).apply();
            }
        } else {
            str = ", errorCnt: ";
            str2 = ", loopTimeOutCnt: ";
            str3 = ", wifiSsoList=";
        }
        z16 = false;
        z17 = z16;
        if (!z17) {
        }
    }

    private boolean a(int i3, int i16) {
        return (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && com.tencent.mobileqq.msf.core.b.f().h()) || (com.tencent.mobileqq.msf.core.b.f().g() && i3 < com.tencent.mobileqq.msf.core.b.f().c() && i16 < com.tencent.mobileqq.msf.core.b.f().e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, int i3) {
        if (this.f248851a == null) {
            this.f248851a = ProxyExecutors.newFixedThreadPool(2);
        }
        this.f248858h.b(1, i3);
        this.f248851a.submit(new b(i3, copyOnWriteArrayList, copyOnWriteArrayList2, arrayList));
    }

    private void a(boolean z16) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f248866p;
        if (j3 == 0 || elapsedRealtime - j3 > Long.parseLong(com.tencent.mobileqq.msf.core.x.b.u())) {
            this.f248866p = elapsedRealtime;
            StringBuffer stringBuffer = new StringBuffer();
            if (NetConnInfoCenter.isWifiConn()) {
                Iterator<com.tencent.mobileqq.msf.core.d> it = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), true).iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.msf.core.d next = it.next();
                    stringBuffer.append(next.e() + "//" + next.b() + ":" + next.d() + ",");
                }
            } else {
                Iterator<com.tencent.mobileqq.msf.core.d> it5 = this.f248854d.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250388t, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true).iterator();
                while (it5.hasNext()) {
                    com.tencent.mobileqq.msf.core.d next2 = it5.next();
                    stringBuffer.append(next2.e() + "//" + next2.b() + ":" + next2.d() + ",");
                }
            }
            try {
                this.f248854d.s().a(BaseApplication.getContext().getAppId(), com.tencent.mobileqq.msf.core.e0.i.i(), 60000L, NetConnInfoCenter.isWifiConn(), stringBuffer.toString(), z16);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, e16.toString(), e16);
                }
            }
        }
    }

    private void a(String str, int i3) {
        c cVar = new c(str, i3);
        cVar.setName("checkNetConnectBySocketThread");
        cVar.start();
    }

    private void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f248875y > 180000) {
            this.f248875y = currentTimeMillis;
            c();
            a("3gimg.qq.com", 80);
            a("120.33.50.146", 80);
            b();
            b(str.split(":")[0].trim());
        }
    }

    private int a(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, int i3, boolean z16) {
        int i16 = 0;
        int i17 = 0;
        while (i16 < copyOnWriteArrayList.size()) {
            try {
                com.tencent.mobileqq.msf.core.d dVar = copyOnWriteArrayList.get(i16);
                NetConnInfoCenter.checkConnInfo();
                if (com.tencent.mobileqq.msf.core.net.k.a(dVar)) {
                    return 0;
                }
                com.tencent.mobileqq.msf.core.net.b a16 = a(arrayList, dVar, i3);
                if (a16.f248722e == q.f248925c) {
                    if (this.C.get()) {
                        this.C.set(false);
                    }
                    return 1;
                }
                if (!com.tencent.mobileqq.msf.core.x.m.j() || a16.f248722e != q.f248948z) {
                    q qVar = a16.f248722e;
                    if (qVar == q.f248935m) {
                        i16--;
                        i17++;
                        if (i17 > 3) {
                            this.C.set(false);
                        } else {
                            int i18 = a16.f248725h;
                            if (i18 > 0) {
                                LockMethodProxy.sleep(i18);
                                if ((z16 && !com.tencent.mobileqq.msf.core.net.k.e()) || (!z16 && com.tencent.mobileqq.msf.core.net.k.e())) {
                                    if (!QLog.isColorLevel()) {
                                        return 0;
                                    }
                                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "NetChanged from wifi to mobile connect again");
                                    return 0;
                                }
                            } else {
                                continue;
                            }
                        }
                    } else if ((qVar == q.f248942t || qVar == q.f248939q) && i16 == 0 && !this.C.get()) {
                        a(a16.f248719b);
                    }
                    i16++;
                }
                return 2;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 2, "selectAndConnect error " + e16, e16);
                }
            }
        }
        return -1;
    }

    private com.tencent.mobileqq.msf.core.net.b a(ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, com.tencent.mobileqq.msf.core.d dVar, int i3) {
        com.tencent.mobileqq.msf.core.net.b bVar = new com.tencent.mobileqq.msf.core.net.b();
        bVar.f248726i = System.currentTimeMillis();
        bVar.f248719b = dVar.n();
        bVar.f248724g = NetConnInfoCenter.getSystemNetworkType();
        bVar.f248727j = 0;
        bVar.f248728k = 0;
        bVar.f248729l = 0;
        bVar.f248730m = 0;
        a(dVar, bVar, i3);
        arrayList.add(bVar);
        return bVar;
    }

    private void a(com.tencent.mobileqq.msf.core.d dVar, com.tencent.mobileqq.msf.core.net.b bVar, int i3) {
        if (dVar.e().equalsIgnoreCase("http")) {
            this.f248859i.get(i3).a(dVar, new com.tencent.mobileqq.msf.core.net.d(this.f248853c, this.f248855e), bVar);
        } else {
            this.f248859i.get(i3).a(dVar, new p(this.f248853c, this.f248855e), bVar);
        }
        W = bVar.f248723f;
    }

    public boolean a(int i3, int i16, String str, String str2, MsfCommand msfCommand, String str3, int i17, byte[] bArr, ToServiceMsg toServiceMsg) throws Exception {
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, msfCommand, str3, Integer.valueOf(i17), bArr, toServiceMsg)).booleanValue();
        }
        this.f248858h.b();
        boolean j3 = i().j();
        if (!this.f248855e.p()) {
            com.tencent.mobileqq.msf.core.d g16 = i().g();
            j3 = j3 && g16 != null && g16.equals(this.f248854d.h());
        }
        if (j3) {
            bArr2 = bArr;
        } else {
            Q = SystemClock.elapsedRealtime();
            if (this.f248855e.p()) {
                toServiceMsg.setFirstPkgAfterConnOpen(true);
                q();
            } else {
                a(i().g());
            }
            byte[] e16 = this.f248855e.e(toServiceMsg);
            QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "p ok re1: [can not reuse old point]" + toServiceMsg.getRequestSsoSeq());
            bArr2 = e16;
        }
        int a16 = i().a(i3, i16, i17, str3, str, str2, msfCommand, bArr2, toServiceMsg);
        if (a16 != -100) {
            if (a16 != -200 && this.f248871u == 0 && this.f248868r != 0 && this.f248869s != 0) {
                this.f248871u = System.currentTimeMillis();
            }
            return true;
        }
        toServiceMsg.setFirstPkgAfterConnOpen(true);
        q();
        byte[] e17 = this.f248855e.e(toServiceMsg);
        QLog.d("MSF.C.NetConnTag." + this.f248855e.p(), 1, "p ok re2: " + toServiceMsg.getRequestSsoSeq());
        if (i().a(i3, i16, i17, str3, str, str2, msfCommand, e17, toServiceMsg) == -100) {
            return false;
        }
        if (this.f248871u == 0 && this.f248868r != 0 && this.f248869s != 0) {
            this.f248871u = System.currentTimeMillis();
        }
        return true;
    }

    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar);
            return;
        }
        b(true);
        if (aVar == com.tencent.qphone.base.a.closeBySSOPingTimeout && i().f() == 2) {
            this.f248863m = true;
        }
        for (int i3 = 0; i3 < this.f248859i.size(); i3++) {
            this.f248859i.get(i3).a(aVar);
        }
        this.f248858h.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        if (i3 < 0 || i3 >= 2) {
            return;
        }
        this.f248859i.get(i3).a(com.tencent.qphone.base.a.closeByPeerWinConnection);
    }

    public void a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (n()) {
            QLog.d("MSF.C.NetConnTag.DualConnContext." + this.f248855e.p(), 1, "onDualConnConnected: connId: " + i3 + ", success: " + z16);
            if (z16) {
                this.f248858h.a(2, i3, 10000L);
            } else {
                this.f248858h.b(-1, i3);
            }
        }
    }
}
