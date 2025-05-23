package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.bizparts.ad;
import com.tencent.biz.qqcircle.bizparts.aw;
import com.tencent.biz.qqcircle.bizparts.bq;
import com.tencent.biz.qqcircle.bizparts.de;
import com.tencent.biz.qqcircle.debug.g;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildAvatarPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildContentQualityFeedbackPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildGameCardPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildLiteBannerPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildMutePresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPositiveFeedbackGuideFollowPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildRecommendAndPushPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedMusicBannerPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ac;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdShadePresenter;
import com.tencent.biz.qqcircle.immersive.feed.al;
import com.tencent.biz.qqcircle.immersive.feed.bc;
import com.tencent.biz.qqcircle.immersive.feed.bk;
import com.tencent.biz.qqcircle.immersive.feed.bm;
import com.tencent.biz.qqcircle.immersive.feed.br;
import com.tencent.biz.qqcircle.immersive.feed.cg;
import com.tencent.biz.qqcircle.immersive.feed.k;
import com.tencent.biz.qqcircle.immersive.feed.m;
import com.tencent.biz.qqcircle.immersive.feed.p;
import com.tencent.biz.qqcircle.immersive.feed.z;
import com.tencent.biz.qqcircle.immersive.layer.base.f;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.QFSLayerPublicAccountPageListPart;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.i;
import com.tencent.biz.qqcircle.immersive.part.QFSEmojiCommentPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerAlbumPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainShoppingCartPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart;
import com.tencent.biz.qqcircle.immersive.part.QFSQCircleTabGuideTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTagPolymerizationTaskDoneDialogPart;
import com.tencent.biz.qqcircle.immersive.part.ak;
import com.tencent.biz.qqcircle.immersive.part.cf;
import com.tencent.biz.qqcircle.immersive.part.cj;
import com.tencent.biz.qqcircle.immersive.part.cp;
import com.tencent.biz.qqcircle.immersive.part.dg;
import com.tencent.biz.qqcircle.immersive.part.dl;
import com.tencent.biz.qqcircle.immersive.part.dz;
import com.tencent.biz.qqcircle.immersive.part.ea;
import com.tencent.biz.qqcircle.immersive.part.ex;
import com.tencent.biz.qqcircle.immersive.part.ez;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u001c\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/a;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/f;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "w", "Lcom/tencent/biz/qqcircle/immersive/part/u;", HippyTKDListViewAdapter.X, "Lcom/tencent/biz/qqcircle/immersive/layer/base/a;", "builder", "", "Lcom/tencent/biz/richframework/part/Part;", "e", "g", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class a extends f {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    protected List<Part> e(@NotNull com.tencent.biz.qqcircle.immersive.layer.base.a builder) {
        List<Part> mutableListOf;
        Intrinsics.checkNotNullParameter(builder, "builder");
        u x16 = x(builder.b());
        QFSLayerAlbumPanelPart qFSLayerAlbumPanelPart = new QFSLayerAlbumPanelPart();
        ad adVar = new ad();
        QFSPersonalPanelPart qFSPersonalPanelPart = new QFSPersonalPanelPart();
        QFSEmojiCommentPanelPart qFSEmojiCommentPanelPart = new QFSEmojiCommentPanelPart();
        cp cpVar = new cp();
        bq bqVar = new bq();
        de deVar = new de();
        QFSSharePart qFSSharePart = new QFSSharePart();
        QCircleRichMediaDownLoadPart qCircleRichMediaDownLoadPart = new QCircleRichMediaDownLoadPart();
        QCircleLightInteractListPart qCircleLightInteractListPart = new QCircleLightInteractListPart();
        qCircleLightInteractListPart.setReportBeanAgent(builder.a());
        boolean z16 = false;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(x16, qFSLayerAlbumPanelPart, adVar, qFSPersonalPanelPart, bqVar, qFSEmojiCommentPanelPart, cpVar, deVar, qFSSharePart, qCircleRichMediaDownLoadPart, qCircleLightInteractListPart, new QFSMainShoppingCartPart(), new QFSPushRocketProgressPart(), new com.tencent.biz.qqcircle.immersive.part.push.a(), new k60.a(true), new QFSTagPolymerizationTaskDoneDialogPart(), new ak(), new aw());
        mutableListOf.add(new QFSReportBottomSheetPart());
        int i3 = 1;
        com.tencent.biz.qqcircle.helpers.f.f84618a.a(mutableListOf, builder.a(), true);
        if (!uq3.c.M6()) {
            mutableListOf.add(new QFSQCircleTabGuideTipExpPart(z16, i3, null));
            mutableListOf.add(new QFSMainTabTipExpPart(true));
        }
        if (cb.c()) {
            mutableListOf.add(new ez());
            mutableListOf.add(new ex());
        }
        com.tencent.biz.qqcircle.immersive.layer.base.b.a(mutableListOf);
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    protected List<Part> g(@NotNull com.tencent.biz.qqcircle.immersive.layer.base.a builder) {
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar;
        List<Part> mutableListOf;
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (builder instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a) {
            aVar = (com.tencent.biz.qqcircle.immersive.layer.biz.a) builder;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return new ArrayList();
        }
        cf cfVar = new cf();
        cfVar.aa(aVar.b());
        QCircleLayerBean b16 = aVar.b();
        Intrinsics.checkNotNullExpressionValue(b16, "defaultBuilder.initBean");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QFSLayerPublicAccountPageListPart(b16), cfVar, new cj(aVar.b()), new dl(v()), new dg(v()), new ea(), new dz());
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(QFSFeedChildLiteBannerPresenter.class, QFSFeedChildBottomInfoPresenter.class, QFSFeedChildRecommendAndPushPresenter.class, p.class, QFSFeedChildAvatarPresenter.class, al.class, com.tencent.biz.qqcircle.immersive.feed.u.class, bc.class, br.class, bk.class, ac.class, bm.class, QFSFeedChildAdShadePresenter.class, QFSFeedChildGameCardPresenter.class, z.class, com.tencent.biz.qqcircle.immersive.feed.ad.class, com.tencent.biz.qqcircle.immersive.feed.ak.class, QFSFeedMusicBannerPresenter.class, m.class, cg.class, QFSFeedChildPositiveFeedbackGuideFollowPresenter.class, QFSFeedChildContentQualityFeedbackPresenter.class, QFSFeedChildMutePresenter.class, g50.d.class, k.class);
        g.a(mutableListOf);
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(@Nullable QCircleInitBean initBean) {
        if ((initBean != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.g(initBean)) || an.d(initBean)) {
            return true;
        }
        return false;
    }

    @NotNull
    public u x(@Nullable QCircleInitBean initBean) {
        return new i();
    }
}
