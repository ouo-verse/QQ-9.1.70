package com.tencent.mobileqq.vasgift.utils;

import android.content.Context;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private Context f312010d;

    /* renamed from: a, reason: collision with root package name */
    private int f312007a = 0;

    /* renamed from: b, reason: collision with root package name */
    private List<InterfaceC8940b> f312008b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private PagSoLoaderBroadcastReceiver f312009c = null;

    /* renamed from: e, reason: collision with root package name */
    final Object f312011e = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Function0<Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IVasTempApi f312012d;

        a(IVasTempApi iVasTempApi) {
            this.f312012d = iVasTempApi;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            b.this.d(this.f312012d.initPagSo());
            return null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8940b {
        void onComplete(boolean z16);
    }

    private void c(Context context) {
        IVasTempApi iVasTempApi = IVasTempApi.INSTANCE.get();
        if (MobileQQ.sProcessId != 1) {
            try {
                IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
                AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BASE_PACKAGE;
                if (iAEResUtil.isAEResExist(aEResInfo)) {
                    QLog.i("PagLoader", 1, "already download");
                    d(iVasTempApi.initPagSo());
                    return;
                }
                if (this.f312009c != null) {
                    QLog.i("PagLoader", 1, "loadPagWithIPC loadPagWithIPC is not null! return.");
                    return;
                }
                synchronized (this.f312011e) {
                    this.f312010d = context;
                    PagSoLoaderBroadcastReceiver pagSoLoaderBroadcastReceiver = new PagSoLoaderBroadcastReceiver();
                    this.f312009c = pagSoLoaderBroadcastReceiver;
                    if (context != null) {
                        context.registerReceiver(pagSoLoaderBroadcastReceiver, pagSoLoaderBroadcastReceiver.a());
                    }
                    ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
                }
                return;
            } catch (Throwable th5) {
                QLog.e("PagLoader", 1, "loadPagWithIPC throw e:" + th5.getMessage());
                return;
            }
        }
        iVasTempApi.requestPagDownload(new a(iVasTempApi));
    }

    public boolean a() {
        if (this.f312007a == 2) {
            return true;
        }
        return false;
    }

    public void b(Context context, InterfaceC8940b interfaceC8940b) {
        if (a()) {
            if (interfaceC8940b != null) {
                interfaceC8940b.onComplete(true);
                return;
            }
            return;
        }
        if (interfaceC8940b != null) {
            synchronized (this.f312008b) {
                this.f312008b.add(interfaceC8940b);
            }
        }
        if (this.f312007a == 1) {
            return;
        }
        this.f312007a = 1;
        c(context);
    }

    public void d(boolean z16) {
        if (z16) {
            this.f312007a = 2;
        } else {
            this.f312007a = 0;
        }
        synchronized (this.f312008b) {
            Iterator<InterfaceC8940b> it = this.f312008b.iterator();
            while (it.hasNext()) {
                it.next().onComplete(z16);
            }
            this.f312008b.clear();
        }
    }

    public void e() {
        PagSoLoaderBroadcastReceiver pagSoLoaderBroadcastReceiver;
        try {
            synchronized (this.f312011e) {
                Context context = this.f312010d;
                if (context != null && (pagSoLoaderBroadcastReceiver = this.f312009c) != null) {
                    context.unregisterReceiver(pagSoLoaderBroadcastReceiver);
                    this.f312010d = null;
                    this.f312009c = null;
                }
            }
        } catch (Throwable th5) {
            QLog.e("PagLoader", 1, "unRegisterPagSoLoaderReceiver throw e:" + th5.getMessage());
        }
    }
}
