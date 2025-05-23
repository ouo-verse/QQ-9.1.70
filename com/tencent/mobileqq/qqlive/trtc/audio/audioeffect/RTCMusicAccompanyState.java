package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RTCMusicAccompanyState {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final SparseArray<String> f273220c;

    /* renamed from: a, reason: collision with root package name */
    private int f273221a;

    /* renamed from: b, reason: collision with root package name */
    private int f273222b;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface STATE {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        f273220c = sparseArray;
        sparseArray.put(1, HippyPagerPageChangeListener.IDLE);
        sparseArray.put(5, "starting");
        sparseArray.put(6, "started");
        sparseArray.put(7, "paused");
        sparseArray.put(9, "complete");
        sparseArray.put(10, "stopping");
        sparseArray.put(11, "stopped");
        sparseArray.put(12, "error");
    }

    public RTCMusicAccompanyState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273221a = 1;
            this.f273222b = 1;
        }
    }

    private void b(int i3, int i16) {
        SparseArray<String> sparseArray = f273220c;
        QLog.i("RTCMusicAccompanyState", 1, "StateChange: state[ cur : " + sparseArray.get(this.f273221a) + "(changed) , pre : " + sparseArray.get(this.f273222b) + "(changed from " + sparseArray.get(i16) + ")]");
    }

    public synchronized void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        int i16 = this.f273221a;
        if (i16 != i3) {
            this.f273222b = i16;
            this.f273221a = i3;
            b(i3, i16);
        }
    }

    public synchronized int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f273221a;
    }

    @NonNull
    public synchronized String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        SparseArray<String> sparseArray = f273220c;
        return "state[cur: " + sparseArray.get(this.f273221a) + " , pre: " + sparseArray.get(this.f273222b) + "]";
    }
}
