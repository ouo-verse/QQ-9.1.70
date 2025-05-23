package com.tencent.mobileqq.banner.processor;

import android.os.Message;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class BaseBannerProcessor implements e {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "Q.recent.banner";
    public static final String TVALUE_CLICK_COMMON = "0X8009EE2";
    public static final String TVALUE_CLICK_MUSIC = "0X8009EE4";
    public static final String TVALUE_CLICK_READ = "0X8009EE3";
    public static final String TVALUE_CLICK_VIDEO = "0X8009EE5";
    public static final String TVALUE_SHOW_COMMON = "0X8009EDE";
    public static final String TVALUE_SHOW_MUSIC = "0X8009EE0";
    public static final String TVALUE_SHOW_READ = "0X8009EDF";
    public static final String TVALUE_SHOW_VIDEO = "0X8009EE1";
    protected MqqHandler handler;
    private a host;

    public BaseBannerProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public QBaseActivity getBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.host.getActivity();
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public void onBeforeAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public final void onCreate(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.host = aVar;
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        MqqHandler mqqHandler = this.handler;
        if (mqqHandler != null) {
            if (z16) {
                mqqHandler.removeMessages(message.what);
            }
            this.handler.sendMessageDelayed(message, j3);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar, (Object) message);
        }
    }
}
