package h50;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import feedcloud.FeedCloudMeta$StFeed;
import g50.c;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y40.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lh50/a;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/a;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "w", "Lcom/tencent/biz/qqcircle/immersive/part/u;", HippyTKDListViewAdapter.X, "", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.a {
    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.a, com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q16 = super.q();
        q16.add(c.class);
        return q16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.a, com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(@Nullable QCircleInitBean initBean) {
        if ((initBean != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.h(initBean)) || an.d(initBean)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.a
    @NotNull
    public u x(@Nullable QCircleInitBean initBean) {
        return new g(initBean, 17);
    }
}
