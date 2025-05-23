package com.tencent.mobileqq.icgame.api.impl.room;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IAudienceList;
import com.tencent.mobileqq.icgame.data.room.LiveRoomUserNumInfo;
import com.tencent.mobileqq.icgame.sso.h;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.qphone.base.util.QLog;
import py0.f;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AudienceListImpl implements IAudienceList {
    private static final String QQ_LIVE_AUDIENCE_NUMBER_CMD = "GetMemberNumber";
    private static final String QQ_LIVE_USER_LIST_SERVICE = "trpc.icggame.room_dispatch.RoomDispatch";
    private static final String TAG = "ICGameAudienceListService";
    private IQQLiveSDK sdk;

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        QLog.d(TAG, 4, "AudienceListImpl destroy");
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceList
    public void getUserNumber(long j3, a32.b bVar) {
        if (this.sdk == null) {
            QLog.e(TAG, 4, "getUserNumber sdk is null");
            return;
        }
        py0.c cVar = new py0.c();
        cVar.f428048a = j3;
        com.tencent.mobileqq.icgame.sso.c cVar2 = (com.tencent.mobileqq.icgame.sso.c) this.sdk.getExtModule("sso_module");
        if (cVar2 == null) {
            QLog.e(TAG, 4, "getUserNumber get sso module null");
        } else {
            cVar2.f(QQ_LIVE_USER_LIST_SERVICE, QQ_LIVE_AUDIENCE_NUMBER_CMD, MessageNano.toByteArray(cVar), new h(new com.tencent.mobileqq.icgame.sso.a(bVar) { // from class: com.tencent.mobileqq.icgame.api.impl.room.AudienceListImpl.1
                final /* synthetic */ a32.b val$callback;

                @Override // com.tencent.mobileqq.icgame.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
                public void onFailed(int i3, String str) {
                    super.onFailed(i3, str);
                }

                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onProxyRequestSuccess(int i3, i iVar) {
                    try {
                        py0.d c16 = py0.d.c(iVar.e());
                        new LiveRoomUserNumInfo();
                        f fVar = c16.f428049a;
                    } catch (InvalidProtocolBufferNanoException e16) {
                        e16.printStackTrace();
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdk = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        QLog.d(TAG, 4, "AudienceListImpl reset");
    }
}
