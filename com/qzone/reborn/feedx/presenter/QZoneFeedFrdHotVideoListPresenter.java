package com.qzone.reborn.feedx.presenter;

import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideo00064Reporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDTReporter;
import com.qzone.module.feedcomponent.util.RecycleExtKt;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.friendlike.CompleteExpElement;
import com.qzone.reborn.feedx.itemview.friendlike.QZoneFrdHotVideoCompleteExpChecker;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0002\u00121B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/QZoneFeedFrdHotVideoListPresenter;", "Lvg/a;", "Lgf/r;", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "play", "pause", "a", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "d", "onPaused", "c", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "J", "onViewHolderDetachedFromWindow", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "videoListRecyclerView", "Lcom/qzone/reborn/feedx/itemview/friendlike/f;", "G", "Lcom/qzone/reborn/feedx/itemview/friendlike/f;", "videoListAdapter", "Lcom/qzone/reborn/feedx/itemview/friendlike/h;", "H", "Lcom/qzone/reborn/feedx/itemview/friendlike/h;", "playController", "I", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "currentFeedData", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker;", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker;", "completeExpChecker", "<init>", "()V", "K", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedFrdHotVideoListPresenter extends vg.a implements gf.r {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int L = ef.d.b(10);
    private static final int M = ef.d.b(13);

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView videoListRecyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.itemview.friendlike.f videoListAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.itemview.friendlike.h playController;

    /* renamed from: I, reason: from kotlin metadata */
    private BusinessFeedData currentFeedData;

    /* renamed from: J, reason: from kotlin metadata */
    private QZoneFrdHotVideoCompleteExpChecker completeExpChecker;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/QZoneFeedFrdHotVideoListPresenter$a;", "", "", "spaceSize", "I", "a", "()I", "startSpaceSize", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.presenter.QZoneFeedFrdHotVideoListPresenter$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QZoneFeedFrdHotVideoListPresenter.L;
        }

        public final int b() {
            return QZoneFeedFrdHotVideoListPresenter.M;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/QZoneFeedFrdHotVideoListPresenter$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "space", "e", "startSpaceSize", "<init>", "(II)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int space;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int startSpaceSize;

        public b(int i3, int i16) {
            this.space = i3;
            this.startSpaceSize = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildPosition(view) == 0) {
                outRect.left = this.startSpaceSize;
            } else {
                outRect.left = this.space / 2;
            }
            outRect.right = this.space / 2;
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        RecyclerView recyclerView = containerView instanceof RecyclerView ? (RecyclerView) containerView : null;
        if (recyclerView == null) {
            return;
        }
        this.videoListRecyclerView = recyclerView;
        com.qzone.reborn.feedx.itemview.friendlike.h hVar = new com.qzone.reborn.feedx.itemview.friendlike.h(recyclerView);
        this.playController = hVar;
        this.videoListAdapter = new com.qzone.reborn.feedx.itemview.friendlike.f(hVar);
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = new QZoneFrdHotVideoCompleteExpChecker(recyclerView);
        qZoneFrdHotVideoCompleteExpChecker.j(new Function1<CompleteExpElement, Unit>() { // from class: com.qzone.reborn.feedx.presenter.QZoneFeedFrdHotVideoListPresenter$onInitView$1$1
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
        RecyclerView recyclerView2 = this.videoListRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.videoListAdapter);
            recyclerView2.addItemDecoration(new b(L, M));
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            recyclerView2.setItemAnimator(null);
        }
    }

    public final void J() {
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = this.completeExpChecker;
        if (qZoneFrdHotVideoCompleteExpChecker != null) {
            qZoneFrdHotVideoCompleteExpChecker.i();
        }
    }

    @Override // gf.r
    public void a() {
        com.qzone.reborn.feedx.itemview.friendlike.h hVar = this.playController;
        if (hVar != null) {
            hVar.j();
        }
    }

    @Override // vg.a, vg.c
    public void c() {
        List allItemViewList;
        super.c();
        RecyclerView recyclerView = this.videoListRecyclerView;
        if (recyclerView != null && (allItemViewList = RecycleExtKt.getAllItemViewList(recyclerView)) != null) {
            Iterator it = allItemViewList.iterator();
            while (it.hasNext()) {
                ((QZoneFrdHotVideoLifeCycle) it.next()).onResume();
            }
        }
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = this.completeExpChecker;
        if (qZoneFrdHotVideoCompleteExpChecker != null) {
            qZoneFrdHotVideoCompleteExpChecker.h();
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        com.qzone.reborn.feedx.itemview.friendlike.h hVar = this.playController;
        if (hVar != null) {
            return hVar.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedQCircleFrdHotVideoPresenter";
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        List allItemViewList;
        super.onPaused();
        RecyclerView recyclerView = this.videoListRecyclerView;
        if (recyclerView != null && (allItemViewList = RecycleExtKt.getAllItemViewList(recyclerView)) != null) {
            Iterator it = allItemViewList.iterator();
            while (it.hasNext()) {
                ((QZoneFrdHotVideoLifeCycle) it.next()).onPause();
            }
        }
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = this.completeExpChecker;
        if (qZoneFrdHotVideoCompleteExpChecker != null) {
            qZoneFrdHotVideoCompleteExpChecker.g();
        }
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        View it = holder.itemView;
        QZoneFrdHotVideoDTReporter qZoneFrdHotVideoDTReporter = QZoneFrdHotVideoDTReporter.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        qZoneFrdHotVideoDTReporter.reportFeedListExposure(it);
        QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedListExposure();
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = this.completeExpChecker;
        if (qZoneFrdHotVideoCompleteExpChecker != null) {
            qZoneFrdHotVideoCompleteExpChecker.f();
        }
    }

    @Override // vg.a, vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder holder) {
        List allItemViewList;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderDetachedFromWindow(holder);
        RecyclerView recyclerView = this.videoListRecyclerView;
        if (recyclerView == null || (allItemViewList = RecycleExtKt.getAllItemViewList(recyclerView)) == null) {
            return;
        }
        Iterator it = allItemViewList.iterator();
        while (it.hasNext()) {
            ((QZoneFrdHotVideoLifeCycle) it.next()).onParentRecycled();
        }
    }

    @Override // gf.r
    public void pause() {
        com.qzone.reborn.feedx.itemview.friendlike.h hVar = this.playController;
        if (hVar != null) {
            hVar.h();
        }
    }

    @Override // gf.r
    public void play() {
        com.qzone.reborn.feedx.itemview.friendlike.h hVar = this.playController;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nlo;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        int collectionSizeOrDefault;
        if (feedData == null) {
            QLog.i("QZoneFeedQCircleFrdHotVideoPresenter", 1, "onBindData, feedData is null");
            return;
        }
        QZoneFrdHotVideoCompleteExpChecker qZoneFrdHotVideoCompleteExpChecker = this.completeExpChecker;
        if (qZoneFrdHotVideoCompleteExpChecker != null) {
            qZoneFrdHotVideoCompleteExpChecker.e();
        }
        if (Intrinsics.areEqual(feedData, this.currentFeedData)) {
            return;
        }
        this.currentFeedData = feedData;
        ArrayList<BusinessFeedData> arrayList = feedData.recBusinessFeedDatas;
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (BusinessFeedData it : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList2.add(com.qzone.proxy.feedcomponent.model.c.f(it));
            }
            QLog.i("QZoneFeedQCircleFrdHotVideoPresenter", 1, "setData, size = " + arrayList2.size());
            com.qzone.reborn.feedx.itemview.friendlike.f fVar = this.videoListAdapter;
            if (fVar != null) {
                fVar.m0(arrayList2, this.f441567m);
                return;
            }
            return;
        }
        QLog.e("QZoneFeedQCircleFrdHotVideoPresenter", 1, "setData, but recBusinessFeedDatas is null");
    }
}
