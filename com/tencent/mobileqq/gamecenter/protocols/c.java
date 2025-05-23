package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.i;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetConfReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetConfRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<i> f212305a;

    /* renamed from: b, reason: collision with root package name */
    private String f212306b;

    /* renamed from: c, reason: collision with root package name */
    private String f212307c;

    /* renamed from: d, reason: collision with root package name */
    private long f212308d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f212309e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.common.offline.a f212310f = new a();

    /* renamed from: g, reason: collision with root package name */
    private Runnable f212311g = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.protocols.b
        @Override // java.lang.Runnable
        public final void run() {
            c.this.g();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private WadlTrpcListener f212312h = new b();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements WadlTrpcListener {
        b() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("/v1/1444");
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (QLog.isColorLevel()) {
                QLog.i("GameActWeb.GameActConfigHandler", 1, "WadlTrpcListener onTrpcRsp cmd:" + str + " ret:" + j3);
            }
            try {
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(c.this.f212312h);
                if (intent == null || intent.getExtras() == null || !"/v1/1444".equals(str)) {
                    return;
                }
                String string = intent.getExtras().getString("act_id");
                GameDataAuthorizeSvr$GetConfRsp gameDataAuthorizeSvr$GetConfRsp = new GameDataAuthorizeSvr$GetConfRsp();
                gameDataAuthorizeSvr$GetConfRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                c.this.i(string, gameDataAuthorizeSvr$GetConfRsp.url.get(), gameDataAuthorizeSvr$GetConfRsp.expire_time.get());
                if (QLog.isColorLevel()) {
                    QLog.i("GameActWeb.GameActConfigHandler", 1, "[onTrpcRsp], end.");
                }
            } catch (Throwable th5) {
                QLog.e("GameActWeb.GameActConfigHandler", 1, "[onTrpcRsp], th:", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (QLog.isColorLevel()) {
            QLog.d("GameActWeb.GameActConfigHandler", 1, "Timeout+++++++++");
        }
        this.f212309e.set(true);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ThreadManagerV2.removeJob(this.f212311g, 128);
        WeakReference<i> weakReference = this.f212305a;
        if (weakReference != null && weakReference.get() != null) {
            this.f212305a.get().a(this.f212306b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, String str2, long j3) {
        if (!TextUtils.isEmpty(str2) && !str2.equals(this.f212307c)) {
            ((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).saveActUrl(str, str2, j3);
            this.f212306b = str2 + "&__refresh_tag=1";
            String str3 = com.tencent.mobileqq.gamecenter.utils.c.e(str2).get("_bid");
            if (TextUtils.isEmpty(str3)) {
                h();
                return;
            }
            String z16 = HtmlOffline.z(str3);
            QLog.i("GameActWeb.GameActConfigHandler", 1, "local bid version:" + z16);
            if (TextUtils.isEmpty(z16)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                this.f212308d = System.currentTimeMillis();
                com.tencent.mobileqq.gamecenter.utils.c.x(arrayList, this.f212310f);
                ThreadManagerV2.executeDelay(this.f212311g, 128, null, true, 500L);
                return;
            }
            h();
        }
    }

    public void j(String str, String str2, i iVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f212307c = str;
        this.f212305a = new WeakReference<>(iVar);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212312h);
        GameDataAuthorizeSvr$GetConfReq gameDataAuthorizeSvr$GetConfReq = new GameDataAuthorizeSvr$GetConfReq();
        gameDataAuthorizeSvr$GetConfReq.act_id.set(str2);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1444", false, gameDataAuthorizeSvr$GetConfReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putString("act_id", str2);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            QLog.i("GameActWeb.GameActConfigHandler", 1, "[offline callback], costT:" + (System.currentTimeMillis() - c.this.f212308d) + ",code:" + i3 + ",param:" + str + ",hasOpenPage:" + c.this.f212309e);
            if (c.this.f212309e.get()) {
                QLog.i("GameActWeb.GameActConfigHandler", 1, "Page opened.");
            } else if (i3 != 0) {
                c.this.h();
            } else if (str == null) {
                c.this.h();
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
