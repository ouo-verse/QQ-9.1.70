package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwNetworkCenter {
    static IPatchRedirector $redirector_ = null;
    public static final String Tag = "NetworkCenter";
    public static HwNetworkCenter sNC;
    private Runnable checkRun;
    private String mApnType;
    private Context mContext;
    private Handler mHandler;
    private AtomicInteger mNetworkType;
    private HandlerThread mUpdateThread;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16665);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sNC = null;
        }
    }

    protected HwNetworkCenter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mNetworkType = new AtomicInteger(0);
        this.mApnType = "";
        this.mUpdateThread = null;
        this.checkRun = new Runnable() { // from class: com.tencent.mobileqq.highway.utils.HwNetworkCenter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HwNetworkCenter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HwNetworkCenter hwNetworkCenter = HwNetworkCenter.this;
                hwNetworkCenter.onNetChange(hwNetworkCenter.mContext);
                HwNetworkCenter.this.mHandler.postDelayed(this, 120000L);
            }
        };
        this.mContext = context;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Highway-BDH-HwNetworkCenter");
        this.mUpdateThread = baseHandlerThread;
        baseHandlerThread.start();
        Handler handler = new Handler(this.mUpdateThread.getLooper());
        this.mHandler = handler;
        handler.postDelayed(this.checkRun, 60000L);
    }

    public static HwNetworkCenter getInstance(Context context) {
        if (sNC == null) {
            synchronized (HwNetworkCenter.class) {
                if (sNC == null) {
                    sNC = new HwNetworkCenter(context);
                }
            }
        }
        return sNC;
    }

    public int getNetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mNetworkType.get();
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mContext = null;
        }
    }

    public synchronized void onNetChange(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            updateNetInfo(context);
        }
    }

    public synchronized void updateNetInfo(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            if (context == null) {
                return;
            }
            try {
                this.mNetworkType.set(HwNetworkUtil.getSystemNetwork(context));
            } catch (Exception e16) {
                BdhLogUtil.LogException("N", "UpdateNetInfo Error.", e16);
            }
        }
    }
}
