package d00;

import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ld00/c;", "Ld00/a;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", h.F, "", "selectedBarId", "Lvy/a;", "a", "Ljava/lang/String;", "contextFeedId", "", "b", "Z", "isContextFeedShowMusk", "<init>", "(Ljava/lang/String;Z)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String contextFeedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isContextFeedShowMusk;

    public c(String contextFeedId, boolean z16) {
        Intrinsics.checkNotNullParameter(contextFeedId, "contextFeedId");
        this.contextFeedId = contextFeedId;
        this.isContextFeedShowMusk = z16;
    }

    @Override // d00.a
    public List<WSNavigationBarInfo> a(String selectedBarId) {
        Intrinsics.checkNotNullParameter(selectedBarId, "selectedBarId");
        ArrayList arrayList = new ArrayList();
        int g16 = com.tencent.biz.pubaccount.weishi.home.e.g();
        com.tencent.biz.pubaccount.weishi.home.e eVar = com.tencent.biz.pubaccount.weishi.home.e.f80814a;
        arrayList.add(new WSNavigationBarInfo(0, "follow_tab", selectedBarId, g16, eVar.d("follow_tab", ag.c(R.string.x8q))));
        arrayList.add(new WSNavigationBarInfo(1, "waterfall_tab", selectedBarId, com.tencent.biz.pubaccount.weishi.home.e.g(), eVar.d("waterfall_tab", ag.c(R.string.x8r))));
        return arrayList;
    }

    @Override // d00.a
    public List<QBaseFragment> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WSFollowFragment());
        if (com.tencent.biz.pubaccount.weishi.config.experiment.b.h().F()) {
            arrayList.add(WSRecommendFragment.Jh(this.contextFeedId, this.isContextFeedShowMusk));
        } else {
            arrayList.add(WSGridPageFragment.Vh("", false, true, this.contextFeedId, this.isContextFeedShowMusk));
        }
        return arrayList;
    }
}
