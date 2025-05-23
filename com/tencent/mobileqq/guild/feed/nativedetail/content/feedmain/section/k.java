package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J4\u0010\u0011\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/k;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "d", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "mFeedShareContentHelper", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FeedShareContentHelper mFeedShareContentHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v3a};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        FeedShareContentHelper feedShareContentHelper = new FeedShareContentHelper();
        feedShareContentHelper.s(containerView.findViewById(R.id.f165624x04));
        feedShareContentHelper.r((ImageView) containerView.findViewById(R.id.x06));
        feedShareContentHelper.p((TextView) containerView.findViewById(R.id.f165623x03));
        feedShareContentHelper.t((TextView) containerView.findViewById(R.id.x07));
        feedShareContentHelper.q((TextView) containerView.findViewById(R.id.f165625x05));
        feedShareContentHelper.u(Integer.valueOf(containerView.getResources().getColor(R.color.qui_common_brand_standard)));
        this.mFeedShareContentHelper = feedShareContentHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!super.q(payload) && payload.getType() != 6) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        FeedShareContentHelper feedShareContentHelper = this.mFeedShareContentHelper;
        Activity activity = null;
        if (feedShareContentHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedShareContentHelper");
            feedShareContentHelper = null;
        }
        View mContentLayout = feedShareContentHelper.getMContentLayout();
        if (mContentLayout != null) {
            mContentLayout.setVisibility(8);
        }
        if (data == 0) {
            return;
        }
        this.mData = data;
        GProThirdBar G = data.getFeedDetail().G();
        if (G != null) {
            FeedShareContentHelper feedShareContentHelper2 = this.mFeedShareContentHelper;
            if (feedShareContentHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedShareContentHelper");
                feedShareContentHelper2 = null;
            }
            Context context = getRootView().getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            String id5 = G.f359315id;
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            String icon = G.icon;
            Intrinsics.checkNotNullExpressionValue(icon, "icon");
            String title = G.title;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            String desc = G.desc;
            Intrinsics.checkNotNullExpressionValue(desc, "desc");
            String contentScheme = G.contentScheme;
            Intrinsics.checkNotNullExpressionValue(contentScheme, "contentScheme");
            String buttonText = G.buttonText;
            Intrinsics.checkNotNullExpressionValue(buttonText, "buttonText");
            String buttonScheme = G.buttonScheme;
            Intrinsics.checkNotNullExpressionValue(buttonScheme, "buttonScheme");
            feedShareContentHelper2.e(activity, new FeedShareContentHelper.ShareContentData(id5, icon, title, desc, contentScheme, buttonText, buttonScheme));
        }
    }
}
