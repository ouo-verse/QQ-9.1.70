package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.ThrowablesUtils;

/* loaded from: classes5.dex */
public class SlideProgressNotifier extends ap implements c, DialogInterface.OnKeyListener {
    RefreshProgressThread C;
    Handler D;

    /* renamed from: m, reason: collision with root package name */
    Activity f94293m;

    /* loaded from: classes5.dex */
    public static class RefreshProgressThread extends BaseThread {
        int C;
        int D;
        int E;
        int F;
        boolean G = false;
        c H;

        public RefreshProgressThread(int i3, int i16, int i17, c cVar) {
            this.C = i3;
            this.D = i16;
            int i18 = i16 - i17;
            if (i18 > 0) {
                this.E = i3 / i18;
            } else {
                this.E = 100;
            }
            this.F = i17;
            this.H = cVar;
        }

        public void cancel() {
            if (QLog.isColorLevel()) {
                QLog.d("QQProgressNotifier", 2, "cancel progress update thread, stack trace : " + ThrowablesUtils.getStackTraceAsString(new RuntimeException()));
            }
            this.G = true;
        }

        public boolean o() {
            return this.G;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.G) {
                int i3 = this.F;
                int i16 = this.D;
                if (i3 < i16) {
                    c cVar = this.H;
                    if (cVar != null) {
                        cVar.a(i3);
                        this.F++;
                        try {
                            LockMethodProxy.sleep(this.E);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                } else {
                    this.F = i16;
                    c cVar2 = this.H;
                    if (cVar2 != null) {
                        cVar2.a(i16);
                    }
                    this.G = true;
                }
            }
        }
    }

    public SlideProgressNotifier(Activity activity, int i3) {
        super(activity, i3);
        this.f94293m = activity;
        this.D = new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.c
    public void a(final int i3) {
        Handler handler = this.D;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQProgressNotifier", 2, "SlideShowProgressUpdate : " + i3 + "%");
                    }
                    ((ap) SlideProgressNotifier.this).f316674d.setMessage(SlideProgressNotifier.this.f94293m.getString(R.string.fv5) + " " + i3 + "%");
                }
            });
        }
    }

    public void h(int i3, int i16, int i17) {
        RefreshProgressThread refreshProgressThread = this.C;
        if (refreshProgressThread != null && !refreshProgressThread.o()) {
            this.C.cancel();
            this.C = null;
        }
        a(i17);
        RefreshProgressThread refreshProgressThread2 = new RefreshProgressThread(i3, i16, i17, this);
        this.C = refreshProgressThread2;
        refreshProgressThread2.start();
        if (QLog.isColorLevel()) {
            QLog.d("SlideProgressNotifier", 2, "beginMerge totalDuration=" + i3 + " totalProgress = " + i16 + " startProgress=" + i17);
        }
    }

    public void i(int i3, int i16, int i17, int i18) {
        super.e(i3, this.f94293m.getString(R.string.fv5) + "0%", 0);
        QQProgressDialog qQProgressDialog = this.f316674d;
        if (qQProgressDialog != null) {
            qQProgressDialog.setOnKeyListener(this);
        }
        RefreshProgressThread refreshProgressThread = this.C;
        if (refreshProgressThread != null && !refreshProgressThread.o()) {
            this.C.cancel();
            this.C = null;
        }
        RefreshProgressThread refreshProgressThread2 = new RefreshProgressThread(i16, i17, i18, this);
        this.C = refreshProgressThread2;
        refreshProgressThread2.start();
        if (QLog.isColorLevel()) {
            QLog.d("SlideProgressNotifier", 2, " beginTask totalDuration=" + i16 + " totalProgress = " + i17 + " startProgress=" + i18);
        }
    }

    public void j() {
        RefreshProgressThread refreshProgressThread = this.C;
        if (refreshProgressThread != null) {
            refreshProgressThread.cancel();
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            SlideShowPhotoListManager.n().G();
            return false;
        }
        return false;
    }
}
