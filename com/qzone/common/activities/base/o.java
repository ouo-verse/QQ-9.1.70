package com.qzone.common.activities.base;

import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("BaseFeedFragmentFavorImp")
/* loaded from: classes39.dex */
public class o implements d5.j<BusinessFeedData> {

    /* renamed from: a, reason: collision with root package name */
    private d5.u f45528a;

    @Inject
    public o() {
    }

    @Override // d5.j
    public boolean a(d5.k<BusinessFeedData> kVar, d5.n<BusinessFeedData> nVar) {
        if (c(kVar.d())) {
            return false;
        }
        QZoneFeedUtil.f0(3585, kVar.b(), this.f45528a.getHandler(), nVar);
        ClickReport.i(kVar.a(), Integer.toString(kVar.getAppId()), "", "", false, 302, 22, 4);
        return true;
    }

    @Override // d5.j
    public void b(d5.k<BusinessFeedData> kVar, d5.n<BusinessFeedData> nVar) {
        if (a(kVar, nVar)) {
            return;
        }
        d(kVar, nVar);
    }

    @Override // d5.j
    public boolean c(String str) {
        return QzoneFavoriteService.M().R(str);
    }

    @Override // d5.j
    public boolean d(d5.k<BusinessFeedData> kVar, d5.n<BusinessFeedData> nVar) {
        if (!c(kVar.d())) {
            return false;
        }
        QZoneFeedUtil.f0(3586, kVar.b(), this.f45528a.getHandler(), nVar);
        ClickReport.i(kVar.a(), Integer.toString(kVar.getAppId()), "", "", false, 302, 22, 5);
        return true;
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45528a = uVar;
    }
}
