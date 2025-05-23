package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes12.dex */
public class FileIPv6Detecter {

    /* renamed from: b, reason: collision with root package name */
    private Executor f207321b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f207320a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private String f207322c = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {

        /* renamed from: c, reason: collision with root package name */
        d.b f207328c;

        /* renamed from: a, reason: collision with root package name */
        volatile boolean f207326a = false;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f207327b = false;

        /* renamed from: d, reason: collision with root package name */
        long f207329d = 0;

        a() {
        }
    }

    private void c() {
        synchronized (this.f207320a) {
            this.f207320a.clear();
        }
    }

    private boolean d(final d.a aVar, final d.b bVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f207639a) && bVar != null && !TextUtils.isEmpty(bVar.f207641a)) {
            final long currentTimeMillis = System.currentTimeMillis();
            QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start delectIP [" + aVar.f207639a + ":" + aVar.f207640b + "] ipInfo[" + bVar.f207641a + ":" + bVar.f207642b + "]");
            k();
            Executor executor = this.f207321b;
            if (executor == null) {
                return false;
            }
            executor.execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    Socket socket = new Socket();
                    try {
                        try {
                            int i3 = bVar.f207642b;
                            if (i3 == 0) {
                                i3 = 80;
                            }
                            socket.connect(new InetSocketAddress(bVar.a(), i3), 6000);
                            try {
                                socket.close();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            z16 = false;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            try {
                                socket.close();
                            } catch (Exception e18) {
                                e18.printStackTrace();
                            }
                            z16 = true;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[IPv6-File] delectIP Result:");
                        sb5.append(!z16);
                        sb5.append(" cost:");
                        sb5.append(currentTimeMillis2 - currentTimeMillis);
                        sb5.append(" [");
                        sb5.append(aVar.f207639a);
                        sb5.append(":");
                        sb5.append(aVar.f207640b);
                        sb5.append("] ipInfo[");
                        sb5.append(bVar.f207641a);
                        sb5.append(":");
                        sb5.append(bVar.f207642b);
                        sb5.append("]");
                        QLog.i("FileIPv6Detecter<FileAssistant>", 1, sb5.toString());
                        a f16 = FileIPv6Detecter.this.f(aVar);
                        if (f16 != null) {
                            f16.f207327b = false;
                            f16.f207326a = !z16;
                            FileIPv6Detecter.this.i(!z16, aVar.f207639a, bVar.a(), bVar.f207642b);
                        }
                    } catch (Throwable th5) {
                        try {
                            socket.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                        throw th5;
                    }
                }
            });
            return true;
        }
        QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectDomainConn err. param=null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a f(d.a aVar) {
        a aVar2;
        if (aVar != null && aVar.f207639a != null) {
            synchronized (this.f207320a) {
                aVar2 = this.f207320a.get(aVar.f207639a);
            }
            return aVar2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z16, String str, String str2, int i3) {
        int i16;
        int i17 = 2;
        if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        int i18 = QQFileUtilsImpl.i();
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 != 3) {
                    i17 = 0;
                }
            } else {
                i17 = 3;
            }
        } else {
            i17 = 1;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_domain", String.valueOf(str));
        hashMap.put("param_ipAddr", String.valueOf(str2));
        hashMap.put("param_port", String.valueOf(i3));
        hashMap.put("param_result", String.valueOf(!z16 ? 1 : 0));
        hashMap.put("param_stackType", String.valueOf(i17));
        hashMap.put("param_loginType", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f207322c, "actFAIPConnect", true, 0L, 0L, hashMap, null);
        QLog.d("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] >> reportDetectConnResult:" + hashMap.toString());
    }

    private void j(d.a aVar, a aVar2) {
        synchronized (this.f207320a) {
            this.f207320a.put(aVar.f207639a, aVar2);
        }
    }

    private synchronized void k() {
        if (this.f207321b == null) {
            QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start conn pool");
            try {
                ThreadPoolParams threadPoolParams = new ThreadPoolParams();
                threadPoolParams.priority = 5;
                threadPoolParams.poolThreadName = "IPv6ConnDelectPool";
                this.f207321b = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
            } catch (Exception e16) {
                QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start conn pool exception:" + e16.toString());
            }
        }
    }

    public void e(BaseQQAppInterface baseQQAppInterface, d.a aVar, d.b bVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f207639a) || bVar == null || TextUtils.isEmpty(bVar.f207641a)) {
            QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] detectV6Domain err. param=null");
        }
        if (baseQQAppInterface != null) {
            this.f207322c = baseQQAppInterface.getCurrentUin();
        }
        long currentTimeMillis = System.currentTimeMillis();
        a f16 = f(aVar);
        if (f16 != null && (f16.f207326a || f16.f207327b || currentTimeMillis - f16.f207329d <= 600000)) {
            return;
        }
        if (d(aVar, bVar)) {
            a aVar2 = new a();
            aVar2.f207327b = true;
            aVar2.f207328c = bVar;
            aVar2.f207329d = currentTimeMillis;
            j(aVar, aVar2);
            return;
        }
        QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectIP err");
    }

    public boolean g(d.a aVar) {
        a f16 = f(aVar);
        if (f16 != null) {
            return f16.f207326a;
        }
        return false;
    }

    public void h() {
        c();
    }
}
