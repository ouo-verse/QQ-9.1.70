package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.Observer;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.banner.CoverBubbleBanner;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bc extends d {

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f56230f;

    /* renamed from: h, reason: collision with root package name */
    private CoverBubbleBanner f56231h;

    public bc(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(com.qzone.feed.business.model.a aVar) {
        if (this.f56231h == null) {
            this.f56231h = new CoverBubbleBanner(g());
            this.f56231h.h((ViewStub) g().findViewById(R.id.myy));
        }
        CoverBubbleBanner coverBubbleBanner = this.f56231h;
        if (coverBubbleBanner != null) {
            coverBubbleBanner.t(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        CoverBubbleBanner coverBubbleBanner = this.f56231h;
        if (coverBubbleBanner != null) {
            coverBubbleBanner.g();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QzoneFeedxCoverBubbleElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) k(com.qzone.reborn.feedx.viewmodel.q.class);
        this.f56230f = qVar;
        qVar.F2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bc.this.q((ArrayList) obj);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        super.onPause();
        CoverBubbleBanner coverBubbleBanner = this.f56231h;
        if (coverBubbleBanner != null) {
            coverBubbleBanner.g();
        }
    }

    public void s(final com.qzone.feed.business.model.a aVar) {
        f().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.ba
            @Override // java.lang.Runnable
            public final void run() {
                bc.this.u(aVar);
            }
        }, 500L);
    }

    public void t() {
        f().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.bb
            @Override // java.lang.Runnable
            public final void run() {
                bc.this.v();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(ArrayList<BusinessADBannerData> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                BusinessADBannerData businessADBannerData = arrayList.get(i3);
                if (businessADBannerData != null && 2 == businessADBannerData.eAdType) {
                    aVar.f47123g = businessADBannerData;
                    aVar.f47132p = businessADBannerData.newRepoertInfoList;
                    aVar.f47124h = this.f56230f.A2();
                    s(aVar);
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (z16) {
            return;
        }
        t();
    }
}
