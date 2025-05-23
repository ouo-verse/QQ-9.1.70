package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import hr4.f;
import hr4.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveFollowMsgServiceImpl implements IQQLiveFollowMsgService {
    static IPatchRedirector $redirector_ = null;
    private static final int FOLLOW_MESSAGE_CMD = 19;
    private static final int FOLLOW_ROOM_CMD = 165;
    private static final String QQ_LIVE_CHK_FOLLOW_METHOD = "ChkFollow";
    private static final String QQ_LIVE_FOLLOW_CMD = "trpc.qlive.relationchain_svr.RelationchainSvr";
    private static final String QQ_LIVE_FOLLOW_METHOD = "Follow";
    private static final String QQ_LIVE_GET_FOLLOW_LIST_METHOD = "GetFollowList";
    private static final String QQ_LIVE_UNFOLLOW_METHOD = "UnFollow";
    private static final String TAG = "IQQLiveFollowMsgService";
    private ni2.c followPushReceiver;
    private ni2.c followRoomPushReceiver;
    private IAegisLogApi mAegisLog;
    private CopyOnWriteArraySet<IQQLiveReceiveFollowListener> receiveFollowListenerSet;
    private CopyOnWriteArraySet<IQQLiveReceiveFollowListener> receiveFollowRoomListenerSet;
    private IQQLiveSDK sdkImpl;

    public QQLiveFollowMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.receiveFollowListenerSet = new CopyOnWriteArraySet<>();
        this.receiveFollowRoomListenerSet = new CopyOnWriteArraySet<>();
        this.mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    }

    private void handleFollowMsg(gp4.a aVar) throws InvalidProtocolBufferNanoException {
        f c16 = f.c(aVar.f403049c);
        FollowPushMessage followPushMessage = new FollowPushMessage();
        followPushMessage.uid = c16.f406107a;
        followPushMessage.nick = c16.f406108b;
        followPushMessage.toUid = c16.f406109c;
        followPushMessage.icon = c16.f406111e;
        if (c16.f406110d == 0) {
            followPushMessage.type = 0;
        } else {
            followPushMessage.type = 1;
        }
        Iterator<IQQLiveReceiveFollowListener> it = this.receiveFollowListenerSet.iterator();
        while (it.hasNext()) {
            it.next().onFollowReceive(followPushMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFollowRoomMsg(byte[] bArr) throws InvalidProtocolBufferNanoException {
        qq3.a c16 = qq3.a.c(bArr);
        FollowPushMessage followPushMessage = new FollowPushMessage();
        followPushMessage.nick = c16.f429280c;
        followPushMessage.uid = c16.f429279b;
        if (c16.f429278a == 0) {
            followPushMessage.type = 0;
        } else {
            followPushMessage.type = 1;
        }
        Iterator<IQQLiveReceiveFollowListener> it = this.receiveFollowRoomListenerSet.iterator();
        while (it.hasNext()) {
            it.next().onFollowReceive(followPushMessage);
        }
    }

    private void initFollowMsgListener(IQQLiveSDK iQQLiveSDK) {
        ni2.b bVar = (ni2.b) iQQLiveSDK.getExtModule("roomPush");
        if (bVar == null) {
            this.mAegisLog.e(TAG, "initFollowMsgListener get IQQLiveRoomPushService null");
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.followPushReceiver = bVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.c
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveFollowMsgServiceImpl.this.lambda$initFollowMsgListener$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
        this.followRoomPushReceiver = bVar.b().b(165, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveFollowMsgServiceImpl.this);
                }
            }

            @Override // ni2.a
            public void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i16), bArr, liveMsgExtInfo);
                    return;
                }
                if (bArr != null) {
                    try {
                        QQLiveFollowMsgServiceImpl.this.handleFollowRoomMsg(bArr);
                        return;
                    } catch (InvalidProtocolBufferNanoException unused) {
                        QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "initFollowMsgListener followRoomPushReceiver QQLive LiveFollowPushMsg onReceive data parse fail");
                        Iterator it = QQLiveFollowMsgServiceImpl.this.receiveFollowListenerSet.iterator();
                        while (it.hasNext()) {
                            ((IQQLiveReceiveFollowListener) it.next()).onFail(-1, "followRoomPushReceiver QQLive LiveFollowPushMsg onReceive data parse fail");
                        }
                        return;
                    }
                }
                QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "initFollowMsgListener followRoomPushReceiver get push data null");
                Iterator it5 = QQLiveFollowMsgServiceImpl.this.receiveFollowListenerSet.iterator();
                while (it5.hasNext()) {
                    ((IQQLiveReceiveFollowListener) it5.next()).onFail(-1, "followPushReceiver get push data null");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFollowMsgListener$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            this.mAegisLog.e(TAG, "initFollowMsgListener get push data null");
            Iterator<IQQLiveReceiveFollowListener> it = this.receiveFollowListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onFail(-1, "followPushReceiver get push data null");
            }
            return;
        }
        try {
            gp4.a c16 = gp4.a.c(bArr);
            if (c16.f403047a == 19) {
                handleFollowMsg(c16);
            }
        } catch (InvalidProtocolBufferNanoException unused) {
            this.mAegisLog.e(TAG, "initFollowMsgListener QQLive LiveFollowPushMsg onReceive data parse fail");
            Iterator<IQQLiveReceiveFollowListener> it5 = this.receiveFollowListenerSet.iterator();
            while (it5.hasNext()) {
                it5.next().onFail(-1, "initFollowMsgListener QQLive LiveFollowPushMsg onReceive data parse fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onCheckFollowAnchorFail(IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback, h hVar) {
        if (iQQLiveCheckFollowCallback == null) {
            this.mAegisLog.e(TAG, "checkFollowCallback is null");
            return true;
        }
        if (hVar != null && hVar.e() != null) {
            if (hVar.b() != 0) {
                iQQLiveCheckFollowCallback.onFail(hVar.b(), hVar.c());
                this.mAegisLog.e(TAG, "onCheckFollowAnchorFail errCode=" + hVar.b() + ",errMsg=" + hVar.c());
                return true;
            }
            return false;
        }
        iQQLiveCheckFollowCallback.onFail(-1, "the data is null");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onFollowAnchorFail(IQQLiveFollowCallback iQQLiveFollowCallback, h hVar) {
        if (iQQLiveFollowCallback == null) {
            this.mAegisLog.e(TAG, "onFollowAnchorFail  callback is null");
            return true;
        }
        if (hVar != null && hVar.e() != null) {
            if (hVar.b() != 0) {
                iQQLiveFollowCallback.onFail(hVar.b(), hVar.c());
                this.mAegisLog.e(TAG, "onFollowAnchorFail errCode=" + hVar.b() + ",errMsg=" + hVar.c());
                return true;
            }
            return false;
        }
        iQQLiveFollowCallback.onFail(-1, "the data is null");
        this.mAegisLog.e(TAG, "onFollowAnchorFail  the data is null");
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void addFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowListenerSet.add(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void addFollowRoomListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowRoomListenerSet.add(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void checkFollowAnchor(long j3, IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), iQQLiveCheckFollowCallback);
            return;
        }
        this.mAegisLog.i(TAG, "checkFollowAnchor send anchorId=" + j3 + ",sdkImpl=" + this.sdkImpl);
        if (this.sdkImpl != null) {
            hr4.a aVar = new hr4.a();
            aVar.f406096a = j3;
            com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                this.mAegisLog.e(TAG, "checkFollowAnchor get IQQLiveRoomPushService null");
            } else {
                cVar.f(QQ_LIVE_FOLLOW_CMD, QQ_LIVE_CHK_FOLLOW_METHOD, MessageNano.toByteArray(aVar), new com.tencent.mobileqq.qqlive.sso.f(iQQLiveCheckFollowCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IQQLiveCheckFollowCallback val$checkFollowCallback;

                    {
                        this.val$checkFollowCallback = iQQLiveCheckFollowCallback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFollowMsgServiceImpl.this, (Object) iQQLiveCheckFollowCallback);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.sso.f
                    public void onReceive(int i3, boolean z16, h hVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQLiveFollowMsgServiceImpl.this.mAegisLog.i(QQLiveFollowMsgServiceImpl.TAG, "checkFollowAnchor onReceive type=" + i3 + ",isSuccess=" + z16);
                            if (z16) {
                                if (QQLiveFollowMsgServiceImpl.this.onCheckFollowAnchorFail(this.val$checkFollowCallback, hVar)) {
                                    QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "checkFollowAnchor onCheckFollowAnchorFail fail");
                                    return;
                                }
                                try {
                                    this.val$checkFollowCallback.onSuccess(hr4.b.c(hVar.e()).f406097a);
                                    return;
                                } catch (InvalidProtocolBufferNanoException e16) {
                                    this.val$checkFollowCallback.onFail(-1, "ChkFollowRsp parse fail");
                                    QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "checkFollowAnchor ChkFollowRsp error:" + e16.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void delFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowListenerSet.remove(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void delFollowRoomListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowRoomListenerSet.remove(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mAegisLog.i(TAG, "IQQLiveFollowMsgService destroy");
        ni2.c cVar = this.followPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        ni2.c cVar2 = this.followRoomPushReceiver;
        if (cVar2 != null) {
            cVar2.a();
        }
        this.receiveFollowListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void followAnchor(long j3, long j16, IQQLiveFollowCallback iQQLiveFollowCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16), iQQLiveFollowCallback);
            return;
        }
        this.mAegisLog.i(TAG, "followAnchor send anchorId=" + j3 + ",roomId=" + j16 + ",sdkImpl=" + this.sdkImpl);
        if (this.sdkImpl != null) {
            hr4.c cVar = new hr4.c();
            cVar.f406098a = j3;
            cVar.f406099b = j16;
            com.tencent.mobileqq.qqlive.sso.c cVar2 = (com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar2 == null) {
                this.mAegisLog.e(TAG, "followAnchor get IQQLiveRoomPushService null");
            } else {
                cVar2.f(QQ_LIVE_FOLLOW_CMD, QQ_LIVE_FOLLOW_METHOD, MessageNano.toByteArray(cVar), new com.tencent.mobileqq.qqlive.sso.f(iQQLiveFollowCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IQQLiveFollowCallback val$followCallback;

                    {
                        this.val$followCallback = iQQLiveFollowCallback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFollowMsgServiceImpl.this, (Object) iQQLiveFollowCallback);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.sso.f
                    public void onReceive(int i3, boolean z16, h hVar) {
                        String str;
                        int i16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQLiveFollowMsgServiceImpl.this.mAegisLog.i(QQLiveFollowMsgServiceImpl.TAG, "followAnchor onReceive type=" + i3 + ",isSuccess=" + z16);
                            if (z16) {
                                if (QQLiveFollowMsgServiceImpl.this.onFollowAnchorFail(this.val$followCallback, hVar)) {
                                    QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "followAnchor onReceive onFollowAnchorFail fail");
                                    return;
                                } else {
                                    this.val$followCallback.onSuccess();
                                    return;
                                }
                            }
                            if (hVar != null) {
                                str = hVar.f();
                                i16 = hVar.g();
                            } else {
                                str = "";
                                i16 = Integer.MIN_VALUE;
                            }
                            QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "[followAnchor] request fail, code=" + i16 + ", msg=" + str);
                            IQQLiveFollowCallback iQQLiveFollowCallback2 = this.val$followCallback;
                            if (iQQLiveFollowCallback2 != null) {
                                iQQLiveFollowCallback2.onFail(i16, str);
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdkImpl = iQQLiveSDK;
            initFollowMsgListener(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mAegisLog.i(TAG, "IQQLiveFollowMsgService reset");
        ni2.c cVar = this.followPushReceiver;
        if (cVar != null) {
            cVar.a();
        }
        ni2.c cVar2 = this.followRoomPushReceiver;
        if (cVar2 != null) {
            cVar2.a();
        }
        this.receiveFollowListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
    public void unFollowAnchor(long j3, long j16, IQQLiveFollowCallback iQQLiveFollowCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Long.valueOf(j16), iQQLiveFollowCallback);
            return;
        }
        this.mAegisLog.i(TAG, "unFollowAnchor send anchorId=" + j3 + ",roomId=" + j16 + ",sdkImpl=" + this.sdkImpl);
        if (this.sdkImpl != null) {
            g gVar = new g();
            gVar.f406112a = j3;
            gVar.f406113b = j16;
            com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                this.mAegisLog.e(TAG, "unFollowAnchor get IQQLiveRoomPushService null");
            } else {
                cVar.f(QQ_LIVE_FOLLOW_CMD, QQ_LIVE_UNFOLLOW_METHOD, MessageNano.toByteArray(gVar), new com.tencent.mobileqq.qqlive.sso.f(iQQLiveFollowCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IQQLiveFollowCallback val$followCallback;

                    {
                        this.val$followCallback = iQQLiveFollowCallback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFollowMsgServiceImpl.this, (Object) iQQLiveFollowCallback);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.sso.f
                    public void onReceive(int i3, boolean z16, h hVar) {
                        String str;
                        int i16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQLiveFollowMsgServiceImpl.this.mAegisLog.i(QQLiveFollowMsgServiceImpl.TAG, "unFollowAnchor onReceive type=" + i3 + ",isSuccess=" + z16);
                            if (z16) {
                                if (QQLiveFollowMsgServiceImpl.this.onFollowAnchorFail(this.val$followCallback, hVar)) {
                                    QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "unFollowAnchor onFollowAnchorFail fail");
                                    return;
                                } else {
                                    this.val$followCallback.onSuccess();
                                    return;
                                }
                            }
                            if (hVar != null) {
                                str = hVar.f();
                                i16 = hVar.g();
                            } else {
                                str = "";
                                i16 = Integer.MIN_VALUE;
                            }
                            QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "[followAnchor] request fail, code=" + i16 + ", msg=" + str);
                            IQQLiveFollowCallback iQQLiveFollowCallback2 = this.val$followCallback;
                            if (iQQLiveFollowCallback2 != null) {
                                iQQLiveFollowCallback2.onFail(i16, str);
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    }
                });
            }
        }
    }
}
