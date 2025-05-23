package com.tencent.mobileqq.danmaku;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.common.danmaku.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.HashMap;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQDanmakuDependImp implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Handler f203060a;

    /* renamed from: b, reason: collision with root package name */
    private DecimalFormat f203061b;

    public QQDanmakuDependImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f203061b = new DecimalFormat("00.00");
        }
    }

    @Override // com.tencent.common.danmaku.b
    public void a(int i3, int i16, long j3, HashMap hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), hashMap);
        } else if (Foreground.getTopActivity() != null && i16 != 0) {
            ThreadManagerV2.post(new Runnable(i16, i3, j3, hashMap) { // from class: com.tencent.mobileqq.danmaku.QQDanmakuDependImp.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f203062d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f203063e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f203064f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ HashMap f203065h;

                {
                    this.f203062d = i16;
                    this.f203063e = i3;
                    this.f203064f = j3;
                    this.f203065h = hashMap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQDanmakuDependImp.this, Integer.valueOf(i16), Integer.valueOf(i3), Long.valueOf(j3), hashMap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity topActivity = Foreground.getTopActivity();
                    if (topActivity != null && this.f203062d != 0) {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put("danmaku_jam_rate", QQDanmakuDependImp.this.f203061b.format((this.f203063e * 100.0f) / this.f203062d));
                        hashMap2.put("danmaku_avg_time", QQDanmakuDependImp.this.f203061b.format(((float) this.f203064f) / this.f203062d));
                        hashMap2.put("application_type", "1");
                        HashMap hashMap3 = this.f203065h;
                        if (hashMap3 != null) {
                            hashMap2.putAll(hashMap3);
                        }
                        StatisticCollector.getInstance(topActivity).collectPerformance(null, "actKanDianDanmakuData", true, -1L, -1L, hashMap2, null);
                    }
                }
            }, 1, null, true);
        }
    }

    @Override // com.tencent.common.danmaku.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.common.danmaku.b
    public WindowManager c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WindowManager) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            return topActivity.getWindowManager();
        }
        return null;
    }

    @Override // com.tencent.common.danmaku.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.common.danmaku.b
    public Resources e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Resources) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MobileQQ.sMobileQQ.getApplicationContext().getResources();
    }

    @Override // com.tencent.common.danmaku.b
    public Object f(Class<?> cls, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, this, cls, str, obj);
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.common.danmaku.b
    public Handler getHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Handler) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f203060a == null) {
            this.f203060a = new Handler(Looper.getMainLooper());
        }
        return this.f203060a;
    }

    @Override // com.tencent.common.danmaku.b
    public boolean isDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
