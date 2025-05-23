package com.tencent.mobileqq.qqlive.api.impl.luckybag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.luckybag.IQQLiveLuckyBagService;
import com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import ni2.b;
import ni2.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveLuckyBagServiceImpl implements IQQLiveLuckyBagService {
    static IPatchRedirector $redirector_ = null;
    private static final int LUCKY_BAG_MESSAGE_CMD = 285;
    private static final int LUCKY_BAG_UPDATE_EXT_DATA_CMD = 100;
    private static final String TAG;
    private Set<ReceiveLuckyBagMessageListener> mListeners;
    private c mPushReceiver;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            TAG = QQLiveLuckyBagServiceImpl.class.getSimpleName();
        }
    }

    public QQLiveLuckyBagServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mListeners = new HashSet();
        }
    }

    private void initMessageListener(IQQLiveSDK iQQLiveSDK) {
        this.mPushReceiver = ((b) iQQLiveSDK.getExtModule("roomPush")).b().b(285, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.luckybag.a
            @Override // ni2.a
            public final void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                QQLiveLuckyBagServiceImpl.this.lambda$initMessageListener$0(i3, bArr, liveMsgExtInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageListener$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            Iterator<ReceiveLuckyBagMessageListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onError(-1, "data is null");
            }
            return;
        }
        try {
            if (gp4.a.c(bArr).f403047a == 100) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "get message push");
                }
                Iterator<ReceiveLuckyBagMessageListener> it5 = this.mListeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onLuckyBagMessageReceive();
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parse data error, e = " + th5.getMessage());
            Iterator<ReceiveLuckyBagMessageListener> it6 = this.mListeners.iterator();
            while (it6.hasNext()) {
                it6.next().onError(-1, "parse data error");
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.luckybag.IQQLiveLuckyBagService
    public void addReceiveGiftMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) receiveLuckyBagMessageListener);
        } else {
            this.mListeners.add(receiveLuckyBagMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.luckybag.IQQLiveLuckyBagService
    public void delReceiveGiftMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) receiveLuckyBagMessageListener);
        } else {
            this.mListeners.remove(receiveLuckyBagMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        c cVar = this.mPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.mListeners.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            initMessageListener(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c cVar = this.mPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.mListeners.clear();
    }
}
