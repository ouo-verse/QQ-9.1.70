package a40;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedAlbum$StFeedDetail;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"La40/l;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "La40/l$a;", "", "Lqqcircle/QQCircleFeedAlbum$StFeedDetail;", "details", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "detailsList", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QQCircleFeedAlbum$StFeedDetail> detailsList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u000e\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001f\u00a8\u0006%"}, d2 = {"La40/l$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqqcircle/QQCircleFeedAlbum$StFeedDetail;", "detail", "", com.tencent.luggage.wxa.c8.c.G, "l", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "itemLayout", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "coverIv", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "G", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "contentTv", "H", "Lqqcircle/QQCircleFeedAlbum$StFeedDetail;", "I", "itemView", "<init>", "(Landroid/view/View;)V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout itemLayout;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundCornerImageView coverIv;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final QCircleAsyncTextView contentTv;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private QQCircleFeedAlbum$StFeedDetail detail;

        /* renamed from: I, reason: from kotlin metadata */
        private int pos;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f518929b);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qfs_related_album_item)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            this.itemLayout = linearLayout;
            View findViewById2 = itemView.findViewById(R.id.f363814e);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.qfs_cover_iv)");
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById2;
            this.coverIv = roundCornerImageView;
            View findViewById3 = itemView.findViewById(R.id.f365814y);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.qfs_desc_text)");
            QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) findViewById3;
            this.contentTv = qCircleAsyncTextView;
            qCircleAsyncTextView.setSpecialClickAreaColor(QFSQUIUtilsKt.d(itemView.getContext(), R.color.qui_common_text_primary), true);
            roundCornerImageView.setCorner(ViewUtils.dip2px(4.0f));
            linearLayout.setOnClickListener(this);
        }

        private final void m() {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            QQCircleFeedAlbum$StFeedDetail qQCircleFeedAlbum$StFeedDetail = this.detail;
            if (qQCircleFeedAlbum$StFeedDetail != null && (feedCloudMeta$StFeed2 = qQCircleFeedAlbum$StFeedDetail.feed) != null) {
                feedCloudMeta$StFeed = feedCloudMeta$StFeed2.get();
            } else {
                feedCloudMeta$StFeed = null;
            }
            if (feedCloudMeta$StFeed == null) {
                return;
            }
            List<FeedCloudMeta$FeedAlbumInfo> list = feedCloudMeta$StFeed.album_infos.get();
            Intrinsics.checkNotNullExpressionValue(list, "feed.album_infos.get()");
            if (list.isEmpty()) {
                return;
            }
            FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = feedCloudMeta$StFeed.album_infos.get().get(0);
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$FeedAlbumInfo, "feed.album_infos.get()[0]");
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(feedCloudMeta$FeedAlbumInfo.album.f398441id.get()));
            VideoReport.setElementId(this.itemLayout, QCircleDaTongConstant.ElementId.EM_XSJ_REC_ALBUM_LIST);
            VideoReport.setElementParams(this.itemLayout, params);
            VideoReport.setElementClickPolicy(this.itemLayout, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(this.itemLayout, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(this.itemLayout, EndExposurePolicy.REPORT_NONE);
            VideoReport.setElementReuseIdentifier(this.itemLayout, QCircleDaTongConstant.ElementId.EM_XSJ_REC_ALBUM_LIST + hashCode() + feedCloudMeta$StFeed.f398449id.get());
        }

        private final void n(FeedCloudMeta$StFeed feed) {
            FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo;
            int i3;
            PBUInt32Field pBUInt32Field;
            String str = feed.content.get();
            if (feed.album_infos.get() != null && feed.album_infos.get().size() > 0) {
                feedCloudMeta$FeedAlbumInfo = feed.album_infos.get().get(0);
            } else {
                feedCloudMeta$FeedAlbumInfo = null;
            }
            if (feedCloudMeta$FeedAlbumInfo != null && (pBUInt32Field = feedCloudMeta$FeedAlbumInfo.feed_serial_number) != null) {
                i3 = pBUInt32Field.get();
            } else {
                i3 = this.pos;
            }
            String string = this.itemView.getContext().getResources().getString(R.string.f195764fh, Integer.valueOf(i3));
            Intrinsics.checkNotNullExpressionValue(string, "itemView.context.resourc\u2026tem_empty_content, index)");
            if (!TextUtils.isEmpty(str)) {
                string = string + "\uff1a" + str;
            }
            this.contentTv.setText((CharSequence) string, false);
        }

        private final void o() {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            QQCircleFeedAlbum$StFeedDetail qQCircleFeedAlbum$StFeedDetail = this.detail;
            if (qQCircleFeedAlbum$StFeedDetail != null && (feedCloudMeta$StFeed2 = qQCircleFeedAlbum$StFeedDetail.feed) != null) {
                feedCloudMeta$StFeed = feedCloudMeta$StFeed2.get();
            } else {
                feedCloudMeta$StFeed = null;
            }
            if (feedCloudMeta$StFeed == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed.album_infos.get(), "feed.album_infos.get()");
            if (!r1.isEmpty()) {
                FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = feedCloudMeta$StFeed.album_infos.get().get(0);
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$FeedAlbumInfo, "feed.album_infos.get()[0]");
                QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$FeedAlbumInfo.album.f398441id.get());
                qCircleFeedAlbumInfo.isDraft = false;
                QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
                qCircleAlbumBean.setNeedShowAlbumPanel(false);
                qCircleAlbumBean.setSourceType(52);
                qCircleAlbumBean.setDataPosInList(this.pos);
                qCircleAlbumBean.setFeed(feedCloudMeta$StFeed);
                qCircleAlbumBean.setPreRenderType(10011);
                com.tencent.biz.qqcircle.launcher.c.u(this.itemView.getContext(), qCircleAlbumBean);
            }
        }

        public final void l(@NotNull QQCircleFeedAlbum$StFeedDetail detail, int pos) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.detail = detail;
            this.pos = pos;
            FeedCloudMeta$StFeed feed = detail.feed.get();
            Intrinsics.checkNotNullExpressionValue(feed, "feed");
            n(feed);
            Option targetView = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(this.coverIv);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView);
            m();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            o();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.detailsList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (ab0.a.a(position, this.detailsList)) {
            return;
        }
        holder.l(this.detailsList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gq9, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(itemView);
    }

    public final void setData(@NotNull List<QQCircleFeedAlbum$StFeedDetail> details) {
        Intrinsics.checkNotNullParameter(details, "details");
        this.detailsList.clear();
        this.detailsList.addAll(details);
        notifyDataSetChanged();
    }
}
