package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    WindowManager f74619a;

    /* renamed from: b, reason: collision with root package name */
    Context f74620b;

    /* renamed from: d, reason: collision with root package name */
    View f74622d;

    /* renamed from: c, reason: collision with root package name */
    WindowManager.LayoutParams f74621c = new WindowManager.LayoutParams();

    /* renamed from: e, reason: collision with root package name */
    boolean f74623e = false;

    public i(Context context, View view) {
        this.f74622d = null;
        this.f74620b = context;
        this.f74619a = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = this.f74621c;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.flags = 776;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 0;
        layoutParams.type = 2010;
        layoutParams.gravity = 51;
        layoutParams.setTitle("Toast");
        this.f74622d = view;
        a();
    }

    void a() {
        try {
            this.f74621c.getClass().getField("privateFlags").set(this.f74621c, Integer.valueOf(((Integer) this.f74621c.getClass().getField("privateFlags").get(this.f74621c)).intValue() | 64));
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.f74623e;
    }

    public WindowManager.LayoutParams c() {
        return this.f74621c;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4 A[Catch: all -> 0x0108, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000a, B:10:0x0010, B:11:0x0019, B:13:0x0028, B:16:0x0034, B:19:0x0050, B:21:0x0058, B:23:0x0072, B:25:0x007a, B:27:0x0095, B:29:0x00a4, B:30:0x00bc, B:33:0x00c8, B:34:0x00ce, B:36:0x00d4, B:37:0x0106), top: B:2:0x0001, inners: #3, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d() {
        boolean z16;
        synchronized (this) {
            z16 = true;
            if (!this.f74623e) {
                this.f74623e = true;
                try {
                    try {
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("SmallScreenToast", 2, "startHandler addView start");
                            }
                            this.f74619a.addView(this.f74622d, this.f74621c);
                            if (QLog.isColorLevel()) {
                                QLog.d("SmallScreenToast", 2, "startHandler addView end");
                            }
                        } catch (WindowManager.BadTokenException e16) {
                            this.f74623e = false;
                            if (QLog.isColorLevel()) {
                                QLog.d("SmallScreenToast", 2, "startHandler error : " + e16);
                            }
                            z16 = false;
                        } catch (IllegalStateException e17) {
                            this.f74619a.updateViewLayout(this.f74622d, this.f74621c);
                            if (QLog.isColorLevel()) {
                                QLog.d("SmallScreenToast", 2, "startHandler error : " + e17);
                            }
                        }
                    } catch (SecurityException e18) {
                        this.f74623e = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("SmallScreenToast", 2, "startHandler error : " + e18);
                        }
                        z16 = false;
                        if (((WindowManager.LayoutParams) this.f74622d.getLayoutParams()) != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return z16;
                    }
                } catch (Exception e19) {
                    this.f74623e = false;
                    AVCoreLog.printErrorLog("SmallScreenToast", "startHandler error : " + e19);
                    z16 = false;
                    if (((WindowManager.LayoutParams) this.f74622d.getLayoutParams()) != null) {
                        z16 = SmallScreenUtils.r(this.f74620b);
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return z16;
                }
            }
            if (((WindowManager.LayoutParams) this.f74622d.getLayoutParams()) != null && z16) {
                z16 = SmallScreenUtils.r(this.f74620b);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenToast", 2, "startHandler isVisible = " + this.f74623e);
                QLog.d("SmallScreenToast", 2, "startHandler result = " + z16);
            }
        }
        return z16;
    }

    public void e() {
        synchronized (this) {
            if (this.f74623e) {
                this.f74623e = false;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenToast", 2, "stopHandler removeView start");
                    }
                    this.f74619a.removeView(this.f74622d);
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenToast", 2, "stopHandler removeView end");
                    }
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenToast", 2, "stopHandler error : " + e16);
                    }
                }
            }
        }
    }

    public void f() {
        if (this.f74623e) {
            try {
                this.f74619a.updateViewLayout(this.f74622d, this.f74621c);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SmallScreenToast", 2, "layout error : " + e16);
                }
            }
        }
    }
}
