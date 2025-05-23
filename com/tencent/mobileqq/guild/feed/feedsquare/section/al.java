package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J*\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/al;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "e", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "mFeedShareContentHelper", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class al extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FeedShareContentHelper mFeedShareContentHelper;

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        GProThirdBar gProThirdBar;
        ij1.g blockData;
        GProStFeed b16;
        Activity activity = null;
        if (data != null && (blockData = data.getBlockData()) != null && (b16 = blockData.b()) != null) {
            gProThirdBar = b16.thirdBar;
        } else {
            gProThirdBar = null;
        }
        if (gProThirdBar == null) {
            return;
        }
        String str = gProThirdBar.f359315id;
        Intrinsics.checkNotNullExpressionValue(str, "barData.id");
        String str2 = gProThirdBar.icon;
        Intrinsics.checkNotNullExpressionValue(str2, "barData.icon");
        String str3 = gProThirdBar.title;
        Intrinsics.checkNotNullExpressionValue(str3, "barData.title");
        String str4 = gProThirdBar.desc;
        Intrinsics.checkNotNullExpressionValue(str4, "barData.desc");
        String str5 = gProThirdBar.contentScheme;
        Intrinsics.checkNotNullExpressionValue(str5, "barData.contentScheme");
        String str6 = gProThirdBar.buttonText;
        Intrinsics.checkNotNullExpressionValue(str6, "barData.buttonText");
        String str7 = gProThirdBar.buttonScheme;
        Intrinsics.checkNotNullExpressionValue(str7, "barData.buttonScheme");
        FeedShareContentHelper.ShareContentData shareContentData = new FeedShareContentHelper.ShareContentData(str, str2, str3, str4, str5, str6, str7);
        FeedShareContentHelper feedShareContentHelper = this.mFeedShareContentHelper;
        if (feedShareContentHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedShareContentHelper");
            feedShareContentHelper = null;
        }
        Context context = getRootView().getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        feedShareContentHelper.e(activity, shareContentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.we7};
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

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareShareContentSection";
    }
}
