package ge;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lge/h;", "", "Lge/i;", "a", "Lge/i;", "()Lge/i;", "d", "(Lge/i;)V", "defaultItemBean", "", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "longPicItems", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "e", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", QCircleScheme.AttrDetail.FEED_INFO, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private i defaultItemBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<i> longPicItems = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CommonFeed feedInfo;

    /* renamed from: a, reason: from getter */
    public final i getDefaultItemBean() {
        return this.defaultItemBean;
    }

    /* renamed from: b, reason: from getter */
    public final CommonFeed getFeedInfo() {
        return this.feedInfo;
    }

    public final List<i> c() {
        return this.longPicItems;
    }

    public final void d(i iVar) {
        this.defaultItemBean = iVar;
    }

    public final void e(CommonFeed commonFeed) {
        this.feedInfo = commonFeed;
    }

    public final void f(List<i> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.longPicItems = list;
    }
}
