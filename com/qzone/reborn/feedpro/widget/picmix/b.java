package com.qzone.reborn.feedpro.widget.picmix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView;
import com.qzone.util.l;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000278B\u0007\u00a2\u0006\u0004\b4\u00105J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017J\u001a\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00103\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/b;", "Lcom/qzone/reborn/base/i;", "Lcom/qzone/reborn/feedpro/widget/picmix/b$b;", "Landroid/view/View;", "view", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "onBindViewHolder", "getItemViewType", "getItemCount", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "mediaList", "l0", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "listener", "o0", "dataPosInList", "n0", "multiBorderWidth", "p0", "", "enableOverLimitView", "m0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mMediaList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "mFeedData", "D", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "mItemClickListener", "E", "I", "mFeedPosition", UserInfo.SEX_FEMALE, "mMultiBorderWidth", "G", "Z", "mEnableOverLimitView", "<init>", "()V", "H", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends com.qzone.reborn.base.i<C0459b> {

    /* renamed from: C, reason: from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: D, reason: from kotlin metadata */
    private QzoneFeedProPicMixVideoView.b mItemClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    private int mFeedPosition;

    /* renamed from: F, reason: from kotlin metadata */
    private int mMultiBorderWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mEnableOverLimitView = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonMedia> mMediaList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J8\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "pictureItemList", "", "position", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "feedPosition", "multiBorderWidth", "", "l", "", "E", "Z", "getMEnableOverLimitView", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "mEnableOverLimitView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.widget.picmix.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0459b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private boolean mEnableOverLimitView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0459b(View itemView, boolean z16) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.mEnableOverLimitView = z16;
        }

        public final void l(List<CommonMedia> pictureItemList, int position, CommonFeed feedData, int feedPosition, int multiBorderWidth) {
            View view = this.itemView;
            QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = view instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) view : null;
            if (qzoneFeedProMixBaseWidgetView == null || pictureItemList == null) {
                return;
            }
            CommonCellMedia cellMedia = feedData != null ? feedData.getCellMedia() : null;
            int uploadNum = cellMedia != null ? cellMedia.getUploadNum() : 0;
            if (this.mEnableOverLimitView && position > 0 && pictureItemList.size() == position + 1 && uploadNum > pictureItemList.size()) {
                qzoneFeedProMixBaseWidgetView.A0(uploadNum - pictureItemList.size());
            } else {
                qzoneFeedProMixBaseWidgetView.x0();
            }
            qzoneFeedProMixBaseWidgetView.setItemViewMultiBorderWidth(multiBorderWidth);
            if (feedData != null) {
                qzoneFeedProMixBaseWidgetView.setFeedData(feedData);
            }
            qzoneFeedProMixBaseWidgetView.setFeedPosition(feedPosition);
            qzoneFeedProMixBaseWidgetView.setPicPosition(position);
            qzoneFeedProMixBaseWidgetView.setData(pictureItemList.get(position), position);
        }

        public final void m(boolean z16) {
            this.mEnableOverLimitView = z16;
        }
    }

    public b() {
        setHasStableIds(true);
    }

    private final void j0(View view, CommonMedia media) {
        Integer type;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(this.mFeedData));
        int i3 = 0;
        if (media != null && (type = media.getType()) != null && type.intValue() == 1) {
            i3 = 1;
        }
        linkedHashMap.put("click_type", Integer.valueOf(i3));
        fo.c.b("dt_clck", view, "em_qz_feed_picture", new fo.b().l(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, CommonMedia pictureItem, int i3, RecyclerView.ViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pictureItem, "$pictureItem");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        QzoneFeedProPicMixVideoView.b bVar = this$0.mItemClickListener;
        if (bVar != null) {
            bVar.a(pictureItem, i3, view);
        }
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        this$0.j0(view2, pictureItem);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<CommonMedia> list = this.mMediaList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object orNull;
        Integer type;
        List<CommonMedia> list = this.mMediaList;
        if (list == null) {
            return 0;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, position);
        CommonMedia commonMedia = (CommonMedia) orNull;
        return (commonMedia == null || (type = commonMedia.getType()) == null || type.intValue() != 1 || commonMedia.getVideo() == null) ? 0 : 1;
    }

    public final void l0(CommonFeed feedData, List<CommonMedia> mediaList) {
        this.mFeedData = feedData;
        this.mMediaList = mediaList;
    }

    public final void m0(boolean enableOverLimitView) {
        this.mEnableOverLimitView = enableOverLimitView;
    }

    public final void n0(int dataPosInList) {
        this.mFeedPosition = dataPosInList;
    }

    public final void o0(QzoneFeedProPicMixVideoView.b listener) {
        this.mItemClickListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        List<CommonMedia> list;
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        C0459b c0459b = holder instanceof C0459b ? (C0459b) holder : null;
        if (c0459b == null || (list = this.mMediaList) == null) {
            return;
        }
        c0459b.m(this.mEnableOverLimitView);
        c0459b.l(list, position, this.mFeedData, this.mFeedPosition, this.mMultiBorderWidth);
        if (position < list.size()) {
            final CommonMedia commonMedia = list.get(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.picmix.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.k0(b.this, commonMedia, position, holder, view);
                }
            });
            View view = holder.itemView;
            QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = view instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) view : null;
            boolean z16 = false;
            if (qzoneFeedProMixBaseWidgetView != null && qzoneFeedProMixBaseWidgetView.y0()) {
                z16 = true;
            }
            if (z16) {
                AccessibilityUtil.p(holder.itemView, l.a(R.string.f2202668n));
                return;
            }
            if (getItemViewType(position) == 0) {
                str = "\u56fe\u7247\u7b2c" + (position + 1) + "\u5f20\u5171" + list.size() + "\u5f20";
            } else {
                str = "\u89c6\u9891\u7b2c" + (position + 1) + "\u4e2a\u5171" + list.size() + "\u4e2a";
            }
            AccessibilityUtil.p(holder.itemView, str);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new C0459b(new QzoneFeedProVideoItemWidgetView(context, null, 0, 6, null), this.mEnableOverLimitView);
        }
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
        return new C0459b(new QzoneFeedProPicWidgetView(context2), this.mEnableOverLimitView);
    }

    public final void p0(int multiBorderWidth) {
        this.mMultiBorderWidth = multiBorderWidth;
    }
}
