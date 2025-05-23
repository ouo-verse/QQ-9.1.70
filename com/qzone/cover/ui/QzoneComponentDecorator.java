package com.qzone.cover.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneComponentDecorator extends View {
    protected static volatile Drawable K;
    protected boolean C;
    protected WeakReference<a> D;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<Activity> f46741d;

    /* renamed from: e, reason: collision with root package name */
    protected String f46742e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f46743f;

    /* renamed from: h, reason: collision with root package name */
    protected int f46744h;

    /* renamed from: i, reason: collision with root package name */
    protected int f46745i;

    /* renamed from: m, reason: collision with root package name */
    protected int f46746m;
    public static int E = ViewUtils.dip2px(67.0f);
    public static int F = ViewUtils.dip2px(83.0f);
    protected static int G = ViewUtils.dip2px(30.0f);
    protected static int H = ViewUtils.dip2px(30.0f);
    protected static int I = ViewUtils.dip2px(52.0f);
    protected static int J = ViewUtils.dip2px(62.0f);
    protected static boolean L = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class WeakRefRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QzoneComponentDecorator> f46747d;

        public WeakRefRunnable(QzoneComponentDecorator qzoneComponentDecorator) {
            this.f46747d = null;
            this.f46747d = new WeakReference<>(qzoneComponentDecorator);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<QzoneComponentDecorator> weakReference = this.f46747d;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f46747d.get().f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void onStateChange(int i3);
    }

    public QzoneComponentDecorator(Context context) {
        super(context);
        this.f46744h = ViewUtils.dip2px(11.0f);
        this.f46745i = ViewUtils.dpToPx(27.0f);
        this.f46746m = ViewUtils.dip2px(65.0f);
        this.C = false;
    }

    public int a() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        return false;
    }

    public void c(Activity activity, String str) {
        this.f46741d = new WeakReference<>(activity);
        this.f46742e = str;
        if (!LoginData.getInstance().getUinString().equals(str)) {
            this.f46743f = false;
        } else {
            this.f46743f = true;
        }
        this.C = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(str).isSplendid();
    }

    public void d() {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneComponentDecorator", 2, "notifyUpdateAllResource");
        }
        VasQzoneYellowThread.INSTANCE.execJob(new WeakRefRunnable(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setLocationOffest(int i3, int i16) {
        this.f46744h = i3;
        this.f46745i = i16;
    }

    public void setOnShowDressStateChangeListener(a aVar) {
        this.D = new WeakReference<>(aVar);
    }

    public QzoneComponentDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f46744h = ViewUtils.dip2px(11.0f);
        this.f46745i = ViewUtils.dpToPx(27.0f);
        this.f46746m = ViewUtils.dip2px(65.0f);
        this.C = false;
    }

    public QzoneComponentDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46744h = ViewUtils.dip2px(11.0f);
        this.f46745i = ViewUtils.dpToPx(27.0f);
        this.f46746m = ViewUtils.dip2px(65.0f);
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
    }
}
