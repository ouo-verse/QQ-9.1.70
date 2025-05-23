package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.BuildConfig;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends SocketImpl {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: n, reason: collision with root package name */
    public static String f250735n = "notfound";

    /* renamed from: o, reason: collision with root package name */
    public static short f250736o = 0;

    /* renamed from: p, reason: collision with root package name */
    public static short f250737p = 1;

    /* renamed from: q, reason: collision with root package name */
    static ConcurrentHashMap<Integer, com.tencent.mobileqq.msf.sdk.utils.b> f250738q = null;

    /* renamed from: r, reason: collision with root package name */
    static ConcurrentHashMap<Integer, com.tencent.mobileqq.msf.sdk.utils.b> f250739r = null;

    /* renamed from: s, reason: collision with root package name */
    private static final int f250740s = 30000;

    /* renamed from: t, reason: collision with root package name */
    private static HandlerThread f250741t;

    /* renamed from: u, reason: collision with root package name */
    private static Handler f250742u;

    /* renamed from: v, reason: collision with root package name */
    private static int f250743v;

    /* renamed from: w, reason: collision with root package name */
    private static long f250744w;

    /* renamed from: x, reason: collision with root package name */
    private static long f250745x;

    /* renamed from: y, reason: collision with root package name */
    private static CopyOnWriteArrayList<String> f250746y;

    /* renamed from: a, reason: collision with root package name */
    private SocketImpl f250747a;

    /* renamed from: b, reason: collision with root package name */
    private Class f250748b;

    /* renamed from: c, reason: collision with root package name */
    public String f250749c;

    /* renamed from: d, reason: collision with root package name */
    public String f250750d;

    /* renamed from: e, reason: collision with root package name */
    public int f250751e;

    /* renamed from: f, reason: collision with root package name */
    public String f250752f;

    /* renamed from: g, reason: collision with root package name */
    public String f250753g;

    /* renamed from: h, reason: collision with root package name */
    public String f250754h;

    /* renamed from: i, reason: collision with root package name */
    public MonitorHttpInfo f250755i;

    /* renamed from: j, reason: collision with root package name */
    MonitorSocketInputStream f250756j;

    /* renamed from: k, reason: collision with root package name */
    MonitorSocketOutputStream f250757k;

    /* renamed from: l, reason: collision with root package name */
    String f250758l;

    /* renamed from: m, reason: collision with root package name */
    public Context f250759m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                BaseApplication.networkMonitorCallback.addHttpInfo(c.this.f250755i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f250761a;

        /* renamed from: b, reason: collision with root package name */
        private int f250762b;

        public b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f250761a = i3;
                this.f250762b = i16;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.mobileqq.msf.sdk.utils.b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i3 = this.f250761a;
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(MonitorSocketImplFactory.tag, 2, "taskRun keyHashCode is 0.");
                    return;
                }
                return;
            }
            short s16 = c.f250736o;
            int i16 = this.f250762b;
            if (s16 == i16) {
                bVar = c.f250739r.remove(Integer.valueOf(i3));
            } else if (c.f250737p == i16) {
                bVar = c.f250738q.remove(Integer.valueOf(i3));
            } else {
                bVar = null;
            }
            if (bVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(MonitorSocketImplFactory.tag, 2, "taskRun dataFlowItem is null.,type:" + this.f250762b + " ,keyhashCode:" + this.f250761a);
                    return;
                }
                return;
            }
            if (bVar.f250733k <= 0 || bVar.f250734l == null || System.currentTimeMillis() - bVar.f250733k >= 3000) {
                c.this.i();
                bVar.f250734l = null;
                BaseApplication.monitor.insertData(bVar);
                c.this.a(bVar);
                return;
            }
            c.f250742u.postDelayed(bVar.f250734l, 10000L);
            short s17 = c.f250736o;
            int i17 = this.f250762b;
            if (s17 == i17) {
                c.f250739r.put(Integer.valueOf(this.f250761a), bVar);
            } else if (c.f250737p == i17) {
                c.f250738q.put(Integer.valueOf(this.f250761a), bVar);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250738q = new ConcurrentHashMap<>();
        f250739r = new ConcurrentHashMap<>();
        f250741t = new BaseHandlerThread("MsfSocketTimeoutChecker");
        f250743v = 0;
        f250744w = 0L;
        f250745x = 0L;
        f250746y = new CopyOnWriteArrayList<>();
    }

    public c(Class cls, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, (Object) context);
            return;
        }
        this.f250749c = "";
        this.f250750d = "";
        this.f250753g = "";
        this.f250754h = "";
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            this.f250747a = (SocketImpl) declaredConstructor.newInstance(new Object[0]);
            this.f250759m = context;
            this.f250748b = cls;
            b();
            g();
            BaseApplication.httpMonitorBan = context.getSharedPreferences("StepUpdate", 4).getBoolean("httpMonitorBan", false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            a(cls, "wait", new Class[0]);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void b() {
        try {
            Method declaredMethod = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
            declaredMethod.setAccessible(true);
            ((SocketImpl) this).fd = (FileDescriptor) declaredMethod.invoke(this.f250747a, new Object[0]);
            this.f250753g = this.f250750d + ":" + this.f250751e + "_" + ((SocketImpl) this).fd.hashCode() + " ";
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Field declaredField = SocketImpl.class.getDeclaredField(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
                declaredField.setAccessible(true);
                declaredField.set(this.f250747a, ((SocketImpl) this).fd);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void d() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion()) {
            new Throwable("MonitorSocketDump").printStackTrace(printWriter);
        }
        String str = stringWriter.toString() + "_";
        this.f250754h = str;
        int lastIndexOf = str.lastIndexOf(BuildConfig.LIBRARY_PACKAGE_NAME);
        if (lastIndexOf <= 0) {
            lastIndexOf = this.f250754h.lastIndexOf("qq");
        }
        if (lastIndexOf <= 0) {
            lastIndexOf = this.f250754h.lastIndexOf("qzone");
        }
        if (lastIndexOf > 0) {
            int indexOf = this.f250754h.indexOf(")", lastIndexOf);
            if (indexOf > 0 && indexOf > lastIndexOf) {
                this.f250754h = this.f250754h.substring(lastIndexOf, indexOf + 1) + "_";
            } else {
                this.f250754h = this.f250754h.substring(lastIndexOf) + "_";
            }
        }
        if (((SocketImpl) this).fd != null) {
            this.f250753g = this.f250750d + ":" + this.f250751e + "_" + ((SocketImpl) this).fd.hashCode() + " ";
            return;
        }
        this.f250753g = this.f250750d + ":" + this.f250751e + "_ ";
    }

    private int e() {
        if (((SocketImpl) this).fd == null) {
            return -1;
        }
        try {
            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(((SocketImpl) this).fd)).intValue();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, th5.getMessage());
            }
            return -1;
        }
    }

    private boolean h() {
        if (((SocketImpl) this).fd == null) {
            return false;
        }
        try {
            Method declaredMethod = FileDescriptor.class.getClassLoader().loadClass("java.io.FileDescriptor").getDeclaredMethod("isSocket$", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(((SocketImpl) this).fd, new Object[0])).booleanValue();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, th5.getMessage());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        MonitorHttpInfo monitorHttpInfo;
        String str = "";
        try {
            if (!BaseApplication.httpMonitorBan && (monitorHttpInfo = this.f250755i) != null) {
                if (BaseApplication.networkMonitorCallback != null) {
                    if (monitorHttpInfo.getFileType() == 1 || this.f250755i.getFileType() == 2) {
                        q.q().post(new a());
                        if (QLog.isColorLevel()) {
                            Object[] objArr = new Object[3];
                            objArr[0] = this.f250755i.toString();
                            objArr[1] = " ProcessName=";
                            String str2 = this.f250752f;
                            if (str2 == null) {
                                str2 = "";
                            }
                            objArr[2] = str2;
                            QLog.d(MonitorSocketImplFactory.tag, 2, objArr);
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = "report failed ";
                    objArr2[1] = this.f250755i.toString();
                    objArr2[2] = " ProcessName=";
                    String str3 = this.f250752f;
                    if (str3 == null) {
                        str3 = "";
                    }
                    objArr2[3] = str3;
                    QLog.d(MonitorSocketImplFactory.tag, 2, objArr2);
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                Object[] objArr3 = new Object[4];
                objArr3[0] = "report failed ";
                objArr3[1] = th5.toString();
                objArr3[2] = " ProcessName=";
                String str4 = this.f250752f;
                if (str4 != null) {
                    str = str4;
                }
                objArr3[3] = str;
                QLog.d(MonitorSocketImplFactory.tag, 2, objArr3);
            }
        }
    }

    @Override // java.net.SocketImpl
    protected void accept(SocketImpl socketImpl) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) socketImpl);
        }
    }

    @Override // java.net.SocketImpl
    protected int available() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        try {
            Method a16 = a(this.f250748b, "available", new Class[0]);
            a16.setAccessible(true);
            return ((Integer) a16.invoke(this.f250747a, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // java.net.SocketImpl
    protected void bind(InetAddress inetAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) inetAddress, i3);
            return;
        }
        try {
            Method a16 = a(this.f250748b, "bind", InetAddress.class, Integer.TYPE);
            a16.setAccessible(true);
            a16.invoke(this.f250747a, inetAddress, Integer.valueOf(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // java.net.SocketImpl
    protected void close() throws IOException {
        com.tencent.mobileqq.msf.sdk.utils.b remove;
        com.tencent.mobileqq.msf.sdk.utils.b remove2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            Method a16 = a(this.f250748b, "close", new Class[0]);
            a16.setAccessible(true);
            a16.invoke(this.f250747a, new Object[0]);
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, this.f250753g + " close MonitorSocket succ.");
            }
            e = null;
        } catch (Exception e16) {
            e = e16;
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, this.f250753g + "close MonitorSocket failed.", e);
            }
        }
        try {
            i();
            if (!f250738q.isEmpty() && (remove2 = f250738q.remove(Integer.valueOf(this.f250753g.hashCode()))) != null && !TextUtils.isEmpty(this.f250754h)) {
                if (TextUtils.isEmpty(remove2.f250730h) || remove2.f250730h.equals(f250735n)) {
                    String str = this.f250754h;
                    remove2.f250730h = str.substring(0, str.indexOf("_"));
                }
                BaseApplication.monitor.insertData(remove2);
                Runnable runnable = remove2.f250734l;
                if (runnable != null) {
                    f250742u.removeCallbacks(runnable);
                    remove2.f250734l = null;
                }
                a(remove2);
            }
            if (!f250739r.isEmpty() && (remove = f250739r.remove(Integer.valueOf(this.f250753g.hashCode()))) != null && !TextUtils.isEmpty(this.f250754h)) {
                if (TextUtils.isEmpty(remove.f250730h) || remove.f250730h.equals(f250735n)) {
                    String str2 = this.f250754h;
                    remove.f250730h = str2.substring(0, str2.indexOf("_"));
                }
                BaseApplication.monitor.insertData(remove);
                Runnable runnable2 = remove.f250734l;
                if (runnable2 != null) {
                    f250742u.removeCallbacks(runnable2);
                    remove.f250734l = null;
                }
                a(remove);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.w(MonitorSocketImplFactory.tag, 2, th5.getMessage(), th5);
            }
        }
        if (e == null) {
        } else {
            throw new IOException(e.toString());
        }
    }

    @Override // java.net.SocketImpl
    protected void connect(String str, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        this.f250750d = str;
        this.f250751e = i3;
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !h()) {
            j();
        }
        try {
            b();
            Method a16 = a(this.f250748b, UploadQualityReportBuilder.STATE_CONNECT, String.class, Integer.TYPE);
            a16.setAccessible(true);
            a16.invoke(this.f250747a, str, Integer.valueOf(i3));
            b();
            d();
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, this.f250753g + "connect to host 1 " + str + " succ.");
            }
        } catch (Exception e16) {
            if (e16 instanceof InvocationTargetException) {
                throw new IOException(((InvocationTargetException) e16).getTargetException().toString());
            }
            throw new IOException(e16.toString());
        }
    }

    @Override // java.net.SocketImpl
    protected void create(boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        try {
            Method a16 = a(this.f250748b, OperateCustomButton.OPERATE_CREATE, Boolean.TYPE);
            a16.setAccessible(true);
            a16.invoke(this.f250747a, Boolean.valueOf(z16));
            b();
        } catch (Exception e16) {
            throw new IOException(e16.toString());
        }
    }

    public Handler f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Handler) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return f250742u;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.f250752f = MsfSdkUtils.getProcessName(this.f250759m);
        try {
            if (f250742u == null) {
                synchronized (f250741t) {
                    if (f250742u == null) {
                        if (!f250741t.isAlive()) {
                            if (QLog.isColorLevel()) {
                                QLog.d(MonitorSocketImplFactory.tag, 2, "initSocketTimeoutChecker PID=" + Process.myPid() + " TID=" + f250741t.getId());
                            }
                            f250741t.start();
                        }
                        f250742u = new Handler(f250741t.getLooper());
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(MonitorSocketImplFactory.tag, 1, "initHandler exception " + e16.toString());
        }
    }

    @Override // java.net.SocketImpl
    protected InetAddress getInetAddress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (InetAddress) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        try {
            Method a16 = a(this.f250748b, "getInetAddress", new Class[0]);
            a16.setAccessible(true);
            return (InetAddress) a16.invoke(this.f250747a, new Object[0]);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // java.net.SocketImpl
    protected InputStream getInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (InputStream) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        try {
            c();
            Method a16 = a(this.f250748b, "getInputStream", new Class[0]);
            a16.setAccessible(true);
            return new MonitorSocketInputStream((InputStream) a16.invoke(this.f250747a, new Object[0]), this, this.f250759m);
        } catch (Exception e16) {
            throw new IOException(e16.toString());
        }
    }

    @Override // java.net.SocketOptions
    public Object getOption(int i3) throws SocketException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.f250747a.getOption(i3);
    }

    @Override // java.net.SocketImpl
    protected OutputStream getOutputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (OutputStream) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        try {
            c();
            Method a16 = a(this.f250748b, "getOutputStream", new Class[0]);
            a16.setAccessible(true);
            MonitorSocketOutputStream monitorSocketOutputStream = new MonitorSocketOutputStream((OutputStream) a16.invoke(this.f250747a, new Object[0]), this, this.f250759m);
            this.f250757k = monitorSocketOutputStream;
            return monitorSocketOutputStream;
        } catch (Exception e16) {
            throw new IOException(e16.toString());
        }
    }

    @Override // java.net.SocketImpl
    protected int getPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        try {
            Method a16 = a(this.f250748b, "getPort", new Class[0]);
            a16.setAccessible(true);
            return ((Integer) a16.invoke(this.f250747a, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void j() {
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        try {
            String str = this.f250752f;
            if (str != null && str.endsWith(":MSF") && (jVar = MsfCore.sCore.statReporter) != null) {
                jVar.a(this.f250748b.getName());
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // java.net.SocketImpl
    protected void listen(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
    }

    @Override // java.net.SocketImpl
    protected void sendUrgentData(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        try {
            Method a16 = a(this.f250748b, "sendUrgentData", Integer.TYPE);
            a16.setAccessible(true);
            a16.invoke(this.f250747a, Integer.valueOf(i3));
        } catch (Exception e16) {
            throw new IOException(e16.toString());
        }
    }

    @Override // java.net.SocketOptions
    public void setOption(int i3, Object obj) throws SocketException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, obj);
            return;
        }
        SocketImpl socketImpl = this.f250747a;
        if (socketImpl != null) {
            socketImpl.setOption(i3, obj);
        }
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (Exception unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return a(superclass, str, clsArr);
        }
    }

    public Runnable a(int i3, int i16) {
        com.tencent.mobileqq.msf.sdk.utils.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Runnable) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, "addSocketTimeoutCheck keyHashCode is 0.");
            }
            return null;
        }
        if (f250736o == i16) {
            bVar = f250739r.get(Integer.valueOf(i3));
        } else {
            bVar = f250737p == i16 ? f250738q.get(Integer.valueOf(i3)) : null;
        }
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, "addSocketTimeoutCheck dataFlowItem is null.");
            }
            return null;
        }
        b bVar2 = new b(i3, i16);
        bVar.f250734l = bVar2;
        f250742u.postDelayed(bVar2, 30000L);
        return bVar2;
    }

    @Override // java.net.SocketImpl
    protected void connect(InetAddress inetAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inetAddress, i3);
            return;
        }
        try {
            this.f250750d = inetAddress.getHostName();
            this.f250751e = i3;
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !h()) {
                j();
            }
            b();
            Method a16 = a(this.f250748b, UploadQualityReportBuilder.STATE_CONNECT, InetAddress.class, Integer.TYPE);
            a16.setAccessible(true);
            a16.invoke(this.f250747a, inetAddress, Integer.valueOf(i3));
            b();
            d();
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, this.f250753g + "connect to host 2 " + this.f250750d + " succ.");
            }
        } catch (Exception e16) {
            if (e16 instanceof InvocationTargetException) {
                throw new IOException(((InvocationTargetException) e16).getTargetException().toString());
            }
            throw new IOException(e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.mobileqq.msf.sdk.utils.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(MonitorSocketImplFactory.tag, 2, bVar.toString());
        } else if (bVar.f250728f > 500000) {
            QLog.d(MonitorSocketImplFactory.tag, 1, bVar.toString());
        }
        f250743v++;
        f250744w += bVar.f250728f;
        f250746y.addIfAbsent(bVar.f250730h);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f250745x > 60000) {
            if (f250743v > 1000 || f250744w > SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
                QLog.i(MonitorSocketImplFactory.tag, 1, "netflowSize:" + f250744w + " ,netflowCount:" + f250743v + " ,mType:" + f250746y.toString());
            }
            f250743v = 0;
            f250744w = 0L;
            f250745x = currentTimeMillis;
            f250746y.clear();
        }
    }

    @Override // java.net.SocketImpl
    public void connect(SocketAddress socketAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) socketAddress, i3);
            return;
        }
        long j3 = 0;
        try {
            InetAddress address = ((InetSocketAddress) socketAddress).getAddress();
            if (address == null) {
                this.f250750d = ((InetSocketAddress) socketAddress).getHostName();
            } else {
                this.f250750d = address.getHostAddress();
            }
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !h()) {
                j();
            }
            b();
            Method a16 = a(this.f250748b, UploadQualityReportBuilder.STATE_CONNECT, SocketAddress.class, Integer.TYPE);
            a16.setAccessible(true);
            j3 = System.currentTimeMillis();
            a16.invoke(this.f250747a, socketAddress, Integer.valueOf(i3));
            b();
            d();
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 1, this.f250753g + "connect to host 3 " + this.f250750d + " succ. impl:" + toString());
            }
        } catch (Exception e16) {
            if (System.currentTimeMillis() - j3 < i3) {
                if (e16 instanceof InvocationTargetException) {
                    throw new IOException(((InvocationTargetException) e16).getTargetException().toString());
                }
                throw new IOException(e16.toString());
            }
            throw new SocketTimeoutException("timeoutexception " + e16.toString());
        }
    }
}
