package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterArkMsgSenderSvr$ArkData;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterArkMsgSenderSvr$GameMsgRoles;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ArkMsgSender {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.api.a f212280a;

    /* renamed from: b, reason: collision with root package name */
    private WadlTrpcListener f212281b = new WadlTrpcListener() { // from class: com.tencent.mobileqq.gamecenter.protocols.ArkMsgSender.1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.protocols.ArkMsgSender.1.1
                {
                    add("/v1/643");
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkMsgSender", 1, "WadlTrpcListener onTrpcRsp cmd:" + str + " ret:" + j3);
            }
            ArkMsgSender.this.g((int) j3);
            if ("/v1/643".equals(str)) {
                ArkMsgSender.this.h(j3, trpcInovkeRsp);
            }
            ArkMsgSender.this.i();
        }
    };

    public ArkMsgSender() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212281b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(URLDecoder.decode(str, "utf-8"));
            if (jSONObject.has(IZootopiaShareArkService.ARK_TYPE)) {
                return jSONObject.optInt(IZootopiaShareArkService.ARK_TYPE);
            }
        } catch (Throwable unused) {
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str, String str2) {
        try {
            return new JSONObject(URLDecoder.decode(str, "utf-8")).optString(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        com.tencent.mobileqq.gamecenter.api.a aVar = this.f212280a;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (0 != j3) {
            return;
        }
        try {
            GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgRsp gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgRsp = new GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgRsp();
            gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
            QLog.i("ArkMsgSender", 1, "msg:" + gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgRsp.f213218msg.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("ArkMsgSender", 1, "[parseSendArkMsgRsp], error:" + e16);
        }
    }

    public void i() {
        QLog.i("ArkMsgSender", 1, "[removeListener]");
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f212281b);
    }

    public boolean j(final int i3, final String str, final String str2) {
        QLog.i("ArkMsgSender", 1, "[sendArkMsg], aioType:" + i3);
        if (i3 != 1 && i3 != 2) {
            g(-1);
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("ArkMsgSender", 2, str2);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.protocols.ArkMsgSender.2
                @Override // java.lang.Runnable
                public void run() {
                    GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq = new GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq();
                    GameCenterArkMsgSenderSvr$ArkData gameCenterArkMsgSenderSvr$ArkData = new GameCenterArkMsgSenderSvr$ArkData();
                    int e16 = ArkMsgSender.this.e(str);
                    if (2 == e16) {
                        GameCenterArkMsgSenderSvr$GameMsgRoles gameCenterArkMsgSenderSvr$GameMsgRoles = new GameCenterArkMsgSenderSvr$GameMsgRoles();
                        gameCenterArkMsgSenderSvr$GameMsgRoles.from_role_id.set(ArkMsgSender.this.f(str, "fromRoleId"));
                        gameCenterArkMsgSenderSvr$GameMsgRoles.to_role_id.set(ArkMsgSender.this.f(str, "toRoleId"));
                        gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.roles.set(gameCenterArkMsgSenderSvr$GameMsgRoles);
                    } else {
                        try {
                            gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.to_uin.set(Long.valueOf(str).longValue());
                        } catch (Exception unused) {
                            QLog.e("ArkMsgSender", 1, "[sendArkMsg],fail to convert uin.");
                            ArkMsgSender.this.g(-3);
                            return;
                        }
                    }
                    gameCenterArkMsgSenderSvr$ArkData.type.set(e16);
                    gameCenterArkMsgSenderSvr$ArkData.data.set(str2);
                    gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.ark_info.set(gameCenterArkMsgSenderSvr$ArkData);
                    int i16 = i3;
                    if (1 == i16) {
                        gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.type.set(1);
                    } else if (2 == i16) {
                        gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.type.set(2);
                    }
                    TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/643", false, gameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.toByteArray());
                    TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                    trpcListReq.list.add(createTrpcInvokeReq);
                    ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
                }
            }, 128, null, true);
            return true;
        }
        g(-2);
        return false;
    }

    public void k(com.tencent.mobileqq.gamecenter.api.a aVar) {
        this.f212280a = aVar;
    }
}
