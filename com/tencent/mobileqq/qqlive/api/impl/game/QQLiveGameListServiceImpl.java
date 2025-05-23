package com.tencent.mobileqq.qqlive.api.impl.game;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.sso.c;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.qphone.base.util.QLog;
import gr4.g;
import gr4.h;
import java.util.ArrayList;
import rq4.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveGameListServiceImpl extends f implements IQQLiveGameListService {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_NOTIFY_TYPE_GET_GAME = 310;
    private static final String QQ_LIVE_GET_GAME_LIST_CMD = "trpc.qlive.qlive_room_play_svr.QliveRoomPlaySvr";
    private static final String QQ_LIVE_GET_GAME_LIST_METHOD = "GetGamePanel";
    private static final String TAG = "IQQLiveGameListService";
    private IQQLiveGameListCallback gameListCallback;
    private IQQLiveSDK sdk;

    public QQLiveGameListServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ArrayList<QQLiveAnchorRoomGameInfo> convertGameItem(h hVar) {
        ArrayList<QQLiveAnchorRoomGameInfo> arrayList = new ArrayList<>();
        for (a aVar : hVar.f403128c) {
            QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
            qQLiveAnchorRoomGameInfo.f271211id = aVar.f431964a;
            qQLiveAnchorRoomGameInfo.name = aVar.f431965b;
            qQLiveAnchorRoomGameInfo.icon = aVar.f431966c;
            qQLiveAnchorRoomGameInfo.secondTagId = aVar.f431967d;
            arrayList.add(qQLiveAnchorRoomGameInfo);
        }
        return arrayList;
    }

    private boolean onGetGameListFail(com.tencent.mobileqq.qqlive.sso.h hVar) {
        if (this.gameListCallback == null) {
            QLog.e(TAG, 4, "gameListCallback is null");
            return true;
        }
        if (hVar != null && hVar.e() != null) {
            if (hVar.b() != 0) {
                this.gameListCallback.onError(hVar.b(), hVar.c());
                return true;
            }
            return false;
        }
        this.gameListCallback.onError(-1, "the data is null");
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveGameListService destroy");
        }
        this.gameListCallback = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService
    public void getGameList(IQQLiveGameListCallback iQQLiveGameListCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveGameListCallback);
            return;
        }
        this.gameListCallback = iQQLiveGameListCallback;
        IQQLiveSDK iQQLiveSDK = this.sdk;
        if (iQQLiveSDK == null) {
            QLog.e(TAG, 4, "sdk is null");
            return;
        }
        c cVar = (c) iQQLiveSDK.getExtModule("sso_module");
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
                return;
            }
            return;
        }
        cVar.g(QQ_LIVE_GET_GAME_LIST_CMD, QQ_LIVE_GET_GAME_LIST_METHOD, MessageNano.toByteArray(new g()), 310, this);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdk = iQQLiveSDK;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sso.f
    public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
            return;
        }
        if (z16 && i3 == 310) {
            if (onGetGameListFail(hVar)) {
                QLog.e(TAG, 4, "onFollowAnchorFail fail");
                return;
            }
            try {
                h c16 = h.c(hVar.e());
                int i16 = c16.f403126a;
                if (i16 == 0) {
                    this.gameListCallback.onSuccess(convertGameItem(c16));
                } else {
                    this.gameListCallback.onError(i16, c16.f403127b);
                }
            } catch (InvalidProtocolBufferNanoException e16) {
                this.gameListCallback.onError(-1, "parse GameItem error");
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "IQQLiveGameListService reset");
        }
        this.gameListCallback = null;
    }
}
