package com.tencent.mobileqq.icgame.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes15.dex */
public class QQLivePushCmdServiceImpl implements IQQLivePushCmdService {
    private static final String TAG = "ICGameIQQLivePushCmdService";
    private t32.b highPriorityPushReceiver;
    private t32.b livePushReceiver;
    private t32.b lowPriorityPushReceiver;
    private IQQLiveSDK sdkImpl;
    private ConcurrentHashMap<Integer, CopyOnWriteArraySet<IQQCmdPushCallback>> highPriorityMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, CopyOnWriteArraySet<IQQCmdPushCallback>> lowPriorityMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, t32.b> receiverMap = new ConcurrentHashMap<>();

    private void initHighPriorityListener(IQQLiveSDK iQQLiveSDK) {
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.highPriorityPushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.e
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLivePushCmdServiceImpl.this.lambda$initHighPriorityListener$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    private void initLowPriorityListener(IQQLiveSDK iQQLiveSDK) {
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.lowPriorityPushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.d
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
            cz0.a c16 = cz0.a.c(bArr);
            CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.highPriorityMap.get(Integer.valueOf(c16.f392433a));
            if (copyOnWriteArraySet != null) {
                Iterator<IQQCmdPushCallback> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    it.next().onReceive(c16.f392435c);
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
            cz0.a c16 = cz0.a.c(bArr);
            CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.lowPriorityMap.get(Integer.valueOf(c16.f392433a));
            if (copyOnWriteArraySet != null) {
                Iterator<IQQCmdPushCallback> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    it.next().onReceive(c16.f392435c);
                }
                return;
            }
            QLog.e(TAG, 4, "find this cmd get result null");
        } catch (InvalidProtocolBufferNanoException unused) {
            QLog.e(TAG, 4, "parse data error");
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveAnnounceMsgService destroy");
        }
        t32.b bVar = this.highPriorityPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        t32.b bVar2 = this.lowPriorityPushReceiver;
        if (bVar2 != null) {
            bVar2.a();
        }
        t32.b bVar3 = this.livePushReceiver;
        if (bVar3 != null) {
            bVar3.a();
        }
        this.highPriorityMap.clear();
        this.lowPriorityMap.clear();
        this.receiverMap.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdkImpl = iQQLiveSDK;
        initHighPriorityListener(iQQLiveSDK);
        initLowPriorityListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService
    public void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (!this.highPriorityMap.containsKey(Integer.valueOf(i3))) {
            this.highPriorityMap.put(Integer.valueOf(i3), new CopyOnWriteArraySet<>());
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.highPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService
    public void registerLivePushChannel(int i3, final IQQCmdPushCallback iQQCmdPushCallback) {
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK == null) {
            return;
        }
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
            }
            iQQCmdPushCallback.onFail(-1, "get IQQLiveRoomPushService null");
        } else {
            this.livePushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLivePushCmdServiceImpl.1
                @Override // ni2.a
                public void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    iQQCmdPushCallback.onReceive(bArr);
                }
            });
            this.receiverMap.put(Integer.valueOf(iQQCmdPushCallback.hashCode()), this.livePushReceiver);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService
    public void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (!this.lowPriorityMap.containsKey(Integer.valueOf(i3))) {
            this.lowPriorityMap.put(Integer.valueOf(i3), new CopyOnWriteArraySet<>());
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.lowPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveAnnounceMsgService reset");
        }
        t32.b bVar = this.highPriorityPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        t32.b bVar2 = this.lowPriorityPushReceiver;
        if (bVar2 != null) {
            bVar2.a();
        }
        t32.b bVar3 = this.livePushReceiver;
        if (bVar3 != null) {
            bVar3.a();
        }
        this.highPriorityMap.clear();
        this.lowPriorityMap.clear();
        this.receiverMap.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService
    public void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (!this.highPriorityMap.containsKey(Integer.valueOf(i3)) && iQQCmdPushCallback != null) {
            iQQCmdPushCallback.onFail(-1, "this cmd did not register before");
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.highPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService
    public void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback) {
        if (iQQCmdPushCallback == null) {
            return;
        }
        t32.b bVar = this.receiverMap.get(Integer.valueOf(iQQCmdPushCallback.hashCode()));
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService
    public void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (!this.lowPriorityMap.containsKey(Integer.valueOf(i3)) && iQQCmdPushCallback != null) {
            iQQCmdPushCallback.onFail(-1, "this cmd did not register before");
        }
        CopyOnWriteArraySet<IQQCmdPushCallback> copyOnWriteArraySet = this.lowPriorityMap.get(Integer.valueOf(i3));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(iQQCmdPushCallback);
        }
    }
}
