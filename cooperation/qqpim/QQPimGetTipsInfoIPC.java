package cooperation.qqpim;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimPluginLoadRunnable;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QQPimGetTipsInfoIPC {

    /* renamed from: j, reason: collision with root package name */
    private static int f390772j = -1;

    /* renamed from: k, reason: collision with root package name */
    private static QQPimGetTipsInfoIPC f390773k;

    /* renamed from: a, reason: collision with root package name */
    private c f390774a;

    /* renamed from: b, reason: collision with root package name */
    private String f390775b;

    /* renamed from: c, reason: collision with root package name */
    private String f390776c;

    /* renamed from: d, reason: collision with root package name */
    private long f390777d;

    /* renamed from: e, reason: collision with root package name */
    public QQPimTipsInfo f390778e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f390779f;

    /* renamed from: g, reason: collision with root package name */
    private QQPimPluginLoadRunnable f390780g;

    /* renamed from: h, reason: collision with root package name */
    QQPimPluginLoadRunnable.a f390781h = new a();

    /* renamed from: i, reason: collision with root package name */
    private QIPCModule f390782i = new b(cooperation.qqpim.a.f390799c);

    /* loaded from: classes28.dex */
    private class GetContactTipsRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private String f390783d;

        /* renamed from: e, reason: collision with root package name */
        private String f390784e;

        /* loaded from: classes28.dex */
        class a implements EIPCResultCallback {
            a() {
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                Bundle bundle;
                Parcelable parcelable;
                if (QLog.isColorLevel()) {
                    QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.onCallback() " + QQPimGetTipsInfoIPC.this.f390774a.hashCode());
                }
                if (eIPCResult != null && (bundle = eIPCResult.data) != null && (parcelable = bundle.getParcelable(cooperation.qqpim.a.f390810n)) != null) {
                    QQPimTipsInfo qQPimTipsInfo = (QQPimTipsInfo) parcelable;
                    QQPimGetTipsInfoIPC qQPimGetTipsInfoIPC = QQPimGetTipsInfoIPC.this;
                    qQPimGetTipsInfoIPC.f390778e = qQPimTipsInfo;
                    qQPimGetTipsInfoIPC.f390774a.a(qQPimTipsInfo);
                }
            }
        }

        public GetContactTipsRunnable(String str, String str2) {
            this.f390783d = str;
            this.f390784e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(cooperation.qqpim.a.f390808l, this.f390783d);
                bundle.putString(cooperation.qqpim.a.f390809m, this.f390784e);
                QIPCServerHelper.getInstance().callClient(cooperation.qqpim.a.f390798b, cooperation.qqpim.a.f390799c, cooperation.qqpim.a.f390800d, bundle, new a());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    /* loaded from: classes28.dex */
    class a implements QQPimPluginLoadRunnable.a {
        a() {
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void a(float f16) {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.downloading() " + f16);
            }
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void b() {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.downloadBegin()");
            }
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void c(int i3) {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.downloadError() " + i3);
            }
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void d() {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.hasInstalled() ");
            }
            QQPimPluginProxyService.a(QQPimGetTipsInfoIPC.this.j());
        }
    }

    /* loaded from: classes28.dex */
    class b extends QIPCModule {
        b(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.onCall()" + str);
            }
            if (cooperation.qqpim.a.f390803g.equals(str)) {
                if (QQPimGetTipsInfoIPC.f390772j == -1 || System.currentTimeMillis() - QQPimGetTipsInfoIPC.this.f390777d < 500) {
                    return null;
                }
                QQPimGetTipsInfoIPC.this.f390777d = System.currentTimeMillis();
                if (QQPimGetTipsInfoIPC.f390772j == 0) {
                    QQPimGetTipsInfoIPC.f390772j = -1;
                    QQPimGetTipsInfoIPC qQPimGetTipsInfoIPC = QQPimGetTipsInfoIPC.this;
                    ThreadManagerV2.postImmediately(new GetContactTipsRunnable(qQPimGetTipsInfoIPC.f390775b, QQPimGetTipsInfoIPC.this.f390776c), null, true);
                } else if (QQPimGetTipsInfoIPC.f390772j == 1) {
                    QQPimGetTipsInfoIPC.f390772j = -1;
                    ThreadManagerV2.postImmediately(new NoticeClickTipsRunnable(), null, true);
                }
            } else {
                if (!cooperation.qqpim.a.f390804h.equals(str) || System.currentTimeMillis() - QQPimGetTipsInfoIPC.this.f390777d < 500) {
                    return null;
                }
                QQPimGetTipsInfoIPC.this.f390777d = System.currentTimeMillis();
                QQPimTipsInfo qQPimTipsInfo = new QQPimTipsInfo();
                qQPimTipsInfo.f390793d = 0;
                QQPimGetTipsInfoIPC.this.f390774a.a(qQPimTipsInfo);
            }
            return null;
        }
    }

    /* loaded from: classes28.dex */
    public interface c {
        void a(QQPimTipsInfo qQPimTipsInfo);
    }

    QQPimGetTipsInfoIPC() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface j() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public static QQPimGetTipsInfoIPC l() {
        if (f390773k == null) {
            synchronized (QQPimGetTipsInfoIPC.class) {
                if (f390773k == null) {
                    f390773k = new QQPimGetTipsInfoIPC();
                }
            }
        }
        return f390773k;
    }

    public void i() {
        this.f390774a = null;
        QQPimPluginLoadRunnable qQPimPluginLoadRunnable = this.f390780g;
        if (qQPimPluginLoadRunnable != null) {
            qQPimPluginLoadRunnable.stop();
            this.f390780g = null;
        }
    }

    public void k(QQAppInterface qQAppInterface, c cVar, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.getContactTipsIpc()" + cVar.hashCode());
        }
        f390772j = 0;
        this.f390774a = cVar;
        this.f390775b = str;
        this.f390776c = str2;
        try {
            if (!this.f390779f) {
                QIPCServerHelper.getInstance().register(this.f390782i);
                this.f390779f = true;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        m();
    }

    public void m() {
        QQPimPluginLoadRunnable qQPimPluginLoadRunnable = this.f390780g;
        if (qQPimPluginLoadRunnable != null) {
            qQPimPluginLoadRunnable.stop();
        }
        QQPimPluginLoadRunnable qQPimPluginLoadRunnable2 = new QQPimPluginLoadRunnable(this.f390781h);
        this.f390780g = qQPimPluginLoadRunnable2;
        ThreadManagerV2.postImmediately(qQPimPluginLoadRunnable2, null, true);
    }

    public void n() {
        if (QLog.isColorLevel()) {
            QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimGetTipsInfoIPC.noticeClickTipsIPC()");
        }
        f390772j = 1;
        QQPimPluginProxyService.a(j());
    }

    /* loaded from: classes28.dex */
    private class NoticeClickTipsRunnable implements Runnable {
        NoticeClickTipsRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt(cooperation.qqpim.a.f390814r, 3);
                QIPCServerHelper.getInstance().callClient(cooperation.qqpim.a.f390798b, cooperation.qqpim.a.f390799c, cooperation.qqpim.a.f390801e, bundle, new a());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        /* loaded from: classes28.dex */
        class a implements EIPCResultCallback {
            a() {
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
            }
        }
    }
}
