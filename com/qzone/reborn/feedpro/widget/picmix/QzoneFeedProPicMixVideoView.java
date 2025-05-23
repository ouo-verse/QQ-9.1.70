package com.qzone.reborn.feedpro.widget.picmix;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002'VB)\b\u0007\u0012\b\b\u0001\u0010O\u001a\u00020N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010R\u001a\u00020\f\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u00182\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0002J\u001e\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH\u0002J\b\u0010!\u001a\u00020\fH\u0016J\u001a\u0010$\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\fH\u0014J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010+\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)J\u0010\u0010-\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010,J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\fJ\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0018J\u0006\u00102\u001a\u00020\nR\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006W"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Lde/f;", "", "C0", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "allCount", "spanCount", "x0", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "list", "B0", "G0", "dataPosInList", "H0", "pictureItemList", "", "J0", "I0", "w0", "z0", "count", "Lkotlin/Function0;", "action", "E0", "getLayoutId", "feedData", "position", "y0", "play", "pause", "a", "d", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "listener", "setOnItemClickListener", "Landroid/view/View$OnTouchListener;", "setOnEmptyTouchListener", "multiBorderWidth", "setItemViewMultiBorderWidth", "enableOverLimit", "setEnableOverLimit", "A0", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/qzone/reborn/feedpro/widget/picmix/b;", "f", "Lcom/qzone/reborn/feedpro/widget/picmix/b;", "mPicMixVideoAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", tl.h.F, "Landroidx/recyclerview/widget/GridLayoutManager;", "mGridLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "i", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mItemDecoration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mPicItemList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "mItemClickListener", "D", "Landroid/view/View$OnTouchListener;", "mOnTouchListener", "E", "I", "mMultiBorderWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProPicMixVideoView extends QZoneBaseWidgetView<CommonFeed> implements de.f {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int G = ImmersiveUtils.dpToPx(2.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private b mItemClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private View.OnTouchListener mOnTouchListener;

    /* renamed from: E, reason: from kotlin metadata */
    private int mMultiBorderWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.widget.picmix.b mPicMixVideoAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GridLayoutManager mGridLayoutManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.ItemDecoration mItemDecoration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonMedia> mPicItemList;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$a;", "", "", "ITEM_SPACE", "I", "a", "()I", "FEED_DETAIL_MAX_SIZE", "FRIEND_FEED_MAX_SIZE", "LONG_PICS_MAX_SIZE", "", "SAFE_RUN_NOTIFY_DELAY_TIME", "J", "SAFE_RUN_NOTIFY_MAX_RETRY_TIMES", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QzoneFeedProPicMixVideoView.G;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "index", "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(CommonMedia media, int index, View view);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$c", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "index", "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements b {
        c() {
        }

        @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView.b
        public void a(CommonMedia media, int index, View view) {
            b bVar = QzoneFeedProPicMixVideoView.this.mItemClickListener;
            if (bVar != null) {
                bVar.a(media, index, view);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            List list = QzoneFeedProPicMixVideoView.this.mPicItemList;
            List list2 = list;
            if (!(list2 == null || list2.isEmpty()) && list.size() != 1) {
                if (QzoneFeedProPicMixVideoView.this.J0(list)) {
                    QzoneFeedProPicMixVideoView.this.x0(outRect, view, parent, list.size(), 2);
                    return;
                } else {
                    QzoneFeedProPicMixVideoView.this.x0(outRect, view, parent, list.size(), 3);
                    return;
                }
            }
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProPicMixVideoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<CommonMedia> B0(List<CommonMedia> list) {
        CommonCellMedia cellMedia;
        int pageType = k0().getPageType();
        CommonFeed data = getData();
        int i3 = 1;
        if (!((data == null || (cellMedia = data.getCellMedia()) == null || !cellMedia.getLongPicsBrowsingMode()) ? false : true)) {
            i3 = x.f55790a.c(pageType) ? 18 : 9;
        }
        return list.size() > i3 ? list.subList(0, i3) : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D0(QzoneFeedProPicMixVideoView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnTouchListener onTouchListener = this$0.mOnTouchListener;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(QzoneFeedProPicMixVideoView this$0, int i3, Function0 action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.E0(i3 - 1, action);
    }

    private final void G0() {
        int i3;
        List<CommonMedia> list = this.mPicItemList;
        GridLayoutManager gridLayoutManager = null;
        if (list != null) {
            GridLayoutManager gridLayoutManager2 = this.mGridLayoutManager;
            if (gridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
                gridLayoutManager2 = null;
            }
            if (I0(list)) {
                i3 = 1;
            } else if (J0(list)) {
                w0();
                i3 = 2;
            } else {
                w0();
                i3 = 3;
            }
            gridLayoutManager2.setSpanCount(i3);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        GridLayoutManager gridLayoutManager3 = this.mGridLayoutManager;
        if (gridLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
        } else {
            gridLayoutManager = gridLayoutManager3;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private final void H0(int dataPosInList) {
        final com.qzone.reborn.feedpro.widget.picmix.b bVar = this.mPicMixVideoAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoAdapter");
            bVar = null;
        }
        bVar.p0(this.mMultiBorderWidth);
        bVar.l0(getData(), this.mPicItemList);
        bVar.n0(dataPosInList);
        E0(5, new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView$updatePicMixVideoUI$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b.this.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J0(List<CommonMedia> pictureItemList) {
        int size = pictureItemList.size();
        return size == 2 || size == 4;
    }

    private final void w0() {
        E0(5, new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView$addItemDecoration$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RecyclerView recyclerView;
                RecyclerView.ItemDecoration itemDecoration;
                recyclerView = QzoneFeedProPicMixVideoView.this.mRecyclerView;
                RecyclerView.ItemDecoration itemDecoration2 = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                    recyclerView = null;
                }
                itemDecoration = QzoneFeedProPicMixVideoView.this.mItemDecoration;
                if (itemDecoration == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemDecoration");
                } else {
                    itemDecoration2 = itemDecoration;
                }
                recyclerView.addItemDecoration(itemDecoration2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Rect outRect, View view, RecyclerView parent, int allCount, int spanCount) {
        int roundToInt;
        int roundToInt2;
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        outRect.top = 0;
        if (spanCount != 2) {
            if (spanCount == 3) {
                int i3 = childAdapterPosition % spanCount;
                if (i3 == 0) {
                    outRect.left = 0;
                    roundToInt = MathKt__MathJVMKt.roundToInt((G / 3) * 2);
                    outRect.right = roundToInt;
                } else if (i3 != 1) {
                    roundToInt2 = MathKt__MathJVMKt.roundToInt((G / 3) * 2);
                    outRect.left = roundToInt2;
                    outRect.right = 0;
                } else {
                    int i16 = G;
                    outRect.left = i16 / 3;
                    outRect.right = i16 / 3;
                }
            }
        } else if (childAdapterPosition % spanCount == 0) {
            outRect.left = 0;
            outRect.right = G / 2;
        } else {
            outRect.left = G / 2;
            outRect.right = 0;
        }
        if (childAdapterPosition < allCount - spanCount) {
            outRect.bottom = G;
        }
    }

    private final de.f z0() {
        GridLayoutManager gridLayoutManager = this.mGridLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
            gridLayoutManager = null;
        }
        int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        GridLayoutManager gridLayoutManager2 = this.mGridLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
            gridLayoutManager2 = null;
        }
        int findLastVisibleItemPosition = gridLayoutManager2.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0 || findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return null;
        }
        Iterator<Integer> it = new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            GridLayoutManager gridLayoutManager3 = this.mGridLayoutManager;
            if (gridLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGridLayoutManager");
                gridLayoutManager3 = null;
            }
            Object findViewByPosition = gridLayoutManager3.findViewByPosition(nextInt);
            if (findViewByPosition == null || !(findViewByPosition instanceof de.f)) {
                findViewByPosition = null;
            } else {
                QLog.d("PSLink-QzoneFeedProPicMixVideoView", 1, "findFirstVideoItemWidgetView | feedPos = " + this.dataPosInList + " | picPos = " + nextInt + " | view = " + findViewByPosition);
            }
            de.f fVar = (de.f) findViewByPosition;
            if (fVar != null) {
                return fVar;
            }
        }
        return null;
    }

    public final RecyclerView A0() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    @Override // de.f
    public void a() {
        de.f z06 = z0();
        if (z06 != null) {
            z06.a();
        }
    }

    @Override // de.f
    public View d() {
        de.f z06 = z0();
        if (z06 != null) {
            return z06.d();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chk;
    }

    @Override // de.f
    public void pause() {
        de.f z06 = z0();
        if (z06 != null) {
            z06.pause();
        }
    }

    @Override // de.f
    public void play() {
        de.f z06 = z0();
        if (z06 != null) {
            z06.play();
        }
    }

    public final void setEnableOverLimit(boolean enableOverLimit) {
        com.qzone.reborn.feedpro.widget.picmix.b bVar = this.mPicMixVideoAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoAdapter");
            bVar = null;
        }
        bVar.m0(enableOverLimit);
    }

    public final void setItemViewMultiBorderWidth(int multiBorderWidth) {
        this.mMultiBorderWidth = multiBorderWidth;
    }

    public final void setOnEmptyTouchListener(View.OnTouchListener listener) {
        this.mOnTouchListener = listener;
    }

    public final void setOnItemClickListener(b listener) {
        this.mItemClickListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonFeed feedData, int position) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView.ItemDecoration itemDecoration = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        if (!recyclerView.isComputingLayout()) {
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            RecyclerView.ItemDecoration itemDecoration2 = this.mItemDecoration;
            if (itemDecoration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemDecoration");
            } else {
                itemDecoration = itemDecoration2;
            }
            recyclerView2.removeItemDecoration(itemDecoration);
        }
        if (feedData != null && (cellMedia = feedData.getCellMedia()) != null && (mediaItems = cellMedia.getMediaItems()) != null) {
            this.mPicItemList = B0(mediaItems);
        }
        G0();
        H0(position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProPicMixVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean I0(List<CommonMedia> pictureItemList) {
        List<CommonMedia> list = pictureItemList;
        return (list == null || list.isEmpty()) || pictureItemList.size() == 1;
    }

    public /* synthetic */ QzoneFeedProPicMixVideoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void E0(final int count, final Function0<Unit> action) {
        RecyclerView recyclerView;
        if (count != 0 && (recyclerView = this.mRecyclerView) != null) {
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView = null;
            }
            if (recyclerView.isComputingLayout()) {
                RecyclerView recyclerView3 = this.mRecyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                } else {
                    recyclerView2 = recyclerView3;
                }
                recyclerView2.postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.picmix.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QzoneFeedProPicMixVideoView.F0(QzoneFeedProPicMixVideoView.this, count, action);
                    }
                }, 20L);
                return;
            }
            action.invoke();
            return;
        }
        RFWLog.i("QzoneFeedProPicMixVideoView", RFWLog.USR, "safeNotify return count = " + count);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProPicMixVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        C0();
    }

    private final void C0() {
        View findViewById = findViewById(R.id.f162898n73);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_media_list_recycler_view)");
        this.mRecyclerView = (RecyclerView) findViewById;
        this.mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        RecyclerView recyclerView = this.mRecyclerView;
        com.qzone.reborn.feedpro.widget.picmix.b bVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.reborn.feedpro.widget.picmix.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D0;
                D0 = QzoneFeedProPicMixVideoView.D0(QzoneFeedProPicMixVideoView.this, view, motionEvent);
                return D0;
            }
        });
        com.qzone.reborn.feedpro.widget.picmix.b bVar2 = new com.qzone.reborn.feedpro.widget.picmix.b();
        this.mPicMixVideoAdapter = bVar2;
        bVar2.o0(new c());
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        com.qzone.reborn.feedpro.widget.picmix.b bVar3 = this.mPicMixVideoAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoAdapter");
        } else {
            bVar = bVar3;
        }
        recyclerView4.setAdapter(bVar);
        this.mItemDecoration = new d();
    }
}
