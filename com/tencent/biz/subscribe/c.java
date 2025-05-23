package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile CertifiedAccountMeta$StUser f95832a;

    /* renamed from: b, reason: collision with root package name */
    private static CertifiedAccountRead$StGetMainPageRsp f95833b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetMainPageRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
            if (z16 && j3 == 0) {
                if (certifiedAccountRead$StGetMainPageRsp != null) {
                    c.f95832a = certifiedAccountRead$StGetMainPageRsp.user.get();
                } else {
                    QLog.w(c.class.getSimpleName(), 1, "getPuinUser empty");
                }
            }
        }
    }

    public static CertifiedAccountRead$StGetMainPageRsp b() {
        return f95833b;
    }

    public static CertifiedAccountMeta$StUser c() {
        try {
            if (f95832a == null) {
                COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                COMM.Entry entry = new COMM.Entry();
                entry.key.set("user_info");
                entry.value.set("1");
                stCommonExt.mapInfo.add(entry);
                if (VSNetworkHelper.getInstance() != null) {
                    VSNetworkHelper.getInstance().sendRequest(new SubscribePersonalDetailRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount(), stCommonExt), new a());
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return f95832a;
    }

    public static void d(CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
        if (f95833b == null) {
            f95833b = new CertifiedAccountRead$StGetMainPageRsp();
        }
        if (f95832a == null) {
            f95832a = new CertifiedAccountMeta$StUser();
        }
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user;
        if (certifiedAccountMeta$StUser == null) {
            return;
        }
        f95833b.feedCount.set(certifiedAccountRead$StGetMainPageRsp.feedCount.get());
        f95833b.followCount.set(certifiedAccountRead$StGetMainPageRsp.followCount.get());
        f95833b.fansCount.set(certifiedAccountRead$StGetMainPageRsp.fansCount.get());
        f95833b.user.set(certifiedAccountRead$StGetMainPageRsp.user.get());
        f95833b.share.set(certifiedAccountRead$StGetMainPageRsp.share);
        if (SubscribeUtils.o(certifiedAccountMeta$StUser.attr.get())) {
            f95832a.f24929id.set(certifiedAccountMeta$StUser.f24929id.get());
            f95832a.nick.set(certifiedAccountMeta$StUser.nick.get());
            f95832a.icon.set(certifiedAccountMeta$StUser.icon.get());
            f95832a.followState.set(certifiedAccountMeta$StUser.followState.get());
            f95832a.attr.set(certifiedAccountMeta$StUser.attr.get());
            f95832a.youZhan.set(certifiedAccountMeta$StUser.youZhan.get());
            f95832a.type.set(certifiedAccountMeta$StUser.type.get());
        }
    }
}
