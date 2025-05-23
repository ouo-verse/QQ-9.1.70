package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f201679a;

    /* renamed from: b, reason: collision with root package name */
    private Context f201680b;

    /* renamed from: d, reason: collision with root package name */
    private View f201682d;

    /* renamed from: c, reason: collision with root package name */
    private WindowManager.LayoutParams f201681c = new WindowManager.LayoutParams();

    /* renamed from: e, reason: collision with root package name */
    private boolean f201683e = false;

    public g(Context context, View view) {
        this.f201682d = null;
        this.f201680b = context;
        this.f201679a = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = this.f201681c;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 0;
        layoutParams.type = 2010;
        layoutParams.gravity = 51;
        layoutParams.setTitle("Toast");
        this.f201682d = view;
        a();
    }

    private void a() {
        try {
            this.f201681c.getClass().getField("privateFlags").set(this.f201681c, Integer.valueOf(((Integer) this.f201681c.getClass().getField("privateFlags").get(this.f201681c)).intValue() | 64));
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.f201683e;
    }

    public WindowManager.LayoutParams c() {
        return this.f201681c;
    }

    public WindowManager d() {
        return this.f201679a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4 A[Catch: all -> 0x0108, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000a, B:10:0x0010, B:11:0x0019, B:13:0x0028, B:16:0x0034, B:19:0x0050, B:21:0x0058, B:23:0x0072, B:25:0x007a, B:27:0x0095, B:29:0x00a4, B:30:0x00bc, B:33:0x00c8, B:34:0x00ce, B:36:0x00d4, B:37:0x0106), top: B:2:0x0001, inners: #3, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        boolean z16;
        synchronized (this) {
            z16 = true;
            if (!this.f201683e) {
                this.f201683e = true;
                try {
                    try {
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorNoteSmallScreenToast", 2, "startHandler addView start");
                            }
                            this.f201679a.addView(this.f201682d, this.f201681c);
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorNoteSmallScreenToast", 2, "startHandler addView end");
                            }
                        } catch (WindowManager.BadTokenException e16) {
                            this.f201683e = false;
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorNoteSmallScreenToast", 2, "startHandler error : " + e16);
                            }
                            z16 = false;
                        } catch (IllegalStateException e17) {
                            this.f201679a.updateViewLayout(this.f201682d, this.f201681c);
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorNoteSmallScreenToast", 2, "startHandler error : " + e17);
                            }
                        }
                    } catch (SecurityException e18) {
                        this.f201683e = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("ColorNoteSmallScreenToast", 2, "startHandler error : " + e18);
                        }
                        z16 = false;
                        if (((WindowManager.LayoutParams) this.f201682d.getLayoutParams()) != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return z16;
                    }
                } catch (Exception e19) {
                    this.f201683e = false;
                    QLog.d("ColorNoteSmallScreenToast", 2, "startHandler error : " + e19);
                    z16 = false;
                    if (((WindowManager.LayoutParams) this.f201682d.getLayoutParams()) != null) {
                        z16 = b.d(this.f201680b);
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return z16;
                }
            }
            if (((WindowManager.LayoutParams) this.f201682d.getLayoutParams()) != null && z16) {
                z16 = b.d(this.f201680b);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenToast", 2, "startHandler mIsVisibe = " + this.f201683e);
                QLog.d("ColorNoteSmallScreenToast", 2, "startHandler result = " + z16);
            }
        }
        return z16;
    }

    public void f() {
        synchronized (this) {
            if (this.f201683e) {
                this.f201683e = false;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView start");
                    }
                    this.f201679a.removeView(this.f201682d);
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView end");
                    }
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler error : " + e16);
                    }
                }
            }
        }
    }

    public void g() {
        if (this.f201683e) {
            try {
                this.f201679a.updateViewLayout(this.f201682d, this.f201681c);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteSmallScreenToast", 2, "layout error : " + e16);
                }
            }
        }
    }
}
