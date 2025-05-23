package com.tencent.mobileqq.qqlive.api.impl.lottery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveLotteryServiceImpl implements IQQLiveLotteryService {
    static IPatchRedirector $redirector_ = null;
    private static final String QQ_LIVE_GET_LOTTERY_METHOD = "GetLotteryPendant";
    private static final String QQ_LIVE_LOTTERY_CMD = "trpc.qlive.lottery_svr.Lottery";
    private static final String TAG = "IQQLiveLotteryModule";
    private CopyOnWriteArraySet<IQQLiveHideLotteryCallback> hideLotteryCallbacks;

    public QQLiveLotteryServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.hideLotteryCallbacks = new CopyOnWriteArraySet<>();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.e(TAG, 4, "IQQLiveLotteryModule destroy");
        CopyOnWriteArraySet<IQQLiveHideLotteryCallback> copyOnWriteArraySet = this.hideLotteryCallbacks;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveSDK);
        } else {
            QLog.d(TAG, 4, "IQQLiveLotteryModule init");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService
    public void notifyHideLotteryResult(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3);
            return;
        }
        CopyOnWriteArraySet<IQQLiveHideLotteryCallback> copyOnWriteArraySet = this.hideLotteryCallbacks;
        if (copyOnWriteArraySet != null) {
            Iterator<IQQLiveHideLotteryCallback> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onHide(str, str2, str3);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService
    public void registerHideLottery(IQQLiveHideLotteryCallback iQQLiveHideLotteryCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveHideLotteryCallback);
        } else if (iQQLiveHideLotteryCallback != null) {
            this.hideLotteryCallbacks.add(iQQLiveHideLotteryCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d(TAG, 4, "IQQLiveLotteryModule reset");
        CopyOnWriteArraySet<IQQLiveHideLotteryCallback> copyOnWriteArraySet = this.hideLotteryCallbacks;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService
    public void unRegisterHideLottery(IQQLiveHideLotteryCallback iQQLiveHideLotteryCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveHideLotteryCallback);
        } else if (iQQLiveHideLotteryCallback != null) {
            this.hideLotteryCallbacks.remove(iQQLiveHideLotteryCallback);
        }
    }
}
