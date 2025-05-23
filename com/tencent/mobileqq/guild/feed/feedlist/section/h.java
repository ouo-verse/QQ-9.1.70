package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J0\u0010\u0010\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/h;", "Ltk1/a;", "Lrj1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "mFeedShareContentHelper", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class h extends tk1.a<rj1.b> {

    /* renamed from: C, reason: from kotlin metadata */
    private FeedShareContentHelper mFeedShareContentHelper;

    public h() {
        super(FeedListSectionType.ShareContent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.we7};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        FeedShareContentHelper feedShareContentHelper = new FeedShareContentHelper();
        feedShareContentHelper.s(p().findViewById(R.id.f165624x04));
        feedShareContentHelper.r((ImageView) p().findViewById(R.id.x06));
        feedShareContentHelper.p((TextView) p().findViewById(R.id.f165623x03));
        feedShareContentHelper.t((TextView) p().findViewById(R.id.x07));
        feedShareContentHelper.q((TextView) p().findViewById(R.id.f165625x05));
        feedShareContentHelper.u(Integer.valueOf(p().getResources().getColor(R.color.qui_common_brand_standard)));
        this.mFeedShareContentHelper = feedShareContentHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<rj1.b> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        GProThirdBar G = r().G();
        if (G != null) {
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
