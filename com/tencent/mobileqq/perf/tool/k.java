package com.tencent.mobileqq.perf.tool;

import android.system.Os;
import android.system.OsConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final long f258207a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258207a = Os.sysconf(OsConstants._SC_PAGESIZE);
        }
    }

    public static ArrayList<String> a(int i3, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/" + i3 + "/" + str, "r");
            while (true) {
                try {
                    String readLine = randomAccessFile.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } finally {
                }
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e16) {
            QLog.e("SysKernelInfoHelper", 1, "[readProcessInfo] error:" + e16.getMessage());
        } catch (IOException e17) {
            QLog.e("SysKernelInfoHelper", 1, "[readProcessInfo] error:" + e17.getMessage());
        }
        return arrayList;
    }
}
