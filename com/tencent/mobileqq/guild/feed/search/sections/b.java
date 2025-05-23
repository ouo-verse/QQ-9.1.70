package com.tencent.mobileqq.guild.feed.search.sections;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0014J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/b;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "commentCount", "", "r", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "p", "", "attached", "onAttachedChanged", "newFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "feedTime", "e", "likeAndCommentCount", "f", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends Section<pn1.a> implements Observer<GProStFeed> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView feedTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView likeAndCommentCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStFeed stFeed;

    private final void r(int likeCount, int commentCount) {
        String str;
        String str2;
        String str3 = "";
        if (likeCount <= 0) {
            str = "";
        } else {
            QRouteApi api = QRoute.api(IGuildFeedUtilsApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedUtilsApi::class.java)");
            str = IGuildFeedUtilsApi.a.a((IGuildFeedUtilsApi) api, likeCount, null, null, 6, null) + "\u8d5e";
        }
        if (commentCount > 0) {
            QRouteApi api2 = QRoute.api(IGuildFeedUtilsApi.class);
            Intrinsics.checkNotNullExpressionValue(api2, "api(IGuildFeedUtilsApi::class.java)");
            str3 = IGuildFeedUtilsApi.a.a((IGuildFeedUtilsApi) api2, commentCount, null, null, 6, null) + "\u8bc4";
        }
        TextView textView = this.likeAndCommentCount;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeAndCommentCount");
            textView = null;
        }
        if (likeCount > 0 && commentCount > 0) {
            str2 = str + " \u00b7 " + str3;
        } else {
            str2 = str + str3;
        }
        textView.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f165511we1};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        String str;
        GProStFeed gProStFeed = this.stFeed;
        if (gProStFeed != null) {
            str = gProStFeed.idd;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (attached) {
            jj1.b.c().observerGlobalState(this.stFeed, this);
        } else {
            jj1.b.c().removeObserverGlobalState(this.stFeed, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.c8z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.feed_time)");
        this.feedTime = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f166052yi4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d.like_and_comment_count)");
        this.likeAndCommentCount = (TextView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull pn1.a data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.stFeed = data.getGetRawFeedData();
        TextView textView = this.feedTime;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTime");
            textView = null;
        }
        textView.setText(ax.z(data.d().m(), data.d().getCreateTime(), data.d().z()));
        r(data.d().e(), data.d().getCommentCount());
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newFeed) {
        String str;
        if (newFeed != null) {
            String str2 = newFeed.idd;
            GProStFeed gProStFeed = this.stFeed;
            GuildFeedRichMediaData guildFeedRichMediaData = null;
            byte b16 = 0;
            if (gProStFeed != null) {
                str = gProStFeed.idd;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str2, str)) {
                GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(newFeed, guildFeedRichMediaData, 2, b16 == true ? 1 : 0);
                r(gProStFeedDetailRspWrapper.e(), gProStFeedDetailRspWrapper.getCommentCount());
            }
        }
    }
}
