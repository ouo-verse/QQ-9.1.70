package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class PicProgressView extends MessageProgressView {
    static IPatchRedirector $redirector_;
    public boolean L0;
    RefreshProgressRunnable M0;
    private BaseTransProcessor N0;
    public String O0;
    private boolean P0;
    int Q0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class RefreshProgressRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f203054d;

        /* renamed from: e, reason: collision with root package name */
        int f203055e;

        public RefreshProgressRunnable(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PicProgressView.this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f203054d = i3;
                this.f203055e = i16;
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f203055e = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            PicProgressView picProgressView = PicProgressView.this;
            picProgressView.M0 = null;
            if (!picProgressView.L0) {
                int i3 = this.f203054d;
                int i16 = this.f203055e;
                int i17 = i3 + i16;
                this.f203054d = i17;
                picProgressView.t(i17, i16);
            }
        }
    }

    public PicProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.L0 = false;
        this.P0 = false;
        this.Q0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3, int i16) {
        long j3;
        BaseTransProcessor baseTransProcessor = this.N0;
        if (baseTransProcessor == null) {
            return;
        }
        if (baseTransProcessor.getCurrentProgress() < 100 && i3 >= 100) {
            i3 = 100;
        } else if (i3 >= 100) {
            this.N0 = null;
            return;
        }
        this.N0.setCurrentProgress(i3);
        int max = Math.max(this.N0.getRealProgress(), 0);
        if (this.N0.getRealProgress() < 0) {
            j3 = 1000;
        } else {
            j3 = 25;
        }
        if (this.N0.getCurrentProgress() <= max) {
            if (QLog.isColorLevel()) {
                QLog.d("PicProgressView", 2, "currentProgress " + i3 + " receiveProgress " + max + "addProgress" + i16 + " processor.getKey() " + this.N0.getKey() + " processor " + this.N0);
            }
            setProgress(i3);
            RefreshProgressRunnable refreshProgressRunnable = this.M0;
            if (refreshProgressRunnable == null) {
                RefreshProgressRunnable refreshProgressRunnable2 = new RefreshProgressRunnable(i3, i16);
                this.M0 = refreshProgressRunnable2;
                postDelayed(refreshProgressRunnable2, j3);
                return;
            } else {
                if (i16 != 1) {
                    refreshProgressRunnable.a(i16);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicProgressView", 2, "doUpdateCurrentProgress ,currentProgress:" + i3 + " receiveProgress " + max + "addProgress" + i16 + " processor.getKey() " + this.N0.getKey() + " processor " + this.N0);
        }
        if (max >= this.Q0) {
            setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.MessageProgressView
    public void h(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        BaseTransProcessor baseTransProcessor = this.N0;
        if (baseTransProcessor != null && (baseTransProcessor instanceof IPicTransFile.b) && baseTransProcessor.getFileStatus() < 1001) {
            return;
        }
        super.h(canvas);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            removeCallbacks(this.M0);
            super.onDetachedFromWindow();
        }
    }

    public void setProcessor(BaseTransProcessor baseTransProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseTransProcessor);
            return;
        }
        if (this.N0 == baseTransProcessor) {
            return;
        }
        RefreshProgressRunnable refreshProgressRunnable = this.M0;
        if (refreshProgressRunnable != null) {
            removeCallbacks(refreshProgressRunnable);
            this.M0 = null;
        }
        this.N0 = baseTransProcessor;
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (i3 == 100) {
            setProcessor(null);
        }
        this.Q0 = i3;
        setDrawStatus(1);
        setAnimProgress(i3, this.O0);
    }

    public void setProgressKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.O0 = str;
            a(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r4 == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setShowProgress(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (!this.P0) {
            z17 = true;
        }
        z17 = false;
        this.P0 = z16;
        if (z17) {
            invalidate();
        }
    }

    public PicProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.L0 = false;
        this.P0 = false;
        this.Q0 = 0;
    }

    public PicProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.L0 = false;
        this.P0 = false;
        this.Q0 = 0;
    }
}
