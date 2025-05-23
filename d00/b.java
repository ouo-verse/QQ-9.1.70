package d00;

import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Ld00/b;", "Ld00/a;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", h.F, "", "selectedBarId", "Lvy/a;", "a", "Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeObserver;", "Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeObserver;", "observer", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeObserver;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WSVideoPageChangeObserver observer;

    public b(WSVideoPageChangeObserver wSVideoPageChangeObserver) {
        this.observer = wSVideoPageChangeObserver;
    }

    @Override // d00.a
    public List<WSNavigationBarInfo> a(String selectedBarId) {
        Intrinsics.checkNotNullParameter(selectedBarId, "selectedBarId");
        ArrayList arrayList = new ArrayList();
        int g16 = com.tencent.biz.pubaccount.weishi.home.e.g();
        com.tencent.biz.pubaccount.weishi.home.e eVar = com.tencent.biz.pubaccount.weishi.home.e.f80814a;
        arrayList.add(new WSNavigationBarInfo(0, "follow_tab", selectedBarId, g16, eVar.d("follow_tab", ag.c(R.string.x8q))));
        arrayList.add(new WSNavigationBarInfo(1, "monofeed_tab", selectedBarId, 2, eVar.d("monofeed_tab", ag.c(R.string.x7g))));
        return arrayList;
    }

    @Override // d00.a
    public List<QBaseFragment> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WSFollowFragment());
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
        WSVerticalPageFragment Rh = WSVerticalPageFragment.Rh(new k("aio_home_page", "feeds").V().getExtras());
        WSVideoPageChangeObserver wSVideoPageChangeObserver = this.observer;
        if (wSVideoPageChangeObserver != null) {
            Rh.zi(wSVideoPageChangeObserver);
        }
        arrayList.add(Rh);
        return arrayList;
    }
}
