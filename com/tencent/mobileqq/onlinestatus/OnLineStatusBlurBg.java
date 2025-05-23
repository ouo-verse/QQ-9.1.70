package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnLineStatusBlurBg {

    /* renamed from: a, reason: collision with root package name */
    private String f255292a = "";

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f255293b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f255294c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<b> f255295d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f255312a = null;

        /* renamed from: b, reason: collision with root package name */
        public QBaseActivity f255313b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f255314c = Color.parseColor("#AA000000");

        /* renamed from: d, reason: collision with root package name */
        public int f255315d = Color.parseColor("#0C000000");

        /* renamed from: e, reason: collision with root package name */
        public int f255316e = Color.parseColor("#4DEBEDF5");

        /* renamed from: f, reason: collision with root package name */
        public String f255317f = "0";

        /* renamed from: g, reason: collision with root package name */
        public int f255318g = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f255319h = -1;

        /* renamed from: i, reason: collision with root package name */
        public boolean f255320i = true;

        public void a() {
            Bitmap bitmap = this.f255312a;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f255312a.recycle();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void v3(boolean z16, Bitmap bitmap, int i3);
    }

    private void e(@NonNull final a aVar, final Bitmap bitmap, final int i3, final String str, final int i16, final long j3) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QBaseActivity qBaseActivity = aVar.f255313b;
                    if (qBaseActivity != null && !qBaseActivity.isFinishing() && OnLineStatusBlurBg.this.f255295d != null && OnLineStatusBlurBg.this.f255295d.get() != 0) {
                        final b bVar = (b) OnLineStatusBlurBg.this.f255295d.get();
                        Bitmap a16 = com.tencent.mobileqq.onlinestatus.utils.g.a(bitmap, i3, aVar.f255313b);
                        if (a16 == null) {
                            QLog.e("OnLineStatusBlurBg", 1, "run: decorViewBitmap == null");
                            aVar.f255313b.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.v3(false, null, i16);
                                }
                            });
                            return;
                        }
                        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                        if (waitAppRuntime == null) {
                            aVar.f255313b.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.v3(false, null, i16);
                                }
                            });
                            return;
                        }
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a16, (int) (a16.getWidth() * 0.0625f), (int) (a16.getHeight() * 0.0625f), false);
                        if (createScaledBitmap == null) {
                            QLog.e("OnLineStatusBlurBg", 1, "run: scaledBitmap == null");
                            waitAppRuntime.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.v3(false, null, i16);
                                }
                            });
                            com.tencent.mobileqq.onlinestatus.utils.h.a();
                            return;
                        }
                        Bitmap process = new StackBlurManager(createScaledBitmap).process(16);
                        if (process == null) {
                            QLog.e("OnLineStatusBlurBg", 1, "run: blured bitmap is null");
                            waitAppRuntime.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.v3(false, null, i16);
                                }
                            });
                            com.tencent.mobileqq.onlinestatus.utils.h.a();
                            return;
                        }
                        Canvas canvas = new Canvas(createScaledBitmap);
                        canvas.setDensity(process.getDensity());
                        canvas.drawColor(0);
                        canvas.drawBitmap(process, 0.0f, 0.0f, (Paint) null);
                        if (!"1103".equals(QQTheme.getCurrentThemeId())) {
                            QQTheme.getCurrentThemeId();
                        }
                        canvas.drawColor(aVar.f255315d);
                        canvas.setBitmap(null);
                        OnLineStatusBlurBg.this.f255293b = createScaledBitmap;
                        OnLineStatusBlurBg.this.f255292a = str;
                        QLog.d("OnLineStatusBlurBg", 1, "blur bg cost " + (System.currentTimeMillis() - j3) + "ms");
                        waitAppRuntime.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1.5
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.v3(true, OnLineStatusBlurBg.this.f255293b, i16);
                            }
                        });
                    }
                } catch (Throwable th5) {
                    QLog.e("OnLineStatusBlurBg", 1, "run: ", th5);
                    com.tencent.mobileqq.onlinestatus.utils.h.a();
                }
            }
        }, null, false);
    }

    private String g(a aVar, int i3) {
        return aVar.f255313b.getActivityName() + "_" + i3 + "_" + aVar.f255317f + "_" + QQTheme.getCurrentThemeId();
    }

    public OnLineStatusBlurBg f() {
        OnLineStatusBlurBg onLineStatusBlurBg = new OnLineStatusBlurBg();
        onLineStatusBlurBg.f255293b = this.f255293b;
        onLineStatusBlurBg.f255294c = this.f255294c;
        onLineStatusBlurBg.f255292a = this.f255292a;
        return onLineStatusBlurBg;
    }

    public boolean h() {
        return true;
    }

    public void i(@NonNull a aVar, b bVar) {
        boolean z16;
        int i3;
        int i16;
        if (aVar.f255313b != null && bVar != null) {
            if (!"1103".equals(QQTheme.getCurrentThemeId()) && !"2920".equals(QQTheme.getCurrentThemeId())) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!h()) {
                if (z16) {
                    i16 = aVar.f255316e;
                } else {
                    i16 = aVar.f255314c;
                }
                this.f255294c = i16;
                bVar.v3(false, null, i16);
                return;
            }
            if (z16) {
                i3 = aVar.f255316e;
            } else {
                i3 = aVar.f255315d;
            }
            int i17 = i3;
            this.f255294c = i17;
            String g16 = g(aVar, i17);
            QLog.d("OnLineStatusBlurBg", 1, "startBlurBg want key: " + g16 + " current key: " + this.f255292a);
            if (g16.equals(this.f255292a)) {
                QLog.d("OnLineStatusBlurBg", 1, "startBlurBg use cached bitmap!");
                bVar.v3(true, this.f255293b, i17);
                return;
            }
            this.f255295d = new WeakReference<>(bVar);
            long currentTimeMillis = System.currentTimeMillis();
            if (OnlineStatusToggleUtils.p() && QQTheme.isVasTheme() && aVar.f255320i) {
                Drawable drawable = ResourcesCompat.getDrawable(BaseApplication.getContext().getResources(), R.drawable.qui_common_bg_primary_bg, BaseApplication.getContext().getTheme());
                if (drawable instanceof BitmapDrawable) {
                    aVar.f255312a = ((BitmapDrawable) drawable).getBitmap();
                }
            }
            Bitmap bitmap = aVar.f255312a;
            if (bitmap == null) {
                bitmap = com.tencent.mobileqq.onlinestatus.utils.g.b(aVar.f255313b, aVar.f255318g, aVar.f255319h);
            }
            e(aVar, bitmap, com.tencent.mobileqq.onlinestatus.utils.g.c(aVar.f255313b, aVar.f255318g), g16, i17, currentTimeMillis);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusBlurBg", 4, "startBlurBg activity or listener is empty");
        }
    }
}
