package com.tencent.mobileqq.qqsomonitor;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f274734a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274734a = new Object();
        }
    }

    public static void c(Context context) {
        if (context == null) {
            QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[convertOldData], context is null!");
        }
        final MMKVOptionEntity from = QMMKV.from(context, "so_monitor_so_file_infocommon_mmkv_configurations");
        if (from.decodeBool("so_monitor_is_convert_done", false)) {
            QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[convertOldData], convertOldData is already done");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqsomonitor.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.g(MMKVOptionEntity.this);
                }
            }, 64, null, false);
        }
    }

    public static a d(Context context, File file) {
        if (context == null) {
            QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[getSoFileInfo], context is null!");
        }
        if (file == null) {
            return null;
        }
        return f(QMMKV.from(context, "so_monitor_so_file_infocommon_mmkv_configurations").decodeString(g.d(g.b(file)), ""));
    }

    private static String e(a aVar) {
        try {
            return new Gson().toJson(aVar);
        } catch (Exception e16) {
            QLog.e("SoMonitor.SoMonitorMmkvHelper", 1, "getSoFileJson err: ", e16);
            return "";
        }
    }

    private static a f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (a) new Gson().fromJson(str, a.class);
        } catch (Exception e16) {
            QLog.e("SoMonitor.SoMonitorMmkvHelper", 1, "getSoFileWithJson err: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(MMKVOptionEntity mMKVOptionEntity) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (a aVar : i(mMKVOptionEntity.decodeStringSet("so_monitor_so_file_info", new HashSet()))) {
            if (aVar != null) {
                String d16 = g.d(aVar.f274724c);
                if (!mMKVOptionEntity.containsKey(d16)) {
                    mMKVOptionEntity.encodeString(d16, e(aVar));
                }
            }
        }
        mMKVOptionEntity.removeKey("so_monitor_so_file_info");
        mMKVOptionEntity.encodeBool("so_monitor_is_convert_done", true);
        QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[convertOldData], convertOldData over, set flag, cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(a aVar, Context context) {
        String str = aVar.f274724c;
        File file = new File(str);
        if (!file.exists()) {
            QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[saveSoFileInfo]: + " + str + " is not exists!");
            return;
        }
        aVar.f274727f = g.c(file);
        j(context, aVar, false);
    }

    private static Set<a> i(Set<String> set) {
        Gson gson = new Gson();
        HashSet hashSet = new HashSet();
        try {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                a aVar = (a) gson.fromJson(it.next(), a.class);
                if (aVar != null) {
                    hashSet.add(aVar);
                }
            }
        } catch (Exception e16) {
            QLog.e("SoMonitor.SoMonitorMmkvHelper", 1, "parseSoFileInfoSet err.", e16);
        }
        return hashSet;
    }

    public static void j(Context context, a aVar, boolean z16) {
        if (context == null) {
            QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[saveSoFileInfo], context is null! " + aVar);
        }
        MMKVOptionEntity from = QMMKV.from(context, "so_monitor_so_file_infocommon_mmkv_configurations");
        QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[saveSoFileInfo], save to mmkv: " + aVar);
        from.encodeString(aVar.f274723b, e(aVar));
        if (z16) {
            l(context, aVar);
        }
    }

    public static boolean k(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("SoMonitor.SoMonitorMmkvHelper", 1, "[saveSoFileInfo], soFileInfoString is empty!");
            return false;
        }
        try {
            j(context, (a) new Gson().fromJson(str, a.class), true);
            return true;
        } catch (Exception e16) {
            QLog.e("SoMonitor.SoMonitorMmkvHelper", 1, "saveSoFileInfo gson err.", e16);
            return false;
        }
    }

    public static void l(final Context context, final a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqsomonitor.e
            @Override // java.lang.Runnable
            public final void run() {
                f.h(a.this, context);
            }
        }, 64, null, false);
    }
}
