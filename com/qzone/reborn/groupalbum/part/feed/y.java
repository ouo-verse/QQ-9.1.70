package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/y;", "Lcom/qzone/reborn/base/k;", "Lai/d;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "t1", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mDetailTitle", "e", "Landroid/view/View;", "mItemView", "f", "mGroupAlbumEntranceView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class y extends com.qzone.reborn.base.k implements ai.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mDetailTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mGroupAlbumEntranceView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel, y this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(this$0.getContext(), "mqzone://arouse/groupalbum/homealbum?groupid=" + groupAlbumFeedDetailViewModel.getGroupId());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(y this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("toggle_share_panel", null);
        fo.c.d("em_qz_on_the_feed_entrance", "pg_qz_group_album_dynamic_details", view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(y this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fo.c.f("em_qz_on_the_feed_entrance", "pg_qz_group_album_dynamic_details", this$0.mItemView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumFeedxDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        View view;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, ai.d.class);
        QZoneCommonTitle qZoneCommonTitle = (QZoneCommonTitle) rootView.findViewById(R.id.mz9);
        this.mDetailTitle = qZoneCommonTitle;
        View view2 = null;
        TextView mCenterTitle = qZoneCommonTitle != null ? qZoneCommonTitle.getMCenterTitle() : null;
        if (mCenterTitle != null) {
            mCenterTitle.setText(com.qzone.util.l.a(R.string.mvm));
        }
        QZoneCommonTitle qZoneCommonTitle2 = this.mDetailTitle;
        if (qZoneCommonTitle2 != null) {
            qZoneCommonTitle2.setupTitleHeight(QZoneFeedxViewUtils.b(getActivity()));
        }
        final GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        if (groupAlbumFeedDetailViewModel.getFromArk()) {
            QZoneCommonTitle qZoneCommonTitle3 = this.mDetailTitle;
            if (qZoneCommonTitle3 != null) {
                String a16 = com.qzone.util.l.a(R.string.gdl);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        y.F9(GroupAlbumFeedDetailViewModel.this, this, view3);
                    }
                };
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026.qzone_default_qun_album)");
                view = qZoneCommonTitle3.e(new uh.d(R.drawable.qui_image, null, onClickListener, null, a16, false, 42, null));
            } else {
                view = null;
            }
            this.mGroupAlbumEntranceView = view;
        }
        if (groupAlbumFeedDetailViewModel.getFromArk()) {
            return;
        }
        QZoneCommonTitle qZoneCommonTitle4 = this.mDetailTitle;
        if (qZoneCommonTitle4 != null) {
            String a17 = com.qzone.util.l.a(R.string.akv);
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    y.G9(y.this, view3);
                }
            };
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(com.tencent.mobile\u2026il_button_top_right_more)");
            view2 = qZoneCommonTitle4.c(new uh.d(R.drawable.qui_more, null, onClickListener2, null, a17, false, 42, null));
        }
        this.mItemView = view2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        View view = this.mItemView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.v
                @Override // java.lang.Runnable
                public final void run() {
                    y.H9(y.this);
                }
            });
        }
    }

    @Override // ai.d
    public void t1() {
        broadcastMessage("SCROLL_TO_TOP", null);
    }
}
