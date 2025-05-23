package com.tencent.mobileqq.icgame.api.impl.message;

import bp4.f;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.sso.g;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveFollowMsgServiceImpl implements IQQLiveFollowMsgService {
    private static final int FOLLOW_MESSAGE_CMD = 19;
    private static final int FOLLOW_ROOM_CMD = 165;
    private static final String QQ_LIVE_CHK_FOLLOW_METHOD = "ChkFollow";
    private static final String QQ_LIVE_FOLLOW_CMD = "trpc.icggame.follow_relationchain_svr.RelationchainSvr";
    private static final String QQ_LIVE_FOLLOW_METHOD = "Follow";
    private static final String QQ_LIVE_GET_FOLLOW_LIST_METHOD = "GetFollowList";
    private static final String QQ_LIVE_UNFOLLOW_METHOD = "UnFollow";
    private static final String TAG = "ICGameIQQLiveFollowMsgService";
    private t32.b followPushReceiver;
    private t32.b followRoomPushReceiver;
    private IQQLiveSDK sdkImpl;
    private CopyOnWriteArraySet<IQQLiveReceiveFollowListener> receiveFollowListenerSet = new CopyOnWriteArraySet<>();
    private CopyOnWriteArraySet<IQQLiveReceiveFollowListener> receiveFollowRoomListenerSet = new CopyOnWriteArraySet<>();
    private IAegisLogApi mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    private void handleFollowMsg(cz0.a aVar) throws InvalidProtocolBufferNanoException {
        bp4.e c16 = bp4.e.c(aVar.f392435c);
        FollowPushMessage followPushMessage = new FollowPushMessage();
        followPushMessage.uid = c16.f28921a;
        followPushMessage.nick = c16.f28922b;
        followPushMessage.toUid = c16.f28923c;
        followPushMessage.icon = c16.f28925e;
        if (c16.f28924d == 0) {
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
        uy0.a c16 = uy0.a.c(bArr);
        FollowPushMessage followPushMessage = new FollowPushMessage();
        followPushMessage.nick = c16.f440584c;
        followPushMessage.uid = c16.f440583b;
        if (c16.f440582a == 0) {
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
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            this.mAegisLog.e(TAG, "initFollowMsgListener get IQQLiveRoomPushService null");
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.followPushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.c
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveFollowMsgServiceImpl.this.lambda$initFollowMsgListener$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
        this.followRoomPushReceiver = aVar.b().b(165, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveFollowMsgServiceImpl.1
            @Override // ni2.a
            public void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
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
            cz0.a c16 = cz0.a.c(bArr);
            if (c16.f392433a == 19) {
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
    public boolean onCheckFollowAnchorFail(IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback, i iVar) {
        if (iQQLiveCheckFollowCallback == null) {
            this.mAegisLog.e(TAG, "checkFollowCallback is null");
            return true;
        }
        if (iVar != null && iVar.e() != null) {
            if (iVar.b() != 0) {
                iQQLiveCheckFollowCallback.onFail(iVar.b(), iVar.c());
                this.mAegisLog.e(TAG, "onCheckFollowAnchorFail errCode=" + iVar.b() + ",errMsg=" + iVar.c());
                return true;
            }
            return false;
        }
        iQQLiveCheckFollowCallback.onFail(-1, "the data is null");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onFollowAnchorFail(IQQLiveFollowCallback iQQLiveFollowCallback, i iVar) {
        if (iQQLiveFollowCallback == null) {
            this.mAegisLog.e(TAG, "onFollowAnchorFail  callback is null");
            return true;
        }
        if (iVar != null && iVar.e() != null) {
            if (iVar.b() != 0) {
                iQQLiveFollowCallback.onFail(iVar.b(), iVar.c());
                this.mAegisLog.e(TAG, "onFollowAnchorFail errCode=" + iVar.b() + ",errMsg=" + iVar.c());
                return true;
            }
            return false;
        }
        iQQLiveFollowCallback.onFail(-1, "the data is null");
        this.mAegisLog.e(TAG, "onFollowAnchorFail  the data is null");
        return true;
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void addFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowListenerSet.add(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void addFollowRoomListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowRoomListenerSet.add(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void checkFollowAnchor(long j3, final IQQLiveCheckFollowCallback iQQLiveCheckFollowCallback) {
        this.mAegisLog.i(TAG, "checkFollowAnchor send anchorId=" + j3 + ",sdkImpl=" + this.sdkImpl);
        if (this.sdkImpl != null) {
            bp4.a aVar = new bp4.a();
            aVar.f28917a = j3;
            com.tencent.mobileqq.icgame.sso.c cVar = (com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                this.mAegisLog.e(TAG, "checkFollowAnchor get IQQLiveRoomPushService null");
            } else {
                cVar.f(QQ_LIVE_FOLLOW_CMD, QQ_LIVE_CHK_FOLLOW_METHOD, MessageNano.toByteArray(aVar), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveFollowMsgServiceImpl.4
                    @Override // com.tencent.mobileqq.icgame.sso.g
                    public void onReceive(int i3, boolean z16, i iVar) {
                        QQLiveFollowMsgServiceImpl.this.mAegisLog.i(QQLiveFollowMsgServiceImpl.TAG, "checkFollowAnchor onReceive type=" + i3 + ",isSuccess=" + z16);
                        if (z16) {
                            if (QQLiveFollowMsgServiceImpl.this.onCheckFollowAnchorFail(iQQLiveCheckFollowCallback, iVar)) {
                                QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "checkFollowAnchor onCheckFollowAnchorFail fail");
                                return;
                            }
                            try {
                                iQQLiveCheckFollowCallback.onSuccess(bp4.b.c(iVar.e()).f28918a);
                            } catch (InvalidProtocolBufferNanoException e16) {
                                iQQLiveCheckFollowCallback.onFail(-1, "ChkFollowRsp parse fail");
                                QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "checkFollowAnchor ChkFollowRsp error:" + e16.getMessage());
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void delFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowListenerSet.remove(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void delFollowRoomListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (iQQLiveReceiveFollowListener != null) {
            this.receiveFollowRoomListenerSet.remove(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.mAegisLog.i(TAG, "IQQLiveFollowMsgService destroy");
        t32.b bVar = this.followPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        t32.b bVar2 = this.followRoomPushReceiver;
        if (bVar2 != null) {
            bVar2.a();
        }
        this.receiveFollowListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void followAnchor(long j3, long j16, final IQQLiveFollowCallback iQQLiveFollowCallback) {
        this.mAegisLog.i(TAG, "followAnchor send anchorId=" + j3 + ",roomId=" + j16 + ",sdkImpl=" + this.sdkImpl);
        if (this.sdkImpl != null) {
            bp4.c cVar = new bp4.c();
            cVar.f28919a = j3;
            cVar.f28920b = j16;
            com.tencent.mobileqq.icgame.sso.c cVar2 = (com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar2 == null) {
                this.mAegisLog.e(TAG, "followAnchor get IQQLiveRoomPushService null");
            } else {
                cVar2.f(QQ_LIVE_FOLLOW_CMD, QQ_LIVE_FOLLOW_METHOD, MessageNano.toByteArray(cVar), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveFollowMsgServiceImpl.2
                    @Override // com.tencent.mobileqq.icgame.sso.g
                    public void onReceive(int i3, boolean z16, i iVar) {
                        String str;
                        int i16;
                        QQLiveFollowMsgServiceImpl.this.mAegisLog.i(QQLiveFollowMsgServiceImpl.TAG, "followAnchor onReceive type=" + i3 + ",isSuccess=" + z16);
                        if (z16) {
                            if (QQLiveFollowMsgServiceImpl.this.onFollowAnchorFail(iQQLiveFollowCallback, iVar)) {
                                QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "followAnchor onReceive onFollowAnchorFail fail");
                                return;
                            } else {
                                iQQLiveFollowCallback.onSuccess();
                                return;
                            }
                        }
                        if (iVar != null) {
                            str = iVar.f();
                            i16 = iVar.g();
                        } else {
                            str = "";
                            i16 = Integer.MIN_VALUE;
                        }
                        QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "[followAnchor] request fail, code=" + i16 + ", msg=" + str);
                        IQQLiveFollowCallback iQQLiveFollowCallback2 = iQQLiveFollowCallback;
                        if (iQQLiveFollowCallback2 != null) {
                            iQQLiveFollowCallback2.onFail(i16, str);
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdkImpl = iQQLiveSDK;
        initFollowMsgListener(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        this.mAegisLog.i(TAG, "IQQLiveFollowMsgService reset");
        t32.b bVar = this.followPushReceiver;
        if (bVar != null) {
            bVar.a();
        }
        t32.b bVar2 = this.followRoomPushReceiver;
        if (bVar2 != null) {
            bVar2.a();
        }
        this.receiveFollowListenerSet.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService
    public void unFollowAnchor(long j3, long j16, final IQQLiveFollowCallback iQQLiveFollowCallback) {
        this.mAegisLog.i(TAG, "unFollowAnchor send anchorId=" + j3 + ",roomId=" + j16 + ",sdkImpl=" + this.sdkImpl);
        if (this.sdkImpl != null) {
            f fVar = new f();
            fVar.f28926a = j3;
            fVar.f28927b = j16;
            com.tencent.mobileqq.icgame.sso.c cVar = (com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                this.mAegisLog.e(TAG, "unFollowAnchor get IQQLiveRoomPushService null");
            } else {
                cVar.f(QQ_LIVE_FOLLOW_CMD, QQ_LIVE_UNFOLLOW_METHOD, MessageNano.toByteArray(fVar), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveFollowMsgServiceImpl.3
                    @Override // com.tencent.mobileqq.icgame.sso.g
                    public void onReceive(int i3, boolean z16, i iVar) {
                        String str;
                        int i16;
                        QQLiveFollowMsgServiceImpl.this.mAegisLog.i(QQLiveFollowMsgServiceImpl.TAG, "unFollowAnchor onReceive type=" + i3 + ",isSuccess=" + z16);
                        if (z16) {
                            if (QQLiveFollowMsgServiceImpl.this.onFollowAnchorFail(iQQLiveFollowCallback, iVar)) {
                                QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "unFollowAnchor onFollowAnchorFail fail");
                                return;
                            } else {
                                iQQLiveFollowCallback.onSuccess();
                                return;
                            }
                        }
                        if (iVar != null) {
                            str = iVar.f();
                            i16 = iVar.g();
                        } else {
                            str = "";
                            i16 = Integer.MIN_VALUE;
                        }
                        QQLiveFollowMsgServiceImpl.this.mAegisLog.e(QQLiveFollowMsgServiceImpl.TAG, "[followAnchor] request fail, code=" + i16 + ", msg=" + str);
                        IQQLiveFollowCallback iQQLiveFollowCallback2 = iQQLiveFollowCallback;
                        if (iQQLiveFollowCallback2 != null) {
                            iQQLiveFollowCallback2.onFail(i16, str);
                        }
                    }
                });
            }
        }
    }
}
