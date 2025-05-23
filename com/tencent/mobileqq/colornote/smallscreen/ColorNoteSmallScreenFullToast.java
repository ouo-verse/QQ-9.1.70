package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSmallScreenFullToast extends RelativeLayout implements View.OnClickListener {
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f201556d;

    /* renamed from: e, reason: collision with root package name */
    private Context f201557e;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f201558f;

    /* renamed from: h, reason: collision with root package name */
    boolean f201559h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f201560i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout.LayoutParams f201561m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void f();

        void l();

        void n();
    }

    public ColorNoteSmallScreenFullToast(Context context, a aVar) {
        super(context);
        this.f201558f = new WindowManager.LayoutParams();
        this.f201559h = false;
        this.f201557e = context;
        this.C = aVar;
        this.f201556d = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = this.f201558f;
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 0;
        layoutParams.gravity = 51;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f201558f;
        layoutParams2.flags = 768;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams2.type = 2038;
        } else {
            layoutParams2.type = 2002;
        }
        ImageView imageView = new ImageView(context);
        this.f201560i = imageView;
        imageView.setContentDescription(context.getResources().getString(R.string.imd));
        this.f201560i.setBackgroundResource(R.drawable.hji);
        this.f201560i.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(Utils.n(24.0f, context.getResources()), Utils.n(24.0f, context.getResources()));
        this.f201561m = layoutParams3;
        addView(this.f201560i, layoutParams3);
        setOnClickListener(this);
        this.f201560i.setOnClickListener(this);
    }

    public void a(int i3, int i16) {
        RelativeLayout.LayoutParams layoutParams = this.f201561m;
        if (layoutParams != null) {
            layoutParams.leftMargin = i3 - Utils.n(12.0f, getResources());
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f201561m.topMargin = (i16 - Utils.n(5.5f, getResources())) - iArr[1];
            this.f201560i.requestLayout();
        }
        if (this.f201560i.getVisibility() == 8) {
            this.f201560i.setVisibility(0);
        }
        this.f201560i.setAlpha(0.0f);
        this.f201560i.animate().alpha(1.0f).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000a, B:10:0x0010, B:11:0x0019, B:13:0x0026, B:29:0x0032, B:20:0x004e, B:22:0x0056, B:25:0x0070, B:27:0x0078, B:16:0x0093, B:18:0x00a0, B:30:0x00b8, B:33:0x00c2, B:34:0x00c8, B:36:0x00ce, B:37:0x0100), top: B:2:0x0001, inners: #1, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        boolean z16;
        synchronized (this) {
            z16 = true;
            if (!this.f201559h) {
                this.f201559h = true;
                try {
                    try {
                        try {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler addView start");
                                }
                                this.f201556d.addView(this, this.f201558f);
                                if (QLog.isColorLevel()) {
                                    QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler addView end");
                                }
                            } catch (Exception e16) {
                                this.f201559h = false;
                                QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler error : " + e16);
                                z16 = false;
                                if (((WindowManager.LayoutParams) getLayoutParams()) != null) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                return z16;
                            }
                        } catch (WindowManager.BadTokenException e17) {
                            this.f201559h = false;
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler error : " + e17);
                            }
                            z16 = false;
                            if (((WindowManager.LayoutParams) getLayoutParams()) != null) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            return z16;
                        }
                    } catch (SecurityException e18) {
                        this.f201559h = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler error : " + e18);
                        }
                        z16 = false;
                        if (((WindowManager.LayoutParams) getLayoutParams()) != null) {
                            z16 = b.d(this.f201557e);
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return z16;
                    }
                } catch (IllegalStateException e19) {
                    this.f201556d.updateViewLayout(this, this.f201558f);
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler error : " + e19);
                    }
                }
            }
            if (((WindowManager.LayoutParams) getLayoutParams()) != null && z16) {
                z16 = b.d(this.f201557e);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler mIsVisibe = " + this.f201559h);
                QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler result = " + z16);
            }
        }
        return z16;
    }

    public void c() {
        synchronized (this) {
            if (this.f201559h) {
                this.f201559h = false;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView start");
                    }
                    RelativeLayout.LayoutParams layoutParams = this.f201561m;
                    if (layoutParams != null) {
                        layoutParams.leftMargin = 0;
                        layoutParams.topMargin = 0;
                        this.f201560i.requestLayout();
                    }
                    this.f201560i.setVisibility(8);
                    this.f201556d.removeView(this);
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView end");
                    }
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler error : " + e16);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            a aVar = this.C;
            if (aVar != null) {
                aVar.l();
            }
            c();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        c();
        if (view == this) {
            a aVar2 = this.C;
            if (aVar2 != null) {
                aVar2.n();
            }
        } else if (view == this.f201560i && (aVar = this.C) != null) {
            aVar.f();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
