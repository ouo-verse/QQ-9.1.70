package com.tencent.mobileqq.qrscan.qrcode;

import android.content.pm.ApplicationInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader;
import com.tencent.mobileqq.qrscan.earlydown.i;
import com.tencent.mobileqq.qrscan.ipc.c;
import com.tencent.mobileqq.qrscan.l;
import com.tencent.mobileqq.qrscan.minicode.e;
import com.tencent.mobileqq.qrscan.u;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qbar.QbarNative;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final l.a f276778a;

    /* renamed from: b, reason: collision with root package name */
    public static final l.a f276779b;

    /* renamed from: c, reason: collision with root package name */
    public static final l.a f276780c;

    /* renamed from: d, reason: collision with root package name */
    private static int f276781d;

    /* renamed from: e, reason: collision with root package name */
    public static QbarNative f276782e;

    /* renamed from: f, reason: collision with root package name */
    private static int f276783f;

    /* renamed from: g, reason: collision with root package name */
    public static QbarNative f276784g;

    /* renamed from: h, reason: collision with root package name */
    private static int f276785h;

    /* renamed from: i, reason: collision with root package name */
    private static String f276786i;

    /* renamed from: j, reason: collision with root package name */
    private static String f276787j;

    /* renamed from: k, reason: collision with root package name */
    private static l.a f276788k;

    /* renamed from: l, reason: collision with root package name */
    private static int f276789l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f276790m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29151);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276778a = new l.a(1);
        f276779b = new l.a(2);
        f276780c = new l.a(2, 1);
        f276781d = -1;
        f276783f = -1;
        f276789l = 0;
        f276790m = false;
    }

    public static synchronized int a(StringBuilder sb5, StringBuilder sb6) {
        int c16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetOneResultForFile.");
            }
            c16 = c(sb5, sb6, 1);
        }
        return c16;
    }

    public static synchronized int b(StringBuilder sb5, StringBuilder sb6) {
        int c16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetOneResultForCamera.");
            }
            c16 = c(sb5, sb6, 0);
        }
        return c16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    private static synchronized int c(StringBuilder sb5, StringBuilder sb6, int i3) {
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetOneResultInternal. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g + " scanMode=" + i3);
            }
            if (i3 == 1) {
                if (f276782e == null) {
                    return f276781d;
                }
            } else if (f276784g == null) {
                return f276783f;
            }
            try {
                if (i3 == 1) {
                    sb5 = f276782e.GetOneResult(sb5, sb6);
                } else {
                    sb5 = f276784g.GetOneResult(sb5, sb6);
                }
                return sb5;
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QbarNativeImpl", 2, "GetOneResultInternal. type:" + sb5 + " data:" + ((Object) sb6), e16);
                    return 0;
                }
                return 0;
            }
        }
    }

    public static synchronized ArrayList<QBarResult> d() {
        ArrayList<QBarResult> f16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetResult.");
            }
            f16 = f(1);
        }
        return f16;
    }

    public static synchronized ArrayList<QBarResult> e() {
        ArrayList<QBarResult> f16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetResultForCamera.");
            }
            f16 = f(0);
        }
        return f16;
    }

    private static synchronized ArrayList<QBarResult> f(int i3) {
        ArrayList<QBarResult> GetResults;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetResultInternal. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g + " scanMode=" + i3);
            }
            if (i3 == 1) {
                if (f276782e == null) {
                    return null;
                }
            } else if (f276784g == null) {
                return null;
            }
            try {
                if (i3 == 1) {
                    GetResults = f276782e.GetResults(3);
                } else {
                    GetResults = f276784g.GetResults(3);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QbarNativeImpl", 2, "GetResultInternal results:" + GetResults);
                }
                return GetResults;
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QbarNativeImpl", 2, "GetResultInternal scanMode:" + i3, e16);
                }
                return null;
            }
        }
    }

    public static synchronized String g() {
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "GetVersion. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g);
            }
            if (f276782e != null) {
                return QbarNative.getVersion();
            }
            if (f276784g != null) {
                return QbarNative.getVersion();
            }
            return "";
        }
    }

    public static synchronized int h(int i3, int i16, String str, String str2) {
        int i17;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, String.format("Init searchMode=%s scanMode=%s inputCharset=%s outputCharset=%s", Integer.valueOf(i3), Integer.valueOf(i16), str, str2));
            }
            if (e.k()) {
                return -1;
            }
            if (i16 == 1) {
                if (f276784g != null) {
                    f276790m = true;
                    f276789l = 0;
                    l();
                }
                if (f276782e == null || f276781d < 0) {
                    QbarNative qbarNative = new QbarNative();
                    f276782e = qbarNative;
                    f276781d = qbarNative.init(i3, 1, str, str2, v(qbarNative));
                }
                i17 = f276781d;
            } else {
                if (f276784g == null || f276783f < 0) {
                    QbarNative qbarNative2 = new QbarNative();
                    f276784g = qbarNative2;
                    f276783f = qbarNative2.init(i3, 0, str, str2, v(qbarNative2));
                    f276785h = i3;
                    f276786i = str;
                    f276787j = str2;
                    f276790m = false;
                }
                i17 = f276783f;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, String.format("Init result=%s ", Integer.valueOf(i17)));
            }
            return i17;
        }
    }

    public static synchronized int i(int i3, String str, String str2) {
        int h16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "InitForFile.");
            }
            h16 = h(i3, 1, str, str2);
        }
        return h16;
    }

    public static synchronized int j(int i3, String str, String str2) {
        int h16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "InitForCamera.");
            }
            h16 = h(i3, 0, str, str2);
        }
        return h16;
    }

    public static synchronized int k() {
        int m3;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "ReleaseForFile.");
            }
            m3 = m(1);
        }
        return m3;
    }

    public static synchronized int l() {
        int m3;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "ReleaseForCamera.");
            }
            m3 = m(0);
        }
        return m3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0090 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x004a, B:11:0x004e, B:13:0x008a, B:15:0x0090, B:20:0x0063, B:22:0x0067, B:24:0x007e), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized int m(int i3) {
        int i16;
        int release;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "Release. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g);
            }
            i16 = -1;
            if (i3 == 1) {
                if (f276782e != null) {
                    c.f().i(f276782e);
                    release = f276782e.release();
                    f276782e = null;
                    f276781d = -1;
                    i16 = release;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QbarNativeImpl", 2, "Release. After release. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g);
                }
            } else {
                if (f276784g != null) {
                    c.f().i(f276784g);
                    release = f276784g.release();
                    f276784g = null;
                    f276783f = -1;
                    if (!f276790m) {
                        f276785h = -1;
                        f276786i = null;
                        f276787j = null;
                        f276788k = null;
                        f276789l = 0;
                    }
                    i16 = release;
                }
                if (QLog.isColorLevel()) {
                }
            }
        }
        return i16;
    }

    public static synchronized int n(byte[] bArr, int i3, int i16) {
        int p16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "ScanImageForFile.");
            }
            p16 = p(bArr, i3, i16, 1);
        }
        return p16;
    }

    public static synchronized int o(byte[] bArr, int i3, int i16) {
        int p16;
        String str;
        int i17;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "ScanImageForCamera.");
            }
            if (f276790m) {
                if (QLog.isColorLevel()) {
                    QLog.d("QbarNativeImpl", 2, "ScanImageForCamera restore before. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g + " sCameraRestoreSkipTimes=" + f276789l);
                }
                if (f276784g == null) {
                    if (f276782e != null && (i17 = f276789l) < 3) {
                        f276789l = i17 + 1;
                    } else {
                        String str2 = f276786i;
                        if (str2 != null && (str = f276787j) != null && f276788k != null) {
                            j(f276785h, str2, str);
                            r(f276788k);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QbarNativeImpl", 2, "ScanImageForCamera restore after. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g + " sCameraRestoreSkipTimes=" + f276789l);
                }
            }
            p16 = p(bArr, i3, i16, 0);
        }
        return p16;
    }

    private static synchronized int p(byte[] bArr, int i3, int i16, int i17) {
        int scanImage;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "ScanImage. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g + " scanMode=" + i17);
            }
            if (!t(i3, i16)) {
                QLog.i("QbarNativeImpl", 1, "ScanImage in limit size, return. width=" + i3 + " height=" + i16);
                return -1;
            }
            if (i17 == 1) {
                QbarNative qbarNative = f276782e;
                if (qbarNative == null) {
                    return f276781d;
                }
                scanImage = qbarNative.scanImage(bArr, i3, i16);
            } else {
                QbarNative qbarNative2 = f276784g;
                if (qbarNative2 == null) {
                    return f276783f;
                }
                scanImage = qbarNative2.scanImage(bArr, i3, i16);
            }
            if (scanImage < 0) {
                return -1;
            }
            return 1;
        }
    }

    public static synchronized int q(l.a aVar) {
        int s16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "SetReadersForFile.");
            }
            s16 = s(aVar, 1);
        }
        return s16;
    }

    public static synchronized int r(l.a aVar) {
        int s16;
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "SetReadersForCamera.");
            }
            s16 = s(aVar, 0);
        }
        return s16;
    }

    private static synchronized int s(l.a aVar, int i3) {
        synchronized (a.class) {
            int[] b16 = aVar.b();
            int a16 = aVar.a();
            if (QLog.isColorLevel()) {
                QLog.d("QbarNativeImpl", 2, "SetReaders. sInitResult=" + f276781d + " sQbarNative=" + f276782e + " sInitResultForCamera=" + f276783f + " sQbarNativeForCamera=" + f276784g + " scanMode=" + i3);
            }
            if (i3 == 1) {
                QbarNative qbarNative = f276782e;
                if (qbarNative == null) {
                    return f276781d;
                }
                return qbarNative.setReaders(b16, a16);
            }
            QbarNative qbarNative2 = f276784g;
            if (qbarNative2 == null) {
                return f276783f;
            }
            f276788k = aVar;
            return qbarNative2.setReaders(b16, a16);
        }
    }

    public static boolean t(int i3, int i16) {
        if (i3 >= 20 && i16 >= 20 && (i3 >= 32 || i16 >= 32)) {
            return true;
        }
        QLog.i("QbarNativeImpl", 1, "isValidScanImageSize false, in limit size. width=" + i3 + " height=" + i16);
        return false;
    }

    public static void u() {
        if (u.a()) {
            QBarSoDownloader.h().d();
        }
    }

    private static QbarNative.QbarAiModelParam v(QbarNative qbarNative) {
        boolean z16;
        boolean z17;
        QbarNative.QbarAiModelParam qbarAiModelParam = new QbarNative.QbarAiModelParam();
        qbarAiModelParam.detect_model_bin_path_ = "";
        qbarAiModelParam.detect_model_param_path_ = "";
        qbarAiModelParam.superresolution_model_bin_path_ = "";
        qbarAiModelParam.superresolution_model_param_path_ = "";
        if (u.a()) {
            z17 = QbarNative.hasSoLoadByPath;
        } else {
            ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
            if (applicationInfo != null && applicationInfo.targetSdkVersion >= 31) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scan_qbar_ai_model_switch", true) && !z16) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        boolean s16 = i.s();
        QLog.i("QbarNativeImpl", 1, "withQbarAiModelInit isAIModelFileReady=" + s16 + ", useQBarAIModel=" + z17);
        if (z17 && s16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i.o());
            String str = File.separator;
            sb5.append(str);
            sb5.append(i.p("detect_model.bin"));
            qbarAiModelParam.detect_model_bin_path_ = sb5.toString();
            qbarAiModelParam.detect_model_param_path_ = i.o() + str + i.p("detect_model.param");
            qbarAiModelParam.superresolution_model_bin_path_ = i.o() + str + i.p("srnet.bin");
            qbarAiModelParam.superresolution_model_param_path_ = i.o() + str + i.p("srnet.param");
        } else if (!s16) {
            c.f().g(qbarNative);
            c.f().c(3);
        }
        return qbarAiModelParam;
    }
}
