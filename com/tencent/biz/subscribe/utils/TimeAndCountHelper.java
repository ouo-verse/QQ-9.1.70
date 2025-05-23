package com.tencent.biz.subscribe.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TimeAndCountHelper {

    /* renamed from: b, reason: collision with root package name */
    private static volatile TimeAndCountHelper f96242b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Timer> f96243a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, a aVar) {
        SharedPreferences a16 = k.a(context);
        if (a16 != null) {
            int i3 = a16.getInt(e(str), 0) + 1;
            if (aVar != null) {
                aVar.a(i3);
            }
        }
    }

    public static TimeAndCountHelper d() {
        if (f96242b == null) {
            synchronized (TimeAndCountHelper.class) {
                if (f96242b == null) {
                    f96242b = new TimeAndCountHelper();
                }
            }
        }
        return f96242b;
    }

    private String e(String str) {
        return str + "_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }

    public int c(Context context, String str) {
        return k.a(context).getInt(e(str), 0);
    }

    @SuppressLint({"NewApi"})
    public void f(Context context, String str, int i3) {
        SharedPreferences a16 = k.a(context);
        SharedPreferences.Editor edit = a16.edit();
        String e16 = e(str);
        edit.putInt(e16, a16.getInt(e16, 0) + i3);
        edit.apply();
    }

    public void g(final Context context, final String str, int i3, final a aVar) {
        if (i3 > 0) {
            h(str);
            BaseTimer baseTimer = new BaseTimer();
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.biz.subscribe.utils.TimeAndCountHelper.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    TimeAndCountHelper.this.b(context, str, aVar);
                }
            }, i3);
            this.f96243a.put(str, baseTimer);
            return;
        }
        b(context, str, aVar);
    }

    public void h(String str) {
        Timer timer = this.f96243a.get(str);
        if (timer != null) {
            timer.cancel();
            timer.purge();
            this.f96243a.remove(str);
        }
    }
}
