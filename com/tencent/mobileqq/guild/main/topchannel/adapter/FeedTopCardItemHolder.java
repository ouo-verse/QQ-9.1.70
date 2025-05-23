package com.tencent.mobileqq.guild.main.topchannel.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.main.topchannel.widget.FeedTopCardThumbView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedThumbnail;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.au;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/main/topchannel/adapter/FeedTopCardItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "summaryData", DomainData.DOMAIN_NAME, "Landroid/view/View$OnClickListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lvp1/au;", "E", "Lvp1/au;", "binding", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "itemViewContainer", "", "Lcom/tencent/mobileqq/guild/main/topchannel/widget/FeedTopCardThumbView;", "G", "Ljava/util/List;", "mediaViews", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "feedSummaryTv", "I", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "<init>", "(Lvp1/au;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FeedTopCardItemHolder extends RecyclerView.ViewHolder {

    @NotNull
    private static final Lazy<Integer> K;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final au binding;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout itemViewContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<FeedTopCardThumbView> mediaViews;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView feedSummaryTv;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private IGProFeedSummary summaryData;

    static {
        Lazy<Integer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.main.topchannel.adapter.FeedTopCardItemHolder$Companion$size$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QQGuildUIUtil.f(16.0f));
            }
        });
        K = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTopCardItemHolder(@NotNull au binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.mediaViews = new ArrayList();
        LinearLayout linearLayout = binding.f442314b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.feedTopCardItemContainer");
        this.itemViewContainer = linearLayout;
        TextView textView = binding.f442315c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.feedTopCardItemSummary");
        this.feedSummaryTv = textView;
    }

    private final void m() {
        boolean z16;
        ArrayList<IGProFeedThumbnail> arrayList;
        int coerceAtMost;
        int i3;
        ArrayList<IGProFeedThumbnail> feedThumbnails;
        IGProFeedSummary iGProFeedSummary = this.summaryData;
        if (iGProFeedSummary != null && (feedThumbnails = iGProFeedSummary.getFeedThumbnails()) != null && (!feedThumbnails.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.mediaViews.isEmpty()) {
            TraceUtils.h("topCard_feed_item_inflatePic");
            List<FeedTopCardThumbView> list = this.mediaViews;
            View inflate = this.binding.f442316d.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.topchannel.widget.FeedTopCardThumbView");
            list.add((FeedTopCardThumbView) inflate);
            List<FeedTopCardThumbView> list2 = this.mediaViews;
            View inflate2 = this.binding.f442317e.inflate();
            Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.topchannel.widget.FeedTopCardThumbView");
            list2.add((FeedTopCardThumbView) inflate2);
            List<FeedTopCardThumbView> list3 = this.mediaViews;
            View inflate3 = this.binding.f442318f.inflate();
            Intrinsics.checkNotNull(inflate3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.topchannel.widget.FeedTopCardThumbView");
            list3.add((FeedTopCardThumbView) inflate3);
            TraceUtils.k();
        }
        TraceUtils.h("topCard_feed_item_bindPic");
        Iterator<T> it = this.mediaViews.iterator();
        while (it.hasNext()) {
            ((FeedTopCardThumbView) it.next()).setVisibility(8);
        }
        IGProFeedSummary iGProFeedSummary2 = this.summaryData;
        if (iGProFeedSummary2 != null) {
            arrayList = iGProFeedSummary2.getFeedThumbnails();
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(3, arrayList.size());
            int size = arrayList.size();
            for (int i16 = 0; i16 < size && i16 < coerceAtMost; i16++) {
                IGProFeedThumbnail iGProFeedThumbnail = arrayList.get(i16);
                FeedTopCardThumbView feedTopCardThumbView = this.mediaViews.get(i16);
                String url = iGProFeedThumbnail.getUrl();
                if (iGProFeedThumbnail.getIsVideoCover()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                feedTopCardThumbView.setThumbData(url, i3);
                this.mediaViews.get(i16).setVisibility(0);
            }
            TraceUtils.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FeedTopCardItemHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    public final void n(@NotNull IGProFeedSummary summaryData) {
        Intrinsics.checkNotNullParameter(summaryData, "summaryData");
        this.summaryData = summaryData;
        this.feedSummaryTv.setText(summaryData.getTitle());
        this.binding.getRoot().setTag(summaryData);
        if (summaryData.getFeedThumbnails().isEmpty()) {
            Iterator<T> it = this.mediaViews.iterator();
            while (it.hasNext()) {
                ((FeedTopCardThumbView) it.next()).setVisibility(8);
            }
            return;
        }
        this.itemViewContainer.post(new Runnable() { // from class: com.tencent.mobileqq.guild.main.topchannel.adapter.b
            @Override // java.lang.Runnable
            public final void run() {
                FeedTopCardItemHolder.o(FeedTopCardItemHolder.this);
            }
        });
    }

    public final void p() {
        this.binding.getRoot().setOnClickListener(null);
    }

    public final void q(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding.getRoot().setOnClickListener(listener);
    }
}
