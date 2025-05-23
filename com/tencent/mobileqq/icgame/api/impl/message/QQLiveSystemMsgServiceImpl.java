package com.tencent.mobileqq.icgame.api.impl.message;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.message.IQQLiveSystemMsgService;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveSystemMsgServiceImpl implements IQQLiveSystemMsgService {
    private static final int SYSTEM_NOTICE_MESSAGE_CMD = 255;
    private static final String TAG = "ICGameSystemMsgService";
    private t32.b systemMsgPushReceiver;
    private CopyOnWriteArraySet<y22.a> systemMsgReceiveListenerSet = new CopyOnWriteArraySet<>();

    private void initSystemNoticeMsgListener(IQQLiveSDK iQQLiveSDK) {
        this.systemMsgPushReceiver = ((t32.a) iQQLiveSDK.getExtModule("roomPush")).b().b(255, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveSystemMsgServiceImpl.1
            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                if (i3 == 255 && bArr != null) {
                    try {
                        String str = new String(qy0.a.c(bArr).f430308b, Charset.forName("UTF-8"));
                        if (!TextUtils.isEmpty(str)) {
                            LiveMessageData liveMessageData = new LiveMessageData();
                            liveMessageData.mMessageType = 4;
                            liveMessageData.mRawTipStr = str;
                            liveMessageData.mMsgExtInfo = liveMsgExtInfo;
                            Iterator it = QQLiveSystemMsgServiceImpl.this.systemMsgReceiveListenerSet.iterator();
                            while (it.hasNext()) {
                                ((y22.a) it.next()).a(liveMessageData);
                            }
                        }
                    } catch (InvalidProtocolBufferNanoException e16) {
                        QLog.e(QQLiveSystemMsgServiceImpl.TAG, 1, "initSystemNoticeMsgListener error:" + e16.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveSystemMsgService
    public void addSystemMessageListener(y22.a aVar) {
        if (aVar != null) {
            this.systemMsgReceiveListenerSet.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveSystemMsgService
    public void delSystemMessageListener(y22.a aVar) {
        if (aVar != null) {
            this.systemMsgReceiveListenerSet.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 4, "IQQLiveSystemMsgService destroy");
        }
        t32.b bVar = this.systemMsgPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.systemMsgReceiveListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        initSystemNoticeMsgListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveSystemMsgService reset");
        }
        t32.b bVar = this.systemMsgPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.systemMsgReceiveListenerSet.clear();
    }
}
