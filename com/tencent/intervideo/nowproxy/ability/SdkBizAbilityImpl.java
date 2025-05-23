package com.tencent.intervideo.nowproxy.ability;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.QQKandianInterface;
import com.tencent.intervideo.nowproxy.common.NowThreadPool;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.IHostCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SdkBizAbilityImpl {
    static IPatchRedirector $redirector_;
    public static SdkBizAbilityImpl sInstance;
    protected Bundle customiseByHost;
    Map<Long, ActionCallback> mActionCallbacks;
    AtomicLong mActionSeq;
    CustomizedRecord mCustomRecord;
    CustomizedShareForQQ mCustomizedShareToQQ;
    IHostCallback mHostCallBack;
    LoginObserver mLoginObserver;
    QQKandianInterface mQQKandianInterface;
    NowThreadPool.ThreadPoolProvider mThreadPoolProvider;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10373);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            sInstance = new SdkBizAbilityImpl();
        }
    }

    public SdkBizAbilityImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.customiseByHost = new Bundle();
        this.mActionCallbacks = new HashMap();
        this.mActionSeq = new AtomicLong(1000L);
    }

    public static SdkBizAbilityImpl getInstance() {
        return sInstance;
    }

    public ExecutorService getFixedThreadPool(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ExecutorService) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        NowThreadPool.ThreadPoolProvider threadPoolProvider = this.mThreadPoolProvider;
        if (threadPoolProvider != null) {
            return threadPoolProvider.getFixedThreadPool(i3);
        }
        return null;
    }

    public LoginObserver getLoginObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LoginObserver) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mLoginObserver;
    }

    public void getRecordInfo(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle, (Object) commonCallback);
            return;
        }
        CustomizedRecord customizedRecord = this.mCustomRecord;
        if (customizedRecord != null) {
            customizedRecord.getRecordInfo(bundle, commonCallback);
        }
    }

    public void jumpToKandianBiu(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
        } else {
            this.mQQKandianInterface.jumpToKandianBiu(bundle);
        }
    }

    public void notifyLoadingCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IHostCallback iHostCallback = this.mHostCallBack;
        if (iHostCallback != null) {
            iHostCallback.notifyLoadingActivityBackPress();
        }
    }

    public void onDoActionResult(long j3, String str) {
        ActionCallback remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), str);
        } else if (j3 != 0 && (remove = this.mActionCallbacks.remove(Long.valueOf(j3))) != null) {
            remove.onResult(str);
        }
    }

    public void onLoginExpired(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mLoginObserver.onLoginDataInvalid(i3);
        }
    }

    public void onNoLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mLoginObserver.onNoLogin();
        }
    }

    public long putActionCallback(ActionCallback actionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, (Object) actionCallback)).longValue();
        }
        if (actionCallback != null) {
            long incrementAndGet = this.mActionSeq.incrementAndGet();
            this.mActionCallbacks.put(Long.valueOf(incrementAndGet), actionCallback);
            return incrementAndGet;
        }
        return 0L;
    }

    public void setCustomRecord(CustomizedRecord customizedRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) customizedRecord);
        } else {
            this.mCustomRecord = customizedRecord;
        }
    }

    public void setCustomShareForQQ(CustomizedShareForQQ customizedShareForQQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) customizedShareForQQ);
        } else {
            this.mCustomizedShareToQQ = customizedShareForQQ;
        }
    }

    public void setHostCallBack(IHostCallback iHostCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iHostCallback);
        } else {
            this.mHostCallBack = iHostCallback;
        }
    }

    public void setLoginObserver(LoginObserver loginObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) loginObserver);
        } else {
            this.mLoginObserver = loginObserver;
        }
    }

    public void setQQKandianInterface(QQKandianInterface qQKandianInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQKandianInterface);
        } else {
            this.mQQKandianInterface = qQKandianInterface;
        }
    }

    public void setThreadPoolProvider(NowThreadPool.ThreadPoolProvider threadPoolProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) threadPoolProvider);
        } else {
            this.mThreadPoolProvider = threadPoolProvider;
        }
    }

    public void shareToQQ(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
        } else {
            this.mCustomizedShareToQQ.shareToQQ(bundle);
        }
    }
}
