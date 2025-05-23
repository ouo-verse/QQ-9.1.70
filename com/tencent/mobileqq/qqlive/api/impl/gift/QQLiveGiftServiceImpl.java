package com.tencent.mobileqq.qqlive.api.impl.gift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import ni2.b;
import ni2.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveGiftServiceImpl implements IQQLiveGiftService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Gift|IQQLiveGiftService";
    private c mGiftPushReceiver;
    private Set<ReceiveGiftMessageListener> mReceiveGiftMessageListeners;
    private IQQLiveSDK sdkImpl;

    public QQLiveGiftServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mReceiveGiftMessageListeners = new HashSet();
        }
    }

    private void initGiftMessageListener(final IQQLiveSDK iQQLiveSDK) {
        b bVar = (b) iQQLiveSDK.getExtModule("roomPush");
        for (final int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.mGiftPushReceiver = bVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.gift.a
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveGiftServiceImpl.this.lambda$initGiftMessageListener$0(i3, iQQLiveSDK, i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGiftMessageListener$0(int i3, IQQLiveSDK iQQLiveSDK, int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        AegisLogger.i(TAG, "initGiftMessageListener", "gift message push cmd:" + i16 + " size:" + this.mReceiveGiftMessageListeners.size());
        if (bArr == null) {
            Iterator<ReceiveGiftMessageListener> it = this.mReceiveGiftMessageListeners.iterator();
            while (it.hasNext()) {
                it.next().onError(-1, "gift data is null");
            }
            return;
        }
        try {
            IQQLivePushCmdHelper iQQLivePushCmdHelper = (IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class);
            GiftMessage covertPushDataToGiftMessage = iQQLivePushCmdHelper.covertPushDataToGiftMessage(i3, iQQLivePushCmdHelper.getGiftPushSubCmd(iQQLiveSDK.getAppId()), bArr);
            if (covertPushDataToGiftMessage == null) {
                return;
            }
            Iterator<ReceiveGiftMessageListener> it5 = this.mReceiveGiftMessageListeners.iterator();
            while (it5.hasNext()) {
                it5.next().onGiftMessageReceive(covertPushDataToGiftMessage);
            }
        } catch (Throwable th5) {
            Iterator<ReceiveGiftMessageListener> it6 = this.mReceiveGiftMessageListeners.iterator();
            while (it6.hasNext()) {
                it6.next().onError(-1, "gift data parse fail");
            }
            QLog.e(TAG, 1, "gift data parse error:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService
    public void addReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) receiveGiftMessageListener);
            return;
        }
        this.mReceiveGiftMessageListeners.add(receiveGiftMessageListener);
        AegisLogger.i(TAG, "addReceiveGiftMessageListener", "size:" + this.mReceiveGiftMessageListeners.size());
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService
    public void delReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) receiveGiftMessageListener);
            return;
        }
        AegisLogger.i(TAG, "delReceiveGiftMessageListener", "remove:" + this.mReceiveGiftMessageListeners.remove(receiveGiftMessageListener));
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveGiftService destroy");
        }
        c cVar = this.mGiftPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.mReceiveGiftMessageListeners.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdkImpl = iQQLiveSDK;
            initGiftMessageListener(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveGiftService reset");
        }
        c cVar = this.mGiftPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.mReceiveGiftMessageListeners.clear();
    }
}
