package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetRecommendUserListRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribeGetRecommendUserListRequest;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FollowedRecommendBannerModel {

    /* renamed from: a, reason: collision with root package name */
    private COMM.StCommonExt f95596a;

    /* renamed from: b, reason: collision with root package name */
    private a f95597b;

    /* renamed from: c, reason: collision with root package name */
    private long f95598c;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(List<ve0.a> list, boolean z16);
    }

    public COMM.StCommonExt d() {
        return this.f95596a;
    }

    public void e(a aVar) {
        this.f95597b = aVar;
    }

    public void f(String str) {
        this.f95598c = System.currentTimeMillis();
        VSNetworkHelper.getInstance().sendRequest(new SubscribeGetRecommendUserListRequest(str, this.f95596a, 0, 1), new VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetRecommendUserListRsp>() { // from class: com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, CertifiedAccountRead$StGetRecommendUserListRsp certifiedAccountRead$StGetRecommendUserListRsp) {
                if (z16) {
                    hd0.c.k("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
                    if (certifiedAccountRead$StGetRecommendUserListRsp != null) {
                        final ArrayList arrayList = new ArrayList();
                        if (certifiedAccountRead$StGetRecommendUserListRsp.vecUser.get() != null) {
                            Iterator<CertifiedAccountMeta$StUser> it = certifiedAccountRead$StGetRecommendUserListRsp.vecUser.get().iterator();
                            while (it.hasNext()) {
                                arrayList.add(new ve0.a(it.next()));
                            }
                        }
                        FollowedRecommendBannerModel.this.f95596a = certifiedAccountRead$StGetRecommendUserListRsp.extInfo.get();
                        final boolean z17 = true;
                        if (certifiedAccountRead$StGetRecommendUserListRsp.isFinish.get() != 1) {
                            z17 = false;
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FollowedRecommendBannerModel.this.f95597b != null) {
                                    FollowedRecommendBannerModel.this.f95597b.a(arrayList, z17);
                                }
                            }
                        });
                    }
                    VSReporter.q("subscribe_personal_detail_page_request", VSReporter.e(0L, System.currentTimeMillis() - FollowedRecommendBannerModel.this.f95598c));
                    return;
                }
                hd0.c.k("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
                VSReporter.q("subscribe_personal_detail_page_request", VSReporter.e(j3, System.currentTimeMillis() - FollowedRecommendBannerModel.this.f95598c));
            }
        });
    }
}
