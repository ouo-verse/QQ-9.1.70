package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class MessageProgressTextView extends TextView {
    static IPatchRedirector $redirector_;
    public boolean C;
    int D;

    /* renamed from: d, reason: collision with root package name */
    public boolean f203046d;

    /* renamed from: e, reason: collision with root package name */
    RefreshProgressRunnable f203047e;

    /* renamed from: f, reason: collision with root package name */
    private BaseTransProcessor f203048f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f203049h;

    /* renamed from: i, reason: collision with root package name */
    int f203050i;

    /* renamed from: m, reason: collision with root package name */
    int f203051m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class RefreshProgressRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f203052d;

        /* renamed from: e, reason: collision with root package name */
        int f203053e;

        public RefreshProgressRunnable(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageProgressTextView.this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f203052d = i3;
                this.f203053e = i16;
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f203053e = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            MessageProgressTextView messageProgressTextView = MessageProgressTextView.this;
            messageProgressTextView.f203047e = null;
            if (!messageProgressTextView.f203046d) {
                int i3 = this.f203052d;
                int i16 = this.f203053e;
                int i17 = i3 + i16;
                this.f203052d = i17;
                messageProgressTextView.b(i17, i16);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface a {
    }

    public MessageProgressTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f203046d = false;
        this.f203049h = true;
        this.C = true;
        this.D = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3, int i16) {
        long j3;
        BaseTransProcessor baseTransProcessor = this.f203048f;
        if (baseTransProcessor == null) {
            return;
        }
        if (baseTransProcessor.getCurrentProgress() < 100 && i3 >= 100) {
            i3 = 100;
        } else if (i3 >= 100) {
            this.f203048f = null;
            return;
        }
        this.f203048f.setCurrentProgress(i3);
        int max = Math.max(this.f203048f.getRealProgress(), 0);
        if (this.f203048f.getRealProgress() < 0) {
            j3 = 1000;
        } else {
            j3 = 25;
        }
        if (this.f203048f.getCurrentProgress() <= max) {
            if (QLog.isColorLevel()) {
                QLog.d("ProgressTextView", 2, "currentProgress " + i3 + " receiveProgress " + max + "addProgress" + i16 + " processor.getKey() " + this.f203048f.getKey() + " processor " + this.f203048f);
            }
            setProgress(i3);
            RefreshProgressRunnable refreshProgressRunnable = this.f203047e;
            if (refreshProgressRunnable == null) {
                RefreshProgressRunnable refreshProgressRunnable2 = new RefreshProgressRunnable(i3, i16);
                this.f203047e = refreshProgressRunnable2;
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
            QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i3 + " receiveProgress " + max + "addProgress" + i16 + " processor.getKey() " + this.f203048f.getKey() + " processor " + this.f203048f);
        }
        if (max >= this.D) {
            setProgress(max);
        }
    }

    public void setDisplayInTextView(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.C = z16;
        this.f203050i = i3;
        this.f203051m = i16;
    }

    public void setProcessor(BaseTransProcessor baseTransProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseTransProcessor);
            return;
        }
        if (this.f203048f == baseTransProcessor) {
            return;
        }
        RefreshProgressRunnable refreshProgressRunnable = this.f203047e;
        if (refreshProgressRunnable != null) {
            removeCallbacks(refreshProgressRunnable);
            this.f203047e = null;
        }
        this.f203048f = baseTransProcessor;
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.D = i3;
        if (this.f203049h && this.C) {
            setText(i3 + "%");
        } else {
            setText("");
        }
        Drawable background = getBackground();
        if (background != null) {
            background.setLevel((100 - i3) * 100);
            if ((background instanceof com.tencent.mobileqq.activity.aio.item.a) && !this.C) {
                ((com.tencent.mobileqq.activity.aio.item.a) background).a(this.f203050i, this.f203051m);
            }
        }
    }

    public void setProgressListener(a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, aVar, Boolean.valueOf(z16));
        } else {
            this.f203049h = z16;
        }
    }

    public MessageProgressTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f203046d = false;
        this.f203049h = true;
        this.C = true;
        this.D = 0;
    }

    public MessageProgressTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f203046d = false;
        this.f203049h = true;
        this.C = true;
        this.D = 0;
    }
}
