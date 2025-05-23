package com.tencent.luggage.wxa.ar;

import android.content.SharedPreferences;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.CommandCfgPlugin;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f121791a = new HashMap();

    public static synchronized boolean a(String str, long j3) {
        synchronized (x.class) {
            if ("true".equals(CommandCfg.getInstance().getCmd("dis_" + str))) {
                x0.d("FrequentLimiter", "canDo, dis_" + str + " is true");
                return false;
            }
            SharedPreferences f16 = y0.f();
            long j16 = f16.getLong(str, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - j16) < j3) {
                x0.d("FrequentLimiter", "canDo, time not up for " + str);
                return false;
            }
            f16.edit().putLong(str, currentTimeMillis).commit();
            return true;
        }
    }

    public static synchronized void b(String str) {
        synchronized (x.class) {
            y0.f().edit().putLong(str, 0L).commit();
        }
    }

    public static synchronized boolean a(String str) {
        synchronized (x.class) {
            SharedPreferences h16 = y0.h();
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
            if (format.equals(h16.getString(str, ""))) {
                return false;
            }
            if ("true".equals(CommandCfgPlugin.getInstance().getCmd("dis_" + str))) {
                x0.d("FrequentLimiter", "canDoDaily, dis_" + str + " is true");
                return false;
            }
            h16.edit().putString(str, format).commit();
            return true;
        }
    }

    public static synchronized boolean a(String str, String str2) {
        synchronized (x.class) {
            SharedPreferences k3 = y0.k();
            String string = k3.getString(str, "");
            if (string == null) {
                string = "";
            }
            if (string.equals(str2)) {
                return false;
            }
            k3.edit().putString(str, str2).commit();
            return true;
        }
    }
}
