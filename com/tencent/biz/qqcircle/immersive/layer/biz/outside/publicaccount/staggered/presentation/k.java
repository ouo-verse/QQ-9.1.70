package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.widget.QFSPublicAccountPYMKUserCardItemView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ$\u0010\u0010\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001dj\b\u0012\u0004\u0012\u00020\u0002`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/k;", "Lcom/tencent/biz/qqcircle/immersive/adapter/a;", "Lqqcircle/QQCircleDitto$StItemInfo;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "", "userList", "", "k0", "removeIdx", "", "hasInsert", "i0", "getItemCount", "holder", "position", "onBindViewHolder", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfeedcloud/FeedCloudMeta$StFeed;", "getMFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "j0", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "mFeed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mUserList", "<init>", "()V", "D", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class k extends com.tencent.biz.qqcircle.immersive.adapter.a<QQCircleDitto$StItemInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<QQCircleDitto$StItemInfo> mUserList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/k$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lqqcircle/QQCircleDitto$StItemInfo;", "info", "", com.tencent.luggage.wxa.c8.c.G, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", ITVKPlayerEventListener.KEY_USER_INFO, "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        private final void m(QQCircleDitto$StItemInfo info, int pos) {
            VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
            HashMap hashMap = new HashMap();
            String str = info.f429300id.get();
            Intrinsics.checkNotNullExpressionValue(str, "info.id.get()");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_INDEX, Integer.valueOf(pos + 1));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_MODULE_TYPE, 4);
            VideoReport.setElementReuseIdentifier(this.itemView, info.f429300id.get());
            VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementParams(this.itemView, hashMap);
        }

        public final void l(@Nullable FeedCloudMeta$StFeed feed, @NotNull QQCircleDitto$StItemInfo userInfo, int pos, @NotNull QCircleReportBean reportBean) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            Intrinsics.checkNotNullParameter(reportBean, "reportBean");
            View view = this.itemView;
            if (view instanceof QFSPublicAccountPYMKUserCardItemView) {
                ((QFSPublicAccountPYMKUserCardItemView) view).setReportBean(reportBean);
                ((QFSPublicAccountPYMKUserCardItemView) this.itemView).setMFeed(feed);
                ((QFSPublicAccountPYMKUserCardItemView) this.itemView).bindData(userInfo, pos);
                m(userInfo, pos);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mUserList.size();
    }

    public final void i0(@NotNull List<QQCircleDitto$StItemInfo> userList, int removeIdx, boolean hasInsert) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        notifyItemRemoved(removeIdx);
        this.mUserList.clear();
        this.mUserList.addAll(userList);
        if (hasInsert) {
            notifyItemInserted(this.mUserList.size() - 1);
        }
    }

    public final void j0(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
    }

    public final void k0(@NotNull List<QQCircleDitto$StItemInfo> userList) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        notifyItemRangeRemoved(0, this.mUserList.size());
        this.mUserList.clear();
        this.mUserList.addAll(userList);
        notifyItemRangeInserted(0, this.mUserList.size());
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof b) || position > this.mUserList.size()) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUserList.get(position);
        Intrinsics.checkNotNullExpressionValue(qQCircleDitto$StItemInfo, "mUserList[position]");
        QCircleReportBean reportBean = getReportBean();
        Intrinsics.checkNotNullExpressionValue(reportBean, "reportBean");
        ((b) holder).l(feedCloudMeta$StFeed, qQCircleDitto$StItemInfo, position, reportBean);
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QFSPublicAccountPYMKUserCardItemView qFSPublicAccountPYMKUserCardItemView = new QFSPublicAccountPYMKUserCardItemView(context);
        qFSPublicAccountPYMKUserCardItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new b(qFSPublicAccountPYMKUserCardItemView);
    }
}
