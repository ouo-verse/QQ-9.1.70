package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes17.dex */
public class QQLivePushCmdServiceImpl implements IQQLivePushCmdService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IQQLivePushCmdService";
    private ConcurrentHashMap<Integer, CopyOnWriteArraySet<IQQCmdPushCallback>> highPriorityMap;
    private ni2.c highPriorityPushReceiver;
    private ni2.c livePushReceiver;
    private ConcurrentHashMap<Integer, CopyOnWriteArraySet<IQQCmdPushCallback>> lowPriorityMap;
    private ni2.c lowPriorityPushReceiver;
    private ConcurrentHashMap<Integer, ni2.c> receiverMap;
    private IQQLiveSDK sdkImpl;

    public QQLivePushCmdServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.highPriorityMap = new ConcurrentHashMap<>();
        this.lowPriorityMap = new ConcurrentHashMap<>();
        this.receiverMap = new ConcurrentHashMap<>();
    }

    private void initHighPriorityListener(IQQLiveSDK iQQLiveSDK) {
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.highPriorityPushReceiver = bVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.d
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLivePushCmdServiceImpl.this.lambda$initHighPriorityListener$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    private void initLowPriorityListener(IQQLiveSDK iQQLiveSDK) {
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.lowPriorityPushReceiver = bVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.e
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLivePushCmdServiceImpl.this.lambda$initLowPriorityListener$1(i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHighPriorityListener$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            QLog.e(TAG, 4, "receive data null");
            return;
        }
        try {
            gp4.a c16 = gp4.a.c(bArr);
            CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.highPriorityMap.get(Integer.valueOf(c16.f403047a));
            if (copyOnWriteArraySet != null) {
                Iterator<IQQCmdPushCallback> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    it.next().onReceive(c16.f403049c);
                }
                return;
            }
            QLog.e(TAG, 4, "find this cmd get result null");
        } catch (InvalidProtocolBufferNanoException unused) {
            QLog.e(TAG, 4, "parse data error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLowPriorityListener$1(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            QLog.e(TAG, 4, "receive data null");
            return;
        }
        try {
            gp4.a c16 = gp4.a.c(bArr);
            CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.lowPriorityMap.get(Integer.valueOf(c16.f403047a));
            if (copyOnWriteArraySet != null) {
                Iterator<IQQCmdPushCallback> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    it.next().onReceive(c16.f403049c);
                }
                return;
            }
            QLog.e(TAG, 4, "find this cmd get result null");
        } catch (InvalidProtocolBufferNanoException unused) {
            QLog.e(TAG, 4, "parse data error");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveAnnounceMsgService destroy");
        }
        ni2.c cVar = this.highPriorityPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        ni2.c cVar2 = this.lowPriorityPushReceiver;
        if (cVar2 != null) {
            cVar2.a();
        }
        ni2.c cVar3 = this.livePushReceiver;
        if (cVar3 != null) {
            cVar3.a();
        }
        this.highPriorityMap.clear();
        this.lowPriorityMap.clear();
        this.receiverMap.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        this.sdkImpl = iQQLiveSDK;
        initHighPriorityListener(iQQLiveSDK);
        initLowPriorityListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
    public void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) iQQCmdPushCallback);
            return;
        }
        if (!this.highPriorityMap.containsKey(Integer.valueOf(i3))) {
            this.highPriorityMap.put(Integer.valueOf(i3), new CopyOnWriteArraySet<>());
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.highPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
    public void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) iQQCmdPushCallback);
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK == null) {
            return;
        }
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
            }
            iQQCmdPushCallback.onFail(-1, "get IQQLiveRoomPushService null");
        } else {
            this.livePushReceiver = bVar.b().b(i3, new ni2.a(iQQCmdPushCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLivePushCmdServiceImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IQQCmdPushCallback val$callback;

                {
                    this.val$callback = iQQCmdPushCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePushCmdServiceImpl.this, (Object) iQQCmdPushCallback);
                    }
                }

                @Override // ni2.a
                public void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i16), bArr, liveMsgExtInfo);
                    } else {
                        this.val$callback.onReceive(bArr);
                    }
                }
            });
            this.receiverMap.put(Integer.valueOf(iQQCmdPushCallback.hashCode()), this.livePushReceiver);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
    public void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) iQQCmdPushCallback);
            return;
        }
        if (!this.lowPriorityMap.containsKey(Integer.valueOf(i3))) {
            this.lowPriorityMap.put(Integer.valueOf(i3), new CopyOnWriteArraySet<>());
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.lowPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(iQQCmdPushCallback);
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
            QLog.d(TAG, 4, "IQQLiveAnnounceMsgService reset");
        }
        ni2.c cVar = this.highPriorityPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        ni2.c cVar2 = this.lowPriorityPushReceiver;
        if (cVar2 != null) {
            cVar2.a();
        }
        ni2.c cVar3 = this.livePushReceiver;
        if (cVar3 != null) {
            cVar3.a();
        }
        this.highPriorityMap.clear();
        this.lowPriorityMap.clear();
        this.receiverMap.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
    public void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) iQQCmdPushCallback);
            return;
        }
        if (!this.highPriorityMap.containsKey(Integer.valueOf(i3)) && iQQCmdPushCallback != null) {
            iQQCmdPushCallback.onFail(-1, "this cmd did not register before");
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.highPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
    public void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQCmdPushCallback);
            return;
        }
        if (iQQCmdPushCallback == null) {
            return;
        }
        ni2.c cVar = this.receiverMap.get(Integer.valueOf(iQQCmdPushCallback.hashCode()));
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
    public void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) iQQCmdPushCallback);
            return;
        }
        if (!this.lowPriorityMap.containsKey(Integer.valueOf(i3)) && iQQCmdPushCallback != null) {
            iQQCmdPushCallback.onFail(-1, "this cmd did not register before");
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.lowPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(iQQCmdPushCallback);
        }
    }
}
