package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/o;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "d", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "mFeedShareContentHelper", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class o extends b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FeedShareContentHelper mFeedShareContentHelper;

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        GProThirdBar G;
        Intrinsics.checkNotNullParameter(data, "data");
        qj1.h d16 = data.d();
        if (d16 != null && (G = d16.G()) != null) {
            FeedShareContentHelper feedShareContentHelper = this.mFeedShareContentHelper;
            Activity activity = null;
            if (feedShareContentHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedShareContentHelper");
                feedShareContentHelper = null;
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
            feedShareContentHelper.e(activity, new FeedShareContentHelper.ShareContentData(id5, icon, title, desc, contentScheme, buttonText, buttonScheme));
        }
    }
}
