package com.tencent.mobileqq.icgame.api.impl.message;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.message.IQQLiveChatMsgService;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.icgame.sso.g;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import vy0.f;
import vy0.h;
import vy0.i;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveChatMsgServiceImpl implements IQQLiveChatMsgService {
    private static final int CHANNEL_ERR0R = -1;
    private static final int DESERIALIZE_ERR0R = -2;
    private static final int EXT_DATA_SERVER_ID = 232;
    private static final int NORMAL_CHAT_MESSAGE_CMD = 33;
    private static final int OTHER_ERR0R = -3;
    private static final int PUSH_ERR0R = 1003;
    private static final String QQ_SEND_MSG_CMD = "trpc.icggame.word_svr.WordSvr";
    private static final String QQ_SEND_MSG_SUBCMD = "NewPublicChat";
    private static final int REPORT_TYPE_BIZ_RSP_ERR = 1;
    private static final int REPORT_TYPE_BIZ_SERVICE_ERR = 6;
    private static final int REPORT_TYPE_CHANNEL_ERR = 3;
    private static final int REPORT_TYPE_DESERIALIZE_ERR = 4;
    private static final int REPORT_TYPE_MSF_ERR = 5;
    private static final int REPORT_TYPE_OTHER_ERR = 7;
    private static final int REPORT_TYPE_PROXY_SERVICE_ERR = 2;
    private static final int REPORT_TYPE_SUCCESS = 0;
    private static final String TAG = "ICGameChatMsgService";
    private static final int TIME_OUT = 1002;
    private CopyOnWriteArraySet<y22.a> chatMsgReceiveListenerSet = new CopyOnWriteArraySet<>();
    private t32.b normalMsgPushReceiver;
    private IQQLiveSDK sdkImpl;

    private LiveMessageData convertBroadCastMsgToMessageData(vy0.a aVar) {
        LiveMessageData liveMessageData = new LiveMessageData();
        liveMessageData.mMessageType = 1;
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        i iVar = aVar.f443673a;
        speakerInfo.mSpeakId = iVar.f443700a;
        speakerInfo.mSpeakerName = iVar.f443701b;
        speakerInfo.mLogo = iVar.f443702c;
        speakerInfo.mQunNick = iVar.f443703d;
        speakerInfo.mBusinessUid = iVar.f443704e;
        speakerInfo.mClientType = aVar.f443675c;
        liveMessageData.mSpeakerInfo = speakerInfo;
        ArrayList<LiveMessageData.MsgElement> arrayList = new ArrayList<>();
        ArrayList<LiveMessageData.ExtData> arrayList2 = new ArrayList<>();
        for (vy0.e eVar : aVar.f443674b.f443682a) {
            LiveMessageData.MsgElement msgElement = new LiveMessageData.MsgElement();
            LiveMessageData.TextElement textElement = new LiveMessageData.TextElement();
            LiveMessageData.ImageElement imageElement = new LiveMessageData.ImageElement();
            h hVar = eVar.f443686b;
            if (hVar != null) {
                byte[] bArr = hVar.f443699a;
                textElement.mText = bArr;
                try {
                    textElement.strText = new String(bArr, "utf-16LE");
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 4, "get 0x21 chat message push message" + textElement.strText);
                    }
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "convertBroadCastMsgToMessageData error:" + e16.getMessage());
                    textElement.strText = "";
                }
            }
            vy0.c cVar = eVar.f443687c;
            if (cVar != null) {
                imageElement.mImageUrl = cVar.f443681a;
            }
            msgElement.mElementType = eVar.f443685a;
            msgElement.mHideLogo = eVar.f443688d;
            msgElement.mTextMsg = textElement;
            msgElement.mImageMsg = imageElement;
            arrayList.add(msgElement);
        }
        for (vy0.b bVar : aVar.f443674b.f443683b) {
            LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
            extData.mId = bVar.f443678a;
            extData.mValue = bVar.f443679b;
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
            return convertBroadCastMsgToMessageData(vy0.a.c(bArr));
        } catch (InvalidProtocolBufferNanoException e16) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "convertChatPbDataToChatMessage error:" + e16.getMessage());
            return liveMessageData;
        }
    }

    private String getAccountStr() {
        AppInterface a16 = t42.d.a();
        if (a16 == null) {
            return null;
        }
        return a16.getAccount();
    }

    private void initNormalChatMsgListener(final IQQLiveSDK iQQLiveSDK) {
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            return;
        }
        this.normalMsgPushReceiver = aVar.b().b(33, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveChatMsgServiceImpl.1
            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                if (iQQLiveSDK.getLoginModule() != null && iQQLiveSDK.getLoginModule().getLoginInfo() != null) {
                    LiveMessageData convertChatPbDataToChatMessage = QQLiveChatMsgServiceImpl.this.convertChatPbDataToChatMessage(bArr);
                    long j3 = iQQLiveSDK.getLoginModule().getLoginInfo().uid;
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
                            ((y22.a) it.next()).a(convertChatPbDataToChatMessage);
                        }
                        return;
                    }
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "parse data failed!!!");
                    return;
                }
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(QQLiveChatMsgServiceImpl.TAG, "initNormalChatMsgListener:loginModule == null or loginInfo == null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reportSendMessageResult(int i3, int i16, String str) {
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK == null) {
            return false;
        }
        String appId = iQQLiveSDK.getAppId();
        String accountStr = getAccountStr();
        if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(accountStr)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_code", String.valueOf(i16));
            hashMap.put(AudienceReportConst.EVENT_MSG, str);
            hashMap.put("ext1", String.valueOf(i3));
            com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_message_send_error", hashMap);
            return true;
        }
        QLog.e(TAG, 1, "reportErrorCode get UIN null");
        return false;
    }

    private void sendMessageReq(LiveMessageData liveMessageData, byte[] bArr, final IQQLiveMessageCallback iQQLiveMessageCallback) {
        ((com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module")).f(QQ_SEND_MSG_CMD, QQ_SEND_MSG_SUBCMD, bArr, new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveChatMsgServiceImpl.2
            @Override // com.tencent.mobileqq.icgame.sso.g
            public void onReceive(int i3, boolean z16, com.tencent.mobileqq.icgame.sso.i iVar) {
                int resultCode;
                String str;
                if (iQQLiveMessageCallback == null) {
                    return;
                }
                if (iVar == null) {
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onReceive rspData null");
                    QQLiveChatMsgServiceImpl.this.reportSendMessageResult(3, -1, "rspData null");
                    return;
                }
                if (iVar.e() == null) {
                    int resultCode2 = iVar.h().getResultCode();
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onReceive data null,errorCode:" + resultCode2);
                    QQLiveChatMsgServiceImpl.this.reportSendMessageResult(3, -1, "data null,errorCode:" + resultCode2);
                    return;
                }
                if (z16) {
                    try {
                        vy0.g c16 = vy0.g.c(iVar.e());
                        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(QQLiveChatMsgServiceImpl.TAG, "onReceive send result, respCode:" + c16.f443696a + ", errMsg:" + c16.f443697b);
                        int i16 = c16.f443696a;
                        if (i16 == 0) {
                            iQQLiveMessageCallback.onSuccess(false);
                        } else if (i16 == 10002) {
                            iQQLiveMessageCallback.onUserForbid(c16.f443697b);
                        } else if (i16 == 10003) {
                            iQQLiveMessageCallback.onIllegalMsg();
                        } else {
                            iQQLiveMessageCallback.onFail(i16, c16.f443697b);
                        }
                        int i17 = c16.f443696a;
                        if (i17 != 0) {
                            QQLiveChatMsgServiceImpl.this.reportSendMessageResult(1, i17, c16.f443697b);
                            return;
                        } else {
                            QQLiveChatMsgServiceImpl.this.reportSendMessageResult(0, i17, c16.f443697b);
                            return;
                        }
                    } catch (InvalidProtocolBufferNanoException unused) {
                        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onReceive data parse fail");
                        iQQLiveMessageCallback.onFail(-1, "QQLive Message onReceive data parse fail");
                        QQLiveChatMsgServiceImpl.this.reportSendMessageResult(4, -2, "data parse fail");
                        return;
                    }
                }
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(QQLiveChatMsgServiceImpl.TAG, "sendMessageReq receive, not success");
                int i18 = 5;
                if (iVar.h().getResultCode() != 1002 && iVar.h().getResultCode() != 1003) {
                    if (iVar.h().getResultCode() != 1000) {
                        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onError msf error");
                        str = "msf error";
                        iQQLiveMessageCallback.onFail(iVar.h().getResultCode(), "msf error");
                        resultCode = iVar.h().getResultCode();
                    } else {
                        i18 = 7;
                        resultCode = -3;
                        str = "other error";
                    }
                } else {
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onError Time out");
                    iQQLiveMessageCallback.onFail(iVar.h().getResultCode(), "time out");
                    resultCode = iVar.h().getResultCode();
                    str = "Time out";
                }
                if (iVar.g() != 0) {
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onError proxy service err " + iVar.g());
                    iQQLiveMessageCallback.onFail(iVar.g(), "proxy service err " + iVar.f());
                    resultCode = iVar.g();
                    i18 = 2;
                    str = "proxy service err";
                }
                if (iVar.b() != 0) {
                    ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(QQLiveChatMsgServiceImpl.TAG, "onError business service err " + iVar.b());
                    iQQLiveMessageCallback.onFail(iVar.b(), "business service err " + iVar.f());
                    resultCode = iVar.b();
                    i18 = 6;
                    str = "business service err";
                }
                QQLiveChatMsgServiceImpl.this.reportSendMessageResult(i18, resultCode, str);
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
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "sendToLocalScreen exception:" + e16);
            }
        }
        Iterator<y22.a> it5 = this.chatMsgReceiveListenerSet.iterator();
        while (it5.hasNext()) {
            it5.next().a(liveMessageData);
        }
        iQQLiveMessageCallback.onSuccess(true);
    }

    private void sendToServer(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback) {
        if (liveMessageData != null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(TAG, "sendToServer");
            f fVar = new f();
            fVar.f443690a = liveMessageData.mMainRoomId;
            fVar.f443691b = liveMessageData.mSubRoomId;
            vy0.d dVar = new vy0.d();
            ArrayList arrayList = new ArrayList();
            Iterator<LiveMessageData.MsgElement> it = liveMessageData.msgContent.mMsgElements.iterator();
            while (it.hasNext()) {
                LiveMessageData.MsgElement next = it.next();
                vy0.e eVar = new vy0.e();
                eVar.f443685a = 1;
                h hVar = new h();
                hVar.f443699a = next.mTextMsg.mText;
                eVar.f443686b = hVar;
                arrayList.add(eVar);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<LiveMessageData.ExtData> it5 = liveMessageData.msgContent.mExtDatas.iterator();
            while (it5.hasNext()) {
                LiveMessageData.ExtData next2 = it5.next();
                vy0.b bVar = new vy0.b();
                bVar.f443678a = next2.mId;
                bVar.f443679b = next2.mValue;
                arrayList2.add(bVar);
            }
            dVar.f443682a = (vy0.e[]) arrayList.toArray(new vy0.e[arrayList.size()]);
            dVar.f443683b = (vy0.b[]) arrayList2.toArray(new vy0.b[arrayList2.size()]);
            fVar.f443692c = dVar;
            sendMessageReq(liveMessageData, MessageNano.toByteArray(fVar), iQQLiveMessageCallback);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveChatMsgService
    public void addChatMessageListener(y22.a aVar) {
        if (aVar != null) {
            this.chatMsgReceiveListenerSet.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveChatMsgService
    public void delChatMessageListener(y22.a aVar) {
        if (aVar != null) {
            this.chatMsgReceiveListenerSet.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(TAG, "QQLiveChatMsgServiceImpl destroy");
        t32.b bVar = this.normalMsgPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.chatMsgReceiveListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdkImpl = iQQLiveSDK;
        if (iQQLiveSDK != null) {
            initNormalChatMsgListener(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        QLog.d(TAG, 4, "IQQLiveChatMsgService reset");
        t32.b bVar = this.normalMsgPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.chatMsgReceiveListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveChatMsgService
    public void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback) {
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK != null) {
            t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
            LiveMessageData liveMessageData = new LiveMessageData();
            if (aVar != null) {
                liveMessageData.mMainRoomId = (int) aVar.getRoomId();
                liveMessageData.mSubRoomId = (int) aVar.getRoomId();
            }
            liveMessageData.mMessageType = 1;
            liveMessageData.mSpeakerInfo.mSpeakId = this.sdkImpl.getLoginModule().getLoginInfo().uid;
            liveMessageData.mSpeakerInfo.mBusinessUid = this.sdkImpl.getLoginModule().getLoginInfo().businessUid;
            LiveUserInfo userInfo = this.sdkImpl.getLoginModule().getUserInfo();
            if (userInfo != null) {
                LiveMessageData.SpeakerInfo speakerInfo = liveMessageData.mSpeakerInfo;
                speakerInfo.mSpeakerName = userInfo.nick;
                speakerInfo.mLogo = userInfo.headUrl;
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
            } catch (UnsupportedEncodingException e16) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "sendMessage exception:" + e16);
            }
            sendMessage(liveMessageData, iQQLiveMessageCallback, 0);
            return;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "sendMessage error, sdkImpl is null.");
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveChatMsgService
    public void sendMessage(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback, int i3) {
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
