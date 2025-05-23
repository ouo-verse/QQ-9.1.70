package com.tencent.mobileqq.pic;

import android.content.Context;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.image.ReportBean;
import com.tencent.image.Utils;
import com.tencent.image.api.ICache;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IReport;
import com.tencent.image.api.IThreadListener;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.ITool;
import com.tencent.image.api.IVersion;
import com.tencent.image.api.ReportEventBean;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f258593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ICache {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.api.ICache
        public void evictAll() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                ImageCacheHelper.f98636a.e();
            }
        }

        @Override // com.tencent.image.api.ICache
        public Object get(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            try {
                Object g16 = ImageCacheHelper.f98636a.g(str);
                if (g16 instanceof com.tencent.cache.api.g) {
                    com.tencent.cache.api.g gVar = (com.tencent.cache.api.g) g16;
                    return new Pair(gVar.b(), Integer.valueOf(gVar.a()));
                }
                return g16;
            } catch (ArrayIndexOutOfBoundsException | IllegalStateException e16) {
                QLog.e("URLDrawableDepWrapInit", 2, e16, new Object[0]);
                return null;
            }
        }

        @Override // com.tencent.image.api.ICache
        public byte getNormalPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Byte) iPatchRedirector.redirect((short) 6, (Object) this)).byteValue();
            }
            return (byte) Priority.Normal.ordinal();
        }

        @Override // com.tencent.image.api.ICache
        public Object put(String str, Object obj, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, str, obj, Byte.valueOf(b16));
            }
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                Object obj2 = pair.second;
                if (obj2 instanceof Integer) {
                    obj = new com.tencent.cache.api.g(pair.first, ((Integer) obj2).intValue());
                }
            }
            ImageCacheHelper.f98636a.k(str, obj, com.tencent.cache.core.manager.api.c.f98725d.e(), Priority.values()[b16], null);
            return null;
        }

        @Override // com.tencent.image.api.ICache
        public void remove(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                ImageCacheHelper.f98636a.m(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends ITool {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.api.ITool
        public Context getContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return BaseApplication.getContext();
        }

        @Override // com.tencent.image.api.ITool
        public URLStreamHandlerFactory getFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (URLStreamHandlerFactory) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.image.api.ITool
        public boolean loadSoByName(Context context, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str)).booleanValue();
            }
            return SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements ILog {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void d(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.d(str, i3, str2);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void e(String str, int i3, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                QLog.e(str, i3, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, th5);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void i(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                QLog.i(str, i3, str2);
            } else {
                iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2);
            }
        }

        @Override // com.tencent.image.api.ILog
        public boolean isColorLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return QLog.isColorLevel();
        }

        @Override // com.tencent.image.api.ILog
        public void w(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                QLog.w(str, i3, str2);
            } else {
                iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void e(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                QLog.e(str, i3, str2);
            } else {
                iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void i(String str, int i3, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                QLog.d(str, i3, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, th5);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void w(String str, int i3, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                QLog.w(str, i3, "", th5);
            } else {
                iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements IThreadManager {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class a implements ThreadExcutor.IThreadListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ IThreadListener f258594d;

            a(IThreadListener iThreadListener) {
                this.f258594d = iThreadListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) iThreadListener);
                }
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onAdded() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f258594d.onAdded();
                }
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPostRun() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                } else {
                    this.f258594d.onPostRun();
                }
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPreRun() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    this.f258594d.onPreRun();
                }
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private ThreadExcutor.IThreadListener a(IThreadListener iThreadListener) {
            if (iThreadListener != null) {
                return new a(iThreadListener);
            }
            return null;
        }

        @Override // com.tencent.image.api.IThreadManager
        public void executeOnFileThreadExcutor(Runnable runnable, IThreadListener iThreadListener, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, runnable, iThreadListener, Boolean.valueOf(z16));
            } else {
                ThreadManagerV2.excute(runnable, 64, a(iThreadListener), z16);
            }
        }

        @Override // com.tencent.image.api.IThreadManager
        public void executeOnNetThreadExcutor(Runnable runnable, IThreadListener iThreadListener, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, runnable, iThreadListener, Boolean.valueOf(z16));
            } else {
                ThreadManagerV2.excute(runnable, 128, a(iThreadListener), z16);
            }
        }

        @Override // com.tencent.image.api.IThreadManager
        public HandlerThread getFileThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HandlerThread) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (HandlerThread) ThreadManagerV2.getFileThread();
        }

        @Override // com.tencent.image.api.IThreadManager
        public HandlerThread getSubThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HandlerThread) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (HandlerThread) ThreadManagerV2.getSubThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements IVersion {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.api.IVersion
        public boolean isPublicVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements IReport {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Set<String> f258596a;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f258596a = new HashSet();
            }
        }

        protected void a(Object[] objArr) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) objArr);
                return;
            }
            if (objArr.length == 5) {
                String str2 = (String) objArr[0];
                String str3 = (String) objArr[1];
                String str4 = (String) objArr[2];
                String str5 = (String) objArr[3];
                Exception exc = (Exception) objArr[4];
                String str6 = "";
                if (objArr.length <= 5) {
                    str = "";
                } else {
                    str = (String) objArr[5];
                }
                try {
                    String[] split = str2.split("\\(|,|\\)");
                    int parseInt = Integer.parseInt(split[1]);
                    int parseInt2 = Integer.parseInt(split[2]);
                    String[] split2 = str3.split("\\(|,|\\)");
                    int parseInt3 = Integer.parseInt(split2[1]);
                    int parseInt4 = Integer.parseInt(split2[2]);
                    if (parseInt3 > 0 && parseInt4 > 0 && parseInt > 0 && parseInt2 > 0) {
                        int max = Math.max(Math.round(parseInt3 / parseInt), Math.round(parseInt4 / parseInt2));
                        if (max >= 2) {
                            int i16 = parseInt3 * parseInt4;
                            i3 = i16 - (i16 / (max * max));
                        } else {
                            i3 = 0;
                        }
                        if (i3 > 0) {
                            int i17 = (i3 * 4) / 1024;
                            HashMap hashMap = new HashMap(8);
                            String d16 = ab.d(exc, false);
                            String e16 = ab.e(d16, 1);
                            if (d16 == null) {
                                d16 = "";
                            }
                            hashMap.put("stack", d16);
                            hashMap.put("title", e16);
                            hashMap.put("viewsize", str2);
                            hashMap.put("picsize", str3);
                            hashMap.put("req_info", str);
                            if (str4 != null) {
                                str6 = str4.replace(Typography.amp, TokenParser.SP);
                            }
                            hashMap.put("img_url", str6);
                            ey3.a.f().addEvent(2, str5, i17, 0, hashMap);
                            if (i17 >= 512) {
                                ab.h(exc, e16, str5, str2 + str, str3, str4, i17);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.tencent.image.api.IReport
        public void debug(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, obj);
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            ab.i((Long) obj);
                            return;
                        }
                        return;
                    }
                    ab.j((Long) obj);
                    return;
                }
                ab.g((Object[]) obj);
                return;
            }
            a((Object[]) obj);
        }

        @Override // com.tencent.image.api.IReport
        public void report(ReportBean reportBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) reportBean);
            } else if (reportBean != null && reportBean.tag != null) {
                StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, reportBean.tag, reportBean.suc, reportBean.time, reportBean.size, reportBean.params, null);
            }
        }

        @Override // com.tencent.image.api.IReport
        public void reportEvent(ReportEventBean reportEventBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) reportEventBean);
            } else {
                ReportController.o(null, reportEventBean.getTag(), reportEventBean.getMainAction(), reportEventBean.getToUin(), reportEventBean.getSubAction(), reportEventBean.getActionName(), reportEventBean.getFromType(), reportEventBean.getResult(), reportEventBean.getR2(), reportEventBean.getR3(), reportEventBean.getR3(), reportEventBean.getR4());
            }
        }

        @Override // com.tencent.image.api.IReport
        public void reportException(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                com.tencent.qqperf.monitor.crash.catchedexception.a.c(new IllegalArgumentException(str), str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73567);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258593a = new CopyOnWriteArrayList();
        }
    }

    public static URLDrawableDepWrap c() {
        URLDrawableDepWrap uRLDrawableDepWrap = new URLDrawableDepWrap();
        uRLDrawableDepWrap.mCache = new a();
        uRLDrawableDepWrap.mTool = new b();
        uRLDrawableDepWrap.mLog = new c();
        uRLDrawableDepWrap.mThreadManager = new d();
        uRLDrawableDepWrap.mVersion = new e();
        f(uRLDrawableDepWrap);
        QLog.i("URLDrawableDepWrapInit", 1, "generateDepWrap, finish");
        return uRLDrawableDepWrap;
    }

    public static String d(Exception exc, boolean z16) {
        if (exc == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = exc.getStackTrace();
        ArrayList arrayList = new ArrayList(8);
        int i3 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (!className.contains("URLDrawable") && !className.startsWith("android.") && !className.startsWith("java.") && !className.startsWith("com.android.") && !className.startsWith("dalvik.")) {
                i3++;
                if (i3 >= 8) {
                    break;
                }
                arrayList.add(stackTraceElement.toString());
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append(",");
                if (z16) {
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(",");
        StringBuilder sb5 = new StringBuilder(128);
        for (int i16 = 0; i16 < split.length && i16 < i3; i16++) {
            int indexOf = split[i16].indexOf("(");
            if (indexOf > 0) {
                sb5.append(split[i16].substring(0, indexOf));
                sb5.append("()");
                sb5.append(",");
            } else {
                sb5.append(split[i16]);
                sb5.append(",");
            }
        }
        return sb5.toString();
    }

    private static void f(URLDrawableDepWrap uRLDrawableDepWrap) {
        uRLDrawableDepWrap.mReport = new f();
    }

    protected static void g(Object[] objArr) {
        if (objArr.length == 2) {
        }
    }

    protected static void i(Long l3) {
        if (SystemClock.uptimeMillis() % 100 == 0) {
            StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, Utils.AIO_PIC_DISPATCH_WAIT, true, l3.longValue(), 0L, null, null);
        }
    }

    protected static void j(Long l3) {
        if (SystemClock.uptimeMillis() % 100 == 0) {
            StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, Utils.AIO_PIC_DOWNLOAD_WAIT, true, l3.longValue(), 0L, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Exception exc, String str, String str2, String str3, String str4, String str5, long j3) {
    }
}
