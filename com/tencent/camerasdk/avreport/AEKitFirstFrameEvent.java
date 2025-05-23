package com.tencent.camerasdk.avreport;

import android.os.AsyncTask;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AEKitFirstFrameEvent {
    static IPatchRedirector $redirector_;
    private int mCameraFirstDataAavailable;
    private int mFirstFrameRenderTime;
    private String mLaunchType;

    public AEKitFirstFrameEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFirstFrameRenderTime = 0;
            this.mCameraFirstDataAavailable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.mFirstFrameRenderTime = 0;
        this.mCameraFirstDataAavailable = 0;
        this.mLaunchType = null;
    }

    public AEKitFirstFrameEvent addCameraFirstFrameDataTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AEKitFirstFrameEvent) iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
        this.mCameraFirstDataAavailable = (int) j3;
        return this;
    }

    public AEKitFirstFrameEvent addFirstRenderCompletedTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AEKitFirstFrameEvent) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
        this.mFirstFrameRenderTime = (int) j3;
        return this;
    }

    public AEKitFirstFrameEvent addLanchCount(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AEKitFirstFrameEvent) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 > 1) {
            str = "hot";
        } else {
            str = TGSplashFileUtil.PRELOAD_CACHE_DIR_COLD;
        }
        this.mLaunchType = str;
        return this;
    }

    public void report() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            AsyncTask.execute(new Runnable() { // from class: com.tencent.camerasdk.avreport.AEKitFirstFrameEvent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AEKitFirstFrameEvent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AEKitBean aEKitBean = new AEKitBean(AEKitReportEvent.PREVIEW_FIRST_FRAME.value);
                    aEKitBean.ext_int1 = Integer.valueOf(AEKitFirstFrameEvent.this.mFirstFrameRenderTime);
                    aEKitBean.ext_int2 = Integer.valueOf(AEKitFirstFrameEvent.this.mCameraFirstDataAavailable);
                    aEKitBean.ext_str1 = AEKitFirstFrameEvent.this.mLaunchType;
                    AEKitFirstFrameEvent.this.resetData();
                    AVReportCenter.getInstance().commit(aEKitBean, Boolean.TRUE);
                }
            });
        }
    }
}
