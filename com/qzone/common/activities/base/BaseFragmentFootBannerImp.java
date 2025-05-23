package com.qzone.common.activities.base;

import android.view.ViewStub;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.banner.FootBanner;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFragmentFootBannerImp implements d5.p<QZoneResult> {

    /* renamed from: a, reason: collision with root package name */
    private d5.u f45052a;

    /* renamed from: b, reason: collision with root package name */
    private FootBanner f45053b;

    @Inject
    public BaseFragmentFootBannerImp() {
    }

    public boolean e(int i3) {
        if (4 == i3) {
            return true;
        }
        return false;
    }

    @Override // d5.p
    public void onResume() {
        FootBanner footBanner = this.f45053b;
        if (footBanner != null) {
            footBanner.r();
        }
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45052a = uVar;
    }

    @Override // d5.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(QZoneResult qZoneResult) {
        ArrayList arrayListFromBundle;
        if (qZoneResult == null || this.f45052a == null || (arrayListFromBundle = ParcelableWrapper.getArrayListFromBundle(qZoneResult.getBundle(), BusinessADBannerData.STORE_KEY)) == null || arrayListFromBundle.size() <= 0) {
            return;
        }
        Iterator it = arrayListFromBundle.iterator();
        while (it.hasNext()) {
            BusinessADBannerData businessADBannerData = (BusinessADBannerData) it.next();
            final com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
            aVar.f47123g = businessADBannerData;
            if (businessADBannerData != null && e(businessADBannerData.eAdType)) {
                this.f45052a.c(new Runnable() { // from class: com.qzone.common.activities.base.BaseFragmentFootBannerImp.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaseFragmentFootBannerImp.this.e(aVar.f47123g.eAdType)) {
                            if (BaseFragmentFootBannerImp.this.f45053b == null) {
                                BaseFragmentFootBannerImp.this.f45053b = new FootBanner(BaseFragmentFootBannerImp.this.f45052a.getActivity());
                                BaseFragmentFootBannerImp.this.f45053b.h((ViewStub) BaseFragmentFootBannerImp.this.f45052a.findViewById(R.id.hig));
                            }
                            if (BaseFragmentFootBannerImp.this.f45053b == null || BaseFragmentFootBannerImp.this.f45053b.l()) {
                                return;
                            }
                            BaseFragmentFootBannerImp.this.f45053b.t(aVar);
                        }
                    }
                }, 500L);
            }
        }
    }
}
