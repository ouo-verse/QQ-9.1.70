package com.qzone.reborn.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;

/* loaded from: classes37.dex */
public class QZoneSoftHeightProvider extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    private Activity f59637d;

    /* renamed from: e, reason: collision with root package name */
    private volatile LinearLayout f59638e;

    /* renamed from: f, reason: collision with root package name */
    private View f59639f;

    /* renamed from: h, reason: collision with root package name */
    private a f59640h;

    /* renamed from: i, reason: collision with root package name */
    private int f59641i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f59642m;

    /* loaded from: classes37.dex */
    public interface a {
        void a(boolean z16, int i3);
    }

    public QZoneSoftHeightProvider(Activity activity, View view) {
        super(activity);
        this.f59642m = false;
        this.f59637d = activity;
        this.f59639f = view;
        this.f59638e = new LinearLayout(activity);
        this.f59638e.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
        setContentView(this.f59638e);
        this.f59638e.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(0);
        setHeight(-1);
        setSoftInputMode(21);
        setInputMethodMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f59638e == null) {
            QLog.e("QZoneSoftHeightProvider", 1, "QZoneSoftHeightProvider mRootView is null");
            return;
        }
        Rect rect = new Rect();
        try {
            this.f59638e.getWindowVisibleDisplayFrame(rect);
            int i3 = rect.bottom;
            if (i3 > this.f59641i) {
                this.f59641i = i3;
            }
            final int i16 = this.f59641i - i3;
            if (QZoneConfigHelper.p() && i16 > this.f59641i / 2 && !AppSetting.p(this.f59637d)) {
                QLog.d("QZoneSoftHeightProvider", 1, "enableFixKeyboardHeightCompat keyboardHeight=" + i16 + ",mHeightMax=" + this.f59641i);
                return;
            }
            if (i16 <= 0 && !this.f59642m) {
                QLog.d("QZoneSoftHeightProvider", 1, "QZoneSoftHeightProvider filter first keyboard height");
                return;
            }
            this.f59642m = true;
            if (!com.qzone.reborn.configx.g.f53821a.b().B1()) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.widget.QZoneSoftHeightProvider.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneSoftHeightProvider.this.f59640h != null) {
                            a aVar = QZoneSoftHeightProvider.this.f59640h;
                            int i17 = i16;
                            aVar.a(i17 > 0, i17);
                        }
                    }
                });
            } else {
                a aVar = this.f59640h;
                if (aVar != null) {
                    aVar.a(i16 > 0, i16);
                }
            }
            int i17 = LocalMultiProcConfig.getInt("QZoneSoftHeight", 0);
            if (i16 <= 0 || i17 == i16) {
                return;
            }
            LocalMultiProcConfig.putInt("QZoneSoftHeight", i16);
        } catch (Exception e16) {
            QLog.e("QZoneSoftHeightProvider", 1, "[onKeyboardChange] getWindowVisibleDisplayFrame error:" + e16);
        }
    }

    public int e() {
        return LocalMultiProcConfig.getInt("QZoneSoftHeight", 0);
    }

    public QZoneSoftHeightProvider f() {
        if (this.f59637d.isFinishing()) {
            QLog.e("QZoneSoftHeightProvider", 1, "QZoneSoftHeightProvider init activity isFinishing");
            return this;
        }
        this.f59639f.post(new Runnable() { // from class: com.qzone.reborn.widget.QZoneSoftHeightProvider.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneSoftHeightProvider.this.isShowing() || QZoneSoftHeightProvider.this.f59639f == null) {
                    return;
                }
                if (QZoneSoftHeightProvider.this.f59639f.getWindowToken() != null) {
                    QZoneSoftHeightProvider qZoneSoftHeightProvider = QZoneSoftHeightProvider.this;
                    qZoneSoftHeightProvider.showAtLocation(qZoneSoftHeightProvider.f59639f, 0, 0, 0);
                    QLog.i("QZoneSoftHeightProvider", 1, "QZoneSoftHeightProvider is show location");
                    return;
                }
                QLog.e("QZoneSoftHeightProvider", 1, "QZoneSoftHeightProvider init getWindowToken = null");
            }
        });
        return this;
    }

    public void h() {
        if (this.f59638e != null) {
            this.f59638e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public QZoneSoftHeightProvider i(a aVar) {
        this.f59640h = aVar;
        return this;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!com.qzone.reborn.configx.g.f53821a.b().B1()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.widget.QZoneSoftHeightProvider.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneSoftHeightProvider.this.g();
                }
            });
        } else {
            g();
        }
    }

    public void d() {
        this.f59640h = null;
        h();
        dismiss();
    }
}
