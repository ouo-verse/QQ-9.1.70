package com.tencent.ditto;

import com.qzone.module.feedcomponent.ui.BirthdayCardFeedView;
import com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.CanvasPresentInfoView;
import com.qzone.module.feedcomponent.ui.CanvasPresentInfoViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.NewGuideView;
import com.qzone.module.feedcomponent.ui.PraiseListView;
import com.qzone.module.feedcomponent.ui.PraiseListViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedView;
import com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedDrawerView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedDrawerViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardView2;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardView2IdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQCircleTailView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQCircleTailViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAd;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyInf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DittoAreaViewInfo {
    public final Map<Class<? extends DittoAreaView>, DittoIdFuncPolyInf> idFuncPolyMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Holder {
        private static final DittoAreaViewInfo INSTANCE = new DittoAreaViewInfo();

        Holder() {
        }
    }

    DittoAreaViewInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put(QzoneSecretCanvasFeedView.class, new QzoneSecretCanvasFeedViewIdFuncPoly());
        hashMap.put(CanvasQzoneCardView.class, new CanvasQzoneCardViewIdFuncPoly());
        hashMap.put(CanvasFeedDrawerView.class, new CanvasFeedDrawerViewIdFuncPoly());
        hashMap.put(CanvasRecommAction.class, new CanvasRecommActionIdFuncPoly());
        hashMap.put(CanvasFriendPlayingCardView2.class, new CanvasFriendPlayingCardView2IdFuncPoly());
        hashMap.put(CanvasRecomFollowVerticalView.class, new CanvasRecomFollowVerticalViewIdFuncPoly());
        hashMap.put(CanvasLogoView.class, new CanvasLogoViewIdFuncPoly());
        hashMap.put(BirthdayCardFeedView.CanvasBirthdayView.class, new CanvasBirthdayViewIdFuncPoly());
        hashMap.put(NewGuideView.NewGuideCanvasView.class, new NewGuideCanvasViewIdFuncPoly());
        hashMap.put(CanvasRecommActionNonAd.class, new CanvasRecommActionNonAdIdFuncPoly());
        hashMap.put(CanvasQCircleTailView.class, new CanvasQCircleTailViewIdFuncPoly());
        hashMap.put(CanvasLeftThumbView.class, new CanvasLeftThumbViewIdFuncPoly());
        hashMap.put(CanvasCellCommentView.class, new CanvasCellCommentViewIdFuncPoly());
        hashMap.put(CanvasRecomFollowListItemView.class, new CanvasRecomFollowListItemViewIdFuncPoly());
        hashMap.put(CanvasPresentInfoView.class, new CanvasPresentInfoViewIdFuncPoly());
        hashMap.put(CanvasFeedContentView.class, new CanvasFeedContentViewIdFuncPoly());
        hashMap.put(CampusShardCardView.class, new CampusShardCardViewIdFuncPoly());
        hashMap.put(CanvasAttachView.class, new CanvasAttachViewIdFuncPoly());
        hashMap.put(CanvasPublicAccountContainerView.class, new CanvasPublicAccountContainerViewIdFuncPoly());
        hashMap.put(PraiseListView.class, new PraiseListViewIdFuncPoly());
        hashMap.put(CanvasTitleView.class, new CanvasTitleViewIdFuncPoly());
        hashMap.put(CanvasMakeDynamicView.class, new CanvasMakeDynamicViewIdFuncPoly());
        hashMap.put(CanvasFriendPlayingCardView.class, new CanvasFriendPlayingCardViewIdFuncPoly());
        this.idFuncPolyMap = Collections.unmodifiableMap(hashMap);
    }

    public static DittoAreaViewInfo getInstance() {
        return Holder.INSTANCE;
    }
}
