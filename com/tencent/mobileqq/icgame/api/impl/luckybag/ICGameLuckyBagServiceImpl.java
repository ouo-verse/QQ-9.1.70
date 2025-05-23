package com.tencent.mobileqq.icgame.api.impl.luckybag;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.luckybag.ICGameLuckyBagServiceImpl;
import com.tencent.mobileqq.icgame.api.luckybag.IICGameLuckyBagService;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import t32.b;
import x22.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ICGameLuckyBagServiceImpl implements IICGameLuckyBagService {
    private static final int LUCKY_BAG_MESSAGE_CMD = 285;
    private static final int LUCKY_BAG_UPDATE_EXT_DATA_CMD = 100;
    private static final String TAG = "ICGameLuckyBagServiceImpl";
    private Set<a> mListeners = new HashSet();
    private b mPushReceiver;

    private void initMessageListener(IQQLiveSDK iQQLiveSDK) {
        this.mPushReceiver = ((t32.a) iQQLiveSDK.getExtModule("roomPush")).b().b(285, new ni2.a() { // from class: c22.a
            @Override // ni2.a
            public final void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                ICGameLuckyBagServiceImpl.this.lambda$initMessageListener$0(i3, bArr, liveMsgExtInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessageListener$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onError(-1, "data is null");
            }
            return;
        }
        try {
            if (cz0.a.c(bArr).f392433a == 100) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "get message push");
                }
                Iterator<a> it5 = this.mListeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onLuckyBagMessageReceive();
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parse data error, e = " + th5.getMessage());
            Iterator<a> it6 = this.mListeners.iterator();
            while (it6.hasNext()) {
                it6.next().onError(-1, "parse data error");
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.luckybag.IICGameLuckyBagService
    public void addReceiveGiftMessageListener(a aVar) {
        this.mListeners.add(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.luckybag.IICGameLuckyBagService
    public void delReceiveGiftMessageListener(a aVar) {
        this.mListeners.remove(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        b bVar = this.mPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.mListeners.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        initMessageListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        b bVar = this.mPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.mListeners.clear();
    }
}
