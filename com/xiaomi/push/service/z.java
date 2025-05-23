package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.xiaomi.push.cn;
import com.xiaomi.push.dy;
import com.xiaomi.push.dz;
import com.xiaomi.push.in;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f389851a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: b, reason: collision with root package name */
    private static long f389852b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f389853c = new BaseThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th5;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th6) {
            bufferedReader = null;
            th5 = th6;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append("\n");
                    sb5.append(readLine);
                } else {
                    String sb6 = sb5.toString();
                    in.b(bufferedReader);
                    return sb6;
                }
            }
        } catch (Exception unused2) {
            in.b(bufferedReader);
            return null;
        } catch (Throwable th7) {
            th5 = th7;
            in.b(bufferedReader);
            throw th5;
        }
    }

    public static void b() {
        cn c16;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f389853c.getActiveCount() <= 0 || currentTimeMillis - f389852b >= 1800000) && dy.f().k() && (c16 = ae.f().c()) != null && c16.y() > 0) {
            f389852b = currentTimeMillis;
            c(c16.o(), true);
        }
    }

    public static void c(final List<String> list, final boolean z16) {
        f389853c.execute(new Runnable() { // from class: com.xiaomi.push.service.z.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                boolean f16 = z.f("www.baidu.com:80");
                Iterator it = list.iterator();
                while (true) {
                    i3 = 1;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (!f16 && !z.f(str)) {
                        f16 = false;
                    } else {
                        f16 = true;
                    }
                    if (f16 && !z16) {
                        break;
                    }
                }
                if (!f16) {
                    i3 = 2;
                }
                dz.b(i3);
            }
        });
    }

    public static void e() {
        String a16 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a16)) {
            jz4.c.m("dump tcp for uid = " + Process.myUid());
            jz4.c.m(a16);
        }
        String a17 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a17)) {
            jz4.c.m("dump tcp6 for uid = " + Process.myUid());
            jz4.c.m(a17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jz4.c.m("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(com.xiaomi.push.az.d(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            jz4.c.m("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th5) {
            jz4.c.B("ConnectivityTest: could not connect to:" + str + " exception: " + th5.getClass().getSimpleName() + " description: " + th5.getMessage());
            return false;
        }
    }
}
