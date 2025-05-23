package com.tencent.mobileqq.qqlive.api.impl.message;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import rq3.h;
import rq3.i;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveChatMsgServiceImpl implements IQQLiveChatMsgService {
    static IPatchRedirector $redirector_ = null;
    private static final int EXT_DATA_SERVER_ID = 232;
    private static final int NORMAL_CHAT_MESSAGE_CMD = 33;
    private static final int PUSH_ERR0R = 1003;
    private static final String QQ_SEND_MSG_CMD = "trpc.qlive.word_svr.WordSvr";
    private static final String QQ_SEND_MSG_SUBCMD = "NewPublicChat";
    private static final String TAG = "QQLiveChatMsgService";
    private static final int TIME_OUT = 1002;
    private CopyOnWriteArraySet<IQQLiveReceiveMessageListener> chatMsgReceiveListenerSet;
    private ni2.c normalMsgPushReceiver;
    private IQQLiveSDK sdkImpl;

    public QQLiveChatMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.chatMsgReceiveListenerSet = new CopyOnWriteArraySet<>();
        }
    }

    private LiveMessageData convertBroadCastMsgToMessageData(rq3.a aVar) {
        LiveMessageData liveMessageData = new LiveMessageData();
        liveMessageData.mMessageType = 1;
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        i iVar = aVar.f431934a;
        speakerInfo.mSpeakId = iVar.f431958a;
        speakerInfo.mSpeakerName = iVar.f431959b;
        speakerInfo.mLogo = iVar.f431960c;
        speakerInfo.mQunNick = iVar.f431961d;
        speakerInfo.mBusinessUid = iVar.f431962e;
        speakerInfo.mClientType = aVar.f431936c;
        liveMessageData.mSpeakerInfo = speakerInfo;
        ArrayList<LiveMessageData.MsgElement> arrayList = new ArrayList<>();
        ArrayList<LiveMessageData.ExtData> arrayList2 = new ArrayList<>();
        for (rq3.e eVar : aVar.f431935b.f431942a) {
            LiveMessageData.MsgElement msgElement = new LiveMessageData.MsgElement();
            LiveMessageData.TextElement textElement = new LiveMessageData.TextElement();
            LiveMessageData.ImageElement imageElement = new LiveMessageData.ImageElement();
            h hVar = eVar.f431946b;
            if (hVar != null) {
                byte[] bArr = hVar.f431957a;
                textElement.mText = bArr;
                try {
                    textElement.strText = new String(bArr, "utf-16LE");
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 4, "get 0x21 chat message push message" + textElement.strText);
                    }
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                    textElement.strText = "";
                }
            }
            rq3.c cVar = eVar.f431947c;
            if (cVar != null) {
                imageElement.mImageUrl = cVar.f431941a;
            }
            msgElement.mElementType = eVar.f431945a;
            msgElement.mHideLogo = eVar.f431948d;
            msgElement.mTextMsg = textElement;
            msgElement.mImageMsg = imageElement;
            arrayList.add(msgElement);
        }
        for (rq3.b bVar : aVar.f431935b.f431943b) {
            LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
            extData.mId = bVar.f431939a;
            extData.mValue = bVar.f431940b;
            arrayList2.add(extData);
            if (extData.mId == 232) {
                liveMessageData.mMessageId = new String(extData.mValue);
            }
        }
        LiveMessageData.MsgContent msgContent = new LiveMessageData.MsgContent();
        msgContent.mMsgElements = arrayList;
        msgContent.mExtDatas = arrayList2;
        liveMessageData.msgContent = msgContent;
        return liveMessageData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LiveMessageData convertChatPbDataToChatMessage(byte[] bArr) {
        LiveMessageData liveMessageData = new LiveMessageData();
        try {
            return convertBroadCastMsgToMessageData(rq3.a.c(bArr));
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e(TAG, 1, "convertChatPbDataToChatMessage error:" + e16.getMessage());
            return liveMessageData;
        }
    }

    private String getAccountStr() {
        AppInterface a16 = g.a();
        if (a16 == null) {
            return null;
        }
        return a16.getAccount();
    }

    private void initNormalChatMsgListener(IQQLiveSDK iQQLiveSDK) {
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            return;
        }
        this.normalMsgPushReceiver = bVar.b().b(33, new ni2.a(iQQLiveSDK) { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IQQLiveSDK val$sdkImpl;

            {
                this.val$sdkImpl = iQQLiveSDK;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMsgServiceImpl.this, (Object) iQQLiveSDK);
                }
            }

            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, liveMsgExtInfo);
                    return;
                }
                if (this.val$sdkImpl.getLoginModule() != null && this.val$sdkImpl.getLoginModule().getLoginInfo() != null) {
                    LiveMessageData convertChatPbDataToChatMessage = QQLiveChatMsgServiceImpl.this.convertChatPbDataToChatMessage(bArr);
                    long j3 = this.val$sdkImpl.getLoginModule().getLoginInfo().uid;
                    if (convertChatPbDataToChatMessage != null) {
                        if (convertChatPbDataToChatMessage.mSpeakerInfo.mSpeakId == j3) {
                            return;
                        }
                        convertChatPbDataToChatMessage.mMsgExtInfo = liveMsgExtInfo;
                        if (QLog.isColorLevel()) {
                            QLog.i(QQLiveChatMsgServiceImpl.TAG, 4, "get 0x21 chat message push, speaker: " + convertChatPbDataToChatMessage.mSpeakerInfo.mSpeakId + "\n messageId = " + convertChatPbDataToChatMessage.mMessageId);
                        }
                        Iterator it = QQLiveChatMsgServiceImpl.this.chatMsgReceiveListenerSet.iterator();
                        while (it.hasNext()) {
                            ((IQQLiveReceiveMessageListener) it.next()).onMessageReceive(convertChatPbDataToChatMessage);
                        }
                        return;
                    }
                    QLog.e(QQLiveChatMsgServiceImpl.TAG, 4, "parse data failed!!!");
                    return;
                }
                QLog.i(QQLiveChatMsgServiceImpl.TAG, 1, "initNormalChatMsgListener:loginModule == null or loginInfo == null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reportMessageError(int i3, String str) {
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK == null) {
            return false;
        }
        String appId = iQQLiveSDK.getAppId();
        String accountStr = getAccountStr();
        if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(accountStr)) {
            ft3.c newReportTask = this.sdkImpl.getDataReportModule().newReportTask();
            newReportTask.a("message_send_error");
            newReportTask.addKeyValue("appid", appId);
            newReportTask.addKeyValue(AudienceReportConst.USER_QQ, accountStr);
            newReportTask.addKeyValue("errorcode", i3);
            newReportTask.addKeyValue("errormsg", str);
            newReportTask.send();
            return true;
        }
        QLog.e(TAG, 1, "reportErrorCode get UIN null");
        return false;
    }

    private void sendMessageReq(LiveMessageData liveMessageData, byte[] bArr, IQQLiveMessageCallback iQQLiveMessageCallback) {
        ((com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module")).f(QQ_SEND_MSG_CMD, QQ_SEND_MSG_SUBCMD, bArr, new f(iQQLiveMessageCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ IQQLiveMessageCallback val$callback;

            {
                this.val$callback = iQQLiveMessageCallback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMsgServiceImpl.this, (Object) iQQLiveMessageCallback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    return;
                }
                if (this.val$callback == null) {
                    return;
                }
                QLog.i(QQLiveChatMsgServiceImpl.TAG, 1, "sendMessageReq receive, isSuccess:" + z16);
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQLiveChatMsgServiceImpl.TAG, 4, "sendMessageReq receive");
                    }
                    if (hVar == null) {
                        QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Message onReceive QQLiveRspData null");
                        return;
                    }
                    if (hVar.e() == null) {
                        QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Message onReceive data null");
                        return;
                    }
                    if (hVar.b() != 0) {
                        QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "bizErrCode:" + hVar.b() + ", bizErrMsg:" + hVar.c());
                        this.val$callback.onFail(hVar.b(), hVar.c());
                        return;
                    }
                    try {
                        rq3.g c16 = rq3.g.c(hVar.e());
                        if (QQLiveChatMsgServiceImpl.this.reportMessageError(c16.f431954a, c16.f431955b)) {
                            QLog.e(QQLiveChatMsgServiceImpl.TAG, 4, "QQLive Message send report fail");
                        }
                        QLog.i(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Message send result, respCode:" + c16.f431954a + ", errMsg:" + c16.f431955b);
                        int i16 = c16.f431954a;
                        if (i16 == 0) {
                            this.val$callback.onSuccess(false);
                            return;
                        }
                        if (i16 == 10002) {
                            this.val$callback.onUserForbid(c16.f431955b);
                            return;
                        } else if (i16 == 10003) {
                            this.val$callback.onIllegalMsg();
                            return;
                        } else {
                            this.val$callback.onFail(i16, c16.f431955b);
                            return;
                        }
                    } catch (InvalidProtocolBufferNanoException unused) {
                        QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Message onReceive data parse fail");
                        this.val$callback.onFail(-1, "QQLive Message onReceive data parse fail");
                        return;
                    }
                }
                if (hVar == null) {
                    QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Send Message onError QQLiveRspData null");
                    return;
                }
                if (hVar.e() == null) {
                    QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Send Message onError data null");
                    return;
                }
                if (hVar.h().getResultCode() == 1002 || hVar.h().getResultCode() == 1003) {
                    QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Send Message onError Time out");
                    this.val$callback.onFail(hVar.h().getResultCode(), "time out");
                }
                if (hVar.g() != 0) {
                    QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Send Message onError proxy service err " + hVar.g());
                    this.val$callback.onFail(hVar.g(), "proxy service err " + hVar.f());
                }
                if (hVar.b() != 0) {
                    QLog.e(QQLiveChatMsgServiceImpl.TAG, 1, "QQLive Send Message onError business service err " + hVar.b());
                    this.val$callback.onFail(hVar.b(), "business service err " + hVar.f());
                }
            }
        });
    }

    private void sendToLocalScreen(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback) {
        LiveMsgExtInfo liveMsgExtInfo = new LiveMsgExtInfo();
        liveMsgExtInfo.msgSpeed = LiveMsgExtInfo.MsgSpeed.NON_CONST;
        liveMessageData.mMsgExtInfo = liveMsgExtInfo;
        Iterator<LiveMessageData.MsgElement> it = liveMessageData.msgContent.mMsgElements.iterator();
        while (it.hasNext()) {
            try {
                LiveMessageData.TextElement textElement = it.next().mTextMsg;
                textElement.strText = new String(textElement.mText, "utf-16LE");
            } catch (UnsupportedEncodingException e16) {
                QLog.e(TAG, 1, "sendToLocalScreen exception:" + e16);
            }
        }
        Iterator<IQQLiveReceiveMessageListener> it5 = this.chatMsgReceiveListenerSet.iterator();
        while (it5.hasNext()) {
            it5.next().onMessageReceive(liveMessageData);
        }
        iQQLiveMessageCallback.onSuccess(true);
    }

    private void sendToServer(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback) {
        if (liveMessageData != null) {
            QLog.i(TAG, 1, "sendToServer");
            rq3.f fVar = new rq3.f();
            fVar.f431949a = liveMessageData.mMainRoomId;
            fVar.f431950b = liveMessageData.mSubRoomId;
            rq3.d dVar = new rq3.d();
            ArrayList arrayList = new ArrayList();
            Iterator<LiveMessageData.MsgElement> it = liveMessageData.msgContent.mMsgElements.iterator();
            while (it.hasNext()) {
                LiveMessageData.MsgElement next = it.next();
                rq3.e eVar = new rq3.e();
                eVar.f431945a = 1;
                h hVar = new h();
                hVar.f431957a = next.mTextMsg.mText;
                eVar.f431946b = hVar;
                arrayList.add(eVar);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<LiveMessageData.ExtData> it5 = liveMessageData.msgContent.mExtDatas.iterator();
            while (it5.hasNext()) {
                LiveMessageData.ExtData next2 = it5.next();
                rq3.b bVar = new rq3.b();
                bVar.f431939a = next2.mId;
                bVar.f431940b = next2.mValue;
                arrayList2.add(bVar);
            }
            dVar.f431942a = (rq3.e[]) arrayList.toArray(new rq3.e[arrayList.size()]);
            dVar.f431943b = (rq3.b[]) arrayList2.toArray(new rq3.b[arrayList2.size()]);
            fVar.f431951c = dVar;
            sendMessageReq(liveMessageData, MessageNano.toByteArray(fVar), iQQLiveMessageCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService
    public void addChatMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else if (iQQLiveReceiveMessageListener != null) {
            this.chatMsgReceiveListenerSet.add(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService
    public void delChatMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else if (iQQLiveReceiveMessageListener != null) {
            this.chatMsgReceiveListenerSet.remove(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.e(TAG, 4, "QQLiveChatMsgServiceImpl destroy");
        ni2.c cVar = this.normalMsgPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.chatMsgReceiveListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        this.sdkImpl = iQQLiveSDK;
        if (iQQLiveSDK != null) {
            initNormalChatMsgListener(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d(TAG, 4, "IQQLiveChatMsgService reset");
        ni2.c cVar = this.normalMsgPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.chatMsgReceiveListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService
    public void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, arrayList, iQQLiveMessageCallback, Integer.valueOf(i3));
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK != null) {
            ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
            LiveMessageData liveMessageData = new LiveMessageData();
            if (bVar != null) {
                liveMessageData.mMainRoomId = (int) bVar.getRoomId();
                liveMessageData.mSubRoomId = (int) bVar.getRoomId();
            }
            liveMessageData.mMessageType = 1;
            LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(this.sdkImpl.getAppId(), ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
            if (loginInfo != null) {
                try {
                    liveMessageData.mSpeakerInfo.mSpeakId = loginInfo.q();
                    liveMessageData.mSpeakerInfo.mBusinessUid = loginInfo.k();
                    liveMessageData.mSpeakerInfo.mSpeakerName = loginInfo.m();
                    liveMessageData.mSpeakerInfo.mLogo = loginInfo.j();
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "sendMessage error", e16);
                    liveMessageData.mSpeakerInfo.mSpeakId = this.sdkImpl.getLoginModule().getLoginInfo().uid;
                    liveMessageData.mSpeakerInfo.mBusinessUid = this.sdkImpl.getLoginModule().getLoginInfo().businessUid;
                    LiveUserInfo userInfo = this.sdkImpl.getLoginModule().getUserInfo();
                    if (userInfo != null) {
                        LiveMessageData.SpeakerInfo speakerInfo = liveMessageData.mSpeakerInfo;
                        speakerInfo.mSpeakerName = userInfo.nick;
                        speakerInfo.mLogo = userInfo.headUrl;
                    }
                }
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            liveMessageData.msgContent.mExtDatas.addAll(arrayList);
            LiveMessageData.MsgElement msgElement = new LiveMessageData.MsgElement();
            msgElement.mElementType = 1;
            LiveMessageData.TextElement textElement = new LiveMessageData.TextElement();
            msgElement.mTextMsg = textElement;
            try {
                textElement.mText = str.getBytes("utf-16LE");
                liveMessageData.msgContent.mMsgElements.add(msgElement);
            } catch (UnsupportedEncodingException e17) {
                QLog.e(TAG, 1, "sendMessage exception:" + e17);
            }
            sendMessage(liveMessageData, iQQLiveMessageCallback, i3);
            return;
        }
        QLog.e(TAG, 1, "sendMessage error, sdkImpl is null.");
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService
    public void sendMessage(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, liveMessageData, iQQLiveMessageCallback, Integer.valueOf(i3));
            return;
        }
        if (i3 == 0) {
            sendToLocalScreen(liveMessageData, iQQLiveMessageCallback);
            sendToServer(liveMessageData, iQQLiveMessageCallback);
        } else if (i3 == 1) {
            sendToServer(liveMessageData, iQQLiveMessageCallback);
        } else {
            if (i3 != 2) {
                return;
            }
            sendToLocalScreen(liveMessageData, iQQLiveMessageCallback);
        }
    }
}
