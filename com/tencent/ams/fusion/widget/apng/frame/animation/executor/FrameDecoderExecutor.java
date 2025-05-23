package com.tencent.ams.fusion.widget.apng.frame.animation.executor;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameDecoderExecutor {
    static IPatchRedirector $redirector_;
    private static int sPoolNumber;
    private AtomicInteger counter;
    private ArrayList<HandlerThread> mHandlerThreadGroup;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class Inner {
        static IPatchRedirector $redirector_;
        static final FrameDecoderExecutor sInstance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51974);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                sInstance = new FrameDecoderExecutor(null);
            }
        }

        Inner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sPoolNumber = 4;
        }
    }

    /* synthetic */ FrameDecoderExecutor(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    public static FrameDecoderExecutor getInstance() {
        return Inner.sInstance;
    }

    public int generateTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.counter.getAndIncrement();
    }

    public Looper getLooper(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Looper) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        int i16 = sPoolNumber;
        if (i16 <= 0) {
            return Looper.getMainLooper();
        }
        int i17 = i3 % i16;
        if (i17 >= this.mHandlerThreadGroup.size()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AMS-FrameDecoderExecutor" + i17);
            baseHandlerThread.start();
            this.mHandlerThreadGroup.add(baseHandlerThread);
            Looper looper = baseHandlerThread.getLooper();
            if (looper != null) {
                return looper;
            }
            return Looper.getMainLooper();
        }
        if (this.mHandlerThreadGroup.get(i17) != null) {
            Looper looper2 = this.mHandlerThreadGroup.get(i17).getLooper();
            if (looper2 != null) {
                return looper2;
            }
            return Looper.getMainLooper();
        }
        return Looper.getMainLooper();
    }

    public void setPoolSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            sPoolNumber = i3;
        }
    }

    FrameDecoderExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHandlerThreadGroup = new ArrayList<>();
            this.counter = new AtomicInteger(0);
        }
    }
}
