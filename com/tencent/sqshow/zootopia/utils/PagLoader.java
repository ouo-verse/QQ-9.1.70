package com.tencent.sqshow.zootopia.utils;

import android.content.Context;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

/* loaded from: classes34.dex */
public class PagLoader {

    /* renamed from: a, reason: collision with root package name */
    private int f373226a;

    /* renamed from: b, reason: collision with root package name */
    private List<b> f373227b;

    /* renamed from: c, reason: collision with root package name */
    private PagSoLoaderBroadcastReceiver f373228c;

    /* renamed from: d, reason: collision with root package name */
    private Context f373229d;

    /* renamed from: e, reason: collision with root package name */
    final Object f373230e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f373231f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements Function0<Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f373232d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IVasTempApi f373233e;

        a(long j3, IVasTempApi iVasTempApi) {
            this.f373232d = j3;
            this.f373233e = iVasTempApi;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            QLog.i("PagLoader", 1, "download so success : cost time : " + (System.currentTimeMillis() - this.f373232d));
            PagLoader.this.h(this.f373233e.initPagSo());
            QLog.i("PagLoader", 1, "init so success : cost time : " + (System.currentTimeMillis() - this.f373232d));
            return null;
        }
    }

    /* loaded from: classes34.dex */
    public interface b {
        void onComplete(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final PagLoader f373235a = new PagLoader();
    }

    public static PagLoader c() {
        return c.f373235a;
    }

    private void g(Context context) {
        IVasTempApi iVasTempApi = IVasTempApi.INSTANCE.get();
        if (MobileQQ.sProcessId != 1) {
            try {
                IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
                AEResInfo aEResInfo = AEResInfo.LIGHT_RES_PAG;
                if (iAEResUtil.isAEResExist(aEResInfo.agentType)) {
                    QLog.i("PagLoader", 1, "already download");
                    h(iVasTempApi.initPagSo());
                    return;
                } else {
                    if (this.f373228c != null) {
                        QLog.i("PagLoader", 1, "loadPagWithIPC loadPagWithIPC is not null! return.");
                        return;
                    }
                    synchronized (this.f373230e) {
                        this.f373229d = context;
                        PagSoLoaderBroadcastReceiver pagSoLoaderBroadcastReceiver = new PagSoLoaderBroadcastReceiver();
                        this.f373228c = pagSoLoaderBroadcastReceiver;
                        if (context != null) {
                            context.registerReceiver(pagSoLoaderBroadcastReceiver, pagSoLoaderBroadcastReceiver.a());
                        }
                        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("PagLoader", 1, "loadPagWithIPC throw e:" + th5.getMessage());
                h(false);
            }
        } else {
            QLog.i("PagLoader", 1, "request pag so download ");
            iVasTempApi.requestPagDownload(new a(System.currentTimeMillis(), iVasTempApi));
        }
        i();
    }

    private void i() {
        if (this.f373226a == 1) {
            QLog.i("PagLoader", 1, "loadPag, postTimeOutTask");
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f373231f, 10000L);
        }
    }

    public boolean d() {
        return this.f373226a == 2;
    }

    public boolean e() {
        return d() || ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_PAG.agentType);
    }

    public void f(Context context, b bVar) {
        boolean d16 = d();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadPag: ");
            sb5.append(d16);
            sb5.append(", ");
            sb5.append(bVar == null);
            sb5.append(", ");
            sb5.append(this.f373226a);
            QLog.d("PagLoader", 1, sb5.toString());
        }
        if (d16) {
            if (bVar != null) {
                bVar.onComplete(true);
                return;
            }
            return;
        }
        if (bVar != null) {
            synchronized (this.f373227b) {
                this.f373227b.add(bVar);
            }
        }
        if (this.f373226a == 1) {
            return;
        }
        this.f373226a = 1;
        g(context);
    }

    public void h(boolean z16) {
        QLog.i("PagLoader", 1, "onComplete: " + z16 + ", " + this.f373226a);
        b();
        if (this.f373226a != 1) {
            return;
        }
        if (z16) {
            this.f373226a = 2;
        } else {
            this.f373226a = 0;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f373227b) {
            arrayList.addAll(this.f373227b);
            this.f373227b.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.onComplete(z16);
            }
        }
    }

    public void j() {
        PagSoLoaderBroadcastReceiver pagSoLoaderBroadcastReceiver;
        try {
            synchronized (this.f373230e) {
                Context context = this.f373229d;
                if (context != null && (pagSoLoaderBroadcastReceiver = this.f373228c) != null) {
                    context.unregisterReceiver(pagSoLoaderBroadcastReceiver);
                    this.f373229d = null;
                    this.f373228c = null;
                }
            }
        } catch (Throwable th5) {
            QLog.e("PagLoader", 1, "unRegisterPagSoLoaderReceiver throw e:" + th5.getMessage());
        }
    }

    PagLoader() {
        this.f373226a = 0;
        this.f373227b = new ArrayList();
        this.f373228c = null;
        this.f373230e = new Object();
        this.f373231f = new Runnable() { // from class: com.tencent.sqshow.zootopia.utils.PagLoader.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("PagLoader", 1, "loadPag, timeOut, " + PagLoader.this.f373226a);
                PagLoader.this.h(false);
            }
        };
    }

    private void b() {
        QLog.i("PagLoader", 1, "loadPag, clearTimeOutTask");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f373231f);
    }
}
