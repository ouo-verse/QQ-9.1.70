package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.view.View;
import com.qzone.feed.utils.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010,J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0005J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u001d\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u001f\u001a\u00020\u000eH&R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/GroupAlbumBaseFeedOperateDialogPart;", "Lcom/qzone/reborn/base/k;", "Lgf/h;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Landroid/view/View;", "containerView", "", "Lcom/qzone/reborn/widget/b;", "F9", "J9", "G9", "", "itemName", "view", "", "M9", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "data", "O9", "y5", "", "feedPos", "Lcom/qzone/reborn/share/QZoneFeedXBottomSheetMenuMore$i;", "listener", SemanticAttributes.DbSystemValues.H2, "N9", "getDtPageId", "Lcom/qzone/reborn/groupalbum/viewmodel/m;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/m;", "mFeedViewModel", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "getMCurrentFeedData", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "setMCurrentFeedData", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)V", "mCurrentFeedData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class GroupAlbumBaseFeedOperateDialogPart extends com.qzone.reborn.base.k implements gf.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.m mFeedViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mCurrentFeedData;

    private final List<com.qzone.reborn.widget.b> F9(Activity activity, BusinessFeedData feedData, View containerView) {
        if (ef.b.h(feedData)) {
            return J9(feedData, containerView);
        }
        return G9(activity, feedData, containerView);
    }

    private final List<com.qzone.reborn.widget.b> G9(final Activity activity, final BusinessFeedData feedData, View containerView) {
        List<com.qzone.reborn.widget.b> mutableListOf;
        M9("chat", containerView);
        M9("rep", containerView);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.qzone.reborn.widget.b(R.drawable.qui_greeting, "\u53d1\u8d77\u804a\u5929", new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupAlbumBaseFeedOperateDialogPart.H9(activity, feedData, this, view);
            }
        }), new com.qzone.reborn.widget.b(R.drawable.qui_complaint, "\u4e3e\u62a5", new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupAlbumBaseFeedOperateDialogPart.I9(BusinessFeedData.this, activity, this, view);
            }
        }));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Activity activity, BusinessFeedData feedData, GroupAlbumBaseFeedOperateDialogPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.g().a(activity, feedData);
        this$0.L9("chat", view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(BusinessFeedData feedData, Activity activity, GroupAlbumBaseFeedOperateDialogPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f.Companion companion = com.qzone.feed.utils.f.INSTANCE;
        com.tencent.mobileqq.dt.api.b g16 = companion.g();
        companion.d(g16, feedData);
        companion.a(activity, g16);
        this$0.L9("rep", view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final List<com.qzone.reborn.widget.b> J9(final BusinessFeedData feedData, View containerView) {
        List<com.qzone.reborn.widget.b> mutableListOf;
        M9("del", containerView);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.qzone.reborn.widget.b(R.drawable.qui_delete, "\u5220\u9664", new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupAlbumBaseFeedOperateDialogPart.K9(GroupAlbumBaseFeedOperateDialogPart.this, feedData, view);
            }
        }));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(final GroupAlbumBaseFeedOperateDialogPart this$0, final BusinessFeedData feedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        com.qzone.reborn.groupalbum.viewmodel.m mVar = this$0.mFeedViewModel;
        if (mVar != null) {
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            mVar.Q1(activity, feedData, new Function1<BusinessFeedData, Unit>() { // from class: com.qzone.reborn.groupalbum.part.feed.GroupAlbumBaseFeedOperateDialogPart$buildFeedMenuForMaster$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BusinessFeedData businessFeedData) {
                    invoke2(businessFeedData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BusinessFeedData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GroupAlbumBaseFeedOperateDialogPart.this.N9(feedData);
                }
            });
        }
        this$0.L9("del", view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L9(String itemName, View view) {
        Map<String, Object> mutableMapOf;
        CellGroupAlbumInfo cellGroupAlbumInfo;
        CellUserInfo cellUserInfo;
        User user;
        fo.c.l(view, getPartRootView());
        String a16 = ef.b.a(this.mCurrentFeedData);
        if (a16 == null) {
            a16 = "";
        }
        BusinessFeedData businessFeedData = this.mCurrentFeedData;
        long j3 = (businessFeedData == null || (cellUserInfo = businessFeedData.cellUserInfo) == null || (user = cellUserInfo.user) == null) ? 0L : user.uin;
        String str = (businessFeedData == null || (cellGroupAlbumInfo = businessFeedData.cellGroupAlbumInfo) == null) ? null : cellGroupAlbumInfo.groupId;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName), TuplesKt.to("feedid", a16), TuplesKt.to("framer_uin", Long.valueOf(j3)), TuplesKt.to("group_uin", str != null ? str : ""));
        VideoReport.setPageParams(getPartRootView(), new fo.a().d("GroupAlbumFeedDetailFragment", mutableMapOf));
        fo.c.e("em_qz_on_the_feed_item", getDtPageId(), view, mutableMapOf);
    }

    private final void M9(String itemName, View view) {
        Map mutableMapOf;
        CellUserInfo cellUserInfo;
        User user;
        CellGroupAlbumInfo cellGroupAlbumInfo;
        fo.c.l(view, getPartRootView());
        String a16 = ef.b.a(this.mCurrentFeedData);
        if (a16 == null) {
            a16 = "";
        }
        BusinessFeedData businessFeedData = this.mCurrentFeedData;
        String str = (businessFeedData == null || (cellGroupAlbumInfo = businessFeedData.cellGroupAlbumInfo) == null) ? null : cellGroupAlbumInfo.groupId;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName), TuplesKt.to("feedid", a16), TuplesKt.to("framer_uin", Long.valueOf((businessFeedData == null || (cellUserInfo = businessFeedData.cellUserInfo) == null || (user = cellUserInfo.user) == null) ? 0L : user.uin)), TuplesKt.to("group_uin", str != null ? str : ""));
        fo.c.g("em_qz_on_the_feed_item", getDtPageId(), view, mutableMapOf);
    }

    public abstract void N9(BusinessFeedData feedData);

    public final void O9(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mCurrentFeedData = data;
    }

    public abstract String getDtPageId();

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.h.class);
        this.mFeedViewModel = (com.qzone.reborn.groupalbum.viewmodel.m) getViewModel(com.qzone.reborn.groupalbum.viewmodel.m.class);
    }

    @Override // gf.h
    public void h2(BusinessFeedData feedData, int feedPos, QZoneFeedXBottomSheetMenuMore.i listener) {
        if (feedData == null) {
            return;
        }
        O9(feedData);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.qzone.reborn.widget.f fVar = new com.qzone.reborn.widget.f(activity, new com.qzone.reborn.widget.a());
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        fVar.Y(F9(activity2, feedData, fVar.S()));
        ef.d.f(fVar, getActivity());
    }

    @Override // gf.h
    public void y5(BusinessFeedData feedData) {
    }
}
