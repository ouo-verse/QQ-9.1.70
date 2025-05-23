package com.tencent.av.ui.guide;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.aj;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GuideHelper {

    /* renamed from: f, reason: collision with root package name */
    private static long f75912f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static long f75913g = -1;

    /* renamed from: h, reason: collision with root package name */
    static String f75914h = "qav_guide_gesture/data.json";

    /* renamed from: i, reason: collision with root package name */
    static String f75915i = "qav_guide_gesture/images/";

    /* renamed from: a, reason: collision with root package name */
    private Context f75916a;

    /* renamed from: c, reason: collision with root package name */
    DelayTryShowRunnable f75918c;

    /* renamed from: b, reason: collision with root package name */
    private boolean f75917b = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f75919d = false;

    /* renamed from: e, reason: collision with root package name */
    c f75920e = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DelayTryShowRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public int f75922d = 0;

        /* renamed from: e, reason: collision with root package name */
        long f75923e = 0;

        /* renamed from: f, reason: collision with root package name */
        WeakReference<Context> f75924f = null;

        /* renamed from: h, reason: collision with root package name */
        WeakReference<GuideHelper> f75925h = null;

        DelayTryShowRunnable() {
        }

        public final boolean a(long j3, Context context, GuideHelper guideHelper, long j16) {
            this.f75923e = j3;
            this.f75924f = new WeakReference<>(context);
            this.f75925h = new WeakReference<>(guideHelper);
            com.tencent.qav.thread.a.d().removeCallbacks(this);
            return com.tencent.qav.thread.a.d().postDelayed(this, j16);
        }

        public final void b(long j3) {
            QLog.w("GuideHelper", 1, "removeCallback, seq[" + j3 + "], last_seq[" + this.f75923e + "]");
            this.f75923e = 0L;
            this.f75924f = null;
            this.f75925h = null;
            com.tencent.qav.thread.a.d().removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            if (this.f75923e == 0) {
                return;
            }
            WeakReference<Context> weakReference = this.f75924f;
            GuideHelper guideHelper = null;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (context == null) {
                QLog.w("GuideHelper", 1, "DelayTryShowRunnable, context fail, seq[" + this.f75923e + "]");
                return;
            }
            WeakReference<GuideHelper> weakReference2 = this.f75925h;
            if (weakReference2 != null) {
                guideHelper = weakReference2.get();
            }
            if (guideHelper != null) {
                guideHelper.q(this.f75923e, context, this.f75922d);
                return;
            }
            QLog.w("GuideHelper", 1, "DelayTryShowRunnable, GuideHelper fail, seq[" + this.f75923e + "]");
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class LottieDrawableHelper {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public interface a {
            void onLoad(LottieDrawable lottieDrawable);
        }

        void a(final long j3, final Context context, String str, final a aVar) {
            try {
                LottieComposition.Factory.fromAssetFileName(context, str, new OnCompositionLoadedListener() { // from class: com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.1

                    /* compiled from: P */
                    /* renamed from: com.tencent.av.ui.guide.GuideHelper$LottieDrawableHelper$1$a */
                    /* loaded from: classes3.dex */
                    class a implements ImageAssetDelegate {
                        a() {
                        }

                        @Override // com.airbnb.lottie.ImageAssetDelegate
                        @Nullable
                        public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                            InputStream inputStream;
                            try {
                                inputStream = context.getAssets().open(GuideHelper.f75915i + lottieImageAsset.getFileName());
                            } catch (Throwable th5) {
                                th = th5;
                                inputStream = null;
                            }
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inScaled = false;
                                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                                inputStream.close();
                                try {
                                    inputStream.close();
                                } catch (Exception unused) {
                                }
                                return decodeStream;
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    QLog.i("GuideHelper", 2, "fetchBitmap error ", th);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    return null;
                                } catch (Throwable th7) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    throw th7;
                                }
                            }
                        }
                    }

                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (lottieComposition == null) {
                            QLog.w("GuideHelper", 1, "onCompositionLoaded, fail, seq[" + j3 + "]");
                            return;
                        }
                        final LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setComposition(lottieComposition);
                        lottieDrawable.setRepeatCount(-1);
                        lottieDrawable.setImageAssetDelegate(new a());
                        com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.onLoad(lottieDrawable);
                                }
                            }
                        });
                    }
                });
            } catch (Exception e16) {
                QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + j3 + "]", e16);
                com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.onLoad(null);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f75934d;

        a(long j3) {
            this.f75934d = j3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QLog.w("GuideHelper", 1, "onTouch to hide, seq[" + this.f75934d + "]");
            GuideHelper.this.j(this.f75934d);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements LottieDrawableHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f75936a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f75937b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f75938c;

        b(long j3, Context context, int i3) {
            this.f75936a = j3;
            this.f75937b = context;
            this.f75938c = i3;
        }

        @Override // com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.a
        public void onLoad(LottieDrawable lottieDrawable) {
            View view;
            c cVar = GuideHelper.this.f75920e;
            cVar.f75943d = lottieDrawable;
            if (lottieDrawable != null && (view = cVar.f75941b) != null) {
                view.setBackgroundDrawable(lottieDrawable);
                GuideHelper.this.q(this.f75936a, this.f75937b, this.f75938c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        ViewStub f75940a = null;

        /* renamed from: b, reason: collision with root package name */
        View f75941b = null;

        /* renamed from: c, reason: collision with root package name */
        View f75942c = null;

        /* renamed from: d, reason: collision with root package name */
        LottieDrawable f75943d = null;

        c() {
        }

        public void a() {
            this.f75940a = null;
            this.f75941b = null;
            this.f75943d = null;
        }

        public void b(boolean z16) {
            int i3;
            QLog.w("GuideHelper", 1, "show[" + z16 + "]");
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            LottieDrawable lottieDrawable = this.f75943d;
            if (lottieDrawable != null) {
                if (z16) {
                    lottieDrawable.pauseAnimation();
                    this.f75943d.playAnimation();
                } else {
                    lottieDrawable.pauseAnimation();
                }
            }
            ViewStub viewStub = this.f75940a;
            if (viewStub != null) {
                viewStub.setVisibility(i3);
            }
            View view = this.f75942c;
            if (view != null) {
                view.setVisibility(i3);
            }
            View view2 = this.f75941b;
            if (view2 != null) {
                view2.setVisibility(i3);
            }
        }
    }

    private boolean c(long j3, Context context) {
        aj ajVar;
        boolean z16;
        if (g(context) != 0) {
            return true;
        }
        AVActivity aVActivity = (AVActivity) context;
        SessionInfo f16 = n.e().f();
        if (f16 == null || (ajVar = aVActivity.I0) == null || ajVar.p() == null || f16.f73098x2) {
            return true;
        }
        boolean P = f16.P();
        boolean I = aVActivity.I0.I();
        if (!aVActivity.I0.p().v0(0) && !aVActivity.I0.p().v0(-1)) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean l16 = aVActivity.I0.l1(j3);
        if (!P || !I || !z16 || !l16) {
            return true;
        }
        return false;
    }

    private boolean d(Context context) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (h(context) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            AVActivity aVActivity = (AVActivity) context;
            SessionInfo f16 = n.e().f();
            if (f16 == null || aVActivity.I0 == null || f16.f73098x2) {
                return true;
            }
            boolean z19 = !f16.B();
            boolean I = aVActivity.I0.I();
            QavPanel p16 = aVActivity.I0.p();
            if (p16 != null && (p16.v0(0) || p16.v0(-1))) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!I || !z17 || !z19) {
                z18 = true;
            }
            return z18;
        }
        return z16;
    }

    private int f(long j3, Context context) {
        boolean c16 = c(j3, context);
        boolean d16 = d(context);
        if (!c16 && !d16) {
            return 2;
        }
        if (!c16) {
            return 0;
        }
        if (!d16) {
            return 1;
        }
        return -1;
    }

    static long g(Context context) {
        if (f75912f == -1) {
            f75912f = ea.U0(context).getLong("qav_UserGuide_gesture_had_show", 0L);
        }
        return f75912f;
    }

    private static long h(Context context) {
        if (f75913g == -1) {
            f75913g = ea.U0(context).getLong("qav_UserGuide_textchat_had_show2", 0L);
        }
        return f75913g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j3) {
        this.f75920e.b(false);
    }

    private boolean k(long j3, Context context, int i3) {
        boolean z16;
        aj ajVar;
        if (!(context instanceof AVActivity)) {
            QLog.w("GuideHelper", 1, "initTipsView, fail, context[" + context + "], seq[" + j3 + "]");
            return false;
        }
        AVActivity aVActivity = (AVActivity) context;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        c cVar = this.f75920e;
        if (cVar.f75941b == null) {
            if (cVar.f75940a == null) {
                cVar.f75940a = (ViewStub) aVActivity.findViewById(R.id.m0y);
                ViewStub viewStub = this.f75920e.f75940a;
                if (viewStub != null) {
                    viewStub.inflate();
                }
            }
            this.f75920e.f75942c = aVActivity.findViewById(R.id.m19);
            c cVar2 = this.f75920e;
            cVar2.f75941b = cVar2.f75942c.findViewById(R.id.m1l);
        }
        this.f75920e.f75942c.setOnTouchListener(new a(j3));
        if (z16) {
            if (this.f75920e.f75943d == null) {
                new LottieDrawableHelper().a(j3, context, f75914h, new b(j3, context, i3));
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.f75920e.f75941b.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f75920e.f75941b.setBackgroundDrawable(aVActivity.getResources().getDrawable(R.drawable.f161332bh1));
            this.f75920e.f75941b.setContentDescription(aVActivity.getString(R.string.f17787355));
        }
        if (aVActivity == null || (ajVar = aVActivity.I0) == null || ajVar.p() == null) {
            return false;
        }
        return true;
    }

    static void o(Context context, long j3) {
        f75912f = System.currentTimeMillis();
        SharedPreferences.Editor edit = ea.U0(context).edit();
        edit.putLong("qav_UserGuide_gesture_had_show", f75912f);
        edit.apply();
        QLog.w("AVActivity", 1, "qav_UserGuide_gesture, save, time[" + f75912f + "], seq[" + j3 + "]");
    }

    private static void p(Context context, long j3) {
        f75913g = System.currentTimeMillis();
        SharedPreferences.Editor edit = ea.U0(context).edit();
        edit.putLong("qav_UserGuide_textchat_had_show2", f75913g);
        edit.apply();
        QLog.w("AVActivity", 1, "qav_UserGuide_gesture, save, time[" + f75912f + "], seq[" + j3 + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final long j3, Context context, int i3) {
        boolean z16;
        int f16 = f(j3, context);
        if (f16 != -1 && (i3 == 2 || ((f16 != 2 && i3 == f16) || f16 == 2))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (e.j()) {
                QLog.w("GuideHelper", 1, "tryShow, checkCondition false, had_show[" + f75912f + "], seq[" + j3 + "]canShowTarget[" + f16 + "]");
                return;
            }
            return;
        }
        if (this.f75919d) {
            QLog.w("GuideHelper", 1, "tryShow, mIsDestroyed[" + this.f75919d + "], seq[" + j3 + "]");
            return;
        }
        if (i3 == 2) {
            if (f16 == 2) {
                i3 = 0;
            } else {
                i3 = f16;
            }
        }
        if (!k(j3, context, i3)) {
            QLog.w("GuideHelper", 1, "tryShow, initTipsView false, had_show[" + f75912f + "], seq[" + j3 + "]");
            return;
        }
        c cVar = this.f75920e;
        if (cVar.f75943d == null && i3 == 0) {
            QLog.w("GuideHelper", 1, "tryShow, loadedLottieDrawable, seq[" + j3 + "]");
            return;
        }
        if (this.f75917b) {
            QLog.w("GuideHelper", 1, "not support show double times guider under one-time talk");
            return;
        }
        this.f75917b = true;
        cVar.b(true);
        DataReport.a.b();
        com.tencent.qav.thread.a.d().postDelayed(new Runnable() { // from class: com.tencent.av.ui.guide.GuideHelper.3
            @Override // java.lang.Runnable
            public void run() {
                GuideHelper.this.j(j3);
            }
        }, 5000L);
        if (i3 == 0) {
            o(context, j3);
        } else {
            p(context, j3);
        }
    }

    public void e() {
        this.f75917b = false;
        q(-1L, this.f75916a, 1);
    }

    public boolean i(int i3) {
        return d(this.f75916a);
    }

    public void l(Context context) {
        this.f75919d = false;
        this.f75917b = false;
        this.f75916a = context;
    }

    public void m(long j3) {
        j(j3);
        LottieDrawable lottieDrawable = this.f75920e.f75943d;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
            this.f75920e.f75943d.clearComposition();
            this.f75920e.f75943d.setImageAssetDelegate(null);
        }
        this.f75920e.a();
        this.f75919d = true;
        this.f75917b = false;
    }

    public void n(long j3, Context context, int i3, int i16) {
        if (4 == i3) {
            if (this.f75918c == null) {
                this.f75918c = new DelayTryShowRunnable();
            }
            DelayTryShowRunnable delayTryShowRunnable = this.f75918c;
            delayTryShowRunnable.f75922d = i16;
            delayTryShowRunnable.a(j3, context, this, 2000L);
        } else if (3 == i3) {
            DelayTryShowRunnable delayTryShowRunnable2 = this.f75918c;
            if (delayTryShowRunnable2 != null) {
                delayTryShowRunnable2.b(j3);
            }
            j(j3);
        }
        if (i3 == 0) {
            j(j3);
        } else if (99 == i3) {
            q(j3, context, i16);
        }
    }
}
