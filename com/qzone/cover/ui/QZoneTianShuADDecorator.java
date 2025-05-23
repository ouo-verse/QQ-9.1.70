package com.qzone.cover.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.qzone.business.tianshu.QZoneTianShuAdManager;
import com.qzone.cover.ui.QZoneTianShuADDecorator;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.ar;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTianShuADDecorator extends QzoneComponentDecorator {
    private String M;
    private HashMap<String, String> N;
    private URLDrawable P;
    private FastDynamicDrawable Q;
    private String R;
    private String S;
    private String T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f46726a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f46727b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f46728c0;

    /* renamed from: d0, reason: collision with root package name */
    private GestureDetector f46729d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Drawable.Callback f46730e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.cover.ui.QZoneTianShuADDecorator$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            QZoneTianShuADDecorator.this.requestLayout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit f(d dVar) {
            QZoneTianShuADDecorator.this.setBoundsForDrawable();
            WeakReference<Activity> weakReference = QZoneTianShuADDecorator.this.f46741d;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            QZoneTianShuADDecorator.this.f46741d.get().runOnUiThread(new Runnable() { // from class: com.qzone.cover.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneTianShuADDecorator.AnonymousClass1.this.e();
                }
            });
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = (HashMap) QZoneTianShuAdManager.e().h("640");
            if (QZoneTianShuADDecorator.this.N == null || !QZoneTianShuADDecorator.this.N.equals(hashMap)) {
                QZoneTianShuADDecorator.this.N = hashMap;
                if (hashMap == null || hashMap.isEmpty()) {
                    QZoneTianShuADDecorator.this.x();
                } else {
                    QZoneTianShuADDecorator.this.S = (String) hashMap.get("img");
                    QZoneTianShuADDecorator.this.T = (String) hashMap.get(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                    QZoneTianShuADDecorator.this.R = (String) hashMap.get("adId");
                    if (!TextUtils.isEmpty(QZoneTianShuADDecorator.this.S) && !TextUtils.isEmpty(QZoneTianShuADDecorator.this.T) && !TextUtils.isEmpty(QZoneTianShuADDecorator.this.R)) {
                        if (ar.b("anzaihuang", "2024-01-19", "vas_qzone_ad_anim_anr_bug").isEnable(true)) {
                            QZoneTianShuADDecorator.this.Q = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(QZoneTianShuADDecorator.this.S).l(VasDynamicDrawableCache.INSTANCE).a();
                            if (QZoneTianShuADDecorator.this.Q != null) {
                                QZoneTianShuADDecorator.this.Q.setCallback(QZoneTianShuADDecorator.this.f46730e0);
                                QZoneTianShuADDecorator.this.Q.c0(new Function1() { // from class: com.qzone.cover.ui.a
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit f16;
                                        f16 = QZoneTianShuADDecorator.AnonymousClass1.this.f((d) obj);
                                        return f16;
                                    }
                                });
                            }
                            QZoneTianShuADDecorator.this.setBoundsForDrawable();
                        } else {
                            QZoneTianShuADDecorator.this.A();
                        }
                    } else {
                        QZLog.w(QZoneTianShuADDecorator.this.M, 1, "Decorator data wrong, imageUrl = ", QZoneTianShuADDecorator.this.S, " mLinkUrl = ", QZoneTianShuADDecorator.this.T);
                        QZoneTianShuADDecorator.this.x();
                        return;
                    }
                }
                if (QZoneTianShuADDecorator.this.P == null && QZoneTianShuADDecorator.this.Q == null) {
                    return;
                }
                QZoneTianShuADDecorator.this.setVisibility(0);
                QZoneTianShuADDecorator.this.requestLayout();
                QZoneTianShuADDecorator.this.postInvalidate();
                QZoneTianShuAdManager.e().d(101, QZoneTianShuADDecorator.this.R);
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneTianShuADDecorator.this.M, 2, "mAdvData equals to adDataMap, return.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            QZoneTianShuADDecorator.this.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            QZoneTianShuADDecorator.this.scheduleDrawable(drawable, runnable, j3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            QZoneTianShuADDecorator.this.unscheduleDrawable(drawable, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            QZoneTianShuADDecorator.this.z((int) motionEvent.getX());
            return true;
        }
    }

    public QZoneTianShuADDecorator(Context context) {
        super(context);
        this.M = "QZoneTianShuADDecorator";
        this.U = com.qzone.util.ar.e(153.0f);
        this.V = com.qzone.util.ar.e(36.0f);
        this.W = com.qzone.util.ar.e(11.0f);
        this.f46726a0 = com.qzone.util.ar.e(196.0f);
        this.f46727b0 = com.qzone.util.ar.e(38.0f);
        this.f46728c0 = com.qzone.util.ar.e(15.0f);
        this.f46730e0 = new a();
        B(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        String str = this.S;
        if (TextUtils.isEmpty(str) || URLDrawable.depImp == null) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mUseApngImage = true;
        obtain.mUseMemoryCache = true;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        this.P = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f46730e0);
            int status = this.P.getStatus();
            if (status != 1) {
                this.P.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.qzone.cover.ui.QZoneTianShuADDecorator.2
                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                        QZLog.w(QZoneTianShuADDecorator.this.M, 1, "Decorator image onLoadFialed, cause = ", th5.getMessage());
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadSuccessed(URLDrawable uRLDrawable) {
                        QZoneTianShuADDecorator.this.P = uRLDrawable;
                        QZoneTianShuADDecorator.this.setBoundsForDrawable();
                        WeakReference<Activity> weakReference = QZoneTianShuADDecorator.this.f46741d;
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        QZoneTianShuADDecorator.this.f46741d.get().runOnUiThread(new Runnable() { // from class: com.qzone.cover.ui.QZoneTianShuADDecorator.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZoneTianShuADDecorator.this.requestLayout();
                            }
                        });
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadCanceled(URLDrawable uRLDrawable) {
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                    }
                });
                if (status == 2) {
                    this.P.restartDownload();
                }
            }
            setBoundsForDrawable();
        }
    }

    private void B(Context context) {
        if (this.f46729d0 == null) {
            this.f46729d0 = new GestureDetector(context, new b(), new Handler(Looper.getMainLooper()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3) {
        if (this.f46726a0 - i3 > this.f46728c0) {
            QZoneTianShuAdManager.e().d(102, this.R);
            WeakReference<Activity> weakReference = this.f46741d;
            if (weakReference != null && weakReference.get() != null) {
                yo.d.d(this.T, this.f46741d.get(), null);
            }
        } else {
            QZoneTianShuAdManager.e().d(122, this.R);
        }
        x();
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public boolean b() {
        return !TextUtils.isEmpty(this.S);
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void c(Activity activity, String str) {
        super.c(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void f() {
        WeakReference<Activity> weakReference = this.f46741d;
        if (weakReference != null && weakReference.get() != null) {
            this.f46741d.get().runOnUiThread(new AnonymousClass1());
        }
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator, android.view.View
    public void onDraw(Canvas canvas) {
        y(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.f46726a0, this.f46727b0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!b()) {
            return false;
        }
        this.f46729d0.onTouchEvent(motionEvent);
        return true;
    }

    public void setBoundsForDrawable() {
        Drawable drawable = this.Q;
        if (drawable == null) {
            drawable = this.P;
        }
        if (drawable != null) {
            int intrinsicWidth = (drawable.getIntrinsicWidth() * this.V) / drawable.getIntrinsicHeight();
            this.f46726a0 = this.W + intrinsicWidth;
            drawable.setBounds(0, 0, intrinsicWidth, this.V);
        }
    }

    protected void y(Canvas canvas) {
        canvas.translate(this.W, 0.0f);
        Drawable drawable = this.Q;
        if (drawable == null) {
            drawable = this.P;
        }
        if (drawable != null) {
            try {
                drawable.draw(canvas);
            } catch (OutOfMemoryError e16) {
                x();
                QZLog.e(this.M, 1, "drawSelf Fialed, cause = ", e16);
            }
        }
        canvas.translate(-this.W, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void e() {
        z(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        setVisibility(8);
        this.N = null;
        this.P = null;
        this.Q = null;
        this.S = null;
        this.T = null;
        this.R = null;
        QZoneTianShuAdManager.e().c();
    }

    public QZoneTianShuADDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = "QZoneTianShuADDecorator";
        this.U = com.qzone.util.ar.e(153.0f);
        this.V = com.qzone.util.ar.e(36.0f);
        this.W = com.qzone.util.ar.e(11.0f);
        this.f46726a0 = com.qzone.util.ar.e(196.0f);
        this.f46727b0 = com.qzone.util.ar.e(38.0f);
        this.f46728c0 = com.qzone.util.ar.e(15.0f);
        this.f46730e0 = new a();
        B(context);
    }

    public QZoneTianShuADDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = "QZoneTianShuADDecorator";
        this.U = com.qzone.util.ar.e(153.0f);
        this.V = com.qzone.util.ar.e(36.0f);
        this.W = com.qzone.util.ar.e(11.0f);
        this.f46726a0 = com.qzone.util.ar.e(196.0f);
        this.f46727b0 = com.qzone.util.ar.e(38.0f);
        this.f46728c0 = com.qzone.util.ar.e(15.0f);
        this.f46730e0 = new a();
        B(context);
    }
}
