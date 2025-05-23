package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideo00064Reporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDTReporter;
import com.qzone.module.feedcomponent.util.RecycleExtKt;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.itemview.friendlike.CompleteExpElement;
import com.qzone.reborn.feedx.itemview.friendlike.QZoneFrdHotVideoCompleteExpChecker;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\u00020\u0001:\u0002LMB\u000f\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0015H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010,\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0015H\u0016J\"\u0010-\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u00100\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000103H\u0016R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006N"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoFeedListView;", "Lcom/qzone/proxy/feedcomponent/ui/AbsFeedView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "setData", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Lcom/qzone/proxy/feedcomponent/ui/g;", "onFeedElementClickListener", "setOnFeedElementClickListener", com.tencent.luggage.wxa.c8.c.G, "setFeedPosition", "getFeedPosition", "Lcom/qzone/module/feedcomponent/ui/FeedAutoVideo;", "getCurrentVideoView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onRecycled", "onStateScrolling", "onStateIdle", "", "isKeepPlayVideo", "onStateIdleOnDetail", "startFlashNickName", "position", "reportFeed", "hasRecommHeader", "setHasRecommHeader", "isAutoVideoFeed", "isAlwaysAutoPlayFeed", "hasVideoPlayed", "separator", "setHasSearchSeparator", "show", "", "tip", "showSearchSeparator", "need", "setNeedFillBlackArea", "updateLikeInfo", "", "uin", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "updateFollowInfo", "updateSpecialFollowInfo", "updateRecommAction", "showFakeGap", "updateTitle", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;Ljava/lang/Boolean;)V", "updateTransparentBackground", "Lcom/qzone/proxy/feedcomponent/ui/h;", "listener", "setOnFeedEventListener", "mFeedPosition", "I", "Lcom/qzone/proxy/feedcomponent/ui/g;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoListAdapter;", "frdHotVideoListAdapter", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoListAdapter;", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;", "autoPlayController", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker;", "completeExpChecker", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "SpacesItemDecoration", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneOldFrdHotVideoFeedListView extends AbsFeedView {
    private static final String TAG = "QZoneOldFrdHotVideoFeedListView";
    private static final float TITLE_TEXT_SIZE_DP = 14.0f;
    private QZoneOldFrdHotVideoAutoPlayController autoPlayController;
    private QZoneFrdHotVideoCompleteExpChecker completeExpChecker;
    private QZoneOldFrdHotVideoListAdapter frdHotVideoListAdapter;
    private int mFeedPosition;
    private com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    private RecyclerView recyclerView;
    private final TextView title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int spaceSize = ef.d.b(8);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoFeedListView$Companion;", "", "()V", "TAG", "", "TITLE_TEXT_SIZE_DP", "", "spaceSize", "", "getSpaceSize", "()I", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getSpaceSize() {
            return QZoneOldFrdHotVideoFeedListView.spaceSize;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoFeedListView$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int space;

        public SpacesItemDecoration(int i3) {
            this.space = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildPosition(view) == 0) {
                outRect.left = this.space;
            } else {
                outRect.left = this.space / 2;
            }
            outRect.right = this.space / 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneOldFrdHotVideoFeedListView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFeedPosition = -1;
        VideoReport.setPageId(this, "pg_discover_feeds_page");
        setOrientation(1);
        setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        View view = new View(context);
        view.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
        addView(view, new LinearLayout.LayoutParams(-1, AreaConst.dp15));
        TextView textView = new TextView(context);
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        textView.setTextSize(1, 14.0f);
        this.title = textView;
        final Button button = new Button(context);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZoneOldFrdHotVideoFeedListView.lambda$3$lambda$2(button, this, view2);
            }
        });
        button.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(719));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setPadding(ef.d.b(8), ef.d.b(10), ef.d.b(8), ef.d.b(10));
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(button, new LinearLayout.LayoutParams(ef.d.b(16), ef.d.b(16)));
        addView(linearLayout);
        FrdHotVideoRecyclerView frdHotVideoRecyclerView = new FrdHotVideoRecyclerView(context, null, 2, null);
        frdHotVideoRecyclerView.addItemDecoration(new SpacesItemDecoration(spaceSize));
        frdHotVideoRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        frdHotVideoRecyclerView.setItemAnimator(null);
        this.recyclerView = frdHotVideoRecyclerView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = ef.d.b(16);
        addView(frdHotVideoRecyclerView, layoutParams2);
        this.autoPlayController = new QZoneOldFrdHotVideoAutoPlayController(this.recyclerView);
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = new QZoneFrdHotVideoCompleteExpChecker(this.recyclerView);
        qZoneFrdHotVideoCompleteExpChecker.j(new Function1<CompleteExpElement, Unit>() { // from class: com.qzone.module.feedcomponent.ui.QZoneOldFrdHotVideoFeedListView$4$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CompleteExpElement completeExpElement) {
                invoke2(completeExpElement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CompleteExpElement it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedCompleteExposure(it.getFeedId(), it.getPosition() + 1);
            }
        });
        this.completeExpChecker = qZoneFrdHotVideoCompleteExpChecker;
        QZoneOldFrdHotVideoListAdapter qZoneOldFrdHotVideoListAdapter = new QZoneOldFrdHotVideoListAdapter(this.autoPlayController);
        this.frdHotVideoListAdapter = qZoneOldFrdHotVideoListAdapter;
        this.recyclerView.setAdapter(qZoneOldFrdHotVideoListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$3$lambda$2(Button this_apply, QZoneOldFrdHotVideoFeedListView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ClickedPoint clickedPoint = new ClickedPoint(this_apply.getLeft(), this_apply.getBottom(), 0, 0, this_apply.getWidth(), this_apply.getHeight());
        com.qzone.proxy.feedcomponent.ui.g gVar = this$0.onFeedElementClickListener;
        if (gVar != null) {
            gVar.onClick(this_apply, FeedElement.DROPDOWN_BUTTON, this$0.getMFeedPosition(), clickedPoint);
        }
        QZoneFrdHotVideo00064Reporter.INSTANCE.reportRightMenuClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final FeedAutoVideo getCurrentVideoView() {
        FeedVideoView feedVideoView;
        QZoneOldFrdHotVideoItemView currentPlayVideoView = this.autoPlayController.getCurrentPlayVideoView();
        if (currentPlayVideoView == null || (feedVideoView = currentPlayVideoView.getFeedVideoView()) == null) {
            return null;
        }
        return feedVideoView.getAutoVideoView();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition, reason: from getter */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onPause() {
        super.onPause();
        QLog.i(TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.autoPlayController.onPagePause();
        Iterator it = RecycleExtKt.getAllItemViewList(this.recyclerView).iterator();
        while (it.hasNext()) {
            ((QZoneFrdHotVideoLifeCycle) it.next()).onPause();
        }
        this.completeExpChecker.g();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        QLog.i(TAG, 1, "onRecycled");
        Iterator it = RecycleExtKt.getAllItemViewList(this.recyclerView).iterator();
        while (it.hasNext()) {
            ((QZoneFrdHotVideoLifeCycle) it.next()).onParentRecycled();
        }
        this.completeExpChecker.f();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        this.completeExpChecker.i();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData feedData) {
        int collectionSizeOrDefault;
        super.setData(feedData);
        if (feedData == null) {
            QLog.e(TAG, 1, "setData, but feedData is null");
            return;
        }
        this.title.setText(feedData.getRecommHeader().leftTitle);
        ArrayList<BusinessFeedData> arrayList = feedData.recBusinessFeedDatas;
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (BusinessFeedData it : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList2.add(com.qzone.proxy.feedcomponent.model.c.f(it));
            }
            QLog.i(TAG, 1, "setData, size = " + arrayList2.size());
            this.frdHotVideoListAdapter.setDataList(arrayList2);
            QZoneFrdHotVideoDTReporter.INSTANCE.reportFeedListExposure(this);
            QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedListExposure();
            this.completeExpChecker.e();
            return;
        }
        QLog.e(TAG, 1, "setData, but recBusinessFeedDatas is null");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int pos) {
        this.mFeedPosition = pos;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener) {
        this.onFeedElementClickListener = onFeedElementClickListener;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean isKeepPlayVideo) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int alpha) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean hasRecommHeader) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean separator) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean need) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h listener) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData feedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData feedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData feedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData feedData, int position) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean show, String tip) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData feedData, Boolean showFakeGap) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData feedData, long uin, boolean followed) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData feedData, long uin, boolean followed) {
    }
}
