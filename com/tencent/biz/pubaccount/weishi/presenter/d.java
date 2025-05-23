package com.tencent.biz.pubaccount.weishi.presenter;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stPublisherRsp;
import UserGrowth.stTabInfo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.home.e;
import com.tencent.biz.pubaccount.weishi.m;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.o;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.guard.GuardManager;
import i10.f;
import java.util.ArrayList;
import java.util.List;
import vy.WSNavigationBarInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends com.tencent.biz.pubaccount.weishi.presenter.a<com.tencent.biz.pubaccount.weishi.home.b> implements com.tencent.biz.pubaccount.weishi.home.a {

    /* renamed from: f, reason: collision with root package name */
    private final m f81246f = new m();

    /* renamed from: h, reason: collision with root package name */
    private int f81247h;

    /* renamed from: i, reason: collision with root package name */
    private d00.a f81248i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements cz.b {
        a() {
        }

        @Override // cz.b
        public void a(stPublisherRsp stpublisherrsp) {
            if (d.this.x0() != null && stpublisherrsp.enable && com.tencent.biz.pubaccount.weishi.home.c.k()) {
                d.this.x0().d4(stpublisherrsp);
            }
        }

        @Override // cz.b
        public void onFailure(int i3, String str) {
            x.f("WSHomeFragmentPresenter", "GetPublisherRequest onTaskResponse failed errorCode:" + i3 + ", errMsg:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements com.tencent.biz.pubaccount.weishi.cache.a {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.cache.a
        public void a(JceStruct jceStruct) {
            stGetTabsRsp stgettabsrsp = jceStruct instanceof stGetTabsRsp ? (stGetTabsRsp) jceStruct : null;
            if (d.this.x0() != null) {
                d.this.x0().Oa(stgettabsrsp);
            }
            d.this.E0(stgettabsrsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f81251a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ stGetTabsRsp f81252b;

        c(long j3, stGetTabsRsp stgettabsrsp) {
            this.f81251a = j3;
            this.f81252b = stgettabsrsp;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            long currentTimeMillis = System.currentTimeMillis() - this.f81251a;
            if (!lVar.d() || !(lVar.f80999l instanceof stGetTabsRsp)) {
                d.this.B0(this.f81252b);
                g.d().r(currentTimeMillis, lVar.f80994g, lVar.f80991d, lVar.f80990c);
                return;
            }
            g.d().p(currentTimeMillis, lVar.f80994g, "feeds", true);
            stGetTabsRsp stgettabsrsp = (stGetTabsRsp) lVar.f80999l;
            WeiShiCacheManager.O().w(stgettabsrsp);
            d.this.B0(stgettabsrsp);
            if (d.this.x0() != null) {
                x.i("WSHomeFragmentPresenter", "getTabsInfo size: " + stgettabsrsp.Tabs.size());
                d.this.x0().Oa(stgettabsrsp);
            }
        }
    }

    public d() {
        e.f80814a.h();
    }

    private void A0(String str, boolean z16) {
        com.tencent.biz.pubaccount.weishi.home.b x06 = x0();
        this.f81248i = d00.e.a(str, z16, x06 != null ? x06.j2() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(stGetTabsRsp stgettabsrsp) {
        ArrayList<stTabInfo> arrayList;
        com.tencent.biz.pubaccount.weishi.home.b x06 = x0();
        if (stgettabsrsp == null || (arrayList = stgettabsrsp.Tabs) == null || arrayList.size() < 1 || x06 == null || TextUtils.isEmpty(stgettabsrsp.Tabs.get(0).displayIcon)) {
            return;
        }
        x06.ye();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(stGetTabsRsp stgettabsrsp) {
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new f(), null, new c(System.currentTimeMillis(), stgettabsrsp), 4017));
    }

    public void C0() {
        cz.d.f392425a.b(new a());
    }

    public void D0() {
        WeiShiCacheManager.O().C(new b());
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public void b0(String str) {
        str.hashCode();
        int i3 = 2;
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2026706425:
                if (str.equals("follow_tab")) {
                    c16 = 0;
                    break;
                }
                break;
            case -710258968:
                if (str.equals("waterfall_tab")) {
                    c16 = 1;
                    break;
                }
                break;
            case 194805079:
                if (str.equals("monofeed_tab")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                i3 = 1;
                break;
            case 1:
                break;
            case 2:
                i3 = 3;
                break;
            default:
                x.f("WSHomeFragmentPresenter", "onTabReselected() barId is invalid. " + str);
                return;
        }
        wz.b.b().a(new WSRefreshEvent(i3));
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public void doOnDestroy() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.f81246f);
        }
        e.f80814a.a();
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public String e() {
        int i3 = this.f81247h;
        if (i3 == 0) {
            return WSPublicAccReport.SOP_NAME_FOCUS;
        }
        if (i3 != 1) {
            return "feeds";
        }
        if (!com.tencent.biz.pubaccount.weishi.home.c.j() && !com.tencent.biz.pubaccount.weishi.home.c.m()) {
            return "feeds";
        }
        return "monofeed";
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public void g() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.f81246f);
        }
        C0();
        D0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public List<QBaseFragment> h() {
        return this.f81248i.h();
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public void o(Bundle bundle) {
        boolean z16;
        Bundle bundle2;
        String str = "";
        if (bundle == null || (bundle2 = bundle.getBundle("key_home_bundle")) == null) {
            z16 = false;
        } else {
            str = bundle2.getString("key_home_to_context_feed_id", "");
            z16 = bundle2.getBoolean("key_context_feed_show_musk");
        }
        A0(str, z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public void onPageSelected(int i3) {
        this.f81247h = i3;
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public List<WSNavigationBarInfo> q() {
        return this.f81248i.a(e.b());
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.a
    public void v0(Context context, stPublisherRsp stpublisherrsp) {
        if (stpublisherrsp == null || stpublisherrsp.guide == null) {
            return;
        }
        new o().f(new URLImageView(context), context.getResources().getDrawable(R.drawable.d7y), stpublisherrsp.guide.imageUrl, true, true);
    }
}
