package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$Authorization;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$AuthorizeReply;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$AuthorizeRequest;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetVisibleRangeReply;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetVisibleRangeRequest;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$LoginGuide;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$PkgInfo;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$ReportAuthorizeInfoReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private b f212315a;

    /* renamed from: c, reason: collision with root package name */
    private String f212317c;

    /* renamed from: d, reason: collision with root package name */
    private int f212318d;

    /* renamed from: b, reason: collision with root package name */
    private HashSet<String> f212316b = new HashSet<>();

    /* renamed from: e, reason: collision with root package name */
    private WadlTrpcListener f212319e = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements WadlTrpcListener {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return d.this.f212316b;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (intent != null && intent.getExtras() != null) {
                if (!d.this.f212317c.equals(intent.getExtras().getString("AppID"))) {
                    return;
                }
                if ("/v1/409".equals(str)) {
                    d.this.i(intent, j3, trpcInovkeRsp);
                } else if ("/v1/408".equals(str)) {
                    d.this.j(intent, j3, trpcInovkeRsp);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(GameDataAuthorizeSvr$LoginGuide gameDataAuthorizeSvr$LoginGuide);

        void b(List<com.tencent.mobileqq.gamecenter.data.b> list);

        void d(String str, String str2, List<com.tencent.mobileqq.gamecenter.data.b> list);
    }

    public d(String str, int i3) {
        this.f212316b.add("/v1/409");
        this.f212316b.add("/v1/408");
        this.f212316b.add("/v1/1924");
        this.f212317c = str;
        this.f212318d = i3;
    }

    private List<com.tencent.mobileqq.gamecenter.data.b> f(List<GameDataAuthorizeSvr$Authorization> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (GameDataAuthorizeSvr$Authorization gameDataAuthorizeSvr$Authorization : list) {
                com.tencent.mobileqq.gamecenter.data.b bVar = new com.tencent.mobileqq.gamecenter.data.b();
                bVar.f211987a = gameDataAuthorizeSvr$Authorization.type.get();
                bVar.f211988b = gameDataAuthorizeSvr$Authorization.range.get();
                bVar.f211989c = gameDataAuthorizeSvr$Authorization.title.get();
                bVar.f211990d = gameDataAuthorizeSvr$Authorization.text.get();
                arrayList.add(bVar);
                if (QLog.isColorLevel()) {
                    QLog.i("GameAuthProtoHandler", 1, "type:" + bVar.f211987a + ",range:" + bVar.f211988b);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String fileChannel = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(str));
            QLog.i("GameAuthProtoHandler", 1, "++++++channelId:" + fileChannel);
            return fileChannel;
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, "[getChannelId], error:" + th5);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i("GameAuthProtoHandler", 1, "[handleGetGameAuthInfo], retCode:" + j3);
        try {
            if (j3 == 0 && trpcInovkeRsp != null) {
                if (this.f212315a == null) {
                    return;
                }
                GameDataAuthorizeSvr$GetVisibleRangeReply gameDataAuthorizeSvr$GetVisibleRangeReply = new GameDataAuthorizeSvr$GetVisibleRangeReply();
                gameDataAuthorizeSvr$GetVisibleRangeReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f212315a.a(gameDataAuthorizeSvr$GetVisibleRangeReply.login_guide.get());
                this.f212315a.d(m(trpcInovkeRsp), n(trpcInovkeRsp), f(l(trpcInovkeRsp)));
                return;
            }
            QLog.w("GameAuthProtoHandler", 1, "rsp errors!");
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i("GameAuthProtoHandler", 1, "[handleSetGameAuthInfo], retCode:" + j3);
        try {
            if (j3 == 0 && trpcInovkeRsp != null) {
                if (this.f212315a == null) {
                    return;
                }
                this.f212315a.b(f(o(trpcInovkeRsp)));
                return;
            }
            QLog.w("GameAuthProtoHandler", 1, "rsp errors!");
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, th5, new Object[0]);
        }
    }

    public void e() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212319e);
    }

    public void h(String str) {
        try {
            GameDataAuthorizeSvr$GetVisibleRangeRequest gameDataAuthorizeSvr$GetVisibleRangeRequest = new GameDataAuthorizeSvr$GetVisibleRangeRequest();
            gameDataAuthorizeSvr$GetVisibleRangeRequest.app_id.set(this.f212317c);
            gameDataAuthorizeSvr$GetVisibleRangeRequest.source.set(this.f212318d);
            GameDataAuthorizeSvr$PkgInfo gameDataAuthorizeSvr$PkgInfo = new GameDataAuthorizeSvr$PkgInfo();
            String g16 = g(str);
            if (!TextUtils.isEmpty(g16)) {
                gameDataAuthorizeSvr$PkgInfo.channel.set(g16);
            }
            String F = ah.F();
            String valueOf = String.valueOf(ah.K());
            if (!TextUtils.isEmpty(F)) {
                gameDataAuthorizeSvr$PkgInfo.model.set(F);
            }
            if (!TextUtils.isEmpty(valueOf)) {
                gameDataAuthorizeSvr$PkgInfo.version.set(valueOf);
            }
            gameDataAuthorizeSvr$PkgInfo.platform.set(1);
            gameDataAuthorizeSvr$GetVisibleRangeRequest.pkg_info.set(gameDataAuthorizeSvr$PkgInfo);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/409", false, gameDataAuthorizeSvr$GetVisibleRangeRequest.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putString("AppID", this.f212317c);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, "[getGameAuthInfo], th:" + th5);
        }
    }

    public void k() {
        QLog.i("GameAuthProtoHandler", 1, "[onDestroy]");
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f212319e);
    }

    public List<GameDataAuthorizeSvr$Authorization> l(TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        try {
            GameDataAuthorizeSvr$GetVisibleRangeReply gameDataAuthorizeSvr$GetVisibleRangeReply = new GameDataAuthorizeSvr$GetVisibleRangeReply();
            gameDataAuthorizeSvr$GetVisibleRangeReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
            return gameDataAuthorizeSvr$GetVisibleRangeReply.authoritys.get();
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, "parse errors," + th5.getMessage());
            return null;
        }
    }

    public String m(TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        try {
            GameDataAuthorizeSvr$GetVisibleRangeReply gameDataAuthorizeSvr$GetVisibleRangeReply = new GameDataAuthorizeSvr$GetVisibleRangeReply();
            gameDataAuthorizeSvr$GetVisibleRangeReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
            return gameDataAuthorizeSvr$GetVisibleRangeReply.jump_url.get();
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, "parse errors," + th5.getMessage());
            return null;
        }
    }

    public String n(TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        try {
            GameDataAuthorizeSvr$GetVisibleRangeReply gameDataAuthorizeSvr$GetVisibleRangeReply = new GameDataAuthorizeSvr$GetVisibleRangeReply();
            gameDataAuthorizeSvr$GetVisibleRangeReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
            return gameDataAuthorizeSvr$GetVisibleRangeReply.bottom_remarks.get();
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, "parse errors," + th5.getMessage());
            return null;
        }
    }

    public List<GameDataAuthorizeSvr$Authorization> o(TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        try {
            GameDataAuthorizeSvr$AuthorizeReply gameDataAuthorizeSvr$AuthorizeReply = new GameDataAuthorizeSvr$AuthorizeReply();
            gameDataAuthorizeSvr$AuthorizeReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
            return gameDataAuthorizeSvr$AuthorizeReply.authoritys.get();
        } catch (Throwable th5) {
            QLog.e("GameAuthProtoHandler", 1, "parse errors," + th5.getMessage());
            return null;
        }
    }

    public void p(int i3, List<com.tencent.mobileqq.gamecenter.data.b> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(this.f212317c)) {
            try {
                GameDataAuthorizeSvr$ReportAuthorizeInfoReq gameDataAuthorizeSvr$ReportAuthorizeInfoReq = new GameDataAuthorizeSvr$ReportAuthorizeInfoReq();
                gameDataAuthorizeSvr$ReportAuthorizeInfoReq.appid.set(this.f212317c);
                gameDataAuthorizeSvr$ReportAuthorizeInfoReq.status.set(i3);
                ArrayList arrayList = new ArrayList();
                for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                    int i16 = bVar.f211987a;
                    if (i16 == 1 || i16 == 2) {
                        GameDataAuthorizeSvr$Authorization gameDataAuthorizeSvr$Authorization = new GameDataAuthorizeSvr$Authorization();
                        gameDataAuthorizeSvr$Authorization.range.set(bVar.f211988b);
                        gameDataAuthorizeSvr$Authorization.text.set(bVar.f211990d);
                        gameDataAuthorizeSvr$Authorization.title.set(bVar.f211989c);
                        gameDataAuthorizeSvr$Authorization.type.set(bVar.f211987a);
                        arrayList.add(gameDataAuthorizeSvr$Authorization);
                    }
                }
                gameDataAuthorizeSvr$ReportAuthorizeInfoReq.authoritys.set(arrayList);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1924", false, gameDataAuthorizeSvr$ReportAuthorizeInfoReq.toByteArray());
                TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                Bundle bundle = new Bundle();
                bundle.putString("AppID", this.f212317c);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
            } catch (Throwable th5) {
                QLog.e("GameAuthProtoHandler", 1, "[reportUserOption], th:", th5);
            }
        }
    }

    public void q(b bVar) {
        this.f212315a = bVar;
    }

    public void r(List<com.tencent.mobileqq.gamecenter.data.b> list) {
        if (list != null && list.size() != 0) {
            GameDataAuthorizeSvr$AuthorizeRequest gameDataAuthorizeSvr$AuthorizeRequest = new GameDataAuthorizeSvr$AuthorizeRequest();
            gameDataAuthorizeSvr$AuthorizeRequest.app_id.set(this.f212317c);
            gameDataAuthorizeSvr$AuthorizeRequest.source.set(this.f212318d);
            for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                GameDataAuthorizeSvr$Authorization gameDataAuthorizeSvr$Authorization = new GameDataAuthorizeSvr$Authorization();
                gameDataAuthorizeSvr$Authorization.type.set(bVar.f211987a);
                gameDataAuthorizeSvr$Authorization.range.set(bVar.f211988b);
                gameDataAuthorizeSvr$AuthorizeRequest.authoritys.add(gameDataAuthorizeSvr$Authorization);
            }
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/408", false, gameDataAuthorizeSvr$AuthorizeRequest.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putString("AppID", this.f212317c);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        }
    }
}
