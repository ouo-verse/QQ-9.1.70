package com.tencent.mobileqq.icgame.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.icgame.api.message.IQQLiveAnnounceMsgService;
import com.tencent.mobileqq.icgame.sso.g;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveAnnounceMsgServiceImpl implements IQQLiveAnnounceMsgService {
    private static final int ANNOUNCE_MESSAGE_CMD = 18;
    private static final String QQ_LIVE_ANNOUNCE_CMD = "trpc.qlive.announce_svr.AnnounceSvr";
    private static final String QQ_LIVE_GET_ANNOUNCE_METHOD = "GetAnnouncement";
    private static final String QQ_LIVE_SET_ANNOUNCE_METHOD = "SetAnnouncement";
    private static final String TAG = "ICGameIQQLiveAnnounceMsgService";
    private t32.b announcePushReceiver;
    private CopyOnWriteArraySet<IQQLiveAnnouncePushListener> receiveAnnounceListenerSet = new CopyOnWriteArraySet<>();
    private IQQLiveSDK sdkImpl;

    private void initAnnounceMsgListener(IQQLiveSDK iQQLiveSDK) {
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.announcePushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.a
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
            cz0.a c16 = cz0.a.c(bArr);
            if (c16.f392433a != 18) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "get LOW_PRIORITY_MESSAGE but not follow");
                    return;
                }
                return;
            }
            gz0.a c17 = gz0.a.c(c16.f392435c);
            AnnouncePushMessage announcePushMessage = new AnnouncePushMessage();
            announcePushMessage.roomId = c17.f403900a;
            announcePushMessage.uid = c17.f403901b;
            announcePushMessage.announce = c17.f403902c;
            announcePushMessage.approved = c17.f403903d;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onGetAnnounceFail(t22.a aVar, i iVar) {
        if (aVar == null) {
            QLog.e(TAG, 4, "setAnnounceCallback is null");
            return true;
        }
        if (iVar != null && iVar.e() != null) {
            if (iVar.b() != 0) {
                aVar.onFail(iVar.b(), iVar.c());
                return true;
            }
            return false;
        }
        aVar.onFail(-1, "the data is null");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onSetAnnounceFail(t22.b bVar, i iVar) {
        if (bVar == null) {
            QLog.e(TAG, 4, "setAnnounceCallback is null");
            return true;
        }
        if (iVar != null && iVar.e() != null) {
            if (iVar.b() != 0) {
                bVar.onFail(iVar.b(), iVar.c());
                return true;
            }
            return false;
        }
        bVar.onFail(-1, "the data is null");
        return true;
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveAnnounceMsgService
    public void addAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        if (iQQLiveAnnouncePushListener != null) {
            this.receiveAnnounceListenerSet.add(iQQLiveAnnouncePushListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveAnnounceMsgService
    public void delAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        if (iQQLiveAnnouncePushListener != null) {
            this.receiveAnnounceListenerSet.remove(iQQLiveAnnouncePushListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        QLog.d(TAG, 4, "IQQLiveAnnounceMsgService destroy");
        t32.b bVar = this.announcePushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.receiveAnnounceListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveAnnounceMsgService
    public void getRoomAnnounce(long j3, final t22.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "getRoomAnnounce send");
        }
        if (this.sdkImpl != null) {
            gz0.b bVar = new gz0.b();
            bVar.f403904a = j3;
            com.tencent.mobileqq.icgame.sso.c cVar = (com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                }
            } else {
                QLog.d(TAG, 4, Long.valueOf(bVar.f403904a));
                cVar.f(QQ_LIVE_ANNOUNCE_CMD, QQ_LIVE_GET_ANNOUNCE_METHOD, MessageNano.toByteArray(bVar), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveAnnounceMsgServiceImpl.2
                    @Override // com.tencent.mobileqq.icgame.sso.g
                    public void onReceive(int i3, boolean z16, i iVar) {
                        if (z16) {
                            if (QQLiveAnnounceMsgServiceImpl.this.onGetAnnounceFail(aVar, iVar)) {
                                QLog.e(QQLiveAnnounceMsgServiceImpl.TAG, 4, "onCheckFollowAnchorFail fail");
                                return;
                            }
                            try {
                                gz0.c c16 = gz0.c.c(iVar.e());
                                aVar.a(c16.f403905a, c16.f403906b);
                            } catch (InvalidProtocolBufferNanoException e16) {
                                aVar.onFail(-1, "GetFollowListRsp parse fail");
                                QLog.e(QQLiveAnnounceMsgServiceImpl.TAG, 4, "GetAnnounceRsp error:" + e16.getMessage());
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        QLog.d(TAG, 4, "IQQLiveAnnounceMsgService init");
        this.sdkImpl = iQQLiveSDK;
        initAnnounceMsgListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        QLog.d(TAG, 4, "IQQLiveAnnounceMsgService reset");
        t32.b bVar = this.announcePushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.receiveAnnounceListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveAnnounceMsgService
    public void setRoomAnnounce(long j3, long j16, String str, final t22.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "setRoomAnnounce send");
        }
        if (this.sdkImpl != null) {
            gz0.d dVar = new gz0.d();
            dVar.f403907a = j3;
            dVar.f403908b = j16;
            dVar.f403909c = str;
            dVar.f403910d = new HashMap();
            com.tencent.mobileqq.icgame.sso.c cVar = (com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                    return;
                }
                return;
            }
            cVar.f(QQ_LIVE_ANNOUNCE_CMD, QQ_LIVE_SET_ANNOUNCE_METHOD, MessageNano.toByteArray(dVar), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveAnnounceMsgServiceImpl.1
                @Override // com.tencent.mobileqq.icgame.sso.g
                public void onReceive(int i3, boolean z16, i iVar) {
                    if (z16) {
                        if (QQLiveAnnounceMsgServiceImpl.this.onSetAnnounceFail(bVar, iVar)) {
                            QLog.e(QQLiveAnnounceMsgServiceImpl.TAG, 4, "onFollowAnchorFail fail");
                        } else {
                            bVar.onSuccess();
                        }
                    }
                }
            });
        }
    }
}
