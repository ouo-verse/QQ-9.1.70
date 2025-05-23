package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredAdItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredTopAdItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredAutoPlayVideoSmallItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredAutoVideoItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredCardFeedItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredNormalItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredPYMKListItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredSinglePYMKItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.j;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewholder/QFSPublicAccountStaggeredItemViewFactory;", "", "", "c", "position", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "supportAutoPlay", "isMaskAd", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewholder/QFSPublicAccountStaggeredItemViewFactory$ItemType;", "a", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "b", "<init>", "()V", "ItemType", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredItemViewFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountStaggeredItemViewFactory f87123a = new QFSPublicAccountStaggeredItemViewFactory();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewholder/QFSPublicAccountStaggeredItemViewFactory$ItemType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "AD", "AUTO_PLAY_VIDEO", "MASK_AD", "CARD", "AUTO_PLAY_VIDEO_SMALL", "SINGLE_USER_PYMK", "PYMK_LIST", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum ItemType {
        NORMAL(1),
        AD(2),
        AUTO_PLAY_VIDEO(3),
        MASK_AD(4),
        CARD(5),
        AUTO_PLAY_VIDEO_SMALL(6),
        SINGLE_USER_PYMK(7),
        PYMK_LIST(8);

        private final int type;

        ItemType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    QFSPublicAccountStaggeredItemViewFactory() {
    }

    @NotNull
    public final ItemType a(int position, @NotNull FeedCloudMeta$StFeed feed, boolean supportAutoPlay, boolean isMaskAd) {
        boolean z16;
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (isMaskAd && position == 0) {
            return ItemType.MASK_AD;
        }
        boolean z17 = true;
        if (feed.feedType.get() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return ItemType.AD;
        }
        if (feed.type.get() != 3) {
            z17 = false;
        }
        JSONObject d16 = d.d(feed);
        if (position == 0 && z17 && j.a(d16)) {
            return ItemType.AUTO_PLAY_VIDEO;
        }
        if (position == 0 && z17 && supportAutoPlay) {
            return ItemType.AUTO_PLAY_VIDEO_SMALL;
        }
        if (feed.dittoFeed.dittoId.get() == 42) {
            return ItemType.CARD;
        }
        if (feed.dittoFeed.dittoId.get() == 45) {
            return ItemType.SINGLE_USER_PYMK;
        }
        if (feed.dittoFeed.dittoId.get() == 46) {
            return ItemType.PYMK_LIST;
        }
        return ItemType.NORMAL;
    }

    @NotNull
    public final QCircleBaseWidgetView<b> b(@NotNull ViewGroup parent, int viewType, @NotNull a operator, @NotNull QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (viewType == ItemType.AUTO_PLAY_VIDEO.getType()) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new QFSPublicAccountStaggeredAutoVideoItemView(context, initBean, operator);
        }
        if (viewType == ItemType.AD.getType()) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            return new QFSPublicAccountStaggeredAdItemView(context2, initBean, operator);
        }
        if (viewType == ItemType.MASK_AD.getType()) {
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            return new QFSPublicAccountStaggeredTopAdItemView(context3, initBean, operator);
        }
        if (viewType == ItemType.CARD.getType()) {
            return new QFSPublicAccountStaggeredCardFeedItemView(parent.getContext(), initBean);
        }
        if (viewType == ItemType.AUTO_PLAY_VIDEO_SMALL.getType()) {
            Context context4 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
            return new QFSPublicAccountStaggeredAutoPlayVideoSmallItemView(context4, initBean, operator);
        }
        if (viewType == ItemType.SINGLE_USER_PYMK.getType()) {
            Context context5 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
            return new QFSPublicAccountStaggeredSinglePYMKItemView(context5, operator);
        }
        if (viewType == ItemType.PYMK_LIST.getType()) {
            Context context6 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "parent.context");
            return new QFSPublicAccountStaggeredPYMKListItemView(context6, operator);
        }
        Context context7 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "parent.context");
        return new QFSPublicAccountStaggeredNormalItemView(context7, initBean, operator);
    }

    public final int c() {
        return ItemType.values().length;
    }
}
