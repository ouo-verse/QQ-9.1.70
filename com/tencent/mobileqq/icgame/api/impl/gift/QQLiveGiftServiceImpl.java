package com.tencent.mobileqq.icgame.api.impl.gift;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftService;
import com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import t32.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveGiftServiceImpl implements IQQLiveGiftService {
    private static final String TAG = "ICGameGift|ICGameIQQLiveGiftService";
    private b mGiftPushReceiver;
    private Set<v22.a> mReceiveGiftMessageListeners = new HashSet();
    private IQQLiveSDK sdkImpl;

    private void initGiftMessageListener(final IQQLiveSDK iQQLiveSDK) {
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        for (final int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.mGiftPushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.gift.a
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveGiftServiceImpl.this.lambda$initGiftMessageListener$0(i3, iQQLiveSDK, i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGiftMessageListener$0(int i3, IQQLiveSDK iQQLiveSDK, int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        rt0.a.f(TAG, "initGiftMessageListener", "gift message push cmd:" + i16 + " size:" + this.mReceiveGiftMessageListeners.size());
        if (bArr == null) {
            Iterator<v22.a> it = this.mReceiveGiftMessageListeners.iterator();
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
            Iterator<v22.a> it5 = this.mReceiveGiftMessageListeners.iterator();
            while (it5.hasNext()) {
                it5.next().a(covertPushDataToGiftMessage);
            }
        } catch (Throwable th5) {
            Iterator<v22.a> it6 = this.mReceiveGiftMessageListeners.iterator();
            while (it6.hasNext()) {
                it6.next().onError(-1, "gift data parse fail");
            }
            QLog.e(TAG, 1, "gift data parse error:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftService
    public void addReceiveGiftMessageListener(v22.a aVar) {
        this.mReceiveGiftMessageListeners.add(aVar);
        rt0.a.f(TAG, "addReceiveGiftMessageListener", "size:" + this.mReceiveGiftMessageListeners.size());
    }

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftService
    public void delReceiveGiftMessageListener(v22.a aVar) {
        rt0.a.f(TAG, "delReceiveGiftMessageListener", "remove:" + this.mReceiveGiftMessageListeners.remove(aVar));
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveGiftService destroy");
        }
        b bVar = this.mGiftPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.mReceiveGiftMessageListeners.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdkImpl = iQQLiveSDK;
        initGiftMessageListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveGiftService reset");
        }
        b bVar = this.mGiftPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.mReceiveGiftMessageListeners.clear();
    }
}
