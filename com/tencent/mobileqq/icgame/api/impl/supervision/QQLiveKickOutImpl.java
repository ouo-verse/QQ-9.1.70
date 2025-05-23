package com.tencent.mobileqq.icgame.api.impl.supervision;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.icgame.sso.c;
import com.tencent.mobileqq.icgame.sso.h;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.data.supervision.KickOutHistoryListData;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import com.tencent.mobileqq.qqlive.utils.n;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.Charsets;
import oy0.a;
import oy0.d;
import oy0.e;
import oy0.f;
import oy0.g;
import t32.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveKickOutImpl extends SuperVisionImpl implements IQQLiveModuleKickOut {
    private static final String CANCEL_KICK_OUT_USER_METHOD = "CancelKickOutSomebody";
    private static final int KICK_OUT_MESSAGE_CMD = 254;
    private static final String KICK_OUT_USER_METHOD = "KickOutSomebody";
    private static final String QUERY_KICK_OUT_USER_HISTORY_METHOD = "GetKickOutUser";
    private static final String TAG = "ICGameKickOutImpl";
    private b kickOutReceiver;
    private final List<ki2.b> listeners = new CopyOnWriteArrayList();

    @Override // com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut
    public void addKickedOutOfRoomListener(ki2.b bVar) {
        if (!this.listeners.contains(bVar)) {
            this.listeners.add(bVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut
    public void cancelKickOutUser(long j3, long j16, final long j17, final KickOutUserCallback kickOutUserCallback) {
        a aVar = new a();
        aVar.f424468b = j3;
        aVar.f424467a = j16;
        aVar.f424469c = this.sdkImpl.getLoginModule().getUserInfo().uid;
        aVar.f424470d = j17;
        ((c) this.sdkImpl.getExtModule("sso_module")).f(SuperVisionImpl.SERVICE_NAME, CANCEL_KICK_OUT_USER_METHOD, MessageNano.toByteArray(aVar), new h(new com.tencent.mobileqq.icgame.sso.a() { // from class: com.tencent.mobileqq.icgame.api.impl.supervision.QQLiveKickOutImpl.3
            @Override // com.tencent.mobileqq.icgame.sso.a
            public void onBusinessFailed(int i3, String str) {
                super.onBusinessFailed(i3, str);
                kickOutUserCallback.onFailed(i3, str);
            }

            @Override // com.tencent.mobileqq.icgame.sso.a
            public void onProxyRequestSuccess(int i3, i iVar) throws InvalidProtocolBufferNanoException {
                oy0.b c16 = oy0.b.c(iVar.e());
                int i16 = c16.f424471a;
                if (i16 == 0) {
                    kickOutUserCallback.onSuccess(j17);
                } else {
                    kickOutUserCallback.onFailed(i16, c16.f424472b);
                }
            }
        }));
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.kickOutReceiver.a();
        this.listeners.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut
    public List<AdminReason> getKickOutReasonList() {
        return this.reasonList;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.supervision.SuperVisionImpl
    public int getReasonFlag() {
        return 2;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.supervision.SuperVisionImpl, com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        super.init(iQQLiveSDK);
        this.kickOutReceiver = ((t32.a) iQQLiveSDK.getExtModule("roomPush")).b().b(254, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.supervision.QQLiveKickOutImpl.1
            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                if (i3 != 254) {
                    return;
                }
                try {
                    g c16 = g.c(bArr);
                    if (c16 != null) {
                        QLog.d(QQLiveKickOutImpl.TAG, 1, "receive a push msg kick out msg 254");
                        String str = new String(c16.f424488a, Charsets.UTF_8);
                        if (!TextUtils.isEmpty(str)) {
                            Iterator it = QQLiveKickOutImpl.this.listeners.iterator();
                            while (it.hasNext()) {
                                ((ki2.b) it.next()).a(str);
                            }
                        }
                    }
                } catch (InvalidProtocolBufferNanoException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut
    public void kickOutUser(long j3, long j16, final long j17, int i3, final KickOutUserCallback kickOutUserCallback) {
        e eVar = new e();
        eVar.f424482b = j3;
        eVar.f424481a = j16;
        eVar.f424483c = this.sdkImpl.getLoginModule().getUserInfo().uid;
        eVar.f424485e = i3;
        eVar.f424484d = j17;
        ((c) this.sdkImpl.getExtModule("sso_module")).f(SuperVisionImpl.SERVICE_NAME, KICK_OUT_USER_METHOD, MessageNano.toByteArray(eVar), new h(new com.tencent.mobileqq.icgame.sso.a() { // from class: com.tencent.mobileqq.icgame.api.impl.supervision.QQLiveKickOutImpl.2
            @Override // com.tencent.mobileqq.icgame.sso.a
            public void onBusinessFailed(int i16, String str) {
                super.onBusinessFailed(i16, str);
                kickOutUserCallback.onFailed(i16, str);
            }

            @Override // com.tencent.mobileqq.icgame.sso.a
            public void onProxyRequestSuccess(int i16, i iVar) throws InvalidProtocolBufferNanoException {
                f c16 = f.c(iVar.e());
                int i17 = c16.f424486a;
                if (i17 == 0) {
                    kickOutUserCallback.onSuccess(j17);
                } else {
                    kickOutUserCallback.onFailed(i17, c16.f424487b);
                }
            }
        }));
    }

    @Override // com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut
    public void queryKickOutHistory(long j3, int i3, int i16, c32.a aVar) {
        oy0.c cVar = new oy0.c();
        cVar.f424473a = j3;
        cVar.f424474b = i3;
        cVar.f424475c = i16;
        ((c) this.sdkImpl.getExtModule("sso_module")).f(SuperVisionImpl.SERVICE_NAME, QUERY_KICK_OUT_USER_HISTORY_METHOD, MessageNano.toByteArray(cVar), new h(new com.tencent.mobileqq.icgame.sso.a(aVar) { // from class: com.tencent.mobileqq.icgame.api.impl.supervision.QQLiveKickOutImpl.4
            final /* synthetic */ c32.a val$callback;

            @Override // com.tencent.mobileqq.icgame.sso.a
            public void onBusinessFailed(int i17, String str) {
                super.onBusinessFailed(i17, str);
                throw null;
            }

            @Override // com.tencent.mobileqq.icgame.sso.a
            public void onProxyRequestSuccess(int i17, i iVar) throws InvalidProtocolBufferNanoException {
                d c16 = d.c(iVar.e());
                KickOutHistoryListData kickOutHistoryListData = new KickOutHistoryListData();
                for (oy0.h hVar : c16.f424478c) {
                    LimitUserInfo limitUserInfo = new LimitUserInfo();
                    limitUserInfo.headUrl = hVar.f424490a;
                    limitUserInfo.nick = hVar.f424491b;
                    limitUserInfo.opTime = hVar.f424493d;
                    limitUserInfo.sex = n.a(hVar.f424492c);
                    limitUserInfo.uid = hVar.f424494e;
                    kickOutHistoryListData.list.add(limitUserInfo);
                }
                kickOutHistoryListData.isEnd = n.b(c16.f424480e);
                kickOutHistoryListData.sum = c16.f424479d;
                throw null;
            }
        }));
    }

    @Override // com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut
    public void removeKickedOutOfRoomListener(ki2.b bVar) {
        if (bVar != null) {
            this.listeners.remove(bVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
