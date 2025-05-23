package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveFloatHeartServiceImpl implements IQQLiveFloatHeartService {
    static IPatchRedirector $redirector_ = null;
    private static final int FLOAT_HEART_CMD = 15;
    private static final String TAG = "QQLiveFloatHeartService";
    private Set<ji2.a> listenerSet;
    private ni2.c pushReceiver;

    public QQLiveFloatHeartServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.listenerSet = new HashSet();
        }
    }

    private void initPush(IQQLiveSDK iQQLiveSDK) {
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            QLog.e(TAG, 4, "GET roomPushService NULL");
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.pushReceiver = bVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.b
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveFloatHeartServiceImpl.this.lambda$initPush$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPush$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            QLog.e(TAG, 4, "QQLive LiveRoomLikePushMsg onReceive data null");
            return;
        }
        try {
            gp4.a c16 = gp4.a.c(bArr);
            if (c16.f403047a != 15) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "get LOW_PRIORITY_MESSAGE but not like");
                    return;
                }
                return;
            }
            onFreeLoveMessageReceive(yq4.a.c(c16.f403049c));
        } catch (InvalidProtocolBufferNanoException unused) {
            QLog.e(TAG, 4, "QQLive LiveRoomLikePushMsg onReceive data parse fail");
        }
    }

    private void onFreeLoveMessageReceive(yq4.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onFreeLoveMessageReceive] data:" + aVar);
        }
        QLBroadCastFreeLove qLBroadCastFreeLove = new QLBroadCastFreeLove();
        qLBroadCastFreeLove.roomId = aVar.f451019a;
        qLBroadCastFreeLove.headImg = aVar.f451022d;
        qLBroadCastFreeLove.roomMsg = aVar.f451023e;
        qLBroadCastFreeLove.userNick = aVar.f451021c;
        qLBroadCastFreeLove.uid = aVar.f451020b;
        qLBroadCastFreeLove.freeLoves = new ArrayList<>();
        for (int i3 = 0; i3 < aVar.f451024f.length; i3++) {
            FreeLove freeLove = new FreeLove();
            freeLove.loveType = aVar.f451024f[i3];
            freeLove.loveNum = 1;
            qLBroadCastFreeLove.freeLoves.add(freeLove);
        }
        for (ji2.a aVar2 : this.listenerSet) {
            aVar2.onReceiveRoomLikePush(qLBroadCastFreeLove);
            aVar2.onReceiveFreeLove(qLBroadCastFreeLove.uid, qLBroadCastFreeLove.freeLoves, Boolean.TRUE);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService
    public void addOnReceiveFloatHeartListener(ji2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            this.listenerSet.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.listenerSet.clear();
        ni2.c cVar = this.pushReceiver;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveSDK);
        } else {
            initPush(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService
    public void removeOnReceiveFloatHeartListener(ji2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            this.listenerSet.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.listenerSet.clear();
        ni2.c cVar = this.pushReceiver;
        if (cVar != null) {
            cVar.a();
        }
    }
}
