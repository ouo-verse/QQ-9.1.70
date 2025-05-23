package com.tencent.mobileqq.qqlive.api.impl.message;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveSystemMsgServiceImpl implements IQQLiveSystemMsgService {
    static IPatchRedirector $redirector_ = null;
    private static final int SYSTEM_NOTICE_MESSAGE_CMD = 255;
    private static final String TAG = "QQLiveSystemMsgService";
    private ni2.c systemMsgPushReceiver;
    private CopyOnWriteArraySet<IQQLiveReceiveMessageListener> systemMsgReceiveListenerSet;

    public QQLiveSystemMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.systemMsgReceiveListenerSet = new CopyOnWriteArraySet<>();
        }
    }

    private void initSystemNoticeMsgListener(IQQLiveSDK iQQLiveSDK) {
        this.systemMsgPushReceiver = ((ni2.b) iQQLiveSDK.getExtModule("roomPush")).b().b(255, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveSystemMsgServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveSystemMsgServiceImpl.this);
                }
            }

            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, liveMsgExtInfo);
                    return;
                }
                if (i3 == 255 && bArr != null) {
                    try {
                        String str = new String(i11.a.c(bArr).f407027b, Charset.forName("UTF-8"));
                        if (!TextUtils.isEmpty(str)) {
                            LiveMessageData liveMessageData = new LiveMessageData();
                            liveMessageData.mMessageType = 4;
                            liveMessageData.mRawTipStr = str;
                            liveMessageData.mMsgExtInfo = liveMsgExtInfo;
                            Iterator it = QQLiveSystemMsgServiceImpl.this.systemMsgReceiveListenerSet.iterator();
                            while (it.hasNext()) {
                                ((IQQLiveReceiveMessageListener) it.next()).onMessageReceive(liveMessageData);
                            }
                        }
                    } catch (InvalidProtocolBufferNanoException e16) {
                        QLog.e(QQLiveSystemMsgServiceImpl.TAG, 1, "initSystemNoticeMsgListener error:" + e16.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService
    public void addSystemMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else if (iQQLiveReceiveMessageListener != null) {
            this.systemMsgReceiveListenerSet.add(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService
    public void delSystemMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else if (iQQLiveReceiveMessageListener != null) {
            this.systemMsgReceiveListenerSet.remove(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 4, "IQQLiveSystemMsgService destroy");
        }
        ni2.c cVar = this.systemMsgPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.systemMsgReceiveListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            initSystemNoticeMsgListener(iQQLiveSDK);
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
            QLog.d(TAG, 4, "IQQLiveSystemMsgService reset");
        }
        ni2.c cVar = this.systemMsgPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.systemMsgReceiveListenerSet.clear();
    }
}
