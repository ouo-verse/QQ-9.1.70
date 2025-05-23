package com.tencent.beacon.base.util;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f77790a;

    public static boolean a() {
        ArrayList<String> e16 = e();
        if (e16 != null && e16.size() > 0) {
            Iterator<String> it = e16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                c.a(next, new Object[0]);
                if (next.contains("not found")) {
                    return false;
                }
            }
            c.a("[core] sufile}", new Object[0]);
            return true;
        }
        c.a("[core] no response}", new Object[0]);
        return false;
    }

    public static boolean b() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                c.a("[core] super_apk", new Object[0]);
                return true;
            }
        } catch (Exception e16) {
            c.a(e16);
        }
        return false;
    }

    public static boolean c() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        c.a("[core] test-keys", new Object[0]);
        return true;
    }

    public static boolean d() {
        boolean z16 = true;
        if (f77790a) {
            return true;
        }
        if (!c() && !b() && !a()) {
            z16 = false;
        }
        f77790a = z16;
        return z16;
    }

    private static ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"/system/bin/sh", LogCmdOptions.CLEAR, "type su"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName("UTF-8")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream(), Charset.forName("UTF-8")));
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 != null) {
                    arrayList.add(readLine2);
                } else {
                    return arrayList;
                }
            }
        } catch (Throwable th5) {
            c.a(th5);
            return null;
        }
    }
}
