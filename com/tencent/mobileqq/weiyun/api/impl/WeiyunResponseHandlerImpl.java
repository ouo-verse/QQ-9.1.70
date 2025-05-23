package com.tencent.mobileqq.weiyun.api.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunGrayTipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeiyunResponseHandlerImpl implements IWeiyunResponseHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ResponseHandler";
    private static final int TIMEOUT = 60000;
    private static a mHandler;
    private static volatile int sErrorCode;
    private static volatile String sFriendUin;
    private static volatile int sIsTroop;
    private static volatile String sSenderUin;
    private static volatile int sWeiyunRequestCounter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends Handler {
        static IPatchRedirector $redirector_;

        public a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                int unused = WeiyunResponseHandlerImpl.sWeiyunRequestCounter = 0;
                return;
            }
            if (i3 == 1) {
                WeiyunResponseHandlerImpl weiyunResponseHandlerImpl = (WeiyunResponseHandlerImpl) QRoute.api(IWeiyunResponseHandler.class);
                if (weiyunResponseHandlerImpl.isAllRequestFinished() && !TextUtils.isEmpty(WeiyunResponseHandlerImpl.sFriendUin) && !TextUtils.isEmpty(WeiyunResponseHandlerImpl.sSenderUin)) {
                    String str = WeiyunResponseHandlerImpl.sFriendUin;
                    String str2 = WeiyunResponseHandlerImpl.sSenderUin;
                    int i16 = WeiyunResponseHandlerImpl.sIsTroop;
                    int i17 = WeiyunResponseHandlerImpl.sErrorCode;
                    String errorMsg = weiyunResponseHandlerImpl.getErrorMsg(MobileQQ.sMobileQQ);
                    Process.setThreadPriority(10);
                    ((IWeiyunGrayTipHelper) QRoute.api(IWeiyunGrayTipHelper.class)).insertAIOGrayTips((AppInterface) message.obj, str, str2, i16, i17, errorMsg);
                    weiyunResponseHandlerImpl.reset();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19563);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            mHandler = new a(Looper.getMainLooper());
        }
    }

    public WeiyunResponseHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void sendShowGrayMsg(AppInterface appInterface) {
        Message obtainMessage = mHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = appInterface;
        mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public synchronized boolean endSave2Weiyun(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (needShowGrayTips(i3) && !isSpaceOverErrorCode(sErrorCode)) {
            sErrorCode = i3;
        }
        if (sWeiyunRequestCounter == 0) {
            mHandler.removeMessages(0);
            return true;
        }
        sWeiyunRequestCounter--;
        QLog.d(TAG, 2, "end count=" + sWeiyunRequestCounter);
        if (sWeiyunRequestCounter > 0) {
            return false;
        }
        mHandler.removeMessages(0);
        sWeiyunRequestCounter = 0;
        return true;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public synchronized String getErrorMsg(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        if (sErrorCode == 1127) {
            return context.getString(R.string.ckl);
        }
        if (sErrorCode == 22000) {
            return context.getString(R.string.ckl);
        }
        if (sErrorCode != 1053 && sErrorCode != -20001) {
            if (sErrorCode == 22081) {
                return context.getString(R.string.if5);
            }
            if (sErrorCode == 22121) {
                return context.getString(R.string.f173185hu4);
            }
            return null;
        }
        return context.getString(R.string.ckm);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public synchronized boolean isAllRequestFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (sWeiyunRequestCounter == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public boolean isFlowOverErrorCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        if (i3 != 1127 && i3 != 22000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public boolean isSpaceOverErrorCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (i3 != 1053 && i3 != 22081 && i3 != 22121 && sErrorCode != -20001) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public boolean needShowGrayTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? needShowGrayTips(sErrorCode) : ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
    }

    void reset() {
        sFriendUin = null;
        sSenderUin = null;
        sIsTroop = 0;
        sErrorCode = 0;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public synchronized void setRequestData(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
            return;
        }
        sFriendUin = str;
        sSenderUin = str2;
        sIsTroop = i3;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public synchronized void showGrayTips(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface);
            return;
        }
        QLog.d(TAG, 2, "sFriendUin =" + sFriendUin + ";  sSenderUin=" + sSenderUin);
        if (!TextUtils.isEmpty(sFriendUin) && !TextUtils.isEmpty(sSenderUin)) {
            sendShowGrayMsg(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public synchronized void startSave2Weiyun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        sWeiyunRequestCounter++;
        QLog.d(TAG, 2, "start count=" + sWeiyunRequestCounter);
        mHandler.removeMessages(0);
        mHandler.sendEmptyMessageDelayed(0, 60000L);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
    public boolean needShowGrayTips(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        if (TextUtils.isEmpty(sFriendUin) || TextUtils.isEmpty(sSenderUin)) {
            return false;
        }
        return isFlowOverErrorCode(i3) || isSpaceOverErrorCode(i3);
    }
}
