package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnnounceMsgServiceImpl implements IQQLiveAnnounceMsgService {
    static IPatchRedirector $redirector_ = null;
    private static final int ANNOUNCE_MESSAGE_CMD = 18;
    private static final String TAG = "IQQLiveAnnounceMsgService";
    private ni2.c announcePushReceiver;
    private CopyOnWriteArraySet<IQQLiveAnnouncePushListener> receiveAnnounceListenerSet;
    private IQQLiveSDK sdkImpl;

    public QQLiveAnnounceMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.receiveAnnounceListenerSet = new CopyOnWriteArraySet<>();
        }
    }

    private void initAnnounceMsgListener(IQQLiveSDK iQQLiveSDK) {
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.announcePushReceiver = bVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.a
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveAnnounceMsgServiceImpl.this.lambda$initAnnounceMsgListener$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAnnounceMsgListener$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            QLog.e(TAG, 4, "QQLive AnnouncePushMsg onReceive data null");
            Iterator<IQQLiveAnnouncePushListener> it = this.receiveAnnounceListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onFail(-1, "QQLive AnnouncePushMsg onReceive data null");
            }
            return;
        }
        try {
            gp4.a c16 = gp4.a.c(bArr);
            if (c16.f403047a != 18) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "get LOW_PRIORITY_MESSAGE but not follow");
                    return;
                }
                return;
            }
            xq4.a c17 = xq4.a.c(c16.f403049c);
            AnnouncePushMessage announcePushMessage = new AnnouncePushMessage();
            announcePushMessage.roomId = c17.f448401a;
            announcePushMessage.uid = c17.f448402b;
            announcePushMessage.announce = c17.f448403c;
            announcePushMessage.approved = c17.f448404d;
            Iterator<IQQLiveAnnouncePushListener> it5 = this.receiveAnnounceListenerSet.iterator();
            while (it5.hasNext()) {
                it5.next().onAnnounceReceive(announcePushMessage);
            }
        } catch (InvalidProtocolBufferNanoException unused) {
            QLog.e(TAG, 4, "QQLive AnnouncePushMsg onReceive data parse fail");
            Iterator<IQQLiveAnnouncePushListener> it6 = this.receiveAnnounceListenerSet.iterator();
            while (it6.hasNext()) {
                it6.next().onFail(-1, "QQLive AnnouncePushMsg onReceive data parse fail");
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService
    public void addAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveAnnouncePushListener);
        } else if (iQQLiveAnnouncePushListener != null) {
            this.receiveAnnounceListenerSet.add(iQQLiveAnnouncePushListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService
    public void delAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveAnnouncePushListener);
        } else if (iQQLiveAnnouncePushListener != null) {
            this.receiveAnnounceListenerSet.remove(iQQLiveAnnouncePushListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d(TAG, 4, "IQQLiveAnnounceMsgService destroy");
        ni2.c cVar = this.announcePushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.receiveAnnounceListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        QLog.d(TAG, 4, "IQQLiveAnnounceMsgService init");
        this.sdkImpl = iQQLiveSDK;
        initAnnounceMsgListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d(TAG, 4, "IQQLiveAnnounceMsgService reset");
        ni2.c cVar = this.announcePushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.receiveAnnounceListenerSet.clear();
    }
}
