package c50;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildRecommendAndPushPresenter;
import com.tencent.biz.qqcircle.immersive.feed.am;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u001c\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0013"}, d2 = {"Lc50/a;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/f;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "w", "Lcom/tencent/biz/qqcircle/immersive/layer/base/a;", "builder", "", "Lcom/tencent/biz/richframework/part/Part;", "g", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends com.tencent.biz.qqcircle.immersive.layer.base.f {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    protected List<Part> g(@NotNull com.tencent.biz.qqcircle.immersive.layer.base.a builder) {
        List<Part> mutableListOf;
        Intrinsics.checkNotNullParameter(builder, "builder");
        QCircleLayerBean initBean = ((com.tencent.biz.qqcircle.immersive.layer.biz.a) builder).b();
        Intrinsics.checkNotNullExpressionValue(initBean, "initBean");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new f(initBean), new c(initBean));
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(e.class, QFSFeedChildBottomInfoPresenter.class, QFSFeedChildRecommendAndPushPresenter.class, am.class);
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(@Nullable QCircleInitBean initBean) {
        if (initBean != null && x(initBean)) {
            return true;
        }
        return false;
    }

    public final boolean x(@Nullable QCircleInitBean initBean) {
        if (initBean != null && initBean.getSchemeAttrs() != null) {
            return TextUtils.equals(initBean.getSchemeAttrs().get("xsj_custom_pgid"), QCircleDaTongConstant.PageId.PG_XSJ_HOT_COMMENT_COLLECTION_PAGE);
        }
        return false;
    }
}
