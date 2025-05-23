package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterAuthApiImpl;
import com.tencent.mobileqq.gamecenter.data.o;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$FollowPublicAccountReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$PublicAcountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes12.dex */
public class GameAuthPubAccHandler {

    /* renamed from: a, reason: collision with root package name */
    private a f212286a;

    /* renamed from: b, reason: collision with root package name */
    private GameCenterAuthApiImpl.a f212287b;

    /* renamed from: c, reason: collision with root package name */
    private WadlTrpcListener f212288c = new WadlTrpcListener() { // from class: com.tencent.mobileqq.gamecenter.protocols.GameAuthPubAccHandler.1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.protocols.GameAuthPubAccHandler.1.1
                {
                    add("/v1/738");
                    add("/v1/100");
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (QLog.isColorLevel()) {
                QLog.i("GameAuthPubAccHandler", 1, "WadlTrpcListener onTrpcRsp cmd:" + str + " ret:" + j3);
            }
            if (0 != j3) {
                GameAuthPubAccHandler.this.d(str);
            } else if ("/v1/738".equals(str)) {
                GameAuthPubAccHandler.this.c(trpcInovkeRsp);
            }
        }
    };

    /* loaded from: classes12.dex */
    public interface a {
        void onGetPubAccInfo(boolean z16, o oVar, GameCenterAuthApiImpl.a aVar, GameAuthPubAccHandler gameAuthPubAccHandler);
    }

    public GameAuthPubAccHandler() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212288c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (trpcInovkeRsp != null && this.f212286a != null) {
            try {
                GameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp gameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp = new GameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp();
                gameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                List<GameDataAuthorizeSvr$PublicAcountInfo> list = gameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp.infos.get();
                if (list != null && list.size() != 0) {
                    GameDataAuthorizeSvr$PublicAcountInfo gameDataAuthorizeSvr$PublicAcountInfo = list.get(0);
                    o oVar = new o();
                    oVar.f212064a = gameDataAuthorizeSvr$PublicAcountInfo.type.get();
                    oVar.f212065b = gameDataAuthorizeSvr$PublicAcountInfo.text.get();
                    this.f212286a.onGetPubAccInfo(true, oVar, this.f212287b, this);
                    return;
                }
                d("/v1/738");
            } catch (Throwable th5) {
                QLog.e("GameAuthPubAccHandler", 1, "parse errors," + th5.getMessage());
                d("/v1/738");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.f212286a != null && "/v1/738".equals(str)) {
            this.f212286a.onGetPubAccInfo(false, null, this.f212287b, this);
        }
    }

    public void e() {
        QLog.i("GameAuthPubAccHandler", 1, "[onDestroy]");
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f212288c);
    }

    public void f(int i3, int i16, String str) {
        QLog.i("GameAuthPubAccHandler", 1, "[requestFollowPubAcc], appId:" + i3 + ",type:" + i16);
        GameDataAuthorizeSvr$FollowPublicAccountReq gameDataAuthorizeSvr$FollowPublicAccountReq = new GameDataAuthorizeSvr$FollowPublicAccountReq();
        gameDataAuthorizeSvr$FollowPublicAccountReq.account_type.set(i16);
        gameDataAuthorizeSvr$FollowPublicAccountReq.source.set(str);
        gameDataAuthorizeSvr$FollowPublicAccountReq.appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/100", false, gameDataAuthorizeSvr$FollowPublicAccountReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }
}
